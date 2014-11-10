package m;

import a.class_341;
import b.class_233;
import f.class_229;
import f.class_325;
import h.class_114;
import h.class_146;
import h.class_96;
import m.class_34;
import m.class_38;
import m.class_40;
import m.class_43;
import m.class_44;
import m.class_49;
import m.class_54;
import m.class_58;
import m.class_80;
import n.class_248;

public class class_81 {

    class_54 field_368;

    class_325 field_369;

    class_325 field_370;

    class_80 field_371;

    private boolean field_372;

    class_81(class_80 var1) {
        this.field_368 = null;
        this.field_369 = null;
        this.field_370 = null;
        this.field_371 = var1;
        this.field_372 = var1.field_352.field_1927 >= 3211264L && var1.field_352.field_1928 < 3211264L;
    }

    boolean method_522(class_58 var1, class_58 var2) {
        return this.method_548(var1, var2) && this.method_524(var1, var2);
    }

    boolean method_523(class_58 var1, class_58 var2) {
        class_40[] var3 = var1.field_276;
        class_40[] var4 = var2.field_276;
        if (var3 == var4) {
            return true;
        } else {
            int var5 = var3.length;
            if (var5 != var4.length) {
                return false;
            } else {
                for (int var6 = 0; var6 < var5; ++var6) {
                    if (!this.method_526(var3[var6], var4[var6])) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    boolean method_524(class_58 var1, class_58 var2) {
        return var1.field_275 == var2.field_275 ? true : (this.method_526(var1.field_275, var2.field_275) ? true : (this.field_372 && var1.field_278 instanceof class_49 && var2.field_278 instanceof class_49 ? this.method_525(var1, var2) : false));
    }

    boolean method_525(class_58 var1, class_58 var2) {
        return var1.field_275.method_148() ? false : (!var1.field_278.method_157() ? (var1.field_278.field_177 == 1 ? var2.field_275.method_152(var1.field_275) : var1.field_275.method_152(var2.field_275)) : (var2.field_278.field_177 == 1 ? var1.field_275.method_152(var2.field_275) : (var1.field_278.method_215(var2.field_278, true) ? var1.field_275.method_152(var2.field_275) : (var2.field_278.method_215(var1.field_278, true) ? var2.field_275.method_152(var1.field_275) : var1.field_275.method_152(var2.field_275) || var2.field_275.method_152(var1.field_275)))));
    }

    boolean method_526(class_40 var1, class_40 var2) {
        return var1 == var2 ? true : (var1 instanceof class_44 ? ((class_44)var1).field_208 == var2 : (var2 instanceof class_44 ? ((class_44)var2).field_208 == var1 : false));
    }

    boolean method_527() {
        return this.field_368.method_240() != null && this.field_368.method_240().method_217() ? false : this.field_368.method_241() == class_34.field_155;
    }

    boolean method_528(class_58 var1, class_58 var2) {
        return var2 == null || var1.field_278 == var2.field_278;
    }

    void method_529(class_58 var1) {
        if (this.method_550(var1.field_278)) {
            class_114 var2 = this.field_368.field_258.field_376;
            if (var2 != null) {
                class_96 var3 = var2.method_846(var1);
                var3.field_478.method_644().method_1463(this.field_368, var1);
            } else {
                this.method_552().method_1463(this.field_368, var1);
            }
        }
    }

    void method_530(class_58 var1, class_58[] var2, int var3, class_58[] var4) {
        if (this.field_368.method_145()) {
            this.method_552().method_1466(var1, var2[var3 - 1]);
        } else {
            class_341 var5 = this.field_368.field_258.method_577();
            int[] var6 = var3 > 1 ? this.method_545(var2, var3) : null;
            int var7 = var3;
            label91:
            while (true) {
                --var7;
                if (var7 < 0) {
                    return;
                }
                class_58 var8 = var2[var7];
                if (var6 == null || var6[var7] == 0) {
                    if (var1.method_370() != var8.method_370()) {
                        this.method_553(var1).method_1756(var1, var8);
                        continue;
                    }
                    if (var8.method_356()) {
                        if (var8.field_278.method_157()) {
                            var1.field_273 |= 536870912;
                        } else {
                            var1.field_273 |= 805306368;
                        }
                    } else if (var8.method_369() || !this.field_368.method_157()) {
                        var1.field_273 |= 268435456;
                    }
                    if (!this.method_524(var1, var8) && (var1.field_275.field_178 & 128L) == 0L && this.method_554(var1, var8)) {
                        continue;
                    }
                    if (var1.field_277 != class_34.field_151) {
                        this.method_532(var1, var8);
                    }
                    if (var8.method_362()) {
                        this.method_553(var1).method_1551(var1, var8);
                    }
                    if (!this.method_546(var1, var8)) {
                        this.method_553(var1).method_1823(var1, var8);
                    }
                    if (var5.field_1940 && var8.method_375() && (!var1.method_375() || var5.field_1939)) {
                        class_43 var9 = var8.field_278;
                        if (var9.method_157()) {
                            int var10 = var3;
                            while (true) {
                                --var10;
                                if (var10 < 0) {
                                    break;
                                }
                                if (var7 != var10 && var2[var10].field_278.method_215(var9, false)) {
                                    continue label91;
                                }
                            }
                        }
                        this.method_553(var1).method_1715(var1, var8);
                    }
                }
                this.method_533(var1, var8, var4);
            }
        }
    }

    void method_531(class_58 var1, class_58[] var2) {
        if (var1.method_370()) {
            this.method_552().method_1758(this.field_368, var1, var2);
        }
        int var3;
        if (!var1.method_369()) {
            var3 = 0;
            int var4 = var2.length;
            if (var1.method_368()) {
                while (var3 < var4 && !var2[var3].method_369()) {
                    ++var3;
                }
            } else if (var1.method_359()) {
                while (var3 < var4 && var2[var3].method_359()) {
                    ++var3;
                }
            }
            if (var3 < var4) {
                this.method_552().method_1614(this.field_368, var1, var2);
            }
        }
        if (var1.field_277 != class_34.field_151) {
            var3 = var2.length;
            while (true) {
                --var3;
                if (var3 < 0) {
                    break;
                }
                this.method_532(var1, var2[var3]);
            }
        }
    }

    void method_532(class_58 var1, class_58 var2) {
        class_43[] var3 = this.method_555(var1);
        class_43[] var4 = this.method_555(var2);
        int var5 = var3.length;
        while (true) {
            --var5;
            if (var5 < 0) {
                return;
            }
            class_43 var6 = var3[var5];
            int var7 = var4.length;
            do {
                --var7;
            } while (var7 > -1 && !this.method_549(var6, var4[var7]));
            if (var7 == -1 && !var6.method_171(false) && (var6.field_178 & 128L) == 0L) {
                this.method_553(var1).method_1607(this.field_368, var1, var2, var6);
            }
        }
    }

    void method_533(class_58 var1, class_58 var2, class_58[] var3) {}

    void method_534(class_43 var1, class_43[] var2) {
        if (var2 != class_34.field_155) {
            class_229 var10000 = new class_229(var2.length);
            class_229 var3 = var10000;
            int var4 = 0;
            for (int var5 = var2.length; var4 < var5; ++var4) {
                var3.method_1335(var2[var4]);
            }
            class_43[] var16 = null;
            var10000 = new class_229(5);
            class_229 var17 = var10000;
            class_43 var6;
            int var7;
            int var11;
            for (var6 = var1; var6 != null && var6.method_101(); var6 = var6.method_240()) {
                if ((var16 = var6.method_241()) != class_34.field_155) {
                    var7 = 0;
                    for (int var8 = var16.length; var7 < var8; ++var7) {
                        class_43 var9 = var16[var7];
                        if (!var17.method_1337(var9) && var9.method_101()) {
                            if (var3.method_1337(var9)) {
                                class_146[] var10 = this.field_368.field_258.field_376.field_582;
                                var11 = 0;
                                for (int var12 = var10.length; var11 < var12; ++var11) {
                                    if (var10[var11].field_675 == var9) {
                                        this.method_552().method_1746(this.field_368, var10[var11], var9, var6);
                                        break;
                                    }
                                }
                            } else {
                                var17.method_1335(var9);
                            }
                        }
                    }
                }
            }
            var7 = var17.field_988;
            if (var7 != 0) {
                class_43[] var18 = new class_43[var7];
                var17.method_1336(var18);
                for (int var19 = 0; var19 < var7; ++var19) {
                    var6 = var18[var19];
                    if ((var16 = var6.method_241()) != class_34.field_155) {
                        int var20 = var16.length;
                        if (var7 + var20 >= var18.length) {
                            System.arraycopy(var18, 0, var18 = new class_43[var7 + var20 + 5], 0, var7);
                        }
                        for (var11 = 0; var11 < var20; ++var11) {
                            class_43 var21 = var16[var11];
                            if (!var17.method_1337(var21) && var21.method_101()) {
                                if (var3.method_1337(var21)) {
                                    class_146[] var13 = this.field_368.field_258.field_376.field_582;
                                    int var14 = 0;
                                    for (int var15 = var13.length; var14 < var15; ++var14) {
                                        if (var13[var14].field_675 == var21) {
                                            this.method_552().method_1746(this.field_368, var13[var14], var21, var6);
                                            break;
                                        }
                                    }
                                } else {
                                    var17.method_1335(var21);
                                    var18[var7++] = var21;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    void method_535(class_58[] var1, int var2) {
        int var4;
        int var6;
        if (var2 > 1) {
            int[] var3 = this.method_545(var1, var2);
            if (var3 != null) {
                var4 = 0;
                class_58[] var5 = new class_58[var2];
                for (var6 = 0; var6 < var2; ++var6) {
                    if (var3[var6] == 0) {
                        var5[var4++] = var1[var6];
                    }
                }
                if (var4 > 1 && !this.method_536(var5, var4)) {
                    return;
                }
            } else if (!this.method_536(var1, var2)) {
                return;
            }
        }
        class_58 var7 = null;
        if (!this.field_368.method_157()) {
            var4 = var2;
            while (true) {
                --var4;
                if (var4 < 0) {
                    break;
                }
                if (!var1[var4].method_356()) {
                    var7 = var1[var4];
                    break;
                }
            }
        }
        if (var7 == null) {
            if (!this.field_368.method_217()) {
                var4 = var2;
                while (true) {
                    --var4;
                    if (var4 < 0) {
                        break;
                    }
                    if (this.method_550(var1[var4].field_278)) {
                        class_114 var10 = this.field_368.field_258.field_376;
                        if (var10 != null) {
                            class_96 var11 = var10.method_846(var1[0]);
                            var11.field_478.method_644().method_1463(this.field_368, var1[0]);
                        } else {
                            this.method_552().method_1463(this.field_368, var1[0]);
                        }
                        return;
                    }
                }
            }
        } else {
            if (var2 > 1) {
                class_58[] var8 = new class_58[var2 - 1];
                int var9 = 0;
                var6 = var2;
                while (true) {
                    --var6;
                    if (var6 < 0) {
                        this.method_531(var7, var8);
                        break;
                    }
                    if (var1[var6] != var7) {
                        var8[var9++] = var1[var6];
                    }
                }
            }
        }
    }

    boolean method_536(class_58[] var1, int var2) {
        class_58 var3 = var1[0];
        int var4 = var2;
        do {
            --var4;
        } while (var4 > 0 && this.method_524(var3, var1[var4]));
        if (var4 == 0) {
            return true;
        } else {
            if (this.field_368.method_157()) {
                int var5 = var2;
                while (true) {
                    --var5;
                    if (var5 < 0) {
                        break;
                    }
                    if (var1[var5].field_278.field_177 == 1) {
                        return false;
                    }
                }
            }
            this.method_552().method_1616(this.field_368, var1, var2);
            return false;
        }
    }

    void method_537() {
        boolean var1 = this.method_551();
        boolean var2 = var1 && this.method_527();
        char[][] var3 = this.field_369.field_1844;
        int var4 = var3.length;
        while (true) {
            --var4;
            if (var4 < 0) {
                return;
            }
            if (var3[var4] != null) {
                class_58[] var5 = (class_58[])((class_58[])this.field_370.method_3226(var3[var4]));
                if (var5 != null || !var2) {
                    class_58[] var6 = (class_58[])((class_58[])this.field_369.field_1845[var4]);
                    if (var6.length == 1 && var5 == null) {
                        if (var1 && var6[0].method_356()) {
                            this.method_529(var6[0]);
                        }
                    } else {
                        int var7 = -1;
                        class_58[] var8 = new class_58[var6.length];
                        int var9;
                        int var10;
                        class_58 var11;
                        int var12;
                        if (var5 != null) {
                            var9 = 0;
                            for (var10 = var5.length; var9 < var10; ++var9) {
                                var11 = var5[var9];
                                var12 = 0;
                                for (int var13 = var6.length; var12 < var13; ++var12) {
                                    class_58 var14 = this.method_542(var6[var12], var11);
                                    if (var14 != null && this.method_548(var11, var14)) {
                                        ++var7;
                                        var8[var7] = var14;
                                        var6[var12] = null;
                                    }
                                }
                                if (var7 >= 0) {
                                    this.method_530(var11, var8, var7 + 1, var6);
                                    while (var7 >= 0) {
                                        var8[var7--] = null;
                                    }
                                }
                            }
                        }
                        var9 = 0;
                        for (var10 = var6.length; var9 < var10; ++var9) {
                            var11 = var6[var9];
                            if (var11 != null) {
                                ++var7;
                                var8[var7] = var11;
                                for (var12 = var9 + 1; var12 < var10; ++var12) {
                                    class_58 var15 = var6[var12];
                                    if (!this.method_528(var11, var15)) {
                                        var15 = this.method_542(var15, var11);
                                        if (var15 != null && this.method_548(var11, var15)) {
                                            ++var7;
                                            var8[var7] = var15;
                                            var6[var12] = null;
                                        }
                                    }
                                }
                                if (var7 != -1) {
                                    if (var7 > 0) {
                                        this.method_535(var8, var7 + 1);
                                    } else if (var1 && var8[0].method_356()) {
                                        this.method_529(var8[0]);
                                    }
                                    while (var7 >= 0) {
                                        var8[var7--] = null;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    void method_538(class_58 var1) {
        class_38 var2 = var1.field_278.field_200;
        if (var2 != this.field_368.field_200) {
            class_43 var3 = this.field_368.method_240();
            char[] var4 = var1.field_274;
            while (var3.method_101()) {
                if (!var3.method_217()) {
                    return;
                }
                if (var2 == var3.field_200) {
                    class_58[] var5 = var3.method_210(var4);
                    int var6 = var5.length;
                    while (true) {
                        --var6;
                        if (var6 < 0) {
                            break;
                        }
                        class_58 var7 = var5[var6];
                        if (!var7.method_367() && !var7.method_358() && !var7.method_360() && this.method_522(var7, var1)) {
                            return;
                        }
                    }
                }
                if ((var3 = var3.method_240()) == var1.field_278) {
                    this.method_552().method_1461(this.field_368, var1);
                    return;
                }
            }
        }
    }

    void method_539() {
        class_43 var1 = this.field_368.method_157() ? this.field_368.field_258.method_609() : this.field_368.method_240();
        this.method_540(var1, this.field_368.method_241());
        this.method_534(var1, this.field_368.method_241());
    }

    void method_540(class_43 var1, class_43[] var2) {
        class_325 var10001 = new class_325(51);
        this.field_369 = var10001;
        class_43[] var3 = null;
        int var4 = 0;
        if (var2 != class_34.field_155) {
            var4 = var2.length;
            var3 = var2;
        }
        class_43 var6 = var1;
        class_325 var10000 = new class_325(3);
        class_325 var7 = var10000;
        boolean var8 = true;
        class_43[] var5;
        int var10;
        int var12;
        int var14;
        int var15;
        int var16;
        class_58[] var26;
        while (var6 != null && var6.method_101()) {
            if (var8) {
                if (var6.method_217()) {
                    if ((var5 = var6.method_241()) != class_34.field_155) {
                        if (var3 == null) {
                            var3 = var5;
                            var4 = var5.length;
                        } else {
                            int var9 = var5.length;
                            if (var4 + var9 >= var3.length) {
                                System.arraycopy(var3, 0, var3 = new class_43[var4 + var9 + 5], 0, var4);
                            }
                            label216:
                            for (var10 = 0; var10 < var9; ++var10) {
                                class_43 var11 = var5[var10];
                                for (var12 = 0; var12 < var4; ++var12) {
                                    if (var11 == var3[var12]) {
                                        continue label216;
                                    }
                                }
                                var3[var4++] = var11;
                            }
                        }
                    }
                } else {
                    var8 = false;
                }
            }
            class_58[] var17 = var6.method_244();
            var10 = var17.length;
            label203:
            while (true) {
                --var10;
                if (var10 < 0) {
                    var6 = var6.method_240();
                    break;
                }
                class_58 var19 = var17[var10];
                if (!var19.method_367() && !var19.method_358() && !var19.method_360()) {
                    class_58[] var20 = (class_58[])((class_58[])this.field_369.method_3226(var19.field_274));
                    if (var20 != null) {
                        int var13 = 0;
                        for (var14 = var20.length; var13 < var14; ++var13) {
                            if (var20[var13].field_278 != var19.field_278 && this.method_522(var20[var13], var19)) {
                                if (var19.method_359() && var19.method_356()) {
                                    this.method_538(var19);
                                }
                                continue label203;
                            }
                        }
                    }
                    class_58[] var23 = (class_58[])((class_58[])var7.method_3226(var19.field_274));
                    if (var23 != null) {
                        var14 = 0;
                        for (var15 = var23.length; var14 < var15; ++var14) {
                            if (this.method_522(var23[var14], var19)) {
                                continue label203;
                            }
                        }
                    }
                    if (var19.method_359() && var19.field_278.field_200 != this.field_368.field_200) {
                        if (var23 == null) {
                            var23 = new class_58[] {var19};
                        } else {
                            var14 = var23.length;
                            System.arraycopy(var23, 0, var23 = new class_58[var14 + 1], 0, var14);
                            var23[var14] = var19;
                        }
                        var7.method_3227(var19.field_274, var23);
                        if (var19.method_356() && !this.field_368.method_217()) {
                            this.method_552().method_1461(this.field_368, var19);
                        }
                        var26 = (class_58[])((class_58[])this.field_370.method_3226(var19.field_274));
                        if (var26 != null && !var19.method_370()) {
                            var15 = 0;
                            for (var16 = var26.length; var15 < var16; ++var15) {
                                if (!var26[var15].method_370() && this.method_522(var26[var15], var19)) {
                                    this.method_552().method_1717(var26[var15], var19);
                                    break;
                                }
                            }
                        }
                    } else {
                        if (var20 == null) {
                            var20 = new class_58[] {var19};
                        } else {
                            var14 = var20.length;
                            System.arraycopy(var20, 0, var20 = new class_58[var14 + 1], 0, var14);
                            var20[var14] = var19;
                        }
                        this.field_369.method_3227(var19.field_274, var20);
                    }
                }
            }
        }
        if (var4 != 0) {
            class_229 var18 = this.method_544(var1, var2);
            for (var10 = 0; var10 < var4; ++var10) {
                var6 = var3[var10];
                if (var6.method_101() && (var18 == null || !var18.method_1337(var6))) {
                    if ((var5 = var6.method_241()) != class_34.field_155) {
                        int var21 = var5.length;
                        if (var4 + var21 >= var3.length) {
                            System.arraycopy(var3, 0, var3 = new class_43[var4 + var21 + 5], 0, var4);
                        }
                        label149:
                        for (var12 = 0; var12 < var21; ++var12) {
                            class_43 var24 = var5[var12];
                            for (var14 = 0; var14 < var4; ++var14) {
                                if (var24 == var3[var14]) {
                                    continue label149;
                                }
                            }
                            var3[var4++] = var24;
                        }
                    }
                    class_58[] var22 = var6.method_244();
                    var12 = var22.length;
                    label136:
                    while (true) {
                        --var12;
                        if (var12 < 0) {
                            break;
                        }
                        class_58 var25 = var22[var12];
                        var26 = (class_58[])((class_58[])this.field_369.method_3226(var25.field_274));
                        if (var26 == null) {
                            var26 = new class_58[] {var25};
                        } else {
                            var15 = var26.length;
                            for (var16 = 0; var16 < var15; ++var16) {
                                if (this.method_547(var25, var26[var16], var6)) {
                                    continue label136;
                                }
                            }
                            System.arraycopy(var26, 0, var26 = new class_58[var15 + 1], 0, var15);
                            var26[var15] = var25;
                        }
                        this.field_369.method_3227(var25.field_274, var26);
                    }
                }
            }
        }
    }

    void method_541() {
        class_58[] var1 = this.field_368.method_232();
        int var2 = var1.length;
        class_325 var10001 = new class_325(var2 == 0 ? 1 : var2);
        this.field_370 = var10001;
        int var3 = var2;
        while (true) {
            --var3;
            if (var3 < 0) {
                return;
            }
            class_58 var4 = var1[var3];
            if (!var4.method_358() && !var4.method_360()) {
                class_58[] var5 = (class_58[])((class_58[])this.field_370.method_3226(var4.field_274));
                if (var5 == null) {
                    var5 = new class_58[1];
                } else {
                    System.arraycopy(var5, 0, var5 = new class_58[var5.length + 1], 0, var5.length - 1);
                }
                var5[var5.length - 1] = var4;
                this.field_370.method_3227(var4.field_274, var5);
            }
        }
    }

    class_58 method_542(class_58 var1, class_58 var2) {
        return var1 == null ? null : (var2.field_276.length != var1.field_276.length ? null : var1);
    }

    boolean method_543(class_58 var1, class_58 var2) {
        if (!class_233.method_1364(var1.field_274, var2.field_274)) {
            return false;
        } else if (var1 != var2 && !var1.method_370() && !var2.method_370()) {
            if (var2.method_367()) {
                return false;
            } else if (var2.method_359() && var1.field_278.method_143() != var2.field_278.method_143()) {
                return false;
            } else {
                if (!var1.method_369()) {
                    if (var2.method_369()) {
                        return false;
                    }
                    if (var2.method_368() && !var1.method_368()) {
                        return false;
                    }
                }
                return true;
            }
        } else {
            return false;
        }
    }

    class_229 method_544(class_43 var1, class_43[] var2) {
        return null;
    }

    int[] method_545(class_58[] var1, int var2) {
        int[] var3 = null;
        int var4 = 0;
        class_43 var5 = var1[var4].field_278;
        if (!var5.method_157()) {
            ++var4;
            class_43 var6;
            for (var6 = var1[var4].field_278; var5 == var6; var6 = var1[var4].field_278) {
                ++var4;
                if (var4 == var2) {
                    return null;
                }
            }
            if (!var6.method_157()) {
                var3 = new int[var2];
                do {
                    var3[var4] = -1;
                    ++var4;
                    if (var4 == var2) {
                        return var3;
                    }
                    var6 = var1[var4].field_278;
                } while (!var6.method_157());
            }
        }
        for (; var4 < var2; ++var4) {
            if (var3 == null || var3[var4] != -1) {
                var5 = var1[var4].field_278;
                for (int var8 = var4 + 1; var8 < var2; ++var8) {
                    if (var3 == null || var3[var8] != -1) {
                        class_43 var7 = var1[var8].field_278;
                        if (var5 != var7) {
                            if (var5.method_215(var7, true)) {
                                if (var3 == null) {
                                    var3 = new int[var2];
                                }
                                var3[var8] = -1;
                            } else if (var7.method_215(var5, true)) {
                                if (var3 == null) {
                                    var3 = new int[var2];
                                }
                                var3[var4] = -1;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return var3;
    }

    boolean method_546(class_58 var1, class_58 var2) {
        return var2.field_273 == var1.field_273 ? true : (var1.method_369() ? true : (var2.method_369() ? false : (var1.method_368() ? true : (var2.method_368() ? false : !var1.method_367()))));
    }

    boolean method_547(class_58 var1, class_58 var2, class_43 var3) {
        return this.method_523(var2, var1) && var2.field_278.method_215(var3, true);
    }

    boolean method_548(class_58 var1, class_58 var2) {
        return this.method_523(var1, var2);
    }

    boolean method_549(class_43 var1, class_43 var2) {
        do {
            if (var1 == var2) {
                return true;
            }
        } while ((var1 = var1.method_240()) != null);
        return false;
    }

    boolean method_550(class_43 var1) {
        class_43 var2 = this.field_368.method_240();
        if (var1.method_151()) {
            while (var2.method_217() && var2 != var1) {
                var2 = var2.method_240();
            }
        } else {
            if (this.field_368.method_215(var1, false)) {
                if (this.field_368.method_217()) {
                    return false;
                }
                if (!var2.method_215(var1, true)) {
                    return true;
                }
            }
            while (var2.method_217() && !var2.method_215(var1, false)) {
                var2 = var2.method_240();
            }
        }
        return var2.method_217();
    }

    boolean method_551() {
        return !this.field_368.method_157() && !this.field_368.method_217();
    }

    class_248 method_552() {
        return this.field_368.field_258.method_644();
    }

    class_248 method_553(class_58 var1) {
        class_248 var2 = this.method_552();
        if (var1.field_278 == this.field_368 && var1.method_384() != null) {
            var2.field_1065 = var1.method_384();
        }
        return var2;
    }

    boolean method_554(class_58 var1, class_58 var2) {
        this.method_553(var1).method_1608(var1, var2);
        return true;
    }

    class_43[] method_555(class_58 var1) {
        class_43[] var2 = var1.field_277;
        if ((var1.field_273 & 33554432) == 0) {
            return var2;
        } else if (!(var1.field_278 instanceof class_49)) {
            return class_34.field_151;
        } else {
            int var3 = var2.length;
            while (true) {
                --var3;
                if (var3 < 0) {
                    return var2;
                }
                var2[var3] = class_49.method_267(var2[var3], this.field_371, true);
            }
        }
    }

    void method_556(class_54 var1) {
        this.field_368 = var1;
        this.method_541();
        this.method_539();
        this.method_537();
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer(10);
        var1.append("MethodVerifier for type: ");
        var1.append(this.field_368.method_103());
        var1.append('\n');
        var1.append("\t-inherited methods: ");
        var1.append(this.field_369);
        return var1.toString();
    }
}
