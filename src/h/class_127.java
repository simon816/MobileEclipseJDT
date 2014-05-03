package h;

import a.class_331;
import c.class_264;
import h.class_126;
import h.class_128;
import h.class_146;
import i.class_268;
import l.class_293;
import l.class_301;
import m.class_40;
import m.class_42;
import m.class_86;

// $FF: renamed from: h.co
public class class_127 extends class_126 {

    // $FF: renamed from: a h.bo
    public class_146 field_676;
    // $FF: renamed from: a h.r[]
    public class_126[] field_677;
    // $FF: renamed from: a h.cr
    public class_128 field_678;

    // $FF: renamed from: <init> () void
    public class_127() {
    }

    // $FF: renamed from: a (m.v, l.j, l.g) l.g
    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        int var4 = 0;
        for (int var5 = this.field_677.length; var4 < var5; ++var4) {
            class_126 var6;
            if ((var6 = this.field_677[var4]) != null) {
                var3 = var6.method_814(var1, var2, var3);
            }
        }
        if (this.field_678 != null) {
            return this.field_678.method_814(var1, var2, var3);
        } else {
            return var3;
        }
    }

    // $FF: renamed from: a (m.v, i.o, boolean) void
    public void method_912(class_86 var1, class_268 var2, boolean var3) {
        int var4 = var2.field_1208;
        if (this.field_678 != null) {
            this.field_678.method_912(var1, var2, var3);
        } else {
            int var5 = 0;
            int var6 = 0;
            class_126 var8;
            for (int var7 = this.field_677.length; var6 < var7 && (var8 = this.field_677[var6]) != null; ++var6) {
                var8.method_912(var1, var2, true);
                ++var5;
            }
            if (var5 == 1) {
                var2.method_2345((class_42)this.field_675);
            } else {
                var2.method_2342(this.field_675, var5);
            }
            if (var3) {
                var2.method_2182(this.field_674);
            } else {
                var2.method_2352();
            }
            var2.method_2360(var4, this.field_444);
        }
    }

    // $FF: renamed from: c (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_924(int var1, StringBuffer var2) {
        var2.append("new ");
        this.field_676.method_757(0, var2);
        for (int var3 = 0; var3 < this.field_677.length; ++var3) {
            if (this.field_677[var3] == null) {
                var2.append("[]");
            } else {
                var2.append('[');
                this.field_677[var3].method_924(0, var2);
                var2.append(']');
            }
        }
        if (this.field_678 != null) {
            this.field_678.method_924(0, var2);
        }
        return var2;
    }

    // $FF: renamed from: a (m.v) m.s
    public class_40 method_925(class_86 var1) {
        class_40 var2 = this.field_676.method_1017(var1, true);
        this.field_672 = class_331.field_1896;
        if (var2 == class_40.field_188) {
            var1.method_644().method_1490(this);
            var2 = null;
        }
        int var3 = -1;
        int var4 = this.field_677.length;
        while (true) {
            --var4;
            if (var4 < 0) {
                break;
            }
            if (this.field_677[var4] != null) {
                if (var3 < 0) {
                    var3 = var4;
                }
            } else if (var3 > 0) {
                var1.method_644().method_1610(this, var3);
                break;
            }
        }
        if (this.field_678 == null) {
            if (var3 < 0) {
                var1.method_644().method_1685(this);
            }
            if (var2 != null && !var2.method_167()) {
                var1.method_644().method_1571(var2, this);
            }
        } else if (var3 >= 0) {
            var1.method_644().method_1494(this);
        }
        for (var4 = 0; var4 <= var3; ++var4) {
            class_126 var5;
            if ((var5 = this.field_677[var4]) != null) {
                class_40 var6 = var5.method_926(var1, class_40.field_179);
                if (var6 != null) {
                    this.field_677[var4].method_911(var1, class_40.field_179, var6);
                }
            }
        }
        if (var2 != null) {
            if (this.field_677.length > 255) {
                var1.method_644().method_1768(this);
            }
            this.field_675 = var1.method_580(var2, this.field_677.length);
            if (this.field_678 != null && this.field_678.method_926(var1, this.field_675) != null) {
                this.field_678.field_680 = (class_42)this.field_675;
            }
            if ((var2.field_178 & 128L) != 0L) {
                return null;
            }
        }
        return this.field_675;
    }

    // $FF: renamed from: a (c.j, m.v) void
    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_1993(this, var2)) {
            int var3 = this.field_677.length;
            this.field_676.method_763(var1, var2);
            for (int var4 = 0; var4 < var3; ++var4) {
                if (this.field_677[var4] != null) {
                    this.field_677[var4].method_763(var1, var2);
                }
            }
            if (this.field_678 != null) {
                this.field_678.method_763(var1, var2);
            }
        }
        var1.method_1908(this, var2);
    }
}
