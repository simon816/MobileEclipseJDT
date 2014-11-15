package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.ast.class_123;
import org.eclipse.jdt.internal.compiler.lookup.class_34;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.class_46;
import org.eclipse.jdt.internal.compiler.lookup.class_49;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.class_58;
import org.eclipse.jdt.internal.compiler.lookup.class_63;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;
import org.eclipse.jdt.internal.compiler.lookup.class_81;
import org.eclipse.jdt.internal.compiler.lookup.class_83;
import org.eclipse.jdt.internal.compiler.util.class_229;
import org.eclipse.jdt.internal.compiler.util.HashtableOfObject;

class class_82 extends class_81 {

    class_82(LookupEnvironment var1) {
        super(var1);
    }

    boolean method_522(class_58 var1, class_58 var2) {
        var1 = var1.method_376();
        var2 = var2.method_376();
        class_40 var3 = var1.field_278.method_140(var2.field_278);
        if (!(var3 instanceof ReferenceBinding)) {
            return false;
        } else {
            if (var3 != var2.field_278) {
                class_58[] var4 = ((ReferenceBinding)var3).method_210(var2.field_274);
                int var5 = 0;
                for (int var6 = var4.length; var5 < var6; ++var5) {
                    if (var4[var5].method_376() == var2) {
                        return this.method_548(var1, var4[var5]);
                    }
                }
            }
            return this.method_548(var1, var2);
        }
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
                int var6;
                if (var1.field_278.method_157()) {
                    for (var6 = 0; var6 < var5; ++var6) {
                        if (!this.method_526(var3[var6], var4[var6])) {
                            return false;
                        }
                    }
                    return true;
                } else {
                    var6 = 0;
                    while (true) {
                        if (var6 < var5) {
                            if (this.method_526(var3[var6], var4[var6])) {
                                ++var6;
                                continue;
                            }
                            if (!var3[var6].method_173().method_166() || var3[var6].method_136() != var4[var6].method_136() || !var3[var6].method_173().method_154(var4[var6].method_173())) {
                                return false;
                            }
                            if (var1.field_279 != class_34.field_157) {
                                return false;
                            }
                            for (int var7 = 0; var7 < var6; ++var7) {
                                if (var3[var7].method_173().method_162()) {
                                    return false;
                                }
                            }
                        }
                        ++var6;
                        for (; var6 < var5; ++var6) {
                            if (!this.method_526(var3[var6], var4[var6])) {
                                if (!var3[var6].method_173().method_166() || var3[var6].method_136() != var4[var6].method_136() || !var3[var6].method_173().method_154(var4[var6].method_173())) {
                                    return false;
                                }
                            } else if (var3[var6].method_173().method_162()) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
            }
        }
    }

    boolean method_524(class_58 var1, class_58 var2) {
        return var1.field_275 == var2.field_275 ? true : this.method_525(var1, var2);
    }

    boolean method_526(class_40 var1, class_40 var2) {
        return var1 == var2 ? true : (var1.method_162() && var2.method_162() ? var1.method_154(var2) && var2.method_154(var1) : false);
    }

    boolean method_527() {
        return this.field_368.method_240() != null && (this.field_368.method_240().method_217() || this.field_368.method_240().method_162()) ? false : this.field_368.method_241() == class_34.field_155;
    }

    boolean method_528(class_58 var1, class_58 var2) {
        return var2 == null || var1.field_278 == var2.field_278 && !var1.field_278.method_162();
    }

    void method_531(class_58 var1, class_58[] var2) {
        super.method_531(var1, var2);
        int var3 = 0;
        for (int var4 = var2.length; var3 < var4; ++var3) {
            class_58 var5 = var2[var3];
            if (var1.method_374() != var5.method_374()) {
                this.method_552().method_1820(var1, var5, this.field_368);
            }
            class_58 var6 = var5.method_376();
            if (var6.field_275 != var1.field_275) {
                if (var5.field_275.method_173().method_162()) {
                    if (var1.field_275.method_173().method_166()) {
                        this.method_552().method_1805(var1, var6, this.field_368);
                    }
                } else if (var5.method_355() && var6.field_275.method_173().method_169() && ((class_46)var6.field_275.method_173()).field_220 == var6) {
                    class_40 var7 = var1.field_275.method_173();
                    if (!var7.method_169() || ((class_46)var7).field_220 != var1) {
                        this.method_552().method_1805(var1, var6, this.field_368);
                    }
                }
            }
            if (var6.field_278.method_157() && (var1.field_278 == this.field_368.field_252 && this.field_368.field_252.method_162() || this.field_368.field_252.method_138().method_140(var6.field_278) == null)) {
                this.field_368.method_303(var6, var1.method_376());
            }
        }
    }

    void method_533(class_58 var1, class_58 var2, class_58[] var3) {
        if (var1.method_374() != var2.method_374()) {
            this.method_553(var1).method_1820(var1, var2, this.field_368);
        }
        class_58 var4 = var2.method_376();
        if (var4.field_275 != var1.field_275) {
            if (var2.field_275.method_173().method_162() && var1.field_275.method_173().method_166()) {
                this.method_553(var1).method_1805(var1, var4, this.field_368);
            } else if (var2.method_355() && var4.field_275.method_173().method_169() && ((class_46)var4.field_275.method_173()).field_220 == var4) {
                class_40 var5 = var1.field_275.method_173();
                if (!var5.method_169() || ((class_46)var5).field_220 != var1) {
                    this.method_553(var1).method_1805(var1, var4, this.field_368);
                }
            }
        }
        if (this.field_368.method_303(var4, var1.method_376()) != null) {
            int var9 = 0;
            for (int var6 = var3.length; var9 < var6; ++var9) {
                class_58 var7 = var3[var9];
                class_58 var8 = var7.method_376();
                if (var8 != var4 && var8 != var7 && !var2.method_344(var7) && (var7.field_278.method_138() == var2.field_278.method_138() || var7.field_278.method_140(var2.field_278) == null) && this.method_560(var4, var8)) {
                    return;
                }
            }
        }
    }

    void method_557(class_58 var1, class_58 var2) {
        if (!var1.field_278.method_157() && !var2.method_370()) {
            if (!this.method_561(var1, var2)) {
                class_40[] var3 = var1.field_276;
                class_40[] var4 = var2.field_276;
                int var5 = var3.length;
                if (var5 == var4.length) {
                    for (int var6 = 0; var6 < var5; ++var6) {
                        if (var3[var6] != var4[var6] && (var3[var6].method_148() != var4[var6].method_148() || !var4[var6].method_152(var3[var6]))) {
                            return;
                        }
                    }
                    ReferenceBinding[] var16 = null;
                    int var7 = 0;
                    ReferenceBinding var8 = var2.field_278;
                    ReferenceBinding[] var9 = var8.method_241();
                    if (var9 != class_34.field_155) {
                        var7 = var9.length;
                        var16 = var9;
                    }
                    int var12;
                    for (var8 = var8.method_240(); var8 != null && var8.method_101(); var8 = var8.method_240()) {
                        class_58[] var10 = var8.method_210(var1.field_274);
                        int var11 = 0;
                        for (var12 = var10.length; var11 < var12; ++var11) {
                            class_58 var13 = this.method_542(var10[var11], var1);
                            if (var13 != null && !this.method_564(var1, var13) && this.method_561(var1, var13)) {
                                return;
                            }
                        }
                        if ((var9 = var8.method_241()) != class_34.field_155) {
                            if (var16 == null) {
                                var16 = var9;
                                var7 = var9.length;
                            } else {
                                var11 = var9.length;
                                if (var7 + var11 >= var16.length) {
                                    System.arraycopy(var16, 0, var16 = new ReferenceBinding[var7 + var11 + 5], 0, var7);
                                }
                                label127:
                                for (var12 = 0; var12 < var11; ++var12) {
                                    ReferenceBinding var20 = var9[var12];
                                    for (int var14 = 0; var14 < var7; ++var14) {
                                        if (var20 == var16[var14]) {
                                            continue label127;
                                        }
                                    }
                                    var16[var7++] = var20;
                                }
                            }
                        }
                    }
                    for (int var17 = 0; var17 < var7; ++var17) {
                        var8 = var16[var17];
                        if (var8.method_101()) {
                            class_58[] var18 = var8.method_210(var1.field_274);
                            var12 = 0;
                            int var19;
                            for (var19 = var18.length; var12 < var19; ++var12) {
                                class_58 var22 = this.method_542(var18[var12], var1);
                                if (var22 != null && !this.method_564(var1, var22) && this.method_561(var1, var22)) {
                                    return;
                                }
                            }
                            if ((var9 = var8.method_241()) != class_34.field_155) {
                                var12 = var9.length;
                                if (var7 + var12 >= var16.length) {
                                    System.arraycopy(var16, 0, var16 = new ReferenceBinding[var7 + var12 + 5], 0, var7);
                                }
                                label97:
                                for (var19 = 0; var19 < var12; ++var19) {
                                    ReferenceBinding var21 = var9[var19];
                                    for (int var15 = 0; var15 < var7; ++var15) {
                                        if (var21 == var16[var15]) {
                                            continue label97;
                                        }
                                    }
                                    var16[var7++] = var21;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    void method_558(class_58 var1, class_58 var2) {
        if (var1.field_278.method_138() == var2.field_278.method_138()) {
            boolean var3 = var1.method_354() && var2.method_354() ? var1.method_344(var2) : var1.method_342(var2);
            if (var3) {
                this.method_552().method_1526(this.field_368, var1, var2);
                return;
            }
        } else if (var1.field_278.method_140(var2.field_278) != null) {
            return;
        }
        if (!var1.field_278.method_157() && !var1.method_370()) {
            this.method_560(var1.method_376(), var2.method_376());
        }
    }

    void method_535(class_58[] var1, int var2) {
        int var3 = var2;
        int[] var4 = new int[var2];
        int var5 = 0;
        int var6;
        for (var6 = var2 - 1; var5 < var6; ++var5) {
            if (var4[var5] != -1) {
                class_58 var7 = var1[var5];
                class_58[] var8 = null;
                int var9;
                class_58 var10;
                for (var9 = var5 + 1; var9 <= var6; ++var9) {
                    var10 = var1[var9];
                    if (var7.field_278 == var10.field_278 && this.method_522(var7, var10)) {
                        var4[var9] = -1;
                        if (var8 == null) {
                            var8 = new class_58[var2];
                        }
                        var8[var9] = var10;
                    }
                }
                if (var8 != null) {
                    var9 = var7.method_356() ? 0 : 1;
                    var10 = var7;
                    int var11 = 0;
                    int var12;
                    for (var12 = var8.length; var11 < var12; ++var11) {
                        if (var8[var11] != null && !var8[var11].method_356()) {
                            var10 = var8[var11];
                            ++var9;
                        }
                    }
                    if (var9 != 1) {
                        var11 = 0;
                        for (var12 = var8.length; var11 < var12; ++var11) {
                            if (var8[var11] != null) {
                                this.method_552().method_1526(this.field_368, var7, var8[var11]);
                                --var3;
                                if (var10 == var8[var11]) {
                                    var1[var5] = null;
                                } else {
                                    var1[var11] = null;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (var3 < var2) {
            if (var3 == 1) {
                return;
            }
            class_58[] var13 = new class_58[var3];
            var6 = var2;
            while (true) {
                --var6;
                if (var6 < 0) {
                    var1 = var13;
                    var2 = var13.length;
                    break;
                }
                if (var1[var6] != null) {
                    --var3;
                    var13[var3] = var1[var6];
                }
            }
        }
        super.method_535(var1, var2);
    }

    boolean method_536(class_58[] var1, int var2) {
        int[] var3 = null;
        int var4 = 0;
        int var5 = var1[0].method_356() ? var2 - 2 : 0;
        int var7;
        while (var4 <= var5) {
            class_58 var6 = var1[var4++];
            label89:
            for (var7 = var4; var7 < var2; ++var7) {
                if (!this.method_524(var6, var1[var7])) {
                    if (this.field_368.method_157()) {
                        int var8 = var2;
                        while (true) {
                            --var8;
                            if (var8 < 0) {
                                break;
                            }
                            if (var1[var8].field_278.field_177 == 1) {
                                continue label89;
                            }
                        }
                    } else if ((var6.field_278.method_151() || !this.field_368.method_215(var6.field_278, false)) && (var1[var7].field_278.method_151() || !this.field_368.method_215(var1[var7].field_278, false))) {
                        continue;
                    }
                    if (this.method_565(var6, var1[var7])) {
                        this.method_553(var6).method_1805(var6, var1[var7], this.field_368);
                    } else {
                        if (var3 == null) {
                            var3 = new int[var2];
                        }
                        var3[var4 - 1] = -1;
                        var3[var7] = -1;
                    }
                }
            }
        }
        if (var3 == null) {
            return true;
        } else {
            var4 = 0;
            for (var5 = 0; var5 < var2; ++var5) {
                if (var3[var5] == -1) {
                    ++var4;
                }
            }
            if (var4 == var2) {
                this.method_552().method_1616(this.field_368, var1, var2);
                return false;
            } else {
                class_58[] var9 = new class_58[var4];
                int var10 = 0;
                for (var7 = 0; var10 < var2; ++var10) {
                    if (var3[var10] == -1) {
                        var9[var7++] = var1[var10];
                    }
                }
                this.method_552().method_1616(this.field_368, var9, var4);
                return false;
            }
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
                        byte[] var9 = new byte[var6.length];
                        int var10;
                        int var11;
                        class_58 var12;
                        int var13;
                        if (var5 != null) {
                            var10 = 0;
                            for (var11 = var5.length; var10 < var11; ++var10) {
                                var12 = var5[var10];
                                var13 = 0;
                                for (int var14 = var6.length; var13 < var14; ++var13) {
                                    class_58 var15 = this.method_542(var6[var13], var12);
                                    if (var15 != null) {
                                        if (var9[var13] == 0 && this.method_564(var12, var15)) {
                                            ++var7;
                                            var8[var7] = var15;
                                            var9[var13] = 1;
                                        } else {
                                            this.method_557(var12, var15);
                                        }
                                    }
                                }
                                if (var7 >= 0) {
                                    this.method_530(var12, var8, var7 + 1, var6);
                                    while (var7 >= 0) {
                                        var8[var7--] = null;
                                    }
                                }
                            }
                        }
                        var10 = 0;
                        for (var11 = var6.length; var10 < var11; ++var10) {
                            if (var9[var10] != 1) {
                                var12 = var6[var10];
                                ++var7;
                                var8[var7] = var12;
                                for (var13 = var10 + 1; var13 < var11; ++var13) {
                                    class_58 var16 = var6[var13];
                                    if (var9[var13] != 1 && !this.method_528(var12, var16)) {
                                        var16 = this.method_542(var16, var12);
                                        if (var16 != null) {
                                            if (var12.field_278 != var16.field_278 && this.method_564(var12, var16)) {
                                                ++var7;
                                                var8[var7] = var16;
                                                var9[var13] = 1;
                                            } else {
                                                this.method_558(var12, var16);
                                            }
                                        }
                                    }
                                }
                                if (var7 != -1) {
                                    if (var7 > 0) {
                                        this.method_535(var8, var7 + 1);
                                    } else if (var1 && var7 == 0 && var8[0].method_356()) {
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

    void method_559(class_123 var1) {
        char[][] var2 = this.field_369.field_1844;
        int var3 = var2.length;
        while (true) {
            --var3;
            if (var3 < 0) {
                return;
            }
            if (var2[var3] != null) {
                class_58[] var4 = (class_58[])((class_58[])this.field_369.field_1845[var3]);
                if (var4.length != 1) {
                    int var5 = -1;
                    class_58[] var6 = new class_58[var4.length];
                    int var7 = 0;
                    for (int var8 = var4.length; var7 < var8; ++var7) {
                        while (var5 >= 0) {
                            var6[var5--] = null;
                        }
                        class_58 var9 = var4[var7];
                        if (var9 != null) {
                            ++var5;
                            var6[var5] = var9;
                            for (int var10 = var7 + 1; var10 < var8; ++var10) {
                                class_58 var11 = var4[var10];
                                if (!this.method_528(var9, var11)) {
                                    var11 = this.method_542(var11, var9);
                                    if (var11 != null && this.method_564(var9, var11)) {
                                        ++var5;
                                        var6[var5] = var11;
                                        var4[var10] = null;
                                    }
                                }
                            }
                        }
                        if (var5 > 0) {
                            class_58 var12 = var6[0];
                            int var13 = var5 + 1;
                            do {
                                --var13;
                            } while (var13 > 0 && this.method_524(var12, var6[var13]));
                            if (var13 > 0) {
                                this.method_552().method_1615(var1, var6, var5 + 1);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    class_58 method_542(class_58 var1, class_58 var2) {
        if (var1 == null) {
            return null;
        } else if (var2.field_276.length != var1.field_276.length) {
            return null;
        } else {
            if (var2.field_278 instanceof class_49) {
                ((class_49)var2.field_278).method_277(var2);
            }
            if (var1.field_278 instanceof class_49) {
                ((class_49)var1.field_278).method_277(var1);
            }
            class_46[] var3 = var1.field_279;
            if (var3 == class_34.field_157) {
                return var1;
            } else {
                int var4 = var3.length;
                class_46[] var5 = var2.field_279;
                int var6 = var5.length;
                if (var6 > 0 && var4 != var6) {
                    return var1;
                } else {
                    class_40[] var7 = new class_40[var4];
                    if (var4 <= var6) {
                        System.arraycopy(var5, 0, var7, 0, var4);
                    } else {
                        System.arraycopy(var5, 0, var7, 0, var6);
                        for (int var8 = var6; var8 < var4; ++var8) {
                            var7[var8] = var3[var8].method_261();
                        }
                    }
                    class_63 var18 = this.field_371.method_499(var1, var7);
                    for (int var9 = 0; var9 < var4; ++var9) {
                        class_46 var10 = var3[var9];
                        class_40 var11 = var7[var9];
                        if (var11 instanceof class_46) {
                            class_46 var12 = (class_46)var11;
                            if (var12.field_222 == var10.field_222) {
                                if (var12.field_222 == null) {
                                    continue;
                                }
                            } else if (var12.field_222 != null && var10.field_222 != null && var12.field_222.method_151() != var10.field_222.method_151()) {
                                return var1;
                            }
                            if (class_83.method_571(var18, var10.field_223) != var12.field_223) {
                                return var1;
                            }
                            int var13 = var10.field_224.length;
                            ReferenceBinding[] var14 = var12.field_224;
                            if (var13 != var14.length) {
                                return var1;
                            }
                            int var15 = 0;
                            label76:
                            while (var15 < var13) {
                                class_40 var16 = class_83.method_571(var18, var10.field_224[var15]);
                                for (int var17 = 0; var17 < var13; ++var17) {
                                    if (var16 == var14[var17]) {
                                        ++var15;
                                        continue label76;
                                    }
                                }
                                return var1;
                            }
                        } else if (var10.method_255(var18, var11) != 0) {
                            return var1;
                        }
                    }
                    return var18;
                }
            }
        }
    }

    boolean method_560(class_58 var1, class_58 var2) {
        if (var1.method_342(var2) && var1.field_275.method_138() == var2.field_275.method_138()) {
            this.method_552().method_1617(this.field_368, var1, var2);
            return true;
        } else {
            return false;
        }
    }

    boolean method_561(class_58 var1, class_58 var2) {
        class_58 var3 = var2.method_376();
        if (var1.method_342(var3) && var1.field_275.method_138() == var3.field_275.method_138()) {
            this.method_553(var1).method_1671(var1, var2.field_278.method_166() ? var2 : var3);
            return true;
        } else {
            return false;
        }
    }

    public boolean method_562(class_58 var1, class_58 var2) {
        return this.method_543(var1, var2) && this.method_522(var1, var2);
    }

    boolean method_563(class_58 var1) {
        if (var1.method_351() == null) {
            return false;
        } else {
            class_40[] var2 = var1.field_276;
            int var3 = 0;
            for (int var4 = var2.length; var3 < var4; ++var3) {
                class_40 var5 = var2[var3].method_173();
                if (var5 instanceof ReferenceBinding) {
                    int var6 = ((ReferenceBinding)var5).field_199;
                    if ((var6 & 1073741824) != 0) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    class_229 method_544(ReferenceBinding var1, ReferenceBinding[] var2) {
        ReferenceBinding[] var3 = null;
        int var4 = 0;
        if (var2 != class_34.field_155) {
            var4 = var2.length;
            var3 = var2;
        }
        boolean var6 = this.field_368.method_156();
        ReferenceBinding[] var5;
        ReferenceBinding var7;
        int var8;
        int var9;
        ReferenceBinding var10;
        for (var7 = var1; var7 != null && var7.method_101(); var7 = var7.method_240()) {
            var6 |= var7.method_156();
            if ((var5 = var7.method_241()) != class_34.field_155) {
                if (var3 == null) {
                    var3 = var5;
                    var4 = var5.length;
                } else {
                    var8 = var5.length;
                    if (var4 + var8 >= var3.length) {
                        System.arraycopy(var3, 0, var3 = new ReferenceBinding[var4 + var8 + 5], 0, var4);
                    }
                    label112:
                    for (var9 = 0; var9 < var8; ++var9) {
                        var10 = var5[var9];
                        for (int var11 = 0; var11 < var4; ++var11) {
                            if (var10 == var3[var11]) {
                                continue label112;
                            }
                        }
                        var3[var4++] = var10;
                    }
                }
            }
        }
        int var12;
        for (var8 = 0; var8 < var4; ++var8) {
            var7 = var3[var8];
            if (var7.method_101()) {
                var6 |= var7.method_156();
                if ((var5 = var7.method_241()) != class_34.field_155) {
                    var9 = var5.length;
                    if (var4 + var9 >= var3.length) {
                        System.arraycopy(var3, 0, var3 = new ReferenceBinding[var4 + var9 + 5], 0, var4);
                    }
                    int var15 = 0;
                    while (var15 < var9) {
                        ReferenceBinding var16 = var5[var15];
                        var12 = 0;
                        while (true) {
                            if (var12 < var4) {
                                if (var16 != var3[var12]) {
                                    ++var12;
                                    continue;
                                }
                            } else {
                                var3[var4++] = var16;
                            }
                            ++var15;
                            break;
                        }
                    }
                }
            }
        }
        if (!var6) {
            return null;
        } else {
            class_229 var14 = null;
            for (var9 = 0; var9 < var4; ++var9) {
                var10 = var3[var9];
                if (var10.method_101()) {
                    class_40 var17 = var10.method_138();
                    for (var12 = var9 + 1; var12 < var4; ++var12) {
                        ReferenceBinding var13 = var3[var12];
                        if (var13.method_101() && var13.method_138() == var17) {
                            if (var14 == null) {
                                class_229 var10000 = new class_229(var4);
                                var14 = var10000;
                            }
                            var14.method_1335(var3[var9]);
                            var14.method_1335(var3[var12]);
                        }
                    }
                }
            }
            return var14;
        }
    }

    boolean method_547(class_58 var1, class_58 var2, ReferenceBinding var3) {
        if (var1.method_376() != var1 && var2.field_278.method_157()) {
            return false;
        } else {
            var1 = this.method_542(var1, var2);
            return var1 != null && var1.field_275 == var2.field_275 && this.method_562(var2, var1);
        }
    }

    boolean method_548(class_58 var1, class_58 var2) {
        class_58 var3 = this.method_542(var2, var1);
        return var3 != null && this.method_564(var1, var3);
    }

    boolean method_564(class_58 var1, class_58 var2) {
        return !this.method_523(var1, var2) ? (var2.method_354() && var1.method_342(var2) ? var1.field_279 == class_34.field_157 && !this.method_563(var1) : false) : (!(var2 instanceof class_63) ? var1.field_279 == class_34.field_157 : !this.method_563(var1) || var1.field_279 != class_34.field_157);
    }

    boolean method_565(class_58 var1, class_58 var2) {
        if (var1.field_275 == var2.field_275.method_138()) {
            class_40[] var3 = var1.field_276;
            class_40[] var4 = var2.field_276;
            int var5 = 0;
            for (int var6 = var3.length; var5 < var6; ++var5) {
                if (!this.method_526(var3[var5], var4[var5])) {
                    return true;
                }
            }
        }
        return var1.field_279 == class_34.field_157 && var2.method_376().field_279 != class_34.field_157 && var1.field_275.method_138().method_140(var2.field_275.method_138()) != null;
    }

    boolean method_554(class_58 var1, class_58 var2) {
        if (this.method_565(var1, var2)) {
            this.method_553(var1).method_1805(var1, var2, this.field_368);
            return false;
        } else {
            return super.method_554(var1, var2);
        }
    }

    void method_556(SourceTypeBinding var1) {
        if (var1.method_145()) {
            var1.method_200();
        }
        super.method_556(var1);
        int var2 = var1.field_257.length;
        while (true) {
            --var2;
            if (var2 < 0) {
                return;
            }
            class_46 var3 = var1.field_257[var2];
            if (var3.field_224 != class_34.field_155 && (var3.field_224.length != 1 || var3.field_223.field_177 != 1)) {
                HashtableOfObject var10001 = new HashtableOfObject(0);
                this.field_370 = var10001;
                ReferenceBinding var4 = var3.method_240();
                if (var4.method_98() == 4100) {
                    var4 = (ReferenceBinding)var4.method_138();
                }
                ReferenceBinding[] var5 = var3.method_241();
                ReferenceBinding[] var6 = new ReferenceBinding[var5.length];
                int var7 = var5.length;
                while (true) {
                    --var7;
                    if (var7 < 0) {
                        this.method_540(var4, var6);
                        this.method_559(var1.field_258.field_376.field_601[var2]);
                        break;
                    }
                    var6[var7] = var5[var7].method_98() == 4100 ? (ReferenceBinding)var5[var7].method_138() : var5[var7];
                }
            }
        }
    }
}
