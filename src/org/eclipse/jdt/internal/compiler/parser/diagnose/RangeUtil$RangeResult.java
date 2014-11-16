package org.eclipse.jdt.internal.compiler.parser.diagnose;

class RangeUtil$RangeResult {

    int pos;

    int[] field_991;

    int[] field_992;

    int[] field_993;

    RangeUtil$RangeResult() {
        this.pos = 0;
        this.field_991 = new int[10];
        this.field_992 = new int[10];
        this.field_993 = new int[10];
    }

    void addInterval(int var1, int var2) {
        this.addInterval(var1, var2, 0);
    }

    void addInterval(int var1, int var2, int var3) {
        if (this.pos >= this.field_991.length) {
            System.arraycopy(this.field_991, 0, this.field_991 = new int[this.pos * 2], 0, this.pos);
            System.arraycopy(this.field_992, 0, this.field_992 = new int[this.pos * 2], 0, this.pos);
            System.arraycopy(this.field_993, 0, this.field_993 = new int[this.pos * 2], 0, this.pos);
        }
        this.field_991[this.pos] = var1;
        this.field_992[this.pos] = var2;
        this.field_993[this.pos] = var3;
        ++this.pos;
    }

    int[][] getRanges() {
        int[] var1 = new int[this.pos];
        int[] var2 = new int[this.pos];
        int[] var3 = new int[this.pos];
        System.arraycopy(this.field_991, 0, var1, 0, this.pos);
        System.arraycopy(this.field_992, 0, var2, 0, this.pos);
        System.arraycopy(this.field_993, 0, var3, 0, this.pos);
        if (var1.length > 1) {
            this.quickSort(var1, var2, var3, 0, var1.length - 1);
        }
        return new int[][] {var1, var2, var3};
    }

    private void quickSort(int[] var1, int[] var2, int[] var3, int var4, int var5) {
        int var6 = var4;
        int var7 = var5;
        int var8 = var1[var4 + (var5 - var4) / 2];
        while (true) {
            while (this.compare(var1[var4], var8) >= 0) {
                while (this.compare(var8, var1[var5]) < 0) {
                    --var5;
                }
                if (var4 <= var5) {
                    int var9 = var1[var4];
                    var1[var4] = var1[var5];
                    var1[var5] = var9;
                    var9 = var2[var4];
                    var2[var4] = var2[var5];
                    var2[var5] = var9;
                    var9 = var3[var4];
                    var3[var4] = var3[var5];
                    var3[var5] = var9;
                    ++var4;
                    --var5;
                }
                if (var4 > var5) {
                    if (var6 < var5) {
                        this.quickSort(var1, var2, var3, var6, var5);
                    }
                    if (var4 < var7) {
                        this.quickSort(var1, var2, var3, var4, var7);
                    }
                    return;
                }
            }
            ++var4;
        }
    }

    private int compare(int var1, int var2) {
        return var1 - var2;
    }
}
