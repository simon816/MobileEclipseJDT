package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;

import java.util.Comparator;

final class ReferenceBinding$2 implements Comparator {

    ReferenceBinding$2() {
    }

    public int compare(Object var1, Object var2) {
        char[] var3 = ((FieldBinding)var1).name;
        char[] var4 = ((FieldBinding)var2).name;
        return ReferenceBinding.compare(var3, var4, var3.length, var4.length);
    }
}
