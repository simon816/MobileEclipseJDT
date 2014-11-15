package org.eclipse.jdt.internal.compiler.util;

import java.util.Map$Entry;
import java.util.HashMap;
import java.util.Arrays;

import java.io.OutputStream;
import java.io.PrintStream;

import org.eclipse.jdt.internal.compiler.util.GenericXMLWriter$1;

public class GenericXMLWriter extends PrintStream {

    public GenericXMLWriter(OutputStream var0) {
        super(var0);
    }

    private String field_890;

    private int field_891;

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

    private static String method_1187(String var0) {
        StringBuffer var1 = new StringBuffer(var0.length() + 10);
        for (int var2 = 0; var2 < var0.length(); ++var2) {
            method_1186(var1, var0.charAt(var2));
        }
        return var1.toString();
    }

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

    public void method_1189(String var1, boolean var2, boolean var3) {
        --this.field_891;
        this.method_1191('/' + var1, (HashMap)null, var2, var3, false);
    }

    private void method_1190() {
        for (int var1 = 0; var1 < this.field_891; ++var1) {
            this.print('\t');
        }
    }

    public void method_1191(String var1, HashMap var2, boolean var3, boolean var4, boolean var5) {
        if (var3) {
            this.method_1190();
        }
        this.print('<');
        this.print(var1);
        if (var2 != null) {
            int var6 = var2.size();
            Map$Entry[] var7 = new Map$Entry[var6];
            var2.entrySet().toArray(var7);
            GenericXMLWriter$1 var10001 = new GenericXMLWriter$1(this);
            Arrays.sort(var7, var10001);
            for (int var8 = 0; var8 < var6; ++var8) {
                this.print(' ');
                this.print(var7[var8].getKey());
                this.print("=\"");
                this.print(method_1187(String.valueOf(var7[var8].getValue())));
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
