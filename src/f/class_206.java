package f;

import f.class_209;
import g.class_15;
import g.class_312;
import g.class_316;

import java.io.OutputStream;
import java.io.PrintStream;

// $FF: renamed from: f.l
public class class_206 extends PrintStream {

    public class_206(OutputStream var0) {
        super(var0);
    }

// $FF: renamed from: a java.lang.String
    private String field_890;
    // $FF: renamed from: a int
    private int field_891;

    // $FF: renamed from: a (java.lang.StringBuffer, char) void
    private static void method_1186(StringBuffer var0, char var1) {
        String var2 = method_1188(var1);
        if (var2 != null) {
            var0.append('&');
            var0.append(var2);
            var0.append(';');
        } else {
            var0.append(var1);
        }
    }

    // $FF: renamed from: a (java.lang.String) java.lang.String
    private static String method_1187(String var0) {
        StringBuffer var1 = new StringBuffer(var0.length() + 10);
        for (int var2 = 0; var2 < var0.length(); ++var2) {
            method_1186(var1, var0.charAt(var2));
        }
        return var1.toString();
    }

    // $FF: renamed from: a (char) java.lang.String
    private static String method_1188(char var0) {
        switch (var0) {
            case 34:
                return "quot";
            case 38:
                return "amp";
            case 39:
                return "apos";
            case 60:
                return "lt";
            case 62:
                return "gt";
            default:
                return null;
        }
    }

    // $FF: renamed from: a (java.lang.String, boolean, boolean) void
    public void method_1189(String var1, boolean var2, boolean var3) {
        --this.field_891;
        this.method_1191('/' + var1, (class_312)null, var2, var3, false);
    }

    // $FF: renamed from: a () void
    private void method_1190() {
        for (int var1 = 0; var1 < this.field_891; ++var1) {
            this.print('\t');
        }
    }

    // $FF: renamed from: a (java.lang.String, g.j, boolean, boolean, boolean) void
    public void method_1191(String var1, class_312 var2, boolean var3, boolean var4, boolean var5) {
        if (var3) {
            this.method_1190();
        }
        this.print('<');
        this.print(var1);
        if (var2 != null) {
            int var6 = var2.method_37();
            class_15[] var7 = new class_15[var6];
            var2.method_44().method_33(var7);
            class_209 var10001 = new class_209(this);
            class_316.method_3170(var7, var10001);
            for (int var8 = 0; var8 < var6; ++var8) {
                this.print(' ');
                this.print(var7[var8].method_45());
                this.print("=\"");
                this.print(method_1187(String.valueOf(var7[var8].method_46())));
                this.print('\"');
            }
        }
        if (var5) {
            this.print("/>");
        } else {
            this.print(">");
        }
        if (var4) {
            this.print(this.field_890);
        }
        if (var2 != null && !var5) {
            ++this.field_891;
        }
    }
}
