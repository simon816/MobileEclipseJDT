package f;

import b.class_233;

// $FF: renamed from: f.e
public final class class_325 {

    // $FF: renamed from: a char[][]
    public char[][] field_1844;
    // $FF: renamed from: a java.lang.Object[]
    public Object[] field_1845;
    // $FF: renamed from: a int
    public int field_1846;
    // $FF: renamed from: b int
    int field_1847;

    // $FF: renamed from: <init> () void
    public class_325() {
        this(13);
    }

    // $FF: renamed from: <init> (int) void
    public class_325(int var1) {
        this.field_1846 = 0;
        this.field_1847 = var1;
        int var2 = (int)((float)var1 * 1.75F);
        if (this.field_1847 == var2) {
            ++var2;
        }
        this.field_1844 = new char[var2][];
        this.field_1845 = new Object[var2];
    }

    // $FF: renamed from: a () void
    public void method_3224() {
        int var1 = this.field_1844.length;
        while (true) {
            --var1;
            if (var1 < 0) {
                this.field_1846 = 0;
                return;
            }
            this.field_1844[var1] = null;
            this.field_1845[var1] = null;
        }
    }

    // $FF: renamed from: a (char[]) boolean
    public boolean method_3225(char[] var1) {
        int var2 = this.field_1844.length;
        int var3 = class_233.method_1369(var1) % var2;
        int var4 = var1.length;
        char[] var5;
        while ((var5 = this.field_1844[var3]) != null) {
            if (var5.length == var4 && class_233.method_1364(var5, var1)) {
                return true;
            }
            ++var3;
            if (var3 == var2) {
                var3 = 0;
            }
        }
        return false;
    }

    // $FF: renamed from: a (char[]) java.lang.Object
    public Object method_3226(char[] var1) {
        int var2 = this.field_1844.length;
        int var3 = class_233.method_1369(var1) % var2;
        int var4 = var1.length;
        char[] var5;
        while ((var5 = this.field_1844[var3]) != null) {
            if (var5.length == var4 && class_233.method_1364(var5, var1)) {
                return this.field_1845[var3];
            }
            ++var3;
            if (var3 == var2) {
                var3 = 0;
            }
        }
        return null;
    }

    // $FF: renamed from: a (char[], java.lang.Object) java.lang.Object
    public Object method_3227(char[] var1, Object var2) {
        int var3 = this.field_1844.length;
        int var4 = class_233.method_1369(var1) % var3;
        int var5 = var1.length;
        char[] var6;
        while ((var6 = this.field_1844[var4]) != null) {
            if (var6.length == var5 && class_233.method_1364(var6, var1)) {
                return this.field_1845[var4] = var2;
            }
            ++var4;
            if (var4 == var3) {
                var4 = 0;
            }
        }
        this.field_1844[var4] = var1;
        this.field_1845[var4] = var2;
        if (++this.field_1846 > this.field_1847) {
            this.method_3228();
        }
        return var2;
    }

    // $FF: renamed from: b () void
    private void method_3228() {
        class_325 var10000 = new class_325(this.field_1846 * 2);
        class_325 var1 = var10000;
        int var3 = this.field_1844.length;
        while (true) {
            --var3;
            if (var3 < 0) {
                this.field_1844 = var1.field_1844;
                this.field_1845 = var1.field_1845;
                this.field_1847 = var1.field_1847;
                return;
            }
            char[] var2;
            if ((var2 = this.field_1844[var3]) != null) {
                var1.method_3227(var2, this.field_1845[var3]);
            }
        }
    }

    public String toString() {
        String var1 = "";
        int var3 = 0;
        for (int var4 = this.field_1845.length; var3 < var4; ++var3) {
            Object var2;
            if ((var2 = this.field_1845[var3]) != null) {
                var1 = var1 + new String(this.field_1844[var3]) + " -> " + var2.toString() + "\n";
            }
        }
        return var1;
    }
}