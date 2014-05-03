package c;

import c.class_288;
import g.class_316;
import m.class_54;

// $FF: renamed from: c.a
public class class_292 {

    // $FF: renamed from: a c.d[]
    class_288[] field_1737;

    // $FF: renamed from: <init> () void
    public class_292() {
        this.field_1737 = new class_288[25];
    }

    // $FF: renamed from: a (m.az) c.d
    public synchronized class_288 method_3027(class_54 var1) {
        class_288 var10000;
        for (int var2 = 0; var2 < 25; ++var2) {
            class_288 var3 = this.field_1737[var2];
            if (var3 == null) {
                var10000 = new class_288(var1);
                class_288 var4 = var10000;
                this.field_1737[var2] = var4;
                var4.field_1727 = true;
                return var4;
            }
            if (!var3.field_1727) {
                var3.method_3013(var1);
                var3.field_1727 = true;
                return var3;
            }
        }
        var10000 = new class_288(var1);
        return var10000;
    }

    // $FF: renamed from: a (c.d) void
    public synchronized void method_3028(class_288 var1) {
        var1.field_1727 = false;
    }

    // $FF: renamed from: a () void
    public void method_3029() {
        class_316.method_3173(this.field_1737, (Object)null);
    }
}
