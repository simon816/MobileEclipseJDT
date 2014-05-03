package m;

import b.class_233;
import h.class_108;
import h.class_114;
import h.class_146;
import h.class_93;
import m.class_17;
import m.class_34;
import m.class_42;
import m.class_43;
import m.class_46;
import m.class_54;
import m.class_55;
import m.class_58;
import m.class_79;
import m.class_80;
import m.class_84;
import m.class_86;
import m.class_87;

// $FF: renamed from: m.aa
public final class class_57 extends class_55 {

    // $FF: renamed from: a char[]
    static final char[] field_267;
    // $FF: renamed from: a m.ac[]
    private class_79[] field_268;
    // $FF: renamed from: a m.p[]
    public class_42[] field_269;
    // $FF: renamed from: a h.bu
    public class_108 field_270;
    // $FF: renamed from: a int
    public int field_271;
    // $FF: renamed from: a m.ae
    public class_58 field_272;

    // $FF: renamed from: <init> (m.f, m.az, h.bu, m.as) void
    public class_57(class_84 var1, class_54 var2, class_108 var3, class_43 var4) {
        super(new char[][] {class_233.method_1355(field_267, var1.field_376.field_580)}, var1, var2);
        class_114 var5 = var1.field_376;
        if ((var5.field_446 & 512) != 0) {
            this.field_178 |= 52L;
        } else {
            this.field_178 |= 20L;
        }
        this.field_270 = var3;
        this.field_271 = var5.field_444;
        class_87 var6 = var1.method_583();
        class_93 var7 = var6.method_730();
        if (var7 != null) {
            this.field_272 = var7.field_488;
        }
    }

    // $FF: renamed from: a (m.v, boolean) void
    public void method_334(class_86 var1, boolean var2) {
        int var3;
        if (this.field_268 == null) {
            var3 = 0;
            this.field_268 = new class_79[1];
        } else {
            var3 = this.field_268.length;
            for (int var4 = 0; var4 < var3; ++var4) {
                if (this.field_268[var4].field_343 == var1) {
                    return;
                }
            }
            System.arraycopy(this.field_268, 0, this.field_268 = new class_79[var3 + 1], 0, var3);
        }
        class_79[] var10000 = this.field_268;
        class_79 var10002 = new class_79(var1, var2);
        var10000[var3] = var10002;
    }

    // $FF: renamed from: c () m.as
    public class_43 method_335() {
        if (this.field_253 != class_34.field_155) {
            return this.field_253[0];
        } else if ((this.field_178 & 131072L) == 0L) {
            return this.field_252;
        } else {
            if (this.field_258 != null) {
                class_146 var1 = this.field_258.field_376.field_598.field_691;
                if (var1 != null) {
                    return (class_43)var1.field_675;
                }
            }
            return this.field_252;
        }
    }

    // $FF: renamed from: b () char[]
    public char[] method_134() {
        return this.field_202;
    }

    // $FF: renamed from: a (int, m.af) m.p
    class_42 method_336(int var1, class_80 var2) {
        if (this.field_269 == null) {
            class_42[] var10001 = new class_42[1];
            class_42 var10004 = new class_42(this, var1, var2);
            var10001[0] = var10004;
            this.field_269 = var10001;
            return this.field_269[0];
        } else {
            int var3 = this.field_269.length;
            for (int var4 = 0; var4 < var3; ++var4) {
                if (this.field_269[var4].field_193 == var1) {
                    return this.field_269[var4];
                }
            }
            System.arraycopy(this.field_269, 0, this.field_269 = new class_42[var3 + 1], 0, var3);
            class_42[] var10000 = this.field_269;
            class_42 var10002 = new class_42(this, var1, var2);
            return var10000[var3] = var10002;
        }
    }

    // $FF: renamed from: f () char[]
    public char[] method_142() {
        if (this.field_260 == null && this.method_134() == null) {
            if (this.method_146()) {
                this.method_338(this.method_240().method_179());
            } else {
                this.method_338(this.method_179());
            }
        }
        return super.method_142();
    }

    // $FF: renamed from: a () char[]
    public char[] method_103() {
        char[] var1;
        if (this.method_146()) {
            var1 = class_233.method_1356(class_17.field_49, this.method_335().method_103(), class_17.field_50);
        } else if (this.method_159()) {
            var1 = class_233.method_1357(this.method_137().method_103(), this.field_198, '.');
        } else {
            var1 = this.field_198;
        }
        class_46[] var2;
        if ((var2 = this.method_181()) != class_34.field_157) {
            StringBuffer var3 = new StringBuffer(10);
            var3.append(var1).append('<');
            int var4 = 0;
            for (int var5 = var2.length; var4 < var5; ++var4) {
                if (var4 > 0) {
                    var3.append(',');
                }
                var3.append(var2[var4].method_103());
            }
            var3.append('>');
            var4 = var3.length();
            var1 = new char[var4];
            var3.getChars(0, var4, var1, 0);
        }
        return var1;
    }

    // $FF: renamed from: d () char[]
    public char[] method_104() {
        char[] var1;
        if (this.method_146()) {
            var1 = class_233.method_1356(class_17.field_49, this.method_335().method_104(), class_17.field_50);
        } else if (this.method_159()) {
            var1 = class_233.method_1357(this.method_137().method_104(), this.field_198, '.');
        } else {
            var1 = this.field_198;
        }
        class_46[] var2;
        if ((var2 = this.method_181()) != class_34.field_157) {
            StringBuffer var3 = new StringBuffer(10);
            var3.append(var1).append('<');
            int var4 = 0;
            for (int var5 = var2.length; var4 < var5; ++var4) {
                if (var4 > 0) {
                    var3.append(',');
                }
                var3.append(var2[var4].method_104());
            }
            var3.append('>');
            var4 = var3.length();
            var1 = new char[var4];
            var3.getChars(0, var4, var1, 0);
        }
        return var1;
    }

    // $FF: renamed from: a_ () void
    public void method_337() {
        this.field_178 |= 12L;
    }

    // $FF: renamed from: a (char[]) void
    public void method_338(char[] var1) {
        this.field_202 = var1;
    }

    // $FF: renamed from: h () char[]
    public char[] method_178() {
        if (this.field_203 == null && this.method_134() == null) {
            if (this.method_146()) {
                this.method_338(this.method_240().method_179());
            } else {
                this.method_338(this.method_179());
            }
        }
        return super.method_178();
    }

    // $FF: renamed from: e () char[]
    public char[] method_179() {
        return this.method_146() ? class_233.method_1356(class_17.field_49, this.method_335().method_179(), class_17.field_50) : this.field_198;
    }

    public String toString() {
        return this.method_146() ? "Anonymous type : " + super.toString() : (this.method_159() ? "Local member type : " + new String(this.method_179()) + " " + super.toString() : "Local type : " + new String(this.method_179()) + " " + super.toString());
    }

    // $FF: renamed from: d () void
    public void method_330() {
        if (this.field_268 != null) {
            for (int var1 = 0; var1 < this.field_268.length; ++var1) {
                class_79 var2 = this.field_268[var1];
                var2.field_343.method_717(this, var2.field_344);
            }
        }
    }

    // $FF: renamed from: <clinit> () void
    static {
        field_267 = new char[] {'$', 'L', 'o', 'c', 'a', 'l', '$'};
    }
}
