package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.CastExpression;
import org.eclipse.jdt.internal.compiler.ast.OperatorExpression;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.codegen.BranchLabel;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.flow.UnconditionalFlowInfo;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.BaseTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class ConditionalExpression extends OperatorExpression {

    public Expression field_702;

    public Expression field_703;

    public Expression field_704;

    public Constant field_705;

    public Constant field_706;

    public Constant field_707;

    int field_708;

    int field_709;

    int field_710;

    public ConditionalExpression(Expression var1, Expression var2, Expression var3) {
        this.field_708 = -1;
        this.field_709 = -1;
        this.field_710 = -1;
        this.field_702 = var1;
        this.field_703 = var2;
        this.field_704 = var3;
        this.field_444 = var1.field_444;
        this.field_445 = var3.field_445;
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        Constant var4 = this.field_702.optimizedBooleanConstant();
        boolean var5 = var4 != Constant.NotAConstant && var4.booleanValue();
        boolean var6 = var4 != Constant.NotAConstant && !var4.booleanValue();
        int var7 = var3.reachMode();
        var3 = this.field_702.analyseCode(var1, var2, var3, var4 == Constant.NotAConstant);
        FlowInfo var8 = var3.method_3081().method_3078();
        if (var6) {
            var8.setReachMode(1);
        }
        this.field_708 = var1.method_635().recordInitializationStates(var8);
        var8 = this.field_703.analyseCode(var1, var2, var8);
        FlowInfo var9 = var3.method_3080().method_3078();
        if (var5) {
            var9.setReachMode(1);
        }
        this.field_709 = var1.method_635().recordInitializationStates(var9);
        var9 = this.field_704.analyseCode(var1, var2, var9);
        FlowInfo var10;
        if (var5) {
            var10 = var8.method_3072(var9);
        } else if (var6) {
            var10 = var9.method_3072(var8);
        } else {
            var4 = this.field_706;
            boolean var11 = var4 != null && var4 != Constant.NotAConstant && var4.booleanValue();
            boolean var12 = var4 != null && var4 != Constant.NotAConstant && !var4.booleanValue();
            var4 = this.field_707;
            boolean var13 = var4 != null && var4 != Constant.NotAConstant && var4.booleanValue();
            boolean var14 = var4 != null && var4 != Constant.NotAConstant && !var4.booleanValue();
            UnconditionalFlowInfo var15 = var8.method_3081().method_3107();
            UnconditionalFlowInfo var16 = var9.method_3081().method_3107();
            UnconditionalFlowInfo var17 = var8.method_3080().method_3109();
            UnconditionalFlowInfo var18 = var9.method_3080().method_3109();
            if (var12) {
                var15.setReachMode(1);
            }
            if (var14) {
                var16.setReachMode(1);
            }
            if (var11) {
                var17.setReachMode(1);
            }
            if (var13) {
                var18.setReachMode(1);
            }
            var10 = FlowInfo.conditional(var15.mergedWith(var16), var17.mergedWith(var18));
        }
        this.field_710 = var1.method_635().recordInitializationStates(var10);
        var10.setReachMode(var7);
        return var10;
    }

    public void generateCode(BlockScope var1, CodeStream var2, boolean var3) {
        int var4 = var2.field_1208;
        if (this.constant != Constant.NotAConstant) {
            if (var3) {
                var2.generateConstant(this.constant, this.field_674);
            }
            var2.method_2360(var4, this.field_444);
        } else {
            Constant var7 = this.field_702.optimizedBooleanConstant();
            boolean var8 = var7 == Constant.NotAConstant || var7.booleanValue();
            boolean var9 = var7 == Constant.NotAConstant || !var7.booleanValue();
            BranchLabel var10000 = new BranchLabel(var2);
            BranchLabel var5 = var10000;
            var10000 = new BranchLabel(var2);
            BranchLabel var6 = var10000;
            var6.tagBits |= 2;
            this.field_702.generateOptimizedBoolean(var1, var2, (BranchLabel)null, var6, var7 == Constant.NotAConstant);
            if (this.field_708 != -1) {
                var2.method_2363(var1, this.field_708);
                var2.method_2088(var1, this.field_708);
            }
            if (var8) {
                this.field_703.generateCode(var1, var2, var3);
                if (var9) {
                    int var10 = var2.field_1208;
                    var2.method_2209(var5);
                    var2.method_2380(var1, var10);
                    if (var3) {
                        var2.method_2125(this.resolvedType != TypeBinding.field_183 && this.resolvedType != TypeBinding.field_185 ? 1 : 2);
                    }
                }
            }
            if (var9) {
                if (this.field_709 != -1) {
                    var2.method_2363(var1, this.field_709);
                    var2.method_2088(var1, this.field_709);
                }
                if (var6.forwardReferenceCount() > 0) {
                    var6.place();
                }
                this.field_704.generateCode(var1, var2, var3);
                if (var3) {
                    var2.method_2359(this.resolvedType);
                }
                if (var8) {
                    var5.place();
                }
            }
            if (this.field_710 != -1) {
                var2.method_2363(var1, this.field_710);
            }
            if (var3) {
                var2.method_2182(this.field_674);
            }
            var2.method_2360(var4, this.field_444);
        }
    }

    public void generateOptimizedBoolean(BlockScope var1, CodeStream var2, BranchLabel var3, BranchLabel var4, boolean var5) {
        if ((this.constant == Constant.NotAConstant || this.constant.typeID() != 5) && (this.field_703.field_674 & 255) >> 4 == 5) {
            Constant var6 = this.field_702.constant;
            Constant var7 = this.field_702.optimizedBooleanConstant();
            boolean var8 = (var6 == Constant.NotAConstant || var6.booleanValue()) && (var7 == Constant.NotAConstant || var7.booleanValue());
            boolean var9 = (var6 == Constant.NotAConstant || !var6.booleanValue()) && (var7 == Constant.NotAConstant || !var7.booleanValue());
            BranchLabel var10000 = new BranchLabel(var2);
            BranchLabel var11 = var10000;
            boolean var12 = var6 == Constant.NotAConstant && var7 == Constant.NotAConstant;
            Expression var14 = this.field_702;
            BranchLabel var10004 = new BranchLabel(var2);
            BranchLabel var10 = var10004;
            var14.generateOptimizedBoolean(var1, var2, (BranchLabel)null, var10004, var12);
            if (this.field_708 != -1) {
                var2.method_2363(var1, this.field_708);
                var2.method_2088(var1, this.field_708);
            }
            if (var8) {
                this.field_703.generateOptimizedBoolean(var1, var2, var3, var4, var5);
                if (var9) {
                    label79: {
                        boolean var13;
                        if (var4 == null) {
                            if (var3 != null) {
                                var6 = this.field_706;
                                var13 = var6 != null && var6 != Constant.NotAConstant && var6.booleanValue();
                                if (var13) {
                                    break label79;
                                }
                            }
                        } else if (var3 == null) {
                            var6 = this.field_706;
                            var13 = var6 != null && var6 != Constant.NotAConstant && !var6.booleanValue();
                            if (var13) {
                                break label79;
                            }
                        }
                        int var15 = var2.field_1208;
                        var2.method_2209(var11);
                        var2.method_2380(var1, var15);
                    }
                }
            }
            if (var9) {
                var10.place();
                if (this.field_709 != -1) {
                    var2.method_2363(var1, this.field_709);
                    var2.method_2088(var1, this.field_709);
                }
                this.field_704.generateOptimizedBoolean(var1, var2, var3, var4, var5);
                var11.place();
            }
            if (this.field_710 != -1) {
                var2.method_2363(var1, this.field_710);
            }
            var2.method_2380(var1, var2.field_1208);
        } else {
            super.generateOptimizedBoolean(var1, var2, var3, var4, var5);
        }
    }

    public int nullStatus(FlowInfo var1) {
        Constant var2 = this.field_702.optimizedBooleanConstant();
        if (var2 != Constant.NotAConstant) {
            return var2.booleanValue() ? this.field_703.nullStatus(var1) : this.field_704.nullStatus(var1);
        } else {
            int var3 = this.field_703.nullStatus(var1);
            int var4 = this.field_704.nullStatus(var1);
            return var3 == var4 ? var3 : 0;
        }
    }

    public Constant optimizedBooleanConstant() {
        return this.field_705 == null ? this.constant : this.field_705;
    }

    public StringBuffer printExpressionNoParenthesis(int var1, StringBuffer var2) {
        this.field_702.printExpression(var1, var2).append(" ? ");
        this.field_703.printExpression(0, var2).append(" : ");
        return this.field_704.printExpression(0, var2);
    }

    public TypeBinding resolveType(BlockScope var1) {
        this.constant = Constant.NotAConstant;
        LookupEnvironment var2 = var1.environment();
        boolean var3 = var1.compilerOptions().field_1928 >= 3211264L;
        TypeBinding var4 = this.field_702.resolveTypeExpecting(var1, TypeBinding.field_186);
        this.field_702.computeConversion(var1, TypeBinding.field_186, var4);
        if (this.field_703 instanceof CastExpression) {
            this.field_703.field_446 |= 32;
        }
        TypeBinding var5 = this.field_703.resolveType(var1);
        if (this.field_704 instanceof CastExpression) {
            this.field_704.field_446 |= 32;
        }
        TypeBinding var6 = this.field_704.resolveType(var1);
        if (var4 != null && var5 != null && var6 != null) {
            TypeBinding var7 = var5;
            TypeBinding var8 = var6;
            if (var3 && var5 != var6) {
                TypeBinding var9;
                if (var5.method_148()) {
                    if (var6.method_148()) {
                        if (var5 == TypeBinding.field_187) {
                            var8 = var2.method_486(var6);
                        } else if (var6 == TypeBinding.field_187) {
                            var7 = var2.method_486(var5);
                        }
                    } else {
                        var9 = var6.method_148() ? var6 : var2.method_486(var6);
                        if (var5.method_161() && var9.method_161()) {
                            var8 = var9;
                        } else if (var5 != TypeBinding.field_187) {
                            var8 = var2.method_486(var6);
                        }
                    }
                } else if (var6.method_148()) {
                    var9 = var5.method_148() ? var5 : var2.method_486(var5);
                    if (var9.method_161() && var6.method_161()) {
                        var7 = var9;
                    } else if (var6 != TypeBinding.field_187) {
                        var7 = var2.method_486(var5);
                    }
                } else {
                    var9 = var2.method_486(var5);
                    TypeBinding var10 = var2.method_486(var6);
                    if (var9.method_161() && var10.method_161()) {
                        var7 = var9;
                        var8 = var10;
                    }
                }
            }
            Constant var13 = this.field_702.constant;
            if (this.field_702.constant != Constant.NotAConstant) {
                Constant var14 = this.field_703.constant;
                if (this.field_703.constant != Constant.NotAConstant) {
                    Constant var11 = this.field_704.constant;
                    if (this.field_704.constant != Constant.NotAConstant) {
                        this.constant = var13.booleanValue() ? var14 : var11;
                    }
                }
            }
            if (var7 == var8) {
                this.field_703.computeConversion(var1, var7, var5);
                this.field_704.computeConversion(var1, var8, var6);
                if (var7 == TypeBinding.field_186) {
                    this.field_706 = this.field_703.optimizedBooleanConstant();
                    this.field_707 = this.field_704.optimizedBooleanConstant();
                    if (this.field_706 != Constant.NotAConstant && this.field_707 != Constant.NotAConstant && this.field_706.booleanValue() == this.field_707.booleanValue()) {
                        this.field_705 = this.field_706;
                    } else if ((var13 = this.field_702.optimizedBooleanConstant()) != Constant.NotAConstant) {
                        this.field_705 = var13.booleanValue() ? this.field_706 : this.field_707;
                    }
                }
                return this.resolvedType = var7;
            } else if (var7.method_161() && var8.method_161()) {
                if ((var7 != TypeBinding.field_180 || var8 != TypeBinding.field_181) && (var7 != TypeBinding.field_181 || var8 != TypeBinding.field_180)) {
                    if ((var7 == TypeBinding.field_180 || var7 == TypeBinding.field_181 || var7 == TypeBinding.field_182) && var8 == TypeBinding.field_179 && this.field_704.isConstantValueOfTypeAssignableToType(var8, var7)) {
                        this.field_703.computeConversion(var1, var7, var5);
                        this.field_704.computeConversion(var1, var7, var6);
                        return this.resolvedType = var7;
                    } else if ((var8 == TypeBinding.field_180 || var8 == TypeBinding.field_181 || var8 == TypeBinding.field_182) && var7 == TypeBinding.field_179 && this.field_703.isConstantValueOfTypeAssignableToType(var7, var8)) {
                        this.field_703.computeConversion(var1, var8, var5);
                        this.field_704.computeConversion(var1, var8, var6);
                        return this.resolvedType = var8;
                    } else if (BaseTypeBinding.method_184(var7.id, 10) && BaseTypeBinding.method_184(var8.id, 10)) {
                        this.field_703.computeConversion(var1, TypeBinding.field_179, var5);
                        this.field_704.computeConversion(var1, TypeBinding.field_179, var6);
                        return this.resolvedType = TypeBinding.field_179;
                    } else if (BaseTypeBinding.method_184(var7.id, 7) && BaseTypeBinding.method_184(var8.id, 7)) {
                        this.field_703.computeConversion(var1, TypeBinding.field_183, var5);
                        this.field_704.computeConversion(var1, TypeBinding.field_183, var6);
                        return this.resolvedType = TypeBinding.field_183;
                    } else if (BaseTypeBinding.method_184(var7.id, 9) && BaseTypeBinding.method_184(var8.id, 9)) {
                        this.field_703.computeConversion(var1, TypeBinding.field_184, var5);
                        this.field_704.computeConversion(var1, TypeBinding.field_184, var6);
                        return this.resolvedType = TypeBinding.field_184;
                    } else {
                        this.field_703.computeConversion(var1, TypeBinding.field_185, var5);
                        this.field_704.computeConversion(var1, TypeBinding.field_185, var6);
                        return this.resolvedType = TypeBinding.field_185;
                    }
                } else {
                    this.field_703.computeConversion(var1, TypeBinding.field_181, var5);
                    this.field_704.computeConversion(var1, TypeBinding.field_181, var6);
                    return this.resolvedType = TypeBinding.field_181;
                }
            } else {
                if (var7.method_148() && var7 != TypeBinding.field_187) {
                    if (!var3) {
                        var1.problemReporter().conditionalArgumentsIncompatibleTypes(this, var7, var8);
                        return null;
                    }
                    var7 = var2.method_486(var7);
                }
                if (var8.method_148() && var8 != TypeBinding.field_187) {
                    if (!var3) {
                        var1.problemReporter().conditionalArgumentsIncompatibleTypes(this, var7, var8);
                        return null;
                    }
                    var8 = var2.method_486(var8);
                }
                if (var3) {
                    TypeBinding var12 = null;
                    if (var7 == TypeBinding.field_187) {
                        var12 = var8;
                    } else if (var8 == TypeBinding.field_187) {
                        var12 = var7;
                    } else {
                        var12 = var1.lowerUpperBound(new TypeBinding[] {var7, var8});
                    }
                    if (var12 != null) {
                        this.field_703.computeConversion(var1, var12, var5);
                        this.field_704.computeConversion(var1, var12, var6);
                        return this.resolvedType = var12.capture(var1, this.field_445);
                    }
                } else {
                    if (var8.isCompatibleWith(var7)) {
                        this.field_703.computeConversion(var1, var7, var5);
                        this.field_704.computeConversion(var1, var7, var6);
                        return this.resolvedType = var7;
                    }
                    if (var7.isCompatibleWith(var8)) {
                        this.field_703.computeConversion(var1, var8, var5);
                        this.field_704.computeConversion(var1, var8, var6);
                        return this.resolvedType = var8;
                    }
                }
                var1.problemReporter().conditionalArgumentsIncompatibleTypes(this, var7, var8);
                return null;
            }
        } else {
            return null;
        }
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            this.field_702.traverse(var1, var2);
            this.field_703.traverse(var1, var2);
            this.field_704.traverse(var1, var2);
        }
        var1.endVisit(this, var2);
    }
}
