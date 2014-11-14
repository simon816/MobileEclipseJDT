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
import org.eclipse.jdt.internal.compiler.lookup.class_42;
import org.eclipse.jdt.internal.compiler.lookup.class_86;

public class class_141 extends class_137 {

    public class_126 field_715;

    public class_126 field_716;

    public class_331 field_717;

    public class_141(class_126 var1, class_126 var2, int var3) {
        this.field_715 = var1;
        this.field_716 = var2;
        this.field_446 |= var3 << 6;
        this.field_444 = var1.field_444;
        this.field_445 = var2.field_445;
    }

    public class_141(class_141 var1) {
        this.field_715 = var1.field_715;
        this.field_716 = var1.field_716;
        this.field_446 = var1.field_446;
        this.field_444 = var1.field_444;
        this.field_445 = var1.field_445;
    }

    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        if (this.field_675.field_177 == 11) {
            return this.field_716.method_814(var1, var2, this.field_715.method_814(var1, var2, var3).method_3109()).method_3109();
        } else {
            this.field_715.method_909(var1, var2, var3);
            class_303 var4 = this.field_715.method_814(var1, var2, var3).method_3109();
            this.field_716.method_909(var1, var2, var4);
            return this.field_716.method_814(var1, var2, var4).method_3109();
        }
    }

    public void method_981(class_86 var1, int var2, int var3) {
        if (this.field_715.field_672 != class_331.field_1896 && this.field_716.field_672 != class_331.field_1896) {
            try {
                this.field_672 = class_331.method_3262(this.field_715.field_672, var2, (this.field_446 & 4032) >> 6, this.field_716.field_672, var3);
            } catch (ArithmeticException var5) {
                this.field_672 = class_331.field_1896;
            }
        } else {
            this.field_672 = class_331.field_1896;
            this.method_993(var2, (this.field_446 & 4032) >> 6, var3);
        }
    }

    public class_331 method_922() {
        return this.field_717 == null ? this.field_672 : this.field_717;
    }

    public void method_912(class_86 var1, class_268 var2, boolean var3) {
        int var4 = var2.field_1208;
        if (this.field_672 != class_331.field_1896) {
            if (var3) {
                var2.method_2179(this.field_672, this.field_674);
            }
            var2.method_2360(var4, this.field_444);
        } else {
            class_74 var5;
            class_74 var6;
            class_74 var10004;
            class_74 var10001;
            label314:
            switch ((this.field_446 & 4032) >> 6) {
                case 2:
                    switch (this.field_446 & 15) {
                        case 5:
                            this.method_986(var1, var2, var3);
                            break label314;
                        case 7:
                            if (this.field_715.field_672 != class_331.field_1896 && this.field_715.field_672.method_3288() == 7 && this.field_715.field_672.method_3285() == 0L) {
                                this.field_716.method_912(var1, var2, false);
                                if (var3) {
                                    var2.method_2307();
                                }
                            } else if (this.field_716.field_672 != class_331.field_1896 && this.field_716.field_672.method_3288() == 7 && this.field_716.field_672.method_3285() == 0L) {
                                this.field_715.method_912(var1, var2, false);
                                if (var3) {
                                    var2.method_2307();
                                }
                            } else {
                                this.field_715.method_912(var1, var2, var3);
                                this.field_716.method_912(var1, var2, var3);
                                if (var3) {
                                    var2.method_2304();
                                }
                            }
                            break label314;
                        case 10:
                            if (this.field_715.field_672 != class_331.field_1896 && this.field_715.field_672.method_3288() == 10 && this.field_715.field_672.method_3284() == 0) {
                                this.field_716.method_912(var1, var2, false);
                                if (var3) {
                                    var2.method_2221();
                                }
                            } else if (this.field_716.field_672 != class_331.field_1896 && this.field_716.field_672.method_3288() == 10 && this.field_716.field_672.method_3284() == 0) {
                                this.field_715.method_912(var1, var2, false);
                                if (var3) {
                                    var2.method_2221();
                                }
                            } else {
                                this.field_715.method_912(var1, var2, var3);
                                this.field_716.method_912(var1, var2, var3);
                                if (var3) {
                                    var2.method_2219();
                                }
                            }
                        default:
                            break label314;
                    }
                case 3:
                    switch (this.field_446 & 15) {
                        case 5:
                            this.method_987(var1, var2, var3);
                            break label314;
                        case 7:
                            if (this.field_715.field_672 != class_331.field_1896 && this.field_715.field_672.method_3288() == 7 && this.field_715.field_672.method_3285() == 0L) {
                                this.field_716.method_912(var1, var2, var3);
                            } else if (this.field_716.field_672 != class_331.field_1896 && this.field_716.field_672.method_3288() == 7 && this.field_716.field_672.method_3285() == 0L) {
                                this.field_715.method_912(var1, var2, var3);
                            } else {
                                this.field_715.method_912(var1, var2, var3);
                                this.field_716.method_912(var1, var2, var3);
                                if (var3) {
                                    var2.method_2327();
                                }
                            }
                            break label314;
                        case 10:
                            if (this.field_715.field_672 != class_331.field_1896 && this.field_715.field_672.method_3288() == 10 && this.field_715.field_672.method_3284() == 0) {
                                this.field_716.method_912(var1, var2, var3);
                            } else if (this.field_716.field_672 != class_331.field_1896 && this.field_716.field_672.method_3288() == 10 && this.field_716.field_672.method_3284() == 0) {
                                this.field_715.method_912(var1, var2, var3);
                            } else {
                                this.field_715.method_912(var1, var2, var3);
                                this.field_716.method_912(var1, var2, var3);
                                if (var3) {
                                    var2.method_2283();
                                }
                            }
                        default:
                            break label314;
                    }
                case 4:
                    var10004 = new class_74(var2);
                    var5 = var10004;
                    this.method_984(var1, var2, (class_74)null, var10004, var3);
                    if (var3) {
                        var2.method_2222();
                        if ((this.field_446 & 16) != 0) {
                            var2.method_2182(this.field_674);
                            var2.method_2192(this);
                            var5.method_458();
                            var2.method_2221();
                        } else {
                            var10001 = new class_74(var2);
                            var6 = var10001;
                            var2.method_2209(var10001);
                            var2.method_2125(1);
                            var5.method_458();
                            var2.method_2221();
                            var6.method_458();
                        }
                    }
                    break;
                case 5:
                    var10004 = new class_74(var2);
                    var5 = var10004;
                    this.method_985(var1, var2, (class_74)null, var10004, var3);
                    if (var3) {
                        var2.method_2222();
                        if ((this.field_446 & 16) != 0) {
                            var2.method_2182(this.field_674);
                            var2.method_2192(this);
                            var5.method_458();
                            var2.method_2221();
                        } else {
                            var10001 = new class_74(var2);
                            var6 = var10001;
                            var2.method_2209(var10001);
                            var2.method_2125(1);
                            var5.method_458();
                            var2.method_2221();
                            var6.method_458();
                        }
                    }
                    break;
                case 6:
                    var10004 = new class_74(var2);
                    var5 = var10004;
                    this.method_982(var1, var2, (class_74)null, var10004, var3);
                    if (var3) {
                        var2.method_2222();
                        if ((this.field_446 & 16) != 0) {
                            var2.method_2182(this.field_674);
                            var2.method_2192(this);
                            var5.method_458();
                            var2.method_2221();
                        } else {
                            var10001 = new class_74(var2);
                            var6 = var10001;
                            var2.method_2209(var10001);
                            var2.method_2125(1);
                            var5.method_458();
                            var2.method_2221();
                            var6.method_458();
                        }
                    }
                    break;
                case 7:
                    var10004 = new class_74(var2);
                    var5 = var10004;
                    this.method_983(var1, var2, (class_74)null, var10004, var3);
                    if (var3) {
                        var2.method_2222();
                        if ((this.field_446 & 16) != 0) {
                            var2.method_2182(this.field_674);
                            var2.method_2192(this);
                            var5.method_458();
                            var2.method_2221();
                        } else {
                            var10001 = new class_74(var2);
                            var6 = var10001;
                            var2.method_2209(var10001);
                            var2.method_2125(1);
                            var5.method_458();
                            var2.method_2221();
                            var6.method_458();
                        }
                    }
                    break;
                case 8:
                    switch (this.field_446 & 15) {
                        case 5:
                            this.method_988(var1, var2, var3);
                            break label314;
                        case 7:
                            if (this.field_715.field_672 != class_331.field_1896 && this.field_715.field_672.method_3288() == 7 && this.field_715.field_672.method_3285() == 0L) {
                                this.field_716.method_912(var1, var2, var3);
                            } else if (this.field_716.field_672 != class_331.field_1896 && this.field_716.field_672.method_3288() == 7 && this.field_716.field_672.method_3285() == 0L) {
                                this.field_715.method_912(var1, var2, var3);
                            } else {
                                this.field_715.method_912(var1, var2, var3);
                                this.field_716.method_912(var1, var2, var3);
                                if (var3) {
                                    var2.method_2339();
                                }
                            }
                            break label314;
                        case 10:
                            if (this.field_715.field_672 != class_331.field_1896 && this.field_715.field_672.method_3288() == 10 && this.field_715.field_672.method_3284() == 0) {
                                this.field_716.method_912(var1, var2, var3);
                            } else if (this.field_716.field_672 != class_331.field_1896 && this.field_716.field_672.method_3288() == 10 && this.field_716.field_672.method_3284() == 0) {
                                this.field_715.method_912(var1, var2, var3);
                            } else {
                                this.field_715.method_912(var1, var2, var3);
                                this.field_716.method_912(var1, var2, var3);
                                if (var3) {
                                    var2.method_2296();
                                }
                            }
                        default:
                            break label314;
                    }
                case 9:
                    switch (this.field_446 & 15) {
                        case 7:
                            this.field_715.method_912(var1, var2, true);
                            this.field_716.method_912(var1, var2, true);
                            var2.method_2316();
                            if (!var3) {
                                var2.method_2353();
                            }
                            break label314;
                        case 8:
                            this.field_715.method_912(var1, var2, var3);
                            this.field_716.method_912(var1, var2, var3);
                            if (var3) {
                                var2.method_2124();
                            }
                            break label314;
                        case 9:
                            this.field_715.method_912(var1, var2, var3);
                            this.field_716.method_912(var1, var2, var3);
                            if (var3) {
                                var2.method_2160();
                            }
                            break label314;
                        case 10:
                            this.field_715.method_912(var1, var2, true);
                            this.field_716.method_912(var1, var2, true);
                            var2.method_2228();
                            if (!var3) {
                                var2.method_2352();
                            }
                        default:
                            break label314;
                    }
                case 10:
                    switch (this.field_446 & 15) {
                        case 7:
                            this.field_715.method_912(var1, var2, var3);
                            this.field_716.method_912(var1, var2, var3);
                            if (var3) {
                                var2.method_2330();
                            }
                            break;
                        case 10:
                            this.field_715.method_912(var1, var2, var3);
                            this.field_716.method_912(var1, var2, var3);
                            if (var3) {
                                var2.method_2287();
                            }
                    }
                case 11:
                case 12:
                case 18:
                default:
                    break;
                case 13:
                    switch (this.field_446 & 15) {
                        case 7:
                            this.field_715.method_912(var1, var2, var3);
                            this.field_716.method_912(var1, var2, var3);
                            if (var3) {
                                var2.method_2337();
                            }
                            break label314;
                        case 8:
                            this.field_715.method_912(var1, var2, var3);
                            this.field_716.method_912(var1, var2, var3);
                            if (var3) {
                                var2.method_2140();
                            }
                            break label314;
                        case 9:
                            this.field_715.method_912(var1, var2, var3);
                            this.field_716.method_912(var1, var2, var3);
                            if (var3) {
                                var2.method_2175();
                            }
                            break label314;
                        case 10:
                            this.field_715.method_912(var1, var2, var3);
                            this.field_716.method_912(var1, var2, var3);
                            if (var3) {
                                var2.method_2294();
                            }
                        default:
                            break label314;
                    }
                case 14:
                    switch (this.field_446 & 15) {
                        case 7:
                            this.field_715.method_912(var1, var2, var3);
                            this.field_716.method_912(var1, var2, var3);
                            if (var3) {
                                var2.method_2302();
                            }
                            break label314;
                        case 8:
                            this.field_715.method_912(var1, var2, var3);
                            this.field_716.method_912(var1, var2, var3);
                            if (var3) {
                                var2.method_2117();
                            }
                            break label314;
                        case 9:
                            this.field_715.method_912(var1, var2, var3);
                            this.field_716.method_912(var1, var2, var3);
                            if (var3) {
                                var2.method_2152();
                            }
                            break label314;
                        case 10:
                            this.field_715.method_912(var1, var2, var3);
                            this.field_716.method_912(var1, var2, var3);
                            if (var3) {
                                var2.method_2217();
                            }
                            break label314;
                        case 11:
                            var2.method_2193(var1, this.field_715, this.field_716);
                            if (!var3) {
                                var2.method_2352();
                            }
                        default:
                            break label314;
                    }
                case 15:
                    switch (this.field_446 & 15) {
                        case 7:
                            this.field_715.method_912(var1, var2, var3);
                            this.field_716.method_912(var1, var2, var3);
                            if (var3) {
                                var2.method_2322();
                            }
                            break label314;
                        case 8:
                            this.field_715.method_912(var1, var2, var3);
                            this.field_716.method_912(var1, var2, var3);
                            if (var3) {
                                var2.method_2131();
                            }
                            break label314;
                        case 9:
                            this.field_715.method_912(var1, var2, var3);
                            this.field_716.method_912(var1, var2, var3);
                            if (var3) {
                                var2.method_2166();
                            }
                            break label314;
                        case 10:
                            this.field_715.method_912(var1, var2, var3);
                            this.field_716.method_912(var1, var2, var3);
                            if (var3) {
                                var2.method_2251();
                            }
                        default:
                            break label314;
                    }
                case 16:
                    switch (this.field_446 & 15) {
                        case 7:
                            this.field_715.method_912(var1, var2, true);
                            this.field_716.method_912(var1, var2, true);
                            var2.method_2328();
                            if (!var3) {
                                var2.method_2353();
                            }
                            break label314;
                        case 8:
                            this.field_715.method_912(var1, var2, var3);
                            this.field_716.method_912(var1, var2, var3);
                            if (var3) {
                                var2.method_2133();
                            }
                            break label314;
                        case 9:
                            this.field_715.method_912(var1, var2, var3);
                            this.field_716.method_912(var1, var2, var3);
                            if (var3) {
                                var2.method_2168();
                            }
                            break label314;
                        case 10:
                            this.field_715.method_912(var1, var2, true);
                            this.field_716.method_912(var1, var2, true);
                            var2.method_2284();
                            if (!var3) {
                                var2.method_2352();
                            }
                        default:
                            break label314;
                    }
                case 17:
                    switch (this.field_446 & 15) {
                        case 7:
                            this.field_715.method_912(var1, var2, var3);
                            this.field_716.method_912(var1, var2, var3);
                            if (var3) {
                                var2.method_2331();
                            }
                            break label314;
                        case 10:
                            this.field_715.method_912(var1, var2, var3);
                            this.field_716.method_912(var1, var2, var3);
                            if (var3) {
                                var2.method_2288();
                            }
                        default:
                            break label314;
                    }
                case 19:
                    switch (this.field_446 & 15) {
                        case 7:
                            this.field_715.method_912(var1, var2, var3);
                            this.field_716.method_912(var1, var2, var3);
                            if (var3) {
                                var2.method_2338();
                            }
                            break;
                        case 10:
                            this.field_715.method_912(var1, var2, var3);
                            this.field_716.method_912(var1, var2, var3);
                            if (var3) {
                                var2.method_2295();
                            }
                    }
            }
            if (var3) {
                var2.method_2182(this.field_674);
            }
            var2.method_2360(var4, this.field_444);
        }
    }

    public void method_913(class_86 var1, class_268 var2, class_74 var3, class_74 var4, boolean var5) {
        if (this.field_672 != class_331.field_1896 && this.field_672.method_3288() == 5) {
            super.method_913(var1, var2, var3, var4, var5);
        } else {
            switch ((this.field_446 & 4032) >> 6) {
                case 2:
                    this.method_989(var1, var2, var3, var4, var5);
                    return;
                case 3:
                    this.method_990(var1, var2, var3, var4, var5);
                    return;
                case 4:
                    this.method_984(var1, var2, var3, var4, var5);
                    return;
                case 5:
                    this.method_985(var1, var2, var3, var4, var5);
                    return;
                case 6:
                    this.method_982(var1, var2, var3, var4, var5);
                    return;
                case 7:
                    this.method_983(var1, var2, var3, var4, var5);
                    return;
                case 8:
                    this.method_991(var1, var2, var3, var4, var5);
                    return;
                default:
                    super.method_913(var1, var2, var3, var4, var5);
            }
        }
    }

    public void method_982(class_86 var1, class_268 var2, class_74 var3, class_74 var4, boolean var5) {
        int var6 = (this.field_715.field_674 & 255) >> 4;
        if (var6 == 10) {
            if (this.field_715.field_672 != class_331.field_1896 && this.field_715.field_672.method_3284() == 0) {
                this.field_716.method_912(var1, var2, var5);
                if (var5) {
                    if (var4 == null) {
                        if (var3 != null) {
                            var2.method_2241(var3);
                        }
                    } else if (var3 == null) {
                        var2.method_2238(var4);
                    }
                }
                var2.method_2380(var1, var2.field_1208);
                return;
            }
            if (this.field_716.field_672 != class_331.field_1896 && this.field_716.field_672.method_3284() == 0) {
                this.field_715.method_912(var1, var2, var5);
                if (var5) {
                    if (var4 == null) {
                        if (var3 != null) {
                            var2.method_2239(var3);
                        }
                    } else if (var3 == null) {
                        var2.method_2240(var4);
                    }
                }
                var2.method_2380(var1, var2.field_1208);
                return;
            }
        }
        this.field_715.method_912(var1, var2, var5);
        this.field_716.method_912(var1, var2, var5);
        if (var5) {
            if (var4 == null) {
                if (var3 != null) {
                    switch (var6) {
                        case 7:
                            var2.method_2306();
                            var2.method_2239(var3);
                            break;
                        case 8:
                            var2.method_2121();
                            var2.method_2239(var3);
                            break;
                        case 9:
                            var2.method_2156();
                            var2.method_2239(var3);
                            break;
                        case 10:
                            var2.method_2233(var3);
                    }
                    var2.method_2380(var1, var2.field_1208);
                    return;
                }
            } else if (var3 == null) {
                switch (var6) {
                    case 7:
                        var2.method_2306();
                        var2.method_2240(var4);
                        break;
                    case 8:
                        var2.method_2121();
                        var2.method_2240(var4);
                        break;
                    case 9:
                        var2.method_2156();
                        var2.method_2240(var4);
                        break;
                    case 10:
                        var2.method_2234(var4);
                }
                var2.method_2380(var1, var2.field_1208);
                return;
            }
        }
    }

    public void method_983(class_86 var1, class_268 var2, class_74 var3, class_74 var4, boolean var5) {
        int var6 = (this.field_715.field_674 & 255) >> 4;
        if (var6 == 10) {
            if (this.field_715.field_672 != class_331.field_1896 && this.field_715.field_672.method_3284() == 0) {
                this.field_716.method_912(var1, var2, var5);
                if (var5) {
                    if (var4 == null) {
                        if (var3 != null) {
                            var2.method_2240(var3);
                        }
                    } else if (var3 == null) {
                        var2.method_2239(var4);
                    }
                }
                var2.method_2380(var1, var2.field_1208);
                return;
            }
            if (this.field_716.field_672 != class_331.field_1896 && this.field_716.field_672.method_3284() == 0) {
                this.field_715.method_912(var1, var2, var5);
                if (var5) {
                    if (var4 == null) {
                        if (var3 != null) {
                            var2.method_2238(var3);
                        }
                    } else if (var3 == null) {
                        var2.method_2241(var4);
                    }
                }
                var2.method_2380(var1, var2.field_1208);
                return;
            }
        }
        this.field_715.method_912(var1, var2, var5);
        this.field_716.method_912(var1, var2, var5);
        if (var5) {
            if (var4 == null) {
                if (var3 != null) {
                    switch (var6) {
                        case 7:
                            var2.method_2306();
                            var2.method_2238(var3);
                            break;
                        case 8:
                            var2.method_2121();
                            var2.method_2238(var3);
                            break;
                        case 9:
                            var2.method_2156();
                            var2.method_2238(var3);
                            break;
                        case 10:
                            var2.method_2232(var3);
                    }
                    var2.method_2380(var1, var2.field_1208);
                    return;
                }
            } else if (var3 == null) {
                switch (var6) {
                    case 7:
                        var2.method_2306();
                        var2.method_2241(var4);
                        break;
                    case 8:
                        var2.method_2121();
                        var2.method_2241(var4);
                        break;
                    case 9:
                        var2.method_2156();
                        var2.method_2241(var4);
                        break;
                    case 10:
                        var2.method_2235(var4);
                }
                var2.method_2380(var1, var2.field_1208);
                return;
            }
        }
    }

    public void method_984(class_86 var1, class_268 var2, class_74 var3, class_74 var4, boolean var5) {
        int var6 = (this.field_715.field_674 & 255) >> 4;
        if (var6 == 10) {
            if (this.field_715.field_672 != class_331.field_1896 && this.field_715.field_672.method_3284() == 0) {
                this.field_716.method_912(var1, var2, var5);
                if (var5) {
                    if (var4 == null) {
                        if (var3 != null) {
                            var2.method_2239(var3);
                        }
                    } else if (var3 == null) {
                        var2.method_2240(var4);
                    }
                }
                var2.method_2380(var1, var2.field_1208);
                return;
            }
            if (this.field_716.field_672 != class_331.field_1896 && this.field_716.field_672.method_3284() == 0) {
                this.field_715.method_912(var1, var2, var5);
                if (var5) {
                    if (var4 == null) {
                        if (var3 != null) {
                            var2.method_2241(var3);
                        }
                    } else if (var3 == null) {
                        var2.method_2238(var4);
                    }
                }
                var2.method_2380(var1, var2.field_1208);
                return;
            }
        }
        this.field_715.method_912(var1, var2, var5);
        this.field_716.method_912(var1, var2, var5);
        if (var5) {
            if (var4 == null) {
                if (var3 != null) {
                    switch (var6) {
                        case 7:
                            var2.method_2306();
                            var2.method_2241(var3);
                            break;
                        case 8:
                            var2.method_2120();
                            var2.method_2241(var3);
                            break;
                        case 9:
                            var2.method_2155();
                            var2.method_2241(var3);
                            break;
                        case 10:
                            var2.method_2235(var3);
                    }
                    var2.method_2380(var1, var2.field_1208);
                    return;
                }
            } else if (var3 == null) {
                switch (var6) {
                    case 7:
                        var2.method_2306();
                        var2.method_2238(var4);
                        break;
                    case 8:
                        var2.method_2120();
                        var2.method_2238(var4);
                        break;
                    case 9:
                        var2.method_2155();
                        var2.method_2238(var4);
                        break;
                    case 10:
                        var2.method_2232(var4);
                }
                var2.method_2380(var1, var2.field_1208);
                return;
            }
        }
    }

    public void method_985(class_86 var1, class_268 var2, class_74 var3, class_74 var4, boolean var5) {
        int var6 = (this.field_715.field_674 & 255) >> 4;
        if (var6 == 10) {
            if (this.field_715.field_672 != class_331.field_1896 && this.field_715.field_672.method_3284() == 0) {
                this.field_716.method_912(var1, var2, var5);
                if (var5) {
                    if (var4 == null) {
                        if (var3 != null) {
                            var2.method_2238(var3);
                        }
                    } else if (var3 == null) {
                        var2.method_2241(var4);
                    }
                }
                var2.method_2380(var1, var2.field_1208);
                return;
            }
            if (this.field_716.field_672 != class_331.field_1896 && this.field_716.field_672.method_3284() == 0) {
                this.field_715.method_912(var1, var2, var5);
                if (var5) {
                    if (var4 == null) {
                        if (var3 != null) {
                            var2.method_2240(var3);
                        }
                    } else if (var3 == null) {
                        var2.method_2239(var4);
                    }
                }
                var2.method_2380(var1, var2.field_1208);
                return;
            }
        }
        this.field_715.method_912(var1, var2, var5);
        this.field_716.method_912(var1, var2, var5);
        if (var5) {
            if (var4 == null) {
                if (var3 != null) {
                    switch (var6) {
                        case 7:
                            var2.method_2306();
                            var2.method_2240(var3);
                            break;
                        case 8:
                            var2.method_2120();
                            var2.method_2240(var3);
                            break;
                        case 9:
                            var2.method_2155();
                            var2.method_2240(var3);
                            break;
                        case 10:
                            var2.method_2234(var3);
                    }
                    var2.method_2380(var1, var2.field_1208);
                    return;
                }
            } else if (var3 == null) {
                switch (var6) {
                    case 7:
                        var2.method_2306();
                        var2.method_2239(var4);
                        break;
                    case 8:
                        var2.method_2120();
                        var2.method_2239(var4);
                        break;
                    case 9:
                        var2.method_2155();
                        var2.method_2239(var4);
                        break;
                    case 10:
                        var2.method_2233(var4);
                }
                var2.method_2380(var1, var2.field_1208);
                return;
            }
        }
    }

    public void method_986(class_86 var1, class_268 var2, boolean var3) {
        if ((this.field_715.field_674 & 15) == 5) {
            class_331 var4;
            if ((var4 = this.field_715.method_922()) != class_331.field_1896) {
                if (var4.method_3257()) {
                    this.field_715.method_912(var1, var2, false);
                    this.field_716.method_912(var1, var2, var3);
                } else {
                    this.field_715.method_912(var1, var2, false);
                    this.field_716.method_912(var1, var2, false);
                    if (var3) {
                        var2.method_2221();
                    }
                    var2.method_2380(var1, var2.field_1208);
                }
                return;
            }
            if ((var4 = this.field_716.method_922()) != class_331.field_1896) {
                if (var4.method_3257()) {
                    this.field_715.method_912(var1, var2, var3);
                    this.field_716.method_912(var1, var2, false);
                } else {
                    this.field_715.method_912(var1, var2, false);
                    this.field_716.method_912(var1, var2, false);
                    if (var3) {
                        var2.method_2221();
                    }
                    var2.method_2380(var1, var2.field_1208);
                }
                return;
            }
        }
        this.field_715.method_912(var1, var2, var3);
        this.field_716.method_912(var1, var2, var3);
        if (var3) {
            var2.method_2219();
        }
        var2.method_2380(var1, var2.field_1208);
    }

    public void method_987(class_86 var1, class_268 var2, boolean var3) {
        if ((this.field_715.field_674 & 15) == 5) {
            class_331 var4;
            if ((var4 = this.field_715.method_922()) != class_331.field_1896) {
                if (var4.method_3257()) {
                    this.field_715.method_912(var1, var2, false);
                    this.field_716.method_912(var1, var2, false);
                    if (var3) {
                        var2.method_2222();
                    }
                    var2.method_2380(var1, var2.field_1208);
                } else {
                    this.field_715.method_912(var1, var2, false);
                    this.field_716.method_912(var1, var2, var3);
                }
                return;
            }
            if ((var4 = this.field_716.method_922()) != class_331.field_1896) {
                if (var4.method_3257()) {
                    this.field_715.method_912(var1, var2, false);
                    this.field_716.method_912(var1, var2, false);
                    if (var3) {
                        var2.method_2222();
                    }
                    var2.method_2380(var1, var2.field_1208);
                } else {
                    this.field_715.method_912(var1, var2, var3);
                    this.field_716.method_912(var1, var2, false);
                }
                return;
            }
        }
        this.field_715.method_912(var1, var2, var3);
        this.field_716.method_912(var1, var2, var3);
        if (var3) {
            var2.method_2283();
        }
        var2.method_2380(var1, var2.field_1208);
    }

    public void method_988(class_86 var1, class_268 var2, boolean var3) {
        if ((this.field_715.field_674 & 15) == 5) {
            class_331 var4;
            if ((var4 = this.field_715.method_922()) != class_331.field_1896) {
                if (var4.method_3257()) {
                    this.field_715.method_912(var1, var2, false);
                    if (var3) {
                        var2.method_2222();
                    }
                    this.field_716.method_912(var1, var2, var3);
                    if (var3) {
                        var2.method_2296();
                        var2.method_2380(var1, var2.field_1208);
                    }
                } else {
                    this.field_715.method_912(var1, var2, false);
                    this.field_716.method_912(var1, var2, var3);
                }
                return;
            }
            if ((var4 = this.field_716.method_922()) != class_331.field_1896) {
                if (var4.method_3257()) {
                    this.field_715.method_912(var1, var2, var3);
                    this.field_716.method_912(var1, var2, false);
                    if (var3) {
                        var2.method_2222();
                        var2.method_2296();
                        var2.method_2380(var1, var2.field_1208);
                    }
                } else {
                    this.field_715.method_912(var1, var2, var3);
                    this.field_716.method_912(var1, var2, false);
                }
                return;
            }
        }
        this.field_715.method_912(var1, var2, var3);
        this.field_716.method_912(var1, var2, var3);
        if (var3) {
            var2.method_2296();
        }
        var2.method_2380(var1, var2.field_1208);
    }

    public void method_989(class_86 var1, class_268 var2, class_74 var3, class_74 var4, boolean var5) {
        if ((this.field_715.field_674 & 15) == 5) {
            class_331 var6;
            if ((var6 = this.field_715.method_922()) != class_331.field_1896) {
                if (var6.method_3257()) {
                    this.field_715.method_913(var1, var2, var3, var4, false);
                    this.field_716.method_913(var1, var2, var3, var4, var5);
                } else {
                    this.field_715.method_913(var1, var2, var3, var4, false);
                    this.field_716.method_913(var1, var2, var3, var4, false);
                    if (var5 && var4 != null) {
                        var2.method_2209(var4);
                    }
                    var2.method_2380(var1, var2.field_1208);
                }
                return;
            }
            if ((var6 = this.field_716.method_922()) != class_331.field_1896) {
                if (var6.method_3257()) {
                    this.field_715.method_913(var1, var2, var3, var4, var5);
                    this.field_716.method_913(var1, var2, var3, var4, false);
                } else {
                    class_74 var10000 = new class_74(var2);
                    class_74 var7 = var10000;
                    this.field_715.method_913(var1, var2, var7, var4, false);
                    var7.method_458();
                    this.field_716.method_913(var1, var2, var3, var4, false);
                    if (var5 && var4 != null) {
                        var2.method_2209(var4);
                    }
                    var2.method_2380(var1, var2.field_1208);
                }
                return;
            }
        }
        this.field_715.method_912(var1, var2, var5);
        this.field_716.method_912(var1, var2, var5);
        if (var5) {
            var2.method_2219();
            if (var4 == null) {
                if (var3 != null) {
                    var2.method_2242(var3);
                }
            } else if (var3 == null) {
                var2.method_2237(var4);
            }
        }
        var2.method_2380(var1, var2.field_1208);
    }

    public void method_990(class_86 var1, class_268 var2, class_74 var3, class_74 var4, boolean var5) {
        if ((this.field_715.field_674 & 15) == 5) {
            class_331 var6;
            class_74 var7;
            class_74 var10000;
            if ((var6 = this.field_715.method_922()) != class_331.field_1896) {
                if (var6.method_3257()) {
                    this.field_715.method_913(var1, var2, var3, var4, false);
                    var10000 = new class_74(var2);
                    var7 = var10000;
                    this.field_716.method_913(var1, var2, var3, var7, false);
                    var7.method_458();
                    if (var5 && var3 != null) {
                        var2.method_2209(var3);
                    }
                    var2.method_2380(var1, var2.field_1208);
                } else {
                    this.field_715.method_913(var1, var2, var3, var4, false);
                    this.field_716.method_913(var1, var2, var3, var4, var5);
                }
                return;
            }
            if ((var6 = this.field_716.method_922()) != class_331.field_1896) {
                if (var6.method_3257()) {
                    var10000 = new class_74(var2);
                    var7 = var10000;
                    this.field_715.method_913(var1, var2, var3, var7, false);
                    var7.method_458();
                    this.field_716.method_913(var1, var2, var3, var4, false);
                    if (var5 && var3 != null) {
                        var2.method_2209(var3);
                    }
                    var2.method_2380(var1, var2.field_1208);
                } else {
                    this.field_715.method_913(var1, var2, var3, var4, var5);
                    this.field_716.method_913(var1, var2, var3, var4, false);
                }
                return;
            }
        }
        this.field_715.method_912(var1, var2, var5);
        this.field_716.method_912(var1, var2, var5);
        if (var5) {
            var2.method_2283();
            if (var4 == null) {
                if (var3 != null) {
                    var2.method_2242(var3);
                }
            } else if (var3 == null) {
                var2.method_2237(var4);
            }
        }
        var2.method_2380(var1, var2.field_1208);
    }

    public void method_991(class_86 var1, class_268 var2, class_74 var3, class_74 var4, boolean var5) {
        if ((this.field_715.field_674 & 15) == 5) {
            class_331 var6;
            if ((var6 = this.field_715.method_922()) != class_331.field_1896) {
                if (var6.method_3257()) {
                    this.field_715.method_913(var1, var2, var3, var4, false);
                    this.field_716.method_913(var1, var2, var4, var3, var5);
                } else {
                    this.field_715.method_913(var1, var2, var3, var4, false);
                    this.field_716.method_913(var1, var2, var3, var4, var5);
                }
                return;
            }
            if ((var6 = this.field_716.method_922()) != class_331.field_1896) {
                if (var6.method_3257()) {
                    this.field_715.method_913(var1, var2, var4, var3, var5);
                    this.field_716.method_913(var1, var2, var3, var4, false);
                } else {
                    this.field_715.method_913(var1, var2, var3, var4, var5);
                    this.field_716.method_913(var1, var2, var3, var4, false);
                }
                return;
            }
        }
        this.field_715.method_912(var1, var2, var5);
        this.field_716.method_912(var1, var2, var5);
        if (var5) {
            var2.method_2296();
            if (var4 == null) {
                if (var3 != null) {
                    var2.method_2242(var3);
                }
            } else if (var3 == null) {
                var2.method_2237(var4);
            }
        }
        var2.method_2380(var1, var2.field_1208);
    }

    public void method_914(class_86 var1, class_268 var2, int var3) {
        if ((this.field_446 & 4032) >> 6 == 14 && (this.field_446 & 15) == 11) {
            if (this.field_672 != class_331.field_1896) {
                var2.method_2179(this.field_672, this.field_674);
                var2.method_2274(this.field_674 & 15);
            } else {
                int var4 = var2.field_1208;
                this.field_715.method_914(var1, var2, this.field_715.field_674 & 15);
                var2.method_2360(var4, this.field_715.field_444);
                var4 = var2.field_1208;
                this.field_716.method_914(var1, var2, this.field_716.field_674 & 15);
                var2.method_2360(var4, this.field_716.field_444);
            }
        } else {
            super.method_914(var1, var2, var3);
        }
    }

    public void method_915(class_86 var1, class_268 var2, int var3) {
        if ((this.field_446 & 4032) >> 6 == 14 && (this.field_446 & 15) == 11) {
            if (this.field_672 != class_331.field_1896) {
                var2.method_2349();
                var2.method_2141();
                var2.method_2311(this.field_672.method_3287());
                var2.method_2276();
            } else {
                int var4 = var2.field_1208;
                this.field_715.method_915(var1, var2, this.field_715.field_674 & 15);
                var2.method_2360(var4, this.field_715.field_444);
                var4 = var2.field_1208;
                this.field_716.method_914(var1, var2, this.field_716.field_674 & 15);
                var2.method_2360(var4, this.field_716.field_444);
            }
        } else {
            super.method_915(var1, var2, var3);
        }
    }

    public boolean method_918() {
        return true;
    }

    void method_992(class_86 var1) {
        class_40 var4 = this.field_715.field_675;
        boolean var3;
        if (var3 = this.field_716 instanceof class_130) {
            this.field_716.field_446 |= 32;
        }
        class_40 var5 = this.field_716.method_925(var1);
        if (var4 != null && var5 != null) {
            int var6 = var4.field_177;
            int var7 = var5.field_177;
            boolean var8 = var1.method_577().field_1928 >= 3211264L;
            if (var8) {
                if (!var4.method_148() && var7 != 11 && var7 != 12) {
                    var6 = var1.method_586().method_486(var4).field_177;
                }
                if (!var5.method_148() && var6 != 11 && var6 != 12) {
                    var7 = var1.method_586().method_486(var5).field_177;
                }
            }
            if (var6 > 15 || var7 > 15) {
                if (var6 == 11) {
                    var7 = 1;
                } else {
                    if (var7 != 11) {
                        this.field_672 = class_331.field_1896;
                        var1.method_644().method_1634(this, var4, var5);
                        return;
                    }
                    var6 = 1;
                }
            }
            if ((this.field_446 & 4032) >> 6 == 14) {
                if (var6 == 11) {
                    this.field_715.method_911(var1, var4, var4);
                    if (var5.method_147() && ((class_42)var5).method_187() == class_40.field_182) {
                        var1.method_644().method_1755(this.field_716);
                    }
                }
                if (var7 == 11) {
                    this.field_716.method_911(var1, var5, var5);
                    if (var4.method_147() && ((class_42)var4).method_187() == class_40.field_182) {
                        var1.method_644().method_1755(this.field_715);
                    }
                }
            }
            int var9 = (this.field_446 & 4032) >> 6;
            int var10 = class_137.field_701[var9][(var6 << 4) + var7];
            this.field_715.method_911(var1, class_40.method_128(var1, var10 >>> 16 & 15), var4);
            this.field_716.method_911(var1, class_40.method_128(var1, var10 >>> 8 & 15), var5);
            this.field_446 |= var10 & 15;
            switch (var10 & 15) {
                case 2:
                    this.field_675 = class_40.field_182;
                    break;
                case 3:
                    this.field_675 = class_40.field_180;
                    break;
                case 4:
                case 6:
                default:
                    this.field_672 = class_331.field_1896;
                    var1.method_644().method_1634(this, var4, var5);
                    return;
                case 5:
                    this.field_675 = class_40.field_186;
                    break;
                case 7:
                    this.field_675 = class_40.field_183;
                    break;
                case 8:
                    this.field_675 = class_40.field_185;
                    break;
                case 9:
                    this.field_675 = class_40.field_184;
                    break;
                case 10:
                    this.field_675 = class_40.field_179;
                    break;
                case 11:
                    this.field_675 = var1.method_610();
            }
            boolean var2;
            if ((var2 = this.field_715 instanceof class_130) || var3) {
                class_130.method_938(var1, var9, var10, this.field_715, var6, var2, this.field_716, var7, var3);
            }
            this.method_981(var1, var6, var7);
        } else {
            this.field_672 = class_331.field_1896;
        }
    }

    public void method_993(int var1, int var2, int var3) {
        class_331 var4;
        switch (var2) {
            case 2:
                if (var1 != 5 || var3 != 5) {
                    return;
                }
            case 0:
                if ((var4 = this.field_715.method_922()) != class_331.field_1896) {
                    if (!var4.method_3257()) {
                        this.field_717 = var4;
                        return;
                    }
                    if ((var4 = this.field_716.method_922()) != class_331.field_1896) {
                        this.field_717 = var4;
                    }
                    return;
                }
                if ((var4 = this.field_716.method_922()) != class_331.field_1896 && !var4.method_3257()) {
                    this.field_717 = var4;
                }
                return;
            case 3:
                if (var1 != 5 || var3 != 5) {
                    return;
                }
            case 1:
                if ((var4 = this.field_715.method_922()) != class_331.field_1896) {
                    if (var4.method_3257()) {
                        this.field_717 = var4;
                        return;
                    }
                    if ((var4 = this.field_716.method_922()) != class_331.field_1896) {
                        this.field_717 = var4;
                    }
                    return;
                } else if ((var4 = this.field_716.method_922()) != class_331.field_1896 && var4.method_3257()) {
                    this.field_717 = var4;
                }
            default:
        }
    }

    public StringBuffer method_975(int var1, StringBuffer var2) {
        this.field_715.method_924(var1, var2).append(' ').append(this.method_974()).append(' ');
        return this.field_716.method_924(0, var2);
    }

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
            int var6 = var4.field_177;
            int var7 = var5.field_177;
            boolean var8 = var1.method_577().field_1928 >= 3211264L;
            if (var8) {
                if (!var4.method_148() && var7 != 11 && var7 != 12) {
                    var6 = var1.method_586().method_486(var4).field_177;
                }
                if (!var5.method_148() && var6 != 11 && var6 != 12) {
                    var7 = var1.method_586().method_486(var5).field_177;
                }
            }
            if (var6 > 15 || var7 > 15) {
                if (var6 == 11) {
                    var7 = 1;
                } else {
                    if (var7 != 11) {
                        this.field_672 = class_331.field_1896;
                        var1.method_644().method_1634(this, var4, var5);
                        return null;
                    }
                    var6 = 1;
                }
            }
            if ((this.field_446 & 4032) >> 6 == 14) {
                if (var6 == 11) {
                    this.field_715.method_911(var1, var4, var4);
                    if (var5.method_147() && ((class_42)var5).method_187() == class_40.field_182) {
                        var1.method_644().method_1755(this.field_716);
                    }
                }
                if (var7 == 11) {
                    this.field_716.method_911(var1, var5, var5);
                    if (var4.method_147() && ((class_42)var4).method_187() == class_40.field_182) {
                        var1.method_644().method_1755(this.field_715);
                    }
                }
            }
            int var9 = (this.field_446 & 4032) >> 6;
            int var10 = class_137.field_701[var9][(var6 << 4) + var7];
            this.field_715.method_911(var1, class_40.method_128(var1, var10 >>> 16 & 15), var4);
            this.field_716.method_911(var1, class_40.method_128(var1, var10 >>> 8 & 15), var5);
            this.field_446 |= var10 & 15;
            switch (var10 & 15) {
                case 2:
                    this.field_675 = class_40.field_182;
                    break;
                case 3:
                    this.field_675 = class_40.field_180;
                    break;
                case 4:
                case 6:
                default:
                    this.field_672 = class_331.field_1896;
                    var1.method_644().method_1634(this, var4, var5);
                    return null;
                case 5:
                    this.field_675 = class_40.field_186;
                    break;
                case 7:
                    this.field_675 = class_40.field_183;
                    break;
                case 8:
                    this.field_675 = class_40.field_185;
                    break;
                case 9:
                    this.field_675 = class_40.field_184;
                    break;
                case 10:
                    this.field_675 = class_40.field_179;
                    break;
                case 11:
                    this.field_675 = var1.method_610();
            }
            if (var2 || var3) {
                class_130.method_938(var1, var9, var10, this.field_715, var6, var2, this.field_716, var7, var3);
            }
            this.method_981(var1, var6, var7);
            return this.field_675;
        } else {
            this.field_672 = class_331.field_1896;
            return null;
        }
    }

    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2002(this, var2)) {
            this.field_715.method_763(var1, var2);
            this.field_716.method_763(var1, var2);
        }
        var1.method_1917(this, var2);
    }
}
