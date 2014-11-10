package h;

import a.class_331;
import c.class_264;
import h.class_146;
import h.class_157;
import i.class_268;
import l.class_293;
import l.class_301;
import m.class_40;
import m.class_43;
import m.class_86;

public class class_159 extends class_157 {

    public class_146 field_746;

    class_43 field_747;

    public class_159(class_146 var1, int var2, int var3) {
        super(var2, var3);
        this.field_746 = var1;
        var1.field_446 |= 1073741824;
        this.field_444 = var1.field_444;
    }

    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        return var3;
    }

    public class_301 method_907(class_86 var1, class_293 var2, class_301 var3, boolean var4) {
        return var3;
    }

    public void method_912(class_86 var1, class_268 var2, boolean var3) {
        int var4 = var2.field_1208;
        if (var3) {
            if ((this.field_446 & 8160) != 0) {
                Object[] var5 = var1.method_714(this.field_747, true, false);
                var2.method_2191(var5, this, this.field_747, var1);
            } else {
                var2.method_2093();
            }
        }
        var2.method_2360(var4, this.field_444);
    }

    public class_40 method_925(class_86 var1) {
        this.field_672 = class_331.field_1896;
        class_40 var2 = this.field_746.method_1017(var1, true);
        if (var2 != null && var2.method_101()) {
            var2 = var2.method_138();
            if (var2 instanceof class_43) {
                this.field_675 = var1.method_586().method_489((class_43)var2);
            } else {
                this.field_675 = var2;
            }
            int var3 = 0;
            for (this.field_747 = var1.method_718().field_586; this.field_747 != null && this.field_747 != var2; this.field_747 = this.field_747.method_226() ? null : this.field_747.method_137()) {
                ++var3;
            }
            this.field_446 &= -8161;
            this.field_446 |= (var3 & 255) << 5;
            if (this.field_747 == null) {
                var1.method_644().method_1707(var2, this, false);
                return this.field_675;
            } else {
                if (var3 == 0) {
                    this.method_1046(var1.method_635());
                }
                return this.field_675;
            }
        } else {
            return null;
        }
    }

    public StringBuffer method_924(int var1, StringBuffer var2) {
        return this.field_746.method_757(0, var2).append(".this");
    }

    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2050(this, var2)) {
            this.field_746.method_763(var1, var2);
        }
        var1.method_1965(this, var2);
    }
}
