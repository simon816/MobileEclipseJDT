package h;

import c.class_264;
import h.class_120;
import h.class_146;
import i.class_268;
import m.class_34;
import m.class_46;
import m.class_83;
import m.class_84;
import m.class_86;

public class class_123 extends class_120 {

    public class_46 field_668;

    public class_146[] field_669;

    public class_123() {
    }

    public int method_887() {
        return 6;
    }

    public void method_896(class_83 var1) {
        if (this.field_660 != null) {
            this.field_660.method_1007(var1);
        }
        if (this.field_669 != null) {
            int var2 = 0;
            for (int var3 = this.field_669.length; var2 < var3; ++var2) {
                this.field_669[var2].method_1007(var1);
            }
        }
    }

    private void method_897(class_83 var1, boolean var2) {
        if (this.field_668 != null) {
            class_34 var3 = var1.field_374.method_598(this.field_659, 4, this, false);
            if (var3 != null && this.field_668 != var3 && var3.method_101() && (var3.method_98() != 4100 || !var2)) {
                var1.method_644().method_1776(this, var3);
            }
        }
    }

    public void method_821(class_86 var1) {
        this.method_897(var1, var1.method_635().field_404);
    }

    public void method_898(class_84 var1) {
        this.method_897(var1, var1.method_585().method_226());
    }

    public StringBuffer method_820(int var1, StringBuffer var2) {
        var2.append(this.field_659);
        if (this.field_660 != null) {
            var2.append(" extends ");
            this.field_660.method_757(0, var2);
        }
        if (this.field_669 != null) {
            for (int var3 = 0; var3 < this.field_669.length; ++var3) {
                var2.append(" & ");
                this.field_669[var3].method_757(0, var2);
            }
        }
        return var2;
    }

    public void method_818(class_86 var1, class_268 var2) {}

    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2068(this, var2)) {
            if (this.field_660 != null) {
                this.field_660.method_763(var1, var2);
            }
            if (this.field_669 != null) {
                int var3 = this.field_669.length;
                for (int var4 = 0; var4 < var3; ++var4) {
                    this.field_669[var4].method_763(var1, var2);
                }
            }
        }
        var1.method_1983(this, var2);
    }

    public void method_899(class_264 var1, class_84 var2) {
        if (var1.method_2069(this, var2)) {
            if (this.field_660 != null) {
                this.field_660.method_1021(var1, var2);
            }
            if (this.field_669 != null) {
                int var3 = this.field_669.length;
                for (int var4 = 0; var4 < var3; ++var4) {
                    this.field_669[var4].method_1021(var1, var2);
                }
            }
        }
        var1.method_1984(this, var2);
    }
}
