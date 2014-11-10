package h;

import c.class_264;
import h.class_146;
import h.class_159;
import m.class_40;
import m.class_86;

public class class_160 extends class_159 {

    public class_160(class_146 var1, int var2, int var3) {
        super(var1, var2, var3);
    }

    public boolean method_754() {
        return true;
    }

    public boolean method_755() {
        return false;
    }

    public StringBuffer method_924(int var1, StringBuffer var2) {
        return this.field_746.method_757(0, var2).append(".super");
    }

    public class_40 method_925(class_86 var1) {
        if ((this.field_446 & 534773760) != 0) {
            var1.method_644().method_1638(this);
            return null;
        } else {
            super.method_925(var1);
            if (this.field_747 == null) {
                return null;
            } else if (this.field_747.field_177 == 1) {
                var1.method_644().method_1506(this);
                return null;
            } else {
                return this.field_675 = this.field_747.method_240();
            }
        }
    }

    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2049(this, var2)) {
            this.field_746.method_763(var1, var2);
        }
        var1.method_1964(this, var2);
    }
}
