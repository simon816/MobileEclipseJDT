package org.eclipse.jdt.internal.compiler.classfmt;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.classfmt.class_186;
import org.eclipse.jdt.internal.compiler.classfmt.class_192;
import org.eclipse.jdt.internal.compiler.classfmt.class_193;
import org.eclipse.jdt.internal.compiler.classfmt.class_196;
import org.eclipse.jdt.internal.compiler.codegen.class_272;
import org.eclipse.jdt.internal.compiler.codegen.AttributeNamesConstants;
import org.eclipse.jdt.internal.compiler.env.class_25;
import org.eclipse.jdt.internal.compiler.env.class_29;
import org.eclipse.jdt.internal.compiler.util.Util;

import java.lang.Comparable;

public class class_191 extends class_186 implements Comparable, class_25 {

    private static final char[][] field_851;

    private static final char[][] field_852;

    protected int field_853;

    protected int field_854;

    protected char[] field_855;

    protected char[][] field_856;

    protected char[] field_857;

    protected char[] field_858;

    protected int field_859;

    protected long field_860;

    protected char[][] field_861;

    protected int field_862;

    public static class_191 method_1131(byte[] var0, int[] var1, int var2) {
        class_191 var10000 = new class_191(var0, var1, var2);
        class_191 var3 = var10000;
        int var4 = var3.method_1104(6);
        int var5 = 8;
        class_196[] var6 = null;
        class_196[][] var7 = (class_196[][])null;
        for (int var8 = 0; var8 < var4; ++var8) {
            int var9 = var3.field_806[var3.method_1104(var5)] - var3.field_807;
            char[] var10 = var3.method_1106(var9 + 3, var3.method_1104(var9 + 1));
            if (var10.length > 0) {
                label69:
                switch (var10[0]) {
                    case 82:
                        class_196[] var11 = null;
                        class_196[][] var12 = (class_196[][])null;
                        if (CharOperation.method_1364(var10, AttributeNamesConstants.field_18)) {
                            var11 = method_1133(var5, true, var3);
                        } else if (CharOperation.method_1364(var10, AttributeNamesConstants.field_17)) {
                            var11 = method_1133(var5, false, var3);
                        } else if (CharOperation.method_1364(var10, AttributeNamesConstants.field_20)) {
                            var12 = method_1134(var5, true, var3);
                        } else if (CharOperation.method_1364(var10, AttributeNamesConstants.field_19)) {
                            var12 = method_1134(var5, false, var3);
                        }
                        int var13;
                        if (var11 != null) {
                            if (var6 == null) {
                                var6 = var11;
                            } else {
                                var13 = var6.length;
                                class_196[] var20 = new class_196[var13 + var11.length];
                                System.arraycopy(var6, 0, var20, 0, var13);
                                System.arraycopy(var11, 0, var20, var13, var11.length);
                                var6 = var20;
                            }
                        } else {
                            if (var12 == null) {
                                break;
                            }
                            var13 = var12.length;
                            if (var7 == null) {
                                var7 = var12;
                            } else {
                                int var14 = 0;
                                while (true) {
                                    if (var14 >= var13) {
                                        break label69;
                                    }
                                    int var15 = var12[var14] == null ? 0 : var12[var14].length;
                                    if (var15 > 0) {
                                        if (var7[var14] == null) {
                                            var7[var14] = var12[var14];
                                        } else {
                                            int var16 = var7[var14].length;
                                            class_196[] var17 = new class_196[var16 + var15];
                                            System.arraycopy(var7[var14], 0, var17, 0, var16);
                                            System.arraycopy(var12[var14], 0, var17, var16, var15);
                                            var7[var14] = var17;
                                        }
                                    }
                                    ++var14;
                                }
                            }
                        }
                        break;
                    case 83:
                        if (CharOperation.method_1364(AttributeNamesConstants.field_13, var10)) {
                            var3.field_859 = var3.field_806[var3.method_1104(var5 + 6)] - var3.field_807;
                        }
                }
            }
            var5 = (int)((long)var5 + 6L + var3.method_1105(var5 + 2));
        }
        var3.field_854 = var5;
        if (var7 != null) {
            class_193 var19 = new class_193(var3, var6, var7);
            return var19;
        } else if (var6 != null) {
            class_192 var18 = new class_192(var3, var6);
            return var18;
        } else {
            return var3;
        }
    }

    static class_196[] method_1132(int var0, boolean var1, int var2, class_191 var3) {
        class_196[] var4 = new class_196[var2];
        int var5 = var0;
        for (int var6 = 0; var6 < var2; ++var6) {
            class_196 var10002 = new class_196(var3.field_805, var3.field_806, var5 + var3.field_807, var1, false);
            var4[var6] = var10002;
            var5 += var4[var6].field_870;
        }
        return var4;
    }

    static class_196[] method_1133(int var0, boolean var1, class_191 var2) {
        int var3 = var2.method_1104(var0 + 6);
        if (var3 <= 0) {
            return null;
        } else {
            class_196[] var4 = method_1132(var0 + 8, var1, var3, var2);
            if (var1) {
                int var5 = 0;
                for (int var6 = 0; var6 < var3; ++var6) {
                    long var7 = var4[var6].field_869;
                    var2.field_860 |= var7;
                    if (var7 != 0L) {
                        var4[var6] = null;
                        ++var5;
                    }
                }
                if (var5 != 0) {
                    if (var5 == var3) {
                        return null;
                    }
                    class_196[] var9 = new class_196[var3 - var5];
                    int var10 = 0;
                    for (int var8 = 0; var8 < var3; ++var8) {
                        if (var4[var8] != null) {
                            var9[var10++] = var4[var8];
                        }
                    }
                    var4 = var9;
                }
            }
            return var4;
        }
    }

    static class_196[][] method_1134(int var0, boolean var1, class_191 var2) {
        class_196[][] var3 = (class_196[][])null;
        int var4 = var2.method_1103(var0 + 6);
        if (var4 > 0) {
            int var5 = var0 + 7;
            for (int var6 = 0; var6 < var4; ++var6) {
                int var7 = var2.method_1104(var5);
                var5 += 2;
                if (var7 > 0) {
                    if (var3 == null) {
                        var3 = new class_196[var4][];
                    }
                    class_196[] var8 = method_1132(var5, var1, var7, var2);
                    var3[var6] = var8;
                    for (int var9 = 0; var9 < var8.length; ++var9) {
                        var5 += var8[var9].field_870;
                    }
                }
            }
        }
        return var3;
    }

    protected class_191(byte[] var1, int[] var2, int var3) {
        super(var1, var2, var3);
        this.field_853 = -1;
        this.field_859 = -1;
    }

    public int compareTo(Object var1) {
        class_191 var2 = (class_191)var1;
        int var3 = (new String(this.method_77())).compareTo(new String(var2.method_77()));
        return var3 != 0 ? var3 : (new String(this.method_75())).compareTo(new String(var2.method_75()));
    }

    public boolean equals(Object var1) {
        if (!(var1 instanceof class_191)) {
            return false;
        } else {
            class_191 var2 = (class_191)var1;
            return CharOperation.method_1364(this.method_77(), var2.method_77()) && CharOperation.method_1364(this.method_75(), var2.method_75());
        }
    }

    public int hashCode() {
        return CharOperation.method_1369(this.method_77()) + CharOperation.method_1369(this.method_75());
    }

    public class_29[] method_71() {
        return null;
    }

    public char[][] method_1135() {
        if (this.field_861 == null) {
            this.method_1142();
        }
        return this.field_861;
    }

    public Object method_72() {
        return null;
    }

    public char[][] method_73() {
        if (this.field_856 == null) {
            this.method_1137();
        }
        return this.field_856;
    }

    public char[] method_74() {
        if (this.field_859 != -1) {
            if (this.field_858 == null) {
                this.field_858 = this.method_1106(this.field_859 + 3, this.method_1104(this.field_859 + 1));
            }
            return this.field_858;
        } else {
            return null;
        }
    }

    public char[] method_75() {
        if (this.field_855 == null) {
            int var1 = this.field_806[this.method_1104(4)] - this.field_807;
            this.field_855 = this.method_1106(var1 + 3, this.method_1104(var1 + 1));
        }
        return this.field_855;
    }

    public int method_69() {
        if (this.field_853 == -1) {
            this.field_853 = this.method_1104(0);
            this.method_1138();
        }
        return this.field_853;
    }

    public class_29[] method_76(int var1) {
        return null;
    }

    public char[] method_77() {
        if (this.field_857 == null) {
            int var1 = this.field_806[this.method_1104(2)] - this.field_807;
            this.field_857 = this.method_1106(var1 + 3, this.method_1104(var1 + 1));
        }
        return this.field_857;
    }

    public long method_78() {
        return this.field_860;
    }

    protected void method_1136() {
        this.method_69();
        this.method_77();
        this.method_75();
        this.method_73();
        this.method_74();
        this.method_1135();
        this.method_1102();
    }

    public boolean method_70() {
        char[] var1 = this.method_77();
        return var1[0] == 60 && var1.length == 6;
    }

    private void method_1137() {
        int var1 = this.method_1104(6);
        int var2 = 8;
        for (int var3 = 0; var3 < var1; ++var3) {
            int var4 = this.field_806[this.method_1104(var2)] - this.field_807;
            char[] var5 = this.method_1106(var4 + 3, this.method_1104(var4 + 1));
            if (CharOperation.method_1364(var5, AttributeNamesConstants.field_10)) {
                int var6 = this.method_1104(var2 + 6);
                var2 += 8;
                if (var6 == 0) {
                    this.field_856 = field_851;
                } else {
                    this.field_856 = new char[var6][];
                    for (int var7 = 0; var7 < var6; ++var7) {
                        var4 = this.field_806[this.method_1104(this.field_806[this.method_1104(var2)] - this.field_807 + 1)] - this.field_807;
                        this.field_856[var7] = this.method_1106(var4 + 3, this.method_1104(var4 + 1));
                        var2 += 2;
                    }
                }
            } else {
                var2 = (int)((long)var2 + 6L + this.method_1105(var2 + 2));
            }
        }
        if (this.field_856 == null) {
            this.field_856 = field_851;
        }
    }

    private void method_1138() {
        int var1 = this.method_1104(6);
        int var2 = 8;
        for (int var3 = 0; var3 < var1; ++var3) {
            int var4 = this.field_806[this.method_1104(var2)] - this.field_807;
            char[] var5 = this.method_1106(var4 + 3, this.method_1104(var4 + 1));
            if (var5.length != 0) {
                switch (var5[0]) {
                    case 65:
                        if (CharOperation.method_1364(var5, AttributeNamesConstants.field_16)) {
                            this.field_853 |= 131072;
                        }
                        break;
                    case 68:
                        if (CharOperation.method_1364(var5, AttributeNamesConstants.field_12)) {
                            this.field_853 |= 1048576;
                        }
                        break;
                    case 83:
                        if (CharOperation.method_1364(var5, AttributeNamesConstants.field_4)) {
                            this.field_853 |= 4096;
                        }
                        break;
                    case 86:
                        if (CharOperation.method_1364(var5, AttributeNamesConstants.field_23)) {
                            this.field_853 |= 128;
                        }
                }
            }
            var2 = (int)((long)var2 + 6L + this.method_1105(var2 + 2));
        }
    }

    public int method_1139() {
        return this.field_854;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        this.method_1140(var1);
        return var1.toString();
    }

    void method_1140(StringBuffer var1) {
        var1.append(this.getClass().getName());
        this.method_1141(var1);
    }

    protected void method_1141(StringBuffer var1) {
        int var2 = this.method_69();
        char[] var3 = this.method_74();
        if (var3 == null) {
            var3 = this.method_75();
        }
        var1.append('{').append(((var2 & 1048576) != 0 ? "deprecated " : Util.field_982) + ((var2 & 1) == 1 ? "public " : Util.field_982) + ((var2 & 2) == 2 ? "private " : Util.field_982) + ((var2 & 4) == 4 ? "protected " : Util.field_982) + ((var2 & 8) == 8 ? "static " : Util.field_982) + ((var2 & 16) == 16 ? "final " : Util.field_982) + ((var2 & 64) == 64 ? "bridge " : Util.field_982) + ((var2 & 128) == 128 ? "varargs " : Util.field_982)).append(this.method_77()).append(var3).append('}');
    }

    private void method_1142() {
        int var1 = this.method_1104(6);
        int var2 = 8;
        if (var1 != 0) {
            for (int var3 = 0; var3 < var1; ++var3) {
                int var4 = this.field_806[this.method_1104(var2)] - this.field_807;
                char[] var5 = this.method_1106(var4 + 3, this.method_1104(var4 + 1));
                if (CharOperation.method_1364(var5, AttributeNamesConstants.field_9)) {
                    this.method_1143(var2);
                    if (this.field_861 == null) {
                        this.field_861 = field_852;
                    }
                    return;
                }
                var2 = (int)((long)var2 + 6L + this.method_1105(var2 + 2));
            }
        }
        this.field_861 = field_852;
    }

    private void method_1143(int var1) {
        int var2 = var1 + 10;
        int var3 = (int)this.method_1105(var2);
        var2 += 4 + var3;
        int var4 = this.method_1104(var2);
        var2 += 2;
        int var5;
        if (var4 != 0) {
            for (var5 = 0; var5 < var4; ++var5) {
                var2 += 8;
            }
        }
        var5 = this.method_1104(var2);
        var2 += 2;
        for (int var6 = 0; var6 < var5; ++var6) {
            int var7 = this.field_806[this.method_1104(var2)] - this.field_807;
            char[] var8 = this.method_1106(var7 + 3, this.method_1104(var7 + 1));
            if (CharOperation.method_1364(var8, AttributeNamesConstants.field_7)) {
                this.method_1144(var2, var3);
            }
            var2 = (int)((long)var2 + 6L + this.method_1105(var2 + 2));
        }
    }

    private void method_1144(int var1, int var2) {
        int var3 = var1 + 6;
        int var4 = this.method_1104(var3);
        if (var4 != 0) {
            var3 += 2;
            this.field_861 = new char[var4][];
            this.field_862 = 0;
            for (int var5 = 0; var5 < var4; ++var5) {
                int var6 = this.method_1104(var3);
                if (var6 != 0) {
                    break;
                }
                int var7 = this.method_1104(4 + var3);
                int var8 = this.field_806[var7] - this.field_807;
                char[] var9 = this.method_1106(var8 + 3, this.method_1104(var8 + 1));
                if (!CharOperation.method_1364(var9, class_272.field_1493)) {
                    this.field_861[this.field_862++] = var9;
                }
                var3 += 10;
            }
            if (this.field_862 != this.field_861.length) {
                System.arraycopy(this.field_861, 0, this.field_861 = new char[this.field_862][], 0, this.field_862);
            }
        }
    }

    static {
        field_851 = CharOperation.field_995;
        field_852 = CharOperation.field_995;
    }
}
