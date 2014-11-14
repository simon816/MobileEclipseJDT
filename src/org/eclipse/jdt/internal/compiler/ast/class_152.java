package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.class_264;
import org.eclipse.jdt.internal.compiler.ast.class_151;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.class_42;
import org.eclipse.jdt.internal.compiler.lookup.class_80;
import org.eclipse.jdt.internal.compiler.lookup.class_83;
import org.eclipse.jdt.internal.compiler.lookup.class_84;
import org.eclipse.jdt.internal.compiler.lookup.class_86;
import org.eclipse.jdt.internal.compiler.problem.class_241;

public class class_152 extends class_151 {

    int field_734;

    public class_152(char[][] var1, int var2, long[] var3) {
        super(var1, var3);
        this.field_734 = var2;
    }

    public int method_1009() {
        return this.field_734;
    }

    protected class_40 method_1011(class_83 var1) {
        if (this.field_675 != null) {
            return this.field_675;
        } else {
            if (this.field_734 > 255) {
                var1.method_644().method_1768(this);
            }
            class_80 var2 = var1.method_586();
            class_42 var4;
            try {
                var2.field_363 = this;
                class_40 var3 = super.method_1011(var1);
                var4 = (class_42)(this.field_675 = var1.method_580(var3, this.field_734));
            } catch (class_241 var8) {
                var8.method_1438(this, var1.method_645().field_455);
                throw var8;
            } finally {
                var2.field_363 = null;
            }
            return var4;
        }
    }

    public StringBuffer method_924(int var1, StringBuffer var2) {
        super.method_924(var1, var2);
        int var3;
        if ((this.field_446 & 16384) != 0) {
            for (var3 = 0; var3 < this.field_734 - 1; ++var3) {
                var2.append("[]");
            }
            var2.append("...");
        } else {
            for (var3 = 0; var3 < this.field_734; ++var3) {
                var2.append("[]");
            }
        }
        return var2;
    }

    public void method_763(class_264 var1, class_86 var2) {
        var1.method_1995(this, var2);
        var1.method_1910(this, var2);
    }

    public void method_1021(class_264 var1, class_84 var2) {
        var1.method_1996(this, var2);
        var1.method_1911(this, var2);
    }
}
