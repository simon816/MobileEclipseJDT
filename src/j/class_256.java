package j;

import h.class_112;
import h.class_114;
import h.class_121;
import h.class_122;
import h.class_89;
import h.class_90;
import h.class_91;
import h.class_93;
import j.class_251;
import j.class_252;
import j.class_257;
import j.class_260;
import j.class_278;

// $FF: renamed from: j.l
public class class_256 extends class_251 {

    // $FF: renamed from: a h.b
    public class_90 field_1101;
    // $FF: renamed from: a j.c[]
    public class_252[] field_1102;
    // $FF: renamed from: a int
    public int field_1103;
    // $FF: renamed from: a j.m[]
    public class_260[] field_1104;
    // $FF: renamed from: b int
    public int field_1105;
    // $FF: renamed from: c int
    int field_1106;
    // $FF: renamed from: d int
    int field_1107;
    // $FF: renamed from: a j.g[]
    class_257[] field_1108;
    // $FF: renamed from: f int
    int field_1109;

    // $FF: renamed from: <init> (h.b, int, j.r) void
    public class_256(class_90 var1, int var2, class_278 var3) {
        super((class_251)null, var2, var3);
        this.field_1107 = -1;
        this.field_1101 = var1;
    }

    // $FF: renamed from: a (int, int, int, int) j.e
    public class_251 method_1831(int var1, int var2, int var3, int var4) {
        if (this.field_1108 == null) {
            this.field_1108 = new class_257[5];
            this.field_1109 = 0;
        } else if (this.field_1109 == this.field_1108.length) {
            System.arraycopy(this.field_1108, 0, this.field_1108 = new class_257[2 * this.field_1109], 0, this.field_1109);
        }
        class_257 var10000 = new class_257(var1, var2, var3, this, var4);
        class_257 var5 = var10000;
        this.field_1108[this.field_1109++] = var5;
        return var5;
    }

    // $FF: renamed from: b (int, int) void
    public void method_1840(int var1, int var2) {
        this.field_1106 |= var1;
        if (this.field_1107 < 0) {
            this.field_1107 = var2;
        }
    }

    // $FF: renamed from: a (h.ci, int) j.e
    public class_251 method_1832(class_93 var1, int var2) {
        if (this.field_1105 > 0) {
            class_260 var3 = this.field_1104[this.field_1105 - 1];
            int var4 = var3.field_1136;
            int var5 = var3.field_1124.field_595;
            var3.field_1136 = 0;
            var3.field_1124.field_593 = 0;
            var3.field_1124.field_595 = 0;
            int var6 = class_114.method_859(var3.field_1124.field_577);
            if (var4 > 0 && var4 < var5 && var6 != 2 && var6 != 4) {
                class_112 var10002 = new class_112(0);
                class_122 var10000 = new class_122(var10002, 0);
                class_122 var7 = var10000;
                var7.field_666 = var5;
                var7.field_667 = var5;
                var7.field_653 = var5;
                var7.field_652 = var5;
                var7.field_444 = var5;
                var7.field_445 = var5;
                var3.method_1834(var7, var2);
            }
            this.method_1846();
            return var3.method_1832(var1, var2);
        } else {
            return this;
        }
    }

    // $FF: renamed from: a (h.m, int) j.e
    public class_251 method_1834(class_121 var1, int var2) {
        if (this.field_1105 > 0) {
            class_260 var3 = this.field_1104[this.field_1105 - 1];
            var3.field_1136 = 0;
            var3.field_1124.field_593 = 0;
            var3.field_1124.field_595 = 0;
            this.method_1846();
            return var3.method_1834(var1, var2);
        } else {
            return this;
        }
    }

    // $FF: renamed from: a (h.z, int) j.e
    public class_251 method_1835(class_91 var1, int var2) {
        this.method_1846();
        if (this.field_1102 == null) {
            this.field_1102 = new class_252[5];
            this.field_1103 = 0;
        } else if (this.field_1103 == this.field_1102.length) {
            System.arraycopy(this.field_1102, 0, this.field_1102 = new class_252[2 * this.field_1103], 0, this.field_1103);
        }
        class_252 var10000 = new class_252(var1, this, var2);
        class_252 var3 = var10000;
        this.field_1102[this.field_1103++] = var3;
        if (var1.field_471 == 0) {
            return var3;
        }
        return this;
    }

    // $FF: renamed from: a (h.bq, int) j.e
    public class_251 method_1838(class_114 var1, int var2) {
        class_260 var3;
        if ((var1.field_446 & 512) != 0 && this.field_1105 > 0) {
            var3 = this.field_1104[this.field_1105 - 1];
            var3.field_1136 = 0;
            var3.field_1124.field_595 = 0;
            var3.field_1124.field_593 = 0;
            ++var3.field_1069;
            this.method_1846();
            return var3.method_1838(var1, var2);
        } else {
            if (this.field_1104 == null) {
                this.field_1104 = new class_260[5];
                this.field_1105 = 0;
            } else if (this.field_1105 == this.field_1104.length) {
                System.arraycopy(this.field_1104, 0, this.field_1104 = new class_260[2 * this.field_1105], 0, this.field_1105);
            }
            class_260 var10000 = new class_260(var1, this, var2);
            var3 = var10000;
            this.field_1104[this.field_1105++] = var3;
            if (this.field_1109 > 0) {
                var3.method_1881(this.field_1108, this.field_1109, this.field_1106, this.field_1107);
            }
            this.method_1846();
            if (var1.field_593 == 0) {
                return var3;
            }
            return this;
        }
    }

    // $FF: renamed from: a () h.cj
    public class_89 method_1845() {
        return this.field_1101;
    }

    // $FF: renamed from: b () void
    public void method_1846() {
        this.field_1108 = null;
        this.field_1109 = 0;
        this.field_1106 = 0;
        this.field_1107 = -1;
    }

    // $FF: renamed from: a (int) java.lang.String
    public String method_1850(int var1) {
        StringBuffer var2 = new StringBuffer(this.method_1848(var1));
        var2.append("Recovered unit: [\n");
        this.field_1101.method_757(var1 + 1, var2);
        var2.append(this.method_1848(var1 + 1));
        var2.append("]");
        int var3;
        if (this.field_1102 != null) {
            for (var3 = 0; var3 < this.field_1103; ++var3) {
                var2.append("\n");
                var2.append(this.field_1102[var3].method_1850(var1 + 1));
            }
        }
        if (this.field_1104 != null) {
            for (var3 = 0; var3 < this.field_1105; ++var3) {
                var2.append("\n");
                var2.append(this.field_1104[var3].method_1850(var1 + 1));
            }
        }
        return var2.toString();
    }

    // $FF: renamed from: a () h.b
    public class_90 method_1870() {
        if (this.field_1103 > 0) {
            class_91[] var1 = new class_91[this.field_1103];
            for (int var2 = 0; var2 < this.field_1103; ++var2) {
                var1[var2] = this.field_1102[var2].method_1859();
            }
            this.field_1101.field_449 = var1;
        }
        if (this.field_1105 > 0) {
            int var6 = this.field_1101.field_450 == null ? 0 : this.field_1101.field_450.length;
            class_114[] var7 = new class_114[var6 + this.field_1105];
            if (var6 > 0) {
                System.arraycopy(this.field_1101.field_450, 0, var7, 0, var6);
            }
            if (this.field_1104[this.field_1105 - 1].field_1124.field_593 == 0) {
                this.field_1104[this.field_1105 - 1].field_1124.field_593 = this.field_1101.field_445;
                this.field_1104[this.field_1105 - 1].field_1124.field_595 = this.field_1101.field_445;
            }
            int var3 = var6;
            for (int var4 = 0; var4 < this.field_1105; ++var4) {
                class_114 var5 = this.field_1104[var4].method_1884();
                if ((var5.field_446 & 256) == 0) {
                    var7[var3++] = var5;
                }
            }
            if (var3 != this.field_1105) {
                System.arraycopy(var7, 0, var7 = new class_114[var6 + var3], 0, var6 + var3);
            }
            this.field_1101.field_450 = var7;
        }
        return this.field_1101;
    }

    // $FF: renamed from: a () void
    public void method_1855() {
        this.method_1870();
    }

    // $FF: renamed from: a (int, int) void
    public void method_1856(int var1, int var2) {
        if (this.field_1101.field_445 == 0) {
            this.field_1101.field_445 = var2;
        }
    }
}
