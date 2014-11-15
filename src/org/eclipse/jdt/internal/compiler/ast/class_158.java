package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.class_264;
import org.eclipse.jdt.internal.compiler.ast.class_105;
import org.eclipse.jdt.internal.compiler.ast.class_157;
import org.eclipse.jdt.internal.compiler.impl.class_331;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.class_86;

public class class_158 extends class_157 {

    public class_158(int var1, int var2) {
        super(var1, var2);
    }

    public static class_105 method_1047() {
        class_105 var10000 = new class_105(1);
        return var10000;
    }

    public boolean method_752() {
        return false;
    }

    public boolean method_754() {
        return true;
    }

    public boolean method_755() {
        return false;
    }

    public StringBuffer method_924(int var1, StringBuffer var2) {
        return var2.append("super");
    }

    public class_40 method_925(class_86 var1) {
        this.field_672 = class_331.field_1896;
        if (!this.method_1046(var1.method_635())) {
            return null;
        } else {
            ReferenceBinding var2 = var1.method_584();
            if (var2.field_177 == 1) {
                var1.method_644().method_1506(this);
                return null;
            } else {
                return this.field_675 = var2.method_240();
            }
        }
    }

    public void method_763(class_264 var1, class_86 var2) {
        var1.method_2059(this, var2);
        var1.method_1974(this, var2);
    }
}
