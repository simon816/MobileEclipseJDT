package h;

import a.class_331;
import c.class_264;
import h.class_126;
import h.class_137;
import h.class_146;
import i.class_268;
import l.class_293;
import l.class_301;
import l.class_303;
import m.class_40;
import m.class_65;
import m.class_83;
import m.class_86;

// $FF: renamed from: h.t
public class class_139 extends class_137 {

    // $FF: renamed from: a h.r
    public class_126 field_711;
    // $FF: renamed from: a h.bo
    public class_146 field_712;

    // $FF: renamed from: <init> (h.r, h.bo) void
    public class_139(class_126 var1, class_146 var2) {
        this.field_711 = var1;
        this.field_712 = var2;
        var2.field_446 |= 1073741824;
        this.field_446 |= 1984;
        this.field_444 = var1.field_444;
        this.field_445 = var2.field_445;
    }

    // $FF: renamed from: a (m.v, l.j, l.g) l.g
    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        class_65 var4 = this.field_711.method_920();
        if (var4 != null && (var4.field_301.field_178 & 2L) == 0L) {
            var2.method_3050(var1, var4, this.field_711, 1025, var3);
            class_303 var6 = this.field_711.method_814(var1, var2, var3).method_3109();
            class_301 var5 = var6.method_3078();
            var5.method_3094(var4);
            return class_301.method_3074(var5, var6.method_3078());
        } else {
            return this.field_711.method_814(var1, var2, var3).method_3109();
        }
    }

    // $FF: renamed from: a (m.v, i.o, boolean) void
    public void method_912(class_86 var1, class_268 var2, boolean var3) {
        int var4 = var2.field_1208;
        this.field_711.method_912(var1, var2, true);
        var2.method_2257(this.field_712.field_675);
        if (var3) {
            var2.method_2182(this.field_674);
        } else {
            var2.method_2352();
        }
        var2.method_2360(var4, this.field_444);
    }

    // $FF: renamed from: a_ (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_975(int var1, StringBuffer var2) {
        this.field_711.method_924(var1, var2).append(" instanceof ");
        return this.field_712.method_757(0, var2);
    }

    // $FF: renamed from: a (m.v) m.s
    public class_40 method_925(class_86 var1) {
        this.field_672 = class_331.field_1896;
        class_40 var2 = this.field_711.method_925(var1);
        class_40 var3 = this.field_712.method_1017(var1, true);
        if (var2 != null && var3 != null) {
            if (!var3.method_167()) {
                var1.method_644().method_1572(var3, this);
            } else if (var2 != class_40.field_187 && var2.method_148() || !this.method_908(var1, var3, var2, (class_126)null)) {
                var1.method_644().method_1709(this, var2, var3);
            }
            return this.field_675 = class_40.field_186;
        } else {
            return null;
        }
    }

    // $FF: renamed from: a (m.bb, m.s) void
    public void method_930(class_83 var1, class_40 var2) {
        if (this.field_711.field_675 != class_40.field_187) {
            var1.method_644().method_1793(this, var2);
        }
    }

    // $FF: renamed from: a (c.j, m.v) void
    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2028(this, var2)) {
            this.field_711.method_763(var1, var2);
            this.field_712.method_763(var1, var2);
        }
        var1.method_1943(this, var2);
    }
}
