package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.class_264;
import org.eclipse.jdt.internal.compiler.ast.class_112;
import org.eclipse.jdt.internal.compiler.ast.class_116;
import org.eclipse.jdt.internal.compiler.ast.class_125;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.codegen.class_268;
import org.eclipse.jdt.internal.compiler.codegen.StackMapFrameCodeStream;
import org.eclipse.jdt.internal.compiler.codegen.class_73;
import org.eclipse.jdt.internal.compiler.codegen.BranchLabel;
import org.eclipse.jdt.internal.compiler.flow.class_293;
import org.eclipse.jdt.internal.compiler.flow.class_294;
import org.eclipse.jdt.internal.compiler.flow.class_298;
import org.eclipse.jdt.internal.compiler.flow.class_300;
import org.eclipse.jdt.internal.compiler.flow.class_301;
import org.eclipse.jdt.internal.compiler.flow.class_303;
import org.eclipse.jdt.internal.compiler.flow.class_304;
import org.eclipse.jdt.internal.compiler.impl.class_331;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.class_58;
import org.eclipse.jdt.internal.compiler.lookup.class_65;
import org.eclipse.jdt.internal.compiler.lookup.class_86;
import org.eclipse.jdt.internal.compiler.lookup.class_87;

public class class_117 extends class_116 {

    private static final char[] field_616;

    private static final char[] field_617;

    private static final char[] field_618;

    public class_112 field_619;

    public class_112[] field_620;

    public class_125[] field_621;

    public class_112 field_622;

    class_86 field_623;

    public class_303 field_624;

    ReferenceBinding[] field_625;

    boolean[] field_626;

    BranchLabel field_627;

    public class_65 field_628;

    public class_65 field_629;

    public class_65 field_630;

    class_73[] field_631;

    private Object[] field_632;

    private BranchLabel[] field_633;

    private int[] field_634;

    private int field_635;

    int field_636;

    int field_637;

    int field_638;

    int[] field_639;

    public class_117() {
        this.field_635 = 0;
        this.field_636 = -1;
        this.field_637 = -1;
        this.field_638 = -1;
    }

    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        this.field_637 = var1.method_635().method_729(var3);
        if (this.field_628 != null) {
            this.field_628.field_307 = 1;
        }
        if (this.field_629 != null) {
            this.field_629.field_307 = 1;
        }
        Object var8;
        class_304 var10001;
        class_298 var14;
        if (this.field_627 == null) {
            var14 = new class_298(var2, this, this.field_625, this.field_623, var3.method_3109());
            class_298 var15 = var14;
            var10001 = new class_304(var3.method_3109());
            var15.field_1741 = var10001;
            Object var16;
            if (this.field_619.method_819()) {
                var16 = var3;
            } else {
                var16 = this.field_619.method_814(var1, var15, var3.method_3078());
                if ((((class_301)var16).field_1783 & 1) != 0) {
                    this.field_446 |= 536870912;
                }
            }
            var15.method_3062(this.field_623, this);
            if (this.field_621 != null) {
                int var17;
                this.field_626 = new boolean[var17 = this.field_620.length];
                this.field_639 = new int[var17];
                for (int var18 = 0; var18 < var17; ++var18) {
                    if (this.field_625[var18].method_171(true)) {
                        var8 = var15.field_1741.method_3121(var3.method_3107().method_3072(var15.method_3063(this.field_625[var18])).method_3072((class_301)var16).method_3072(var15.field_1770));
                    } else {
                        var8 = var3.method_3107().method_3072(var15.method_3063(this.field_625[var18])).method_3072(((class_301)var16).method_3106()).method_3072(var15.field_1770.method_3106());
                    }
                    class_65 var20 = this.field_621[var18].field_670;
                    ((class_301)var8).method_3099(var20);
                    ((class_301)var8).method_3097(var20);
                    if (this.field_619.field_572 == null) {
                        ((class_301)var8).method_3104(1);
                    }
                    class_301 var21 = this.field_620[var18].method_814(var1, var2, (class_301)var8);
                    this.field_639[var18] = var1.method_635().method_729(var21);
                    this.field_626[var18] = (var21.field_1783 & 1) != 0;
                    var16 = ((class_301)var16).method_3105(var21.method_3109());
                }
            }
            this.field_636 = var1.method_635().method_729((class_301)var16);
            if (var2.field_1741 != null) {
                var2.field_1741.method_3120(var15.field_1741);
            }
            return (class_301)var16;
        } else {
            class_294 var10000 = new class_294(var2, this);
            class_294 var4 = var10000;
            class_112 var13 = this.field_622;
            class_300 var10002 = new class_300(var2, this.field_622);
            class_300 var5 = var10002;
            class_303 var6 = var13.method_814(var1, var10002, var3.method_3106()).method_3109();
            if (var6 == class_301.field_1784) {
                this.field_446 |= 16384;
                this.field_623.method_644().method_1550(this.field_622);
            }
            this.field_624 = var6;
            var14 = new class_298(var4, this, this.field_625, this.field_623, var3.method_3109());
            class_298 var7 = var14;
            var10001 = new class_304(var3.method_3109());
            var7.field_1741 = var10001;
            if (this.field_619.method_819()) {
                var8 = var3;
            } else {
                var8 = this.field_619.method_814(var1, var7, var3.method_3078());
                if ((((class_301)var8).field_1783 & 1) != 0) {
                    this.field_446 |= 536870912;
                }
            }
            var7.method_3062(this.field_623, this);
            if (this.field_621 != null) {
                int var9;
                this.field_626 = new boolean[var9 = this.field_620.length];
                this.field_639 = new int[var9];
                for (int var10 = 0; var10 < var9; ++var10) {
                    Object var11;
                    if (this.field_625[var10].method_171(true)) {
                        var11 = var7.field_1741.method_3121(var3.method_3107().method_3072(var7.method_3063(this.field_625[var10])).method_3072((class_301)var8).method_3072(var7.field_1770));
                    } else {
                        var11 = var3.method_3107().method_3072(var7.method_3063(this.field_625[var10])).method_3072(((class_301)var8).method_3106()).method_3072(var7.field_1770.method_3106());
                    }
                    class_65 var12 = this.field_621[var10].field_670;
                    ((class_301)var11).method_3099(var12);
                    ((class_301)var11).method_3097(var12);
                    if (this.field_619.field_572 == null) {
                        ((class_301)var11).method_3104(1);
                    }
                    class_301 var22 = this.field_620[var10].method_814(var1, var4, (class_301)var11);
                    this.field_639[var10] = var1.method_635().method_729(var22);
                    this.field_626[var10] = (var22.field_1783 & 1) != 0;
                    var8 = ((class_301)var8).method_3105(var22.method_3109());
                }
            }
            var5.method_3068(var7.field_1741.method_3121((class_301)((((class_301)var8).field_1783 & 1) == 0 ? var3.method_3107().method_3072((class_301)var8).method_3072(var4.field_1744) : var4.field_1744)), var1);
            if (var2.field_1741 != null) {
                var2.field_1741.method_3120(var7.field_1741);
            }
            this.field_638 = var1.method_635().method_729((class_301)var8);
            if (var6 == class_301.field_1784) {
                this.field_636 = var1.method_635().method_729(var6);
                return var6;
            } else {
                class_301 var19 = ((class_301)var8).method_3071(var6);
                this.field_636 = var1.method_635().method_729(var19);
                return var19;
            }
        }
    }

    public class_73 method_872(class_268 var1) {
        return this.field_627 == null ? null : super.method_872(var1);
    }

    public void method_873(class_268 var1) {
        int var2 = 0;
        for (int var3 = this.field_631 == null ? 0 : this.field_631.length; var2 < var3; ++var2) {
            this.field_631[var2].method_449();
        }
    }

    public void method_874() {
        if (this.field_627 != null) {
            super.method_874();
        }
    }

    public void method_878(class_268 var1) {
        int var2 = 0;
        for (int var3 = this.field_631 == null ? 0 : this.field_631.length; var2 < var3; ++var2) {
            this.field_631[var2].method_448();
        }
    }

    private int method_879() {
        return this.field_627 == null ? 0 : (this.method_876() ? 2 : (this.field_623.method_577().field_1957 ? 3 : 1));
    }

    public void method_818(class_86 var1, class_268 var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            boolean var3 = var2 instanceof StackMapFrameCodeStream;
            this.field_615 = null;
            this.field_632 = null;
            this.field_633 = null;
            this.field_635 = 0;
            int var4 = var2.field_1208;
            int var5 = this.method_879();
            boolean var6 = false;
            int var7 = this.field_621 == null ? 0 : this.field_621.length;
            class_73[] var8;
            class_73 var10000;
            if (var7 > 0) {
                var8 = new class_73[var7];
                for (int var9 = 0; var9 < var7; ++var9) {
                    var10000 = new class_73(var2, this.field_621[var9].field_670.field_301);
                    class_73 var10 = var10000;
                    var10.method_449();
                    var8[var9] = var10;
                }
            } else {
                var8 = null;
            }
            if (this.field_627 != null) {
                this.field_627.method_456(var2);
                this.method_872(var2);
            }
            try {
                this.field_631 = var8;
                this.field_619.method_818(this.field_623, var2);
            } finally {
                this.field_631 = null;
            }
            boolean var18 = var2.field_1208 != var4;
            if (var18) {
                BranchLabel var17 = new BranchLabel(var2);
                BranchLabel var19 = var17;
                BranchLabel var11 = null;
                int var12;
                for (var12 = 0; var12 < var7; ++var12) {
                    var8[var12].method_448();
                }
                if ((this.field_446 & 536870912) == 0) {
                    var12 = var2.field_1208;
                    switch (var5) {
                        case 0:
                            if (this.field_638 != -1) {
                                var2.method_2363(var1, this.field_638);
                                var2.method_2088(var1, this.field_638);
                            }
                            var2.method_2209(var19);
                            break;
                        case 1:
                        case 3:
                            var6 = true;
                            if (this.field_638 != -1) {
                                var2.method_2363(var1, this.field_638);
                                var2.method_2088(var1, this.field_638);
                            }
                            var2.method_2209(var19);
                            break;
                        case 2:
                            var2.method_2209(this.field_627);
                    }
                    var2.method_2380(this.field_619.field_574, var12);
                }
                this.method_874();
                int var14;
                if (this.field_621 != null) {
                    var17 = new BranchLabel(var2);
                    var11 = var17;
                    for (var12 = 0; var12 < var7; ++var12) {
                        if (var8[var12].field_325 != 0) {
                            this.method_872(var2);
                            if (this.field_637 != -1) {
                                var2.method_2363(var1, this.field_637);
                                var2.method_2088(var1, this.field_637);
                            }
                            var2.method_2355(var8[var12].field_326);
                            var8[var12].method_447();
                            var14 = var2.field_1208;
                            class_65 var13;
                            if ((var13 = this.field_621[var12].field_670).field_306 != -1) {
                                var2.method_2376(var13, false);
                                var13.method_415(var2.field_1208);
                                var2.method_2090(var13);
                            } else {
                                var2.method_2352();
                            }
                            var2.method_2360(var14, this.field_621[var12].field_444);
                            this.field_620[var12].method_818(this.field_623, var2);
                            this.method_874();
                            if (!this.field_626[var12]) {
                                switch (var5) {
                                    case 1:
                                        var6 = true;
                                    case 0:
                                        if (this.field_638 != -1) {
                                            var2.method_2363(var1, this.field_638);
                                            var2.method_2088(var1, this.field_638);
                                        }
                                        var2.method_2209(var19);
                                        break;
                                    case 2:
                                        var2.method_2209(this.field_627);
                                        break;
                                    case 3:
                                        if (var3) {
                                            ((StackMapFrameCodeStream)var2).method_2401(this.field_638);
                                        }
                                        if (this.field_639[var12] != -1) {
                                            var2.method_2363(var1, this.field_639[var12]);
                                            var2.method_2088(var1, this.field_639[var12]);
                                        }
                                        this.field_622.method_818(this.field_623, var2);
                                        var2.method_2209(var11);
                                        if (var3) {
                                            ((StackMapFrameCodeStream)var2).method_2400();
                                        }
                                }
                            }
                        }
                    }
                }
                if (var6 && var5 == 1) {
                    var10000 = new class_73(var2, (class_40)null);
                } else {
                    var10000 = null;
                }
                class_73 var20 = var10000;
                int var21 = var2.field_1208;
                if (this.field_627 != null && this.field_615.field_325 != 0) {
                    var2.method_2355(this.field_623.method_611());
                    if (this.field_637 != -1) {
                        var2.method_2363(var1, this.field_637);
                        var2.method_2088(var1, this.field_637);
                    }
                    this.method_877();
                    if (var20 != null) {
                        var20.method_447();
                    }
                    switch (var5) {
                        case 1:
                            var2.method_2376(this.field_628, false);
                            var2.method_2297(this.field_627);
                            var2.method_2360(var21, this.field_622.field_444);
                            var14 = var2.field_1208;
                            var2.method_2379(this.field_628);
                            var2.method_2360(var14, this.field_622.field_445);
                            this.field_627.method_458();
                            var2.method_2355(this.field_623.method_611());
                            var14 = var2.field_1208;
                            var2.method_2376(this.field_629, false);
                            var2.method_2360(var14, this.field_622.field_444);
                            this.field_622.method_818(this.field_623, var2);
                            var14 = var2.field_1208;
                            var2.method_2370(this.field_629.field_306);
                            var2.method_2360(var14, this.field_622.field_445);
                            break;
                        case 2:
                            var2.method_2352();
                            this.field_627.method_458();
                            var2.method_2360(var21, this.field_622.field_444);
                            this.field_622.method_818(this.field_623, var2);
                            break;
                        case 3:
                            var2.method_2376(this.field_628, false);
                            var2.method_2091(this.field_628);
                            var2.method_2360(var21, this.field_622.field_444);
                            this.field_622.method_818(var1, var2);
                            var14 = var2.field_1208;
                            var2.method_2379(this.field_628);
                            var2.method_2365(this.field_628);
                            if (this.field_637 != -1) {
                                var2.method_2363(var1, this.field_637);
                            }
                            this.field_627.method_458();
                            var2.method_2360(var14, this.field_622.field_445);
                    }
                    if (var6) {
                        switch (var5) {
                            case 1:
                                var19.method_458();
                                var14 = var2.field_1208;
                                var20.method_449();
                                var2.method_2297(this.field_627);
                                var20.method_448();
                                var2.method_2360(var14, this.field_622.field_445);
                            case 2:
                                break;
                            case 3:
                                if (var3) {
                                    ((StackMapFrameCodeStream)var2).method_2401(this.field_638);
                                }
                                if (this.field_638 != -1) {
                                    var2.method_2363(var1, this.field_638);
                                    var2.method_2088(var1, this.field_638);
                                }
                                var19.method_458();
                                this.field_622.method_818(this.field_623, var2);
                                if (var11 != null) {
                                    var14 = var2.field_1208;
                                    var2.method_2209(var11);
                                    var2.method_2360(var14, this.field_622.field_445);
                                }
                                if (var3) {
                                    ((StackMapFrameCodeStream)var2).method_2400();
                                }
                                break;
                            default:
                                var19.method_458();
                        }
                    }
                    if (var11 != null) {
                        var11.method_458();
                    }
                } else {
                    var19.method_458();
                }
            } else if (this.field_627 != null) {
                this.field_622.method_818(this.field_623, var2);
            }
            if (this.field_636 != -1) {
                var2.method_2363(var1, this.field_636);
                var2.method_2088(var1, this.field_636);
            }
            var2.method_2360(var4, this.field_444);
        }
    }

    public boolean method_875(class_86 var1, class_268 var2, Object var3, int var4, class_65 var5) {
        boolean var6 = var2 instanceof StackMapFrameCodeStream;
        int var7 = this.method_879();
        switch (var7) {
            case 0:
                this.method_878(var2);
                return false;
            case 2:
                var2.method_2209(this.field_627);
                return true;
            default:
                if (var3 != null) {
                    boolean var8 = true;
                    if (this.field_635 > 0) {
                        int var9 = 0;
                        for (int var10 = this.field_635; var9 < var10; ++var9) {
                            Object var11 = this.field_632[var9];
                            if (var3 == var11 || var3 instanceof class_331 && var11 instanceof class_331 && ((class_331)var3).method_3283((class_331)var11)) {
                                if (this.field_634[var9] == var4 || var7 != 3 || !var6) {
                                    var2.method_2209(this.field_633[var9]);
                                    return true;
                                }
                                var8 = false;
                                break;
                            }
                        }
                    } else {
                        this.field_632 = new Object[3];
                        this.field_633 = new BranchLabel[3];
                        this.field_634 = new int[3];
                    }
                    if (var8) {
                        if (this.field_635 == this.field_632.length) {
                            System.arraycopy(this.field_632, 0, this.field_632 = new Object[2 * this.field_635], 0, this.field_635);
                            System.arraycopy(this.field_633, 0, this.field_633 = new BranchLabel[2 * this.field_635], 0, this.field_635);
                            System.arraycopy(this.field_634, 0, this.field_634 = new int[2 * this.field_635], 0, this.field_635);
                        }
                        this.field_632[this.field_635] = var3;
                        BranchLabel var10000 = new BranchLabel(var2);
                        BranchLabel var12 = var10000;
                        var12.method_458();
                        this.field_634[this.field_635] = var4;
                        this.field_633[this.field_635++] = var12;
                    }
                }
                if (var7 == 3) {
                    if (var6) {
                        ((StackMapFrameCodeStream)var2).method_2401(var4);
                        if (this.field_638 != -1 || var4 != -1) {
                            var2.method_2363(var1, this.field_638);
                            var2.method_2088(var1, this.field_638);
                        }
                    } else if (this.field_638 != -1) {
                        var2.method_2363(var1, this.field_638);
                        var2.method_2088(var1, this.field_638);
                    }
                    if (var5 != null) {
                        var2.method_2091(var5);
                    }
                    this.method_874();
                    this.method_878(var2);
                    this.field_622.method_818(var1, var2);
                    if (var6) {
                        ((StackMapFrameCodeStream)var2).method_2400();
                    }
                } else {
                    var2.method_2297(this.field_627);
                    this.method_874();
                    this.method_878(var2);
                }
                return false;
        }
    }

    public boolean method_876() {
        return (this.field_446 & 16384) != 0;
    }

    public StringBuffer method_820(int var1, StringBuffer var2) {
        method_759(var1, var2).append("try \n");
        this.field_619.method_820(var1 + 1, var2);
        if (this.field_620 != null) {
            for (int var3 = 0; var3 < this.field_620.length; ++var3) {
                var2.append('\n');
                method_759(var1, var2).append("catch (");
                this.field_621[var3].method_757(0, var2).append(") ");
                this.field_620[var3].method_820(var1 + 1, var2);
            }
        }
        if (this.field_622 != null) {
            var2.append('\n');
            method_759(var1, var2).append("finally\n");
            this.field_622.method_820(var1 + 1, var2);
        }
        return var2;
    }

    public void method_821(class_86 var1) {
        class_86 var10001 = new class_86(var1);
        this.field_623 = var10001;
        class_86 var10000 = new class_86(this.field_623);
        class_86 var2 = var10000;
        class_86 var3 = null;
        if (this.field_622 != null) {
            if (this.field_622.method_819()) {
                if ((this.field_622.field_446 & 8) != 0) {
                    this.field_623.method_644().method_1783(this.field_622.field_444, this.field_622.field_445);
                }
            } else {
                var10000 = new class_86(this.field_623, false);
                var3 = var10000;
                class_87 var4 = this.field_623.method_635();
                class_65 var10;
                if (!var1.method_577().field_1957) {
                    var10 = new class_65(field_616, var1.method_609(), 0, false);
                    this.field_629 = var10;
                    var3.method_704(this.field_629);
                    this.field_629.method_410(class_331.field_1896);
                }
                BranchLabel var9 = new BranchLabel();
                this.field_627 = var9;
                var10 = new class_65(field_617, this.field_623.method_611(), 0, false);
                this.field_628 = var10;
                var3.method_704(this.field_628);
                this.field_628.method_410(class_331.field_1896);
                if (!var4.method_727()) {
                    class_58 var5 = ((AbstractMethodDeclaration)var4.field_403).field_488;
                    if (var5 != null) {
                        class_40 var6 = var5.field_275;
                        if (var6.field_177 != 6) {
                            var10 = new class_65(field_618, var6, 0, false);
                            this.field_630 = var10;
                            var3.method_704(this.field_630);
                            this.field_630.method_410(class_331.field_1896);
                        }
                    }
                }
                this.field_622.method_842(var3);
                var3.field_396 = new class_86[this.field_621 == null ? 1 : this.field_621.length + 1];
                var3.field_396[0] = var2;
            }
        }
        this.field_619.method_842(var2);
        if (this.field_620 != null) {
            int var11 = this.field_621.length;
            class_40[] var12 = new class_40[var11];
            boolean var13 = false;
            int var7;
            for (var7 = 0; var7 < var11; ++var7) {
                var10000 = new class_86(this.field_623);
                class_86 var8 = var10000;
                if (var3 != null) {
                    var3.field_396[var7 + 1] = var8;
                }
                if ((var12[var7] = this.field_621[var7].method_905(var8)) == null) {
                    var13 = true;
                }
                this.field_620[var7].method_842(var8);
            }
            if (var13) {
                return;
            }
            this.field_625 = new ReferenceBinding[var11];
            for (var7 = 0; var7 < var11; ++var7) {
                this.field_625[var7] = (ReferenceBinding)var12[var7];
                for (int var14 = 0; var14 < var7; ++var14) {
                    if (this.field_625[var7].method_152(var12[var14])) {
                        this.field_623.method_644().method_1826(this, this.field_625[var7], var7, var12[var14]);
                    }
                }
            }
        } else {
            this.field_625 = new ReferenceBinding[0];
        }
        if (var3 != null) {
            this.field_623.method_705(var3);
        }
    }

    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2065(this, var2)) {
            this.field_619.method_763(var1, this.field_623);
            if (this.field_621 != null) {
                int var3 = 0;
                for (int var4 = this.field_620.length; var3 < var4; ++var3) {
                    this.field_621[var3].method_763(var1, this.field_623);
                    this.field_620[var3].method_763(var1, this.field_623);
                }
            }
            if (this.field_622 != null) {
                this.field_622.method_763(var1, this.field_623);
            }
        }
        var1.method_1980(this, var2);
    }

    static {
        field_616 = " returnAddress".toCharArray();
        field_617 = " anyExceptionHandler".toCharArray();
        field_618 = " returnValue".toCharArray();
    }
}
