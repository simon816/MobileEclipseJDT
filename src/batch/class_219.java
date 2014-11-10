package batch;

import batch.class_4;
import f.class_2;
import k.class_343;
import k.class_345;

public abstract class class_219 implements class_4, class_2 {

    String field_937;

    char[] field_938;

    public class_343 field_939;

    public String field_940;

    protected class_219(class_343 var1, String var2) {
        this.field_939 = var1;
        this.field_940 = var2;
    }

    protected class_345 method_1279(String var1) {
        if (this.field_939 == null) {
            return null;
        } else {
            char[] var2 = var1.substring(0, var1.length() - field_1.length).toCharArray();
            return this.field_939.method_3324(var2);
        }
    }
}
