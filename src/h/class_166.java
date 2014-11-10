package h;

import c.class_264;
import h.class_146;
import h.class_164;
import h.class_92;
import m.class_86;

public class class_166 extends class_164 {

    public class_166(class_146 var1, int var2) {
        this.field_767 = var1;
        this.field_444 = var2;
        this.field_445 = var1.field_445;
    }

    public class_92[] method_1074() {
        return field_764;
    }

    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2033(this, var2) && this.field_767 != null) {
            this.field_767.method_763(var1, var2);
        }
        var1.method_1948(this, var2);
    }
}
