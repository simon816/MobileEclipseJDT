package h;

import a.class_33;
import b.class_233;
import b.class_235;
import c.class_264;
import c.class_284;
import c.class_288;
import f.class_226;
import h.class_123;
import h.class_125;
import h.class_146;
import h.class_147;
import h.class_164;
import h.class_89;
import h.class_90;
import h.class_98;
import i.class_268;
import j.class_278;
import l.class_299;
import l.class_301;
import m.class_203;
import m.class_34;
import m.class_40;
import m.class_43;
import m.class_58;
import m.class_65;
import m.class_84;
import m.class_87;
import n.class_241;
import n.class_242;
import n.class_243;
import n.class_244;
import n.class_248;

// $FF: renamed from: h.ci
public abstract class class_93 extends class_89 implements class_33 {

    // $FF: renamed from: a m.aj
    public class_87 field_478;
    // $FF: renamed from: a char[]
    public char[] field_479;
    // $FF: renamed from: a int
    public int field_480;
    // $FF: renamed from: b int
    public int field_481;
    // $FF: renamed from: c int
    public int field_482;
    // $FF: renamed from: a h.cn[]
    public class_164[] field_483;
    // $FF: renamed from: a h.cp[]
    public class_125[] field_484;
    // $FF: renamed from: a h.bo[]
    public class_146[] field_485;
    // $FF: renamed from: a h.bf[]
    public class_98[] field_486;
    // $FF: renamed from: d int
    public int field_487;
    // $FF: renamed from: a m.ae
    public class_58 field_488;
    // $FF: renamed from: a boolean
    public boolean field_489;
    // $FF: renamed from: e int
    public int field_490;
    // $FF: renamed from: f int
    public int field_491;
    // $FF: renamed from: a c.h
    public class_284 field_492;

    // $FF: renamed from: <init> (c.h) void
    class_93(class_284 var1) {
        this.field_489 = false;
        this.field_491 = -1;
        this.field_492 = var1;
    }

    // $FF: renamed from: a (int, b.e) void
    public void method_93(int var1, class_235 var2) {
        switch (var1) {
            case 2:
                class_241 var5 = new class_241(this.field_492, var2);
                throw var5;
            case 4:
                class_242 var4 = new class_242(this.field_492, var2);
                throw var4;
            case 8:
                class_243 var10000 = new class_243(this.field_492, var2);
                throw var10000;
            default:
                class_244 var3 = new class_244(this.field_492, var2);
                throw var3;
        }
    }

    // $FF: renamed from: a (m.f, l.h, l.g) void
    public abstract void method_786(class_84 var1, class_299 var2, class_301 var3);

    // $FF: renamed from: d () void
    public void method_787() {
        if (this.field_484 != null) {
            if (this.field_488 == null) {
                int var7 = 0;
                for (int var8 = this.field_484.length; var7 < var8; ++var7) {
                    this.field_484[var7].method_903(this.field_478, (class_40)null, true);
                }
                return;
            }
            boolean var1 = this.field_488.method_356() || this.field_488.method_365();
            class_203[][] var2 = (class_203[][])null;
            int var3 = 0;
            for (int var4 = this.field_484.length; var3 < var4; ++var3) {
                class_125 var5 = this.field_484[var3];
                var5.method_903(this.field_478, this.field_488.field_276[var3], var1);
                if (var5.field_658 != null) {
                    if (var2 == null) {
                        var2 = new class_203[var4][];
                        for (int var6 = 0; var6 < var3; ++var6) {
                            var2[var6] = class_34.field_158;
                        }
                    }
                    var2[var3] = var5.field_670.method_413();
                } else if (var2 != null) {
                    var2[var3] = class_34.field_158;
                }
            }
            if (var2 != null) {
                this.field_488.method_380(var2);
            }
        }
    }

    // $FF: renamed from: e () void
    public void method_788() {
        if (this.field_485 != null && this.field_488 != null && this.field_488.field_277 != null) {
            int var1 = this.field_485.length;
            int var2 = this.field_488.field_277.length;
            int var3;
            if (var2 == var1) {
                for (var3 = 0; var3 < var2; ++var3) {
                    this.field_485[var3].field_675 = this.field_488.field_277[var3];
                }
            } else {
                var3 = 0;
                for (int var4 = 0; var4 < var1 && var3 < var2; ++var4) {
                    class_146 var5 = this.field_485[var4];
                    class_43 var6 = this.field_488.field_277[var3];
                    char[][] var7 = var6.field_197;
                    if (var7 != null) {
                        if (var5 instanceof class_147) {
                            int var8 = var7.length;
                            char[] var9 = var5.method_1012()[0];
                            if (class_233.method_1364(var9, var7[var8 - 1])) {
                                var5.field_675 = var6;
                                ++var3;
                            }
                        } else if (class_233.method_1363(var5.method_1012(), var7)) {
                            var5.field_675 = var6;
                            ++var3;
                        }
                    }
                }
            }
        }
    }

    // $FF: renamed from: a () c.h
    public class_284 method_94() {
        return this.field_492;
    }

    // $FF: renamed from: a (m.f, c.d) void
    public void method_789(class_84 var1, class_288 var2) {
        byte var3 = 0;
        var2.field_1715.field_1216 = false;
        class_235[] var6;
        if (this.field_489) {
            if (this.field_488 != null) {
                class_235[] var12 = this.field_478.method_645().field_455.method_2922();
                int var4;
                var6 = new class_235[var4 = var12.length];
                System.arraycopy(var12, 0, var6, 0, var4);
                var2.method_2969(this, this.field_488, var6);
            }
        } else {
            try {
                int var11 = var2.field_1719;
                this.method_790(var2);
            } catch (class_244 var10) {
                class_235[] var7;
                if (var10.field_1049 == class_268.field_1186) {
                    try {
                        var2.field_1719 = var3;
                        --var2.field_1725;
                        var2.field_1715.field_1216 = true;
                        this.method_790(var2);
                    } catch (class_244 var9) {
                        var7 = this.field_478.method_645().field_455.method_2916();
                        int var13;
                        class_235[] var8 = new class_235[var13 = var7.length];
                        System.arraycopy(var7, 0, var8, 0, var13);
                        var2.method_2970(this, this.field_488, var8, var3);
                    }
                } else {
                    var6 = this.field_478.method_645().field_455.method_2916();
                    int var5;
                    var7 = new class_235[var5 = var6.length];
                    System.arraycopy(var6, 0, var7, 0, var5);
                    var2.method_2970(this, this.field_488, var7, var3);
                }
            }
        }
    }

    // $FF: renamed from: a (c.d) void
    public void method_790(class_288 var1) {
        var1.method_2995(this.field_488);
        int var2 = var1.field_1719;
        int var3 = var1.method_2993(this.field_488);
        if (!this.field_488.method_365() && !this.field_488.method_356()) {
            int var4 = var1.field_1719;
            var1.method_2989();
            class_268 var5 = var1.field_1715;
            var5.method_2366(this, var1);
            this.field_478.method_724(this.field_488.method_370() ? 0 : 1, var5);
            int var6;
            int var7;
            if (this.field_484 != null) {
                var6 = 0;
                for (var7 = this.field_484.length; var6 < var7; ++var6) {
                    class_65 var8;
                    var5.method_2090(var8 = this.field_484[var6].field_670);
                    var8.method_415(0);
                }
            }
            if (this.field_486 != null) {
                var6 = 0;
                for (var7 = this.field_486.length; var6 < var7; ++var6) {
                    this.field_486[var6].method_818(this.field_478, var5);
                }
            }
            if (this.field_489) {
                class_244 var10000 = new class_244(this.field_478.method_645().field_455, (class_235)null);
                throw var10000;
            }
            if ((this.field_446 & 64) != 0) {
                var5.method_2371();
            }
            var5.method_2147(this.field_478);
            var5.method_2360(0, this.field_481);
            var1.method_2979(var4);
            ++var3;
        } else {
            this.method_791();
        }
        var1.method_2986(var2, var3);
    }

    // $FF: renamed from: f () void
    private void method_791() {
        class_40[] var1 = this.field_488.field_276;
        int var2 = 1;
        int var3 = 0;
        for (int var4 = var1.length; var3 < var4; ++var3) {
            class_40 var5 = var1[var3];
            if (var5 != class_40.field_183 && var5 != class_40.field_185) {
                ++var2;
            } else {
                var2 += 2;
            }
            if (var2 > 255) {
                this.field_478.method_644().method_1697(this.field_478.field_391[var3], this.field_478.field_391[var3].field_309);
            }
        }
    }

    // $FF: renamed from: a () boolean
    public boolean method_95() {
        return this.field_489;
    }

    // $FF: renamed from: h () boolean
    public boolean method_792() {
        return this.field_488 != null ? this.field_488.method_356() : (this.field_482 & 1024) != 0;
    }

    // $FF: renamed from: i () boolean
    public boolean method_793() {
        return false;
    }

    // $FF: renamed from: f () boolean
    public boolean method_794() {
        return false;
    }

    // $FF: renamed from: b_ () boolean
    public boolean method_795() {
        return false;
    }

    // $FF: renamed from: c_ () boolean
    public boolean method_796() {
        return false;
    }

    // $FF: renamed from: d () boolean
    public boolean method_797() {
        return false;
    }

    // $FF: renamed from: j () boolean
    public boolean method_798() {
        return this.field_488 != null ? this.field_488.method_365() : (this.field_482 & 256) != 0;
    }

    // $FF: renamed from: g () boolean
    public boolean method_799() {
        return this.field_488 != null ? this.field_488.method_370() : (this.field_482 & 8) != 0;
    }

    // $FF: renamed from: a (j.r, h.b) void
    public abstract void method_800(class_278 var1, class_90 var2);

    // $FF: renamed from: a (int, java.lang.StringBuffer) java.lang.StringBuffer
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
        this.method_801(var1 + 1, var2);
        return var2;
    }

    // $FF: renamed from: b (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_801(int var1, StringBuffer var2) {
        if (!this.method_792() && (this.field_482 & 16777216) == 0) {
            var2.append(" {");
            if (this.field_486 != null) {
                for (int var3 = 0; var3 < this.field_486.length; ++var3) {
                    var2.append('\n');
                    this.field_486[var3].method_820(var1, var2);
                }
            }
            var2.append('\n');
            method_759(var1 == 0 ? 0 : var1 - 1, var2).append('}');
            return var2;
        } else {
            return var2.append(';');
        }
    }

    // $FF: renamed from: c (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_802(int var1, StringBuffer var2) {
        return var2;
    }

    // $FF: renamed from: a (m.f) void
    public void method_803(class_84 var1) {
        if (this.field_488 == null) {
            this.field_489 = true;
        }
        try {
            this.method_787();
            this.method_788();
            this.method_804();
            method_761(this.field_478, this.field_483, this.field_488);
            this.method_805();
            if (this.field_488 != null && (this.field_488.method_99() & 70368744177664L) == 0L && (this.field_488.field_273 & 1048576) != 0 && this.field_478.method_577().field_1928 >= 3211264L) {
                this.field_478.method_644().method_1676(this);
            }
        } catch (class_244 var3) {
            this.field_489 = true;
        }
    }

    // $FF: renamed from: b () void
    public void method_804() {
        if (this.field_488 != null) {
            if (this.field_488.field_278 != null && !this.field_488.field_278.method_158()) {
                int var1 = this.field_488.field_273 & 7;
                class_84 var2 = this.field_478.method_575();
                class_248 var3 = this.field_478.method_644();
                int var4 = var3.method_1449(-1610612250);
                if (var4 != -1) {
                    if (var2 != null) {
                        var1 = class_226.method_1318(var2.method_671(), var1);
                    }
                    int var5 = this.field_488.field_273 & -8 | var1;
                }
            }
        }
    }

    // $FF: renamed from: c () void
    public void method_805() {
        if (this.field_486 != null) {
            int var1 = 0;
            for (int var2 = this.field_486.length; var1 < var2; ++var1) {
                this.field_486[var1].method_821(this.field_478);
            }
        } else if ((this.field_446 & 8) != 0) {
            this.field_478.method_644().method_1783(this.field_490 - 1, this.field_491 + 1);
        }
    }

    // $FF: renamed from: a () void
    public void method_96() {
        this.field_489 = true;
    }

    // $FF: renamed from: a (c.j, m.f) void
    public void method_806(class_264 var1, class_84 var2) {}

    // $FF: renamed from: a () h.br[]
    public class_123[] method_807() {
        return null;
    }
}
