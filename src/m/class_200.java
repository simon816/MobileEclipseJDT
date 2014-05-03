package m;

import m.class_201;
import m.class_202;
import m.class_203;

// $FF: renamed from: m.bg
public class class_200 {

    // $FF: renamed from: a m.bf[]
    class_203[] field_883;

    // $FF: renamed from: <init> () void
    public class_200() {
    }

    // $FF: renamed from: a (m.bf[], m.bf[][], java.lang.Object) m.bg
    static class_200 method_1169(class_203[] var0, class_203[][] var1, Object var2) {
        if (var1 != null) {
            boolean var3 = true;
            int var4 = var1.length;
            while (var3) {
                --var4;
                if (var4 < 0) {
                    break;
                }
                if (var1[var4] != null && var1[var4].length > 0) {
                    var3 = false;
                }
            }
            if (var3) {
                var1 = (class_203[][])null;
            }
        }
        if (var2 != null) {
            class_202 var6 = new class_202(var0, var1, var2);
            return var6;
        } else if (var1 != null) {
            class_201 var5 = new class_201(var0, var1);
            return var5;
        } else {
            class_200 var10000 = new class_200();
            return var10000.method_1173(var0);
        }
    }

    // $FF: renamed from: a () m.bf[]
    class_203[] method_1170() {
        return this.field_883;
    }

    // $FF: renamed from: a () java.lang.Object
    Object method_1171() {
        return null;
    }

    // $FF: renamed from: a () m.bf[][]
    public class_203[][] method_1172() {
        return (class_203[][])null;
    }

    // $FF: renamed from: a (m.bf[]) m.bg
    class_200 method_1173(class_203[] var1) {
        if (var1 != null && var1.length != 0) {
            this.field_883 = var1;
            return this;
        } else {
            return null;
        }
    }
}
