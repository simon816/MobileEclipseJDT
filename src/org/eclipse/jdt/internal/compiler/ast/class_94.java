package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.core.compiler.CategorizedProblem;
import org.eclipse.jdt.internal.compiler.class_264;
import org.eclipse.jdt.internal.compiler.class_284;
import org.eclipse.jdt.internal.compiler.class_288;
import org.eclipse.jdt.internal.compiler.ast.class_105;
import org.eclipse.jdt.internal.compiler.ast.class_114;
import org.eclipse.jdt.internal.compiler.ast.class_121;
import org.eclipse.jdt.internal.compiler.ast.class_123;
import org.eclipse.jdt.internal.compiler.ast.class_158;
import org.eclipse.jdt.internal.compiler.ast.class_89;
import org.eclipse.jdt.internal.compiler.ast.class_90;
import org.eclipse.jdt.internal.compiler.ast.class_93;
import org.eclipse.jdt.internal.compiler.ast.class_98;
import org.eclipse.jdt.internal.compiler.codegen.class_268;
import org.eclipse.jdt.internal.compiler.flow.class_298;
import org.eclipse.jdt.internal.compiler.flow.class_299;
import org.eclipse.jdt.internal.compiler.flow.class_301;
import org.eclipse.jdt.internal.compiler.flow.class_303;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.class_43;
import org.eclipse.jdt.internal.compiler.lookup.class_54;
import org.eclipse.jdt.internal.compiler.lookup.class_55;
import org.eclipse.jdt.internal.compiler.lookup.class_58;
import org.eclipse.jdt.internal.compiler.lookup.class_65;
import org.eclipse.jdt.internal.compiler.lookup.class_66;
import org.eclipse.jdt.internal.compiler.lookup.class_67;
import org.eclipse.jdt.internal.compiler.lookup.class_84;
import org.eclipse.jdt.internal.compiler.lookup.class_87;
import org.eclipse.jdt.internal.compiler.parser.Parser;
import org.eclipse.jdt.internal.compiler.problem.class_244;

import java.util.ArrayList;

public class class_94 extends class_93 {

    public class_105 field_493;

    public class_123[] field_494;

    public class_94(class_284 var1) {
        super(var1);
    }

    public void method_786(class_84 var1, class_299 var2, class_301 var3) {
        this.method_808(var1, var2, var3, 0);
    }

    public void method_808(class_84 var1, class_299 var2, class_301 var3, int var4) {
        if (!this.field_489) {
            int var5 = var3.method_3102();
            var3.method_3104(var4);
            class_58 var6 = this.field_488;
            if (this.field_488 != null && (this.field_446 & 128) == 0 && !var6.method_373()) {
                label119: {
                    if (var6.method_367()) {
                        if ((this.field_488.field_278.field_178 & 4503599627370496L) == 0L) {
                            break label119;
                        }
                    } else if ((this.field_488.field_278.field_178 & 48L) != 16L) {
                        break label119;
                    }
                    this.field_478.method_644().method_1812(this);
                }
            }
            if (this.method_811((ArrayList)null)) {
                this.field_478.method_644().method_1743(this.field_493);
            }
            try {
                class_298 var10000 = new class_298(var2.field_1740, this, this.field_488.field_277, this.field_478, class_301.field_1784);
                class_298 var13 = var10000;
                var2.method_3067(this.field_478, var13, var3);
                int var8;
                if (this.field_488.field_278.method_146()) {
                    ArrayList var7 = var13.field_1771;
                    if (var7 != null && (var8 = var7.size()) > 0) {
                        class_43[] var9;
                        var7.toArray(var9 = new class_43[var8]);
                        this.field_488.field_277 = var9;
                    }
                }
                if (this.field_484 != null) {
                    int var14 = 0;
                    for (var8 = this.field_484.length; var14 < var8; ++var14) {
                        var3.method_3099(this.field_484[var14].field_670);
                    }
                }
                class_67 var10;
                class_67[] var15;
                int var17;
                if (this.field_493 != null) {
                    if (this.field_493.field_551 == 3) {
                        var15 = this.field_488.field_278.method_204();
                        var8 = 0;
                        for (var17 = var15.length; var8 < var17; ++var8) {
                            if (!(var10 = var15[var8]).method_431()) {
                                var3.method_3096(var10);
                            }
                        }
                    }
                    var3 = this.field_493.method_814(this.field_478, var13, var3);
                }
                var3.method_3104(var5);
                if (this.field_486 != null) {
                    boolean var16 = false;
                    var8 = 0;
                    for (var17 = this.field_486.length; var8 < var17; ++var8) {
                        class_98 var18 = this.field_486[var8];
                        if (!var18.method_816(var3, this.field_478, var16)) {
                            var3 = var18.method_814(this.field_478, var13, var3);
                        } else {
                            var16 = true;
                        }
                    }
                }
                if ((var3.field_1783 & 1) == 0) {
                    this.field_446 |= 64;
                }
                var3.method_3104(var4);
                if (this.field_493 != null && this.field_493.field_551 != 3) {
                    class_303 var12 = var3.method_3105(var13.field_1770);
                    var15 = this.field_488.field_278.method_204();
                    var8 = 0;
                    for (var17 = var15.length; var8 < var17; ++var8) {
                        if (!(var10 = var15[var8]).method_431() && var10.method_409() && !var12.method_3082(var15[var8])) {
                            class_89 var18;
                            if ((this.field_446 & 128) != 0) {
                                var18 = this.field_478.method_718();
                            } else {
                                var18 = this;
                            }
                            this.field_478.method_644().method_1788(var10, var18);
                        }
                    }
                }
                var13.method_3061(this);
                this.field_478.method_723(this.field_488);
            } catch (class_244 var11) {
                this.field_489 = true;
            }
        }
    }

    public void method_789(class_84 var1, class_288 var2) {
        byte var3 = 0;
        CategorizedProblem[] var6;
        if (this.field_489) {
            if (this.field_488 != null) {
                CategorizedProblem[] var12 = this.field_478.method_645().field_455.method_2922();
                int var4;
                var6 = new CategorizedProblem[var4 = var12.length];
                System.arraycopy(var12, 0, var6, 0, var4);
                var2.method_2967(this, this.field_488, var6);
            }
        } else {
            try {
                int var11 = var2.field_1719;
                this.method_810(var1, var2);
            } catch (class_244 var10) {
                CategorizedProblem[] var7;
                if (var10.field_1049 == class_268.field_1186) {
                    try {
                        var2.field_1719 = var3;
                        --var2.field_1725;
                        var2.field_1715.field_1216 = true;
                        this.method_810(var1, var2);
                    } catch (class_244 var9) {
                        var7 = this.field_478.method_645().field_455.method_2916();
                        int var13;
                        CategorizedProblem[] var8 = new CategorizedProblem[var13 = var7.length];
                        System.arraycopy(var7, 0, var8, 0, var13);
                        var2.method_2968(this, this.field_488, var8, var3);
                    }
                } else {
                    var6 = this.field_478.method_645().field_455.method_2916();
                    int var5;
                    var7 = new CategorizedProblem[var5 = var6.length];
                    System.arraycopy(var6, 0, var7, 0, var5);
                    var2.method_2968(this, this.field_488, var7, var3);
                }
            }
        }
    }

    public void method_809(class_87 var1, class_268 var2, class_43 var3) {
        if (var3.method_160()) {
            class_55 var4 = (class_55)var3;
            class_66[] var5 = var4.method_329();
            int var6 = 0;
            int var7;
            class_66 var8;
            for (var7 = var5 == null ? 0 : var5.length; var6 < var7; ++var6) {
                if ((var8 = var5[var6]).field_313 != null) {
                    var2.method_2093();
                    var2.method_2324(var8);
                    var2.method_2356(var8.field_313);
                }
            }
            var5 = var4.method_243();
            var6 = 0;
            for (var7 = var5 == null ? 0 : var5.length; var6 < var7; ++var6) {
                if ((var8 = var5[var6]).field_313 != null) {
                    var2.method_2093();
                    var2.method_2324(var8);
                    var2.method_2356(var8.field_313);
                }
            }
        }
    }

    private void method_810(class_84 var1, class_288 var2) {
        var2.method_2995(this.field_488);
        int var3 = var2.field_1719;
        int var4 = var2.method_2993(this.field_488);
        if (!this.field_488.method_365() && !this.field_488.method_356()) {
            class_114 var5 = var1.field_376;
            int var6 = var2.field_1719;
            var2.method_2989();
            class_268 var7 = var2.field_1715;
            var7.method_2366(this, var2);
            class_43 var8 = this.field_488.field_278;
            int var9 = var8.method_153() ? 2 : 0;
            int var10 = 1 + var9;
            if (var8.method_160()) {
                class_55 var11 = (class_55)var8;
                this.field_478.field_413 = var11.method_243();
                this.field_478.method_724(var11.field_265 + 1 + var9, var7);
                var10 += var11.field_265;
                var10 += var11.field_266;
            } else {
                this.field_478.method_724(1 + var9, var7);
            }
            if (this.field_484 != null) {
                int var17 = 0;
                for (int var12 = this.field_484.length; var17 < var12; ++var17) {
                    class_65 var13;
                    var7.method_2090(var13 = this.field_484[var17].field_670);
                    var13.method_415(0);
                    class_40 var14 = var13.field_301;
                    if (var13.field_301 != class_40.field_183 && var14 != class_40.field_185) {
                        ++var10;
                    } else {
                        var10 += 2;
                    }
                }
            }
            class_87 var19 = var5.field_588;
            var19.method_724(var10, var7);
            boolean var18 = this.field_493 == null || this.field_493.field_551 != 3;
            boolean var20 = this.field_478.method_577().field_1929 >= 3145728L;
            if (var18 && var20) {
                this.method_809(this.field_478, var7, var8);
            }
            if (this.field_493 != null) {
                this.field_493.method_818(this.field_478, var7);
            }
            int var15;
            int var21;
            if (var18) {
                if (!var20) {
                    this.method_809(this.field_478, var7, var8);
                }
                if (var5.field_583 != null) {
                    var21 = 0;
                    for (var15 = var5.field_583.length; var21 < var15; ++var21) {
                        class_121 var16;
                        if (!(var16 = var5.field_583[var21]).method_891()) {
                            var16.method_818(var19, var7);
                        }
                    }
                }
            }
            if (this.field_486 != null) {
                var21 = 0;
                for (var15 = this.field_486.length; var21 < var15; ++var21) {
                    this.field_486[var21].method_818(this.field_478, var7);
                }
            }
            if (this.field_489) {
                class_244 var10000 = new class_244(this.field_478.method_645().field_455, (CategorizedProblem)null);
                throw var10000;
            }
            if ((this.field_446 & 64) != 0) {
                var7.method_2371();
            }
            var7.method_2147(this.field_478);
            var7.method_2360(0, this.field_491);
            var2.method_2979(var6);
            ++var4;
        }
        var2.method_2986(var3, var4);
    }

    public boolean method_795() {
        return true;
    }

    public boolean method_796() {
        return (this.field_446 & 128) != 0;
    }

    public boolean method_797() {
        return true;
    }

    public boolean method_811(ArrayList var1) {
        if (this.field_488 != null && this.field_493 != null && this.field_493.field_548 != null && !this.field_493.method_1() && this.field_493.field_548.method_101()) {
            class_94 var2 = (class_94)this.field_478.method_718().method_854(this.field_493.field_548.method_376());
            if (this == var2) {
                return true;
            } else {
                if (var1 == null) {
                    ArrayList var10000 = new ArrayList(1);
                    var1 = var10000;
                } else {
                    int var3 = var1.indexOf(this);
                    if (var3 >= 0) {
                        return var3 == 0;
                    }
                }
                var1.add(this);
                return var2.method_811(var1);
            }
        } else {
            return false;
        }
    }

    public void method_800(Parser var1, class_90 var2) {
        if ((this.field_446 & 128) != 0 && this.field_493 == null) {
            this.field_493 = class_158.method_1047();
            this.field_493.field_444 = this.field_444;
            this.field_493.field_445 = this.field_445;
        } else {
            var1.method_2855(this, var2, false);
        }
    }

    public StringBuffer method_801(int var1, StringBuffer var2) {
        var2.append(" {");
        if (this.field_493 != null) {
            var2.append('\n');
            this.field_493.method_820(var1, var2);
        }
        if (this.field_486 != null) {
            for (int var3 = 0; var3 < this.field_486.length; ++var3) {
                var2.append('\n');
                this.field_486[var3].method_820(var1, var2);
            }
        }
        var2.append('\n');
        method_759(var1 == 0 ? 0 : var1 - 1, var2).append('}');
        return var2;
    }

    public void method_804() {}

    public void method_805() {
        class_54 var1 = this.field_478.method_585();
        if (!CharOperation.method_1364(var1.field_198, this.field_479)) {
            this.field_478.method_644().method_1680(this);
        }
        if (this.field_494 != null) {
            int var2 = 0;
            for (int var3 = this.field_494.length; var2 < var3; ++var2) {
                this.field_494[var2].method_821(this.field_478);
            }
        }
        if (this.field_488 != null && !this.field_488.method_367()) {
            var1.field_178 |= 4503599627370496L;
        }
        if (this.field_493 != null) {
            if (var1.field_177 == 1 && this.field_493.field_551 != 3) {
                if (this.field_493.field_551 == 2) {
                    this.field_478.method_644().method_1506(this.field_493);
                }
                this.field_493 = null;
            } else {
                this.field_493.method_821(this.field_478);
            }
        }
        if ((this.field_482 & 16777216) != 0) {
            this.field_478.method_644().method_1672(this);
        }
        super.method_805();
    }

    public void method_806(class_264 var1, class_84 var2) {
        if (var1.method_2012(this, var2)) {
            int var3;
            int var4;
            if (this.field_483 != null) {
                var3 = this.field_483.length;
                for (var4 = 0; var4 < var3; ++var4) {
                    this.field_483[var4].method_763(var1, this.field_478);
                }
            }
            if (this.field_494 != null) {
                var3 = this.field_494.length;
                for (var4 = 0; var4 < var3; ++var4) {
                    this.field_494[var4].method_763(var1, this.field_478);
                }
            }
            if (this.field_484 != null) {
                var3 = this.field_484.length;
                for (var4 = 0; var4 < var3; ++var4) {
                    this.field_484[var4].method_763(var1, this.field_478);
                }
            }
            if (this.field_485 != null) {
                var3 = this.field_485.length;
                for (var4 = 0; var4 < var3; ++var4) {
                    this.field_485[var4].method_763(var1, this.field_478);
                }
            }
            if (this.field_493 != null) {
                this.field_493.method_763(var1, this.field_478);
            }
            if (this.field_486 != null) {
                var3 = this.field_486.length;
                for (var4 = 0; var4 < var3; ++var4) {
                    this.field_486[var4].method_763(var1, this.field_478);
                }
            }
        }
        var1.method_1927(this, var2);
    }

    public class_123[] method_807() {
        return this.field_494;
    }
}
