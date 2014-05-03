package h;

import a.class_331;
import c.class_264;
import h.class_126;
import h.class_127;
import h.class_128;
import h.class_129;
import h.class_161;
import h.class_164;
import h.class_176;
import h.class_89;
import m.class_320;
import m.class_34;
import m.class_40;
import m.class_41;
import m.class_58;
import m.class_67;
import m.class_86;

// $FF: renamed from: h.ak
public class class_92 extends class_89 {

    // $FF: renamed from: a char[]
    public char[] field_474;
    // $FF: renamed from: a h.r
    public class_126 field_475;
    // $FF: renamed from: a m.ae
    public class_58 field_476;
    // $FF: renamed from: a m.c
    public class_320 field_477;

    // $FF: renamed from: <init> (char[], int, int, h.r) void
    public class_92(char[] var1, int var2, int var3, class_126 var4) {
        this.field_477 = null;
        this.field_474 = var1;
        this.field_444 = var2;
        this.field_445 = var3;
        this.field_475 = var4;
        if (var4 instanceof class_128) {
            var4.field_446 |= 1;
        }
    }

    // $FF: renamed from: a (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_757(int var1, StringBuffer var2) {
        var2.append(this.field_474).append(" = ");
        this.field_475.method_757(0, var2);
        return var2;
    }

    // $FF: renamed from: a (m.v, m.s) void
    public void method_784(class_86 var1, class_40 var2) {
        class_320 var10001;
        if (this.field_475 == null) {
            var10001 = new class_320(this.field_474, this.field_475, this.field_476);
            this.field_477 = var10001;
        } else if (var2 == null) {
            if (this.field_475 instanceof class_128) {
                this.field_475.method_926(var1, (class_40)null);
            } else {
                this.field_475.method_925(var1);
            }
            var10001 = new class_320(this.field_474, this.field_475, this.field_476);
            this.field_477 = var10001;
        } else {
            this.field_475.method_928(var2);
            class_40 var3;
            if (this.field_475 instanceof class_128) {
                class_128 var4 = (class_128)this.field_475;
                var3 = var4.method_926(var1, this.field_476.field_275);
            } else if (this.field_475 instanceof class_127) {
                var1.method_644().method_1475(this.field_476.field_278, this.field_474, this.field_475);
                this.field_475.method_925(var1);
                var3 = null;
            } else {
                var3 = this.field_475.method_925(var1);
            }
            var10001 = new class_320(this.field_474, this.field_475, this.field_476);
            this.field_477 = var10001;
            if (var3 != null) {
                class_40 var13 = var2.method_173();
                if (!this.field_475.method_919(var3, var2) && (!var2.method_148() || !class_41.method_185(var2.field_177, var3.field_177)) && !var3.method_152(var2)) {
                    if ((!var2.method_147() || var2.method_136() != 1 || !this.field_475.method_919(var3, var13) && (!var13.method_148() || !class_41.method_185(var13.field_177, var3.field_177))) && !var3.method_152(var13)) {
                        if (var13.method_145() && !var3.method_145()) {
                            var1.method_644().method_1474(this.field_476.field_278, this.field_474, this.field_475, var13);
                        } else {
                            var1.method_644().method_1777(var3, var2, this.field_475, (class_89)null);
                        }
                        return;
                    }
                } else {
                    var1.method_576().method_692(var2.method_173(), var3.method_173());
                    this.field_475.method_911(var1, var2, var3);
                }
                class_128 var5;
                class_126[] var6;
                int var7;
                int var8;
                class_126 var9;
                switch (var13.method_138().field_177) {
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                        if (this.field_475 instanceof class_128) {
                            var5 = (class_128)this.field_475;
                            var6 = var5.field_679;
                            if (var6 != null) {
                                var7 = 0;
                                for (var8 = var6.length; var7 < var8; ++var7) {
                                    var9 = var6[var7];
                                    if (var9.field_675 != null && var9.field_672 == class_331.field_1896) {
                                        var1.method_644().method_1477(this.field_476.field_278, this.field_474, var6[var7], false);
                                    }
                                }
                            }
                        } else if (this.field_475.field_672 == class_331.field_1896) {
                            if (var3.method_147()) {
                                var1.method_644().method_1475(this.field_476.field_278, this.field_474, this.field_475);
                            } else {
                                var1.method_644().method_1477(this.field_476.field_278, this.field_474, this.field_475, false);
                            }
                        }
                        break;
                    case 6:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    default:
                        if (var13.method_153()) {
                            if (this.field_475 instanceof class_176) {
                                var1.method_644().method_1477(this.field_476.field_278, this.field_474, this.field_475, true);
                            } else if (this.field_475 instanceof class_128) {
                                var5 = (class_128)this.field_475;
                                var6 = var5.field_679;
                                if (var6 != null) {
                                    var7 = 0;
                                    for (var8 = var6.length; var7 < var8; ++var7) {
                                        var9 = var6[var7];
                                        if (var9 instanceof class_176) {
                                            var1.method_644().method_1477(this.field_476.field_278, this.field_474, var9, true);
                                        } else if (var9 instanceof class_161) {
                                            class_161 var10 = (class_161)var9;
                                            class_34 var11 = var10.field_748;
                                            if (var11.method_98() == 1) {
                                                class_67 var12 = (class_67)var11;
                                                if (!var12.field_314.method_153()) {
                                                    var1.method_644().method_1477(this.field_476.field_278, this.field_474, var9, true);
                                                }
                                            }
                                        }
                                    }
                                }
                            } else if (this.field_475 instanceof class_161) {
                                class_161 var14 = (class_161)this.field_475;
                                class_34 var15 = var14.field_748;
                                if (var15.method_98() == 1) {
                                    class_67 var16 = (class_67)var15;
                                    if (!var16.field_314.method_153()) {
                                        if (!var16.field_301.method_147()) {
                                            var1.method_644().method_1477(this.field_476.field_278, this.field_474, this.field_475, true);
                                        } else {
                                            var1.method_644().method_1475(this.field_476.field_278, this.field_474, this.field_475);
                                        }
                                    }
                                }
                            }
                        } else if (var13.method_145()) {
                            if (!var3.method_173().method_145()) {
                                var1.method_644().method_1474(this.field_476.field_278, this.field_474, this.field_475, var13);
                            } else if (this.field_475 instanceof class_128) {
                                var5 = (class_128)this.field_475;
                                var6 = var5.field_679;
                                if (var6 != null) {
                                    var7 = 0;
                                    for (var8 = var6.length; var7 < var8; ++var7) {
                                        var9 = var6[var7];
                                        if (var9 instanceof class_176 || !(var9 instanceof class_164)) {
                                            var1.method_644().method_1474(this.field_476.field_278, this.field_474, var9, var13);
                                        }
                                    }
                                }
                            } else if (!(this.field_475 instanceof class_164)) {
                                var1.method_644().method_1474(this.field_476.field_278, this.field_474, this.field_475, var13);
                            }
                        }
                        break;
                    case 16:
                        if (this.field_475 instanceof class_128) {
                            var5 = (class_128)this.field_475;
                            var6 = var5.field_679;
                            if (var6 != null) {
                                var7 = 0;
                                for (var8 = var6.length; var7 < var8; ++var7) {
                                    var9 = var6[var7];
                                    if (!(var9 instanceof class_129)) {
                                        var1.method_644().method_1476(this.field_476.field_278, this.field_474, var9);
                                    }
                                }
                            }
                        } else if (!(this.field_475 instanceof class_129)) {
                            var1.method_644().method_1476(this.field_476.field_278, this.field_474, this.field_475);
                        }
                }
            }
        }
    }

    // $FF: renamed from: a (c.j, m.v) void
    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2034(this, var2) && this.field_475 != null) {
            this.field_475.method_763(var1, var2);
        }
        var1.method_1949(this, var2);
    }
}
