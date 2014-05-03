package e;

import a.class_331;
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
import e.class_188;
import e.class_196;
import f.class_226;
import g.class_11;
import i.class_5;
import k.class_27;
import k.class_29;

// $FF: renamed from: e.j
public class class_187 extends class_186 implements class_11, class_27 {

    // $FF: renamed from: a int
    protected int field_808;
    // $FF: renamed from: c int
    protected int field_809;
    // $FF: renamed from: a a.k
    protected class_331 field_810;
    // $FF: renamed from: a char[]
    protected char[] field_811;
    // $FF: renamed from: b char[]
    protected char[] field_812;
    // $FF: renamed from: c char[]
    protected char[] field_813;
    // $FF: renamed from: d int
    protected int field_814;
    // $FF: renamed from: a long
    protected long field_815;
    // $FF: renamed from: a java.lang.Object
    protected Object field_816;

    // $FF: renamed from: a (byte[], int[], int) e.j
    public static class_187 method_1107(byte[] var0, int[] var1, int var2) {
        class_187 var10000 = new class_187(var0, var1, var2);
        class_187 var3 = var10000;
        class_196[] var4 = var3.method_1110();
        if (var4 == null) {
            return var3;
        } else {
            class_188 var5 = new class_188(var3, var4);
            return var5;
        }
    }

    // $FF: renamed from: <init> (byte[], int[], int) void
    protected class_187(byte[] var1, int[] var2, int var3) {
        super(var1, var2, var3);
        this.field_808 = -1;
        this.field_814 = -1;
    }

    // $FF: renamed from: a (int, boolean) e.b[]
    private class_196[] method_1108(int var1, boolean var2) {
        int var3 = this.method_1104(var1 + 6);
        if (var3 > 0) {
            int var4 = var1 + 8;
            class_196[] var5 = null;
            int var6 = 0;
            for (int var7 = 0; var7 < var3; ++var7) {
                class_196 var10000 = new class_196(this.field_805, this.field_806, var4 + this.field_807, var2, false);
                class_196 var8 = var10000;
                var4 += var8.field_870;
                long var9 = var8.field_869;
                if (var9 != 0L) {
                    this.field_815 |= var9;
                } else {
                    if (var5 == null) {
                        var5 = new class_196[var3 - var7];
                    }
                    var5[var6++] = var8;
                }
            }
            if (var5 != null) {
                if (var6 != var5.length) {
                    System.arraycopy(var5, 0, var5 = new class_196[var6], 0, var6);
                }
                return var5;
            }
        }
        return null;
    }

    // $FF: renamed from: a (java.lang.Object) int
    public int method_28(Object var1) {
        return (new String(this.method_75())).compareTo(new String(((class_187)var1).method_75()));
    }

    public boolean equals(Object var1) {
        return !(var1 instanceof class_187) ? false : class_233.method_1364(this.method_75(), ((class_187)var1).method_75());
    }

    public int hashCode() {
        return class_233.method_1369(this.method_75());
    }

    // $FF: renamed from: a () a.k
    public class_331 method_79() {
        if (this.field_810 == null) {
            this.method_1111();
        }
        return this.field_810;
    }

    // $FF: renamed from: a () char[]
    public char[] method_74() {
        if (this.field_814 != -1) {
            if (this.field_813 == null) {
                this.field_813 = this.method_1106(this.field_814 + 3, this.method_1104(this.field_814 + 1));
            }
            return this.field_813;
        } else {
            return null;
        }
    }

    // $FF: renamed from: a () int
    public int method_69() {
        if (this.field_808 == -1) {
            this.field_808 = this.method_1104(0);
            this.method_1112();
        }
        return this.field_808;
    }

    // $FF: renamed from: b () char[]
    public char[] method_75() {
        if (this.field_812 == null) {
            int var1 = this.field_806[this.method_1104(2)] - this.field_807;
            this.field_812 = this.method_1106(var1 + 3, this.method_1104(var1 + 1));
        }
        return this.field_812;
    }

    // $FF: renamed from: a () long
    public long method_78() {
        return this.field_815;
    }

    // $FF: renamed from: c () char[]
    public char[] method_77() {
        if (this.field_811 == null) {
            int var1 = this.field_806[this.method_1104(4)] - this.field_807;
            this.field_811 = this.method_1106(var1 + 3, this.method_1104(var1 + 1));
        }
        return this.field_811;
    }

    // $FF: renamed from: a () k.e[]
    public class_29[] method_71() {
        return null;
    }

    // $FF: renamed from: a () void
    protected void method_1109() {
        this.method_69();
        this.method_75();
        this.method_79();
        this.method_77();
        this.method_74();
        this.method_1102();
    }

    // $FF: renamed from: a () e.b[]
    private class_196[] method_1110() {
        int var1 = this.method_1104(6);
        int var2 = 8;
        class_196[] var3 = null;
        for (int var4 = 0; var4 < var1; ++var4) {
            int var5 = this.field_806[this.method_1104(var2)] - this.field_807;
            char[] var6 = this.method_1106(var5 + 3, this.method_1104(var5 + 1));
            if (var6.length > 0) {
                switch (var6[0]) {
                    case 82:
                        class_196[] var7 = null;
                        if (class_233.method_1364(var6, class_5.field_18)) {
                            var7 = this.method_1108(var2, true);
                        } else if (class_233.method_1364(var6, class_5.field_17)) {
                            var7 = this.method_1108(var2, false);
                        }
                        if (var7 != null) {
                            if (var3 == null) {
                                var3 = var7;
                            } else {
                                int var8 = var3.length;
                                class_196[] var9 = new class_196[var8 + var7.length];
                                System.arraycopy(var3, 0, var9, 0, var8);
                                System.arraycopy(var7, 0, var9, var8, var7.length);
                                var3 = var9;
                            }
                        }
                        break;
                    case 83:
                        if (class_233.method_1364(class_5.field_13, var6)) {
                            this.field_814 = this.field_806[this.method_1104(var2 + 6)] - this.field_807;
                        }
                }
            }
            var2 = (int)((long)var2 + 6L + this.method_1105(var2 + 2));
        }
        this.field_809 = var2;
        return var3;
    }

    // $FF: renamed from: c () void
    private void method_1111() {
        int var1 = this.method_1104(6);
        int var2 = 8;
        boolean var3 = false;
        for (int var4 = 0; var4 < var1; ++var4) {
            int var5 = this.field_806[this.method_1104(var2)] - this.field_807;
            char[] var6 = this.method_1106(var5 + 3, this.method_1104(var5 + 1));
            if (class_233.method_1364(var6, class_5.field_5)) {
                var3 = true;
                int var7 = this.field_806[this.method_1104(var2 + 6)] - this.field_807;
                label35:
                switch (this.method_1103(var7)) {
                    case 3:
                        char[] var8 = this.method_77();
                        if (var8.length == 1) {
                            switch (var8[0]) {
                                case 66:
                                    this.field_810 = class_339.method_3305((byte)this.method_1100(var7 + 1));
                                    break label35;
                                case 67:
                                    this.field_810 = class_338.method_3303((char)this.method_1100(var7 + 1));
                                    break label35;
                                case 73:
                                    this.field_810 = class_337.method_3301(this.method_1100(var7 + 1));
                                    break label35;
                                case 83:
                                    this.field_810 = class_334.method_3295((short)this.method_1100(var7 + 1));
                                    break label35;
                                case 90:
                                    this.field_810 = class_340.method_3307(this.method_1100(var7 + 1) == 1);
                                    break label35;
                                default:
                                    this.field_810 = class_331.field_1896;
                            }
                        } else {
                            this.field_810 = class_331.field_1896;
                        }
                        break;
                    case 4:
                        this.field_810 = class_333.method_3293(this.method_1099(var7 + 1));
                        break;
                    case 5:
                        this.field_810 = class_335.method_3297(this.method_1101(var7 + 1));
                        break;
                    case 6:
                        this.field_810 = class_332.method_3291(this.method_1098(var7 + 1));
                    case 7:
                    default:
                        break;
                    case 8:
                        var5 = this.field_806[this.method_1104(var7 + 1)] - this.field_807;
                        this.field_810 = class_336.method_3299(String.valueOf(this.method_1106(var5 + 3, this.method_1104(var5 + 1))));
                }
            }
            var2 = (int)((long)var2 + 6L + this.method_1105(var2 + 2));
        }
        if (!var3) {
            this.field_810 = class_331.field_1896;
        }
    }

    // $FF: renamed from: d () void
    private void method_1112() {
        int var1 = this.method_1104(6);
        int var2 = 8;
        for (int var3 = 0; var3 < var1; ++var3) {
            int var4 = this.field_806[this.method_1104(var2)] - this.field_807;
            char[] var5 = this.method_1106(var4 + 3, this.method_1104(var4 + 1));
            if (var5.length != 0) {
                switch (var5[0]) {
                    case 68:
                        if (class_233.method_1364(var5, class_5.field_12)) {
                            this.field_808 |= 1048576;
                        }
                        break;
                    case 83:
                        if (class_233.method_1364(var5, class_5.field_4)) {
                            this.field_808 |= 4096;
                        }
                }
            }
            var2 = (int)((long)var2 + 6L + this.method_1105(var2 + 2));
        }
    }

    // $FF: renamed from: b () int
    public int method_1113() {
        return this.field_809;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer(this.getClass().getName());
        this.method_1114(var1);
        return var1.toString();
    }

    // $FF: renamed from: a (java.lang.StringBuffer) void
    protected void method_1114(StringBuffer var1) {
        int var2 = this.method_69();
        var1.append('{').append(((var2 & 1048576) != 0 ? "deprecated " : class_226.field_982) + ((var2 & 1) == 1 ? "public " : class_226.field_982) + ((var2 & 2) == 2 ? "private " : class_226.field_982) + ((var2 & 4) == 4 ? "protected " : class_226.field_982) + ((var2 & 8) == 8 ? "static " : class_226.field_982) + ((var2 & 16) == 16 ? "final " : class_226.field_982) + ((var2 & 64) == 64 ? "volatile " : class_226.field_982) + ((var2 & 128) == 128 ? "transient " : class_226.field_982)).append(this.method_77()).append(' ').append(this.method_75()).append(' ').append(this.method_79()).append('}').toString();
    }
}
