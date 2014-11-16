package org.eclipse.jdt.internal.compiler;

import org.eclipse.jdt.internal.compiler.env.ICompilationUnit;

public class ReadManager implements Runnable {

    ICompilationUnit[] field_1660;

    int field_1661;

    ICompilationUnit[] field_1662;

    char[][] contentsRead;

    int field_1664;

    int field_1665;

    Thread[] readingThreads;

    char[] readInProcessMarker;

    int field_1668;

    private Throwable caughtException;

    static int field_1670;

    public static int field_1671;

    static int field_1672;

    public ReadManager(ICompilationUnit[] var1, int var2) {
        this.readInProcessMarker = new char[0];
    }

    public char[] getContents(ICompilationUnit var1) {
        if (this.readingThreads != null && this.field_1660.length != 0) {
            boolean var2 = false;
            char[] var3 = null;
            synchronized (this) {
                if (var1 == this.field_1662[this.field_1664]) {
                    for (var3 = this.contentsRead[this.field_1664]; var3 == this.readInProcessMarker || var3 == null; var3 = this.contentsRead[this.field_1664]) {
                        this.contentsRead[this.field_1664] = null;
                        try {
                            this.wait(250L);
                        } catch (InterruptedException var8) {
                            ;
                        }
                    }
                    this.field_1662[this.field_1664] = null;
                    this.contentsRead[this.field_1664] = null;
                    if (++this.field_1664 >= this.contentsRead.length) {
                        this.field_1664 = 0;
                    }
                    if (this.field_1668 > 0) {
                        this.notify();
                        var2 = this.field_1668 == this.readingThreads.length;
                    }
                } else {
                    int var5 = 0;
                    for (int var6 = this.field_1660.length; var5 < var6 && this.field_1660[var5] != var1; ++var5) {
                        ;
                    }
                    if (var5 == this.field_1660.length) {
                        this.field_1660 = new ICompilationUnit[0];
                    } else if (var5 >= this.field_1661) {
                        this.field_1661 = var5 + field_1670;
                        this.field_1664 = 0;
                        this.field_1665 = 0;
                        this.field_1662 = new ICompilationUnit[field_1672];
                        this.contentsRead = new char[field_1672][];
                        this.notifyAll();
                    }
                }
            }
            if (var2) {
                Thread.yield();
            }
            return var3 != null ? var3 : var1.getContents();
        } else if (this.caughtException != null) {
            if (this.caughtException instanceof Error) {
                throw(Error)this.caughtException;
            } else {
                throw(RuntimeException)this.caughtException;
            }
        } else {
            return var1.getContents();
        }
    }

    public void run() {
        RuntimeException var1;
        try {
            while (this.readingThreads != null && this.field_1661 < this.field_1660.length) {
                var1 = null;
                boolean var2 = true;
                ICompilationUnit var17;
                int var18;
                synchronized (this) {
                    if (this.readingThreads == null) {
                        return;
                    }
                    while (this.field_1662[this.field_1665] != null) {
                        ++this.field_1668;
                        try {
                            this.wait(250L);
                        } catch (InterruptedException var12) {
                            ;
                        }
                        --this.field_1668;
                        if (this.readingThreads == null) {
                            return;
                        }
                    }
                    if (this.field_1661 >= this.field_1660.length) {
                        return;
                    }
                    var17 = this.field_1660[this.field_1661++];
                    var18 = this.field_1665;
                    if (++this.field_1665 >= this.contentsRead.length) {
                        this.field_1665 = 0;
                    }
                    this.field_1662[var18] = var17;
                    this.contentsRead[var18] = this.readInProcessMarker;
                }
                char[] var3 = var17.getContents();
                synchronized (this) {
                    if (this.field_1662[var18] == var17) {
                        if (this.contentsRead[var18] == null) {
                            this.notifyAll();
                        }
                        this.contentsRead[var18] = var3;
                    }
                }
            }
        } catch (Error var14) {
            Error var16 = var14;
            synchronized (this) {
                this.caughtException = var16;
                this.shutdown();
            }
        } catch (RuntimeException var15) {
            var1 = var15;
            synchronized (this) {
                this.caughtException = var1;
                this.shutdown();
            }
        }
    }

    public synchronized void shutdown() {
        this.readingThreads = null;
        this.notifyAll();
    }

    static {
        field_1670 = 5;
        field_1671 = 10;
        field_1672 = 15;
    }
}
