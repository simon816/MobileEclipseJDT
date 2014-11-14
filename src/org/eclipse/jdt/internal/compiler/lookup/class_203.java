package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.ast.class_164;
import org.eclipse.jdt.internal.compiler.lookup.class_17;
import org.eclipse.jdt.internal.compiler.lookup.class_320;
import org.eclipse.jdt.internal.compiler.lookup.class_34;
import org.eclipse.jdt.internal.compiler.lookup.class_43;
import org.eclipse.jdt.internal.compiler.lookup.class_58;
import org.eclipse.jdt.internal.compiler.lookup.class_67;
import org.eclipse.jdt.internal.compiler.lookup.class_80;
import org.eclipse.jdt.internal.compiler.lookup.class_83;

public class class_203 {

    class_43 field_886;

    class_320[] field_887;

    public static class_203[] method_1176(class_203[] var0, long var1, class_80 var3) {
        int var4 = 0;
        if ((var1 & 17557826306048L) != 0L) {
            ++var4;
        }
        if ((var1 & 52776558133248L) != 0L) {
            ++var4;
        }
        if ((var1 & 70368744177664L) != 0L) {
            ++var4;
        }
        if ((var1 & 140737488355328L) != 0L) {
            ++var4;
        }
        if ((var1 & 281474976710656L) != 0L) {
            ++var4;
        }
        if ((var1 & 562949953421312L) != 0L) {
            ++var4;
        }
        if ((var1 & 1125899906842624L) != 0L) {
            ++var4;
        }
        if (var4 == 0) {
            return var0;
        } else {
            int var5 = var0.length;
            class_203[] var6 = new class_203[var5 + var4];
            System.arraycopy(var0, 0, var6, 0, var5);
            if ((var1 & 17557826306048L) != 0L) {
                var6[var5++] = method_1179(var1, var3);
            }
            if ((var1 & 52776558133248L) != 0L) {
                var6[var5++] = method_1178(var1, var3);
            }
            if ((var1 & 70368744177664L) != 0L) {
                var6[var5++] = method_1177(class_17.field_119, var3);
            }
            if ((var1 & 140737488355328L) != 0L) {
                var6[var5++] = method_1177(class_17.field_120, var3);
            }
            if ((var1 & 281474976710656L) != 0L) {
                var6[var5++] = method_1177(class_17.field_121, var3);
            }
            if ((var1 & 562949953421312L) != 0L) {
                var6[var5++] = method_1177(class_17.field_122, var3);
            }
            if ((var1 & 1125899906842624L) != 0L) {
                var6[var5++] = method_1177(class_17.field_124, var3);
            }
            return var6;
        }
    }

    private static class_203 method_1177(char[][] var0, class_80 var1) {
        class_43 var2 = var1.method_506(var0, (class_83)null);
        return var1.method_492(var2, class_34.field_159);
    }

    private static class_203 method_1178(long var0, class_80 var2) {
        class_43 var3 = var2.method_506(class_17.field_126, (class_83)null);
        class_67 var4 = null;
        if ((var0 & 52776558133248L) != 0L) {
            var4 = var3.method_208(class_17.field_75, true);
        } else if ((var0 & 35184372088832L) != 0L) {
            var4 = var3.method_208(class_17.field_74, true);
        } else if ((var0 & 17592186044416L) != 0L) {
            var4 = var3.method_208(class_17.field_73, true);
        }
        class_43 var10001 = var2.method_506(class_17.field_123, (class_83)null);
        class_320[] var10002 = new class_320[1];
        class_320 var10005 = new class_320(class_17.field_70, var4, (class_58)null);
        var10002[0] = var10005;
        return var2.method_492(var10001, var10002);
    }

    private static class_203 method_1179(long var0, class_80 var2) {
        class_43 var3 = var2.method_506(class_17.field_125, (class_83)null);
        if ((var0 & 34359738368L) != 0L) {
            class_203 var10000 = new class_203(var3, class_34.field_159);
            return var10000;
        } else {
            int var4 = 0;
            if ((var0 & 4398046511104L) != 0L) {
                ++var4;
            }
            if ((var0 & 1099511627776L) != 0L) {
                ++var4;
            }
            if ((var0 & 137438953472L) != 0L) {
                ++var4;
            }
            if ((var0 & 2199023255552L) != 0L) {
                ++var4;
            }
            if ((var0 & 274877906944L) != 0L) {
                ++var4;
            }
            if ((var0 & 8796093022208L) != 0L) {
                ++var4;
            }
            if ((var0 & 549755813888L) != 0L) {
                ++var4;
            }
            if ((var0 & 68719476736L) != 0L) {
                ++var4;
            }
            Object[] var5 = new Object[var4];
            if (var4 > 0) {
                class_43 var6 = var2.method_506(class_17.field_127, (class_83)null);
                int var7 = 0;
                if ((var0 & 4398046511104L) != 0L) {
                    var5[var7++] = var6.method_208(class_17.field_84, true);
                }
                if ((var0 & 1099511627776L) != 0L) {
                    var5[var7++] = var6.method_208(class_17.field_82, true);
                }
                if ((var0 & 137438953472L) != 0L) {
                    var5[var7++] = var6.method_208(class_17.field_79, true);
                }
                if ((var0 & 2199023255552L) != 0L) {
                    var5[var7++] = var6.method_208(class_17.field_83, true);
                }
                if ((var0 & 274877906944L) != 0L) {
                    var5[var7++] = var6.method_208(class_17.field_80, true);
                }
                if ((var0 & 8796093022208L) != 0L) {
                    var5[var7++] = var6.method_208(class_17.field_85, true);
                }
                if ((var0 & 549755813888L) != 0L) {
                    var5[var7++] = var6.method_208(class_17.field_81, true);
                }
                if ((var0 & 68719476736L) != 0L) {
                    var5[var7++] = var6.method_208(class_17.field_78, true);
                }
            }
            class_320[] var10002 = new class_320[1];
            class_320 var10005 = new class_320(class_17.field_70, var5, (class_58)null);
            var10002[0] = var10005;
            return var2.method_492(var3, var10002);
        }
    }

    class_203(class_43 var1, class_320[] var2) {
        this.field_886 = var1;
        this.field_887 = var2;
    }

    class_203(class_164 var1) {
        this((class_43)var1.field_675, var1.method_1071());
    }

    public class_43 method_1182() {
        return this.field_886;
    }

    public static void method_1183(class_43 var0, class_320[] var1) {
        int var2 = var1.length;
        while (true) {
            --var2;
            if (var2 < 0) {
                return;
            }
            class_320 var3 = var1[var2];
            class_58[] var4 = var0.method_210(var3.method_3200());
            if (var4 != null && var4.length == 1) {
                var3.method_3201(var4[0]);
            }
        }
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer(5);
        var1.append('@').append(this.field_886.field_198);
        if (this.field_887 != null && this.field_887.length > 0) {
            var1.append("{ ");
            int var2 = 0;
            for (int var3 = this.field_887.length; var2 < var3; ++var2) {
                if (var2 > 0) {
                    var1.append(", ");
                }
                var1.append(this.field_887[var2]);
            }
            var1.append('}');
        }
        return var1.toString();
    }
}
