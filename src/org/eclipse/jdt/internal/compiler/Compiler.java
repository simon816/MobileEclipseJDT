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

    public Parser field_1697;

    public ICompilerRequestor field_1698;

    public CompilerOptions field_1699;

    public ProblemReporter field_1700;

    protected PrintStream field_1701;

    public CompilerStats field_1702;

    public CompilationProgress field_1703;

    public int field_1704;

    public CompilationUnitDeclaration[] field_1705;

    public int field_1706;

    public LookupEnvironment field_1707;

    public static boolean field_1708;

    public int field_1709;

    public AbstractAnnotationProcessorManager field_1710;

    public ReferenceBinding[] field_1711;

    public boolean field_1712;

    public static IDebugRequestor field_1713;

    public Compiler(INameEnvironment var1, IErrorHandlingPolicy var2, CompilerOptions var3, ICompilerRequestor var4, IProblemFactory var5, PrintStream var6, CompilationProgress var7) {
        this.field_1704 = 1;
        this.field_1709 = -1;
        this.field_1712 = true;
        this.field_1699 = var3;
        this.field_1703 = var7;
        if (field_1713 == null) {
            this.field_1698 = var4;
        } else {
            Compiler$1 var10001 = new Compiler$1(this, var4);
            this.field_1698 = var10001;
        }
        try {
            this.field_1701 = System.out;
            CompilerStats var12 = new CompilerStats();
            this.field_1702 = var12;
            ProblemReporter var10 = new ProblemReporter(var2, this.field_1699, var5);
            this.field_1700 = var10;
            LookupEnvironment var11 = new LookupEnvironment(this, this.field_1699, this.field_1700, var1);
            this.field_1707 = var11;
            this.method_2948();
        } catch (Throwable var9) {
            var9.printStackTrace();
        }
    }

    public void method_87(IBinaryType var1, PackageBinding var2, AccessRestriction var3) {
        if (this.field_1699.field_1931) {
            this.field_1701.println(Messages.method_3251(Messages.field_1863, new String(var1.method_60())));
        }
        this.field_1707.method_494(var1, var2, var3);
    }

    public void method_88(ICompilationUnit var1, AccessRestriction var2) {
        CompilationResult var10000 = new CompilationResult(var1, this.field_1706, this.field_1706, this.field_1699.field_1935);
        CompilationResult var3 = var10000;
        var3.field_1694 = true;
        try {
            if (this.field_1699.field_1931) {
                String var4 = String.valueOf(this.field_1706 + 1);
                this.field_1701.println(Messages.method_3253(Messages.field_1862, new String[] {var4, var4, new String(var1.method_50())}));
            }
            CompilationUnitDeclaration var6;
            if (this.field_1706 < this.field_1709) {
                var6 = this.field_1697.method_2856(var1, var3);
            } else {
                var6 = this.field_1697.method_2827(var1, var3);
            }
            var6.field_446 |= 1;
            this.field_1707.method_483(var6, var2);
            this.method_2940(var1, var6);
            this.field_1707.method_485(var6);
        } catch (AbortCompilationUnit var5) {
            if (var3.field_1677 != var1) {
                throw var5;
            }
            this.field_1698.method_26(var3.method_2932());
        }
    }

    public void method_89(ISourceType[] var1, PackageBinding var2, AccessRestriction var3) {
        this.field_1700.method_1459(Messages.method_3253(Messages.field_1880, new String[] {String.valueOf(var1[0].method_51()), String.valueOf(var1[0].method_50())}));
    }

    protected synchronized void method_2940(ICompilationUnit var1, CompilationUnitDeclaration var2) {
        int var3 = this.field_1705.length;
        if (this.field_1706 == var3) {
            System.arraycopy(this.field_1705, 0, this.field_1705 = new CompilationUnitDeclaration[var3 * 2], 0, this.field_1706);
        }
        this.field_1705[this.field_1706++] = var2;
    }

    protected void method_2941(ICompilationUnit[] var1) {
        int var2 = var1.length;
        this.field_1706 = 0;
        this.field_1705 = new CompilationUnitDeclaration[var2];
        this.method_2949(var1, var2);
    }

    protected void method_2942(String var1) {
        if (this.field_1703 != null) {
            if (this.field_1703.method_1394()) {
                AbortCompilation var10000 = new AbortCompilation(true, (RuntimeException)null);
                throw var10000;
            }
            this.field_1703.method_1395(var1);
        }
    }

    protected void method_2943(int var1, int var2) {
        if (this.field_1703 != null) {
            if (this.field_1703.method_1394()) {
                AbortCompilation var10000 = new AbortCompilation(true, (RuntimeException)null);
                throw var10000;
            }
            this.field_1703.method_1396(var1, this.field_1706 * this.field_1704 - var2 - 1);
        }
    }

    public void method_2944(ICompilationUnit[] var1) {
        this.field_1702.field_1967 = System.currentTimeMillis();
        CompilationUnitDeclaration var2 = null;
        ProcessTaskManager var3 = null;
        try {
            this.method_2942(Messages.field_1870);
            this.method_2941(var1);
            if (this.field_1710 != null) {
                this.method_2951();
                if (!this.field_1699.field_1964) {
                    return;
                }
            }
            int var4;
            if (this.field_1712) {
                for (var4 = 0; var4 < this.field_1706; ++var4) {
                    var2 = this.field_1705[var4];
                    this.method_2942(Messages.method_3251(Messages.field_1871, new String(var2.method_771())));
                    try {
                        if (this.field_1699.field_1931) {
                            this.field_1701.println(Messages.method_3253(Messages.field_1864, new String[] {String.valueOf(var4 + 1), String.valueOf(this.field_1706), new String(this.field_1705[var4].method_771())}));
                        }
                        this.method_2950(var2, var4);
                    } finally {
                        var2.method_766();
                    }
                    this.field_1705[var4] = null;
                    this.method_2943(1, var4);
                    this.field_1702.field_1969 += (long)var2.field_455.field_1684.length;
                    long var5 = System.currentTimeMillis();
                    this.field_1698.method_26(var2.field_455.method_2932());
                    this.field_1702.field_1973 += System.currentTimeMillis() - var5;
                    if (this.field_1699.field_1931) {
                        this.field_1701.println(Messages.method_3253(Messages.field_1866, new String[] {String.valueOf(var4 + 1), String.valueOf(this.field_1706), new String(var2.method_771())}));
                    }
                }
            } else {
                ProcessTaskManager var10000 = new ProcessTaskManager(this);
                var3 = var10000;
                var4 = 0;
                while (true) {
                    try {
                        var2 = var3.method_2906();
                    } catch (Error var22) {
                        var2 = var3.field_1652;
                        throw var22;
                    } catch (RuntimeException var23) {
                        var2 = var3.field_1652;
                        throw var23;
                    }
                    if (var2 == null) {
                        break;
                    }
                    this.method_2943(1, var4++);
                    this.field_1702.field_1969 += (long)var2.field_455.field_1684.length;
                    this.field_1698.method_26(var2.field_455.method_2932());
                    if (this.field_1699.field_1931) {
                        this.field_1701.println(Messages.method_3253(Messages.field_1866, new String[] {String.valueOf(var4), String.valueOf(this.field_1706), new String(var2.method_771())}));
                    }
                }
            }
        } catch (AbortCompilation var25) {
            this.method_2947(var25, var2);
        } catch (Error var26) {
            this.method_2946(var26, var2, (CompilationResult)null);
            throw var26;
        } catch (RuntimeException var27) {
            this.method_2946(var27, var2, (CompilationResult)null);
            throw var27;
        } finally {
            if (var3 != null) {
                var3.method_2907();
                var3 = null;
            }
            this.method_2952();
            this.field_1702.field_1968 = System.currentTimeMillis();
        }
        if (this.field_1699.field_1931) {
            if (this.field_1706 > 1) {
                this.field_1701.println(Messages.method_3251(Messages.field_1867, String.valueOf(this.field_1706)));
            } else {
                this.field_1701.println(Messages.method_3251(Messages.field_1868, String.valueOf(this.field_1706)));
            }
        }
    }

    public synchronized CompilationUnitDeclaration method_2945(int var1) {
        if (var1 < this.field_1706) {
            CompilationUnitDeclaration var2 = this.field_1705[var1];
            this.field_1705[var1] = null;
            return var2;
        } else {
            return null;
        }
    }

    protected void method_2946(Throwable var1, CompilationUnitDeclaration var2, CompilationResult var3) {
        if (var3 == null && var2 != null) {
            var3 = var2.field_455;
        }
        if (var3 == null && this.field_1707.field_362 != null) {
            var3 = this.field_1707.field_362.field_455;
        }
        if (var3 == null) {
            synchronized (this) {
                if (this.field_1705 != null && this.field_1706 > 0) {
                    var3 = this.field_1705[this.field_1706 - 1].field_455;
                }
            }
        }
        boolean var4 = true;
        if (var3 != null) {
            var1.printStackTrace();
            String[] var5 = new String[] {Messages.field_1869 + "\n" + var1.toString()};
            var3.method_2929(this.field_1700.method_1450(var3.method_2920(), 0, var5, var5, 1, 0, 0, 0, 0), var2);
            if (!var3.field_1689) {
                this.field_1698.method_26(var3.method_2932());
                var4 = false;
            }
        }
        if (var4) {
            var1.printStackTrace();
        }
    }

    protected void method_2947(AbortCompilation var1, CompilationUnitDeclaration var2) {
        if (var1.field_1052) {
            if (var1.field_1053 != null) {
                throw var1.field_1053;
            }
        } else {
            CompilationResult var3 = var1.field_1049;
            if (var3 == null && var2 != null) {
                var3 = var2.field_455;
            }
            if (var3 == null && this.field_1707.field_362 != null) {
                var3 = this.field_1707.field_362.field_455;
            }
            if (var3 == null) {
                synchronized (this) {
                    if (this.field_1705 != null && this.field_1706 > 0) {
                        var3 = this.field_1705[this.field_1706 - 1].field_455;
                    }
                }
            }
            if (var3 != null && !var3.field_1689) {
                if (var1.field_1051 != null) {
                    CategorizedProblem var4 = var1.field_1051;
                    CategorizedProblem[] var5 = var3.field_1673;
                    int var6 = 0;
                    while (true) {
                        if (var6 >= var3.field_1675) {
                            if (var4 instanceof DefaultProblem) {
                                ((DefaultProblem)var4).method_1406(var3.method_2920());
                            }
                            var3.method_2929(var4, var2);
                            break;
                        }
                        if (var5[var6] == var4) {
                            break;
                        }
                        ++var6;
                    }
                } else if (var1.field_1050 != null) {
                    this.method_2946(var1.field_1050, (CompilationUnitDeclaration)null, var3);
                    return;
                }
                if (!var3.field_1689) {
                    this.field_1698.method_26(var3.method_2932());
                }
            } else {
                var1.printStackTrace();
            }
        }
    }

    public void method_2948() {
        Parser var10001 = new Parser(this.field_1700, this.field_1699.field_1934);
        this.field_1697 = var10001;
    }

    protected void method_2949(ICompilationUnit[] var1, int var2) {
        if (!this.field_1712 && var2 >= ReadManager.field_1671) {
            Parser var10000 = this.field_1697;
            ReadManager var10001 = new ReadManager(var1, var2);
            var10000.field_1636 = var10001;
        }
        for (int var3 = 0; var3 < var2; ++var3) {
            try {
                eclipse.instance.println(Messages.method_3253(Messages.field_1862, new String[] {String.valueOf(var3 + 1), String.valueOf(var2), new String(var1[var3].method_50())}));
                CompilationResult var14 = new CompilationResult(var1[var3], var3, var2, this.field_1699.field_1935);
                CompilationResult var5 = var14;
                long var6 = System.currentTimeMillis();
                CompilationUnitDeclaration var4;
                if (this.field_1706 < this.field_1709) {
                    var4 = this.field_1697.method_2856(var1[var3], var5);
                } else {
                    var4 = this.field_1697.method_2827(var1[var3], var5);
                }
                long var8 = System.currentTimeMillis();
                this.field_1702.field_1970 += var8 - var6;
                this.field_1707.method_483(var4, (AccessRestriction)null);
                this.field_1702.field_1971 += System.currentTimeMillis() - var8;
                this.method_2940(var1[var3], var4);
                ImportReference var10 = var4.field_448;
                if (var10 != null) {
                    var5.method_2928(var10.field_467);
                }
            } finally {
                var1[var3] = null;
            }
        }
        if (this.field_1697.field_1636 != null) {
            this.field_1697.field_1636.method_2911();
            this.field_1697.field_1636 = null;
        }
        this.field_1707.method_484();
    }

    public void method_2950(CompilationUnitDeclaration var1, int var2) {
        this.field_1707.field_362 = var1;
        long var3 = System.currentTimeMillis();
        this.field_1697.method_2834(var1);
        long var5 = System.currentTimeMillis();
        this.field_1702.field_1970 += var5 - var3;
        if (var1.field_453 != null) {
            var1.field_453.method_680();
        }
        if (var1.field_453 != null) {
            var1.field_453.method_698(this.field_1707.method_516());
        }
        var1.method_778();
        long var7 = System.currentTimeMillis();
        this.field_1702.field_1971 += var7 - var5;
        var1.method_765();
        long var9 = System.currentTimeMillis();
        this.field_1702.field_1972 += var9 - var7;
        var1.method_770();
        if (this.field_1699.field_1932 && var1.field_453 != null) {
            var1.field_453.method_696();
        }
        var1.method_769();
        this.field_1702.field_1973 += System.currentTimeMillis() - var9;
        var1.field_455.field_1688 = this.field_1706;
        this.field_1707.field_362 = null;
    }

    protected void method_2951() {
        boolean var1 = false;
        boolean var2 = false;
        int var3 = 0;
        int var4 = this.field_1706;
        ReferenceBinding[] var5 = this.field_1711;
        if (var4 != 0 || var5 != null) {
            this.field_1711 = null;
            int var11;
            int var12;
            do {
                int var6 = var4 - var3;
                CompilationUnitDeclaration[] var7 = new CompilationUnitDeclaration[var6];
                int var8 = 0;
                for (int var9 = var3; var9 < var4; ++var9) {
                    CompilationUnitDeclaration var10 = this.field_1705[var9];
                    if ((var10.field_446 & 1) == 0) {
                        var7[var8++] = var10;
                    }
                }
                if (var8 != var6) {
                    System.arraycopy(var7, 0, var7 = new CompilationUnitDeclaration[var8], 0, var8);
                }
                this.field_1710.method_2938(var7, var5, false);
                ICompilationUnit[] var13 = this.field_1710.method_2935();
                var11 = var13.length;
                ReferenceBinding[] var14 = this.field_1710.method_2936();
                var5 = var14;
                var12 = var14.length;
                if (var11 != 0) {
                    this.method_2949(var13, var11);
                    var3 = var4;
                    var4 = this.field_1706;
                } else {
                    var3 = var4;
                }
                this.field_1710.method_2937();
            } while (var11 != 0 || var12 != 0);
            this.field_1710.method_2938((CompilationUnitDeclaration[])null, (ReferenceBinding[])null, true);
        }
    }

    public void method_2952() {
        this.field_1707.method_518();
        this.field_1697.field_1628.field_1237 = null;
        this.field_1705 = null;
        if (field_1713 != null) {
            field_1713.method_22();
        }
        this.field_1700.method_1748();
    }

    static {
        field_1708 = false;
        field_1713 = null;
    }
}
