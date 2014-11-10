package f;

import b.class_233;
import m.class_38;

public final class class_324 {

    public char[][] field_1840;

    public class_38[] field_1841;

    public int field_1842;

    int field_1843;

    public class_324() {
        this(3);
    }

    public class_324(int var1) {
        this.field_1842 = 0;
        this.field_1843 = var1;
        int var2 = (int)((float)var1 * 1.75F);
        if (this.field_1843 == var2) {
            ++var2;
        }
        this.field_1840 = new char[var2][];
        this.field_1841 = new class_38[var2];
    }

    public class_38 method_3219(char[] var1) {
        int var2 = this.field_1840.length;
        int var3 = class_233.method_1369(var1) % var2;
        int var4 = var1.length;
        char[] var5;
        while ((var5 = this.field_1840[var3]) != null) {
            if (var5.length == var4 && class_233.method_1364(var5, var1)) {
                return this.field_1841[var3];
            }
            ++var3;
            if (var3 == var2) {
                var3 = 0;
            }
        }
        return null;
    }

    public class_38 method_3220(char[] var1, class_38 var2) {
        int var3 = this.field_1840.length;
        int var4 = class_233.method_1369(var1) % var3;
        int var5 = var1.length;
        char[] var6;
        while ((var6 = this.field_1840[var4]) != null) {
            if (var6.length == var5 && class_233.method_1364(var6, var1)) {
                return this.field_1841[var4] = var2;
            }
            ++var4;
            if (var4 == var3) {
                var4 = 0;
            }
        }
        this.field_1840[var4] = var1;
        this.field_1841[var4] = var2;
        if (++this.field_1842 > this.field_1843) {
            this.method_3221();
        }
        return var2;
    }

    private void method_3221() {
        class_324 var10000 = new class_324(this.field_1842 * 2);
        class_324 var1 = var10000;
        int var3 = this.field_1840.length;
        while (true) {
            --var3;
            if (var3 < 0) {
                this.field_1840 = var1.field_1840;
                this.field_1841 = var1.field_1841;
                this.field_1843 = var1.field_1843;
                return;
            }
            char[] var2;
            if ((var2 = this.field_1840[var3]) != null) {
                var1.method_3220(var2, this.field_1841[var3]);
            }
        }
    }

    public String toString() {
        String var1 = "";
        int var3 = 0;
        for (int var4 = this.field_1841.length; var3 < var4; ++var3) {
            class_38 var2;
            if ((var2 = this.field_1841[var3]) != null) {
                var1 = var1 + var2.toString() + "\n";
            }
        }
        return var1;
    }
}
