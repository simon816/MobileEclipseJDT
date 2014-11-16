package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.BranchStatement;
import org.eclipse.jdt.internal.compiler.ast.SubRoutineStatement;
import org.eclipse.jdt.internal.compiler.ast.TryStatement;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.InsideSubRoutineFlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class ContinueStatement extends BranchStatement {

    public ContinueStatement(char[] var1, int var2, int var3) {
        super(var1, var2, var3);
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        FlowContext var4 = this.label == null ? var2.method_3038() : var2.method_3036(this.label);
        if (var4 == null) {
            if (this.label == null) {
                var1.problemReporter().method_1625(this);
            } else {
                var1.problemReporter().undefinedLabel(this);
            }
            return var3;
        } else if (var4 == FlowContext.NotContinuableContext) {
            var1.problemReporter().method_1625(this);
            return var3;
        } else {
            this.initStateIndex = var1.method_635().recordInitializationStates(var3);
            this.targetLabel = var4.continueLabel();
            FlowContext var5 = var2;
            int var6 = 0;
            this.subroutines = new SubRoutineStatement[5];
            do {
                SubRoutineStatement var7;
                if ((var7 = var5.subroutine()) != null) {
                    if (var6 == this.subroutines.length) {
                        System.arraycopy(this.subroutines, 0, this.subroutines = new SubRoutineStatement[var6 * 2], 0, var6);
                    }
                    this.subroutines[var6++] = var7;
                    if (var7.isSubRoutineEscaping()) {
                        break;
                    }
                }
                var5.recordReturnFrom(var3.method_3109());
                if (var5 instanceof InsideSubRoutineFlowContext) {
                    ASTNode var8 = var5.associatedNode;
                    if (var8 instanceof TryStatement) {
                        TryStatement var9 = (TryStatement)var8;
                        var3.method_3071(var9.subRoutineInits);
                    }
                } else if (var5 == var4) {
                    var4.recordContinueFrom(var2, var3);
                    break;
                }
            } while ((var5 = var5.parent) != null);
            if (var6 != this.subroutines.length) {
                System.arraycopy(this.subroutines, 0, this.subroutines = new SubRoutineStatement[var6], 0, var6);
            }
            return FlowInfo.DEAD_END;
        }
    }

    public StringBuffer printStatement(int var1, StringBuffer var2) {
        method_759(var1, var2).append("continue ");
        if (this.label != null) {
            var2.append(this.label);
        }
        return var2.append(';');
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        var1.visit(this, var2);
        var1.endVisit(this, var2);
    }
}
