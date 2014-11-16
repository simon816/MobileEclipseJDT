package org.eclipse.jdt.internal.compiler.flow;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.codegen.BranchLabel;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.SwitchFlowContext;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class LabelFlowContext extends SwitchFlowContext {

    public char[] labelName;

    public LabelFlowContext(FlowContext var1, ASTNode var2, char[] var3, BranchLabel var4, BlockScope var5) {
        super(var1, var2, var4);
        this.labelName = var3;
        this.checkLabelValidity(var5);
    }

    void checkLabelValidity(BlockScope var1) {
        for (FlowContext var2 = this.parent; var2 != null; var2 = var2.parent) {
            char[] var3;
            if ((var3 = var2.labelName()) != null && CharOperation.method_1364(var3, this.labelName)) {
                var1.problemReporter().alreadyDefinedLabel(this.labelName, this.associatedNode);
            }
        }
    }

    public String individualToString() {
        return "Label flow context [label:" + String.valueOf(this.labelName) + "]";
    }

    public char[] labelName() {
        return this.labelName;
    }
}
