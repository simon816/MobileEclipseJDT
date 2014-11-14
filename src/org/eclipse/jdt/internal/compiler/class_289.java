package org.eclipse.jdt.internal.compiler;

import org.eclipse.jdt.internal.compiler.class_284;
import org.eclipse.jdt.internal.compiler.Compiler;
import org.eclipse.jdt.internal.compiler.class_9;

class class_289 implements class_9 {

    private final class_9 field_1733;

    private final Compiler field_1734;

    class_289(Compiler var1, class_9 var2) {
        this.field_1734 = var1;
        this.field_1733 = var2;
    }

    public void method_26(class_284 var1) {
        if (Compiler.field_1713.method_21()) {
            Compiler.field_1713.method_20(var1);
        }
        this.field_1733.method_26(var1);
    }
}
