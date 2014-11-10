package m;

import b.class_233;
import m.class_34;
import m.class_40;
import m.class_43;
import m.class_45;
import m.class_46;
import m.class_52;
import m.class_58;
import m.class_62;
import m.class_80;

public class class_53 extends class_52 {

    public class_53(class_43 var1, class_43 var2, class_80 var3) {
        super(var1, (class_40[])null, var2, var3);
        if (var2 == null || (var2.field_199 & 1073741824) == 0) {
            this.field_199 &= -1073741825;
        }
    }

    public class_62 method_285(class_58 var1) {
        return (class_62)(var1.field_279 != class_34.field_157 && !var1.method_370() ? this.field_244.method_498(var1, this) : super.method_285(var1));
    }

    public int method_98() {
        return 1028;
    }

    public String method_135() {
        StringBuffer var1 = new StringBuffer(10);
        var1.append(this.method_283().method_179()).append("#RAW");
        return var1.toString();
    }

    public char[] method_142() {
        if (this.field_245 == null) {
            if ((this.field_199 & 1073741824) == 0) {
                this.field_245 = this.method_286().method_178();
            } else {
                StringBuffer var1 = new StringBuffer(10);
                if (this.method_159()) {
                    class_43 var2 = this.method_137();
                    char[] var3 = var2.method_142();
                    var1.append(var3, 0, var3.length - 1);
                    if ((var2.field_199 & 1073741824) != 0) {
                        var1.append('.');
                    } else {
                        var1.append('$');
                    }
                    var1.append(this.method_179());
                } else {
                    char[] var4 = this.method_286().method_178();
                    var1.append(var4, 0, var4.length - 1);
                }
                var1.append(';');
                int var5 = var1.length();
                this.field_245 = new char[var5];
                var1.getChars(0, var5, this.field_245, 0);
            }
        }
        return this.field_245;
    }

    public boolean method_154(class_40 var1) {
        if (this == var1) {
            return true;
        } else if (var1 == null) {
            return false;
        } else {
            switch (var1.method_98()) {
                case 260:
                case 1028:
                case 2052:
                    return this.method_138() == var1.method_138();
                case 516:
                case 8196:
                    return ((class_45)var1).method_250(this);
                default:
                    return false;
            }
        }
    }

    public boolean method_164(class_40 var1) {
        if (this == var1) {
            return false;
        } else if (var1 == null) {
            return true;
        } else {
            switch (var1.method_98()) {
                case 260:
                case 1028:
                case 2052:
                    return this.method_138() != var1.method_138();
                default:
                    return true;
            }
        }
    }

    public boolean method_162() {
        return false;
    }

    public boolean method_166() {
        return true;
    }

    protected void method_288() {
        class_46[] var1 = this.method_286().method_181();
        int var2 = var1.length;
        class_40[] var3 = new class_40[var2];
        for (int var4 = 0; var4 < var2; ++var4) {
            var3[var4] = this.field_244.method_490(var1[var4].method_138(), false);
        }
        this.field_243 = var3;
    }

    public char[] method_103() {
        char[] var1;
        if (this.method_159()) {
            var1 = class_233.method_1357(this.method_137().method_103(), this.field_198, '.');
        } else {
            var1 = class_233.method_1361(this.method_283().field_197, '.');
        }
        return var1;
    }

    public char[] method_104() {
        char[] var1;
        if (this.method_159()) {
            var1 = class_233.method_1357(this.method_137().method_104(), this.field_198, '.');
        } else {
            var1 = this.method_283().field_198;
        }
        return var1;
    }
}
