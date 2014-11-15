package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.class_264;
import org.eclipse.jdt.internal.compiler.ast.class_126;
import org.eclipse.jdt.internal.compiler.ast.class_98;
import org.eclipse.jdt.internal.compiler.ast.class_99;
import org.eclipse.jdt.internal.compiler.codegen.class_268;
import org.eclipse.jdt.internal.compiler.codegen.BranchLabel;
import org.eclipse.jdt.internal.compiler.flow.class_293;
import org.eclipse.jdt.internal.compiler.flow.class_297;
import org.eclipse.jdt.internal.compiler.flow.class_301;
import org.eclipse.jdt.internal.compiler.flow.class_303;
import org.eclipse.jdt.internal.compiler.impl.class_331;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.class_86;

public class class_107 extends class_98 {

    public class_126 field_559;

    public class_98 field_560;

    private BranchLabel field_561;

    private BranchLabel field_562;

    int field_563;

    int field_564;

    int field_565;

    public class_107(class_126 var1, class_98 var2, int var3, int var4) {
        this.field_563 = -1;
        this.field_564 = -1;
        this.field_565 = -1;
        this.field_559 = var1;
        this.field_560 = var2;
        if (var2 instanceof class_99) {
            var2.field_446 |= 1;
        }
        this.field_444 = var3;
        this.field_445 = var4;
    }

    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        BranchLabel var10001 = new BranchLabel();
        this.field_561 = var10001;
        var10001 = new BranchLabel();
        this.field_562 = var10001;
        class_331 var4 = this.field_559.field_672;
        boolean var5 = var4 != class_331.field_1896 && var4.method_3257();
        boolean var6 = var4 != class_331.field_1896 && !var4.method_3257();
        var4 = this.field_559.method_922();
        boolean var7 = var4 != class_331.field_1896 && var4.method_3257();
        boolean var8 = var4 != class_331.field_1896 && !var4.method_3257();
        this.field_563 = var1.method_635().method_729(var3);
        class_303 var10 = var3.method_3106();
        class_126 var10000 = this.field_559;
        class_297 var10002 = new class_297(var2, var3, this, (BranchLabel)null, (BranchLabel)null, var1);
        class_297 var9 = var10002;
        class_301 var16 = var10000.method_814(var1, var10002, var10);
        if (this.field_560 != null && (!this.field_560.method_819() || var1.method_577().field_1927 > 3080192L)) {
            class_297 var15 = new class_297(var2, var3, this, this.field_561, this.field_562, var1);
            class_297 var11 = var15;
            Object var12;
            if (var6) {
                var12 = class_301.field_1784;
            } else {
                var12 = var16.method_3081().method_3078();
                if (var8) {
                    ((class_301)var12).method_3104(1);
                }
            }
            this.field_564 = var1.method_635().method_729(var16.method_3081());
            if (!this.field_560.method_816((class_301)var12, var1, false)) {
                var12 = this.field_560.method_814(var1, var11, (class_301)var12);
            }
            class_301 var13 = var3.method_3078();
            if ((((class_301)var12).field_1783 & var11.field_1749.field_1783 & 1) != 0) {
                this.field_562 = null;
                var13.method_3071(var16.method_3080());
            } else {
                var9.method_3057(var1, var16);
                class_303 var17 = ((class_301)var12).method_3105(var11.field_1749.method_3109());
                var9.method_3058(var1, var17);
                var11.method_3057(var1, var17);
                var11.method_3058(var1, var17);
                var13.method_3072(var17.method_3109()).method_3071(var16.method_3080());
            }
            class_303 var18 = class_301.method_3101((class_301)((var11.field_1746.field_1783 & 1) != 0 ? var11.field_1746 : var3.method_3071(var11.field_1746)), var7, var13, var8, !var5);
            this.field_565 = var1.method_635().method_729(var18);
            return var18;
        } else {
            var9.method_3057(var1, var16);
            var9.method_3058(var1, var16.method_3109());
            if (var5) {
                return class_301.field_1784;
            } else {
                class_301 var14 = var3.method_3078().method_3071(var16.method_3080());
                if (var7) {
                    var14.method_3104(1);
                }
                this.field_565 = var1.method_635().method_729(var14);
                return var14;
            }
        }
    }

    public void method_818(class_86 var1, class_268 var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            int var3 = var2.field_1208;
            class_331 var4 = this.field_559.method_922();
            boolean var5 = var4 != class_331.field_1896 && !var4.method_3257();
            if (var5) {
                this.field_559.method_912(var1, var2, false);
                if (this.field_565 != -1) {
                    var2.method_2363(var1, this.field_565);
                    var2.method_2088(var1, this.field_565);
                }
                var2.method_2360(var3, this.field_444);
            } else {
                this.field_561.method_456(var2);
                if (this.field_562 == null) {
                    if (this.field_559.field_672 == class_331.field_1896) {
                        this.field_559.method_913(var1, var2, (BranchLabel)null, this.field_561, true);
                    }
                } else {
                    this.field_562.method_456(var2);
                    if ((this.field_559.field_672 == class_331.field_1896 || !this.field_559.field_672.method_3257()) && this.field_560 != null && !this.field_560.method_819()) {
                        int var6 = var2.field_1208;
                        var2.method_2209(this.field_562);
                        var2.method_2360(var6, this.field_559.field_444);
                    }
                }
                BranchLabel var10000 = new BranchLabel(var2);
                BranchLabel var7 = var10000;
                if (this.field_560 != null) {
                    var7.field_330 |= 2;
                    if (this.field_564 != -1) {
                        var2.method_2088(var1, this.field_564);
                    }
                    var7.method_458();
                    this.field_560.method_818(var1, var2);
                    if (this.field_563 != -1) {
                        var2.method_2363(var1, this.field_563);
                    }
                } else {
                    var7.method_458();
                }
                if (this.field_562 != null) {
                    this.field_562.method_458();
                    this.field_559.method_913(var1, var2, var7, (BranchLabel)null, true);
                }
                if (this.field_565 != -1) {
                    var2.method_2363(var1, this.field_565);
                    var2.method_2088(var1, this.field_565);
                }
                this.field_561.method_458();
                var2.method_2360(var3, this.field_444);
            }
        }
    }

    public void method_821(class_86 var1) {
        class_40 var2 = this.field_559.method_926(var1, class_40.field_186);
        this.field_559.method_911(var1, var2, var2);
        if (this.field_560 != null) {
            this.field_560.method_821(var1);
        }
    }

    public StringBuffer method_820(int var1, StringBuffer var2) {
        method_759(var1, var2).append("while (");
        this.field_559.method_924(0, var2).append(')');
        if (this.field_560 == null) {
            var2.append(';');
        } else {
            this.field_560.method_820(var1 + 1, var2);
        }
        return var2;
    }

    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2071(this, var2)) {
            this.field_559.method_763(var1, var2);
            if (this.field_560 != null) {
                this.field_560.method_763(var1, var2);
            }
        }
        var1.method_1986(this, var2);
    }
}
