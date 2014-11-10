package h;

import a.class_341;
import b.class_233;
import c.class_264;
import c.class_284;
import h.class_114;
import h.class_123;
import h.class_146;
import h.class_90;
import h.class_93;
import h.class_98;
import j.class_278;
import l.class_298;
import l.class_299;
import l.class_301;
import m.class_17;
import m.class_40;
import m.class_84;
import n.class_244;

public class class_96 extends class_93 {

    public class_146 field_497;

    public class_123[] field_498;

    public class_96(class_284 var1) {
        super(var1);
    }

    public void method_786(class_84 var1, class_299 var2, class_301 var3) {
        if (!this.field_489) {
            try {
                if (this.field_488 == null) {
                    return;
                }
                if (!this.field_488.method_373() && (this.field_488.method_367() || (this.field_488.field_273 & 805306368) == 0 && this.field_488.field_278.method_158()) && !var1.method_645().field_455.field_1692) {
                    this.field_478.method_644().method_1814(this);
                }
                if (this.field_488.field_278.method_153() && (this.field_479 == class_17.field_71 || this.field_479 == class_17.field_72)) {
                    return;
                }
                if (this.field_488.method_356() || this.field_488.method_365()) {
                    return;
                }
                class_298 var10000 = new class_298(var2, this, this.field_488.field_277, this.field_478, class_301.field_1784);
                class_298 var4 = var10000;
                int var6;
                if (this.field_484 != null) {
                    int var5 = 0;
                    for (var6 = this.field_484.length; var5 < var6; ++var5) {
                        var3.method_3099(this.field_484[var5].field_670);
                    }
                }
                if (this.field_486 != null) {
                    boolean var10 = false;
                    var6 = 0;
                    for (int var7 = this.field_486.length; var6 < var7; ++var6) {
                        class_98 var8 = this.field_486[var6];
                        if (!var8.method_816(var3, this.field_478, var10)) {
                            var3 = var8.method_814(this.field_478, var4, var3);
                        } else {
                            var10 = true;
                        }
                    }
                }
                class_40 var11 = this.field_488.field_275;
                if (var11 != class_40.field_188 && !this.method_792()) {
                    if (var3 != class_301.field_1784) {
                        this.field_478.method_644().method_1754(var11, this);
                    }
                } else if ((var3.field_1783 & 1) == 0) {
                    this.field_446 |= 64;
                }
                var4.method_3061(this);
                this.field_478.method_723(this.field_488);
            } catch (class_244 var9) {
                this.field_489 = true;
            }
        }
    }

    public void method_800(class_278 var1, class_90 var2) {
        var1.method_2859(this, var2);
    }

    public StringBuffer method_802(int var1, StringBuffer var2) {
        return this.field_497 == null ? var2 : this.field_497.method_924(0, var2).append(' ');
    }

    public void method_805() {
        if (this.field_497 != null && this.field_488 != null) {
            this.field_497.field_675 = this.field_488.field_275;
        }
        if (class_233.method_1364(this.field_478.method_585().field_198, this.field_479)) {
            this.field_478.method_644().method_1674(this);
        }
        int var2;
        if (this.field_498 != null) {
            int var1 = 0;
            for (var2 = this.field_498.length; var1 < var2; ++var1) {
                this.field_498[var1].method_821(this.field_478);
            }
        }
        class_341 var6 = this.field_478.method_577();
        if (this.field_488 != null) {
            long var7 = var6.field_1928;
            if (var7 >= 3211264L) {
                int var4 = this.field_488.field_273;
                boolean var5 = (this.field_488.field_281 & 562949953421312L) != 0L;
                if (var5) {
                    if ((var4 & 268435464) != 268435456 && (var7 < 3276800L || (var4 & 536870920) != 536870912)) {
                        this.field_478.method_644().method_1670(this);
                    }
                } else if (!this.field_488.field_278.method_157() && (var4 & 268435464) == 268435456) {
                    this.field_478.method_644().method_1679(this);
                }
            }
        }
        switch (class_114.method_859(this.field_478.method_718().field_577)) {
            case 3:
                if (this.field_479 == class_17.field_71 || this.field_479 == class_17.field_72) {
                    break;
                }
            case 1:
                if ((this.field_482 & 16777216) != 0) {
                    if ((this.field_482 & 256) == 0 && (this.field_482 & 1024) == 0) {
                        this.field_478.method_644().method_1672(this);
                    }
                } else if ((this.field_482 & 256) != 0 || (this.field_482 & 1024) != 0) {
                    this.field_478.method_644().method_1673(this);
                }
        }
        super.method_805();
        if (var6.method_3313(562949953421312L) != -1 && this.field_488 != null) {
            var2 = this.field_488.field_273;
            if ((var2 & 805306368) == 268435456 && (this.field_446 & 16) == 0) {
                this.field_478.method_644().method_1716(this.field_488);
            }
        }
    }

    public void method_806(class_264 var1, class_84 var2) {
        if (var1.method_2036(this, var2)) {
            int var3;
            int var4;
            if (this.field_483 != null) {
                var3 = this.field_483.length;
                for (var4 = 0; var4 < var3; ++var4) {
                    this.field_483[var4].method_763(var1, this.field_478);
                }
            }
            if (this.field_498 != null) {
                var3 = this.field_498.length;
                for (var4 = 0; var4 < var3; ++var4) {
                    this.field_498[var4].method_763(var1, this.field_478);
                }
            }
            if (this.field_497 != null) {
                this.field_497.method_763(var1, this.field_478);
            }
            if (this.field_484 != null) {
                var3 = this.field_484.length;
                for (var4 = 0; var4 < var3; ++var4) {
                    this.field_484[var4].method_763(var1, this.field_478);
                }
            }
            if (this.field_485 != null) {
                var3 = this.field_485.length;
                for (var4 = 0; var4 < var3; ++var4) {
                    this.field_485[var4].method_763(var1, this.field_478);
                }
            }
            if (this.field_486 != null) {
                var3 = this.field_486.length;
                for (var4 = 0; var4 < var3; ++var4) {
                    this.field_486[var4].method_763(var1, this.field_478);
                }
            }
        }
        var1.method_1951(this, var2);
    }

    public class_123[] method_807() {
        return this.field_498;
    }
}
