package m;

import b.class_233;
import g.class_13;
import g.class_313;
import m.class_34;
import m.class_38;
import m.class_43;
import m.class_49;
import m.class_80;

public class class_50 extends class_49 {

    public class_50(class_38 var1, char[][] var2, class_80 var3) {
        this.field_197 = var2;
        this.method_198();
        this.field_178 |= 131264L;
        this.field_238 = var3;
        this.field_200 = var1;
        this.field_201 = new String(class_233.method_1361(var2, '/'));
        this.field_198 = var2[var2.length - 1];
        this.field_199 = 1;
        this.field_231 = null;
        this.field_233 = class_34.field_155;
        this.field_237 = class_34.field_157;
        this.field_236 = class_34.field_156;
        this.field_234 = class_34.field_153;
        this.field_235 = class_34.field_154;
    }

    public class_13 method_132(class_13 var1) {
        if (var1 == null) {
            class_313 var10000 = new class_313(5);
            var1 = var10000;
        } else if (((class_13)var1).method_30(this)) {
            return (class_13)var1;
        }
        ((class_13)var1).method_34(this);
        return (class_13)var1;
    }

    public int method_102() {
        return 1;
    }

    void method_279(class_43 var1) {
        this.field_231 = var1;
    }

    public String toString() {
        return "[MISSING:" + new String(class_233.method_1361(this.field_197, '.')) + "]";
    }
}
