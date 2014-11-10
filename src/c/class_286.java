package c;

import a.class_31;
import a.class_341;
import a.class_342;
import b.class_234;
import b.class_235;
import batch.eclipse;
import c.class_282;
import c.class_283;
import c.class_284;
import c.class_285;
import c.class_289;
import c.class_6;
import c.class_7;
import c.class_8;
import c.class_9;
import f.class_329;
import h.class_90;
import h.class_91;
import j.class_278;
import java.io.PrintStream;
import k.class_19;
import k.class_21;
import k.class_22;
import k.class_28;
import k.class_345;
import m.class_38;
import m.class_43;
import m.class_80;
import n.class_236;
import n.class_241;
import n.class_242;
import n.class_248;

public class class_286 implements class_31 {

    public class_278 field_1697;

    public class_9 field_1698;

    public class_341 field_1699;

    public class_248 field_1700;

    protected PrintStream field_1701;

    public class_342 field_1702;

    public class_234 field_1703;

    public int field_1704;

    public class_90[] field_1705;

    public int field_1706;

    public class_80 field_1707;

    public static boolean field_1708;

    public int field_1709;

    public class_285 field_1710;

    public class_43[] field_1711;

    public boolean field_1712;

    public static class_6 field_1713;

    public class_286(class_28 var1, class_7 var2, class_341 var3, class_9 var4, class_8 var5, PrintStream var6, class_234 var7) {
        this.field_1704 = 1;
        this.field_1709 = -1;
        this.field_1712 = true;
        this.field_1699 = var3;
        this.field_1703 = var7;
        if (field_1713 == null) {
            this.field_1698 = var4;
        } else {
            class_289 var10001 = new class_289(this, var4);
            this.field_1698 = var10001;
        }
        try {
            this.field_1701 = System.out;
            class_342 var12 = new class_342();
            this.field_1702 = var12;
            class_248 var10 = new class_248(var2, this.field_1699, var5);
            this.field_1700 = var10;
            class_80 var11 = new class_80(this, this.field_1699, this.field_1700, var1);
            this.field_1707 = var11;
            this.method_2948();
        } catch (Throwable var9) {
            var9.printStackTrace();
        }
    }

    public void method_87(class_22 var1, class_38 var2, class_345 var3) {
        if (this.field_1699.field_1931) {
            this.field_1701.println(class_329.method_3251(class_329.field_1863, new String(var1.method_60())));
        }
        this.field_1707.method_494(var1, var2, var3);
    }

    public void method_88(class_19 var1, class_345 var2) {
        class_284 var10000 = new class_284(var1, this.field_1706, this.field_1706, this.field_1699.field_1935);
        class_284 var3 = var10000;
        var3.field_1694 = true;
        try {
            if (this.field_1699.field_1931) {
                String var4 = String.valueOf(this.field_1706 + 1);
                this.field_1701.println(class_329.method_3253(class_329.field_1862, new String[] {var4, var4, new String(var1.method_50())}));
            }
            class_90 var6;
            if (this.field_1706 < this.field_1709) {
                var6 = this.field_1697.method_2856(var1, var3);
            } else {
                var6 = this.field_1697.method_2827(var1, var3);
            }
            var6.field_446 |= 1;
            this.field_1707.method_483(var6, var2);
            this.method_2940(var1, var6);
            this.field_1707.method_485(var6);
        } catch (class_242 var5) {
            if (var3.field_1677 != var1) {
                throw var5;
            }
            this.field_1698.method_26(var3.method_2932());
        }
    }

    public void method_89(class_21[] var1, class_38 var2, class_345 var3) {
        this.field_1700.method_1459(class_329.method_3253(class_329.field_1880, new String[] {String.valueOf(var1[0].method_51()), String.valueOf(var1[0].method_50())}));
    }

    protected synchronized void method_2940(class_19 var1, class_90 var2) {
        int var3 = this.field_1705.length;
        if (this.field_1706 == var3) {
            System.arraycopy(this.field_1705, 0, this.field_1705 = new class_90[var3 * 2], 0, this.field_1706);
        }
        this.field_1705[this.field_1706++] = var2;
    }

    protected void method_2941(class_19[] var1) {
        int var2 = var1.length;
        this.field_1706 = 0;
        this.field_1705 = new class_90[var2];
        this.method_2949(var1, var2);
    }

    protected void method_2942(String var1) {
        if (this.field_1703 != null) {
            if (this.field_1703.method_1394()) {
                class_241 var10000 = new class_241(true, (RuntimeException)null);
                throw var10000;
            }
            this.field_1703.method_1395(var1);
        }
    }

    protected void method_2943(int var1, int var2) {
        if (this.field_1703 != null) {
            if (this.field_1703.method_1394()) {
                class_241 var10000 = new class_241(true, (RuntimeException)null);
                throw var10000;
            }
            this.field_1703.method_1396(var1, this.field_1706 * this.field_1704 - var2 - 1);
        }
    }

    public void method_2944(class_19[] var1) {
        this.field_1702.field_1967 = System.currentTimeMillis();
        class_90 var2 = null;
        class_282 var3 = null;
        try {
            this.method_2942(class_329.field_1870);
            this.method_2941(var1);
            if (this.field_1710 != null) {
                this.method_2951();
                if (!this.field_1699.field_1964) {
                    return;
                }
            }
            int var4;
            if (this.field_1712) {
                for (var4 = 0; var4 < this.field_1706; ++var4) {
                    var2 = this.field_1705[var4];
                    this.method_2942(class_329.method_3251(class_329.field_1871, new String(var2.method_771())));
                    try {
                        if (this.field_1699.field_1931) {
                            this.field_1701.println(class_329.method_3253(class_329.field_1864, new String[] {String.valueOf(var4 + 1), String.valueOf(this.field_1706), new String(this.field_1705[var4].method_771())}));
                        }
                        this.method_2950(var2, var4);
                    } finally {
                        var2.method_766();
                    }
                    this.field_1705[var4] = null;
                    this.method_2943(1, var4);
                    this.field_1702.field_1969 += (long)var2.field_455.field_1684.length;
                    long var5 = System.currentTimeMillis();
                    this.field_1698.method_26(var2.field_455.method_2932());
                    this.field_1702.field_1973 += System.currentTimeMillis() - var5;
                    if (this.field_1699.field_1931) {
                        this.field_1701.println(class_329.method_3253(class_329.field_1866, new String[] {String.valueOf(var4 + 1), String.valueOf(this.field_1706), new String(var2.method_771())}));
                    }
                }
            } else {
                class_282 var10000 = new class_282(this);
                var3 = var10000;
                var4 = 0;
                while (true) {
                    try {
                        var2 = var3.method_2906();
                    } catch (Error var22) {
                        var2 = var3.field_1652;
                        throw var22;
                    } catch (RuntimeException var23) {
                        var2 = var3.field_1652;
                        throw var23;
                    }
                    if (var2 == null) {
                        break;
                    }
                    this.method_2943(1, var4++);
                    this.field_1702.field_1969 += (long)var2.field_455.field_1684.length;
                    this.field_1698.method_26(var2.field_455.method_2932());
                    if (this.field_1699.field_1931) {
                        this.field_1701.println(class_329.method_3253(class_329.field_1866, new String[] {String.valueOf(var4), String.valueOf(this.field_1706), new String(var2.method_771())}));
                    }
                }
            }
        } catch (class_241 var25) {
            this.method_2947(var25, var2);
        } catch (Error var26) {
            this.method_2946(var26, var2, (class_284)null);
            throw var26;
        } catch (RuntimeException var27) {
            this.method_2946(var27, var2, (class_284)null);
            throw var27;
        } finally {
            if (var3 != null) {
                var3.method_2907();
                var3 = null;
            }
            this.method_2952();
            this.field_1702.field_1968 = System.currentTimeMillis();
        }
        if (this.field_1699.field_1931) {
            if (this.field_1706 > 1) {
                this.field_1701.println(class_329.method_3251(class_329.field_1867, String.valueOf(this.field_1706)));
            } else {
                this.field_1701.println(class_329.method_3251(class_329.field_1868, String.valueOf(this.field_1706)));
            }
        }
    }

    public synchronized class_90 method_2945(int var1) {
        if (var1 < this.field_1706) {
            class_90 var2 = this.field_1705[var1];
            this.field_1705[var1] = null;
            return var2;
        } else {
            return null;
        }
    }

    protected void method_2946(Throwable var1, class_90 var2, class_284 var3) {
        if (var3 == null && var2 != null) {
            var3 = var2.field_455;
        }
        if (var3 == null && this.field_1707.field_362 != null) {
            var3 = this.field_1707.field_362.field_455;
        }
        if (var3 == null) {
            synchronized (this) {
                if (this.field_1705 != null && this.field_1706 > 0) {
                    var3 = this.field_1705[this.field_1706 - 1].field_455;
                }
            }
        }
        boolean var4 = true;
        if (var3 != null) {
            var1.printStackTrace();
            String[] var5 = new String[] {class_329.field_1869 + "\n" + var1.toString()};
            var3.method_2929(this.field_1700.method_1450(var3.method_2920(), 0, var5, var5, 1, 0, 0, 0, 0), var2);
            if (!var3.field_1689) {
                this.field_1698.method_26(var3.method_2932());
                var4 = false;
            }
        }
        if (var4) {
            var1.printStackTrace();
        }
    }

    protected void method_2947(class_241 var1, class_90 var2) {
        if (var1.field_1052) {
            if (var1.field_1053 != null) {
                throw var1.field_1053;
            }
        } else {
            class_284 var3 = var1.field_1049;
            if (var3 == null && var2 != null) {
                var3 = var2.field_455;
            }
            if (var3 == null && this.field_1707.field_362 != null) {
                var3 = this.field_1707.field_362.field_455;
            }
            if (var3 == null) {
                synchronized (this) {
                    if (this.field_1705 != null && this.field_1706 > 0) {
                        var3 = this.field_1705[this.field_1706 - 1].field_455;
                    }
                }
            }
            if (var3 != null && !var3.field_1689) {
                if (var1.field_1051 != null) {
                    class_235 var4 = var1.field_1051;
                    class_235[] var5 = var3.field_1673;
                    int var6 = 0;
                    while (true) {
                        if (var6 >= var3.field_1675) {
                            if (var4 instanceof class_236) {
                                ((class_236)var4).method_1406(var3.method_2920());
                            }
                            var3.method_2929(var4, var2);
                            break;
                        }
                        if (var5[var6] == var4) {
                            break;
                        }
                        ++var6;
                    }
                } else if (var1.field_1050 != null) {
                    this.method_2946(var1.field_1050, (class_90)null, var3);
                    return;
                }
                if (!var3.field_1689) {
                    this.field_1698.method_26(var3.method_2932());
                }
            } else {
                var1.printStackTrace();
            }
        }
    }

    public void method_2948() {
        class_278 var10001 = new class_278(this.field_1700, this.field_1699.field_1934);
        this.field_1697 = var10001;
    }

    protected void method_2949(class_19[] var1, int var2) {
        if (!this.field_1712 && var2 >= class_283.field_1671) {
            class_278 var10000 = this.field_1697;
            class_283 var10001 = new class_283(var1, var2);
            var10000.field_1636 = var10001;
        }
        for (int var3 = 0; var3 < var2; ++var3) {
            try {
                eclipse.field_427.method_733(class_329.method_3253(class_329.field_1862, new String[] {String.valueOf(var3 + 1), String.valueOf(var2), new String(var1[var3].method_50())}));
                class_284 var14 = new class_284(var1[var3], var3, var2, this.field_1699.field_1935);
                class_284 var5 = var14;
                long var6 = System.currentTimeMillis();
                class_90 var4;
                if (this.field_1706 < this.field_1709) {
                    var4 = this.field_1697.method_2856(var1[var3], var5);
                } else {
                    var4 = this.field_1697.method_2827(var1[var3], var5);
                }
                long var8 = System.currentTimeMillis();
                this.field_1702.field_1970 += var8 - var6;
                this.field_1707.method_483(var4, (class_345)null);
                this.field_1702.field_1971 += System.currentTimeMillis() - var8;
                this.method_2940(var1[var3], var4);
                class_91 var10 = var4.field_448;
                if (var10 != null) {
                    var5.method_2928(var10.field_467);
                }
            } finally {
                var1[var3] = null;
            }
        }
        if (this.field_1697.field_1636 != null) {
            this.field_1697.field_1636.method_2911();
            this.field_1697.field_1636 = null;
        }
        this.field_1707.method_484();
    }

    public void method_2950(class_90 var1, int var2) {
        this.field_1707.field_362 = var1;
        long var3 = System.currentTimeMillis();
        this.field_1697.method_2834(var1);
        long var5 = System.currentTimeMillis();
        this.field_1702.field_1970 += var5 - var3;
        if (var1.field_453 != null) {
            var1.field_453.method_680();
        }
        if (var1.field_453 != null) {
            var1.field_453.method_698(this.field_1707.method_516());
        }
        var1.method_778();
        long var7 = System.currentTimeMillis();
        this.field_1702.field_1971 += var7 - var5;
        var1.method_765();
        long var9 = System.currentTimeMillis();
        this.field_1702.field_1972 += var9 - var7;
        var1.method_770();
        if (this.field_1699.field_1932 && var1.field_453 != null) {
            var1.field_453.method_696();
        }
        var1.method_769();
        this.field_1702.field_1973 += System.currentTimeMillis() - var9;
        var1.field_455.field_1688 = this.field_1706;
        this.field_1707.field_362 = null;
    }

    protected void method_2951() {
        boolean var1 = false;
        boolean var2 = false;
        int var3 = 0;
        int var4 = this.field_1706;
        class_43[] var5 = this.field_1711;
        if (var4 != 0 || var5 != null) {
            this.field_1711 = null;
            int var11;
            int var12;
            do {
                int var6 = var4 - var3;
                class_90[] var7 = new class_90[var6];
                int var8 = 0;
                for (int var9 = var3; var9 < var4; ++var9) {
                    class_90 var10 = this.field_1705[var9];
                    if ((var10.field_446 & 1) == 0) {
                        var7[var8++] = var10;
                    }
                }
                if (var8 != var6) {
                    System.arraycopy(var7, 0, var7 = new class_90[var8], 0, var8);
                }
                this.field_1710.method_2938(var7, var5, false);
                class_19[] var13 = this.field_1710.method_2935();
                var11 = var13.length;
                class_43[] var14 = this.field_1710.method_2936();
                var5 = var14;
                var12 = var14.length;
                if (var11 != 0) {
                    this.method_2949(var13, var11);
                    var3 = var4;
                    var4 = this.field_1706;
                } else {
                    var3 = var4;
                }
                this.field_1710.method_2937();
            } while (var11 != 0 || var12 != 0);
            this.field_1710.method_2938((class_90[])null, (class_43[])null, true);
        }
    }

    public void method_2952() {
        this.field_1707.method_518();
        this.field_1697.field_1628.field_1237 = null;
        this.field_1705 = null;
        if (field_1713 != null) {
            field_1713.method_22();
        }
        this.field_1700.method_1748();
    }

    static {
        field_1708 = false;
        field_1713 = null;
    }
}
