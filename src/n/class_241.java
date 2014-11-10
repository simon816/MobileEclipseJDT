package n;

import b.class_235;
import c.class_284;
import f.class_226;
import h.class_89;
import m.class_0;

public class class_241 extends RuntimeException {

    public class_284 field_1049;

    public Throwable field_1050;

    public class_235 field_1051;

    public boolean field_1052;

    public RuntimeException field_1053;

    public class_241() {
    }

    public class_241(class_284 var1, class_235 var2) {
        this();
        this.field_1049 = var1;
        this.field_1051 = var2;
    }

    public class_241(class_284 var1, Throwable var2) {
        this();
        this.field_1049 = var1;
        this.field_1050 = var2;
    }

    public class_241(boolean var1, RuntimeException var2) {
        this();
        this.field_1052 = var1;
        this.field_1053 = var2;
    }

    public void method_1437(class_0 var1, class_284 var2) {
        if (this.field_1051 != null) {
            if (this.field_1051.method_1401() == 0 && this.field_1051.method_1402() == 0) {
                this.field_1051.method_13(var1.method_5());
                this.field_1051.method_11(var1.method_6());
                int[] var3 = var2.method_2921();
                this.field_1051.method_12(class_226.method_1324(var1.method_5(), var3, 0, var3.length - 1));
                this.field_1049 = var2;
            }
        }
    }

    public void method_1438(class_89 var1, class_284 var2) {
        if (this.field_1051 != null) {
            if (this.field_1051.method_1401() == 0 && this.field_1051.method_1402() == 0) {
                this.field_1051.method_13(var1.method_5());
                this.field_1051.method_11(var1.method_6());
                int[] var3 = var2.method_2921();
                this.field_1051.method_12(class_226.method_1324(var1.method_5(), var3, 0, var3.length - 1));
                this.field_1049 = var2;
            }
        }
    }
}
