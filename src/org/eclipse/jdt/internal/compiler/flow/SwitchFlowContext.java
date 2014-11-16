package org.eclipse.jdt.internal.compiler.flow;

import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.codegen.BranchLabel;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.flow.UnconditionalFlowInfo;

public class SwitchFlowContext extends FlowContext {

    public BranchLabel breakLabel;

    public UnconditionalFlowInfo initsOnBreak;

    public SwitchFlowContext(FlowContext var1, ASTNode var2, BranchLabel var3) {
        super(var1, var2);
        this.initsOnBreak = FlowInfo.DEAD_END;
        this.breakLabel = var3;
    }

    public BranchLabel breakLabel() {
        return this.breakLabel;
    }

    public String individualToString() {
        StringBuffer var1 = new StringBuffer("Switch flow context");
        var1.append("[initsOnBreak -").append(this.initsOnBreak.toString()).append(']');
        return var1.toString();
    }

    public boolean isBreakable() {
        return true;
    }

    public void recordBreakFrom(FlowInfo var1) {
        if ((this.initsOnBreak.tagBits & 1) == 0) {
            this.initsOnBreak = this.initsOnBreak.mergedWith(var1.method_3109());
        } else {
            this.initsOnBreak = var1.method_3107();
        }
    }
}
