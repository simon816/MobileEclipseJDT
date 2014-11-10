package l;

import b.class_233;
import h.class_89;
import i.class_74;
import l.class_293;
import l.class_295;
import m.class_86;

public class class_296 extends class_295 {

    public char[] field_1747;

    public class_296(class_293 var1, class_89 var2, char[] var3, class_74 var4, class_86 var5) {
        super(var1, var2, var4);
        this.field_1747 = var3;
        this.method_3055(var5);
    }

    void method_3055(class_86 var1) {
        for (class_293 var2 = this.field_1740; var2 != null; var2 = var2.field_1740) {
            char[] var3;
            if ((var3 = var2.method_3043()) != null && class_233.method_1364(var3, this.field_1747)) {
                var1.method_644().method_1465(this.field_1747, this.field_1739);
            }
        }
    }

    public String method_3039() {
        return "Label flow context [label:" + String.valueOf(this.field_1747) + "]";
    }

    public char[] method_3043() {
        return this.field_1747;
    }
}
