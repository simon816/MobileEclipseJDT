package h;

import a.class_33;
import a.class_331;
import a.class_341;
import b.class_233;
import b.class_235;
import c.class_284;
import c.class_288;
import f.class_322;
import g.class_10;
import g.class_316;
import h.class_114;
import h.class_126;
import h.class_128;
import h.class_164;
import h.class_170;
import h.class_330;
import h.class_89;
import h.class_91;
import h.class_92;
import j.class_279;
import m.class_17;
import m.class_35;
import m.class_57;
import m.class_85;
import n.class_242;
import n.class_243;
import n.class_244;
import n.class_248;

public class class_90 extends class_89 implements class_33 {

    private static final class_10 field_447;

    public class_91 field_448;

    public class_91[] field_449;

    public class_114[] field_450;

    public boolean field_451;

    public boolean field_452;

    public class_85 field_453;

    public class_248 field_454;

    public class_284 field_455;

    public class_57[] field_456;

    public int field_457;

    public boolean field_458;

    public class_279[] field_459;

    private class_170[] field_460;

    private int field_461;

    private class_322 field_462;

    long[] field_463;

    class_164[] field_464;

    long[] field_465;

    int field_466;

    public class_90(class_248 var1, class_284 var2, int var3) {
        this.field_451 = false;
        this.field_452 = false;
        this.field_457 = 0;
        this.field_454 = var1;
        this.field_455 = var2;
        this.field_444 = 0;
        this.field_445 = var3 - 1;
    }

    public void method_93(int var1, class_235 var2) {
        switch (var1) {
            case 8:
                class_243 var3 = new class_243(this.field_455, var2);
                throw var3;
            case 16:
                class_244 var10000 = new class_244(this.field_455, var2);
                throw var10000;
            default:
                class_242 var4 = new class_242(this.field_455, var2);
                throw var4;
        }
    }

    public void method_765() {
        if (!this.field_451) {
            try {
                if (this.field_450 != null) {
                    int var1 = 0;
                    for (int var2 = this.field_450.length; var1 < var2; ++var1) {
                        this.field_450[var1].method_849(this.field_453);
                    }
                }
                this.method_774();
            } catch (class_242 var3) {
                this.field_451 = true;
            }
        }
    }

    public void method_766() {
        int var2;
        if (this.field_450 != null) {
            int var1 = 0;
            for (var2 = this.field_450.length; var1 < var2; ++var1) {
                this.method_767(this.field_450[var1]);
            }
            var1 = 0;
            for (var2 = this.field_457; var1 < var2; ++var1) {
                class_57 var3 = this.field_456[var1];
                var3.field_258 = null;
                var3.field_270 = null;
            }
        }
        this.field_455.field_1685 = null;
        class_288[] var5 = this.field_455.method_2917();
        var2 = 0;
        for (int var6 = var5.length; var2 < var6; ++var2) {
            class_288 var4 = var5[var2];
            var4.field_1729 = null;
            var4.field_1724 = null;
            var4.field_1732 = null;
        }
        this.field_464 = null;
    }

    private void method_767(class_114 var1) {
        if (var1.field_585 != null) {
            int var2 = 0;
            for (int var3 = var1.field_585.length; var2 < var3; ++var2) {
                this.method_767(var1.field_585[var2]);
            }
        }
        if (var1.field_586 != null && var1.field_586.method_145()) {
            this.field_455.field_1683 = true;
        }
        if (var1.field_586 != null) {
            var1.field_586.field_258 = null;
        }
    }

    public void method_768() {
        if (this.field_453.field_382 != null) {
            int var1 = 0;
            for (int var2 = this.field_453.field_382.length; var1 < var2; ++var1) {
                class_35 var3 = this.field_453.field_382[var1];
                class_91 var4 = var3.field_164;
                if (var4 != null && (var4.field_446 & 2) == 0) {
                    this.field_453.method_644().method_1809(var4);
                }
            }
        }
    }

    public class_284 method_94() {
        return this.field_455;
    }

    public void method_769() {
        if (this.field_466 != 0) {
            int var1 = 0;
            class_235[] var2 = this.field_455.field_1673;
            int var3 = this.field_455.field_1675;
            long[] var4 = new long[this.field_466];
            class_341 var5 = this.field_453.method_577();
            boolean var6 = false;
            int var7 = 0;
            int var8;
            class_235 var9;
            int var10;
            int var15;
            int var16;
            for (var8 = var3; var7 < var8; ++var7) {
                var9 = var2[var7];
                var10 = var9.method_1398();
                if (var9.method_1399()) {
                    if (var10 != 536871547) {
                        var6 = true;
                    }
                } else {
                    int var11 = var9.method_1401();
                    int var12 = var9.method_1402();
                    long var13 = class_248.method_1457(var10);
                    var15 = 0;
                    for (var16 = this.field_466; var15 < var16; ++var15) {
                        long var17 = this.field_465[var15];
                        int var19 = (int)(var17 >>> 32);
                        int var20 = (int)var17;
                        if (var11 >= var19 && var12 <= var20 && (var13 & this.field_463[var15]) != 0L) {
                            ++var1;
                            var2[var7] = null;
                            if (this.field_455.field_1678 != null) {
                                this.field_455.field_1678.method_40(var9);
                            }
                            if (this.field_455.field_1679 != null) {
                                this.field_455.field_1679.removeElement(var9);
                            }
                            var4[var15] |= var13;
                            break;
                        }
                    }
                }
            }
            if (var1 > 0) {
                var7 = 0;
                for (var8 = 0; var7 < var3; ++var7) {
                    if ((var9 = var2[var7]) != null) {
                        if (var7 > var8) {
                            var2[var8++] = var9;
                        } else {
                            ++var8;
                        }
                    }
                }
                this.field_455.field_1675 -= var1;
            }
            if (!var6) {
                var7 = var5.method_3313(18014398509481984L);
                if (var7 != -1) {
                    boolean var33 = (var7 & 1) == 0;
                    int var34 = 0;
                    label167:
                    for (var10 = this.field_466; var34 < var10; ++var34) {
                        class_164 var35 = this.field_464[var34];
                        if (var35 != null) {
                            long var36 = this.field_463[var34];
                            if ((!var33 || ~var36 != 0L) && var36 != var4[var34]) {
                                class_92[] var14 = var35.method_1074();
                                var15 = 0;
                                for (var16 = var14.length; var15 < var16; ++var15) {
                                    class_92 var37 = var14[var15];
                                    if (class_233.method_1364(var37.field_474, class_17.field_70)) {
                                        class_126 var18 = var37.field_475;
                                        int var22;
                                        int var27;
                                        int var28;
                                        if (var18 instanceof class_128) {
                                            class_128 var38 = (class_128)var18;
                                            class_126[] var40 = var38.field_679;
                                            if (var40 != null) {
                                                int var21 = 0;
                                                for (var22 = var40.length; var21 < var22; ++var21) {
                                                    class_331 var23 = var40[var21].field_672;
                                                    if (var23 != class_331.field_1896 && var23.method_3288() == 11) {
                                                        long var24 = class_341.method_3320(var23.method_3287());
                                                        if (var24 != 0L && ~var24 != 0L && var5.method_3313(var24) != -1 && (var4[var34] & var24) == 0L) {
                                                            if (var33) {
                                                                int var26 = var18.field_444;
                                                                var27 = var18.field_445;
                                                                for (var28 = var34 - 1; var28 >= 0; --var28) {
                                                                    long var29 = this.field_465[var28];
                                                                    int var31 = (int)(var29 >>> 32);
                                                                    int var32 = (int)var29;
                                                                    if (var26 >= var31 && var27 <= var32 && ~this.field_463[var28] == 0L) {
                                                                        continue label167;
                                                                    }
                                                                }
                                                            }
                                                            this.field_453.method_644().method_1816(var40[var21]);
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            class_331 var41 = var18.field_672;
                                            if (var41 != class_331.field_1896 && var41.method_3288() == 11) {
                                                long var39 = class_341.method_3320(var41.method_3287());
                                                if (var39 != 0L && ~var39 != 0L && var5.method_3313(var39) != -1 && (var4[var34] & var39) == 0L) {
                                                    if (var33) {
                                                        var22 = var18.field_444;
                                                        int var42 = var18.field_445;
                                                        for (int var43 = var34 - 1; var43 >= 0; --var43) {
                                                            long var25 = this.field_465[var43];
                                                            var27 = (int)(var25 >>> 32);
                                                            var28 = (int)var25;
                                                            if (var22 >= var27 && var42 <= var28 && ~this.field_463[var43] == 0L) {
                                                                continue label167;
                                                            }
                                                        }
                                                    }
                                                    this.field_453.method_644().method_1816(var18);
                                                }
                                            }
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void method_770() {
        int var1;
        int var2;
        if (this.field_451) {
            if (this.field_450 != null) {
                var1 = 0;
                for (var2 = this.field_450.length; var1 < var2; ++var1) {
                    this.field_450[var1].field_590 = true;
                    this.field_450[var1].method_857(this.field_453);
                }
            }
        } else {
            if (this.method_773() && this.field_450 != null && this.field_448 != null && this.field_448.field_473 != null) {
                this.field_450[0].field_579 = this.field_448.field_473;
            }
            try {
                if (this.field_450 != null) {
                    var1 = 0;
                    for (var2 = this.field_450.length; var1 < var2; ++var1) {
                        this.field_450[var1].method_857(this.field_453);
                    }
                }
            } catch (class_242 var3) {
                ;
            }
        }
    }

    public String method_771() {
        return this.field_455.method_2920();
    }

    public char[] method_772() {
        if (this.field_455.field_1677 != null) {
            return this.field_455.field_1677.method_52();
        } else {
            char[] var1 = this.field_455.method_2920().toCharArray();
            int var2 = class_233.method_1376('/', var1) + 1;
            if (var2 == 0 || var2 < class_233.method_1376('\\', var1)) {
                var2 = class_233.method_1376('\\', var1) + 1;
            }
            int var3 = class_233.method_1376('.', var1);
            if (var3 == -1) {
                var3 = var1.length;
            }
            return class_233.method_1388(var1, var2, var3);
        }
    }

    public boolean method_773() {
        return class_233.method_1364(this.method_772(), class_17.field_144);
    }

    public boolean method_95() {
        return this.field_451;
    }

    public StringBuffer method_757(int var1, StringBuffer var2) {
        if (this.field_448 != null) {
            method_759(var1, var2).append("package ");
            this.field_448.method_782(0, var2, false).append(";\n");
        }
        int var3;
        if (this.field_449 != null) {
            for (var3 = 0; var3 < this.field_449.length; ++var3) {
                method_759(var1, var2).append("import ");
                class_91 var4 = this.field_449[var3];
                if (var4.method_781()) {
                    var2.append("static ");
                }
                var4.method_757(0, var2).append(";\n");
            }
        }
        if (this.field_450 != null) {
            for (var3 = 0; var3 < this.field_450.length; ++var3) {
                this.field_450[var3].method_757(var1, var2).append("\n");
            }
        }
        return var2;
    }

    public void method_774() {
        this.field_458 = true;
        int var1 = 0;
        for (int var2 = this.field_457; var1 < var2; ++var1) {
            class_57 var3 = this.field_456[var1];
            if ((var3.field_258.method_671().field_446 & Integer.MIN_VALUE) != 0) {
                var3.method_330();
            }
        }
    }

    public void method_775(class_170 var1, boolean var2) {
        int var3;
        if (this.field_462 != null) {
            if (this.field_462.method_3209(var1.field_444)) {
                return;
            }
            this.field_462.method_3210(var1.field_444);
        } else if (var2) {
            class_322 var10001 = new class_322(this.field_461 + 10);
            this.field_462 = var10001;
            for (var3 = 0; var3 < this.field_461; ++var3) {
                this.field_462.method_3210(this.field_460[var3].field_444);
            }
            if (this.field_462.method_3209(var1.field_444)) {
                return;
            }
            this.field_462.method_3210(var1.field_444);
        }
        if (this.field_460 == null) {
            this.field_460 = new class_170[10];
            this.field_461 = 0;
        } else {
            var3 = this.field_460.length;
            if (this.field_461 == var3) {
                System.arraycopy(this.field_460, 0, this.field_460 = new class_170[var3 + 10], 0, var3);
            }
        }
        this.field_460[this.field_461++] = var1;
    }

    public void method_776(long var1, class_164 var3, int var4, int var5) {
        if (this.field_463 == null) {
            this.field_463 = new long[3];
            this.field_464 = new class_164[3];
            this.field_465 = new long[3];
        } else if (this.field_463.length == this.field_466) {
            System.arraycopy(this.field_463, 0, this.field_463 = new long[2 * this.field_466], 0, this.field_466);
            System.arraycopy(this.field_464, 0, this.field_464 = new class_164[2 * this.field_466], 0, this.field_466);
            System.arraycopy(this.field_465, 0, this.field_465 = new long[2 * this.field_466], 0, this.field_466);
        }
        this.field_463[this.field_466] = var1;
        this.field_464[this.field_466] = var3;
        this.field_465[this.field_466++] = ((long)var4 << 32) + (long)var5;
    }

    public void method_777(class_57 var1) {
        if (this.field_457 == 0) {
            this.field_456 = new class_57[5];
        } else if (this.field_457 == this.field_456.length) {
            System.arraycopy(this.field_456, 0, this.field_456 = new class_57[this.field_457 * 2], 0, this.field_457);
        }
        this.field_456[this.field_457++] = var1;
    }

    public void method_778() {
        byte var1 = 0;
        boolean var2 = this.method_773();
        if (this.field_450 != null && var2) {
            class_114 var3 = this.field_450[0];
            var3.method_868(this.field_453);
            if (this.field_448 != null && this.field_448.field_473 != null) {
                method_761(var3.field_589, this.field_448.field_473, this.field_453.field_381);
            }
            var1 = 1;
        }
        if (this.field_448 != null && this.field_448.field_473 != null && !var2) {
            this.field_453.method_644().method_1631(this.field_448.field_473[0]);
        }
        try {
            if (this.field_450 != null) {
                int var6 = var1;
                for (int var4 = this.field_450.length; var6 < var4; ++var6) {
                    this.field_450[var6].method_868(this.field_453);
                }
            }
            if (!this.field_455.method_2924()) {
                this.method_768();
            }
            this.method_779();
        } catch (class_242 var5) {
            this.field_451 = true;
        }
    }

    private void method_779() {
        if (this.field_459 != null || this.field_460 != null) {
            int var1 = this.field_461;
            int var2 = this.field_459 == null ? 0 : this.field_459.length;
            int var3;
            if (var1 == 0) {
                if (var2 != 0) {
                    for (var3 = 0; var3 < var2; ++var3) {
                        class_279 var4 = this.field_459[var3];
                        if (var4 != null) {
                            this.field_453.method_644().method_1794(var4.field_1638, var4.field_1639);
                        }
                    }
                }
            } else if (var2 == 0) {
                if (this.field_460.length != var1) {
                    System.arraycopy(this.field_460, 0, this.field_460 = new class_170[var1], 0, var1);
                }
                class_316.method_3170(this.field_460, field_447);
                for (var3 = 0; var3 < var1; ++var3) {
                    this.field_453.method_644().method_1701(this.field_460[var3]);
                }
            } else {
                if (this.field_460.length != var1) {
                    System.arraycopy(this.field_460, 0, this.field_460 = new class_170[var1], 0, var1);
                }
                class_316.method_3170(this.field_460, field_447);
                var3 = 1;
                int var14 = -1;
                class_170 var5 = null;
                int var6 = 0;
                int var7;
                label109:
                for (var7 = 0; var7 < var1; ++var7) {
                    var5 = this.field_460[var7];
                    int var8 = var5.field_786;
                    if (var14 != var8) {
                        var3 = 1;
                        var14 = var8;
                    } else {
                        ++var3;
                    }
                    if (var6 >= var2) {
                        break;
                    }
                    while (true) {
                        if (var6 >= var2) {
                            break label109;
                        }
                        class_279 var9 = this.field_459[var6];
                        if (var9 != null) {
                            int var10 = var9.field_1640;
                            if (var8 < var10) {
                                this.field_453.method_644().method_1701(var5);
                                break;
                            }
                            if (var8 == var10) {
                                if (var9.field_1641 == var3) {
                                    this.field_459[var6] = null;
                                    ++var6;
                                } else {
                                    for (int var11 = var6 + 1; var11 < var2; ++var11) {
                                        class_279 var12 = this.field_459[var11];
                                        if (var12 != null) {
                                            int var13 = var12.field_1640;
                                            if (var8 != var13) {
                                                this.field_453.method_644().method_1701(var5);
                                                continue label109;
                                            }
                                            if (var12.field_1641 == var3) {
                                                this.field_459[var11] = null;
                                                continue label109;
                                            }
                                        }
                                    }
                                    this.field_453.method_644().method_1701(var5);
                                }
                                break;
                            }
                            this.field_453.method_644().method_1794(var9.field_1638, var9.field_1639);
                        }
                        ++var6;
                    }
                }
                while (var7 < var1) {
                    this.field_453.method_644().method_1701(this.field_460[var7]);
                    ++var7;
                }
                if (var6 < var2) {
                    for (; var6 < var2; ++var6) {
                        class_279 var15 = this.field_459[var6];
                        if (var15 != null) {
                            this.field_453.method_644().method_1794(var15.field_1638, var15.field_1639);
                        }
                    }
                }
            }
        }
    }

    public void method_96() {
        this.field_451 = true;
    }

    static {
        class_330 var10000 = new class_330();
        field_447 = var10000;
    }
}
