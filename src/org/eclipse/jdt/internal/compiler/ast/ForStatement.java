package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.EmptyStatement;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.codegen.BranchLabel;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.LoopingFlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.flow.UnconditionalFlowInfo;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class ForStatement extends Statement {

    public Statement[] field_530;

    public Expression condition;

    public Statement[] field_532;

    public Statement action;

    public BlockScope scope;

    private BranchLabel field_535;

    private BranchLabel field_536;

    int field_537;

    int field_538;

    int field_539;

    int field_540;

    public ForStatement(Statement[] var1, Expression var2, Statement[] var3, Statement var4, boolean var5, int var6, int var7) {
        this.field_537 = -1;
        this.field_538 = -1;
        this.field_539 = -1;
        this.field_540 = -1;
        this.field_444 = var6;
        this.field_445 = var7;
        this.field_530 = var1;
        this.condition = var2;
        this.field_532 = var3;
        this.action = var4;
        if (var4 instanceof EmptyStatement) {
            var4.field_446 |= 1;
        }
        if (var5) {
            this.field_446 |= 536870912;
        }
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        BranchLabel var10001 = new BranchLabel();
        this.field_535 = var10001;
        var10001 = new BranchLabel();
        this.field_536 = var10001;
        if (this.field_530 != null) {
            int var4 = 0;
            for (int var5 = this.field_530.length; var4 < var5; ++var4) {
                var3 = this.field_530[var4].analyseCode(this.scope, var2, var3);
            }
        }
        this.field_537 = var1.method_635().recordInitializationStates(var3);
        Constant var20 = this.condition == null ? null : this.condition.constant;
        boolean var21 = var20 == null || var20 != Constant.NotAConstant && var20.booleanValue();
        boolean var6 = var20 != null && var20 != Constant.NotAConstant && !var20.booleanValue();
        var20 = this.condition == null ? null : this.condition.optimizedBooleanConstant();
        boolean var7 = var20 == null || var20 != Constant.NotAConstant && var20.booleanValue();
        boolean var8 = var20 != null && var20 != Constant.NotAConstant && !var20.booleanValue();
        LoopingFlowContext var9 = null;
        Object var10 = var3.method_3106();
        if (this.condition != null && !var21) {
            Expression var10000 = this.condition;
            BlockScope var18 = this.scope;
            LoopingFlowContext var10002 = new LoopingFlowContext(var2, var3, this, (BranchLabel)null, (BranchLabel)null, this.scope);
            var9 = var10002;
            var10 = var10000.analyseCode(var18, var10002, (FlowInfo)var10);
        }
        LoopingFlowContext var11;
        UnconditionalFlowInfo var12;
        FlowInfo var13;
        LoopingFlowContext var19;
        if (this.action != null && (!this.action.isEmptyBlock() || var1.compilerOptions().field_1927 > 3080192L)) {
            var19 = new LoopingFlowContext(var2, var3, this, this.field_535, this.field_536, this.scope);
            var11 = var19;
            var13 = ((FlowInfo)var10).method_3081();
            this.field_539 = var1.method_635().recordInitializationStates(var13);
            if (var6) {
                var12 = FlowInfo.DEAD_END;
            } else {
                var12 = var13.method_3107();
                if (var8) {
                    var12.setReachMode(1);
                }
            }
            if (!this.action.method_816(var12, this.scope, false)) {
                var12 = this.action.analyseCode(this.scope, var11, var12).method_3109();
            }
            if ((var12.tagBits & var11.initsOnContinue.tagBits & 1) != 0) {
                this.field_536 = null;
            } else {
                if (var9 != null) {
                    var9.method_3057(this.scope, (FlowInfo)var10);
                }
                var12 = var12.mergedWith(var11.initsOnContinue);
                var11.method_3057(this.scope, var12);
            }
        } else {
            if (var9 != null) {
                var9.method_3057(this.scope, (FlowInfo)var10);
            }
            if (var21) {
                if (var9 != null) {
                    var9.method_3058(var1, (FlowInfo)var10);
                }
                return FlowInfo.DEAD_END;
            }
            if (var6) {
                this.field_536 = null;
            }
            var12 = ((FlowInfo)var10).method_3081().method_3107();
            var19 = new LoopingFlowContext(var2, var3, this, this.field_535, this.field_536, this.scope);
            var11 = var19;
        }
        var13 = var3.method_3078();
        LoopingFlowContext var14 = null;
        if (this.field_536 != null) {
            if (this.field_532 != null) {
                var19 = new LoopingFlowContext(var2, var3, this, (BranchLabel)null, (BranchLabel)null, this.scope);
                var14 = var19;
                Object var15 = var12;
                this.field_538 = var1.method_635().recordInitializationStates(var12);
                int var16 = 0;
                for (int var17 = this.field_532.length; var16 < var17; ++var16) {
                    var15 = this.field_532[var16].analyseCode(this.scope, var14, (FlowInfo)var15);
                }
                var14.method_3057(this.scope, var12 = ((FlowInfo)var15).method_3109());
            }
            var13.method_3072(var12).method_3071(((FlowInfo)var10).method_3080());
        } else {
            var13.method_3071(((FlowInfo)var10).method_3080());
        }
        if (var9 != null) {
            var9.method_3058(var1, var12);
        }
        var11.method_3058(var1, var12);
        if (var14 != null) {
            var14.method_3058(var1, var12);
        }
        UnconditionalFlowInfo var22 = FlowInfo.mergedOptimizedBranches((FlowInfo)((var11.initsOnBreak.tagBits & 1) != 0 ? var11.initsOnBreak : var3.method_3071(var11.initsOnBreak)), var7, var13, var8, !var21);
        this.field_540 = var1.method_635().recordInitializationStates(var22);
        return var22;
    }

    public void generateCode(BlockScope var1, CodeStream var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            int var3 = var2.field_1208;
            if (this.field_530 != null) {
                int var4 = 0;
                for (int var5 = this.field_530.length; var4 < var5; ++var4) {
                    this.field_530[var4].generateCode(this.scope, var2);
                }
            }
            Constant var10 = this.condition == null ? null : this.condition.optimizedBooleanConstant();
            boolean var11 = var10 != null && var10 != Constant.NotAConstant && !var10.booleanValue();
            if (var11) {
                this.condition.generateCode(this.scope, var2, false);
                if ((this.field_446 & 536870912) != 0) {
                    var2.exitUserScope(this.scope);
                }
                if (this.field_540 != -1) {
                    var2.method_2363(var1, this.field_540);
                    var2.method_2088(var1, this.field_540);
                }
                var2.method_2360(var3, this.field_444);
            } else {
                BranchLabel var10000 = new BranchLabel(var2);
                BranchLabel var6 = var10000;
                var6.tagBits |= 2;
                var10000 = new BranchLabel(var2);
                BranchLabel var7 = var10000;
                this.field_535.initialize(var2);
                int var8;
                if (this.field_536 == null) {
                    var7.place();
                    if (this.condition != null && this.condition.constant == Constant.NotAConstant) {
                        this.condition.generateOptimizedBoolean(this.scope, var2, (BranchLabel)null, this.field_535, true);
                    }
                } else {
                    this.field_536.initialize(var2);
                    if (this.condition != null && this.condition.constant == Constant.NotAConstant && (this.action != null && !this.action.isEmptyBlock() || this.field_532 != null)) {
                        var7.tagBits |= 2;
                        var8 = var2.field_1208;
                        var2.method_2209(var7);
                        var2.method_2360(var8, this.condition.field_444);
                    }
                }
                if (this.action != null) {
                    if (this.field_539 != -1) {
                        var2.method_2088(var1, this.field_539);
                    }
                    var6.place();
                    this.action.generateCode(this.scope, var2);
                } else {
                    var6.place();
                }
                if (this.field_538 != -1) {
                    var2.method_2363(var1, this.field_538);
                    var2.method_2088(var1, this.field_538);
                }
                if (this.field_536 != null) {
                    this.field_536.place();
                    if (this.field_532 != null) {
                        var8 = 0;
                        for (int var9 = this.field_532.length; var8 < var9; ++var8) {
                            this.field_532[var8].generateCode(this.scope, var2);
                        }
                    }
                    if (this.field_537 != -1) {
                        var2.method_2363(var1, this.field_537);
                    }
                    var7.place();
                    if (this.condition != null && this.condition.constant == Constant.NotAConstant) {
                        this.condition.generateOptimizedBoolean(this.scope, var2, var6, (BranchLabel)null, true);
                    } else {
                        var2.method_2209(var6);
                    }
                } else if (this.field_537 != -1) {
                    var2.method_2363(var1, this.field_537);
                }
                if ((this.field_446 & 536870912) != 0) {
                    var2.exitUserScope(this.scope);
                }
                if (this.field_540 != -1) {
                    var2.method_2363(var1, this.field_540);
                    var2.method_2088(var1, this.field_540);
                }
                this.field_535.place();
                var2.method_2360(var3, this.field_444);
            }
        }
    }

    public StringBuffer printStatement(int var1, StringBuffer var2) {
        method_759(var1, var2).append("for (");
        int var3;
        if (this.field_530 != null) {
            for (var3 = 0; var3 < this.field_530.length; ++var3) {
                if (var3 > 0) {
                    var2.append(", ");
                }
                this.field_530[var3].print(0, var2);
            }
        }
        var2.append("; ");
        if (this.condition != null) {
            this.condition.printExpression(0, var2);
        }
        var2.append("; ");
        if (this.field_532 != null) {
            for (var3 = 0; var3 < this.field_532.length; ++var3) {
                if (var3 > 0) {
                    var2.append(", ");
                }
                this.field_532[var3].print(0, var2);
            }
        }
        var2.append(") ");
        if (this.action == null) {
            var2.append(';');
        } else {
            var2.append('\n');
            this.action.printStatement(var1 + 1, var2);
        }
        return var2;
    }

    public void resolve(BlockScope var1) {
        BlockScope var10001;
        if ((this.field_446 & 536870912) != 0) {
            var10001 = new BlockScope(var1);
        } else {
            var10001 = var1;
        }
        this.scope = var10001;
        int var2;
        int var3;
        if (this.field_530 != null) {
            var2 = 0;
            for (var3 = this.field_530.length; var2 < var3; ++var2) {
                this.field_530[var2].resolve(this.scope);
            }
        }
        if (this.condition != null) {
            TypeBinding var4 = this.condition.resolveTypeExpecting(this.scope, TypeBinding.field_186);
            this.condition.computeConversion(this.scope, var4, var4);
        }
        if (this.field_532 != null) {
            var2 = 0;
            for (var3 = this.field_532.length; var2 < var3; ++var2) {
                this.field_532[var2].resolve(this.scope);
            }
        }
        if (this.action != null) {
            this.action.resolve(this.scope);
        }
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            int var3;
            int var4;
            if (this.field_530 != null) {
                var3 = this.field_530.length;
                for (var4 = 0; var4 < var3; ++var4) {
                    this.field_530[var4].traverse(var1, this.scope);
                }
            }
            if (this.condition != null) {
                this.condition.traverse(var1, this.scope);
            }
            if (this.field_532 != null) {
                var3 = this.field_532.length;
                for (var4 = 0; var4 < var3; ++var4) {
                    this.field_532[var4].traverse(var1, this.scope);
                }
            }
            if (this.action != null) {
                this.action.traverse(var1, this.scope);
            }
        }
        var1.endVisit(this, var2);
    }
}
