package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.lookup.class_32;
import org.eclipse.jdt.internal.compiler.lookup.class_321;
import org.eclipse.jdt.internal.compiler.lookup.class_34;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.class_43;
import org.eclipse.jdt.internal.compiler.lookup.class_45;
import org.eclipse.jdt.internal.compiler.lookup.class_49;
import org.eclipse.jdt.internal.compiler.lookup.class_80;
import org.eclipse.jdt.internal.compiler.lookup.class_83;

public class class_46 extends class_43 {

    public class_34 field_220;

    public int field_221;

    public class_40 field_222;

    public class_43 field_223;

    public class_43[] field_224;

    public char[] field_225;

    public class_46(char[] var1, class_34 var2, int var3) {
        this.field_198 = var1;
        this.field_220 = var2;
        this.field_221 = var3;
        this.field_199 = 1073741825;
        this.field_178 |= 536870912L;
    }

    public int method_98() {
        return 4100;
    }

    public int method_255(class_32 var1, class_40 var2) {
        if (var2 != class_40.field_187 && var2 != this) {
            boolean var3 = var1 != null;
            if (!(var2 instanceof class_43) && !var2.method_147()) {
                return 2;
            } else if (this.field_223 == null) {
                return 0;
            } else {
                class_40 var8;
                if (var2.method_98() != 516) {
                    boolean var14 = false;
                    if (this.field_223.field_177 != 1) {
                        Object var15 = var3 ? class_83.method_571(var1, this.field_223) : this.field_223;
                        if (var15 != var2) {
                            if (!var2.method_152((class_40)var15)) {
                                return 2;
                            }
                            class_40 var18 = var2.method_140((class_40)var15);
                            if (var18 != null && var18.method_166() && ((class_40)var15).method_149()) {
                                var14 = true;
                            }
                        }
                    }
                    int var16 = 0;
                    for (int var17 = this.field_224.length; var16 < var17; ++var16) {
                        Object var19 = var3 ? class_83.method_571(var1, this.field_224[var16]) : this.field_224[var16];
                        if (var19 != var2) {
                            if (!var2.method_152((class_40)var19)) {
                                return 2;
                            }
                            var8 = var2.method_140((class_40)var19);
                            if (var8 != null && var8.method_166() && ((class_40)var19).method_149()) {
                                var14 = true;
                            }
                        }
                    }
                    return var14 ? 1 : 0;
                } else {
                    class_45 var4 = (class_45)var2;
                    switch (var4.field_215) {
                        case 1:
                            class_40 var5 = var4.field_212;
                            if (var5 == this) {
                                return 0;
                            } else {
                                class_43 var6 = var3 ? (class_43)class_83.method_571(var1, this.field_223) : this.field_223;
                                boolean var7 = var5.method_147();
                                if (!var5.method_157() && var6.field_177 != 1) {
                                    if (var7) {
                                        if (!var5.method_152(var6)) {
                                            return 2;
                                        }
                                    } else {
                                        var8 = var5.method_140(var6);
                                        if (var8 != null) {
                                            if (var6.method_164(var8)) {
                                                return 2;
                                            }
                                        } else {
                                            var8 = var6.method_140(var5);
                                            if (var8 != null) {
                                                if (var8.method_164(var5)) {
                                                    return 2;
                                                }
                                            } else if (!var5.method_169() && !var6.method_169()) {
                                                return 2;
                                            }
                                        }
                                    }
                                }
                                class_43[] var20 = var3 ? class_83.method_570(var1, this.field_224) : this.field_224;
                                int var9 = var20.length;
                                boolean var10 = var7 || ((class_43)var5).method_221();
                                for (int var11 = 0; var11 < var9; ++var11) {
                                    class_43 var12 = var20[var11];
                                    if (var7) {
                                        if (!var5.method_152(var12)) {
                                            return 2;
                                        }
                                    } else {
                                        class_40 var13 = var5.method_140(var12);
                                        if (var13 != null) {
                                            if (var12.method_164(var13)) {
                                                return 2;
                                            }
                                        } else if (var10) {
                                            return 2;
                                        }
                                    }
                                }
                            }
                        case 0:
                        default:
                            return 0;
                        case 2:
                            return this.method_255(var1, var4.field_212);
                    }
                }
            }
        } else {
            return 0;
        }
    }

    public boolean method_129() {
        return false;
    }

    public void method_133(class_83 var1, class_40 var2, class_321 var3, int var4) {
        if (this.field_220 == var3.field_1827) {
            switch (var2.method_98()) {
                case 132:
                    if (var2 == class_40.field_187) {
                        return;
                    } else {
                        class_40 var5 = var1.method_586().method_486(var2);
                        if (var5 == var2) {
                            return;
                        } else {
                            var2 = var5;
                        }
                    }
                case 516:
                    return;
                default:
                    byte var6;
                    switch (var4) {
                        case 0:
                            var6 = 0;
                            break;
                        case 1:
                            var6 = 2;
                            break;
                        default:
                            var6 = 1;
                    }
                    var3.method_3206(this, var2, var6);
            }
        }
    }

    public char[] method_134() {
        return this.field_222 != null ? this.field_222.method_134() : this.field_223.method_134();
    }

    public String method_135() {
        return new String(this.field_198);
    }

    public class_40 method_138() {
        return (class_40)(this.field_222 != null ? this.field_222.method_138() : this.field_223);
    }

    public char[] method_256() {
        StringBuffer var1 = new StringBuffer(10);
        var1.append(this.field_198).append(':');
        int var2 = this.field_224 == null ? 0 : this.field_224.length;
        if ((var2 == 0 || this.field_222 == this.field_223) && this.field_223 != null) {
            var1.append(this.field_223.method_142());
        }
        int var3;
        for (var3 = 0; var3 < var2; ++var3) {
            var1.append(':').append(this.field_224[var3].method_142());
        }
        var3 = var1.length();
        char[] var4 = new char[var3];
        var1.getChars(0, var3, var4, 0);
        return var4;
    }

    public char[] method_142() {
        return this.field_225 != null ? this.field_225 : (this.field_225 = CharOperation.method_1359('T', this.field_198, ';'));
    }

    public int method_257() {
        return this.field_222 == null ? 0 : (this.field_222 == this.field_223 ? this.field_224.length + 1 : this.field_224.length);
    }

    public boolean method_258(class_40 var1) {
        if (this.field_223.method_138() == var1) {
            return true;
        } else {
            int var2 = 0;
            for (int var3 = this.field_224.length; var2 < var3; ++var2) {
                if (this.field_224[var2].method_138() == var1) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean method_259(class_46 var1, class_32 var2) {
        if (this == var1) {
            return true;
        } else {
            int var3 = this.field_224.length;
            if (var3 != var1.field_224.length) {
                return false;
            } else if (this.field_223 != class_83.method_571(var2, var1.field_223)) {
                return false;
            } else {
                int var4 = 0;
                label35:
                while (var4 < var3) {
                    class_40 var5 = class_83.method_571(var2, var1.field_224[var4]);
                    for (int var6 = 0; var6 < var3; ++var6) {
                        if (var5 == this.field_224[var6]) {
                            ++var4;
                            continue label35;
                        }
                    }
                    return false;
                }
                return true;
            }
        }
    }

    public boolean method_169() {
        return true;
    }

    public char[] method_103() {
        return this.field_198;
    }

    class_43 method_260(class_80 var1) {
        if ((this.field_199 & 33554432) == 0) {
            return this;
        } else {
            class_43 var2 = this.field_223;
            class_43 var3 = null;
            if (this.field_223 != null) {
                this.field_223 = class_49.method_267(this.field_223, var1, true);
            }
            class_43[] var4 = this.field_224;
            int var5;
            if ((var5 = var4.length) != 0) {
                var3 = var4[0];
                int var6 = var5;
                while (true) {
                    --var6;
                    if (var6 < 0) {
                        break;
                    }
                    var4[var6] = class_49.method_267(var4[var6], var1, true);
                }
            }
            if (this.field_222 != null) {
                if (this.field_222 == var2) {
                    this.field_222 = this.field_223;
                } else if (this.field_222 == var3) {
                    this.field_222 = var4[0];
                }
            }
            this.field_199 &= -33554433;
            return this;
        }
    }

    public char[] method_104() {
        return this.method_103();
    }

    public class_43 method_240() {
        return this.field_223;
    }

    public class_43[] method_241() {
        return this.field_224;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer(10);
        var1.append('<').append(this.field_198);
        if (this.field_223 != null && this.field_222 == this.field_223) {
            var1.append(" extends ").append(this.field_223.method_135());
        }
        if (this.field_224 != null && this.field_224 != class_34.field_155) {
            if (this.field_222 != this.field_223) {
                var1.append(" extends ");
            }
            int var2 = 0;
            for (int var3 = this.field_224.length; var2 < var3; ++var2) {
                if (var2 > 0 || this.field_222 == this.field_223) {
                    var1.append(" & ");
                }
                var1.append(this.field_224[var2].method_135());
            }
        }
        var1.append('>');
        return var1.toString();
    }

    public class_40 method_261() {
        return (class_40)(this.field_222 != null ? this.field_222 : this.field_223);
    }
}
