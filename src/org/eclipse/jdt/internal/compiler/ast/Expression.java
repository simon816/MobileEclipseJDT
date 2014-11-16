package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.codegen.BranchLabel;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.BaseTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ArrayBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.WildcardBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.problem.ShouldNotImplement;
import org.eclipse.jdt.internal.compiler.util.Messages;

import java.util.ArrayList;

public abstract class Expression extends Statement {

    public Constant constant;

    public int field_673;

    public int field_674;

    public TypeBinding resolvedType;

    public static final boolean isConstantValueRepresentable(Constant var0, int var1, int var2) {
        if (var2 == var1) {
            return true;
        } else {
            switch (var2) {
                case 2:
                    switch (var1) {
                        case 2:
                            return true;
                        case 3:
                            return var0.byteValue() == var0.charValue();
                        case 4:
                            return var0.shortValue() == var0.charValue();
                        case 5:
                        case 6:
                        default:
                            return false;
                        case 7:
                            return var0.longValue() == (long)var0.charValue();
                        case 8:
                            return var0.doubleValue() == (double)var0.charValue();
                        case 9:
                            return var0.floatValue() == (float)var0.charValue();
                        case 10:
                            return var0.intValue() == var0.charValue();
                    }
                case 3:
                    switch (var1) {
                        case 2:
                            return var0.charValue() == var0.byteValue();
                        case 3:
                            return true;
                        case 4:
                            return var0.shortValue() == var0.byteValue();
                        case 5:
                        case 6:
                        default:
                            return false;
                        case 7:
                            return var0.longValue() == (long)var0.byteValue();
                        case 8:
                            return var0.doubleValue() == (double)var0.byteValue();
                        case 9:
                            return var0.floatValue() == (float)var0.byteValue();
                        case 10:
                            return var0.intValue() == var0.byteValue();
                    }
                case 4:
                    switch (var1) {
                        case 2:
                            return var0.charValue() == var0.shortValue();
                        case 3:
                            return var0.byteValue() == var0.shortValue();
                        case 4:
                            return true;
                        case 5:
                        case 6:
                        default:
                            return false;
                        case 7:
                            return var0.longValue() == (long)var0.shortValue();
                        case 8:
                            return var0.doubleValue() == (double)var0.shortValue();
                        case 9:
                            return var0.floatValue() == (float)var0.shortValue();
                        case 10:
                            return var0.intValue() == var0.shortValue();
                    }
                case 5:
                case 6:
                default:
                    return false;
                case 7:
                    switch (var1) {
                        case 2:
                            return (long)var0.charValue() == var0.longValue();
                        case 3:
                            return (long)var0.byteValue() == var0.longValue();
                        case 4:
                            return (long)var0.shortValue() == var0.longValue();
                        case 5:
                        case 6:
                        default:
                            return false;
                        case 7:
                            return true;
                        case 8:
                            return var0.doubleValue() == (double)var0.longValue();
                        case 9:
                            return var0.floatValue() == (float)var0.longValue();
                        case 10:
                            return (long)var0.intValue() == var0.longValue();
                    }
                case 8:
                    switch (var1) {
                        case 2:
                            return (double)var0.charValue() == var0.doubleValue();
                        case 3:
                            return (double)var0.byteValue() == var0.doubleValue();
                        case 4:
                            return (double)var0.shortValue() == var0.doubleValue();
                        case 5:
                        case 6:
                        default:
                            return false;
                        case 7:
                            return (double)var0.longValue() == var0.doubleValue();
                        case 8:
                            return true;
                        case 9:
                            return (double)var0.floatValue() == var0.doubleValue();
                        case 10:
                            return (double)var0.intValue() == var0.doubleValue();
                    }
                case 9:
                    switch (var1) {
                        case 2:
                            return (float)var0.charValue() == var0.floatValue();
                        case 3:
                            return (float)var0.byteValue() == var0.floatValue();
                        case 4:
                            return (float)var0.shortValue() == var0.floatValue();
                        case 5:
                        case 6:
                        default:
                            return false;
                        case 7:
                            return (float)var0.longValue() == var0.floatValue();
                        case 8:
                            return var0.doubleValue() == (double)var0.floatValue();
                        case 9:
                            return true;
                        case 10:
                            return (float)var0.intValue() == var0.floatValue();
                    }
                case 10:
                    switch (var1) {
                        case 2:
                            return var0.charValue() == var0.intValue();
                        case 3:
                            return var0.byteValue() == var0.intValue();
                        case 4:
                            return var0.shortValue() == var0.intValue();
                        case 5:
                        case 6:
                        default:
                            return false;
                        case 7:
                            return var0.longValue() == (long)var0.intValue();
                        case 8:
                            return var0.doubleValue() == (double)var0.intValue();
                        case 9:
                            return var0.floatValue() == (float)var0.intValue();
                        case 10:
                            return true;
                    }
            }
        }
    }

    public Expression() {
        this.field_673 = -1;
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        return var3;
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3, boolean var4) {
        return this.analyseCode(var1, var2, var3);
    }

    public final boolean checkCastTypesCompatibility(Scope var1, TypeBinding var2, TypeBinding var3, Expression var4) {
        if (var2 != null && var3 != null) {
            boolean var5 = var1.compilerOptions().field_1928 >= 3211264L;
            if (var2.method_148()) {
                if (var3.method_148()) {
                    if (var3 == var2) {
                        if (var4 != null) {
                            this.constant = var4.constant;
                        }
                        this.tagAsUnnecessaryCast(var1, var2);
                        return true;
                    }
                    boolean var16 = false;
                    if (var3.isCompatibleWith(var2) || (var16 = BaseTypeBinding.method_184(var2.id, var3.id))) {
                        if (var4 != null) {
                            var4.field_674 = (var2.id << 4) + var3.id;
                            if (var4.constant != Constant.NotAConstant) {
                                this.constant = var4.constant.castTo(var4.field_674);
                            }
                        }
                        if (!var16) {
                            this.tagAsUnnecessaryCast(var1, var2);
                        }
                        return true;
                    }
                } else if (var5 && var1.environment().method_486(var3).isCompatibleWith(var2)) {
                    this.tagAsUnnecessaryCast(var1, var2);
                    return true;
                }
                return false;
            } else if (var5 && var3.method_148() && var1.environment().method_486(var3).isCompatibleWith(var2)) {
                this.tagAsUnnecessaryCast(var1, var2);
                return true;
            } else {
                TypeBinding var6;
                switch (var3.kind()) {
                    case 68:
                        if (var2 == var3) {
                            this.tagAsUnnecessaryCast(var1, var2);
                            return true;
                        } else {
                            switch (var2.kind()) {
                                case 68:
                                    var6 = ((ArrayBinding)var2).method_187();
                                    TypeBinding var7 = ((ArrayBinding)var3).method_187();
                                    if (!var7.method_148() && !var6.method_148()) {
                                        return this.checkCastTypesCompatibility(var1, var6, var7, var4);
                                    } else {
                                        if (var6 == var7) {
                                            this.tagAsNeedCheckCast();
                                            return true;
                                        }
                                        return false;
                                    }
                                case 4100:
                                    TypeBinding var8 = var3.method_140(var2);
                                    if (var8 == null) {
                                        this.checkUnsafeCast(var1, var2, var3, (TypeBinding)null, true);
                                    }
                                    return this.checkCastTypesCompatibility(var1, ((TypeVariableBinding)var2).method_261(), var3, var4);
                                default:
                                    switch (var2.id) {
                                        case 1:
                                            this.tagAsUnnecessaryCast(var1, var2);
                                            return true;
                                        case 36:
                                        case 37:
                                            this.tagAsNeedCheckCast();
                                            return true;
                                        default:
                                            return false;
                                    }
                            }
                        }
                    case 132:
                        if (var3 == TypeBinding.field_187) {
                            this.tagAsUnnecessaryCast(var1, var2);
                            return true;
                        }
                        return false;
                    case 516:
                    case 8196:
                        var6 = var3.method_140(var2);
                        if (var6 != null) {
                            return this.checkUnsafeCast(var1, var2, var3, var6, false);
                        }
                        return this.checkCastTypesCompatibility(var1, var2, ((WildcardBinding)var3).bound, var4);
                    case 4100:
                        var6 = var3.method_140(var2);
                        if (var6 != null) {
                            return this.checkUnsafeCast(var1, var2, var3, var6, false);
                        }
                        return this.checkCastTypesCompatibility(var1, var2, ((TypeVariableBinding)var3).method_261(), var4);
                    default:
                        ReferenceBinding var14;
                        if (!var3.method_157()) {
                            switch (var2.kind()) {
                                case 68:
                                    if (var3.id == 1) {
                                        if (var5) {
                                            this.checkUnsafeCast(var1, var2, var3, var3, true);
                                        }
                                        this.tagAsNeedCheckCast();
                                        return true;
                                    }
                                    return false;
                                case 4100:
                                    var6 = var3.method_140(var2);
                                    if (var6 == null) {
                                        this.checkUnsafeCast(var1, var2, var3, var6, true);
                                    }
                                    return this.checkCastTypesCompatibility(var1, ((TypeVariableBinding)var2).method_261(), var3, var4);
                                default:
                                    if (var2.method_157()) {
                                        var14 = (ReferenceBinding)var3;
                                        var6 = var14.method_140(var2);
                                        if (var6 != null) {
                                            return this.checkUnsafeCast(var1, var2, var3, var6, false);
                                        } else if (var14.method_221()) {
                                            return false;
                                        } else {
                                            this.tagAsNeedCheckCast();
                                            var6 = var2.method_140(var3);
                                            if (var6 != null) {
                                                return this.checkUnsafeCast(var1, var2, var3, var6, true);
                                            } else {
                                                if (var5) {
                                                    this.checkUnsafeCast(var1, var2, var3, (TypeBinding)null, true);
                                                    if (var14.method_212((ReferenceBinding)var2)) {
                                                        return false;
                                                    }
                                                }
                                                return true;
                                            }
                                        }
                                    } else {
                                        var6 = var3.method_140(var2);
                                        if (var6 != null) {
                                            if (var4 != null && var2.id == 11) {
                                                this.constant = var4.constant;
                                            }
                                            return this.checkUnsafeCast(var1, var2, var3, var6, false);
                                        } else {
                                            var6 = var2.method_140(var3);
                                            if (var6 != null) {
                                                this.tagAsNeedCheckCast();
                                                return this.checkUnsafeCast(var1, var2, var3, var6, true);
                                            } else {
                                                return false;
                                            }
                                        }
                                    }
                            }
                        } else {
                            switch (var2.kind()) {
                                case 68:
                                    switch (var3.id) {
                                        case 36:
                                        case 37:
                                            this.tagAsNeedCheckCast();
                                            return true;
                                        default:
                                            return false;
                                    }
                                case 4100:
                                    var6 = var3.method_140(var2);
                                    if (var6 == null) {
                                        this.checkUnsafeCast(var1, var2, var3, (TypeBinding)null, true);
                                    }
                                    return this.checkCastTypesCompatibility(var1, ((TypeVariableBinding)var2).method_261(), var3, var4);
                                default:
                                    if (!var2.method_157()) {
                                        if (var2.id == 1) {
                                            this.tagAsUnnecessaryCast(var1, var2);
                                            return true;
                                        } else {
                                            this.tagAsNeedCheckCast();
                                            var6 = var2.method_140(var3);
                                            if (var6 != null) {
                                                return this.checkUnsafeCast(var1, var2, var3, var6, true);
                                            } else if (((ReferenceBinding)var2).method_221()) {
                                                return false;
                                            } else {
                                                if (var5) {
                                                    this.checkUnsafeCast(var1, var2, var3, (TypeBinding)null, true);
                                                    if (((ReferenceBinding)var2).method_212((ReferenceBinding)var3)) {
                                                        return false;
                                                    }
                                                }
                                                return true;
                                            }
                                        }
                                    } else {
                                        var14 = (ReferenceBinding)var3;
                                        var6 = var14.method_140(var2);
                                        if (var6 != null) {
                                            return this.checkUnsafeCast(var1, var2, var14, var6, false);
                                        } else {
                                            this.tagAsNeedCheckCast();
                                            var6 = var2.method_140(var14);
                                            if (var6 != null) {
                                                return this.checkUnsafeCast(var1, var2, var14, var6, true);
                                            } else {
                                                if (var5) {
                                                    this.checkUnsafeCast(var1, var2, var3, (TypeBinding)null, true);
                                                    if (var14.method_212((ReferenceBinding)var2)) {
                                                        return false;
                                                    }
                                                } else {
                                                    MethodBinding[] var15 = this.getAllInheritedMethods((ReferenceBinding)var2);
                                                    MethodBinding[] var9 = this.getAllInheritedMethods((ReferenceBinding)var3);
                                                    int var10 = var9.length;
                                                    int var11 = 0;
                                                    for (int var12 = var15.length; var11 < var12; ++var11) {
                                                        for (int var13 = 0; var13 < var10; ++var13) {
                                                            if (var15[var11].returnType != var9[var13].returnType && CharOperation.method_1364(var15[var11].selector, var9[var13].selector) && var15[var11].method_344(var9[var13])) {
                                                                return false;
                                                            }
                                                        }
                                                    }
                                                }
                                                return true;
                                            }
                                        }
                                    }
                            }
                        }
                }
            }
        } else {
            return true;
        }
    }

    public void checkNPE(BlockScope var1, FlowContext var2, FlowInfo var3) {
        LocalVariableBinding var4 = this.localVariableBinding();
        if (var4 != null && (var4.type.tagBits & 2L) == 0L) {
            if ((this.field_446 & 131072) == 0) {
                var2.recordUsingNullReference(var1, var4, this, 3, var3);
            }
            var3.method_3094(var4);
            if (var2.initsOnFinally != null) {
                var2.initsOnFinally.method_3094(var4);
            }
        }
    }

    public boolean checkUnsafeCast(Scope var1, TypeBinding var2, TypeBinding var3, TypeBinding var4, boolean var5) {
        if (var4 == var2) {
            if (!var5) {
                this.tagAsUnnecessaryCast(var1, var2);
            }
            return true;
        } else {
            if (var4 != null && (var2.method_149() || var3.method_149())) {
                label40: {
                    if (var5) {
                        if (!var4.method_164(var3)) {
                            break label40;
                        }
                    } else if (!var2.method_164(var4)) {
                        break label40;
                    }
                    return false;
                }
            }
            if (!var5) {
                this.tagAsUnnecessaryCast(var1, var2);
            }
            return true;
        }
    }

    public void computeConversion(Scope var1, TypeBinding var2, TypeBinding var3) {
        if (var2 != null && var3 != null) {
            if (this.field_674 == 0) {
                TypeBinding var4;
                if (var2 != TypeBinding.field_187 && var2.method_148()) {
                    if (!var3.method_148()) {
                        var4 = var1.environment().method_486(var3);
                        this.field_674 = 1024;
                        var1.problemReporter().method_1485(this, var3, var2);
                        var3 = var4;
                    }
                } else {
                    if (var3 != TypeBinding.field_187 && var3.method_148()) {
                        var4 = var1.environment().method_486(var2);
                        if (var4 == var2) {
                            var4 = var3;
                        }
                        this.field_674 = 512 | (var4.id << 4) + var3.id;
                        var1.problemReporter().method_1485(this, var3, var1.environment().method_486(var4));
                        return;
                    }
                    if (this.constant != Constant.NotAConstant && this.constant.typeID() != 11) {
                        this.field_674 = 512;
                        return;
                    }
                }
                int var6 = var3.id;
                if (var3.id == Integer.MAX_VALUE) {
                    var6 = var3.erasure().id == 11 ? 11 : 1;
                }
                int var5 = var2.id;
                switch (var2.id) {
                    case 2:
                    case 3:
                    case 4:
                        this.field_674 |= 160 + var6;
                        break;
                    case 5:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                        this.field_674 |= (var5 << 4) + var6;
                    case 6:
                }
            }
        }
    }

    public void generateCode(BlockScope var1, CodeStream var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            this.generateCode(var1, var2, false);
        }
    }

    public void generateCode(BlockScope var1, CodeStream var2, boolean var3) {
        if (this.constant != Constant.NotAConstant) {
            int var4 = var2.field_1208;
            var2.generateConstant(this.constant, this.field_674);
            var2.method_2360(var4, this.field_444);
        } else {
            ShouldNotImplement var10000 = new ShouldNotImplement(Messages.field_1893);
            throw var10000;
        }
    }

    public void generateOptimizedBoolean(BlockScope var1, CodeStream var2, BranchLabel var3, BranchLabel var4, boolean var5) {
        Constant var6 = this.optimizedBooleanConstant();
        this.generateCode(var1, var2, var5 && var6 == Constant.NotAConstant);
        int var7;
        if (var6 != Constant.NotAConstant && var6.typeID() == 5) {
            var7 = var2.field_1208;
            if (var6.booleanValue()) {
                if (var5 && var4 == null && var3 != null) {
                    var2.method_2209(var3);
                }
            } else if (var5 && var4 != null && var3 == null) {
                var2.method_2209(var4);
            }
            var2.method_2360(var7, this.field_444);
        } else {
            var7 = var2.field_1208;
            if (var5) {
                if (var4 == null) {
                    if (var3 != null) {
                        var2.method_2242(var3);
                    }
                } else if (var3 == null) {
                    var2.method_2237(var4);
                }
            }
            var2.method_2380(var1, var7);
        }
    }

    public void method_914(BlockScope var1, CodeStream var2, int var3) {
        if (var3 != 11 || this.constant == Constant.NotAConstant || this.constant.method_3287().length() != 0) {
            this.generateCode(var1, var2, true);
            var2.method_2274(var3);
        }
    }

    public void method_915(BlockScope var1, CodeStream var2, int var3) {
        var2.method_2349();
        var2.method_2141();
        switch (var3) {
            case 0:
            case 1:
                var2.method_2275();
                this.generateCode(var1, var2, true);
                var2.method_2274(1);
                return;
            case 11:
            case 12:
                if (this.constant != Constant.NotAConstant) {
                    String var4 = this.constant.method_3287();
                    if (var4.length() == 0) {
                        var2.method_2275();
                        return;
                    }
                    var2.ldc(var4);
                } else {
                    this.generateCode(var1, var2, true);
                    var2.method_2279(1);
                }
                break;
            default:
                this.generateCode(var1, var2, true);
                var2.method_2279(var3);
        }
        var2.method_2276();
    }

    private MethodBinding[] getAllInheritedMethods(ReferenceBinding var1) {
        ArrayList var10000 = new ArrayList();
        ArrayList var2 = var10000;
        this.method_917(var1, var2);
        return (MethodBinding[])((MethodBinding[])var2.toArray(new MethodBinding[var2.size()]));
    }

    private void method_917(ReferenceBinding var1, ArrayList var2) {
        if (var1.method_157()) {
            MethodBinding[] var3 = var1.methods();
            int var4 = 0;
            int var5;
            for (var5 = var3.length; var4 < var5; ++var4) {
                var2.add(var3[var4]);
            }
            ReferenceBinding[] var7 = var1.superInterfaces();
            var5 = 0;
            for (int var6 = var7.length; var5 < var6; ++var5) {
                this.method_917(var7[var5], var2);
            }
        }
    }

    public boolean isCompactableOperation() {
        return false;
    }

    public boolean isConstantValueOfTypeAssignableToType(TypeBinding var1, TypeBinding var2) {
        return this.constant == Constant.NotAConstant ? false : (var1 == var2 ? true : (var1.method_148() && var2.method_148() && (var1 == TypeBinding.field_179 || BaseTypeBinding.method_185(10, var1.id)) && BaseTypeBinding.method_184(var2.id, 10) ? isConstantValueRepresentable(this.constant, var1.id, var2.id) : false));
    }

    public LocalVariableBinding localVariableBinding() {
        return null;
    }

    public int nullStatus(FlowInfo var1) {
        if (this.constant != null && this.constant != Constant.NotAConstant) {
            return -1;
        } else {
            LocalVariableBinding var2 = this.localVariableBinding();
            return var2 != null ? (var1.method_3085(var2) ? 1 : (var1.method_3084(var2) ? -1 : 0)) : -1;
        }
    }

    public Constant optimizedBooleanConstant() {
        return this.constant;
    }

    public TypeBinding postConversionType(Scope var1) {
        Object var2 = this.resolvedType;
        int var3 = (this.field_674 & 255) >> 4;
        switch (var3) {
            case 2:
                var2 = TypeBinding.field_182;
                break;
            case 3:
                var2 = TypeBinding.field_180;
                break;
            case 4:
                var2 = TypeBinding.field_181;
                break;
            case 5:
                var2 = TypeBinding.field_186;
            case 6:
            default:
                break;
            case 7:
                var2 = TypeBinding.field_183;
                break;
            case 8:
                var2 = TypeBinding.field_185;
                break;
            case 9:
                var2 = TypeBinding.field_184;
                break;
            case 10:
                var2 = TypeBinding.field_179;
        }
        if ((this.field_674 & 512) != 0) {
            var2 = var1.environment().method_486((TypeBinding)var2);
        }
        return (TypeBinding)var2;
    }

    public StringBuffer print(int var1, StringBuffer var2) {
        method_759(var1, var2);
        return this.printExpression(var1, var2);
    }

    public abstract StringBuffer printExpression(int var1, StringBuffer var2);

    public StringBuffer printStatement(int var1, StringBuffer var2) {
        return this.print(var1, var2).append(";");
    }

    public void resolve(BlockScope var1) {
        this.resolveType(var1);
    }

    public TypeBinding resolveType(BlockScope var1) {
        return null;
    }

    public TypeBinding resolveTypeExpecting(BlockScope var1, TypeBinding var2) {
        this.setExpectedType(var2);
        TypeBinding var3 = this.resolveType(var1);
        if (var3 == null) {
            return null;
        } else if (var3 == var2) {
            return var3;
        } else {
            if (!var3.isCompatibleWith(var2)) {
                if (!var1.isBoxingCompatibleWith(var3, var2)) {
                    var1.problemReporter().typeMismatchError(var3, var2, this, (ASTNode)null);
                    return null;
                }
                this.computeConversion(var1, var2, var3);
            }
            return var3;
        }
    }

    public Object reusableJSRTarget() {
        return this.constant != Constant.NotAConstant ? this.constant : null;
    }

    public void setExpectedType(TypeBinding var1) {}

    public void tagAsNeedCheckCast() {}

    public void tagAsUnnecessaryCast(Scope var1, TypeBinding var2) {}

    public void traverse(ASTVisitor var1, BlockScope var2) {}
}
