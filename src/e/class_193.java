package e;

import e.class_191;
import e.class_192;
import e.class_196;
import k.class_29;

// $FF: renamed from: e.m
class class_193 extends class_192 {

    // $FF: renamed from: a e.b[][]
    private class_196[][] field_864;

    // $FF: renamed from: <init> (e.i, e.b[], e.b[][]) void
    class_193(class_191 var1, class_196[] var2, class_196[][] var3) {
        super(var1, var2);
        this.field_864 = var3;
    }

    // $FF: renamed from: a (int) k.e[]
    public class_29[] method_76(int var1) {
        return this.field_864[var1];
    }

    // $FF: renamed from: a () void
    protected void method_1136() {
        int var1 = 0;
        for (int var2 = this.field_864 == null ? 0 : this.field_864.length; var1 < var2; ++var1) {
            class_196[] var3 = this.field_864[var1];
            int var4 = 0;
            for (int var5 = var3 == null ? 0 : var3.length; var4 < var5; ++var4) {
                var3[var4].method_1154();
            }
        }
        super.method_1136();
    }

    // $FF: renamed from: b () void
    protected void method_1102() {
        int var1 = 0;
        for (int var2 = this.field_864 == null ? 0 : this.field_864.length; var1 < var2; ++var1) {
            class_196[] var3 = this.field_864[var1];
            int var4 = 0;
            for (int var5 = var3 == null ? 0 : var3.length; var4 < var5; ++var4) {
                var3[var4].method_1102();
            }
        }
        super.method_1102();
    }

    // $FF: renamed from: a (java.lang.StringBuffer) void
    protected void method_1141(StringBuffer var1) {
        super.method_1141(var1);
        int var2 = 0;
        for (int var3 = this.field_864 == null ? 0 : this.field_864.length; var2 < var3; ++var2) {
            var1.append("param" + (var2 - 1));
            var1.append('\n');
            class_196[] var4 = this.field_864[var2];
            int var5 = 0;
            for (int var6 = var4 == null ? 0 : var4.length; var5 < var6; ++var5) {
                var1.append(var4[var5]);
                var1.append('\n');
            }
        }
    }
}