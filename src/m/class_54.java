package m;

import a.class_331;
import b.CharOperation;
import f.class_327;
import java.util.Iterator;
import java.util.HashMap;
import h.class_114;
import h.class_121;
import h.class_123;
import h.class_125;
import h.class_146;
import h.class_89;
import h.class_93;
import h.class_96;
import java.util.Hashtable;
import m.class_17;
import m.class_200;
import m.class_34;
import m.class_38;
import m.class_40;
import m.class_42;
import m.class_43;
import m.class_45;
import m.class_46;
import m.class_52;
import m.class_58;
import m.class_60;
import m.class_65;
import m.class_67;
import m.class_68;
import m.class_81;
import m.class_84;
import m.class_85;
import m.class_86;
import m.class_87;

public class class_54 extends class_43 {

    public class_43 field_252;

    public class_43[] field_253;

    private class_67[] field_254;

    private class_58[] field_255;

    public class_43[] field_256;

    public class_46[] field_257;

    public class_84 field_258;

    HashMap[] field_259;

    char[] field_260;

    private class_327 field_261;

    public class_54(char[][] var1, class_38 var2, class_84 var3) {
        this.field_261 = null;
        this.field_197 = var1;
        this.field_200 = var2;
        this.field_201 = var3.method_645().method_771();
        this.field_199 = var3.field_376.field_577;
        this.field_198 = var3.field_376.field_580;
        this.field_258 = var3;
        this.field_254 = class_34.field_160;
        this.field_255 = class_34.field_161;
        this.method_198();
    }

    private void method_292() {
        if ((this.field_178 & 1024L) == 0L) {
            this.field_178 |= 1024L;
            if (this.method_151() && this.method_217()) {
                if (this.field_258.method_577().field_1929 >= 3014656L) {
                    return;
                }
                class_43[] var1 = this.method_241();
                if (var1 != class_34.field_155) {
                    class_58[] var2 = null;
                    int var3 = 0;
                    class_43[] var4 = var1;
                    int var5 = var1.length;
                    int var6;
                    for (var6 = 0; var6 < var5; ++var6) {
                        class_43 var7 = var4[var6];
                        if (var7.method_101()) {
                            class_58[] var8 = var7.method_232();
                            int var9 = var8.length;
                            label85:
                            while (true) {
                                --var9;
                                if (var9 < 0) {
                                    if ((var1 = var7.method_241()) != class_34.field_155) {
                                        var9 = var1.length;
                                        if (var5 + var9 >= var4.length) {
                                            System.arraycopy(var4, 0, var4 = new class_43[var5 + var9 + 5], 0, var5);
                                        }
                                        label67:
                                        for (int var13 = 0; var13 < var9; ++var13) {
                                            class_43 var16 = var1[var13];
                                            for (int var14 = 0; var14 < var5; ++var14) {
                                                if (var16 == var4[var14]) {
                                                    continue label67;
                                                }
                                            }
                                            var4[var5++] = var16;
                                        }
                                    }
                                    break;
                                }
                                class_58 var10 = var8[var9];
                                if (!this.method_216(var10)) {
                                    if (var3 == 0) {
                                        var2 = new class_58[5];
                                    } else {
                                        for (int var11 = 0; var11 < var3; ++var11) {
                                            class_58 var12 = var2[var11];
                                            if (CharOperation.method_1364(var12.field_274, var10.field_274) && var12.method_344(var10)) {
                                                continue label85;
                                            }
                                        }
                                    }
                                    class_58 var10000 = new class_58(var10.field_273 | 524288 | 4096, var10.field_274, var10.field_275, var10.field_276, var10.field_277, this);
                                    class_58 var15 = var10000;
                                    if (var3 == var2.length) {
                                        System.arraycopy(var2, 0, var2 = new class_58[2 * var3], 0, var3);
                                    }
                                    var2[var3++] = var15;
                                }
                            }
                        }
                    }
                    if (var3 > 0) {
                        var6 = this.field_255.length;
                        System.arraycopy(this.field_255, 0, this.field_255 = new class_58[var6 + var3], 0, var6);
                        System.arraycopy(var2, 0, this.field_255, var6, var3);
                        var6 += var3;
                        if (var6 > 1) {
                            class_43.method_193(this.field_255, 0, var6);
                        }
                    }
                }
            }
        }
    }

    public class_67 method_293(class_65 var1) {
        if (this.field_259 == null) {
            this.field_259 = new HashMap[4];
        }
        if (this.field_259[1] == null) {
            HashMap[] var10000 = this.field_259;
            HashMap var10002 = new HashMap(5);
            var10000[1] = var10002;
        }
        Object var2 = (class_67)this.field_259[1].get(var1);
        if (var2 == null) {
            class_68 var11 = new class_68(CharOperation.method_1355(class_17.field_141, var1.field_302), var1.field_301, 4114, this, class_331.field_1896, this.field_259[1].size());
            var2 = var11;
            this.field_259[1].put(var1, var2);
        }
        int var4 = 1;
        boolean var3;
        do {
            var3 = false;
            class_67 var5;
            if ((var5 = this.method_208(((class_67)var2).field_302, true)) != null) {
                class_114 var6 = this.field_258.field_376;
                int var7 = 0;
                for (int var8 = var6.field_583.length; var7 < var8; ++var7) {
                    class_121 var9 = var6.field_583[var7];
                    if (var9.field_661 == var5) {
                        ((class_67)var2).field_302 = CharOperation.method_1356(class_17.field_141, var1.field_302, ("$" + String.valueOf(var4++)).toCharArray());
                        var3 = true;
                        break;
                    }
                }
            }
        } while (var3);
        return (class_67)var2;
    }

    public class_67 method_294(class_43 var1) {
        if (this.field_259 == null) {
            this.field_259 = new HashMap[4];
        }
        if (this.field_259[1] == null) {
            HashMap[] var10000 = this.field_259;
            HashMap var10002 = new HashMap(5);
            var10000[1] = var10002;
        }
        Object var2 = (class_67)this.field_259[1].get(var1);
        if (var2 == null) {
            class_68 var9 = new class_68(CharOperation.method_1355(class_17.field_142, String.valueOf(var1.method_199()).toCharArray()), var1, 4112, this, class_331.field_1896, this.field_259[1].size());
            var2 = var9;
            this.field_259[1].put(var1, var2);
        }
        boolean var3;
        do {
            var3 = false;
            class_67 var4;
            if ((var4 = this.method_208(((class_67)var2).field_302, true)) != null) {
                class_114 var5 = this.field_258.field_376;
                int var6 = 0;
                for (int var7 = var5.field_583.length; var6 < var7; ++var6) {
                    class_121 var8 = var5.field_583[var6];
                    if (var8.field_661 == var4) {
                        if (this.field_258.method_577().field_1927 >= 3211264L) {
                            ((class_67)var2).field_302 = CharOperation.method_1355(((class_67)var2).field_302, "$".toCharArray());
                            var3 = true;
                        } else {
                            this.field_258.method_644().method_1524(this, var8);
                        }
                        break;
                    }
                }
            }
        } while (var3);
        return (class_67)var2;
    }

    public class_67 method_295(class_40 var1, class_86 var2) {
        if (this.field_259 == null) {
            this.field_259 = new HashMap[4];
        }
        if (this.field_259[2] == null) {
            HashMap[] var10000 = this.field_259;
            HashMap var10002 = new HashMap(5);
            var10000[2] = var10002;
        }
        Object var3 = (class_67)this.field_259[2].get(var1);
        if (var3 == null) {
            class_68 var9 = new class_68(CharOperation.method_1355(class_17.field_140, String.valueOf(this.field_259[2].size()).toCharArray()), var2.method_606(), 4104, this, class_331.field_1896, this.field_259[2].size());
            var3 = var9;
            this.field_259[2].put(var1, var3);
        }
        class_67 var4;
        if ((var4 = this.method_208(((class_67)var3).field_302, true)) != null) {
            class_114 var5 = var2.method_718();
            int var6 = 0;
            for (int var7 = var5.field_583.length; var6 < var7; ++var6) {
                class_121 var8 = var5.field_583[var6];
                if (var8.field_661 == var4) {
                    var2.method_644().method_1524(this, var8);
                    break;
                }
            }
        }
        return (class_67)var3;
    }

    public class_67 method_296(class_86 var1) {
        if (this.field_259 == null) {
            this.field_259 = new HashMap[4];
        }
        if (this.field_259[1] == null) {
            HashMap[] var10000 = this.field_259;
            HashMap var10002 = new HashMap(5);
            var10000[1] = var10002;
        }
        Object var2 = (class_67)this.field_259[1].get("assertionEmulation");
        if (var2 == null) {
            class_68 var11 = new class_68(class_17.field_139, class_40.field_186, 4120, this, class_331.field_1896, this.field_259[1].size());
            var2 = var11;
            this.field_259[1].put("assertionEmulation", var2);
        }
        int var4 = 0;
        boolean var3;
        do {
            var3 = false;
            class_67 var5;
            if ((var5 = this.method_208(((class_67)var2).field_302, true)) != null) {
                class_114 var6 = this.field_258.field_376;
                int var7 = 0;
                for (int var8 = var6.field_583.length; var7 < var8; ++var7) {
                    class_121 var9 = var6.field_583[var7];
                    if (var9.field_661 == var5) {
                        ((class_67)var2).field_302 = CharOperation.method_1355(class_17.field_139, ("_" + String.valueOf(var4++)).toCharArray());
                        var3 = true;
                        break;
                    }
                }
            }
        } while (var3);
        return (class_67)var2;
    }

    public class_67 method_297() {
        if (this.field_259 == null) {
            this.field_259 = new HashMap[4];
        }
        if (this.field_259[1] == null) {
            HashMap[] var10000 = this.field_259;
            HashMap var10002 = new HashMap(5);
            var10000[1] = var10002;
        }
        Object var1 = (class_67)this.field_259[1].get("enumConstantValues");
        if (var1 == null) {
            class_68 var10 = new class_68(class_17.field_138, this.field_258.method_580(this, 1), 4122, this, class_331.field_1896, this.field_259[1].size());
            var1 = var10;
            this.field_259[1].put("enumConstantValues", var1);
        }
        int var3 = 0;
        boolean var2;
        do {
            var2 = false;
            class_67 var4;
            if ((var4 = this.method_208(((class_67)var1).field_302, true)) != null) {
                class_114 var5 = this.field_258.field_376;
                int var6 = 0;
                for (int var7 = var5.field_583.length; var6 < var7; ++var6) {
                    class_121 var8 = var5.field_583[var6];
                    if (var8.field_661 == var4) {
                        ((class_67)var1).field_302 = CharOperation.method_1355(class_17.field_138, ("_" + String.valueOf(var3++)).toCharArray());
                        var2 = true;
                        break;
                    }
                }
            }
        } while (var2);
        return (class_67)var1;
    }

    public class_60 method_298(class_67 var1, boolean var2) {
        if (this.field_259 == null) {
            this.field_259 = new HashMap[4];
        }
        if (this.field_259[0] == null) {
            HashMap[] var10000 = this.field_259;
            HashMap var10002 = new HashMap(5);
            var10000[0] = var10002;
        }
        class_60 var3 = null;
        class_60[] var4 = (class_60[])((class_60[])this.field_259[0].get(var1));
        class_60 var5;
        if (var4 == null) {
            var5 = new class_60(var1, var2, this);
            var3 = var5;
            this.field_259[0].put(var1, var4 = new class_60[2]);
            var4[var2 ? 0 : 1] = var3;
        } else if ((var3 = var4[var2 ? 0 : 1]) == null) {
            var5 = new class_60(var1, var2, this);
            var3 = var5;
            var4[var2 ? 0 : 1] = var3;
        }
        return var3;
    }

    public class_60 method_299(char[] var1) {
        if (this.field_259 == null) {
            this.field_259 = new HashMap[4];
        }
        if (this.field_259[0] == null) {
            HashMap[] var10000 = this.field_259;
            HashMap var10002 = new HashMap(5);
            var10000[0] = var10002;
        }
        class_60 var2 = null;
        class_60[] var3 = (class_60[])((class_60[])this.field_259[0].get(var1));
        class_60 var4;
        if (var3 == null) {
            var4 = new class_60(this, var1);
            var2 = var4;
            this.field_259[0].put(var1, var3 = new class_60[2]);
            var3[0] = var2;
        } else if ((var2 = var3[0]) == null) {
            var4 = new class_60(this, var1);
            var2 = var4;
            var3[0] = var2;
        }
        return var2;
    }

    public class_68 method_300(char[] var1, String var2) {
        if (this.field_259 == null) {
            this.field_259 = new HashMap[4];
        }
        if (this.field_259[1] == null) {
            HashMap[] var10000 = this.field_259;
            HashMap var10002 = new HashMap(5);
            var10000[1] = var10002;
        }
        class_68 var3 = (class_68)this.field_259[1].get(var2);
        if (var3 == null) {
            class_68 var12 = new class_68(var1, this.field_258.method_580(class_40.field_179, 1), 4106, this, class_331.field_1896, this.field_259[1].size());
            var3 = var12;
            this.field_259[1].put(var2, var3);
        }
        int var5 = 0;
        boolean var4;
        do {
            var4 = false;
            class_67 var6;
            if ((var6 = this.method_208(var3.field_302, true)) != null) {
                class_114 var7 = this.field_258.field_376;
                int var8 = 0;
                for (int var9 = var7.field_583.length; var8 < var9; ++var8) {
                    class_121 var10 = var7.field_583[var8];
                    if (var10.field_661 == var6) {
                        var3.field_302 = CharOperation.method_1355(var1, ("_" + String.valueOf(var5++)).toCharArray());
                        var4 = true;
                        break;
                    }
                }
            }
        } while (var4);
        return var3;
    }

    public class_60 method_301(class_40 var1) {
        if (this.field_259 == null) {
            this.field_259 = new HashMap[4];
        }
        if (this.field_259[0] == null) {
            HashMap[] var10000 = this.field_259;
            HashMap var10002 = new HashMap(5);
            var10000[0] = var10002;
        }
        class_60 var2 = null;
        char[] var3 = CharOperation.method_1355(class_17.field_137, var1.method_134());
        CharOperation.method_1382(var3, '/', '$');
        String var4 = new String(var3);
        class_60[] var5 = (class_60[])((class_60[])this.field_259[0].get(var4));
        class_68 var6;
        class_60 var7;
        if (var5 == null) {
            var6 = this.method_300(var3, var4);
            var7 = new class_60(var6, this, var1, var3);
            var2 = var7;
            this.field_259[0].put(var4, var5 = new class_60[2]);
            var5[0] = var2;
        } else if ((var2 = var5[0]) == null) {
            var6 = this.method_300(var3, var4);
            var7 = new class_60(var6, this, var1, var3);
            var2 = var7;
            var5[0] = var2;
        }
        return var2;
    }

    public class_60 method_302(class_58 var1, boolean var2) {
        if (this.field_259 == null) {
            this.field_259 = new HashMap[4];
        }
        if (this.field_259[0] == null) {
            HashMap[] var10000 = this.field_259;
            HashMap var10002 = new HashMap(5);
            var10000[0] = var10002;
        }
        class_60 var3 = null;
        class_60[] var4 = (class_60[])((class_60[])this.field_259[0].get(var1));
        class_60 var5;
        if (var4 == null) {
            var5 = new class_60(var1, var2, this);
            var3 = var5;
            this.field_259[0].put(var1, var4 = new class_60[2]);
            var4[var2 ? 0 : 1] = var3;
        } else if ((var3 = var4[var2 ? 0 : 1]) == null) {
            var5 = new class_60(var1, var2, this);
            var3 = var5;
            var4[var2 ? 0 : 1] = var3;
        }
        return var3;
    }

    public class_60 method_303(class_58 var1, class_58 var2) {
        if (this.method_157()) {
            return null;
        } else if (var1.field_275.method_138() == var2.field_275.method_138() && var1.method_342(var2)) {
            return null;
        } else {
            if (this.field_259 == null) {
                this.field_259 = new HashMap[4];
            }
            Iterator var3;
            if (this.field_259[0] == null) {
                HashMap[] var10000 = this.field_259;
                HashMap var10002 = new HashMap(5);
                var10000[0] = var10002;
            } else {
                var3 = this.field_259[0].keySet().iterator();
                while (var3.hasNext()) {
                    Object var4 = var3.next();
                    if (var4 instanceof class_58) {
                        class_58 var5 = (class_58)var4;
                        if (CharOperation.method_1364(var1.field_274, var5.field_274) && var1.field_275.method_138() == var5.field_275.method_138() && var1.method_342(var5)) {
                            return null;
                        }
                    }
                }
            }
            var3 = null;
            class_60[] var8 = (class_60[])((class_60[])this.field_259[0].get(var1));
            class_60 var6;
            class_60 var7;
            if (var8 == null) {
                var7 = new class_60(var1, var2, this);
                var6 = var7;
                this.field_259[0].put(var1, var8 = new class_60[2]);
                var8[1] = var6;
            } else if ((var6 = var8[1]) == null) {
                var7 = new class_60(var1, var2, this);
                var6 = var7;
                var8[1] = var6;
            }
            return var6;
        }
    }

    boolean method_304() {
        return this.field_254 != class_34.field_160;
    }

    boolean method_305() {
        return this.field_255 != class_34.field_161;
    }

    public int method_98() {
        return this.field_257 != class_34.field_157 ? 2052 : 4;
    }

    void method_306() {
        this.method_99();
        class_43 var1 = this.method_137();
        if (var1 != null && var1.method_230() && !this.method_220()) {
            this.field_199 |= 2097152;
        }
        this.method_204();
        this.method_232();
        int var2 = 0;
        for (int var3 = this.field_256.length; var2 < var3; ++var2) {
            ((class_54)this.field_256[var2]).method_306();
        }
    }

    public class_67[] method_204() {
        if ((this.field_178 & 8192L) != 0L) {
            return this.field_254;
        } else {
            int var1 = 0;
            class_67[] var2 = this.field_254;
            try {
                int var3;
                if ((this.field_178 & 4096L) == 0L) {
                    var3 = this.field_254.length;
                    if (var3 > 1) {
                        class_43.method_192(this.field_254, 0, var3);
                    }
                    this.field_178 |= 4096L;
                }
                var3 = 0;
                for (int var4 = this.field_254.length; var3 < var4; ++var3) {
                    if (this.method_313(this.field_254[var3]) == null) {
                        if (var2 == this.field_254) {
                            System.arraycopy(this.field_254, 0, var2 = new class_67[var4], 0, var4);
                        }
                        var2[var3] = null;
                        ++var1;
                    }
                }
            } finally {
                if (var1 > 0) {
                    int var7 = var2.length - var1;
                    if (var7 == 0) {
                        return this.field_254 = class_34.field_153;
                    }
                    class_67[] var8 = new class_67[var7];
                    int var9 = 0;
                    int var10 = 0;
                    for (int var11 = var2.length; var9 < var11; ++var9) {
                        if (var2[var9] != null) {
                            var8[var10++] = var2[var9];
                        }
                    }
                    this.field_254 = var8;
                }
            }
            this.field_178 |= 8192L;
            return this.field_254;
        }
    }

    public char[] method_142() {
        if (this.field_260 == null) {
            this.field_260 = this.method_197(this.field_257);
        }
        return this.field_260;
    }

    public char[] method_307() {
        StringBuffer var1 = null;
        int var2;
        int var3;
        if (this.field_257 != class_34.field_157) {
            var1 = new StringBuffer(10);
            var1.append('<');
            var2 = 0;
            for (var3 = this.field_257.length; var2 < var3; ++var2) {
                var1.append(this.field_257[var2].method_256());
            }
            var1.append('>');
        } else {
            if (this.field_252 == null || !this.field_252.method_162()) {
                var2 = 0;
                var3 = this.field_253.length;
                while (true) {
                    if (var2 >= var3) {
                        return null;
                    }
                    if (this.field_253[var2].method_162()) {
                        break;
                    }
                    ++var2;
                }
            }
            var1 = new StringBuffer(10);
        }
        if (this.field_252 != null) {
            var1.append(this.field_252.method_142());
        } else {
            var1.append(this.field_258.method_609().method_142());
        }
        var2 = 0;
        for (var3 = this.field_253.length; var2 < var3; ++var2) {
            var1.append(this.field_253[var2].method_142());
        }
        return var1.toString().toCharArray();
    }

    public long method_99() {
        if ((this.field_178 & 8589934592L) == 0L && this.field_258 != null) {
            class_114 var1 = this.field_258.field_376;
            boolean var2 = var1.field_589.field_412;
            try {
                var1.field_589.field_412 = true;
                class_89.method_761(var1.field_589, var1.field_579, this);
            } finally {
                var1.field_589.field_412 = var2;
            }
            if ((this.field_178 & 70368744177664L) != 0L) {
                this.field_199 |= 1048576;
            }
        }
        return this.field_178;
    }

    public class_58[] method_308() {
        int var1 = 0;
        int var2 = this.field_255.length;
        while (true) {
            --var2;
            if (var2 < 0) {
                if (var1 == 0) {
                    return class_34.field_154;
                }
                class_58[] var4 = new class_58[var1];
                var1 = 0;
                int var3 = this.field_255.length;
                while (true) {
                    --var3;
                    if (var3 < 0) {
                        return var4;
                    }
                    if (this.field_255[var3].method_360()) {
                        var4[var1++] = this.field_255[var3];
                    }
                }
            }
            if (this.field_255[var2].method_360()) {
                ++var1;
            }
        }
    }

    public class_58 method_206(class_40[] var1) {
        int var2 = var1.length;
        long var3;
        int var5;
        int var6;
        class_58 var7;
        class_40[] var8;
        int var9;
        if ((this.field_178 & 32768L) != 0L) {
            if ((var3 = class_43.method_190(class_17.field_135, this.field_255)) >= 0L) {
                var5 = (int)var3;
                label60:
                for (var6 = (int)(var3 >> 32); var5 <= var6; ++var5) {
                    var7 = this.field_255[var5];
                    if (var7.field_276.length == var2) {
                        var8 = var7.field_276;
                        for (var9 = 0; var9 < var2; ++var9) {
                            if (var8[var9] != var1[var9]) {
                                continue label60;
                            }
                        }
                        return var7;
                    }
                }
            }
        } else {
            if ((this.field_178 & 16384L) == 0L) {
                int var10 = this.field_255.length;
                if (var10 > 1) {
                    class_43.method_193(this.field_255, 0, var10);
                }
                this.field_178 |= 16384L;
            }
            if ((var3 = class_43.method_190(class_17.field_135, this.field_255)) >= 0L) {
                var5 = (int)var3;
                label69:
                for (var6 = (int)(var3 >> 32); var5 <= var6; ++var5) {
                    var7 = this.field_255[var5];
                    if (this.method_314(var7) == null || var7.field_275 == null) {
                        this.method_232();
                        return this.method_206(var1);
                    }
                    if (var7.field_276.length == var2) {
                        var8 = var7.field_276;
                        for (var9 = 0; var9 < var2; ++var9) {
                            if (var8[var9] != var1[var9]) {
                                continue label69;
                            }
                        }
                        return var7;
                    }
                }
            }
        }
        return null;
    }

    public class_58 method_207(char[] var1, class_40[] var2, class_85 var3) {
        int var4 = var2.length;
        boolean var5 = true;
        long var6;
        int var8;
        int var9;
        if ((this.field_178 & 32768L) != 0L) {
            if ((var6 = class_43.method_190(var1, this.field_255)) >= 0L) {
                var8 = (int)var6;
                label119:
                for (var9 = (int)(var6 >> 32); var8 <= var9; ++var8) {
                    class_58 var10 = this.field_255[var8];
                    var5 = false;
                    if (var10.field_276.length == var4) {
                        class_40[] var11 = var10.field_276;
                        for (int var12 = 0; var12 < var4; ++var12) {
                            if (var11[var12] != var2[var12]) {
                                continue label119;
                            }
                        }
                        return var10;
                    }
                }
            }
        } else {
            if ((this.field_178 & 16384L) == 0L) {
                int var16 = this.field_255.length;
                if (var16 > 1) {
                    class_43.method_193(this.field_255, 0, var16);
                }
                this.field_178 |= 16384L;
            }
            if ((var6 = class_43.method_190(var1, this.field_255)) >= 0L) {
                var8 = (int)var6;
                var9 = (int)(var6 >> 32);
                int var18 = var8;
                label128:
                while (true) {
                    if (var18 <= var9) {
                        class_58 var21 = this.field_255[var18];
                        if (this.method_314(var21) != null && var21.field_275 != null) {
                            ++var18;
                            continue;
                        }
                        this.method_232();
                        return this.method_207(var1, var2, var3);
                    }
                    boolean var19 = this.field_258.method_577().field_1928 >= 3211264L;
                    int var17;
                    class_58 var20;
                    for (var17 = var8; var17 <= var9; ++var17) {
                        var20 = this.field_255[var17];
                        for (int var13 = var9; var13 > var17; --var13) {
                            class_58 var14 = this.field_255[var13];
                            boolean var15 = var19 ? var20.method_342(var14) : var20.method_344(var14);
                            if (var15) {
                                this.method_232();
                                return this.method_207(var1, var2, var3);
                            }
                        }
                    }
                    var17 = var8;
                    while (true) {
                        if (var17 > var9) {
                            break label128;
                        }
                        var20 = this.field_255[var17];
                        class_40[] var22 = var20.field_276;
                        if (var22.length == var4) {
                            int var23 = 0;
                            while (true) {
                                if (var23 >= var4) {
                                    return var20;
                                }
                                if (var22[var23] != var2[var23]) {
                                    break;
                                }
                                ++var23;
                            }
                        }
                        ++var17;
                    }
                }
            }
        }
        if (var5) {
            if (this.method_157()) {
                if (this.field_253.length == 1) {
                    if (var3 != null) {
                        var3.method_693(this.field_253[0]);
                    }
                    return this.field_253[0].method_207(var1, var2, var3);
                }
            } else if (this.field_252 != null) {
                if (var3 != null) {
                    var3.method_693(this.field_252);
                }
                return this.field_252.method_207(var1, var2, var3);
            }
        }
        return null;
    }

    public class_67 method_208(char[] var1, boolean var2) {
        if ((this.field_178 & 8192L) != 0L) {
            return class_43.method_189(var1, this.field_254);
        } else {
            if ((this.field_178 & 4096L) == 0L) {
                int var3 = this.field_254.length;
                if (var3 > 1) {
                    class_43.method_192(this.field_254, 0, var3);
                }
                this.field_178 |= 4096L;
            }
            class_67 var16 = class_43.method_189(var1, this.field_254);
            if (var16 != null) {
                class_67 var4 = null;
                class_67 var5;
                try {
                    var4 = (class_67) this.method_313(var16);
                    var5 = var4;
                } finally {
                    if (var4 == null) {
                        int var8 = this.field_254.length - 1;
                        if (var8 == 0) {
                            this.field_254 = class_34.field_153;
                        } else {
                            class_67[] var9 = new class_67[var8];
                            int var10 = 0;
                            int var11 = 0;
                            for (int var12 = this.field_254.length; var11 < var12; ++var11) {
                                class_67 var13 = this.field_254[var11];
                                if (var13 != var16) {
                                    var9[var10++] = var13;
                                }
                            }
                            this.field_254 = var9;
                        }
                    }
                }
                return var5;
            } else {
                return null;
            }
        }
    }

    public class_58[] method_210(char[] var1) {
        int var5;
        int var6;
        if ((this.field_178 & 32768L) != 0L) {
            long var12;
            if ((var12 = class_43.method_190(var1, this.field_255)) >= 0L) {
                int var4 = (int)var12;
                var5 = (int)(var12 >> 32);
                var6 = var5 - var4 + 1;
                class_58[] var14;
                System.arraycopy(this.field_255, var4, var14 = new class_58[var6], 0, var6);
                return var14;
            } else {
                return class_34.field_154;
            }
        } else {
            if ((this.field_178 & 16384L) == 0L) {
                int var2 = this.field_255.length;
                if (var2 > 1) {
                    class_43.method_193(this.field_255, 0, var2);
                }
                this.field_178 |= 16384L;
            }
            long var3;
            if ((var3 = class_43.method_190(var1, this.field_255)) < 0L) {
                return class_34.field_154;
            } else {
                var5 = (int)var3;
                var6 = (int)(var3 >> 32);
                int var7;
                class_58 var8;
                for (var7 = var5; var7 <= var6; ++var7) {
                    var8 = this.field_255[var7];
                    if (this.method_314(var8) == null || var8.field_275 == null) {
                        this.method_232();
                        return this.method_210(var1);
                    }
                }
                var7 = var6 - var5 + 1;
                class_58[] var11;
                System.arraycopy(this.field_255, var5, var11 = new class_58[var7], 0, var7);
                boolean var13 = this.field_258.method_577().field_1928 >= 3211264L;
                var6 = 0;
                for (var7 = var11.length - 1; var6 < var7; ++var6) {
                    var8 = var11[var6];
                    for (int var9 = var7; var9 > var6; --var9) {
                        boolean var10 = var13 ? var8.method_342(var11[var9]) : var8.method_344(var11[var9]);
                        if (var10) {
                            this.method_232();
                            return this.method_210(var1);
                        }
                    }
                }
                return var11;
            }
        }
    }

    public class_67 method_309(class_65 var1) {
        return this.field_259 != null && this.field_259[1] != null ? (class_67)this.field_259[1].get(var1) : null;
    }

    public class_67 method_310(class_43 var1, boolean var2) {
        if (this.field_259 != null && this.field_259[1] != null) {
            class_67 var3 = (class_67)this.field_259[1].get(var1);
            if (var3 != null) {
                return var3;
            } else {
                if (!var2) {
                    Iterator var4 = this.field_259[1].values().iterator();
                    while (var4.hasNext()) {
                        var3 = (class_67)var4.next();
                        if (CharOperation.method_1381(class_17.field_142, var3.field_302) && var3.field_301.method_140(var1) != null) {
                            return var3;
                        }
                    }
                }
                return null;
            }
        } else {
            return null;
        }
    }

    public void method_100() {
        if ((this.field_178 & 17179869184L) == 0L) {
            class_114 var1 = this.field_258.field_376;
            boolean var2 = var1.field_589.field_412;
            try {
                var1.field_589.field_412 = true;
                class_89.method_762(var1.field_589, var1.field_579, this);
                this.field_178 |= 17179869184L;
            } finally {
                var1.field_589.field_412 = var2;
            }
            if ((this.field_178 & 70368744177664L) != 0L) {
                this.field_199 |= 1048576;
            }
        }
    }

    void method_144() {
        if (this.field_258 != null) {
            if (this.field_253 == null) {
                this.field_258.method_666();
            }
            this.field_258.method_649();
            this.field_258.method_654();
        }
    }

    public boolean method_154(class_40 var1) {
        if (this == var1) {
            return true;
        } else if (var1 == null) {
            return false;
        } else {
            switch (var1.method_98()) {
                case 260:
                    if ((var1.field_178 & 1073741824L) == 0L && (!this.method_159() || !var1.method_159())) {
                        return false;
                    } else {
                        class_52 var2 = (class_52)var1;
                        if (this != var2.method_286()) {
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
                            int var7 = this.field_257 == null ? 0 : this.field_257.length;
                            class_40[] var8 = var2.field_243;
                            int var5 = var8 == null ? 0 : var8.length;
                            if (var5 != var7) {
                                return false;
                            } else {
                                for (int var6 = 0; var6 < var7; ++var6) {
                                    if (!this.field_257[var6].method_168(var8[var6])) {
                                        return false;
                                    }
                                }
                                return true;
                            }
                        }
                    }
                case 516:
                case 8196:
                    return ((class_45)var1).method_250(this);
                case 1028:
                    return var1.method_138() == this;
                default:
                    return false;
            }
        }
    }

    public boolean method_155() {
        return this.field_257 != class_34.field_157;
    }

    public class_43[] method_231() {
        return this.field_256;
    }

    public class_67 method_311(class_67 var1, class_43 var2) {
        if (this.field_259 == null) {
            this.field_259 = new HashMap[4];
        }
        if (this.field_259[3] == null) {
            HashMap[] var10000 = this.field_259;
            HashMap var10002 = new HashMap(5);
            var10000[3] = var10002;
        }
        Hashtable var3 = (Hashtable)this.field_259[3].get(var1);
        if (var3 == null) {
            var3 = new Hashtable(5);
            this.field_259[3].put(var1, var3);
        }
        class_67 var4 = (class_67)var3.get(var2);
        if (var4 == null) {
            class_67 var5 = new class_67(var1, var2);
            var4 = var5;
            var3.put(var2, var4);
        }
        return var4;
    }

    public class_58 method_312(class_58 var1, class_43 var2) {
        if (this.field_259 == null) {
            this.field_259 = new HashMap[4];
        }
        if (this.field_259[3] == null) {
            HashMap[] var10000 = this.field_259;
            HashMap var10002 = new HashMap(5);
            var10000[3] = var10002;
        }
        Hashtable var3 = (Hashtable)this.field_259[3].get(var1);
        if (var3 == null) {
            var3 = new Hashtable(5);
            this.field_259[3].put(var1, var3);
        }
        class_58 var4 = (class_58)var3.get(var2);
        if (var4 == null) {
            class_58 var5 = new class_58(var1, var2);
            var4 = var5;
            var3.put(var2, var4);
        }
        return var4;
    }

    public boolean method_213() {
        return this.field_256.length > 0;
    }

    public class_58[] method_232() {
        if ((this.field_178 & 32768L) != 0L) {
            return this.field_255;
        } else {
            int var1;
            if ((this.field_178 & 16384L) == 0L) {
                var1 = this.field_255.length;
                if (var1 > 1) {
                    class_43.method_193(this.field_255, 0, var1);
                }
                this.field_178 |= 16384L;
            }
            var1 = 0;
            class_58[] var2 = this.field_255;
            try {
                int var3 = 0;
                int var4;
                for (var4 = this.field_255.length; var3 < var4; ++var3) {
                    if (this.method_314(this.field_255[var3]) == null) {
                        if (var2 == this.field_255) {
                            System.arraycopy(this.field_255, 0, var2 = new class_58[var4], 0, var4);
                        }
                        var2[var3] = null;
                        ++var1;
                    }
                }
                boolean var30 = this.field_258.method_577().field_1928 >= 3211264L;
                var4 = 0;
                for (int var5 = this.field_255.length; var4 < var5; ++var4) {
                    class_58 var6 = var2[var4];
                    if (var6 != null) {
                        char[] var7 = var6.field_274;
                        class_93 var8 = null;
                        for (int var9 = var4 + 1; var9 < var5; ++var9) {
                            class_58 var10 = var2[var9];
                            if (var10 != null) {
                                if (!CharOperation.method_1364(var7, var10.field_274)) {
                                    break;
                                }
                                if (var30 && var6.field_275 != null && var10.field_275 != null) {
                                    class_40[] var11 = var6.field_276;
                                    class_40[] var12 = var10.field_276;
                                    int var13 = var11.length;
                                    if (var13 != var12.length) {
                                        continue;
                                    }
                                    class_46[] var14 = var6.field_279;
                                    class_46[] var15 = var10.field_279;
                                    boolean var16 = var14 == var15;
                                    class_58 var17 = var10;
                                    if (!var16) {
                                        class_58 var18 = var6.method_349(var10, this.field_258.method_586());
                                        if (var18 != null) {
                                            var16 = true;
                                            var17 = var18;
                                        }
                                    }
                                    boolean var33 = var6.method_344(var17);
                                    if ((!var33 || !var16) && (var6.field_275.method_138() != var17.field_275.method_138() || !var33 && !var6.method_342(var10))) {
                                        if (!var16 && var14 != class_34.field_157 && var15 != class_34.field_157) {
                                            continue;
                                        }
                                        if (var13 > 0) {
                                            int var19 = var13;
                                            while (true) {
                                                --var19;
                                                if (var19 < 0 || var11[var19] != var12[var19].method_138()) {
                                                    break;
                                                }
                                                if (var11[var19] == var12[var19]) {
                                                    class_40 var20 = var11[var19].method_173();
                                                    if (var20 instanceof class_54 && var20.method_181() != class_34.field_157) {
                                                        var19 = var13;
                                                        break;
                                                    }
                                                }
                                            }
                                            if (var19 >= 0 && var19 < var13) {
                                                var19 = var13;
                                                do {
                                                    --var19;
                                                } while (var19 >= 0 && var11[var19].method_138() == var12[var19]);
                                            }
                                            if (var19 >= 0) {
                                                continue;
                                            }
                                        }
                                    }
                                } else if (!var6.method_344(var10)) {
                                    continue;
                                }
                                boolean var31 = this.method_153() && (CharOperation.method_1364(var7, class_17.field_72) || CharOperation.method_1364(var7, class_17.field_71));
                                if (var8 == null) {
                                    var8 = var6.method_384();
                                    if (var8 != null && var8.field_488 != null) {
                                        if (var31) {
                                            this.field_258.method_644().method_1523(this, var8);
                                        } else {
                                            this.field_258.method_644().method_1529(this, var8, var6.method_344(var10));
                                        }
                                        var8.field_488 = null;
                                        if (var2 == this.field_255) {
                                            System.arraycopy(this.field_255, 0, var2 = new class_58[var5], 0, var5);
                                        }
                                        var2[var4] = null;
                                        ++var1;
                                    }
                                }
                                class_93 var32 = var10.method_384();
                                if (var32 != null && var32.field_488 != null) {
                                    if (var31) {
                                        this.field_258.method_644().method_1523(this, var32);
                                    } else {
                                        this.field_258.method_644().method_1529(this, var32, var6.method_344(var10));
                                    }
                                    var32.field_488 = null;
                                    if (var2 == this.field_255) {
                                        System.arraycopy(this.field_255, 0, var2 = new class_58[var5], 0, var5);
                                    }
                                    var2[var9] = null;
                                    ++var1;
                                }
                            }
                        }
                        if (var6.field_275 == null && var8 == null) {
                            var8 = var6.method_384();
                            if (var8 != null) {
                                var8.field_488 = null;
                            }
                            if (var2 == this.field_255) {
                                System.arraycopy(this.field_255, 0, var2 = new class_58[var5], 0, var5);
                            }
                            var2[var4] = null;
                            ++var1;
                        }
                    }
                }
            } finally {
                if (var1 > 0) {
                    int var23 = var2.length - var1;
                    if (var23 == 0) {
                        this.field_255 = class_34.field_154;
                    } else {
                        class_58[] var24 = new class_58[var23];
                        int var25 = 0;
                        int var26 = 0;
                        for (int var27 = var2.length; var25 < var27; ++var25) {
                            if (var2[var25] != null) {
                                var24[var26++] = var2[var25];
                            }
                        }
                        this.field_255 = var24;
                    }
                }
                this.method_292();
                this.field_178 |= 32768L;
            }
            return this.field_255;
        }
    }

    private class_34 method_313(class_67 var1) {
        if ((var1.field_300 & 33554432) == 0) {
            return var1;
        } else {
            if (this.field_258.method_577().field_1928 >= 3211264L && (var1.method_99() & 70368744177664L) != 0L) {
                var1.field_300 |= 1048576;
            }
            if (this.method_230() && !var1.method_427()) {
                var1.field_300 |= 2097152;
            }
            if (this.method_214()) {
                var1.field_300 |= 262144;
            }
            class_121[] var2 = this.field_258.field_376.field_583;
            int var3 = 0;
            for (int var4 = var2.length; var3 < var4; ++var3) {
                if (var2[var3].field_661 == var1) {
                    class_87 var5 = var1.method_431() ? this.field_258.field_376.field_589 : this.field_258.field_376.field_588;
                    class_67 var6 = var5.field_406;
                    class_40 var9;
                    try {
                        var5.field_406 = var1;
                        class_121 var7 = var2[var3];
                        class_40 var8 = var7.method_887() == 3 ? var5.method_586().method_490(this, false) : var7.field_660.method_1017(var5, true);
                        var1.field_301 = var8;
                        var1.field_300 &= -33554433;
                        if (var8 == null) {
                            var7.field_661 = null;
                            var9 = null;
                            return var9;
                        }
                        if (var8 != class_40.field_188) {
                            if (var8.method_147() && ((class_42)var8).field_192 == class_40.field_188) {
                                this.field_258.method_644().method_1822(var7);
                                var7.field_661 = null;
                                var9 = null;
                                return var9;
                            }
                            if ((var8.field_178 & 128L) != 0L) {
                                var1.field_305 |= 128L;
                            }
                            var9 = var8.method_173();
                            if (var9 instanceof class_43 && (((class_43)var9).field_199 & 1073741824) != 0) {
                                var1.field_300 |= 1073741824;
                            }
                            return var1;
                        }
                        this.field_258.method_644().method_1821(var7);
                        var7.field_661 = null;
                        var9 = null;
                    } finally {
                        var5.field_406 = var6;
                    }
                    return var9;
                }
            }
            return null;
        }
    }

    public class_58 method_314(class_58 var1) {
        if ((var1.field_273 & 33554432) == 0) {
            return var1;
        } else {
            if (this.field_258.method_577().field_1928 >= 3211264L && (var1.method_99() & 70368744177664L) != 0L) {
                var1.field_273 |= 1048576;
            }
            if (this.method_230() && !var1.method_361()) {
                var1.field_273 |= 2097152;
            }
            if (this.method_214()) {
                var1.field_273 |= 262144;
            }
            class_93 var2 = var1.method_384();
            if (var2 == null) {
                return null;
            } else {
                class_123[] var3 = var2.method_807();
                int var5;
                if (var3 != null) {
                    var2.field_478.method_579(var3, true);
                    int var4 = 0;
                    for (var5 = var3.length; var4 < var5; ++var4) {
                        var3[var4].method_896(var2.field_478);
                    }
                }
                class_146[] var14 = var2.field_485;
                int var8;
                if (var14 != null) {
                    var5 = var14.length;
                    var1.field_277 = new class_43[var5];
                    int var6 = 0;
                    for (var8 = 0; var8 < var5; ++var8) {
                        class_43 var7 = (class_43)var14[var8].method_1017(var2.field_478, true);
                        if (var7 != null) {
                            if (var7.method_149()) {
                                var2.field_478.method_644().method_1637(var7, var14[var8]);
                            } else if (var7.method_139(21, true) == null && var7.method_101()) {
                                var2.field_478.method_644().method_1504(var14[var8], var7);
                            } else {
                                if ((var7.field_178 & 128L) != 0L) {
                                    var1.field_281 |= 128L;
                                }
                                var1.field_273 |= var7.field_199 & 1073741824;
                                var1.field_277[var6++] = var7;
                            }
                        }
                    }
                    if (var6 < var5) {
                        System.arraycopy(var1.field_277, 0, var1.field_277 = new class_43[var6], 0, var6);
                    }
                }
                boolean var15 = false;
                class_125[] var16 = var2.field_484;
                int var9;
                if (var16 != null) {
                    int var17 = var16.length;
                    var1.field_276 = class_34.field_150;
                    class_40[] var19 = new class_40[var17];
                    for (var9 = 0; var9 < var17; ++var9) {
                        class_125 var10 = var16[var9];
                        if (var10.field_658 != null) {
                            var1.field_281 |= 1024L;
                        }
                        class_40 var11 = var10.field_660.method_1017(var2.field_478, true);
                        if (var11 == null) {
                            var15 = true;
                        } else if (var11 == class_40.field_188) {
                            var2.field_478.method_644().method_1479(this, var2, var10);
                            var15 = true;
                        } else {
                            if ((var11.field_178 & 128L) != 0L) {
                                var1.field_281 |= 128L;
                            }
                            class_40 var12 = var11.method_173();
                            if (var12 instanceof class_43 && (((class_43)var12).field_199 & 1073741824) != 0) {
                                var1.field_273 |= 1073741824;
                            }
                            var19[var9] = var11;
                            class_65 var13 = new class_65(var10, var11, var10.field_656, true);
                            var10.field_670 = var13;
                        }
                    }
                    if (!var15) {
                        var1.field_276 = var19;
                    }
                }
                boolean var18 = false;
                if (!var1.method_358()) {
                    class_146 var20 = var2 instanceof class_96 ? ((class_96)var2).field_497 : null;
                    if (var20 == null) {
                        var2.field_478.method_644().method_1680(var2);
                        var1.field_275 = null;
                        var18 = true;
                    } else {
                        class_40 var21 = var20.method_1017(var2.field_478, true);
                        if (var21 == null) {
                            var18 = true;
                        } else if (var21.method_147() && ((class_42)var21).field_192 == class_40.field_188) {
                            var2.field_478.method_644().method_1752((class_96)var2);
                            var18 = true;
                        } else {
                            if ((var21.field_178 & 128L) != 0L) {
                                var1.field_281 |= 128L;
                            }
                            var1.field_275 = var21;
                            class_40 var22 = var21.method_173();
                            if (var22 instanceof class_43 && (((class_43)var22).field_199 & 1073741824) != 0) {
                                var1.field_273 |= 1073741824;
                            }
                        }
                    }
                }
                if (!var15) {
                    if (var18) {
                        return var1;
                    } else {
                        var1.field_273 &= -33554433;
                        return var1;
                    }
                } else {
                    var2.field_488 = null;
                    var1.field_276 = class_34.field_150;
                    if (var3 != null) {
                        var8 = 0;
                        for (var9 = var3.length; var8 < var9; ++var8) {
                            var3[var8].field_668 = null;
                        }
                    }
                    return null;
                }
            }
        }
    }

    public class_200 method_234(class_34 var1, boolean var2) {
        if (var2) {
            var1.method_99();
        }
        return super.method_234(var1, false);
    }

    public void method_315(class_67[] var1) {
        this.field_254 = var1;
    }

    public void method_316(class_58[] var1) {
        this.field_255 = var1;
    }

    public final int method_317() {
        return this.field_258.field_376.field_445;
    }

    public final int method_318() {
        return this.field_258.field_376.field_444;
    }

    class_327 method_239(boolean var1) {
        if (var1 && this.field_261 == null && this.field_258 != null) {
            this.field_258.method_645().field_455.field_1683 = true;
            if (!this.field_258.method_586().field_352.field_1963) {
                return null;
            }
            class_327 var10001 = new class_327(3);
            this.field_261 = var10001;
        }
        return this.field_261;
    }

    public class_43 method_240() {
        return this.field_252;
    }

    public class_43[] method_241() {
        return this.field_253;
    }

    public class_60[] method_319() {
        if (this.field_259 != null && this.field_259[0] != null && this.field_259[0].size() != 0) {
            int var1 = 0;
            class_60[] var2 = new class_60[1];
            Iterator var3 = this.field_259[0].keySet().iterator();
            class_60[] var5;
            int var6;
            while (var3.hasNext()) {
                Object var4 = var3.next();
                if (var4 instanceof class_58) {
                    var5 = (class_60[])((class_60[])this.field_259[0].get(var4));
                    var6 = 0;
                    if (var5[0] != null) {
                        ++var6;
                    }
                    if (var5[1] != null) {
                        ++var6;
                    }
                    if (var1 + var6 > var2.length) {
                        System.arraycopy(var2, 0, var2 = new class_60[var1 + var6], 0, var1);
                    }
                    if (var5[0] != null) {
                        var2[var1++] = var5[0];
                    }
                    if (var5[1] != null) {
                        var2[var1++] = var5[1];
                    }
                } else {
                    var5 = (class_60[])((class_60[])this.field_259[0].get(var4));
                    var6 = 0;
                    if (var5[0] != null) {
                        ++var6;
                    }
                    if (var5[1] != null) {
                        ++var6;
                    }
                    if (var1 + var6 > var2.length) {
                        System.arraycopy(var2, 0, var2 = new class_60[var1 + var6], 0, var1);
                    }
                    if (var5[0] != null) {
                        var2[var1++] = var5[0];
                    }
                    if (var5[1] != null) {
                        var2[var1++] = var5[1];
                    }
                }
            }
            int var8;
            var5 = new class_60[var8 = var2.length];
            for (var6 = 0; var6 < var8; ++var6) {
                class_60 var7 = var2[var6];
                var5[var7.field_289] = var7;
            }
            return var5;
        } else {
            return null;
        }
    }

    public class_67[] method_320() {
        if (this.field_259 == null) {
            return null;
        } else {
            int var1 = this.field_259[1] == null ? 0 : this.field_259[1].size();
            int var2 = this.field_259[2] == null ? 0 : this.field_259[2].size();
            int var3 = var1 + var2;
            if (var3 == 0) {
                return null;
            } else {
                class_67[] var4 = new class_67[var3];
                Iterator var5;
                int var6;
                class_68 var7;
                if (this.field_259[1] != null) {
                    var5 = this.field_259[1].values().iterator();
                    for (var6 = 0; var6 < var1; ++var6) {
                        var7 = (class_68)var5.next();
                        var4[var7.field_315] = var7;
                    }
                }
                if (this.field_259[2] != null) {
                    var5 = this.field_259[2].values().iterator();
                    for (var6 = 0; var6 < var2; ++var6) {
                        var7 = (class_68)var5.next();
                        var4[var1 + var7.field_315] = var7;
                    }
                }
                return var4;
            }
        }
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer(30);
        var1.append("(id=");
        if (this.field_177 == Integer.MAX_VALUE) {
            var1.append("NoId");
        } else {
            var1.append(this.field_177);
        }
        var1.append(")\n");
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
        var1.append(this.field_197 != null ? CharOperation.method_1389(this.field_197) : "UNNAMED TYPE");
        int var2;
        int var3;
        if (this.field_257 == null) {
            var1.append("<NULL TYPE VARIABLES>");
        } else if (this.field_257 != class_34.field_157) {
            var1.append("\n\t<");
            var2 = 0;
            for (var3 = this.field_257.length; var2 < var3; ++var2) {
                if (var2 > 0) {
                    var1.append(", ");
                }
                var1.append(this.field_257[var2] != null ? this.field_257[var2].toString() : "NULL TYPE VARIABLE");
            }
            var1.append(">");
        }
        var1.append("\n\textends ");
        var1.append(this.field_252 != null ? this.field_252.method_135() : "NULL TYPE");
        if (this.field_253 != null) {
            if (this.field_253 != class_34.field_155) {
                var1.append("\n\timplements : ");
                var2 = 0;
                for (var3 = this.field_253.length; var2 < var3; ++var2) {
                    if (var2 > 0) {
                        var1.append(", ");
                    }
                    var1.append(this.field_253[var2] != null ? this.field_253[var2].method_135() : "NULL TYPE");
                }
            }
        } else {
            var1.append("NULL SUPERINTERFACES");
        }
        if (this.method_137() != null) {
            var1.append("\n\tenclosing type : ");
            var1.append(this.method_137().method_135());
        }
        if (this.field_254 != null) {
            if (this.field_254 != class_34.field_153) {
                var1.append("\n/*   fields   */");
                var2 = 0;
                for (var3 = this.field_254.length; var2 < var3; ++var2) {
                    var1.append('\n').append(this.field_254[var2] != null ? this.field_254[var2].toString() : "NULL FIELD");
                }
            }
        } else {
            var1.append("NULL FIELDS");
        }
        if (this.field_255 != null) {
            if (this.field_255 != class_34.field_154) {
                var1.append("\n/*   methods   */");
                var2 = 0;
                for (var3 = this.field_255.length; var2 < var3; ++var2) {
                    var1.append('\n').append(this.field_255[var2] != null ? this.field_255[var2].toString() : "NULL METHOD");
                }
            }
        } else {
            var1.append("NULL METHODS");
        }
        if (this.field_256 != null) {
            if (this.field_256 != class_34.field_156) {
                var1.append("\n/*   members   */");
                var2 = 0;
                for (var3 = this.field_256.length; var2 < var3; ++var2) {
                    var1.append('\n').append(this.field_256[var2] != null ? this.field_256[var2].toString() : "NULL TYPE");
                }
            }
        } else {
            var1.append("NULL MEMBER TYPES");
        }
        var1.append("\n\n");
        return var1.toString();
    }

    public class_46[] method_181() {
        return this.field_257;
    }

    void method_321(class_81 var1) {
        var1.method_556(this);
        int var2 = this.field_256.length;
        while (true) {
            --var2;
            if (var2 < 0) {
                return;
            }
            ((class_54)this.field_256[var2]).method_321(var1);
        }
    }
}
