package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.class_264;
import org.eclipse.jdt.internal.compiler.ast.class_126;
import org.eclipse.jdt.internal.compiler.ast.class_132;
import org.eclipse.jdt.internal.compiler.ast.class_154;
import org.eclipse.jdt.internal.compiler.codegen.class_268;
import org.eclipse.jdt.internal.compiler.lookup.class_86;

public class class_133 extends class_132 {

    public class_133(class_126 var1, class_126 var2, int var3, int var4) {
        super(var1, var2, var3, var4);
        this.field_444 = var1.field_444;
        this.field_445 = var4;
    }

    public void method_912(class_86 var1, class_268 var2, boolean var3) {
        int var4 = var2.field_1208;
        ((class_154)this.field_687).method_1040(var1, var2, this, var3);
        if (var3) {
            var2.method_2182(this.field_674);
        }
        var2.method_2360(var4, this.field_444);
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
        return this.field_687.method_924(var1, var2).append(' ').append(this.method_948());
    }

    public boolean method_949() {
        return true;
    }

    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2045(this, var2)) {
            this.field_687.method_763(var1, var2);
        }
        var1.method_1960(this, var2);
    }
}
