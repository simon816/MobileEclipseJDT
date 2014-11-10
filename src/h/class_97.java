package h;

import c.class_264;
import c.class_284;
import c.class_288;
import h.class_123;
import h.class_126;
import h.class_90;
import h.class_92;
import h.class_96;
import j.class_278;
import m.class_320;
import m.class_40;
import m.class_84;

public class class_97 extends class_96 {

    public class_126 field_499;

    public int field_500;

    public class_97(class_284 var1) {
        super(var1);
    }

    public void method_790(class_288 var1) {
        var1.method_2995(this.field_488);
        int var2 = var1.field_1719;
        int var3 = var1.method_2994(this.field_488, this);
        var1.method_2986(var2, var3);
    }

    public boolean method_793() {
        return true;
    }

    public void method_800(class_278 var1, class_90 var2) {}

    public StringBuffer method_757(int var1, StringBuffer var2) {
        method_759(var1, var2);
        method_760(this.field_482, var2);
        if (this.field_483 != null) {
            method_758(this.field_483, var2);
        }
        class_123[] var3 = this.method_807();
        int var4;
        if (var3 != null) {
            var2.append('<');
            var4 = var3.length - 1;
            for (int var5 = 0; var5 < var4; ++var5) {
                var3[var5].method_757(0, var2);
                var2.append(", ");
            }
            var3[var4].method_757(0, var2);
            var2.append('>');
        }
        this.method_802(0, var2).append(this.field_479).append('(');
        if (this.field_484 != null) {
            for (var4 = 0; var4 < this.field_484.length; ++var4) {
                if (var4 > 0) {
                    var2.append(", ");
                }
                this.field_484[var4].method_757(0, var2);
            }
        }
        var2.append(')');
        if (this.field_485 != null) {
            var2.append(" throws ");
            for (var4 = 0; var4 < this.field_485.length; ++var4) {
                if (var4 > 0) {
                    var2.append(", ");
                }
                this.field_485[var4].method_757(0, var2);
            }
        }
        if (this.field_499 != null) {
            var2.append(" default ");
            this.field_499.method_757(0, var2);
        }
        this.method_801(var1 + 1, var2);
        return var2;
    }

    public void method_805() {
        super.method_805();
        if (this.field_484 != null) {
            this.field_478.method_644().method_1468(this);
        }
        if (this.field_498 != null) {
            this.field_478.method_644().method_1469(this);
        }
        if (this.field_500 != 0) {
            this.field_478.method_644().method_1569(this);
        }
        if (this.field_488 != null) {
            class_40 var1 = this.field_488.field_275;
            if (var1 != null) {
                label35: {
                    class_40 var2 = var1.method_173();
                    if (var1.method_136() <= 1) {
                        switch (var2.method_138().field_177) {
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 16:
                                break label35;
                            case 6:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                            default:
                                if (var2.method_153() || var2.method_145()) {
                                    break label35;
                                }
                        }
                    }
                    this.field_478.method_644().method_1622(this);
                }
                if (this.field_499 != null) {
                    class_92 var10000 = new class_92(this.field_479, this.field_444, this.field_445, this.field_499);
                    class_92 var3 = var10000;
                    var3.field_476 = this.field_488;
                    var3.method_784(this.field_478, var1);
                    this.field_488.method_379(class_320.method_3197(this.field_499));
                } else {
                    this.field_488.method_379((Object)null);
                }
            }
        }
    }

    public void method_806(class_264 var1, class_84 var2) {
        if (var1.method_1991(this, var2)) {
            if (this.field_483 != null) {
                int var3 = this.field_483.length;
                for (int var4 = 0; var4 < var3; ++var4) {
                    this.field_483[var4].method_763(var1, this.field_478);
                }
            }
            if (this.field_497 != null) {
                this.field_497.method_763(var1, this.field_478);
            }
            if (this.field_499 != null) {
                this.field_499.method_763(var1, this.field_478);
            }
        }
        var1.method_1906(this, var2);
    }
}
