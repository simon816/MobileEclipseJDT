package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.class_264;
import org.eclipse.jdt.internal.compiler.ast.class_112;
import org.eclipse.jdt.internal.compiler.ast.class_116;
import org.eclipse.jdt.internal.compiler.ast.class_126;
import org.eclipse.jdt.internal.compiler.codegen.class_268;
import org.eclipse.jdt.internal.compiler.codegen.class_74;
import org.eclipse.jdt.internal.compiler.flow.class_293;
import org.eclipse.jdt.internal.compiler.flow.class_294;
import org.eclipse.jdt.internal.compiler.flow.class_301;
import org.eclipse.jdt.internal.compiler.impl.class_331;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.class_65;
import org.eclipse.jdt.internal.compiler.lookup.class_86;

public class class_118 extends class_116 {

    public class_126 field_640;

    public class_112 field_641;

    public class_86 field_642;

    public class_65 field_643;

    static final char[] field_644;

    int field_645;

    int field_646;

    public class_118(class_126 var1, class_112 var2, int var3, int var4) {
        this.field_645 = -1;
        this.field_646 = -1;
        this.field_640 = var1;
        this.field_641 = var2;
        this.field_445 = var4;
        this.field_444 = var3;
    }

    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        this.field_645 = var1.method_635().method_729(var3);
        this.field_643.field_307 = 1;
        class_112 var10000 = this.field_641;
        class_86 var10001 = this.field_642;
        class_294 var10002 = new class_294(var2, this);
        var3 = var10000.method_814(var10001, var10002, this.field_640.method_814(this.field_642, var2, var3));
        this.field_646 = var1.method_635().method_729(var3);
        if ((var3.field_1783 & 1) != 0) {
            this.field_446 |= 536870912;
        }
        return var3;
    }

    public boolean method_876() {
        return false;
    }

    public void method_818(class_86 var1, class_268 var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            this.field_615 = null;
            int var3 = var2.field_1208;
            this.field_640.method_912(this.field_642, var2, true);
            if (this.field_641.method_819()) {
                if (this.field_643.field_301 != class_40.field_183 && this.field_643.field_301 != class_40.field_185) {
                    var2.method_2141();
                } else {
                    var2.method_2144();
                }
                var2.method_2340();
                var2.method_2341();
                if (this.field_642 != var1) {
                    var2.method_2147(this.field_642);
                }
            } else {
                var2.method_2376(this.field_643, true);
                var2.method_2091(this.field_643);
                var2.method_2340();
                this.method_872(var2);
                this.field_641.method_818(this.field_642, var2);
                if (this.field_642 != var1) {
                    var2.method_2148(this.field_642, this.field_643);
                }
                class_74 var10000 = new class_74(var2);
                class_74 var4 = var10000;
                if ((this.field_446 & 536870912) == 0) {
                    var2.method_2324(this.field_643);
                    var2.method_2341();
                    this.method_874();
                    var2.method_2209(var4);
                    this.method_872(var2);
                }
                var2.method_2355(this.field_642.method_611());
                if (this.field_645 != -1) {
                    var2.method_2363(var1, this.field_645);
                }
                this.method_877();
                var2.method_2324(this.field_643);
                var2.method_2341();
                this.method_874();
                var2.method_2107();
                if (this.field_646 != -1) {
                    var2.method_2363(var1, this.field_646);
                    var2.method_2088(var1, this.field_646);
                }
                if (this.field_642 != var1) {
                    var2.method_2365(this.field_643);
                }
                if ((this.field_446 & 536870912) == 0) {
                    var4.method_458();
                }
            }
            var2.method_2360(var3, this.field_444);
        }
    }

    public boolean method_875(class_86 var1, class_268 var2, Object var3, int var4, class_65 var5) {
        var2.method_2324(this.field_643);
        var2.method_2341();
        this.method_874();
        return false;
    }

    public void method_821(class_86 var1) {
        class_86 var10001 = new class_86(var1);
        this.field_642 = var10001;
        class_40 var2 = this.field_640.method_925(this.field_642);
        if (var2 != null) {
            switch (var2.field_177) {
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    this.field_642.method_644().method_1642(this.field_640, var2);
                    break;
                case 6:
                    this.field_642.method_644().method_1605(this.field_640);
                case 11:
                default:
                    break;
                case 12:
                    this.field_642.method_644().method_1633(this.field_640);
            }
            class_65 var3 = new class_65(field_644, var2, 0, false);
            this.field_643 = var3;
            this.field_642.method_704(this.field_643);
            this.field_643.method_410(class_331.field_1896);
            this.field_640.method_911(this.field_642, var2, var2);
            this.field_641.method_842(this.field_642);
        }
    }

    public StringBuffer method_820(int var1, StringBuffer var2) {
        method_759(var1, var2);
        var2.append("synchronized (");
        this.field_640.method_924(0, var2).append(')');
        var2.append('\n');
        return this.field_641.method_820(var1 + 1, var2);
    }

    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2061(this, var2)) {
            this.field_640.method_763(var1, this.field_642);
            this.field_641.method_763(var1, this.field_642);
        }
        var1.method_1976(this, var2);
    }

    static {
        field_644 = " syncValue".toCharArray();
    }
}
