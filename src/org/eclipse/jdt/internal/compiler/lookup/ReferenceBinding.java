package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ast.class_96;
import org.eclipse.jdt.internal.compiler.env.IDependent;
import org.eclipse.jdt.internal.compiler.lookup.class_17;
import org.eclipse.jdt.internal.compiler.lookup.class_185;
import org.eclipse.jdt.internal.compiler.lookup.class_200;
import org.eclipse.jdt.internal.compiler.lookup.class_203;
import org.eclipse.jdt.internal.compiler.lookup.class_205;
import org.eclipse.jdt.internal.compiler.lookup.class_34;
import org.eclipse.jdt.internal.compiler.lookup.PackageBinding;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.class_46;
import org.eclipse.jdt.internal.compiler.lookup.class_47;
import org.eclipse.jdt.internal.compiler.lookup.class_48;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.class_58;
import org.eclipse.jdt.internal.compiler.lookup.class_66;
import org.eclipse.jdt.internal.compiler.lookup.class_67;
import org.eclipse.jdt.internal.compiler.lookup.class_83;
import org.eclipse.jdt.internal.compiler.lookup.class_85;
import org.eclipse.jdt.internal.compiler.util.class_327;

import java.util.Comparator;
import java.util.Arrays;

public abstract class ReferenceBinding extends class_40 implements IDependent {

    public char[][] field_197;

    public char[] field_198;

    public int field_199;

    public PackageBinding field_200;

    String field_201;

    char[] field_202;

    char[] field_203;

    private class_327 field_204;

    public static ReferenceBinding field_205;

    private static final Comparator field_206;

    private static final Comparator field_207;

    public ReferenceBinding() {
    }

    public static class_67 method_189(char[] var0, class_67[] var1) {
        if (var1 == null) {
            return null;
        } else {
            int var2 = var1.length;
            if (var2 == 0) {
                return null;
            } else {
                int var3 = 0;
                int var4 = var2 - 1;
                int var5 = var0.length;
                boolean var6 = false;
                while (var3 <= var4) {
                    int var9 = var3 + (var4 - var3) / 2;
                    char[] var7;
                    int var8 = method_191(var0, var7 = var1[var9].field_302, var5, var7.length);
                    if (var8 < 0) {
                        var4 = var9 - 1;
                    } else {
                        if (var8 <= 0) {
                            return var1[var9];
                        }
                        var3 = var9 + 1;
                    }
                }
                return null;
            }
        }
    }

    public static long method_190(char[] var0, class_58[] var1) {
        if (var1 == null) {
            return -1L;
        } else {
            int var2 = var1.length;
            if (var2 == 0) {
                return -1L;
            } else {
                int var3 = 0;
                int var4 = var2 - 1;
                int var5 = var0.length;
                boolean var6 = false;
                while (var3 <= var4) {
                    int var11 = var3 + (var4 - var3) / 2;
                    char[] var7;
                    int var8 = method_191(var0, var7 = var1[var11].field_274, var5, var7.length);
                    if (var8 < 0) {
                        var4 = var11 - 1;
                    } else {
                        if (var8 <= 0) {
                            int var9 = var11;
                            int var10;
                            for (var10 = var11; var9 > var3 && CharOperation.method_1364(var1[var9 - 1].field_274, var0); --var9) {
                                ;
                            }
                            while (var10 < var4 && CharOperation.method_1364(var1[var10 + 1].field_274, var0)) {
                                ++var10;
                            }
                            return (long)var9 + ((long)var10 << 32);
                        }
                        var3 = var11 + 1;
                    }
                }
                return -1L;
            }
        }
    }

    static int method_191(char[] var0, char[] var1, int var2, int var3) {
        int var4 = Math.min(var2, var3);
        int var5 = 0;
        char var6;
        char var7;
        do {
            if (var4-- == 0) {
                return var2 - var3;
            }
            var6 = var0[var5];
            var7 = var1[var5++];
        } while (var6 == var7);
        return var6 - var7;
    }

    public static void method_192(class_67[] var0, int var1, int var2) {
        Arrays.sort(var0, var1, var2, field_206);
    }

    public static void method_193(class_58[] var0, int var1, int var2) {
        Arrays.sort(var0, var1, var2, field_207);
    }

    public boolean method_129() {
        return (this.field_199 & 26112) == 0;
    }

    public final boolean method_194(PackageBinding var1) {
        return this.method_225() ? true : (this.method_223() ? false : var1 == this.field_200);
    }

    public final boolean method_195(ReferenceBinding var1, ReferenceBinding var2) {
        if (this.method_225()) {
            return true;
        } else if (var2 == this && var2 == var1) {
            return true;
        } else if (this.method_224()) {
            if (var2 == this) {
                return true;
            } else if (var2.field_200 == this.field_200) {
                return true;
            } else {
                Object var7 = var2.method_138();
                class_40 var9 = this.method_137().method_138();
                if (var9 == var2) {
                    return true;
                } else if (var9 == null) {
                    return false;
                } else {
                    while (((class_40)var7).method_140(var9) == null) {
                        var7 = ((class_40)var7).method_137();
                        if (var7 == null) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        } else {
            ReferenceBinding var4;
            ReferenceBinding var6;
            if (!this.method_223()) {
                if (var2.field_200 != this.field_200) {
                    return false;
                } else {
                    var6 = var1;
                    var4 = this.method_137() == null ? this : this.method_137();
                    do {
                        if (var4 == var6) {
                            return true;
                        }
                        PackageBinding var8 = var6.field_200;
                        if (var8 != null && var8 != this.field_200) {
                            return false;
                        }
                    } while ((var6 = var6.method_240()) != null);
                    return false;
                }
            } else {
                if (var1 != this && var1 != this.method_137()) {
                    label103: {
                        if (var1.method_169()) {
                            class_46 var3 = (class_46)var1;
                            if (var3.method_258(this.method_138()) || var3.method_258(this.method_137().method_138())) {
                                break label103;
                            }
                        }
                        return false;
                    }
                }
                if (var2 != this) {
                    var6 = var2;
                    for (var4 = var2.method_137(); var4 != null; var4 = var4.method_137()) {
                        var6 = var4;
                    }
                    ReferenceBinding var5 = (ReferenceBinding)this.method_138();
                    for (var4 = var5.method_137(); var4 != null; var4 = var4.method_137()) {
                        var5 = var4;
                    }
                    if (var6 != var5) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    public final boolean method_196(class_83 var1) {
        if (this.method_225()) {
            return true;
        } else {
            SourceTypeBinding var2 = var1.method_585();
            if (var2 == this) {
                return true;
            } else if (var2 == null) {
                return !this.method_223() && var1.method_600() == this.field_200;
            } else {
                Object var3;
                if (this.method_224()) {
                    if (var2.field_200 == this.field_200) {
                        return true;
                    } else {
                        var3 = var2.method_138();
                        class_40 var6 = this.method_137().method_138();
                        if (var6 == null) {
                            return false;
                        } else {
                            while (var6 != var2) {
                                if (((class_40)var3).method_140(var6) != null) {
                                    return true;
                                }
                                var3 = ((class_40)var3).method_137();
                                if (var3 == null) {
                                    return false;
                                }
                            }
                            return true;
                        }
                    }
                } else if (!this.method_223()) {
                    return var2.field_200 == this.field_200;
                } else {
                    var3 = var2;
                    ReferenceBinding var4;
                    for (var4 = var2.method_137(); var4 != null; var4 = var4.method_137()) {
                        var3 = var4;
                    }
                    ReferenceBinding var5 = (ReferenceBinding)this.method_138();
                    for (var4 = var5.method_137(); var4 != null; var4 = var4.method_137()) {
                        var5 = var4;
                    }
                    return var3 == var5;
                }
            }
        }
    }

    public char[] method_197(class_46[] var1) {
        boolean var2 = this.method_159() && (this.method_137().field_199 & 1073741824) != 0;
        if (var1 == class_34.field_157 && !var2) {
            return this.method_178();
        } else {
            StringBuffer var3 = new StringBuffer(10);
            char[] var4;
            if (var2) {
                var4 = this.method_137().method_142();
                var3.append(var4, 0, var4.length - 1);
                var3.append('.');
                var3.append(this.field_198);
            } else {
                var4 = this.method_178();
                var3.append(var4, 0, var4.length - 1);
            }
            int var6;
            if (var1 == class_34.field_157) {
                var3.append(';');
            } else {
                var3.append('<');
                var6 = 0;
                for (int var5 = var1.length; var6 < var5; ++var6) {
                    var3.append(var1[var6].method_142());
                }
                var3.append(">;");
            }
            var6 = var3.length();
            char[] var7 = new char[var6];
            var3.getChars(0, var6, var7, 0);
            return var7;
        }
    }

    public void method_198() {
        char[] var1;
        switch (this.field_197.length) {
            case 3:
                if (!CharOperation.method_1364(class_17.field_26, this.field_197[0])) {
                    return;
                }
                if (!CharOperation.method_1364(class_17.field_27, this.field_197[1])) {
                    if (CharOperation.method_1364(class_17.field_28, this.field_197[1])) {
                        if (CharOperation.method_1364(class_17.field_107[2], this.field_197[2])) {
                            this.field_177 = 53;
                        } else if (CharOperation.method_1364(class_17.field_108[2], this.field_197[2])) {
                            this.field_177 = 37;
                        } else if (CharOperation.method_1364(class_17.field_131[2], this.field_197[2])) {
                            this.field_177 = 56;
                        } else if (CharOperation.method_1364(class_17.field_130[2], this.field_197[2])) {
                            this.field_177 = 57;
                        } else if (CharOperation.method_1364(class_17.field_132[2], this.field_197[2])) {
                            this.field_177 = 58;
                        }
                    } else if (CharOperation.method_1364(class_17.field_29, this.field_197[1]) && CharOperation.method_1364(class_17.field_118[2], this.field_197[2])) {
                        this.field_177 = 39;
                    }
                    return;
                }
                var1 = this.field_197[2];
                if (var1.length == 0) {
                    return;
                }
                switch (var1[0]) {
                    case 65:
                        if (CharOperation.method_1364(var1, class_17.field_89[2])) {
                            this.field_177 = 35;
                        }
                        return;
                    case 66:
                        if (CharOperation.method_1364(var1, class_17.field_116[2])) {
                            this.field_177 = 33;
                        } else if (CharOperation.method_1364(var1, class_17.field_109[2])) {
                            this.field_177 = 26;
                        }
                        return;
                    case 67:
                        if (CharOperation.method_1364(var1, class_17.field_111[2])) {
                            this.field_177 = 28;
                        } else if (CharOperation.method_1364(var1, class_17.field_90[2])) {
                            this.field_177 = 16;
                        } else if (CharOperation.method_1364(var1, class_17.field_91[2])) {
                            this.field_177 = 23;
                        } else if (CharOperation.method_1364(var1, class_17.field_92[2])) {
                            this.field_177 = 36;
                        }
                        return;
                    case 68:
                        if (CharOperation.method_1364(var1, class_17.field_115[2])) {
                            this.field_177 = 32;
                        } else if (CharOperation.method_1364(var1, class_17.field_119[2])) {
                            this.field_177 = 44;
                        }
                        return;
                    case 69:
                        if (CharOperation.method_1364(var1, class_17.field_95[2])) {
                            this.field_177 = 19;
                        } else if (CharOperation.method_1364(var1, class_17.field_94[2])) {
                            this.field_177 = 25;
                        } else if (CharOperation.method_1364(var1, class_17.field_93[2])) {
                            this.field_177 = 41;
                        }
                        return;
                    case 70:
                        if (CharOperation.method_1364(var1, class_17.field_114[2])) {
                            this.field_177 = 31;
                        }
                        return;
                    case 71:
                    case 72:
                    case 74:
                    case 75:
                    case 77:
                    case 80:
                    case 81:
                    case 85:
                    default:
                        return;
                    case 73:
                        if (CharOperation.method_1364(var1, class_17.field_112[2])) {
                            this.field_177 = 29;
                        } else if (CharOperation.method_1364(var1, class_17.field_97[2])) {
                            this.field_177 = 38;
                        } else if (CharOperation.method_1364(var1, class_17.field_96[2])) {
                            this.field_177 = 42;
                        }
                        return;
                    case 76:
                        if (CharOperation.method_1364(var1, class_17.field_113[2])) {
                            this.field_177 = 30;
                        }
                        return;
                    case 78:
                        if (CharOperation.method_1364(var1, class_17.field_98[2])) {
                            this.field_177 = 22;
                        }
                        return;
                    case 79:
                        if (CharOperation.method_1364(var1, class_17.field_99[2])) {
                            this.field_177 = 1;
                        } else if (CharOperation.method_1364(var1, class_17.field_122[2])) {
                            this.field_177 = 47;
                        }
                        return;
                    case 82:
                        if (CharOperation.method_1364(var1, class_17.field_104[2])) {
                            this.field_177 = 24;
                        }
                        return;
                    case 83:
                        if (CharOperation.method_1364(var1, class_17.field_100[2])) {
                            this.field_177 = 11;
                        } else if (CharOperation.method_1364(var1, class_17.field_101[2])) {
                            this.field_177 = 17;
                        } else if (CharOperation.method_1364(var1, class_17.field_102[2])) {
                            this.field_177 = 40;
                        } else if (CharOperation.method_1364(var1, class_17.field_103[2])) {
                            this.field_177 = 18;
                        } else if (CharOperation.method_1364(var1, class_17.field_110[2])) {
                            this.field_177 = 27;
                        } else if (CharOperation.method_1364(var1, class_17.field_124[2])) {
                            this.field_177 = 49;
                        }
                        return;
                    case 84:
                        if (CharOperation.method_1364(var1, class_17.field_105[2])) {
                            this.field_177 = 21;
                        }
                        return;
                    case 86:
                        if (CharOperation.method_1364(var1, class_17.field_117[2])) {
                            this.field_177 = 34;
                        }
                        return;
                }
            case 4:
                if (!CharOperation.method_1364(class_17.field_26, this.field_197[0])) {
                    return;
                }
                if (!CharOperation.method_1364(class_17.field_27, this.field_197[1])) {
                    return;
                }
                char[] var2 = this.field_197[2];
                if (var2.length == 0) {
                    return;
                }
                var1 = this.field_197[3];
                if (var1.length == 0) {
                    return;
                }
                if (CharOperation.method_1364(var2, class_17.field_31)) {
                    if (CharOperation.method_1364(var1, class_17.field_106[3])) {
                        this.field_177 = 20;
                    } else if (CharOperation.method_1364(var1, class_17.field_128[3])) {
                        this.field_177 = 54;
                    } else if (CharOperation.method_1364(var1, class_17.field_129[3])) {
                        this.field_177 = 55;
                    }
                    return;
                }
                if (CharOperation.method_1364(var2, class_17.field_30)) {
                    switch (var1[0]) {
                        case 65:
                            if (CharOperation.method_1364(var1, class_17.field_88[3])) {
                                this.field_177 = 43;
                            }
                            return;
                        case 66:
                        case 67:
                        case 70:
                        case 71:
                        case 72:
                        case 74:
                        case 75:
                        case 76:
                        case 77:
                        case 78:
                        case 79:
                        case 80:
                        case 81:
                        case 83:
                        default:
                            break;
                        case 68:
                            if (CharOperation.method_1364(var1, class_17.field_120[3])) {
                                this.field_177 = 45;
                            }
                            return;
                        case 69:
                            if (CharOperation.method_1364(var1, class_17.field_127[3])) {
                                this.field_177 = 52;
                            }
                            return;
                        case 73:
                            if (CharOperation.method_1364(var1, class_17.field_121[3])) {
                                this.field_177 = 46;
                            }
                            return;
                        case 82:
                            if (CharOperation.method_1364(var1, class_17.field_123[3])) {
                                this.field_177 = 48;
                            } else if (CharOperation.method_1364(var1, class_17.field_126[3])) {
                                this.field_177 = 51;
                            }
                            return;
                        case 84:
                            if (CharOperation.method_1364(var1, class_17.field_125[3])) {
                                this.field_177 = 50;
                            }
                            return;
                    }
                }
        }
    }

    public char[] method_134() {
        return this.field_202 != null ? this.field_202 : (this.field_202 = CharOperation.method_1361(this.field_197, '/'));
    }

    public String method_135() {
        return this.field_197 != null ? new String(this.method_103()) : "UNNAMED TYPE";
    }

    public final int method_199() {
        int var1 = 0;
        for (ReferenceBinding var2 = this; (var2 = var2.method_137()) != null; ++var1) {
            ;
        }
        return var1;
    }

    public boolean method_200() {
        if ((this.field_178 & 4294967296L) != 0L) {
            return false;
        } else if ((this.field_178 & 2147483648L) != 0L) {
            return true;
        } else {
            this.field_178 |= 2147483648L;
            class_58[] var1 = this.method_232();
            boolean var2 = false;
            int var3 = 0;
            for (int var4 = var1.length; var3 < var4; ++var3) {
                class_40 var5 = var1[var3].field_275.method_173();
                class_96 var6;
                if (this == var5) {
                    if (this instanceof SourceTypeBinding) {
                        var6 = (class_96)var1[var3].method_384();
                        ((SourceTypeBinding)this).field_258.method_644().method_1467(this, this, var6 != null ? var6.field_497 : null);
                    }
                } else if (var5.method_145() && ((ReferenceBinding)var5).method_200()) {
                    if (this instanceof SourceTypeBinding) {
                        var6 = (class_96)var1[var3].method_384();
                        ((SourceTypeBinding)this).field_258.method_644().method_1467(this, var5, var6 != null ? var6.field_497 : null);
                    }
                    var2 = true;
                }
            }
            if (var2) {
                return true;
            } else {
                this.field_178 |= 4294967296L;
                return false;
            }
        }
    }

    public final ReferenceBinding method_201(int var1) {
        ReferenceBinding var2;
        for (var2 = this; var1-- > 0 && var2 != null; var2 = var2.method_137()) {
            ;
        }
        return var2;
    }

    public int method_202() {
        int var1 = 0;
        class_67[] var2 = this.method_204();
        int var3 = 0;
        for (int var4 = var2.length; var3 < var4; ++var3) {
            if ((var2[var3].field_300 & 16384) != 0) {
                ++var1;
            }
        }
        return var1;
    }

    public int method_203() {
        return this.method_204().length;
    }

    public class_67[] method_204() {
        return class_34.field_153;
    }

    public final int method_205() {
        return this.field_199 & '\uffff';
    }

    public long method_99() {
        return this.field_178;
    }

    public class_58 method_206(class_40[] var1) {
        return null;
    }

    public class_58 method_207(char[] var1, class_40[] var2, class_85 var3) {
        return null;
    }

    public class_67 method_208(char[] var1, boolean var2) {
        return null;
    }

    public String method_50() {
        return this.field_201;
    }

    public ReferenceBinding method_209(char[] var1) {
        ReferenceBinding[] var2 = this.method_231();
        int var3 = var2.length;
        do {
            --var3;
            if (var3 < 0) {
                return null;
            }
        } while (!CharOperation.method_1364(var2[var3].field_198, var1));
        return var2[var3];
    }

    public class_58[] method_210(char[] var1) {
        return class_34.field_154;
    }

    public PackageBinding method_143() {
        return this.field_200;
    }

    public class_46 method_211(char[] var1) {
        class_46[] var2 = this.method_181();
        int var3 = var2.length;
        do {
            --var3;
            if (var3 < 0) {
                return null;
            }
        } while (!CharOperation.method_1364(var2[var3].field_198, var1));
        return var2[var3];
    }

    public int hashCode() {
        return this.field_197 != null && this.field_197.length != 0 ? CharOperation.method_1369(this.field_197[this.field_197.length - 1]) : super.hashCode();
    }

    public boolean method_212(ReferenceBinding var1) {
        if (this == var1) {
            return false;
        } else {
            ReferenceBinding[] var2 = null;
            int var3 = 0;
            ReferenceBinding var4 = this;
            class_40 var5;
            int var8;
            do {
                var5 = var1.method_140(var4);
                if (var5 != null && var5.method_164(var4)) {
                    return true;
                }
                ReferenceBinding[] var6 = var4.method_241();
                if (var6 != null && var6 != class_34.field_155) {
                    if (var2 == null) {
                        var2 = var6;
                        var3 = var6.length;
                    } else {
                        int var7 = var6.length;
                        if (var3 + var7 >= var2.length) {
                            System.arraycopy(var2, 0, var2 = new ReferenceBinding[var3 + var7 + 5], 0, var3);
                        }
                        var8 = 0;
                        while (var8 < var7) {
                            ReferenceBinding var9 = var6[var8];
                            int var10 = 0;
                            while (true) {
                                if (var10 < var3) {
                                    if (var9 != var2[var10]) {
                                        ++var10;
                                        continue;
                                    }
                                } else {
                                    var2[var3++] = var9;
                                }
                                ++var8;
                                break;
                            }
                        }
                    }
                }
            } while ((var4 = var4.method_240()) != null);
            for (int var12 = 0; var12 < var3; ++var12) {
                var4 = var2[var12];
                if (var4 == var1) {
                    return false;
                }
                var5 = var1.method_140(var4);
                if (var5 != null && var5.method_164(var4)) {
                    return true;
                }
                ReferenceBinding[] var13 = var4.method_241();
                if (var13 != null && var13 != class_34.field_155) {
                    var8 = var13.length;
                    if (var3 + var8 >= var2.length) {
                        System.arraycopy(var2, 0, var2 = new ReferenceBinding[var3 + var8 + 5], 0, var3);
                    }
                    int var14 = 0;
                    while (var14 < var8) {
                        ReferenceBinding var15 = var13[var14];
                        int var11 = 0;
                        while (true) {
                            if (var11 < var3) {
                                if (var15 != var2[var11]) {
                                    ++var11;
                                    continue;
                                }
                            } else {
                                var2[var3++] = var15;
                            }
                            ++var14;
                            break;
                        }
                    }
                }
            }
            return false;
        }
    }

    public boolean method_213() {
        return false;
    }

    public final boolean method_214() {
        return (this.field_199 & 262144) != 0;
    }

    public boolean method_215(ReferenceBinding var1, boolean var2) {
        if (this == var1) {
            return true;
        } else {
            ReferenceBinding[] var3 = null;
            int var4 = 0;
            ReferenceBinding var5 = this;
            int var8;
            do {
                ReferenceBinding[] var6 = var5.method_241();
                if (var6 != null && var6 != class_34.field_155) {
                    if (var3 == null) {
                        var3 = var6;
                        var4 = var6.length;
                    } else {
                        int var7 = var6.length;
                        if (var4 + var7 >= var3.length) {
                            System.arraycopy(var3, 0, var3 = new ReferenceBinding[var4 + var7 + 5], 0, var4);
                        }
                        label80:
                        for (var8 = 0; var8 < var7; ++var8) {
                            ReferenceBinding var9 = var6[var8];
                            for (int var10 = 0; var10 < var4; ++var10) {
                                if (var9 == var3[var10]) {
                                    continue label80;
                                }
                            }
                            var3[var4++] = var9;
                        }
                    }
                }
            } while (var2 && (var5 = var5.method_240()) != null);
            for (int var12 = 0; var12 < var4; ++var12) {
                var5 = var3[var12];
                if (var5.method_154(var1)) {
                    return true;
                }
                ReferenceBinding[] var13 = var5.method_241();
                if (var13 != null && var13 != class_34.field_155) {
                    var8 = var13.length;
                    if (var4 + var8 >= var3.length) {
                        System.arraycopy(var3, 0, var3 = new ReferenceBinding[var4 + var8 + 5], 0, var4);
                    }
                    int var14 = 0;
                    while (var14 < var8) {
                        ReferenceBinding var15 = var13[var14];
                        int var11 = 0;
                        while (true) {
                            if (var11 < var4) {
                                if (var15 != var3[var11]) {
                                    ++var11;
                                    continue;
                                }
                            } else {
                                var3[var4++] = var15;
                            }
                            ++var14;
                            break;
                        }
                    }
                }
            }
            return false;
        }
    }

    boolean method_216(class_58 var1) {
        char[] var2 = var1.field_274;
        for (ReferenceBinding var3 = this; var3 != null; var3 = var3.method_240()) {
            class_58[] var4 = var3.method_232();
            long var5;
            if ((var5 = method_190(var2, var4)) >= 0L) {
                int var7 = (int)var5;
                int var8 = (int)(var5 >> 32);
                for (int var9 = var7; var9 <= var8; ++var9) {
                    if (var4[var9].method_344(var1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean method_217() {
        return (this.field_199 & 1024) != 0;
    }

    public boolean method_145() {
        return (this.field_199 & 8192) != 0;
    }

    public final boolean method_218() {
        return (this.field_178 & 64L) != 0L;
    }

    public boolean method_151() {
        return (this.field_199 & 25088) == 0;
    }

    public boolean method_152(class_40 var1) {
        if (var1 == this) {
            return true;
        } else if (var1.field_177 == 1) {
            return true;
        } else {
            Object var2;
            if (this.field_204 == null) {
                class_327 var10001 = new class_327(3);
                this.field_204 = var10001;
                var2 = null;
            } else {
                var2 = this.field_204.method_3241(var1);
                if (var2 != null) {
                    return var2 == Boolean.TRUE;
                }
            }
            this.field_204.method_3242(var1, Boolean.FALSE);
            if (this.method_219(var1)) {
                this.field_204.method_3242(var1, Boolean.TRUE);
                return true;
            } else {
                return false;
            }
        }
    }

    private boolean method_219(class_40 var1) {
        if (var1 == this) {
            return true;
        } else if (var1.field_177 == 1) {
            return true;
        } else if (this.method_154(var1)) {
            return true;
        } else {
            switch (var1.method_98()) {
                case 516:
                case 8196:
                    return false;
                case 4100:
                    if (var1.method_150()) {
                        class_47 var2 = (class_47)var1;
                        class_40 var3 = var2.field_226;
                        if (var2.field_226 != null) {
                            if (var3.method_147()) {
                                return false;
                            }
                            return this.method_152(var3);
                        }
                    }
                case 4:
                case 260:
                case 1028:
                case 2052:
                    switch (this.method_98()) {
                        case 260:
                        case 1028:
                        case 2052:
                            if (this.method_138() == var1.method_138()) {
                                return false;
                            }
                        default:
                            ReferenceBinding var4 = (ReferenceBinding)var1;
                            if (var4.method_157()) {
                                return this.method_215(var4, true);
                            } else {
                                if (this.method_157()) {
                                    return false;
                                }
                                return var4.method_228(this);
                            }
                    }
                default:
                    return false;
            }
        }
    }

    public final boolean method_220() {
        return (this.field_199 & 1048576) != 0;
    }

    public boolean method_153() {
        return (this.field_199 & 16384) != 0;
    }

    public final boolean method_221() {
        return (this.field_199 & 16) != 0;
    }

    public boolean method_222() {
        return (this.field_178 & 512L) == 0L && (this.field_178 & 256L) != 0L;
    }

    public boolean method_157() {
        return (this.field_199 & 512) != 0;
    }

    public final boolean method_223() {
        return (this.field_199 & 2) != 0;
    }

    public final boolean method_224() {
        return (this.field_199 & 4) != 0;
    }

    public final boolean method_225() {
        return (this.field_199 & 1) != 0;
    }

    public final boolean method_226() {
        return (this.field_199 & 520) != 0 || (this.field_178 & 4L) == 0L;
    }

    public final boolean method_227() {
        return (this.field_199 & 2048) != 0;
    }

    public boolean method_228(ReferenceBinding var1) {
        while (true) {
            if ((var1 = var1.method_240()) != null) {
                if (!var1.method_154(this)) {
                    continue;
                }
                return true;
            }
            return false;
        }
    }

    public boolean method_171(boolean var1) {
        switch (this.field_177) {
            case 19:
            case 24:
                return true;
            case 20:
            case 22:
            case 23:
            default:
                ReferenceBinding var2 = this;
                while ((var2 = var2.method_240()) != null) {
                    switch (var2.field_177) {
                        case 19:
                        case 24:
                            return true;
                        case 20:
                        case 22:
                        case 23:
                        default:
                            break;
                        case 21:
                        case 25:
                            return false;
                    }
                }
                return false;
            case 21:
            case 25:
                return var1;
        }
    }

    public final boolean method_229() {
        return (this.field_199 & 134217728) != 0;
    }

    public final boolean method_230() {
        return (this.field_199 & 3145728) != 0 || (this.method_143().field_170 & 70368744177664L) != 0L;
    }

    public ReferenceBinding[] method_231() {
        return class_34.field_156;
    }

    public class_58[] method_232() {
        return class_34.field_154;
    }

    public final ReferenceBinding method_233() {
        ReferenceBinding var1 = this;
        ReferenceBinding var2;
        do {
            var2 = var1;
        } while ((var1 = var1.method_137()) != null);
        return var2;
    }

    public char[] method_177() {
        return this.method_159() ? CharOperation.method_1357(this.method_137().method_177(), this.method_179(), '.') : this.method_179();
    }

    public char[] method_103() {
        char[] var1;
        if (this.method_159()) {
            var1 = CharOperation.method_1357(this.method_137().method_103(), this.field_198, '.');
        } else {
            var1 = CharOperation.method_1361(this.field_197, '.');
        }
        class_46[] var2;
        if ((var2 = this.method_181()) != class_34.field_157) {
            StringBuffer var3 = new StringBuffer(10);
            var3.append(var1).append('<');
            int var4 = 0;
            for (int var5 = var2.length; var4 < var5; ++var4) {
                if (var4 > 0) {
                    var3.append(',');
                }
                var3.append(var2[var4].method_103());
            }
            var3.append('>');
            var4 = var3.length();
            var1 = new char[var4];
            var3.getChars(0, var4, var1, 0);
        }
        return var1;
    }

    public class_200 method_234(class_34 var1, boolean var2) {
        class_327 var3 = this.method_239(false);
        return var3 == null ? null : (class_200)var3.method_3241(var1);
    }

    class_203[] method_235(class_34 var1) {
        class_200 var2 = this.method_234(var1, true);
        return var2 == null ? class_34.field_158 : var2.method_1170();
    }

    public void method_236(class_203[] var1) {
        this.method_238(this, var1);
    }

    public char[] method_104() {
        char[] var1;
        if (this.method_159()) {
            var1 = CharOperation.method_1357(this.method_137().method_104(), this.field_198, '.');
        } else {
            var1 = this.field_198;
        }
        class_46[] var2;
        if ((var2 = this.method_181()) != class_34.field_157) {
            StringBuffer var3 = new StringBuffer(10);
            var3.append(var1).append('<');
            int var4 = 0;
            for (int var5 = var2.length; var4 < var5; ++var4) {
                if (var4 > 0) {
                    var3.append(',');
                }
                var3.append(var2[var4].method_104());
            }
            var3.append('>');
            var4 = var3.length();
            var1 = new char[var4];
            var3.getChars(0, var4, var1, 0);
        }
        return var1;
    }

    public char[] method_178() {
        return this.field_203 != null ? this.field_203 : (this.field_203 = CharOperation.method_1359('L', this.method_134(), ';'));
    }

    public char[] method_179() {
        return this.field_198;
    }

    void method_237(class_34 var1, class_200 var2) {
        class_327 var3;
        if (var2 == null) {
            var3 = this.method_239(false);
            if (var3 != null) {
                var3.method_3243(var1);
            }
        } else {
            var3 = this.method_239(true);
            if (var3 != null) {
                var3.method_3242(var1, var2);
            }
        }
    }

    void method_238(class_34 var1, class_203[] var2) {
        class_200 var3 = null;
        class_327 var4;
        if (var2 != null && var2.length != 0) {
            var4 = this.method_239(true);
            if (var4 == null) {
                return;
            }
            var3 = (class_200)var4.method_3241(var1);
            if (var3 == null) {
                class_200 var10000 = new class_200();
                var3 = var10000;
            }
        } else {
            var4 = this.method_239(false);
            if (var4 != null) {
                var3 = (class_200)var4.method_3241(var1);
            }
            if (var3 == null) {
                return;
            }
        }
        this.method_237(var1, var3.method_1173(var2));
    }

    class_327 method_239(boolean var1) {
        return null;
    }

    public ReferenceBinding method_240() {
        return null;
    }

    public ReferenceBinding[] method_241() {
        return class_34.field_155;
    }

    public ReferenceBinding[] method_242() {
        if (this.method_226()) {
            return null;
        } else {
            ReferenceBinding var1 = this.method_137();
            return var1 == null ? null : new ReferenceBinding[] {var1};
        }
    }

    public class_66[] method_243() {
        return null;
    }

    class_58[] method_244() {
        return this.method_232();
    }

    static {
        class_48 var10000 = new class_48();
        field_205 = var10000;
        class_205 var0 = new class_205();
        field_206 = var0;
        class_185 var1 = new class_185();
        field_207 = var1;
    }
}
