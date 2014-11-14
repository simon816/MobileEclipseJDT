package org.eclipse.jdt.internal.compiler.flow;

import org.eclipse.jdt.internal.compiler.ast.class_116;
import org.eclipse.jdt.internal.compiler.ast.class_89;
import org.eclipse.jdt.internal.compiler.flow.class_293;
import org.eclipse.jdt.internal.compiler.flow.class_301;
import org.eclipse.jdt.internal.compiler.flow.class_303;

public class class_294 extends class_293 {

    public class_303 field_1744;

    public class_294(class_293 var1, class_89 var2) {
        super(var1, var2);
        this.field_1744 = class_301.field_1784;
    }

    public String method_3039() {
        StringBuffer var1 = new StringBuffer("Inside SubRoutine flow context");
        var1.append("[initsOnReturn -").append(this.field_1744.toString()).append(']');
        return var1.toString();
    }

    public boolean method_3042() {
        return ((class_116)this.field_1739).method_876();
    }

    public void method_3048(class_303 var1) {
        if ((var1.field_1783 & 1) == 0) {
            if (this.field_1744 == class_301.field_1784) {
                this.field_1744 = (class_303)var1.method_3078();
            } else {
                this.field_1744 = this.field_1744.method_3105(var1);
            }
        }
    }

    public class_116 method_3052() {
        return (class_116)this.field_1739;
    }
}
