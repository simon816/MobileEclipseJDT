package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.OperatorExpression;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.NameReference;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.ast.CastExpression$1;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.InvocationSite;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ArrayBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.ParameterizedTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.ParameterizedGenericMethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class CastExpression extends Expression {

    public Expression field_684;

    public Expression field_685;

    public TypeBinding expectedType;

    public CastExpression(Expression var1, Expression var2) {
        this.field_684 = var1;
        this.field_685 = var2;
        var2.field_446 |= 1073741824;
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        return this.field_684.analyseCode(var1, var2, var3).method_3109();
    }

    public static void checkNeedForAssignedCast(BlockScope var0, TypeBinding var1, CastExpression var2) {
        if (var0.compilerOptions().method_3313(67108864L) != -1) {
            TypeBinding var3 = var2.field_684.resolvedType;
            if (var3 != null && !var2.resolvedType.method_148()) {
                if (var3.isCompatibleWith(var1)) {
                    var0.problemReporter().unnecessaryCast(var2);
                }
            }
        }
    }

    public static void checkNeedForCastCast(BlockScope var0, CastExpression var1) {
        if (var0.compilerOptions().method_3313(67108864L) != -1) {
            CastExpression var2 = (CastExpression)var1.field_684;
            if ((var2.field_446 & 16384) != 0) {
                CastExpression var10000 = new CastExpression((Expression)null, var1.field_685);
                CastExpression var3 = var10000;
                var3.resolvedType = var1.resolvedType;
                if (var3.checkCastTypesCompatibility(var0, var1.resolvedType, var2.field_684.resolvedType, var2.field_684)) {
                    var0.problemReporter().unnecessaryCast(var2);
                }
            }
        }
    }

    public static void checkNeedForEnclosingInstanceCast(BlockScope var0, Expression var1, TypeBinding var2, TypeBinding var3) {
        if (var0.compilerOptions().method_3313(67108864L) != -1) {
            TypeBinding var4 = ((CastExpression)var1).field_684.resolvedType;
            if (var4 != null) {
                if (var4 == var2) {
                    var0.problemReporter().unnecessaryCast((CastExpression)var1);
                } else {
                    if (var4 == TypeBinding.field_187) {
                        return;
                    }
                    if (var4.method_148() || var4.method_147()) {
                        return;
                    }
                    if (var3 == var0.getMemberType(var3.method_179(), (ReferenceBinding)var4)) {
                        var0.problemReporter().unnecessaryCast((CastExpression)var1);
                    }
                }
            }
        }
    }

    public static void checkNeedForArgumentCast(BlockScope var0, int var1, int var2, Expression var3, int var4) {
        if (var0.compilerOptions().method_3313(67108864L) != -1) {
            if ((var3.field_446 & 16384) != 0 || !var3.resolvedType.method_148()) {
                TypeBinding var6 = ((CastExpression)var3).field_684.resolvedType;
                if (var6 != null) {
                    int var5 = var6.id;
                    if (var6.id == var4) {
                        var0.problemReporter().unnecessaryCast((CastExpression)var3);
                    } else if (var5 != 12) {
                        ;
                    }
                }
            }
        }
    }

    public static void checkNeedForArgumentCasts(BlockScope var0, Expression var1, TypeBinding var2, MethodBinding var3, Expression[] var4, TypeBinding[] var5, InvocationSite var6) {
        if (var0.compilerOptions().method_3313(67108864L) != -1) {
            int var7 = var5.length;
            TypeBinding[] var8 = var5;
            for (int var9 = 0; var9 < var7; ++var9) {
                Expression var10 = var4[var9];
                if (var10 instanceof CastExpression && ((var10.field_446 & 16384) != 0 || !var10.resolvedType.method_148())) {
                    TypeBinding var11 = ((CastExpression)var10).field_684.resolvedType;
                    if (var11 == null) {
                        return;
                    }
                    if (var11 == var5[var9]) {
                        var0.problemReporter().unnecessaryCast((CastExpression)var10);
                    } else if (var11 != TypeBinding.field_187 && (var10.field_674 & 512) == 0) {
                        if (var8 == var5) {
                            System.arraycopy(var8, 0, var8 = new TypeBinding[var7], 0, var7);
                        }
                        var8[var9] = var11;
                    }
                }
            }
            if (var8 != var5) {
                method_939(var0, var1, var2, var3, var4, var5, var8, var6);
            }
        }
    }

    public static void checkNeedForArgumentCasts(BlockScope var0, int var1, int var2, Expression var3, int var4, boolean var5, Expression var6, int var7, boolean var8) {
        if (var0.compilerOptions().method_3313(67108864L) != -1) {
            int var9 = var4;
            if (var5) {
                if ((var3.field_446 & 16384) == 0 && var3.resolvedType.method_148()) {
                    var5 = false;
                } else {
                    TypeBinding var10 = ((CastExpression)var3).field_684.resolvedType;
                    if (var10 == null) {
                        return;
                    }
                    var9 = var10.id;
                    if (var10.id == var4) {
                        var0.problemReporter().unnecessaryCast((CastExpression)var3);
                        var5 = false;
                    } else if (var9 == 12) {
                        var9 = var4;
                        var5 = false;
                    }
                }
            }
            int var13 = var7;
            if (var8) {
                if ((var6.field_446 & 16384) == 0 && var6.resolvedType.method_148()) {
                    var8 = false;
                } else {
                    TypeBinding var11 = ((CastExpression)var6).field_684.resolvedType;
                    if (var11 == null) {
                        return;
                    }
                    var13 = var11.id;
                    if (var11.id == var7) {
                        var0.problemReporter().unnecessaryCast((CastExpression)var6);
                        var8 = false;
                    } else if (var13 == 12) {
                        var13 = var7;
                        var8 = false;
                    }
                }
            }
            if (var5 || var8) {
                if (var9 > 15 || var13 > 15) {
                    if (var9 == 11) {
                        var13 = 1;
                    } else {
                        if (var13 != 11) {
                            return;
                        }
                        var9 = 1;
                    }
                }
                int var12 = OperatorExpression.OperatorSignatures[var1][(var9 << 4) + var13];
                if ((var2 & 986895) == (var12 & 986895)) {
                    if (var5) {
                        var0.problemReporter().unnecessaryCast((CastExpression)var3);
                    }
                    if (var8) {
                        var0.problemReporter().unnecessaryCast((CastExpression)var6);
                    }
                }
            }
        }
    }

    private static void method_939(BlockScope var0, Expression var1, TypeBinding var2, MethodBinding var3, Expression[] var4, TypeBinding[] var5, TypeBinding[] var6, InvocationSite var7) {
        CastExpression$1 var10000 = new CastExpression$1(var7);
        CastExpression$1 var8 = var10000;
        MethodBinding var9;
        if (var3.method_358()) {
            var9 = var0.method_599((ReferenceBinding)var2, var6, var8);
        } else {
            if (var1.method_752()) {
                var9 = var0.getImplicitMethod(var3.selector, var6, var8);
            } else {
                try {
                    var9 = var0.method_614(var2, var3.selector, var6, var8);
                } catch (Throwable e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
        if (var9 == var3) {
            int var10 = var5.length;
            int var11;
            if (var3.method_374()) {
                var11 = var3.parameters.length;
                if (var11 == var10) {
                    int var12 = var11 - 1;
                    ArrayBinding var13 = (ArrayBinding)var3.parameters[var12];
                    TypeBinding var14 = var6[var12];
                    if (var13.dimensions != var14.method_136()) {
                        return;
                    }
                    if (var14.isCompatibleWith(var13.method_187()) && var14.isCompatibleWith(var13)) {
                        return;
                    }
                }
            }
            for (var11 = 0; var11 < var10; ++var11) {
                if (var5[var11] != var6[var11]) {
                    var0.problemReporter().unnecessaryCast((CastExpression)var4[var11]);
                }
            }
        }
    }

    public boolean checkUnsafeCast(Scope var1, TypeBinding var2, TypeBinding var3, TypeBinding var4, boolean var5) {
        if (var4 == var2) {
            if (!var5 && var4 == this.resolvedType.method_173()) {
                this.tagAsUnnecessaryCast(var1, var2);
            }
            return true;
        } else {
            if (var4 != null) {
                label97: {
                    if (var5) {
                        if (!var4.method_164(var3)) {
                            break label97;
                        }
                    } else if (!var2.method_164(var4)) {
                        break label97;
                    }
                    return false;
                }
            }
            switch (var2.kind()) {
                case 68:
                    TypeBinding var14 = var2.method_173();
                    if (var5 && (var14.method_149() || var14.method_169())) {
                        this.field_446 |= 128;
                        return true;
                    }
                    break;
                case 260:
                    if (var2.method_149()) {
                        if (var4 == null) {
                            this.field_446 |= 128;
                            return true;
                        }
                        switch (var4.kind()) {
                            case 260:
                                if (var5) {
                                    if (!var3.method_166() && var3.isEquivalentTo(var4)) {
                                        ParameterizedTypeBinding var6 = (ParameterizedTypeBinding)var2;
                                        ParameterizedTypeBinding var7 = (ParameterizedTypeBinding)var4;
                                        TypeBinding[] var8 = var6.arguments;
                                        int var9 = var8.length;
                                        if (var7.arguments != null && var9 <= var7.arguments.length) {
                                            if ((var6.tagBits & 1610612736L) != 0L) {
                                                int var10 = 0;
                                                while (var10 < var9) {
                                                    switch (var8[var10].kind()) {
                                                        case 516:
                                                        case 4100:
                                                            TypeBinding[] var11;
                                                            System.arraycopy(var6.arguments, 0, var11 = new TypeBinding[var9], 0, var9);
                                                            var11[var10] = var1.method_609();
                                                            LookupEnvironment var12 = var1.environment();
                                                            ParameterizedTypeBinding var13 = var12.createParameterizedType((ReferenceBinding)var2.erasure(), var11, var2.enclosingType());
                                                            if (var13.method_140(var3) == var4) {
                                                                this.field_446 |= 128;
                                                                return true;
                                                            }
                                                        default:
                                                            ++var10;
                                                    }
                                                }
                                            }
                                        } else {
                                            this.field_446 |= 128;
                                        }
                                        return true;
                                    }
                                    this.field_446 |= 128;
                                    return true;
                                }
                                if (!var4.isEquivalentTo(var2)) {
                                    this.field_446 |= 128;
                                    return true;
                                }
                                break;
                            case 1028:
                                this.field_446 |= 128;
                                return true;
                            default:
                                if (var5) {
                                    this.field_446 |= 128;
                                    return true;
                                }
                        }
                    }
                    break;
                case 4100:
                    this.field_446 |= 128;
                    return true;
            }
            if (!var5 && var4 == this.resolvedType.method_173()) {
                this.tagAsUnnecessaryCast(var1, var2);
            }
            return true;
        }
    }

    public void generateCode(BlockScope var1, CodeStream var2, boolean var3) {
        int var4 = var2.field_1208;
        boolean var5 = (this.field_446 & 64) != 0;
        if (this.constant != Constant.NotAConstant) {
            if (var3 || var5) {
                var2.generateConstant(this.constant, this.field_674);
                if (var5) {
                    var2.method_2113(this.resolvedType);
                }
                if (!var3) {
                    var2.method_2352();
                }
            }
            var2.method_2360(var4, this.field_444);
        } else {
            this.field_684.generateCode(var1, var2, var3 || var5);
            if (var5 && this.field_684.postConversionType(var1) != this.resolvedType.erasure()) {
                var2.method_2113(this.resolvedType);
            }
            if (var3) {
                var2.method_2182(this.field_674);
            } else if (var5) {
                var2.method_2352();
            }
            var2.method_2360(var4, this.field_444);
        }
    }

    public Expression innermostCastedExpression() {
        Expression var1;
        for (var1 = this.field_684; var1 instanceof CastExpression; var1 = ((CastExpression)var1).field_684) {
            ;
        }
        return var1;
    }

    public LocalVariableBinding localVariableBinding() {
        return this.field_684.localVariableBinding();
    }

    public int nullStatus(FlowInfo var1) {
        return this.field_684.nullStatus(var1);
    }

    public Constant optimizedBooleanConstant() {
        switch (this.resolvedType.id) {
            case 5:
            case 33:
                return this.field_684.optimizedBooleanConstant();
            default:
                return Constant.NotAConstant;
        }
    }

    public StringBuffer printExpression(int var1, StringBuffer var2) {
        var2.append('(');
        this.field_685.print(0, var2).append(") ");
        return this.field_684.printExpression(0, var2);
    }

    public TypeBinding resolveType(BlockScope var1) {
        this.constant = Constant.NotAConstant;
        this.field_674 = 0;
        if (!(this.field_685 instanceof TypeReference) && (!(this.field_685 instanceof NameReference) || (this.field_685.field_446 & 534773760) >> 21 != 0)) {
            TypeBinding var6 = this.field_684.resolveType(var1);
            if (var6 == null) {
                return null;
            } else {
                var1.problemReporter().method_1641(this.field_685);
                return null;
            }
        } else {
            boolean var2 = false;
            TypeBinding var3 = this.resolvedType = this.field_685.resolveType(var1);
            if (this.field_684 instanceof CastExpression) {
                this.field_684.field_446 |= 32;
                var2 = true;
            }
            TypeBinding var4 = this.field_684.resolveType(var1);
            if (var3 != null) {
                if (var4 != null) {
                    boolean var5 = this.checkCastTypesCompatibility(var1, var3, var4, this.field_684);
                    if (var5) {
                        this.field_684.computeConversion(var1, var3, var4);
                        if ((this.field_446 & 128) != 0) {
                            var1.problemReporter().unsafeCast(this, var1);
                        } else {
                            if (var3.method_166() && var1.compilerOptions().method_3313(35184372088832L) != -1) {
                                var1.problemReporter().method_1742(this.field_685, var3);
                            }
                            if ((this.field_446 & 16416) == 16384 && !this.isIndirectlyUsed()) {
                                var1.problemReporter().unnecessaryCast(this);
                            }
                        }
                    } else {
                        if ((var3.tagBits & 128L) == 0L) {
                            var1.problemReporter().typeCastError(this, var3, var4);
                        }
                        this.field_446 |= 32;
                    }
                }
                this.resolvedType = var3.capture(var1, this.field_445);
                if (var2) {
                    checkNeedForCastCast(var1, this);
                }
            }
            return this.resolvedType;
        }
    }

    public void setExpectedType(TypeBinding var1) {
        this.expectedType = var1;
    }

    private boolean isIndirectlyUsed() {
        if (this.field_684 instanceof MessageSend) {
            MethodBinding var1 = ((MessageSend)this.field_684).field_775;
            if (var1 instanceof ParameterizedGenericMethodBinding && ((ParameterizedGenericMethodBinding)var1).field_295) {
                if (this.expectedType == null) {
                    return true;
                }
                if (this.resolvedType != this.expectedType) {
                    return true;
                }
            }
        }
        return this.expectedType != null && this.resolvedType.method_148() && !this.resolvedType.isCompatibleWith(this.expectedType);
    }

    public void tagAsNeedCheckCast() {
        this.field_446 |= 64;
    }

    public void tagAsUnnecessaryCast(Scope var1, TypeBinding var2) {
        this.field_446 |= 16384;
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            this.field_685.traverse(var1, var2);
            this.field_684.traverse(var1, var2);
        }
        var1.endVisit(this, var2);
    }
}
