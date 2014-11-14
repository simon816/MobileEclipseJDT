package org.eclipse.jdt.internal.compiler.util;

public final class class_326 {

    static int field_1848;

    public int field_1849;

    int field_1850;

    Object[] field_1851;

    public class_326() {
        this(field_1848);
    }

    public class_326(int var1) {
        this.field_1850 = var1 > 0 ? var1 : field_1848;
        this.field_1849 = 0;
        this.field_1851 = new Object[this.field_1850];
    }

    public void method_3231(Object var1) {
        if (this.field_1849 == this.field_1850) {
            System.arraycopy(this.field_1851, 0, this.field_1851 = new Object[this.field_1850 *= 2], 0, this.field_1849);
        }
        this.field_1851[this.field_1849++] = var1;
    }

    public void method_3232(Object[] var1) {
        if (this.field_1849 + var1.length >= this.field_1850) {
            this.field_1850 = this.field_1849 + var1.length;
            System.arraycopy(this.field_1851, 0, this.field_1851 = new Object[this.field_1850], 0, this.field_1849);
        }
        System.arraycopy(var1, 0, this.field_1851, this.field_1849, var1.length);
        this.field_1849 += var1.length;
    }

    public boolean method_3233(Object var1) {
        int var2 = this.field_1849;
        do {
            --var2;
            if (var2 < 0) {
                return false;
            }
        } while (var1 != this.field_1851[var2]);
        return true;
    }

    public boolean method_3234(Object var1) {
        int var2 = this.field_1849;
        do {
            --var2;
            if (var2 < 0) {
                return false;
            }
        } while (!var1.equals(this.field_1851[var2]));
        return true;
    }

    public void method_3235(Object[] var1) {
        this.method_3236(var1, 0);
    }

    public void method_3236(Object[] var1, int var2) {
        System.arraycopy(this.field_1851, 0, var1, var2, this.field_1849);
    }

    public Object method_3237(int var1) {
        return this.field_1851[var1];
    }

    public String toString() {
        String var1 = "";
        for (int var2 = 0; var2 < this.field_1849; ++var2) {
            var1 = var1 + this.field_1851[var2].toString() + "\n";
        }
        return var1;
    }

    static {
        field_1848 = 10;
    }
}
