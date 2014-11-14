package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.class_264;
import org.eclipse.jdt.internal.compiler.ast.class_146;
import org.eclipse.jdt.internal.compiler.ast.class_149;
import org.eclipse.jdt.internal.compiler.impl.class_331;
import org.eclipse.jdt.internal.compiler.lookup.class_34;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.class_43;
import org.eclipse.jdt.internal.compiler.lookup.class_46;
import org.eclipse.jdt.internal.compiler.lookup.class_52;
import org.eclipse.jdt.internal.compiler.lookup.class_83;
import org.eclipse.jdt.internal.compiler.lookup.class_84;
import org.eclipse.jdt.internal.compiler.lookup.class_86;

public class class_150 extends class_149 {

    public class_146[] field_731;

    public class_150(char[] var1, class_146[] var2, int var3, long var4) {
        super(var1, var3, var4);
        this.field_730 = this.field_445;
        this.field_731 = var2;
    }

    public void method_1007(class_83 var1) {
        if (this.field_675 != null) {
            if (this.field_675.method_173() instanceof class_52) {
                class_52 var2 = (class_52)this.field_675.method_173();
                class_43 var3 = var2.method_286();
                class_46[] var4 = var3.method_181();
                class_40[] var5 = var2.field_243;
                if (var5 != null && var4 != null) {
                    var2.method_284(var1, this.field_731);
                }
            }
        }
    }

    public class_146 method_1008(int var1) {
        class_150 var10000 = new class_150(this.field_726, this.field_731, var1, ((long)this.field_444 << 32) + (long)this.field_445);
        return var10000;
    }

    protected class_40 method_1011(class_83 var1) {
        return null;
    }

    private class_40 method_1028(class_83 var1, class_43 var2, boolean var3) {
        this.field_672 = class_331.field_1896;
        if ((this.field_446 & 262144) != 0 && this.field_675 != null) {
            if (this.field_675.method_101()) {
                return this.field_675;
            } else {
                switch (this.field_675.method_102()) {
                    case 1:
                    case 2:
                    case 5:
                        class_40 var15 = this.field_675.method_131();
                        return var15;
                    case 3:
                    case 4:
                    default:
                        return null;
                }
            }
        } else {
            boolean var4 = false;
            this.field_446 |= 262144;
            Object var5;
            int var8;
            if (var2 == null) {
                this.field_675 = var1.method_616(this.field_726);
                if (this.field_675.method_101()) {
                    var5 = (class_43)this.field_675;
                } else {
                    var4 = true;
                    this.method_1015(var1);
                    switch (this.field_675.method_102()) {
                        case 1:
                        case 2:
                        case 5:
                            class_40 var6 = this.field_675.method_131();
                            if (var6 instanceof class_43) {
                                var5 = (class_43)var6;
                                break;
                            }
                        case 3:
                        case 4:
                        default:
                            boolean var7 = var1.field_373 == 3;
                            var8 = this.field_731.length;
                            for (int var9 = 0; var9 < var8; ++var9) {
                                class_146 var10 = this.field_731[var9];
                                if (var7) {
                                    var10.method_1018((class_84)var1);
                                } else {
                                    var10.method_1017((class_86)var1, var3);
                                }
                            }
                            return null;
                    }
                }
                var2 = ((class_43)var5).method_137();
                if (var2 != null) {
                    var2 = ((class_43)var5).method_226() ? (class_43)var1.method_586().method_490(var2, false) : var1.method_586().method_489(var2);
                    var5 = var1.method_586().method_500((class_43)((class_43)var5).method_138(), (class_40[])null, var2);
                }
            } else {
                this.field_675 = (class_40)(var5 = var1.method_613(this.field_726, var2));
                if (!this.field_675.method_101()) {
                    var4 = true;
                    var1.method_644().method_1626(this, (class_40)var5, var2);
                    return null;
                }
                if (this.method_756((class_40)var5, var1)) {
                    var1.method_644().method_1516((class_40)var5, this);
                }
            }
            boolean var16 = var1.field_373 == 3;
            class_146 var17 = null;
            if (var16) {
                var17 = ((class_84)var1).field_377;
                ((class_84)var1).field_377 = null;
            }
            var8 = this.field_731.length;
            class_40[] var18 = new class_40[var8];
            boolean var19 = false;
            class_43 var11 = (class_43)((class_43)var5).method_138();
            for (int var12 = 0; var12 < var8; ++var12) {
                class_146 var13 = this.field_731[var12];
                class_40 var14 = var16 ? var13.method_1020((class_84)var1, var11, var12) : var13.method_1019((class_86)var1, var11, var12);
                if (var14 == null) {
                    var19 = true;
                } else {
                    var18[var12] = var14;
                }
            }
            if (var19) {
                return null;
            } else {
                if (var16) {
                    ((class_84)var1).field_377 = var17;
                    if (((class_84)var1).method_668(var11, this)) {
                        return null;
                    }
                }
                class_46[] var20 = var11.method_181();
                Object var24;
                if (var20 == class_34.field_157) {
                    boolean var23 = var1.method_577().field_1928 >= 3211264L;
                    if ((var11.field_178 & 128L) == 0L && var23) {
                        this.field_675 = (class_40)var5;
                        var1.method_644().method_1702(0, this, (class_40)var5, var18);
                        return null;
                    }
                    if (!var23) {
                        var24 = var5;
                        if (this.field_729 > 0) {
                            if (this.field_729 > 255) {
                                var1.method_644().method_1768(this);
                            }
                            var24 = var1.method_580((class_40)var5, this.field_729);
                        }
                        if (var4) {
                            return (class_40)var24;
                        }
                        return (class_40)(this.field_675 = (class_40)var24);
                    }
                } else {
                    if (var8 != var20.length) {
                        var1.method_644().method_1609(this, (class_40)var5, var18);
                        return null;
                    }
                    if (!((class_43)var5).method_226()) {
                        class_43 var21 = ((class_43)var5).method_137();
                        if (var21 != null && var21.method_166()) {
                            var1.method_644().method_1741(this, var1.method_586().method_501(var11, var21), var18);
                            return null;
                        }
                    }
                }
                class_52 var22 = var1.method_586().method_500(var11, var18, var2);
                if (var3) {
                    var22.method_284(var1, this.field_731);
                }
                if (this.method_756(var22, var1)) {
                    this.method_1014(var22, var1);
                }
                var24 = var22;
                if (this.field_729 > 0) {
                    if (this.field_729 > 255) {
                        var1.method_644().method_1768(this);
                    }
                    var24 = var1.method_580(var22, this.field_729);
                }
                if (var4) {
                    return (class_40)var24;
                } else {
                    return (class_40)(this.field_675 = (class_40)var24);
                }
            }
        }
    }

    public StringBuffer method_924(int var1, StringBuffer var2) {
        var2.append(this.field_726);
        var2.append("<");
        int var3 = this.field_731.length - 1;
        int var4;
        for (var4 = 0; var4 < var3; ++var4) {
            this.field_731[var4].method_757(0, var2);
            var2.append(", ");
        }
        this.field_731[var3].method_757(0, var2);
        var2.append(">");
        if ((this.field_446 & 16384) != 0) {
            for (var4 = 0; var4 < this.field_729 - 1; ++var4) {
                var2.append("[]");
            }
            var2.append("...");
        } else {
            for (var4 = 0; var4 < this.field_729; ++var4) {
                var2.append("[]");
            }
        }
        return var2;
    }

    public class_40 method_1017(class_86 var1, boolean var2) {
        return this.method_1028(var1, (class_43)null, var2);
    }

    public class_40 method_1018(class_84 var1) {
        return this.method_1028(var1, (class_43)null, false);
    }

    public class_40 method_1023(class_86 var1, class_43 var2) {
        return this.method_1028(var1, var2, true);
    }

    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2043(this, var2)) {
            int var3 = 0;
            for (int var4 = this.field_731.length; var3 < var4; ++var3) {
                this.field_731[var3].method_763(var1, var2);
            }
        }
        var1.method_1958(this, var2);
    }

    public void method_1021(class_264 var1, class_84 var2) {
        if (var1.method_2044(this, var2)) {
            int var3 = 0;
            for (int var4 = this.field_731.length; var3 < var4; ++var3) {
                this.field_731[var3].method_1021(var1, var2);
            }
        }
        var1.method_1959(this, var2);
    }
}
