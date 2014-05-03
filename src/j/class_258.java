package j;

import h.class_89;
import h.class_98;
import j.class_251;

// $FF: renamed from: j.n
public class class_258 extends class_251 {

    // $FF: renamed from: a h.bf
    public class_98 field_1117;

    // $FF: renamed from: <init> (h.bf, j.e, int) void
    public class_258(class_98 var1, class_251 var2, int var3) {
        super(var2, var3);
        this.field_1117 = var1;
    }

    // $FF: renamed from: a () h.cj
    public class_89 method_1845() {
        return this.field_1117;
    }

    // $FF: renamed from: a (int) java.lang.String
    public String method_1850(int var1) {
        return this.method_1848(var1) + "Recovered statement:\n" + this.field_1117.method_757(var1 + 1, new StringBuffer(10));
    }

    // $FF: renamed from: a () h.bf
    public class_98 method_1876() {
        return this.field_1117;
    }

    // $FF: renamed from: a () void
    public void method_1855() {
        this.method_1876();
    }

    // $FF: renamed from: a (int, int) void
    public void method_1856(int var1, int var2) {
        if (this.field_1117.field_445 == 0) {
            this.field_1117.field_445 = var2;
        }
    }
}
