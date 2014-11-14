package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.class_264;
import org.eclipse.jdt.internal.compiler.ast.class_126;
import org.eclipse.jdt.internal.compiler.ast.class_130;
import org.eclipse.jdt.internal.compiler.ast.class_137;
import org.eclipse.jdt.internal.compiler.codegen.class_268;
import org.eclipse.jdt.internal.compiler.codegen.class_74;
import org.eclipse.jdt.internal.compiler.flow.class_293;
import org.eclipse.jdt.internal.compiler.flow.class_301;
import org.eclipse.jdt.internal.compiler.flow.class_303;
import org.eclipse.jdt.internal.compiler.impl.class_331;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.class_41;
import org.eclipse.jdt.internal.compiler.lookup.class_80;
import org.eclipse.jdt.internal.compiler.lookup.class_86;

public class class_138 extends class_137 {

    public class_126 field_702;

    public class_126 field_703;

    public class_126 field_704;

    public class_331 field_705;

    public class_331 field_706;

    public class_331 field_707;

    int field_708;

    int field_709;

    int field_710;

    public class_138(class_126 var1, class_126 var2, class_126 var3) {
        this.field_708 = -1;
        this.field_709 = -1;
        this.field_710 = -1;
        this.field_702 = var1;
        this.field_703 = var2;
        this.field_704 = var3;
        this.field_444 = var1.field_444;
        this.field_445 = var3.field_445;
    }

    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        class_331 var4 = this.field_702.method_922();
        boolean var5 = var4 != class_331.field_1896 && var4.method_3257();
        boolean var6 = var4 != class_331.field_1896 && !var4.method_3257();
        int var7 = var3.method_3102();
        var3 = this.field_702.method_907(var1, var2, var3, var4 == class_331.field_1896);
        class_301 var8 = var3.method_3081().method_3078();
        if (var6) {
            var8.method_3104(1);
        }
        this.field_708 = var1.method_635().method_729(var8);
        var8 = this.field_703.method_814(var1, var2, var8);
        class_301 var9 = var3.method_3080().method_3078();
        if (var5) {
            var9.method_3104(1);
        }
        this.field_709 = var1.method_635().method_729(var9);
        var9 = this.field_704.method_814(var1, var2, var9);
        class_301 var10;
        if (var5) {
            var10 = var8.method_3072(var9);
        } else if (var6) {
            var10 = var9.method_3072(var8);
        } else {
            var4 = this.field_706;
            boolean var11 = var4 != null && var4 != class_331.field_1896 && var4.method_3257();
            boolean var12 = var4 != null && var4 != class_331.field_1896 && !var4.method_3257();
            var4 = this.field_707;
            boolean var13 = var4 != null && var4 != class_331.field_1896 && var4.method_3257();
            boolean var14 = var4 != null && var4 != class_331.field_1896 && !var4.method_3257();
            class_303 var15 = var8.method_3081().method_3107();
            class_303 var16 = var9.method_3081().method_3107();
            class_303 var17 = var8.method_3080().method_3109();
            class_303 var18 = var9.method_3080().method_3109();
            if (var12) {
                var15.method_3104(1);
            }
            if (var14) {
                var16.method_3104(1);
            }
            if (var11) {
                var17.method_3104(1);
            }
            if (var13) {
                var18.method_3104(1);
            }
            var10 = class_301.method_3074(var15.method_3105(var16), var17.method_3105(var18));
        }
        this.field_710 = var1.method_635().method_729(var10);
        var10.method_3104(var7);
        return var10;
    }

    public void method_912(class_86 var1, class_268 var2, boolean var3) {
        int var4 = var2.field_1208;
        if (this.field_672 != class_331.field_1896) {
            if (var3) {
                var2.method_2179(this.field_672, this.field_674);
            }
            var2.method_2360(var4, this.field_444);
        } else {
            class_331 var7 = this.field_702.method_922();
            boolean var8 = var7 == class_331.field_1896 || var7.method_3257();
            boolean var9 = var7 == class_331.field_1896 || !var7.method_3257();
            class_74 var10000 = new class_74(var2);
            class_74 var5 = var10000;
            var10000 = new class_74(var2);
            class_74 var6 = var10000;
            var6.field_330 |= 2;
            this.field_702.method_913(var1, var2, (class_74)null, var6, var7 == class_331.field_1896);
            if (this.field_708 != -1) {
                var2.method_2363(var1, this.field_708);
                var2.method_2088(var1, this.field_708);
            }
            if (var8) {
                this.field_703.method_912(var1, var2, var3);
                if (var9) {
                    int var10 = var2.field_1208;
                    var2.method_2209(var5);
                    var2.method_2380(var1, var10);
                    if (var3) {
                        var2.method_2125(this.field_675 != class_40.field_183 && this.field_675 != class_40.field_185 ? 1 : 2);
                    }
                }
            }
            if (var9) {
                if (this.field_709 != -1) {
                    var2.method_2363(var1, this.field_709);
                    var2.method_2088(var1, this.field_709);
                }
                if (var6.method_454() > 0) {
                    var6.method_458();
                }
                this.field_704.method_912(var1, var2, var3);
                if (var3) {
                    var2.method_2359(this.field_675);
                }
                if (var8) {
                    var5.method_458();
                }
            }
            if (this.field_710 != -1) {
                var2.method_2363(var1, this.field_710);
            }
            if (var3) {
                var2.method_2182(this.field_674);
            }
            var2.method_2360(var4, this.field_444);
        }
    }

    public void method_913(class_86 var1, class_268 var2, class_74 var3, class_74 var4, boolean var5) {
        if ((this.field_672 == class_331.field_1896 || this.field_672.method_3288() != 5) && (this.field_703.field_674 & 255) >> 4 == 5) {
            class_331 var6 = this.field_702.field_672;
            class_331 var7 = this.field_702.method_922();
            boolean var8 = (var6 == class_331.field_1896 || var6.method_3257()) && (var7 == class_331.field_1896 || var7.method_3257());
            boolean var9 = (var6 == class_331.field_1896 || !var6.method_3257()) && (var7 == class_331.field_1896 || !var7.method_3257());
            class_74 var10000 = new class_74(var2);
            class_74 var11 = var10000;
            boolean var12 = var6 == class_331.field_1896 && var7 == class_331.field_1896;
            class_126 var14 = this.field_702;
            class_74 var10004 = new class_74(var2);
            class_74 var10 = var10004;
            var14.method_913(var1, var2, (class_74)null, var10004, var12);
            if (this.field_708 != -1) {
                var2.method_2363(var1, this.field_708);
                var2.method_2088(var1, this.field_708);
            }
            if (var8) {
                this.field_703.method_913(var1, var2, var3, var4, var5);
                if (var9) {
                    label79: {
                        boolean var13;
                        if (var4 == null) {
                            if (var3 != null) {
                                var6 = this.field_706;
                                var13 = var6 != null && var6 != class_331.field_1896 && var6.method_3257();
                                if (var13) {
                                    break label79;
                                }
                            }
                        } else if (var3 == null) {
                            var6 = this.field_706;
                            var13 = var6 != null && var6 != class_331.field_1896 && !var6.method_3257();
                            if (var13) {
                                break label79;
                            }
                        }
                        int var15 = var2.field_1208;
                        var2.method_2209(var11);
                        var2.method_2380(var1, var15);
                    }
                }
            }
            if (var9) {
                var10.method_458();
                if (this.field_709 != -1) {
                    var2.method_2363(var1, this.field_709);
                    var2.method_2088(var1, this.field_709);
                }
                this.field_704.method_913(var1, var2, var3, var4, var5);
                var11.method_458();
            }
            if (this.field_710 != -1) {
                var2.method_2363(var1, this.field_710);
            }
            var2.method_2380(var1, var2.field_1208);
        } else {
            super.method_913(var1, var2, var3, var4, var5);
        }
    }

    public int method_921(class_301 var1) {
        class_331 var2 = this.field_702.method_922();
        if (var2 != class_331.field_1896) {
            return var2.method_3257() ? this.field_703.method_921(var1) : this.field_704.method_921(var1);
        } else {
            int var3 = this.field_703.method_921(var1);
            int var4 = this.field_704.method_921(var1);
            return var3 == var4 ? var3 : 0;
        }
    }

    public class_331 method_922() {
        return this.field_705 == null ? this.field_672 : this.field_705;
    }

    public StringBuffer method_975(int var1, StringBuffer var2) {
        this.field_702.method_924(var1, var2).append(" ? ");
        this.field_703.method_924(0, var2).append(" : ");
        return this.field_704.method_924(0, var2);
    }

    public class_40 method_925(class_86 var1) {
        this.field_672 = class_331.field_1896;
        class_80 var2 = var1.method_586();
        boolean var3 = var1.method_577().field_1928 >= 3211264L;
        class_40 var4 = this.field_702.method_926(var1, class_40.field_186);
        this.field_702.method_911(var1, class_40.field_186, var4);
        if (this.field_703 instanceof class_130) {
            this.field_703.field_446 |= 32;
        }
        class_40 var5 = this.field_703.method_925(var1);
        if (this.field_704 instanceof class_130) {
            this.field_704.field_446 |= 32;
        }
        class_40 var6 = this.field_704.method_925(var1);
        if (var4 != null && var5 != null && var6 != null) {
            class_40 var7 = var5;
            class_40 var8 = var6;
            if (var3 && var5 != var6) {
                class_40 var9;
                if (var5.method_148()) {
                    if (var6.method_148()) {
                        if (var5 == class_40.field_187) {
                            var8 = var2.method_486(var6);
                        } else if (var6 == class_40.field_187) {
                            var7 = var2.method_486(var5);
                        }
                    } else {
                        var9 = var6.method_148() ? var6 : var2.method_486(var6);
                        if (var5.method_161() && var9.method_161()) {
                            var8 = var9;
                        } else if (var5 != class_40.field_187) {
                            var8 = var2.method_486(var6);
                        }
                    }
                } else if (var6.method_148()) {
                    var9 = var5.method_148() ? var5 : var2.method_486(var5);
                    if (var9.method_161() && var6.method_161()) {
                        var7 = var9;
                    } else if (var6 != class_40.field_187) {
                        var7 = var2.method_486(var5);
                    }
                } else {
                    var9 = var2.method_486(var5);
                    class_40 var10 = var2.method_486(var6);
                    if (var9.method_161() && var10.method_161()) {
                        var7 = var9;
                        var8 = var10;
                    }
                }
            }
            class_331 var13 = this.field_702.field_672;
            if (this.field_702.field_672 != class_331.field_1896) {
                class_331 var14 = this.field_703.field_672;
                if (this.field_703.field_672 != class_331.field_1896) {
                    class_331 var11 = this.field_704.field_672;
                    if (this.field_704.field_672 != class_331.field_1896) {
                        this.field_672 = var13.method_3257() ? var14 : var11;
                    }
                }
            }
            if (var7 == var8) {
                this.field_703.method_911(var1, var7, var5);
                this.field_704.method_911(var1, var8, var6);
                if (var7 == class_40.field_186) {
                    this.field_706 = this.field_703.method_922();
                    this.field_707 = this.field_704.method_922();
                    if (this.field_706 != class_331.field_1896 && this.field_707 != class_331.field_1896 && this.field_706.method_3257() == this.field_707.method_3257()) {
                        this.field_705 = this.field_706;
                    } else if ((var13 = this.field_702.method_922()) != class_331.field_1896) {
                        this.field_705 = var13.method_3257() ? this.field_706 : this.field_707;
                    }
                }
                return this.field_675 = var7;
            } else if (var7.method_161() && var8.method_161()) {
                if ((var7 != class_40.field_180 || var8 != class_40.field_181) && (var7 != class_40.field_181 || var8 != class_40.field_180)) {
                    if ((var7 == class_40.field_180 || var7 == class_40.field_181 || var7 == class_40.field_182) && var8 == class_40.field_179 && this.field_704.method_919(var8, var7)) {
                        this.field_703.method_911(var1, var7, var5);
                        this.field_704.method_911(var1, var7, var6);
                        return this.field_675 = var7;
                    } else if ((var8 == class_40.field_180 || var8 == class_40.field_181 || var8 == class_40.field_182) && var7 == class_40.field_179 && this.field_703.method_919(var7, var8)) {
                        this.field_703.method_911(var1, var8, var5);
                        this.field_704.method_911(var1, var8, var6);
                        return this.field_675 = var8;
                    } else if (class_41.method_184(var7.field_177, 10) && class_41.method_184(var8.field_177, 10)) {
                        this.field_703.method_911(var1, class_40.field_179, var5);
                        this.field_704.method_911(var1, class_40.field_179, var6);
                        return this.field_675 = class_40.field_179;
                    } else if (class_41.method_184(var7.field_177, 7) && class_41.method_184(var8.field_177, 7)) {
                        this.field_703.method_911(var1, class_40.field_183, var5);
                        this.field_704.method_911(var1, class_40.field_183, var6);
                        return this.field_675 = class_40.field_183;
                    } else if (class_41.method_184(var7.field_177, 9) && class_41.method_184(var8.field_177, 9)) {
                        this.field_703.method_911(var1, class_40.field_184, var5);
                        this.field_704.method_911(var1, class_40.field_184, var6);
                        return this.field_675 = class_40.field_184;
                    } else {
                        this.field_703.method_911(var1, class_40.field_185, var5);
                        this.field_704.method_911(var1, class_40.field_185, var6);
                        return this.field_675 = class_40.field_185;
                    }
                } else {
                    this.field_703.method_911(var1, class_40.field_181, var5);
                    this.field_704.method_911(var1, class_40.field_181, var6);
                    return this.field_675 = class_40.field_181;
                }
            } else {
                if (var7.method_148() && var7 != class_40.field_187) {
                    if (!var3) {
                        var1.method_644().method_1509(this, var7, var8);
                        return null;
                    }
                    var7 = var2.method_486(var7);
                }
                if (var8.method_148() && var8 != class_40.field_187) {
                    if (!var3) {
                        var1.method_644().method_1509(this, var7, var8);
                        return null;
                    }
                    var8 = var2.method_486(var8);
                }
                if (var3) {
                    class_40 var12 = null;
                    if (var7 == class_40.field_187) {
                        var12 = var8;
                    } else if (var8 == class_40.field_187) {
                        var12 = var7;
                    } else {
                        var12 = var1.method_633(new class_40[] {var7, var8});
                    }
                    if (var12 != null) {
                        this.field_703.method_911(var1, var12, var5);
                        this.field_704.method_911(var1, var12, var6);
                        return this.field_675 = var12.method_130(var1, this.field_445);
                    }
                } else {
                    if (var8.method_152(var7)) {
                        this.field_703.method_911(var1, var7, var5);
                        this.field_704.method_911(var1, var7, var6);
                        return this.field_675 = var7;
                    }
                    if (var7.method_152(var8)) {
                        this.field_703.method_911(var1, var8, var5);
                        this.field_704.method_911(var1, var8, var6);
                        return this.field_675 = var8;
                    }
                }
                var1.method_644().method_1509(this, var7, var8);
                return null;
            }
        } else {
            return null;
        }
    }

    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2011(this, var2)) {
            this.field_702.method_763(var1, var2);
            this.field_703.method_763(var1, var2);
            this.field_704.method_763(var1, var2);
        }
        var1.method_1926(this, var2);
    }
}
