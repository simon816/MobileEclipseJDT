package org.eclipse.jdt.internal.compiler.codegen;

public class FloatCache {

    private float[] keyTable;

    private int[] valueTable;

    private int elementSize;

    public FloatCache() {
        this(13);
    }

    public FloatCache(int var1) {
        this.elementSize = 0;
        this.keyTable = new float[var1];
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
            this.keyTable[var1] = 0.0F;
            this.valueTable[var1] = 0;
        }
    }

    public int method_2484(float var1, int var2) {
        int var3;
        int var4;
        if (var1 == 0.0F) {
            var3 = 0;
            for (var4 = this.elementSize; var3 < var4; ++var3) {
                if (this.keyTable[var3] == 0.0F) {
                    int var5 = Float.floatToIntBits(var1);
                    int var6 = Float.floatToIntBits(this.keyTable[var3]);
                    if (var5 == Integer.MIN_VALUE && var6 == Integer.MIN_VALUE) {
                        return this.valueTable[var3];
                    }
                    if (var5 == 0 && var6 == 0) {
                        return this.valueTable[var3];
                    }
                }
            }
        } else {
            var3 = 0;
            for (var4 = this.elementSize; var3 < var4; ++var3) {
                if (this.keyTable[var3] == var1) {
                    return this.valueTable[var3];
                }
            }
        }
        if (this.elementSize == this.keyTable.length) {
            System.arraycopy(this.keyTable, 0, this.keyTable = new float[this.elementSize * 2], 0, this.elementSize);
            System.arraycopy(this.valueTable, 0, this.valueTable = new int[this.elementSize * 2], 0, this.elementSize);
        }
        this.keyTable[this.elementSize] = var1;
        this.valueTable[this.elementSize] = var2;
        ++this.elementSize;
        return -var2;
    }

    public String toString() {
        int var1 = this.elementSize;
        StringBuffer var2 = new StringBuffer();
        var2.append("{");
        for (int var3 = 0; var3 < var1; ++var3) {
            if (this.keyTable[var3] != 0.0F || this.keyTable[var3] == 0.0F && this.valueTable[var3] != 0) {
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
