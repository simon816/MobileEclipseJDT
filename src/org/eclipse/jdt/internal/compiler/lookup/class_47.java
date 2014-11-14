package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.lookup.class_17;
import org.eclipse.jdt.internal.compiler.lookup.class_34;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.class_43;
import org.eclipse.jdt.internal.compiler.lookup.class_45;
import org.eclipse.jdt.internal.compiler.lookup.class_46;
import org.eclipse.jdt.internal.compiler.lookup.class_52;
import org.eclipse.jdt.internal.compiler.lookup.class_83;

public class class_47 extends class_46 {

    public class_40 field_226;

    public class_45 field_227;

    public int field_228;

    public class_43 field_229;

    public int field_230;

    public class_47(class_45 var1, class_43 var2, int var3, int var4) {
        super(class_17.field_57, (class_34)null, 0);
        this.field_227 = var1;
        this.field_199 = 1073741825;
        this.field_200 = var1.field_200;
        this.field_229 = var2;
        this.field_230 = var3;
        this.field_228 = var4;
    }

    public String method_135() {
        if (this.field_227 != null) {
            StringBuffer var1 = new StringBuffer(10);
            var1.append(class_17.field_57).append(this.field_228).append(class_17.field_58).append(this.field_227.method_135());
            return var1.toString();
        } else {
            return super.method_135();
        }
    }

    public char[] method_142() {
        if (this.field_225 == null) {
            this.field_225 = CharOperation.method_1355(class_17.field_59, this.field_227.method_142());
        }
        return this.field_225;
    }

    public void method_263(class_83 var1, class_52 var2) {
        class_46 var3 = this.field_227.method_253();
        if (var3 == null) {
            class_40 var11 = this.field_227.field_212;
            switch (this.field_227.field_215) {
                case 0:
                    this.field_223 = var1.method_609();
                    this.field_224 = class_34.field_155;
                    this.field_178 &= -536870913L;
                    break;
                case 1:
                    class_40 var12 = var11.method_130(var1, this.field_230);
                    if (var11.method_157()) {
                        this.field_223 = var1.method_609();
                        this.field_224 = new class_43[] {(class_43)var12};
                    } else {
                        if (!var12.method_147() && var12 != this) {
                            this.field_223 = (class_43)var12;
                        } else {
                            this.field_223 = var1.method_609();
                        }
                        this.field_224 = class_34.field_155;
                    }
                    this.field_222 = var12;
                    if ((var12.field_178 & 536870912L) == 0L) {
                        this.field_178 &= -536870913L;
                    }
                    break;
                case 2:
                    this.field_223 = var1.method_609();
                    this.field_224 = class_34.field_155;
                    this.field_226 = this.field_227.field_212;
                    if ((var11.field_178 & 536870912L) == 0L) {
                        this.field_178 &= -536870913L;
                    }
            }
        } else {
            class_43 var4 = var3.field_223;
            class_43 var5 = (class_43)class_83.method_571(var2, var4);
            if (var5 == this) {
                var5 = var4;
            }
            class_43[] var6 = var3.method_241();
            class_43[] var7 = class_83.method_570(var2, var6);
            if (var7 != var6) {
                int var8 = 0;
                for (int var9 = var7.length; var8 < var9; ++var8) {
                    if (var7[var8] == this) {
                        var7[var8] = var6[var8];
                    }
                }
            }
            class_40 var13 = this.field_227.field_212;
            switch (this.field_227.field_215) {
                case 0:
                    this.field_223 = var5;
                    this.field_224 = var7;
                    this.field_178 &= -536870913L;
                    break;
                case 1:
                    class_40 var14 = var13.method_130(var1, this.field_230);
                    if (var13.method_157()) {
                        this.field_223 = var5;
                        if (var7 == class_34.field_155) {
                            this.field_224 = new class_43[] {(class_43)var14};
                        } else {
                            int var10 = var7.length;
                            System.arraycopy(var7, 0, var7 = new class_43[var10 + 1], 1, var10);
                            var7[0] = (class_43)var14;
                            this.field_224 = class_83.method_568(var7);
                        }
                    } else {
                        if (!var14.method_147() && var14 != this) {
                            this.field_223 = (class_43)var14;
                            if (this.field_223.method_228(var5)) {
                                this.field_223 = var5;
                            }
                        } else {
                            this.field_223 = var5;
                        }
                        this.field_224 = var7;
                    }
                    this.field_222 = var14;
                    if ((var14.field_178 & 536870912L) == 0L) {
                        this.field_178 &= -536870913L;
                    }
                    break;
                case 2:
                    this.field_223 = var5;
                    if (var3.field_222 == var5 || var13 == var5) {
                        this.field_222 = var5;
                    }
                    this.field_224 = var7;
                    this.field_226 = var13;
                    if ((var13.field_178 & 536870912L) == 0L) {
                        this.field_178 &= -536870913L;
                    }
            }
        }
    }

    public boolean method_150() {
        return true;
    }

    public boolean method_154(class_40 var1) {
        if (this == var1) {
            return true;
        } else if (var1 == null) {
            return false;
        } else if (this.field_222 != null && this.field_222.method_147() && this.field_222.method_152(var1)) {
            return true;
        } else {
            switch (var1.method_98()) {
                case 516:
                case 8196:
                    return ((class_45)var1).method_250(this);
                default:
                    return false;
            }
        }
    }

    public char[] method_103() {
        if (this.field_227 != null) {
            StringBuffer var1 = new StringBuffer(10);
            var1.append(class_17.field_57).append(this.field_228).append(class_17.field_58).append(this.field_227.method_103());
            int var2 = var1.length();
            char[] var3 = new char[var2];
            var1.getChars(0, var2, var3, 0);
            return var3;
        } else {
            return super.method_103();
        }
    }

    public char[] method_104() {
        if (this.field_227 != null) {
            StringBuffer var1 = new StringBuffer(10);
            var1.append(class_17.field_57).append(this.field_228).append(class_17.field_58).append(this.field_227.method_104());
            int var2 = var1.length();
            char[] var3 = new char[var2];
            var1.getChars(0, var2, var3, 0);
            return var3;
        } else {
            return super.method_104();
        }
    }

    public String toString() {
        if (this.field_227 != null) {
            StringBuffer var1 = new StringBuffer(10);
            var1.append(class_17.field_57).append(this.field_228).append(class_17.field_58).append(this.field_227);
            return var1.toString();
        } else {
            return super.toString();
        }
    }
}
