package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.class_264;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.class_98;
import org.eclipse.jdt.internal.compiler.codegen.class_268;
import org.eclipse.jdt.internal.compiler.codegen.BranchLabel;
import org.eclipse.jdt.internal.compiler.flow.class_293;
import org.eclipse.jdt.internal.compiler.flow.class_301;
import org.eclipse.jdt.internal.compiler.impl.class_331;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.class_41;
import org.eclipse.jdt.internal.compiler.lookup.class_42;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.class_45;
import org.eclipse.jdt.internal.compiler.lookup.class_46;
import org.eclipse.jdt.internal.compiler.lookup.class_58;
import org.eclipse.jdt.internal.compiler.lookup.class_65;
import org.eclipse.jdt.internal.compiler.lookup.class_83;
import org.eclipse.jdt.internal.compiler.lookup.class_86;
import org.eclipse.jdt.internal.compiler.problem.class_249;
import org.eclipse.jdt.internal.compiler.util.Messages;

import java.util.ArrayList;

public abstract class class_126 extends class_98 {

    public class_331 field_672;

    public int field_673;

    public int field_674;

    public class_40 field_675;

    public static final boolean method_906(class_331 var0, int var1, int var2) {
        if (var2 == var1) {
            return true;
        } else {
            switch (var2) {
                case 2:
                    switch (var1) {
                        case 2:
                            return true;
                        case 3:
                            return var0.method_3258() == var0.method_3260();
                        case 4:
                            return var0.method_3286() == var0.method_3260();
                        case 5:
                        case 6:
                        default:
                            return false;
                        case 7:
                            return var0.method_3285() == (long)var0.method_3260();
                        case 8:
                            return var0.method_3281() == (double)var0.method_3260();
                        case 9:
                            return var0.method_3282() == (float)var0.method_3260();
                        case 10:
                            return var0.method_3284() == var0.method_3260();
                    }
                case 3:
                    switch (var1) {
                        case 2:
                            return var0.method_3260() == var0.method_3258();
                        case 3:
                            return true;
                        case 4:
                            return var0.method_3286() == var0.method_3258();
                        case 5:
                        case 6:
                        default:
                            return false;
                        case 7:
                            return var0.method_3285() == (long)var0.method_3258();
                        case 8:
                            return var0.method_3281() == (double)var0.method_3258();
                        case 9:
                            return var0.method_3282() == (float)var0.method_3258();
                        case 10:
                            return var0.method_3284() == var0.method_3258();
                    }
                case 4:
                    switch (var1) {
                        case 2:
                            return var0.method_3260() == var0.method_3286();
                        case 3:
                            return var0.method_3258() == var0.method_3286();
                        case 4:
                            return true;
                        case 5:
                        case 6:
                        default:
                            return false;
                        case 7:
                            return var0.method_3285() == (long)var0.method_3286();
                        case 8:
                            return var0.method_3281() == (double)var0.method_3286();
                        case 9:
                            return var0.method_3282() == (float)var0.method_3286();
                        case 10:
                            return var0.method_3284() == var0.method_3286();
                    }
                case 5:
                case 6:
                default:
                    return false;
                case 7:
                    switch (var1) {
                        case 2:
                            return (long)var0.method_3260() == var0.method_3285();
                        case 3:
                            return (long)var0.method_3258() == var0.method_3285();
                        case 4:
                            return (long)var0.method_3286() == var0.method_3285();
                        case 5:
                        case 6:
                        default:
                            return false;
                        case 7:
                            return true;
                        case 8:
                            return var0.method_3281() == (double)var0.method_3285();
                        case 9:
                            return var0.method_3282() == (float)var0.method_3285();
                        case 10:
                            return (long)var0.method_3284() == var0.method_3285();
                    }
                case 8:
                    switch (var1) {
                        case 2:
                            return (double)var0.method_3260() == var0.method_3281();
                        case 3:
                            return (double)var0.method_3258() == var0.method_3281();
                        case 4:
                            return (double)var0.method_3286() == var0.method_3281();
                        case 5:
                        case 6:
                        default:
                            return false;
                        case 7:
                            return (double)var0.method_3285() == var0.method_3281();
                        case 8:
                            return true;
                        case 9:
                            return (double)var0.method_3282() == var0.method_3281();
                        case 10:
                            return (double)var0.method_3284() == var0.method_3281();
                    }
                case 9:
                    switch (var1) {
                        case 2:
                            return (float)var0.method_3260() == var0.method_3282();
                        case 3:
                            return (float)var0.method_3258() == var0.method_3282();
                        case 4:
                            return (float)var0.method_3286() == var0.method_3282();
                        case 5:
                        case 6:
                        default:
                            return false;
                        case 7:
                            return (float)var0.method_3285() == var0.method_3282();
                        case 8:
                            return var0.method_3281() == (double)var0.method_3282();
                        case 9:
                            return true;
                        case 10:
                            return (float)var0.method_3284() == var0.method_3282();
                    }
                case 10:
                    switch (var1) {
                        case 2:
                            return var0.method_3260() == var0.method_3284();
                        case 3:
                            return var0.method_3258() == var0.method_3284();
                        case 4:
                            return var0.method_3286() == var0.method_3284();
                        case 5:
                        case 6:
                        default:
                            return false;
                        case 7:
                            return var0.method_3285() == (long)var0.method_3284();
                        case 8:
                            return var0.method_3281() == (double)var0.method_3284();
                        case 9:
                            return var0.method_3282() == (float)var0.method_3284();
                        case 10:
                            return true;
                    }
            }
        }
    }

    public class_126() {
        this.field_673 = -1;
    }

    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        return var3;
    }

    public class_301 method_907(class_86 var1, class_293 var2, class_301 var3, boolean var4) {
        return this.method_814(var1, var2, var3);
    }

    public final boolean method_908(class_83 var1, class_40 var2, class_40 var3, class_126 var4) {
        if (var2 != null && var3 != null) {
            boolean var5 = var1.method_577().field_1928 >= 3211264L;
            if (var2.method_148()) {
                if (var3.method_148()) {
                    if (var3 == var2) {
                        if (var4 != null) {
                            this.field_672 = var4.field_672;
                        }
                        this.method_930(var1, var2);
                        return true;
                    }
                    boolean var16 = false;
                    if (var3.method_152(var2) || (var16 = class_41.method_184(var2.field_177, var3.field_177))) {
                        if (var4 != null) {
                            var4.field_674 = (var2.field_177 << 4) + var3.field_177;
                            if (var4.field_672 != class_331.field_1896) {
                                this.field_672 = var4.field_672.method_3259(var4.field_674);
                            }
                        }
                        if (!var16) {
                            this.method_930(var1, var2);
                        }
                        return true;
                    }
                } else if (var5 && var1.method_586().method_486(var3).method_152(var2)) {
                    this.method_930(var1, var2);
                    return true;
                }
                return false;
            } else if (var5 && var3.method_148() && var1.method_586().method_486(var3).method_152(var2)) {
                this.method_930(var1, var2);
                return true;
            } else {
                class_40 var6;
                switch (var3.method_98()) {
                    case 68:
                        if (var2 == var3) {
                            this.method_930(var1, var2);
                            return true;
                        } else {
                            switch (var2.method_98()) {
                                case 68:
                                    var6 = ((class_42)var2).method_187();
                                    class_40 var7 = ((class_42)var3).method_187();
                                    if (!var7.method_148() && !var6.method_148()) {
                                        return this.method_908(var1, var6, var7, var4);
                                    } else {
                                        if (var6 == var7) {
                                            this.method_929();
                                            return true;
                                        }
                                        return false;
                                    }
                                case 4100:
                                    class_40 var8 = var3.method_140(var2);
                                    if (var8 == null) {
                                        this.method_910(var1, var2, var3, (class_40)null, true);
                                    }
                                    return this.method_908(var1, ((class_46)var2).method_261(), var3, var4);
                                default:
                                    switch (var2.field_177) {
                                        case 1:
                                            this.method_930(var1, var2);
                                            return true;
                                        case 36:
                                        case 37:
                                            this.method_929();
                                            return true;
                                        default:
                                            return false;
                                    }
                            }
                        }
                    case 132:
                        if (var3 == class_40.field_187) {
                            this.method_930(var1, var2);
                            return true;
                        }
                        return false;
                    case 516:
                    case 8196:
                        var6 = var3.method_140(var2);
                        if (var6 != null) {
                            return this.method_910(var1, var2, var3, var6, false);
                        }
                        return this.method_908(var1, var2, ((class_45)var3).field_212, var4);
                    case 4100:
                        var6 = var3.method_140(var2);
                        if (var6 != null) {
                            return this.method_910(var1, var2, var3, var6, false);
                        }
                        return this.method_908(var1, var2, ((class_46)var3).method_261(), var4);
                    default:
                        ReferenceBinding var14;
                        if (!var3.method_157()) {
                            switch (var2.method_98()) {
                                case 68:
                                    if (var3.field_177 == 1) {
                                        if (var5) {
                                            this.method_910(var1, var2, var3, var3, true);
                                        }
                                        this.method_929();
                                        return true;
                                    }
                                    return false;
                                case 4100:
                                    var6 = var3.method_140(var2);
                                    if (var6 == null) {
                                        this.method_910(var1, var2, var3, var6, true);
                                    }
                                    return this.method_908(var1, ((class_46)var2).method_261(), var3, var4);
                                default:
                                    if (var2.method_157()) {
                                        var14 = (ReferenceBinding)var3;
                                        var6 = var14.method_140(var2);
                                        if (var6 != null) {
                                            return this.method_910(var1, var2, var3, var6, false);
                                        } else if (var14.method_221()) {
                                            return false;
                                        } else {
                                            this.method_929();
                                            var6 = var2.method_140(var3);
                                            if (var6 != null) {
                                                return this.method_910(var1, var2, var3, var6, true);
                                            } else {
                                                if (var5) {
                                                    this.method_910(var1, var2, var3, (class_40)null, true);
                                                    if (var14.method_212((ReferenceBinding)var2)) {
                                                        return false;
                                                    }
                                                }
                                                return true;
                                            }
                                        }
                                    } else {
                                        var6 = var3.method_140(var2);
                                        if (var6 != null) {
                                            if (var4 != null && var2.field_177 == 11) {
                                                this.field_672 = var4.field_672;
                                            }
                                            return this.method_910(var1, var2, var3, var6, false);
                                        } else {
                                            var6 = var2.method_140(var3);
                                            if (var6 != null) {
                                                this.method_929();
                                                return this.method_910(var1, var2, var3, var6, true);
                                            } else {
                                                return false;
                                            }
                                        }
                                    }
                            }
                        } else {
                            switch (var2.method_98()) {
                                case 68:
                                    switch (var3.field_177) {
                                        case 36:
                                        case 37:
                                            this.method_929();
                                            return true;
                                        default:
                                            return false;
                                    }
                                case 4100:
                                    var6 = var3.method_140(var2);
                                    if (var6 == null) {
                                        this.method_910(var1, var2, var3, (class_40)null, true);
                                    }
                                    return this.method_908(var1, ((class_46)var2).method_261(), var3, var4);
                                default:
                                    if (!var2.method_157()) {
                                        if (var2.field_177 == 1) {
                                            this.method_930(var1, var2);
                                            return true;
                                        } else {
                                            this.method_929();
                                            var6 = var2.method_140(var3);
                                            if (var6 != null) {
                                                return this.method_910(var1, var2, var3, var6, true);
                                            } else if (((ReferenceBinding)var2).method_221()) {
                                                return false;
                                            } else {
                                                if (var5) {
                                                    this.method_910(var1, var2, var3, (class_40)null, true);
                                                    if (((ReferenceBinding)var2).method_212((ReferenceBinding)var3)) {
                                                        return false;
                                                    }
                                                }
                                                return true;
                                            }
                                        }
                                    } else {
                                        var14 = (ReferenceBinding)var3;
                                        var6 = var14.method_140(var2);
                                        if (var6 != null) {
                                            return this.method_910(var1, var2, var14, var6, false);
                                        } else {
                                            this.method_929();
                                            var6 = var2.method_140(var14);
                                            if (var6 != null) {
                                                return this.method_910(var1, var2, var14, var6, true);
                                            } else {
                                                if (var5) {
                                                    this.method_910(var1, var2, var3, (class_40)null, true);
                                                    if (var14.method_212((ReferenceBinding)var2)) {
                                                        return false;
                                                    }
                                                } else {
                                                    class_58[] var15 = this.method_916((ReferenceBinding)var2);
                                                    class_58[] var9 = this.method_916((ReferenceBinding)var3);
                                                    int var10 = var9.length;
                                                    int var11 = 0;
                                                    for (int var12 = var15.length; var11 < var12; ++var11) {
                                                        for (int var13 = 0; var13 < var10; ++var13) {
                                                            if (var15[var11].field_275 != var9[var13].field_275 && CharOperation.method_1364(var15[var11].field_274, var9[var13].field_274) && var15[var11].method_344(var9[var13])) {
                                                                return false;
                                                            }
                                                        }
                                                    }
                                                }
                                                return true;
                                            }
                                        }
                                    }
                            }
                        }
                }
            }
        } else {
            return true;
        }
    }

    public void method_909(class_86 var1, class_293 var2, class_301 var3) {
        class_65 var4 = this.method_920();
        if (var4 != null && (var4.field_301.field_178 & 2L) == 0L) {
            if ((this.field_446 & 131072) == 0) {
                var2.method_3050(var1, var4, this, 3, var3);
            }
            var3.method_3094(var4);
            if (var2.field_1741 != null) {
                var2.field_1741.method_3094(var4);
            }
        }
    }

    public boolean method_910(class_83 var1, class_40 var2, class_40 var3, class_40 var4, boolean var5) {
        if (var4 == var2) {
            if (!var5) {
                this.method_930(var1, var2);
            }
            return true;
        } else {
            if (var4 != null && (var2.method_149() || var3.method_149())) {
                label40: {
                    if (var5) {
                        if (!var4.method_164(var3)) {
                            break label40;
                        }
                    } else if (!var2.method_164(var4)) {
                        break label40;
                    }
                    return false;
                }
            }
            if (!var5) {
                this.method_930(var1, var2);
            }
            return true;
        }
    }

    public void method_911(class_83 var1, class_40 var2, class_40 var3) {
        if (var2 != null && var3 != null) {
            if (this.field_674 == 0) {
                class_40 var4;
                if (var2 != class_40.field_187 && var2.method_148()) {
                    if (!var3.method_148()) {
                        var4 = var1.method_586().method_486(var3);
                        this.field_674 = 1024;
                        var1.method_644().method_1485(this, var3, var2);
                        var3 = var4;
                    }
                } else {
                    if (var3 != class_40.field_187 && var3.method_148()) {
                        var4 = var1.method_586().method_486(var2);
                        if (var4 == var2) {
                            var4 = var3;
                        }
                        this.field_674 = 512 | (var4.field_177 << 4) + var3.field_177;
                        var1.method_644().method_1485(this, var3, var1.method_586().method_486(var4));
                        return;
                    }
                    if (this.field_672 != class_331.field_1896 && this.field_672.method_3288() != 11) {
                        this.field_674 = 512;
                        return;
                    }
                }
                int var6 = var3.field_177;
                if (var3.field_177 == Integer.MAX_VALUE) {
                    var6 = var3.method_138().field_177 == 11 ? 11 : 1;
                }
                int var5 = var2.field_177;
                switch (var2.field_177) {
                    case 2:
                    case 3:
                    case 4:
                        this.field_674 |= 160 + var6;
                        break;
                    case 5:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                        this.field_674 |= (var5 << 4) + var6;
                    case 6:
                }
            }
        }
    }

    public void method_818(class_86 var1, class_268 var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            this.method_912(var1, var2, false);
        }
    }

    public void method_912(class_86 var1, class_268 var2, boolean var3) {
        if (this.field_672 != class_331.field_1896) {
            int var4 = var2.field_1208;
            var2.method_2179(this.field_672, this.field_674);
            var2.method_2360(var4, this.field_444);
        } else {
            class_249 var10000 = new class_249(Messages.field_1893);
            throw var10000;
        }
    }

    public void method_913(class_86 var1, class_268 var2, BranchLabel var3, BranchLabel var4, boolean var5) {
        class_331 var6 = this.method_922();
        this.method_912(var1, var2, var5 && var6 == class_331.field_1896);
        int var7;
        if (var6 != class_331.field_1896 && var6.method_3288() == 5) {
            var7 = var2.field_1208;
            if (var6.method_3257()) {
                if (var5 && var4 == null && var3 != null) {
                    var2.method_2209(var3);
                }
            } else if (var5 && var4 != null && var3 == null) {
                var2.method_2209(var4);
            }
            var2.method_2360(var7, this.field_444);
        } else {
            var7 = var2.field_1208;
            if (var5) {
                if (var4 == null) {
                    if (var3 != null) {
                        var2.method_2242(var3);
                    }
                } else if (var3 == null) {
                    var2.method_2237(var4);
                }
            }
            var2.method_2380(var1, var7);
        }
    }

    public void method_914(class_86 var1, class_268 var2, int var3) {
        if (var3 != 11 || this.field_672 == class_331.field_1896 || this.field_672.method_3287().length() != 0) {
            this.method_912(var1, var2, true);
            var2.method_2274(var3);
        }
    }

    public void method_915(class_86 var1, class_268 var2, int var3) {
        var2.method_2349();
        var2.method_2141();
        switch (var3) {
            case 0:
            case 1:
                var2.method_2275();
                this.method_912(var1, var2, true);
                var2.method_2274(1);
                return;
            case 11:
            case 12:
                if (this.field_672 != class_331.field_1896) {
                    String var4 = this.field_672.method_3287();
                    if (var4.length() == 0) {
                        var2.method_2275();
                        return;
                    }
                    var2.method_2311(var4);
                } else {
                    this.method_912(var1, var2, true);
                    var2.method_2279(1);
                }
                break;
            default:
                this.method_912(var1, var2, true);
                var2.method_2279(var3);
        }
        var2.method_2276();
    }

    private class_58[] method_916(ReferenceBinding var1) {
        ArrayList var10000 = new ArrayList();
        ArrayList var2 = var10000;
        this.method_917(var1, var2);
        return (class_58[])((class_58[])var2.toArray(new class_58[var2.size()]));
    }

    private void method_917(ReferenceBinding var1, ArrayList var2) {
        if (var1.method_157()) {
            class_58[] var3 = var1.method_232();
            int var4 = 0;
            int var5;
            for (var5 = var3.length; var4 < var5; ++var4) {
                var2.add(var3[var4]);
            }
            ReferenceBinding[] var7 = var1.method_241();
            var5 = 0;
            for (int var6 = var7.length; var5 < var6; ++var5) {
                this.method_917(var7[var5], var2);
            }
        }
    }

    public boolean method_918() {
        return false;
    }

    public boolean method_919(class_40 var1, class_40 var2) {
        return this.field_672 == class_331.field_1896 ? false : (var1 == var2 ? true : (var1.method_148() && var2.method_148() && (var1 == class_40.field_179 || class_41.method_185(10, var1.field_177)) && class_41.method_184(var2.field_177, 10) ? method_906(this.field_672, var1.field_177, var2.field_177) : false));
    }

    public class_65 method_920() {
        return null;
    }

    public int method_921(class_301 var1) {
        if (this.field_672 != null && this.field_672 != class_331.field_1896) {
            return -1;
        } else {
            class_65 var2 = this.method_920();
            return var2 != null ? (var1.method_3085(var2) ? 1 : (var1.method_3084(var2) ? -1 : 0)) : -1;
        }
    }

    public class_331 method_922() {
        return this.field_672;
    }

    public class_40 method_923(class_83 var1) {
        Object var2 = this.field_675;
        int var3 = (this.field_674 & 255) >> 4;
        switch (var3) {
            case 2:
                var2 = class_40.field_182;
                break;
            case 3:
                var2 = class_40.field_180;
                break;
            case 4:
                var2 = class_40.field_181;
                break;
            case 5:
                var2 = class_40.field_186;
            case 6:
            default:
                break;
            case 7:
                var2 = class_40.field_183;
                break;
            case 8:
                var2 = class_40.field_185;
                break;
            case 9:
                var2 = class_40.field_184;
                break;
            case 10:
                var2 = class_40.field_179;
        }
        if ((this.field_674 & 512) != 0) {
            var2 = var1.method_586().method_486((class_40)var2);
        }
        return (class_40)var2;
    }

    public StringBuffer method_757(int var1, StringBuffer var2) {
        method_759(var1, var2);
        return this.method_924(var1, var2);
    }

    public abstract StringBuffer method_924(int var1, StringBuffer var2);

    public StringBuffer method_820(int var1, StringBuffer var2) {
        return this.method_757(var1, var2).append(";");
    }

    public void method_821(class_86 var1) {
        this.method_925(var1);
    }

    public class_40 method_925(class_86 var1) {
        return null;
    }

    public class_40 method_926(class_86 var1, class_40 var2) {
        this.method_928(var2);
        class_40 var3 = this.method_925(var1);
        if (var3 == null) {
            return null;
        } else if (var3 == var2) {
            return var3;
        } else {
            if (!var3.method_152(var2)) {
                if (!var1.method_624(var3, var2)) {
                    var1.method_644().method_1777(var3, var2, this, (ASTNode)null);
                    return null;
                }
                this.method_911(var1, var2, var3);
            }
            return var3;
        }
    }

    public Object method_927() {
        return this.field_672 != class_331.field_1896 ? this.field_672 : null;
    }

    public void method_928(class_40 var1) {}

    public void method_929() {}

    public void method_930(class_83 var1, class_40 var2) {}

    public void method_763(class_264 var1, class_86 var2) {}
}
