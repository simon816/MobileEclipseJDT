package batch;

import b.CharOperation;
import c.class_284;
import f.Util;
import java.io.File;
import java.io.IOException;
import k.class_19;
import n.class_242;

public class class_237 implements class_19 {

    public char[] field_1007;

    public String field_1008;

    public char[] field_1009;

    String field_1010;

    public String field_1011;

    public class_237(char[] var1, String var2, String var3, String var4) {
        this.field_1007 = var1;
        char[] var5 = var2.toCharArray();
        switch (47) {
            case 47:
                if (CharOperation.method_1371('\\', var5) != -1) {
                    CharOperation.method_1382(var5, '\\', '/');
                }
                break;
            case 92:
                if (CharOperation.method_1371('/', var5) != -1) {
                    CharOperation.method_1382(var5, '/', '\\');
                }
        }
        this.field_1008 = var2;
        int var6 = CharOperation.method_1376('/', var5) + 1;
        int var7 = CharOperation.method_1376('.', var5);
        if (var7 == -1) {
            var7 = var5.length;
        }
        this.field_1009 = CharOperation.method_1388(var5, var6, var7);
        this.field_1010 = var3;
        this.field_1011 = var4;
    }

    public char[] method_51() {
        if (this.field_1007 != null) {
            return this.field_1007;
        } else {
            try {
                File var3 = new File(this.field_1008);
                return Util.method_1320(var3, this.field_1010);
            } catch (IOException var2) {
                this.field_1007 = CharOperation.field_994;
                class_242 var10000 = new class_242((class_284)null, var2, this.field_1010);
                throw var10000;
            }
        }
    }

    public String method_50() {
        return this.field_1008;
    }

    public char[] method_52() {
        return this.field_1009;
    }

    public char[][] method_53() {
        return (char[][])null;
    }

    public String toString() {
        return "CompilationUnit[" + this.field_1008 + "]";
    }
}
