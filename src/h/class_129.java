package h;

import a.class_331;
import c.class_264;
import h.class_126;
import h.class_146;
import i.class_268;
import l.class_293;
import l.class_301;
import m.class_40;
import m.class_42;
import m.class_43;
import m.class_46;
import m.class_54;
import m.class_67;
import m.class_86;

public class class_129 extends class_126 {

    public class_146 field_681;

    public class_40 field_682;

    class_67 field_683;

    public class_129(int var1, class_146 var2) {
        this.field_681 = var2;
        var2.field_446 |= 1073741824;
        this.field_444 = var2.field_444;
        this.field_445 = var1;
    }

    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        class_54 var4 = var1.method_640().method_585();
        if (!var4.method_157() && !this.field_682.method_148() && var1.method_577().field_1928 < 3211264L) {
            this.field_683 = var4.method_295(this.field_682, var1);
        }
        return var3;
    }

    public void method_912(class_86 var1, class_268 var2, boolean var3) {
        int var4 = var2.field_1208;
        if (var3) {
            var2.method_2177(this.field_681.field_675, this.field_683);
            var2.method_2182(this.field_674);
        }
        var2.method_2360(var4, this.field_444);
    }

    public StringBuffer method_924(int var1, StringBuffer var2) {
        return this.field_681.method_757(0, var2).append(".class");
    }

    public class_40 method_925(class_86 var1) {
        this.field_672 = class_331.field_1896;
        if ((this.field_682 = this.field_681.method_1017(var1, true)) == null) {
            return null;
        } else {
            class_40 var3;
            if (this.field_682.method_147()) {
                class_42 var2 = (class_42)this.field_682;
                var3 = var2.field_192;
                if (var3 == class_40.field_188) {
                    var1.method_644().method_1490(this);
                    return null;
                }
                if (var3.method_169()) {
                    var1.method_644().method_1568((class_46)var3, this);
                }
            } else if (this.field_682.method_169()) {
                var1.method_644().method_1568((class_46)this.field_682, this);
            }
            class_43 var4 = var1.method_606();
            if (var4.method_155()) {
                var3 = null;
                Object var5;
                if (this.field_682.field_177 == 6) {
                    var5 = var1.method_586().method_506(field_117, var1);
                } else {
                    var5 = var1.method_574(this.field_682);
                }
                this.field_675 = var1.method_586().method_500(var4, new class_40[] {(class_40)var5}, (class_43)null);
            } else {
                this.field_675 = var4;
            }
            return this.field_675;
        }
    }

    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2008(this, var2)) {
            this.field_681.method_763(var1, var2);
        }
        var1.method_1923(this, var2);
    }
}
