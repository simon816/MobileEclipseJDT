package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.lookup.InvocationSite;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;

final class CastExpression$1 implements InvocationSite {

    private final InvocationSite field_1067;

    CastExpression$1(InvocationSite var1) {
        this.field_1067 = var1;
    }

    public TypeBinding[] genericTypeArguments() {
        return null;
    }

    public boolean isSuperAccess() {
        return this.field_1067.isSuperAccess();
    }

    public void setActualReceiverType(ReferenceBinding var1) {}

    public void method_2(int var1) {}

    public void setFieldIndex(int var1) {}

    public int method_5() {
        return 0;
    }

    public int method_6() {
        return 0;
    }
}
