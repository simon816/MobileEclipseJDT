package n;

import b.class_235;
import c.class_284;
import f.class_226;
import h.class_89;
import m.class_0;

// $FF: renamed from: n.i
public class class_241 extends RuntimeException {

    // $FF: renamed from: a c.h
    public class_284 field_1049;
    // $FF: renamed from: a java.lang.Throwable
    public Throwable field_1050;
    // $FF: renamed from: a b.e
    public class_235 field_1051;
    // $FF: renamed from: a boolean
    public boolean field_1052;
    // $FF: renamed from: a java.lang.RuntimeException
    public RuntimeException field_1053;

    // $FF: renamed from: <init> () void
    public class_241() {
    }

    // $FF: renamed from: <init> (c.h, b.e) void
    public class_241(class_284 var1, class_235 var2) {
        this();
        this.field_1049 = var1;
        this.field_1051 = var2;
    }

    // $FF: renamed from: <init> (c.h, java.lang.Throwable) void
    public class_241(class_284 var1, Throwable var2) {
        this();
        this.field_1049 = var1;
        this.field_1050 = var2;
    }

    // $FF: renamed from: <init> (boolean, java.lang.RuntimeException) void
    public class_241(boolean var1, RuntimeException var2) {
        this();
        this.field_1052 = var1;
        this.field_1053 = var2;
    }

    // $FF: renamed from: a (m.ad, c.h) void
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

    // $FF: renamed from: a (h.cj, c.h) void
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
