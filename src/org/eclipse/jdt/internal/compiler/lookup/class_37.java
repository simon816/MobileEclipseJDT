package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.lookup.class_34;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;

public class class_37 extends class_34 {

    public char[] field_167;

    public ReferenceBinding field_168;

    private int field_169;

    public class_37(char[][] var1, int var2) {
        this(CharOperation.method_1361(var1, '.'), var2);
    }

    public class_37(char[][] var1, ReferenceBinding var2, int var3) {
        this(CharOperation.method_1361(var1, '.'), var2, var3);
    }

    class_37(char[] var1, int var2) {
        this.field_167 = var1;
        this.field_169 = var2;
    }

    class_37(char[] var1, ReferenceBinding var2, int var3) {
        this(var1, var3);
        this.field_168 = var2;
    }

    public final int method_98() {
        return 7;
    }

    public final int method_102() {
        return this.field_169;
    }

    public char[] method_103() {
        return this.field_167;
    }
}
