package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.class_264;
import org.eclipse.jdt.internal.compiler.ast.class_112;
import org.eclipse.jdt.internal.compiler.ast.class_114;
import org.eclipse.jdt.internal.compiler.ast.class_121;
import org.eclipse.jdt.internal.compiler.ast.class_90;
import org.eclipse.jdt.internal.compiler.codegen.class_268;
import org.eclipse.jdt.internal.compiler.flow.class_293;
import org.eclipse.jdt.internal.compiler.flow.class_301;
import org.eclipse.jdt.internal.compiler.lookup.class_54;
import org.eclipse.jdt.internal.compiler.lookup.class_67;
import org.eclipse.jdt.internal.compiler.lookup.class_86;
import org.eclipse.jdt.internal.compiler.lookup.class_87;
import org.eclipse.jdt.internal.compiler.parser.Parser;

public class class_122 extends class_121 {

    public class_112 field_664;

    public int field_665;

    public int field_666;

    public int field_667;

    public class_122(class_112 var1, int var2) {
        this.field_664 = var1;
        this.field_656 = var2;
        if (var1 != null) {
            this.field_653 = this.field_444 = var1.field_444;
        }
    }

    public class_301 method_890(class_87 var1, class_293 var2, class_301 var3) {
        return this.field_664 != null ? this.field_664.method_814(var1, var2, var3) : var3;
    }

    public void method_818(class_86 var1, class_268 var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            int var3 = var2.field_1208;
            if (this.field_664 != null) {
                this.field_664.method_818(var1, var2);
            }
            var2.method_2360(var3, this.field_444);
        }
    }

    public int method_887() {
        return 2;
    }

    public boolean method_891() {
        return (this.field_656 & 8) != 0;
    }

    public void method_895(Parser var1, class_114 var2, class_90 var3) {
        var1.method_2858(this, var2, var3);
    }

    public StringBuffer method_820(int var1, StringBuffer var2) {
        if (this.field_656 != 0) {
            method_759(var1, var2);
            method_760(this.field_656, var2);
            if (this.field_658 != null) {
                method_758(this.field_658, var2);
            }
            var2.append("{\n");
            if (this.field_664 != null) {
                this.field_664.method_841(var1, var2);
            }
            method_759(var1, var2).append('}');
            return var2;
        } else {
            if (this.field_664 != null) {
                this.field_664.method_820(var1, var2);
            } else {
                method_759(var1, var2).append("{}");
            }
            return var2;
        }
    }

    public void method_892(class_87 var1) {
        class_67 var2 = var1.field_406;
        int var3 = var1.field_407;
        try {
            var1.field_406 = null;
            var1.field_407 = this.field_665;
            if (this.method_891()) {
                class_54 var4 = var1.method_585();
                if (var4.method_160() && !var4.method_226()) {
                    var1.method_644().method_1619(var4, this);
                }
            }
            if (this.field_664 != null) {
                this.field_664.method_821(var1);
            }
        } finally {
            var1.field_406 = var2;
            var1.field_407 = var3;
        }
    }

    public void method_893(class_264 var1, class_87 var2) {
        if (var1.method_2027(this, var2) && this.field_664 != null) {
            this.field_664.method_763(var1, var2);
        }
        var1.method_1942(this, var2);
    }
}
