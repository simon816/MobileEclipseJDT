package a;

import g.class_11;

public class class_342 implements class_11 {

    public long field_1967;

    public long field_1968;

    public long field_1969;

    public long field_1970;

    public long field_1971;

    public long field_1972;

    public long field_1973;

    public class_342() {
    }

    public long method_3323() {
        return this.field_1968 - this.field_1967;
    }

    public int method_28(Object var1) {
        class_342 var2 = (class_342)var1;
        long var3 = this.method_3323();
        long var5 = var2.method_3323();
        return var3 < var5 ? -1 : (var3 == var5 ? 0 : 1);
    }
}
