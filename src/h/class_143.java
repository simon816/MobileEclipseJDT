package h;

import a.class_331;
import c.class_264;
import h.class_126;
import h.class_141;
import i.class_268;
import i.class_74;
import l.class_293;
import l.class_301;
import l.class_303;
import m.class_86;

public class class_143 extends class_141 {

    int field_718;

    int field_719;

    public class_143(class_126 var1, class_126 var2, int var3) {
        super(var1, var2, var3);
        this.field_718 = -1;
        this.field_719 = -1;
    }

    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        class_331 var4 = this.field_715.method_922();
        boolean var5 = var4 != class_331.field_1896 && var4.method_3257();
        boolean var6 = var4 != class_331.field_1896 && !var4.method_3257();
        class_301 var7;
        if (var5) {
            class_303 var11 = this.field_715.method_814(var1, var2, var3).method_3109();
            var7 = this.field_716.method_814(var1, var2, var11);
            this.field_719 = var1.method_635().method_729(var7);
            return var7;
        } else {
            var7 = this.field_715.method_814(var1, var2, var3);
            class_303 var8 = var7.method_3081().method_3107();
            this.field_718 = var1.method_635().method_729(var8);
            int var9 = var8.method_3102();
            if (var6) {
                var8.method_3104(1);
            }
            class_301 var12 = this.field_716.method_814(var1, var2, var8);
            class_301 var10 = class_301.method_3074(var12.method_3103(), var7.method_3080().method_3109().method_3105(var12.method_3080().method_3104(var9).method_3109()));
            this.field_719 = var1.method_635().method_729(var10);
            return var10;
        }
    }

    public void method_912(class_86 var1, class_268 var2, boolean var3) {
        int var4 = var2.field_1208;
        if (this.field_672 != class_331.field_1896) {
            if (var3) {
                var2.method_2179(this.field_672, this.field_674);
            }
            var2.method_2360(var4, this.field_444);
        } else {
            class_331 var5 = this.field_716.field_672;
            if (var5 != class_331.field_1896) {
                if (var5.method_3257()) {
                    this.field_715.method_912(var1, var2, var3);
                } else {
                    this.field_715.method_912(var1, var2, false);
                    if (var3) {
                        var2.method_2221();
                    }
                }
                if (this.field_719 != -1) {
                    var2.method_2363(var1, this.field_719);
                }
                var2.method_2182(this.field_674);
                var2.method_2380(var1, var2.field_1208);
                var2.method_2360(var4, this.field_444);
            } else {
                class_74 var6;
                boolean var8;
                boolean var9;
                boolean var10;
                boolean var11;
                label108: {
                    class_74 var10000 = new class_74(var2);
                    var6 = var10000;
                    var5 = this.field_715.method_922();
                    var8 = var5 != class_331.field_1896;
                    var9 = var8 && var5.method_3257();
                    var5 = this.field_716.method_922();
                    var10 = var5 != class_331.field_1896;
                    var11 = var10 && var5.method_3257();
                    if (var8) {
                        this.field_715.method_912(var1, var2, false);
                        if (!var9) {
                            break label108;
                        }
                    } else {
                        this.field_715.method_913(var1, var2, (class_74)null, var6, true);
                    }
                    if (this.field_718 != -1) {
                        var2.method_2088(var1, this.field_718);
                    }
                    if (var10) {
                        this.field_716.method_912(var1, var2, false);
                    } else {
                        this.field_716.method_913(var1, var2, (class_74)null, var6, var3);
                    }
                }
                if (this.field_719 != -1) {
                    var2.method_2363(var1, this.field_719);
                }
                if (var3) {
                    if (var8 && !var9) {
                        var2.method_2221();
                        var2.method_2380(var1, var2.field_1208);
                    } else {
                        if (var10 && !var11) {
                            var2.method_2221();
                            var2.method_2380(var1, var2.field_1208);
                        } else {
                            var2.method_2222();
                        }
                        if (var6.method_454() > 0) {
                            if ((this.field_446 & 16) != 0) {
                                var2.method_2182(this.field_674);
                                var2.method_2192(this);
                                var6.method_458();
                                var2.method_2221();
                            } else {
                                class_74 var10001 = new class_74(var2);
                                class_74 var7 = var10001;
                                var2.method_2209(var10001);
                                var2.method_2125(1);
                                var6.method_458();
                                var2.method_2221();
                                var7.method_458();
                            }
                        } else {
                            var6.method_458();
                        }
                    }
                    var2.method_2182(this.field_674);
                    var2.method_2380(var1, var2.field_1208);
                } else {
                    var6.method_458();
                }
            }
        }
    }

    public void method_913(class_86 var1, class_268 var2, class_74 var3, class_74 var4, boolean var5) {
        if (this.field_672 != class_331.field_1896) {
            super.method_913(var1, var2, var3, var4, var5);
        } else {
            class_331 var6 = this.field_716.field_672;
            if (var6 != class_331.field_1896 && var6.method_3257()) {
                int var12 = var2.field_1208;
                this.field_715.method_913(var1, var2, var3, var4, var5);
                if (this.field_719 != -1) {
                    var2.method_2363(var1, this.field_719);
                }
                var2.method_2360(var12, this.field_444);
            } else {
                var6 = this.field_715.method_922();
                boolean var7 = var6 != class_331.field_1896;
                boolean var8 = var7 && var6.method_3257();
                var6 = this.field_716.method_922();
                boolean var9 = var6 != class_331.field_1896;
                boolean var10 = var9 && var6.method_3257();
                if (var4 == null) {
                    if (var3 != null) {
                        class_74 var10000 = new class_74(var2);
                        class_74 var11 = var10000;
                        this.field_715.method_913(var1, var2, (class_74)null, var11, !var7);
                        if (var7 && !var8) {
                            var11.method_458();
                        } else {
                            if (this.field_718 != -1) {
                                var2.method_2088(var1, this.field_718);
                            }
                            this.field_716.method_913(var1, var2, var3, (class_74)null, var5 && !var9);
                            if (var5 && var9 && var10) {
                                var2.method_2209(var3);
                                var2.method_2380(var1, var2.field_1208);
                            }
                            var11.method_458();
                        }
                    }
                } else if (var3 == null) {
                    this.field_715.method_913(var1, var2, (class_74)null, var4, !var7);
                    if (var7 && !var8) {
                        if (var5) {
                            var2.method_2209(var4);
                        }
                        var2.method_2380(var1, var2.field_1208);
                    } else {
                        if (this.field_718 != -1) {
                            var2.method_2088(var1, this.field_718);
                        }
                        this.field_716.method_913(var1, var2, (class_74)null, var4, var5 && !var9);
                        if (var5 && var9 && !var10) {
                            var2.method_2209(var4);
                            var2.method_2380(var1, var2.field_1208);
                        }
                    }
                }
                if (this.field_719 != -1) {
                    var2.method_2363(var1, this.field_719);
                }
            }
        }
    }

    public boolean method_918() {
        return false;
    }

    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_1990(this, var2)) {
            this.field_715.method_763(var1, var2);
            this.field_716.method_763(var1, var2);
        }
        var1.method_1905(this, var2);
    }
}
