package j;

import h.class_124;
import h.class_126;
import h.class_149;
import h.class_152;
import h.class_164;
import h.class_89;
import h.class_98;
import j.class_251;
import j.class_257;
import j.class_258;

// $FF: renamed from: j.p
public class class_259 extends class_258 {

    // $FF: renamed from: a j.g[]
    public class_257[] field_1118;
    // $FF: renamed from: a int
    public int field_1119;
    // $FF: renamed from: b int
    public int field_1120;
    // $FF: renamed from: c int
    public int field_1121;
    // $FF: renamed from: a h.ac
    public class_124 field_1122;
    // $FF: renamed from: a boolean
    boolean field_1123;

    // $FF: renamed from: <init> (h.ac, j.e, int) void
    public class_259(class_124 var1, class_251 var2, int var3) {
        super(var1, var2, var3);
        this.field_1122 = var1;
        this.field_1123 = var1.field_655 != null;
    }

    // $FF: renamed from: a (h.bf, int) j.e
    public class_251 method_1837(class_98 var1, int var2) {
        if (!this.field_1123 && var1 instanceof class_126) {
            this.field_1123 = true;
            this.field_1122.field_655 = (class_126)var1;
            this.field_1122.field_652 = var1.field_445;
            this.field_1122.field_651 = var1.field_445;
            return this;
        } else {
            return super.method_1837(var1, var2);
        }
    }

    // $FF: renamed from: a (j.g[], int, int, int) void
    public void method_1878(class_257[] var1, int var2, int var3, int var4) {
        if (var2 > 0) {
            class_164[] var5 = this.field_1122.field_658;
            if (var5 != null) {
                this.field_1118 = new class_257[var2];
                this.field_1119 = 0;
                label33:
                for (int var6 = 0; var6 < var2; ++var6) {
                    for (int var7 = 0; var7 < var5.length; ++var7) {
                        if (var1[var6].field_1116 == var5[var7]) {
                            continue label33;
                        }
                    }
                    this.field_1118[this.field_1119++] = var1[var6];
                }
            } else {
                this.field_1118 = var1;
                this.field_1119 = var2;
            }
        }
        if (var3 != 0) {
            this.field_1120 = var3;
            this.field_1121 = var4;
        }
    }

    // $FF: renamed from: a () h.cj
    public class_89 method_1845() {
        return this.field_1122;
    }

    // $FF: renamed from: a (int) java.lang.String
    public String method_1850(int var1) {
        return this.method_1848(var1) + "Recovered local variable:\n" + this.field_1122.method_757(var1 + 1, new StringBuffer(10));
    }

    // $FF: renamed from: a () h.bf
    public class_98 method_1876() {
        if (this.field_1120 != 0) {
            this.field_1122.field_656 |= this.field_1120;
            if (this.field_1121 < this.field_1122.field_653) {
                this.field_1122.field_653 = this.field_1121;
            }
        }
        if (this.field_1119 > 0) {
            int var1 = this.field_1122.field_658 == null ? 0 : this.field_1122.field_658.length;
            class_164[] var2 = new class_164[var1 + this.field_1119];
            if (var1 > 0) {
                System.arraycopy(this.field_1122.field_658, 0, var2, this.field_1119, var1);
            }
            int var3;
            for (var3 = 0; var3 < this.field_1119; ++var3) {
                var2[var3] = this.field_1118[var3].method_1874();
            }
            this.field_1122.field_658 = var2;
            var3 = this.field_1118[0].field_1116.field_444;
            if (var3 < this.field_1122.field_653) {
                this.field_1122.field_653 = var3;
            }
        }
        return this.field_1122;
    }

    // $FF: renamed from: a (int, int) j.e
    public class_251 method_1853(int var1, int var2) {
        if (this.field_1069 > 0) {
            --this.field_1069;
            if (this.field_1069 == 0) {
                this.field_1123 = true;
            }
            return this;
        } else {
            return (class_251)(this.field_1068 != null ? this.field_1068.method_1853(var1, var2) : this);
        }
    }

    // $FF: renamed from: b (int, int) j.e
    public class_251 method_1854(int var1, int var2) {
        if (this.field_1122.field_652 == 0 && (this.field_1122.field_660 instanceof class_149 || this.field_1122.field_660 instanceof class_152) && !this.field_1123) {
            ++this.field_1069;
            return null;
        } else {
            this.method_1856(var1 - 1, var2 - 1);
            return this.field_1068.method_1854(var1, var2);
        }
    }

    // $FF: renamed from: a () void
    public void method_1855() {
        this.method_1876();
    }

    // $FF: renamed from: a (int, int) void
    public void method_1856(int var1, int var2) {
        if (this.field_1122.field_652 == 0) {
            this.field_1122.field_652 = var2;
            this.field_1122.field_651 = var2;
        }
    }
}
