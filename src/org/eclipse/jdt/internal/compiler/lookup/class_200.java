package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.lookup.class_201;
import org.eclipse.jdt.internal.compiler.lookup.class_202;
import org.eclipse.jdt.internal.compiler.lookup.class_203;

public class class_200 {

    class_203[] field_883;

    public class_200() {
    }

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

    class_203[] method_1170() {
        return this.field_883;
    }

    Object method_1171() {
        return null;
    }

    public class_203[][] method_1172() {
        return (class_203[][])null;
    }

    class_200 method_1173(class_203[] var1) {
        if (var1 != null && var1.length != 0) {
            this.field_883 = var1;
            return this;
        } else {
            return null;
        }
    }
}