package batch;

import b.class_233;
import c.class_284;
import f.class_226;
import g.class_308;
import java.io.IOException;
import k.class_19;
import n.class_242;

// $FF: renamed from: batch.c
public class class_237 implements class_19 {

    // $FF: renamed from: a char[]
    public char[] field_1007;
    // $FF: renamed from: a java.lang.String
    public String field_1008;
    // $FF: renamed from: b char[]
    public char[] field_1009;
    // $FF: renamed from: b java.lang.String
    String field_1010;
    // $FF: renamed from: c java.lang.String
    public String field_1011;

    // $FF: renamed from: <init> (char[], java.lang.String, java.lang.String, java.lang.String) void
    public class_237(char[] var1, String var2, String var3, String var4) {
        this.field_1007 = var1;
        char[] var5 = var2.toCharArray();
        switch (47) {
            case 47:
                if (class_233.method_1371('\\', var5) != -1) {
                    class_233.method_1382(var5, '\\', '/');
                }
                break;
            case 92:
                if (class_233.method_1371('/', var5) != -1) {
                    class_233.method_1382(var5, '/', '\\');
                }
        }
        this.field_1008 = var2;
        int var6 = class_233.method_1376('/', var5) + 1;
        int var7 = class_233.method_1376('.', var5);
        if (var7 == -1) {
            var7 = var5.length;
        }
        this.field_1009 = class_233.method_1388(var5, var6, var7);
        this.field_1010 = var3;
        this.field_1011 = var4;
    }

    // $FF: renamed from: a () char[]
    public char[] method_51() {
        if (this.field_1007 != null) {
            return this.field_1007;
        } else {
            try {
                class_308 var3 = new class_308(this.field_1008);
                return class_226.method_1320(var3, this.field_1010);
            } catch (IOException var2) {
                this.field_1007 = class_233.field_994;
                class_242 var10000 = new class_242((class_284)null, var2, this.field_1010);
                throw var10000;
            }
        }
    }

    // $FF: renamed from: a () java.lang.String
    public String method_50() {
        return this.field_1008;
    }

    // $FF: renamed from: b () char[]
    public char[] method_52() {
        return this.field_1009;
    }

    // $FF: renamed from: a () char[][]
    public char[][] method_53() {
        return (char[][])null;
    }

    public String toString() {
        return "CompilationUnit[" + this.field_1008 + "]";
    }
}