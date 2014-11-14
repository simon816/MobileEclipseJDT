package m;

import b.CharOperation;
import h.class_91;
import m.class_34;
import m.class_35;
import m.class_43;

public class class_36 extends class_35 {

    public class_43 field_166;

    public class_36(char[][] var1, class_34 var2, class_43 var3, class_91 var4) {
        super(var1, false, var2, var4);
        this.field_166 = var3;
    }

    public char[] method_103() {
        return CharOperation.method_1361(this.field_162, '.');
    }

    public String toString() {
        return "method import : " + new String(this.method_103());
    }
}
