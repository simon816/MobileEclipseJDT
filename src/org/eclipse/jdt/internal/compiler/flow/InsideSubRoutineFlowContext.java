package org.eclipse.jdt.internal.compiler.flow;

import org.eclipse.jdt.internal.compiler.ast.SubRoutineStatement;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.flow.UnconditionalFlowInfo;

public class InsideSubRoutineFlowContext extends FlowContext {

    public UnconditionalFlowInfo initsOnReturn;

    public InsideSubRoutineFlowContext(FlowContext var1, ASTNode var2) {
        super(var1, var2);
        this.initsOnReturn = FlowInfo.DEAD_END;
    }

    public String individualToString() {
        StringBuffer var1 = new StringBuffer("Inside SubRoutine flow context");
        var1.append("[initsOnReturn -").append(this.initsOnReturn.toString()).append(']');
        return var1.toString();
    }

    public boolean isNonReturningContext() {
        return ((SubRoutineStatement)this.associatedNode).isSubRoutineEscaping();
    }

    public void recordReturnFrom(UnconditionalFlowInfo var1) {
        if ((var1.tagBits & 1) == 0) {
            if (this.initsOnReturn == FlowInfo.DEAD_END) {
                this.initsOnReturn = (UnconditionalFlowInfo)var1.method_3078();
            } else {
                this.initsOnReturn = this.initsOnReturn.mergedWith(var1);
            }
        }
    }

    public SubRoutineStatement subroutine() {
        return (SubRoutineStatement)this.associatedNode;
    }
}
