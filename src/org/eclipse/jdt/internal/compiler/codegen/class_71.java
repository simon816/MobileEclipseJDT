package org.eclipse.jdt.internal.compiler.codegen;

import org.eclipse.jdt.internal.compiler.codegen.class_77;

public class class_71 {

    public int field_319;

    public int field_320;

    public class_77[] field_321;

    public class_71(int var1, int var2) {
        this.field_319 = var1;
        this.field_320 = var2;
    }

    public void method_443(class_77[] var1) {
        this.field_321 = var1;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        var1.append("[copy stack items from ").append(this.field_319).append(" to ").append(this.field_320);
        if (this.field_321 != null) {
            int var2 = 0;
            for (int var3 = this.field_321.length; var2 < var3; ++var2) {
                if (var2 > 0) {
                    var1.append(',');
                }
                var1.append(this.field_321[var2]);
            }
        }
        var1.append(']');
        return String.valueOf(var1);
    }
}
