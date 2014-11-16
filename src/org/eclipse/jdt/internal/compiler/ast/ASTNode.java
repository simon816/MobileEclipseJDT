package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.CastExpression;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.env.AccessRestriction;
import org.eclipse.jdt.internal.compiler.lookup.InvocationSite;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.AnnotationBinding;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.PackageBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ArrayBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.WildcardBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.ParameterizedGenericMethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public abstract class ASTNode implements TypeConstants {

    public int field_444;

    public int field_445;

    public int field_446;

    public ASTNode() {
        this.field_446 = Integer.MIN_VALUE;
    }

    private static int checkInvocationArgument(BlockScope var0, Expression var1, TypeBinding var2, TypeBinding var3, TypeBinding var4) {
        var1.computeConversion(var0, var2, var3);
        if (var3 != TypeBinding.field_187 && var2.kind() == 516) {
            WildcardBinding var5 = (WildcardBinding)var2;
            if (var5.field_215 != 2) {
                return 2;
            }
        }
        TypeBinding var6 = var4 == null ? var2 : var4;
        if (var3 != var6 && var3.method_174(var6)) {
            var0.problemReporter().method_1806(var1, var3, var6);
            return 1;
        } else {
            return 0;
        }
    }

    public static void method_749(BlockScope var0, Expression var1, TypeBinding var2, MethodBinding var3, Expression[] var4, TypeBinding[] var5, boolean var6, InvocationSite var7) {
        TypeBinding[] var8 = var3.parameters;
        int var9 = var8.length;
        boolean var10 = !var3.method_370() && !var2.method_170() && var3.declaringClass.method_166() && var3.method_354();
        MethodBinding var11 = null;
        if (!var10 && var3 instanceof ParameterizedGenericMethodBinding) {
            ParameterizedGenericMethodBinding var12 = (ParameterizedGenericMethodBinding)var3;
            if (var12.field_299 || var12.field_297 && var3.method_354()) {
                var11 = var3.original();
            }
        }
        int var19 = 0;
        if (var4 == null) {
            if (var3.method_374()) {
                TypeBinding var13 = ((ArrayBinding)var8[var9 - 1]).method_187();
                if (!var13.method_167()) {
                    var0.problemReporter().method_1801(var13, (ASTNode)var7);
                }
            }
        } else {
            int var20;
            if (var3.method_374()) {
                var20 = var9 - 1;
                int var14;
                TypeBinding var15;
                for (var14 = 0; var14 < var20; ++var14) {
                    var15 = var11 == null ? null : var11.parameters[var14];
                    var19 |= checkInvocationArgument(var0, var4[var14], var8[var14], var5[var14], var15);
                }
                var14 = var4.length;
                if (var20 < var14) {
                    var15 = var8[var20];
                    TypeBinding var16 = null;
                    if (var9 != var14 || var15.method_136() != var5[var20].method_136()) {
                        var15 = ((ArrayBinding)var15).method_187();
                        if (!var15.method_167()) {
                            var0.problemReporter().method_1801(var15, (ASTNode)var7);
                        }
                        var16 = var11 == null ? null : ((ArrayBinding)var11.parameters[var20]).method_187();
                    }
                    for (int var17 = var20; var17 < var14; ++var17) {
                        var19 |= checkInvocationArgument(var0, var4[var17], var15, var5[var17], var16);
                    }
                }
                if (var9 == var5.length) {
                    int var22 = var9 - 1;
                    ArrayBinding var24 = (ArrayBinding)var8[var22];
                    TypeBinding var23 = var5[var22];
                    if (var23 == TypeBinding.field_187) {
                        if (!var24.method_173().method_148() || var24.method_136() != 1) {
                            var0.problemReporter().varargsArgumentNeedCast(var3, var23, var7);
                        }
                    } else {
                        int var18;
                        if (var24.dimensions <= (var18 = var23.method_136())) {
                            if (var23.method_173().method_148()) {
                                --var18;
                            }
                            if (var24.dimensions < var18) {
                                var0.problemReporter().varargsArgumentNeedCast(var3, var23, var7);
                            } else if (var24.dimensions == var18 && var23 != var24 && var23.method_173().erasure() != var24.leafComponentType.erasure() && var23.isCompatibleWith(var24.method_187()) && var23.isCompatibleWith(var24)) {
                                var0.problemReporter().varargsArgumentNeedCast(var3, var23, var7);
                            }
                        }
                    }
                }
            } else {
                for (var20 = 0; var20 < var9; ++var20) {
                    TypeBinding var21 = var11 == null ? null : var11.parameters[var20];
                    var19 |= checkInvocationArgument(var0, var4[var20], var8[var20], var5[var20], var21);
                }
            }
            if (var6) {
                CastExpression.checkNeedForArgumentCasts(var0, var1, var2, var3, var4, var5, var7);
            }
        }
        if ((var19 & 2) != 0) {
            var0.problemReporter().wildcardInvocation((ASTNode)var7, var2, var3, var5);
        } else if (!var3.method_370() && !var2.method_170() && var3.declaringClass.method_166() && var3.method_354()) {
            var0.problemReporter().method_1804((ASTNode)var7, var3);
        } else if (var11 != null) {
            var0.problemReporter().method_1803((ASTNode)var7, var3);
        }
    }

    public ASTNode concreteStatement() {
        return this;
    }

    public final boolean isFieldUseDeprecated(FieldBinding var1, Scope var2, boolean var3) {
        if ((this.field_446 & '\u8000') == 0 && !var3 && (var1.method_428() || var1.declaringClass != null && var1.declaringClass.method_158()) && !var2.isDefinedInField(var1)) {
            FieldBinding var10000 = var1.original();
            var10000.field_300 |= 134217728;
        }
        if ((var1.field_300 & 262144) != 0) {
            AccessRestriction var4 = var2.environment().getAccessRestriction(var1.declaringClass.erasure());
            if (var4 != null) {
                var2.problemReporter().forbiddenReference(var1, this, var4.classpathEntryType, var4.classpathEntryName, var4.getProblemId());
            }
        }
        return !var1.method_434() ? false : (var2.method_627(var1.declaringClass) ? false : var2.compilerOptions().field_1939 || !var2.isInsideDeprecatedCode());
    }

    public boolean method_752() {
        return false;
    }

    public final boolean isMethodUseDeprecated(MethodBinding var1, Scope var2, boolean var3) {
        if ((this.field_446 & '\u8000') == 0 && (var1.method_367() || var1.declaringClass.method_158()) && !var2.isDefinedInMethod(var1)) {
            MethodBinding var10000 = var1.original();
            var10000.modifiers |= 134217728;
        }
        if (var3 && (var1.modifiers & 262144) != 0) {
            AccessRestriction var4 = var2.environment().getAccessRestriction(var1.declaringClass.erasure());
            if (var4 != null) {
                var2.problemReporter().forbiddenReference(var1, this, var4.classpathEntryType, var4.classpathEntryName, var4.getProblemId());
            }
        }
        return !var1.method_375() ? false : (var2.method_627(var1.declaringClass) ? false : (!var3 && (var1.modifiers & 1048576) == 0 ? false : var2.compilerOptions().field_1939 || !var2.isInsideDeprecatedCode()));
    }

    public boolean method_754() {
        return false;
    }

    public boolean method_755() {
        return false;
    }

    public final boolean isTypeUseDeprecated(TypeBinding var1, Scope var2) {
        if (var1.method_147()) {
            var1 = ((ArrayBinding)var1).leafComponentType;
        }
        if (var1.method_148()) {
            return false;
        } else {
            ReferenceBinding var3 = (ReferenceBinding)var1;
            if ((this.field_446 & '\u8000') == 0 && (var3.method_223() || var3.method_158()) && !var2.method_628(var3)) {
                ReferenceBinding var10000 = (ReferenceBinding)var3.erasure();
                var10000.modifiers |= 134217728;
            }
            if (var3.method_214()) {
                AccessRestriction var4 = var2.environment().getAccessRestriction(var1.erasure());
                if (var4 != null) {
                    var2.problemReporter().forbiddenReference(var1, this, var4.classpathEntryType, var4.classpathEntryName, var4.getProblemId());
                }
            }
            var3.initializeDeprecatedAnnotationTagBits();
            return !var3.method_230() ? false : (var2.method_627(var3) ? false : var2.compilerOptions().field_1939 || !var2.isInsideDeprecatedCode());
        }
    }

    public abstract StringBuffer print(int var1, StringBuffer var2);

    public static StringBuffer printAnnotations(Annotation[] var0, StringBuffer var1) {
        int var2 = var0.length;
        for (int var3 = 0; var3 < var2; ++var3) {
            var0[var3].print(0, var1);
            var1.append(" ");
        }
        return var1;
    }

    public static StringBuffer method_759(int var0, StringBuffer var1) {
        for (int var2 = var0; var2 > 0; --var2) {
            var1.append("  ");
        }
        return var1;
    }

    public static StringBuffer method_760(int var0, StringBuffer var1) {
        if ((var0 & 1) != 0) {
            var1.append("public ");
        }
        if ((var0 & 2) != 0) {
            var1.append("private ");
        }
        if ((var0 & 4) != 0) {
            var1.append("protected ");
        }
        if ((var0 & 8) != 0) {
            var1.append("static ");
        }
        if ((var0 & 16) != 0) {
            var1.append("final ");
        }
        if ((var0 & 32) != 0) {
            var1.append("synchronized ");
        }
        if ((var0 & 64) != 0) {
            var1.append("volatile ");
        }
        if ((var0 & 128) != 0) {
            var1.append("transient ");
        }
        if ((var0 & 256) != 0) {
            var1.append("native ");
        }
        if ((var0 & 1024) != 0) {
            var1.append("abstract ");
        }
        return var1;
    }

    public static void method_761(BlockScope var0, Annotation[] var1, Binding var2) {
        AnnotationBinding[] var3 = null;
        int var4 = var1 == null ? 0 : var1.length;
        FieldBinding var8;
        LocalVariableBinding var9;
        if (var2 != null) {
            switch (var2.kind()) {
                case 1:
                    var8 = (FieldBinding)var2;
                    if ((var8.tagBits & 8589934592L) != 0L) {
                        return;
                    }
                    var8.tagBits |= 25769803776L;
                    if (var4 > 0) {
                        var3 = new AnnotationBinding[var4];
                        var8.setAnnotations(var3);
                    }
                    break;
                case 2:
                    var9 = (LocalVariableBinding)var2;
                    if ((var9.tagBits & 8589934592L) != 0L) {
                        return;
                    }
                    var9.tagBits |= 25769803776L;
                    if (var4 > 0) {
                        var3 = new AnnotationBinding[var4];
                        var9.setAnnotations(var3);
                    }
                    break;
                case 4:
                case 2052:
                    ReferenceBinding var6 = (ReferenceBinding)var2;
                    if ((var6.tagBits & 8589934592L) != 0L) {
                        return;
                    }
                    var6.tagBits |= 25769803776L;
                    if (var4 > 0) {
                        var3 = new AnnotationBinding[var4];
                        var6.setAnnotations(var3);
                    }
                    break;
                case 8:
                    MethodBinding var7 = (MethodBinding)var2;
                    if ((var7.tagBits & 8589934592L) != 0L) {
                        return;
                    }
                    var7.tagBits |= 25769803776L;
                    if (var4 > 0) {
                        var3 = new AnnotationBinding[var4];
                        var7.setAnnotations(var3);
                    }
                    break;
                case 16:
                    PackageBinding var5 = (PackageBinding)var2;
                    if ((var5.tagBits & 8589934592L) != 0L) {
                        return;
                    }
                    var5.tagBits |= 25769803776L;
                    break;
                default:
                    return;
            }
        }
        if (var1 != null) {
            for (int var12 = 0; var12 < var4; ++var12) {
                Annotation var15 = var1[var12];
                Binding var16 = var15.recipient;
                if (var16 != null && var2 != null) {
                    switch (var2.kind()) {
                        case 1:
                            var8 = (FieldBinding)var2;
                            var8.tagBits = ((FieldBinding)var16).tagBits;
                            break;
                        case 2:
                            var9 = (LocalVariableBinding)var2;
                            var9.tagBits = ((LocalVariableBinding)var16).tagBits;
                    }
                    if (var3 != null) {
                        var3[0] = var15.getCompilerAnnotation();
                        for (int var18 = 1; var18 < var4; ++var18) {
                            Annotation var21 = var1[var18];
                            var3[var18] = var21.getCompilerAnnotation();
                        }
                    }
                    return;
                }
                var15.recipient = var2;
                var15.resolveType(var0);
                if (var3 != null) {
                    var3[var12] = var15.getCompilerAnnotation();
                }
            }
            if (var3 != null) {
                AnnotationBinding[] var13 = var3;
                for (int var14 = 0; var14 < var4; ++var14) {
                    AnnotationBinding var17 = var13[var14];
                    if (var17 != null) {
                        ReferenceBinding var19 = var17.getAnnotationType();
                        boolean var20 = false;
                        for (int var10 = var14 + 1; var10 < var4; ++var10) {
                            AnnotationBinding var11 = var13[var10];
                            if (var11 != null && var11.getAnnotationType() == var19) {
                                var20 = true;
                                if (var13 == var3) {
                                    System.arraycopy(var13, 0, var13 = new AnnotationBinding[var4], 0, var4);
                                }
                                var13[var10] = null;
                                var0.problemReporter().method_1518(var1[var10]);
                            }
                        }
                        if (var20) {
                            var0.problemReporter().method_1518(var1[var14]);
                        }
                    }
                }
            }
        }
    }

    public static void method_762(BlockScope var0, Annotation[] var1, Binding var2) {
        if (var2 != null) {
            int var3 = var2.kind();
            int var4;
            if (var1 != null && (var4 = var1.length) >= 0) {
                switch (var3) {
                    case 1:
                        FieldBinding var8 = (FieldBinding)var2;
                        if ((var8.tagBits & 17179869184L) != 0L) {
                            return;
                        }
                        break;
                    case 2:
                        LocalVariableBinding var9 = (LocalVariableBinding)var2;
                        if ((var9.tagBits & 17179869184L) != 0L) {
                            return;
                        }
                        break;
                    case 4:
                    case 2052:
                        ReferenceBinding var6 = (ReferenceBinding)var2;
                        if ((var6.tagBits & 17179869184L) != 0L) {
                            return;
                        }
                        break;
                    case 8:
                        MethodBinding var7 = (MethodBinding)var2;
                        if ((var7.tagBits & 17179869184L) != 0L) {
                            return;
                        }
                        break;
                    case 16:
                        PackageBinding var5 = (PackageBinding)var2;
                        if ((var5.tagBits & 17179869184L) != 0L) {
                            return;
                        }
                        break;
                    default:
                        return;
                }
                for (int var14 = 0; var14 < var4; ++var14) {
                    TypeReference var17 = var1[var14].type;
                    if (!CharOperation.method_1364(TypeConstants.field_119[2], var17.getLastToken())) {
                        return;
                    }
                    TypeBinding var18 = var1[var14].type.resolveType(var0);
                    if (var18 != null && var18.isValidBinding() && var18.id == 44) {
                        switch (var3) {
                            case 1:
                                FieldBinding var11 = (FieldBinding)var2;
                                var11.tagBits |= 70385924046848L;
                                return;
                            case 2:
                                LocalVariableBinding var12 = (LocalVariableBinding)var2;
                                var12.tagBits |= 70385924046848L;
                                return;
                            case 4:
                            case 2052:
                            case 4100:
                                ReferenceBinding var22 = (ReferenceBinding)var2;
                                var22.tagBits |= 70385924046848L;
                                return;
                            case 8:
                                MethodBinding var10 = (MethodBinding)var2;
                                var10.tagBits |= 70385924046848L;
                                return;
                            case 16:
                                PackageBinding var21 = (PackageBinding)var2;
                                var21.tagBits |= 70385924046848L;
                                return;
                            default:
                                return;
                        }
                    }
                }
            }
            switch (var3) {
                case 1:
                    FieldBinding var19 = (FieldBinding)var2;
                    var19.tagBits |= 17179869184L;
                    return;
                case 2:
                    LocalVariableBinding var20 = (LocalVariableBinding)var2;
                    var20.tagBits |= 17179869184L;
                    return;
                case 4:
                case 2052:
                case 4100:
                    ReferenceBinding var15 = (ReferenceBinding)var2;
                    var15.tagBits |= 17179869184L;
                    return;
                case 8:
                    MethodBinding var16 = (MethodBinding)var2;
                    var16.tagBits |= 17179869184L;
                    return;
                case 16:
                    PackageBinding var13 = (PackageBinding)var2;
                    var13.tagBits |= 17179869184L;
                    return;
                default:
            }
        }
    }

    public int method_5() {
        return this.field_444;
    }

    public int method_6() {
        return this.field_445;
    }

    public String toString() {
        return this.print(0, new StringBuffer(30)).toString();
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {}
}
