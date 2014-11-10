package g;

public class class_309 {

    public class_309() {
    }

    public static String method_3156(String var0, Object[] var1) {
        if (var1 != null && var1.length >= 1) {
            StringBuffer var2 = new StringBuffer();
            boolean var3 = false;
            int var4 = 0;
            int var5;
            while ((var5 = var0.indexOf(123, var4)) >= 0) {
                if (var5 > var4) {
                    var2.append(var0.substring(var4, var5));
                }
                var4 = var0.indexOf(125, var5) + 1;
                var2.append(var1[Integer.parseInt(var0.substring(var5 + 1, var4 - 1))]);
            }
            var2.append(var0.substring(var4));
            return var2.toString();
        } else {
            return var0;
        }
    }
}
