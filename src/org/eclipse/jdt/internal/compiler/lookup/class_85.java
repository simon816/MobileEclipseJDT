package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ast.class_114;
import org.eclipse.jdt.internal.compiler.ast.class_90;
import org.eclipse.jdt.internal.compiler.ast.class_91;
import org.eclipse.jdt.internal.compiler.env.class_345;
import org.eclipse.jdt.internal.compiler.lookup.class_0;
import org.eclipse.jdt.internal.compiler.lookup.class_17;
import org.eclipse.jdt.internal.compiler.lookup.class_34;
import org.eclipse.jdt.internal.compiler.lookup.class_35;
import org.eclipse.jdt.internal.compiler.lookup.class_36;
import org.eclipse.jdt.internal.compiler.lookup.class_38;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.class_42;
import org.eclipse.jdt.internal.compiler.lookup.class_43;
import org.eclipse.jdt.internal.compiler.lookup.class_44;
import org.eclipse.jdt.internal.compiler.lookup.class_50;
import org.eclipse.jdt.internal.compiler.lookup.class_51;
import org.eclipse.jdt.internal.compiler.lookup.class_54;
import org.eclipse.jdt.internal.compiler.lookup.class_57;
import org.eclipse.jdt.internal.compiler.lookup.class_58;
import org.eclipse.jdt.internal.compiler.lookup.class_67;
import org.eclipse.jdt.internal.compiler.lookup.class_69;
import org.eclipse.jdt.internal.compiler.lookup.class_80;
import org.eclipse.jdt.internal.compiler.lookup.class_81;
import org.eclipse.jdt.internal.compiler.lookup.class_83;
import org.eclipse.jdt.internal.compiler.lookup.class_84;
import org.eclipse.jdt.internal.compiler.problem.ProblemReporter;
import org.eclipse.jdt.internal.compiler.util.class_212;
import org.eclipse.jdt.internal.compiler.util.class_218;
import org.eclipse.jdt.internal.compiler.util.class_325;
import org.eclipse.jdt.internal.compiler.util.class_326;
import org.eclipse.jdt.internal.compiler.util.class_328;

public class class_85 extends class_83 {

    public class_80 field_378;

    public class_90 field_379;

    public char[][] field_380;

    public class_38 field_381;

    public class_35[] field_382;

    public class_325 field_383;

    public class_54[] field_384;

    private class_212 field_385;

    private class_218 field_386;

    private class_326 field_387;

    private class_326 field_388;

    class_328 field_389;

    private int field_390;

    public class_85(class_90 var1, class_80 var2) {
        super(4, (class_83)null);
        this.field_390 = 1;
        this.field_378 = var2;
        this.field_379 = var1;
        var1.field_453 = this;
        this.field_380 = var1.field_448 == null ? CharOperation.field_995 : var1.field_448.field_467;
        if (this.method_577().field_1932) {
            class_212 var10001 = new class_212();
            this.field_385 = var10001;
            class_218 var4 = new class_218();
            this.field_386 = var4;
            class_326 var3 = new class_326();
            this.field_387 = var3;
            var3 = new class_326();
            this.field_388 = var3;
        } else {
            this.field_385 = null;
            this.field_386 = null;
            this.field_387 = null;
            this.field_388 = null;
        }
    }

    void method_673() {
        int var1 = 0;
        for (int var2 = this.field_384.length; var1 < var2; ++var1) {
            this.field_384[var1].field_258.method_650();
        }
    }

    void method_674(class_345 var1) {
        this.field_384 = new class_54[0];
        boolean var2 = false;
        if (this.field_379.field_455.field_1677 != null) {
            char[][] var3 = this.field_379.field_455.field_1677.method_53();
            if (var3 != null && !CharOperation.method_1363(this.field_380, var3)) {
                if (this.field_379.field_448 != null || this.field_379.field_450 != null || this.field_379.field_449 != null) {
                    this.method_644().method_1719(this.field_379);
                }
                this.field_380 = var3.length == 0 ? CharOperation.field_995 : var3;
            }
        }
        if (this.field_380 == CharOperation.field_995) {
            if ((this.field_381 = this.field_378.field_347) == null) {
                this.method_644().method_1686(this.field_379);
                return;
            }
        } else {
            if ((this.field_381 = this.field_378.method_497(this.field_380)) == null) {
                this.method_644().method_1718(this.field_379);
                return;
            }
            if (this.field_379.method_773() && (this.field_379.field_450 == null || this.field_379.field_450.length == 0)) {
                this.field_379.field_450 = new class_114[1];
                class_114 var10000 = new class_114(this.field_379.field_455);
                class_114 var11 = var10000;
                this.field_379.field_450[0] = var11;
                var11.field_580 = class_17.field_144;
                var11.field_577 = 512;
                var2 = true;
            }
            this.method_687(this.field_380);
        }
        class_114[] var12 = this.field_379.field_450;
        int var4 = var12 == null ? 0 : var12.length;
        this.field_384 = new class_54[var4];
        int var5 = 0;
        for (int var6 = 0; var6 < var4; ++var6) {
            class_114 var7 = var12[var6];
            class_43 var8 = this.field_381.method_124(var7.field_580);
            this.method_690(var7.field_580);
            if (var8 != null && var8.method_101() && !(var8 instanceof class_44)) {
                this.method_644().method_1538(this.field_379, var7);
            } else {
                if (this.field_381 != this.field_378.field_347 && this.field_381.method_121(var7.field_580) != null) {
                    this.method_644().method_1773(this.field_379, var7);
                }
                char[] var9;
                if ((var7.field_577 & 1) != 0 && (var9 = this.field_379.method_772()) != null && !CharOperation.method_1364(var9, var7.field_580)) {
                    this.method_644().method_1740(this.field_379, var7);
                }
                class_84 var13 = new class_84(this, var7);
                class_84 var14 = var13;
                class_54 var10 = var14.method_655((class_54)null, this.field_381, var1);
                if (var2 && var6 == 0) {
                    var10.field_199 |= 4096;
                }
                if (var10 != null) {
                    this.field_384[var5++] = var10;
                }
            }
        }
        if (var5 != this.field_384.length) {
            System.arraycopy(this.field_384, 0, this.field_384 = new class_54[var5], 0, var5);
        }
    }

    void method_675() {
        if (this.field_379.field_449 == null) {
            this.field_382 = this.method_685();
        } else {
            int var1 = this.field_379.field_449.length;
            int var2 = var1 + 1;
            for (int var3 = 0; var3 < var1; ++var3) {
                class_91 var4 = this.field_379.field_449[var3];
                if ((var4.field_446 & 131072) != 0 && CharOperation.method_1363(class_17.field_86, var4.field_467) && !var4.method_781()) {
                    --var2;
                    break;
                }
            }
            class_35[] var10 = new class_35[var2];
            var10[0] = this.method_685()[0];
            int var11 = 1;
            int var5 = 0;
            while (var5 < var1) {
                class_91 var6 = this.field_379.field_449[var5];
                char[][] var7 = var6.field_467;
                int var8 = 0;
                while (true) {
                    if (var8 < var11) {
                        class_35 var9 = var10[var8];
                        if (var9.field_163 != ((var6.field_446 & 131072) != 0) || var9.method_106() != var6.method_781() || !CharOperation.method_1363(var7, var10[var8].field_162)) {
                            ++var8;
                            continue;
                        }
                    } else {
                        int var10001;
                        class_35 var10002;
                        if ((var6.field_446 & 131072) != 0) {
                            if (!CharOperation.method_1363(var7, this.field_380)) {
                                class_34 var12 = this.method_681(var7, var7.length);
                                if (var12.method_101() && (!var6.method_781() || !(var12 instanceof class_38))) {
                                    var10001 = var11++;
                                    var10002 = new class_35(var7, true, var12, var6);
                                    var10[var10001] = var10002;
                                }
                            }
                        } else {
                            var10001 = var11++;
                            var10002 = new class_35(var7, false, (class_34)null, var6);
                            var10[var10001] = var10002;
                        }
                    }
                    ++var5;
                    break;
                }
            }
            if (var10.length > var11) {
                System.arraycopy(var10, 0, var10 = new class_35[var11], 0, var11);
            }
            this.field_382 = var10;
        }
    }

    void method_676() {
        if (this.method_577().field_1928 >= 3211264L) {
            int var1 = 0;
            for (int var2 = this.field_384.length; var1 < var2; ++var1) {
                class_84 var3 = this.field_384[var1].field_258;
                var3.method_661();
                var3.method_659();
            }
        }
    }

    public char[] method_677(class_57 var1) {
        if (var1.method_134() != null) {
            return var1.method_134();
        } else {
            if (this.field_389 == null) {
                class_328 var10001 = new class_328();
                this.field_389 = var10001;
            }
            class_54 var2 = var1.field_258.method_640().method_585();
            int var3 = 0;
            boolean var5 = this.method_577().field_1927 >= 3211264L;
            while (true) {
                char[] var4;
                if (var1.method_159()) {
                    if (var3 == 0) {
                        var4 = CharOperation.method_1357(var1.method_137().method_134(), var1.field_198, '$');
                    } else {
                        var4 = CharOperation.method_1358(var1.method_137().method_134(), '$', String.valueOf(var3).toCharArray(), '$', var1.field_198);
                    }
                } else if (var1.method_146()) {
                    if (var5) {
                        var4 = CharOperation.method_1357(var1.field_262.method_134(), String.valueOf(var3 + 1).toCharArray(), '$');
                    } else {
                        var4 = CharOperation.method_1357(var2.method_134(), String.valueOf(var3 + 1).toCharArray(), '$');
                    }
                } else if (var5) {
                    var4 = CharOperation.method_1355(CharOperation.method_1357(var1.method_137().method_134(), String.valueOf(var3 + 1).toCharArray(), '$'), var1.field_198);
                } else {
                    var4 = CharOperation.method_1358(var2.method_134(), '$', String.valueOf(var3 + 1).toCharArray(), '$', var1.field_198);
                }
                if (this.field_389.method_3247(var4) == null) {
                    this.field_389.method_3248(var4, var1);
                    return var4;
                }
                ++var3;
            }
        }
    }

    void method_678() {
        int var1 = 0;
        for (int var2 = this.field_384.length; var1 < var2; ++var1) {
            this.field_384[var1].field_258.method_666();
        }
    }

    void method_679() {
        if (this.field_383 == null) {
            class_325 var17;
            if (this.field_379.field_449 == null) {
                var17 = new class_325(1);
                this.field_383 = var17;
            } else {
                int var1 = this.field_379.field_449.length;
                class_328 var2 = null;
                int var3;
                int var4;
                int var5;
                label202:
                for (var3 = 0; var3 < var1; ++var3) {
                    if ((this.field_379.field_449[var3].field_446 & 131072) == 0) {
                        class_328 var10000 = new class_328(this.field_384.length + var1);
                        var2 = var10000;
                        var4 = 0;
                        var5 = this.field_384.length;
                        while (true) {
                            if (var4 >= var5) {
                                break label202;
                            }
                            var2.method_3248(this.field_384[var4].field_198, this.field_384[var4]);
                            ++var4;
                        }
                    }
                }
                var3 = var1 + 1;
                for (var4 = 0; var4 < var1; ++var4) {
                    class_91 var19 = this.field_379.field_449[var4];
                    if ((var19.field_446 & 131072) != 0 && CharOperation.method_1363(class_17.field_86, var19.field_467) && !var19.method_781()) {
                        --var3;
                        break;
                    }
                }
                class_35[] var18 = new class_35[var3];
                var18[0] = this.method_685()[0];
                var5 = 1;
                int var6 = 0;
                while (var6 < var1) {
                    class_91 var7 = this.field_379.field_449[var6];
                    char[][] var8 = var7.field_467;
                    int var9 = 0;
                    while (true) {
                        if (var9 < var5) {
                            class_35 var10 = var18[var9];
                            if (var10.field_163 != ((var7.field_446 & 131072) != 0) || var10.method_106() != var7.method_781() || !CharOperation.method_1363(var8, var10.field_162)) {
                                ++var9;
                                continue;
                            }
                            this.method_644().method_1809(var7);
                        } else {
                            class_34 var22;
                            int var10001;
                            if ((var7.field_446 & 131072) != 0) {
                                if (CharOperation.method_1363(var8, this.field_380)) {
                                    this.method_644().method_1809(var7);
                                } else {
                                    var22 = this.method_681(var8, var8.length);
                                    if (!var22.method_101()) {
                                        this.method_644().method_1606(var7, var22);
                                    } else if (var7.method_781() && var22 instanceof class_38) {
                                        this.method_644().method_1497(var7);
                                    } else {
                                        var10001 = var5++;
                                        class_35 var10002 = new class_35(var8, true, var22, var7);
                                        var18[var10001] = var10002;
                                    }
                                }
                            } else {
                                var22 = this.method_682(var8, var7.method_781());
                                if (!var22.method_101() && var22.method_102() != 3) {
                                    this.method_644().method_1606(var7, var22);
                                } else if (var22 instanceof class_38) {
                                    this.method_644().method_1497(var7);
                                } else {
                                    label226: {
                                        class_43 var24 = null;
                                        if (var22 instanceof class_58) {
                                            var24 = (class_43)this.method_618(var8, var8.length);
                                            if (!var24.method_101()) {
                                                var24 = null;
                                            }
                                        }
                                        if (!(var22 instanceof class_43) && var24 == null) {
                                            if (var22 instanceof class_67) {
                                                for (int var23 = 0; var23 < var5; ++var23) {
                                                    class_35 var25 = var18[var23];
                                                    if (var25.method_106() && var25.field_165 instanceof class_67 && var22 != var25.field_165 && CharOperation.method_1364(var8[var8.length - 1], var25.field_162[var25.field_162.length - 1])) {
                                                        this.method_644().method_1525(var7);
                                                        break label226;
                                                    }
                                                }
                                            }
                                        } else {
                                            class_43 var11 = var24 == null ? (class_43)var22 : var24;
                                            class_43 var12 = var11.method_102() == 3 ? ((class_51)var11).field_240 : var11;
                                            if (var7.method_756(var12, this)) {
                                                this.method_644().method_1516(var12, var7);
                                            }
                                            class_43 var13 = var2.method_3247(var8[var8.length - 1]);
                                            if (var13 != null) {
                                                if (var13 != var11) {
                                                    int var14 = 0;
                                                    for (int var15 = this.field_384.length; var14 < var15; ++var14) {
                                                        if (CharOperation.method_1364(this.field_384[var14].field_198, var13.field_198)) {
                                                            this.method_644().method_1510(var7);
                                                            break label226;
                                                        }
                                                    }
                                                    this.method_644().method_1525(var7);
                                                }
                                                break label226;
                                            }
                                            var2.method_3248(var8[var8.length - 1], var11);
                                        }
                                        var10001 = var5++;
                                        Object var16;
                                        if (var24 == null) {
                                            var16 = new class_35(var8, false, var22, var7);
                                        } else {
                                            var16 = new class_36(var8, var22, var24, var7);
                                        }
                                        var18[var10001] = (class_35)var16;
                                    }
                                }
                            }
                        }
                        ++var6;
                        break;
                    }
                }
                if (var18.length > var5) {
                    System.arraycopy(var18, 0, var18 = new class_35[var5], 0, var5);
                }
                this.field_382 = var18;
                var6 = this.field_382.length;
                var17 = new class_325(var6);
                this.field_383 = var17;
                for (int var20 = 0; var20 < var6; ++var20) {
                    class_35 var21 = this.field_382[var20];
                    if (!var21.field_163 && var21.field_165 instanceof class_43 || var21 instanceof class_36) {
                        this.field_383.method_3227(var21.field_162[var21.field_162.length - 1], var21);
                    }
                }
            }
        }
    }

    public void method_680() {
        this.method_679();
        int var1 = 0;
        for (int var2 = this.field_384.length; var1 < var2; ++var1) {
            this.field_384[var1].method_306();
        }
    }

    private class_34 method_681(char[][] var1, int var2) {
        this.method_687(var1);
        Object var3 = this.field_378.method_507(var1[0]);
        int var4 = 1;
        if (var3 != null) {
            class_38 var5 = (class_38)var3;
            while (true) {
                if (var4 >= var2) {
                    return var5;
                }
                var3 = var5.method_125(var1[var4++]);
                if (var3 == null || !((class_34)var3).method_101()) {
                    var3 = null;
                    break;
                }
                if (!(var3 instanceof class_38)) {
                    break;
                }
                var5 = (class_38)var3;
            }
        }
        class_43 var7;
        class_51 var10000;
        if (var3 == null) {
            if (this.field_378.field_347 == null || this.method_577().field_1927 >= 3145728L) {
                var10000 = new class_51(CharOperation.method_1387(var1, 0, var4), (class_43)null, 1);
                return var10000;
            }
            var7 = this.method_596(var1[0], this.field_378.field_347, this.field_378.field_347);
            if (var7 == null || !var7.method_101()) {
                var10000 = new class_51(CharOperation.method_1387(var1, 0, var4), (class_43)null, 1);
                return var10000;
            }
            var4 = 1;
        } else {
            var7 = (class_43)var3;
        }
        do {
            if (var4 >= var2) {
                if (!var7.method_194(this.field_381)) {
                    var10000 = new class_51(var1, var7, 2);
                    return var10000;
                }
                return var7;
            }
            var7 = (class_43)this.field_378.method_490(var7, false);
            if (!var7.method_194(this.field_381)) {
                var10000 = new class_51(CharOperation.method_1387(var1, 0, var4), var7, 2);
                return var10000;
            }
            char[] var6 = var1[var4++];
            var7 = var7.method_209(var6);
        } while (var7 != null);
        var10000 = new class_51(CharOperation.method_1387(var1, 0, var4), (class_43)null, 1);
        return var10000;
    }

    private class_34 method_682(char[][] var1, boolean var2) {
        if (var1.length == 1) {
            class_51 var10000;
            if (this.field_378.field_347 != null && this.method_577().field_1927 < 3145728L) {
                class_43 var3 = this.method_596(var1[0], this.field_378.field_347, this.field_381);
                if (var3 == null) {
                    var10000 = new class_51(var1, (class_43)null, 1);
                    return var10000;
                } else {
                    return var3;
                }
            } else {
                var10000 = new class_51(var1, (class_43)null, 1);
                return var10000;
            }
        } else {
            return var2 ? this.method_683(var1) : this.method_681(var1, var1.length);
        }
    }

    private class_34 method_683(char[][] var1) {
        class_34 var2 = this.method_681(var1, var1.length - 1);
        if (!var2.method_101()) {
            return var2;
        } else {
            char[] var3 = var1[var1.length - 1];
            class_51 var10000;
            if (var2 instanceof class_38) {
                class_34 var7 = ((class_38)var2).method_125(var3);
                if (var7 != null && var7 instanceof class_43) {
                    var10000 = new class_51(var1, (class_43)var7, 14);
                    return var10000;
                } else {
                    return var2;
                }
            } else {
                class_43 var4 = (class_43)var2;
                class_67 var5 = this.method_590(var4, var3, (class_0)null, true);
                if (var5 != null) {
                    if (var5.method_102() == 3 && ((class_69)var5).field_317.method_431()) {
                        return var5;
                    }
                    if (var5.method_101() && var5.method_431() && var5.method_423(var4, (class_0)null, this)) {
                        return var5;
                    }
                }
                class_58 var6 = this.method_684(var4, var3);
                if (var6 != null) {
                    return var6;
                } else {
                    var4 = this.method_591(var3, var4);
                    if (var4 != null && var4.method_226()) {
                        if (var4.method_101() && !var4.method_194(this.field_381)) {
                            var10000 = new class_51(var1, var4, 2);
                            return var10000;
                        } else if (var4.method_102() == 2) {
                            var10000 = new class_51(var1, ((class_51)var4).field_240, 2);
                            return var10000;
                        } else {
                            return var4;
                        }
                    } else if (var5 != null && !var5.method_101() && var5.method_102() != 1) {
                        return var5;
                    } else {
                        var10000 = new class_51(var1, var4, 1);
                        return var10000;
                    }
                }
            }
        }
    }

    private class_58 method_684(class_43 var1, char[] var2) {
        if (!var1.method_196(this)) {
            return null;
        } else {
            label28:
            do {
                var1.method_144();
                class_58[] var3 = var1.method_210(var2);
                if (var3 != class_34.field_154) {
                    int var4 = var3.length;
                    class_58 var5;
                    do {
                        --var4;
                        if (var4 < 0) {
                            continue label28;
                        }
                        var5 = var3[var4];
                    } while (!var5.method_370() || !var5.method_346(this.field_381));
                    return var5;
                }
            } while ((var1 = var1.method_240()) != null);
            return null;
        }
    }

    class_35[] method_685() {
        if (this.field_378.field_346 != null) {
            return this.field_378.field_346;
        } else {
            Object var1 = this.field_378.method_507(class_17.field_26);
            if (var1 != null) {
                var1 = ((class_38)var1).method_125(class_17.field_86[1]);
            }
            if (var1 == null || !((class_34)var1).method_101()) {
                this.method_644().method_1655(class_17.field_99, this.field_379, this.field_378.field_363);
                class_50 var2 = this.field_378.method_496((class_38)null, class_17.field_99);
                var1 = var2.field_200;
            }
            class_80 var10000 = this.field_378;
            class_35[] var10001 = new class_35[1];
            class_35 var10004 = new class_35(class_17.field_86, true, (class_34)var1, (class_91)null);
            var10001[0] = var10004;
            return var10000.field_346 = var10001;
        }
    }

    public int method_686() {
        return this.field_390++;
    }

    public ProblemReporter method_644() {
        ProblemReporter var1 = this.field_379.field_454;
        var1.field_1065 = this.field_379;
        return var1;
    }

    void method_687(char[][] var1) {
        if (this.field_385 != null) {
            int var2 = var1.length;
            if (var2 > 1) {
                while (!this.field_385.method_1199(var1)) {
                    this.field_385.method_1198(var1);
                    if (var2 == 2) {
                        this.method_690(var1[0]);
                        this.method_690(var1[1]);
                        return;
                    }
                    --var2;
                    this.method_690(var1[var2]);
                    System.arraycopy(var1, 0, var1 = new char[var2][], 0, var2);
                }
            } else if (var2 == 1) {
                this.method_690(var1[0]);
            }
        }
    }

    void method_688(char[][] var1, char[] var2) {
        this.method_687(var1);
        this.method_690(var2);
    }

    void method_689(class_43 var1, char[] var2) {
        class_43 var3 = this.method_697(var1);
        if (var3 != null) {
            this.method_688(var3.field_197, var2);
        }
    }

    void method_690(char[] var1) {
        if (this.field_386 != null) {
            if (!this.field_386.method_1275(var1)) {
                this.field_386.method_1274(var1);
            }
        }
    }

    void method_691(class_40 var1) {
        if (this.field_388 != null) {
            class_43 var2 = this.method_697(var1);
            if (var2 != null && !this.field_388.method_3233(var2)) {
                this.field_388.method_3231(var2);
            }
        }
    }

    public void method_692(class_40 var1, class_40 var2) {
        this.method_691(var2);
    }

    void method_693(class_40 var1) {
        if (this.field_387 != null) {
            class_43 var2 = this.method_697(var1);
            if (var2 != null && !this.field_387.method_3233(var2)) {
                this.field_387.method_3231(var2);
            }
        }
    }

    void method_694(class_40[] var1) {
        if (this.field_387 != null) {
            if (var1 != null && var1.length != 0) {
                int var2 = 0;
                for (int var3 = var1.length; var2 < var3; ++var2) {
                    class_43 var4 = this.method_697(var1[var2]);
                    if (var4 != null && !this.field_387.method_3233(var4)) {
                        this.field_387.method_3231(var4);
                    }
                }
            }
        }
    }

    class_34 method_695(class_35 var1) {
        if (var1.field_165 == null) {
            var1.field_165 = this.method_682(var1.field_162, var1.method_106());
            if (!var1.field_165.method_101() || var1.field_165 instanceof class_38) {
                if (var1.field_165.method_102() == 3) {
                    return var1.field_165;
                }
                if (this.field_382 != null) {
                    class_35[] var2 = new class_35[this.field_382.length - 1];
                    int var3 = 0;
                    int var4 = 0;
                    for (int var5 = this.field_382.length; var3 < var5; ++var3) {
                        if (this.field_382[var3] != var1) {
                            var2[var4++] = this.field_382[var3];
                        }
                    }
                    this.field_382 = var2;
                }
                return null;
            }
        }
        return var1.field_165;
    }

    public void method_696() {
        int var1;
        class_43 var3;
        for (var1 = 0; var1 < this.field_388.field_1849; ++var1) {
            class_43 var2 = (class_43)this.field_388.method_3237(var1);
            if (!this.field_387.method_3233(var2)) {
                this.field_387.method_3231(var2);
            }
            if (!var2.method_158()) {
                var3 = var2.method_137();
                if (var3 != null) {
                    this.method_691(var3);
                }
            }
            var3 = var2.method_240();
            if (var3 != null) {
                this.method_691(var3);
            }
            class_43[] var4 = var2.method_241();
            if (var4 != null) {
                int var5 = 0;
                for (int var6 = var4.length; var5 < var6; ++var5) {
                    this.method_691(var4[var5]);
                }
            }
        }
        var1 = 0;
        for (int var7 = this.field_387.field_1849; var1 < var7; ++var1) {
            var3 = (class_43)this.field_387.method_3237(var1);
            if (!var3.method_158()) {
                this.method_687(var3.method_159() ? CharOperation.method_1385('.', var3.method_103()) : var3.field_197);
            }
        }
        var1 = this.field_385.field_906;
        char[][][] var8 = new char[var1][][];
        for (int var9 = 0; var9 < var1; ++var9) {
            var8[var9] = this.field_385.method_1200(var9);
        }
        this.field_379.field_455.field_1681 = var8;
        var1 = this.field_386.field_934;
        char[][] var11 = new char[var1][];
        for (int var10 = 0; var10 < var1; ++var10) {
            var11[var10] = this.field_386.method_1276(var10);
        }
        this.field_379.field_455.field_1682 = var11;
    }

    public String toString() {
        return "--- CompilationUnit Scope : " + new String(this.field_379.method_771());
    }

    private class_43 method_697(class_40 var1) {
        if (var1.method_147()) {
            var1 = ((class_42)var1).field_192;
        }
        switch (var1.method_98()) {
            case 132:
            case 516:
            case 4100:
            case 8196:
                return null;
            case 260:
            case 1028:
                var1 = var1.method_138();
            default:
                class_43 var2 = (class_43)var1;
                return var2.method_158() ? null : var2;
        }
    }

    public void method_698(class_81 var1) {
        int var2 = 0;
        for (int var3 = this.field_384.length; var2 < var3; ++var2) {
            this.field_384[var2].method_321(var1);
        }
    }
}
