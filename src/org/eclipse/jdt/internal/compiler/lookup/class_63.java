package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.ast.class_168;
import org.eclipse.jdt.internal.compiler.lookup.InvocationSite;
import org.eclipse.jdt.internal.compiler.lookup.class_32;
import org.eclipse.jdt.internal.compiler.lookup.class_321;
import org.eclipse.jdt.internal.compiler.lookup.class_34;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.class_42;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.class_46;
import org.eclipse.jdt.internal.compiler.lookup.class_53;
import org.eclipse.jdt.internal.compiler.lookup.class_58;
import org.eclipse.jdt.internal.compiler.lookup.class_61;
import org.eclipse.jdt.internal.compiler.lookup.class_62;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;
import org.eclipse.jdt.internal.compiler.lookup.class_83;

public class class_63 extends class_62 implements class_32 {

    public class_40[] field_293;

    private LookupEnvironment field_294;

    public boolean field_295;

    public boolean field_296;

    public boolean field_297;

    private class_58 field_298;

    public boolean field_299;

    public static class_58 method_400(class_58 var0, class_40[] var1, class_83 var2, InvocationSite var3) {
        class_46[] var5 = var0.field_279;
        class_40[] var6 = var3.method_0();
        class_63 var4;
        class_61 var10000;
        if (var6 != null) {
            if (var6.length != var5.length) {
                var10000 = new class_61(var0, var0.field_274, var6, 11);
                return var10000;
            }
            var4 = var2.method_586().method_499(var0, var6);
        } else {
            class_40[] var7 = var0.field_276;
            class_321 var13 = new class_321(var0);
            class_321 var8 = var13;
            var4 = method_401(var2, var0, var1, var7, var8);
            if (var4 == null) {
                return null;
            }
            if (var8.method_3205()) {
                if (var4.field_275 != class_40.field_188) {
                    Object var9 = null;
                    if (var3 instanceof class_168) {
                        class_168 var10 = (class_168)var3;
                        var9 = var10.field_778;
                    }
                    if (var9 != null) {
                        var8.field_1831 = true;
                    } else {
                        var9 = var2.method_609();
                    }
                    var8.field_1830 = (class_40)var9;
                }
                var4 = var4.method_405(var2, var8);
                if (var4 == null) {
                    return null;
                }
            }
        }
        if (!var4.field_297) {
            int var14 = 0;
            int var15 = var5.length;
            while (var14 < var15) {
                class_46 var17 = var5[var14];
                class_40 var16 = var4.field_293[var14];
                switch (var17.method_255(var4, var16)) {
                    case 1:
                        var4.field_299 = true;
                    case 2:
                        int var11 = var1.length;
                        class_40[] var12 = new class_40[var11 + 2];
                        System.arraycopy(var1, 0, var12, 0, var11);
                        var12[var11] = var16;
                        var12[var11 + 1] = var17;
                        var10000 = new class_61(var4, var0.field_274, var12, 10);
                        return var10000;
                    default:
                        ++var14;
                }
            }
        }
        return var4;
    }

    private static class_63 method_401(class_83 var0, class_58 var1, class_40[] var2, class_40[] var3, class_321 var4) {
        int var5;
        int var6;
        int var8;
        if (var1.method_374()) {
            var5 = var3.length;
            var6 = var5 - 1;
            int var7 = var2.length;
            for (var8 = 0; var8 < var6; ++var8) {
                var3[var8].method_133(var0, var2[var8], var4, 1);
                if (var4.field_1829 == 1) {
                    return null;
                }
            }
            if (var6 < var7) {
                class_40 var14;
                label84: {
                    var14 = var3[var6];
                    class_40 var9 = var2[var6];
                    if (var5 == var7) {
                        if (var9 == class_40.field_187) {
                            break label84;
                        }
                        switch (var9.method_136()) {
                            case 0:
                                break;
                            case 1:
                                if (!var9.method_173().method_148()) {
                                    break label84;
                                }
                                break;
                            default:
                                break label84;
                        }
                    }
                    var14 = ((class_42)var14).method_187();
                }
                for (int var10 = var6; var10 < var7; ++var10) {
                    var14.method_133(var0, var2[var10], var4, 1);
                    if (var4.field_1829 == 1) {
                        return null;
                    }
                }
            }
        } else {
            var5 = var3.length;
            for (var6 = 0; var6 < var5; ++var6) {
                var3[var6].method_133(var0, var2[var6], var4, 1);
                if (var4.field_1829 == 1) {
                    return null;
                }
            }
        }
        if (var4.field_1829 == 2) {
            return var0.method_586().method_498(var1, (class_53)null);
        } else {
            class_46[] var11 = var1.field_279;
            if (!method_402(var0, var11, var4, false)) {
                return null;
            } else {
                class_40[] var13 = var4.field_1832;
                class_40[] var12 = var13;
                var8 = 0;
                for (int var15 = var11.length; var8 < var15; ++var8) {
                    if (var13[var8] == null) {
                        if (var12 == var13) {
                            System.arraycopy(var13, 0, var12 = new class_40[var15], 0, var8);
                        }
                        var12[var8] = var11[var8];
                    } else if (var12 != var13) {
                        var12[var8] = var13[var8];
                    }
                }
                class_63 var16 = var0.method_586().method_499(var1, var12);
                return var16;
            }
        }
    }

    private static boolean method_402(class_83 var0, class_46[] var1, class_321 var2, boolean var3) {
        class_40[] var4 = var2.field_1832;
        int var5 = var1.length;
        int var6;
        class_46 var7;
        class_40 var8;
        class_40[] var9;
        label98:
        for (var6 = 0; var6 < var5; ++var6) {
            var7 = var1[var6];
            var8 = var4[var6];
            if (var8 == null) {
                var9 = var2.method_3204(var7, 0);
                if (var9 != null) {
                    int var10 = 0;
                    for (int var11 = var9.length; var10 < var11; ++var10) {
                        class_40 var12 = var9[var10];
                        if (var12 != null) {
                            if (var12 == var7) {
                                for (int var13 = var10 + 1; var13 < var11; ++var13) {
                                    var12 = var9[var13];
                                    if (var12 != var7 && var12 != null) {
                                        var4[var6] = var12;
                                        continue label98;
                                    }
                                }
                                var4[var6] = var7;
                                break;
                            }
                            var4[var6] = var12;
                            break;
                        }
                    }
                }
            }
        }
        if (var2.method_3205()) {
            for (var6 = 0; var6 < var5; ++var6) {
                var7 = var1[var6];
                var8 = var4[var6];
                if (var8 == null) {
                    var9 = var2.method_3204(var7, 2);
                    if (var9 != null) {
                        class_40 var16 = var0.method_633(var9);
                        if (var16 == null) {
                            return false;
                        }
                        if (var16 != class_40.field_188) {
                            var4[var6] = var16;
                        }
                    }
                }
            }
        }
        if (var3 && var2.method_3205()) {
            for (var6 = 0; var6 < var5; ++var6) {
                var7 = var1[var6];
                var8 = var4[var6];
                if (var8 == null) {
                    var9 = var2.method_3204(var7, 1);
                    if (var9 != null) {
                        class_40[] var14 = class_83.method_569(var9);
                        class_40 var15 = null;
                        if (var14 != null) {
                            var15 = var14[0];
                        }
                        if (var15 != null) {
                            var4[var6] = var15;
                        }
                    }
                }
            }
        }
        return true;
    }

    public class_63(class_58 var1, class_53 var2, LookupEnvironment var3) {
        class_46[] var4 = var1.field_279;
        int var5 = var4.length;
        class_40[] var6 = new class_40[var5];
        for (int var7 = 0; var7 < var5; ++var7) {
            var6[var7] = var3.method_490(var4[var7].method_138(), false);
        }
        this.field_297 = true;
        this.field_281 = var1.field_281;
        this.field_294 = var3;
        this.field_273 = var1.field_273;
        this.field_274 = var1.field_274;
        this.field_278 = (ReferenceBinding)(var2 == null ? var1.field_278 : var2);
        this.field_279 = class_34.field_157;
        this.field_293 = var6;
        this.field_292 = var1;
        boolean var8 = var2 == null || var1.method_370();
        this.field_276 = class_83.method_572(this, var8 ? var1.field_276 : class_83.method_572(var2, var1.field_276));
        this.field_277 = class_83.method_570(this, var8 ? var1.field_277 : class_83.method_570(var2, var1.field_277));
        if (this.field_277 == null) {
            this.field_277 = class_34.field_151;
        }
        this.field_275 = class_83.method_571(this, var8 ? var1.field_275 : class_83.method_571(var2, var1.field_275));
        this.field_296 = false;
    }

    public class_63(class_58 var1, class_40[] var2, LookupEnvironment var3) {
        this.field_294 = var3;
        this.field_273 = var1.field_273;
        this.field_274 = var1.field_274;
        this.field_278 = var1.field_278;
        this.field_279 = class_34.field_157;
        this.field_293 = var2;
        this.field_297 = false;
        this.field_281 = var1.field_281;
        this.field_292 = var1;
        this.field_276 = class_83.method_572(this, var1.field_276);
        this.field_277 = class_83.method_570(this, var1.field_277);
        if (this.field_277 == null) {
            this.field_277 = class_34.field_151;
        }
        this.field_275 = class_83.method_571(this, var1.field_275);
        if ((this.field_281 & 128L) == 0L) {
            if ((this.field_275.field_178 & 128L) != 0L) {
                this.field_281 |= 128L;
            } else {
                int var4 = 0;
                int var5 = this.field_276.length;
                label34:
                while (true) {
                    if (var4 >= var5) {
                        var4 = 0;
                        var5 = this.field_277.length;
                        while (true) {
                            if (var4 >= var5) {
                                break label34;
                            }
                            if ((this.field_277[var4].field_178 & 128L) != 0L) {
                                this.field_281 |= 128L;
                                break label34;
                            }
                            ++var4;
                        }
                    }
                    if ((this.field_276[var4].field_178 & 128L) != 0L) {
                        this.field_281 |= 128L;
                        break;
                    }
                    ++var4;
                }
            }
        }
        this.field_296 = true;
    }

    public LookupEnvironment method_91() {
        return this.field_294;
    }

    public boolean method_354() {
        return this.field_296 ? this.field_292.method_354() : super.method_354();
    }

    public boolean method_355() {
        return this.field_295 ? this.field_292.method_355() : super.method_355();
    }

    private class_63 method_405(class_83 var1, class_321 var2) {
        class_46[] var3 = this.field_292.field_279;
        int var4 = var3.length;
        if (var2.field_1830 != null) {
            this.field_275.method_133(var1, var2.field_1830, var2, 2);
            if (var2.field_1829 == 1) {
                return null;
            }
        }
        int var5;
        for (var5 = 0; var5 < var4; ++var5) {
            class_46 var6 = var3[var5];
            class_40 var7 = this.field_293[var5];
            boolean var8 = var7 != var6;
            if (var6.field_222 == var6.field_223) {
                class_40 var9 = class_83.method_571(this, var6.field_223);
                var7.method_133(var1, var9, var2, 2);
                if (var2.field_1829 == 1) {
                    return null;
                }
                if (var8) {
                    var9.method_133(var1, var7, var2, 1);
                    if (var2.field_1829 == 1) {
                        return null;
                    }
                }
            }
            int var16 = 0;
            for (int var10 = var6.field_224.length; var16 < var10; ++var16) {
                class_40 var11 = class_83.method_571(this, var6.field_224[var16]);
                var7.method_133(var1, var11, var2, 2);
                if (var2.field_1829 == 1) {
                    return null;
                }
                if (var8) {
                    var11.method_133(var1, var7, var2, 1);
                    if (var2.field_1829 == 1) {
                        return null;
                    }
                }
            }
        }
        if (var2.field_1829 == 2) {
            this.field_297 = true;
            this.field_299 = false;
            for (var5 = 0; var5 < var4; ++var5) {
                this.field_293[var5] = var3[var5].method_261();
            }
        } else {
            if (!method_402(var1, var3, var2, true)) {
                return null;
            }
            for (var5 = 0; var5 < var4; ++var5) {
                class_40 var13 = var2.field_1832[var5];
                if (var13 != null) {
                    this.field_293[var5] = var2.field_1832[var5];
                } else {
                    this.field_293[var5] = var3[var5].method_261();
                }
            }
        }
        this.field_293 = class_83.method_572(this, this.field_293);
        class_40 var15 = this.field_275;
        this.field_275 = class_83.method_571(this, this.field_275);
        this.field_295 = var2.field_1831 && this.field_275 != var15;
        this.field_276 = class_83.method_572(this, this.field_276);
        this.field_277 = class_83.method_570(this, this.field_277);
        if (this.field_277 == null) {
            this.field_277 = class_34.field_151;
        }
        if ((this.field_281 & 128L) == 0L) {
            if ((this.field_275.field_178 & 128L) != 0L) {
                this.field_281 |= 128L;
            } else {
                int var12 = 0;
                int var14 = this.field_276.length;
                while (true) {
                    if (var12 >= var14) {
                        var12 = 0;
                        for (var14 = this.field_277.length; var12 < var14; ++var12) {
                            if ((this.field_277[var12].field_178 & 128L) != 0L) {
                                this.field_281 |= 128L;
                                return this;
                            }
                        }
                        return this;
                    }
                    if ((this.field_276[var12].field_178 & 128L) != 0L) {
                        this.field_281 |= 128L;
                        break;
                    }
                    ++var12;
                }
            }
        }
        return this;
    }

    public boolean method_92() {
        return this.field_297;
    }

    public class_40 method_90(class_46 var1) {
        class_46[] var2 = this.field_292.field_279;
        int var3 = var2.length;
        return (class_40)(var1.field_221 < var3 && var2[var1.field_221] == var1 ? this.field_293[var1.field_221] : var1);
    }

    public class_58 method_386() {
        if (this.field_298 == null) {
            class_46[] var1 = this.field_292.field_279;
            int var2 = var1.length;
            class_40[] var3 = new class_40[var2];
            for (int var4 = 0; var4 < var2; ++var4) {
                class_46 var5 = var1[var4];
                if (var5.method_257() <= 1) {
                    var3[var4] = this.field_294.method_490(var5.method_261(), false);
                } else {
                    var3[var4] = this.field_294.method_490(this.field_294.method_502((ReferenceBinding)null, 0, var5.method_240(), var5.method_241(), 1), false);
                }
            }
            this.field_298 = this.field_294.method_499(this.field_292, var3);
        }
        return this.field_298;
    }
}
