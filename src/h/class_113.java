package h;

import c.class_264;
import h.class_126;
import h.class_98;
import i.class_268;
import l.class_293;
import l.class_301;
import m.class_40;
import m.class_86;

// $FF: renamed from: h.bn
public class class_113 extends class_98 {

    // $FF: renamed from: a h.r
    public class_126 field_575;
    // $FF: renamed from: a m.s
    public class_40 field_576;

    // $FF: renamed from: <init> (h.r, int, int) void
    public class_113(class_126 var1, int var2, int var3) {
        this.field_575 = var1;
        this.field_444 = var2;
        this.field_445 = var3;
    }

    // $FF: renamed from: a (m.v, l.j, l.g) l.g
    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        this.field_575.method_814(var1, var2, var3);
        this.field_575.method_909(var1, var2, var3);
        var2.method_3032(this.field_576, this, var3, var1);
        return class_301.field_1784;
    }

    // $FF: renamed from: a (m.v, i.o) void
    public void method_818(class_86 var1, class_268 var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            int var3 = var2.field_1208;
            this.field_575.method_912(var1, var2, true);
            var2.method_2107();
            var2.method_2360(var3, this.field_444);
        }
    }

    // $FF: renamed from: b (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_820(int var1, StringBuffer var2) {
        method_759(var1, var2).append("throw ");
        this.field_575.method_924(0, var2);
        return var2.append(';');
    }

    // $FF: renamed from: a (m.v) void
    public void method_821(class_86 var1) {
        this.field_576 = this.field_575.method_925(var1);
        if (this.field_576 != null && this.field_576.method_101()) {
            if (this.field_576 == class_40.field_187) {
                if (var1.method_577().field_1927 <= 3080192L) {
                    var1.method_644().method_1503(this.field_575);
                }
            } else if (this.field_576.method_139(21, true) == null) {
                var1.method_644().method_1504(this.field_575, this.field_576);
            }
            this.field_575.method_911(var1, this.field_576, this.field_576);
        }
    }

    // $FF: renamed from: a (c.j, m.v) void
    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2063(this, var2)) {
            this.field_575.method_763(var1, var2);
        }
        var1.method_1978(this, var2);
    }
}