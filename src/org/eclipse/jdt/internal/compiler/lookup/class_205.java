package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.class_67;

import java.util.Comparator;

final class class_205 implements Comparator {

    class_205() {
    }

    public int compare(Object var1, Object var2) {
        char[] var3 = ((class_67)var1).field_302;
        char[] var4 = ((class_67)var2).field_302;
        return ReferenceBinding.method_191(var3, var4, var3.length, var4.length);
    }
}
