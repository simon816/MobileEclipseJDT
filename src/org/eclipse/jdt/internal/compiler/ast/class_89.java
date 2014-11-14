package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.class_264;
import org.eclipse.jdt.internal.compiler.ast.class_126;
import org.eclipse.jdt.internal.compiler.ast.class_130;
import org.eclipse.jdt.internal.compiler.ast.class_146;
import org.eclipse.jdt.internal.compiler.ast.class_164;
import org.eclipse.jdt.internal.compiler.env.class_345;
import org.eclipse.jdt.internal.compiler.lookup.class_0;
import org.eclipse.jdt.internal.compiler.lookup.class_17;
import org.eclipse.jdt.internal.compiler.lookup.class_203;
import org.eclipse.jdt.internal.compiler.lookup.class_34;
import org.eclipse.jdt.internal.compiler.lookup.class_38;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.class_42;
import org.eclipse.jdt.internal.compiler.lookup.class_43;
import org.eclipse.jdt.internal.compiler.lookup.class_45;
import org.eclipse.jdt.internal.compiler.lookup.class_58;
import org.eclipse.jdt.internal.compiler.lookup.class_63;
import org.eclipse.jdt.internal.compiler.lookup.class_65;
import org.eclipse.jdt.internal.compiler.lookup.class_67;
import org.eclipse.jdt.internal.compiler.lookup.class_83;
import org.eclipse.jdt.internal.compiler.lookup.class_86;

public abstract class class_89 implements class_17 {

    public int field_444;

    public int field_445;

    public int field_446;

    public class_89() {
        this.field_446 = Integer.MIN_VALUE;
    }

    private static int method_748(class_86 var0, class_126 var1, class_40 var2, class_40 var3, class_40 var4) {
        var1.method_911(var0, var2, var3);
        if (var3 != class_40.field_187 && var2.method_98() == 516) {
            class_45 var5 = (class_45)var2;
            if (var5.field_215 != 2) {
                return 2;
            }
        }
        class_40 var6 = var4 == null ? var2 : var4;
        if (var3 != var6 && var3.method_174(var6)) {
            var0.method_644().method_1806(var1, var3, var6);
            return 1;
        } else {
            return 0;
        }
    }

    public static void method_749(class_86 var0, class_126 var1, class_40 var2, class_58 var3, class_126[] var4, class_40[] var5, boolean var6, class_0 var7) {
        class_40[] var8 = var3.field_276;
        int var9 = var8.length;
        boolean var10 = !var3.method_370() && !var2.method_170() && var3.field_278.method_166() && var3.method_354();
        class_58 var11 = null;
        if (!var10 && var3 instanceof class_63) {
            class_63 var12 = (class_63)var3;
            if (var12.field_299 || var12.field_297 && var3.method_354()) {
                var11 = var3.method_376();
            }
        }
        int var19 = 0;
        if (var4 == null) {
            if (var3.method_374()) {
                class_40 var13 = ((class_42)var8[var9 - 1]).method_187();
                if (!var13.method_167()) {
                    var0.method_644().method_1801(var13, (class_89)var7);
                }
            }
        } else {
            int var20;
            if (var3.method_374()) {
                var20 = var9 - 1;
                int var14;
                class_40 var15;
                for (var14 = 0; var14 < var20; ++var14) {
                    var15 = var11 == null ? null : var11.field_276[var14];
                    var19 |= method_748(var0, var4[var14], var8[var14], var5[var14], var15);
                }
                var14 = var4.length;
                if (var20 < var14) {
                    var15 = var8[var20];
                    class_40 var16 = null;
                    if (var9 != var14 || var15.method_136() != var5[var20].method_136()) {
                        var15 = ((class_42)var15).method_187();
                        if (!var15.method_167()) {
                            var0.method_644().method_1801(var15, (class_89)var7);
                        }
                        var16 = var11 == null ? null : ((class_42)var11.field_276[var20]).method_187();
                    }
                    for (int var17 = var20; var17 < var14; ++var17) {
                        var19 |= method_748(var0, var4[var17], var15, var5[var17], var16);
                    }
                }
                if (var9 == var5.length) {
                    int var22 = var9 - 1;
                    class_42 var24 = (class_42)var8[var22];
                    class_40 var23 = var5[var22];
                    if (var23 == class_40.field_187) {
                        if (!var24.method_173().method_148() || var24.method_136() != 1) {
                            var0.method_644().method_1819(var3, var23, var7);
                        }
                    } else {
                        int var18;
                        if (var24.field_193 <= (var18 = var23.method_136())) {
                            if (var23.method_173().method_148()) {
                                --var18;
                            }
                            if (var24.field_193 < var18) {
                                var0.method_644().method_1819(var3, var23, var7);
                            } else if (var24.field_193 == var18 && var23 != var24 && var23.method_173().method_138() != var24.field_192.method_138() && var23.method_152(var24.method_187()) && var23.method_152(var24)) {
                                var0.method_644().method_1819(var3, var23, var7);
                            }
                        }
                    }
                }
            } else {
                for (var20 = 0; var20 < var9; ++var20) {
                    class_40 var21 = var11 == null ? null : var11.field_276[var20];
                    var19 |= method_748(var0, var4[var20], var8[var20], var5[var20], var21);
                }
            }
            if (var6) {
                class_130.method_937(var0, var1, var2, var3, var4, var5, var7);
            }
        }
        if ((var19 & 2) != 0) {
            var0.method_644().method_1825((class_89)var7, var2, var3, var5);
        } else if (!var3.method_370() && !var2.method_170() && var3.field_278.method_166() && var3.method_354()) {
            var0.method_644().method_1804((class_89)var7, var3);
        } else if (var11 != null) {
            var0.method_644().method_1803((class_89)var7, var3);
        }
    }

    public class_89 method_750() {
        return this;
    }

    public final boolean method_751(class_67 var1, class_83 var2, boolean var3) {
        if ((this.field_446 & '\u8000') == 0 && !var3 && (var1.method_428() || var1.field_314 != null && var1.field_314.method_158()) && !var2.method_625(var1)) {
            class_67 var10000 = var1.method_435();
            var10000.field_300 |= 134217728;
        }
        if ((var1.field_300 & 262144) != 0) {
            class_345 var4 = var2.method_586().method_503(var1.field_314.method_138());
            if (var4 != null) {
                var2.method_644().method_1553(var1, this, var4.field_1980, var4.field_1981, var4.method_3329());
            }
        }
        return !var1.method_434() ? false : (var2.method_627(var1.field_314) ? false : var2.method_577().field_1939 || !var2.method_630());
    }

    public boolean method_752() {
        return false;
    }

    public final boolean method_753(class_58 var1, class_83 var2, boolean var3) {
        if ((this.field_446 & '\u8000') == 0 && (var1.method_367() || var1.field_278.method_158()) && !var2.method_626(var1)) {
            class_58 var10000 = var1.method_376();
            var10000.field_273 |= 134217728;
        }
        if (var3 && (var1.field_273 & 262144) != 0) {
            class_345 var4 = var2.method_586().method_503(var1.field_278.method_138());
            if (var4 != null) {
                var2.method_644().method_1554(var1, this, var4.field_1980, var4.field_1981, var4.method_3329());
            }
        }
        return !var1.method_375() ? false : (var2.method_627(var1.field_278) ? false : (!var3 && (var1.field_273 & 1048576) == 0 ? false : var2.method_577().field_1939 || !var2.method_630()));
    }

    public boolean method_754() {
        return false;
    }

    public boolean method_755() {
        return false;
    }

    public final boolean method_756(class_40 var1, class_83 var2) {
        if (var1.method_147()) {
            var1 = ((class_42)var1).field_192;
        }
        if (var1.method_148()) {
            return false;
        } else {
            class_43 var3 = (class_43)var1;
            if ((this.field_446 & '\u8000') == 0 && (var3.method_223() || var3.method_158()) && !var2.method_628(var3)) {
                class_43 var10000 = (class_43)var3.method_138();
                var10000.field_199 |= 134217728;
            }
            if (var3.method_214()) {
                class_345 var4 = var2.method_586().method_503(var1.method_138());
                if (var4 != null) {
                    var2.method_644().method_1555(var1, this, var4.field_1980, var4.field_1981, var4.method_3329());
                }
            }
            var3.method_100();
            return !var3.method_230() ? false : (var2.method_627(var3) ? false : var2.method_577().field_1939 || !var2.method_630());
        }
    }

    public abstract StringBuffer method_757(int var1, StringBuffer var2);

    public static StringBuffer method_758(class_164[] var0, StringBuffer var1) {
        int var2 = var0.length;
        for (int var3 = 0; var3 < var2; ++var3) {
            var0[var3].method_757(0, var1);
            var1.append(" ");
        }
        return var1;
    }

    public static StringBuffer method_759(int var0, StringBuffer var1) {
        for (int var2 = var0; var2 > 0; --var2) {
            var1.append("  ");
        }
        return var1;
    }

    public static StringBuffer method_760(int var0, StringBuffer var1) {
        if ((var0 & 1) != 0) {
            var1.append("public ");
        }
        if ((var0 & 2) != 0) {
            var1.append("private ");
        }
        if ((var0 & 4) != 0) {
            var1.append("protected ");
        }
        if ((var0 & 8) != 0) {
            var1.append("static ");
        }
        if ((var0 & 16) != 0) {
            var1.append("final ");
        }
        if ((var0 & 32) != 0) {
            var1.append("synchronized ");
        }
        if ((var0 & 64) != 0) {
            var1.append("volatile ");
        }
        if ((var0 & 128) != 0) {
            var1.append("transient ");
        }
        if ((var0 & 256) != 0) {
            var1.append("native ");
        }
        if ((var0 & 1024) != 0) {
            var1.append("abstract ");
        }
        return var1;
    }

    public static void method_761(class_86 var0, class_164[] var1, class_34 var2) {
        class_203[] var3 = null;
        int var4 = var1 == null ? 0 : var1.length;
        class_67 var8;
        class_65 var9;
        if (var2 != null) {
            switch (var2.method_98()) {
                case 1:
                    var8 = (class_67)var2;
                    if ((var8.field_305 & 8589934592L) != 0L) {
                        return;
                    }
                    var8.field_305 |= 25769803776L;
                    if (var4 > 0) {
                        var3 = new class_203[var4];
                        var8.method_436(var3);
                    }
                    break;
                case 2:
                    var9 = (class_65)var2;
                    if ((var9.field_305 & 8589934592L) != 0L) {
                        return;
                    }
                    var9.field_305 |= 25769803776L;
                    if (var4 > 0) {
                        var3 = new class_203[var4];
                        var9.method_416(var3);
                    }
                    break;
                case 4:
                case 2052:
                    class_43 var6 = (class_43)var2;
                    if ((var6.field_178 & 8589934592L) != 0L) {
                        return;
                    }
                    var6.field_178 |= 25769803776L;
                    if (var4 > 0) {
                        var3 = new class_203[var4];
                        var6.method_236(var3);
                    }
                    break;
                case 8:
                    class_58 var7 = (class_58)var2;
                    if ((var7.field_281 & 8589934592L) != 0L) {
                        return;
                    }
                    var7.field_281 |= 25769803776L;
                    if (var4 > 0) {
                        var3 = new class_203[var4];
                        var7.method_377(var3);
                    }
                    break;
                case 16:
                    class_38 var5 = (class_38)var2;
                    if ((var5.field_170 & 8589934592L) != 0L) {
                        return;
                    }
                    var5.field_170 |= 25769803776L;
                    break;
                default:
                    return;
            }
        }
        if (var1 != null) {
            for (int var12 = 0; var12 < var4; ++var12) {
                class_164 var15 = var1[var12];
                class_34 var16 = var15.field_766;
                if (var16 != null && var2 != null) {
                    switch (var2.method_98()) {
                        case 1:
                            var8 = (class_67)var2;
                            var8.field_305 = ((class_67)var16).field_305;
                            break;
                        case 2:
                            var9 = (class_65)var2;
                            var9.field_305 = ((class_65)var16).field_305;
                    }
                    if (var3 != null) {
                        var3[0] = var15.method_1073();
                        for (int var18 = 1; var18 < var4; ++var18) {
                            class_164 var21 = var1[var18];
                            var3[var18] = var21.method_1073();
                        }
                    }
                    return;
                }
                var15.field_766 = var2;
                var15.method_925(var0);
                if (var3 != null) {
                    var3[var12] = var15.method_1073();
                }
            }
            if (var3 != null) {
                class_203[] var13 = var3;
                for (int var14 = 0; var14 < var4; ++var14) {
                    class_203 var17 = var13[var14];
                    if (var17 != null) {
                        class_43 var19 = var17.method_1182();
                        boolean var20 = false;
                        for (int var10 = var14 + 1; var10 < var4; ++var10) {
                            class_203 var11 = var13[var10];
                            if (var11 != null && var11.method_1182() == var19) {
                                var20 = true;
                                if (var13 == var3) {
                                    System.arraycopy(var13, 0, var13 = new class_203[var4], 0, var4);
                                }
                                var13[var10] = null;
                                var0.method_644().method_1518(var1[var10]);
                            }
                        }
                        if (var20) {
                            var0.method_644().method_1518(var1[var14]);
                        }
                    }
                }
            }
        }
    }

    public static void method_762(class_86 var0, class_164[] var1, class_34 var2) {
        if (var2 != null) {
            int var3 = var2.method_98();
            int var4;
            if (var1 != null && (var4 = var1.length) >= 0) {
                switch (var3) {
                    case 1:
                        class_67 var8 = (class_67)var2;
                        if ((var8.field_305 & 17179869184L) != 0L) {
                            return;
                        }
                        break;
                    case 2:
                        class_65 var9 = (class_65)var2;
                        if ((var9.field_305 & 17179869184L) != 0L) {
                            return;
                        }
                        break;
                    case 4:
                    case 2052:
                        class_43 var6 = (class_43)var2;
                        if ((var6.field_178 & 17179869184L) != 0L) {
                            return;
                        }
                        break;
                    case 8:
                        class_58 var7 = (class_58)var2;
                        if ((var7.field_281 & 17179869184L) != 0L) {
                            return;
                        }
                        break;
                    case 16:
                        class_38 var5 = (class_38)var2;
                        if ((var5.field_170 & 17179869184L) != 0L) {
                            return;
                        }
                        break;
                    default:
                        return;
                }
                for (int var14 = 0; var14 < var4; ++var14) {
                    class_146 var17 = var1[var14].field_767;
                    if (!CharOperation.method_1364(class_17.field_119[2], var17.method_1010())) {
                        return;
                    }
                    class_40 var18 = var1[var14].field_767.method_925(var0);
                    if (var18 != null && var18.method_101() && var18.field_177 == 44) {
                        switch (var3) {
                            case 1:
                                class_67 var11 = (class_67)var2;
                                var11.field_305 |= 70385924046848L;
                                return;
                            case 2:
                                class_65 var12 = (class_65)var2;
                                var12.field_305 |= 70385924046848L;
                                return;
                            case 4:
                            case 2052:
                            case 4100:
                                class_43 var22 = (class_43)var2;
                                var22.field_178 |= 70385924046848L;
                                return;
                            case 8:
                                class_58 var10 = (class_58)var2;
                                var10.field_281 |= 70385924046848L;
                                return;
                            case 16:
                                class_38 var21 = (class_38)var2;
                                var21.field_170 |= 70385924046848L;
                                return;
                            default:
                                return;
                        }
                    }
                }
            }
            switch (var3) {
                case 1:
                    class_67 var19 = (class_67)var2;
                    var19.field_305 |= 17179869184L;
                    return;
                case 2:
                    class_65 var20 = (class_65)var2;
                    var20.field_305 |= 17179869184L;
                    return;
                case 4:
                case 2052:
                case 4100:
                    class_43 var15 = (class_43)var2;
                    var15.field_178 |= 17179869184L;
                    return;
                case 8:
                    class_58 var16 = (class_58)var2;
                    var16.field_281 |= 17179869184L;
                    return;
                case 16:
                    class_38 var13 = (class_38)var2;
                    var13.field_170 |= 17179869184L;
                    return;
                default:
            }
        }
    }

    public int method_5() {
        return this.field_444;
    }

    public int method_6() {
        return this.field_445;
    }

    public String toString() {
        return this.method_757(0, new StringBuffer(30)).toString();
    }

    public void method_763(class_264 var1, class_86 var2) {}
}
