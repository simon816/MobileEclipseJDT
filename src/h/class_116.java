package h;

import h.class_98;
import i.class_268;
import i.class_73;
import m.class_40;
import m.class_65;
import m.class_86;

// $FF: renamed from: h.bi
public abstract class class_116 extends class_98 {

    // $FF: renamed from: a i.n
    class_73 field_615;

    // $FF: renamed from: <init> () void
    public class_116() {
    }

    // $FF: renamed from: a (h.bi[], int, i.o) void
    public static void method_871(class_116[] var0, int var1, class_268 var2) {
        if (var0 != null) {
            if (var1 < 0) {
                var1 = var0.length;
            }
            for (int var3 = 0; var3 < var1; ++var3) {
                class_116 var4 = var0[var3];
                var4.method_872(var2);
                var4.method_873(var2);
            }
        }
    }

    // $FF: renamed from: a (i.o) i.n
    public class_73 method_872(class_268 var1) {
        if (this.field_615 == null) {
            class_73 var10001 = new class_73(var1, (class_40)null);
            this.field_615 = var10001;
        }
        this.field_615.method_449();
        return this.field_615;
    }

    // $FF: renamed from: a (i.o) void
    public void method_873(class_268 var1) {}

    // $FF: renamed from: a () void
    public void method_874() {
        if (this.field_615 != null) {
            this.field_615.method_448();
        }
    }

    // $FF: renamed from: a (m.v, i.o, java.lang.Object, int, m.ab) boolean
    public abstract boolean method_875(class_86 var1, class_268 var2, Object var3, int var4, class_65 var5);

    // $FF: renamed from: a () boolean
    public abstract boolean method_876();

    // $FF: renamed from: b () void
    public void method_877() {
        this.field_615.method_447();
    }
}
