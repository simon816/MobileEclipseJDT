package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.BinaryExpression;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.codegen.BranchLabel;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.flow.UnconditionalFlowInfo;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class OR_OR_Expression extends BinaryExpression {

    int field_724;

    int field_725;

    public OR_OR_Expression(Expression var1, Expression var2, int var3) {
        super(var1, var2, var3);
        this.field_724 = -1;
        this.field_725 = -1;
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        Constant var4 = this.field_715.optimizedBooleanConstant();
        boolean var5 = var4 != Constant.NotAConstant && var4.booleanValue();
        boolean var6 = var4 != Constant.NotAConstant && !var4.booleanValue();
        FlowInfo var7;
        if (var6) {
            UnconditionalFlowInfo var11 = this.field_715.analyseCode(var1, var2, var3).method_3109();
            var7 = this.field_716.analyseCode(var1, var2, var11);
            this.field_725 = var1.method_635().recordInitializationStates(var7);
            return var7;
        } else {
            var7 = this.field_715.analyseCode(var1, var2, var3);
            UnconditionalFlowInfo var8 = var7.method_3080().method_3107();
            this.field_724 = var1.method_635().recordInitializationStates(var8);
            int var9 = var8.reachMode();
            if (var5) {
                var8.setReachMode(1);
            }
            FlowInfo var12 = this.field_716.analyseCode(var1, var2, var8);
            FlowInfo var10 = FlowInfo.conditional(var7.method_3081().method_3109().mergedWith(var12.method_3103().setReachMode(var9).method_3109()), var12.method_3080());
            this.field_725 = var1.method_635().recordInitializationStates(var10);
            return var10;
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
            Constant var5 = this.field_716.constant;
            if (var5 != Constant.NotAConstant) {
                if (var5.booleanValue()) {
                    this.field_715.generateCode(var1, var2, false);
                    if (var3) {
                        var2.method_2222();
                    }
                } else {
                    this.field_715.generateCode(var1, var2, var3);
                }
                if (this.field_725 != -1) {
                    var2.method_2363(var1, this.field_725);
                }
                var2.method_2182(this.field_674);
                var2.method_2380(var1, var2.field_1208);
                var2.method_2360(var4, this.field_444);
            } else {
                BranchLabel var6;
                boolean var8;
                boolean var9;
                boolean var10;
                boolean var11;
                label108: {
                    BranchLabel var10000 = new BranchLabel(var2);
                    var6 = var10000;
                    var5 = this.field_715.optimizedBooleanConstant();
                    var8 = var5 != Constant.NotAConstant;
                    var9 = var8 && var5.booleanValue();
                    var5 = this.field_716.optimizedBooleanConstant();
                    var10 = var5 != Constant.NotAConstant;
                    var11 = var10 && var5.booleanValue();
                    if (var8) {
                        this.field_715.generateCode(var1, var2, false);
                        if (var9) {
                            break label108;
                        }
                    } else {
                        this.field_715.generateOptimizedBoolean(var1, var2, var6, (BranchLabel)null, true);
                    }
                    if (this.field_724 != -1) {
                        var2.method_2088(var1, this.field_724);
                    }
                    if (var10) {
                        this.field_716.generateCode(var1, var2, false);
                    } else {
                        this.field_716.generateOptimizedBoolean(var1, var2, var6, (BranchLabel)null, var3);
                    }
                }
                if (this.field_725 != -1) {
                    var2.method_2363(var1, this.field_725);
                }
                if (var3) {
                    if (var8 && var9) {
                        var2.method_2222();
                        var2.method_2380(var1, var2.field_1208);
                    } else {
                        if (var10 && var11) {
                            var2.method_2222();
                            var2.method_2380(var1, var2.field_1208);
                        } else {
                            var2.method_2221();
                        }
                        if (var6.forwardReferenceCount() > 0) {
                            if ((this.field_446 & 16) != 0) {
                                var2.method_2182(this.field_674);
                                var2.generateReturnBytecode(this);
                                var6.place();
                                var2.method_2222();
                            } else {
                                BranchLabel var10001 = new BranchLabel(var2);
                                BranchLabel var7 = var10001;
                                var2.method_2209(var10001);
                                var2.method_2125(1);
                                var6.place();
                                var2.method_2222();
                                var7.place();
                            }
                        } else {
                            var6.place();
                        }
                    }
                    var2.method_2182(this.field_674);
                    var2.method_2380(var1, var2.field_1208);
                } else {
                    var6.place();
                }
            }
        }
    }

    public void generateOptimizedBoolean(BlockScope var1, CodeStream var2, BranchLabel var3, BranchLabel var4, boolean var5) {
        if (this.constant != Constant.NotAConstant) {
            super.generateOptimizedBoolean(var1, var2, var3, var4, var5);
        } else {
            Constant var6 = this.field_716.constant;
            if (var6 != Constant.NotAConstant && !var6.booleanValue()) {
                int var12 = var2.field_1208;
                this.field_715.generateOptimizedBoolean(var1, var2, var3, var4, var5);
                if (this.field_725 != -1) {
                    var2.method_2363(var1, this.field_725);
                }
                var2.method_2360(var12, this.field_444);
            } else {
                var6 = this.field_715.optimizedBooleanConstant();
                boolean var7 = var6 != Constant.NotAConstant;
                boolean var8 = var7 && var6.booleanValue();
                var6 = this.field_716.optimizedBooleanConstant();
                boolean var9 = var6 != Constant.NotAConstant;
                boolean var10 = var9 && var6.booleanValue();
                if (var4 == null) {
                    if (var3 != null) {
                        this.field_715.generateOptimizedBoolean(var1, var2, var3, (BranchLabel)null, !var7);
                        if (var8) {
                            if (var5) {
                                var2.method_2209(var3);
                            }
                            var2.method_2380(var1, var2.field_1208);
                        } else {
                            if (this.field_724 != -1) {
                                var2.method_2088(var1, this.field_724);
                            }
                            this.field_716.generateOptimizedBoolean(var1, var2, var3, (BranchLabel)null, var5 && !var9);
                            if (var5 && var10) {
                                var2.method_2209(var3);
                                var2.method_2380(var1, var2.field_1208);
                            }
                        }
                    }
                } else if (var3 == null) {
                    BranchLabel var10000 = new BranchLabel(var2);
                    BranchLabel var11 = var10000;
                    this.field_715.generateOptimizedBoolean(var1, var2, var11, (BranchLabel)null, !var7);
                    if (var8) {
                        var11.place();
                    } else {
                        if (this.field_724 != -1) {
                            var2.method_2088(var1, this.field_724);
                        }
                        this.field_716.generateOptimizedBoolean(var1, var2, (BranchLabel)null, var4, var5 && !var9);
                        if (var5 && var9 && !var10) {
                            var2.method_2209(var4);
                            var2.method_2380(var1, var2.field_1208);
                        }
                        var11.place();
                    }
                }
                if (this.field_725 != -1) {
                    var2.method_2363(var1, this.field_725);
                }
            }
        }
    }

    public boolean isCompactableOperation() {
        return false;
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            this.field_715.traverse(var1, var2);
            this.field_716.traverse(var1, var2);
        }
        var1.endVisit(this, var2);
    }
}
