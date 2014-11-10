package n;

import java.io.IOException;
import b.class_233;
import b.class_235;
import c.class_8;
import f.class_226;
import f.class_323;
import java.io.InputStream;
import n.class_236;

public class class_246 implements class_8 {

    public static class_323 field_1056;

    private static final char[] field_1057;

    private static final char[] field_1058;

    private static final char[] field_1059;

    static byte[] field_1060;

    public class_235 method_24(String var1, int var2, String[] var3, String[] var4, int var5, int var6, int var7, int var8, int var9) {
        class_236 var10000 = new class_236(var1, this.method_1444(var2, var4), var2, var3, var5, var6, var7, var8, var9);
        return var10000;
    }

    public class_246() {
        String var1 = "/batch/problem.txt";
        InputStream var2 = var1.getClass().getResourceAsStream(var1);
        class_323 var10000 = new class_323(700);
        class_323 var3 = var10000;
        label26:
        while (true) {
            try {
                while (true) {
                    if (var2.available() <= 0) {
                        break label26;
                    }
                    String var4 = method_1446(var2);
                    int var5 = var4.indexOf(61);
                    if (!var4.startsWith("#") && var5 >= 0) {
                        int var6 = Integer.parseInt(var4.substring(0, var5 - 1));
                        var3.method_3215(method_1443(var6), var4.substring(var5 + 1));
                    }
                }
            } catch (Exception var7) {
                var7.printStackTrace();
            }
        }
        field_1056 = var3;
    }

    public class_235 method_25(String var1, int var2, String[] var3, int var4, String[] var5, int var6, int var7, int var8, int var9, int var10) {
        class_236 var10000 = new class_236(var1, this.method_1445(var2, var4, var5), var2, var3, var6, var7, var8, var9, var10);
        return var10000;
    }

    private static final int method_1443(int var0) {
        return var0 + 1;
    }

    public final String method_1444(int var1, String[] var2) {
        return this.method_1445(var1, 0, var2);
    }

    public final String method_1445(int var1, int var2, String[] var3) {
        String var4 = (String)field_1056.method_3214(method_1443(var1 & 16777215));
        if (var4 == null) {
            return "Unable to retrieve the error message for problem id: " + (var1 & 16777215) + ". Check compiler resources.";
        } else {
            char[] var5 = var4.toCharArray();
            if (var2 != 0) {
                String var6 = (String)field_1056.method_3214(method_1443(var2));
                if (var6 == null) {
                    return "Unable to retrieve the error message elaboration for elaboration id: " + var2 + ". Check compiler resources.";
                }
                var5 = class_233.method_1383(var5, field_1059, var6.toCharArray());
            }
            var5 = class_233.method_1383(var5, field_1057, field_1058);
            if (var3 == null) {
                return new String(var5);
            } else {
                int var13 = var5.length;
                int var7 = 0;
                StringBuffer var9 = null;
                if ((var1 & Integer.MIN_VALUE) != 0) {
                    var9 = new StringBuffer(10 + var13 + var3.length * 20);
                    var9.append((String)field_1056.method_3214(method_1443(514)));
                }
                while (true) {
                    int var8;
                    if ((var8 = class_233.method_1374('{', var5, var7)) > -1) {
                        if (var9 == null) {
                            var9 = new StringBuffer(var13 + var3.length * 20);
                        }
                        var9.append(var5, var7, var8 - var7);
                        if ((var7 = class_233.method_1374('}', var5, var8 + 1)) > -1) {
                            try {
                                var9.append(var3[class_233.method_1380(var5, var8 + 1, var7 - var8 - 1)]);
                            } catch (NumberFormatException var11) {
                                var9.append(var5, var8 + 1, var7 - var8);
                            } catch (ArrayIndexOutOfBoundsException var12) {
                                return "Cannot bind message for problem (id: " + (var1 & 16777215) + ") \"" + new String(var5) + "\" with arguments: {" + class_226.method_1328(var3) + "}";
                            }
                            ++var7;
                            continue;
                        }
                        var9.append(var5, var8, var13);
                        break;
                    }
                    if (var9 == null) {
                        return new String(var5);
                    }
                    var9.append(var5, var7, var13 - var7);
                    break;
                }
                return new String(var9.toString());
            }
        }
    }

    public static final String method_1446(InputStream var0) throws IOException {
        int var1 = 0;
        while (true) {
            int var2;
            switch (var2 = var0.read()) {
                case -1:
                case 10:
                    return var2 == -1 && var1 == 0 ? null : new String(field_1060, 0, var1, "utf-8");
                case 13:
                    var0.read();
                    return var2 == -1 && var1 == 0 ? null : new String(field_1060, 0, var1, "utf-8");
                default:
                    field_1060[var1++] = (byte)var2;
            }
        }
    }

    static {
        field_1057 = "\'\'".toCharArray();
        field_1058 = "\'".toCharArray();
        field_1059 = "{0}".toCharArray();
        field_1060 = new byte[10240];
    }
}
