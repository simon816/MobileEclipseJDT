package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.CastExpression;
import org.eclipse.jdt.internal.compiler.ast.Assignment;
import org.eclipse.jdt.internal.compiler.ast.CompoundAssignment;
import org.eclipse.jdt.internal.compiler.ast.Reference;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedThisReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedSuperReference;
import org.eclipse.jdt.internal.compiler.ast.NameReference;
import org.eclipse.jdt.internal.compiler.ast.IntLiteral;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.flow.UnconditionalFlowInfo;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;
import org.eclipse.jdt.internal.compiler.lookup.InvocationSite;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.ProblemReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodScope;
import org.eclipse.jdt.internal.compiler.problem.ProblemReporter;

public class FieldReference extends Reference implements InvocationSite {

    public Expression receiver;

    public char[] token;

    public FieldBinding binding;

    protected FieldBinding field_739;

    public MethodBinding[] syntheticAccessors;

    public long nameSourcePosition;

    public TypeBinding field_742;

    public TypeBinding field_743;

    public FieldReference(char[] var1, long var2) {
        this.token = var1;
        this.nameSourcePosition = var2;
        this.field_444 = (int)(var2 >>> 32);
        this.field_445 = (int)(var2 & 4294967295L);
        this.field_446 |= 1;
    }

    public FlowInfo analyseAssignment(BlockScope var1, FlowContext var2, FlowInfo var3, Assignment var4, boolean var5) {
        if (var5) {
            if (this.binding.method_408() && this.receiver.method_755() && var1.method_716(this.binding) && !var3.method_3082(this.binding)) {
                var1.problemReporter().method_1788(this.binding, this);
            }
            this.manageSyntheticAccessIfNecessary(var1, var3, true);
        }
        UnconditionalFlowInfo var6 = this.receiver.analyseCode(var1, var2, var3, !this.binding.method_431()).method_3109();
        if (var4.field_688 != null) {
            var6 = var4.field_688.analyseCode(var1, var2, var6).method_3109();
        }
        this.manageSyntheticAccessIfNecessary(var1, var6, false);
        if (this.binding.method_409()) {
            if (this.binding.method_408() && !var5 && this.receiver.method_755() && !(this.receiver instanceof QualifiedThisReference) && (this.receiver.field_446 & 534773760) == 0 && var1.method_706(this.binding)) {
                if (var6.method_3087(this.binding)) {
                    var1.problemReporter().duplicateInitializationOfBlankFinalField(this.binding, this);
                } else {
                    var2.recordSettingFinal(this.binding, this, var6);
                }
                var6.markAsDefinitelyAssigned(this.binding);
            } else {
                var1.problemReporter().method_1491(this.binding, this);
            }
        }
        return var6;
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        return this.analyseCode(var1, var2, var3, true);
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3, boolean var4) {
        boolean var5 = !this.binding.method_431();
        this.receiver.analyseCode(var1, var2, var3, var5);
        if (var5) {
            this.receiver.checkNPE(var1, var2, var3);
        }
        if (var4 || var1.compilerOptions().field_1927 >= 3145728L) {
            this.manageSyntheticAccessIfNecessary(var1, var3, true);
        }
        return var3;
    }

    public void computeConversion(Scope var1, TypeBinding var2, TypeBinding var3) {
        if (var2 != null && var3 != null) {
            if (this.binding != null && this.binding.isValidBinding()) {
                FieldBinding var4 = this.binding.original();
                TypeBinding var5 = var4.type;
                if (var4 != this.binding && var5 != this.binding.type && var2.id != 1 && (var5.tagBits & 536870912L) != 0L) {
                    TypeBinding var6 = !var3.method_148() && var2.method_148() ? var3 : var2;
                    this.field_743 = var4.type.method_141(var6);
                    if (this.field_743 instanceof ReferenceBinding) {
                        ReferenceBinding var7 = (ReferenceBinding)this.field_743;
                        if (!var7.canBeSeenBy(var1)) {
                            ProblemReporter var10000 = var1.problemReporter();
                            ProblemReferenceBinding var10002 = new ProblemReferenceBinding(CharOperation.method_1385('.', var7.shortReadableName()), var7, 2);
                            var10000.method_1639(this, var10002);
                        }
                    }
                }
            }
            super.computeConversion(var1, var2, var3);
        }
    }

    public FieldBinding fieldBinding() {
        return this.binding;
    }

    public void generateAssignment(BlockScope var1, CodeStream var2, Assignment var3, boolean var4) {
        int var5 = var2.field_1208;
        this.receiver.generateCode(var1, var2, !this.field_739.method_431());
        var2.method_2360(var5, this.field_444);
        var3.field_688.generateCode(var1, var2, true);
        this.method_1037(var2, this.field_739, this.syntheticAccessors == null ? null : this.syntheticAccessors[1], var4);
        if (var4) {
            var2.method_2182(var3.field_674);
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
            boolean var5 = this.field_739.method_431();
            boolean var6 = this.receiver instanceof ThisReference;
            Constant var7 = this.field_739.constant();
            if (var7 != Constant.NotAConstant) {
                if (!var6) {
                    this.receiver.generateCode(var1, var2, !var5);
                    if (!var5) {
                        var2.method_2271();
                        var2.method_2352();
                    }
                }
                if (var3) {
                    var2.generateConstant(var7, this.field_674);
                }
                var2.method_2360(var4, this.field_444);
            } else {
                if (!var3 && (var6 || var1.compilerOptions().field_1927 < 3145728L) && (this.field_674 & 1024) == 0 && this.field_743 == null) {
                    if (var6) {
                        if (var5 && this.binding.original().declaringClass != this.field_742.erasure()) {
                            MethodBinding var9 = this.syntheticAccessors == null ? null : this.syntheticAccessors[0];
                            if (var9 == null) {
                                var2.method_2207(this.field_739);
                            } else {
                                var2.method_2273(var9);
                            }
                            switch (this.field_739.type.id) {
                                case 7:
                                case 8:
                                    var2.method_2353();
                                    break;
                                default:
                                    var2.method_2352();
                            }
                        }
                    } else {
                        this.receiver.generateCode(var1, var2, !var5);
                        if (!var5) {
                            var2.method_2271();
                            var2.method_2352();
                        }
                    }
                } else {
                    this.receiver.generateCode(var1, var2, !var5);
                    var4 = var2.field_1208;
                    if (this.field_739.declaringClass == null) {
                        var2.method_2101();
                        if (var3) {
                            var2.method_2182(this.field_674);
                        } else {
                            var2.method_2352();
                        }
                    } else {
                        if (this.syntheticAccessors != null && this.syntheticAccessors[0] != null) {
                            var2.method_2273(this.syntheticAccessors[0]);
                        } else if (var5) {
                            var2.method_2207(this.field_739);
                        } else {
                            var2.method_2205(this.field_739);
                        }
                        if (this.field_743 != null) {
                            var2.method_2113(this.field_743);
                        }
                        if (var3) {
                            var2.method_2182(this.field_674);
                        } else {
                            boolean var8 = (this.field_674 & 1024) != 0;
                            if (var8) {
                                var2.method_2182(this.field_674);
                            }
                            switch (var8 ? this.postConversionType(var1).id : this.field_739.type.id) {
                                case 7:
                                case 8:
                                    var2.method_2353();
                                    break;
                                default:
                                    var2.method_2352();
                            }
                        }
                    }
                }
                var2.method_2360(var4, this.field_445);
            }
        }
    }

    public void generateCompoundAssignment(BlockScope var1, CodeStream var2, Expression var3, int var4, int var5, boolean var6) {
        boolean var7;
        this.receiver.generateCode(var1, var2, !(var7 = this.field_739.method_431()));
        if (var7) {
            if (this.syntheticAccessors != null && this.syntheticAccessors[0] != null) {
                var2.method_2273(this.syntheticAccessors[0]);
            } else {
                var2.method_2207(this.field_739);
            }
        } else {
            var2.method_2141();
            if (this.syntheticAccessors != null && this.syntheticAccessors[0] != null) {
                var2.method_2273(this.syntheticAccessors[0]);
            } else {
                var2.method_2205(this.field_739);
            }
        }
        int var8;
        switch (var8 = (this.field_674 & 255) >> 4) {
            case 0:
            case 1:
            case 11:
                var2.generateStringConcatenationAppend(var1, (Expression)null, var3);
                break;
            default:
                if (this.field_743 != null) {
                    var2.method_2113(this.field_743);
                }
                var2.method_2182(this.field_674);
                if (var3 == IntLiteral.One) {
                    var2.generateConstant(var3.constant, this.field_674);
                } else {
                    var3.generateCode(var1, var2, true);
                }
                var2.method_2374(var4, var8);
                var2.method_2182(var5);
        }
        this.method_1037(var2, this.field_739, this.syntheticAccessors == null ? null : this.syntheticAccessors[1], var6);
    }

    public void generatePostIncrement(BlockScope var1, CodeStream var2, CompoundAssignment var3, boolean var4) {
        boolean var5;
        this.receiver.generateCode(var1, var2, !(var5 = this.field_739.method_431()));
        if (var5) {
            if (this.syntheticAccessors != null && this.syntheticAccessors[0] != null) {
                var2.method_2273(this.syntheticAccessors[0]);
            } else {
                var2.method_2207(this.field_739);
            }
        } else {
            var2.method_2141();
            if (this.syntheticAccessors != null && this.syntheticAccessors[0] != null) {
                var2.method_2273(this.syntheticAccessors[0]);
            } else {
                var2.method_2205(this.field_739);
            }
        }
        if (var4) {
            if (var5) {
                if (this.field_739.type != TypeBinding.field_183 && this.field_739.type != TypeBinding.field_185) {
                    var2.method_2141();
                } else {
                    var2.method_2144();
                }
            } else if (this.field_739.type != TypeBinding.field_183 && this.field_739.type != TypeBinding.field_185) {
                var2.method_2142();
            } else {
                var2.method_2145();
            }
        }
        if (this.field_743 != null) {
            var2.method_2113(this.field_743);
        }
        var2.method_2182(this.field_674);
        var2.generateConstant(var3.field_688.constant, this.field_674);
        var2.method_2374(var3.field_689, this.field_674 & 15);
        var2.method_2182(var3.field_690);
        this.method_1037(var2, this.field_739, this.syntheticAccessors == null ? null : this.syntheticAccessors[1], false);
    }

    public TypeBinding[] genericTypeArguments() {
        return null;
    }

    public boolean isSuperAccess() {
        return this.receiver.method_754();
    }

    public void manageSyntheticAccessIfNecessary(BlockScope var1, FlowInfo var2, boolean var3) {
        if ((var2.tagBits & 1) == 0) {
            this.field_739 = this.binding.original();
            if (this.binding.method_428()) {
                if (var1.enclosingSourceType() != this.field_739.declaringClass && this.binding.constant() == Constant.NotAConstant) {
                    if (this.syntheticAccessors == null) {
                        this.syntheticAccessors = new MethodBinding[2];
                    }
                    this.syntheticAccessors[var3 ? 0 : 1] = ((SourceTypeBinding)this.field_739.declaringClass).method_298(this.field_739, var3);
                    var1.problemReporter().needToEmulateFieldAccess(this.field_739, this, var3);
                    return;
                }
            } else {
                SourceTypeBinding var4;
                if (this.receiver instanceof QualifiedSuperReference) {
                    var4 = (SourceTypeBinding)((SourceTypeBinding)((QualifiedSuperReference)this.receiver).currentCompatibleType);
                    if (this.syntheticAccessors == null) {
                        this.syntheticAccessors = new MethodBinding[2];
                    }
                    this.syntheticAccessors[var3 ? 0 : 1] = var4.method_298(this.field_739, var3);
                    var1.problemReporter().needToEmulateFieldAccess(this.field_739, this, var3);
                    return;
                }
                if (this.binding.method_429() && (this.field_446 & 8160) != 0 && this.binding.declaringClass.getPackage() != (var4 = var1.enclosingSourceType()).getPackage()) {
                    SourceTypeBinding var5 = (SourceTypeBinding)var4.enclosingTypeAt((this.field_446 & 8160) >> 5);
                    if (this.syntheticAccessors == null) {
                        this.syntheticAccessors = new MethodBinding[2];
                    }
                    this.syntheticAccessors[var3 ? 0 : 1] = var5.method_298(this.field_739, var3);
                    var1.problemReporter().needToEmulateFieldAccess(this.field_739, this, var3);
                    return;
                }
            }
            if (this.binding.declaringClass != this.field_742 && !this.field_742.method_147() && this.binding.declaringClass != null && this.binding.constant() == Constant.NotAConstant) {
                CompilerOptions var6 = var1.compilerOptions();
                if (var6.field_1929 >= 3014656L && (var6.field_1927 >= 3145728L || !this.receiver.method_752() || !this.field_739.method_431()) && this.binding.declaringClass.id != 1 || !this.binding.declaringClass.canBeSeenBy(var1)) {
                    this.field_739 = var1.enclosingSourceType().method_311(this.field_739, (ReferenceBinding)this.field_742.erasure());
                }
            }
        }
    }

    public int nullStatus(FlowInfo var1) {
        return 0;
    }

    public Constant optimizedBooleanConstant() {
        switch (this.resolvedType.id) {
            case 5:
            case 33:
                return this.constant != Constant.NotAConstant ? this.constant : this.binding.constant();
            default:
                return Constant.NotAConstant;
        }
    }

    public TypeBinding postConversionType(Scope var1) {
        Object var2 = this.resolvedType;
        if (this.field_743 != null) {
            var2 = this.field_743;
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
        return this.receiver.printExpression(0, var2).append('.').append(this.token);
    }

    public TypeBinding resolveType(BlockScope var1) {
        boolean var2 = false;
        if (this.receiver instanceof CastExpression) {
            this.receiver.field_446 |= 32;
            var2 = true;
        }
        this.field_742 = this.receiver.resolveType(var1);
        if (this.field_742 == null) {
            this.constant = Constant.NotAConstant;
            return null;
        } else {
            if (var2 && ((CastExpression)this.receiver).field_684.resolvedType == this.field_742) {
                var1.problemReporter().unnecessaryCast((CastExpression)this.receiver);
            }
            FieldBinding var3 = this.field_739 = this.binding = var1.method_601(this.field_742, this.token, this);
            if (!var3.isValidBinding()) {
                this.constant = Constant.NotAConstant;
                if (this.receiver.resolvedType instanceof ProblemReferenceBinding) {
                    return null;
                } else {
                    var1.problemReporter().invalidField(this, this.field_742);
                    return null;
                }
            } else {
                TypeBinding var4 = this.field_742.erasure();
                if (var4 instanceof ReferenceBinding && var4.method_140(var3.declaringClass) == null) {
                    this.field_742 = var3.declaringClass;
                }
                this.receiver.computeConversion(var1, this.field_742, this.field_742);
                if (this.isFieldUseDeprecated(var3, var1, (this.field_446 & 8192) != 0)) {
                    var1.problemReporter().method_1514(var3, this);
                }
                boolean var5 = this.receiver.method_752();
                this.constant = var5 ? var3.constant() : Constant.NotAConstant;
                if (var3.method_431()) {
                    if (!var5 && (!(this.receiver instanceof NameReference) || (((NameReference)this.receiver).field_446 & 4) == 0)) {
                        var1.problemReporter().method_1703(this, var3);
                    }
                    ReferenceBinding var6 = this.binding.declaringClass;
                    if (!var5 && var6 != this.field_742 && var6.canBeSeenBy(var1)) {
                        var1.problemReporter().method_1612(this, var3);
                    }
                    if (var6.method_153()) {
                        MethodScope var7 = var1.method_635();
                        SourceTypeBinding var8 = var1.enclosingSourceType();
                        if (this.constant == Constant.NotAConstant && !var7.field_404 && (var8 == var6 || var8.superclass == var6) && var7.method_728()) {
                            var1.problemReporter().method_1543(this.binding, this);
                        }
                    }
                }
                TypeBinding var9 = var3.type;
                if (var9 != null) {
                    if ((this.field_446 & 8192) == 0) {
                        var9 = var9.capture(var1, this.field_445);
                    }
                    this.resolvedType = var9;
                    if ((var9.tagBits & 128L) != 0L) {
                        var1.problemReporter().method_1639(this, var9);
                        return null;
                    }
                }
                return var9;
            }
        }
    }

    public void setActualReceiverType(ReferenceBinding var1) {}

    public void method_2(int var1) {
        this.field_446 &= -8161;
        if (var1 > 0) {
            this.field_446 |= (var1 & 255) << 5;
        }
    }

    public void setFieldIndex(int var1) {}

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            this.receiver.traverse(var1, var2);
        }
        var1.endVisit(this, var2);
    }
}
