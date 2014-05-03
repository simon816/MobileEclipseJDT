package batch;

import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import n.class_246;

// $FF: renamed from: batch.f
public class class_214 {

    // $FF: renamed from: a java.util.Hashtable
    private static Hashtable field_919;

    // $FF: renamed from: <init> () void
    public class_214() {
    }

    // $FF: renamed from: a () java.util.Hashtable
    public static synchronized Hashtable method_1219() {
        if (field_919 == null) {
            field_919 = method_1220("/batch/messages.txt");
        }
        return field_919;
    }

    // $FF: renamed from: a (java.lang.String) java.util.Hashtable
    protected static Hashtable method_1220(String var0) {
        Hashtable var1 = new Hashtable();
        InputStream var2 = var0.getClass().getResourceAsStream(var0);
        label32:
        while (true) {
            try {
                while (true) {
                    if (var2.available() <= 0) {
                        break label32;
                    }
                    String var3 = class_246.method_1446(var2);
                    int var4 = var3.indexOf(61);
                    if (!var3.startsWith("#") && var4 >= 0) {
                        var1.put(var3.substring(0, var4 - 1), var3.substring(var4 + 2));
                    }
                }
            } catch (Exception var6) {
                var6.printStackTrace();
            }
        }
        try {
            var2.close();
        } catch (IOException var5) {
            var5.printStackTrace();
        }
        return var1;
    }

    // $FF: renamed from: <clinit> () void
    static {
        field_919 = null;
    }
}
