package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.class_264;
import org.eclipse.jdt.internal.compiler.ast.class_126;
import org.eclipse.jdt.internal.compiler.ast.class_130;
import org.eclipse.jdt.internal.compiler.ast.class_131;
import org.eclipse.jdt.internal.compiler.ast.class_132;
import org.eclipse.jdt.internal.compiler.ast.class_154;
import org.eclipse.jdt.internal.compiler.ast.class_176;
import org.eclipse.jdt.internal.compiler.ast.class_180;
import org.eclipse.jdt.internal.compiler.codegen.class_268;
import org.eclipse.jdt.internal.compiler.flow.class_293;
import org.eclipse.jdt.internal.compiler.flow.class_301;
import org.eclipse.jdt.internal.compiler.impl.class_331;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.class_42;
import org.eclipse.jdt.internal.compiler.lookup.class_86;

public class class_156 extends class_154 {

    public class_126 field_744;

    public class_126 field_745;

    public class_156(class_126 var1, class_126 var2) {
        this.field_744 = var1;
        this.field_745 = var2;
        this.field_444 = var1.field_444;
    }

    public class_301 method_1035(class_86 var1, class_293 var2, class_301 var3, class_131 var4, boolean var5) {
        return var4.field_688 == null ? this.method_814(var1, var2, var3) : var4.field_688.method_814(var1, var2, this.method_814(var1, var2, var3).method_3109());
    }

    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        this.field_744.method_909(var1, var2, var3);
        var3 = this.field_744.method_814(var1, var2, var3);
        return this.field_745.method_814(var1, var2, var3);
    }

    public void method_1038(class_86 var1, class_268 var2, class_131 var3, boolean var4) {
        int var5 = var2.field_1208;
        this.field_744.method_912(var1, var2, true);
        if (this.field_744 instanceof class_130 && ((class_130)this.field_744).method_940().field_675 == class_40.field_187) {
            var2.method_2113(this.field_744.field_675);
        }
        var2.method_2360(var5, this.field_444);
        this.field_745.method_912(var1, var2, true);
        var3.field_688.method_912(var1, var2, true);
        var2.method_2100(this.field_675.field_177, var4);
        if (var4) {
            var2.method_2182(var3.field_674);
        }
    }

    public void method_912(class_86 var1, class_268 var2, boolean var3) {
        int var4 = var2.field_1208;
        this.field_744.method_912(var1, var2, true);
        if (this.field_744 instanceof class_130 && ((class_130)this.field_744).method_940().field_675 == class_40.field_187) {
            var2.method_2113(this.field_744.field_675);
        }
        this.field_745.method_912(var1, var2, true);
        var2.method_2099(this.field_675.field_177);
        if (var3) {
            var2.method_2182(this.field_674);
        } else {
            boolean var5 = (this.field_674 & 1024) != 0;
            if (var5) {
                var2.method_2182(this.field_674);
            }
            switch (var5 ? this.method_923(var1).field_177 : this.field_675.field_177) {
                case 7:
                case 8:
                    var2.method_2353();
                    break;
                default:
                    var2.method_2352();
            }
        }
        var2.method_2360(var4, this.field_444);
    }

    public void method_1039(class_86 var1, class_268 var2, class_126 var3, int var4, int var5, boolean var6) {
        this.field_744.method_912(var1, var2, true);
        if (this.field_744 instanceof class_130 && ((class_130)this.field_744).method_940().field_675 == class_40.field_187) {
            var2.method_2113(this.field_744.field_675);
        }
        this.field_745.method_912(var1, var2, true);
        var2.method_2144();
        var2.method_2099(this.field_675.field_177);
        int var7;
        switch (var7 = (this.field_674 & 255) >> 4) {
            case 0:
            case 1:
            case 11:
                var2.method_2193(var1, (class_126)null, var3);
                break;
            default:
                var2.method_2182(this.field_674);
                if (var3 == class_180.field_797) {
                    var2.method_2179(var3.field_672, this.field_674);
                } else {
                    var3.method_912(var1, var2, true);
                }
                var2.method_2374(var4, var7);
                var2.method_2182(var5);
        }
        var2.method_2100(this.field_675.field_177, var6);
    }

    public void method_1040(class_86 var1, class_268 var2, class_132 var3, boolean var4) {
        this.field_744.method_912(var1, var2, true);
        if (this.field_744 instanceof class_130 && ((class_130)this.field_744).method_940().field_675 == class_40.field_187) {
            var2.method_2113(this.field_744.field_675);
        }
        this.field_745.method_912(var1, var2, true);
        var2.method_2144();
        var2.method_2099(this.field_675.field_177);
        if (var4) {
            if (this.field_675 != class_40.field_183 && this.field_675 != class_40.field_185) {
                var2.method_2143();
            } else {
                var2.method_2146();
            }
        }
        var2.method_2182(this.field_674);
        var2.method_2179(var3.field_688.field_672, this.field_674);
        var2.method_2374(var3.field_689, this.field_674 & 15);
        var2.method_2182(var3.field_690);
        var2.method_2100(this.field_675.field_177, false);
    }

    public int method_921(class_301 var1) {
        return 0;
    }

    public StringBuffer method_924(int var1, StringBuffer var2) {
        this.field_744.method_924(0, var2).append('[');
        return this.field_745.method_924(0, var2).append(']');
    }

    public class_40 method_925(class_86 var1) {
        this.field_672 = class_331.field_1896;
        if (this.field_744 instanceof class_130 && ((class_130)this.field_744).method_940() instanceof class_176) {
            this.field_744.field_446 |= 32;
        }
        class_40 var2 = this.field_744.method_925(var1);
        class_40 var3;
        if (var2 != null) {
            this.field_744.method_911(var1, var2, var2);
            if (var2.method_147()) {
                var3 = ((class_42)var2).method_187();
                this.field_675 = (this.field_446 & 8192) == 0 ? var3.method_130(var1, this.field_445) : var3;
            } else {
                var1.method_644().method_1747(var2, this);
            }
        }
        var3 = this.field_745.method_926(var1, class_40.field_179);
        if (var3 != null) {
            this.field_745.method_911(var1, class_40.field_179, var3);
        }
        return this.field_675;
    }

    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_1997(this, var2)) {
            this.field_744.method_763(var1, var2);
            this.field_745.method_763(var1, var2);
        }
        var1.method_1912(this, var2);
    }
}
