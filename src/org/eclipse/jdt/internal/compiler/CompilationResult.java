package org.eclipse.jdt.internal.compiler;

import java.util.Comparator;
import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Arrays;

import java.util.Vector;

import org.eclipse.jdt.core.compiler.CategorizedProblem;
import org.eclipse.jdt.internal.compiler.CompilationResult$1;
import org.eclipse.jdt.internal.compiler.ClassFile;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.env.ICompilationUnit;
import org.eclipse.jdt.internal.compiler.impl.ReferenceContext;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.parser.RecoveryScannerData;
import org.eclipse.jdt.internal.compiler.util.Util;

public class CompilationResult {

    public CategorizedProblem[] field_1673;

    public CategorizedProblem[] field_1674;

    public int field_1675;

    public int field_1676;

    public ICompilationUnit compilationUnit;

    public Map field_1678;

    public Vector field_1679;

    private int maxProblemPerUnit;

    public char[][][] qualifiedReferences;

    public char[][] field_1682;

    public boolean field_1683;

    public int[] lineSeparatorPositions;

    public RecoveryScannerData recoveryScannerData;

    public Map field_1686;

    public int field_1687;

    public int field_1688;

    public boolean field_1689;

    public String field_1690;

    public boolean field_1691;

    public boolean field_1692;

    public char[][] field_1693;

    public boolean field_1694;

    private static final int[] EMPTY_LINE_ENDS;

    private static final Comparator field_1696;

    public CompilationResult(String var1, int var2, int var3, int var4) {
        this.field_1683 = false;
        HashMap var10001 = new HashMap(11);
        this.field_1686 = var10001;
        this.field_1689 = false;
        this.field_1691 = false;
        this.field_1692 = false;
        this.field_1694 = false;
        this.field_1690 = var1;
        this.field_1687 = var2;
        this.field_1688 = var3;
        this.maxProblemPerUnit = var4;
    }

    public CompilationResult(ICompilationUnit var1, int var2, int var3, int var4) {
        this.field_1683 = false;
        HashMap var10001 = new HashMap(11);
        this.field_1686 = var10001;
        this.field_1689 = false;
        this.field_1691 = false;
        this.field_1692 = false;
        this.field_1694 = false;
        this.field_1690 = var1.method_50();
        this.compilationUnit = var1;
        this.field_1687 = var2;
        this.field_1688 = var3;
        this.maxProblemPerUnit = var4;
    }

    private int computePriority(CategorizedProblem var1) {
        int var6 = 10000 - var1.method_1403();
        if (var6 < 0) {
            var6 = 0;
        }
        if (var1.method_1399()) {
            var6 += 100000;
        }
        ReferenceContext var7 = this.field_1678 == null ? null : (ReferenceContext)this.field_1678.get(var1);
        if (var7 != null) {
            if (var7 instanceof AbstractMethodDeclaration) {
                AbstractMethodDeclaration var8 = (AbstractMethodDeclaration)var7;
                if (var8.method_799()) {
                    var6 += 10000;
                }
            } else {
                var6 += '\u9c40';
            }
            if (this.field_1679.contains(var1)) {
                var6 += 20000;
            }
        } else {
            var6 += '\u9c40';
        }
        return var6;
    }

    public CategorizedProblem[] method_2916() {
        CategorizedProblem[] var1 = this.method_2922();
        int var2 = var1 != null ? var1.length : 0;
        CategorizedProblem[] var3 = this.method_2923();
        int var4 = var3 != null ? var3.length : 0;
        if (var4 == 0) {
            return var1;
        } else if (var2 == 0) {
            return var3;
        } else {
            int var5 = var2 + var4;
            CategorizedProblem[] var6 = new CategorizedProblem[var5];
            int var7 = 0;
            int var8 = 0;
            CategorizedProblem var12;
            for (int var9 = 0; var8 + var9 < var5; var6[var7++] = var12) {
                CategorizedProblem var10 = null;
                CategorizedProblem var11 = null;
                if (var8 < var4) {
                    var10 = var3[var8];
                }
                if (var9 < var2) {
                    var11 = var1[var9];
                }
                var12 = null;
                if (var11 != null) {
                    if (var10 != null) {
                        if (var11.method_1401() < var10.method_1401()) {
                            var12 = var11;
                            ++var9;
                        } else {
                            var12 = var10;
                            ++var8;
                        }
                    } else {
                        var12 = var11;
                        ++var9;
                    }
                } else if (var10 != null) {
                    var12 = var10;
                    ++var8;
                }
            }
            return var6;
        }
    }

    public ClassFile[] getClassFiles() {
        ClassFile[] var1 = new ClassFile[this.field_1686.size()];
        this.field_1686.values().toArray(var1);
        return var1;
    }

    public ICompilationUnit getCompilationUnit() {
        return this.compilationUnit;
    }

    public CategorizedProblem[] method_2919() {
        CategorizedProblem[] var1 = this.method_2922();
        int var2 = 0;
        for (int var3 = 0; var3 < this.field_1675; ++var3) {
            if (var1[var3].method_1399()) {
                ++var2;
            }
        }
        if (var2 == this.field_1675) {
            return var1;
        } else {
            CategorizedProblem[] var6 = new CategorizedProblem[var2];
            int var4 = 0;
            for (int var5 = 0; var5 < this.field_1675; ++var5) {
                if (var1[var5].method_1399()) {
                    var6[var4++] = var1[var5];
                }
            }
            return var6;
        }
    }

    public String method_2920() {
        return this.field_1690;
    }

    public int[] getLineSeparatorPositions() {
        return this.lineSeparatorPositions == null ? EMPTY_LINE_ENDS : this.lineSeparatorPositions;
    }

    public CategorizedProblem[] method_2922() {
        if (this.field_1673 != null) {
            if (this.field_1675 != this.field_1673.length) {
                System.arraycopy(this.field_1673, 0, this.field_1673 = new CategorizedProblem[this.field_1675], 0, this.field_1675);
            }
            if (this.maxProblemPerUnit > 0 && this.field_1675 > this.maxProblemPerUnit) {
                this.quickPrioritize(this.field_1673, 0, this.field_1675 - 1);
                this.field_1675 = this.maxProblemPerUnit;
                System.arraycopy(this.field_1673, 0, this.field_1673 = new CategorizedProblem[this.field_1675], 0, this.field_1675);
            }
            Arrays.sort(this.field_1673, 0, this.field_1673.length, field_1696);
        }
        return this.field_1673;
    }

    public CategorizedProblem[] method_2923() {
        if (this.field_1674 != null) {
            if (this.field_1676 != this.field_1674.length) {
                System.arraycopy(this.field_1674, 0, this.field_1674 = new CategorizedProblem[this.field_1676], 0, this.field_1676);
            }
            Arrays.sort(this.field_1674, 0, this.field_1674.length, field_1696);
        }
        return this.field_1674;
    }

    public boolean method_2924() {
        if (this.field_1673 != null) {
            for (int var1 = 0; var1 < this.field_1675; ++var1) {
                if (this.field_1673[var1].method_1399()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean method_2925() {
        return this.field_1675 != 0;
    }

    public boolean method_2926() {
        return this.field_1676 != 0;
    }

    private void quickPrioritize(CategorizedProblem[] var1, int var2, int var3) {
        if (var2 < var3) {
            int var4 = var2;
            int var5 = var3;
            int var6 = this.computePriority(var1[var2 + (var3 - var2) / 2]);
            while (true) {
                while (this.computePriority(var1[var3]) >= var6) {
                    while (var6 < this.computePriority(var1[var2])) {
                        ++var2;
                    }
                    if (var2 <= var3) {
                        CategorizedProblem var7 = var1[var2];
                        var1[var2] = var1[var3];
                        var1[var3] = var7;
                        ++var2;
                        --var3;
                    }
                    if (var2 > var3) {
                        if (var4 < var3) {
                            this.quickPrioritize(var1, var4, var3);
                        }
                        if (var2 < var5) {
                            this.quickPrioritize(var1, var2, var5);
                        }
                        return;
                    }
                }
                --var3;
            }
        }
    }

    public void recordPackageName(char[][] var1) {
        this.field_1693 = var1;
    }

    public void record(CategorizedProblem var1, ReferenceContext var2) {
        if (var1.method_1398() == 536871362) {
            this.recordTask(var1);
        } else {
            if (this.field_1675 == 0) {
                this.field_1673 = new CategorizedProblem[5];
            } else if (this.field_1675 == this.field_1673.length) {
                System.arraycopy(this.field_1673, 0, this.field_1673 = new CategorizedProblem[this.field_1675 * 2], 0, this.field_1675);
            }
            this.field_1673[this.field_1675++] = var1;
            if (var2 != null) {
                if (this.field_1678 == null) {
                    HashMap var10001 = new HashMap(5);
                    this.field_1678 = var10001;
                }
                if (this.field_1679 == null) {
                    this.field_1679 = new Vector(5);
                }
                if (var1.method_1399() && !var2.hasErrors()) {
                    this.field_1679.addElement(var1);
                }
                this.field_1678.put(var1, var2);
            }
            if ((var1.method_1398() & 1073741824) != 0 && var1.method_1399()) {
                this.field_1692 = true;
            }
        }
    }

    public void record(char[] var1, ClassFile var2) {
        SourceTypeBinding var3 = var2.referenceBinding;
        if (!var3.method_158() && var3.method_156()) {
            this.field_1691 = true;
        }
        this.field_1686.put(var1, var2);
    }

    private void recordTask(CategorizedProblem var1) {
        if (this.field_1676 == 0) {
            this.field_1674 = new CategorizedProblem[5];
        } else if (this.field_1676 == this.field_1674.length) {
            System.arraycopy(this.field_1674, 0, this.field_1674 = new CategorizedProblem[this.field_1676 * 2], 0, this.field_1676);
        }
        this.field_1674[this.field_1676++] = var1;
    }

    public CompilationResult tagAsAccepted() {
        this.field_1689 = true;
        this.field_1678 = null;
        this.field_1679 = null;
        return this;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        if (this.field_1690 != null) {
            var1.append("Filename : ").append(this.field_1690).append('\n');
        }
        if (this.field_1686 != null) {
            var1.append("COMPILED type(s)\t\n");
            Iterator var2 = this.field_1686.keySet().iterator();
            while (var2.hasNext()) {
                char[] var3 = (char[])((char[])var2.next());
                var1.append("\t - ").append(var3).append('\n');
            }
        } else {
            var1.append("No COMPILED type\n");
        }
        if (this.field_1673 != null) {
            var1.append(this.field_1675).append(" PROBLEM(s) detected \n");
            for (int var4 = 0; var4 < this.field_1675; ++var4) {
                var1.append("\t - ").append(this.field_1673[var4]).append('\n');
            }
        } else {
            var1.append("No PROBLEM\n");
        }
        return var1.toString();
    }

    static {
        EMPTY_LINE_ENDS = Util.EMPTY_INT_ARRAY;
        CompilationResult$1 var10000 = new CompilationResult$1();
        field_1696 = var10000;
    }
}
