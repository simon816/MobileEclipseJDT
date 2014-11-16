package org.eclipse.jdt.internal.compiler.flow;

import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.flow.UnconditionalFlowInfo;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;

public class ConditionalFlowInfo extends FlowInfo {

    public FlowInfo field_1785;

    public FlowInfo field_1786;

    ConditionalFlowInfo(FlowInfo var1, FlowInfo var2) {
        this.field_1785 = var1;
        this.field_1786 = var2;
    }

    public FlowInfo method_3071(FlowInfo var1) {
        this.field_1785.method_3071(var1);
        this.field_1786.method_3071(var1);
        return this;
    }

    public FlowInfo method_3072(FlowInfo var1) {
        this.field_1785.method_3072(var1);
        this.field_1786.method_3072(var1);
        return this;
    }

    public FlowInfo asNegatedCondition() {
        FlowInfo var1 = this.field_1785;
        this.field_1785 = this.field_1786;
        this.field_1786 = var1;
        return this;
    }

    public FlowInfo method_3078() {
        ConditionalFlowInfo var10000 = new ConditionalFlowInfo(this.field_1785.method_3078(), this.field_1786.method_3078());
        return var10000;
    }

    public FlowInfo method_3080() {
        return this.field_1786;
    }

    public FlowInfo method_3081() {
        return this.field_1785;
    }

    public boolean method_3082(FieldBinding var1) {
        return this.field_1785.method_3082(var1) && this.field_1786.method_3082(var1);
    }

    public boolean method_3083(LocalVariableBinding var1) {
        return this.field_1785.method_3083(var1) && this.field_1786.method_3083(var1);
    }

    public boolean method_3084(LocalVariableBinding var1) {
        return this.field_1785.method_3084(var1) && this.field_1786.method_3084(var1);
    }

    public boolean method_3085(LocalVariableBinding var1) {
        return this.field_1785.method_3085(var1) && this.field_1786.method_3085(var1);
    }

    public boolean method_3086(LocalVariableBinding var1) {
        return this.field_1785.method_3086(var1) && this.field_1786.method_3086(var1);
    }

    public boolean method_3087(FieldBinding var1) {
        return this.field_1785.method_3087(var1) || this.field_1786.method_3087(var1);
    }

    public boolean method_3088(LocalVariableBinding var1) {
        return this.field_1785.method_3088(var1) || this.field_1786.method_3088(var1);
    }

    public boolean method_3089(LocalVariableBinding var1) {
        return this.field_1785.method_3089(var1) || this.field_1786.method_3089(var1);
    }

    public boolean method_3090(LocalVariableBinding var1) {
        return this.field_1785.method_3090(var1) || this.field_1786.method_3090(var1);
    }

    public boolean method_3091(LocalVariableBinding var1) {
        return this.field_1785.method_3091(var1) || this.field_1786.method_3091(var1);
    }

    public boolean method_3092(LocalVariableBinding var1) {
        return this.field_1785.method_3092(var1) && this.field_1786.method_3092(var1);
    }

    public boolean method_3093(LocalVariableBinding var1) {
        return this.field_1785.method_3093(var1) && this.field_1786.method_3093(var1);
    }

    public void method_3094(LocalVariableBinding var1) {
        this.field_1785.method_3094(var1);
        this.field_1786.method_3094(var1);
    }

    public void method_3095(LocalVariableBinding var1) {
        this.field_1785.method_3095(var1);
        this.field_1786.method_3095(var1);
    }

    public void markAsDefinitelyAssigned(FieldBinding var1) {
        this.field_1785.markAsDefinitelyAssigned(var1);
        this.field_1786.markAsDefinitelyAssigned(var1);
    }

    public void method_3099(LocalVariableBinding var1) {
        this.field_1785.method_3099(var1);
        this.field_1786.method_3099(var1);
    }

    public void method_3097(LocalVariableBinding var1) {
        this.field_1785.method_3097(var1);
        this.field_1786.method_3097(var1);
    }

    public void method_3098(LocalVariableBinding var1) {
        this.field_1785.method_3098(var1);
        this.field_1786.method_3098(var1);
    }

    public void method_3100(LocalVariableBinding var1) {
        this.field_1785.method_3100(var1);
        this.field_1786.method_3100(var1);
    }

    public FlowInfo setReachMode(int var1) {
        if (var1 == 0) {
            this.tagBits &= -2;
        } else {
            this.tagBits |= 1;
        }
        this.field_1785.setReachMode(var1);
        this.field_1786.setReachMode(var1);
        return this;
    }

    public UnconditionalFlowInfo mergedWith(UnconditionalFlowInfo var1) {
        return this.method_3109().mergedWith(var1);
    }

    public UnconditionalFlowInfo method_3106() {
        return this.method_3110().method_3106();
    }

    public String toString() {
        return "FlowInfo<true: " + this.field_1785.toString() + ", false: " + this.field_1786.toString() + ">";
    }

    public FlowInfo method_3103() {
        return this.field_1785;
    }

    public UnconditionalFlowInfo method_3107() {
        return this.field_1785.method_3107().mergedWith(this.field_1786.method_3109());
    }

    public UnconditionalFlowInfo method_3108() {
        return this.field_1785.method_3108().mergedWith(this.field_1786.method_3108());
    }

    public UnconditionalFlowInfo method_3109() {
        return this.field_1785.method_3109().mergedWith(this.field_1786.method_3109());
    }

    public UnconditionalFlowInfo method_3110() {
        return this.field_1785.method_3107().mergedWith(this.field_1786.method_3109());
    }
}
