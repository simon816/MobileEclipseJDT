package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.core.compiler.CategorizedProblem;
import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.ClassFile;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.ArrayInitializer;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.StringLiteral;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration$1;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.ImportReference;
import org.eclipse.jdt.internal.compiler.ast.MemberValuePair;
import org.eclipse.jdt.internal.compiler.impl.ReferenceContext;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.ImportBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.CompilationUnitScope;
import org.eclipse.jdt.internal.compiler.parser.NLSTag;
import org.eclipse.jdt.internal.compiler.problem.AbortCompilationUnit;
import org.eclipse.jdt.internal.compiler.problem.AbortType;
import org.eclipse.jdt.internal.compiler.problem.AbortMethod;
import org.eclipse.jdt.internal.compiler.problem.ProblemReporter;
import org.eclipse.jdt.internal.compiler.util.HashSetOfInt;

import java.util.Comparator;
import java.util.Arrays;

public class CompilationUnitDeclaration extends ASTNode implements ReferenceContext {

    private static final Comparator field_447;

    public ImportReference currentPackage;

    public ImportReference[] imports;

    public TypeDeclaration[] types;

    public boolean field_451;

    public boolean field_452;

    public CompilationUnitScope scope;

    public ProblemReporter problemReporter;

    public CompilationResult compilationResult;

    public LocalTypeBinding[] localTypes;

    public int localTypeCount;

    public boolean field_458;

    public NLSTag[] nlsTags;

    private StringLiteral[] stringLiterals;

    private int stringLiteralsPtr;

    private HashSetOfInt stringLiteralsStart;

    long[] field_463;

    Annotation[] suppressWarningAnnotations;

    long[] field_465;

    int suppressWarningsCount;

    public CompilationUnitDeclaration(ProblemReporter var1, CompilationResult var2, int var3) {
        this.field_451 = false;
        this.field_452 = false;
        this.localTypeCount = 0;
        this.problemReporter = var1;
        this.compilationResult = var2;
        this.field_444 = 0;
        this.field_445 = var3 - 1;
    }

    public void abort(int var1, CategorizedProblem var2) {
        switch (var1) {
            case 8:
                AbortType var3 = new AbortType(this.compilationResult, var2);
                throw var3;
            case 16:
                AbortMethod var10000 = new AbortMethod(this.compilationResult, var2);
                throw var10000;
            default:
                AbortCompilationUnit var4 = new AbortCompilationUnit(this.compilationResult, var2);
                throw var4;
        }
    }

    public void method_765() {
        if (!this.field_451) {
            try {
                if (this.types != null) {
                    int var1 = 0;
                    for (int var2 = this.types.length; var1 < var2; ++var1) {
                        this.types[var1].analyseCode(this.scope);
                    }
                }
                this.method_774();
            } catch (AbortCompilationUnit var3) {
                this.field_451 = true;
            }
        }
    }

    public void method_766() {
        int var2;
        if (this.types != null) {
            int var1 = 0;
            for (var2 = this.types.length; var1 < var2; ++var1) {
                this.cleanUp(this.types[var1]);
            }
            var1 = 0;
            for (var2 = this.localTypeCount; var1 < var2; ++var1) {
                LocalTypeBinding var3 = this.localTypes[var1];
                var3.scope = null;
                var3.enclosingCase = null;
            }
        }
        this.compilationResult.recoveryScannerData = null;
        ClassFile[] var5 = this.compilationResult.getClassFiles();
        var2 = 0;
        for (int var6 = var5.length; var2 < var6; ++var2) {
            ClassFile var4 = var5[var2];
            var4.referenceBinding = null;
            var4.field_1724 = null;
            var4.field_1732 = null;
        }
        this.suppressWarningAnnotations = null;
    }

    private void cleanUp(TypeDeclaration var1) {
        if (var1.memberTypes != null) {
            int var2 = 0;
            for (int var3 = var1.memberTypes.length; var2 < var3; ++var2) {
                this.cleanUp(var1.memberTypes[var2]);
            }
        }
        if (var1.binding != null && var1.binding.method_145()) {
            this.compilationResult.field_1683 = true;
        }
        if (var1.binding != null) {
            var1.binding.scope = null;
        }
    }

    public void method_768() {
        if (this.scope.imports != null) {
            int var1 = 0;
            for (int var2 = this.scope.imports.length; var1 < var2; ++var1) {
                ImportBinding var3 = this.scope.imports[var1];
                ImportReference var4 = var3.reference;
                if (var4 != null && (var4.field_446 & 2) == 0) {
                    this.scope.problemReporter().method_1809(var4);
                }
            }
        }
    }

    public CompilationResult compilationResult() {
        return this.compilationResult;
    }

    public void method_769() {
        if (this.suppressWarningsCount != 0) {
            int var1 = 0;
            CategorizedProblem[] var2 = this.compilationResult.field_1673;
            int var3 = this.compilationResult.field_1675;
            long[] var4 = new long[this.suppressWarningsCount];
            CompilerOptions var5 = this.scope.compilerOptions();
            boolean var6 = false;
            int var7 = 0;
            int var8;
            CategorizedProblem var9;
            int var10;
            int var15;
            int var16;
            for (var8 = var3; var7 < var8; ++var7) {
                var9 = var2[var7];
                var10 = var9.method_1398();
                if (var9.method_1399()) {
                    if (var10 != 536871547) {
                        var6 = true;
                    }
                } else {
                    int var11 = var9.method_1401();
                    int var12 = var9.method_1402();
                    long var13 = ProblemReporter.method_1457(var10);
                    var15 = 0;
                    for (var16 = this.suppressWarningsCount; var15 < var16; ++var15) {
                        long var17 = this.field_465[var15];
                        int var19 = (int)(var17 >>> 32);
                        int var20 = (int)var17;
                        if (var11 >= var19 && var12 <= var20 && (var13 & this.field_463[var15]) != 0L) {
                            ++var1;
                            var2[var7] = null;
                            if (this.compilationResult.field_1678 != null) {
                                this.compilationResult.field_1678.remove(var9);
                            }
                            if (this.compilationResult.field_1679 != null) {
                                this.compilationResult.field_1679.removeElement(var9);
                            }
                            var4[var15] |= var13;
                            break;
                        }
                    }
                }
            }
            if (var1 > 0) {
                var7 = 0;
                for (var8 = 0; var7 < var3; ++var7) {
                    if ((var9 = var2[var7]) != null) {
                        if (var7 > var8) {
                            var2[var8++] = var9;
                        } else {
                            ++var8;
                        }
                    }
                }
                this.compilationResult.field_1675 -= var1;
            }
            if (!var6) {
                var7 = var5.method_3313(18014398509481984L);
                if (var7 != -1) {
                    boolean var33 = (var7 & 1) == 0;
                    int var34 = 0;
                    label167:
                    for (var10 = this.suppressWarningsCount; var34 < var10; ++var34) {
                        Annotation var35 = this.suppressWarningAnnotations[var34];
                        if (var35 != null) {
                            long var36 = this.field_463[var34];
                            if ((!var33 || ~var36 != 0L) && var36 != var4[var34]) {
                                MemberValuePair[] var14 = var35.memberValuePairs();
                                var15 = 0;
                                for (var16 = var14.length; var15 < var16; ++var15) {
                                    MemberValuePair var37 = var14[var15];
                                    if (CharOperation.method_1364(var37.name, TypeConstants.field_70)) {
                                        Expression var18 = var37.value;
                                        int var22;
                                        int var27;
                                        int var28;
                                        if (var18 instanceof ArrayInitializer) {
                                            ArrayInitializer var38 = (ArrayInitializer)var18;
                                            Expression[] var40 = var38.expressions;
                                            if (var40 != null) {
                                                int var21 = 0;
                                                for (var22 = var40.length; var21 < var22; ++var21) {
                                                    Constant var23 = var40[var21].constant;
                                                    if (var23 != Constant.NotAConstant && var23.typeID() == 11) {
                                                        long var24 = CompilerOptions.optionKeyToIrritant(var23.method_3287());
                                                        if (var24 != 0L && ~var24 != 0L && var5.method_3313(var24) != -1 && (var4[var34] & var24) == 0L) {
                                                            if (var33) {
                                                                int var26 = var18.field_444;
                                                                var27 = var18.field_445;
                                                                for (var28 = var34 - 1; var28 >= 0; --var28) {
                                                                    long var29 = this.field_465[var28];
                                                                    int var31 = (int)(var29 >>> 32);
                                                                    int var32 = (int)var29;
                                                                    if (var26 >= var31 && var27 <= var32 && ~this.field_463[var28] == 0L) {
                                                                        continue label167;
                                                                    }
                                                                }
                                                            }
                                                            this.scope.problemReporter().method_1816(var40[var21]);
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            Constant var41 = var18.constant;
                                            if (var41 != Constant.NotAConstant && var41.typeID() == 11) {
                                                long var39 = CompilerOptions.optionKeyToIrritant(var41.method_3287());
                                                if (var39 != 0L && ~var39 != 0L && var5.method_3313(var39) != -1 && (var4[var34] & var39) == 0L) {
                                                    if (var33) {
                                                        var22 = var18.field_444;
                                                        int var42 = var18.field_445;
                                                        for (int var43 = var34 - 1; var43 >= 0; --var43) {
                                                            long var25 = this.field_465[var43];
                                                            var27 = (int)(var25 >>> 32);
                                                            var28 = (int)var25;
                                                            if (var22 >= var27 && var42 <= var28 && ~this.field_463[var43] == 0L) {
                                                                continue label167;
                                                            }
                                                        }
                                                    }
                                                    this.scope.problemReporter().method_1816(var18);
                                                }
                                            }
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void method_770() {
        int var1;
        int var2;
        if (this.field_451) {
            if (this.types != null) {
                var1 = 0;
                for (var2 = this.types.length; var1 < var2; ++var1) {
                    this.types[var1].field_590 = true;
                    this.types[var1].method_857(this.scope);
                }
            }
        } else {
            if (this.method_773() && this.types != null && this.currentPackage != null && this.currentPackage.annotations != null) {
                this.types[0].annotations = this.currentPackage.annotations;
            }
            try {
                if (this.types != null) {
                    var1 = 0;
                    for (var2 = this.types.length; var1 < var2; ++var1) {
                        this.types[var1].method_857(this.scope);
                    }
                }
            } catch (AbortCompilationUnit var3) {
                ;
            }
        }
    }

    public String method_771() {
        return this.compilationResult.method_2920();
    }

    public char[] method_772() {
        if (this.compilationResult.compilationUnit != null) {
            return this.compilationResult.compilationUnit.method_52();
        } else {
            char[] var1 = this.compilationResult.method_2920().toCharArray();
            int var2 = CharOperation.method_1376('/', var1) + 1;
            if (var2 == 0 || var2 < CharOperation.method_1376('\\', var1)) {
                var2 = CharOperation.method_1376('\\', var1) + 1;
            }
            int var3 = CharOperation.method_1376('.', var1);
            if (var3 == -1) {
                var3 = var1.length;
            }
            return CharOperation.subarray(var1, var2, var3);
        }
    }

    public boolean method_773() {
        return CharOperation.method_1364(this.method_772(), TypeConstants.field_144);
    }

    public boolean hasErrors() {
        return this.field_451;
    }

    public StringBuffer print(int var1, StringBuffer var2) {
        if (this.currentPackage != null) {
            method_759(var1, var2).append("package ");
            this.currentPackage.print(0, var2, false).append(";\n");
        }
        int var3;
        if (this.imports != null) {
            for (var3 = 0; var3 < this.imports.length; ++var3) {
                method_759(var1, var2).append("import ");
                ImportReference var4 = this.imports[var3];
                if (var4.isStatic()) {
                    var2.append("static ");
                }
                var4.print(0, var2).append(";\n");
            }
        }
        if (this.types != null) {
            for (var3 = 0; var3 < this.types.length; ++var3) {
                this.types[var3].print(var1, var2).append("\n");
            }
        }
        return var2;
    }

    public void method_774() {
        this.field_458 = true;
        int var1 = 0;
        for (int var2 = this.localTypeCount; var1 < var2; ++var1) {
            LocalTypeBinding var3 = this.localTypes[var1];
            if ((var3.scope.referenceType().field_446 & Integer.MIN_VALUE) != 0) {
                var3.updateInnerEmulationDependents();
            }
        }
    }

    public void recordStringLiteral(StringLiteral var1, boolean var2) {
        int var3;
        if (this.stringLiteralsStart != null) {
            if (this.stringLiteralsStart.contains(var1.field_444)) {
                return;
            }
            this.stringLiteralsStart.method_3210(var1.field_444);
        } else if (var2) {
            HashSetOfInt var10001 = new HashSetOfInt(this.stringLiteralsPtr + 10);
            this.stringLiteralsStart = var10001;
            for (var3 = 0; var3 < this.stringLiteralsPtr; ++var3) {
                this.stringLiteralsStart.method_3210(this.stringLiterals[var3].field_444);
            }
            if (this.stringLiteralsStart.contains(var1.field_444)) {
                return;
            }
            this.stringLiteralsStart.method_3210(var1.field_444);
        }
        if (this.stringLiterals == null) {
            this.stringLiterals = new StringLiteral[10];
            this.stringLiteralsPtr = 0;
        } else {
            var3 = this.stringLiterals.length;
            if (this.stringLiteralsPtr == var3) {
                System.arraycopy(this.stringLiterals, 0, this.stringLiterals = new StringLiteral[var3 + 10], 0, var3);
            }
        }
        this.stringLiterals[this.stringLiteralsPtr++] = var1;
    }

    public void method_776(long var1, Annotation var3, int var4, int var5) {
        if (this.field_463 == null) {
            this.field_463 = new long[3];
            this.suppressWarningAnnotations = new Annotation[3];
            this.field_465 = new long[3];
        } else if (this.field_463.length == this.suppressWarningsCount) {
            System.arraycopy(this.field_463, 0, this.field_463 = new long[2 * this.suppressWarningsCount], 0, this.suppressWarningsCount);
            System.arraycopy(this.suppressWarningAnnotations, 0, this.suppressWarningAnnotations = new Annotation[2 * this.suppressWarningsCount], 0, this.suppressWarningsCount);
            System.arraycopy(this.field_465, 0, this.field_465 = new long[2 * this.suppressWarningsCount], 0, this.suppressWarningsCount);
        }
        this.field_463[this.suppressWarningsCount] = var1;
        this.suppressWarningAnnotations[this.suppressWarningsCount] = var3;
        this.field_465[this.suppressWarningsCount++] = ((long)var4 << 32) + (long)var5;
    }

    public void record(LocalTypeBinding var1) {
        if (this.localTypeCount == 0) {
            this.localTypes = new LocalTypeBinding[5];
        } else if (this.localTypeCount == this.localTypes.length) {
            System.arraycopy(this.localTypes, 0, this.localTypes = new LocalTypeBinding[this.localTypeCount * 2], 0, this.localTypeCount);
        }
        this.localTypes[this.localTypeCount++] = var1;
    }

    public void method_778() {
        byte var1 = 0;
        boolean var2 = this.method_773();
        if (this.types != null && var2) {
            TypeDeclaration var3 = this.types[0];
            var3.method_868(this.scope);
            if (this.currentPackage != null && this.currentPackage.annotations != null) {
                method_761(var3.field_589, this.currentPackage.annotations, this.scope.fPackage);
            }
            var1 = 1;
        }
        if (this.currentPackage != null && this.currentPackage.annotations != null && !var2) {
            this.scope.problemReporter().method_1631(this.currentPackage.annotations[0]);
        }
        try {
            if (this.types != null) {
                int var6 = var1;
                for (int var4 = this.types.length; var6 < var4; ++var6) {
                    this.types[var6].method_868(this.scope);
                }
            }
            if (!this.compilationResult.method_2924()) {
                this.method_768();
            }
            this.reportNLSProblems();
        } catch (AbortCompilationUnit var5) {
            this.field_451 = true;
        }
    }

    private void reportNLSProblems() {
        if (this.nlsTags != null || this.stringLiterals != null) {
            int var1 = this.stringLiteralsPtr;
            int var2 = this.nlsTags == null ? 0 : this.nlsTags.length;
            int var3;
            if (var1 == 0) {
                if (var2 != 0) {
                    for (var3 = 0; var3 < var2; ++var3) {
                        NLSTag var4 = this.nlsTags[var3];
                        if (var4 != null) {
                            this.scope.problemReporter().method_1794(var4.field_1638, var4.field_1639);
                        }
                    }
                }
            } else if (var2 == 0) {
                if (this.stringLiterals.length != var1) {
                    System.arraycopy(this.stringLiterals, 0, this.stringLiterals = new StringLiteral[var1], 0, var1);
                }
                Arrays.sort(this.stringLiterals, field_447);
                for (var3 = 0; var3 < var1; ++var3) {
                    this.scope.problemReporter().method_1701(this.stringLiterals[var3]);
                }
            } else {
                if (this.stringLiterals.length != var1) {
                    System.arraycopy(this.stringLiterals, 0, this.stringLiterals = new StringLiteral[var1], 0, var1);
                }
                Arrays.sort(this.stringLiterals, field_447);
                var3 = 1;
                int var14 = -1;
                StringLiteral var5 = null;
                int var6 = 0;
                int var7;
                label109:
                for (var7 = 0; var7 < var1; ++var7) {
                    var5 = this.stringLiterals[var7];
                    int var8 = var5.lineNumber;
                    if (var14 != var8) {
                        var3 = 1;
                        var14 = var8;
                    } else {
                        ++var3;
                    }
                    if (var6 >= var2) {
                        break;
                    }
                    while (true) {
                        if (var6 >= var2) {
                            break label109;
                        }
                        NLSTag var9 = this.nlsTags[var6];
                        if (var9 != null) {
                            int var10 = var9.field_1640;
                            if (var8 < var10) {
                                this.scope.problemReporter().method_1701(var5);
                                break;
                            }
                            if (var8 == var10) {
                                if (var9.field_1641 == var3) {
                                    this.nlsTags[var6] = null;
                                    ++var6;
                                } else {
                                    for (int var11 = var6 + 1; var11 < var2; ++var11) {
                                        NLSTag var12 = this.nlsTags[var11];
                                        if (var12 != null) {
                                            int var13 = var12.field_1640;
                                            if (var8 != var13) {
                                                this.scope.problemReporter().method_1701(var5);
                                                continue label109;
                                            }
                                            if (var12.field_1641 == var3) {
                                                this.nlsTags[var11] = null;
                                                continue label109;
                                            }
                                        }
                                    }
                                    this.scope.problemReporter().method_1701(var5);
                                }
                                break;
                            }
                            this.scope.problemReporter().method_1794(var9.field_1638, var9.field_1639);
                        }
                        ++var6;
                    }
                }
                while (var7 < var1) {
                    this.scope.problemReporter().method_1701(this.stringLiterals[var7]);
                    ++var7;
                }
                if (var6 < var2) {
                    for (; var6 < var2; ++var6) {
                        NLSTag var15 = this.nlsTags[var6];
                        if (var15 != null) {
                            this.scope.problemReporter().method_1794(var15.field_1638, var15.field_1639);
                        }
                    }
                }
            }
        }
    }

    public void tagAsHavingErrors() {
        this.field_451 = true;
    }

    static {
        CompilationUnitDeclaration$1 var10000 = new CompilationUnitDeclaration$1();
        field_447 = var10000;
    }
}
