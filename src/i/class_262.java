package i;

import b.CharOperation;

public class class_262 {

    public char[][] field_1153;

    public int[] field_1154;

    int field_1155;

    int field_1156;

    public class_262() {
        this(9);
    }

    public class_262(int var1) {
        this.field_1155 = 0;
        this.field_1156 = var1 * 2 / 3;
        this.field_1153 = new char[var1][];
        this.field_1154 = new int[var1];
    }

    public void method_1894() {
        int var1 = this.field_1153.length;
        while (true) {
            --var1;
            if (var1 < 0) {
                this.field_1155 = 0;
                return;
            }
            this.field_1153[var1] = null;
            this.field_1154[var1] = 0;
        }
    }

    public int method_1895(char[] var1) {
        int var2 = this.field_1153.length;
        int var3 = CharOperation.method_1369(var1) % var2;
        while (this.field_1153[var3] != null) {
            if (CharOperation.method_1364(this.field_1153[var3], var1)) {
                return this.field_1154[var3];
            }
            ++var3;
            if (var3 == var2) {
                var3 = 0;
            }
        }
        return -1;
    }

    public int method_1896(char[] var1, int var2) {
        int var3 = this.field_1153.length;
        int var4 = CharOperation.method_1369(var1) % var3;
        while (this.field_1153[var4] != null) {
            if (CharOperation.method_1364(this.field_1153[var4], var1)) {
                return this.field_1154[var4];
            }
            ++var4;
            if (var4 == var3) {
                var4 = 0;
            }
        }
        this.field_1153[var4] = var1;
        this.field_1154[var4] = var2;
        if (++this.field_1155 > this.field_1156) {
            this.method_1898();
        }
        return -var2;
    }

    private int method_1897(char[] var1, int var2) {
        int var3 = this.field_1153.length;
        int var4 = CharOperation.method_1369(var1) % var3;
        while (this.field_1153[var4] != null) {
            if (CharOperation.method_1364(this.field_1153[var4], var1)) {
                return this.field_1154[var4] = var2;
            }
            ++var4;
            if (var4 == var3) {
                var4 = 0;
            }
        }
        this.field_1153[var4] = var1;
        this.field_1154[var4] = var2;
        if (++this.field_1155 > this.field_1156) {
            this.method_1898();
        }
        return var2;
    }

    private void method_1898() {
        class_262 var10000 = new class_262(this.field_1153.length * 2);
        class_262 var1 = var10000;
        int var2 = this.field_1153.length;
        while (true) {
            --var2;
            if (var2 < 0) {
                this.field_1153 = var1.field_1153;
                this.field_1154 = var1.field_1154;
                this.field_1156 = var1.field_1156;
                return;
            }
            if (this.field_1153[var2] != null) {
                var1.method_1897(this.field_1153[var2], this.field_1154[var2]);
            }
        }
    }

    public void method_1899(char[] var1) {
        int var2 = this.field_1153.length;
        int var3 = CharOperation.method_1369(var1) % var2;
        while (this.field_1153[var3] != null) {
            if (CharOperation.method_1364(this.field_1153[var3], var1)) {
                this.field_1154[var3] = 0;
                this.field_1153[var3] = null;
                return;
            }
            ++var3;
            if (var3 == var2) {
                var3 = 0;
            }
        }
    }

    public char[] method_1900(int var1) {
        int var2 = this.field_1153.length;
        do {
            if (var2-- <= 0) {
                return null;
            }
        } while (this.field_1154[var2] != var1);
        return this.field_1153[var2];
    }

    public int method_1901() {
        return this.field_1155;
    }

    public String toString() {
        int var1 = this.method_1901();
        StringBuffer var2 = new StringBuffer();
        var2.append("{");
        for (int var3 = 0; var3 < var1; ++var3) {
            if (this.field_1153[var3] != null) {
                var2.append(this.field_1153[var3]).append("->").append(this.field_1154[var3]);
            }
            if (var3 < var1) {
                var2.append(", ");
            }
        }
        var2.append("}");
        return var2.toString();
    }
}
