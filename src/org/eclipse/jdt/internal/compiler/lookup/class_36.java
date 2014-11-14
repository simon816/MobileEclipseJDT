package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ast.class_91;
import org.eclipse.jdt.internal.compiler.lookup.class_34;
import org.eclipse.jdt.internal.compiler.lookup.class_35;
import org.eclipse.jdt.internal.compiler.lookup.class_43;

public class class_36 extends class_35 {

    public class_43 field_166;

    public class_36(char[][] var1, class_34 var2, class_43 var3, class_91 var4) {
        super(var1, false, var2, var4);
        this.field_166 = var3;
    }

    public char[] method_103() {
        return CharOperation.method_1361(this.field_162, '.');
    }

    public String toString() {
        return "method import : " + new String(this.method_103());
    }
}
