package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ClassFile;
import org.eclipse.jdt.internal.compiler.ast.class_114;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.codegen.class_272;
import org.eclipse.jdt.internal.compiler.lookup.InvocationSite;
import org.eclipse.jdt.internal.compiler.lookup.class_17;
import org.eclipse.jdt.internal.compiler.lookup.class_200;
import org.eclipse.jdt.internal.compiler.lookup.class_203;
import org.eclipse.jdt.internal.compiler.lookup.class_34;
import org.eclipse.jdt.internal.compiler.lookup.PackageBinding;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.class_42;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.class_46;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.class_60;
import org.eclipse.jdt.internal.compiler.lookup.class_63;
import org.eclipse.jdt.internal.compiler.lookup.class_66;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;
import org.eclipse.jdt.internal.compiler.lookup.class_83;
import org.eclipse.jdt.internal.compiler.lookup.class_84;

import java.util.List;

public class class_58 extends class_34 {

    public int field_273;

    public char[] field_274;

    public class_40 field_275;

    public class_40[] field_276;

    public ReferenceBinding[] field_277;

    public ReferenceBinding field_278;

    public class_46[] field_279;

    char[] field_280;

    public long field_281;

    protected class_58() {
        this.field_279 = class_34.field_157;
    }

    public class_58(int var1, char[] var2, class_40 var3, class_40[] var4, ReferenceBinding[] var5, ReferenceBinding var6) {
        this.field_279 = class_34.field_157;
        this.field_273 = var1;
        this.field_274 = var2;
        this.field_275 = var3;
        this.field_276 = var4 != null && var4.length != 0 ? var4 : class_34.field_150;
        this.field_277 = var5 != null && var5.length != 0 ? var5 : class_34.field_151;
        this.field_278 = var6;
        if (this.field_278 != null && this.field_278.method_227() && !this.method_365() && !this.method_356()) {
            this.field_273 |= 2048;
        }
    }

    public class_58(int var1, class_40[] var2, ReferenceBinding[] var3, ReferenceBinding var4) {
        this(var1, class_17.field_135, class_40.field_188, var2, var3, var4);
    }

    public class_58(class_58 var1, ReferenceBinding var2) {
        this.field_279 = class_34.field_157;
        this.field_273 = var1.field_273;
        this.field_274 = var1.field_274;
        this.field_275 = var1.field_275;
        this.field_276 = var1.field_276;
        this.field_277 = var1.field_277;
        this.field_278 = var2;
        var2.method_237(this, var1.field_278.method_234(var1, true));
    }

    public final boolean method_342(class_58 var1) {
        class_40[] var2 = var1.field_276;
        if (this.field_276 == var2) {
            return true;
        } else {
            int var3 = this.field_276.length;
            if (var3 != var2.length) {
                return false;
            } else {
                for (int var4 = 0; var4 < var3; ++var4) {
                    if (this.field_276[var4] != var2[var4] && this.field_276[var4].method_138() != var2[var4].method_138()) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    public final boolean method_343(class_40[] var1) {
        int var2 = this.field_276.length;
        int var3 = var1.length;
        int var4 = var3;
        if (this.method_374()) {
            var4 = var2 - 1;
            class_40 var5;
            if (var2 == var3) {
                var5 = this.field_276[var4];
                class_40 var6 = var1[var4];
                if (var5 != var6 && !var6.method_152(var5)) {
                    return false;
                }
            } else if (var2 < var3) {
                var5 = ((class_42)this.field_276[var4]).method_187();
                for (int var8 = var4; var8 < var3; ++var8) {
                    if (var5 != var1[var8] && !var1[var8].method_152(var5)) {
                        return false;
                    }
                }
            } else if (var4 != var3) {
                return false;
            }
        }
        for (int var7 = 0; var7 < var4; ++var7) {
            if (this.field_276[var7] != var1[var7] && !var1[var7].method_152(this.field_276[var7])) {
                return false;
            }
        }
        return true;
    }

    public final boolean method_344(class_58 var1) {
        class_40[] var2 = var1.field_276;
        if (this.field_276 == var2) {
            return true;
        } else {
            int var3 = this.field_276.length;
            if (var3 != var2.length) {
                return false;
            } else {
                for (int var4 = 0; var4 < var3; ++var4) {
                    if (this.field_276[var4] != var2[var4]) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    public final boolean method_345(InvocationSite var1, class_83 var2) {
        if (this.method_369()) {
            return true;
        } else {
            SourceTypeBinding var3 = var2.method_585();
            if (var3 == this.field_278) {
                return true;
            } else if (this.method_368()) {
                return var3.field_200 == this.field_278.field_200 ? true : var1.method_1();
            } else if (!this.method_367()) {
                return var3.field_200 == this.field_278.field_200;
            } else {
                Object var4 = var3;
                ReferenceBinding var5;
                for (var5 = var3.method_137(); var5 != null; var5 = var5.method_137()) {
                    var4 = var5;
                }
                ReferenceBinding var6 = (ReferenceBinding)this.field_278.method_138();
                for (var5 = var6.method_137(); var5 != null; var5 = var5.method_137()) {
                    var6 = var5;
                }
                return var4 == var6;
            }
        }
    }

    public final boolean method_346(PackageBinding var1) {
        return this.method_369() ? true : (this.method_367() ? false : var1 == this.field_278.method_143());
    }

    public final boolean method_347(class_40 var1, InvocationSite var2, class_83 var3) {
        if (this.method_369()) {
            return true;
        } else {
            SourceTypeBinding var4 = var3.method_585();
            if (var4 == this.field_278 && var4 == var1) {
                return true;
            } else if (var4 == null) {
                return !this.method_367() && var3.method_600() == this.field_278.field_200;
            } else {
                Object var5;
                ReferenceBinding var7;
                if (this.method_368()) {
                    if (var4 == this.field_278) {
                        return true;
                    } else if (var4.field_200 == this.field_278.field_200) {
                        return true;
                    } else {
                        var5 = var4;
                        class_40 var10 = var1.method_138();
                        var7 = (ReferenceBinding)this.field_278.method_138();
                        int var8 = 0;
                        do {
                            if (((ReferenceBinding)var5).method_140(var7) != null) {
                                if (var2.method_1()) {
                                    return true;
                                }
                                if (var1 instanceof class_42) {
                                    return false;
                                }
                                if (this.method_370()) {
                                    if (var8 > 0) {
                                        var2.method_2(var8);
                                    }
                                    return true;
                                }
                                if (var5 == var10 || var10.method_140((class_40)var5) != null) {
                                    if (var8 > 0) {
                                        var2.method_2(var8);
                                    }
                                    return true;
                                }
                            }
                            ++var8;
                            var5 = ((ReferenceBinding)var5).method_137();
                        } while (var5 != null);
                        return false;
                    }
                } else {
                    ReferenceBinding var6;
                    if (!this.method_367()) {
                        PackageBinding var9 = this.field_278.field_200;
                        if (var4.field_200 != var9) {
                            return false;
                        } else if (var1 instanceof class_42) {
                            return false;
                        } else {
                            var6 = (ReferenceBinding)var1;
                            do {
                                if (this.field_278 == var6) {
                                    return true;
                                }
                                PackageBinding var11 = var6.field_200;
                                if (var11 != null && var11 != var9) {
                                    return false;
                                }
                            } while ((var6 = var6.method_240()) != null);
                            return false;
                        }
                    } else if (var1 != this.field_278 && (!var1.method_169() || !((class_46)var1).method_258(this.field_278.method_138()))) {
                        return false;
                    } else {
                        if (var4 != this.field_278) {
                            var5 = var4;
                            for (var6 = var4.method_137(); var6 != null; var6 = var6.method_137()) {
                                var5 = var6;
                            }
                            var7 = (ReferenceBinding)this.field_278.method_138();
                            for (var6 = var7.method_137(); var6 != null; var6 = var6.method_137()) {
                                var7 = var6;
                            }
                            if (var5 != var7) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
            }
        }
    }

    public List method_348(List var1) {
        if ((this.field_281 & 128L) != 0L) {
            var1 = this.field_275.method_132(var1);
            int var2 = 0;
            int var3;
            for (var3 = this.field_276.length; var2 < var3; ++var2) {
                var1 = this.field_276[var2].method_132(var1);
            }
            var2 = 0;
            for (var3 = this.field_277.length; var2 < var3; ++var2) {
                var1 = this.field_277[var2].method_132(var1);
            }
            var2 = 0;
            for (var3 = this.field_279.length; var2 < var3; ++var2) {
                class_46 var4 = this.field_279[var2];
                var1 = var4.method_240().method_132(var1);
                ReferenceBinding[] var5 = var4.method_241();
                int var6 = 0;
                for (int var7 = var5.length; var6 < var7; ++var6) {
                    var1 = var5[var2].method_132(var1);
                }
            }
        }
        return var1;
    }

    class_58 method_349(class_58 var1, LookupEnvironment var2) {
        int var3 = this.field_279.length;
        class_46[] var4 = var1.field_279;
        if (var3 != var4.length) {
            return null;
        } else {
            class_63 var5 = var2.method_499(var1, this.field_279);
            for (int var6 = 0; var6 < var3; ++var6) {
                if (!this.field_279[var6].method_259(var4[var6], var5)) {
                    return null;
                }
            }
            return var5;
        }
    }

    public class_40 method_350() {
        return this.field_278;
    }

    public char[] method_351() {
        if ((this.field_273 & 1073741824) == 0) {
            return null;
        } else {
            StringBuffer var1 = new StringBuffer(10);
            int var2;
            int var3;
            if (this.field_279 != class_34.field_157) {
                var1.append('<');
                var2 = 0;
                for (var3 = this.field_279.length; var2 < var3; ++var2) {
                    var1.append(this.field_279[var2].method_256());
                }
                var1.append('>');
            }
            var1.append('(');
            var2 = 0;
            for (var3 = this.field_276.length; var2 < var3; ++var2) {
                var1.append(this.field_276[var2].method_142());
            }
            var1.append(')');
            if (this.field_275 != null) {
                var1.append(this.field_275.method_142());
            }
            boolean var6 = false;
            var3 = this.field_277.length;
            int var4;
            for (var4 = 0; var4 < var3; ++var4) {
                if ((this.field_277[var4].field_199 & 1073741824) != 0) {
                    var6 = true;
                    break;
                }
            }
            if (var6) {
                for (var4 = 0; var4 < var3; ++var4) {
                    var1.append('^');
                    var1.append(this.field_277[var4].method_142());
                }
            }
            var4 = var1.length();
            char[] var5 = new char[var4];
            var1.getChars(0, var4, var5, 0);
            return var5;
        }
    }

    public final int method_352() {
        return this.field_273 & '\uffff';
    }

    public long method_99() {
        class_58 var1 = this.method_376();
        if ((var1.field_281 & 8589934592L) == 0L && var1.field_278 instanceof SourceTypeBinding) {
            class_84 var2 = ((SourceTypeBinding)var1.field_278).field_258;
            if (var2 != null) {
                class_114 var3 = var2.field_376;
                AbstractMethodDeclaration var4 = var3.method_854(var1);
                if (var4 != null) {
                    ASTNode.method_761(var4.field_478, var4.field_483, var1);
                }
            }
        }
        return var1.field_281;
    }

    public class_46 method_353(char[] var1) {
        int var2 = this.field_279.length;
        do {
            --var2;
            if (var2 < 0) {
                return null;
            }
        } while (!CharOperation.method_1364(this.field_279[var2].field_198, var1));
        return this.field_279[var2];
    }

    public boolean method_354() {
        return false;
    }

    public boolean method_355() {
        return false;
    }

    public final boolean method_356() {
        return (this.field_273 & 1024) != 0;
    }

    public final boolean method_357() {
        return (this.field_273 & 64) != 0;
    }

    public final boolean method_358() {
        return this.field_274 == class_17.field_135;
    }

    public final boolean method_359() {
        return !this.method_369() && !this.method_368() && !this.method_367();
    }

    public final boolean method_360() {
        return (this.field_273 & 524288) != 0;
    }

    public final boolean method_361() {
        return (this.field_273 & 1048576) != 0;
    }

    public final boolean method_362() {
        return (this.field_273 & 16) != 0;
    }

    public final boolean method_363() {
        return (this.field_273 & 536870912) != 0;
    }

    public final boolean method_364() {
        if (this.field_274.length == 4 && CharOperation.method_1364(this.field_274, class_17.field_36) && (this.field_273 & 9) != 0 && class_40.field_188 == this.field_275 && this.field_276.length == 1) {
            class_40 var1 = this.field_276[0];
            if (var1.method_136() == 1 && var1.method_173().field_177 == 11) {
                return true;
            }
        }
        return false;
    }

    public final boolean method_365() {
        return (this.field_273 & 256) != 0;
    }

    public final boolean method_366() {
        return (this.field_273 & 268435456) != 0;
    }

    public final boolean method_367() {
        return (this.field_273 & 2) != 0;
    }

    public final boolean method_368() {
        return (this.field_273 & 4) != 0;
    }

    public final boolean method_369() {
        return (this.field_273 & 1) != 0;
    }

    public final boolean method_370() {
        return (this.field_273 & 8) != 0;
    }

    public final boolean method_371() {
        return (this.field_273 & 2048) != 0;
    }

    public final boolean method_372() {
        return (this.field_273 & 4096) != 0;
    }

    public final boolean method_373() {
        return (this.field_273 & 134217728) != 0;
    }

    public final boolean method_374() {
        return (this.field_273 & 128) != 0;
    }

    public final boolean method_375() {
        return (this.field_273 & 3145728) != 0;
    }

    public final int method_98() {
        return 8;
    }

    public class_58 method_376() {
        return this;
    }

    public char[] method_103() {
        StringBuffer var1 = new StringBuffer(this.field_276.length + 20);
        if (this.method_358()) {
            var1.append(this.field_278.method_179());
        } else {
            var1.append(this.field_274);
        }
        var1.append('(');
        if (this.field_276 != class_34.field_150) {
            int var2 = 0;
            for (int var3 = this.field_276.length; var2 < var3; ++var2) {
                if (var2 > 0) {
                    var1.append(", ");
                }
                var1.append(this.field_276[var2].method_179());
            }
        }
        var1.append(')');
        return var1.toString().toCharArray();
    }

    public void method_377(class_203[] var1) {
        this.field_278.method_238(this, var1);
    }

    public void method_378(class_203[] var1, class_203[][] var2, Object var3) {
        this.field_278.method_237(this, class_200.method_1169(var1, var2, var3));
    }

    public void method_379(Object var1) {
        class_58 var2 = this.method_376();
        var2.field_281 |= 2251799813685248L;
        class_200 var3 = this.field_278.method_234(this, false);
        if (var3 == null) {
            this.method_378((class_203[])null, (class_203[][])null, var1);
        } else {
            this.method_378(var3.method_1170(), var3.method_1172(), var1);
        }
    }

    public void method_380(class_203[][] var1) {
        class_200 var2 = this.field_278.method_234(this, false);
        if (var2 == null) {
            this.method_378((class_203[])null, var1, (Object)null);
        } else {
            this.method_378(var2.method_1170(), var1, var2.method_1171());
        }
    }

    protected final void method_381(char[] var1) {
        this.field_274 = var1;
        this.field_280 = null;
    }

    public char[] method_104() {
        StringBuffer var1 = new StringBuffer(this.field_276.length + 20);
        if (this.method_358()) {
            var1.append(this.field_278.method_104());
        } else {
            var1.append(this.field_274);
        }
        var1.append('(');
        int var2;
        if (this.field_276 != class_34.field_150) {
            var2 = 0;
            for (int var3 = this.field_276.length; var2 < var3; ++var2) {
                if (var2 > 0) {
                    var1.append(", ");
                }
                var1.append(this.field_276[var2].method_104());
            }
        }
        var1.append(')');
        var2 = var1.length();
        char[] var4 = new char[var2];
        var1.getChars(0, var2, var4, 0);
        return var4;
    }

    public final char[] method_382(ClassFile var1) {
        class_40[] var3;
        boolean var4;
        int var7;
        int var15;
        class_40 var16;
        class_40 var19;
        class_40 var20;
        if (this.field_280 != null) {
            if ((this.field_281 & 512L) != 0L) {
                boolean var12 = this.method_358();
                var3 = this.field_276;
                var4 = var12 && this.field_278.method_160();
                if (var4) {
                    ReferenceBinding[] var13 = this.field_278.method_242();
                    if (var13 != null) {
                        var15 = 0;
                        for (var7 = var13.length; var15 < var7; ++var15) {
                            ReferenceBinding var22 = var13[var15];
                            if (var22.method_160()) {
                                var1.method_3012(var22);
                            }
                        }
                    }
                    if (this instanceof class_60) {
                        var3 = ((class_60)this).field_285.field_276;
                    }
                }
                int var14;
                if (var3 != class_34.field_150) {
                    for (var14 = 0; var14 < var3.length; ++var14) {
                        var16 = var3[var14];
                        var19 = var16.method_173();
                        if (var19.method_160()) {
                            var1.method_3012(var19);
                        }
                    }
                }
                if (var4) {
                    var14 = var3.length;
                    for (var15 = this.field_276.length; var14 < var15; ++var14) {
                        var19 = this.field_276[var14];
                        var20 = var19.method_173();
                        if (var20.method_160()) {
                            var1.method_3012(var20);
                        }
                    }
                }
                if (this.field_275 != null) {
                    class_40 var18 = this.field_275.method_173();
                    if (var18.method_160()) {
                        var1.method_3012(var18);
                    }
                }
            }
            return this.field_280;
        } else {
            StringBuffer var2 = new StringBuffer(this.field_276.length + 20);
            var2.append('(');
            var3 = this.field_276;
            var4 = this.method_358();
            if (var4 && this.field_278.method_153()) {
                var2.append(class_272.field_1433);
                var2.append(class_40.field_179.method_178());
            }
            boolean var5 = var4 && this.field_278.method_160();
            int var8;
            if (var5) {
                ReferenceBinding[] var6 = this.field_278.method_242();
                if (var6 != null) {
                    var7 = 0;
                    for (var8 = var6.length; var7 < var8; ++var7) {
                        ReferenceBinding var9 = var6[var7];
                        if (var9.method_160()) {
                            this.field_281 |= 512L;
                            var1.method_3012(var9);
                        }
                        var2.append(var9.method_178());
                    }
                }
                if (this instanceof class_60) {
                    var3 = ((class_60)this).field_285.field_276;
                }
            }
            if (var3 != class_34.field_150) {
                for (var15 = 0; var15 < var3.length; ++var15) {
                    var19 = var3[var15];
                    var20 = var19.method_173();
                    if (var20.method_160()) {
                        this.field_281 |= 512L;
                        var1.method_3012(var20);
                    }
                    var2.append(var19.method_178());
                }
            }
            if (var5) {
                class_66[] var17 = this.field_278.method_243();
                var7 = var17 == null ? 0 : var17.length;
                for (var8 = 0; var8 < var7; ++var8) {
                    var2.append(var17[var8].field_301.method_178());
                }
                var8 = var3.length;
                for (int var21 = this.field_276.length; var8 < var21; ++var8) {
                    class_40 var10 = this.field_276[var8];
                    class_40 var11 = var10.method_173();
                    if (var11.method_160()) {
                        this.field_281 |= 512L;
                        var1.method_3012(var11);
                    }
                    var2.append(var10.method_178());
                }
            }
            var2.append(')');
            if (this.field_275 != null) {
                var16 = this.field_275.method_173();
                if (var16.method_160()) {
                    this.field_281 |= 512L;
                    var1.method_3012(var16);
                }
                var2.append(this.field_275.method_178());
            }
            var15 = var2.length();
            this.field_280 = new char[var15];
            var2.getChars(0, var15, this.field_280, 0);
            return this.field_280;
        }
    }

    public final int method_383() {
        AbstractMethodDeclaration var1 = this.method_384();
        return var1 == null ? (this.field_278 instanceof SourceTypeBinding ? ((SourceTypeBinding)this.field_278).method_317() : 0) : var1.field_445;
    }

    public AbstractMethodDeclaration method_384() {
        SourceTypeBinding var1;
        try {
            var1 = (SourceTypeBinding)this.field_278;
        } catch (ClassCastException var4) {
            return null;
        }
        AbstractMethodDeclaration[] var2 = var1.field_258.field_376.field_584;
        int var3 = var2.length;
        do {
            --var3;
            if (var3 < 0) {
                return null;
            }
        } while (this != var2[var3].field_488);
        return var2[var3];
    }

    public final int method_385() {
        AbstractMethodDeclaration var1 = this.method_384();
        return var1 == null ? (this.field_278 instanceof SourceTypeBinding ? ((SourceTypeBinding)this.field_278).method_318() : 0) : var1.field_444;
    }

    public class_58 method_386() {
        return this;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer(10);
        if ((this.field_273 & 33554432) != 0) {
            var1.append("[unresolved] ");
        }
        ASTNode.method_760(this.field_273, var1);
        var1.append(this.field_275 != null ? this.field_275.method_135() : "<no type>");
        var1.append(" ");
        var1.append(this.field_274 != null ? new String(this.field_274) : "<no selector>");
        var1.append("(");
        int var2;
        int var3;
        if (this.field_276 != null) {
            if (this.field_276 != class_34.field_150) {
                var2 = 0;
                for (var3 = this.field_276.length; var2 < var3; ++var2) {
                    if (var2 > 0) {
                        var1.append(", ");
                    }
                    var1.append(this.field_276[var2] != null ? this.field_276[var2].method_135() : "<no argument type>");
                }
            }
        } else {
            var1.append("<no argument types>");
        }
        var1.append(") ");
        if (this.field_277 != null) {
            if (this.field_277 != class_34.field_151) {
                var1.append("throws ");
                var2 = 0;
                for (var3 = this.field_277.length; var2 < var3; ++var2) {
                    if (var2 > 0) {
                        var1.append(", ");
                    }
                    var1.append(this.field_277[var2] != null ? this.field_277[var2].method_135() : "<no exception type>");
                }
            }
        } else {
            var1.append("<no exception types>");
        }
        return var1.toString();
    }
}
