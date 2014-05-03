package m;

import a.class_31;
import a.class_341;
import b.class_233;
import c.class_288;
import c.class_292;
import f.class_324;
import f.class_327;
import g.class_14;
import g.class_312;
import g.class_313;
import h.class_90;
import java.util.Vector;
import k.class_22;
import k.class_28;
import k.class_317;
import k.class_345;
import m.class_17;
import m.class_197;
import m.class_203;
import m.class_320;
import m.class_35;
import m.class_38;
import m.class_39;
import m.class_40;
import m.class_42;
import m.class_43;
import m.class_44;
import m.class_45;
import m.class_46;
import m.class_49;
import m.class_50;
import m.class_51;
import m.class_52;
import m.class_53;
import m.class_57;
import m.class_58;
import m.class_63;
import m.class_81;
import m.class_82;
import m.class_83;
import m.class_85;
import n.class_248;

// $FF: renamed from: m.af
public class class_80 implements class_17 {

    // $FF: renamed from: a g.m
    private class_14 field_345;
    // $FF: renamed from: a m.i[]
    class_35[] field_346;
    // $FF: renamed from: a m.ar
    public class_38 field_347;
    // $FF: renamed from: a f.f
    class_324 field_348;
    // $FF: renamed from: a int
    private int field_349;
    // $FF: renamed from: b int
    private int field_350;
    // $FF: renamed from: a k.s
    public class_28 field_351;
    // $FF: renamed from: a a.c
    public class_341 field_352;
    // $FF: renamed from: a n.e
    public class_248 field_353;
    // $FF: renamed from: a c.a
    public class_292 field_354;
    // $FF: renamed from: c int
    private int field_355;
    // $FF: renamed from: a a.n
    public class_31 field_356;
    // $FF: renamed from: a m.p[][]
    private class_42[][] field_357;
    // $FF: renamed from: a f.c
    private class_327 field_358;
    // $FF: renamed from: b f.c
    private class_327 field_359;
    // $FF: renamed from: c f.c
    private class_327 field_360;
    // $FF: renamed from: d f.c
    private class_327 field_361;
    // $FF: renamed from: a h.b
    public class_90 field_362;
    // $FF: renamed from: a java.lang.Object
    public Object field_363;
    // $FF: renamed from: a h.b[]
    private class_90[] field_364;
    // $FF: renamed from: a m.ak
    private class_81 field_365;
    // $FF: renamed from: a m.av
    static final class_39 field_366;
    // $FF: renamed from: a m.au
    static final class_51 field_367;

    // $FF: renamed from: <init> (a.n, a.c, n.e, k.s) void
    public class_80(class_31 var1, class_341 var2, class_248 var3, class_28 var4) {
        this.field_349 = -1;
        this.field_350 = -1;
        this.field_362 = null;
        this.field_363 = null;
        this.field_364 = new class_90[4];
        this.field_356 = var1;
        this.field_352 = var2;
        this.field_353 = var3;
        class_38 var10001 = new class_38(this);
        this.field_347 = var10001;
        this.field_346 = null;
        this.field_351 = var4;
        class_324 var8 = new class_324();
        this.field_348 = var8;
        this.field_357 = new class_42[5][];
        this.field_357[0] = new class_42[50];
        class_327 var7 = new class_327(3);
        this.field_358 = var7;
        var7 = new class_327(3);
        this.field_359 = var7;
        var7 = new class_327(3);
        this.field_360 = var7;
        var7 = new class_327(3);
        this.field_361 = var7;
        class_312 var5 = new class_312(3);
        this.field_345 = var5;
        class_292 var6 = new class_292();
        this.field_354 = var6;
    }

    // $FF: renamed from: a (char[][]) m.as
    public class_43 method_481(char[][] var1) {
        class_317 var2 = this.field_351.method_80(var1);
        if (var2 == null) {
            return null;
        } else {
            if (var2.method_3187()) {
                this.field_356.method_87(var2.method_3184(), this.method_487(var1, false), var2.method_3183());
            } else if (var2.method_3188()) {
                this.field_356.method_88(var2.method_3185(), var2.method_3183());
            } else if (var2.method_3189()) {
                this.field_356.method_89(var2.method_3186(), this.method_487(var1, false), var2.method_3183());
            }
            return this.method_504(var1);
        }
    }

    // $FF: renamed from: a (m.ar, char[]) m.as
    class_43 method_482(class_38 var1, char[] var2) {
        if (var1 == null) {
            if (this.field_347 == null) {
                return null;
            }
            var1 = this.field_347;
        }
        class_317 var3 = this.field_351.method_81(var2, var1.field_171);
        if (var3 == null) {
            return null;
        } else {
            if (var3.method_3187()) {
                this.field_356.method_87(var3.method_3184(), var1, var3.method_3183());
            } else if (var3.method_3188()) {
                this.field_356.method_88(var3.method_3185(), var3.method_3183());
            } else if (var3.method_3189()) {
                this.field_356.method_89(var3.method_3186(), var1, var3.method_3183());
            }
            return var1.method_124(var2);
        }
    }

    // $FF: renamed from: a (h.b, k.c) void
    public void method_483(class_90 var1, class_345 var2) {
        class_85 var10000 = new class_85(var1, this);
        class_85 var3 = var10000;
        var3.method_674(var2);
        int var4 = this.field_364.length;
        if (++this.field_350 >= var4) {
            System.arraycopy(this.field_364, 0, this.field_364 = new class_90[2 * var4], 0, var4);
        }
        this.field_364[this.field_350] = var1;
    }

    // $FF: renamed from: a () void
    public void method_484() {
        this.field_355 = 1;
        int var1;
        for (var1 = this.field_349 + 1; var1 <= this.field_350; ++var1) {
            (this.field_362 = this.field_364[var1]).field_453.method_675();
        }
        this.field_355 = 2;
        for (var1 = this.field_349 + 1; var1 <= this.field_350; ++var1) {
            (this.field_362 = this.field_364[var1]).field_453.method_678();
        }
        this.field_355 = 3;
        for (var1 = this.field_349 + 1; var1 <= this.field_350; ++var1) {
            class_85 var2 = (this.field_362 = this.field_364[var1]).field_453;
            var2.method_676();
            var2.method_673();
            this.field_364[var1] = null;
        }
        this.field_355 = 4;
        this.field_349 = this.field_350;
        this.field_362 = null;
    }

    // $FF: renamed from: a (h.b) void
    public void method_485(class_90 var1) {
        if (this.field_355 == 4) {
            this.method_484();
        } else {
            if (var1.field_453 == null) {
                return;
            }
            if (this.field_355 >= 2) {
                (this.field_362 = var1).field_453.method_675();
            }
            if (this.field_355 >= 3) {
                (this.field_362 = var1).field_453.method_678();
            }
            this.field_362 = null;
        }
    }

    // $FF: renamed from: a (m.s) m.s
    public class_40 method_486(class_40 var1) {
        class_43 var2;
        class_51 var10000;
        switch (var1.field_177) {
            case 2:
                var2 = this.method_508(field_111);
                if (var2 != null) {
                    return var2;
                }
                var10000 = new class_51(field_111, (class_43)null, 1);
                return var10000;
            case 3:
                var2 = this.method_508(field_109);
                if (var2 != null) {
                    return var2;
                }
                var10000 = new class_51(field_109, (class_43)null, 1);
                return var10000;
            case 4:
                var2 = this.method_508(field_110);
                if (var2 != null) {
                    return var2;
                }
                var10000 = new class_51(field_110, (class_43)null, 1);
                return var10000;
            case 5:
                var2 = this.method_508(field_116);
                if (var2 != null) {
                    return var2;
                }
                var10000 = new class_51(field_116, (class_43)null, 1);
                return var10000;
            case 6:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            default:
                switch (var1.method_98()) {
                    case 516:
                    case 4100:
                    case 8196:
                        switch (var1.method_138().field_177) {
                            case 26:
                                return class_40.field_180;
                            case 27:
                                return class_40.field_181;
                            case 28:
                                return class_40.field_182;
                            case 29:
                                return class_40.field_179;
                            case 30:
                                return class_40.field_183;
                            case 31:
                                return class_40.field_184;
                            case 32:
                                return class_40.field_185;
                            case 33:
                                return class_40.field_186;
                        }
                    default:
                        return var1;
                }
            case 7:
                var2 = this.method_508(field_113);
                if (var2 != null) {
                    return var2;
                }
                var10000 = new class_51(field_113, (class_43)null, 1);
                return var10000;
            case 8:
                var2 = this.method_508(field_115);
                if (var2 != null) {
                    return var2;
                }
                var10000 = new class_51(field_115, (class_43)null, 1);
                return var10000;
            case 9:
                var2 = this.method_508(field_114);
                if (var2 != null) {
                    return var2;
                }
                var10000 = new class_51(field_114, (class_43)null, 1);
                return var10000;
            case 10:
                var2 = this.method_508(field_112);
                if (var2 != null) {
                    return var2;
                }
                var10000 = new class_51(field_112, (class_43)null, 1);
                return var10000;
            case 26:
                return class_40.field_180;
            case 27:
                return class_40.field_181;
            case 28:
                return class_40.field_182;
            case 29:
                return class_40.field_179;
            case 30:
                return class_40.field_183;
            case 31:
                return class_40.field_184;
            case 32:
                return class_40.field_185;
            case 33:
                return class_40.field_186;
        }
    }

    // $FF: renamed from: a (char[][], boolean) m.ar
    private class_38 method_487(char[][] var1, boolean var2) {
        if (var1.length == 1) {
            return this.field_347;
        } else {
            class_38 var3 = this.method_505(var1[0]);
            class_38 var10000;
            if (var3 == null || var3 == field_366) {
                var10000 = new class_38(var1[0], this);
                var3 = var10000;
                if (var2) {
                    var3.field_170 |= 128L;
                }
                this.field_348.method_3220(var1[0], var3);
            }
            int var4 = 1;
            for (int var5 = var1.length - 1; var4 < var5; ++var4) {
                class_38 var6 = var3;
                if ((var3 = var3.method_122(var1[var4])) == null || var3 == field_366) {
                    var10000 = new class_38(class_233.method_1387(var1, 0, var4 + 1), var6, this);
                    var3 = var10000;
                    if (var2) {
                        var3.field_170 |= 128L;
                    }
                    var6.method_117(var3);
                }
            }
            return var3;
        }
    }

    // $FF: renamed from: a (m.s, m.as, int, java.util.Vector) m.s
    public class_40 method_488(class_40 var1, class_43 var2, int var3, Vector var4) {
        if ((var1.field_178 & 536870912L) != 0L) {
            class_43 var9;
            class_43 var10;
            class_40 var15;
            class_40 var19;
            class_40 var18;
            switch (var1.method_98()) {
                case 68:
                    class_42 var5 = (class_42)var1;
                    class_40 var6 = var5.field_192;
                    class_40 var7 = this.method_488(var6, var2, var3, var4);
                    if (var7 != var6) {
                        return this.method_493(var7.method_173(), var7.method_136() + var5.method_136());
                    }
                    break;
                case 260:
                    class_52 var8 = (class_52)var1;
                    var9 = var8.method_137();
                    var10 = var9;
                    if (var9 != null) {
                        var10 = (class_43)this.method_488(var9, var2, var3, var4);
                    }
                    class_40[] var27 = var8.field_243;
                    class_40[] var28 = var27;
                    int var29 = 0;
                    for (int var30 = var27 == null ? 0 : var27.length; var29 < var30; ++var29) {
                        var15 = var27[var29];
                        class_40 var31 = this.method_488(var15, var8.method_286(), var29, var4);
                        if (var31 != var15) {
                            if (var28 == var27) {
                                System.arraycopy(var27, 0, var28 = new class_40[var30], 0, var29);
                            }
                            var28[var29] = var31;
                        } else if (var28 != var27) {
                            var28[var29] = var15;
                        }
                    }
                    if (var9 != var10 || var27 != var28) {
                        return this.method_500(var8.method_286(), var28, var10);
                    }
                    break;
                case 516:
                    class_45 var32 = (class_45)var1;
                    var18 = var32.field_212;
                    if (var18 != null) {
                        var19 = this.method_488(var18, var2, var3, var4);
                        if (var19 != var18) {
                            return this.method_502(var32.field_210, var32.field_211, var19, (class_40[])null, var32.field_215);
                        }
                    }
                case 1028:
                default:
                    break;
                case 2052:
                    class_43 var16 = (class_43)var1;
                    var9 = var16.method_137();
                    var10 = var9;
                    if (var9 != null) {
                        var10 = (class_43)this.method_488(var9, var2, var3, var4);
                    }
                    class_46[] var11 = var16.method_181();
                    Object var12 = var11;
                    int var17 = 0;
                    for (int var33 = var11 == null ? 0 : var11.length; var17 < var33; ++var17) {
                        class_46 var35 = var11[var17];
                        class_40 var34 = this.method_488(var35, var16, var17, var4);
                        if (var34 != var35) {
                            if (var12 == var11) {
                                System.arraycopy(var11, 0, var12 = new class_40[var33], 0, var17);
                            }
                            ((Object[])var12)[var17] = var34;
                        } else if (var12 != var11) {
                            ((Object[])var12)[var17] = var35;
                        }
                    }
                    if (var9 != var10 || var11 != var12) {
                        return this.method_500(var2, (class_40[])var12, var10);
                    }
                    break;
                case 4100:
                    if (var4 != null && var4.contains(var1)) {
                        return this.method_502(var2, var3, (class_40)null, (class_40[])null, 0);
                    }
                    class_46 var13 = (class_46)var1;
                    class_40 var14 = var13.method_261();
                    if (var4 == null) {
                        var4 = new Vector(2);
                    }
                    var4.addElement(var13);
                    var15 = this.method_488(var14, var2, var3, var4);
                    var4.removeElement(var13);
                    return this.method_502(var2, var3, var15, (class_40[])null, 1);
                case 8196:
                    class_45 var20 = (class_45)var1;
                    var18 = var20.field_212;
                    var19 = var18;
                    if (var18 != null) {
                        var19 = this.method_488(var18, var2, var3, var4);
                    }
                    class_40[] var21 = var20.field_213;
                    class_40[] var22 = var21;
                    int var23 = 0;
                    for (int var24 = var21 == null ? 0 : var21.length; var23 < var24; ++var23) {
                        class_40 var25 = var21[var23];
                        class_40 var26 = this.method_488(var25, var2, var3, var4);
                        if (var26 != var25) {
                            if (var22 == var21) {
                                System.arraycopy(var21, 0, var22 = new class_40[var24], 0, var23);
                            }
                            var22[var23] = var26;
                        } else if (var22 != var21) {
                            var22[var23] = var25;
                        }
                    }
                    if (var19 != var18 || var22 != var21) {
                        return this.method_502(var20.field_210, var20.field_211, var19, var22, var20.field_215);
                    }
            }
        }
        return var1;
    }

    // $FF: renamed from: a (m.as) m.as
    public class_43 method_489(class_43 var1) {
        if (var1 != null) {
            boolean var2 = var1.method_155();
            class_43 var3 = var1.method_137();
            class_43 var4 = var3;
            boolean var5 = var2;
            if (var3 != null) {
                var4 = var1.method_226() ? (class_43)this.method_490(var3, false) : this.method_489(var3);
                var5 = var2 | var3 != var4;
            }
            if (var5) {
                return this.method_500(var1, var2 ? var1.method_181() : null, var4);
            }
        }
        return var1;
    }

    // $FF: renamed from: a (m.s, boolean) m.s
    public class_40 method_490(class_40 var1, boolean var2) {
        int var3;
        class_40 var4;
        switch (var1.method_98()) {
            case 68:
                var3 = var1.method_136();
                var4 = var1.method_173();
                break;
            case 132:
            case 516:
            case 1028:
            case 4100:
            case 8196:
                return var1;
            default:
                if (var1.field_177 == 1) {
                    return var1;
                }
                var3 = 0;
                var4 = var1;
        }
        boolean var5;
        switch (var4.method_98()) {
            case 132:
                return var1;
            case 260:
                class_52 var6 = (class_52)var4;
                var5 = var6.method_286().method_155();
                break;
            case 2052:
                var5 = true;
                break;
            default:
                var5 = false;
        }
        class_43 var9 = var4.method_137();
        Object var7;
        if (var9 == null) {
            var7 = var5 ? this.method_501((class_43)var4.method_138(), (class_43)null) : var4;
        } else {
            class_43 var8;
            if (var9.method_98() == 1028) {
                var5 |= !((class_43)var4).method_226();
                var8 = var9;
            } else if (var2 && !var5) {
                var8 = (class_43)this.method_490(var9, var2);
                var5 = var9 != var8;
            } else if (!var5 && !((class_43)var4).method_226()) {
                var8 = this.method_489(var9);
            } else {
                var8 = (class_43)this.method_490(var9, false);
            }
            if (var5) {
                var7 = this.method_501((class_43)var4.method_138(), var8);
            } else if (var9 != var8) {
                var7 = this.method_500((class_43)var4.method_138(), (class_40[])null, var8);
            } else {
                var7 = var4;
            }
        }
        return (class_40)(var4 != var7 ? (var3 > 0 ? this.method_493((class_40)var7, var3) : var7) : var1);
    }

    // $FF: renamed from: b (m.s) m.s
    public class_40 method_491(class_40 var1) {
        int var2;
        class_40 var3;
        switch (var1.method_98()) {
            case 68:
                var2 = var1.method_136();
                var3 = var1.method_173();
                break;
            case 132:
            case 516:
            case 1028:
            case 4100:
            case 8196:
                return var1;
            default:
                if (var1.field_177 == 1) {
                    return var1;
                }
                var2 = 0;
                var3 = var1;
        }
        boolean var4;
        switch (var3.method_98()) {
            case 132:
                return var1;
            case 260:
                class_52 var5 = (class_52)var3;
                var4 = var5.method_286().method_155();
                break;
            case 2052:
                var4 = true;
                break;
            default:
                var4 = false;
        }
        class_43 var8 = var3.method_137();
        Object var6;
        if (var8 == null) {
            var6 = var4 ? this.method_501((class_43)var3.method_138(), (class_43)null) : var3;
        } else {
            class_43 var7 = (class_43)this.method_491(var8);
            if (var7 != var8) {
                var4 |= !((class_43)var3).method_226();
            }
            if (var4) {
                var6 = this.method_501((class_43)var3.method_138(), var7);
            } else if (var8 != var7) {
                var6 = this.method_500((class_43)var3.method_138(), (class_40[])null, var7);
            } else {
                var6 = var3;
            }
        }
        return (class_40)(var3 != var6 ? (var2 > 0 ? this.method_493((class_40)var6, var2) : var6) : var1);
    }

    // $FF: renamed from: a (m.as, m.c[]) m.bf
    public class_203 method_492(class_43 var1, class_320[] var2) {
        if (var2.length != 0) {
            class_203.method_1183(var1, var2);
        }
        class_203 var10000 = new class_203(var1, var2);
        return var10000;
    }

    // $FF: renamed from: a (m.s, int) m.p
    public class_42 method_493(class_40 var1, int var2) {
        if (var1 instanceof class_57) {
            return ((class_57)var1).method_336(var2, this);
        } else {
            int var3 = var2 - 1;
            int var4 = this.field_357.length;
            class_42[] var5;
            if (var3 < var4) {
                if ((var5 = this.field_357[var3]) == null) {
                    this.field_357[var3] = var5 = new class_42[10];
                }
            } else {
                System.arraycopy(this.field_357, 0, this.field_357 = new class_42[var2][], 0, var4);
                this.field_357[var3] = var5 = new class_42[10];
            }
            int var6 = -1;
            var4 = var5.length;
            class_42 var7;
            do {
                ++var6;
                class_42 var10002;
                if (var6 >= var4) {
                    System.arraycopy(var5, 0, var5 = new class_42[var4 * 2], 0, var4);
                    this.field_357[var3] = var5;
                    var10002 = new class_42(var1, var2, this);
                    return var5[var4] = var10002;
                }
                var7 = var5[var6];
                if (var7 == null) {
                    var10002 = new class_42(var1, var2, this);
                    return var5[var6] = var10002;
                }
            } while (var7.field_192 != var1);
            return var7;
        }
    }

    // $FF: renamed from: a (k.o, m.ar, k.c) m.y
    public class_49 method_494(class_22 var1, class_38 var2, class_345 var3) {
        return this.method_495(var1, var2, true, var3);
    }

    // $FF: renamed from: a (k.o, m.ar, boolean, k.c) m.y
    public class_49 method_495(class_22 var1, class_38 var2, boolean var3, class_345 var4) {
        class_49 var10000 = new class_49(var2, var1, this);
        class_49 var5 = var10000;
        class_43 var6 = var2.method_124(var5.field_197[var5.field_197.length - 1]);
        if (var6 != null) {
            if (!(var6 instanceof class_44)) {
                if (var6.method_218()) {
                    return (class_49)var6;
                }
                return null;
            }
            ((class_44)var6).method_248(var5, this);
        }
        var2.method_118(var5);
        this.method_519(var5, var4);
        var5.method_270(var1, var3);
        return var5;
    }

    // $FF: renamed from: a (m.ar, char[][]) m.ai
    public class_50 method_496(class_38 var1, char[][] var2) {
        if (var1 == null) {
            var1 = this.method_487(var2, true);
            if (var1 == field_366) {
                var1 = this.field_347;
            }
        }
        class_50 var10000 = new class_50(var1, var2, this);
        class_50 var3 = var10000;
        if (var3.field_177 != 1) {
            Object var4 = this.method_508(class_17.field_99);
            if (var4 == null) {
                var4 = this.method_496((class_38)null, class_17.field_99);
            }
            var3.method_279((class_43)var4);
        }
        var1.method_118(var3);
        return var3;
    }

    // $FF: renamed from: a (char[][]) m.ar
    public class_38 method_497(char[][] var1) {
        class_38 var2 = this.method_505(var1[0]);
        class_38 var10000;
        if (var2 == null || var2 == field_366) {
            var10000 = new class_38(var1[0], this);
            var2 = var10000;
            this.field_348.method_3220(var1[0], var2);
        }
        int var3 = 1;
        for (int var4 = var1.length; var3 < var4; ++var3) {
            class_43 var5 = var2.method_124(var1[var3]);
            if (var5 != null && var5 != field_367 && !(var5 instanceof class_44)) {
                return null;
            }
            class_38 var6 = var2;
            if ((var2 = var2.method_122(var1[var3])) == null || var2 == field_366) {
                if (this.field_351.method_81(var1[var3], var6.field_171) != null) {
                    return null;
                }
                var10000 = new class_38(class_233.method_1387(var1, 0, var3 + 1), var6, this);
                var2 = var10000;
                var6.method_117(var2);
            }
        }
        return var2;
    }

    // $FF: renamed from: a (m.ae, m.at) m.ap
    public class_63 method_498(class_58 var1, class_53 var2) {
        class_63[] var3 = (class_63[])((class_63[])this.field_361.method_3241(var1));
        boolean var4 = false;
        int var5 = 0;
        int var6;
        class_63 var7;
        if (var3 != null) {
            for (var6 = var3.length; var5 < var6; ++var5) {
                var7 = var3[var5];
                if (var7 == null) {
                    break;
                }
                if (var7.field_297 && var7.field_278 == (var2 == null ? var1.field_278 : var2)) {
                    return var7;
                }
            }
            var4 = true;
        } else {
            var3 = new class_63[5];
            this.field_361.method_3242(var1, var3);
        }
        var6 = var3.length;
        if (var4 && var5 == var6) {
            System.arraycopy(var3, 0, var3 = new class_63[var6 * 2], 0, var6);
            this.field_361.method_3242(var1, var3);
        }
        class_63 var10000 = new class_63(var1, var2, this);
        var7 = var10000;
        var3[var5] = var7;
        return var7;
    }

    // $FF: renamed from: a (m.ae, m.s[]) m.ap
    public class_63 method_499(class_58 var1, class_40[] var2) {
        class_63[] var3 = (class_63[])((class_63[])this.field_361.method_3241(var1));
        int var4 = var2 == null ? 0 : var2.length;
        boolean var5 = false;
        int var6 = 0;
        int var7;
        class_63 var8;
        if (var3 != null) {
            label53:
            for (var7 = var3.length; var6 < var7; ++var6) {
                var8 = var3[var6];
                if (var8 == null) {
                    break;
                }
                if (!var8.field_297) {
                    class_40[] var9 = var8.field_293;
                    int var10 = var9 == null ? 0 : var9.length;
                    if (var4 == var10) {
                        for (int var11 = 0; var11 < var10; ++var11) {
                            if (var2[var11] != var9[var11]) {
                                continue label53;
                            }
                        }
                        return var8;
                    }
                }
            }
            var5 = true;
        } else {
            var3 = new class_63[5];
            this.field_361.method_3242(var1, var3);
        }
        var7 = var3.length;
        if (var5 && var6 == var7) {
            System.arraycopy(var3, 0, var3 = new class_63[var7 * 2], 0, var7);
            this.field_361.method_3242(var1, var3);
        }
        class_63 var10000 = new class_63(var1, var2, this);
        var8 = var10000;
        var3[var6] = var8;
        return var8;
    }

    // $FF: renamed from: a (m.as, m.s[], m.as) m.al
    public class_52 method_500(class_43 var1, class_40[] var2, class_43 var3) {
        class_52[] var4 = (class_52[])((class_52[])this.field_358.method_3241(var1));
        int var5 = var2 == null ? 0 : var2.length;
        boolean var6 = false;
        int var7 = 0;
        int var8;
        class_52 var9;
        if (var4 != null) {
            label56:
            for (var8 = var4.length; var7 < var8; ++var7) {
                var9 = var4[var7];
                if (var9 == null) {
                    break;
                }
                if (var9.method_283() == var1 && var9.method_137() == var3) {
                    class_40[] var10 = var9.field_243;
                    int var11 = var10 == null ? 0 : var10.length;
                    if (var5 == var11) {
                        for (int var12 = 0; var12 < var11; ++var12) {
                            if (var2[var12] != var10[var12]) {
                                continue label56;
                            }
                        }
                        return var9;
                    }
                }
            }
            var6 = true;
        } else {
            var4 = new class_52[5];
            this.field_358.method_3242(var1, var4);
        }
        var8 = var4.length;
        if (var6 && var7 == var8) {
            System.arraycopy(var4, 0, var4 = new class_52[var8 * 2], 0, var8);
            this.field_358.method_3242(var1, var4);
        }
        class_52 var10000 = new class_52(var1, var2, var3, this);
        var9 = var10000;
        var4[var7] = var9;
        return var9;
    }

    // $FF: renamed from: a (m.as, m.as) m.at
    public class_53 method_501(class_43 var1, class_43 var2) {
        class_53[] var3 = (class_53[])((class_53[])this.field_359.method_3241(var1));
        boolean var4 = false;
        int var5 = 0;
        int var6;
        class_53 var7;
        if (var3 != null) {
            for (var6 = var3.length; var5 < var6; ++var5) {
                var7 = var3[var5];
                if (var7 == null) {
                    break;
                }
                if (var7.method_283() == var1 && var7.method_137() == var2) {
                    return var7;
                }
            }
            var4 = true;
        } else {
            var3 = new class_53[1];
            this.field_359.method_3242(var1, var3);
        }
        var6 = var3.length;
        if (var4 && var5 == var6) {
            System.arraycopy(var3, 0, var3 = new class_53[var6 * 2], 0, var6);
            this.field_359.method_3242(var1, var3);
        }
        class_53 var10000 = new class_53(var1, var2, this);
        var7 = var10000;
        var3[var5] = var7;
        return var7;
    }

    // $FF: renamed from: a (m.as, int, m.s, m.s[], int) m.z
    public class_45 method_502(class_43 var1, int var2, class_40 var3, class_40[] var4, int var5) {
        if (var1 == null) {
            var1 = class_43.field_205;
        }
        class_45[] var6 = (class_45[])((class_45[])this.field_360.method_3241(var1));
        boolean var7 = false;
        int var8 = 0;
        int var9;
        class_45 var10;
        if (var6 != null) {
            label73:
            for (var9 = var6.length; var8 < var9; ++var8) {
                var10 = var6[var8];
                if (var10 == null) {
                    break;
                }
                if (var10.field_210 == var1 && var10.field_211 == var2 && var10.field_215 == var5 && var10.field_212 == var3) {
                    if (var10.field_213 != var4) {
                        int var11 = var10.field_213 == null ? 0 : var10.field_213.length;
                        int var12 = var4 == null ? 0 : var4.length;
                        if (var11 != var12) {
                            continue;
                        }
                        for (int var13 = 0; var13 < var12; ++var13) {
                            if (var10.field_213[var13] != var4[var13]) {
                                continue label73;
                            }
                        }
                    }
                    return var10;
                }
            }
            var7 = true;
        } else {
            var6 = new class_45[10];
            this.field_360.method_3242(var1, var6);
        }
        var9 = var6.length;
        if (var7 && var8 == var9) {
            System.arraycopy(var6, 0, var6 = new class_45[var9 * 2], 0, var9);
            this.field_360.method_3242(var1, var6);
        }
        class_45 var10000 = new class_45(var1, var2, var3, var4, var5, this);
        var10 = var10000;
        var6[var8] = var10;
        return var10;
    }

    // $FF: renamed from: a (m.s) k.c
    public class_345 method_503(class_40 var1) {
        return (class_345)this.field_345.method_38(var1);
    }

    // $FF: renamed from: b (char[][]) m.as
    public class_43 method_504(char[][] var1) {
        if (var1.length == 1) {
            return this.field_347 == null ? null : this.field_347.method_124(var1[0]);
        } else {
            class_38 var2 = this.method_505(var1[0]);
            if (var2 != null && var2 != field_366) {
                int var3 = 1;
                for (int var4 = var1.length - 1; var3 < var4; ++var3) {
                    if ((var2 = var2.method_122(var1[var3])) == null || var2 == field_366) {
                        return null;
                    }
                }
                return var2.method_124(var1[var1.length - 1]);
            } else {
                return null;
            }
        }
    }

    // $FF: renamed from: a (char[]) m.ar
    class_38 method_505(char[] var1) {
        return this.field_348.method_3219(var1);
    }

    // $FF: renamed from: a (char[][], m.bb) m.as
    public class_43 method_506(char[][] var1, class_83 var2) {
        class_43 var3 = this.method_508(var1);
        if (var3 != null) {
            return var3;
        } else {
            this.field_353.method_1655(var1, var2 == null ? this.field_362 : var2.method_645(), this.field_363);
            return this.method_496((class_38)null, var1);
        }
    }

    // $FF: renamed from: b (char[]) m.ar
    class_38 method_507(char[] var1) {
        class_38 var2 = this.method_505(var1);
        if (var2 != null) {
            return var2 == field_366 ? null : var2;
        } else if (this.field_351.method_82((char[][])null, var1)) {
            class_324 var10000 = this.field_348;
            class_38 var10002 = new class_38(var1, this);
            var2 = var10002;
            var10000.method_3220(var1, var10002);
            return var2;
        } else {
            this.field_348.method_3220(var1, field_366);
            return null;
        }
    }

    // $FF: renamed from: c (char[][]) m.as
    public class_43 method_508(char[][] var1) {
        class_43 var2;
        class_38 var3;
        if (var1.length == 1) {
            if (this.field_347 == null) {
                return null;
            }
            if ((var2 = this.field_347.method_124(var1[0])) == null) {
                var3 = this.method_505(var1[0]);
                if (var3 != null && var3 != field_366) {
                    return null;
                }
                var2 = this.method_482(this.field_347, var1[0]);
            }
        } else {
            var3 = this.method_505(var1[0]);
            if (var3 == field_366) {
                return null;
            }
            if (var3 != null) {
                int var4 = 1;
                for (int var5 = var1.length - 1; var4 < var5 && (var3 = var3.method_122(var1[var4])) != null; ++var4) {
                    if (var3 == field_366) {
                        return null;
                    }
                }
            }
            if (var3 == null) {
                var2 = this.method_481(var1);
            } else if ((var2 = var3.method_124(var1[var1.length - 1])) == null) {
                var2 = this.method_482(var3, var1[var1.length - 1]);
            }
        }
        if (var2 != null && var2 != field_367) {
            var2 = class_49.method_267(var2, this, false);
            if (var2.method_160()) {
                class_51 var10000 = new class_51(var1, var2, 4);
                return var10000;
            } else {
                return var2;
            }
        } else {
            return null;
        }
    }

    // $FF: renamed from: a (m.ba, m.x[], m.as, m.as, char[][][]) m.s[]
    private class_40[] method_509(class_197 var1, class_46[] var2, class_43 var3, class_43 var4, char[][][] var5) {
        class_313 var10000 = new class_313(2);
        class_313 var6 = var10000;
        int var7 = 0;
        do {
            var6.method_34(this.method_514(var1, var2, var3, var4, var7++, var5));
        } while (var1.field_872[var1.field_873] != 62);
        ++var1.field_873;
        class_40[] var8 = new class_40[var6.method_29()];
        var6.method_33(var8);
        return var8;
    }

    // $FF: renamed from: a (char[][], boolean, boolean) m.as
    private class_43 method_510(char[][] var1, boolean var2, boolean var3) {
        Object var4 = this.method_504(var1);
        if (var4 == null) {
            class_38 var5 = this.method_487(var1, false);
            class_44 var10000 = new class_44(var1, var5);
            var4 = var10000;
            if (var3) {
                ((class_43)var4).field_178 |= 128L;
            }
            var5.method_118((class_43)var4);
        } else if (var4 == field_367) {
            this.field_353.method_1655(var1, this.field_362, this.field_363);
            var4 = this.method_496((class_38)null, var1);
        } else if (!var2) {
            var4 = (class_43)this.method_491((class_40)var4);
        }
        return (class_43)var4;
    }

    // $FF: renamed from: a (char[], int, int, boolean, char[][][]) m.as
    class_43 method_511(char[] var1, int var2, int var3, boolean var4, char[][][] var5) {
        if (var3 == -1) {
            var3 = var1.length;
        }
        char[][] var6 = class_233.method_1386('/', var1, var2, var3);
        boolean var7 = false;
        if (var5 != null) {
            int var8 = 0;
            for (int var9 = var5.length; var8 < var9; ++var8) {
                if (class_233.method_1363(var6, var5[var8])) {
                    var7 = true;
                    break;
                }
            }
        }
        return this.method_510(var6, var4, var7);
    }

    // $FF: renamed from: a (char[], int, int, boolean, m.s, char[][][]) m.s
    class_40 method_512(char[] var1, int var2, int var3, boolean var4, class_40 var5, char[][][] var6) {
        int var7;
        for (var7 = 0; var1[var2] == 91; ++var7) {
            ++var2;
        }
        if (var3 == -1) {
            var3 = var1.length - 1;
        }
        Object var8 = null;
        if (var2 == var3) {
            switch (var1[var2]) {
                case 66:
                    var8 = class_40.field_180;
                    break;
                case 67:
                    var8 = class_40.field_182;
                    break;
                case 68:
                    var8 = class_40.field_185;
                    break;
                case 69:
                case 71:
                case 72:
                case 75:
                case 76:
                case 77:
                case 78:
                case 79:
                case 80:
                case 81:
                case 82:
                case 84:
                case 85:
                case 87:
                case 88:
                case 89:
                default:
                    this.field_353.method_1513(var5, var1, var2);
                    break;
                case 70:
                    var8 = class_40.field_184;
                    break;
                case 73:
                    var8 = class_40.field_179;
                    break;
                case 74:
                    var8 = class_40.field_183;
                    break;
                case 83:
                    var8 = class_40.field_181;
                    break;
                case 86:
                    var8 = class_40.field_188;
                    break;
                case 90:
                    var8 = class_40.field_186;
            }
        } else {
            var8 = this.method_511(var1, var2 + 1, var3, var4, var6);
        }
        return (class_40)(var7 == 0 ? var8 : this.method_493((class_40)var8, var7));
    }

    // $FF: renamed from: a (m.ba, m.x[], m.as, char[][][]) m.s
    public class_40 method_513(class_197 var1, class_46[] var2, class_43 var3, char[][][] var4) {
        int var5;
        for (var5 = 0; var1.field_872[var1.field_873] == 91; ++var5) {
            ++var1.field_873;
        }
        class_43 var16;
        if (var1.field_872[var1.field_873] != 84) {
            boolean var14;
            class_40 var15 = this.method_512(var1.field_872, var1.field_873, var1.method_1162(), var14 = var1.field_874 == var1.field_875, var3, var4);
            if (!var14) {
                return (class_40)(var5 == 0 ? var15 : this.method_493(var15, var5));
            } else {
                var16 = (class_43)var15;
                if (var16 instanceof class_44 && class_233.method_1371('$', var16.field_197[var16.field_197.length - 1]) > 0) {
                    var16 = class_49.method_267(var16, this, false);
                }
                class_43 var17 = var16.method_137();
                if (var17 != null) {
                    var17 = (class_43)this.method_490(var17, false);
                }
                class_40[] var18 = this.method_509(var1, var2, var3, var16, var4);
                class_52 var11;
                class_43 var13;
                for (var11 = this.method_500(var16, var18, var17); var1.field_872[var1.field_873] == 46; var11 = this.method_500(var13, var18, var11)) {
                    ++var1.field_873;
                    char[] var12 = var1.method_1163();
                    class_49.method_267(var11, this, false);
                    var13 = var11.method_286().method_209(var12);
                    if (var1.field_872[var1.field_873] == 60) {
                        ++var1.field_873;
                        var18 = this.method_509(var1, var2, var3, var13, var4);
                    } else {
                        var18 = null;
                    }
                }
                ++var1.field_873;
                if (var5 == 0) {
                    return var11;
                }
                return this.method_493(var11, var5);
            }
        } else {
            int var6 = var1.field_873 + 1;
            int var7 = var1.method_1162();
            int var8 = var2.length;
            do {
                --var8;
                if (var8 < 0) {
                    var16 = var3;
                    label86:
                    while (true) {
                        class_46[] var9;
                        if (var3 instanceof class_49) {
                            var9 = ((class_49)var3).field_237;
                        } else {
                            var9 = var3.method_181();
                        }
                        int var10 = var9.length;
                        do {
                            --var10;
                            if (var10 < 0) {
                                if ((var3 = var3.method_137()) == null) {
                                    this.field_353.method_1782(class_233.method_1388(var1.field_872, var6, var7), var16);
                                    return null;
                                }
                                continue label86;
                            }
                        } while (!class_233.method_1365(var9[var10].field_198, var1.field_872, var6, var7));
                        if (var5 == 0) {
                            return var9[var10];
                        }
                        return this.method_493(var9[var10], var5);
                    }
                }
            } while (!class_233.method_1365(var2[var8].field_198, var1.field_872, var6, var7));
            if (var5 == 0) {
                return var2[var8];
            }
            return this.method_493(var2[var8], var5);
        }
    }

    // $FF: renamed from: a (m.ba, m.x[], m.as, m.as, int, char[][][]) m.s
    class_40 method_514(class_197 var1, class_46[] var2, class_43 var3, class_43 var4, int var5, char[][][] var6) {
        class_40 var7;
        switch (var1.field_872[var1.field_873]) {
            case 42:
                ++var1.field_873;
                return this.method_502(var4, var5, (class_40)null, (class_40[])null, 0);
            case 43:
                ++var1.field_873;
                var7 = this.method_513(var1, var2, var3, var6);
                return this.method_502(var4, var5, var7, (class_40[])null, 1);
            case 44:
            default:
                return this.method_513(var1, var2, var3, var6);
            case 45:
                ++var1.field_873;
                var7 = this.method_513(var1, var2, var3, var6);
                return this.method_502(var4, var5, var7, (class_40[])null, 2);
        }
    }

    // $FF: renamed from: a (char[][], char[]) boolean
    boolean method_515(char[][] var1, char[] var2) {
        return var1 != null && var1.length != 0 ? this.field_351.method_82(var1, var2) : this.field_351.method_82((char[][])null, var2);
    }

    // $FF: renamed from: a () m.ak
    public class_81 method_516() {
        if (this.field_365 == null) {
            Object var10001;
            if (this.field_352.field_1928 < 3211264L) {
                var10001 = new class_81(this);
            } else {
                var10001 = new class_82(this);
            }
            this.field_365 = (class_81)var10001;
        }
        return this.field_365;
    }

    // $FF: renamed from: a (c.d[]) void
    public void method_517(class_288[] var1) {
        int var2 = 0;
        for (int var3 = var1.length; var2 < var3; ++var2) {
            this.field_354.method_3028(var1[var2]);
        }
    }

    // $FF: renamed from: b () void
    public void method_518() {
        class_38 var10001 = new class_38(this);
        this.field_347 = var10001;
        this.field_346 = null;
        class_324 var6 = new class_324();
        this.field_348 = var6;
        class_312 var4 = new class_312(3);
        this.field_345 = var4;
        this.field_365 = null;
        int var1 = this.field_357.length;
        while (true) {
            --var1;
            if (var1 < 0) {
                class_327 var5 = new class_327(3);
                this.field_358 = var5;
                var5 = new class_327(3);
                this.field_359 = var5;
                var5 = new class_327(3);
                this.field_360 = var5;
                var5 = new class_327(3);
                this.field_361 = var5;
                var1 = this.field_364.length;
                while (true) {
                    --var1;
                    if (var1 < 0) {
                        this.field_350 = -1;
                        this.field_349 = -1;
                        this.field_362 = null;
                        this.field_354.method_3029();
                        return;
                    }
                    this.field_364[var1] = null;
                }
            }
            class_42[] var2 = this.field_357[var1];
            if (var2 != null) {
                int var3 = var2.length;
                while (true) {
                    --var3;
                    if (var3 < 0) {
                        break;
                    }
                    var2[var3] = null;
                }
            }
        }
    }

    // $FF: renamed from: a (m.as, k.c) void
    public void method_519(class_43 var1, class_345 var2) {
        if (var2 != null) {
            var1.field_199 |= 262144;
            this.field_345.method_39(var1, var2);
        }
    }

    // $FF: renamed from: a (m.m, m.as) void
    void method_520(class_44 var1, class_43 var2) {
        Object[] var3;
        int var4;
        int var5;
        if (this.field_358.method_3241(var1) != null) {
            var3 = this.field_358.field_1852;
            var4 = 0;
            for (var5 = var3.length; var4 < var5; ++var4) {
                if (var3[var4] == var1) {
                    var3[var4] = var2;
                    break;
                }
            }
        }
        if (this.field_359.method_3241(var1) != null) {
            var3 = this.field_359.field_1852;
            var4 = 0;
            for (var5 = var3.length; var4 < var5; ++var4) {
                if (var3[var4] == var1) {
                    var3[var4] = var2;
                    break;
                }
            }
        }
        if (this.field_360.method_3241(var1) != null) {
            var3 = this.field_360.field_1852;
            var4 = 0;
            for (var5 = var3.length; var4 < var5; ++var4) {
                if (var3[var4] == var1) {
                    var3[var4] = var2;
                    break;
                }
            }
        }
    }

    // $FF: renamed from: <clinit> () void
    static {
        class_39 var10000 = new class_39(class_233.field_994, 1);
        field_366 = var10000;
        class_51 var0 = new class_51(class_233.field_995, (class_43)null, 1);
        field_367 = var0;
    }
}
