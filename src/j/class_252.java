package j;

import h.class_89;
import h.class_91;
import j.class_251;

// $FF: renamed from: j.c
public class class_252 extends class_251 {

    // $FF: renamed from: a h.z
    public class_91 field_1072;

    // $FF: renamed from: <init> (h.z, j.e, int) void
    public class_252(class_91 var1, class_251 var2, int var3) {
        super(var2, var3);
        this.field_1072 = var1;
    }

    // $FF: renamed from: a () h.cj
    public class_89 method_1845() {
        return this.field_1072;
    }

    // $FF: renamed from: a (int) java.lang.String
    public String method_1850(int var1) {
        return this.method_1848(var1) + "Recovered import: " + this.field_1072.toString();
    }

    // $FF: renamed from: a () h.z
    public class_91 method_1859() {
        return this.field_1072;
    }

    // $FF: renamed from: a () void
    public void method_1855() {
        this.method_1859();
    }

    // $FF: renamed from: a (int, int) void
    public void method_1856(int var1, int var2) {
        if (this.field_1072.field_471 == 0) {
            this.field_1072.field_471 = var2;
            this.field_1072.field_469 = var2;
        }
    }
}
