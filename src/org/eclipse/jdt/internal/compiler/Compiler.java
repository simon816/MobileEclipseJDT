package org.eclipse.jdt.internal.compiler;

import java.io.PrintStream;

import org.eclipse.jdt.core.compiler.CompilationProgress;
import org.eclipse.jdt.core.compiler.CategorizedProblem;
import org.eclipse.jdt.internal.compiler.ProcessTaskManager;
import org.eclipse.jdt.internal.compiler.ReadManager;
import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.AbstractAnnotationProcessorManager;
import org.eclipse.jdt.internal.compiler.Compiler$1;
import org.eclipse.jdt.internal.compiler.IDebugRequestor;
import org.eclipse.jdt.internal.compiler.IErrorHandlingPolicy;
import org.eclipse.jdt.internal.compiler.IProblemFactory;
import org.eclipse.jdt.internal.compiler.ICompilerRequestor;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ImportReference;
import org.eclipse.jdt.internal.compiler.batch.eclipse;
import org.eclipse.jdt.internal.compiler.env.ICompilationUnit;
import org.eclipse.jdt.internal.compiler.env.ISourceType;
import org.eclipse.jdt.internal.compiler.env.IBinaryType;
import org.eclipse.jdt.internal.compiler.env.INameEnvironment;
import org.eclipse.jdt.internal.compiler.env.AccessRestriction;
import org.eclipse.jdt.internal.compiler.impl.ITypeRequestor;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;
import org.eclipse.jdt.internal.compiler.impl.CompilerStats;
import org.eclipse.jdt.internal.compiler.lookup.PackageBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;
import org.eclipse.jdt.internal.compiler.parser.Parser;
import org.eclipse.jdt.internal.compiler.problem.DefaultProblem;
import org.eclipse.jdt.internal.compiler.problem.AbortCompilation;
import org.eclipse.jdt.internal.compiler.problem.AbortCompilationUnit;
import org.eclipse.jdt.internal.compiler.problem.ProblemReporter;
import org.eclipse.jdt.internal.compiler.util.Messages;

public class Compiler implements ITypeRequestor {

    public Parser parser;

    public ICompilerRequestor requestor;

    public CompilerOptions options;

    public ProblemReporter problemReporter;

    protected PrintStream field_1701;

    public CompilerStats stats;

    public CompilationProgress progress;

    public int field_1704;

    public CompilationUnitDeclaration[] unitsToProcess;

    public int field_1706;

    public LookupEnvironment lookupEnvironment;

    public static boolean DEBUG;

    public int field_1709;

    public AbstractAnnotationProcessorManager annotationProcessorManager;

    public ReferenceBinding[] referenceBindings;

    public boolean useSingleThread;

    public static IDebugRequestor DebugRequestor;

    public Compiler(INameEnvironment var1, IErrorHandlingPolicy var2, CompilerOptions var3, ICompilerRequestor var4, IProblemFactory var5, PrintStream var6, CompilationProgress var7) {
        this.field_1704 = 1;
        this.field_1709 = -1;
        this.useSingleThread = true;
        this.options = var3;
        this.progress = var7;
        if (DebugRequestor == null) {
            this.requestor = var4;
        } else {
            Compiler$1 var10001 = new Compiler$1(this, var4);
            this.requestor = var10001;
        }
        try {
            this.field_1701 = System.out;
            CompilerStats var12 = new CompilerStats();
            this.stats = var12;
            ProblemReporter var10 = new ProblemReporter(var2, this.options, var5);
            this.problemReporter = var10;
            LookupEnvironment var11 = new LookupEnvironment(this, this.options, this.problemReporter, var1);
            this.lookupEnvironment = var11;
            this.method_2948();
        } catch (Throwable var9) {
            var9.printStackTrace();
        }
    }

    public void accept(IBinaryType var1, PackageBinding var2, AccessRestriction var3) {
        if (this.options.field_1931) {
            this.field_1701.println(Messages.bind(Messages.field_1863, new String(var1.method_60())));
        }
        this.lookupEnvironment.createBinaryTypeFrom(var1, var2, var3);
    }

    public void accept(ICompilationUnit var1, AccessRestriction var2) {
        CompilationResult var10000 = new CompilationResult(var1, this.field_1706, this.field_1706, this.options.field_1935);
        CompilationResult var3 = var10000;
        var3.field_1694 = true;
        try {
            if (this.options.field_1931) {
                String var4 = String.valueOf(this.field_1706 + 1);
                this.field_1701.println(Messages.bind(Messages.field_1862, new String[] {var4, var4, new String(var1.method_50())}));
            }
            CompilationUnitDeclaration var6;
            if (this.field_1706 < this.field_1709) {
                var6 = this.parser.parse(var1, var3);
            } else {
                var6 = this.parser.dietParse(var1, var3);
            }
            var6.field_446 |= 1;
            this.lookupEnvironment.buildTypeBindings(var6, var2);
            this.addCompilationUnit(var1, var6);
            this.lookupEnvironment.completeTypeBindings(var6);
        } catch (AbortCompilationUnit var5) {
            if (var3.compilationUnit != var1) {
                throw var5;
            }
            this.requestor.acceptResult(var3.tagAsAccepted());
        }
    }

    public void accept(ISourceType[] var1, PackageBinding var2, AccessRestriction var3) {
        this.problemReporter.abortDueToInternalError(Messages.bind(Messages.field_1880, new String[] {String.valueOf(var1[0].getContents()), String.valueOf(var1[0].method_50())}));
    }

    protected synchronized void addCompilationUnit(ICompilationUnit var1, CompilationUnitDeclaration var2) {
        int var3 = this.unitsToProcess.length;
        if (this.field_1706 == var3) {
            System.arraycopy(this.unitsToProcess, 0, this.unitsToProcess = new CompilationUnitDeclaration[var3 * 2], 0, this.field_1706);
        }
        this.unitsToProcess[this.field_1706++] = var2;
    }

    protected void beginToCompile(ICompilationUnit[] var1) {
        int var2 = var1.length;
        this.field_1706 = 0;
        this.unitsToProcess = new CompilationUnitDeclaration[var2];
        this.internalBeginToCompile(var1, var2);
    }

    protected void reportProgress(String var1) {
        if (this.progress != null) {
            if (this.progress.isCanceled()) {
                AbortCompilation var10000 = new AbortCompilation(true, (RuntimeException)null);
                throw var10000;
            }
            this.progress.setTaskName(var1);
        }
    }

    protected void reportWorked(int var1, int var2) {
        if (this.progress != null) {
            if (this.progress.isCanceled()) {
                AbortCompilation var10000 = new AbortCompilation(true, (RuntimeException)null);
                throw var10000;
            }
            this.progress.worked(var1, this.field_1706 * this.field_1704 - var2 - 1);
        }
    }

    public void method_2944(ICompilationUnit[] var1) {
        this.stats.field_1967 = System.currentTimeMillis();
        CompilationUnitDeclaration var2 = null;
        ProcessTaskManager var3 = null;
        try {
            this.reportProgress(Messages.field_1870);
            this.beginToCompile(var1);
            if (this.annotationProcessorManager != null) {
                this.method_2951();
                if (!this.options.field_1964) {
                    return;
                }
            }
            int var4;
            if (this.useSingleThread) {
                for (var4 = 0; var4 < this.field_1706; ++var4) {
                    var2 = this.unitsToProcess[var4];
                    this.reportProgress(Messages.bind(Messages.field_1871, new String(var2.method_771())));
                    try {
                        if (this.options.field_1931) {
                            this.field_1701.println(Messages.bind(Messages.field_1864, new String[] {String.valueOf(var4 + 1), String.valueOf(this.field_1706), new String(this.unitsToProcess[var4].method_771())}));
                        }
                        this.process(var2, var4);
                    } finally {
                        var2.method_766();
                    }
                    this.unitsToProcess[var4] = null;
                    this.reportWorked(1, var4);
                    this.stats.field_1969 += (long)var2.compilationResult.lineSeparatorPositions.length;
                    long var5 = System.currentTimeMillis();
                    this.requestor.acceptResult(var2.compilationResult.tagAsAccepted());
                    this.stats.field_1973 += System.currentTimeMillis() - var5;
                    if (this.options.field_1931) {
                        this.field_1701.println(Messages.bind(Messages.field_1866, new String[] {String.valueOf(var4 + 1), String.valueOf(this.field_1706), new String(var2.method_771())}));
                    }
                }
            } else {
                ProcessTaskManager var10000 = new ProcessTaskManager(this);
                var3 = var10000;
                var4 = 0;
                while (true) {
                    try {
                        var2 = var3.removeNextUnit();
                    } catch (Error var22) {
                        var2 = var3.unitToProcess;
                        throw var22;
                    } catch (RuntimeException var23) {
                        var2 = var3.unitToProcess;
                        throw var23;
                    }
                    if (var2 == null) {
                        break;
                    }
                    this.reportWorked(1, var4++);
                    this.stats.field_1969 += (long)var2.compilationResult.lineSeparatorPositions.length;
                    this.requestor.acceptResult(var2.compilationResult.tagAsAccepted());
                    if (this.options.field_1931) {
                        this.field_1701.println(Messages.bind(Messages.field_1866, new String[] {String.valueOf(var4), String.valueOf(this.field_1706), new String(var2.method_771())}));
                    }
                }
            }
        } catch (AbortCompilation var25) {
            this.handleInternalException(var25, var2);
        } catch (Error var26) {
            this.handleInternalException(var26, var2, (CompilationResult)null);
            throw var26;
        } catch (RuntimeException var27) {
            this.handleInternalException(var27, var2, (CompilationResult)null);
            throw var27;
        } finally {
            if (var3 != null) {
                var3.shutdown();
                var3 = null;
            }
            this.method_2952();
            this.stats.field_1968 = System.currentTimeMillis();
        }
        if (this.options.field_1931) {
            if (this.field_1706 > 1) {
                this.field_1701.println(Messages.bind(Messages.field_1867, String.valueOf(this.field_1706)));
            } else {
                this.field_1701.println(Messages.bind(Messages.field_1868, String.valueOf(this.field_1706)));
            }
        }
    }

    public synchronized CompilationUnitDeclaration getUnitToProcess(int var1) {
        if (var1 < this.field_1706) {
            CompilationUnitDeclaration var2 = this.unitsToProcess[var1];
            this.unitsToProcess[var1] = null;
            return var2;
        } else {
            return null;
        }
    }

    protected void handleInternalException(Throwable var1, CompilationUnitDeclaration var2, CompilationResult var3) {
        if (var3 == null && var2 != null) {
            var3 = var2.compilationResult;
        }
        if (var3 == null && this.lookupEnvironment.unitBeingCompleted != null) {
            var3 = this.lookupEnvironment.unitBeingCompleted.compilationResult;
        }
        if (var3 == null) {
            synchronized (this) {
                if (this.unitsToProcess != null && this.field_1706 > 0) {
                    var3 = this.unitsToProcess[this.field_1706 - 1].compilationResult;
                }
            }
        }
        boolean var4 = true;
        if (var3 != null) {
            var1.printStackTrace();
            String[] var5 = new String[] {Messages.field_1869 + "\n" + var1.toString()};
            var3.record(this.problemReporter.method_1450(var3.method_2920(), 0, var5, var5, 1, 0, 0, 0, 0), var2);
            if (!var3.field_1689) {
                this.requestor.acceptResult(var3.tagAsAccepted());
                var4 = false;
            }
        }
        if (var4) {
            var1.printStackTrace();
        }
    }

    protected void handleInternalException(AbortCompilation var1, CompilationUnitDeclaration var2) {
        if (var1.isSilent) {
            if (var1.silentException != null) {
                throw var1.silentException;
            }
        } else {
            CompilationResult var3 = var1.compilationResult;
            if (var3 == null && var2 != null) {
                var3 = var2.compilationResult;
            }
            if (var3 == null && this.lookupEnvironment.unitBeingCompleted != null) {
                var3 = this.lookupEnvironment.unitBeingCompleted.compilationResult;
            }
            if (var3 == null) {
                synchronized (this) {
                    if (this.unitsToProcess != null && this.field_1706 > 0) {
                        var3 = this.unitsToProcess[this.field_1706 - 1].compilationResult;
                    }
                }
            }
            if (var3 != null && !var3.field_1689) {
                if (var1.problem != null) {
                    CategorizedProblem var4 = var1.problem;
                    CategorizedProblem[] var5 = var3.field_1673;
                    int var6 = 0;
                    while (true) {
                        if (var6 >= var3.field_1675) {
                            if (var4 instanceof DefaultProblem) {
                                ((DefaultProblem)var4).method_1406(var3.method_2920());
                            }
                            var3.record(var4, var2);
                            break;
                        }
                        if (var5[var6] == var4) {
                            break;
                        }
                        ++var6;
                    }
                } else if (var1.exception != null) {
                    this.handleInternalException(var1.exception, (CompilationUnitDeclaration)null, var3);
                    return;
                }
                if (!var3.field_1689) {
                    this.requestor.acceptResult(var3.tagAsAccepted());
                }
            } else {
                var1.printStackTrace();
            }
        }
    }

    public void method_2948() {
        Parser var10001 = new Parser(this.problemReporter, this.options.field_1934);
        this.parser = var10001;
    }

    protected void internalBeginToCompile(ICompilationUnit[] var1, int var2) {
        if (!this.useSingleThread && var2 >= ReadManager.field_1671) {
            Parser var10000 = this.parser;
            ReadManager var10001 = new ReadManager(var1, var2);
            var10000.readManager = var10001;
        }
        for (int var3 = 0; var3 < var2; ++var3) {
            try {
                eclipse.instance.println(Messages.bind(Messages.field_1862, new String[] {String.valueOf(var3 + 1), String.valueOf(var2), new String(var1[var3].method_50())}));
                CompilationResult var14 = new CompilationResult(var1[var3], var3, var2, this.options.field_1935);
                CompilationResult var5 = var14;
                long var6 = System.currentTimeMillis();
                CompilationUnitDeclaration var4;
                if (this.field_1706 < this.field_1709) {
                    var4 = this.parser.parse(var1[var3], var5);
                } else {
                    var4 = this.parser.dietParse(var1[var3], var5);
                }
                long var8 = System.currentTimeMillis();
                this.stats.field_1970 += var8 - var6;
                this.lookupEnvironment.buildTypeBindings(var4, (AccessRestriction)null);
                this.stats.field_1971 += System.currentTimeMillis() - var8;
                this.addCompilationUnit(var1[var3], var4);
                ImportReference var10 = var4.currentPackage;
                if (var10 != null) {
                    var5.recordPackageName(var10.tokens);
                }
            } finally {
                var1[var3] = null;
            }
        }
        if (this.parser.readManager != null) {
            this.parser.readManager.shutdown();
            this.parser.readManager = null;
        }
        this.lookupEnvironment.method_484();
    }

    public void process(CompilationUnitDeclaration var1, int var2) {
        this.lookupEnvironment.unitBeingCompleted = var1;
        long var3 = System.currentTimeMillis();
        this.parser.getMethodBodies(var1);
        long var5 = System.currentTimeMillis();
        this.stats.field_1970 += var5 - var3;
        if (var1.scope != null) {
            var1.scope.method_680();
        }
        if (var1.scope != null) {
            var1.scope.verifyMethods(this.lookupEnvironment.methodVerifier());
        }
        var1.method_778();
        long var7 = System.currentTimeMillis();
        this.stats.field_1971 += var7 - var5;
        var1.method_765();
        long var9 = System.currentTimeMillis();
        this.stats.field_1972 += var9 - var7;
        var1.method_770();
        if (this.options.field_1932 && var1.scope != null) {
            var1.scope.method_696();
        }
        var1.method_769();
        this.stats.field_1973 += System.currentTimeMillis() - var9;
        var1.compilationResult.field_1688 = this.field_1706;
        this.lookupEnvironment.unitBeingCompleted = null;
    }

    protected void method_2951() {
        boolean var1 = false;
        boolean var2 = false;
        int var3 = 0;
        int var4 = this.field_1706;
        ReferenceBinding[] var5 = this.referenceBindings;
        if (var4 != 0 || var5 != null) {
            this.referenceBindings = null;
            int var11;
            int var12;
            do {
                int var6 = var4 - var3;
                CompilationUnitDeclaration[] var7 = new CompilationUnitDeclaration[var6];
                int var8 = 0;
                for (int var9 = var3; var9 < var4; ++var9) {
                    CompilationUnitDeclaration var10 = this.unitsToProcess[var9];
                    if ((var10.field_446 & 1) == 0) {
                        var7[var8++] = var10;
                    }
                }
                if (var8 != var6) {
                    System.arraycopy(var7, 0, var7 = new CompilationUnitDeclaration[var8], 0, var8);
                }
                this.annotationProcessorManager.processAnnotations(var7, var5, false);
                ICompilationUnit[] var13 = this.annotationProcessorManager.method_2935();
                var11 = var13.length;
                ReferenceBinding[] var14 = this.annotationProcessorManager.getNewClassFiles();
                var5 = var14;
                var12 = var14.length;
                if (var11 != 0) {
                    this.internalBeginToCompile(var13, var11);
                    var3 = var4;
                    var4 = this.field_1706;
                } else {
                    var3 = var4;
                }
                this.annotationProcessorManager.reset();
            } while (var11 != 0 || var12 != 0);
            this.annotationProcessorManager.processAnnotations((CompilationUnitDeclaration[])null, (ReferenceBinding[])null, true);
        }
    }

    public void method_2952() {
        this.lookupEnvironment.method_518();
        this.parser.scanner.field_1237 = null;
        this.unitsToProcess = null;
        if (DebugRequestor != null) {
            DebugRequestor.method_22();
        }
        this.problemReporter.reset();
    }

    static {
        DEBUG = false;
        DebugRequestor = null;
    }
}
