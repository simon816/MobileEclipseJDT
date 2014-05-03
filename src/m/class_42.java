package m;

import a.class_331;
import b.class_233;
import g.class_13;
import m.class_17;
import m.class_321;
import m.class_38;
import m.class_40;
import m.class_43;
import m.class_44;
import m.class_45;
import m.class_47;
import m.class_67;
import m.class_80;
import m.class_83;

// $FF: renamed from: m.p
public final class class_42 extends class_40 {

    // $FF: renamed from: a m.k
    public static final class_67 field_191;
    // $FF: renamed from: a m.s
    public class_40 field_192;
    // $FF: renamed from: a int
    public int field_193;
    // $FF: renamed from: a m.af
    class_80 field_194;
    // $FF: renamed from: a char[]
    char[] field_195;
    // $FF: renamed from: b char[]
    char[] field_196;

    // $FF: renamed from: <init> (m.s, int, m.af) void
    public class_42(class_40 var1, int var2, class_80 var3) {
        this.field_178 |= 1L;
        this.field_192 = var1;
        this.field_193 = var2;
        this.field_194 = var3;
        if (var1 instanceof class_44) {
            ((class_44)var1).method_246(this, var3);
        } else {
            this.field_178 |= var1.field_178 & 1610612864L;
        }
    }

    // $FF: renamed from: a () m.s
    public class_40 method_131() {
        if (this.method_101()) {
            return this;
        } else {
            class_40 var1 = this.field_192.method_131();
            return var1 == null ? null : this.field_194.method_493(this.field_192.method_131(), this.field_193);
        }
    }

    // $FF: renamed from: a (g.l) g.l
    public class_13 method_132(class_13 var1) {
        if ((this.field_178 & 128L) != 0L) {
            var1 = this.field_192.method_132(var1);
        }
        return var1;
    }

    // $FF: renamed from: a (m.bb, m.s, m.g, int) void
    public void method_133(class_83 var1, class_40 var2, class_321 var3, int var4) {
        if ((this.field_178 & 536870912L) != 0L) {
            if (var2 != class_40.field_187) {
                switch (var2.method_98()) {
                    case 68:
                        int var5 = var2.method_136();
                        if (var5 == this.field_193) {
                            this.field_192.method_133(var1, var2.method_173(), var3, var4);
                        } else if (var5 > this.field_193) {
                            class_42 var6 = this.field_194.method_493(var2.method_173(), var5 - this.field_193);
                            this.field_192.method_133(var1, var6, var3, var4);
                        }
                    case 4100:
                    default:
                }
            }
        }
    }

    // $FF: renamed from: b () char[]
    public char[] method_134() {
        if (this.field_195 != null) {
            return this.field_195;
        } else {
            char[] var1 = new char[this.field_193];
            for (int var2 = this.field_193 - 1; var2 >= 0; --var2) {
                var1[var2] = 91;
            }
            return this.field_195 = class_233.method_1355(var1, this.field_192.method_178());
        }
    }

    // $FF: renamed from: b () java.lang.String
    public String method_135() {
        StringBuffer var1 = new StringBuffer(this.field_193 * 2);
        int var2 = this.field_193;
        while (true) {
            --var2;
            if (var2 < 0) {
                return this.field_192.method_135() + var1.toString();
            }
            var1.append("[]");
        }
    }

    // $FF: renamed from: b () int
    public int method_136() {
        return this.field_193;
    }

    // $FF: renamed from: b () m.s
    public class_40 method_187() {
        return (class_40)(this.field_193 == 1 ? this.field_192 : this.field_194.method_493(this.field_192, this.field_193 - 1));
    }

    // $FF: renamed from: c () m.s
    public class_40 method_138() {
        class_40 var1 = this.field_192.method_138();
        return this.field_192 != var1 ? this.field_194.method_493(var1, this.field_193) : this;
    }

    // $FF: renamed from: a () m.af
    public class_80 method_188() {
        return this.field_194;
    }

    // $FF: renamed from: f () char[]
    public char[] method_142() {
        if (this.field_196 == null) {
            char[] var1 = new char[this.field_193];
            for (int var2 = this.field_193 - 1; var2 >= 0; --var2) {
                var1[var2] = 91;
            }
            this.field_196 = class_233.method_1355(var1, this.field_192.method_142());
        }
        return this.field_196;
    }

    // $FF: renamed from: a () m.ar
    public class_38 method_143() {
        return this.field_192.method_143();
    }

    public int hashCode() {
        return this.field_192 == null ? super.hashCode() : this.field_192.hashCode();
    }

    // $FF: renamed from: a (m.s) boolean
    public boolean method_152(class_40 var1) {
        if (this == var1) {
            return true;
        } else {
            switch (var1.method_98()) {
                case 68:
                    class_42 var2 = (class_42)var1;
                    if (var2.field_192.method_148()) {
                        return false;
                    } else if (this.field_193 == var2.field_193) {
                        return this.field_192.method_152(var2.field_192);
                    } else if (this.field_193 < var2.field_193) {
                        return false;
                    }
                case 132:
                    return false;
                case 516:
                case 8196:
                    return ((class_45)var1).method_250(this);
                case 4100:
                    if (var1.method_150()) {
                        class_47 var3 = (class_47)var1;
                        class_40 var4 = var3.field_226;
                        if (var3.field_226 != null) {
                            if (!var4.method_147()) {
                                return false;
                            }
                            return this.method_152(var4);
                        }
                    }
                    return false;
                default:
                    switch (var1.method_173().field_177) {
                        case 1:
                        case 36:
                        case 37:
                            return true;
                        default:
                            return false;
                    }
            }
        }
    }

    // $FF: renamed from: a () int
    public int method_98() {
        return 68;
    }

    // $FF: renamed from: d () m.s
    public class_40 method_173() {
        return this.field_192;
    }

    // $FF: renamed from: c () int
    public int method_102() {
        return this.field_192.method_102();
    }

    // $FF: renamed from: c () char[]
    public char[] method_177() {
        char[] var1 = new char[this.field_193 * 2];
        for (int var2 = this.field_193 * 2 - 1; var2 >= 0; var2 -= 2) {
            var1[var2] = 93;
            var1[var2 - 1] = 91;
        }
        return class_233.method_1355(this.field_192.method_177(), var1);
    }

    // $FF: renamed from: a () char[]
    public char[] method_103() {
        char[] var1 = new char[this.field_193 * 2];
        for (int var2 = this.field_193 * 2 - 1; var2 >= 0; var2 -= 2) {
            var1[var2] = 93;
            var1[var2 - 1] = 91;
        }
        return class_233.method_1355(this.field_192.method_103(), var1);
    }

    // $FF: renamed from: d () char[]
    public char[] method_104() {
        char[] var1 = new char[this.field_193 * 2];
        for (int var2 = this.field_193 * 2 - 1; var2 >= 0; var2 -= 2) {
            var1[var2] = 93;
            var1[var2 - 1] = 91;
        }
        return class_233.method_1355(this.field_192.method_104(), var1);
    }

    // $FF: renamed from: e () char[]
    public char[] method_179() {
        char[] var1 = new char[this.field_193 * 2];
        for (int var2 = this.field_193 * 2 - 1; var2 >= 0; var2 -= 2) {
            var1[var2] = 93;
            var1[var2 - 1] = 91;
        }
        return class_233.method_1355(this.field_192.method_179(), var1);
    }

    // $FF: renamed from: a (m.m, m.as, m.af) void
    public void method_180(class_44 var1, class_43 var2, class_80 var3) {
        if (this.field_192 == var1) {
            this.field_192 = var3.method_491(var2);
            this.field_178 |= this.field_192.field_178 & 1610612864L;
        }
    }

    public String toString() {
        return this.field_192 != null ? this.method_135() : "NULL TYPE ARRAY";
    }

    // $FF: renamed from: <clinit> () void
    static {
        class_67 var10000 = new class_67(class_17.field_32, class_40.field_179, 17, (class_43)null, class_331.field_1896);
        field_191 = var10000;
    }
}
