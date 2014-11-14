package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.class_264;
import org.eclipse.jdt.internal.compiler.ast.class_126;
import org.eclipse.jdt.internal.compiler.ast.class_132;
import org.eclipse.jdt.internal.compiler.lookup.class_86;

public class class_134 extends class_132 {

    public class_134(class_126 var1, class_126 var2, int var3, int var4) {
        super(var1, var2, var3, var1.field_445);
        this.field_444 = var4;
        this.field_445 = var1.field_445;
    }

    public String method_948() {
        switch (this.field_689) {
            case 13:
                return "--";
            case 14:
                return "++";
            default:
                return "unknown operator";
        }
    }

    public StringBuffer method_946(int var1, StringBuffer var2) {
        var2.append(this.method_948()).append(' ');
        return this.field_687.method_924(0, var2);
    }

    public boolean method_949() {
        return true;
    }

    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2046(this, var2)) {
            this.field_687.method_763(var1, var2);
        }
        var1.method_1961(this, var2);
    }
}
