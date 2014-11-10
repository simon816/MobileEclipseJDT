package h;

import a.class_331;
import a.class_337;
import c.class_264;
import h.class_115;
import h.class_126;
import h.class_161;
import h.class_162;
import h.class_163;
import h.class_98;
import i.class_268;
import i.class_75;
import l.class_293;
import l.class_301;
import m.class_40;
import m.class_43;
import m.class_67;
import m.class_86;

public class class_108 extends class_98 {

    public class_126 field_566;

    public class_75 field_567;

    public class_108(class_126 var1, int var2, int var3) {
        this.field_566 = var1;
        this.field_445 = var2;
        this.field_444 = var3;
    }

    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        if (this.field_566 != null) {
            if (this.field_566.field_672 == class_331.field_1896 && !this.field_566.field_675.method_153()) {
                var1.method_644().method_1507(this.field_566);
            }
            this.field_566.method_814(var1, var2, var3);
        }
        return var3;
    }

    public StringBuffer method_820(int var1, StringBuffer var2) {
        method_759(var1, var2);
        if (this.field_566 == null) {
            var2.append("default : ");
        } else {
            var2.append("case ");
            this.field_566.method_924(0, var2).append(" : ");
        }
        return var2.append(';');
    }

    public void method_818(class_86 var1, class_268 var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            int var3 = var2.field_1208;
            this.field_567.method_458();
            var2.method_2360(var3, this.field_444);
        }
    }

    public void method_821(class_86 var1) {}

    public class_331 method_822(class_86 var1, class_40 var2, class_115 var3) {
        var1.field_399 = this;
        if (this.field_566 == null) {
            if (var3.field_608 != null) {
                var1.method_644().method_1522(this);
            }
            var3.field_608 = this;
            return class_331.field_1896;
        } else {
            var3.field_607[var3.field_610++] = this;
            if (var2 != null && var2.method_153() && this.field_566 instanceof class_162) {
                ((class_162)this.field_566).method_4((class_43)var2);
            }
            class_40 var4 = this.field_566.method_925(var1);
            if (var4 != null && var2 != null) {
                if (!this.field_566.method_919(var4, var2) && !var4.method_152(var2)) {
                    if (var1.method_624(var4, var2) || var4.method_148() && var1.method_577().field_1928 >= 3211264L && !var2.method_148() && this.field_566.method_919(var4, var1.method_586().method_486(var2))) {
                        return this.field_566.field_672;
                    }
                } else {
                    if (!var4.method_153()) {
                        return this.field_566.field_672;
                    }
                    if ((this.field_566.field_446 & 534773760) >> 21 != 0) {
                        var1.method_644().method_1542(this.field_566);
                    }
                    if (this.field_566 instanceof class_161 && (this.field_566.field_446 & 7) == 1) {
                        class_161 var5 = (class_161)this.field_566;
                        class_67 var6 = var5.method_1036();
                        if ((var6.field_300 & 16384) == 0) {
                            var1.method_644().method_1544(var5, var6);
                        } else if (var5 instanceof class_163) {
                            var1.method_644().method_1505(var5, var6);
                        }
                        return class_337.method_3301(var6.method_435().field_304 + 1);
                    }
                }
                var1.method_644().method_1777(var4, var2, this.field_566, var3.field_602);
                return class_331.field_1896;
            } else {
                return class_331.field_1896;
            }
        }
    }

    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2005(this, var2) && this.field_566 != null) {
            this.field_566.method_763(var1, var2);
        }
        var1.method_1920(this, var2);
    }
}
