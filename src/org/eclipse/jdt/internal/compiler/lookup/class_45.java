package org.eclipse.jdt.internal.compiler.lookup;

import java.util.List;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.lookup.class_17;
import org.eclipse.jdt.internal.compiler.lookup.class_321;
import org.eclipse.jdt.internal.compiler.lookup.class_34;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.class_43;
import org.eclipse.jdt.internal.compiler.lookup.class_44;
import org.eclipse.jdt.internal.compiler.lookup.class_46;
import org.eclipse.jdt.internal.compiler.lookup.class_47;
import org.eclipse.jdt.internal.compiler.lookup.class_49;
import org.eclipse.jdt.internal.compiler.lookup.class_52;
import org.eclipse.jdt.internal.compiler.lookup.class_80;
import org.eclipse.jdt.internal.compiler.lookup.class_83;

public class class_45 extends class_43 {

    class_43 field_210;

    int field_211;

    public class_40 field_212;

    public class_40[] field_213;

    char[] field_214;

    public int field_215;

    class_43 field_216;

    class_43[] field_217;

    class_46 field_218;

    class_80 field_219;

    public class_45(class_43 var1, int var2, class_40 var3, class_40[] var4, int var5, class_80 var6) {
        this.field_211 = var2;
        this.field_215 = var5;
        this.field_199 = 1073741825;
        this.field_219 = var6;
        this.method_251(var1, var3, var4);
        if (var1 instanceof class_44) {
            ((class_44)var1).method_246(this, var6);
        }
        if (var3 instanceof class_44) {
            ((class_44)var3).method_246(this, var6);
        }
        this.field_178 |= 16777216L;
    }

    public int method_98() {
        return this.field_213 == null ? 516 : 8196;
    }

    public boolean method_250(class_40 var1) {
        switch (this.field_215) {
            case 0:
                return true;
            case 1:
                if (var1.method_152(this.field_212)) {
                    return true;
                } else {
                    int var2 = 0;
                    for (int var3 = this.field_213 == null ? 0 : this.field_213.length; var2 < var3; ++var2) {
                        if (var1.method_152(this.field_213[var2])) {
                            return true;
                        }
                    }
                    return false;
                }
            default:
                return var1.method_152(this.field_212);
        }
    }

    public boolean method_129() {
        return false;
    }

    public List method_132(List var1) {
        if ((this.field_178 & 128L) != 0L) {
            var1 = this.field_212.method_132(var1);
        }
        return var1;
    }

    public void method_133(class_83 var1, class_40 var2, class_321 var3, int var4) {
        if ((this.field_178 & 536870912L) != 0L) {
            if (var2 != class_40.field_187) {
                if (((class_40)var2).method_150()) {
                    class_47 var5 = (class_47)var2;
                    var2 = var5.field_227;
                }
                int var6;
                int var7;
                int var8;
                class_45 var9;
                class_45 var10;
                label205:
                switch (var4) {
                    case 0:
                        switch (this.field_215) {
                            case 0:
                            default:
                                return;
                            case 1:
                                switch (((class_40)var2).method_98()) {
                                    case 516:
                                        var9 = (class_45)var2;
                                        switch (var9.field_215) {
                                            case 0:
                                            case 2:
                                            default:
                                                return;
                                            case 1:
                                                this.field_212.method_133(var1, var9.field_212, var3, 0);
                                                var6 = 0;
                                                for (var7 = var9.field_213 == null ? 0 : var9.field_213.length; var6 < var7; ++var6) {
                                                    this.field_212.method_133(var1, var9.field_213[var6], var3, 0);
                                                }
                                                return;
                                        }
                                    case 8196:
                                        var10 = (class_45)var2;
                                        this.field_212.method_133(var1, var10.field_212, var3, 0);
                                        var7 = 0;
                                        for (var8 = var10.field_213 == null ? 0 : var10.field_213.length; var7 < var8; ++var7) {
                                            this.field_212.method_133(var1, var10.field_213[var7], var3, 0);
                                        }
                                        break label205;
                                    default:
                                        return;
                                }
                            case 2:
                                switch (((class_40)var2).method_98()) {
                                    case 516:
                                        var9 = (class_45)var2;
                                        switch (var9.field_215) {
                                            case 0:
                                            case 1:
                                            default:
                                                return;
                                            case 2:
                                                this.field_212.method_133(var1, var9.field_212, var3, 0);
                                                var6 = 0;
                                                for (var7 = var9.field_213 == null ? 0 : var9.field_213.length; var6 < var7; ++var6) {
                                                    this.field_212.method_133(var1, var9.field_213[var6], var3, 0);
                                                }
                                                break label205;
                                        }
                                    case 8196:
                                    default:
                                        return;
                                }
                        }
                    case 1:
                        switch (this.field_215) {
                            case 0:
                            default:
                                return;
                            case 1:
                                switch (((class_40)var2).method_98()) {
                                    case 516:
                                        var9 = (class_45)var2;
                                        switch (var9.field_215) {
                                            case 0:
                                            case 2:
                                            default:
                                                return;
                                            case 1:
                                                this.field_212.method_133(var1, var9.field_212, var3, 1);
                                                return;
                                        }
                                    case 8196:
                                        var10 = (class_45)var2;
                                        this.field_212.method_133(var1, var10.field_212, var3, 1);
                                        var7 = 0;
                                        for (var8 = var10.field_213.length; var7 < var8; ++var7) {
                                            this.field_212.method_133(var1, var10.field_213[var7], var3, 1);
                                        }
                                        return;
                                    default:
                                        this.field_212.method_133(var1, (class_40)var2, var3, 1);
                                        return;
                                }
                            case 2:
                                switch (((class_40)var2).method_98()) {
                                    case 516:
                                        var9 = (class_45)var2;
                                        switch (var9.field_215) {
                                            case 0:
                                            case 1:
                                            default:
                                                return;
                                            case 2:
                                                this.field_212.method_133(var1, var9.field_212, var3, 2);
                                                var6 = 0;
                                                for (var7 = var9.field_213 == null ? 0 : var9.field_213.length; var6 < var7; ++var6) {
                                                    this.field_212.method_133(var1, var9.field_213[var6], var3, 2);
                                                }
                                                break label205;
                                        }
                                    case 8196:
                                        return;
                                    default:
                                        this.field_212.method_133(var1, (class_40)var2, var3, 2);
                                        return;
                                }
                        }
                    case 2:
                        label152:
                        switch (this.field_215) {
                            case 0:
                            default:
                                break;
                            case 1:
                                switch (((class_40)var2).method_98()) {
                                    case 516:
                                        var9 = (class_45)var2;
                                        switch (var9.field_215) {
                                            case 0:
                                            case 2:
                                            default:
                                                return;
                                            case 1:
                                                this.field_212.method_133(var1, var9.field_212, var3, 2);
                                                var6 = 0;
                                                for (var7 = var9.field_213 == null ? 0 : var9.field_213.length; var6 < var7; ++var6) {
                                                    this.field_212.method_133(var1, var9.field_213[var6], var3, 2);
                                                }
                                                return;
                                        }
                                    case 8196:
                                        var10 = (class_45)var2;
                                        this.field_212.method_133(var1, var10.field_212, var3, 2);
                                        var7 = 0;
                                        for (var8 = var10.field_213 == null ? 0 : var10.field_213.length; var7 < var8; ++var7) {
                                            this.field_212.method_133(var1, var10.field_213[var7], var3, 2);
                                        }
                                        break label152;
                                    default:
                                        return;
                                }
                            case 2:
                                switch (((class_40)var2).method_98()) {
                                    case 516:
                                        var9 = (class_45)var2;
                                        switch (var9.field_215) {
                                            case 0:
                                            case 1:
                                            default:
                                                break;
                                            case 2:
                                                this.field_212.method_133(var1, var9.field_212, var3, 2);
                                                var6 = 0;
                                                for (var7 = var9.field_213 == null ? 0 : var9.field_213.length; var6 < var7; ++var6) {
                                                    this.field_212.method_133(var1, var9.field_213[var6], var3, 2);
                                                }
                                        }
                                    case 8196:
                                }
                        }
                }
            }
        }
    }

    public char[] method_134() {
        return this.method_138().method_134();
    }

    public String method_135() {
        return this.toString();
    }

    public class_40 method_138() {
        return this.field_213 == null ? (this.field_215 == 1 ? this.field_212.method_138() : this.method_253().method_138()) : (this.field_212.field_177 == 1 ? this.field_213[0].method_138() : this.field_212.method_138());
    }

    public char[] method_142() {
        if (this.field_214 == null) {
            switch (this.field_215) {
                case 0:
                    this.field_214 = class_17.field_55;
                    break;
                case 1:
                    this.field_214 = CharOperation.method_1355(class_17.field_56, this.field_212.method_142());
                    break;
                default:
                    this.field_214 = CharOperation.method_1355(class_17.field_54, this.field_212.method_142());
            }
        }
        return this.field_214;
    }

    public int hashCode() {
        return this.field_210.hashCode();
    }

    void method_251(class_43 var1, class_40 var2, class_40[] var3) {
        this.field_210 = var1;
        this.field_212 = var2;
        this.field_213 = var3;
        if (var1 != null) {
            this.field_200 = var1.method_143();
        }
        if (var2 != null) {
            this.field_178 |= var2.field_178 & 536871040L;
        }
    }

    public boolean method_228(class_43 var1) {
        return this.field_215 == 2 ? (this.field_212 instanceof class_43 ? ((class_43)this.field_212).method_228(var1) : var1.field_177 == 1) : false;
    }

    public boolean method_170() {
        return this.field_215 == 0;
    }

    public boolean method_172() {
        return true;
    }

    public char[] method_103() {
        switch (this.field_215) {
            case 0:
                return class_17.field_51;
            case 1:
                if (this.field_213 == null) {
                    return CharOperation.method_1356(class_17.field_51, class_17.field_53, this.field_212.method_103());
                }
                StringBuffer var1 = new StringBuffer(10);
                var1.append(this.field_212.method_103());
                int var2 = 0;
                for (int var3 = this.field_213.length; var2 < var3; ++var2) {
                    var1.append('&').append(this.field_213[var2].method_103());
                }
                char[] var4 = new char[var2 = var1.length()];
                var1.getChars(0, var2, var4, 0);
                return var4;
            default:
                return CharOperation.method_1356(class_17.field_51, class_17.field_52, this.field_212.method_103());
        }
    }

    class_43 method_252() {
        if ((this.field_178 & 16777216L) == 0L) {
            return this;
        } else {
            this.field_178 &= -16777217L;
            class_49.method_268(this.field_210, this.field_219, (class_52)null, 0);
            switch (this.field_215) {
                case 0:
                default:
                    break;
                case 1:
                    this.field_212 = class_49.method_268(this.field_212, this.field_219, (class_52)null, 0);
                    int var1 = 0;
                    for (int var2 = this.field_213 == null ? 0 : this.field_213.length; var1 < var2; ++var1) {
                        this.field_213[var1] = class_49.method_268(this.field_212, this.field_219, (class_52)null, 0);
                    }
                    return this;
                case 2:
                    this.field_212 = class_49.method_268(this.field_212, this.field_219, (class_52)null, 0);
            }
            return this;
        }
    }

    public char[] method_104() {
        switch (this.field_215) {
            case 0:
                return class_17.field_51;
            case 1:
                if (this.field_213 == null) {
                    return CharOperation.method_1356(class_17.field_51, class_17.field_53, this.field_212.method_104());
                }
                StringBuffer var1 = new StringBuffer(10);
                var1.append(this.field_212.method_104());
                int var2 = 0;
                for (int var3 = this.field_213.length; var2 < var3; ++var2) {
                    var1.append('&').append(this.field_213[var2].method_104());
                }
                char[] var4 = new char[var2 = var1.length()];
                var1.getChars(0, var2, var4, 0);
                return var4;
            default:
                return CharOperation.method_1356(class_17.field_51, class_17.field_52, this.field_212.method_104());
        }
    }

    public char[] method_178() {
        if (this.field_203 == null) {
            switch (this.field_215) {
                case 1:
                    return this.field_212.method_178();
                default:
                    return this.method_253().method_178();
            }
        } else {
            return this.field_203;
        }
    }

    public char[] method_179() {
        switch (this.field_215) {
            case 0:
                return class_17.field_51;
            case 1:
                return CharOperation.method_1356(class_17.field_51, class_17.field_53, this.field_212.method_179());
            default:
                return CharOperation.method_1356(class_17.field_51, class_17.field_52, this.field_212.method_179());
        }
    }

    public class_43 method_240() {
        if (this.field_216 == null) {
            class_40 var1 = null;
            if (this.field_215 == 1 && !this.field_212.method_157()) {
                var1 = this.field_212;
            } else {
                class_46 var2 = this.method_253();
                if (var2 != null) {
                    var1 = var2.field_222;
                }
            }
            this.field_216 = var1 instanceof class_43 && !var1.method_157() ? (class_43)var1 : this.field_219.method_506(class_17.field_99, (class_83)null);
        }
        return this.field_216;
    }

    public class_43[] method_241() {
        if (this.field_217 == null) {
            if (this.method_253() != null) {
                this.field_217 = this.field_218.method_241();
            } else {
                this.field_217 = class_34.field_155;
            }
            if (this.field_215 == 1) {
                int var1;
                if (this.field_212.method_157()) {
                    var1 = this.field_217.length;
                    System.arraycopy(this.field_217, 0, this.field_217 = new class_43[var1 + 1], 1, var1);
                    this.field_217[0] = (class_43)this.field_212;
                }
                if (this.field_213 != null) {
                    var1 = this.field_217.length;
                    int var2 = this.field_213.length;
                    System.arraycopy(this.field_217, 0, this.field_217 = new class_43[var1 + var2], 0, var1);
                    for (int var3 = 0; var3 < var2; ++var3) {
                        this.field_217[var1 + var3] = (class_43)this.field_213[var3];
                    }
                }
            }
        }
        return this.field_217;
    }

    public void method_180(class_44 var1, class_43 var2, class_80 var3) {
        boolean var4 = false;
        if (this.field_210 == var1) {
            this.field_210 = var2;
            var4 = true;
        }
        if (this.field_212 == var1) {
            this.field_212 = var3.method_491(var2);
            var4 = true;
        }
        if (this.field_213 != null) {
            int var5 = 0;
            for (int var6 = this.field_213.length; var5 < var6; ++var5) {
                if (this.field_213[var5] == var1) {
                    this.field_213[var5] = var3.method_491(var2);
                    var4 = true;
                }
            }
        }
        if (var4) {
            this.method_251(this.field_210, this.field_212, this.field_213);
        }
    }

    public String toString() {
        switch (this.field_215) {
            case 0:
                return new String(class_17.field_51);
            case 1:
                if (this.field_213 == null) {
                    return new String(CharOperation.method_1356(class_17.field_51, class_17.field_53, this.field_212.method_135().toCharArray()));
                }
                StringBuffer var1 = new StringBuffer(this.field_212.method_135());
                int var2 = 0;
                for (int var3 = this.field_213.length; var2 < var3; ++var2) {
                    var1.append('&').append(this.field_213[var2].method_135());
                }
                return var1.toString();
            default:
                return new String(CharOperation.method_1356(class_17.field_51, class_17.field_52, this.field_212.method_135().toCharArray()));
        }
    }

    public class_46 method_253() {
        if (this.field_218 == null) {
            class_46[] var1 = this.field_210.method_181();
            if (this.field_211 < var1.length) {
                this.field_218 = var1[this.field_211];
            }
        }
        return this.field_218;
    }
}
