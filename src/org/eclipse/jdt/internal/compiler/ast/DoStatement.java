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

public class DoStatement extends Statement {

    public Expression condition;

    public Statement action;

    private BranchLabel field_503;

    private BranchLabel field_504;

    int mergedInitStateIndex;

    public DoStatement(Expression var1, Statement var2, int var3, int var4) {
        this.mergedInitStateIndex = -1;
        this.field_444 = var3;
        this.field_445 = var4;
        this.condition = var1;
        this.action = var2;
        if (var2 instanceof EmptyStatement) {
            var2.field_446 |= 1;
        }
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        BranchLabel var10001 = new BranchLabel();
        this.field_503 = var10001;
        var10001 = new BranchLabel();
        this.field_504 = var10001;
        LoopingFlowContext var10000 = new LoopingFlowContext(var2, var3, this, this.field_503, this.field_504, var1);
        LoopingFlowContext var4 = var10000;
        Constant var5 = this.condition.constant;
        boolean var6 = var5 != Constant.NotAConstant && var5.booleanValue();
        var5 = this.condition.optimizedBooleanConstant();
        boolean var7 = var5 != Constant.NotAConstant && var5.booleanValue();
        boolean var8 = var5 != Constant.NotAConstant && !var5.booleanValue();
        int var9 = var3.reachMode();
        UnconditionalFlowInfo var10 = var3.method_3106();
        if (this.action != null && !this.action.isEmptyBlock()) {
            var10 = this.action.analyseCode(var1, var4, var10).method_3109();
            if ((var10.tagBits & var4.initsOnContinue.tagBits & 1) != 0) {
                this.field_504 = null;
            }
        }
        var10.setReachMode(var9);
        Expression var14 = this.condition;
        LoopingFlowContext var10002 = new LoopingFlowContext(var2, var3, this, (BranchLabel)null, (BranchLabel)null, var1);
        LoopingFlowContext var11 = var10002;
        FlowInfo var12 = var14.analyseCode(var1, var10002, (this.action == null ? var10 : var10.mergedWith(var4.initsOnContinue)).method_3078());
        if (!var8 && this.field_504 != null) {
            var4.method_3057(var1, var12);
            var11.method_3057(var1, var12);
            var4.method_3058(var1, var3.method_3107().method_3113(var12.method_3081().method_3109()));
            var11.method_3058(var1, var10.method_3113(var12.method_3081().method_3109()));
        }
        UnconditionalFlowInfo var13 = FlowInfo.mergedOptimizedBranches((FlowInfo)((var4.initsOnBreak.tagBits & 1) != 0 ? var4.initsOnBreak : var3.method_3107().method_3071(var4.initsOnBreak)), var7, (var12.tagBits & 1) == 0 ? var3.method_3071(var12.method_3080()) : var12, false, !var6);
        this.mergedInitStateIndex = var1.method_635().recordInitializationStates(var13);
        return var13;
    }

    public void generateCode(BlockScope var1, CodeStream var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            int var3 = var2.field_1208;
            BranchLabel var10000 = new BranchLabel(var2);
            BranchLabel var4 = var10000;
            if (this.action != null) {
                var4.tagBits |= 2;
            }
            var4.place();
            this.field_503.initialize(var2);
            boolean var5 = this.field_504 != null;
            if (var5) {
                this.field_504.initialize(var2);
            }
            if (this.action != null) {
                this.action.generateCode(var1, var2);
            }
            if (var5) {
                this.field_504.place();
            }
            Constant var6 = this.condition.optimizedBooleanConstant();
            boolean var7 = var6 != Constant.NotAConstant && !var6.booleanValue();
            if (var7) {
                this.condition.generateCode(var1, var2, false);
            } else if (var5) {
                this.condition.generateOptimizedBoolean(var1, var2, var4, (BranchLabel)null, true);
            }
            if (this.mergedInitStateIndex != -1) {
                var2.method_2363(var1, this.mergedInitStateIndex);
                var2.method_2088(var1, this.mergedInitStateIndex);
            }
            if (this.field_503.forwardReferenceCount() > 0) {
                this.field_503.place();
            }
            var2.method_2360(var3, this.field_444);
        }
    }

    public StringBuffer printStatement(int var1, StringBuffer var2) {
        method_759(var1, var2).append("do");
        if (this.action == null) {
            var2.append(" ;\n");
        } else {
            var2.append('\n');
            this.action.printStatement(var1 + 1, var2).append('\n');
        }
        var2.append("while (");
        return this.condition.printExpression(0, var2).append(");");
    }

    public void resolve(BlockScope var1) {
        TypeBinding var2 = this.condition.resolveTypeExpecting(var1, TypeBinding.field_186);
        this.condition.computeConversion(var1, var2, var2);
        if (this.action != null) {
            this.action.resolve(var1);
        }
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            if (this.action != null) {
                this.action.traverse(var1, var2);
            }
            this.condition.traverse(var1, var2);
        }
        var1.endVisit(this, var2);
    }
}
