package h;

import c.class_264;
import h.class_98;
import i.class_268;
import i.class_74;
import l.class_293;
import l.class_301;
import m.class_86;

// $FF: renamed from: h.bz
public class class_112 extends class_98 {

    // $FF: renamed from: a h.bf[]
    public class_98[] field_572;
    // $FF: renamed from: a int
    public int field_573;
    // $FF: renamed from: a m.v
    public class_86 field_574;

    // $FF: renamed from: <init> (int) void
    public class_112(int var1) {
        this.field_573 = var1;
    }

    // $FF: renamed from: a (m.v, l.j, l.g) l.g
    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        if (this.field_572 == null) {
            return var3;
        } else {
            boolean var4 = false;
            int var5 = 0;
            for (int var6 = this.field_572.length; var5 < var6; ++var5) {
                class_98 var7 = this.field_572[var5];
                if (!var7.method_816(var3, this.field_574, var4)) {
                    var3 = var7.method_814(this.field_574, var2, var3);
                } else {
                    var4 = true;
                }
            }
            return var3;
        }
    }

    // $FF: renamed from: a (m.v, i.o) void
    public void method_818(class_86 var1, class_268 var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            int var3 = var2.field_1208;
            if (this.field_572 != null) {
                int var4 = 0;
                for (int var5 = this.field_572.length; var4 < var5; ++var4) {
                    this.field_572[var4].method_818(this.field_574, var2);
                }
            }
            if (this.field_574 != var1) {
                var2.method_2147(this.field_574);
            }
            var2.method_2360(var3, this.field_444);
        }
    }

    // $FF: renamed from: d () boolean
    public boolean method_819() {
        return this.field_572 == null;
    }

    // $FF: renamed from: c (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_841(int var1, StringBuffer var2) {
        if (this.field_572 == null) {
            return var2;
        } else {
            for (int var3 = 0; var3 < this.field_572.length; ++var3) {
                this.field_572[var3].method_820(var1 + 1, var2);
                var2.append('\n');
            }
            return var2;
        }
    }

    // $FF: renamed from: b (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_820(int var1, StringBuffer var2) {
        method_759(var1, var2);
        var2.append("{\n");
        this.method_841(var1, var2);
        return method_759(var1, var2).append('}');
    }

    // $FF: renamed from: a (m.v) void
    public void method_821(class_86 var1) {
        if ((this.field_446 & 8) != 0) {
            var1.method_644().method_1783(this.field_444, this.field_445);
        }
        if (this.field_572 != null) {
            class_86 var10001;
            if (this.field_573 == 0) {
                var10001 = var1;
            } else {
                var10001 = new class_86(var1, this.field_573);
            }
            this.field_574 = var10001;
            int var2 = 0;
            for (int var3 = this.field_572.length; var2 < var3; ++var2) {
                this.field_572[var2].method_821(this.field_574);
            }
        }
    }

    // $FF: renamed from: b (m.v) void
    public void method_842(class_86 var1) {
        if ((this.field_446 & 8) != 0) {
            var1.method_644().method_1783(this.field_444, this.field_445);
        }
        this.field_574 = var1;
        if (this.field_572 != null) {
            int var2 = 0;
            for (int var3 = this.field_572.length; var2 < var3; ++var2) {
                this.field_572[var2].method_821(this.field_574);
            }
        }
    }

    // $FF: renamed from: a (c.j, m.v) void
    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2003(this, var2) && this.field_572 != null) {
            int var3 = 0;
            for (int var4 = this.field_572.length; var3 < var4; ++var3) {
                this.field_572[var3].method_763(var1, this.field_574);
            }
        }
        var1.method_1918(this, var2);
    }

    // $FF: renamed from: a (i.s) void
    public void method_815(class_74 var1) {
        if (this.field_572 != null) {
            this.field_572[this.field_572.length - 1].method_815(var1);
        }
    }
}