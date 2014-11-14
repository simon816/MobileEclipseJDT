package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.class_264;
import org.eclipse.jdt.internal.compiler.ast.class_126;
import org.eclipse.jdt.internal.compiler.ast.class_98;
import org.eclipse.jdt.internal.compiler.ast.class_99;
import org.eclipse.jdt.internal.compiler.codegen.class_268;
import org.eclipse.jdt.internal.compiler.codegen.class_74;
import org.eclipse.jdt.internal.compiler.flow.class_293;
import org.eclipse.jdt.internal.compiler.flow.class_297;
import org.eclipse.jdt.internal.compiler.flow.class_301;
import org.eclipse.jdt.internal.compiler.flow.class_303;
import org.eclipse.jdt.internal.compiler.impl.class_331;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.class_86;

public class class_100 extends class_98 {

    public class_126 field_501;

    public class_98 field_502;

    private class_74 field_503;

    private class_74 field_504;

    int field_505;

    public class_100(class_126 var1, class_98 var2, int var3, int var4) {
        this.field_505 = -1;
        this.field_444 = var3;
        this.field_445 = var4;
        this.field_501 = var1;
        this.field_502 = var2;
        if (var2 instanceof class_99) {
            var2.field_446 |= 1;
        }
    }

    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        class_74 var10001 = new class_74();
        this.field_503 = var10001;
        var10001 = new class_74();
        this.field_504 = var10001;
        class_297 var10000 = new class_297(var2, var3, this, this.field_503, this.field_504, var1);
        class_297 var4 = var10000;
        class_331 var5 = this.field_501.field_672;
        boolean var6 = var5 != class_331.field_1896 && var5.method_3257();
        var5 = this.field_501.method_922();
        boolean var7 = var5 != class_331.field_1896 && var5.method_3257();
        boolean var8 = var5 != class_331.field_1896 && !var5.method_3257();
        int var9 = var3.method_3102();
        class_303 var10 = var3.method_3106();
        if (this.field_502 != null && !this.field_502.method_819()) {
            var10 = this.field_502.method_814(var1, var4, var10).method_3109();
            if ((var10.field_1783 & var4.field_1749.field_1783 & 1) != 0) {
                this.field_504 = null;
            }
        }
        var10.method_3104(var9);
        class_126 var14 = this.field_501;
        class_297 var10002 = new class_297(var2, var3, this, (class_74)null, (class_74)null, var1);
        class_297 var11 = var10002;
        class_301 var12 = var14.method_814(var1, var10002, (this.field_502 == null ? var10 : var10.method_3105(var4.field_1749)).method_3078());
        if (!var8 && this.field_504 != null) {
            var4.method_3057(var1, var12);
            var11.method_3057(var1, var12);
            var4.method_3058(var1, var3.method_3107().method_3113(var12.method_3081().method_3109()));
            var11.method_3058(var1, var10.method_3113(var12.method_3081().method_3109()));
        }
        class_303 var13 = class_301.method_3101((class_301)((var4.field_1746.field_1783 & 1) != 0 ? var4.field_1746 : var3.method_3107().method_3071(var4.field_1746)), var7, (var12.field_1783 & 1) == 0 ? var3.method_3071(var12.method_3080()) : var12, false, !var6);
        this.field_505 = var1.method_635().method_729(var13);
        return var13;
    }

    public void method_818(class_86 var1, class_268 var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            int var3 = var2.field_1208;
            class_74 var10000 = new class_74(var2);
            class_74 var4 = var10000;
            if (this.field_502 != null) {
                var4.field_330 |= 2;
            }
            var4.method_458();
            this.field_503.method_456(var2);
            boolean var5 = this.field_504 != null;
            if (var5) {
                this.field_504.method_456(var2);
            }
            if (this.field_502 != null) {
                this.field_502.method_818(var1, var2);
            }
            if (var5) {
                this.field_504.method_458();
            }
            class_331 var6 = this.field_501.method_922();
            boolean var7 = var6 != class_331.field_1896 && !var6.method_3257();
            if (var7) {
                this.field_501.method_912(var1, var2, false);
            } else if (var5) {
                this.field_501.method_913(var1, var2, var4, (class_74)null, true);
            }
            if (this.field_505 != -1) {
                var2.method_2363(var1, this.field_505);
                var2.method_2088(var1, this.field_505);
            }
            if (this.field_503.method_454() > 0) {
                this.field_503.method_458();
            }
            var2.method_2360(var3, this.field_444);
        }
    }

    public StringBuffer method_820(int var1, StringBuffer var2) {
        method_759(var1, var2).append("do");
        if (this.field_502 == null) {
            var2.append(" ;\n");
        } else {
            var2.append('\n');
            this.field_502.method_820(var1 + 1, var2).append('\n');
        }
        var2.append("while (");
        return this.field_501.method_924(0, var2).append(");");
    }

    public void method_821(class_86 var1) {
        class_40 var2 = this.field_501.method_926(var1, class_40.field_186);
        this.field_501.method_911(var1, var2, var2);
        if (this.field_502 != null) {
            this.field_502.method_821(var1);
        }
    }

    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2014(this, var2)) {
            if (this.field_502 != null) {
                this.field_502.method_763(var1, var2);
            }
            this.field_501.method_763(var1, var2);
        }
        var1.method_1929(this, var2);
    }
}
