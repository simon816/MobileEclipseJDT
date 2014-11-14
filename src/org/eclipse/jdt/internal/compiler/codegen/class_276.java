package org.eclipse.jdt.internal.compiler.codegen;

public class class_276 {

    private double[] field_1522;

    private int[] field_1523;

    private int field_1524;

    public class_276() {
        this(13);
    }

    public class_276(int var1) {
        this.field_1524 = 0;
        this.field_1522 = new double[var1];
        this.field_1523 = new int[var1];
    }

    public void method_2495() {
        int var1 = this.field_1522.length;
        while (true) {
            --var1;
            if (var1 < 0) {
                this.field_1524 = 0;
                return;
            }
            this.field_1522[var1] = 0.0D;
            this.field_1523[var1] = 0;
        }
    }

    public int method_2496(double var1, int var3) {
        int var4;
        int var5;
        if (var1 == 0.0D) {
            var4 = 0;
            for (var5 = this.field_1524; var4 < var5; ++var4) {
                if (this.field_1522[var4] == 0.0D) {
                    long var6 = Double.doubleToLongBits(var1);
                    long var8 = Double.doubleToLongBits(this.field_1522[var4]);
                    if (var6 == Long.MIN_VALUE && var8 == Long.MIN_VALUE) {
                        return this.field_1523[var4];
                    }
                    if (var6 == 0L && var8 == 0L) {
                        return this.field_1523[var4];
                    }
                }
            }
        } else {
            var4 = 0;
            for (var5 = this.field_1524; var4 < var5; ++var4) {
                if (this.field_1522[var4] == var1) {
                    return this.field_1523[var4];
                }
            }
        }
        if (this.field_1524 == this.field_1522.length) {
            System.arraycopy(this.field_1522, 0, this.field_1522 = new double[this.field_1524 * 2], 0, this.field_1524);
            System.arraycopy(this.field_1523, 0, this.field_1523 = new int[this.field_1524 * 2], 0, this.field_1524);
        }
        this.field_1522[this.field_1524] = var1;
        this.field_1523[this.field_1524] = var3;
        ++this.field_1524;
        return -var3;
    }

    public String toString() {
        int var1 = this.field_1524;
        StringBuffer var2 = new StringBuffer();
        var2.append("{");
        for (int var3 = 0; var3 < var1; ++var3) {
            if (this.field_1522[var3] != 0.0D || this.field_1522[var3] == 0.0D && this.field_1523[var3] != 0) {
                var2.append(this.field_1522[var3]).append("->").append(this.field_1523[var3]);
            }
            if (var3 < var1) {
                var2.append(", ");
            }
        }
        var2.append("}");
        return var2.toString();
    }
}
