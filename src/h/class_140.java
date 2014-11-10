package h;

import a.class_331;
import a.class_340;
import c.class_264;
import h.class_126;
import h.class_130;
import h.class_137;
import i.class_268;
import i.class_74;
import l.class_293;
import l.class_301;
import m.class_40;
import m.class_86;

public class class_140 extends class_137 {

    public class_126 field_713;

    public class_331 field_714;

    public class_140(class_126 var1, int var2) {
        this.field_713 = var1;
        this.field_446 |= var2 << 6;
    }

    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        this.field_713.method_909(var1, var2, var3);
        return (this.field_446 & 4032) >> 6 == 11 ? this.field_713.method_814(var1, var2, var3).method_3073() : this.field_713.method_814(var1, var2, var3);
    }

    public class_331 method_922() {
        return this.field_714 == null ? this.field_672 : this.field_714;
    }

    public void method_912(class_86 var1, class_268 var2, boolean var3) {
        int var4 = var2.field_1208;
        if (this.field_672 != class_331.field_1896) {
            if (var3) {
                var2.method_2179(this.field_672, this.field_674);
            }
            var2.method_2360(var4, this.field_444);
        } else {
            label63:
            switch ((this.field_446 & 4032) >> 6) {
                case 11:
                    switch ((this.field_713.field_674 & 255) >> 4) {
                        case 5:
                            class_126 var10000 = this.field_713;
                            class_74 var10004 = new class_74(var2);
                            class_74 var5 = var10004;
                            var10000.method_913(var1, var2, (class_74)null, var10004, var3);
                            if (var3) {
                                var2.method_2221();
                                if (var5.method_454() > 0) {
                                    class_74 var10001 = new class_74(var2);
                                    class_74 var6 = var10001;
                                    var2.method_2209(var10001);
                                    var2.method_2125(1);
                                    var5.method_458();
                                    var2.method_2222();
                                    var6.method_458();
                                }
                            } else {
                                var5.method_458();
                            }
                        default:
                            break label63;
                    }
                case 12:
                    switch ((this.field_713.field_674 & 255) >> 4) {
                        case 7:
                            this.field_713.method_912(var1, var2, var3);
                            if (var3) {
                                var2.method_2314(-1L);
                                var2.method_2339();
                            }
                            break label63;
                        case 10:
                            this.field_713.method_912(var1, var2, var3);
                            if (var3) {
                                var2.method_2227();
                                var2.method_2296();
                            }
                        default:
                            break label63;
                    }
                case 13:
                    if (this.field_672 != class_331.field_1896) {
                        if (var3) {
                            switch ((this.field_713.field_674 & 255) >> 4) {
                                case 7:
                                    var2.method_2189(this.field_672.method_3285() * -1L);
                                    break label63;
                                case 8:
                                    var2.method_2186(this.field_672.method_3281() * -1.0D);
                                    break label63;
                                case 9:
                                    var2.method_2187(this.field_672.method_3282() * -1.0F);
                                    break label63;
                                case 10:
                                    var2.method_2188(this.field_672.method_3284() * -1);
                            }
                        }
                    } else {
                        this.field_713.method_912(var1, var2, var3);
                        if (var3) {
                            switch ((this.field_713.field_674 & 255) >> 4) {
                                case 7:
                                    var2.method_2323();
                                    break label63;
                                case 8:
                                    var2.method_2132();
                                    break label63;
                                case 9:
                                    var2.method_2167();
                                    break label63;
                                case 10:
                                    var2.method_2253();
                            }
                        }
                    }
                    break;
                case 14:
                    this.field_713.method_912(var1, var2, var3);
            }
            if (var3) {
                var2.method_2182(this.field_674);
            }
            var2.method_2360(var4, this.field_444);
        }
    }

    public void method_913(class_86 var1, class_268 var2, class_74 var3, class_74 var4, boolean var5) {
        if (this.field_672 != class_331.field_1896 && this.field_672.method_3288() == 5) {
            super.method_913(var1, var2, var3, var4, var5);
        } else {
            if ((this.field_446 & 4032) >> 6 == 11) {
                this.field_713.method_913(var1, var2, var4, var3, var5);
            } else {
                super.method_913(var1, var2, var3, var4, var5);
            }
        }
    }

    public StringBuffer method_975(int var1, StringBuffer var2) {
        var2.append(this.method_974()).append(' ');
        return this.field_713.method_924(0, var2);
    }

    public class_40 method_925(class_86 var1) {
        boolean var2;
        if (var2 = this.field_713 instanceof class_130) {
            this.field_713.field_446 |= 32;
        }
        class_40 var3 = this.field_713.method_925(var1);
        if (var3 == null) {
            this.field_672 = class_331.field_1896;
            return null;
        } else {
            int var4 = var3.field_177;
            boolean var5 = var1.method_577().field_1928 >= 3211264L;
            if (var5 && !var3.method_148()) {
                var4 = var1.method_586().method_486(var3).field_177;
            }
            if (var4 > 15) {
                this.field_672 = class_331.field_1896;
                var1.method_644().method_1636(this, var3);
                return null;
            } else {
                byte var6;
                switch ((this.field_446 & 4032) >> 6) {
                    case 11:
                        var6 = 0;
                        break;
                    case 12:
                        var6 = 10;
                        break;
                    default:
                        var6 = 13;
                }
                int var7 = field_701[var6][(var4 << 4) + var4];
                this.field_713.method_911(var1, class_40.method_128(var1, var7 >>> 16 & 15), var3);
                this.field_446 |= var7 & 15;
                switch (var7 & 15) {
                    case 2:
                        this.field_675 = class_40.field_182;
                        break;
                    case 3:
                        this.field_675 = class_40.field_180;
                        break;
                    case 4:
                    case 6:
                    default:
                        this.field_672 = class_331.field_1896;
                        if (var4 != 0) {
                            var1.method_644().method_1636(this, var3);
                        }
                        return null;
                    case 5:
                        this.field_675 = class_40.field_186;
                        break;
                    case 7:
                        this.field_675 = class_40.field_183;
                        break;
                    case 8:
                        this.field_675 = class_40.field_185;
                        break;
                    case 9:
                        this.field_675 = class_40.field_184;
                        break;
                    case 10:
                        this.field_675 = class_40.field_179;
                }
                if (this.field_713.field_672 != class_331.field_1896) {
                    this.field_672 = class_331.method_3261(this.field_713.field_672, var4, (this.field_446 & 4032) >> 6);
                } else {
                    this.field_672 = class_331.field_1896;
                    if ((this.field_446 & 4032) >> 6 == 11) {
                        class_331 var8 = this.field_713.method_922();
                        if (var8 != class_331.field_1896) {
                            this.field_714 = class_340.method_3307(!var8.method_3257());
                        }
                    }
                }
                if (var2) {
                    class_130.method_936(var1, var6, var7, this.field_713, var4);
                }
                return this.field_675;
            }
        }
    }

    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2070(this, var2)) {
            this.field_713.method_763(var1, var2);
        }
        var1.method_1985(this, var2);
    }
}
