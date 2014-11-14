package m;

import b.CharOperation;
import m.class_38;
import m.class_40;
import m.class_43;
import m.class_80;

public class class_44 extends class_43 {

    class_43 field_208;

    class_40[] field_209;

    class_44(char[][] var1, class_38 var2) {
        this.field_197 = var1;
        this.field_198 = var1[var1.length - 1];
        this.field_200 = var2;
        this.field_209 = null;
    }

    void method_246(class_40 var1, class_80 var2) {
        if (this.field_208 != null) {
            var1.method_180(this, this.field_208, var2);
        } else {
            if (this.field_209 == null) {
                this.field_209 = new class_40[] {var1};
            } else {
                int var3 = this.field_209.length;
                System.arraycopy(this.field_209, 0, this.field_209 = new class_40[var3 + 1], 0, var3);
                this.field_209[var3] = var1;
            }
        }
    }

    public String method_135() {
        return this.toString();
    }

    class_43 method_247(class_80 var1, boolean var2) {
        Object var3 = this.field_208;
        if (var3 == null) {
            var3 = this.field_200.method_124(this.field_197[this.field_197.length - 1]);
            if (var3 == this) {
                var3 = var1.method_481(this.field_197);
            }
            if (var3 == null || var3 == this) {
                if ((this.field_178 & 128L) == 0L) {
                    var1.field_353.method_1655(this.field_197, var1.field_362, var1.field_363);
                }
                var3 = var1.method_496((class_38)null, this.field_197);
            }
            this.method_248((class_43)var3, var1);
        }
        if (var2) {
            var3 = (class_43)var1.method_491((class_40)var3);
        }
        return (class_43)var3;
    }

    void method_248(class_43 var1, class_80 var2) {
        if (this.field_208 != var1) {
            this.field_208 = var1;
            if (this.field_209 != null) {
                int var3 = 0;
                for (int var4 = this.field_209.length; var3 < var4; ++var3) {
                    this.field_209[var3].method_180(this, var1, var2);
                }
            }
            var2.method_520(this, var1);
        }
    }

    public String toString() {
        return "Unresolved type " + (this.field_197 != null ? CharOperation.method_1389(this.field_197) : "UNNAMED");
    }
}
