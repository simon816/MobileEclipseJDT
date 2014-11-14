package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ast.class_154;
import org.eclipse.jdt.internal.compiler.lookup.class_0;
import org.eclipse.jdt.internal.compiler.lookup.class_34;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.class_43;
import org.eclipse.jdt.internal.compiler.lookup.class_67;

public abstract class class_161 extends class_154 implements class_0 {

    public class_34 field_748;

    public class_34 field_749;

    public class_40 field_750;

    public class_161() {
        this.field_446 |= 7;
    }

    public class_67 method_1036() {
        return (class_67)this.field_748;
    }

    public boolean method_1() {
        return false;
    }

    public void method_4(class_43 var1) {
        if (var1 != null) {
            this.field_750 = var1;
        }
    }

    public void method_2(int var1) {
        this.field_446 &= -8161;
        if (var1 > 0) {
            this.field_446 |= (var1 & 255) << 5;
        }
    }

    public void method_3(int var1) {}
}
