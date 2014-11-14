package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.lookup.class_200;
import org.eclipse.jdt.internal.compiler.lookup.class_203;
import org.eclipse.jdt.internal.compiler.lookup.class_34;

class class_201 extends class_200 {

    class_203[][] field_884;

    class_201(class_203[] var1, class_203[][] var2) {
        this.method_1173(var1);
        this.field_884 = var2;
    }

    public class_203[][] method_1172() {
        return this.field_884;
    }

    class_200 method_1173(class_203[] var1) {
        this.field_883 = var1 != null && var1.length != 0 ? var1 : class_34.field_158;
        return this;
    }
}
