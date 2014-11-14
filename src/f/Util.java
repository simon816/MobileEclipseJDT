package f;

import b.CharOperation;
import c.class_288;
import f.class_1;
import f.SuffixConstants;
import f.class_223;
import f.class_329;
import g.class_307;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import h.class_114;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Util implements SuffixConstants {

    public static final String field_981;

    public static final String field_982;

    public static final int[] field_983;

    public Util() {
    }

    public static String method_1317(String var0, String var1) throws IOException {
        char var2 = 47;
        String var3 = "/";
        var0 = var0.replace('/', var2);
        var1 = var1.replace('/', var2);
        int var7 = var1.lastIndexOf(var2);
        String var5;
        String var6;
        if (var7 == -1) {
            if (var0.endsWith(var3)) {
                var5 = var0.substring(0, var0.length() - 1);
                var6 = var0 + var1;
            } else {
                var5 = var0;
                var6 = var0 + var3 + var1;
            }
        } else if (var0.endsWith(var3)) {
            var5 = var0 + var1.substring(0, var7);
            var6 = var0 + var1;
        } else {
            var5 = var0 + var3 + var1.substring(0, var7);
            var6 = var0 + var3 + var1;
        }
        File var10000 = new File(var5);
        File var4 = var10000;
        var4.mkdirs();
        if (var4.isDirectory()) {
            return var6;
        } else {
            if (var0.endsWith(var3)) {
                var0 = var0.substring(0, var0.length() - 1);
            }
            var10000 = new File(var0);
            var4 = var10000;
            boolean var8 = false;
            if (var4.exists()) {
                var8 = true;
            } else if (!var4.mkdirs()) {
                if (!var4.exists()) {
                    throw new IOException(class_329.method_3251(class_329.field_1873, var4.getPath()));
                }
                var8 = true;
            }
            if (var8 && !var4.isDirectory()) {
                throw new IOException(class_329.method_3251(class_329.field_1872, var4.getPath()));
            } else {
                StringBuffer var9 = new StringBuffer(var0);
                var9.append(var3);
                class_307 var12 = new class_307(var1, var3);
                class_307 var10 = var12;
                String var11;
                for (var11 = var10.method_3140(); var10.method_3139(); var11 = var10.method_3140()) {
                    var10000 = new File(var9.append(var11).append(var3).toString());
                    var4 = var10000;
                    var8 = false;
                    if (var4.exists()) {
                        var8 = true;
                    } else if (!var4.mkdir()) {
                        if (!var4.exists()) {
                            throw new IOException(class_329.method_3252(class_329.field_1874, var9.toString().substring(var0.length() + 1, var9.length() - 1), var0));
                        }
                        var8 = true;
                    }
                    if (var8 && !var4.isDirectory()) {
                        throw new IOException(class_329.method_3251(class_329.field_1872, var4.getPath()));
                    }
                }
                return var9.append(var11).toString();
            }
        }
    }

    public static int method_1318(class_114 var0, int var1) {
        for (; var0 != null; var0 = var0.field_599) {
            switch (var0.field_577 & 7) {
                case 0:
                    if (var1 != 2) {
                        var1 = 0;
                    }
                case 1:
                case 3:
                default:
                    break;
                case 2:
                    var1 = 2;
                    break;
                case 4:
                    if (var1 == 1) {
                        var1 = 4;
                    }
            }
        }
        return var1;
    }

    public static byte[] method_1319(File var0) throws IOException {
        FileInputStream var1 = null;
        byte[] var2;
        try {
            FileInputStream var10000 = new FileInputStream(var0);
            var1 = var10000;
            var2 = method_1322(var1, (int)var0.length());
        } finally {
            if (var1 != null) {
                try {
                    var1.close();
                } catch (IOException var9) {
                    ;
                }
            }
        }
        return var2;
    }

    public static char[] method_1320(File var0, String var1) throws IOException {
        FileInputStream var2 = null;
        char[] var3;
        try {
            FileInputStream var10000 = new FileInputStream(var0);
            var2 = var10000;
            var3 = method_1323(var2, (int)var0.length(), var1);
        } finally {
            if (var2 != null) {
                try {
                    var2.close();
                } catch (IOException var10) {
                    ;
                }
            }
        }
        return var3;
    }

    private static FileOutputStream method_1321(boolean var0, String var1, String var2) throws IOException {
        FileOutputStream var10000;
        File var10002;
        if (var0) {
            var10002 = new File(method_1317(var1, var2));
            var10000 = new FileOutputStream(var10002);
            return var10000;
        } else {
            String var3 = null;
            char var4 = 47;
            String var5 = "/";
            var1 = var1.replace('/', var4);
            int var6 = var2.lastIndexOf(var4);
            if (var6 == -1) {
                if (var1.endsWith(var5)) {
                    var3 = var1 + var2;
                } else {
                    var3 = var1 + var5 + var2;
                }
            } else {
                int var7 = var2.length();
                if (var1.endsWith(var5)) {
                    var3 = var1 + var2.substring(var6 + 1, var7);
                } else {
                    var3 = var1 + var5 + var2.substring(var6 + 1, var7);
                }
            }
            var10002 = new File(var3);
            var10000 = new FileOutputStream(var10002);
            return var10000;
        }
    }

    public static byte[] method_1322(InputStream var0, int var1) throws IOException {
        byte[] var2;
        int var3;
        int var6;
        if (var1 == -1) {
            var2 = new byte[0];
            var3 = 0;
            boolean var4 = true;
            do {
                int var5 = Math.max(var0.available(), 8192);
                if (var3 + var5 > var2.length) {
                    System.arraycopy(var2, 0, var2 = new byte[var3 + var5], 0, var3);
                }
                var6 = var0.read(var2, var3, var5);
                if (var6 > 0) {
                    var3 += var6;
                }
            } while (var6 != -1);
            if (var3 < var2.length) {
                System.arraycopy(var2, 0, var2 = new byte[var3], 0, var3);
            }
        } else {
            var2 = new byte[var1];
            var3 = 0;
            for (var6 = 0; var6 != -1 && var3 != var1; var6 = var0.read(var2, var3, var1 - var3)) {
                var3 += var6;
            }
        }
        return var2;
    }

    public static char[] method_1323(InputStream var0, int var1, String var2) throws IOException {
        InputStreamReader var3 = null;
        try {
            var3 = new InputStreamReader(var0, "utf-8");
        } catch (Exception var8) {
            var3 = new InputStreamReader(var0);
        }
        int var5 = 0;
        char[] var4;
        if (var1 == -1) {
            var4 = CharOperation.field_994;
        } else {
            var4 = new char[var1];
        }
        while (true) {
            int var6;
            int var7;
            if (var5 < var1) {
                var6 = var1 - var5;
            } else {
                var7 = var3.read();
                if (var7 < 0) {
                    break;
                }
                var6 = Math.max(var0.available(), 8192);
                if (var5 + 1 + var6 > var4.length) {
                    System.arraycopy(var4, 0, var4 = new char[var5 + 1 + var6], 0, var5);
                }
                var4[var5++] = (char)var7;
            }
            var7 = var3.read(var4, var5, var6);
            if (var7 < 0) {
                break;
            }
            var5 += var7;
        }
        byte var9 = 0;
        if (var5 > 0 && "UTF-8".equals(var2) && var4[0] == '\ufeff') {
            --var5;
            var9 = 1;
        }
        if (var5 < var4.length) {
            System.arraycopy(var4, var9, var4 = new char[var5], 0, var5);
        }
        return var4;
    }

    public static int method_1324(int var0, int[] var1, int var2, int var3) {
        if (var1 == null) {
            return 1;
        } else if (var3 == -1) {
            return 1;
        } else {
            int var4 = var2;
            while (var2 <= var3) {
                var4 = var2 + (var3 - var2) / 2;
                int var5;
                if (var0 < (var5 = var1[var4])) {
                    var3 = var4 - 1;
                } else {
                    if (var0 <= var5) {
                        return var4 + 1;
                    }
                    var2 = var4 + 1;
                }
            }
            if (var0 < var1[var4]) {
                return var4 + 1;
            } else {
                return var4 + 2;
            }
        }
    }

    public static void method_1325(char[][] var0, int var1, int var2) {
        int var3 = var1;
        int var4 = var2;
        char[] var5 = var0[(var2 + var1) / 2];
        while (true) {
            while (CharOperation.method_1354(var0[var1], var5) <= 0) {
                while (CharOperation.method_1354(var5, var0[var2]) > 0) {
                    --var2;
                }
                if (var1 <= var2) {
                    char[] var6 = var0[var1];
                    var0[var1] = var0[var2];
                    var0[var2] = var6;
                    ++var1;
                    --var2;
                }
                if (var1 > var2) {
                    if (var3 < var2) {
                        method_1325(var0, var3, var2);
                    }
                    if (var1 < var4) {
                        method_1325(var0, var1, var4);
                    }
                    return;
                }
            }
            ++var1;
        }
    }

    public static void method_1326(char[][] var0, int var1, int var2, int[] var3) {
        int var4 = var1;
        int var5 = var2;
        char[] var6 = var0[(var2 + var1) / 2];
        while (true) {
            while (CharOperation.method_1354(var0[var1], var6) <= 0) {
                while (CharOperation.method_1354(var6, var0[var2]) > 0) {
                    --var2;
                }
                if (var1 <= var2) {
                    char[] var7 = var0[var1];
                    var0[var1] = var0[var2];
                    var0[var2] = var7;
                    int var8 = var3[var1];
                    var3[var1] = var3[var2];
                    var3[var2] = var8;
                    ++var1;
                    --var2;
                }
                if (var1 > var2) {
                    if (var4 < var2) {
                        method_1326(var0, var4, var2, var3);
                    }
                    if (var1 < var5) {
                        method_1326(var0, var1, var5, var3);
                    }
                    return;
                }
            }
            ++var1;
        }
    }

    public static final int method_1327(int[] var0, int var1, int var2) {
        switch (var1) {
            case 1:
                return var2 + 1;
            case 2:
                return var2 - var0[0];
            default:
                int var3 = var1 - 2;
                int var4 = var0.length;
                return var3 >= var4 ? var2 - var0[var4 - 1] : var2 - var0[var3];
        }
    }

    public static String method_1328(Object[] var0) {
        class_223 var10001 = new class_223();
        return method_1329(var0, var10001);
    }

    public static String method_1329(Object[] var0, class_1 var1) {
        if (var0 == null) {
            return "";
        } else {
            StringBuffer var2 = new StringBuffer(10);
            for (int var3 = 0; var3 < var0.length; ++var3) {
                if (var3 > 0) {
                    var2.append(", ");
                }
                var2.append(var1.method_7(var0[var3]));
            }
            return var2.toString();
        }
    }

    public static void method_1330(boolean var0, String var1, String var2, class_288 var3) throws IOException {
        FileOutputStream var4 = method_1321(var0, var1, var2);
        FileOutputStream var5 = var4;
        try {
            var5.write(var3.field_1722, 0, var3.field_1723);
            var5.write(var3.field_1718, 0, var3.field_1719);
            var5.flush();
        } catch (IOException var10) {
            throw var10;
        } finally {
            var4.close();
        }
    }

    static {
        field_981 = System.getProperty("line.separator");
        field_982 = new String(CharOperation.field_994);
        field_983 = new int[0];
    }
}
