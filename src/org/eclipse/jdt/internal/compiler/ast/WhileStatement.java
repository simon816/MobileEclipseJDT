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

public class WhileStatement extends Statement {

    public Expression condition;

    public Statement action;

    private BranchLabel field_561;

    private BranchLabel field_562;

    int field_563;

    int field_564;

    int field_565;

    public WhileStatement(Expression var1, Statement var2, int var3, int var4) {
        this.field_563 = -1;
        this.field_564 = -1;
        this.field_565 = -1;
        this.condition = var1;
        this.action = var2;
        if (var2 instanceof EmptyStatement) {
            var2.field_446 |= 1;
        }
        this.field_444 = var3;
        this.field_445 = var4;
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        BranchLabel var10001 = new BranchLabel();
        this.field_561 = var10001;
        var10001 = new BranchLabel();
        this.field_562 = var10001;
        Constant var4 = this.condition.constant;
        boolean var5 = var4 != Constant.NotAConstant && var4.booleanValue();
        boolean var6 = var4 != Constant.NotAConstant && !var4.booleanValue();
        var4 = this.condition.optimizedBooleanConstant();
        boolean var7 = var4 != Constant.NotAConstant && var4.booleanValue();
        boolean var8 = var4 != Constant.NotAConstant && !var4.booleanValue();
        this.field_563 = var1.method_635().recordInitializationStates(var3);
        UnconditionalFlowInfo var10 = var3.method_3106();
        Expression var10000 = this.condition;
        LoopingFlowContext var10002 = new LoopingFlowContext(var2, var3, this, (BranchLabel)null, (BranchLabel)null, var1);
        LoopingFlowContext var9 = var10002;
        FlowInfo var16 = var10000.analyseCode(var1, var10002, var10);
        if (this.action != null && (!this.action.isEmptyBlock() || var1.compilerOptions().field_1927 > 3080192L)) {
            LoopingFlowContext var15 = new LoopingFlowContext(var2, var3, this, this.field_561, this.field_562, var1);
            LoopingFlowContext var11 = var15;
            Object var12;
            if (var6) {
                var12 = FlowInfo.DEAD_END;
            } else {
                var12 = var16.method_3081().method_3078();
                if (var8) {
                    ((FlowInfo)var12).setReachMode(1);
                }
            }
            this.field_564 = var1.method_635().recordInitializationStates(var16.method_3081());
            if (!this.action.method_816((FlowInfo)var12, var1, false)) {
                var12 = this.action.analyseCode(var1, var11, (FlowInfo)var12);
            }
            FlowInfo var13 = var3.method_3078();
            if ((((FlowInfo)var12).tagBits & var11.initsOnContinue.tagBits & 1) != 0) {
                this.field_562 = null;
                var13.method_3071(var16.method_3080());
            } else {
                var9.method_3057(var1, var16);
                UnconditionalFlowInfo var17 = ((FlowInfo)var12).mergedWith(var11.initsOnContinue.method_3109());
                var9.method_3058(var1, var17);
                var11.method_3057(var1, var17);
                var11.method_3058(var1, var17);
                var13.method_3072(var17.method_3109()).method_3071(var16.method_3080());
            }
            UnconditionalFlowInfo var18 = FlowInfo.mergedOptimizedBranches((FlowInfo)((var11.initsOnBreak.tagBits & 1) != 0 ? var11.initsOnBreak : var3.method_3071(var11.initsOnBreak)), var7, var13, var8, !var5);
            this.field_565 = var1.method_635().recordInitializationStates(var18);
            return var18;
        } else {
            var9.method_3057(var1, var16);
            var9.method_3058(var1, var16.method_3109());
            if (var5) {
                return FlowInfo.DEAD_END;
            } else {
                FlowInfo var14 = var3.method_3078().method_3071(var16.method_3080());
                if (var7) {
                    var14.setReachMode(1);
                }
                this.field_565 = var1.method_635().recordInitializationStates(var14);
                return var14;
            }
        }
    }

    public void generateCode(BlockScope var1, CodeStream var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            int var3 = var2.field_1208;
            Constant var4 = this.condition.optimizedBooleanConstant();
            boolean var5 = var4 != Constant.NotAConstant && !var4.booleanValue();
            if (var5) {
                this.condition.generateCode(var1, var2, false);
                if (this.field_565 != -1) {
                    var2.method_2363(var1, this.field_565);
                    var2.method_2088(var1, this.field_565);
                }
                var2.method_2360(var3, this.field_444);
            } else {
                this.field_561.initialize(var2);
                if (this.field_562 == null) {
                    if (this.condition.constant == Constant.NotAConstant) {
                        this.condition.generateOptimizedBoolean(var1, var2, (BranchLabel)null, this.field_561, true);
                    }
                } else {
                    this.field_562.initialize(var2);
                    if ((this.condition.constant == Constant.NotAConstant || !this.condition.constant.booleanValue()) && this.action != null && !this.action.isEmptyBlock()) {
                        int var6 = var2.field_1208;
                        var2.method_2209(this.field_562);
                        var2.method_2360(var6, this.condition.field_444);
                    }
                }
                BranchLabel var10000 = new BranchLabel(var2);
                BranchLabel var7 = var10000;
                if (this.action != null) {
                    var7.tagBits |= 2;
                    if (this.field_564 != -1) {
                        var2.method_2088(var1, this.field_564);
                    }
                    var7.place();
                    this.action.generateCode(var1, var2);
                    if (this.field_563 != -1) {
                        var2.method_2363(var1, this.field_563);
                    }
                } else {
                    var7.place();
                }
                if (this.field_562 != null) {
                    this.field_562.place();
                    this.condition.generateOptimizedBoolean(var1, var2, var7, (BranchLabel)null, true);
                }
                if (this.field_565 != -1) {
                    var2.method_2363(var1, this.field_565);
                    var2.method_2088(var1, this.field_565);
                }
                this.field_561.place();
                var2.method_2360(var3, this.field_444);
            }
        }
    }

    public void resolve(BlockScope var1) {
        TypeBinding var2 = this.condition.resolveTypeExpecting(var1, TypeBinding.field_186);
        this.condition.computeConversion(var1, var2, var2);
        if (this.action != null) {
            this.action.resolve(var1);
        }
    }

    public StringBuffer printStatement(int var1, StringBuffer var2) {
        method_759(var1, var2).append("while (");
        this.condition.printExpression(0, var2).append(')');
        if (this.action == null) {
            var2.append(';');
        } else {
            this.action.printStatement(var1 + 1, var2);
        }
        return var2;
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            this.condition.traverse(var1, var2);
            if (this.action != null) {
                this.action.traverse(var1, var2);
            }
        }
        var1.endVisit(this, var2);
    }
}
