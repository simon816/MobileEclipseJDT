package f;

// $FF: renamed from: f.h
public final class class_322 {

    // $FF: renamed from: a int[]
    public int[] field_1833;
    // $FF: renamed from: a int
    public int field_1834;
    // $FF: renamed from: b int
    int field_1835;

    // $FF: renamed from: <init> () void
    public class_322() {
        this(13);
    }

    // $FF: renamed from: <init> (int) void
    public class_322(int var1) {
        this.field_1834 = 0;
        this.field_1835 = var1;
        int var2 = (int)((float)var1 * 1.75F);
        if (this.field_1835 == var2) {
            ++var2;
        }
        this.field_1833 = new int[var2];
    }

    // $FF: renamed from: a (int) boolean
    public boolean method_3209(int var1) {
        int var2 = this.field_1833.length;
        int var3 = var1 % var2;
        int var4;
        while ((var4 = this.field_1833[var3]) != 0) {
            if (var4 == var1) {
                return true;
            }
            ++var3;
            if (var3 == var2) {
                var3 = 0;
            }
        }
        return false;
    }

    // $FF: renamed from: a (int) int
    public int method_3210(int var1) {
        int var2 = this.field_1833.length;
        int var3 = var1 % var2;
        int var4;
        while ((var4 = this.field_1833[var3]) != 0) {
            if (var4 == var1) {
                return this.field_1833[var3] = var1;
            }
            ++var3;
            if (var3 == var2) {
                var3 = 0;
            }
        }
        this.field_1833[var3] = var1;
        if (++this.field_1834 > this.field_1835) {
            this.method_3211();
        }
        return var1;
    }

    // $FF: renamed from: a () void
    private void method_3211() {
        class_322 var10000 = new class_322(this.field_1834 * 2);
        class_322 var1 = var10000;
        int var3 = this.field_1833.length;
        while (true) {
            --var3;
            if (var3 < 0) {
                this.field_1833 = var1.field_1833;
                this.field_1835 = var1.field_1835;
                return;
            }
            int var2;
            if ((var2 = this.field_1833[var3]) != 0) {
                var1.method_3210(var2);
            }
        }
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        int var3 = 0;
        for (int var4 = this.field_1833.length; var3 < var4; ++var3) {
            int var2;
            if ((var2 = this.field_1833[var3]) != 0) {
                var1.append(var2);
                if (var3 != var4 - 1) {
                    var1.append('\n');
                }
            }
        }
        return var1.toString();
    }
}
