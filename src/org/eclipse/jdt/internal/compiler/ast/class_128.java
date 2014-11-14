package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.class_264;
import org.eclipse.jdt.internal.compiler.ast.class_126;
import org.eclipse.jdt.internal.compiler.ast.class_176;
import org.eclipse.jdt.internal.compiler.ast.class_89;
import org.eclipse.jdt.internal.compiler.codegen.class_268;
import org.eclipse.jdt.internal.compiler.flow.class_293;
import org.eclipse.jdt.internal.compiler.flow.class_301;
import org.eclipse.jdt.internal.compiler.impl.class_331;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.class_41;
import org.eclipse.jdt.internal.compiler.lookup.class_42;
import org.eclipse.jdt.internal.compiler.lookup.class_86;

public class class_128 extends class_126 {

    public class_126[] field_679;

    public class_42 field_680;

    public class_128() {
    }

    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        if (this.field_679 != null) {
            int var4 = 0;
            for (int var5 = this.field_679.length; var4 < var5; ++var4) {
                var3 = this.field_679[var4].method_814(var1, var2, (class_301)var3).method_3109();
            }
        }
        return (class_301)var3;
    }

    public void method_912(class_86 var1, class_268 var2, boolean var3) {
        int var4 = var2.field_1208;
        int var5 = this.field_679 == null ? 0 : this.field_679.length;
        var2.method_2188(var5);
        var2.method_2345(this.field_680);
        if (this.field_679 != null) {
            int var6 = this.field_680.field_193 > 1 ? -1 : this.field_680.field_192.field_177;
            for (int var7 = 0; var7 < var5; ++var7) {
                class_126 var8;
                if ((var8 = this.field_679[var7]).field_672 != class_331.field_1896) {
                    switch (var6) {
                        case 2:
                        case 3:
                        case 4:
                        case 7:
                        case 10:
                            if (var8.field_672.method_3285() != 0L) {
                                var2.method_2141();
                                var2.method_2188(var7);
                                var8.method_912(var1, var2, true);
                                var2.method_2100(var6, false);
                            }
                            break;
                        case 5:
                            if (var8.field_672.method_3257()) {
                                var2.method_2141();
                                var2.method_2188(var7);
                                var8.method_912(var1, var2, true);
                                var2.method_2100(var6, false);
                            }
                            break;
                        case 6:
                        default:
                            if (!(var8 instanceof class_176)) {
                                var2.method_2141();
                                var2.method_2188(var7);
                                var8.method_912(var1, var2, true);
                                var2.method_2100(var6, false);
                            }
                            break;
                        case 8:
                        case 9:
                            double var9 = var8.field_672.method_3281();
                            if (var9 == -0.0D || var9 != 0.0D) {
                                var2.method_2141();
                                var2.method_2188(var7);
                                var8.method_912(var1, var2, true);
                                var2.method_2100(var6, false);
                            }
                    }
                } else if (!(var8 instanceof class_176)) {
                    var2.method_2141();
                    var2.method_2188(var7);
                    var8.method_912(var1, var2, true);
                    var2.method_2100(var6, false);
                }
            }
        }
        if (var3) {
            var2.method_2182(this.field_674);
        } else {
            var2.method_2352();
        }
        var2.method_2360(var4, this.field_444);
    }

    public StringBuffer method_924(int var1, StringBuffer var2) {
        var2.append('{');
        if (this.field_679 != null) {
            int var3 = 20;
            for (int var4 = 0; var4 < this.field_679.length; ++var4) {
                if (var4 > 0) {
                    var2.append(", ");
                }
                this.field_679[var4].method_924(0, var2);
                --var3;
                if (var3 == 0) {
                    var2.append('\n');
                    method_759(var1 + 1, var2);
                    var3 = 20;
                }
            }
        }
        return var2.append('}');
    }

    public class_40 method_926(class_86 var1, class_40 var2) {
        this.field_672 = class_331.field_1896;
        int var4;
        if (var2 instanceof class_42) {
            class_40 var8;
            if ((this.field_446 & 1) == 0) {
                var8 = var2.method_173();
                if (!var8.method_167()) {
                    var1.method_644().method_1571(var8, this);
                }
            }
            this.field_675 = this.field_680 = (class_42)var2;
            if (this.field_679 == null) {
                return this.field_680;
            } else {
                var8 = this.field_680.method_187();
                var4 = 0;
                for (int var9 = this.field_679.length; var4 < var9; ++var4) {
                    class_126 var12 = this.field_679[var4];
                    var12.method_928(var8);
                    class_40 var11 = var12 instanceof class_128 ? var12.method_926(var1, var8) : var12.method_925(var1);
                    if (var11 != null) {
                        if (var8 != var11) {
                            var1.method_576().method_692(var8, var11);
                        }
                        if (!var12.method_919(var11, var8) && (!var8.method_148() || !class_41.method_185(var8.field_177, var11.field_177)) && !var11.method_152(var8)) {
                            if (!var1.method_624(var11, var8) && (!var11.method_148() || var1.method_577().field_1928 < 3211264L || var8.method_148() || !var12.method_919(var11, var1.method_586().method_486(var8)))) {
                                var1.method_644().method_1777(var11, var8, var12, (class_89)null);
                            } else {
                                var12.method_911(var1, var8, var11);
                            }
                        } else {
                            var12.method_911(var1, var8, var11);
                        }
                    }
                }
                return this.field_680;
            }
        } else {
            Object var3 = null;
            var4 = 1;
            if (this.field_679 == null) {
                var3 = var1.method_609();
            } else {
                class_126 var5;
                for (var5 = this.field_679[0]; var5 != null && var5 instanceof class_128; var5 = ((class_128)var5).field_679[0]) {
                    ++var4;
                    class_126[] var6 = ((class_128)var5).field_679;
                    if (var6 == null) {
                        var3 = var1.method_609();
                        var5 = null;
                        break;
                    }
                }
                if (var5 != null) {
                    var3 = var5.method_925(var1);
                }
                int var10 = 1;
                for (int var7 = this.field_679.length; var10 < var7; ++var10) {
                    var5 = this.field_679[var10];
                    if (var5 != null) {
                        var5.method_925(var1);
                    }
                }
            }
            if (var3 != null) {
                this.field_675 = var1.method_580((class_40)var3, var4);
                if (var2 != null) {
                    var1.method_644().method_1777(this.field_675, var2, this, (class_89)null);
                }
            }
            return null;
        }
    }

    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_1994(this, var2) && this.field_679 != null) {
            int var3 = this.field_679.length;
            for (int var4 = 0; var4 < var3; ++var4) {
                this.field_679[var4].method_763(var1, var2);
            }
        }
        var1.method_1909(this, var2);
    }
}
