package h;

import a.class_331;
import a.class_332;
import a.class_337;
import c.class_264;
import h.class_177;
import i.class_268;
import j.class_346;
import m.class_40;
import m.class_86;

// $FF: renamed from: h.s
public class class_180 extends class_177 {

    // $FF: renamed from: a int
    public int field_796;
    // $FF: renamed from: a h.s
    public static final class_180 field_797;
    // $FF: renamed from: a a.k
    static final class_331 field_798;

    // $FF: renamed from: <init> (char[], int, int) void
    public class_180(char[] var1, int var2, int var3) {
        super(var1, var2, var3);
    }

    // $FF: renamed from: <init> (char[], int, int, int) void
    public class_180(char[] var1, int var2, int var3, int var4) {
        this(var1, var2, var3);
        this.field_796 = var4;
    }

    // $FF: renamed from: a () void
    public void method_1081() {
        long var1 = 2147483647L;
        if (this == field_797) {
            this.field_672 = class_337.method_3301(1);
        } else {
            int var3 = this.field_792.length;
            long var4 = 0L;
            if (this.field_792[0] == 48) {
                var1 = 4294967295L;
                if (var3 == 1) {
                    this.field_672 = class_337.method_3301(0);
                    return;
                }
                byte var6;
                byte var7;
                int var8;
                if (this.field_792[1] != 120 && this.field_792[1] != 88) {
                    var6 = 3;
                    var8 = 1;
                    var7 = 8;
                } else {
                    var6 = 4;
                    var8 = 2;
                    var7 = 16;
                }
                while (this.field_792[var8] == 48) {
                    ++var8;
                    if (var8 == var3) {
                        this.field_672 = class_337.method_3301(this.field_796 = (int)var4);
                        return;
                    }
                }
                while (var8 < var3) {
                    int var9;
                    if ((var9 = class_346.method_3339(this.field_792[var8++], var7)) < 0) {
                        this.field_672 = field_798;
                        return;
                    }
                    var4 = var4 << var6 | (long)var9;
                    if (var4 > var1) {
                        return;
                    }
                }
            } else {
                for (int var10 = 0; var10 < var3; ++var10) {
                    int var11;
                    if ((var11 = class_346.method_3339(this.field_792[var10], 10)) < 0) {
                        this.field_672 = field_798;
                        return;
                    }
                    var4 = 10L * var4 + (long)var11;
                    if (var4 > var1) {
                        return;
                    }
                }
            }
            this.field_672 = class_337.method_3301(this.field_796 = (int)var4);
        }
    }

    // $FF: renamed from: a (m.v, i.o, boolean) void
    public void method_912(class_86 var1, class_268 var2, boolean var3) {
        int var4 = var2.field_1208;
        if (var3) {
            var2.method_2179(this.field_672, this.field_674);
        }
        var2.method_2360(var4, this.field_444);
    }

    // $FF: renamed from: b (m.v) m.s
    public class_40 method_1082(class_86 var1) {
        return class_40.field_179;
    }

    // $FF: renamed from: f_ () boolean
    public final boolean method_1093() {
        return this.field_792.length == 10 && this.field_792[0] == 50 && this.field_792[1] == 49 && this.field_792[2] == 52 && this.field_792[3] == 55 && this.field_792[4] == 52 && this.field_792[5] == 56 && this.field_792[6] == 51 && this.field_792[7] == 54 && this.field_792[8] == 52 && this.field_792[9] == 56 && (this.field_446 & 534773760) >> 21 == 0;
    }

    // $FF: renamed from: a (m.v) m.s
    public class_40 method_925(class_86 var1) {
        class_40 var2 = super.method_925(var1);
        if (this.field_672 == field_798) {
            this.field_672 = class_331.field_1896;
            var1.method_644().method_1511(this);
            this.field_675 = null;
            return null;
        } else {
            return var2;
        }
    }

    // $FF: renamed from: c (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_924(int var1, StringBuffer var2) {
        return this.field_792 == null ? var2.append(String.valueOf(this.field_796)) : super.method_924(var1, var2);
    }

    // $FF: renamed from: a (c.j, m.v) void
    public void method_763(class_264 var1, class_86 var2) {
        var1.method_2029(this, var2);
        var1.method_1944(this, var2);
    }

    // $FF: renamed from: <clinit> () void
    static {
        class_180 var10000 = new class_180(new char[] {'1'}, 0, 0, 1);
        field_797 = var10000;
        field_798 = class_332.method_3291(Double.POSITIVE_INFINITY);
    }
}
