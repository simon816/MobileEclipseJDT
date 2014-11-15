package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.class_264;
import org.eclipse.jdt.internal.compiler.ast.class_126;
import org.eclipse.jdt.internal.compiler.ast.class_137;
import org.eclipse.jdt.internal.compiler.ast.class_146;
import org.eclipse.jdt.internal.compiler.ast.class_161;
import org.eclipse.jdt.internal.compiler.ast.class_168;
import org.eclipse.jdt.internal.compiler.ast.class_250;
import org.eclipse.jdt.internal.compiler.codegen.class_268;
import org.eclipse.jdt.internal.compiler.flow.class_293;
import org.eclipse.jdt.internal.compiler.flow.class_301;
import org.eclipse.jdt.internal.compiler.impl.class_331;
import org.eclipse.jdt.internal.compiler.lookup.InvocationSite;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.class_42;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.class_52;
import org.eclipse.jdt.internal.compiler.lookup.class_58;
import org.eclipse.jdt.internal.compiler.lookup.class_63;
import org.eclipse.jdt.internal.compiler.lookup.class_65;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;
import org.eclipse.jdt.internal.compiler.lookup.class_83;
import org.eclipse.jdt.internal.compiler.lookup.class_86;

public class class_130 extends class_126 {

    public class_126 field_684;

    public class_126 field_685;

    public class_40 field_686;

    public class_130(class_126 var1, class_126 var2) {
        this.field_684 = var1;
        this.field_685 = var2;
        var2.field_446 |= 1073741824;
    }

    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        return this.field_684.method_814(var1, var2, var3).method_3109();
    }

    public static void method_933(class_86 var0, class_40 var1, class_130 var2) {
        if (var0.method_577().method_3313(67108864L) != -1) {
            class_40 var3 = var2.field_684.field_675;
            if (var3 != null && !var2.field_675.method_148()) {
                if (var3.method_152(var1)) {
                    var0.method_644().method_1790(var2);
                }
            }
        }
    }

    public static void method_934(class_86 var0, class_130 var1) {
        if (var0.method_577().method_3313(67108864L) != -1) {
            class_130 var2 = (class_130)var1.field_684;
            if ((var2.field_446 & 16384) != 0) {
                class_130 var10000 = new class_130((class_126)null, var1.field_685);
                class_130 var3 = var10000;
                var3.field_675 = var1.field_675;
                if (var3.method_908(var0, var1.field_675, var2.field_684.field_675, var2.field_684)) {
                    var0.method_644().method_1790(var2);
                }
            }
        }
    }

    public static void method_935(class_86 var0, class_126 var1, class_40 var2, class_40 var3) {
        if (var0.method_577().method_3313(67108864L) != -1) {
            class_40 var4 = ((class_130)var1).field_684.field_675;
            if (var4 != null) {
                if (var4 == var2) {
                    var0.method_644().method_1790((class_130)var1);
                } else {
                    if (var4 == class_40.field_187) {
                        return;
                    }
                    if (var4.method_148() || var4.method_147()) {
                        return;
                    }
                    if (var3 == var0.method_613(var3.method_179(), (ReferenceBinding)var4)) {
                        var0.method_644().method_1790((class_130)var1);
                    }
                }
            }
        }
    }

    public static void method_936(class_86 var0, int var1, int var2, class_126 var3, int var4) {
        if (var0.method_577().method_3313(67108864L) != -1) {
            if ((var3.field_446 & 16384) != 0 || !var3.field_675.method_148()) {
                class_40 var6 = ((class_130)var3).field_684.field_675;
                if (var6 != null) {
                    int var5 = var6.field_177;
                    if (var6.field_177 == var4) {
                        var0.method_644().method_1790((class_130)var3);
                    } else if (var5 != 12) {
                        ;
                    }
                }
            }
        }
    }

    public static void method_937(class_86 var0, class_126 var1, class_40 var2, class_58 var3, class_126[] var4, class_40[] var5, InvocationSite var6) {
        if (var0.method_577().method_3313(67108864L) != -1) {
            int var7 = var5.length;
            class_40[] var8 = var5;
            for (int var9 = 0; var9 < var7; ++var9) {
                class_126 var10 = var4[var9];
                if (var10 instanceof class_130 && ((var10.field_446 & 16384) != 0 || !var10.field_675.method_148())) {
                    class_40 var11 = ((class_130)var10).field_684.field_675;
                    if (var11 == null) {
                        return;
                    }
                    if (var11 == var5[var9]) {
                        var0.method_644().method_1790((class_130)var10);
                    } else if (var11 != class_40.field_187 && (var10.field_674 & 512) == 0) {
                        if (var8 == var5) {
                            System.arraycopy(var8, 0, var8 = new class_40[var7], 0, var7);
                        }
                        var8[var9] = var11;
                    }
                }
            }
            if (var8 != var5) {
                method_939(var0, var1, var2, var3, var4, var5, var8, var6);
            }
        }
    }

    public static void method_938(class_86 var0, int var1, int var2, class_126 var3, int var4, boolean var5, class_126 var6, int var7, boolean var8) {
        if (var0.method_577().method_3313(67108864L) != -1) {
            int var9 = var4;
            if (var5) {
                if ((var3.field_446 & 16384) == 0 && var3.field_675.method_148()) {
                    var5 = false;
                } else {
                    class_40 var10 = ((class_130)var3).field_684.field_675;
                    if (var10 == null) {
                        return;
                    }
                    var9 = var10.field_177;
                    if (var10.field_177 == var4) {
                        var0.method_644().method_1790((class_130)var3);
                        var5 = false;
                    } else if (var9 == 12) {
                        var9 = var4;
                        var5 = false;
                    }
                }
            }
            int var13 = var7;
            if (var8) {
                if ((var6.field_446 & 16384) == 0 && var6.field_675.method_148()) {
                    var8 = false;
                } else {
                    class_40 var11 = ((class_130)var6).field_684.field_675;
                    if (var11 == null) {
                        return;
                    }
                    var13 = var11.field_177;
                    if (var11.field_177 == var7) {
                        var0.method_644().method_1790((class_130)var6);
                        var8 = false;
                    } else if (var13 == 12) {
                        var13 = var7;
                        var8 = false;
                    }
                }
            }
            if (var5 || var8) {
                if (var9 > 15 || var13 > 15) {
                    if (var9 == 11) {
                        var13 = 1;
                    } else {
                        if (var13 != 11) {
                            return;
                        }
                        var9 = 1;
                    }
                }
                int var12 = class_137.field_701[var1][(var9 << 4) + var13];
                if ((var2 & 986895) == (var12 & 986895)) {
                    if (var5) {
                        var0.method_644().method_1790((class_130)var3);
                    }
                    if (var8) {
                        var0.method_644().method_1790((class_130)var6);
                    }
                }
            }
        }
    }

    private static void method_939(class_86 var0, class_126 var1, class_40 var2, class_58 var3, class_126[] var4, class_40[] var5, class_40[] var6, InvocationSite var7) {
        class_250 var10000 = new class_250(var7);
        class_250 var8 = var10000;
        class_58 var9;
        if (var3.method_358()) {
            var9 = var0.method_599((ReferenceBinding)var2, var6, var8);
        } else {
            if (var1.method_752()) {
                var9 = var0.method_602(var3.field_274, var6, var8);
            } else {
                try {
                    var9 = var0.method_614(var2, var3.field_274, var6, var8);
                } catch (Throwable e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
        if (var9 == var3) {
            int var10 = var5.length;
            int var11;
            if (var3.method_374()) {
                var11 = var3.field_276.length;
                if (var11 == var10) {
                    int var12 = var11 - 1;
                    class_42 var13 = (class_42)var3.field_276[var12];
                    class_40 var14 = var6[var12];
                    if (var13.field_193 != var14.method_136()) {
                        return;
                    }
                    if (var14.method_152(var13.method_187()) && var14.method_152(var13)) {
                        return;
                    }
                }
            }
            for (var11 = 0; var11 < var10; ++var11) {
                if (var5[var11] != var6[var11]) {
                    var0.method_644().method_1790((class_130)var4[var11]);
                }
            }
        }
    }

    public boolean method_910(class_83 var1, class_40 var2, class_40 var3, class_40 var4, boolean var5) {
        if (var4 == var2) {
            if (!var5 && var4 == this.field_675.method_173()) {
                this.method_930(var1, var2);
            }
            return true;
        } else {
            if (var4 != null) {
                label97: {
                    if (var5) {
                        if (!var4.method_164(var3)) {
                            break label97;
                        }
                    } else if (!var2.method_164(var4)) {
                        break label97;
                    }
                    return false;
                }
            }
            switch (var2.method_98()) {
                case 68:
                    class_40 var14 = var2.method_173();
                    if (var5 && (var14.method_149() || var14.method_169())) {
                        this.field_446 |= 128;
                        return true;
                    }
                    break;
                case 260:
                    if (var2.method_149()) {
                        if (var4 == null) {
                            this.field_446 |= 128;
                            return true;
                        }
                        switch (var4.method_98()) {
                            case 260:
                                if (var5) {
                                    if (!var3.method_166() && var3.method_154(var4)) {
                                        class_52 var6 = (class_52)var2;
                                        class_52 var7 = (class_52)var4;
                                        class_40[] var8 = var6.field_243;
                                        int var9 = var8.length;
                                        if (var7.field_243 != null && var9 <= var7.field_243.length) {
                                            if ((var6.field_178 & 1610612736L) != 0L) {
                                                int var10 = 0;
                                                while (var10 < var9) {
                                                    switch (var8[var10].method_98()) {
                                                        case 516:
                                                        case 4100:
                                                            class_40[] var11;
                                                            System.arraycopy(var6.field_243, 0, var11 = new class_40[var9], 0, var9);
                                                            var11[var10] = var1.method_609();
                                                            LookupEnvironment var12 = var1.method_586();
                                                            class_52 var13 = var12.method_500((ReferenceBinding)var2.method_138(), var11, var2.method_137());
                                                            if (var13.method_140(var3) == var4) {
                                                                this.field_446 |= 128;
                                                                return true;
                                                            }
                                                        default:
                                                            ++var10;
                                                    }
                                                }
                                            }
                                        } else {
                                            this.field_446 |= 128;
                                        }
                                        return true;
                                    }
                                    this.field_446 |= 128;
                                    return true;
                                }
                                if (!var4.method_154(var2)) {
                                    this.field_446 |= 128;
                                    return true;
                                }
                                break;
                            case 1028:
                                this.field_446 |= 128;
                                return true;
                            default:
                                if (var5) {
                                    this.field_446 |= 128;
                                    return true;
                                }
                        }
                    }
                    break;
                case 4100:
                    this.field_446 |= 128;
                    return true;
            }
            if (!var5 && var4 == this.field_675.method_173()) {
                this.method_930(var1, var2);
            }
            return true;
        }
    }

    public void method_912(class_86 var1, class_268 var2, boolean var3) {
        int var4 = var2.field_1208;
        boolean var5 = (this.field_446 & 64) != 0;
        if (this.field_672 != class_331.field_1896) {
            if (var3 || var5) {
                var2.method_2179(this.field_672, this.field_674);
                if (var5) {
                    var2.method_2113(this.field_675);
                }
                if (!var3) {
                    var2.method_2352();
                }
            }
            var2.method_2360(var4, this.field_444);
        } else {
            this.field_684.method_912(var1, var2, var3 || var5);
            if (var5 && this.field_684.method_923(var1) != this.field_675.method_138()) {
                var2.method_2113(this.field_675);
            }
            if (var3) {
                var2.method_2182(this.field_674);
            } else if (var5) {
                var2.method_2352();
            }
            var2.method_2360(var4, this.field_444);
        }
    }

    public class_126 method_940() {
        class_126 var1;
        for (var1 = this.field_684; var1 instanceof class_130; var1 = ((class_130)var1).field_684) {
            ;
        }
        return var1;
    }

    public class_65 method_920() {
        return this.field_684.method_920();
    }

    public int method_921(class_301 var1) {
        return this.field_684.method_921(var1);
    }

    public class_331 method_922() {
        switch (this.field_675.field_177) {
            case 5:
            case 33:
                return this.field_684.method_922();
            default:
                return class_331.field_1896;
        }
    }

    public StringBuffer method_924(int var1, StringBuffer var2) {
        var2.append('(');
        this.field_685.method_757(0, var2).append(") ");
        return this.field_684.method_924(0, var2);
    }

    public class_40 method_925(class_86 var1) {
        this.field_672 = class_331.field_1896;
        this.field_674 = 0;
        if (!(this.field_685 instanceof class_146) && (!(this.field_685 instanceof class_161) || (this.field_685.field_446 & 534773760) >> 21 != 0)) {
            class_40 var6 = this.field_684.method_925(var1);
            if (var6 == null) {
                return null;
            } else {
                var1.method_644().method_1641(this.field_685);
                return null;
            }
        } else {
            boolean var2 = false;
            class_40 var3 = this.field_675 = this.field_685.method_925(var1);
            if (this.field_684 instanceof class_130) {
                this.field_684.field_446 |= 32;
                var2 = true;
            }
            class_40 var4 = this.field_684.method_925(var1);
            if (var3 != null) {
                if (var4 != null) {
                    boolean var5 = this.method_908(var1, var3, var4, this.field_684);
                    if (var5) {
                        this.field_684.method_911(var1, var3, var4);
                        if ((this.field_446 & 128) != 0) {
                            var1.method_644().method_1800(this, var1);
                        } else {
                            if (var3.method_166() && var1.method_577().method_3313(35184372088832L) != -1) {
                                var1.method_644().method_1742(this.field_685, var3);
                            }
                            if ((this.field_446 & 16416) == 16384 && !this.method_941()) {
                                var1.method_644().method_1790(this);
                            }
                        }
                    } else {
                        if ((var3.field_178 & 128L) == 0L) {
                            var1.method_644().method_1771(this, var3, var4);
                        }
                        this.field_446 |= 32;
                    }
                }
                this.field_675 = var3.method_130(var1, this.field_445);
                if (var2) {
                    method_934(var1, this);
                }
            }
            return this.field_675;
        }
    }

    public void method_928(class_40 var1) {
        this.field_686 = var1;
    }

    private boolean method_941() {
        if (this.field_684 instanceof class_168) {
            class_58 var1 = ((class_168)this.field_684).field_775;
            if (var1 instanceof class_63 && ((class_63)var1).field_295) {
                if (this.field_686 == null) {
                    return true;
                }
                if (this.field_675 != this.field_686) {
                    return true;
                }
            }
        }
        return this.field_686 != null && this.field_675.method_148() && !this.field_675.method_152(this.field_686);
    }

    public void method_929() {
        this.field_446 |= 64;
    }

    public void method_930(class_83 var1, class_40 var2) {
        this.field_446 |= 16384;
    }

    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2006(this, var2)) {
            this.field_685.method_763(var1, var2);
            this.field_684.method_763(var1, var2);
        }
        var1.method_1921(this, var2);
    }
}
