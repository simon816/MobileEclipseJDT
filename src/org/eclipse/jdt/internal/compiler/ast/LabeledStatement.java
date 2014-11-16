package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.EmptyStatement;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.codegen.BranchLabel;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.LabelFlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.flow.UnconditionalFlowInfo;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class LabeledStatement extends Statement {

    public Statement statement;

    public char[] label;

    public BranchLabel targetLabel;

    public int labelEnd;

    int mergedInitStateIndex;

    public LabeledStatement(char[] var1, Statement var2, long var3, int var5) {
        this.mergedInitStateIndex = -1;
        this.statement = var2;
        if (var2 instanceof EmptyStatement) {
            var2.field_446 |= 1;
        }
        this.label = var1;
        this.field_444 = (int)(var3 >>> 32);
        this.labelEnd = (int)var3;
        this.field_445 = var5;
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        if (this.statement == null) {
            return var3;
        } else {
            Statement var10000 = this.statement;
            char[] var10006 = this.label;
            BranchLabel var10008 = new BranchLabel();
            LabelFlowContext var10002 = new LabelFlowContext(var2, this, var10006, this.targetLabel = var10008, var1);
            LabelFlowContext var4 = var10002;
            FlowInfo var5 = var10000.analyseCode(var1, var10002, var3);
            boolean var7 = (var5.tagBits & 1) != 0 && (var4.initsOnBreak.tagBits & 1) == 0;
            UnconditionalFlowInfo var6 = var5.mergedWith(var4.initsOnBreak);
            if (var7) {
                ((UnconditionalFlowInfo)var6).method_3071(var3.method_3108()).method_3071(var4.initsOnBreak.method_3108());
            }
            this.mergedInitStateIndex = var1.method_635().recordInitializationStates(var6);
            if ((this.field_446 & 64) == 0) {
                var1.problemReporter().unusedLabel(this);
            }
            return var6;
        }
    }

    public ASTNode concreteStatement() {
        return this.statement;
    }

    public void generateCode(BlockScope var1, CodeStream var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            int var3 = var2.field_1208;
            if (this.targetLabel != null) {
                this.targetLabel.initialize(var2);
                if (this.statement != null) {
                    this.statement.generateCode(var1, var2);
                }
                this.targetLabel.place();
            }
            if (this.mergedInitStateIndex != -1) {
                var2.method_2363(var1, this.mergedInitStateIndex);
                var2.method_2088(var1, this.mergedInitStateIndex);
            }
            var2.method_2360(var3, this.field_444);
        }
    }

    public StringBuffer printStatement(int var1, StringBuffer var2) {
        method_759(var1, var2).append(this.label).append(": ");
        if (this.statement == null) {
            var2.append(';');
        } else {
            this.statement.printStatement(0, var2);
        }
        return var2;
    }

    public void resolve(BlockScope var1) {
        if (this.statement != null) {
            this.statement.resolve(var1);
        }
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2) && this.statement != null) {
            this.statement.traverse(var1, var2);
        }
        var1.endVisit(this, var2);
    }
}
