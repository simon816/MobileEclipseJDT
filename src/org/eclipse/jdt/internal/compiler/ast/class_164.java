package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.class_264;
import org.eclipse.jdt.internal.compiler.ast.class_114;
import org.eclipse.jdt.internal.compiler.ast.class_121;
import org.eclipse.jdt.internal.compiler.ast.class_124;
import org.eclipse.jdt.internal.compiler.ast.class_126;
import org.eclipse.jdt.internal.compiler.ast.class_128;
import org.eclipse.jdt.internal.compiler.ast.class_146;
import org.eclipse.jdt.internal.compiler.ast.class_154;
import org.eclipse.jdt.internal.compiler.ast.class_161;
import org.eclipse.jdt.internal.compiler.ast.class_89;
import org.eclipse.jdt.internal.compiler.ast.class_92;
import org.eclipse.jdt.internal.compiler.ast.class_93;
import org.eclipse.jdt.internal.compiler.impl.class_331;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;
import org.eclipse.jdt.internal.compiler.lookup.class_17;
import org.eclipse.jdt.internal.compiler.lookup.class_203;
import org.eclipse.jdt.internal.compiler.lookup.class_320;
import org.eclipse.jdt.internal.compiler.lookup.class_34;
import org.eclipse.jdt.internal.compiler.lookup.class_38;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.class_43;
import org.eclipse.jdt.internal.compiler.lookup.class_54;
import org.eclipse.jdt.internal.compiler.lookup.class_58;
import org.eclipse.jdt.internal.compiler.lookup.class_65;
import org.eclipse.jdt.internal.compiler.lookup.class_67;
import org.eclipse.jdt.internal.compiler.lookup.class_83;
import org.eclipse.jdt.internal.compiler.lookup.class_86;

public abstract class class_164 extends class_126 {

    static final class_92[] field_764;

    public int field_765;

    public class_34 field_766;

    public class_146 field_767;

    private class_203 field_768;

    public class_164() {
        this.field_768 = null;
    }

    public static long method_1069(char[] var0) {
        if (var0 != null && var0.length != 0) {
            switch (var0[0]) {
                case 67:
                    if (CharOperation.method_1364(var0, class_17.field_74)) {
                        return 35184372088832L;
                    }
                    break;
                case 82:
                    if (CharOperation.method_1364(var0, class_17.field_75)) {
                        return 52776558133248L;
                    }
                    break;
                case 83:
                    if (CharOperation.method_1364(var0, class_17.field_73)) {
                        return 17592186044416L;
                    }
            }
            return 0L;
        } else {
            return 0L;
        }
    }

    public static long method_1070(char[] var0) {
        if (var0 != null && var0.length != 0) {
            switch (var0[0]) {
                case 65:
                    if (CharOperation.method_1364(var0, class_17.field_84)) {
                        return 4398046511104L;
                    }
                case 66:
                case 68:
                case 69:
                case 71:
                case 72:
                case 73:
                case 74:
                case 75:
                case 78:
                case 79:
                case 81:
                case 82:
                case 83:
                default:
                    break;
                case 67:
                    if (CharOperation.method_1364(var0, class_17.field_82)) {
                        return 1099511627776L;
                    }
                    break;
                case 70:
                    if (CharOperation.method_1364(var0, class_17.field_79)) {
                        return 137438953472L;
                    }
                    break;
                case 76:
                    if (CharOperation.method_1364(var0, class_17.field_83)) {
                        return 2199023255552L;
                    }
                    break;
                case 77:
                    if (CharOperation.method_1364(var0, class_17.field_80)) {
                        return 274877906944L;
                    }
                    break;
                case 80:
                    if (CharOperation.method_1364(var0, class_17.field_81)) {
                        return 549755813888L;
                    }
                    if (CharOperation.method_1364(var0, class_17.field_85)) {
                        return 8796093022208L;
                    }
                    break;
                case 84:
                    if (CharOperation.method_1364(var0, class_17.field_78)) {
                        return 68719476736L;
                    }
            }
            return 0L;
        } else {
            return 0L;
        }
    }

    public class_320[] method_1071() {
        return class_34.field_159;
    }

    private long method_1072(class_83 var1, class_43 var2, class_92 var3) {
        long var4 = 0L;
        class_126 var6;
        class_67 var15;
        switch (var2.field_177) {
            case 44:
                var4 |= 70368744177664L;
                break;
            case 45:
                var4 |= 140737488355328L;
                break;
            case 46:
                var4 |= 281474976710656L;
                break;
            case 47:
                var4 |= 562949953421312L;
                break;
            case 48:
                if (var3 != null) {
                    var6 = var3.field_475;
                    if ((var6.field_446 & 3) == 1) {
                        var15 = ((class_154)var6).method_1036();
                        if (var15 != null && var15.field_314.field_177 == 51) {
                            var4 |= method_1069(var15.field_302);
                        }
                    }
                }
                break;
            case 49:
                var4 |= 1125899906842624L;
                break;
            case 50:
                var4 |= 34359738368L;
                if (var3 != null) {
                    var6 = var3.field_475;
                    if (var6 instanceof class_128) {
                        class_128 var7 = (class_128)var6;
                        class_126[] var8 = var7.field_679;
                        if (var8 != null) {
                            int var9 = 0;
                            for (int var10 = var8.length; var9 < var10; ++var9) {
                                class_126 var11 = var8[var9];
                                if ((var11.field_446 & 3) == 1) {
                                    class_67 var12 = ((class_154)var11).method_1036();
                                    if (var12 != null && var12.field_314.field_177 == 52) {
                                        long var13 = method_1070(var12.field_302);
                                        if ((var4 & var13) != 0L) {
                                            var1.method_644().method_1536(var2, (class_161)var11);
                                        } else {
                                            var4 |= var13;
                                        }
                                    }
                                }
                            }
                        }
                    } else if ((var6.field_446 & 3) == 1) {
                        var15 = ((class_154)var6).method_1036();
                        if (var15 != null && var15.field_314.field_177 == 52) {
                            var4 |= method_1070(var15.field_302);
                        }
                    }
                }
        }
        return var4;
    }

    public class_203 method_1073() {
        return this.field_768;
    }

    public abstract class_92[] method_1074();

    public StringBuffer method_924(int var1, StringBuffer var2) {
        var2.append('@');
        this.field_767.method_924(0, var2);
        return var2;
    }

    public void method_1075(class_83 var1, int var2, int var3, boolean var4) {
        long var5 = 0L;
        class_92[] var7 = this.method_1074();
        int var8 = 0;
        for (int var9 = var7.length; var8 < var9; ++var8) {
            class_92 var10 = var7[var8];
            if (CharOperation.method_1364(var10.field_474, class_17.field_70)) {
                class_126 var11 = var10.field_475;
                if (var11 instanceof class_128) {
                    class_128 var12 = (class_128)var11;
                    class_126[] var13 = var12.field_679;
                    if (var13 != null) {
                        int var14 = 0;
                        for (int var15 = var13.length; var14 < var15; ++var14) {
                            class_331 var16 = var13[var14].field_672;
                            if (var16 != class_331.field_1896 && var16.method_3288() == 11) {
                                long var17 = CompilerOptions.method_3320(var16.method_3287());
                                if (var17 != 0L) {
                                    if ((var5 & var17) == var17) {
                                        var1.method_644().method_1816(var13[var14]);
                                    } else {
                                        var5 |= var17;
                                    }
                                } else {
                                    var1.method_644().method_1787(var13[var14]);
                                }
                            }
                        }
                    }
                } else {
                    class_331 var19 = var11.field_672;
                    if (var19 != class_331.field_1896 && var19.method_3288() == 11) {
                        long var20 = CompilerOptions.method_3320(var19.method_3287());
                        if (var20 != 0L) {
                            var5 |= var20;
                        } else {
                            var1.method_644().method_1787(var11);
                        }
                    }
                }
                break;
            }
        }
        if (var4 && var5 != 0L) {
            var1.method_645().method_776(var5, this, var2, var3);
        }
    }

    public class_40 method_925(class_86 var1) {
        if (this.field_768 != null) {
            return this.field_675;
        } else {
            this.field_672 = class_331.field_1896;
            class_40 var2 = this.field_767.method_925(var1);
            if (var2 == null) {
                return null;
            } else {
                this.field_675 = var2;
                if (!var2.method_145() && var2.method_101()) {
                    var1.method_644().method_1777(var2, var1.method_604(), this.field_767, (class_89)null);
                    return null;
                } else {
                    class_43 var3 = (class_43)this.field_675;
                    class_58[] var4 = var3.method_232();
                    class_92[] var5 = this.method_1074();
                    class_92 var6 = null;
                    int var8 = var5.length;
                    class_92[] var7;
                    if (var8 > 0) {
                        System.arraycopy(var5, 0, var7 = new class_92[var8], 0, var8);
                    } else {
                        var7 = var5;
                    }
                    int var9 = 0;
                    int var10 = var4.length;
                    while (var9 < var10) {
                        class_58 var11 = var4[var9];
                        char[] var12 = var11.field_274;
                        boolean var13 = false;
                        int var14 = 0;
                        while (true) {
                            if (var14 < var8) {
                                label152: {
                                    class_92 var15 = var7[var14];
                                    if (var15 != null) {
                                        char[] var16 = var15.field_474;
                                        if (CharOperation.method_1364(var16, var12)) {
                                            if (var6 == null && CharOperation.method_1364(var16, class_17.field_70)) {
                                                var6 = var15;
                                            }
                                            var15.field_476 = var11;
                                            var15.method_784(var1, var11.field_275);
                                            var7[var14] = null;
                                            var13 = true;
                                            boolean var17 = false;
                                            for (int var18 = var14 + 1; var18 < var8; ++var18) {
                                                class_92 var19 = var7[var18];
                                                if (var19 != null && CharOperation.method_1364(var19.field_474, var12)) {
                                                    var17 = true;
                                                    var1.method_644().method_1519(var3, var19);
                                                    var19.field_476 = var11;
                                                    var19.method_784(var1, var11.field_275);
                                                    var7[var18] = null;
                                                }
                                            }
                                            if (var17) {
                                                var1.method_644().method_1519(var3, var15);
                                                break label152;
                                            }
                                        }
                                    }
                                    ++var14;
                                    continue;
                                }
                            } else if (!var13 && (var11.field_273 & 131072) == 0 && (this.field_446 & 32) == 0) {
                                var1.method_644().method_1684(this, var12);
                            }
                            ++var9;
                            break;
                        }
                    }
                    for (var9 = 0; var9 < var8; ++var9) {
                        if (var7[var9] != null) {
                            var1.method_644().method_1780(var3, var7[var9]);
                            var7[var9].method_784(var1, (class_40)null);
                        }
                    }
                    this.field_768 = var1.method_586().method_492((class_43)this.field_675, this.method_1071());
                    long var21 = this.method_1072(var1, var3, var6);
                    var1.method_645().method_776(256L, (class_164)null, this.field_444, this.field_765);
                    if (this.field_766 != null) {
                        if (var21 != 0L) {
                            class_54 var20;
                            switch (this.field_766.method_98()) {
                                case 1:
                                    class_67 var27 = (class_67)this.field_766;
                                    var27.field_305 |= var21;
                                    if ((var21 & 1125899906842624L) != 0L) {
                                        var20 = (class_54)var27.field_314;
                                        class_121 var28 = var20.field_258.field_376.method_853(var27);
                                        this.method_1075(var1, var28.field_653, var28.field_652, var1.method_577().field_1959);
                                    }
                                    break;
                                case 2:
                                    class_65 var30 = (class_65)this.field_766;
                                    var30.field_305 |= var21;
                                    if ((var21 & 1125899906842624L) != 0L) {
                                        class_124 var29 = var30.field_309;
                                        this.method_1075(var1, var29.field_653, var29.field_652, var1.method_577().field_1959);
                                    }
                                    break;
                                case 4:
                                case 2052:
                                    var20 = (class_54)this.field_766;
                                    var20.field_178 |= var21;
                                    if ((var21 & 1125899906842624L) != 0L) {
                                        class_114 var24 = var20.field_258.field_376;
                                        int var26;
                                        if (var1.method_645().field_450[0] == var24) {
                                            var26 = 0;
                                        } else {
                                            var26 = var24.field_592;
                                        }
                                        this.method_1075(var1, var26, var24.field_593, var1.method_577().field_1959);
                                    }
                                    break;
                                case 8:
                                    class_58 var22 = (class_58)this.field_766;
                                    var22.field_281 |= var21;
                                    if ((var21 & 1125899906842624L) != 0L) {
                                        var20 = (class_54)var22.field_278;
                                        class_93 var25 = var20.field_258.field_376.method_854(var22);
                                        this.method_1075(var1, var25.field_480, var25.field_481, var1.method_577().field_1959);
                                    }
                                    break;
                                case 16:
                                    ((class_38)this.field_766).field_170 |= var21;
                            }
                        }
                        long var23 = var3.method_99();
                        if ((var23 & 17557826306048L) != 0L) {
                            switch (this.field_766.method_98()) {
                                case 1:
                                    if ((var23 & 137438953472L) != 0L) {
                                        return this.field_675;
                                    }
                                    break;
                                case 2:
                                    if ((((class_65)this.field_766).field_305 & 1024L) != 0L) {
                                        if ((var23 & 549755813888L) != 0L) {
                                            return this.field_675;
                                        }
                                    } else if ((var3.field_178 & 2199023255552L) != 0L) {
                                        return this.field_675;
                                    }
                                    break;
                                case 4:
                                case 2052:
                                    if (((class_43)this.field_766).method_145()) {
                                        if ((var23 & 4466765987840L) != 0L) {
                                            return this.field_675;
                                        }
                                    } else if ((var23 & 68719476736L) != 0L) {
                                        return this.field_675;
                                    }
                                    break;
                                case 8:
                                    if (((class_58)this.field_766).method_358()) {
                                        if ((var23 & 1099511627776L) != 0L) {
                                            return this.field_675;
                                        }
                                    } else if ((var23 & 274877906944L) != 0L) {
                                        return this.field_675;
                                    }
                                    break;
                                case 16:
                                    if ((var23 & 8796093022208L) != 0L) {
                                        return this.field_675;
                                    }
                            }
                            var1.method_644().method_1517(this);
                        }
                    }
                    return this.field_675;
                }
            }
        }
    }

    public abstract void method_763(class_264 var1, class_86 var2);

    static {
        field_764 = new class_92[0];
    }
}
