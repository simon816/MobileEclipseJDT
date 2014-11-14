package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.class_264;
import org.eclipse.jdt.internal.compiler.ast.class_98;
import org.eclipse.jdt.internal.compiler.codegen.class_268;
import org.eclipse.jdt.internal.compiler.flow.class_293;
import org.eclipse.jdt.internal.compiler.flow.class_301;
import org.eclipse.jdt.internal.compiler.lookup.class_86;

public class class_99 extends class_98 {

    public class_99(int var1, int var2) {
        this.field_444 = var1;
        this.field_445 = var2;
    }

    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        return var3;
    }

    public boolean method_816(class_301 var1, class_86 var2, boolean var3) {
        return var2.method_577().field_1927 < 3145728L ? false : super.method_816(var1, var2, var3);
    }

    public void method_818(class_86 var1, class_268 var2) {}

    public StringBuffer method_820(int var1, StringBuffer var2) {
        return method_759(var1, var2).append(';');
    }

    public void method_821(class_86 var1) {
        if ((this.field_446 & 1) == 0) {
            var1.method_644().method_1762(this.field_444, this.field_445);
        } else {
            var1.method_644().method_1539(this.field_444, this.field_445);
        }
    }

    public void method_763(class_264 var1, class_86 var2) {
        var1.method_2016(this, var2);
        var1.method_1931(this, var2);
    }
}
