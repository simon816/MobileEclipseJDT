package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.lookup.PackageBinding;

public class class_39 extends PackageBinding {

    private int field_176;

    class_39(char[][] var1, int var2) {
        this.field_171 = var1;
        this.field_176 = var2;
    }

    class_39(char[] var1, int var2) {
        this(new char[][] {var1}, var2);
    }

    public final int method_102() {
        return this.field_176;
    }
}
