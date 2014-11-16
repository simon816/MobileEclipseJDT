package org.eclipse.jdt.internal.compiler;

import org.eclipse.jdt.internal.compiler.Compiler;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.util.Messages;

public class ProcessTaskManager implements Runnable {

    Compiler compiler;

    private int unitIndex;

    private Thread processingThread;

    CompilationUnitDeclaration unitToProcess;

    private Throwable caughtException;

    volatile int field_1654;

    volatile int field_1655;

    volatile int field_1656;

    volatile int field_1657;

    CompilationUnitDeclaration[] units;

    public static int field_1659;

    public ProcessTaskManager(Compiler var1) {
        this.compiler = var1;
        this.unitIndex = 0;
        this.field_1654 = 0;
        this.field_1655 = 0;
        this.field_1656 = field_1659;
        this.field_1657 = 0;
        this.units = new CompilationUnitDeclaration[this.field_1656];
        synchronized (this) {
            this.processingThread = new Thread(this, "Compiler Processing Task");
            this.processingThread.start();
        }
    }

    private synchronized void addNextUnit(CompilationUnitDeclaration var1) {
        for (; this.units[this.field_1655] != null; this.field_1657 = 0) {
            this.field_1657 = 1;
            try {
                this.wait(250L);
            } catch (InterruptedException var3) {
                ;
            }
        }
        this.units[this.field_1655++] = var1;
        if (this.field_1655 >= this.field_1656) {
            this.field_1655 = 0;
        }
        if (this.field_1657 <= -1) {
            this.notify();
        }
    }

    public CompilationUnitDeclaration removeNextUnit() {
        CompilationUnitDeclaration var1 = null;
        boolean var2 = false;
        synchronized (this) {
            var1 = this.units[this.field_1654];
            if (var1 == null || this.caughtException != null) {
                do {
                    if (this.processingThread == null) {
                        if (this.caughtException != null) {
                            if (this.caughtException instanceof Error) {
                                throw(Error)this.caughtException;
                            }
                            throw(RuntimeException)this.caughtException;
                        }
                        return null;
                    }
                    this.field_1657 = -1;
                    try {
                        this.wait(100L);
                    } catch (InterruptedException var6) {
                        ;
                    }
                    this.field_1657 = 0;
                    var1 = this.units[this.field_1654];
                } while (var1 == null);
            }
            this.units[this.field_1654++] = null;
            if (this.field_1654 >= this.field_1656) {
                this.field_1654 = 0;
            }
            if (this.field_1657 >= 1 && ++this.field_1657 > 4) {
                this.notify();
                var2 = this.field_1657 > 8;
            }
        }
        if (var2) {
            Thread.yield();
        }
        return var1;
    }

    public void run() {
        while (this.processingThread != null) {
            this.unitToProcess = null;
            boolean var1 = true;
            try {
                int var19;
                synchronized (this) {
                    if (this.processingThread == null) {
                        return;
                    }
                    this.unitToProcess = this.compiler.getUnitToProcess(this.unitIndex);
                    if (this.unitToProcess == null) {
                        this.processingThread = null;
                        return;
                    }
                    var19 = this.unitIndex++;
                }
                try {
                    this.compiler.reportProgress(Messages.bind(Messages.field_1871, new String(this.unitToProcess.method_771())));
                    if (this.compiler.options.field_1931) {
                        this.compiler.field_1701.println(Messages.bind(Messages.field_1864, new String[] {String.valueOf(var19 + 1), String.valueOf(this.compiler.field_1706), new String(this.unitToProcess.method_771())}));
                    }
                    this.compiler.process(this.unitToProcess, var19);
                } finally {
                    if (this.unitToProcess != null) {
                        this.unitToProcess.method_766();
                    }
                }
                this.addNextUnit(this.unitToProcess);
            } catch (Error var17) {
                Error var20 = var17;
                synchronized (this) {
                    this.processingThread = null;
                    this.caughtException = var20;
                    return;
                }
            } catch (RuntimeException var18) {
                RuntimeException var2 = var18;
                synchronized (this) {
                    this.processingThread = null;
                    this.caughtException = var2;
                    return;
                }
            }
        }
    }

    public void shutdown() {
        try {
            Thread var1 = null;
            synchronized (this) {
                if (this.processingThread != null) {
                    var1 = this.processingThread;
                    this.processingThread = null;
                    this.notifyAll();
                }
            }
            if (var1 != null) {
                var1.join();
            }
        } catch (InterruptedException var5) {
            ;
        }
    }

    static {
        field_1659 = 12;
    }
}
