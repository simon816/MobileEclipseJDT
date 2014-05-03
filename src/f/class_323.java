package f;

// $FF: renamed from: f.g
public final class class_323 {

    // $FF: renamed from: a int[]
    public int[] field_1836;
    // $FF: renamed from: a java.lang.Object[]
    public Object[] field_1837;
    // $FF: renamed from: a int
    public int field_1838;
    // $FF: renamed from: b int
    int field_1839;

    // $FF: renamed from: <init> () void
    public class_323() {
        this(13);
    }

    // $FF: renamed from: <init> (int) void
    public class_323(int var1) {
        this.field_1838 = 0;
        this.field_1839 = var1;
        int var2 = (int)((float)var1 * 1.75F);
        if (this.field_1839 == var2) {
            ++var2;
        }
        this.field_1836 = new int[var2];
        this.field_1837 = new Object[var2];
    }

    // $FF: renamed from: a (int) java.lang.Object
    public Object method_3214(int var1) {
        int var2 = this.field_1836.length;
        int var3 = var1 % var2;
        int var4;
        while ((var4 = this.field_1836[var3]) != 0) {
            if (var4 == var1) {
                return this.field_1837[var3];
            }
            ++var3;
            if (var3 == var2) {
                var3 = 0;
            }
        }
        return null;
    }

    // $FF: renamed from: a (int, java.lang.Object) java.lang.Object
    public Object method_3215(int var1, Object var2) {
        int var3 = this.field_1836.length;
        int var4 = var1 % var3;
        int var5;
        while ((var5 = this.field_1836[var4]) != 0) {
            if (var5 == var1) {
                return this.field_1837[var4] = var2;
            }
            ++var4;
            if (var4 == var3) {
                var4 = 0;
            }
        }
        this.field_1836[var4] = var1;
        this.field_1837[var4] = var2;
        if (++this.field_1838 > this.field_1839) {
            this.method_3216();
        }
        return var2;
    }

    // $FF: renamed from: a () void
    private void method_3216() {
        class_323 var10000 = new class_323(this.field_1838 * 2);
        class_323 var1 = var10000;
        int var3 = this.field_1836.length;
        while (true) {
            --var3;
            if (var3 < 0) {
                this.field_1836 = var1.field_1836;
                this.field_1837 = var1.field_1837;
                this.field_1839 = var1.field_1839;
                return;
            }
            int var2;
            if ((var2 = this.field_1836[var3]) != 0) {
                var1.method_3215(var2, this.field_1837[var3]);
            }
        }
    }

    public String toString() {
        String var1 = "";
        int var3 = 0;
        for (int var4 = this.field_1837.length; var3 < var4; ++var3) {
            Object var2;
            if ((var2 = this.field_1837[var3]) != null) {
                var1 = var1 + this.field_1836[var3] + " -> " + var2.toString() + "\n";
            }
        }
        return var1;
    }
}
