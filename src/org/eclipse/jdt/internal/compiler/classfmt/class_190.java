package org.eclipse.jdt.internal.compiler.classfmt;

import java.io.IOException;

import java.io.File;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.classfmt.class_186;
import org.eclipse.jdt.internal.compiler.classfmt.class_187;
import org.eclipse.jdt.internal.compiler.classfmt.class_189;
import org.eclipse.jdt.internal.compiler.classfmt.class_191;
import org.eclipse.jdt.internal.compiler.classfmt.class_194;
import org.eclipse.jdt.internal.compiler.classfmt.class_196;
import org.eclipse.jdt.internal.compiler.classfmt.class_198;
import org.eclipse.jdt.internal.compiler.codegen.AttributeNamesConstants;
import org.eclipse.jdt.internal.compiler.env.class_22;
import org.eclipse.jdt.internal.compiler.env.class_23;
import org.eclipse.jdt.internal.compiler.env.class_25;
import org.eclipse.jdt.internal.compiler.env.class_27;
import org.eclipse.jdt.internal.compiler.env.class_29;
import org.eclipse.jdt.internal.compiler.util.Util;

public class class_190 extends class_186 implements class_22 {

    private int field_828;

    private String field_829;

    private char[] field_830;

    private int field_831;

    private int field_832;

    private class_196[] field_833;

    private class_187[] field_834;

    private int field_835;

    private class_189 field_836;

    private int field_837;

    private class_189[] field_838;

    private char[][] field_839;

    private int field_840;

    private class_191[] field_841;

    private int field_842;

    private char[] field_843;

    private char[] field_844;

    private char[] field_845;

    private char[] field_846;

    private long field_847;

    private long field_848;

    private char[] field_849;

    private char[][][] field_850;

    private static String method_1120(int var0) {
        ByteArrayOutputStream var1 = new ByteArrayOutputStream();
        PrintStream var2 = new PrintStream(var1);
        if ((var0 & 1) != 0) {
            var2.print("public ");
        }
        if ((var0 & 2) != 0) {
            var2.print("private ");
        }
        if ((var0 & 16) != 0) {
            var2.print("final ");
        }
        if ((var0 & 32) != 0) {
            var2.print("super ");
        }
        if ((var0 & 512) != 0) {
            var2.print("interface ");
        }
        if ((var0 & 1024) != 0) {
            var2.print("abstract ");
        }
        var2.flush();
        return var1.toString();
    }

    public static class_190 method_1121(File var0, boolean var1) throws IOException, class_198 {
        byte[] var2 = Util.method_1319(var0);
        class_190 var10000 = new class_190(var2, var0.getPath());
        class_190 var3 = var10000;
        if (var1) {
            var3.method_1130();
        }
        return var3;
    }

    public static class_190 method_1122(String var0) throws IOException, class_198 {
        return method_1123(var0, false);
    }

    public static class_190 method_1123(String var0, boolean var1) throws IOException, class_198 {
        File var10000 = new File(var0);
        return method_1121(var10000, var1);
    }

    public class_190(byte[] var1, String var2) throws class_198 {
        this(var1, var2, false);
    }

    public class_190(byte[] var1, String var2, boolean var3) throws class_198 {
        super(var1, (int[])null, 0);
        this.field_829 = var2;
        int var4 = 10;
        try {
            this.field_848 = ((long)this.method_1104(6) << 16) + (long)this.method_1104(4);
            this.field_832 = this.method_1104(8);
            this.field_806 = new int[this.field_832];
            int var5;
            int var6;
            for (var5 = 1; var5 < this.field_832; ++var5) {
                var6 = this.method_1103(var4);
                switch (var6) {
                    case 1:
                        this.field_806[var5] = var4;
                        var4 += this.method_1104(var4 + 1);
                        var4 += 3;
                    case 2:
                    default:
                        break;
                    case 3:
                        this.field_806[var5] = var4;
                        var4 += 5;
                        break;
                    case 4:
                        this.field_806[var5] = var4;
                        var4 += 5;
                        break;
                    case 5:
                        this.field_806[var5] = var4;
                        var4 += 9;
                        ++var5;
                        break;
                    case 6:
                        this.field_806[var5] = var4;
                        var4 += 9;
                        ++var5;
                        break;
                    case 7:
                        this.field_806[var5] = var4;
                        var4 += 3;
                        break;
                    case 8:
                        this.field_806[var5] = var4;
                        var4 += 3;
                        break;
                    case 9:
                        this.field_806[var5] = var4;
                        var4 += 5;
                        break;
                    case 10:
                        this.field_806[var5] = var4;
                        var4 += 5;
                        break;
                    case 11:
                        this.field_806[var5] = var4;
                        var4 += 5;
                        break;
                    case 12:
                        this.field_806[var5] = var4;
                        var4 += 5;
                }
            }
            this.field_828 = this.method_1104(var4);
            var4 += 2;
            this.field_831 = this.method_1104(var4);
            this.field_830 = this.method_1128(this.field_831);
            var4 += 2;
            var5 = this.method_1104(var4);
            var4 += 2;
            if (var5 != 0) {
                this.field_846 = this.method_1128(var5);
            }
            this.field_840 = this.method_1104(var4);
            var4 += 2;
            if (this.field_840 != 0) {
                this.field_839 = new char[this.field_840][];
                for (var6 = 0; var6 < this.field_840; ++var6) {
                    this.field_839[var6] = this.method_1128(this.method_1104(var4));
                    var4 += 2;
                }
            }
            this.field_835 = this.method_1104(var4);
            var4 += 2;
            int var7;
            if (this.field_835 != 0) {
                this.field_834 = new class_187[this.field_835];
                for (var7 = 0; var7 < this.field_835; ++var7) {
                    class_187 var17 = class_187.method_1107(this.field_805, this.field_806, var4);
                    this.field_834[var7] = var17;
                    var4 += var17.method_1113();
                }
            }
            this.field_842 = this.method_1104(var4);
            var4 += 2;
            if (this.field_842 != 0) {
                this.field_841 = new class_191[this.field_842];
                boolean var16 = (this.field_828 & 8192) != 0;
                for (var7 = 0; var7 < this.field_842; ++var7) {
                    this.field_841[var7] = var16 ? class_194.method_1148(this.field_805, this.field_806, var4) : class_191.method_1131(this.field_805, this.field_806, var4);
                    var4 += this.field_841[var7].method_1139();
                }
            }
            var6 = this.method_1104(var4);
            var4 += 2;
            for (var7 = 0; var7 < var6; ++var7) {
                int var8 = this.field_806[this.method_1104(var4)];
                char[] var9 = this.method_1106(var8 + 3, this.method_1104(var8 + 1));
                if (var9.length == 0) {
                    var4 = (int)((long)var4 + 6L + this.method_1105(var4 + 2));
                } else {
                    int var10;
                    int var11;
                    int var12;
                    switch (var9[0]) {
                        case 68:
                            if (CharOperation.method_1364(var9, AttributeNamesConstants.field_12)) {
                                this.field_828 |= 1048576;
                            }
                            break;
                        case 69:
                            if (CharOperation.method_1364(var9, AttributeNamesConstants.field_15)) {
                                var8 = this.field_806[this.method_1104(this.field_806[this.method_1104(var4 + 6)] - this.field_807 + 1)] - this.field_807;
                                this.field_849 = this.method_1106(var8 + 3, this.method_1104(var8 + 1));
                            }
                        case 70:
                        case 71:
                        case 72:
                        case 74:
                        case 75:
                        case 76:
                        case 78:
                        case 79:
                        case 80:
                        case 81:
                        default:
                            break;
                        case 73:
                            if (CharOperation.method_1364(var9, AttributeNamesConstants.field_8)) {
                                var10 = var4 + 6;
                                var11 = this.method_1104(var10);
                                if (var11 != 0) {
                                    var10 += 2;
                                    this.field_838 = new class_189[var11];
                                    for (var12 = 0; var12 < var11; ++var12) {
                                        class_189[] var19 = this.field_838;
                                        class_189 var10002 = new class_189(this.field_805, this.field_806, var10);
                                        var19[var12] = var10002;
                                        if (this.field_831 == this.field_838[var12].field_818) {
                                            this.field_836 = this.field_838[var12];
                                            this.field_837 = var12;
                                        }
                                        var10 += 8;
                                    }
                                    if (this.field_836 != null) {
                                        char[] var18 = this.field_836.method_1116();
                                        if (var18 != null) {
                                            this.field_849 = var18;
                                        }
                                    }
                                }
                            } else if (CharOperation.method_1364(var9, AttributeNamesConstants.field_22)) {
                                this.field_847 |= 131072L;
                            }
                            break;
                        case 77:
                            if (CharOperation.method_1364(var9, AttributeNamesConstants.field_25)) {
                                var10 = var4 + 6;
                                var11 = this.method_1104(var10);
                                if (var11 != 0) {
                                    this.field_850 = new char[var11][][];
                                    var10 += 2;
                                    for (var12 = 0; var12 < var11; ++var12) {
                                        var8 = this.field_806[this.method_1104(this.field_806[this.method_1104(var10)] + 1)];
                                        char[] var13 = this.method_1106(var8 + 3, this.method_1104(var8 + 1));
                                        this.field_850[var12] = CharOperation.method_1385('/', var13);
                                        var10 += 2;
                                    }
                                }
                            }
                            break;
                        case 82:
                            if (CharOperation.method_1364(var9, AttributeNamesConstants.field_18)) {
                                this.method_1127(var4, true);
                            } else if (CharOperation.method_1364(var9, AttributeNamesConstants.field_17)) {
                                this.method_1127(var4, false);
                            }
                            break;
                        case 83:
                            if (var9.length > 2) {
                                switch (var9[1]) {
                                    case 105:
                                        if (CharOperation.method_1364(var9, AttributeNamesConstants.field_13)) {
                                            var8 = this.field_806[this.method_1104(var4 + 6)];
                                            this.field_843 = this.method_1106(var8 + 3, this.method_1104(var8 + 1));
                                        }
                                        break;
                                    case 111:
                                        if (CharOperation.method_1364(var9, AttributeNamesConstants.field_11)) {
                                            var8 = this.field_806[this.method_1104(var4 + 6)];
                                            this.field_845 = this.method_1106(var8 + 3, this.method_1104(var8 + 1));
                                        }
                                        break;
                                    case 121:
                                        if (CharOperation.method_1364(var9, AttributeNamesConstants.field_4)) {
                                            this.field_828 |= 4096;
                                        }
                                }
                            }
                    }
                    var4 = (int)((long)var4 + 6L + this.method_1105(var4 + 2));
                }
            }
            if (var3) {
                this.method_1130();
            }
        } catch (class_198 var14) {
            throw var14;
        } catch (Exception var15) {
            class_198 var10000 = new class_198(21, var4);
            throw var10000;
        }
    }

    public int method_1126() {
        return this.field_828;
    }

    private void method_1127(int var1, boolean var2) {
        int var3 = this.method_1104(var1 + 6);
        if (var3 > 0) {
            int var4 = var1 + 8;
            class_196[] var5 = null;
            int var6 = 0;
            int var7;
            for (var7 = 0; var7 < var3; ++var7) {
                class_196 var10000 = new class_196(this.field_805, this.field_806, var4, var2, false);
                class_196 var8 = var10000;
                var4 += var8.field_870;
                long var9 = var8.field_869;
                if (var9 != 0L) {
                    this.field_847 |= var9;
                } else {
                    if (var5 == null) {
                        var5 = new class_196[var3 - var7];
                    }
                    var5[var6++] = var8;
                }
            }
            if (var5 == null) {
                return;
            }
            if (this.field_833 == null) {
                if (var6 != var5.length) {
                    System.arraycopy(var5, 0, var5 = new class_196[var6], 0, var6);
                }
                this.field_833 = var5;
            } else {
                var7 = this.field_833.length;
                class_196[] var11 = new class_196[var7 + var6];
                System.arraycopy(this.field_833, 0, var11, 0, var7);
                System.arraycopy(var5, 0, var11, var7, var6);
                this.field_833 = var11;
            }
        }
    }

    public class_29[] method_55() {
        return this.field_833;
    }

    private char[] method_1128(int var1) {
        int var2 = this.field_806[this.method_1104(this.field_806[var1] + 1)];
        return this.method_1106(var2 + 3, this.method_1104(var2 + 1));
    }

    public char[] method_51() {
        return this.field_849;
    }

    public class_27[] method_56() {
        return this.field_834;
    }

    public String method_50() {
        return this.field_829;
    }

    public char[] method_52() {
        return this.field_843;
    }

    public char[] method_1129() {
        return this.field_836 != null ? this.field_836.method_1118() : null;
    }

    public char[][] method_53() {
        return this.field_839;
    }

    public class_23[] method_57() {
        if (this.field_838 == null) {
            return null;
        } else {
            int var1 = this.field_838.length;
            int var2 = this.field_836 != null ? this.field_837 + 1 : 0;
            if (var1 != var2) {
                class_23[] var3 = new class_23[var1 - this.field_837];
                int var4 = 0;
                for (int var5 = var2; var5 < var1; ++var5) {
                    class_189 var6 = this.field_838[var5];
                    int var7 = var6.field_819;
                    int var8 = var6.field_820;
                    if (var7 != 0 && var8 != 0 && var7 == this.field_831 && var6.method_1118().length != 0) {
                        var3[var4++] = var6;
                    }
                }
                if (var4 == 0) {
                    return null;
                } else {
                    if (var4 != var3.length) {
                        System.arraycopy(var3, 0, var3 = new class_23[var4], 0, var4);
                    }
                    return var3;
                }
            } else {
                return null;
            }
        }
    }

    public class_25[] method_58() {
        return this.field_841;
    }

    public char[][][] method_59() {
        return this.field_850;
    }

    public int method_54() {
        return this.field_836 != null ? this.field_836.method_1117() | this.field_828 & 1048576 : this.field_828;
    }

    public char[] method_60() {
        return this.field_830;
    }

    public char[] method_61() {
        if (this.field_844 != null) {
            return this.field_844;
        } else {
            char[] var1 = this.method_1129();
            if (var1 == null) {
                var1 = this.method_60();
                int var2;
                if (this.method_64()) {
                    var2 = CharOperation.method_1374('$', var1, CharOperation.method_1376('/', var1) + 1) + 1;
                } else {
                    var2 = CharOperation.method_1376('/', var1) + 1;
                }
                if (var2 > 0) {
                    char[] var3 = new char[var1.length - var2];
                    System.arraycopy(var1, var2, var3, 0, var3.length);
                    var1 = var3;
                }
            }
            return this.field_844 = var1;
        }
    }

    public char[] method_62() {
        return this.field_846;
    }

    public long method_63() {
        return this.field_847;
    }

    private void method_1130() throws class_198 {
        try {
            int var1 = 0;
            int var2;
            for (var2 = this.field_835; var1 < var2; ++var1) {
                this.field_834[var1].method_1109();
            }
            var1 = 0;
            for (var2 = this.field_842; var1 < var2; ++var1) {
                this.field_841[var1].method_1136();
            }
            if (this.field_838 != null) {
                var1 = 0;
                for (var2 = this.field_838.length; var1 < var2; ++var1) {
                    this.field_838[var1].method_1119();
                }
            }
            if (this.field_833 != null) {
                var1 = 0;
                for (var2 = this.field_833.length; var1 < var2; ++var1) {
                    this.field_833[var1].method_1154();
                }
            }
            this.method_1102();
        } catch (RuntimeException var3) {
            class_198 var10000 = new class_198(var3, this.field_829);
            throw var10000;
        }
    }

    public boolean method_64() {
        if (this.field_836 == null) {
            return false;
        } else {
            char[] var1 = this.field_836.method_1118();
            return var1 == null || var1.length == 0;
        }
    }

    public boolean method_65() {
        if (this.field_836 == null) {
            return false;
        } else if (this.field_836.method_1116() != null) {
            return false;
        } else {
            char[] var1 = this.field_836.method_1118();
            return var1 != null && var1.length > 0;
        }
    }

    public boolean method_66() {
        if (this.field_836 == null) {
            return false;
        } else if (this.field_836.method_1116() == null) {
            return false;
        } else {
            char[] var1 = this.field_836.method_1118();
            return var1 != null && var1.length > 0;
        }
    }

    public String toString() {
        ByteArrayOutputStream var1 = new ByteArrayOutputStream();
        PrintStream var2 = new PrintStream(var1);
        var2.println(this.getClass().getName() + "{");
        var2.println(" this.className: " + new String(this.method_60()));
        var2.println(" this.superclassName: " + (this.method_62() == null ? "null" : new String(this.method_62())));
        var2.println(" access_flags: " + method_1120(this.method_1126()) + "(" + this.method_1126() + ")");
        var2.flush();
        return var1.toString();
    }
}
