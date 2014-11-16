package org.eclipse.jdt.internal.compiler.codegen;

public class DoubleCache {

    private double[] keyTable;

    private int[] valueTable;

    private int elementSize;

    public DoubleCache() {
        this(13);
    }

    public DoubleCache(int var1) {
        this.elementSize = 0;
        this.keyTable = new double[var1];
        this.valueTable = new int[var1];
    }

    public void clear() {
        int var1 = this.keyTable.length;
        while (true) {
            --var1;
            if (var1 < 0) {
                this.elementSize = 0;
                return;
            }
            this.keyTable[var1] = 0.0D;
            this.valueTable[var1] = 0;
        }
    }

    public int method_2496(double var1, int var3) {
        int var4;
        int var5;
        if (var1 == 0.0D) {
            var4 = 0;
            for (var5 = this.elementSize; var4 < var5; ++var4) {
                if (this.keyTable[var4] == 0.0D) {
                    long var6 = Double.doubleToLongBits(var1);
                    long var8 = Double.doubleToLongBits(this.keyTable[var4]);
                    if (var6 == Long.MIN_VALUE && var8 == Long.MIN_VALUE) {
                        return this.valueTable[var4];
                    }
                    if (var6 == 0L && var8 == 0L) {
                        return this.valueTable[var4];
                    }
                }
            }
        } else {
            var4 = 0;
            for (var5 = this.elementSize; var4 < var5; ++var4) {
                if (this.keyTable[var4] == var1) {
                    return this.valueTable[var4];
                }
            }
        }
        if (this.elementSize == this.keyTable.length) {
            System.arraycopy(this.keyTable, 0, this.keyTable = new double[this.elementSize * 2], 0, this.elementSize);
            System.arraycopy(this.valueTable, 0, this.valueTable = new int[this.elementSize * 2], 0, this.elementSize);
        }
        this.keyTable[this.elementSize] = var1;
        this.valueTable[this.elementSize] = var3;
        ++this.elementSize;
        return -var3;
    }

    public String toString() {
        int var1 = this.elementSize;
        StringBuffer var2 = new StringBuffer();
        var2.append("{");
        for (int var3 = 0; var3 < var1; ++var3) {
            if (this.keyTable[var3] != 0.0D || this.keyTable[var3] == 0.0D && this.valueTable[var3] != 0) {
                var2.append(this.keyTable[var3]).append("->").append(this.valueTable[var3]);
            }
            if (var3 < var1) {
                var2.append(", ");
            }
        }
        var2.append("}");
        return var2.toString();
    }
}
