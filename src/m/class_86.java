package m;

import a.class_331;
import b.class_233;
import h.class_108;
import h.class_114;
import h.class_125;
import h.class_89;
import h.class_93;
import i.class_268;
import m.class_0;
import m.class_34;
import m.class_37;
import m.class_38;
import m.class_40;
import m.class_43;
import m.class_51;
import m.class_54;
import m.class_55;
import m.class_57;
import m.class_64;
import m.class_65;
import m.class_66;
import m.class_67;
import m.class_69;
import m.class_83;
import m.class_84;
import m.class_85;
import m.class_87;
import n.class_248;

public class class_86 extends class_83 {

    public class_65[] field_391;

    public int field_392;

    public int field_393;

    public int field_394;

    public int field_395;

    public class_86[] field_396;

    public class_83[] field_397;

    public int field_398;

    public class_108 field_399;

    public static final class_64[] field_400;

    public static final class_64[] field_401;

    public static final class_64[] field_402;

    public class_86(class_86 var1) {
        this(var1, true);
    }

    public class_86(class_86 var1, boolean var2) {
        this(1, var1);
        this.field_391 = new class_65[5];
        if (var2) {
            var1.method_705(this);
        }
        this.field_393 = var1.field_392;
    }

    public class_86(class_86 var1, int var2) {
        this(1, var1);
        this.field_391 = new class_65[var2];
        var1.method_705(this);
        this.field_393 = var1.field_392;
    }

    protected class_86(int var1, class_83 var2) {
        super(var1, var2);
        this.field_397 = new class_83[1];
        this.field_398 = 0;
    }

    public final void method_702(class_114 var1, class_43 var2) {
        class_84 var10000 = new class_84(this, var1);
        class_84 var3 = var10000;
        var3.method_648(this.method_585(), var2);
    }

    public final void method_703(class_114 var1) {
        class_84 var10000 = new class_84(this, var1);
        class_84 var2 = var10000;
        this.method_705(var2);
        var2.method_652(this.method_585());
    }

    public final void method_704(class_65 var1) {
        this.method_708(var1);
        if (this.field_392 == this.field_391.length) {
            System.arraycopy(this.field_391, 0, this.field_391 = new class_65[this.field_392 * 2], 0, this.field_392);
        }
        this.field_391[this.field_392++] = var1;
        var1.field_308 = this;
        class_87 var10001 = this.method_641();
        int var10003 = var10001.field_408;
        class_87 var10002 = var10001;
        int var2 = var10001.field_408;
        var10002.field_408 = var10003 + 1;
        var1.field_304 = var2;
    }

    public void method_705(class_83 var1) {
        if (this.field_398 == this.field_397.length) {
            System.arraycopy(this.field_397, 0, this.field_397 = new class_83[this.field_398 * 2], 0, this.field_398);
        }
        this.field_397[this.field_398++] = var1;
    }

    public final boolean method_706(class_67 var1) {
        if (this.method_584() != var1.field_314) {
            return false;
        } else {
            class_87 var2 = this.method_635();
            return var2.field_404 != var1.method_431() ? false : var2.method_727() || ((class_93)var2.field_403).method_797();
        }
    }

    String method_707(int var1) {
        String var2 = "\n";
        int var3 = var1;
        while (true) {
            --var3;
            if (var3 < 0) {
                String var5 = var2 + "--- Block Scope ---";
                var2 = var2 + "\t";
                var5 = var5 + var2 + "locals:";
                for (int var4 = 0; var4 < this.field_392; ++var4) {
                    var5 = var5 + var2 + "\t" + this.field_391[var4].toString();
                }
                var5 = var5 + var2 + "startIndex = " + this.field_393;
                return var5;
            }
            var2 = var2 + "\t";
        }
    }

    private void method_708(class_65 var1) {
        int var2 = var1.field_300;
        if ((var2 & 4194304) != 0 && var1.field_309 != null) {
            this.method_644().method_1533(var1.field_309, this instanceof class_87);
        }
        int var3 = var2 & '\uffff';
        byte var4 = -17;
        if ((var3 & var4) != 0 && var1.field_309 != null) {
            this.method_644().method_1594(var1.field_309, this instanceof class_87);
        }
        var1.field_300 = var2;
    }

    void method_709(int var1, int var2, class_268 var3) {
        this.field_394 = var2;
        this.field_395 = var2;
        int var4 = this.field_392;
        boolean var5 = var1 < var4;
        int var6 = 0;
        int var7 = this.field_398;
        boolean var8 = var7 > 0;
        while (var5 || var8) {
            if (var8 && (!var5 || this.field_397[var6].method_646() <= var1)) {
                if (this.field_397[var6] instanceof class_86) {
                    class_86 var11 = (class_86)this.field_397[var6];
                    int var12 = var11.field_396 == null ? this.field_394 : var11.method_715();
                    var11.method_709(0, var12, var3);
                    if (var11.field_395 > this.field_395) {
                        this.field_395 = var11.field_395;
                    }
                }
                ++var6;
                var8 = var6 < var7;
            } else {
                class_65 var9 = this.field_391[var1];
                boolean var10 = var9.field_307 == 1 && var9.method_407() == class_331.field_1896;
                if (var9.field_307 == 0 && var9.field_309 != null && (var9.field_309.field_446 & 1073741824) != 0 && !(var9.field_309 instanceof class_125)) {
                    this.method_644().method_1811(var9.field_309);
                }
                if (!var10 && var9.field_309 != null && this.method_577().field_1933) {
                    var10 = true;
                    var9.field_307 = 1;
                }
                if (var10) {
                    if (var9.field_309 != null) {
                        var3.method_2358(var9);
                    }
                    var9.field_306 = this.field_394;
                    if (var9.field_301 != class_40.field_183 && var9.field_301 != class_40.field_185) {
                        ++this.field_394;
                    } else {
                        this.field_394 += 2;
                    }
                    if (this.field_394 > '\uffff') {
                        this.method_644().method_1699(var9, (class_89)(var9.field_309 == null ? (class_89)this.method_635().field_403 : var9.field_309));
                    }
                } else {
                    var9.field_306 = -1;
                }
                ++var1;
                var5 = var1 < var4;
            }
        }
        if (this.field_394 > this.field_395) {
            this.field_395 = this.field_394;
        }
    }

    public void method_710(class_65 var1) {
        class_86 var2 = var1.field_308;
        if (var2 != null) {
            class_87 var3 = this.method_635();
            if (var2.method_635() != var3) {
                class_55 var4 = (class_55)this.method_585();
                if (!var4.method_158()) {
                    return;
                }
                if (!var3.method_728()) {
                    var4.method_325(var1);
                } else {
                    var4.method_323(var1);
                }
            }
        }
    }

    public final class_43 method_711(char[] var1) {
        long var2 = this.method_577().field_1927;
        for (int var4 = this.field_398 - 1; var4 >= 0; --var4) {
            if (this.field_397[var4] instanceof class_84) {
                class_57 var5 = (class_57)((class_84)this.field_397[var4]).field_376.field_586;
                if ((var2 < 3145728L || var5.field_270 == null || this.method_629(var5.field_270)) && class_233.method_1364(var5.method_179(), var1)) {
                    return var5;
                }
            }
        }
        return null;
    }

    public class_65 method_597(char[] var1) {
        int var2 = var1.length;
        for (int var3 = this.field_392 - 1; var3 >= 0; --var3) {
            class_65 var4;
            char[] var5;
            if ((var5 = (var4 = this.field_391[var3]).field_302).length == var2 && class_233.method_1364(var5, var1)) {
                return var4;
            }
        }
        return null;
    }

    public class_34 method_712(char[][] var1, int var2, class_0 var3, boolean var4) {
        class_34 var5 = this.method_598(var1[0], var2 | 4 | 16, var3, var4);
        var3.method_3(1);
        if (var5 instanceof class_64) {
            return var5;
        } else {
            class_85 var6 = this.method_576();
            var6.method_687(var1);
            if (!var5.method_101()) {
                return var5;
            } else {
                int var7 = var1.length;
                int var8 = 1;
                class_51 var10000;
                class_37 var13;
                if (var5 instanceof class_38) {
                    class_38 var9 = (class_38)var5;
                    while (true) {
                        if (var8 >= var7) {
                            var10000 = new class_51(class_233.method_1387(var1, 0, var8), (class_43)null, 1);
                            return var10000;
                        }
                        var6.method_688(var9.field_171, var1[var8]);
                        var5 = var9.method_125(var1[var8++]);
                        var3.method_3(var8);
                        if (var5 == null) {
                            if (var8 == var7) {
                                var10000 = new class_51(class_233.method_1387(var1, 0, var8), (class_43)null, 1);
                                return var10000;
                            }
                            var13 = new class_37(class_233.method_1387(var1, 0, var8), 1);
                            return var13;
                        }
                        if (var5 instanceof class_43) {
                            if (!var5.method_101()) {
                                var10000 = new class_51(class_233.method_1387(var1, 0, var8), (class_43)((class_43)var5).method_131(), var5.method_102());
                                return var10000;
                            }
                            if (!((class_43)var5).method_196(this)) {
                                var10000 = new class_51(class_233.method_1387(var1, 0, var8), (class_43)var5, 2);
                                return var10000;
                            }
                            break;
                        }
                        var9 = (class_38)var5;
                    }
                }
                class_43 var15 = (class_43)var5;
                Object var14 = this.method_586().method_490(var15, false);
                if (var3 instanceof class_89) {
                    class_89 var10 = (class_89)var3;
                    if (var10.method_756(var15, this)) {
                        this.method_644().method_1516(var15, var10);
                    }
                }
                class_69 var12;
                while (var8 < var7) {
                    var15 = (class_43)var14;
                    char[] var16 = var1[var8++];
                    var3.method_3(var8);
                    var3.method_4(var15);
                    if ((var2 & 1) != 0 && (var14 = this.method_590(var15, var16, var3, true)) != null) {
                        if (!((class_34)var14).method_101()) {
                            var12 = new class_69(((class_69)var14).field_317, ((class_69)var14).field_314, class_233.method_1361(class_233.method_1387(var1, 0, var8), '.'), ((class_34)var14).method_102());
                            return var12;
                        }
                        break;
                    }
                    if ((var14 = this.method_591(var16, var15)) == null) {
                        if ((var2 & 1) != 0) {
                            var13 = new class_37(class_233.method_1387(var1, 0, var8), var15, 1);
                            return var13;
                        }
                        var10000 = new class_51(class_233.method_1387(var1, 0, var8), var15, 1);
                        return var10000;
                    }
                    if (!((class_34)var14).method_101()) {
                        var10000 = new class_51(class_233.method_1387(var1, 0, var8), (class_43)((class_43)var14).method_131(), ((class_34)var14).method_102());
                        return var10000;
                    }
                    if (var3 instanceof class_89) {
                        var15 = (class_43)var14;
                        class_89 var11 = (class_89)var3;
                        if (var11.method_756(var15, this)) {
                            this.method_644().method_1516(var15, var11);
                        }
                    }
                }
                if ((var2 & 1) != 0 && var14 instanceof class_67) {
                    class_67 var17 = (class_67)var14;
                    if (!var17.method_431()) {
                        var12 = new class_69(var17, var17.field_314, class_233.method_1361(class_233.method_1387(var1, 0, var8), '.'), 7);
                        return var12;
                    } else {
                        return (class_34)var14;
                    }
                } else if ((var2 & 4) != 0 && var14 instanceof class_43) {
                    return (class_34)var14;
                } else {
                    var13 = new class_37(class_233.method_1387(var1, 0, var8), 1);
                    return var13;
                }
            }
        }
    }

    public class_64[] method_713(class_65 var1) {
        class_87 var2 = this.method_635();
        class_54 var3 = var2.method_585();
        class_86 var4 = var1.field_308;
        class_66 var5;
        class_67 var6;
        return var4 != null && var2 != var4.method_635() ? (var2.method_728() && var3.method_160() && (var5 = ((class_55)var3).method_328(var1)) != null ? new class_64[] {var5}: (!var2.field_404 && (var6 = var3.method_309(var1)) != null ? new class_64[] {var6}: null)): new class_64[] {var1};
    }

    public Object[] method_714(class_43 var1, boolean var2, boolean var3) {
        class_87 var4 = this.method_635();
        class_54 var5 = var4.method_585();
        if (!var4.field_404 && !var4.field_405 && (var5 == var1 || !var2 && var5.method_140(var1) != null)) {
            return field_400;
        } else if (var5.method_160() && !var5.method_226()) {
            boolean var6 = var4.method_728();
            class_66 var7;
            if (var6 && (var7 = ((class_55)var5).method_331(var1, var2)) != null) {
                return (Object[])(var3 && var4.field_405 && (var5 == var1 || !var2 && var5.method_140(var1) != null) ? field_401 : new Object[] {var7});
            } else if (var4.field_404) {
                return field_402;
            } else {
                if (var5.method_146()) {
                    class_43 var12 = var5.method_137();
                    if (var12.method_160()) {
                        class_55 var8 = (class_55)var12;
                        class_66 var9 = var8.method_331(var8.method_137(), var2);
                        if (var9 != null) {
                            class_67 var10 = var5.method_309(var9);
                            if (var10 != null && (var10.field_301 == var1 || !var2 && ((class_43)var10.field_301).method_140(var1) != null)) {
                                return new Object[] {var10};
                            }
                        }
                    }
                }
                class_67 var13 = var5.method_310(var1, var2);
                if (var13 != null) {
                    return (Object[])(var4.field_405 ? field_401 : new Object[] {var13});
                } else {
                    Object[] var14 = new Object[2];
                    class_43 var15 = var5.method_137();
                    if (var6) {
                        var14[0] = ((class_55)var5).method_331(var15, var2);
                    } else {
                        if (var4.field_405) {
                            return field_401;
                        }
                        var14[0] = var5.method_310(var15, var2);
                    }
                    if (var14[0] != null) {
                        class_43 var11;
                        for (int var16 = 1; (var11 = var15.method_137()) != null && var15 != var1 && (var2 || var15.method_140(var1) == null); var15 = var11) {
                            if (var4 != null) {
                                var4 = var4.method_583();
                                if (var4 != null && var4.field_405) {
                                    return field_401;
                                }
                                if (var4 != null && var4.field_404) {
                                    return field_402;
                                }
                            }
                            var13 = ((class_55)var15).method_310(var11, var2);
                            if (var13 == null) {
                                break;
                            }
                            if (var16 == var14.length) {
                                System.arraycopy(var14, 0, var14 = new Object[var16 + 1], 0, var16);
                            }
                            var14[var16++] = ((class_54)var13.field_314).method_298(var13, true);
                        }
                        if (var15 == var1 || !var2 && var15.method_140(var1) != null) {
                            return var14;
                        }
                    }
                    return null;
                }
            }
        } else {
            return var4.field_405 ? field_401 : (var4.field_404 ? field_402 : null);
        }
    }

    public int method_715() {
        int var1 = -1;
        if (this.field_396 != null) {
            int var2 = 0;
            for (int var3 = this.field_396.length; var2 < var3; ++var2) {
                int var4 = this.field_396[var2].field_395;
                if (var4 > var1) {
                    var1 = var4;
                }
            }
        }
        return var1;
    }

    public final boolean method_716(class_67 var1) {
        boolean var2 = var1.method_431();
        class_43 var3 = var1.field_314;
        for (class_87 var4 = this.method_635(); var4 != null; var4 = var4.method_583()) {
            if (var4.field_404 != var2) {
                return false;
            }
            if (!var4.method_727() && !((class_93)var4.field_403).method_797()) {
                return false;
            }
            if (var3 == var4.method_584()) {
                return true;
            }
        }
        return false;
    }

    public class_248 method_644() {
        return this.method_641().method_644();
    }

    public void method_717(class_43 var1, boolean var2) {
        class_66[] var3;
        if ((var3 = var1.method_243()) != null) {
            int var4 = 0;
            for (int var5 = var3.length; var4 < var5; ++var4) {
                class_66 var6 = var3[var4];
                if (!var2 || var6.field_301 != var1.method_137()) {
                    this.method_710(var6.field_312);
                }
            }
        }
    }

    public class_114 method_718() {
        return this.method_635().method_718();
    }

    int method_646() {
        return this.field_393;
    }

    public String toString() {
        return this.method_719(0);
    }

    public String method_719(int var1) {
        String var2 = this.method_707(var1);
        for (int var3 = 0; var3 < this.field_398; ++var3) {
            if (this.field_397[var3] instanceof class_86) {
                var2 = var2 + ((class_86)this.field_397[var3]).method_719(var1 + 1) + "\n";
            }
        }
        return var2;
    }

    static {
        field_400 = new class_64[0];
        field_401 = new class_64[0];
        field_402 = new class_64[0];
    }
}
