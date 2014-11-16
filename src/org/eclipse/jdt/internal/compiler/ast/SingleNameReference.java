package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.CastExpression;
import org.eclipse.jdt.internal.compiler.ast.Assignment;
import org.eclipse.jdt.internal.compiler.ast.CompoundAssignment;
import org.eclipse.jdt.internal.compiler.ast.BinaryExpression;
import org.eclipse.jdt.internal.compiler.ast.NameReference;
import org.eclipse.jdt.internal.compiler.ast.IntLiteral;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.MissingTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ProblemReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.VariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.ProblemFieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodScope;
import org.eclipse.jdt.internal.compiler.problem.ProblemReporter;

public class SingleNameReference extends NameReference {

    public char[] token;

    public MethodBinding[] syntheticAccessors;

    public TypeBinding genericCast;

    public SingleNameReference(char[] var1, long var2) {
        this.token = var1;
        this.field_444 = (int)(var2 >>> 32);
        this.field_445 = (int)var2;
    }

    public FlowInfo analyseAssignment(BlockScope var1, FlowContext var2, FlowInfo var3, Assignment var4, boolean var5) {
        boolean var6 = (((FlowInfo)var3).tagBits & 1) == 0;
        FieldBinding var7;
        LocalVariableBinding var8;
        if (var5) {
            switch (this.field_446 & 7) {
                case 1:
                    if ((var7 = (FieldBinding)this.field_748).method_408() && var1.method_716(var7) && !((FlowInfo)var3).method_3082(var7)) {
                        var1.problemReporter().method_1788(var7, this);
                    }
                    this.manageSyntheticAccessIfNecessary(var1, (FlowInfo)var3, true);
                    break;
                case 2:
                    if (!((FlowInfo)var3).method_3083(var8 = (LocalVariableBinding)this.field_748)) {
                        var1.problemReporter().method_1789(var8, this);
                    }
                    if (var6) {
                        var8.field_307 = 1;
                    } else if (var8.field_307 == 0) {
                        var8.field_307 = 2;
                    }
            }
        }
        if (var4.field_688 != null) {
            var3 = var4.field_688.analyseCode(var1, var2, (FlowInfo)var3).method_3109();
        }
        switch (this.field_446 & 7) {
            case 1:
                this.manageSyntheticAccessIfNecessary(var1, (FlowInfo)var3, false);
                var7 = (FieldBinding)this.field_748;
                if (var7.method_409()) {
                    if (!var5 && var7.method_408() && var1.method_706(var7)) {
                        if (((FlowInfo)var3).method_3087(var7)) {
                            var1.problemReporter().duplicateInitializationOfBlankFinalField(var7, this);
                        } else {
                            var2.recordSettingFinal(var7, this, (FlowInfo)var3);
                        }
                        ((FlowInfo)var3).markAsDefinitelyAssigned(var7);
                    } else {
                        var1.problemReporter().method_1491(var7, this);
                    }
                }
                break;
            case 2:
                var8 = (LocalVariableBinding)this.field_748;
                if (!((FlowInfo)var3).method_3083(var8)) {
                    this.field_446 |= 8;
                } else {
                    this.field_446 &= -9;
                }
                if (var8.method_409()) {
                    if ((this.field_446 & 8160) == 0) {
                        if ((!var6 || !var5) && var8.method_408()) {
                            if (((FlowInfo)var3).method_3088(var8)) {
                                var1.problemReporter().method_1528(var8, this);
                            } else {
                                var2.recordSettingFinal(var8, this, (FlowInfo)var3);
                            }
                        } else {
                            var1.problemReporter().method_1492(var8, this);
                        }
                    } else {
                        var1.problemReporter().method_1493(var8, this);
                    }
                } else if ((var8.tagBits & 1024L) != 0L) {
                    var1.problemReporter().method_1720(var8, this);
                }
                ((FlowInfo)var3).method_3099(var8);
        }
        this.manageEnclosingInstanceAccessIfNecessary(var1, (FlowInfo)var3);
        return (FlowInfo)var3;
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        return this.analyseCode(var1, var2, var3, true);
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3, boolean var4) {
        switch (this.field_446 & 7) {
            case 1:
                if (var4 || var1.compilerOptions().field_1927 >= 3145728L) {
                    this.manageSyntheticAccessIfNecessary(var1, var3, true);
                }
                FieldBinding var5 = (FieldBinding)this.field_748;
                if (var5.method_408() && var1.method_716(var5) && !var3.method_3082(var5)) {
                    var1.problemReporter().method_1788(var5, this);
                }
                break;
            case 2:
                LocalVariableBinding var6;
                if (!var3.method_3083(var6 = (LocalVariableBinding)this.field_748)) {
                    var1.problemReporter().method_1789(var6, this);
                }
                if ((var3.tagBits & 1) == 0) {
                    var6.field_307 = 1;
                } else if (var6.field_307 == 0) {
                    var6.field_307 = 2;
                }
        }
        if (var4) {
            this.manageEnclosingInstanceAccessIfNecessary(var1, var3);
        }
        return var3;
    }

    public TypeBinding method_1050(BlockScope var1) {
        FieldBinding var2 = (FieldBinding)this.field_748;
        this.constant = var2.constant();
        this.field_446 &= -8;
        this.field_446 |= 1;
        MethodScope var3 = var1.method_635();
        if (var2.method_431()) {
            ReferenceBinding var4 = var2.declaringClass;
            if (var4.method_153()) {
                SourceTypeBinding var5 = var1.enclosingSourceType();
                if (this.constant == Constant.NotAConstant && !var3.field_404 && (var5 == var4 || var5.superclass == var4) && var3.method_728()) {
                    var1.problemReporter().method_1543(var2, this);
                }
            }
        } else {
            if (var1.compilerOptions().method_3313(4194304L) != -1) {
                var1.problemReporter().method_1796(this, var2);
            }
            if (var3.field_404) {
                var1.problemReporter().method_1757(this, var2);
                return var2.type;
            }
        }
        if (this.isFieldUseDeprecated(var2, var1, (this.field_446 & 8192) != 0)) {
            var1.problemReporter().method_1514(var2, this);
        }
        if ((this.field_446 & 8192) == 0 && var3.enclosingSourceType() == var2.original().declaringClass && var3.field_407 >= 0 && var2.field_304 >= var3.field_407 && (!var2.method_431() || var3.field_404)) {
            var1.problemReporter().method_1556(this, 0, var3.enclosingSourceType());
            this.field_446 |= 536870912;
        }
        return var2.type;
    }

    public void computeConversion(Scope var1, TypeBinding var2, TypeBinding var3) {
        if (var2 != null && var3 != null) {
            if ((this.field_446 & 1) != 0 && this.field_748 != null && this.field_748.isValidBinding()) {
                FieldBinding var4 = (FieldBinding)this.field_748;
                FieldBinding var5 = var4.original();
                TypeBinding var6 = var5.type;
                if (var5 != var4 && var6 != var4.type && var2.id != 1 && (var6.tagBits & 536870912L) != 0L) {
                    TypeBinding var7 = !var3.method_148() && var2.method_148() ? var3 : var2;
                    this.genericCast = var6.method_141(var1.boxing(var7));
                    if (this.genericCast instanceof ReferenceBinding) {
                        ReferenceBinding var8 = (ReferenceBinding)this.genericCast;
                        if (!var8.canBeSeenBy(var1)) {
                            ProblemReporter var10000 = var1.problemReporter();
                            ProblemReferenceBinding var10002 = new ProblemReferenceBinding(CharOperation.method_1385('.', var8.shortReadableName()), var8, 2);
                            var10000.method_1639(this, var10002);
                        }
                    }
                }
            }
            super.computeConversion(var1, var2, var3);
        }
    }

    public void generateAssignment(BlockScope var1, CodeStream var2, Assignment var3, boolean var4) {
        int var6;
        if (var3.field_688.isCompactableOperation()) {
            BinaryExpression var5 = (BinaryExpression)var3.field_688;
            var6 = (var5.field_446 & 4032) >> 6;
            SingleNameReference var7;
            if (var5.field_715 instanceof SingleNameReference && (var7 = (SingleNameReference)var5.field_715).field_748 == this.field_748) {
                var7.generateCompoundAssignment(var1, var2, this.syntheticAccessors == null ? null : this.syntheticAccessors[1], var5.field_716, var6, var5.field_674, var4);
                if (var4) {
                    var2.method_2182(var3.field_674);
                }
                return;
            }
            if (var5.field_716 instanceof SingleNameReference && (var6 == 14 || var6 == 15) && (var7 = (SingleNameReference)var5.field_716).field_748 == this.field_748 && var5.field_715.constant != Constant.NotAConstant && (var5.field_715.field_674 & 255) >> 4 != 11 && (var5.field_716.field_674 & 255) >> 4 != 11) {
                var7.generateCompoundAssignment(var1, var2, this.syntheticAccessors == null ? null : this.syntheticAccessors[1], var5.field_715, var6, var5.field_674, var4);
                if (var4) {
                    var2.method_2182(var3.field_674);
                }
                return;
            }
        }
        switch (this.field_446 & 7) {
            case 1:
                var6 = var2.field_1208;
                FieldBinding var9;
                if (!(var9 = (FieldBinding)this.field_749).method_431()) {
                    if ((this.field_446 & 8160) != 0) {
                        ReferenceBinding var10 = var1.enclosingSourceType().enclosingTypeAt((this.field_446 & 8160) >> 5);
                        Object[] var8 = var1.getEmulationPath(var10, true, false);
                        var2.generateOuterAccess(var8, this, var10, var1);
                    } else {
                        this.generateReceiver(var2);
                    }
                }
                var2.method_2360(var6, this.field_444);
                var3.field_688.generateCode(var1, var2, true);
                this.method_1037(var2, var9, this.syntheticAccessors == null ? null : this.syntheticAccessors[1], var4);
                if (var4) {
                    var2.method_2182(var3.field_674);
                }
                return;
            case 2:
                LocalVariableBinding var11 = (LocalVariableBinding)this.field_749;
                if (var11.field_306 == -1) {
                    if (var3.field_688.constant != Constant.NotAConstant) {
                        if (var4) {
                            var2.generateConstant(var3.field_688.constant, var3.field_674);
                        }
                    } else {
                        var3.field_688.generateCode(var1, var2, true);
                        if (var4) {
                            var2.method_2182(var3.field_674);
                        } else if (var11.type != TypeBinding.field_183 && var11.type != TypeBinding.field_185) {
                            var2.method_2352();
                        } else {
                            var2.method_2353();
                        }
                    }
                    return;
                } else {
                    var3.field_688.generateCode(var1, var2, true);
                    if (var11.type.method_147() && (var3.field_688.resolvedType == TypeBinding.field_187 || var3.field_688 instanceof CastExpression && ((CastExpression)var3.field_688).innermostCastedExpression().resolvedType == TypeBinding.field_187)) {
                        var2.method_2113(var11.type);
                    }
                    var2.store(var11, var4);
                    if ((this.field_446 & 8) != 0) {
                        var11.method_415(var2.field_1208);
                    }
                    if (var4) {
                        var2.method_2182(var3.field_674);
                    }
                }
            default:
        }
    }

    public void generateCode(BlockScope var1, CodeStream var2, boolean var3) {
        int var4 = var2.field_1208;
        if (this.constant != Constant.NotAConstant) {
            if (var3) {
                var2.generateConstant(this.constant, this.field_674);
            }
            var2.method_2360(var4, this.field_444);
        } else {
            switch (this.field_446 & 7) {
                case 1:
                    FieldBinding var5 = (FieldBinding)this.field_749;
                    Constant var6 = var5.constant();
                    if (var6 != Constant.NotAConstant) {
                        if (var3) {
                            var2.generateConstant(var6, this.field_674);
                        }
                        var2.method_2360(var4, this.field_444);
                        return;
                    }
                    if (var5.method_431()) {
                        if (!var3 && ((FieldBinding)this.field_748).original().declaringClass == this.actualReceiverType.erasure() && (this.field_674 & 1024) == 0 && this.genericCast == null) {
                            var2.method_2360(var4, this.field_444);
                            return;
                        }
                        if (this.syntheticAccessors != null && this.syntheticAccessors[0] != null) {
                            var2.method_2273(this.syntheticAccessors[0]);
                        } else {
                            var2.method_2207(var5);
                        }
                    } else {
                        if (!var3 && (this.field_674 & 1024) == 0 && this.genericCast == null) {
                            var2.method_2360(var4, this.field_444);
                            return;
                        }
                        if ((this.field_446 & 8160) != 0) {
                            ReferenceBinding var10 = var1.enclosingSourceType().enclosingTypeAt((this.field_446 & 8160) >> 5);
                            Object[] var11 = var1.getEmulationPath(var10, true, false);
                            var2.generateOuterAccess(var11, this, var10, var1);
                        } else {
                            this.generateReceiver(var2);
                        }
                        if (this.syntheticAccessors != null && this.syntheticAccessors[0] != null) {
                            var2.method_2273(this.syntheticAccessors[0]);
                        } else {
                            var2.method_2205(var5);
                        }
                    }
                    break;
                case 2:
                    LocalVariableBinding var7 = (LocalVariableBinding)this.field_749;
                    if (!var3 && (this.field_674 & 1024) == 0) {
                        var2.method_2360(var4, this.field_444);
                        return;
                    }
                    if ((this.field_446 & 8160) != 0) {
                        VariableBinding[] var8 = var1.getEmulationPath(var7);
                        var2.generateOuterAccess(var8, this, var7, var1);
                    } else {
                        var2.load(var7);
                    }
                    break;
                default:
                    var2.method_2360(var4, this.field_444);
                    return;
            }
            if (this.genericCast != null) {
                var2.method_2113(this.genericCast);
            }
            if (var3) {
                var2.method_2182(this.field_674);
            } else {
                boolean var9 = (this.field_674 & 1024) != 0;
                if (var9) {
                    var2.method_2182(this.field_674);
                }
                switch (var9 ? this.postConversionType(var1).id : this.resolvedType.id) {
                    case 7:
                    case 8:
                        var2.method_2353();
                        break;
                    default:
                        var2.method_2352();
                }
            }
            var2.method_2360(var4, this.field_444);
        }
    }

    public void generateCompoundAssignment(BlockScope var1, CodeStream var2, Expression var3, int var4, int var5, boolean var6) {
        this.generateCompoundAssignment(var1, var2, this.syntheticAccessors == null ? null : this.syntheticAccessors[1], var3, var4, var5, var6);
    }

    public void generateCompoundAssignment(BlockScope var1, CodeStream var2, MethodBinding var3, Expression var4, int var5, int var6, boolean var7) {
        LocalVariableBinding var9;
        switch (this.field_446 & 7) {
            case 1:
                FieldBinding var8;
                if ((var8 = (FieldBinding)this.field_749).method_431()) {
                    if (this.syntheticAccessors != null && this.syntheticAccessors[0] != null) {
                        var2.method_2273(this.syntheticAccessors[0]);
                    } else {
                        var2.method_2207(var8);
                    }
                } else {
                    if ((this.field_446 & 8160) != 0) {
                        ReferenceBinding var13 = var1.enclosingSourceType().enclosingTypeAt((this.field_446 & 8160) >> 5);
                        Object[] var14 = var1.getEmulationPath(var13, true, false);
                        var2.generateOuterAccess(var14, this, var13, var1);
                    } else {
                        var2.method_2093();
                    }
                    var2.method_2141();
                    if (this.syntheticAccessors != null && this.syntheticAccessors[0] != null) {
                        var2.method_2273(this.syntheticAccessors[0]);
                    } else {
                        var2.method_2205(var8);
                    }
                }
                break;
            case 2:
                var9 = (LocalVariableBinding)this.field_749;
                label54:
                switch (var9.type.id) {
                    case 10:
                        Constant var10 = var4.constant;
                        if (var4.constant != Constant.NotAConstant && var10.typeID() != 9 && var10.typeID() != 8) {
                            int var11;
                            switch (var5) {
                                case 13:
                                    var11 = -var10.intValue();
                                    if (var11 == (short)var11) {
                                        var2.iinc(var9.field_306, var11);
                                        if (var7) {
                                            var2.load(var9);
                                        }
                                        return;
                                    }
                                    break label54;
                                case 14:
                                    var11 = var10.intValue();
                                    if (var11 == (short)var11) {
                                        var2.iinc(var9.field_306, var11);
                                        if (var7) {
                                            var2.load(var9);
                                        }
                                        return;
                                    }
                            }
                        }
                    case 11: {
                        var2.generateStringConcatenationAppend(var1, this, var4);
                        if (var7) {
                            var2.method_2141();
                        }
                        var2.store(var9, false);
                        return;
                    }
                    default:
                        var2.load(var9);
                }
        }
        int var12;
        switch (var12 = (this.field_674 & 255) >> 4) {
            case 0:
            case 1:
            case 11:
                var2.generateStringConcatenationAppend(var1, (Expression)null, var4);
                break;
            default:
                if (this.genericCast != null) {
                    var2.method_2113(this.genericCast);
                }
                var2.method_2182(this.field_674);
                if (var4 == IntLiteral.One) {
                    var2.generateConstant(var4.constant, this.field_674);
                } else {
                    var4.generateCode(var1, var2, true);
                }
                var2.method_2374(var5, var12);
                var2.method_2182(var6);
        }
        switch (this.field_446 & 7) {
            case 1:
                this.method_1037(var2, (FieldBinding)this.field_749, var3, var7);
                return;
            case 2:
                var9 = (LocalVariableBinding)this.field_749;
                if (var7) {
                    if (var9.type != TypeBinding.field_183 && var9.type != TypeBinding.field_185) {
                        var2.method_2141();
                    } else {
                        var2.method_2144();
                    }
                }
                var2.store(var9, false);
            default:
        }
    }

    public void generatePostIncrement(BlockScope var1, CodeStream var2, CompoundAssignment var3, boolean var4) {
        switch (this.field_446 & 7) {
            case 1:
                FieldBinding var5;
                if ((var5 = (FieldBinding)this.field_749).method_431()) {
                    if (this.syntheticAccessors != null && this.syntheticAccessors[0] != null) {
                        var2.method_2273(this.syntheticAccessors[0]);
                    } else {
                        var2.method_2207(var5);
                    }
                } else {
                    if ((this.field_446 & 8160) != 0) {
                        ReferenceBinding var8 = var1.enclosingSourceType().enclosingTypeAt((this.field_446 & 8160) >> 5);
                        Object[] var7 = var1.getEmulationPath(var8, true, false);
                        var2.generateOuterAccess(var7, this, var8, var1);
                    } else {
                        var2.method_2093();
                    }
                    var2.method_2141();
                    if (this.syntheticAccessors != null && this.syntheticAccessors[0] != null) {
                        var2.method_2273(this.syntheticAccessors[0]);
                    } else {
                        var2.method_2205(var5);
                    }
                }
                if (var4) {
                    if (var5.method_431()) {
                        if (var5.type != TypeBinding.field_183 && var5.type != TypeBinding.field_185) {
                            var2.method_2141();
                        } else {
                            var2.method_2144();
                        }
                    } else if (var5.type != TypeBinding.field_183 && var5.type != TypeBinding.field_185) {
                        var2.method_2142();
                    } else {
                        var2.method_2145();
                    }
                }
                if (this.genericCast != null) {
                    var2.method_2113(this.genericCast);
                }
                var2.method_2182(this.field_674);
                var2.generateConstant(var3.field_688.constant, this.field_674);
                var2.method_2374(var3.field_689, this.field_674 & 15);
                var2.method_2182(var3.field_690);
                this.method_1037(var2, var5, this.syntheticAccessors == null ? null : this.syntheticAccessors[1], false);
                return;
            case 2:
                LocalVariableBinding var6 = (LocalVariableBinding)this.field_749;
                if (var6.type == TypeBinding.field_179) {
                    if (var4) {
                        var2.load(var6);
                    }
                    if (var3.field_689 == 14) {
                        var2.iinc(var6.field_306, 1);
                    } else {
                        var2.iinc(var6.field_306, -1);
                    }
                } else {
                    var2.load(var6);
                    if (var4) {
                        if (var6.type != TypeBinding.field_183 && var6.type != TypeBinding.field_185) {
                            var2.method_2141();
                        } else {
                            var2.method_2144();
                        }
                    }
                    var2.method_2182(this.field_674);
                    var2.generateConstant(var3.field_688.constant, this.field_674);
                    var2.method_2374(var3.field_689, this.field_674 & 15);
                    var2.method_2182(var3.field_690);
                    var2.store(var6, false);
                }
            default:
        }
    }

    public void generateReceiver(CodeStream var1) {
        var1.method_2093();
    }

    public TypeBinding[] genericTypeArguments() {
        return null;
    }

    public LocalVariableBinding localVariableBinding() {
        switch (this.field_446 & 7) {
            case 1:
            default:
                return null;
            case 2:
                return (LocalVariableBinding)this.field_748;
        }
    }

    public void manageEnclosingInstanceAccessIfNecessary(BlockScope var1, FlowInfo var2) {
        if ((var2.tagBits & 1) == 0) {
            if ((this.field_446 & 8160) == 0 || this.constant != Constant.NotAConstant) {
                return;
            }
            if ((this.field_446 & 7) == 2) {
                var1.emulateOuterAccess((LocalVariableBinding)this.field_748);
            }
        }
    }

    public void manageSyntheticAccessIfNecessary(BlockScope var1, FlowInfo var2, boolean var3) {
        if ((var2.tagBits & 1) == 0) {
            if (this.constant == Constant.NotAConstant) {
                if ((this.field_446 & 1) != 0) {
                    FieldBinding var4 = (FieldBinding)this.field_748;
                    FieldBinding var5 = var4.original();
                    this.field_749 = var5;
                    if ((this.field_446 & 8160) != 0 && (var5.method_428() || var5.method_429() && var5.declaringClass.getPackage() != var1.enclosingSourceType().getPackage())) {
                        if (this.syntheticAccessors == null) {
                            this.syntheticAccessors = new MethodBinding[2];
                        }
                        this.syntheticAccessors[var3 ? 0 : 1] = ((SourceTypeBinding)var1.enclosingSourceType().enclosingTypeAt((this.field_446 & 8160) >> 5)).method_298(var5, var3);
                        var1.problemReporter().needToEmulateFieldAccess(var5, this, var3);
                        return;
                    }
                    if (var4.declaringClass != this.actualReceiverType && !this.actualReceiverType.method_147() && var4.declaringClass != null && var4.constant() == Constant.NotAConstant) {
                        CompilerOptions var6 = var1.compilerOptions();
                        if (var6.field_1929 >= 3014656L && (var6.field_1927 >= 3145728L || !var4.method_431()) && var4.declaringClass.id != 1 || !var4.declaringClass.canBeSeenBy(var1)) {
                            this.field_749 = var1.enclosingSourceType().method_311(var5, (ReferenceBinding)this.actualReceiverType.erasure());
                        }
                    }
                }
            }
        }
    }

    public int nullStatus(FlowInfo var1) {
        if (this.constant != null && this.constant != Constant.NotAConstant) {
            return -1;
        } else {
            switch (this.field_446 & 7) {
                case 1:
                    return 0;
                case 2:
                    LocalVariableBinding var2 = (LocalVariableBinding)this.field_748;
                    if (var2 != null) {
                        if (var1.method_3085(var2)) {
                            return 1;
                        } else {
                            if (var1.method_3084(var2)) {
                                return -1;
                            }
                            return 0;
                        }
                    }
                default:
                    return -1;
            }
        }
    }

    public TypeBinding postConversionType(Scope var1) {
        Object var2 = this.resolvedType;
        if (this.genericCast != null) {
            var2 = this.genericCast;
        }
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

    public StringBuffer printExpression(int var1, StringBuffer var2) {
        return var2.append(this.token);
    }

    public TypeBinding method_1055(BlockScope var1) {
        this.constant = Constant.NotAConstant;
        if (this.field_748 instanceof ProblemFieldBinding) {
            var1.problemReporter().method_1629(this, (FieldBinding)this.field_748);
        } else if (!(this.field_748 instanceof ProblemReferenceBinding) && !(this.field_748 instanceof MissingTypeBinding)) {
            var1.problemReporter().unresolvableReference(this, this.field_748);
        } else {
            var1.problemReporter().method_1639(this, (TypeBinding)this.field_748);
        }
        return null;
    }

    public TypeBinding resolveType(BlockScope var1) {
        if (this.actualReceiverType != null) {
            this.field_748 = var1.method_601(this.actualReceiverType, this.token, this);
        } else {
            this.actualReceiverType = var1.enclosingSourceType();
            this.field_748 = var1.getBinding(this.token, this.field_446 & 7, this, true);
        }
        this.field_749 = this.field_748;
        if (this.field_748.isValidBinding()) {
            switch (this.field_446 & 7) {
                case 3:
                case 7:
                    if (this.field_748 instanceof VariableBinding) {
                        VariableBinding var4 = (VariableBinding)this.field_748;
                        TypeBinding var3;
                        if (this.field_748 instanceof LocalVariableBinding) {
                            this.field_446 &= -8;
                            this.field_446 |= 2;
                            if (!var4.method_409() && (this.field_446 & 8160) != 0) {
                                var1.problemReporter().method_1501((LocalVariableBinding)var4, this);
                            }
                            var3 = var4.type;
                            this.constant = (this.field_446 & 8192) == 0 ? var4.constant() : Constant.NotAConstant;
                        } else {
                            var3 = this.method_1050(var1);
                        }
                        if (var3 != null) {
                            TypeBinding var10001 = (this.field_446 & 8192) == 0 ? var3.capture(var1, this.field_445) : var3;
                            var3 = var10001;
                            this.resolvedType = var10001;
                            if ((var3.tagBits & 128L) != 0L) {
                                if ((this.field_446 & 2) == 0) {
                                    var1.problemReporter().method_1639(this, var3);
                                }
                                return null;
                            }
                        }
                        return var3;
                    }
                    this.field_446 &= -8;
                    this.field_446 |= 4;
                case 4:
                    this.constant = Constant.NotAConstant;
                    TypeBinding var2 = (TypeBinding)this.field_748;
                    if (this.isTypeUseDeprecated(var2, var1)) {
                        var1.problemReporter().method_1516(var2, this);
                    }
                    var2 = var1.environment().convertToRawType(var2, false);
                    return this.resolvedType = var2;
                case 5:
                case 6:
            }
        }
        return this.resolvedType = this.method_1055(var1);
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        var1.visit(this, var2);
        var1.endVisit(this, var2);
    }
}
