package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.class_264;
import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.ClassFile;
import org.eclipse.jdt.internal.compiler.ast.class_114;
import org.eclipse.jdt.internal.compiler.ast.class_121;
import org.eclipse.jdt.internal.compiler.ast.class_122;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.codegen.class_268;
import org.eclipse.jdt.internal.compiler.codegen.class_272;
import org.eclipse.jdt.internal.compiler.codegen.BranchLabel;
import org.eclipse.jdt.internal.compiler.flow.class_298;
import org.eclipse.jdt.internal.compiler.flow.class_299;
import org.eclipse.jdt.internal.compiler.flow.class_301;
import org.eclipse.jdt.internal.compiler.flow.class_303;
import org.eclipse.jdt.internal.compiler.lookup.class_17;
import org.eclipse.jdt.internal.compiler.lookup.class_34;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.class_67;
import org.eclipse.jdt.internal.compiler.lookup.class_84;
import org.eclipse.jdt.internal.compiler.lookup.class_86;
import org.eclipse.jdt.internal.compiler.lookup.class_87;
import org.eclipse.jdt.internal.compiler.parser.Parser;
import org.eclipse.jdt.internal.compiler.problem.class_244;

public class class_95 extends AbstractMethodDeclaration {

    private class_67 field_495;

    private class_67 field_496;

    public class_95(CompilationResult var1) {
        super(var1);
        this.field_495 = null;
        this.field_496 = null;
        this.field_482 = 0;
        this.field_479 = class_17.field_136;
    }

    public void method_786(class_84 var1, class_299 var2, class_301 var3) {
        if (!this.field_489) {
            try {
                class_298 var10000 = new class_298(var2.field_1740, this, class_34.field_151, this.field_478, class_301.field_1784);
                class_298 var4 = var10000;
                if ((var3.field_1783 & 1) == 0) {
                    this.field_446 |= 64;
                }
                class_303 var10 = var3.method_3105(var2.field_1770);
                class_67[] var5 = this.field_478.method_585().method_204();
                int var6 = 0;
                for (int var7 = var5.length; var6 < var7; ++var6) {
                    class_67 var8;
                    if ((var8 = var5[var6]).method_431() && var8.method_409() && !var10.method_3082(var5[var6])) {
                        this.field_478.method_644().method_1788(var8, this.field_478.method_718().method_853(var8.method_435()));
                    }
                }
                var2.method_3067(this.field_478, var4, var10);
            } catch (class_244 var9) {
                this.field_489 = true;
            }
        }
    }

    public void method_789(class_84 var1, ClassFile var2) {
        byte var3 = 0;
        if (!this.field_489) {
            try {
                int var8 = var2.field_1719;
                this.method_812(var1, var2, var8);
            } catch (class_244 var7) {
                if (var7.field_1049 == class_268.field_1186) {
                    try {
                        var2.field_1719 = var3;
                        --var2.field_1725;
                        var2.field_1715.field_1216 = true;
                        this.method_812(var1, var2, var3);
                    } catch (class_244 var6) {
                        var2.field_1719 = var3;
                        --var2.field_1725;
                    }
                } else {
                    var2.field_1719 = var3;
                    --var2.field_1725;
                }
            }
        }
    }

    private void method_812(class_84 var1, ClassFile var2, int var3) {
        class_272 var4 = var2.field_1716;
        int var5 = var4.field_1321;
        int var6 = var4.field_1320;
        var2.method_2997();
        int var7 = var2.field_1719;
        var2.method_2989();
        class_268 var8 = var2.field_1715;
        this.method_803(var1);
        var8.method_2366(this, var2);
        class_114 var9 = var1.field_376;
        class_87 var10 = var9.field_589;
        var10.method_724(0, var8);
        if (this.field_495 != null) {
            var8.method_2177(var1.method_640().method_585(), this.field_496);
            var8.method_2264();
            BranchLabel var10000 = new BranchLabel(var8);
            BranchLabel var11 = var10000;
            var8.method_2242(var11);
            var8.method_2222();
            var10000 = new BranchLabel(var8);
            BranchLabel var12 = var10000;
            var8.method_2125(1);
            var8.method_2209(var12);
            var11.method_458();
            var8.method_2221();
            var12.method_458();
            var8.method_2357(this.field_495);
        }
        class_121[] var18 = var9.field_583;
        class_86 var19 = null;
        int var13;
        int var14;
        if (class_114.method_859(var9.field_577) == 3) {
            var13 = 0;
            var14 = 0;
            int var15;
            class_121 var17;
            int var16;
            if (var18 != null) {
                var15 = 0;
                for (var16 = var18.length; var15 < var16; ++var15) {
                    var17 = var18[var15];
                    if (var17.method_891()) {
                        if (var17.method_887() == 3) {
                            var17.method_818(var10, var8);
                            ++var13;
                        } else {
                            ++var14;
                        }
                    }
                }
            }
            var8.method_2188(var13);
            var8.method_2097(var9.field_586);
            if (var13 > 0 && var18 != null) {
                var15 = 0;
                for (var16 = var18.length; var15 < var16; ++var15) {
                    var17 = var18[var15];
                    if (var17.method_887() == 3) {
                        var8.method_2141();
                        var8.method_2188(var17.field_661.field_304);
                        var8.method_2207(var17.field_661);
                        var8.method_2086();
                    }
                }
            }
            var8.method_2357(var9.field_600);
            if (var14 != 0) {
                var15 = 0;
                for (var16 = var18.length; var15 < var16; ++var15) {
                    var17 = var18[var15];
                    switch (var17.method_887()) {
                        case 1:
                            if (var17.field_661.method_431()) {
                                var19 = null;
                                var17.method_818(var10, var8);
                            }
                            break;
                        case 2:
                            if (var17.method_891()) {
                                var19 = ((class_122)var17).field_664.field_574;
                                var17.method_818(var10, var8);
                            }
                        case 3:
                    }
                }
            }
        } else if (var18 != null) {
            var13 = 0;
            for (var14 = var18.length; var13 < var14; ++var13) {
                class_121 var20 = var18[var13];
                switch (var20.method_887()) {
                    case 1:
                        if (var20.field_661.method_431()) {
                            var19 = null;
                            var20.method_818(var10, var8);
                        }
                        break;
                    case 2:
                        if (var20.method_891()) {
                            var19 = ((class_122)var20).field_664.field_574;
                            var20.method_818(var10, var8);
                        }
                }
            }
        }
        if (var8.field_1208 == 0) {
            var2.field_1719 = var3;
            --var2.field_1725;
            var4.method_2475(var6, var5);
        } else {
            if ((this.field_446 & 64) != 0) {
                var13 = var8.field_1208;
                var8.method_2371();
                if (var19 != null) {
                    var8.method_2380(var19, var13);
                }
            }
            var8.method_2360(0, var9.field_444);
            var2.method_2980(var7);
        }
    }

    public boolean method_794() {
        return true;
    }

    public boolean method_797() {
        return true;
    }

    public boolean method_799() {
        return true;
    }

    public void method_800(Parser var1, CompilationUnitDeclaration var2) {}

    public StringBuffer method_757(int var1, StringBuffer var2) {
        method_759(var1, var2).append("<clinit>()");
        this.method_801(var1 + 1, var2);
        return var2;
    }

    public void method_803(class_84 var1) {
        class_87 var10001 = new class_87(var1, var1.field_376, true);
        this.field_478 = var10001;
    }

    public void method_806(class_264 var1, class_84 var2) {
        var1.method_2009(this, var2);
        var1.method_1924(this, var2);
    }

    public void method_813(class_67 var1, boolean var2) {
        this.field_495 = var1;
        if (var2) {
            SourceTypeBinding var3 = this.field_478.method_640().method_585();
            if (!var3.method_157() && !var3.method_148()) {
                this.field_496 = var3.method_295(var3, this.field_478);
            }
        }
    }
}
