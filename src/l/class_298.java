package l;

import g.class_313;
import h.class_116;
import h.class_117;
import h.class_89;
import h.class_93;
import i.class_277;
import l.class_293;
import l.class_301;
import l.class_303;
import m.class_40;
import m.class_43;
import m.class_83;
import m.class_86;
import m.class_87;

// $FF: renamed from: l.l
public class class_298 extends class_293 {

    // $FF: renamed from: a m.as[]
    public class_43[] field_1764;
    // $FF: renamed from: a int[]
    int[] field_1765;
    // $FF: renamed from: b int[]
    int[] field_1766;
    // $FF: renamed from: a l.f[]
    class_303[] field_1767;
    // $FF: renamed from: a i.f
    class_277 field_1768;
    // $FF: renamed from: c boolean
    boolean field_1769;
    // $FF: renamed from: a l.f
    public class_303 field_1770;
    // $FF: renamed from: a g.p
    public class_313 field_1771;

    // $FF: renamed from: <init> (l.j, h.cj, m.as[], m.v, l.f) void
    public class_298(class_293 var1, class_89 var2, class_43[] var3, class_86 var4, class_303 var5) {
        super(var1, var2);
        class_277 var10001 = new class_277();
        this.field_1768 = var10001;
        this.field_1769 = var4 == var4.method_635();
        this.field_1764 = var3;
        int var6 = var3.length;
        int var7 = var6 / 32 + 1;
        this.field_1765 = new int[var7];
        this.field_1766 = new int[var7];
        this.field_1767 = new class_303[var6];
        boolean var8 = !this.field_1769 || var4.method_577().field_1946;
        for (int var9 = 0; var9 < var6; ++var9) {
            class_43 var10 = var3[var9];
            this.field_1768.method_2501(var10, var9);
            if (var10.method_171(true)) {
                if (var8 || var10.field_177 != 21 && var10.field_177 != 25) {
                    this.field_1765[var9 / 32] |= 1 << var9 % 32;
                }
                this.field_1767[var9] = var5.method_3107();
            } else {
                this.field_1767[var9] = class_301.field_1784;
            }
        }
        if (!this.field_1769) {
            System.arraycopy(this.field_1765, 0, this.field_1766, 0, var7);
        }
        this.field_1770 = class_301.field_1784;
    }

    // $FF: renamed from: a (h.ci) void
    public void method_3061(class_93 var1) {
        class_87 var2 = var1.field_478;
        if ((var1.field_488.field_273 & 805306368) == 0 || var2.method_577().field_1944) {
            Object var3 = null;
            byte var4 = 0;
            int var5 = 0;
            label32:
            for (int var6 = this.field_1764.length; var5 < var6; ++var5) {
                int var7 = this.field_1768.method_2499(this.field_1764[var5]);
                if ((this.field_1765[var7 / 32] & 1 << var7 % 32) == 0) {
                    for (int var8 = 0; var8 < var4; ++var8) {
                        if (((Object[])var3)[var8] == this.field_1764[var5]) {
                            continue label32;
                        }
                    }
                    var2.method_644().method_1808(this.field_1764[var7], var1, var1.field_485[var7]);
                }
            }
        }
    }

    // $FF: renamed from: a (m.v, h.bl) void
    public void method_3062(class_86 var1, class_117 var2) {
        int var3 = 0;
        for (int var4 = this.field_1764.length; var3 < var4; ++var3) {
            int var5 = this.field_1768.method_2499(this.field_1764[var3]);
            int var6 = var5 / 32;
            int var7 = 1 << var5 % 32;
            if ((this.field_1765[var6] & var7) == 0) {
                var1.method_644().method_1797(this.field_1764[var5], var2.field_621[var5].field_660);
            } else if ((this.field_1766[var6] & var7) == 0) {
                var1.method_644().method_1563(this.field_1764[var5], var2.field_621[var5].field_660);
            }
        }
    }

    // $FF: renamed from: a () java.lang.String
    public String method_3039() {
        StringBuffer var1 = new StringBuffer("Exception flow context");
        int var2 = this.field_1764.length;
        for (int var3 = 0; var3 < var2; ++var3) {
            int var4 = var3 / 32;
            int var5 = 1 << var3 % 32;
            var1.append('[').append(this.field_1764[var3].method_103());
            if ((this.field_1765[var4] & var5) != 0) {
                if ((this.field_1766[var4] & var5) == 0) {
                    var1.append("-masked");
                } else {
                    var1.append("-reached");
                }
            } else {
                var1.append("-not reached");
            }
            var1.append('-').append(this.field_1767[var3].toString()).append(']');
        }
        var1.append("[initsOnReturn -").append(this.field_1770.toString()).append(']');
        return var1.toString();
    }

    // $FF: renamed from: a (m.as) l.f
    public class_303 method_3063(class_43 var1) {
        int var2;
        return (var2 = this.field_1768.method_2499(var1)) < 0 ? class_301.field_1784 : this.field_1767[var2];
    }

    // $FF: renamed from: a (m.s) void
    public void method_3064(class_40 var1) {
        if (this.field_1771 == null) {
            class_313 var10001 = new class_313(5);
            this.field_1771 = var10001;
            for (int var2 = 0; var2 < this.field_1764.length; ++var2) {
                this.field_1771.method_34(this.field_1764[var2]);
            }
        }
        boolean var4 = false;
        for (int var3 = this.field_1771.method_29() - 1; var3 >= 0; --var3) {
            switch (class_83.method_566(var1, (class_40)this.field_1771.method_36(var3))) {
                case -1:
                    var4 = true;
                case 0:
                default:
                    break;
                case 1:
                    this.field_1771.method_3163(var3);
            }
        }
        if (!var4) {
            this.field_1771.method_34(var1);
        }
    }

    // $FF: renamed from: a (m.as, l.f, m.s, h.cj, boolean) void
    public void method_3065(class_43 var1, class_303 var2, class_40 var3, class_89 var4, boolean var5) {
        int var6 = this.field_1768.method_2499(var1);
        int var7 = var6 / 32;
        int var8 = 1 << var6 % 32;
        if (!var5) {
            this.field_1766[var7] |= var8;
        }
        this.field_1765[var7] |= var8;
        this.field_1767[var6] = (this.field_1767[var6].field_1783 & 1) == 0 ? this.field_1767[var6].method_3105(var2) : var2.method_3107();
    }

    // $FF: renamed from: a (l.f) void
    public void method_3048(class_303 var1) {
        if ((var1.field_1783 & 1) == 0) {
            if ((this.field_1770.field_1783 & 1) == 0) {
                this.field_1770 = this.field_1770.method_3105(var1);
            } else {
                this.field_1770 = (class_303)var1.method_3078();
            }
        }
    }

    // $FF: renamed from: a () h.bi
    public class_116 method_3052() {
        return this.field_1739 instanceof class_116 ? (this.field_1740.method_3052() == this.field_1739 ? null : (class_116)this.field_1739) : null;
    }
}