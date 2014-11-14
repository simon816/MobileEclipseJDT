package h;

import a.class_331;
import b.CharOperation;
import c.class_264;
import h.class_124;
import h.class_146;
import h.class_93;
import m.class_34;
import m.class_40;
import m.class_42;
import m.class_65;
import m.class_67;
import m.class_86;
import m.class_87;

public class class_125 extends class_124 {

    private static final char[] field_671;

    public class_125(char[] var1, long var2, class_146 var4, int var5) {
        super(var1, (int)(var2 >>> 32), (int)var2);
        this.field_652 = (int)var2;
        this.field_656 = var5;
        this.field_660 = var4;
        this.field_446 |= 1073741824;
    }

    public void method_903(class_87 var1, class_40 var2, boolean var3) {
        class_34 var4 = var1.method_598(this.field_659, 3, this, false);
        if (var4 != null && var4.method_101()) {
            if (var4 instanceof class_65 && this.field_654 == 0) {
                var1.method_644().method_1744(this);
            } else {
                boolean var5 = false;
                if (var4 instanceof class_67) {
                    if (var1.method_726()) {
                        var5 = true;
                    } else {
                        class_93 var6 = var1.method_730();
                        if (var6 != null && CharOperation.method_1381(field_671, var6.field_479)) {
                            var5 = true;
                        }
                    }
                }
                var1.method_644().method_1661(this, var4, var5);
            }
        }
        if (this.field_670 == null) {
            class_65 var10001 = new class_65(this, var2, this.field_656, true);
            this.field_670 = var10001;
        }
        var1.method_704(this.field_670);
        method_761(var1, this.field_658, this.field_670);
        this.field_670.field_309 = this;
        this.field_670.field_307 = var3 ? 1 : 0;
    }

    public int method_887() {
        return 5;
    }

    public boolean method_904() {
        return this.field_660 != null && (this.field_660.field_446 & 16384) != 0;
    }

    public StringBuffer method_757(int var1, StringBuffer var2) {
        method_759(var1, var2);
        method_760(this.field_656, var2);
        if (this.field_658 != null) {
            method_758(this.field_658, var2);
        }
        if (this.field_660 == null) {
            var2.append("<no type> ");
        } else {
            this.field_660.method_757(0, var2).append(' ');
        }
        return var2.append(this.field_659);
    }

    public StringBuffer method_820(int var1, StringBuffer var2) {
        return this.method_757(var1, var2).append(';');
    }

    public class_40 method_905(class_86 var1) {
        class_40 var2 = this.field_660.method_1017(var1, true);
        boolean var3;
        if (var2 == null) {
            var3 = true;
        } else {
            var3 = false;
            switch (var2.method_98()) {
                case 68:
                    if (((class_42)var2).field_192 == class_40.field_188) {
                        var1.method_644().method_1822(this);
                        var3 = true;
                    }
                    break;
                case 260:
                    if (var2.method_149()) {
                        var3 = true;
                        var1.method_644().method_1637(var2, this);
                    }
                    break;
                case 4100:
                    var1.method_644().method_1643(var2, this);
                    var3 = true;
            }
            if (var2.method_139(21, true) == null && var2.method_101()) {
                var1.method_644().method_1504(this.field_660, var2);
                var3 = true;
            }
        }
        class_34 var4 = var1.method_598(this.field_659, 3, this, false);
        if (var4 != null && var4.method_101()) {
            if (var4 instanceof class_65 && this.field_654 == 0) {
                var1.method_644().method_1744(this);
            } else {
                var1.method_644().method_1661(this, var4, false);
            }
        }
        class_65 var10001 = new class_65(this, var2, this.field_656, false);
        this.field_670 = var10001;
        method_761(var1, this.field_658, this.field_670);
        var1.method_704(this.field_670);
        this.field_670.method_410(class_331.field_1896);
        return var3 ? null : var2;
    }

    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_1992(this, var2)) {
            if (this.field_658 != null) {
                int var3 = this.field_658.length;
                for (int var4 = 0; var4 < var3; ++var4) {
                    this.field_658[var4].method_763(var1, var2);
                }
            }
            if (this.field_660 != null) {
                this.field_660.method_763(var1, var2);
            }
        }
        var1.method_1907(this, var2);
    }

    static {
        field_671 = "set".toCharArray();
    }
}
