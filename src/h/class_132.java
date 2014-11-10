package h;

import a.class_331;
import c.class_264;
import h.class_126;
import h.class_131;
import h.class_137;
import h.class_154;
import i.class_268;
import l.class_293;
import l.class_301;
import m.class_40;
import m.class_80;
import m.class_86;

public class class_132 extends class_131 {

    public int field_689;

    public int field_690;

    public class_132(class_126 var1, class_126 var2, int var3, int var4) {
        super(var1, var2, var4);
        var1.field_446 &= -8193;
        var1.field_446 |= 65536;
        this.field_689 = var3;
    }

    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        if (this.field_675.field_177 != 11) {
            this.field_687.method_909(var1, var2, var3);
        }
        return ((class_154)this.field_687).method_1035(var1, var2, var3, this, true).method_3109();
    }

    public void method_912(class_86 var1, class_268 var2, boolean var3) {
        int var4 = var2.field_1208;
        ((class_154)this.field_687).method_1039(var1, var2, this.field_688, this.field_689, this.field_690, var3);
        if (var3) {
            var2.method_2182(this.field_674);
        }
        var2.method_2360(var4, this.field_444);
    }

    public int method_921(class_301 var1) {
        return -1;
    }

    public String method_948() {
        switch (this.field_689) {
            case 2:
                return "&=";
            case 3:
                return "|=";
            case 4:
            case 5:
            case 6:
            case 7:
            case 11:
            case 12:
            case 18:
            default:
                return "unknown operator";
            case 8:
                return "^=";
            case 9:
                return "/=";
            case 10:
                return "<<=";
            case 13:
                return "-=";
            case 14:
                return "+=";
            case 15:
                return "*=";
            case 16:
                return "%=";
            case 17:
                return ">>=";
            case 19:
                return ">>>=";
        }
    }

    public StringBuffer method_946(int var1, StringBuffer var2) {
        this.field_687.method_924(var1, var2).append(' ').append(this.method_948()).append(' ');
        return this.field_688.method_924(0, var2);
    }

    public class_40 method_925(class_86 var1) {
        this.field_672 = class_331.field_1896;
        if (this.field_687 instanceof class_154 && !this.field_687.method_755()) {
            class_40 var2 = this.field_687.method_925(var1);
            class_40 var3 = this.field_688.method_925(var1);
            if (var2 != null && var3 != null) {
                class_80 var4 = var1.method_586();
                class_40 var5 = var2;
                class_40 var6 = var3;
                boolean var7 = var1.method_577().field_1928 >= 3211264L;
                boolean var8 = false;
                if (var7) {
                    if (!var2.method_148() && var3.field_177 != 11 && var3.field_177 != 12) {
                        class_40 var9 = var4.method_486(var2);
                        if (var9 != var2) {
                            var5 = var9;
                            var8 = true;
                        }
                    }
                    if (!var3.method_148() && var5.field_177 != 11 && var5.field_177 != 12) {
                        var6 = var4.method_486(var3);
                    }
                }
                if (this.method_949() && !var5.method_161()) {
                    var1.method_644().method_1714(this, var5, var6);
                    return null;
                } else {
                    int var12 = var5.field_177;
                    int var10 = var6.field_177;
                    if (var12 > 15 || var10 > 15) {
                        if (var12 != 11) {
                            var1.method_644().method_1635(this, var5, var6);
                            return null;
                        }
                        var10 = 1;
                    }
                    int var11 = class_137.field_701[this.field_689][(var12 << 4) + var10];
                    if (var11 == 0) {
                        var1.method_644().method_1635(this, var5, var6);
                        return null;
                    } else {
                        if (this.field_689 == 14) {
                            if (var12 == 1) {
                                var1.method_644().method_1635(this, var5, var6);
                                return null;
                            }
                            if ((var5.method_161() || var12 == 5) && !var6.method_161()) {
                                var1.method_644().method_1635(this, var5, var6);
                                return null;
                            }
                        }
                        this.field_687.method_911(var1, class_40.method_128(var1, var11 >>> 16 & 15), var2);
                        this.field_688.method_911(var1, class_40.method_128(var1, var11 >>> 8 & 15), var3);
                        this.field_690 = (var8 ? 512 : 0) | var12 << 4 | var11 & 15;
                        if (var8) {
                            var1.method_644().method_1485(this, var5, var2);
                        }
                        return this.field_675 = var2;
                    }
                }
            } else {
                return null;
            }
        } else {
            var1.method_644().method_1547(this.field_687);
            return null;
        }
    }

    public boolean method_949() {
        return false;
    }

    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2010(this, var2)) {
            this.field_687.method_763(var1, var2);
            this.field_688.method_763(var1, var2);
        }
        var1.method_1925(this, var2);
    }
}
