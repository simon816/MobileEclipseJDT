package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.class_264;
import org.eclipse.jdt.internal.compiler.ast.class_173;
import org.eclipse.jdt.internal.compiler.codegen.class_268;
import org.eclipse.jdt.internal.compiler.flow.class_301;
import org.eclipse.jdt.internal.compiler.impl.class_331;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.class_86;

public class class_176 extends class_173 {

    static final char[] field_791;

    public class_176(int var1, int var2) {
        super(var1, var2);
    }

    public void method_1081() {
        this.field_672 = class_331.field_1896;
    }

    public void method_912(class_86 var1, class_268 var2, boolean var3) {
        int var4 = var2.field_1208;
        if (var3) {
            var2.method_2087();
            var2.method_2182(this.field_674);
        }
        var2.method_2360(var4, this.field_444);
    }

    public class_40 method_1082(class_86 var1) {
        return class_40.field_187;
    }

    public int method_921(class_301 var1) {
        return 1;
    }

    public Object method_927() {
        return class_40.field_187;
    }

    public char[] method_1083() {
        return field_791;
    }

    public void method_763(class_264 var1, class_86 var2) {
        var1.method_2039(this, var2);
        var1.method_1954(this, var2);
    }

    static {
        field_791 = new char[] {'n', 'u', 'l', 'l'};
    }
}
