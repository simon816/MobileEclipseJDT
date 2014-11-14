package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ast.class_146;
import org.eclipse.jdt.internal.compiler.ast.class_89;
import org.eclipse.jdt.internal.compiler.lookup.class_17;
import org.eclipse.jdt.internal.compiler.lookup.class_32;
import org.eclipse.jdt.internal.compiler.lookup.class_321;
import org.eclipse.jdt.internal.compiler.lookup.class_34;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.class_43;
import org.eclipse.jdt.internal.compiler.lookup.class_44;
import org.eclipse.jdt.internal.compiler.lookup.class_45;
import org.eclipse.jdt.internal.compiler.lookup.class_46;
import org.eclipse.jdt.internal.compiler.lookup.class_47;
import org.eclipse.jdt.internal.compiler.lookup.class_49;
import org.eclipse.jdt.internal.compiler.lookup.class_58;
import org.eclipse.jdt.internal.compiler.lookup.class_62;
import org.eclipse.jdt.internal.compiler.lookup.class_66;
import org.eclipse.jdt.internal.compiler.lookup.class_67;
import org.eclipse.jdt.internal.compiler.lookup.class_70;
import org.eclipse.jdt.internal.compiler.lookup.class_80;
import org.eclipse.jdt.internal.compiler.lookup.class_83;
import org.eclipse.jdt.internal.compiler.lookup.class_85;

import java.util.List;

public class class_52 extends class_43 implements class_32 {

    private class_43 field_242;

    public class_40[] field_243;

    public class_80 field_244;

    public char[] field_245;

    public class_43 field_246;

    public class_43[] field_247;

    public class_67[] field_248;

    public class_43[] field_249;

    public class_58[] field_250;

    private class_43 field_251;

    public class_52(class_43 var1, class_40[] var2, class_43 var3, class_80 var4) {
        this.field_244 = var4;
        this.field_251 = var3;
        this.method_287(var1, var2);
        if (var1 instanceof class_44) {
            ((class_44)var1).method_246(this, var4);
        }
        if (var2 != null) {
            int var5 = 0;
            for (int var6 = var2.length; var5 < var6; ++var5) {
                if (var2[var5] instanceof class_44) {
                    ((class_44)var2[var5]).method_246(this, var4);
                }
            }
        }
        this.field_178 |= 16777216L;
    }

    protected class_43 method_283() {
        return this.field_242;
    }

    public void method_284(class_83 var1, class_146[] var2) {
        if ((this.field_178 & 4194304L) == 0L) {
            boolean var3 = false;
            class_46[] var4 = this.field_242.method_181();
            if (this.field_243 != null && var4 != null) {
                int var5 = 0;
                for (int var6 = var4.length; var5 < var6; ++var5) {
                    if (var4[var5].method_255(this, this.field_243[var5]) != 0) {
                        var3 = true;
                        if ((this.field_243[var5].field_178 & 128L) == 0L) {
                            var1.method_644().method_1778(this.field_243[var5], var4[var5], this.field_242, var2[var5]);
                        }
                    }
                }
            }
            if (!var3) {
                this.field_178 |= 4194304L;
            }
        }
    }

    public boolean method_129() {
        return (this.field_178 & 1073741824L) == 0L && super.method_129();
    }

    public class_40 method_130(class_83 var1, int var2) {
        if ((this.field_178 & 1073741824L) == 0L) {
            return this;
        } else {
            class_40[] var3 = this.field_243;
            int var4 = var3.length;
            class_40[] var5 = new class_40[var4];
            Object var6 = var1.method_585();
            if (var6 != null) {
                var6 = ((class_43)var6).method_233();
            }
            for (int var7 = 0; var7 < var4; ++var7) {
                class_40 var8 = var3[var7];
                if (var8.method_98() == 516) {
                    class_47 var10002 = new class_47((class_45)var8, (class_43)var6, var2, var1.method_576().method_686());
                    var5[var7] = var10002;
                } else {
                    var5[var7] = var8;
                }
            }
            class_52 var10 = this.field_244.method_500(this.field_242, var5, this.method_137());
            for (int var11 = 0; var11 < var4; ++var11) {
                class_40 var9 = var5[var11];
                if (var9.method_150()) {
                    ((class_47)var9).method_263(var1, var10);
                }
            }
            return var10;
        }
    }

    public List method_132(List var1) {
        if ((this.field_178 & 128L) != 0L) {
            if (this.field_251 != null) {
                var1 = this.field_251.method_132(var1);
            }
            var1 = this.method_286().method_132(var1);
            if (this.field_243 != null) {
                int var2 = 0;
                for (int var3 = this.field_243.length; var2 < var3; ++var2) {
                    var1 = this.field_243[var2].method_132(var1);
                }
            }
        }
        return var1;
    }

    public void method_133(class_83 var1, class_40 var2, class_321 var3, int var4) {
        if ((this.field_178 & 536870912L) != 0L) {
            if (var2 != class_40.field_187) {
                if (var2 instanceof class_43) {
                    Object var5;
                    class_40 var6;
                    switch (var4) {
                        case 0:
                        case 1:
                            var5 = this;
                            var6 = var2.method_140(this.field_242);
                            if (var6 == null) {
                                return;
                            }
                            break;
                        case 2:
                        default:
                            var5 = this.method_140(var2);
                            if (var5 == null) {
                                return;
                            }
                            var6 = var2;
                    }
                    class_43 var7 = ((class_40)var5).method_137();
                    if (var7 != null) {
                        var7.method_133(var1, var6.method_137(), var3, var4);
                    }
                    if (this.field_243 != null) {
                        Object var8;
                        switch (((class_40)var5).method_98()) {
                            case 260:
                                var8 = ((class_52)var5).field_243;
                                break;
                            case 1028:
                                if (!var3.method_3203()) {
                                    var3.field_1829 = 1;
                                }
                                return;
                            case 2052:
                                var8 = ((class_40)var5).method_181();
                                break;
                            default:
                                return;
                        }
                        Object var9;
                        switch (var6.method_98()) {
                            case 260:
                                var9 = ((class_52)var6).field_243;
                                break;
                            case 1028:
                                if (!var3.method_3203()) {
                                    var3.field_1829 = 1;
                                }
                                return;
                            case 2052:
                                var9 = var6.method_181();
                                break;
                            default:
                                return;
                        }
                        ++var3.field_1828;
                        int var10 = 0;
                        for (int var11 = ((Object[])var8).length; var10 < var11; ++var10) {
                            Object var12 = ((Object[])var8)[var10];
                            Object var13 = ((Object[])var9)[var10];
                            if (((class_40)var12).method_172()) {
                                ((class_40)var12).method_133(var1, (class_40)var13, var3, var4);
                            } else {
                                if (((class_40)var13).method_172()) {
                                    class_45 var14 = (class_45)var13;
                                    if (var14.field_213 == null) {
                                        if (var4 == 2) {
                                            switch (var14.field_215) {
                                                case 1:
                                                    ((class_40)var12).method_133(var1, var14.field_212, var3, 2);
                                                    continue;
                                                case 2:
                                                    ((class_40)var12).method_133(var1, var14.field_212, var3, 1);
                                            }
                                        }
                                        continue;
                                    }
                                }
                                ((class_40)var12).method_133(var1, (class_40)var13, var3, 0);
                            }
                        }
                        --var3.field_1828;
                    }
                }
            }
        }
    }

    public void method_198() {
        this.field_177 = Integer.MAX_VALUE;
    }

    public char[] method_134() {
        return this.field_242.method_134();
    }

    public class_62 method_285(class_58 var1) {
        class_62 var10000 = new class_62(this, var1);
        return var10000;
    }

    public String method_135() {
        StringBuffer var1 = new StringBuffer(10);
        if (this.field_242 instanceof class_44) {
            var1.append(this.field_242);
        } else {
            var1.append(this.field_242.method_179());
        }
        if (this.field_243 != null) {
            var1.append('<');
            int var2 = 0;
            for (int var3 = this.field_243.length; var2 < var3; ++var2) {
                if (var2 > 0) {
                    var1.append(',');
                }
                var1.append(this.field_243[var2].method_135());
            }
            var1.append('>');
        }
        return var1.toString();
    }

    public class_43 method_137() {
        return this.field_251;
    }

    public class_80 method_91() {
        return this.field_244;
    }

    public class_40 method_138() {
        return this.field_242.method_138();
    }

    public int method_203() {
        return this.field_242.method_203();
    }

    public class_67[] method_204() {
        if ((this.field_178 & 8192L) != 0L) {
            return this.field_248;
        } else {
            try {
                class_67[] var1 = this.field_242.method_204();
                int var2 = var1.length;
                class_67[] var3 = new class_67[var2];
                for (int var4 = 0; var4 < var2; ++var4) {
                    class_70 var10002 = new class_70(this, var1[var4]);
                    var3[var4] = var10002;
                }
                this.field_248 = var3;
                return this.field_248;
            } finally {
                if (this.field_248 == null) {
                    this.field_248 = class_34.field_153;
                }
                this.field_178 |= 8192L;
            }
        }
    }

    public class_43 method_286() {
        if (this.field_242 instanceof class_44) {
            ((class_44)this.field_242).method_247(this.field_244, false);
        }
        return this.field_242;
    }

    public char[] method_142() {
        if (this.field_245 == null) {
            if ((this.field_199 & 1073741824) == 0) {
                this.field_245 = this.field_242.method_178();
            } else {
                StringBuffer var1 = new StringBuffer(10);
                if (this.method_159()) {
                    class_43 var2 = this.method_137();
                    char[] var3 = var2.method_142();
                    var1.append(var3, 0, var3.length - 1);
                    if ((var2.field_199 & 1073741824) != 0) {
                        var1.append('.');
                    } else {
                        var1.append('$');
                    }
                    var1.append(this.method_179());
                } else {
                    char[] var4 = this.field_242.method_178();
                    var1.append(var4, 0, var4.length - 1);
                }
                int var5;
                if (this.field_243 != null) {
                    var1.append('<');
                    var5 = 0;
                    for (int var6 = this.field_243.length; var5 < var6; ++var5) {
                        var1.append(this.field_243[var5].method_142());
                    }
                    var1.append('>');
                }
                var1.append(';');
                var5 = var1.length();
                this.field_245 = new char[var5];
                var1.getChars(0, var5, this.field_245, 0);
            }
        }
        return this.field_245;
    }

    public long method_99() {
        return this.field_242.method_99();
    }

    public class_58 method_206(class_40[] var1) {
        int var2 = var1.length;
        class_58 var3 = null;
        if ((this.field_178 & 32768L) != 0L) {
            long var4;
            if ((var4 = class_43.method_190(class_17.field_135, this.field_250)) >= 0L) {
                int var6 = (int)var4;
                label61:
                for (int var7 = (int)(var4 >> 32); var6 <= var7; ++var6) {
                    class_58 var8 = this.field_250[var6];
                    if (var8.field_276.length == var2) {
                        class_40[] var9 = var8.field_276;
                        for (int var10 = 0; var10 < var2; ++var10) {
                            if (var9[var10] != var1[var10]) {
                                continue label61;
                            }
                        }
                        if (var3 != null) {
                            return null;
                        }
                        var3 = var8;
                    }
                }
            }
        } else {
            class_58[] var11 = this.method_210(class_17.field_135);
            int var5 = var11.length;
            label47:
            while (true) {
                --var5;
                if (var5 < 0) {
                    break;
                }
                class_58 var12 = var11[var5];
                class_40[] var13 = var12.field_276;
                if (var13.length == var2) {
                    for (int var14 = 0; var14 < var2; ++var14) {
                        if (var13[var14] != var1[var14]) {
                            continue label47;
                        }
                    }
                    if (var3 != null) {
                        return null;
                    }
                    var3 = var12;
                }
            }
        }
        return var3;
    }

    public class_58 method_207(char[] var1, class_40[] var2, class_85 var3) {
        int var4 = var2.length;
        boolean var5 = true;
        class_58 var6 = null;
        if ((this.field_178 & 32768L) != 0L) {
            long var7;
            if ((var7 = class_43.method_190(var1, this.field_250)) >= 0L) {
                int var9 = (int)var7;
                label99:
                for (int var10 = (int)(var7 >> 32); var9 <= var10; ++var9) {
                    class_58 var11 = this.field_250[var9];
                    var5 = false;
                    if (var11.field_276.length == var4) {
                        class_40[] var12 = var11.field_276;
                        for (int var13 = 0; var13 < var4; ++var13) {
                            if (var12[var13] != var2[var13]) {
                                continue label99;
                            }
                        }
                        if (var6 != null) {
                            return null;
                        }
                        var6 = var11;
                    }
                }
            }
        } else {
            class_58[] var14 = this.method_210(var1);
            var5 = var14 == class_34.field_154;
            int var8 = var14.length;
            label85:
            while (true) {
                --var8;
                if (var8 < 0) {
                    break;
                }
                class_58 var15 = var14[var8];
                class_40[] var17 = var15.field_276;
                if (var17.length == var4) {
                    for (int var16 = 0; var16 < var4; ++var16) {
                        if (var17[var16] != var2[var16]) {
                            continue label85;
                        }
                    }
                    if (var6 != null) {
                        return null;
                    }
                    var6 = var15;
                }
            }
        }
        if (var6 != null) {
            return var6.method_354() ? null : var6;
        } else {
            if (var5 && (this.field_243 == null || this.field_243.length <= 1)) {
                if (this.method_157()) {
                    if (this.method_241().length == 1) {
                        if (var3 != null) {
                            var3.method_693(this.field_247[0]);
                        }
                        return this.field_247[0].method_207(var1, var2, var3);
                    }
                } else if (this.method_240() != null) {
                    if (var3 != null) {
                        var3.method_693(this.field_246);
                    }
                    return this.field_246.method_207(var1, var2, var3);
                }
            }
            return null;
        }
    }

    public class_67 method_208(char[] var1, boolean var2) {
        this.method_204();
        return class_43.method_189(var1, this.field_248);
    }

    public class_43 method_209(char[] var1) {
        this.method_231();
        int var2 = var1.length;
        int var3 = this.field_249.length;
        class_43 var4;
        do {
            --var3;
            if (var3 < 0) {
                return null;
            }
            var4 = this.field_249[var3];
        } while (var4.field_198.length != var2 || !CharOperation.method_1364(var4.field_198, var1));
        return var4;
    }

    public class_58[] method_210(char[] var1) {
        long var2;
        int var4;
        int var5;
        class_58[] var6;
        if (this.field_250 != null && (var2 = class_43.method_190(var1, this.field_250)) >= 0L) {
            var4 = (int)var2;
            var5 = (int)(var2 >> 32) - var4 + 1;
            System.arraycopy(this.field_250, var4, var6 = new class_58[var5], 0, var5);
            return var6;
        } else if ((this.field_178 & 32768L) != 0L) {
            return class_34.field_154;
        } else {
            class_58[] var10 = null;
            class_58[] var11;
            try {
                class_58[] var3 = this.field_242.method_210(var1);
                var4 = var3.length;
                if (var4 == 0) {
                    var11 = class_34.field_154;
                    return var11;
                }
                var10 = new class_58[var4];
                for (var5 = 0; var5 < var4; ++var5) {
                    var10[var5] = this.method_285(var3[var5]);
                }
                if (this.field_250 == null) {
                    var11 = new class_58[var4];
                    System.arraycopy(var10, 0, var11, 0, var4);
                    this.field_250 = var11;
                } else {
                    var5 = var4 + this.field_250.length;
                    var6 = new class_58[var5];
                    System.arraycopy(var10, 0, var6, 0, var4);
                    System.arraycopy(this.field_250, 0, var6, var4, this.field_250.length);
                    if (var5 > 1) {
                        class_43.method_193(var6, 0, var5);
                    }
                    this.field_250 = var6;
                }
                var11 = var10;
            } finally {
                if (var10 == null) {
                    var10 = class_34.field_154;
                    this.field_250 = class_34.field_154;
                }
            }
            return var11;
        }
    }

    public boolean method_213() {
        return this.field_242.method_213();
    }

    public boolean method_216(class_58 var1) {
        return this.field_242.method_216(var1);
    }

    void method_287(class_43 var1, class_40[] var2) {
        this.field_242 = var1;
        this.field_198 = var1.field_198;
        this.field_197 = var1.field_197;
        this.field_200 = var1.field_200;
        this.field_201 = var1.field_201;
        this.field_199 = var1.field_199 & -1073741825;
        if (var2 != null) {
            this.field_199 |= 1073741824;
        } else if (this.field_251 != null) {
            this.field_199 |= this.field_251.field_199 & 1073741824;
            this.field_178 |= this.field_251.field_178 & 536871040L;
        }
        if (var2 != null) {
            this.field_243 = var2;
            int var3 = 0;
            for (int var4 = var2.length; var3 < var4; ++var3) {
                class_40 var5 = var2[var3];
                switch (var5.method_98()) {
                    case 516:
                        this.field_178 |= 1073741824L;
                        if (((class_45)var5).field_215 != 0) {
                            this.field_178 |= 8388608L;
                        }
                        break;
                    case 8196:
                        this.field_178 |= 1073741824L;
                        break;
                    default:
                        this.field_178 |= 8388608L;
                }
                this.field_178 |= var5.field_178 & 536871040L;
            }
        }
        this.field_178 |= var1.field_178 & 156L;
        this.field_178 &= -40961L;
    }

    protected void method_288() {}

    void method_144() {
        this.field_242.method_144();
    }

    public boolean method_154(class_40 var1) {
        if (this == var1) {
            return true;
        } else if (var1 == null) {
            return false;
        } else {
            switch (var1.method_98()) {
                case 260:
                    class_52 var2 = (class_52)var1;
                    if (this.field_242 != var2.field_242) {
                        return false;
                    } else {
                        if (!this.method_226()) {
                            class_43 var3 = this.method_137();
                            if (var3 != null) {
                                class_43 var4 = var2.method_137();
                                if (var4 == null) {
                                    return false;
                                }
                                if ((var4.field_178 & 1073741824L) == 0L) {
                                    if (var3 != var4) {
                                        return false;
                                    }
                                } else if (!var3.method_154(var2.method_137())) {
                                    return false;
                                }
                            }
                        }
                        if (this.field_243 == null) {
                            return var2.field_243 == null;
                        } else {
                            int var6 = this.field_243.length;
                            class_40[] var7 = var2.field_243;
                            if (var7 != null && var7.length == var6) {
                                for (int var5 = 0; var5 < var6; ++var5) {
                                    if (!this.field_243[var5].method_168(var7[var5])) {
                                        return false;
                                    }
                                }
                                return true;
                            }
                            return false;
                        }
                    }
                case 516:
                case 8196:
                    return ((class_45)var1).method_250(this);
                case 1028:
                    return this.method_138() == var1.method_138();
                default:
                    return false;
            }
        }
    }

    public boolean method_162() {
        return true;
    }

    public boolean method_92() {
        return this.method_166();
    }

    public int method_98() {
        return 260;
    }

    public class_43[] method_231() {
        if (this.field_249 == null) {
            try {
                class_43[] var1 = this.field_242.method_231();
                int var2 = var1.length;
                class_43[] var3 = new class_43[var2];
                for (int var4 = 0; var4 < var2; ++var4) {
                    var3[var4] = this.field_244.method_500(var1[var4], (class_40[])null, this);
                }
                this.field_249 = var3;
            } finally {
                if (this.field_249 == null) {
                    this.field_249 = class_34.field_156;
                }
            }
        }
        return this.field_249;
    }

    public class_58[] method_232() {
        if ((this.field_178 & 32768L) != 0L) {
            return this.field_250;
        } else {
            try {
                class_58[] var1 = this.field_242.method_232();
                int var2 = var1.length;
                class_58[] var3 = new class_58[var2];
                for (int var4 = 0; var4 < var2; ++var4) {
                    var3[var4] = this.method_285(var1[var4]);
                }
                this.field_250 = var3;
                return this.field_250;
            } finally {
                if (this.field_250 == null) {
                    this.field_250 = class_34.field_154;
                }
                this.field_178 |= 32768L;
            }
        }
    }

    public char[] method_176() {
        return this.field_242.method_176();
    }

    public char[] method_177() {
        return this.field_242.method_177();
    }

    public char[] method_103() {
        StringBuffer var1 = new StringBuffer(10);
        if (this.method_159()) {
            var1.append(CharOperation.method_1357(this.method_137().method_103(), this.field_198, '.'));
        } else {
            var1.append(CharOperation.method_1361(this.field_242.field_197, '.'));
        }
        int var2;
        if (this.field_243 != null) {
            var1.append('<');
            var2 = 0;
            for (int var3 = this.field_243.length; var2 < var3; ++var2) {
                if (var2 > 0) {
                    var1.append(',');
                }
                var1.append(this.field_243[var2].method_103());
            }
            var1.append('>');
        }
        var2 = var1.length();
        char[] var4 = new char[var2];
        var1.getChars(0, var2, var4, 0);
        return var4;
    }

    class_43 method_289() {
        if ((this.field_178 & 16777216L) == 0L) {
            return this;
        } else {
            this.field_178 &= -16777217L;
            class_43 var1 = class_49.method_267(this.field_242, this.field_244, false);
            if (this.field_243 != null) {
                int var2 = this.field_243.length;
                for (int var3 = 0; var3 < var2; ++var3) {
                    this.field_243[var3] = class_49.method_268(this.field_243[var3], this.field_244, (class_52)null, 0);
                }
                class_46[] var4 = var1.method_181();
                if (var4 == class_34.field_157) {
                    if ((var1.field_178 & 128L) == 0L) {
                        this.field_244.field_353.method_1702(0, (class_89)null, var1, this.field_243);
                    }
                    return this;
                }
                if (var2 != var4.length) {
                    this.field_244.field_353.method_1609((class_89)null, var1, this.field_243);
                    return this;
                }
            }
            return this;
        }
    }

    public char[] method_104() {
        StringBuffer var1 = new StringBuffer(10);
        if (this.method_159()) {
            var1.append(CharOperation.method_1357(this.method_137().method_104(), this.field_198, '.'));
        } else {
            var1.append(this.field_242.field_198);
        }
        int var2;
        if (this.field_243 != null) {
            var1.append('<');
            var2 = 0;
            for (int var3 = this.field_243.length; var2 < var3; ++var2) {
                if (var2 > 0) {
                    var1.append(',');
                }
                var1.append(this.field_243[var2].method_104());
            }
            var1.append('>');
        }
        var2 = var1.length();
        char[] var4 = new char[var2];
        var1.getChars(0, var2, var4, 0);
        return var4;
    }

    public char[] method_178() {
        if (this.field_203 == null) {
            this.field_203 = this.field_242.method_178();
        }
        return this.field_203;
    }

    public char[] method_179() {
        return this.field_242.method_179();
    }

    public class_40 method_90(class_46 var1) {
        class_52 var2 = this;
        while (true) {
            class_46[] var3 = var2.field_242.method_181();
            int var4 = var3.length;
            if (var1.field_221 < var4 && var3[var1.field_221] == var1) {
                if (var2.field_243 == null) {
                    var2.method_288();
                }
                if (var2.field_243 != null) {
                    return var2.field_243[var1.field_221];
                }
            }
            if (var2.method_226()) {
                break;
            }
            class_43 var5 = var2.method_137();
            if (!(var5 instanceof class_52)) {
                break;
            }
            var2 = (class_52)var5;
        }
        return var1;
    }

    public class_43 method_240() {
        if (this.field_246 == null) {
            class_43 var1 = this.field_242.method_240();
            if (var1 == null) {
                return null;
            }
            this.field_246 = (class_43)class_83.method_571(this, var1);
        }
        return this.field_246;
    }

    public class_43[] method_241() {
        if (this.field_247 == null) {
            if (this.field_242.method_222()) {
                return class_34.field_155;
            }
            this.field_247 = class_83.method_570(this, this.field_242.method_241());
        }
        return this.field_247;
    }

    public void method_180(class_44 var1, class_43 var2, class_80 var3) {
        boolean var4 = false;
        if (this.field_242 == var1) {
            this.field_242 = var2;
            var4 = true;
            class_43 var5 = var2.method_137();
            if (var5 != null) {
                this.field_251 = (class_43)var3.method_491(var5);
            }
        }
        if (this.field_243 != null) {
            int var7 = 0;
            for (int var6 = this.field_243.length; var7 < var6; ++var7) {
                if (this.field_243[var7] == var1) {
                    this.field_243[var7] = var3.method_491(var2);
                    var4 = true;
                }
            }
        }
        if (var4) {
            this.method_287(this.field_242, this.field_243);
        }
    }

    public class_43[] method_242() {
        return this.field_242.method_242();
    }

    public class_66[] method_243() {
        return this.field_242.method_243();
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer(30);
        if (this.field_242 instanceof class_44) {
            var1.append(this.method_135());
        } else {
            if (this.method_220()) {
                var1.append("deprecated ");
            }
            if (this.method_225()) {
                var1.append("public ");
            }
            if (this.method_224()) {
                var1.append("protected ");
            }
            if (this.method_223()) {
                var1.append("private ");
            }
            if (this.method_217() && this.method_151()) {
                var1.append("abstract ");
            }
            if (this.method_226() && this.method_160()) {
                var1.append("static ");
            }
            if (this.method_221()) {
                var1.append("final ");
            }
            if (this.method_153()) {
                var1.append("enum ");
            } else if (this.method_145()) {
                var1.append("@interface ");
            } else if (this.method_151()) {
                var1.append("class ");
            } else {
                var1.append("interface ");
            }
            var1.append(this.method_135());
            var1.append("\n\textends ");
            var1.append(this.field_246 != null ? this.field_246.method_135() : "NULL TYPE");
            int var2;
            int var3;
            if (this.field_247 != null) {
                if (this.field_247 != class_34.field_155) {
                    var1.append("\n\timplements : ");
                    var2 = 0;
                    for (var3 = this.field_247.length; var2 < var3; ++var2) {
                        if (var2 > 0) {
                            var1.append(", ");
                        }
                        var1.append(this.field_247[var2] != null ? this.field_247[var2].method_135() : "NULL TYPE");
                    }
                }
            } else {
                var1.append("NULL SUPERINTERFACES");
            }
            if (this.method_137() != null) {
                var1.append("\n\tenclosing type : ");
                var1.append(this.method_137().method_135());
            }
            if (this.field_248 != null) {
                if (this.field_248 != class_34.field_153) {
                    var1.append("\n/*   fields   */");
                    var2 = 0;
                    for (var3 = this.field_248.length; var2 < var3; ++var2) {
                        var1.append('\n').append(this.field_248[var2] != null ? this.field_248[var2].toString() : "NULL FIELD");
                    }
                }
            } else {
                var1.append("NULL FIELDS");
            }
            if (this.field_250 != null) {
                if (this.field_250 != class_34.field_154) {
                    var1.append("\n/*   methods   */");
                    var2 = 0;
                    for (var3 = this.field_250.length; var2 < var3; ++var2) {
                        var1.append('\n').append(this.field_250[var2] != null ? this.field_250[var2].toString() : "NULL METHOD");
                    }
                }
            } else {
                var1.append("NULL METHODS");
            }
            var1.append("\n\n");
        }
        return var1.toString();
    }

    public class_46[] method_181() {
        return this.field_243 == null ? this.field_242.method_181() : class_34.field_157;
    }
}
