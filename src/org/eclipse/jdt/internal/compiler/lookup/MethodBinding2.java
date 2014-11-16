package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;

public class MethodBinding2 extends MethodBinding {

    public TypeBinding field_282;

    public MethodBinding2(TypeBinding var1, int var2, char[] var3, TypeBinding var4, TypeBinding[] var5, ReferenceBinding[] var6, ReferenceBinding var7) {
        super(var2, var3, var4, var5, var6, var7);
        this.field_282 = var1;
    }

    public TypeBinding method_350() {
        return this.field_282;
    }
}
