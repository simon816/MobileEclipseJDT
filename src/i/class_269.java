package i;

import c.class_288;
import g.class_12;
import g.class_16;
import g.class_312;
import g.class_313;
import g.class_316;
import i.class_268;
import i.class_272;
import i.class_273;
import i.class_281;
import i.class_71;
import i.class_73;
import i.class_74;
import i.class_78;
import java.util.Vector;
import m.class_40;
import m.class_58;
import m.class_65;
import m.class_67;
import m.class_83;

// $FF: renamed from: i.g
public class class_269 extends class_268 {

    // $FF: renamed from: a int[]
    public int[] field_1217;
    // $FF: renamed from: a int
    public int field_1218;
    // $FF: renamed from: a g.j
    private class_312 field_1219;
    // $FF: renamed from: a java.util.Vector
    public Vector field_1220;
    // $FF: renamed from: a g.p
    public class_313 field_1221;
    // $FF: renamed from: b g.p
    public class_313 field_1222;

    // $FF: renamed from: <init> (c.d) void
    public class_269(class_288 var1) {
        super(var1);
        this.field_1195 |= 16;
    }

    // $FF: renamed from: a (m.bb, int) void
    public void method_2088(class_83 var1, int var2) {
        for (int var3 = 0; var3 < this.field_1215; ++var3) {
            class_65 var4 = this.field_1214[var3];
            if (var4 != null) {
                boolean var5 = this.method_2286(var1, var2, var4);
                if (!var5) {
                    if (this.field_1217 != null) {
                        int var6 = 0;
                        for (int var7 = this.field_1218; var6 < var7; ++var6) {
                            if (this.method_2286(var1, this.field_1217[var6], var4)) {
                                if (var4.field_311 == 0 || var4.field_310[(var4.field_311 - 1 << 1) + 1] != -1) {
                                    var4.method_415(this.field_1208);
                                }
                                break;
                            }
                        }
                    }
                } else if (var4.field_311 == 0 || var4.field_310[(var4.field_311 - 1 << 1) + 1] != -1) {
                    var4.method_415(this.field_1208);
                }
            }
        }
    }

    // $FF: renamed from: a (int, m.s) void
    public void method_2390(int var1, class_40 var2) {
        if (this.field_1220 == null) {
            this.field_1220 = new Vector();
        }
        class_273 var10001;
        Vector var10000;
        if (var2 == null) {
            var10000 = this.field_1220;
            var10001 = new class_273(var1, class_272.field_1436);
            var10000.addElement(var10001);
        } else {
            switch (var2.field_177) {
                case 7:
                    var10000 = this.field_1220;
                    var10001 = new class_273(var1, class_272.field_1421);
                    var10000.addElement(var10001);
                    break;
                case 12:
                    var10000 = this.field_1220;
                    var10001 = new class_273(var1, class_272.field_1411);
                    var10000.addElement(var10001);
                    break;
                default:
                    var10000 = this.field_1220;
                    var10001 = new class_273(var1, var2.method_134());
                    var10000.addElement(var10001);
            }
        }
    }

    // $FF: renamed from: a (int) void
    public void method_2391(int var1) {
        Integer var2 = new Integer(var1);
        class_281 var3;
        if ((var3 = (class_281)this.field_1219.method_38(var2)) != null) {
            ++var3.field_1648;
        } else {
            class_312 var10000 = this.field_1219;
            class_281 var10002 = new class_281();
            var10000.method_39(var2, var10002);
        }
    }

    // $FF: renamed from: a (int, i.s) void
    public void method_2351(int var1, class_74 var2) {
        super.method_2351(var1, var2);
        this.method_2392(var1);
    }

    // $FF: renamed from: b (int) void
    public void method_2392(int var1) {
        Integer var2 = new Integer(var1);
        class_281 var3;
        if ((var3 = (class_281)this.field_1219.method_38(var2)) != null) {
            --var3.field_1648;
            if (var3.field_1648 <= 0) {
                this.field_1219.method_40(var2);
            }
        }
    }

    // $FF: renamed from: a (m.ab) void
    public void method_2091(class_65 var1) {
        if (var1.field_310 == null) {
            this.method_2358(var1);
        }
        var1.method_415(this.field_1208);
    }

    // $FF: renamed from: e (int, int) void
    private void method_2393(int var1, int var2) {
        class_71 var4;
        class_313 var10000;
        if (this.field_1222 == null) {
            class_313 var10001 = new class_313();
            this.field_1222 = var10001;
            var10000 = this.field_1222;
            var4 = new class_71(var1, var2);
            var10000.method_34(var4);
        } else {
            int var3 = this.field_1222.method_29();
            if (var3 == 0 || ((class_71)this.field_1222.method_36(var3 - 1)).field_319 != this.field_1208) {
                var10000 = this.field_1222;
                var4 = new class_71(var1, var2);
                var10000.method_34(var4);
            }
        }
    }

    // $FF: renamed from: a (int, int, m.s) void
    private void method_2394(int var1, int var2, class_40 var3) {
        class_78 var5;
        class_313 var10000;
        if (this.field_1221 == null) {
            class_313 var10001 = new class_313();
            this.field_1221 = var10001;
            var10000 = this.field_1221;
            var5 = new class_78(var1, var2, var3);
            var10000.method_34(var5);
        } else {
            int var4 = this.field_1221.method_29();
            if (var4 == 0 || ((class_78)this.field_1221.method_36(var4 - 1)).field_340 != this.field_1208) {
                var10000 = this.field_1221;
                var5 = new class_78(var1, var2, var3);
                var10000.method_34(var5);
            }
        }
    }

    // $FF: renamed from: c (int) void
    public void method_2125(int var1) {
        super.method_2125(var1);
        this.method_2394(this.field_1208, -1, (class_40)null);
    }

    // $FF: renamed from: a (m.s) void
    public void method_2359(class_40 var1) {
        this.method_2394(this.field_1208, 0, var1);
    }

    // $FF: renamed from: a (m.s, m.k) void
    public void method_2177(class_40 var1, class_67 var2) {
        if (var1.method_148() && var1 != class_40.field_187) {
            this.method_2208(var1.field_177);
        } else {
            if (this.field_1213 >= 3211264L) {
                this.method_2312(var1);
            } else {
                class_74 var10000 = new class_74(this);
                class_74 var3 = var10000;
                if (var2 != null) {
                    this.method_2207(var2);
                    this.method_2141();
                    this.method_2243(var3);
                    this.method_2352();
                }
                class_73 var7 = new class_73(this, class_40.field_187);
                class_73 var4 = var7;
                var4.method_449();
                this.method_2311(var1 == class_40.field_187 ? "java.lang.Object" : String.valueOf(var1.method_134()).replace('/', '.'));
                this.method_2259();
                var4.method_448();
                if (var2 != null) {
                    this.method_2141();
                    this.method_2357(var2);
                }
                int var5 = this.field_1208;
                this.method_2209(var3);
                int var6 = this.field_1210;
                this.method_2355(class_40.field_187);
                var4.method_447();
                this.method_2348();
                this.method_2142();
                this.method_2377();
                this.method_2281();
                this.method_2270();
                this.method_2107();
                var3.method_458();
                this.method_2393(var5, this.field_1208);
                this.field_1210 = var6;
            }
        }
    }

    // $FF: renamed from: a () i.j[]
    public class_273[] method_2395() {
        Vector var1 = this.field_1220;
        if (this.field_1220 == null) {
            return null;
        } else {
            int var2 = var1.size();
            class_273[] var3 = new class_273[var2];
            var1.copyInto(var3);
            class_316.method_3171(var3);
            return var3;
        }
    }

    // $FF: renamed from: a () int[]
    public int[] method_2396() {
        class_12 var1 = this.field_1219.method_42();
        int var2 = var1.method_29();
        int[] var3 = new int[var2];
        int var4 = 0;
        for (class_16 var5 = var1.method_31(); var5.method_47(); var3[var4++] = ((Integer)var5.method_48()).intValue()) {
            ;
        }
        class_316.method_3169(var3);
        return var3;
    }

    // $FF: renamed from: a () i.b[]
    public class_78[] method_2397() {
        if (this.field_1221 == null) {
            return null;
        } else {
            int var1 = this.field_1221.method_29();
            if (var1 == 0) {
                return null;
            } else {
                class_78[] var2 = new class_78[var1];
                this.field_1221.method_33(var2);
                return var2;
            }
        }
    }

    // $FF: renamed from: a () i.a[]
    public class_71[] method_2398() {
        if (this.field_1222 == null) {
            return null;
        } else {
            int var1 = this.field_1222.method_29();
            if (var1 == 0) {
                return null;
            } else {
                class_71[] var2 = new class_71[var1];
                this.field_1222.method_33(var2);
                return var2;
            }
        }
    }

    // $FF: renamed from: a () boolean
    public boolean method_2399() {
        return this.field_1219.method_37() != 0;
    }

    // $FF: renamed from: a (c.d) void
    public void method_2255(class_288 var1) {
        super.method_2255(var1);
        this.field_1218 = 0;
        if (this.field_1219 != null) {
            this.field_1219.method_41();
        }
        if (this.field_1220 != null) {
            this.field_1220.removeAllElements();
        }
        if (this.field_1221 != null) {
            this.field_1221.method_35();
        }
        if (this.field_1222 != null) {
            this.field_1222.method_35();
        }
    }

    // $FF: renamed from: a (m.ae) void
    public void method_2256(class_58 var1) {
        super.method_2256(var1);
        if (this.field_1219 == null) {
            class_312 var10001 = new class_312();
            this.field_1219 = var10001;
        } else {
            this.field_1219.method_41();
        }
    }

    // $FF: renamed from: a () void
    public void method_2400() {
        --this.field_1218;
    }

    // $FF: renamed from: d (int) void
    public void method_2401(int var1) {
        if (this.field_1217 == null) {
            this.field_1217 = new int[3];
        }
        int var2 = this.field_1217.length;
        if (var2 == this.field_1218) {
            System.arraycopy(this.field_1217, 0, this.field_1217 = new int[var2 * 2], 0, var2);
        }
        this.field_1217[this.field_1218++] = var1;
    }

    // $FF: renamed from: b (m.bb, int) void
    public void method_2363(class_83 var1, int var2) {
        int var3 = this.field_1215;
        label34:
        for (int var4 = 0; var4 < var3; ++var4) {
            class_65 var5 = this.field_1214[var4];
            if (var5 != null && var5.field_311 > 0) {
                boolean var6 = this.method_2286(var1, var2, var5);
                if (!var6) {
                    if (this.field_1217 != null) {
                        int var7 = 0;
                        for (int var8 = this.field_1218; var7 < var8; ++var7) {
                            if (this.method_2286(var1, this.field_1217[var7], var5)) {
                                continue label34;
                            }
                        }
                    }
                    var5.method_414(this.field_1208);
                }
            }
        }
    }

    // $FF: renamed from: b (c.d) void
    public void method_2367(class_288 var1) {
        super.method_2367(var1);
        this.field_1218 = 0;
        if (this.field_1219 != null) {
            this.field_1219.method_41();
        }
        if (this.field_1220 != null) {
            this.field_1220.removeAllElements();
        }
        if (this.field_1221 != null) {
            this.field_1221.method_35();
        }
        if (this.field_1222 != null) {
            this.field_1222.method_35();
        }
    }

    // $FF: renamed from: a (i.s) void
    protected void method_2381(class_74 var1) {
        super.method_2381(var1);
        this.method_2391(var1.field_323);
    }

    // $FF: renamed from: a (i.s, int) void
    protected void method_2382(class_74 var1, int var2) {
        super.method_2382(var1, var2);
        this.method_2391(var1.field_323);
    }

    // $FF: renamed from: a (int, int) void
    protected void method_2386(int var1, int var2) {
        super.method_2386(var1, var2);
        this.method_2391(this.field_1208);
    }

    // $FF: renamed from: b (i.s) void
    protected void method_2388(class_74 var1) {
        super.method_2388(var1);
        this.method_2391(var1.field_323);
    }

    // $FF: renamed from: b () void
    public void method_2098() {
        super.method_2098();
        this.method_2391(this.field_1208);
    }

    // $FF: renamed from: c () void
    public void method_2285() {
        super.method_2285();
        this.method_2391(this.field_1208);
    }

    // $FF: renamed from: d () void
    public void method_2329() {
        super.method_2329();
        this.method_2391(this.field_1208);
    }

    // $FF: renamed from: e () void
    public void method_2169() {
        super.method_2169();
        this.method_2391(this.field_1208);
    }

    // $FF: renamed from: f () void
    public void method_2134() {
        super.method_2134();
        this.method_2391(this.field_1208);
    }

    // $FF: renamed from: g () void
    public void method_2371() {
        super.method_2371();
        this.method_2391(this.field_1208);
    }

    // $FF: renamed from: h () void
    public void method_2107() {
        super.method_2107();
        this.method_2391(this.field_1208);
    }

    // $FF: renamed from: b (m.s) void
    public void method_2354(class_40 var1) {
        super.method_2354(var1);
        this.method_2394(this.field_1208, 1, var1);
    }

    // $FF: renamed from: c (m.s) void
    public void method_2355(class_40 var1) {
        super.method_2355(var1);
        this.method_2390(this.field_1208, var1);
    }

    // $FF: renamed from: c (i.s) void
    public void method_2209(class_74 var1) {
        super.method_2209(var1);
        this.method_2391(this.field_1208);
    }

    // $FF: renamed from: d (i.s) void
    public void method_2210(class_74 var1) {
        super.method_2210(var1);
        this.method_2391(this.field_1208);
    }
}
