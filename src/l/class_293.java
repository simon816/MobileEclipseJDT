package l;

import b.class_233;
import h.class_104;
import h.class_116;
import h.class_117;
import h.class_126;
import h.class_154;
import h.class_89;
import h.class_93;
import i.class_74;
import l.class_294;
import l.class_298;
import l.class_301;
import l.class_303;
import l.class_304;
import m.class_17;
import m.class_34;
import m.class_40;
import m.class_43;
import m.class_64;
import m.class_65;
import m.class_83;
import m.class_86;

// $FF: renamed from: l.j
public class class_293 implements class_17 {

    // $FF: renamed from: a l.j
    public static final class_293 field_1738;
    // $FF: renamed from: a h.cj
    public class_89 field_1739;
    // $FF: renamed from: b l.j
    public class_293 field_1740;
    // $FF: renamed from: a l.d
    public class_304 field_1741;
    // $FF: renamed from: a boolean
    boolean field_1742;
    // $FF: renamed from: b boolean
    boolean field_1743;

    // $FF: renamed from: <init> (l.j, h.cj) void
    public class_293(class_293 var1, class_89 var2) {
        this.field_1740 = var1;
        this.field_1739 = var2;
        if (var1 != null) {
            this.field_1742 = var1.field_1742 || var1.field_1743;
            this.field_1741 = var1.field_1741;
        }
    }

    // $FF: renamed from: b () i.s
    public class_74 method_3031() {
        return null;
    }

    // $FF: renamed from: a (m.s, h.cj, l.g, m.v) void
    public void method_3032(class_40 var1, class_89 var2, class_301 var3, class_86 var4) {
        for (class_293 var5 = this; var5 != null; var5 = var5.field_1740) {
            class_116 var6;
            if ((var6 = var5.method_3052()) != null && var6.method_876()) {
                return;
            }
            if (var5 instanceof class_298) {
                class_298 var7 = (class_298)var5;
                class_43[] var8 = var7.field_1764;
                if (var7.field_1764 != class_34.field_151) {
                    boolean var9 = false;
                    int var10 = 0;
                    for (int var11 = var8.length; var10 < var11; ++var10) {
                        class_43 var12 = var8[var10];
                        int var13 = var12 == null ? -1 : class_83.method_566(var1, var12);
                        switch (var13) {
                            case -1:
                                var7.method_3065(var12, var3.method_3109(), var1, var2, var9);
                                var9 = true;
                                break;
                            case 1:
                                var7.method_3065(var12, var3.method_3109(), var1, var2, false);
                        }
                    }
                    if (var9) {
                        return;
                    }
                }
                if (var7.field_1769) {
                    if (var1.method_171(false)) {
                        return;
                    }
                    if (var7.field_1739 instanceof class_93) {
                        class_93 var16 = (class_93)var7.field_1739;
                        if (var16.method_795() && var16.field_488.field_278.method_146()) {
                            var7.method_3064(var1);
                            return;
                        }
                    }
                    break;
                }
            }
            var5.method_3048(var3.method_3109());
            if (var5 instanceof class_294) {
                class_89 var14 = var5.field_1739;
                if (var14 instanceof class_117) {
                    class_117 var15 = (class_117)var14;
                    var3.method_3071(var15.field_624);
                }
            }
        }
        var4.method_644().method_1786(var1, var2);
    }

    // $FF: renamed from: a (m.s[], h.cj, l.g, m.v) void
    public void method_3033(class_40[] var1, class_89 var2, class_301 var3, class_86 var4) {
        int var6;
        if (var1 != null && (var6 = var1.length) != 0) {
            int var5 = var6;
            System.arraycopy(var1, 0, var1 = new class_40[var6], 0, var6);
            for (class_293 var7 = this; var7 != null; var7 = var7.field_1740) {
                class_116 var8;
                if ((var8 = var7.method_3052()) != null && var8.method_876()) {
                    return;
                }
                if (var7 instanceof class_298) {
                    class_298 var9 = (class_298)var7;
                    class_43[] var10 = var9.field_1764;
                    int var11;
                    if (var9.field_1764 != class_34.field_151) {
                        var11 = var10.length;
                        boolean[] var12 = new boolean[var6];
                        int var13;
                        for (var13 = 0; var13 < var11; ++var13) {
                            class_43 var14 = var10[var13];
                            for (int var15 = 0; var15 < var6; ++var15) {
                                class_40 var16;
                                if ((var16 = var1[var15]) != null) {
                                    int var17 = var14 == null ? -1 : class_83.method_566(var16, var14);
                                    switch (var17) {
                                        case -1:
                                            var9.method_3065(var14, var3.method_3109(), var16, var2, var12[var15]);
                                            if (!var12[var15]) {
                                                var12[var15] = true;
                                                --var5;
                                            }
                                            break;
                                        case 1:
                                            var9.method_3065(var14, var3.method_3109(), var16, var2, false);
                                    }
                                }
                            }
                        }
                        for (var13 = 0; var13 < var6; ++var13) {
                            if (var12[var13]) {
                                var1[var13] = null;
                            }
                        }
                    }
                    if (var9.field_1769) {
                        for (var11 = 0; var11 < var6; ++var11) {
                            class_40 var23;
                            if ((var23 = var1[var11]) != null && var23.method_171(false)) {
                                --var5;
                                var1[var11] = null;
                            }
                        }
                        if (var9.field_1739 instanceof class_93) {
                            class_93 var25 = (class_93)var9.field_1739;
                            if (var25.method_795() && var25.field_488.field_278.method_146()) {
                                for (int var24 = 0; var24 < var6; ++var24) {
                                    class_40 var26;
                                    if ((var26 = var1[var24]) != null) {
                                        var9.method_3064(var26);
                                    }
                                }
                                return;
                            }
                        }
                        break;
                    }
                }
                if (var5 == 0) {
                    return;
                }
                var7.method_3048(var3.method_3109());
                if (var7 instanceof class_294) {
                    class_89 var19 = var7.field_1739;
                    if (var19 instanceof class_117) {
                        class_117 var21 = (class_117)var19;
                        var3.method_3071(var21.field_624);
                    }
                }
            }
            label107:
            for (int var18 = 0; var18 < var6; ++var18) {
                class_40 var20;
                if ((var20 = var1[var18]) != null) {
                    for (int var22 = 0; var22 < var18; ++var22) {
                        if (var1[var22] == var20) {
                            continue label107;
                        }
                    }
                    var4.method_644().method_1786(var20, var2);
                }
            }
        }
    }

    // $FF: renamed from: a () i.s
    public class_74 method_3034() {
        return null;
    }

    // $FF: renamed from: a (char[]) l.j
    public class_293 method_3035(char[] var1) {
        class_293 var2 = this;
        for (class_293 var3 = null; var2 != null; var2 = var2.field_1740) {
            if (var2.method_3042()) {
                var3 = var2;
            }
            char[] var4;
            if ((var4 = var2.method_3043()) != null && class_233.method_1364(var4, var1)) {
                ((class_104)var2.field_1739).field_446 |= 64;
                if (var3 == null) {
                    return var2;
                }
                return var3;
            }
        }
        return null;
    }

    // $FF: renamed from: b (char[]) l.j
    public class_293 method_3036(char[] var1) {
        class_293 var2 = this;
        class_293 var3 = null;
        for (class_293 var4 = null; var2 != null; var2 = var2.field_1740) {
            if (var2.method_3042()) {
                var4 = var2;
            } else if (var2.method_3041()) {
                var3 = var2;
            }
            char[] var5;
            if ((var5 = var2.method_3043()) != null && class_233.method_1364(var5, var1)) {
                ((class_104)var2.field_1739).field_446 |= 64;
                if (var3 != null && var2.field_1739.method_750() == var3.field_1739) {
                    if (var4 == null) {
                        return var3;
                    }
                    return var4;
                }
                return field_1738;
            }
        }
        return null;
    }

    // $FF: renamed from: a () l.j
    public class_293 method_3037() {
        class_293 var1 = this;
        for (class_293 var2 = null; var1 != null; var1 = var1.field_1740) {
            if (var1.method_3042()) {
                var2 = var1;
            }
            if (var1.method_3040() && var1.method_3043() == null) {
                if (var2 == null) {
                    return var1;
                }
                return var2;
            }
        }
        return null;
    }

    // $FF: renamed from: b () l.j
    public class_293 method_3038() {
        class_293 var1 = this;
        for (class_293 var2 = null; var1 != null; var1 = var1.field_1740) {
            if (var1.method_3042()) {
                var2 = var1;
            }
            if (var1.method_3041()) {
                if (var2 == null) {
                    return var1;
                }
                return var2;
            }
        }
        return null;
    }

    // $FF: renamed from: a () java.lang.String
    public String method_3039() {
        return "Flow context";
    }

    // $FF: renamed from: c () boolean
    public boolean method_3040() {
        return false;
    }

    // $FF: renamed from: b () boolean
    public boolean method_3041() {
        return false;
    }

    // $FF: renamed from: a () boolean
    public boolean method_3042() {
        return false;
    }

    // $FF: renamed from: a () char[]
    public char[] method_3043() {
        return null;
    }

    // $FF: renamed from: a (l.g) void
    public void method_3044(class_301 var1) {}

    // $FF: renamed from: a (l.j) void
    public void method_3045(class_293 var1) {}

    // $FF: renamed from: a (l.j, l.g) void
    public void method_3046(class_293 var1, class_301 var2) {}

    // $FF: renamed from: a (m.q, h.bb) boolean
    protected boolean method_3047(class_64 var1, class_154 var2) {
        return true;
    }

    // $FF: renamed from: a (l.f) void
    public void method_3048(class_303 var1) {}

    // $FF: renamed from: a (m.q, h.bb, l.g) void
    public void method_3049(class_64 var1, class_154 var2, class_301 var3) {
        if ((var3.field_1783 & 1) == 0) {
            for (class_293 var4 = this; var4 != null && var4.method_3047(var1, var2); var4 = var4.field_1740) {
                ;
            }
        }
    }

    // $FF: renamed from: a (m.bb, m.ab, h.r, int, l.g) void
    public void method_3050(class_83 var1, class_65 var2, class_126 var3, int var4, class_301 var5) {
        if ((var5.field_1783 & 1) == 0 && !var5.method_3086(var2)) {
            switch (var4) {
                case 3:
                    if (var5.method_3085(var2)) {
                        var1.method_644().method_1665(var2, var3);
                        return;
                    }
                    if (var5.method_3090(var2)) {
                        var1.method_644().method_1666(var2, var3);
                        return;
                    }
                    break;
                case 256:
                case 512:
                    if (var5.method_3084(var2)) {
                        if (var4 == 512) {
                            var1.method_644().method_1667(var2, var3);
                        } else {
                            var1.method_644().method_1662(var2, var3);
                        }
                        return;
                    }
                    if (var5.method_3075(var2)) {
                        return;
                    }
                case 257:
                case 513:
                case 769:
                case 1025:
                    if (var5.method_3085(var2)) {
                        switch (var4 & -256) {
                            case 256:
                                var1.method_644().method_1668(var2, var3);
                                return;
                            case 512:
                                var1.method_644().method_1663(var2, var3);
                                return;
                            case 768:
                                var1.method_644().method_1669(var2, var3);
                                return;
                            case 1024:
                                var1.method_644().method_1664(var2, var3);
                                return;
                        }
                    } else if (var5.method_3075(var2)) {
                        return;
                    }
            }
            if (this.field_1740 != null) {
                this.field_1740.method_3050(var1, var2, var3, var4, var5);
            }
        }
    }

    // $FF: renamed from: a (h.bb) void
    void method_3051(class_154 var1) {}

    // $FF: renamed from: a () h.bi
    public class_116 method_3052() {
        return null;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        class_293 var2 = this;
        int var3;
        for (var3 = 0; (var2 = var2.field_1740) != null; ++var3) {
            ;
        }
        class_293[] var4 = new class_293[var3 + 1];
        var2 = this;
        for (int var5 = var3; var5 >= 0; var2 = var2.field_1740) {
            var4[var5--] = var2;
        }
        int var6;
        for (var6 = 0; var6 < var3; ++var6) {
            for (int var7 = 0; var7 < var6; ++var7) {
                var1.append('\t');
            }
            var1.append(var4[var6].method_3039()).append('\n');
        }
        var1.append('*');
        for (var6 = 0; var6 < var3 + 1; ++var6) {
            var1.append('\t');
        }
        var1.append(this.method_3039()).append('\n');
        return var1.toString();
    }

    // $FF: renamed from: <clinit> () void
    static {
        class_293 var10000 = new class_293((class_293)null, (class_89)null);
        field_1738 = var10000;
    }
}
