package m;

import a.class_331;
import h.class_124;
import h.class_164;
import h.class_89;
import m.class_203;
import m.class_34;
import m.class_40;
import m.class_54;
import m.class_64;
import m.class_86;

// $FF: renamed from: m.ab
public class class_65 extends class_64 {

    // $FF: renamed from: a int
    public int field_306;
    // $FF: renamed from: d int
    public int field_307;
    // $FF: renamed from: a m.v
    public class_86 field_308;
    // $FF: renamed from: a h.ac
    public class_124 field_309;
    // $FF: renamed from: a int[]
    public int[] field_310;
    // $FF: renamed from: e int
    public int field_311;

    // $FF: renamed from: <init> (char[], m.s, int, boolean) void
    public class_65(char[] var1, class_40 var2, int var3, boolean var4) {
        super(var1, var2, var3, var4 ? class_331.field_1896 : null);
        this.field_311 = 0;
        if (var4) {
            this.field_305 |= 1024L;
        }
    }

    // $FF: renamed from: <init> (h.ac, m.s, int, boolean) void
    public class_65(class_124 var1, class_40 var2, int var3, boolean var4) {
        this(var1.field_659, var2, var3, var4);
        this.field_309 = var1;
    }

    // $FF: renamed from: a () int
    public final int method_98() {
        return 2;
    }

    // $FF: renamed from: a () m.bf[]
    public class_203[] method_413() {
        int var4;
        if (this.field_308 == null) {
            if ((this.field_305 & 8589934592L) != 0L) {
                if (this.field_309 == null) {
                    return class_34.field_158;
                }
                class_164[] var6 = this.field_309.field_658;
                if (var6 != null) {
                    int var7 = var6.length;
                    class_203[] var8 = new class_203[var7];
                    for (var4 = 0; var4 < var7; ++var4) {
                        class_203 var9 = var6[var4].method_1073();
                        if (var9 == null) {
                            return class_34.field_158;
                        }
                        var8[var4] = var9;
                    }
                    return var8;
                }
            }
            return class_34.field_158;
        } else {
            class_54 var1 = this.field_308.method_585();
            if (var1 == null) {
                return class_34.field_158;
            } else {
                class_203[] var2 = var1.method_235(this);
                if ((this.field_305 & 8589934592L) == 0L && (this.field_305 & 1024L) != 0L && this.field_309 != null) {
                    class_164[] var3 = this.field_309.field_658;
                    if (var3 != null) {
                        var4 = var3.length;
                        class_89.method_761(this.field_308, var3, this);
                        var2 = new class_203[var4];
                        for (int var5 = 0; var5 < var4; ++var5) {
                            class_203 var10002 = new class_203(var3[var5]);
                            var2[var5] = var10002;
                        }
                        this.method_416(var2);
                    }
                }
                return var2;
            }
        }
    }

    // $FF: renamed from: a (int) void
    public void method_414(int var1) {
        if (this.field_310[(this.field_311 - 1 << 1) + 1] == -1) {
            this.field_310[(this.field_311 - 1 << 1) + 1] = var1;
        }
    }

    // $FF: renamed from: b (int) void
    public void method_415(int var1) {
        if (this.field_310 != null) {
            int var2;
            if (this.field_311 > 0) {
                var2 = this.field_310[(this.field_311 - 1 << 1) + 1];
                if (var2 == -1) {
                    return;
                }
                if (var2 == var1) {
                    this.field_310[(this.field_311 - 1 << 1) + 1] = -1;
                    return;
                }
            }
            var2 = this.field_311 << 1;
            if (var2 == this.field_310.length) {
                System.arraycopy(this.field_310, 0, this.field_310 = new int[this.field_311 << 2], 0, var2);
            }
            this.field_310[var2] = var1;
            this.field_310[var2 + 1] = -1;
            ++this.field_311;
        }
    }

    // $FF: renamed from: a (m.bf[]) void
    public void method_416(class_203[] var1) {
        if (this.field_308 != null) {
            class_54 var2 = this.field_308.method_585();
            if (var2 != null) {
                var2.method_238(this, var1);
            }
        }
    }

    public String toString() {
        String var1 = super.toString();
        switch (this.field_307) {
            case 0:
                var1 = var1 + "[pos: unused]";
                break;
            case 1:
                var1 = var1 + "[pos: " + this.field_306 + "]";
                break;
            case 2:
                var1 = var1 + "[pos: fake_used]";
        }
        var1 = var1 + "[id:" + this.field_304 + "]";
        if (this.field_311 > 0) {
            var1 = var1 + "[pc: ";
            for (int var2 = 0; var2 < this.field_311; ++var2) {
                if (var2 > 0) {
                    var1 = var1 + ", ";
                }
                var1 = var1 + String.valueOf(this.field_310[var2 << 1]) + "-" + (this.field_310[(var2 << 1) + 1] == -1 ? "?" : String.valueOf(this.field_310[(var2 << 1) + 1]));
            }
            var1 = var1 + "]";
        }
        return var1;
    }
}
