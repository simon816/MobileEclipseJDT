package e;

import a.class_332;
import a.class_333;
import a.class_334;
import a.class_335;
import a.class_336;
import a.class_337;
import a.class_338;
import a.class_339;
import a.class_340;
import b.class_233;
import e.class_186;
import e.class_199;
import h.class_164;
import i.class_272;
import k.class_29;
import k.class_30;
import k.class_318;
import k.class_319;

// $FF: renamed from: e.b
public class class_196 extends class_186 implements class_29 {

    // $FF: renamed from: a char[]
    private char[] field_867;
    // $FF: renamed from: a e.e[]
    private class_199[] field_868;
    // $FF: renamed from: a long
    long field_869;
    // $FF: renamed from: a int
    int field_870;
    // $FF: renamed from: a java.lang.Object[]
    static Object[] field_871;

    // $FF: renamed from: <init> (byte[], int[], int) void
    class_196(byte[] var1, int[] var2, int var3) {
        super(var1, var2, var3);
        this.field_869 = 0L;
        this.field_870 = 0;
    }

    // $FF: renamed from: <init> (byte[], int[], int, boolean, boolean) void
    class_196(byte[] var1, int[] var2, int var3, boolean var4, boolean var5) {
        this(var1, var2, var3);
        if (var5) {
            this.method_1152();
        } else {
            this.field_870 = this.method_1157(0, var4, true);
        }
    }

    // $FF: renamed from: c () void
    private void method_1152() {
        this.field_870 = 0;
        int var1 = this.field_806[this.method_1104(0)] - this.field_807;
        this.field_867 = this.method_1106(var1 + 3, this.method_1104(var1 + 1));
        int var2 = this.method_1104(2);
        this.field_870 += 4;
        this.field_868 = var2 == 0 ? class_199.field_880 : new class_199[var2];
        for (int var3 = 0; var3 < var2; ++var3) {
            var1 = this.field_806[this.method_1104(this.field_870)] - this.field_807;
            char[] var4 = this.method_1106(var1 + 3, this.method_1104(var1 + 1));
            this.field_870 += 2;
            Object var5 = this.method_1153();
            class_199[] var10000 = this.field_868;
            class_199 var10002 = new class_199(var4, var5);
            var10000[var3] = var10002;
        }
    }

    // $FF: renamed from: a () java.lang.Object
    Object method_1153() {
        Object var1 = null;
        int var2 = this.method_1103(this.field_870);
        ++this.field_870;
        boolean var3 = true;
        int var10;
        switch (var2) {
            case 64:
                class_196 var12 = new class_196(this.field_805, this.field_806, this.field_870 + this.field_807, false, true);
                var1 = var12;
                this.field_870 += ((class_196)var1).field_870;
                break;
            case 65:
            case 69:
            case 71:
            case 72:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 100:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            default:
                throw new IllegalStateException("Unrecognized tag " + (char)var2);
            case 66:
                var10 = this.field_806[this.method_1104(this.field_870)] - this.field_807;
                var1 = class_339.method_3305((byte)this.method_1100(var10 + 1));
                this.field_870 += 2;
                break;
            case 67:
                var10 = this.field_806[this.method_1104(this.field_870)] - this.field_807;
                var1 = class_338.method_3303((char)this.method_1100(var10 + 1));
                this.field_870 += 2;
                break;
            case 68:
                var10 = this.field_806[this.method_1104(this.field_870)] - this.field_807;
                var1 = class_332.method_3291(this.method_1098(var10 + 1));
                this.field_870 += 2;
                break;
            case 70:
                var10 = this.field_806[this.method_1104(this.field_870)] - this.field_807;
                var1 = class_333.method_3293(this.method_1099(var10 + 1));
                this.field_870 += 2;
                break;
            case 73:
                var10 = this.field_806[this.method_1104(this.field_870)] - this.field_807;
                var1 = class_337.method_3301(this.method_1100(var10 + 1));
                this.field_870 += 2;
                break;
            case 74:
                var10 = this.field_806[this.method_1104(this.field_870)] - this.field_807;
                var1 = class_335.method_3297(this.method_1101(var10 + 1));
                this.field_870 += 2;
                break;
            case 83:
                var10 = this.field_806[this.method_1104(this.field_870)] - this.field_807;
                var1 = class_334.method_3295((short)this.method_1100(var10 + 1));
                this.field_870 += 2;
                break;
            case 90:
                var10 = this.field_806[this.method_1104(this.field_870)] - this.field_807;
                var1 = class_340.method_3307(this.method_1100(var10 + 1) == 1);
                this.field_870 += 2;
                break;
            case 91:
                int var7 = this.method_1104(this.field_870);
                this.field_870 += 2;
                if (var7 == 0) {
                    var1 = field_871;
                    break;
                } else {
                    Object[] var8 = new Object[var7];
                    var1 = var8;
                    for (int var9 = 0; var9 < var7; ++var9) {
                        var8[var9] = this.method_1153();
                    }
                    return var1;
                }
            case 99:
                var10 = this.field_806[this.method_1104(this.field_870)] - this.field_807;
                char[] var6 = this.method_1106(var10 + 3, this.method_1104(var10 + 1));
                class_318 var11 = new class_318(var6);
                var1 = var11;
                this.field_870 += 2;
                break;
            case 101:
                var10 = this.field_806[this.method_1104(this.field_870)] - this.field_807;
                char[] var4 = this.method_1106(var10 + 3, this.method_1104(var10 + 1));
                this.field_870 += 2;
                var10 = this.field_806[this.method_1104(this.field_870)] - this.field_807;
                char[] var5 = this.method_1106(var10 + 3, this.method_1104(var10 + 1));
                this.field_870 += 2;
                class_319 var10000 = new class_319(var4, var5);
                var1 = var10000;
                break;
            case 115:
                var10 = this.field_806[this.method_1104(this.field_870)] - this.field_807;
                var1 = class_336.method_3299(String.valueOf(this.method_1106(var10 + 3, this.method_1104(var10 + 1))));
                this.field_870 += 2;
        }
        return var1;
    }

    // $FF: renamed from: a () k.d[]
    public class_30[] method_84() {
        if (this.field_868 == null) {
            this.method_1154();
        }
        return this.field_868;
    }

    // $FF: renamed from: a () char[]
    public char[] method_83() {
        return this.field_867;
    }

    // $FF: renamed from: a () void
    void method_1154() {
        if (this.field_868 == null) {
            this.method_1152();
        }
    }

    // $FF: renamed from: d (int) int
    private int method_1155(int var1) {
        int var3 = this.method_1103(var1);
        int var2 = var1 + 1;
        switch (var3) {
            case 64:
                var2 = this.method_1157(var2, false, false);
                break;
            case 65:
            case 69:
            case 71:
            case 72:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 100:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            default:
                throw new IllegalStateException();
            case 66:
            case 67:
            case 68:
            case 70:
            case 73:
            case 74:
            case 83:
            case 90:
            case 99:
            case 115:
                var2 += 2;
                break;
            case 91:
                int var8 = this.method_1104(var2);
                var2 += 2;
                for (int var7 = 0; var7 < var8; ++var7) {
                    var2 = this.method_1158(var2);
                }
                return var2;
            case 101:
                int var4 = this.field_806[this.method_1104(var2)] - this.field_807;
                char[] var5 = this.method_1106(var4 + 3, this.method_1104(var4 + 1));
                var2 += 2;
                if (var5.length == 38 && class_233.method_1364(var5, class_272.field_1509)) {
                    var4 = this.field_806[this.method_1104(var2)] - this.field_807;
                    char[] var6 = this.method_1106(var4 + 3, this.method_1104(var4 + 1));
                    this.field_869 |= class_164.method_1069(var6);
                }
                var2 += 2;
        }
        return var2;
    }

    // $FF: renamed from: e (int) int
    private int method_1156(int var1) {
        int var3 = this.method_1103(var1);
        int var2 = var1 + 1;
        switch (var3) {
            case 64:
                var2 = this.method_1157(var2, false, false);
                break;
            case 65:
            case 69:
            case 71:
            case 72:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 100:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            default:
                throw new IllegalStateException();
            case 66:
            case 67:
            case 68:
            case 70:
            case 73:
            case 74:
            case 83:
            case 90:
            case 99:
            case 115:
                var2 += 2;
                break;
            case 91:
                int var8 = this.method_1104(var2);
                var2 += 2;
                if (var8 == 0) {
                    this.field_869 |= 34359738368L;
                    break;
                } else {
                    for (int var7 = 0; var7 < var8; ++var7) {
                        var2 = this.method_1156(var2);
                    }
                    return var2;
                }
            case 101:
                int var4 = this.field_806[this.method_1104(var2)] - this.field_807;
                char[] var5 = this.method_1106(var4 + 3, this.method_1104(var4 + 1));
                var2 += 2;
                if (var5.length == 34 && class_233.method_1364(var5, class_272.field_1507)) {
                    var4 = this.field_806[this.method_1104(var2)] - this.field_807;
                    char[] var6 = this.method_1106(var4 + 3, this.method_1104(var4 + 1));
                    this.field_869 |= class_164.method_1070(var6);
                }
                var2 += 2;
        }
        return var2;
    }

    // $FF: renamed from: a (int, boolean, boolean) int
    private int method_1157(int var1, boolean var2, boolean var3) {
        int var5 = this.field_806[this.method_1104(var1)] - this.field_807;
        char[] var6 = this.method_1106(var5 + 3, this.method_1104(var5 + 1));
        if (var3) {
            this.field_867 = var6;
        }
        int var7 = this.method_1104(var1 + 2);
        int var4 = var1 + 4;
        if (var2 && var3) {
            switch (var6.length) {
                case 22:
                    if (class_233.method_1364(var6, class_272.field_1511)) {
                        this.field_869 |= 70368744177664L;
                        return var4;
                    }
                    break;
                case 29:
                    if (class_233.method_1364(var6, class_272.field_1510)) {
                        var4 += 2;
                        return this.method_1156(var4);
                    }
                    break;
                case 32:
                    if (class_233.method_1364(var6, class_272.field_1508)) {
                        var4 += 2;
                        return this.method_1155(var4);
                    }
                    if (class_233.method_1364(var6, class_272.field_1512)) {
                        this.field_869 |= 281474976710656L;
                        return var4;
                    }
                    break;
                case 33:
                    if (class_233.method_1364(var6, class_272.field_1506)) {
                        this.field_869 |= 140737488355328L;
                        return var4;
                    }
            }
        }
        for (int var8 = 0; var8 < var7; ++var8) {
            var4 += 2;
            var4 = this.method_1158(var4);
        }
        return var4;
    }

    // $FF: renamed from: f (int) int
    private int method_1158(int var1) {
        int var3 = this.method_1103(var1);
        int var2 = var1 + 1;
        switch (var3) {
            case 64:
                var2 = this.method_1157(var2, false, false);
                break;
            case 65:
            case 69:
            case 71:
            case 72:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 100:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            default:
                throw new IllegalStateException();
            case 66:
            case 67:
            case 68:
            case 70:
            case 73:
            case 74:
            case 83:
            case 90:
            case 99:
            case 115:
                var2 += 2;
                break;
            case 91:
                int var4 = this.method_1104(var2);
                var2 += 2;
                for (int var5 = 0; var5 < var4; ++var5) {
                    var2 = this.method_1158(var2);
                }
                return var2;
            case 101:
                var2 += 4;
        }
        return var2;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        var1.append('@');
        var1.append(this.field_867);
        if (this.field_868 != null) {
            var1.append('(');
            var1.append("\n\t");
            int var2 = 0;
            for (int var3 = this.field_868.length; var2 < var3; ++var2) {
                if (var2 > 0) {
                    var1.append(",\n\t");
                }
                var1.append(this.field_868[var2]);
            }
            var1.append(')');
        }
        return var1.toString();
    }

    // $FF: renamed from: <clinit> () void
    static {
        field_871 = new Object[0];
    }
}
