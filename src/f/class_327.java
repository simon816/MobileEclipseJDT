package f;

public final class class_327 {

    public Object[] field_1852;

    public Object[] field_1853;

    public int field_1854;

    public int field_1855;

    public class_327() {
        this(13);
    }

    public class_327(int var1) {
        this.field_1854 = 0;
        this.field_1855 = var1;
        int var2 = (int)((float)var1 * 1.5F);
        if (this.field_1855 == var2) {
            ++var2;
        }
        this.field_1852 = new Object[var2];
        this.field_1853 = new Object[var2];
    }

    public Object method_3241(Object var1) {
        int var2 = this.field_1852.length;
        int var3 = (var1.hashCode() & Integer.MAX_VALUE) % var2;
        Object var4;
        while ((var4 = this.field_1852[var3]) != null) {
            if (var4.equals(var1)) {
                return this.field_1853[var3];
            }
            ++var3;
            if (var3 == var2) {
                var3 = 0;
            }
        }
        return null;
    }

    public Object method_3242(Object var1, Object var2) {
        int var3 = this.field_1852.length;
        int var4 = (var1.hashCode() & Integer.MAX_VALUE) % var3;
        Object var5;
        while ((var5 = this.field_1852[var4]) != null) {
            if (var5.equals(var1)) {
                return this.field_1853[var4] = var2;
            }
            ++var4;
            if (var4 == var3) {
                var4 = 0;
            }
        }
        this.field_1852[var4] = var1;
        this.field_1853[var4] = var2;
        if (++this.field_1854 > this.field_1855) {
            this.method_3244();
        }
        return var2;
    }

    public Object method_3243(Object var1) {
        int var2 = this.field_1852.length;
        int var3 = (var1.hashCode() & Integer.MAX_VALUE) % var2;
        Object var4;
        while ((var4 = this.field_1852[var3]) != null) {
            if (var4.equals(var1)) {
                --this.field_1854;
                Object var5 = this.field_1853[var3];
                this.field_1852[var3] = null;
                this.field_1853[var3] = null;
                if (this.field_1852[var3 + 1 == var2 ? 0 : var3 + 1] != null) {
                    this.method_3244();
                }
                return var5;
            }
            ++var3;
            if (var3 == var2) {
                var3 = 0;
            }
        }
        return null;
    }

    private void method_3244() {
        class_327 var10000 = new class_327(this.field_1854 * 2);
        class_327 var1 = var10000;
        int var3 = this.field_1852.length;
        while (true) {
            --var3;
            if (var3 < 0) {
                this.field_1852 = var1.field_1852;
                this.field_1853 = var1.field_1853;
                this.field_1854 = var1.field_1854;
                this.field_1855 = var1.field_1855;
                return;
            }
            Object var2;
            if ((var2 = this.field_1852[var3]) != null) {
                var1.method_3242(var2, this.field_1853[var3]);
            }
        }
    }

    public String toString() {
        String var1 = "";
        int var3 = 0;
        for (int var4 = this.field_1853.length; var3 < var4; ++var3) {
            Object var2;
            if ((var2 = this.field_1853[var3]) != null) {
                var1 = var1 + this.field_1852[var3].toString() + " -> " + var2.toString() + "\n";
            }
        }
        return var1;
    }
}
