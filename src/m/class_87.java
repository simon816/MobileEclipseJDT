package m;

import a.class_33;
import h.class_114;
import h.class_123;
import h.class_125;
import h.class_162;
import h.class_163;
import h.class_89;
import h.class_93;
import h.class_94;
import i.class_268;
import l.class_301;
import l.class_303;
import m.class_0;
import m.class_34;
import m.class_40;
import m.class_43;
import m.class_54;
import m.class_58;
import m.class_65;
import m.class_66;
import m.class_67;
import m.class_69;
import m.class_84;
import m.class_86;
import n.class_248;

// $FF: renamed from: m.aj
public class class_87 extends class_86 {

    // $FF: renamed from: a a.i
    public class_33 field_403;
    // $FF: renamed from: a boolean
    public boolean field_404;
    // $FF: renamed from: b boolean
    public boolean field_405;
    // $FF: renamed from: a m.k
    public class_67 field_406;
    // $FF: renamed from: f int
    public int field_407;
    // $FF: renamed from: g int
    public int field_408;
    // $FF: renamed from: h int
    public int field_409;
    // $FF: renamed from: a long[]
    public long[] field_410;
    // $FF: renamed from: a long[][]
    public long[][] field_411;
    // $FF: renamed from: c boolean
    public boolean field_412;
    // $FF: renamed from: a m.a[]
    public class_66[] field_413;

    // $FF: renamed from: <init> (m.f, a.i, boolean) void
    public class_87(class_84 var1, class_33 var2, boolean var3) {
        super(2, var1);
        this.field_405 = false;
        this.field_407 = -1;
        this.field_409 = 0;
        this.field_410 = new long[4];
        this.field_411 = new long[4][];
        this.field_412 = false;
        this.field_391 = new class_65[5];
        this.field_403 = var2;
        this.field_404 = var3;
        this.field_393 = 0;
    }

    // $FF: renamed from: a (int) java.lang.String
    String method_707(int var1) {
        String var2 = "\n";
        int var3 = var1;
        while (true) {
            --var3;
            if (var3 < 0) {
                String var5 = var2 + "--- Method Scope ---";
                var2 = var2 + "\t";
                var5 = var5 + var2 + "locals:";
                for (int var4 = 0; var4 < this.field_392; ++var4) {
                    var5 = var5 + var2 + "\t" + this.field_391[var4].toString();
                }
                var5 = var5 + var2 + "startIndex = " + this.field_393;
                var5 = var5 + var2 + "isConstructorCall = " + this.field_405;
                var5 = var5 + var2 + "initializedField = " + this.field_406;
                var5 = var5 + var2 + "lastVisibleFieldID = " + this.field_407;
                var5 = var5 + var2 + "referenceContext = " + this.field_403;
                return var5;
            }
            var2 = var2 + "\t";
        }
    }

    // $FF: renamed from: b (m.ae) void
    private void method_721(class_58 var1) {
        int var2 = var1.field_273;
        class_43 var3 = var1.field_278;
        if ((var2 & 4194304) != 0) {
            this.method_644().method_1531(var3, (class_93)this.field_403);
        }
        int var6;
        if ((((class_94)this.field_403).field_446 & 128) != 0 && (var6 = var3.field_199 & 16389) != 0) {
            if ((var6 & 16384) != 0) {
                var2 &= -8;
                var2 |= 2;
            } else {
                var2 &= -8;
                var2 |= var6;
            }
        }
        int var4 = var2 & '\uffff';
        if (var3.method_153() && (((class_94)this.field_403).field_446 & 128) == 0) {
            if ((var4 & -2051) != 0) {
                this.method_644().method_1583((class_93)this.field_403);
                var2 &= -63486;
            } else if ((((class_93)this.field_403).field_482 & 2048) != 0) {
                this.method_644().method_1593((class_93)this.field_403);
            }
            var2 |= 2;
        } else if ((var4 & -2056) != 0) {
            this.method_644().method_1593((class_93)this.field_403);
            var2 &= -63481;
        } else if ((((class_93)this.field_403).field_482 & 2048) != 0) {
            this.method_644().method_1593((class_93)this.field_403);
        }
        var6 = var4 & 7;
        if ((var6 & var6 - 1) != 0) {
            this.method_644().method_1603(var3, (class_93)this.field_403);
            if ((var6 & 1) != 0) {
                if ((var6 & 4) != 0) {
                    var2 &= -5;
                }
                if ((var6 & 2) != 0) {
                    var2 &= -3;
                }
            } else if ((var6 & 4) != 0 && (var6 & 2) != 0) {
                var2 &= -3;
            }
        }
        var1.field_273 = var2;
    }

    // $FF: renamed from: c (m.ae) void
    private void method_722(class_58 var1) {
        int var2 = var1.field_273;
        class_43 var3 = var1.field_278;
        if ((var2 & 4194304) != 0) {
            this.method_644().method_1531(var3, (class_93)this.field_403);
        }
        int var4 = var2 & '\uffff';
        if (var3.method_157()) {
            if ((var4 & -1026) != 0) {
                if ((var3.field_199 & 8192) != 0) {
                    this.method_644().method_1577((class_93)this.field_403);
                } else {
                    this.method_644().method_1587((class_93)this.field_403);
                }
            }
        } else {
            if ((var4 & -3392) != 0) {
                this.method_644().method_1593((class_93)this.field_403);
                var2 &= -62145;
            }
            int var6 = var4 & 7;
            if ((var6 & var6 - 1) != 0) {
                this.method_644().method_1603(var3, (class_93)this.field_403);
                if ((var6 & 1) != 0) {
                    if ((var6 & 4) != 0) {
                        var2 &= -5;
                    }
                    if ((var6 & 2) != 0) {
                        var2 &= -3;
                    }
                } else if ((var6 & 4) != 0 && (var6 & 2) != 0) {
                    var2 &= -3;
                }
            }
            if ((var2 & 1024) != 0) {
                short var7 = 2362;
                if ((var2 & var7) != 0) {
                    this.method_644().method_1566(var3, (class_93)this.field_403);
                }
                if (!var1.field_278.method_217()) {
                    this.method_644().method_1462((class_54)var3, (class_93)this.field_403);
                }
            }
            if ((var2 & 256) != 0 && (var2 & 2048) != 0) {
                this.method_644().method_1688(var3, (class_93)this.field_403);
            }
            if ((var4 & 8) != 0 && var3.method_160() && !var3.method_226()) {
                this.method_644().method_1785(var3, (class_93)this.field_403);
            }
            var1.field_273 = var2;
        }
    }

    // $FF: renamed from: a (m.ae) void
    public void method_723(class_58 var1) {
        if (!var1.method_356() && (!var1.method_363() || this.method_577().field_1941) && (!var1.method_366() || var1.method_363() || this.method_577().field_1942) && !var1.method_364()) {
            int var2 = 0;
            for (int var3 = this.field_392; var2 < var3; ++var2) {
                class_65 var4 = this.field_391[var2];
                if (var4 == null || (var4.field_305 & 1024L) == 0L) {
                    break;
                }
                if (var4.field_307 == 0 && (var4.field_309.field_446 & 1073741824) != 0) {
                    this.method_644().method_1807(var4.field_309);
                }
            }
        }
    }

    // $FF: renamed from: a (int, i.o) void
    public void method_724(int var1, class_268 var2) {
        this.field_394 = var1;
        this.field_395 = var1;
        int var3 = 0;
        for (int var4 = this.field_392; var3 < var4; ++var3) {
            class_65 var5 = this.field_391[var3];
            if (var5 == null || (var5.field_305 & 1024L) == 0L) {
                break;
            }
            var2.method_2358(var5);
            var5.field_306 = this.field_394;
            if (var5.field_301 != class_40.field_183 && var5.field_301 != class_40.field_185) {
                ++this.field_394;
            } else {
                this.field_394 += 2;
            }
            if (this.field_394 > 255) {
                this.method_644().method_1697(var5, var5.field_309);
            }
        }
        if (this.field_413 != null) {
            int var8 = 0;
            for (int var6 = this.field_413.length; var8 < var6; ++var8) {
                class_66 var7 = this.field_413[var8];
                var7.field_306 = this.field_394;
                if (var7.field_301 != class_40.field_183 && var7.field_301 != class_40.field_185) {
                    ++this.field_394;
                } else {
                    this.field_394 += 2;
                }
                if (this.field_394 > 255) {
                    this.method_644().method_1697(var7, (class_89)this.field_403);
                }
            }
        }
        this.method_709(var3, this.field_394, var2);
    }

    // $FF: renamed from: a (h.ci) m.ae
    class_58 method_725(class_93 var1) {
        this.field_403 = var1;
        var1.field_478 = this;
        class_54 var2 = this.method_718().field_586;
        int var3 = var1.field_482 | 33554432;
        class_58 var10001;
        if (var1.method_795()) {
            if (var1.method_796()) {
                var3 |= 67108864;
            }
            var10001 = new class_58(var3, (class_40[])null, (class_43[])null, var2);
            var1.field_488 = var10001;
            this.method_721(var1.field_488);
        } else {
            if (var2.method_157()) {
                var3 |= 1025;
            }
            var10001 = new class_58(var3, var1.field_479, (class_40)null, (class_40[])null, (class_43[])null, var2);
            var1.field_488 = var10001;
            this.method_722(var1.field_488);
        }
        this.field_404 = var1.field_488.method_370();
        class_125[] var4 = var1.field_484;
        int var5 = var4 == null ? 0 : var4.length;
        if (var5 > 0 && this.method_577().field_1928 >= 3211264L) {
            --var5;
            if (var4[var5].method_904()) {
                var1.field_488.field_273 |= 128;
            }
            while (true) {
                --var5;
                if (var5 < 0) {
                    break;
                }
                if (var4[var5].method_904()) {
                    this.method_644().method_1600(var4[var5], var1);
                }
            }
        }
        class_123[] var6 = var1.method_807();
        if (var6 != null && this.method_577().field_1928 >= 3211264L) {
            var1.field_488.field_279 = this.method_581(var6, var1.field_488);
            var1.field_488.field_273 |= 1073741824;
        } else {
            var1.field_488.field_279 = class_34.field_157;
        }
        return var1.field_488;
    }

    // $FF: renamed from: a (m.s, char[], m.ad, boolean) m.k
    public class_67 method_590(class_40 var1, char[] var2, class_0 var3, boolean var4) {
        class_67 var5 = super.method_590(var1, var2, var3, var4);
        if (var5 == null) {
            return null;
        } else if (!var5.method_101()) {
            return var5;
        } else if (var5.method_431()) {
            return var5;
        } else if (this.field_405 && var1 == this.method_585()) {
            class_69 var10000;
            if (var3 instanceof class_162) {
                var10000 = new class_69(var5, var5.field_314, var2, 6);
                return var10000;
            } else {
                if (var3 instanceof class_163) {
                    class_163 var6 = (class_163)var3;
                    if (var6.field_748 == null) {
                        var10000 = new class_69(var5, var5.field_314, var2, 6);
                        return var10000;
                    }
                }
                return var5;
            }
        } else {
            return var5;
        }
    }

    // $FF: renamed from: a () boolean
    public boolean method_726() {
        return this.field_403 instanceof class_94;
    }

    // $FF: renamed from: b () boolean
    public boolean method_727() {
        return this.field_403 instanceof class_114;
    }

    // $FF: renamed from: c () boolean
    public boolean method_728() {
        return this.field_403 instanceof class_114 || this.field_403 instanceof class_94;
    }

    // $FF: renamed from: a () n.e
    public class_248 method_644() {
        class_87 var1;
        if ((var1 = this.method_641()) == this) {
            class_248 var2 = this.method_645().field_454;
            var2.field_1065 = this.field_403;
            return var2;
        } else {
            return var1.method_644();
        }
    }

    // $FF: renamed from: a (l.g) int
    public final int method_729(class_301 var1) {
        if ((var1.field_1783 & 1) != 0) {
            return -1;
        } else {
            class_303 var2 = var1.method_3110();
            long[] var3 = var2.field_1793 == null ? null : var2.field_1793[0];
            long var4 = var2.field_1787;
            int var6 = this.field_409;
            label55:
            while (true) {
                --var6;
                if (var6 < 0) {
                    if (this.field_410.length == this.field_409) {
                        System.arraycopy(this.field_410, 0, this.field_410 = new long[this.field_409 + 20], 0, this.field_409);
                        System.arraycopy(this.field_411, 0, this.field_411 = new long[this.field_409 + 20][], 0, this.field_409);
                    }
                    this.field_410[this.field_409] = var4;
                    if (var3 != null) {
                        this.field_411[this.field_409] = new long[var3.length];
                        System.arraycopy(var3, 0, this.field_411[this.field_409], 0, var3.length);
                    }
                    return this.field_409++;
                }
                if (this.field_410[var6] == var4) {
                    long[] var7 = this.field_411[var6];
                    if (var3 != null && var7 != null) {
                        if (var3.length == var7.length) {
                            int var8 = 0;
                            for (int var9 = var3.length; var8 < var9; ++var8) {
                                if (var3[var8] != var7[var8]) {
                                    continue label55;
                                }
                            }
                            return var6;
                        }
                    } else if (var3 == null && var7 == null) {
                        return var6;
                    }
                }
            }
        }
    }

    // $FF: renamed from: a () h.ci
    public class_93 method_730() {
        return this.field_403 instanceof class_93 ? (class_93)this.field_403 : null;
    }

    // $FF: renamed from: a () h.bq
    public class_114 method_718() {
        return ((class_84)this.field_374).field_376;
    }
}
