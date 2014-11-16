package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;

public class SyntheticFieldBinding extends FieldBinding {

    public int index;

    public SyntheticFieldBinding(char[] var1, TypeBinding var2, int var3, ReferenceBinding var4, Constant var5, int var6) {
        super(var1, var2, var3, var4, var5);
        this.index = var6;
        this.tagBits |= 25769803776L;
    }
}
