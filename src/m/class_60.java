package m;

import b.class_233;
import h.class_121;
import h.class_93;
import m.class_17;
import m.class_34;
import m.class_40;
import m.class_43;
import m.class_54;
import m.class_58;
import m.class_67;
import m.class_80;

public class class_60 extends class_58 {

    public class_67 field_283;

    public class_67 field_284;

    public class_58 field_285;

    public class_40 field_286;

    public int field_287;

    public int field_288;

    public int field_289;

    public class_60(class_67 var1, boolean var2, class_43 var3) {
        this.field_288 = 0;
        this.field_273 = 4104;
        this.field_281 |= 25769803776L;
        class_54 var4 = (class_54)var3;
        class_60[] var5 = var4.method_319();
        int var6 = var5 == null ? 0 : var5.length;
        this.field_289 = var6;
        this.field_274 = class_233.method_1355(class_17.field_143, String.valueOf(var6).toCharArray());
        if (var2) {
            this.field_275 = var1.field_301;
            if (var1.method_431()) {
                this.field_276 = class_34.field_150;
            } else {
                this.field_276 = new class_40[1];
                this.field_276[0] = var4;
            }
            this.field_283 = var1;
            this.field_287 = 1;
        } else {
            this.field_275 = class_40.field_188;
            if (var1.method_431()) {
                this.field_276 = new class_40[1];
                this.field_276[0] = var1.field_301;
            } else {
                this.field_276 = new class_40[2];
                this.field_276[0] = var4;
                this.field_276[1] = var1.field_301;
            }
            this.field_284 = var1;
            this.field_287 = 2;
        }
        this.field_277 = class_34.field_151;
        this.field_278 = var4;
        boolean var7;
        do {
            label99: {
                var7 = false;
                class_58[] var10 = var4.method_232();
                long var8;
                int var11;
                int var12;
                if ((var8 = class_43.method_190(this.field_274, var10)) >= 0L) {
                    var11 = this.field_276.length;
                    var12 = (int)var8;
                    label90:
                    for (int var13 = (int)(var8 >> 32); var12 <= var13; ++var12) {
                        class_58 var14 = var10[var12];
                        if (var14.field_276.length == var11) {
                            class_40[] var15 = var14.field_276;
                            for (int var16 = 0; var16 < var11; ++var16) {
                                if (var15[var16] != this.field_276[var16]) {
                                    continue label90;
                                }
                            }
                            var7 = true;
                            break label99;
                        }
                    }
                }
                if (var5 != null) {
                    var11 = 0;
                    for (var12 = var5.length; var11 < var12; ++var11) {
                        if (var5[var11] != null && class_233.method_1364(this.field_274, var5[var11].field_274) && this.method_344(var10[var11])) {
                            var7 = true;
                            break;
                        }
                    }
                }
            }
            if (var7) {
                ++var6;
                this.method_381(class_233.method_1355(class_17.field_143, String.valueOf(var6).toCharArray()));
            }
        } while (var7);
        class_121[] var17 = var4.field_258.field_376.field_583;
        if (var17 != null) {
            int var9 = 0;
            for (int var18 = var17.length; var9 < var18; ++var9) {
                if (var17[var9].field_661 == var1) {
                    this.field_288 = var17[var9].field_444;
                    return;
                }
            }
        }
        this.field_288 = var4.field_258.field_376.field_444;
    }

    public class_60(class_67 var1, class_43 var2, class_40 var3, char[] var4) {
        this.field_288 = 0;
        this.field_273 = 4104;
        this.field_281 |= 25769803776L;
        class_54 var5 = (class_54)var2;
        class_60[] var6 = var5.method_319();
        int var7 = var6 == null ? 0 : var6.length;
        this.field_289 = var7;
        this.field_274 = var4;
        this.field_275 = var5.field_258.method_580(class_40.field_179, 1);
        this.field_276 = class_34.field_150;
        this.field_283 = var1;
        this.field_286 = var3;
        this.field_287 = 9;
        this.field_277 = class_34.field_151;
        this.field_278 = var5;
        if (var5.method_227()) {
            this.field_273 |= 2048;
        }
        boolean var8;
        do {
            label71: {
                var8 = false;
                class_58[] var11 = var5.method_232();
                long var9;
                int var12;
                int var13;
                if ((var9 = class_43.method_190(this.field_274, var11)) >= 0L) {
                    var12 = this.field_276.length;
                    var13 = (int)var9;
                    label62:
                    for (int var14 = (int)(var9 >> 32); var13 <= var14; ++var13) {
                        class_58 var15 = var11[var13];
                        if (var15.field_276.length == var12) {
                            class_40[] var16 = var15.field_276;
                            for (int var17 = 0; var17 < var12; ++var17) {
                                if (var16[var17] != this.field_276[var17]) {
                                    continue label62;
                                }
                            }
                            var8 = true;
                            break label71;
                        }
                    }
                }
                if (var6 != null) {
                    var12 = 0;
                    for (var13 = var6.length; var12 < var13; ++var12) {
                        if (var6[var12] != null && class_233.method_1364(this.field_274, var6[var12].field_274) && this.method_344(var11[var12])) {
                            var8 = true;
                            break;
                        }
                    }
                }
            }
            if (var8) {
                ++var7;
                this.method_381(class_233.method_1355(var4, String.valueOf(var7).toCharArray()));
            }
        } while (var8);
        this.field_288 = var5.field_258.field_376.field_444;
    }

    public class_60(class_58 var1, boolean var2, class_43 var3) {
        this.field_288 = 0;
        if (var1.method_358()) {
            this.method_393(var1);
        } else {
            this.method_394(var1, var2, var3);
        }
    }

    public class_60(class_58 var1, class_58 var2, class_54 var3) {
        this.field_288 = 0;
        this.field_278 = var3;
        this.field_274 = var1.field_274;
        this.field_273 = (var2.field_273 | 64 | 4096) & -1073743121;
        this.field_281 |= 25769803776L;
        this.field_275 = var1.field_275;
        this.field_276 = var1.field_276;
        this.field_277 = var1.field_277;
        this.field_285 = var2;
        this.field_287 = 6;
        class_60[] var4 = var3.method_319();
        int var5 = var4 == null ? 0 : var4.length;
        this.field_289 = var5;
    }

    public class_60(class_54 var1, char[] var2) {
        this.field_288 = 0;
        this.field_278 = var1;
        this.field_274 = var2;
        this.field_273 = 9;
        this.field_281 |= 25769803776L;
        class_80 var3 = var1.field_258.method_586();
        this.field_277 = class_34.field_151;
        if (var2 == class_17.field_71) {
            this.field_275 = var3.method_493(var3.method_489(var1), 1);
            this.field_276 = class_34.field_150;
            this.field_287 = 7;
        } else if (var2 == class_17.field_72) {
            this.field_275 = var3.method_489(var1);
            this.field_276 = new class_40[] {var1.field_258.method_610()};
            this.field_287 = 8;
        }
        class_60[] var4 = ((class_54)this.field_278).method_319();
        int var5 = var4 == null ? 0 : var4.length;
        this.field_289 = var5;
        if (var1.method_227()) {
            this.field_273 |= 2048;
        }
    }

    public void method_393(class_58 var1) {
        this.field_285 = var1;
        this.field_273 = 4096;
        this.field_281 |= 25769803776L;
        class_54 var2 = (class_54)var1.field_278;
        class_60[] var3 = var2.method_319();
        this.field_289 = var3 == null ? 0 : var3.length;
        this.field_274 = var1.field_274;
        this.field_275 = var1.field_275;
        this.field_287 = 4;
        this.field_276 = new class_40[var1.field_276.length + 1];
        System.arraycopy(var1.field_276, 0, this.field_276, 0, var1.field_276.length);
        this.field_276[var1.field_276.length] = var1.field_278;
        this.field_277 = var1.field_277;
        this.field_278 = var2;
        while (true) {
            boolean var4 = false;
            class_58[] var5 = var2.method_232();
            int var6 = 0;
            int var7 = var5.length;
            while (true) {
                if (var6 < var7) {
                    if (!class_233.method_1364(this.field_274, var5[var6].field_274) || !this.method_344(var5[var6])) {
                        ++var6;
                        continue;
                    }
                    var4 = true;
                } else if (var3 != null) {
                    var6 = 0;
                    for (var7 = var3.length; var6 < var7; ++var6) {
                        if (var3[var6] != null && class_233.method_1364(this.field_274, var3[var6].field_274) && this.method_344(var3[var6])) {
                            var4 = true;
                            break;
                        }
                    }
                }
                if (var4) {
                    int var8 = this.field_276.length;
                    System.arraycopy(this.field_276, 0, this.field_276 = new class_40[var8 + 1], 0, var8);
                    this.field_276[var8] = this.field_278;
                }
                if (!var4) {
                    class_93[] var9 = var2.field_258.field_376.field_584;
                    if (var9 != null) {
                        var6 = 0;
                        for (var7 = var9.length; var6 < var7; ++var6) {
                            if (var9[var6].field_488 == var1) {
                                this.field_288 = var9[var6].field_444;
                                return;
                            }
                        }
                    }
                    return;
                }
                break;
            }
        }
    }

    public void method_394(class_58 var1, boolean var2, class_43 var3) {
        this.field_285 = var1;
        this.field_273 = 4104;
        this.field_281 |= 25769803776L;
        class_54 var4 = (class_54)var3;
        class_60[] var5 = var4.method_319();
        int var6 = var5 == null ? 0 : var5.length;
        this.field_289 = var6;
        this.field_274 = class_233.method_1355(class_17.field_143, String.valueOf(var6).toCharArray());
        this.field_275 = var1.field_275;
        this.field_287 = var2 ? 5 : 3;
        if (var1.method_370()) {
            this.field_276 = var1.field_276;
        } else {
            this.field_276 = new class_40[var1.field_276.length + 1];
            this.field_276[0] = var4;
            System.arraycopy(var1.field_276, 0, this.field_276, 1, var1.field_276.length);
        }
        this.field_277 = var1.field_277;
        this.field_278 = var4;
        while (true) {
            boolean var7 = false;
            class_58[] var8 = var4.method_232();
            int var9 = 0;
            int var10 = var8.length;
            while (true) {
                if (var9 < var10) {
                    if (!class_233.method_1364(this.field_274, var8[var9].field_274) || !this.method_344(var8[var9])) {
                        ++var9;
                        continue;
                    }
                    var7 = true;
                } else if (var5 != null) {
                    var9 = 0;
                    for (var10 = var5.length; var9 < var10; ++var9) {
                        if (var5[var9] != null && class_233.method_1364(this.field_274, var5[var9].field_274) && this.method_344(var5[var9])) {
                            var7 = true;
                            break;
                        }
                    }
                }
                if (var7) {
                    ++var6;
                    this.method_381(class_233.method_1355(class_17.field_143, String.valueOf(var6).toCharArray()));
                }
                if (!var7) {
                    class_93[] var11 = var4.field_258.field_376.field_584;
                    if (var11 != null) {
                        var9 = 0;
                        for (var10 = var11.length; var9 < var10; ++var9) {
                            if (var11[var9].field_488 == var1) {
                                this.field_288 = var11[var9].field_444;
                                return;
                            }
                        }
                    }
                    return;
                }
                break;
            }
        }
    }
}
