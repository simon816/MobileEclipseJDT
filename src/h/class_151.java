package h;

import b.class_233;
import c.class_264;
import h.class_146;
import h.class_152;
import m.class_34;
import m.class_38;
import m.class_40;
import m.class_43;
import m.class_46;
import m.class_51;
import m.class_80;
import m.class_83;
import m.class_84;
import m.class_86;
import n.class_241;

// $FF: renamed from: h.av
public class class_151 extends class_146 {

    // $FF: renamed from: a char[][]
    public char[][] field_732;
    // $FF: renamed from: a long[]
    public long[] field_733;

    // $FF: renamed from: <init> (char[][], long[]) void
    public class_151(char[][] var1, long[] var2) {
        this.field_732 = var1;
        this.field_733 = var2;
        this.field_444 = (int)(this.field_733[0] >>> 32);
        this.field_445 = (int)(this.field_733[this.field_733.length - 1] & 4294967295L);
    }

    // $FF: renamed from: a (int) h.bo
    public class_146 method_1008(int var1) {
        class_152 var10000 = new class_152(this.field_732, var1, this.field_733);
        return var10000;
    }

    // $FF: renamed from: a (int, m.bb, m.ar) m.s
    protected class_40 method_1030(int var1, class_83 var2, class_38 var3) {
        class_80 var4 = var2.method_586();
        class_40 var5;
        try {
            var4.field_363 = this;
            if (this.field_675 == null) {
                this.field_675 = var2.method_617(this.field_732[var1], var3);
            } else {
                this.field_675 = var2.method_613(this.field_732[var1], (class_43)this.field_675);
                if (!this.field_675.method_101()) {
                    class_51 var10001 = new class_51(class_233.method_1387(this.field_732, 0, var1 + 1), (class_43)this.field_675.method_131(), this.field_675.method_102());
                    this.field_675 = var10001;
                }
            }
            var5 = this.field_675;
        } catch (class_241 var9) {
            var9.method_1438(this, var2.method_645().field_455);
            throw var9;
        } finally {
            var4.field_363 = null;
        }
        return var5;
    }

    // $FF: renamed from: a () char[]
    public char[] method_1010() {
        return this.field_732[this.field_732.length - 1];
    }

    // $FF: renamed from: b (m.bb) m.s
    protected class_40 method_1011(class_83 var1) {
        if (this.field_675 != null) {
            return this.field_675;
        } else {
            class_34 var2 = var1.method_615(this.field_732);
            if (var2 != null && !var2.method_101()) {
                if (var2 instanceof class_51 && var2.method_102() == 1) {
                    class_51 var11 = (class_51)var2;
                    class_34 var12 = var1.method_620(this.field_732);
                    class_51 var10000 = new class_51(var11.field_197, var12 instanceof class_38 ? null : var1.method_586().method_496((class_38)null, this.field_732), 1);
                    return var10000;
                } else {
                    return (class_43)var2;
                }
            } else {
                class_38 var3 = var2 == null ? null : (class_38)var2;
                boolean var4 = var1.field_373 == 3;
                Object var5 = null;
                int var6 = var3 == null ? 0 : var3.field_171.length;
                int var7 = this.field_732.length;
                for (int var8 = var7 - 1; var6 < var7; ++var6) {
                    this.method_1030(var6, var1, var3);
                    if (!this.field_675.method_101()) {
                        return this.field_675;
                    }
                    if (var6 == 0 && this.field_675.method_169() && ((class_46)this.field_675).field_222 == null) {
                        var1.method_644().method_1567((class_46)this.field_675, this);
                        return null;
                    }
                    if (var6 < var8 && this.method_756(this.field_675, var1)) {
                        this.method_1014(this.field_675, var1);
                    }
                    if (var4 && ((class_84)var1).method_668(this.field_675, this)) {
                        return null;
                    }
                    class_43 var9 = (class_43)this.field_675;
                    if (var5 != null) {
                        if (var9.method_155()) {
                            var5 = var1.method_586().method_501(var9, (class_43)var5);
                        } else {
                            boolean var10;
                            if ((var10 = ((class_43)var5).method_166()) && !var9.method_226()) {
                                var5 = var1.method_586().method_501((class_43)var9.method_138(), (class_43)var5);
                            } else if ((var10 || ((class_43)var5).method_162()) && ((class_43)var5).method_138() == var9.method_137().method_138()) {
                                var5 = var1.method_586().method_500((class_43)var9.method_138(), (class_40[])null, (class_43)var5);
                            } else {
                                var5 = var9;
                            }
                        }
                    } else {
                        var5 = var9.method_155() ? (class_43)var1.method_586().method_490(var9, false) : var9;
                    }
                }
                this.field_675 = (class_40)var5;
                return this.field_675;
            }
        }
    }

    // $FF: renamed from: a () char[][]
    public char[][] method_1012() {
        return this.field_732;
    }

    // $FF: renamed from: c (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_924(int var1, StringBuffer var2) {
        for (int var3 = 0; var3 < this.field_732.length; ++var3) {
            if (var3 > 0) {
                var2.append('.');
            }
            var2.append(this.field_732[var3]);
        }
        return var2;
    }

    // $FF: renamed from: a (c.j, m.v) void
    public void method_763(class_264 var1, class_86 var2) {
        var1.method_2051(this, var2);
        var1.method_1966(this, var2);
    }

    // $FF: renamed from: a (c.j, m.f) void
    public void method_1021(class_264 var1, class_84 var2) {
        var1.method_2052(this, var2);
        var1.method_1967(this, var2);
    }
}