package d;

class class_231 {

    int field_990;

    int[] field_991;

    int[] field_992;

    int[] field_993;

    class_231() {
        this.field_990 = 0;
        this.field_991 = new int[10];
        this.field_992 = new int[10];
        this.field_993 = new int[10];
    }

    void method_1345(int var1, int var2) {
        this.method_1346(var1, var2, 0);
    }

    void method_1346(int var1, int var2, int var3) {
        if (this.field_990 >= this.field_991.length) {
            System.arraycopy(this.field_991, 0, this.field_991 = new int[this.field_990 * 2], 0, this.field_990);
            System.arraycopy(this.field_992, 0, this.field_992 = new int[this.field_990 * 2], 0, this.field_990);
            System.arraycopy(this.field_993, 0, this.field_993 = new int[this.field_990 * 2], 0, this.field_990);
        }
        this.field_991[this.field_990] = var1;
        this.field_992[this.field_990] = var2;
        this.field_993[this.field_990] = var3;
        ++this.field_990;
    }

    int[][] method_1347() {
        int[] var1 = new int[this.field_990];
        int[] var2 = new int[this.field_990];
        int[] var3 = new int[this.field_990];
        System.arraycopy(this.field_991, 0, var1, 0, this.field_990);
        System.arraycopy(this.field_992, 0, var2, 0, this.field_990);
        System.arraycopy(this.field_993, 0, var3, 0, this.field_990);
        if (var1.length > 1) {
            this.method_1348(var1, var2, var3, 0, var1.length - 1);
        }
        return new int[][] {var1, var2, var3};
    }

    private void method_1348(int[] var1, int[] var2, int[] var3, int var4, int var5) {
        int var6 = var4;
        int var7 = var5;
        int var8 = var1[var4 + (var5 - var4) / 2];
        while (true) {
            while (this.method_1349(var1[var4], var8) >= 0) {
                while (this.method_1349(var8, var1[var5]) < 0) {
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
                        this.method_1348(var1, var2, var3, var6, var5);
                    }
                    if (var4 < var7) {
                        this.method_1348(var1, var2, var3, var4, var7);
                    }
                    return;
                }
            }
            ++var4;
        }
    }

    private int method_1349(int var1, int var2) {
        return var1 - var2;
    }
}
