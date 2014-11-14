package org.eclipse.jdt.internal.compiler.codegen;

public class class_76 {

    public long[] field_332;

    public int[] field_333;

    int field_334;

    int field_335;

    public class_76() {
        this(13);
    }

    public class_76(int var1) {
        this.field_334 = 0;
        this.field_335 = (int)((double)var1 * 0.66D);
        this.field_332 = new long[var1];
        this.field_333 = new int[var1];
    }

    public void method_462() {
        int var1 = this.field_332.length;
        while (true) {
            --var1;
            if (var1 < 0) {
                this.field_334 = 0;
                return;
            }
            this.field_332[var1] = 0L;
            this.field_333[var1] = 0;
        }
    }

    public int method_463(long var1) {
        return ((int)var1 & Integer.MAX_VALUE) % this.field_332.length;
    }

    public int method_464(long var1, int var3) {
        int var4 = this.method_463(var1);
        int var5 = this.field_332.length;
        while (this.field_332[var4] != 0L || this.field_332[var4] == 0L && this.field_333[var4] != 0) {
            if (this.field_332[var4] == var1) {
                return this.field_333[var4] = var3;
            }
            ++var4;
            if (var4 == var5) {
                var4 = 0;
            }
        }
        this.field_332[var4] = var1;
        this.field_333[var4] = var3;
        if (++this.field_334 > this.field_335) {
            this.method_466();
        }
        return var3;
    }

    public int method_465(long var1, int var3) {
        int var4 = this.method_463(var1);
        int var5 = this.field_332.length;
        while (this.field_332[var4] != 0L || this.field_332[var4] == 0L && this.field_333[var4] != 0) {
            if (this.field_332[var4] == var1) {
                return this.field_333[var4];
            }
            ++var4;
            if (var4 == var5) {
                var4 = 0;
            }
        }
        this.field_332[var4] = var1;
        this.field_333[var4] = var3;
        if (++this.field_334 > this.field_335) {
            this.method_466();
        }
        return -var3;
    }

    private void method_466() {
        class_76 var10000 = new class_76(this.field_332.length * 2);
        class_76 var1 = var10000;
        int var2 = this.field_332.length;
        while (true) {
            --var2;
            if (var2 < 0) {
                this.field_332 = var1.field_332;
                this.field_333 = var1.field_333;
                this.field_335 = var1.field_335;
                return;
            }
            long var3 = this.field_332[var2];
            int var5 = this.field_333[var2];
            if (var3 != 0L || var3 == 0L && var5 != 0) {
                var1.method_464(var3, var5);
            }
        }
    }

    public int method_467() {
        return this.field_334;
    }

    public String toString() {
        int var1 = this.method_467();
        StringBuffer var2 = new StringBuffer();
        var2.append("{");
        for (int var3 = 0; var3 < var1; ++var3) {
            if (this.field_332[var3] != 0L || this.field_332[var3] == 0L && this.field_333[var3] != 0) {
                var2.append(this.field_332[var3]).append("->").append(this.field_333[var3]);
            }
            if (var3 < var1) {
                var2.append(", ");
            }
        }
        var2.append("}");
        return var2.toString();
    }
}
