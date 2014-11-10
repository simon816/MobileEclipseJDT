package k;

import k.class_19;
import k.class_21;
import k.class_22;
import k.class_345;

public class class_317 {

    class_22 field_1816;

    class_19 field_1817;

    class_21[] field_1818;

    class_345 field_1819;

    public class_317(class_22 var1, class_345 var2) {
        this.field_1816 = var1;
        this.field_1819 = var2;
    }

    public class_317(class_19 var1, class_345 var2) {
        this.field_1817 = var1;
        this.field_1819 = var2;
    }

    public class_345 method_3183() {
        return this.field_1819;
    }

    public class_22 method_3184() {
        return this.field_1816;
    }

    public class_19 method_3185() {
        return this.field_1817;
    }

    public class_21[] method_3186() {
        return this.field_1818;
    }

    public boolean method_3187() {
        return this.field_1816 != null;
    }

    public boolean method_3188() {
        return this.field_1817 != null;
    }

    public boolean method_3189() {
        return this.field_1818 != null;
    }

    public boolean method_3190() {
        return this.field_1819 != null && this.field_1819.method_3330();
    }

    public boolean method_3191(class_317 var1) {
        return var1 == null ? true : (this.field_1819 == null ? true : var1.field_1819 != null && this.field_1819.method_3329() < var1.field_1819.method_3329());
    }
}
