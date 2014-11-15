package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.lookup.class_34;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.class_58;

public class class_61 extends class_58 {

    private int field_290;

    public class_58 field_291;

    public class_61(char[] var1, class_40[] var2, int var3) {
        this.field_274 = var1;
        this.field_276 = var2 != null && var2.length != 0 ? var2 : class_34.field_150;
        this.field_290 = var3;
        this.field_277 = class_34.field_151;
    }

    public class_61(char[] var1, class_40[] var2, ReferenceBinding var3, int var4) {
        this.field_274 = var1;
        this.field_276 = var2 != null && var2.length != 0 ? var2 : class_34.field_150;
        this.field_278 = var3;
        this.field_290 = var4;
        this.field_277 = class_34.field_151;
    }

    public class_61(class_58 var1, char[] var2, class_40[] var3, int var4) {
        this(var2, var3, var4);
        this.field_291 = var1;
        if (var1 != null && var4 != 3) {
            this.field_278 = var1.field_278;
        }
    }

    public final int method_102() {
        return this.field_290;
    }
}
