package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.class_264;
import org.eclipse.jdt.internal.compiler.ast.class_112;
import org.eclipse.jdt.internal.compiler.ast.class_126;
import org.eclipse.jdt.internal.compiler.ast.class_98;
import org.eclipse.jdt.internal.compiler.ast.class_99;
import org.eclipse.jdt.internal.compiler.codegen.class_268;
import org.eclipse.jdt.internal.compiler.codegen.class_74;
import org.eclipse.jdt.internal.compiler.flow.class_293;
import org.eclipse.jdt.internal.compiler.flow.class_301;
import org.eclipse.jdt.internal.compiler.flow.class_303;
import org.eclipse.jdt.internal.compiler.impl.class_331;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.class_86;

public class class_101 extends class_98 {

    public class_126 field_506;

    public class_98 field_507;

    public class_98 field_508;

    int field_509;

    int field_510;

    int field_511;

    public class_101(class_126 var1, class_98 var2, int var3, int var4) {
        this.field_509 = -1;
        this.field_510 = -1;
        this.field_511 = -1;
        this.field_506 = var1;
        this.field_507 = var2;
        if (var2 instanceof class_99) {
            var2.field_446 |= 1;
        }
        this.field_444 = var3;
        this.field_445 = var4;
    }

    public class_101(class_126 var1, class_98 var2, class_98 var3, int var4, int var5) {
        this.field_509 = -1;
        this.field_510 = -1;
        this.field_511 = -1;
        this.field_506 = var1;
        this.field_507 = var2;
        if (var2 instanceof class_99) {
            var2.field_446 |= 1;
        }
        this.field_508 = var3;
        if (var3 instanceof class_101) {
            var3.field_446 |= 536870912;
        }
        if (var3 instanceof class_99) {
            var3.field_446 |= 1;
        }
        this.field_444 = var4;
        this.field_445 = var5;
    }

    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        class_301 var4 = this.field_506.method_814(var1, var2, var3);
        class_331 var5 = this.field_506.method_922();
        boolean var6 = var5 != class_331.field_1896 && var5.method_3257();
        boolean var7 = var5 != class_331.field_1896 && !var5.method_3257();
        class_301 var8 = var4.method_3103();
        if (var7) {
            var8.method_3104(1);
        }
        class_301 var9 = var4.method_3080();
        if (var6) {
            var9.method_3104(1);
        }
        if (this.field_507 != null) {
            this.field_509 = var1.method_635().method_729(var8);
            if (!this.field_507.method_816(var8, var1, false)) {
                var8 = this.field_507.method_814(var1, var2, var8);
            }
        }
        if ((var8.field_1783 & 1) != 0) {
            this.field_446 |= 1073741824;
        }
        if (this.field_508 != null) {
            if (var8 == class_301.field_1784 && (this.field_446 & 536870912) == 0 && !(this.field_508 instanceof class_101)) {
                var1.method_644().method_1791(this.field_508);
            }
            this.field_510 = var1.method_635().method_729(var9);
            if (!this.field_508.method_816(var9, var1, false)) {
                var9 = this.field_508.method_814(var1, var2, var9);
            }
        }
        class_303 var10 = class_301.method_3101(var8, var6, var9, var7, true);
        this.field_511 = var1.method_635().method_729(var10);
        return var10;
    }

    public void method_818(class_86 var1, class_268 var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            int var3 = var2.field_1208;
            class_74 var10000 = new class_74(var2);
            class_74 var4 = var10000;
            class_331 var5;
            boolean var6 = ((var5 = this.field_506.method_922()) == class_331.field_1896 || var5.method_3257()) && this.field_507 != null && !this.field_507.method_819();
            boolean var7 = (var5 == class_331.field_1896 || !var5.method_3257()) && this.field_508 != null && !this.field_508.method_819();
            if (var6) {
                class_74 var8 = null;
                class_74 var10004;
                if (var7) {
                    var10004 = new class_74(var2);
                    var8 = var10004;
                } else {
                    var10004 = var4;
                }
                this.field_506.method_913(var1, var2, (class_74)null, var10004, true);
                if (this.field_509 != -1) {
                    var2.method_2363(var1, this.field_509);
                    var2.method_2088(var1, this.field_509);
                }
                this.field_507.method_818(var1, var2);
                if (var7) {
                    if ((this.field_446 & 1073741824) == 0) {
                        this.field_507.method_815(var4);
                        int var9 = var2.field_1208;
                        var2.method_2209(var4);
                        var2.method_2380(this.field_507 instanceof class_112 ? ((class_112)this.field_507).field_574 : var1, var9);
                    }
                    if (this.field_510 != -1) {
                        var2.method_2363(var1, this.field_510);
                        var2.method_2088(var1, this.field_510);
                    }
                    if (var8 != null) {
                        var8.method_458();
                    }
                    this.field_508.method_818(var1, var2);
                }
            } else if (var7) {
                this.field_506.method_913(var1, var2, var4, (class_74)null, true);
                if (this.field_510 != -1) {
                    var2.method_2363(var1, this.field_510);
                    var2.method_2088(var1, this.field_510);
                }
                this.field_508.method_818(var1, var2);
            } else {
                this.field_506.method_912(var1, var2, false);
                var2.method_2360(var3, this.field_444);
            }
            if (this.field_511 != -1) {
                var2.method_2363(var1, this.field_511);
                var2.method_2088(var1, this.field_511);
            }
            var4.method_458();
            var2.method_2360(var3, this.field_444);
        }
    }

    public StringBuffer method_820(int var1, StringBuffer var2) {
        method_759(var1, var2).append("if (");
        this.field_506.method_924(0, var2).append(")\n");
        this.field_507.method_820(var1 + 2, var2);
        if (this.field_508 != null) {
            var2.append('\n');
            method_759(var1, var2);
            var2.append("else\n");
            this.field_508.method_820(var1 + 2, var2);
        }
        return var2;
    }

    public void method_821(class_86 var1) {
        class_40 var2 = this.field_506.method_926(var1, class_40.field_186);
        this.field_506.method_911(var1, var2, var2);
        if (this.field_507 != null) {
            this.field_507.method_821(var1);
        }
        if (this.field_508 != null) {
            this.field_508.method_821(var1);
        }
    }

    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2026(this, var2)) {
            this.field_506.method_763(var1, var2);
            if (this.field_507 != null) {
                this.field_507.method_763(var1, var2);
            }
            if (this.field_508 != null) {
                this.field_508.method_763(var1, var2);
            }
        }
        var1.method_1941(this, var2);
    }
}
