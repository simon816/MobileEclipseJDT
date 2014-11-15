package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.class_264;
import org.eclipse.jdt.internal.compiler.ast.class_124;
import org.eclipse.jdt.internal.compiler.ast.class_126;
import org.eclipse.jdt.internal.compiler.ast.class_98;
import org.eclipse.jdt.internal.compiler.codegen.class_268;
import org.eclipse.jdt.internal.compiler.codegen.BranchLabel;
import org.eclipse.jdt.internal.compiler.flow.class_293;
import org.eclipse.jdt.internal.compiler.flow.class_297;
import org.eclipse.jdt.internal.compiler.flow.class_301;
import org.eclipse.jdt.internal.compiler.flow.class_303;
import org.eclipse.jdt.internal.compiler.impl.class_331;
import org.eclipse.jdt.internal.compiler.lookup.class_34;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.class_42;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.class_52;
import org.eclipse.jdt.internal.compiler.lookup.class_58;
import org.eclipse.jdt.internal.compiler.lookup.class_65;
import org.eclipse.jdt.internal.compiler.lookup.class_86;

public class class_102 extends class_98 {

    public class_124 field_512;

    public int field_513;

    public class_126 field_514;

    public class_98 field_515;

    private int field_516;

    private class_40 field_517;

    private class_40 field_518;

    private BranchLabel field_519;

    private BranchLabel field_520;

    public class_86 field_521;

    public class_65 field_522;

    public class_65 field_523;

    public class_65 field_524;

    private static final char[] field_525;

    private static final char[] field_526;

    private static final char[] field_527;

    int field_528;

    int field_529;

    public class_102(class_124 var1, int var2) {
        this.field_513 = -1;
        this.field_528 = -1;
        this.field_529 = -1;
        this.field_512 = var1;
        this.field_444 = var2;
        this.field_516 = -1;
    }

    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        BranchLabel var10001 = new BranchLabel();
        this.field_519 = var10001;
        var10001 = new BranchLabel();
        this.field_520 = var10001;
        this.field_514.method_909(var1, var2, var3);
        var3 = this.field_512.method_814(this.field_521, var2, var3);
        class_301 var4 = this.field_514.method_814(this.field_521, var2, var3.method_3078());
        var4.method_3099(this.field_512.field_670);
        this.field_528 = var1.method_635().method_729(var4);
        class_297 var10000 = new class_297(var2, var3, this, this.field_519, this.field_520, this.field_521);
        class_297 var5 = var10000;
        class_303 var6 = var4.method_3106();
        var6.method_3100(this.field_512.field_670);
        class_301 var7;
        if (this.field_515 != null && (!this.field_515.method_819() || var1.method_577().field_1927 > 3080192L)) {
            if (!this.field_515.method_816(var6, this.field_521, false)) {
                var6 = this.field_515.method_814(this.field_521, var5, var6).method_3107();
            }
            var7 = var3.method_3107().method_3071(var4.method_3080());
            if ((var6.field_1783 & var5.field_1749.field_1783 & 1) != 0) {
                this.field_520 = null;
            } else {
                var6 = var6.method_3105(var5.field_1749);
                var5.method_3057(this.field_521, var6);
                var7.method_3072(var6);
            }
        } else {
            var7 = var4.method_3080();
        }
        boolean var8 = this.field_515 == null || this.field_515.method_819() || (this.field_515.field_446 & 1) != 0;
        switch (this.field_516) {
            case 0:
                if (!var8 || this.field_512.field_670.field_306 != -1) {
                    this.field_523.field_307 = 1;
                    if (this.field_520 != null) {
                        this.field_522.field_307 = 1;
                        this.field_524.field_307 = 1;
                    }
                }
                break;
            case 1:
            case 2:
                this.field_522.field_307 = 1;
        }
        var5.method_3058(var1, var6);
        class_303 var9 = class_301.method_3101((class_301)((var5.field_1746.field_1783 & 1) != 0 ? var5.field_1746 : var3.method_3071(var5.field_1746)), false, var7, false, true);
        this.field_529 = var1.method_635().method_729(var9);
        return var9;
    }

    public void method_818(class_86 var1, class_268 var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            int var3 = var2.field_1208;
            boolean var4 = this.field_515 == null || this.field_515.method_819() || (this.field_515.field_446 & 1) != 0;
            if (var4 && this.field_512.field_670.field_306 == -1 && this.field_516 == 0) {
                this.field_514.method_912(this.field_521, var2, false);
                var2.method_2147(this.field_521);
                if (this.field_529 != -1) {
                    var2.method_2363(var1, this.field_529);
                    var2.method_2088(var1, this.field_529);
                }
                var2.method_2360(var3, this.field_444);
            } else {
                switch (this.field_516) {
                    case 0:
                        this.field_514.method_912(this.field_521, var2, true);
                        var2.method_2376(this.field_523, true);
                        var2.method_2091(this.field_523);
                        if (this.field_520 != null) {
                            var2.method_2101();
                            var2.method_2376(this.field_524, false);
                            var2.method_2091(this.field_524);
                            var2.method_2221();
                            var2.method_2376(this.field_522, false);
                            var2.method_2091(this.field_522);
                        }
                        break;
                    case 1:
                    case 2:
                        this.field_514.method_912(this.field_521, var2, true);
                        class_58 var10000 = new class_58(1, "iterator".toCharArray(), this.field_521.method_612(), class_34.field_150, class_34.field_151, (ReferenceBinding)this.field_517.method_138());
                        class_58 var5 = var10000;
                        if (this.field_517.method_157()) {
                            var2.method_2261(var5);
                        } else {
                            var2.method_2282(var5);
                        }
                        var2.method_2376(this.field_522, false);
                        var2.method_2091(this.field_522);
                }
                BranchLabel var8 = new BranchLabel(var2);
                BranchLabel var9 = var8;
                var9.field_330 |= 2;
                var8 = new BranchLabel(var2);
                BranchLabel var6 = var8;
                var6.field_330 |= 2;
                this.field_519.method_456(var2);
                int var7;
                if (this.field_520 == null) {
                    var6.method_458();
                    var7 = var2.field_1208;
                    switch (this.field_516) {
                        case 0:
                            var2.method_2101();
                            var2.method_2237(this.field_519);
                            break;
                        case 1:
                        case 2:
                            var2.method_2324(this.field_522);
                            var2.method_2268();
                            var2.method_2237(this.field_519);
                    }
                    var2.method_2360(var7, this.field_512.field_444);
                } else {
                    this.field_520.method_456(var2);
                    this.field_520.field_330 |= 2;
                    var2.method_2209(var6);
                }
                var9.method_458();
                switch (this.field_516) {
                    case 0:
                        if (this.field_512.field_670.field_306 != -1) {
                            var2.method_2324(this.field_523);
                            if (this.field_520 == null) {
                                var2.method_2221();
                            } else {
                                var2.method_2324(this.field_522);
                            }
                            var2.method_2099(this.field_518.field_177);
                            if (this.field_513 != -1) {
                                var2.method_2182(this.field_513);
                            }
                            var2.method_2376(this.field_512.field_670, false);
                            var2.method_2090(this.field_512.field_670);
                            if (this.field_528 != -1) {
                                var2.method_2088(var1, this.field_528);
                            }
                        }
                        break;
                    case 1:
                    case 2:
                        var2.method_2324(this.field_522);
                        var2.method_2269();
                        if (this.field_512.field_670.field_301.field_177 != 1) {
                            if (this.field_513 != -1) {
                                var2.method_2113(this.field_518);
                                var2.method_2182(this.field_513);
                            } else {
                                var2.method_2113(this.field_512.field_670.field_301);
                            }
                        }
                        if (this.field_512.field_670.field_306 == -1) {
                            var2.method_2352();
                        } else {
                            var2.method_2376(this.field_512.field_670, false);
                            var2.method_2090(this.field_512.field_670);
                            if (this.field_528 != -1) {
                                var2.method_2088(var1, this.field_528);
                            }
                        }
                }
                if (!var4) {
                    this.field_515.method_818(this.field_521, var2);
                }
                var2.method_2365(this.field_512.field_670);
                if (this.field_528 != -1) {
                    var2.method_2363(var1, this.field_528);
                }
                if (this.field_520 != null) {
                    this.field_520.method_458();
                    var7 = var2.field_1208;
                    switch (this.field_516) {
                        case 0:
                            if (!var4 || this.field_512.field_670.field_306 >= 0) {
                                var2.method_2245(this.field_522.field_306, 1);
                            }
                            var6.method_458();
                            var2.method_2324(this.field_522);
                            var2.method_2324(this.field_524);
                            var2.method_2235(var9);
                            break;
                        case 1:
                        case 2:
                            var6.method_458();
                            var2.method_2324(this.field_522);
                            var2.method_2268();
                            var2.method_2242(var9);
                    }
                    var2.method_2360(var7, this.field_512.field_444);
                }
                switch (this.field_516) {
                    case 0:
                        var2.method_2365(this.field_522);
                        var2.method_2365(this.field_524);
                        var2.method_2365(this.field_523);
                        break;
                    case 1:
                    case 2:
                        var2.method_2365(this.field_522);
                }
                var2.method_2147(this.field_521);
                if (this.field_529 != -1) {
                    var2.method_2363(var1, this.field_529);
                    var2.method_2088(var1, this.field_529);
                }
                this.field_519.method_458();
                var2.method_2360(var3, this.field_444);
            }
        }
    }

    public StringBuffer method_820(int var1, StringBuffer var2) {
        method_759(var1, var2).append("for (");
        this.field_512.method_888(0, var2);
        var2.append(" : ");
        this.field_514.method_757(0, var2).append(") ");
        if (this.field_515 == null) {
            var2.append(';');
        } else {
            var2.append('\n');
            this.field_515.method_820(var1 + 1, var2);
        }
        return var2;
    }

    public void method_821(class_86 var1) {
        class_86 var10001 = new class_86(var1);
        this.field_521 = var10001;
        this.field_512.method_821(this.field_521);
        class_40 var2 = this.field_512.field_660.field_675;
        class_40 var3 = this.field_514 == null ? null : this.field_514.method_925(this.field_521);
        if (var2 != null && var3 != null) {
            if (var3.method_147()) {
                this.field_516 = 0;
                this.field_514.method_911(this.field_521, var3, var3);
                this.field_518 = ((class_42)var3).method_187();
                if (!this.field_518.method_152(var2) && !this.field_521.method_624(this.field_518, var2)) {
                    this.field_521.method_644().method_1710(this.field_514, this.field_518, var2);
                }
                int var4 = this.field_518.field_177;
                if (var2.method_148()) {
                    if (!this.field_518.method_148()) {
                        var4 = this.field_521.method_586().method_486(this.field_518).field_177;
                        this.field_513 = 1024;
                        if (var2.method_148()) {
                            this.field_513 |= (var2.field_177 << 4) + var4;
                            this.field_521.method_644().method_1485(this.field_514, this.field_518, var2);
                        }
                    } else {
                        this.field_513 = (var2.field_177 << 4) + var4;
                    }
                } else if (this.field_518.method_148()) {
                    int var5 = this.field_521.method_586().method_486(this.field_518).field_177;
                    this.field_513 = 512 | var4 << 4 | var4;
                    this.field_521.method_644().method_1485(this.field_514, this.field_518, var2);
                }
            } else if (var3 instanceof ReferenceBinding) {
                ReferenceBinding var9 = ((ReferenceBinding)var3).method_139(38, false);
                if (var9 != null) {
                    label90: {
                        this.field_517 = var3.method_138();
                        if (((ReferenceBinding)this.field_517).method_139(38, false) == null) {
                            this.field_517 = var9;
                            this.field_514.method_911(this.field_521, var9, var3);
                        } else {
                            this.field_514.method_911(this.field_521, var3, var3);
                        }
                        Object var10 = null;
                        switch (var9.method_98()) {
                            case 260:
                                var10 = ((class_52)var9).field_243;
                                break;
                            case 1028:
                                this.field_516 = 1;
                                this.field_518 = this.field_521.method_609();
                                if (!this.field_518.method_152(var2) && !this.field_521.method_624(this.field_518, var2)) {
                                    this.field_521.method_644().method_1710(this.field_514, this.field_518, var2);
                                }
                                break label90;
                            case 2052:
                                var10 = var9.method_181();
                                break;
                            default:
                                break label90;
                        }
                        if (((Object[])var10).length == 1) {
                            this.field_516 = 2;
                            this.field_518 = (class_40)((Object[])var10)[0];
                            if (!this.field_518.method_152(var2) && !this.field_521.method_624(this.field_518, var2)) {
                                this.field_521.method_644().method_1710(this.field_514, this.field_518, var2);
                            }
                            int var6 = this.field_518.field_177;
                            if (var2.method_148()) {
                                if (!this.field_518.method_148()) {
                                    var6 = this.field_521.method_586().method_486(this.field_518).field_177;
                                    this.field_513 = 1024;
                                    if (var2.method_148()) {
                                        this.field_513 |= (var2.field_177 << 4) + var6;
                                    }
                                } else {
                                    this.field_513 = (var2.field_177 << 4) + var6;
                                }
                            } else if (this.field_518.method_148()) {
                                int var7 = this.field_521.method_586().method_486(this.field_518).field_177;
                                this.field_513 = 512 | var6 << 4 | var6;
                            }
                        }
                    }
                }
            }
            class_65 var8;
            switch (this.field_516) {
                case 0:
                    var8 = new class_65(field_525, class_40.field_179, 0, false);
                    this.field_522 = var8;
                    this.field_521.method_704(this.field_522);
                    this.field_522.method_410(class_331.field_1896);
                    var8 = new class_65(field_527, class_40.field_179, 0, false);
                    this.field_524 = var8;
                    this.field_521.method_704(this.field_524);
                    this.field_524.method_410(class_331.field_1896);
                    var8 = new class_65(field_526, var3, 0, false);
                    this.field_523 = var8;
                    this.field_521.method_704(this.field_523);
                    this.field_523.method_410(class_331.field_1896);
                    break;
                case 1:
                case 2:
                    var8 = new class_65(field_525, this.field_521.method_612(), 0, false);
                    this.field_522 = var8;
                    this.field_521.method_704(this.field_522);
                    this.field_522.method_410(class_331.field_1896);
                    break;
                default:
                    this.field_521.method_644().method_1640(this.field_514);
            }
        }
        if (this.field_515 != null) {
            this.field_515.method_821(this.field_521);
        }
    }

    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2024(this, var2)) {
            this.field_512.method_763(var1, this.field_521);
            this.field_514.method_763(var1, this.field_521);
            if (this.field_515 != null) {
                this.field_515.method_763(var1, this.field_521);
            }
        }
        var1.method_1939(this, var2);
    }

    static {
        field_525 = " index".toCharArray();
        field_526 = " collection".toCharArray();
        field_527 = " max".toCharArray();
    }
}
