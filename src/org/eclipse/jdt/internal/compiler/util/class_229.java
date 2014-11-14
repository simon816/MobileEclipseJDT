package org.eclipse.jdt.internal.compiler.util;

public final class class_229 {

    public Object[] field_987;

    public int field_988;

    public int field_989;

    public class_229() {
        this(13);
    }

    public class_229(int var1) {
        if (var1 < 3) {
            var1 = 3;
        }
        this.field_988 = 0;
        this.field_989 = var1 + 1;
        this.field_987 = new Object[2 * var1 + 1];
    }

    public Object method_1335(Object var1) {
        int var2 = this.field_987.length;
        int var3 = (var1.hashCode() & Integer.MAX_VALUE) % var2;
        Object var4;
        while ((var4 = this.field_987[var3]) != null) {
            if (var4.equals(var1)) {
                return this.field_987[var3] = var1;
            }
            ++var3;
            if (var3 == var2) {
                var3 = 0;
            }
        }
        this.field_987[var3] = var1;
        if (++this.field_988 > this.field_989) {
            this.method_1338();
        }
        return var1;
    }

    public void method_1336(Object[] var1) {
        if (this.field_988 != var1.length) {
            throw new IllegalArgumentException();
        } else {
            int var2 = this.field_988;
            int var3 = 0;
            for (int var4 = this.field_987.length; var3 < var4 && var2 > 0; ++var3) {
                if (this.field_987[var3] != null) {
                    --var2;
                    var1[var2] = this.field_987[var3];
                }
            }
        }
    }

    public boolean method_1337(Object var1) {
        int var2 = this.field_987.length;
        int var3 = (var1.hashCode() & Integer.MAX_VALUE) % var2;
        Object var4;
        while ((var4 = this.field_987[var3]) != null) {
            if (var4.equals(var1)) {
                return true;
            }
            ++var3;
            if (var3 == var2) {
                var3 = 0;
            }
        }
        return false;
    }

    private void method_1338() {
        class_229 var10000 = new class_229(this.field_988 * 2);
        class_229 var1 = var10000;
        int var3 = this.field_987.length;
        while (true) {
            --var3;
            if (var3 < 0) {
                this.field_987 = var1.field_987;
                this.field_988 = var1.field_988;
                this.field_989 = var1.field_989;
                return;
            }
            Object var2;
            if ((var2 = this.field_987[var3]) != null) {
                var1.method_1335(var2);
            }
        }
    }

    public String toString() {
        String var1 = "";
        int var3 = 0;
        for (int var4 = this.field_987.length; var3 < var4; ++var3) {
            Object var2;
            if ((var2 = this.field_987[var3]) != null) {
                var1 = var1 + var2.toString() + "\n";
            }
        }
        return var1;
    }
}
