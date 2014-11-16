package org.eclipse.jdt.internal.compiler.flow;

import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.ExceptionHandlingFlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.flow.UnconditionalFlowInfo;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class InitializationFlowContext extends ExceptionHandlingFlowContext {

    public int exceptionCount;

    public TypeBinding[] thrownExceptions;

    public ASTNode[] exceptionThrowers;

    public FlowInfo[] exceptionThrowerFlowInfos;

    public InitializationFlowContext(FlowContext var1, ASTNode var2, BlockScope var3) {
        super(var1, var2, Binding.field_151, var3, FlowInfo.DEAD_END);
        this.thrownExceptions = new TypeBinding[5];
        this.exceptionThrowers = new ASTNode[5];
        this.exceptionThrowerFlowInfos = new FlowInfo[5];
    }

    public void checkInitializerExceptions(BlockScope var1, FlowContext var2, FlowInfo var3) {
        for (int var4 = 0; var4 < this.exceptionCount; ++var4) {
            var2.checkExceptionHandlers(this.thrownExceptions[var4], this.exceptionThrowers[var4], this.exceptionThrowerFlowInfos[var4], var1);
        }
    }

    public String individualToString() {
        StringBuffer var1 = new StringBuffer("Initialization flow context");
        for (int var2 = 0; var2 < this.exceptionCount; ++var2) {
            var1.append('[').append(this.thrownExceptions[var2].readableName());
            var1.append('-').append(this.exceptionThrowerFlowInfos[var2].toString()).append(']');
        }
        return var1.toString();
    }

    public void recordHandlingException(ReferenceBinding var1, UnconditionalFlowInfo var2, TypeBinding var3, ASTNode var4, boolean var5) {
        int var6 = this.thrownExceptions.length;
        if (this.exceptionCount == var6) {
            System.arraycopy(this.thrownExceptions, 0, this.thrownExceptions = new TypeBinding[var6 * 2], 0, var6);
            System.arraycopy(this.exceptionThrowers, 0, this.exceptionThrowers = new ASTNode[var6 * 2], 0, var6);
            System.arraycopy(this.exceptionThrowerFlowInfos, 0, this.exceptionThrowerFlowInfos = new FlowInfo[var6 * 2], 0, var6);
        }
        this.thrownExceptions[this.exceptionCount] = var3;
        this.exceptionThrowers[this.exceptionCount] = var4;
        this.exceptionThrowerFlowInfos[this.exceptionCount++] = var2.method_3078();
    }
}
