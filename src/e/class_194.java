package e;

import b.class_233;
import e.class_191;
import e.class_192;
import e.class_195;
import e.class_196;
import i.class_5;

// $FF: renamed from: e.c
public class class_194 extends class_191 {

    // $FF: renamed from: a java.lang.Object
    protected Object field_865;

    // $FF: renamed from: a (byte[], int[], int) e.i
    public static class_191 method_1148(byte[] var0, int[] var1, int var2) {
        class_191 var10000 = new class_191(var0, var1, var2);
        class_191 var3 = var10000;
        int var4 = var3.method_1104(6);
        int var5 = 8;
        class_196[] var6 = null;
        Object var7 = null;
        for (int var8 = 0; var8 < var4; ++var8) {
            int var9 = var3.field_806[var3.method_1104(var5)] - var3.field_807;
            char[] var10 = var3.method_1106(var9 + 3, var3.method_1104(var9 + 1));
            if (var10.length > 0) {
                switch (var10[0]) {
                    case 65:
                        if (class_233.method_1364(var10, class_5.field_16)) {
                            class_196 var16 = new class_196(var3.field_805, var3.field_806, var5 + 6 + var3.field_807);
                            class_196 var18 = var16;
                            var7 = var18.method_1153();
                        }
                        break;
                    case 82:
                        class_196[] var11 = null;
                        if (class_233.method_1364(var10, class_5.field_18)) {
                            var11 = method_1133(var5, true, var3);
                        } else if (class_233.method_1364(var10, class_5.field_17)) {
                            var11 = method_1133(var5, false, var3);
                        }
                        if (var11 != null) {
                            if (var6 == null) {
                                var6 = var11;
                            } else {
                                int var12 = var6.length;
                                class_196[] var13 = new class_196[var12 + var11.length];
                                System.arraycopy(var6, 0, var13, 0, var12);
                                System.arraycopy(var11, 0, var13, var12, var11.length);
                                var6 = var13;
                            }
                        }
                        break;
                    case 83:
                        if (class_233.method_1364(class_5.field_13, var10)) {
                            var3.field_859 = var3.field_806[var3.method_1104(var5 + 6)] - var3.field_807;
                        }
                }
            }
            var5 = (int)((long)var5 + 6L + var3.method_1105(var5 + 2));
        }
        var3.field_854 = var5;
        if (var7 != null) {
            if (var6 != null) {
                class_195 var15 = new class_195(var3, var7, var6);
                return var15;
            } else {
                class_194 var14 = new class_194(var3, var7);
                return var14;
            }
        } else if (var6 != null) {
            class_192 var17 = new class_192(var3, var6);
            return var17;
        } else {
            return var3;
        }
    }

    // $FF: renamed from: <init> (e.i, java.lang.Object) void
    class_194(class_191 var1, Object var2) {
        super(var1.field_805, var1.field_806, var1.field_807);
        this.field_865 = null;
        this.field_865 = var2;
        this.field_853 = var1.field_853;
        this.field_854 = var1.field_854;
        this.field_855 = var1.field_855;
        this.field_856 = var1.field_856;
        this.field_857 = var1.field_857;
        this.field_858 = var1.field_858;
        this.field_859 = var1.field_859;
        this.field_860 = var1.field_860;
    }

    // $FF: renamed from: a () java.lang.Object
    public Object method_72() {
        return this.field_865;
    }

    // $FF: renamed from: a (java.lang.StringBuffer) void
    protected void method_1141(StringBuffer var1) {
        super.method_1141(var1);
        if (this.field_865 != null) {
            var1.append(" default ");
            if (this.field_865 instanceof Object[]) {
                var1.append('{');
                Object[] var2 = (Object[])((Object[])this.field_865);
                int var3 = 0;
                for (int var4 = var2.length; var3 < var4; ++var3) {
                    if (var3 > 0) {
                        var1.append(", ");
                    }
                    var1.append(var2[var3]);
                }
                var1.append('}');
            } else {
                var1.append(this.field_865);
            }
            var1.append('\n');
        }
    }
}
