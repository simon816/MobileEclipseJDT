package h;

import a.class_331;
import h.class_115;
import h.class_126;
import h.class_89;
import i.class_268;
import i.class_74;
import l.class_293;
import l.class_301;
import m.class_40;
import m.class_42;
import m.class_58;
import m.class_86;

// $FF: renamed from: h.bf
public abstract class class_98 extends class_89 {

    // $FF: renamed from: <init> () void
    public class_98() {
    }

    // $FF: renamed from: a (m.v, l.j, l.g) l.g
    public abstract class_301 method_814(class_86 var1, class_293 var2, class_301 var3);

    // $FF: renamed from: a (i.s) void
    public void method_815(class_74 var1) {}

    // $FF: renamed from: a (l.g, m.v, boolean) boolean
    public boolean method_816(class_301 var1, class_86 var2, boolean var3) {
        if ((var1.method_3102() & 1) != 0) {
            this.field_446 &= Integer.MAX_VALUE;
            boolean var4 = var1 == class_301.field_1784;
            if (!var3 && var4) {
                var2.method_644().method_1798(this);
            }
            return var4;
        } else {
            return false;
        }
    }

    // $FF: renamed from: a (m.ae, h.r[], m.v, i.o) void
    public void method_817(class_58 var1, class_126[] var2, class_86 var3, class_268 var4) {
        int var6;
        if (var1.method_374()) {
            class_40[] var5 = var1.field_276;
            var6 = var5.length;
            int var7 = var6 - 1;
            for (int var8 = 0; var8 < var7; ++var8) {
                var2[var8].method_912(var3, var4, true);
            }
            class_42 var14 = (class_42)var5[var7];
            class_42 var9 = (class_42)var1.field_276[var7].method_138();
            int var10 = var14.method_187().field_177;
            int var11 = var2 == null ? 0 : var2.length;
            if (var11 > var6) {
                var4.method_2188(var11 - var7);
                var4.method_2345(var9);
                for (int var12 = var7; var12 < var11; ++var12) {
                    var4.method_2141();
                    var4.method_2188(var12 - var7);
                    var2[var12].method_912(var3, var4, true);
                    var4.method_2100(var10, false);
                }
            } else if (var11 == var6) {
                class_40 var15 = var2[var7].field_675;
                if (var15 != class_40.field_187 && (var14.method_136() != var15.method_136() || !var15.method_152(var14))) {
                    var4.method_2188(1);
                    var4.method_2345(var9);
                    var4.method_2141();
                    var4.method_2188(0);
                    var2[var7].method_912(var3, var4, true);
                    var4.method_2100(var10, false);
                } else {
                    var2[var7].method_912(var3, var4, true);
                }
            } else {
                var4.method_2188(0);
                var4.method_2345(var9);
            }
        } else if (var2 != null) {
            int var13 = 0;
            for (var6 = var2.length; var13 < var6; ++var13) {
                var2[var13].method_912(var3, var4, true);
            }
        }
    }

    // $FF: renamed from: a (m.v, i.o) void
    public abstract void method_818(class_86 var1, class_268 var2);

    // $FF: renamed from: d () boolean
    public boolean method_819() {
        return false;
    }

    // $FF: renamed from: a (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_757(int var1, StringBuffer var2) {
        return this.method_820(var1, var2);
    }

    // $FF: renamed from: b (int, java.lang.StringBuffer) java.lang.StringBuffer
    public abstract StringBuffer method_820(int var1, StringBuffer var2);

    // $FF: renamed from: a (m.v) void
    public abstract void method_821(class_86 var1);

    // $FF: renamed from: a (m.v, m.s, h.bg) a.k
    public class_331 method_822(class_86 var1, class_40 var2, class_115 var3) {
        this.method_821(var1);
        return class_331.field_1896;
    }
}
