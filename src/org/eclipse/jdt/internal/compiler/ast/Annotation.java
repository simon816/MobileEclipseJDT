package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.ArrayInitializer;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.Reference;
import org.eclipse.jdt.internal.compiler.ast.NameReference;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.MemberValuePair;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.AnnotationBinding;
import org.eclipse.jdt.internal.compiler.lookup.ElementValuePair;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.PackageBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public abstract class Annotation extends Expression {

    static final MemberValuePair[] NoValuePairs;

    public int declarationSourceEnd;

    public Binding recipient;

    public TypeReference type;

    private AnnotationBinding compilerAnnotation;

    public Annotation() {
        this.compilerAnnotation = null;
    }

    public static long method_1069(char[] var0) {
        if (var0 != null && var0.length != 0) {
            switch (var0[0]) {
                case 67:
                    if (CharOperation.method_1364(var0, TypeConstants.field_74)) {
                        return 35184372088832L;
                    }
                    break;
                case 82:
                    if (CharOperation.method_1364(var0, TypeConstants.field_75)) {
                        return 52776558133248L;
                    }
                    break;
                case 83:
                    if (CharOperation.method_1364(var0, TypeConstants.field_73)) {
                        return 17592186044416L;
                    }
            }
            return 0L;
        } else {
            return 0L;
        }
    }

    public static long method_1070(char[] var0) {
        if (var0 != null && var0.length != 0) {
            switch (var0[0]) {
                case 65:
                    if (CharOperation.method_1364(var0, TypeConstants.field_84)) {
                        return 4398046511104L;
                    }
                case 66:
                case 68:
                case 69:
                case 71:
                case 72:
                case 73:
                case 74:
                case 75:
                case 78:
                case 79:
                case 81:
                case 82:
                case 83:
                default:
                    break;
                case 67:
                    if (CharOperation.method_1364(var0, TypeConstants.field_82)) {
                        return 1099511627776L;
                    }
                    break;
                case 70:
                    if (CharOperation.method_1364(var0, TypeConstants.field_79)) {
                        return 137438953472L;
                    }
                    break;
                case 76:
                    if (CharOperation.method_1364(var0, TypeConstants.field_83)) {
                        return 2199023255552L;
                    }
                    break;
                case 77:
                    if (CharOperation.method_1364(var0, TypeConstants.field_80)) {
                        return 274877906944L;
                    }
                    break;
                case 80:
                    if (CharOperation.method_1364(var0, TypeConstants.field_81)) {
                        return 549755813888L;
                    }
                    if (CharOperation.method_1364(var0, TypeConstants.field_85)) {
                        return 8796093022208L;
                    }
                    break;
                case 84:
                    if (CharOperation.method_1364(var0, TypeConstants.field_78)) {
                        return 68719476736L;
                    }
            }
            return 0L;
        } else {
            return 0L;
        }
    }

    public ElementValuePair[] computeElementValuePairs() {
        return Binding.NO_ELEMENT_VALUE_PAIRS;
    }

    private long detectStandardAnnotation(Scope var1, ReferenceBinding var2, MemberValuePair var3) {
        long var4 = 0L;
        Expression var6;
        FieldBinding var15;
        switch (var2.id) {
            case 44:
                var4 |= 70368744177664L;
                break;
            case 45:
                var4 |= 140737488355328L;
                break;
            case 46:
                var4 |= 281474976710656L;
                break;
            case 47:
                var4 |= 562949953421312L;
                break;
            case 48:
                if (var3 != null) {
                    var6 = var3.value;
                    if ((var6.field_446 & 3) == 1) {
                        var15 = ((Reference)var6).fieldBinding();
                        if (var15 != null && var15.declaringClass.id == 51) {
                            var4 |= method_1069(var15.name);
                        }
                    }
                }
                break;
            case 49:
                var4 |= 1125899906842624L;
                break;
            case 50:
                var4 |= 34359738368L;
                if (var3 != null) {
                    var6 = var3.value;
                    if (var6 instanceof ArrayInitializer) {
                        ArrayInitializer var7 = (ArrayInitializer)var6;
                        Expression[] var8 = var7.expressions;
                        if (var8 != null) {
                            int var9 = 0;
                            for (int var10 = var8.length; var9 < var10; ++var9) {
                                Expression var11 = var8[var9];
                                if ((var11.field_446 & 3) == 1) {
                                    FieldBinding var12 = ((Reference)var11).fieldBinding();
                                    if (var12 != null && var12.declaringClass.id == 52) {
                                        long var13 = method_1070(var12.name);
                                        if ((var4 & var13) != 0L) {
                                            var1.problemReporter().duplicateTargetInTargetAnnotation(var2, (NameReference)var11);
                                        } else {
                                            var4 |= var13;
                                        }
                                    }
                                }
                            }
                        }
                    } else if ((var6.field_446 & 3) == 1) {
                        var15 = ((Reference)var6).fieldBinding();
                        if (var15 != null && var15.declaringClass.id == 52) {
                            var4 |= method_1070(var15.name);
                        }
                    }
                }
        }
        return var4;
    }

    public AnnotationBinding getCompilerAnnotation() {
        return this.compilerAnnotation;
    }

    public abstract MemberValuePair[] memberValuePairs();

    public StringBuffer printExpression(int var1, StringBuffer var2) {
        var2.append('@');
        this.type.printExpression(0, var2);
        return var2;
    }

    public void recordSuppressWarnings(Scope var1, int var2, int var3, boolean var4) {
        long var5 = 0L;
        MemberValuePair[] var7 = this.memberValuePairs();
        int var8 = 0;
        for (int var9 = var7.length; var8 < var9; ++var8) {
            MemberValuePair var10 = var7[var8];
            if (CharOperation.method_1364(var10.name, TypeConstants.field_70)) {
                Expression var11 = var10.value;
                if (var11 instanceof ArrayInitializer) {
                    ArrayInitializer var12 = (ArrayInitializer)var11;
                    Expression[] var13 = var12.expressions;
                    if (var13 != null) {
                        int var14 = 0;
                        for (int var15 = var13.length; var14 < var15; ++var14) {
                            Constant var16 = var13[var14].constant;
                            if (var16 != Constant.NotAConstant && var16.typeID() == 11) {
                                long var17 = CompilerOptions.optionKeyToIrritant(var16.method_3287());
                                if (var17 != 0L) {
                                    if ((var5 & var17) == var17) {
                                        var1.problemReporter().method_1816(var13[var14]);
                                    } else {
                                        var5 |= var17;
                                    }
                                } else {
                                    var1.problemReporter().method_1787(var13[var14]);
                                }
                            }
                        }
                    }
                } else {
                    Constant var19 = var11.constant;
                    if (var19 != Constant.NotAConstant && var19.typeID() == 11) {
                        long var20 = CompilerOptions.optionKeyToIrritant(var19.method_3287());
                        if (var20 != 0L) {
                            var5 |= var20;
                        } else {
                            var1.problemReporter().method_1787(var11);
                        }
                    }
                }
                break;
            }
        }
        if (var4 && var5 != 0L) {
            var1.referenceCompilationUnit().method_776(var5, this, var2, var3);
        }
    }

    public TypeBinding resolveType(BlockScope var1) {
        if (this.compilerAnnotation != null) {
            return this.resolvedType;
        } else {
            this.constant = Constant.NotAConstant;
            TypeBinding var2 = this.type.resolveType(var1);
            if (var2 == null) {
                return null;
            } else {
                this.resolvedType = var2;
                if (!var2.method_145() && var2.isValidBinding()) {
                    var1.problemReporter().typeMismatchError(var2, var1.method_604(), this.type, (ASTNode)null);
                    return null;
                } else {
                    ReferenceBinding var3 = (ReferenceBinding)this.resolvedType;
                    MethodBinding[] var4 = var3.methods();
                    MemberValuePair[] var5 = this.memberValuePairs();
                    MemberValuePair var6 = null;
                    int var8 = var5.length;
                    MemberValuePair[] var7;
                    if (var8 > 0) {
                        System.arraycopy(var5, 0, var7 = new MemberValuePair[var8], 0, var8);
                    } else {
                        var7 = var5;
                    }
                    int var9 = 0;
                    int var10 = var4.length;
                    while (var9 < var10) {
                        MethodBinding var11 = var4[var9];
                        char[] var12 = var11.selector;
                        boolean var13 = false;
                        int var14 = 0;
                        while (true) {
                            if (var14 < var8) {
                                label152: {
                                    MemberValuePair var15 = var7[var14];
                                    if (var15 != null) {
                                        char[] var16 = var15.name;
                                        if (CharOperation.method_1364(var16, var12)) {
                                            if (var6 == null && CharOperation.method_1364(var16, TypeConstants.field_70)) {
                                                var6 = var15;
                                            }
                                            var15.binding = var11;
                                            var15.resolveTypeExpecting(var1, var11.returnType);
                                            var7[var14] = null;
                                            var13 = true;
                                            boolean var17 = false;
                                            for (int var18 = var14 + 1; var18 < var8; ++var18) {
                                                MemberValuePair var19 = var7[var18];
                                                if (var19 != null && CharOperation.method_1364(var19.name, var12)) {
                                                    var17 = true;
                                                    var1.problemReporter().method_1519(var3, var19);
                                                    var19.binding = var11;
                                                    var19.resolveTypeExpecting(var1, var11.returnType);
                                                    var7[var18] = null;
                                                }
                                            }
                                            if (var17) {
                                                var1.problemReporter().method_1519(var3, var15);
                                                break label152;
                                            }
                                        }
                                    }
                                    ++var14;
                                    continue;
                                }
                            } else if (!var13 && (var11.modifiers & 131072) == 0 && (this.field_446 & 32) == 0) {
                                var1.problemReporter().missingValueForAnnotationMember(this, var12);
                            }
                            ++var9;
                            break;
                        }
                    }
                    for (var9 = 0; var9 < var8; ++var9) {
                        if (var7[var9] != null) {
                            var1.problemReporter().method_1780(var3, var7[var9]);
                            var7[var9].resolveTypeExpecting(var1, (TypeBinding)null);
                        }
                    }
                    this.compilerAnnotation = var1.environment().createAnnotation((ReferenceBinding)this.resolvedType, this.computeElementValuePairs());
                    long var21 = this.detectStandardAnnotation(var1, var3, var6);
                    var1.referenceCompilationUnit().method_776(256L, (Annotation)null, this.field_444, this.declarationSourceEnd);
                    if (this.recipient != null) {
                        if (var21 != 0L) {
                            SourceTypeBinding var20;
                            switch (this.recipient.kind()) {
                                case 1:
                                    FieldBinding var27 = (FieldBinding)this.recipient;
                                    var27.tagBits |= var21;
                                    if ((var21 & 1125899906842624L) != 0L) {
                                        var20 = (SourceTypeBinding)var27.declaringClass;
                                        FieldDeclaration var28 = var20.scope.referenceContext.declarationOf(var27);
                                        this.recordSuppressWarnings(var1, var28.field_653, var28.field_652, var1.compilerOptions().field_1959);
                                    }
                                    break;
                                case 2:
                                    LocalVariableBinding var30 = (LocalVariableBinding)this.recipient;
                                    var30.tagBits |= var21;
                                    if ((var21 & 1125899906842624L) != 0L) {
                                        LocalDeclaration var29 = var30.declaration;
                                        this.recordSuppressWarnings(var1, var29.field_653, var29.field_652, var1.compilerOptions().field_1959);
                                    }
                                    break;
                                case 4:
                                case 2052:
                                    var20 = (SourceTypeBinding)this.recipient;
                                    var20.tagBits |= var21;
                                    if ((var21 & 1125899906842624L) != 0L) {
                                        TypeDeclaration var24 = var20.scope.referenceContext;
                                        int var26;
                                        if (var1.referenceCompilationUnit().types[0] == var24) {
                                            var26 = 0;
                                        } else {
                                            var26 = var24.field_592;
                                        }
                                        this.recordSuppressWarnings(var1, var26, var24.field_593, var1.compilerOptions().field_1959);
                                    }
                                    break;
                                case 8:
                                    MethodBinding var22 = (MethodBinding)this.recipient;
                                    var22.tagBits |= var21;
                                    if ((var21 & 1125899906842624L) != 0L) {
                                        var20 = (SourceTypeBinding)var22.declaringClass;
                                        AbstractMethodDeclaration var25 = var20.scope.referenceContext.declarationOf(var22);
                                        this.recordSuppressWarnings(var1, var25.field_480, var25.field_481, var1.compilerOptions().field_1959);
                                    }
                                    break;
                                case 16:
                                    ((PackageBinding)this.recipient).tagBits |= var21;
                            }
                        }
                        long var23 = var3.getAnnotationTagBits();
                        if ((var23 & 17557826306048L) != 0L) {
                            switch (this.recipient.kind()) {
                                case 1:
                                    if ((var23 & 137438953472L) != 0L) {
                                        return this.resolvedType;
                                    }
                                    break;
                                case 2:
                                    if ((((LocalVariableBinding)this.recipient).tagBits & 1024L) != 0L) {
                                        if ((var23 & 549755813888L) != 0L) {
                                            return this.resolvedType;
                                        }
                                    } else if ((var3.tagBits & 2199023255552L) != 0L) {
                                        return this.resolvedType;
                                    }
                                    break;
                                case 4:
                                case 2052:
                                    if (((ReferenceBinding)this.recipient).method_145()) {
                                        if ((var23 & 4466765987840L) != 0L) {
                                            return this.resolvedType;
                                        }
                                    } else if ((var23 & 68719476736L) != 0L) {
                                        return this.resolvedType;
                                    }
                                    break;
                                case 8:
                                    if (((MethodBinding)this.recipient).method_358()) {
                                        if ((var23 & 1099511627776L) != 0L) {
                                            return this.resolvedType;
                                        }
                                    } else if ((var23 & 274877906944L) != 0L) {
                                        return this.resolvedType;
                                    }
                                    break;
                                case 16:
                                    if ((var23 & 8796093022208L) != 0L) {
                                        return this.resolvedType;
                                    }
                            }
                            var1.problemReporter().method_1517(this);
                        }
                    }
                    return this.resolvedType;
                }
            }
        }
    }

    public abstract void traverse(ASTVisitor var1, BlockScope var2);

    static {
        NoValuePairs = new MemberValuePair[0];
    }
}
