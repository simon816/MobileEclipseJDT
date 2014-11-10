package m;

import a.class_331;
import h.class_126;
import h.class_128;
import h.class_129;
import h.class_154;
import h.class_155;
import h.class_161;
import h.class_164;
import m.class_34;
import m.class_58;
import m.class_67;

public class class_320 {

    char[] field_1823;

    public Object field_1824;

    public class_58 field_1825;

    public static Object method_3197(class_126 var0) {
        if (var0 == null) {
            return null;
        } else {
            class_331 var1 = var0.field_672;
            if (var1 != null && var1 != class_331.field_1896) {
                return var1;
            } else if (var0 instanceof class_164) {
                return ((class_164)var0).method_1073();
            } else if (!(var0 instanceof class_128)) {
                if (var0 instanceof class_129) {
                    return ((class_129)var0).field_682;
                } else {
                    if (var0 instanceof class_154) {
                        class_67 var6 = null;
                        if (var0 instanceof class_155) {
                            var6 = ((class_155)var0).method_1036();
                        } else if (var0 instanceof class_161) {
                            class_34 var7 = ((class_161)var0).field_748;
                            if (var7 != null && var7.method_98() == 1) {
                                var6 = (class_67)var7;
                            }
                        }
                        if (var6 != null && (var6.field_300 & 16384) > 0) {
                            return var6;
                        }
                    }
                    return null;
                }
            } else {
                class_126[] var2 = ((class_128)var0).field_679;
                int var3 = var2 == null ? 0 : var2.length;
                Object[] var4 = new Object[var3];
                for (int var5 = 0; var5 < var3; ++var5) {
                    var4[var5] = method_3197(var2[var5]);
                }
                return var4;
            }
        }
    }

    public class_320(char[] var1, class_126 var2, class_58 var3) {
        this(var1, method_3197(var2), var3);
    }

    public class_320(char[] var1, Object var2, class_58 var3) {
        this.field_1823 = var1;
        this.field_1824 = var2;
        this.field_1825 = var3;
    }

    public char[] method_3200() {
        return this.field_1823;
    }

    void method_3201(class_58 var1) {
        this.field_1825 = var1;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer(5);
        var1.append(this.field_1823).append(" = ");
        var1.append(this.field_1824);
        return var1.toString();
    }
}
