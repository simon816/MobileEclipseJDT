package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ast.Reference;
import org.eclipse.jdt.internal.compiler.lookup.InvocationSite;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;

public abstract class NameReference extends Reference implements InvocationSite {

    public Binding field_748;

    public Binding field_749;

    public TypeBinding actualReceiverType;

    public NameReference() {
        this.field_446 |= 7;
    }

    public FieldBinding fieldBinding() {
        return (FieldBinding)this.field_748;
    }

    public boolean isSuperAccess() {
        return false;
    }

    public void setActualReceiverType(ReferenceBinding var1) {
        if (var1 != null) {
            this.actualReceiverType = var1;
        }
    }

    public void method_2(int var1) {
        this.field_446 &= -8161;
        if (var1 > 0) {
            this.field_446 |= (var1 & 255) << 5;
        }
    }

    public void setFieldIndex(int var1) {}
}
