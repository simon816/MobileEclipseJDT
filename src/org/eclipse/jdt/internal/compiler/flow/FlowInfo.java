package org.eclipse.jdt.internal.compiler.flow;

import org.eclipse.jdt.internal.compiler.flow.ConditionalFlowInfo;
import org.eclipse.jdt.internal.compiler.flow.UnconditionalFlowInfo;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;

public abstract class FlowInfo {

    public int tagBits;

    public static final UnconditionalFlowInfo DEAD_END;

    public FlowInfo() {
    }

    public abstract FlowInfo method_3071(FlowInfo var1);

    public abstract FlowInfo method_3072(FlowInfo var1);

    public FlowInfo asNegatedCondition() {
        return this;
    }

    public static FlowInfo conditional(FlowInfo var0, FlowInfo var1) {
        ConditionalFlowInfo var10000 = new ConditionalFlowInfo(var0, var1);
        return var10000;
    }

    public boolean method_3075(LocalVariableBinding var1) {
        return this.method_3091(var1) || this.method_3089(var1) && this.method_3090(var1);
    }

    public boolean method_3076(LocalVariableBinding var1) {
        return this.method_3084(var1) || this.method_3092(var1);
    }

    public boolean method_3077(LocalVariableBinding var1) {
        return this.method_3085(var1) || this.method_3093(var1);
    }

    public abstract FlowInfo method_3078();

    public static UnconditionalFlowInfo initial(int var0) {
        UnconditionalFlowInfo var10000 = new UnconditionalFlowInfo();
        UnconditionalFlowInfo var1 = var10000;
        var1.maxFieldCount = var0;
        return var1;
    }

    public abstract FlowInfo method_3080();

    public abstract FlowInfo method_3081();

    public abstract boolean method_3082(FieldBinding var1);

    public abstract boolean method_3083(LocalVariableBinding var1);

    public abstract boolean method_3084(LocalVariableBinding var1);

    public abstract boolean method_3085(LocalVariableBinding var1);

    public abstract boolean method_3086(LocalVariableBinding var1);

    public abstract boolean method_3087(FieldBinding var1);

    public abstract boolean method_3088(LocalVariableBinding var1);

    public abstract boolean method_3089(LocalVariableBinding var1);

    public abstract boolean method_3090(LocalVariableBinding var1);

    public abstract boolean method_3091(LocalVariableBinding var1);

    public abstract boolean method_3092(LocalVariableBinding var1);

    public abstract boolean method_3093(LocalVariableBinding var1);

    public abstract void method_3094(LocalVariableBinding var1);

    public abstract void method_3095(LocalVariableBinding var1);

    public abstract void markAsDefinitelyAssigned(FieldBinding var1);

    public abstract void method_3097(LocalVariableBinding var1);

    public abstract void method_3098(LocalVariableBinding var1);

    public abstract void method_3099(LocalVariableBinding var1);

    public abstract void method_3100(LocalVariableBinding var1);

    public static UnconditionalFlowInfo mergedOptimizedBranches(FlowInfo var0, boolean var1, FlowInfo var2, boolean var3, boolean var4) {
        UnconditionalFlowInfo var5;
        if (var1) {
            if (var0 == DEAD_END && var4) {
                var5 = var2.setReachMode(1).method_3109();
            } else {
                var5 = var0.method_3072(var2.method_3106()).method_3109();
            }
        } else if (var3) {
            if (var2 == DEAD_END && var4) {
                var5 = var0.setReachMode(1).method_3109();
            } else {
                var5 = var2.method_3072(var0.method_3106()).method_3109();
            }
        } else {
            var5 = var0.mergedWith(var2.method_3109());
        }
        return var5;
    }

    public int reachMode() {
        return this.tagBits & 1;
    }

    public abstract FlowInfo method_3103();

    public abstract FlowInfo setReachMode(int var1);

    public abstract UnconditionalFlowInfo mergedWith(UnconditionalFlowInfo var1);

    public abstract UnconditionalFlowInfo method_3106();

    public String toString() {
        return this == DEAD_END ? "FlowInfo.DEAD_END" : super.toString();
    }

    public abstract UnconditionalFlowInfo method_3107();

    public abstract UnconditionalFlowInfo method_3108();

    public abstract UnconditionalFlowInfo method_3109();

    public abstract UnconditionalFlowInfo method_3110();

    static {
        UnconditionalFlowInfo var10000 = new UnconditionalFlowInfo();
        DEAD_END = var10000;
        DEAD_END.tagBits = 1;
    }
}
