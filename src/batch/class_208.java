package batch;

import batch.class_238;
import c.class_284;
import c.class_9;
import h.class_90;

// $FF: renamed from: batch.h
class class_208 implements class_9 {

    // $FF: renamed from: a int
    int field_899;
    // $FF: renamed from: a batch.d
    private final class_238 field_900;

    // $FF: renamed from: <init> (batch.d) void
    class_208(class_238 var1) {
        this.field_900 = var1;
        this.field_899 = 0;
    }

    // $FF: renamed from: a (c.h) void
    public void method_26(class_284 var1) {
        int var2;
        if (var1.field_1684 != null) {
            var2 = var1.field_1684.length;
            this.field_899 += var2;
            if (this.field_900.field_1036 && this.field_899 > 2000) {
                this.field_900.field_1028.method_1253();
                this.field_899 = 0;
            }
        }
        this.field_900.field_1028.method_1269(var1);
        if (var1.method_2925() || var1.method_2926()) {
            var2 = this.field_900.field_1028.method_1251(var1.method_2916(), var1.field_1677.method_51(), this.field_900);
            if (this.field_900.field_1039 && !this.field_900.field_1032 && var2 > 0) {
                class_90[] var3 = this.field_900.field_1013.field_1705;
                int var4 = 0;
                for (int var5 = this.field_900.field_1013.field_1706; var4 < var5; ++var4) {
                    class_90 var6 = var3[var4];
                    if (var6 != null) {
                        class_284 var7 = var6.field_455;
                        if (var7.method_2925() && !var7.field_1689) {
                            this.field_900.field_1028.method_1251(var7.method_2916(), var7.field_1677.method_51(), this.field_900);
                        }
                    }
                }
                this.field_900.field_1028.method_1233();
                this.field_900.field_1028.method_1234();
                this.field_900.field_1028.method_1265();
                this.field_900.field_1028.method_1239();
                this.field_900.field_1028.method_1229();
                throw new RuntimeException("-1");
            }
        }
        this.field_900.method_1424(var1);
        this.field_900.field_1028.method_1233();
    }
}
