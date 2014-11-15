package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.class_264;
import org.eclipse.jdt.internal.compiler.ast.class_108;
import org.eclipse.jdt.internal.compiler.ast.class_126;
import org.eclipse.jdt.internal.compiler.ast.class_98;
import org.eclipse.jdt.internal.compiler.codegen.class_268;
import org.eclipse.jdt.internal.compiler.codegen.BranchLabel;
import org.eclipse.jdt.internal.compiler.codegen.class_75;
import org.eclipse.jdt.internal.compiler.flow.class_293;
import org.eclipse.jdt.internal.compiler.flow.class_295;
import org.eclipse.jdt.internal.compiler.flow.class_301;
import org.eclipse.jdt.internal.compiler.flow.class_303;
import org.eclipse.jdt.internal.compiler.impl.class_331;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.class_60;
import org.eclipse.jdt.internal.compiler.lookup.class_67;
import org.eclipse.jdt.internal.compiler.lookup.class_86;

public class class_115 extends class_98 {

    public class_126 field_602;

    public class_98[] field_603;

    public class_86 field_604;

    public int field_605;

    public BranchLabel field_606;

    public class_108[] field_607;

    public class_108 field_608;

    public int field_609;

    public int field_610;

    int[] field_611;

    public class_60 field_612;

    int field_613;

    int field_614;

    public class_115() {
        this.field_613 = -1;
        this.field_614 = -1;
    }

    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        class_303 var17;
        try {
            var3 = this.field_602.method_814(var1, var2, var3);
            BranchLabel var10005 = new BranchLabel();
            class_295 var10000 = new class_295(var2, this, this.field_606 = var10005);
            class_295 var4 = var10000;
            Object var5 = class_301.field_1784;
            this.field_613 = var1.method_635().method_729(var3);
            int var6 = 0;
            if (this.field_603 != null) {
                boolean var7 = false;
                boolean var8 = false;
                int var9 = 0;
                for (int var10 = this.field_603.length; var9 < var10; ++var9) {
                    class_98 var11 = this.field_603[var9];
                    if (var6 < this.field_610 && var11 == this.field_607[var6]) {
                        this.field_604.field_399 = this.field_607[var6];
                        ++var6;
                        if (var8 && (var11.field_446 & 536870912) == 0) {
                            this.field_604.method_644().method_1739(this.field_604.field_399);
                        }
                        var5 = ((class_301)var5).method_3105(var3.method_3109());
                        var7 = false;
                        var8 = false;
                    } else if (var11 == this.field_608) {
                        this.field_604.field_399 = this.field_608;
                        if (var8 && (var11.field_446 & 536870912) == 0) {
                            this.field_604.method_644().method_1739(this.field_604.field_399);
                        }
                        var5 = ((class_301)var5).method_3105(var3.method_3109());
                        var7 = false;
                        var8 = false;
                    } else {
                        var8 = true;
                    }
                    if (!var11.method_816((class_301)var5, this.field_604, var7)) {
                        var5 = var11.method_814(this.field_604, var4, (class_301)var5);
                        if (var5 == class_301.field_1784) {
                            var8 = true;
                        }
                    } else {
                        var7 = true;
                    }
                }
            }
            class_40 var15 = this.field_602.field_675;
            if (this.field_610 > 0 && var15.method_153()) {
                SourceTypeBinding var18 = this.field_604.method_575().field_376.field_586;
                this.field_612 = var18.method_301(var15);
            }
            if (this.field_608 == null) {
                var3.method_3072(((class_301)var5).method_3105(var4.field_1746));
                this.field_614 = var1.method_635().method_729(var3);
                class_301 var19 = var3;
                return var19;
            }
            class_303 var16 = ((class_301)var5).method_3105(var4.field_1746);
            this.field_614 = var1.method_635().method_729(var16);
            var17 = var16;
        } finally {
            if (this.field_604 != null) {
                this.field_604.field_399 = null;
            }
        }
        return var17;
    }

    public void method_818(class_86 var1, class_268 var2) {
        try {
            if ((this.field_446 & Integer.MIN_VALUE) == 0) {
                return;
            }
            int var3 = var2.field_1208;
            this.field_606.method_456(var2);
            class_75[] var4 = new class_75[this.field_610];
            boolean var5 = this.field_610 != 0;
            for (int var6 = 0; var6 < this.field_610; ++var6) {
                class_108 var10000 = this.field_607[var6];
                class_75 var10003 = new class_75(var2);
                var10000.field_567 = var4[var6] = var10003;
                var4[var6].field_330 |= 2;
            }
            class_75 var15 = new class_75(var2);
            class_75 var16 = var15;
            if (var5) {
                var16.field_330 |= 2;
            }
            if (this.field_608 != null) {
                this.field_608.field_567 = var16;
            }
            class_40 var7 = this.field_602.field_675;
            if (var7.method_153()) {
                if (var5) {
                    var2.method_2273(this.field_612);
                    this.field_602.method_912(var1, var2, true);
                    var2.method_2260(var7.method_134());
                    var2.method_2218();
                } else {
                    this.field_602.method_912(var1, var2, false);
                }
            } else {
                this.field_602.method_912(var1, var2, var5);
            }
            int var9;
            int var10;
            if (var5) {
                int[] var8 = new int[this.field_610];
                for (var9 = 0; var9 < this.field_610; var8[var9] = var9++) {
                    ;
                }
                int[] var18;
                System.arraycopy(this.field_611, 0, var18 = new int[this.field_610], 0, this.field_610);
                class_268.method_2082(var18, 0, this.field_610 - 1, var8);
                var10 = var18[this.field_610 - 1];
                int var11 = var18[0];
                if ((long)((double)this.field_610 * 2.5D) > (long)var10 - (long)var11) {
                    if (var10 > 2147418112 && var1.method_577().field_1927 < 3145728L) {
                        var2.method_2326(var16, this.field_611, var8, var4);
                    } else {
                        var2.method_2378(var16, var11, var10, this.field_611, var8, var4);
                    }
                } else {
                    var2.method_2326(var16, this.field_611, var8, var4);
                }
                var2.method_2380(this.field_604, var2.field_1208);
            }
            int var17 = 0;
            if (this.field_603 != null) {
                var9 = 0;
                for (var10 = this.field_603.length; var9 < var10; ++var9) {
                    class_98 var19 = this.field_603[var9];
                    if (var17 < this.field_610 && var19 == this.field_607[var17]) {
                        this.field_604.field_399 = this.field_607[var17];
                        if (this.field_613 != -1) {
                            var2.method_2363(var1, this.field_613);
                        }
                        ++var17;
                    } else if (var19 == this.field_608) {
                        this.field_604.field_399 = this.field_608;
                        if (this.field_613 != -1) {
                            var2.method_2363(var1, this.field_613);
                        }
                    }
                    var19.method_818(this.field_604, var2);
                }
            }
            if (this.field_614 != -1) {
                var2.method_2363(var1, this.field_614);
                var2.method_2088(var1, this.field_614);
            }
            if (this.field_604 != var1) {
                var2.method_2147(this.field_604);
            }
            this.field_606.method_458();
            if (this.field_608 == null) {
                var2.method_2361(var2.field_1208, this.field_445, true);
                var16.method_458();
            }
            var2.method_2360(var3, this.field_444);
        } finally {
            if (this.field_604 != null) {
                this.field_604.field_399 = null;
            }
        }
    }

    public StringBuffer method_820(int var1, StringBuffer var2) {
        method_759(var1, var2).append("switch (");
        this.field_602.method_924(0, var2).append(") {");
        if (this.field_603 != null) {
            for (int var3 = 0; var3 < this.field_603.length; ++var3) {
                var2.append('\n');
                if (this.field_603[var3] instanceof class_108) {
                    this.field_603[var3].method_820(var1, var2);
                } else {
                    this.field_603[var3].method_820(var1 + 2, var2);
                }
            }
        }
        var2.append("\n");
        return method_759(var1, var2).append('}');
    }

    public void method_821(class_86 var1) {
        try {
            boolean var2 = false;
            class_40 var3 = this.field_602.method_925(var1);
            if (var3 != null) {
                this.field_602.method_911(var1, var3, var3);
                if (!var3.method_101()) {
                    var3 = null;
                } else {
                    label276: {
                        if (var3.method_148()) {
                            if (this.field_602.method_919(var3, class_40.field_179) || var3.method_152(class_40.field_179)) {
                                break label276;
                            }
                        } else {
                            if (var3.method_153()) {
                                var2 = true;
                                break label276;
                            }
                            if (var1.method_624(var3, class_40.field_179)) {
                                this.field_602.method_911(var1, class_40.field_179, var3);
                                break label276;
                            }
                        }
                        var1.method_644().method_1611(this.field_602, var3);
                        var3 = null;
                    }
                }
            }
            int var4;
            int var6;
            int var7;
            if (this.field_603 != null) {
                class_86 var10001 = new class_86(var1);
                this.field_604 = var10001;
                this.field_607 = new class_108[var4 = this.field_603.length];
                this.field_611 = new int[var4];
                class_108[] var5 = null;
                var6 = 0;
                var7 = 0;
                for (int var8 = 0; var8 < var4; ++var8) {
                    class_98 var10 = this.field_603[var8];
                    class_331 var9;
                    if ((var9 = var10.method_822(this.field_604, var3, this)) != class_331.field_1896) {
                        int var11 = var9.method_3284();
                        for (int var12 = 0; var12 < var7; ++var12) {
                            if (this.field_611[var12] == var11) {
                                class_108 var13 = (class_108)var10;
                                if (var5 == null) {
                                    this.field_604.method_644().method_1521(this.field_607[var12]);
                                    this.field_604.method_644().method_1521(var13);
                                    var5 = new class_108[var4];
                                    var5[var6++] = this.field_607[var12];
                                    var5[var6++] = var13;
                                } else {
                                    boolean var14 = false;
                                    for (int var15 = 2; var15 < var6; ++var15) {
                                        if (var5[var15] == var10) {
                                            var14 = true;
                                            break;
                                        }
                                    }
                                    if (!var14) {
                                        this.field_604.method_644().method_1521(var13);
                                        var5[var6++] = var13;
                                    }
                                }
                            }
                        }
                        this.field_611[var7++] = var11;
                    }
                }
                if (var4 != var7) {
                    System.arraycopy(this.field_611, 0, this.field_611 = new int[var7], 0, var7);
                }
            } else if ((this.field_446 & 8) != 0) {
                var1.method_644().method_1783(this.field_609, this.field_445);
            }
            if (var2 && this.field_608 == null && var1.method_577().method_3313(2199023255552L) != -1) {
                var4 = this.field_611 == null ? 0 : this.field_611.length;
                if (var4 == this.field_610 && this.field_610 != ((ReferenceBinding)var3).method_202()) {
                    class_67[] var20 = ((ReferenceBinding)var3.method_138()).method_204();
                    var6 = 0;
                    label231:
                    for (var7 = var20.length; var6 < var7; ++var6) {
                        class_67 var21 = var20[var6];
                        if ((var21.field_300 & 16384) != 0) {
                            for (int var22 = 0; var22 < this.field_610; ++var22) {
                                if (var21.field_304 + 1 == this.field_611[var22]) {
                                    continue label231;
                                }
                            }
                            var1.method_644().method_1678(this, var21);
                        }
                    }
                }
            }
        } finally {
            if (this.field_604 != null) {
                this.field_604.field_399 = null;
            }
        }
    }

    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2060(this, var2)) {
            this.field_602.method_763(var1, this.field_604);
            if (this.field_603 != null) {
                int var3 = this.field_603.length;
                for (int var4 = 0; var4 < var3; ++var4) {
                    this.field_603[var4].method_763(var1, this.field_604);
                }
            }
        }
        var1.method_1975(this, var2);
    }

    public void method_815(BranchLabel var1) {
        if (this.field_606.method_454() > 0) {
            var1.method_451(this.field_606);
        }
    }
}
