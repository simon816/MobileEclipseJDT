package h;

import c.class_264;
import h.class_146;
import h.class_149;
import m.class_40;
import m.class_43;
import m.class_83;
import m.class_84;
import m.class_86;

// $FF: renamed from: h.be
public class class_147 extends class_146 {

    // $FF: renamed from: a char[]
    public char[] field_726;

    // $FF: renamed from: <init> (char[], long) void
    public class_147(char[] var1, long var2) {
        this.field_726 = var1;
        this.field_444 = (int)(var2 >>> 32);
        this.field_445 = (int)(var2 & 4294967295L);
    }

    // $FF: renamed from: a (int) h.bo
    public class_146 method_1008(int var1) {
        class_149 var10000 = new class_149(this.field_726, var1, ((long)this.field_444 << 32) + (long)this.field_445);
        return var10000;
    }

    // $FF: renamed from: a () char[]
    public char[] method_1010() {
        return this.field_726;
    }

    // $FF: renamed from: b (m.bb) m.s
    protected class_40 method_1011(class_83 var1) {
        if (this.field_675 != null) {
            return this.field_675;
        } else {
            this.field_675 = var1.method_616(this.field_726);
            return var1.field_373 == 3 && this.field_675.method_101() && ((class_84)var1).method_668(this.field_675, this) ? null : this.field_675;
        }
    }

    // $FF: renamed from: a () char[][]
    public char[][] method_1012() {
        return new char[][] {this.field_726};
    }

    // $FF: renamed from: c (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_924(int var1, StringBuffer var2) {
        return var2.append(this.field_726);
    }

    // $FF: renamed from: a (m.v, m.as) m.s
    public class_40 method_1023(class_86 var1, class_43 var2) {
        Object var3 = this.field_675 = var1.method_613(this.field_726, var2);
        boolean var4 = false;
        if (!((class_40)var3).method_101()) {
            var4 = true;
            var1.method_644().method_1626(this, (class_40)var3, var2);
            var3 = ((class_43)var3).method_131();
            if (var3 == null) {
                return null;
            }
        }
        if (this.method_756((class_40)var3, var1)) {
            var1.method_644().method_1516((class_40)var3, this);
        }
        class_40 var5 = var1.method_586().method_490((class_40)var3, false);
        if (var5.method_166() && (this.field_446 & 1073741824) == 0 && var1.method_577().method_3313(35184372088832L) != -1) {
            var1.method_644().method_1742(this, var5);
        }
        return var4 ? var5 : (this.field_675 = var5);
    }

    // $FF: renamed from: a (c.j, m.v) void
    public void method_763(class_264 var1, class_86 var2) {
        var1.method_2056(this, var2);
        var1.method_1971(this, var2);
    }

    // $FF: renamed from: a (c.j, m.f) void
    public void method_1021(class_264 var1, class_84 var2) {
        var1.method_2057(this, var2);
        var1.method_1972(this, var2);
    }
}
