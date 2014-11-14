package org.eclipse.jdt.internal.compiler.codegen;

public class class_275 {

    public int[] field_1518;

    public int[] field_1519;

    int field_1520;

    int field_1521;

    public class_275() {
        this(13);
    }

    public class_275(int var1) {
        this.field_1520 = 0;
        this.field_1521 = (int)((double)var1 * 0.66D);
        this.field_1518 = new int[var1];
        this.field_1519 = new int[var1];
    }

    public void method_2487() {
        int var1 = this.field_1518.length;
        while (true) {
            --var1;
            if (var1 < 0) {
                this.field_1520 = 0;
                return;
            }
            this.field_1518[var1] = 0;
            this.field_1519[var1] = 0;
        }
    }

    public int method_2488(int var1) {
        return (var1 & Integer.MAX_VALUE) % this.field_1518.length;
    }

    public int method_2489(int var1, int var2) {
        int var3 = this.method_2488(var1);
        int var4 = this.field_1518.length;
        while (this.field_1518[var3] != 0 || this.field_1518[var3] == 0 && this.field_1519[var3] != 0) {
            if (this.field_1518[var3] == var1) {
                return this.field_1519[var3] = var2;
            }
            ++var3;
            if (var3 == var4) {
                var3 = 0;
            }
        }
        this.field_1518[var3] = var1;
        this.field_1519[var3] = var2;
        if (++this.field_1520 > this.field_1521) {
            this.method_2491();
        }
        return var2;
    }

    public int method_2490(int var1, int var2) {
        int var3 = this.method_2488(var1);
        int var4 = this.field_1518.length;
        while (this.field_1518[var3] != 0 || this.field_1518[var3] == 0 && this.field_1519[var3] != 0) {
            if (this.field_1518[var3] == var1) {
                return this.field_1519[var3];
            }
            ++var3;
            if (var3 == var4) {
                var3 = 0;
            }
        }
        this.field_1518[var3] = var1;
        this.field_1519[var3] = var2;
        if (++this.field_1520 > this.field_1521) {
            this.method_2491();
        }
        return -var2;
    }

    private void method_2491() {
        class_275 var10000 = new class_275(this.field_1518.length * 2);
        class_275 var1 = var10000;
        int var2 = this.field_1518.length;
        while (true) {
            --var2;
            if (var2 < 0) {
                this.field_1518 = var1.field_1518;
                this.field_1519 = var1.field_1519;
                this.field_1521 = var1.field_1521;
                return;
            }
            int var3 = this.field_1518[var2];
            int var4 = this.field_1519[var2];
            if (var3 != 0 || var3 == 0 && var4 != 0) {
                var1.method_2489(var3, var4);
            }
        }
    }

    public int method_2492() {
        return this.field_1520;
    }

    public String toString() {
        int var1 = this.method_2492();
        StringBuffer var2 = new StringBuffer();
        var2.append("{");
        for (int var3 = 0; var3 < var1; ++var3) {
            if (this.field_1518[var3] != 0 || this.field_1518[var3] == 0 && this.field_1519[var3] != 0) {
                var2.append(this.field_1518[var3]).append("->").append(this.field_1519[var3]);
            }
            if (var3 < var1) {
                var2.append(", ");
            }
        }
        var2.append("}");
        return var2.toString();
    }
}
