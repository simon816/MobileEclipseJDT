package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;

import java.util.Comparator;

final class ReferenceBinding$3 implements Comparator {

    ReferenceBinding$3() {
    }

    public int compare(Object var1, Object var2) {
        MethodBinding var3 = (MethodBinding)var1;
        MethodBinding var4 = (MethodBinding)var2;
        char[] var5 = var3.selector;
        char[] var6 = var4.selector;
        int var7 = ReferenceBinding.compare(var5, var6, var5.length, var6.length);
        return var7 == 0 ? var3.parameters.length - var4.parameters.length : var7;
    }
}
