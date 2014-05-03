package h;

import a.class_331;
import a.class_340;
import c.class_264;
import h.class_126;
import h.class_130;
import h.class_141;
import h.class_176;
import i.class_268;
import i.class_74;
import l.class_293;
import l.class_301;
import l.class_303;
import m.class_40;
import m.class_43;
import m.class_65;
import m.class_86;

// $FF: renamed from: h.d
public class class_142 extends class_141 {

    // $FF: renamed from: <init> (h.r, h.r, int) void
    public class_142(class_126 var1, class_126 var2, int var3) {
        super(var1, var2, var3);
    }

    // $FF: renamed from: a (m.v, l.j, l.g, l.g, l.g) void
    private void method_994(class_86 var1, class_293 var2, class_301 var3, class_301 var4, class_301 var5) {
        class_65 var6 = this.field_715.method_920();
        if (var6 != null && (var6.field_301.field_178 & 2L) == 0L) {
            this.method_995(var1, var2, var3, var4, var5, var6, this.field_716.method_921(var3), this.field_715);
        }
        var6 = this.field_716.method_920();
        if (var6 != null && (var6.field_301.field_178 & 2L) == 0L) {
            this.method_995(var1, var2, var3, var4, var5, var6, this.field_715.method_921(var3), this.field_716);
        }
    }

    // $FF: renamed from: a (m.v, l.j, l.g, l.g, l.g, m.ab, int, h.r) void
    private void method_995(class_86 var1, class_293 var2, class_301 var3, class_301 var4, class_301 var5, class_65 var6, int var7, class_126 var8) {
        switch (var7) {
            case -1:
                if ((this.field_446 & 4032) >> 6 == 18) {
                    var2.method_3050(var1, var6, var8, 513, var3);
                    var4.method_3094(var6);
                } else {
                    var2.method_3050(var1, var6, var8, 257, var3);
                }
                break;
            case 1:
                if ((this.field_446 & 4032) >> 6 == 18) {
                    var2.method_3050(var1, var6, var8, 256, var3);
                    var4.method_3095(var6);
                    var5.method_3094(var6);
                } else {
                    var2.method_3050(var1, var6, var8, 512, var3);
                    var4.method_3094(var6);
                    var5.method_3095(var6);
                }
        }
    }

    // $FF: renamed from: a (m.v, l.j, l.g) l.g
    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        Object var4;
        if ((this.field_446 & 4032) >> 6 == 18) {
            if (this.field_715.field_672 != class_331.field_1896 && this.field_715.field_672.method_3288() == 5) {
                if (this.field_715.field_672.method_3257()) {
                    var4 = this.field_716.method_814(var1, var2, var3);
                } else {
                    var4 = this.field_716.method_814(var1, var2, var3).method_3073();
                }
            } else if (this.field_716.field_672 != class_331.field_1896 && this.field_716.field_672.method_3288() == 5) {
                if (this.field_716.field_672.method_3257()) {
                    var4 = this.field_715.method_814(var1, var2, var3);
                } else {
                    var4 = this.field_715.method_814(var1, var2, var3).method_3073();
                }
            } else {
                var4 = this.field_716.method_814(var1, var2, this.field_715.method_814(var1, var2, var3).method_3109()).method_3109();
            }
        } else if (this.field_715.field_672 != class_331.field_1896 && this.field_715.field_672.method_3288() == 5) {
            if (!this.field_715.field_672.method_3257()) {
                var4 = this.field_716.method_814(var1, var2, var3);
            } else {
                var4 = this.field_716.method_814(var1, var2, var3).method_3073();
            }
        } else if (this.field_716.field_672 != class_331.field_1896 && this.field_716.field_672.method_3288() == 5) {
            if (!this.field_716.field_672.method_3257()) {
                var4 = this.field_715.method_814(var1, var2, var3);
            } else {
                var4 = this.field_715.method_814(var1, var2, var3).method_3073();
            }
        } else {
            var4 = this.field_716.method_814(var1, var2, this.field_715.method_814(var1, var2, var3).method_3109()).method_3109();
        }
        if (var4 instanceof class_303 && (((class_301)var4).field_1783 & 1) == 0) {
            var4 = class_301.method_3074(((class_301)var4).method_3078(), ((class_301)var4).method_3078());
        }
        this.method_994(var1, var2, (class_301)var4, ((class_301)var4).method_3081(), ((class_301)var4).method_3080());
        return (class_301)var4;
    }

    // $FF: renamed from: a (m.s, m.s) void
    public final void method_996(class_40 var1, class_40 var2) {
        if (this.field_715.field_672 != class_331.field_1896 && this.field_716.field_672 != class_331.field_1896) {
            this.field_672 = class_331.method_3266(this.field_715.field_672, var1.field_177, this.field_716.field_672, var2.field_177);
            if ((this.field_446 & 4032) >> 6 == 29) {
                this.field_672 = class_340.method_3307(!this.field_672.method_3257());
            }
        } else {
            this.field_672 = class_331.field_1896;
        }
    }

    // $FF: renamed from: a (m.v, i.o, boolean) void
    public void method_912(class_86 var1, class_268 var2, boolean var3) {
        int var4 = var2.field_1208;
        if (this.field_672 != class_331.field_1896) {
            if (var3) {
                var2.method_2179(this.field_672, this.field_674);
            }
            var2.method_2360(var4, this.field_444);
        } else {
            if ((this.field_715.field_674 & 15) == 5) {
                this.method_997(var1, var2, var3);
            } else {
                this.method_999(var1, var2, var3);
            }
            if (var3) {
                var2.method_2182(this.field_674);
            }
            var2.method_2360(var4, this.field_444);
        }
    }

    // $FF: renamed from: a (m.v, i.o, i.s, i.s, boolean) void
    public void method_913(class_86 var1, class_268 var2, class_74 var3, class_74 var4, boolean var5) {
        if (this.field_672 != class_331.field_1896) {
            super.method_913(var1, var2, var3, var4, var5);
        } else {
            if ((this.field_446 & 4032) >> 6 == 18) {
                if ((this.field_715.field_674 & 15) == 5) {
                    this.method_998(var1, var2, var3, var4, var5);
                } else {
                    this.method_1000(var1, var2, var3, var4, var5);
                }
            } else if ((this.field_715.field_674 & 15) == 5) {
                this.method_998(var1, var2, var4, var3, var5);
            } else {
                this.method_1000(var1, var2, var4, var3, var5);
            }
        }
    }

    // $FF: renamed from: b (m.v, i.o, boolean) void
    public void method_997(class_86 var1, class_268 var2, boolean var3) {
        boolean var4 = (this.field_446 & 4032) >> 6 == 18;
        class_331 var5 = this.field_715.method_922();
        class_74 var7;
        class_74 var10000;
        if (var5 != class_331.field_1896) {
            class_331 var9 = this.field_716.method_922();
            if (var9 != class_331.field_1896) {
                this.field_715.method_912(var1, var2, false);
                this.field_716.method_912(var1, var2, false);
                if (var3) {
                    boolean var10 = var5.method_3257();
                    boolean var8 = var9.method_3257();
                    if (var4) {
                        if (var10 == var8) {
                            var2.method_2222();
                        } else {
                            var2.method_2221();
                        }
                    } else if (var10 != var8) {
                        var2.method_2222();
                    } else {
                        var2.method_2221();
                    }
                }
            } else if (var5.method_3257() == var4) {
                this.field_715.method_912(var1, var2, false);
                this.field_716.method_912(var1, var2, var3);
            } else if (var3) {
                var10000 = new class_74(var2);
                var7 = var10000;
                this.field_715.method_912(var1, var2, false);
                this.field_716.method_913(var1, var2, (class_74)null, var7, var3);
                var2.method_2221();
                if ((this.field_446 & 16) != 0) {
                    var2.method_2182(this.field_674);
                    var2.method_2192(this);
                    var7.method_458();
                    var2.method_2222();
                } else {
                    var10000 = new class_74(var2);
                    class_74 var11 = var10000;
                    var2.method_2209(var11);
                    var2.method_2125(1);
                    var7.method_458();
                    var2.method_2222();
                    var11.method_458();
                }
            } else {
                this.field_715.method_912(var1, var2, false);
                this.field_716.method_912(var1, var2, false);
            }
        } else {
            var5 = this.field_716.method_922();
            class_74 var6;
            if (var5 != class_331.field_1896) {
                if (var5.method_3257() == var4) {
                    this.field_715.method_912(var1, var2, var3);
                    this.field_716.method_912(var1, var2, false);
                } else if (var3) {
                    var10000 = new class_74(var2);
                    var6 = var10000;
                    this.field_715.method_913(var1, var2, (class_74)null, var6, var3);
                    this.field_716.method_912(var1, var2, false);
                    var2.method_2221();
                    if ((this.field_446 & 16) != 0) {
                        var2.method_2182(this.field_674);
                        var2.method_2192(this);
                        var6.method_458();
                        var2.method_2222();
                    } else {
                        var10000 = new class_74(var2);
                        var7 = var10000;
                        var2.method_2209(var7);
                        var2.method_2125(1);
                        var6.method_458();
                        var2.method_2222();
                        var7.method_458();
                    }
                } else {
                    this.field_715.method_912(var1, var2, false);
                    this.field_716.method_912(var1, var2, false);
                }
            } else {
                this.field_715.method_912(var1, var2, var3);
                this.field_716.method_912(var1, var2, var3);
                if (var3) {
                    if (var4) {
                        class_74 var10001 = new class_74(var2);
                        var6 = var10001;
                        var2.method_2236(var10001);
                        var2.method_2222();
                        if ((this.field_446 & 16) != 0) {
                            var2.method_2182(this.field_674);
                            var2.method_2192(this);
                            var6.method_458();
                            var2.method_2221();
                        } else {
                            var10000 = new class_74(var2);
                            var7 = var10000;
                            var2.method_2209(var7);
                            var2.method_2125(1);
                            var6.method_458();
                            var2.method_2221();
                            var7.method_458();
                        }
                    } else {
                        var2.method_2296();
                    }
                }
            }
        }
    }

    // $FF: renamed from: b (m.v, i.o, i.s, i.s, boolean) void
    public void method_998(class_86 var1, class_268 var2, class_74 var3, class_74 var4, boolean var5) {
        boolean var6;
        if (this.field_715.field_672 != class_331.field_1896) {
            var6 = this.field_715.field_672.method_3257();
            this.field_716.method_913(var1, var2, var6 ? var3 : var4, var6 ? var4 : var3, var5);
        } else if (this.field_716.field_672 != class_331.field_1896) {
            var6 = this.field_716.field_672.method_3257();
            this.field_715.method_913(var1, var2, var6 ? var3 : var4, var6 ? var4 : var3, var5);
        } else {
            this.field_715.method_912(var1, var2, var5);
            this.field_716.method_912(var1, var2, var5);
            if (var5) {
                if (var4 == null) {
                    if (var3 != null) {
                        var2.method_2231(var3);
                    }
                } else if (var3 == null) {
                    var2.method_2236(var4);
                }
            }
            var2.method_2380(var1, var2.field_1208);
        }
    }

    // $FF: renamed from: c (m.v, i.o, boolean) void
    public void method_999(class_86 var1, class_268 var2, boolean var3) {
        boolean var4 = (this.field_446 & 4032) >> 6 == 18;
        class_74 var6;
        class_74 var10000;
        if ((this.field_715.field_674 & 255) >> 4 == 10) {
            class_331 var5 = this.field_715.field_672;
            class_74 var7;
            if (this.field_715.field_672 != class_331.field_1896 && var5.method_3284() == 0) {
                this.field_716.method_912(var1, var2, var3);
                if (var3) {
                    var10000 = new class_74(var2);
                    var6 = var10000;
                    if (var4) {
                        var2.method_2242(var6);
                    } else {
                        var2.method_2237(var6);
                    }
                    var2.method_2222();
                    if ((this.field_446 & 16) != 0) {
                        var2.method_2182(this.field_674);
                        var2.method_2192(this);
                        var6.method_458();
                        var2.method_2221();
                    } else {
                        var10000 = new class_74(var2);
                        var7 = var10000;
                        var2.method_2209(var7);
                        var2.method_2125(1);
                        var6.method_458();
                        var2.method_2221();
                        var7.method_458();
                    }
                }
                return;
            }
            var5 = this.field_716.field_672;
            if (this.field_716.field_672 != class_331.field_1896 && var5.method_3284() == 0) {
                this.field_715.method_912(var1, var2, var3);
                if (var3) {
                    var10000 = new class_74(var2);
                    var6 = var10000;
                    if (var4) {
                        var2.method_2242(var6);
                    } else {
                        var2.method_2237(var6);
                    }
                    var2.method_2222();
                    if ((this.field_446 & 16) != 0) {
                        var2.method_2182(this.field_674);
                        var2.method_2192(this);
                        var6.method_458();
                        var2.method_2221();
                    } else {
                        var10000 = new class_74(var2);
                        var7 = var10000;
                        var2.method_2209(var7);
                        var2.method_2125(1);
                        var6.method_458();
                        var2.method_2221();
                        var7.method_458();
                    }
                }
                return;
            }
        }
        class_74 var8;
        if (this.field_716 instanceof class_176) {
            if (this.field_715 instanceof class_176) {
                if (var3) {
                    if (var4) {
                        var2.method_2222();
                    } else {
                        var2.method_2221();
                    }
                }
            } else {
                this.field_715.method_912(var1, var2, var3);
                if (var3) {
                    var10000 = new class_74(var2);
                    var8 = var10000;
                    if (var4) {
                        var2.method_2243(var8);
                    } else {
                        var2.method_2244(var8);
                    }
                    var2.method_2222();
                    if ((this.field_446 & 16) != 0) {
                        var2.method_2182(this.field_674);
                        var2.method_2192(this);
                        var8.method_458();
                        var2.method_2221();
                    } else {
                        var10000 = new class_74(var2);
                        var6 = var10000;
                        var2.method_2209(var6);
                        var2.method_2125(1);
                        var8.method_458();
                        var2.method_2221();
                        var6.method_458();
                    }
                }
            }
        } else if (this.field_715 instanceof class_176) {
            this.field_716.method_912(var1, var2, var3);
            if (var3) {
                var10000 = new class_74(var2);
                var8 = var10000;
                if (var4) {
                    var2.method_2243(var8);
                } else {
                    var2.method_2244(var8);
                }
                var2.method_2222();
                if ((this.field_446 & 16) != 0) {
                    var2.method_2182(this.field_674);
                    var2.method_2192(this);
                    var8.method_458();
                    var2.method_2221();
                } else {
                    var10000 = new class_74(var2);
                    var6 = var10000;
                    var2.method_2209(var6);
                    var2.method_2125(1);
                    var8.method_458();
                    var2.method_2221();
                    var6.method_458();
                }
            }
        } else {
            this.field_715.method_912(var1, var2, var3);
            this.field_716.method_912(var1, var2, var3);
            if (var3) {
                var10000 = new class_74(var2);
                var8 = var10000;
                if (var4) {
                    switch ((this.field_715.field_674 & 255) >> 4) {
                        case 7:
                            var2.method_2306();
                            var2.method_2242(var8);
                            break;
                        case 8:
                            var2.method_2121();
                            var2.method_2242(var8);
                            break;
                        case 9:
                            var2.method_2156();
                            var2.method_2242(var8);
                            break;
                        case 10:
                            var2.method_2236(var8);
                            break;
                        default:
                            var2.method_2230(var8);
                    }
                } else {
                    switch ((this.field_715.field_674 & 255) >> 4) {
                        case 7:
                            var2.method_2306();
                            var2.method_2237(var8);
                            break;
                        case 8:
                            var2.method_2121();
                            var2.method_2237(var8);
                            break;
                        case 9:
                            var2.method_2156();
                            var2.method_2237(var8);
                            break;
                        case 10:
                            var2.method_2231(var8);
                            break;
                        default:
                            var2.method_2229(var8);
                    }
                }
                var2.method_2222();
                if ((this.field_446 & 16) != 0) {
                    var2.method_2182(this.field_674);
                    var2.method_2192(this);
                    var8.method_458();
                    var2.method_2221();
                } else {
                    var10000 = new class_74(var2);
                    var6 = var10000;
                    var2.method_2209(var6);
                    var2.method_2125(1);
                    var8.method_458();
                    var2.method_2221();
                    var6.method_458();
                }
            }
        }
    }

    // $FF: renamed from: c (m.v, i.o, i.s, i.s, boolean) void
    public void method_1000(class_86 var1, class_268 var2, class_74 var3, class_74 var4, boolean var5) {
        int var6 = var2.field_1208;
        class_331 var7 = this.field_716.field_672;
        if (this.field_716.field_672 != class_331.field_1896 && (this.field_715.field_674 & 255) >> 4 == 10 && var7.method_3284() == 0) {
            this.field_715.method_912(var1, var2, var5);
            if (var5) {
                if (var4 == null) {
                    if (var3 != null) {
                        var2.method_2237(var3);
                    }
                } else if (var3 == null) {
                    var2.method_2242(var4);
                }
            }
            var2.method_2360(var6, this.field_444);
        } else {
            var7 = this.field_715.field_672;
            if (this.field_715.field_672 != class_331.field_1896 && (this.field_715.field_674 & 255) >> 4 == 10 && var7.method_3284() == 0) {
                this.field_716.method_912(var1, var2, var5);
                if (var5) {
                    if (var4 == null) {
                        if (var3 != null) {
                            var2.method_2237(var3);
                        }
                    } else if (var3 == null) {
                        var2.method_2242(var4);
                    }
                }
                var2.method_2360(var6, this.field_444);
            } else if (this.field_716 instanceof class_176) {
                if (this.field_715 instanceof class_176) {
                    if (var5 && var4 == null && var3 != null) {
                        var2.method_2209(var3);
                    }
                } else {
                    this.field_715.method_912(var1, var2, var5);
                    if (var5) {
                        if (var4 == null) {
                            if (var3 != null) {
                                var2.method_2244(var3);
                            }
                        } else if (var3 == null) {
                            var2.method_2243(var4);
                        }
                    }
                }
                var2.method_2360(var6, this.field_444);
            } else if (this.field_715 instanceof class_176) {
                this.field_716.method_912(var1, var2, var5);
                if (var5) {
                    if (var4 == null) {
                        if (var3 != null) {
                            var2.method_2244(var3);
                        }
                    } else if (var3 == null) {
                        var2.method_2243(var4);
                    }
                }
                var2.method_2360(var6, this.field_444);
            } else {
                this.field_715.method_912(var1, var2, var5);
                this.field_716.method_912(var1, var2, var5);
                if (var5) {
                    if (var4 == null) {
                        if (var3 != null) {
                            switch ((this.field_715.field_674 & 255) >> 4) {
                                case 7:
                                    var2.method_2306();
                                    var2.method_2237(var3);
                                    break;
                                case 8:
                                    var2.method_2121();
                                    var2.method_2237(var3);
                                    break;
                                case 9:
                                    var2.method_2156();
                                    var2.method_2237(var3);
                                    break;
                                case 10:
                                    var2.method_2231(var3);
                                    break;
                                default:
                                    var2.method_2229(var3);
                            }
                        }
                    } else if (var3 == null) {
                        switch ((this.field_715.field_674 & 255) >> 4) {
                            case 7:
                                var2.method_2306();
                                var2.method_2242(var4);
                                break;
                            case 8:
                                var2.method_2121();
                                var2.method_2242(var4);
                                break;
                            case 9:
                                var2.method_2156();
                                var2.method_2242(var4);
                                break;
                            case 10:
                                var2.method_2236(var4);
                                break;
                            default:
                                var2.method_2230(var4);
                        }
                    }
                }
                var2.method_2360(var6, this.field_444);
            }
        }
    }

    // $FF: renamed from: a () boolean
    public boolean method_918() {
        return false;
    }

    // $FF: renamed from: a (m.v) m.s
    public class_40 method_925(class_86 var1) {
        boolean var2;
        if (var2 = this.field_715 instanceof class_130) {
            this.field_715.field_446 |= 32;
        }
        class_40 var4 = this.field_715.method_925(var1);
        boolean var3;
        if (var3 = this.field_716 instanceof class_130) {
            this.field_716.field_446 |= 32;
        }
        class_40 var5 = this.field_716.method_925(var1);
        if (var4 != null && var5 != null) {
            boolean var6 = var1.method_577().field_1928 >= 3211264L;
            class_40 var7 = var4;
            class_40 var8 = var5;
            if (var6) {
                if (var4 != class_40.field_187 && var4.method_148()) {
                    if (!var5.method_148()) {
                        var8 = var1.method_586().method_486(var5);
                    }
                } else if (var5 != class_40.field_187 && var5.method_148()) {
                    var7 = var1.method_586().method_486(var4);
                }
            }
            if (var7.method_148() && var8.method_148()) {
                int var14 = var7.field_177;
                int var16 = var8.field_177;
                int var15 = field_701[18][(var14 << 4) + var16];
                this.field_715.method_911(var1, class_40.method_128(var1, var15 >>> 16 & 15), var4);
                this.field_716.method_911(var1, class_40.method_128(var1, var15 >>> 8 & 15), var5);
                this.field_446 |= var15 & 15;
                if ((var15 & 15) == 0) {
                    this.field_672 = class_331.field_1896;
                    var1.method_644().method_1634(this, var7, var8);
                    return null;
                } else {
                    if (var2 || var3) {
                        class_130.method_938(var1, 18, var15, this.field_715, var7.field_177, var2, this.field_716, var8.field_177, var3);
                    }
                    this.method_996(var7, var8);
                    return this.field_675 = class_40.field_186;
                }
            } else if ((!var7.method_148() || var7 == class_40.field_187) && (!var8.method_148() || var8 == class_40.field_187) && (this.method_908(var1, var7, var8, (class_126)null) || this.method_908(var1, var8, var7, (class_126)null))) {
                if (var8.field_177 == 11 && var7.field_177 == 11) {
                    this.method_996(var7, var8);
                } else {
                    this.field_672 = class_331.field_1896;
                }
                class_43 var9 = var1.method_609();
                this.field_715.method_911(var1, var9, var7);
                this.field_716.method_911(var1, var9, var8);
                boolean var10 = (this.field_715.field_446 & 16384) != 0;
                boolean var11 = (this.field_716.field_446 & 16384) != 0;
                if (var10 || var11) {
                    class_40 var12 = var10 ? ((class_130)this.field_715).field_684.field_675 : var7;
                    class_40 var13 = var11 ? ((class_130)this.field_716).field_684.field_675 : var8;
                    if (this.method_908(var1, var12, var13, (class_126)null) || this.method_908(var1, var13, var12, (class_126)null)) {
                        if (var10) {
                            var1.method_644().method_1790((class_130)this.field_715);
                        }
                        if (var11) {
                            var1.method_644().method_1790((class_130)this.field_716);
                        }
                    }
                }
                return this.field_675 = class_40.field_186;
            } else {
                this.field_672 = class_331.field_1896;
                var1.method_644().method_1708(this, var7, var8);
                return null;
            }
        } else {
            this.field_672 = class_331.field_1896;
            return null;
        }
    }

    // $FF: renamed from: a (c.j, m.v) void
    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2017(this, var2)) {
            this.field_715.method_763(var1, var2);
            this.field_716.method_763(var1, var2);
        }
        var1.method_1932(this, var2);
    }
}
