package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Block;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.EmptyStatement;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.codegen.BranchLabel;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.flow.UnconditionalFlowInfo;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class IfStatement extends Statement {

    public Expression condition;

    public Statement field_507;

    public Statement field_508;

    int field_509;

    int field_510;

    int field_511;

    public IfStatement(Expression var1, Statement var2, int var3, int var4) {
        this.field_509 = -1;
        this.field_510 = -1;
        this.field_511 = -1;
        this.condition = var1;
        this.field_507 = var2;
        if (var2 instanceof EmptyStatement) {
            var2.field_446 |= 1;
        }
        this.field_444 = var3;
        this.field_445 = var4;
    }

    public IfStatement(Expression var1, Statement var2, Statement var3, int var4, int var5) {
        this.field_509 = -1;
        this.field_510 = -1;
        this.field_511 = -1;
        this.condition = var1;
        this.field_507 = var2;
        if (var2 instanceof EmptyStatement) {
            var2.field_446 |= 1;
        }
        this.field_508 = var3;
        if (var3 instanceof IfStatement) {
            var3.field_446 |= 536870912;
        }
        if (var3 instanceof EmptyStatement) {
            var3.field_446 |= 1;
        }
        this.field_444 = var4;
        this.field_445 = var5;
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        FlowInfo var4 = this.condition.analyseCode(var1, var2, var3);
        Constant var5 = this.condition.optimizedBooleanConstant();
        boolean var6 = var5 != Constant.NotAConstant && var5.booleanValue();
        boolean var7 = var5 != Constant.NotAConstant && !var5.booleanValue();
        FlowInfo var8 = var4.method_3103();
        if (var7) {
            var8.setReachMode(1);
        }
        FlowInfo var9 = var4.method_3080();
        if (var6) {
            var9.setReachMode(1);
        }
        if (this.field_507 != null) {
            this.field_509 = var1.method_635().recordInitializationStates(var8);
            if (!this.field_507.method_816(var8, var1, false)) {
                var8 = this.field_507.analyseCode(var1, var2, var8);
            }
        }
        if ((var8.tagBits & 1) != 0) {
            this.field_446 |= 1073741824;
        }
        if (this.field_508 != null) {
            if (var8 == FlowInfo.DEAD_END && (this.field_446 & 536870912) == 0 && !(this.field_508 instanceof IfStatement)) {
                var1.problemReporter().method_1791(this.field_508);
            }
            this.field_510 = var1.method_635().recordInitializationStates(var9);
            if (!this.field_508.method_816(var9, var1, false)) {
                var9 = this.field_508.analyseCode(var1, var2, var9);
            }
        }
        UnconditionalFlowInfo var10 = FlowInfo.mergedOptimizedBranches(var8, var6, var9, var7, true);
        this.field_511 = var1.method_635().recordInitializationStates(var10);
        return var10;
    }

    public void generateCode(BlockScope var1, CodeStream var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            int var3 = var2.field_1208;
            BranchLabel var10000 = new BranchLabel(var2);
            BranchLabel var4 = var10000;
            Constant var5;
            boolean var6 = ((var5 = this.condition.optimizedBooleanConstant()) == Constant.NotAConstant || var5.booleanValue()) && this.field_507 != null && !this.field_507.isEmptyBlock();
            boolean var7 = (var5 == Constant.NotAConstant || !var5.booleanValue()) && this.field_508 != null && !this.field_508.isEmptyBlock();
            if (var6) {
                BranchLabel var8 = null;
                BranchLabel var10004;
                if (var7) {
                    var10004 = new BranchLabel(var2);
                    var8 = var10004;
                } else {
                    var10004 = var4;
                }
                this.condition.generateOptimizedBoolean(var1, var2, (BranchLabel)null, var10004, true);
                if (this.field_509 != -1) {
                    var2.method_2363(var1, this.field_509);
                    var2.method_2088(var1, this.field_509);
                }
                this.field_507.generateCode(var1, var2);
                if (var7) {
                    if ((this.field_446 & 1073741824) == 0) {
                        this.field_507.branchChainTo(var4);
                        int var9 = var2.field_1208;
                        var2.method_2209(var4);
                        var2.method_2380(this.field_507 instanceof Block ? ((Block)this.field_507).scope : var1, var9);
                    }
                    if (this.field_510 != -1) {
                        var2.method_2363(var1, this.field_510);
                        var2.method_2088(var1, this.field_510);
                    }
                    if (var8 != null) {
                        var8.place();
                    }
                    this.field_508.generateCode(var1, var2);
                }
            } else if (var7) {
                this.condition.generateOptimizedBoolean(var1, var2, var4, (BranchLabel)null, true);
                if (this.field_510 != -1) {
                    var2.method_2363(var1, this.field_510);
                    var2.method_2088(var1, this.field_510);
                }
                this.field_508.generateCode(var1, var2);
            } else {
                this.condition.generateCode(var1, var2, false);
                var2.method_2360(var3, this.field_444);
            }
            if (this.field_511 != -1) {
                var2.method_2363(var1, this.field_511);
                var2.method_2088(var1, this.field_511);
            }
            var4.place();
            var2.method_2360(var3, this.field_444);
        }
    }

    public StringBuffer printStatement(int var1, StringBuffer var2) {
        method_759(var1, var2).append("if (");
        this.condition.printExpression(0, var2).append(")\n");
        this.field_507.printStatement(var1 + 2, var2);
        if (this.field_508 != null) {
            var2.append('\n');
            method_759(var1, var2);
            var2.append("else\n");
            this.field_508.printStatement(var1 + 2, var2);
        }
        return var2;
    }

    public void resolve(BlockScope var1) {
        TypeBinding var2 = this.condition.resolveTypeExpecting(var1, TypeBinding.field_186);
        this.condition.computeConversion(var1, var2, var2);
        if (this.field_507 != null) {
            this.field_507.resolve(var1);
        }
        if (this.field_508 != null) {
            this.field_508.resolve(var1);
        }
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            this.condition.traverse(var1, var2);
            if (this.field_507 != null) {
                this.field_507.traverse(var1, var2);
            }
            if (this.field_508 != null) {
                this.field_508.traverse(var1, var2);
            }
        }
        var1.endVisit(this, var2);
    }
}
