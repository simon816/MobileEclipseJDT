package i;

public class class_277 {

    public Object[] field_1525;

    public int[] field_1526;

    int field_1527;

    int field_1528;

    public class_277() {
        this(13);
    }

    public class_277(int var1) {
        this.field_1527 = 0;
        this.field_1528 = (int)((float)var1 * 0.66F);
        this.field_1525 = new Object[var1];
        this.field_1526 = new int[var1];
    }

    public int method_2499(Object var1) {
        int var2 = this.method_2500(var1);
        int var3 = this.field_1525.length;
        while (this.field_1525[var2] != null) {
            if (this.field_1525[var2] == var1) {
                return this.field_1526[var2];
            }
            ++var2;
            if (var2 == var3) {
                var2 = 0;
            }
        }
        return -1;
    }

    public int method_2500(Object var1) {
        return (var1.hashCode() & Integer.MAX_VALUE) % this.field_1525.length;
    }

    public int method_2501(Object var1, int var2) {
        int var3 = this.method_2500(var1);
        int var4 = this.field_1525.length;
        while (this.field_1525[var3] != null) {
            if (this.field_1525[var3] == var1) {
                return this.field_1526[var3] = var2;
            }
            ++var3;
            if (var3 == var4) {
                var3 = 0;
            }
        }
        this.field_1525[var3] = var1;
        this.field_1526[var3] = var2;
        if (++this.field_1527 > this.field_1528) {
            this.method_2502();
        }
        return var2;
    }

    private void method_2502() {
        class_277 var10000 = new class_277(this.field_1525.length * 2);
        class_277 var1 = var10000;
        int var2 = this.field_1525.length;
        while (true) {
            --var2;
            if (var2 < 0) {
                this.field_1525 = var1.field_1525;
                this.field_1526 = var1.field_1526;
                this.field_1528 = var1.field_1528;
                return;
            }
            if (this.field_1525[var2] != null) {
                var1.method_2501(this.field_1525[var2], this.field_1526[var2]);
            }
        }
    }

    public int method_2503() {
        return this.field_1527;
    }

    public String toString() {
        int var1 = this.method_2503();
        StringBuffer var2 = new StringBuffer();
        var2.append("{");
        for (int var3 = 0; var3 < var1; ++var3) {
            if (this.field_1525[var3] != null) {
                var2.append(this.field_1525[var3]).append("->").append(this.field_1526[var3]);
            }
            if (var3 < var1) {
                var2.append(", ");
            }
        }
        var2.append("}");
        return var2.toString();
    }
}
