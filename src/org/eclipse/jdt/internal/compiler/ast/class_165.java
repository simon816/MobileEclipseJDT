package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.class_264;
import org.eclipse.jdt.internal.compiler.ast.class_126;
import org.eclipse.jdt.internal.compiler.ast.class_146;
import org.eclipse.jdt.internal.compiler.ast.class_164;
import org.eclipse.jdt.internal.compiler.ast.class_92;
import org.eclipse.jdt.internal.compiler.lookup.class_320;
import org.eclipse.jdt.internal.compiler.lookup.class_86;

public class class_165 extends class_164 {

    public class_126 field_769;

    private class_92[] field_770;

    public class_165(class_146 var1, int var2) {
        this.field_767 = var1;
        this.field_444 = var2;
        this.field_445 = var1.field_445;
    }

    public class_320[] method_1071() {
        return new class_320[] {this.method_1074()[0].field_477};
    }

    public class_92[] method_1074() {
        if (this.field_770 == null) {
            class_92[] var10001 = new class_92[1];
            class_92 var10004 = new class_92(field_70, this.field_769.field_444, this.field_769.field_445, this.field_769);
            var10001[0] = var10004;
            this.field_770 = var10001;
        }
        return this.field_770;
    }

    public StringBuffer method_924(int var1, StringBuffer var2) {
        super.method_924(var1, var2);
        var2.append('(');
        this.field_769.method_924(var1, var2);
        return var2.append(')');
    }

    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2054(this, var2)) {
            if (this.field_767 != null) {
                this.field_767.method_763(var1, var2);
            }
            if (this.field_769 != null) {
                this.field_769.method_763(var1, var2);
            }
        }
        var1.method_1969(this, var2);
    }
}
