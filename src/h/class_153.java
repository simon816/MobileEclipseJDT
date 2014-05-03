package h;

import a.class_331;
import c.class_264;
import h.class_146;
import h.class_152;
import m.class_34;
import m.class_38;
import m.class_40;
import m.class_43;
import m.class_46;
import m.class_52;
import m.class_83;
import m.class_84;
import m.class_86;

// $FF: renamed from: h.al
public class class_153 extends class_152 {

    // $FF: renamed from: a h.bo[][]
    public class_146[][] field_735;

    // $FF: renamed from: <init> (char[][], h.bo[][], int, long[]) void
    public class_153(char[][] var1, class_146[][] var2, int var3, long[] var4) {
        super(var1, var3, var4);
        this.field_735 = var2;
    }

    // $FF: renamed from: a (m.bb) void
    public void method_1007(class_83 var1) {
        if (this.field_675 != null) {
            this.method_1033((class_43)this.field_675.method_173(), var1, this.field_735.length - 1);
        }
    }

    // $FF: renamed from: a (m.as, m.bb, int) void
    public void method_1033(class_43 var1, class_83 var2, int var3) {
        if (var3 > 0 && var1.method_137() != null) {
            this.method_1033(var1.method_137(), var2, var3 - 1);
        }
        if (var1.method_162()) {
            class_52 var4 = (class_52)var1;
            class_43 var5 = var4.method_286();
            class_46[] var6 = var5.method_181();
            class_40[] var7 = var4.field_243;
            if (var7 != null && var6 != null) {
                var4.method_284(var2, this.field_735[var3]);
            }
        }
    }

    // $FF: renamed from: a (int) h.bo
    public class_146 method_1008(int var1) {
        class_153 var10000 = new class_153(this.field_732, this.field_735, var1, this.field_733);
        return var10000;
    }

    // $FF: renamed from: b (m.bb) m.s
    protected class_40 method_1011(class_83 var1) {
        return null;
    }

    // $FF: renamed from: a (m.bb, boolean) m.s
    private class_40 method_1034(class_83 var1, boolean var2) {
        this.field_672 = class_331.field_1896;
        if ((this.field_446 & 262144) != 0 && this.field_675 != null && this.field_675 != null) {
            if (this.field_675.method_101()) {
                return this.field_675;
            } else {
                switch (this.field_675.method_102()) {
                    case 1:
                    case 2:
                    case 5:
                        class_40 var20 = this.field_675.method_131();
                        return var20;
                    case 3:
                    case 4:
                    default:
                        return null;
                }
            }
        } else {
            this.field_446 |= 262144;
            boolean var3 = var1.field_373 == 3;
            class_34 var4 = var1.method_615(this.field_732);
            int var8;
            int var9;
            if (var4 != null && !var4.method_101()) {
                this.field_675 = (class_43)var4;
                this.method_1015(var1);
                int var21 = 0;
                for (int var22 = this.field_732.length; var21 < var22; ++var21) {
                    class_146[] var24 = this.field_735[var21];
                    if (var24 != null) {
                        var8 = var24.length;
                        for (var9 = 0; var9 < var8; ++var9) {
                            class_146 var23 = var24[var9];
                            if (var3) {
                                var23.method_1018((class_84)var1);
                            } else {
                                var23.method_1017((class_86)var1, var2);
                            }
                        }
                    }
                }
                return null;
            } else {
                class_38 var5 = var4 == null ? null : (class_38)var4;
                boolean var6 = true;
                Object var7 = null;
                var8 = var5 == null ? 0 : var5.field_171.length;
                for (var9 = this.field_732.length; var8 < var9; ++var8) {
                    this.method_1030(var8, var1, var5);
                    class_146[] var11;
                    int var13;
                    if (!this.field_675.method_101()) {
                        this.method_1015(var1);
                        for (int var25 = var8; var25 < var9; ++var25) {
                            var11 = this.field_735[var25];
                            if (var11 != null) {
                                int var27 = var11.length;
                                for (var13 = 0; var13 < var27; ++var13) {
                                    class_146 var28 = var11[var13];
                                    if (var3) {
                                        var28.method_1018((class_84)var1);
                                    } else {
                                        var28.method_925((class_86)var1);
                                    }
                                }
                            }
                        }
                        return null;
                    }
                    class_43 var10 = (class_43)this.field_675;
                    if (var7 == null) {
                        var7 = var10.method_137();
                        if (var7 != null) {
                            var7 = var10.method_226() ? (class_43)var1.method_586().method_490((class_40)var7, false) : var1.method_586().method_489((class_43)var7);
                        }
                    }
                    if (var6 && var10.method_226() && var7 != null && (((class_43)var7).method_162() && ((class_52)var7).field_243 != null || ((class_43)var7).method_155())) {
                        var1.method_644().method_1759(this, var1.method_586().method_500((class_43)var10.method_138(), (class_40[])null, (class_43)var7));
                        var6 = false;
                    }
                    var11 = this.field_735[var8];
                    if (var11 != null) {
                        class_146 var12 = null;
                        if (var3) {
                            var12 = ((class_84)var1).field_377;
                            ((class_84)var1).field_377 = null;
                        }
                        var13 = var11.length;
                        class_40[] var14 = new class_40[var13];
                        boolean var15 = false;
                        class_43 var16 = (class_43)var10.method_138();
                        for (int var17 = 0; var17 < var13; ++var17) {
                            class_146 var18 = var11[var17];
                            class_40 var19 = var3 ? var18.method_1020((class_84)var1, var16, var17) : var18.method_1019((class_86)var1, var16, var17);
                            if (var19 == null) {
                                var15 = true;
                            } else {
                                var14[var17] = var19;
                            }
                        }
                        if (var15) {
                            return null;
                        }
                        if (var3) {
                            ((class_84)var1).field_377 = var12;
                            if (((class_84)var1).method_668(var16, this)) {
                                return null;
                            }
                        }
                        class_46[] var29 = var16.method_181();
                        if (var29 == class_34.field_157) {
                            if (var1.method_577().field_1928 >= 3211264L) {
                                var1.method_644().method_1702(var8, this, var10, var14);
                                return null;
                            }
                            this.field_675 = (class_40)(var7 != null && ((class_43)var7).method_162() ? var1.method_586().method_500(var16, (class_40[])null, (class_43)var7) : var10);
                            if (this.field_734 > 0) {
                                if (this.field_734 > 255) {
                                    var1.method_644().method_1768(this);
                                }
                                this.field_675 = var1.method_580(this.field_675, this.field_734);
                            }
                            return this.field_675;
                        }
                        if (var13 != var29.length) {
                            var1.method_644().method_1609(this, var10, var14);
                            return null;
                        }
                        if (var6 && !var10.method_226()) {
                            class_43 var31 = var10.method_137();
                            if (var31 != null && var31.method_166()) {
                                var1.method_644().method_1741(this, var1.method_586().method_501(var16, var31), var14);
                                var6 = false;
                            }
                        }
                        class_52 var30 = var1.method_586().method_500(var16, var14, (class_43)var7);
                        if (var2) {
                            var30.method_284(var1, var11);
                        }
                        var7 = var30;
                    } else {
                        class_43 var26 = (class_43)var10.method_138();
                        if (var3 && ((class_84)var1).method_668(var26, this)) {
                            return null;
                        }
                        if (var26.method_155()) {
                            if (var6 && var7 != null && ((class_43)var7).method_162()) {
                                var1.method_644().method_1722(this, var1.method_586().method_500(var26, (class_40[])null, (class_43)var7));
                                var6 = false;
                            }
                            var7 = var1.method_586().method_501(var26, (class_43)var7);
                        } else {
                            var7 = var7 != null && ((class_43)var7).method_162() ? var1.method_586().method_500(var26, (class_40[])null, (class_43)var7) : var10;
                        }
                    }
                    if (this.method_756((class_40)var7, var1)) {
                        this.method_1014((class_40)var7, var1);
                    }
                    this.field_675 = (class_40)var7;
                }
                if (this.field_734 > 0) {
                    if (this.field_734 > 255) {
                        var1.method_644().method_1768(this);
                    }
                    this.field_675 = var1.method_580(this.field_675, this.field_734);
                }
                return this.field_675;
            }
        }
    }

    // $FF: renamed from: c (int, java.lang.StringBuffer) java.lang.StringBuffer
    public StringBuffer method_924(int var1, StringBuffer var2) {
        int var3 = this.field_732.length;
        int var6;
        for (int var4 = 0; var4 < var3 - 1; ++var4) {
            var2.append(this.field_732[var4]);
            class_146[] var5 = this.field_735[var4];
            if (var5 != null) {
                var2.append('<');
                var6 = var5.length - 1;
                for (int var7 = 0; var7 < var6; ++var7) {
                    var5[var7].method_757(0, var2);
                    var2.append(", ");
                }
                var5[var6].method_757(0, var2);
                var2.append('>');
            }
            var2.append('.');
        }
        var2.append(this.field_732[var3 - 1]);
        class_146[] var8 = this.field_735[var3 - 1];
        int var9;
        if (var8 != null) {
            var2.append('<');
            var9 = var8.length - 1;
            for (var6 = 0; var6 < var9; ++var6) {
                var8[var6].method_757(0, var2);
                var2.append(", ");
            }
            var8[var9].method_757(0, var2);
            var2.append('>');
        }
        if ((this.field_446 & 16384) != 0) {
            for (var9 = 0; var9 < this.field_734 - 1; ++var9) {
                var2.append("[]");
            }
            var2.append("...");
        } else {
            for (var9 = 0; var9 < this.field_734; ++var9) {
                var2.append("[]");
            }
        }
        return var2;
    }

    // $FF: renamed from: a (m.v, boolean) m.s
    public class_40 method_1017(class_86 var1, boolean var2) {
        return this.method_1034(var1, var2);
    }

    // $FF: renamed from: a (m.f) m.s
    public class_40 method_1018(class_84 var1) {
        return this.method_1034(var1, false);
    }

    // $FF: renamed from: a (c.j, m.v) void
    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2041(this, var2)) {
            int var3 = 0;
            for (int var4 = this.field_735.length; var3 < var4; ++var3) {
                if (this.field_735[var3] != null) {
                    int var5 = 0;
                    for (int var6 = this.field_735[var3].length; var5 < var6; ++var5) {
                        this.field_735[var3][var5].method_763(var1, var2);
                    }
                }
            }
        }
        var1.method_1956(this, var2);
    }

    // $FF: renamed from: a (c.j, m.f) void
    public void method_1021(class_264 var1, class_84 var2) {
        if (var1.method_2042(this, var2)) {
            int var3 = 0;
            for (int var4 = this.field_735.length; var3 < var4; ++var3) {
                if (this.field_735[var3] != null) {
                    int var5 = 0;
                    for (int var6 = this.field_735[var3].length; var5 < var6; ++var5) {
                        this.field_735[var3][var5].method_1021(var1, var2);
                    }
                }
            }
        }
        var1.method_1957(this, var2);
    }
}
