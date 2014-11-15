package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.lookup.class_17;
import org.eclipse.jdt.internal.compiler.lookup.class_32;
import org.eclipse.jdt.internal.compiler.lookup.class_34;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.class_46;
import org.eclipse.jdt.internal.compiler.lookup.class_52;
import org.eclipse.jdt.internal.compiler.lookup.class_58;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;
import org.eclipse.jdt.internal.compiler.lookup.class_83;
import org.eclipse.jdt.internal.compiler.lookup.class_88;

public class class_62 extends class_58 {

    protected class_58 field_292;

    public class_62(class_52 var1, class_58 var2) {
        super(var2.field_273, var2.field_274, var2.field_275, var2.field_276, var2.field_277, var1);
        this.field_292 = var2;
        this.field_281 = var2.field_281;
        class_46[] var3 = var2.field_279;
        Object var4 = null;
        int var5 = var3.length;
        boolean var6 = var2.method_370();
        int var8;
        if (var5 == 0) {
            this.field_279 = class_34.field_157;
            if (!var6) {
                var4 = var1;
            }
        } else {
            class_46[] var7 = new class_46[var5];
            class_46 var9;
            for (var8 = 0; var8 < var5; ++var8) {
                var9 = var3[var8];
                class_46 var10002 = new class_46(var9.field_198, this, var9.field_221);
                var7[var8] = var10002;
            }
            this.field_279 = var7;
            class_88 var10000 = new class_88(this, var1, var6, var5, var3, var7);
            var4 = var10000;
            for (var8 = 0; var8 < var5; ++var8) {
                var9 = var3[var8];
                class_46 var10 = var7[var8];
                class_40 var11 = class_83.method_571((class_32)var4, var9.field_223);
                ReferenceBinding[] var12 = class_83.method_570((class_32)var4, var9.field_224);
                if (var9.field_222 != null) {
                    var10.field_222 = (class_40)(var9.field_222 == var9.field_223 ? var11 : var12[0]);
                }
                switch (var11.method_98()) {
                    case 68:
                        var10.field_223 = var1.field_244.method_506(class_17.field_99, (class_83)null);
                        var10.field_224 = var12;
                        break;
                    default:
                        if (var11.method_157()) {
                            var10.field_223 = var1.field_244.method_506(class_17.field_99, (class_83)null);
                            int var13 = var12.length;
                            System.arraycopy(var12, 0, var12 = new ReferenceBinding[var13 + 1], 1, var13);
                            var12[0] = (ReferenceBinding)var11;
                            var10.field_224 = var12;
                        } else {
                            var10.field_223 = (ReferenceBinding)var11;
                            var10.field_224 = var12;
                        }
                }
            }
        }
        if (var4 != null) {
            this.field_275 = class_83.method_571((class_32)var4, this.field_275);
            this.field_276 = class_83.method_572((class_32)var4, this.field_276);
            this.field_277 = class_83.method_570((class_32)var4, this.field_277);
            if (this.field_277 == null) {
                this.field_277 = class_34.field_151;
            }
        }
        if ((this.field_281 & 128L) == 0L) {
            if ((this.field_275.field_178 & 128L) != 0L) {
                this.field_281 |= 128L;
            } else {
                int var14 = 0;
                var8 = this.field_276.length;
                while (true) {
                    if (var14 >= var8) {
                        var14 = 0;
                        for (var8 = this.field_277.length; var14 < var8; ++var14) {
                            if ((this.field_277[var14].field_178 & 128L) != 0L) {
                                this.field_281 |= 128L;
                                return;
                            }
                        }
                        return;
                    }
                    if ((this.field_276[var14].field_178 & 128L) != 0L) {
                        this.field_281 |= 128L;
                        break;
                    }
                    ++var14;
                }
            }
        }
    }

    public class_62() {
    }

    public static class_62 method_399(class_40 var0, class_58 var1, class_83 var2) {
        class_62 var10000 = new class_62();
        class_62 var3 = var10000;
        var3.field_273 = var1.field_273;
        var3.field_274 = var1.field_274;
        var3.field_278 = var1.field_278;
        var3.field_279 = class_34.field_157;
        var3.field_292 = var1;
        var3.field_276 = var1.field_276;
        var3.field_277 = var1.field_277;
        var3.field_281 = var1.field_281;
        ReferenceBinding var4 = var2.method_606();
        LookupEnvironment var5 = var2.method_586();
        class_40 var6 = var5.method_490(var0.method_138(), false);
        var3.field_275 = var5.method_500(var4, new class_40[] {var5.method_502(var4, 0, var6, (class_40[])null, 1)}, (ReferenceBinding)null);
        if ((var3.field_275.field_178 & 128L) != 0L) {
            var3.field_281 |= 128L;
        }
        return var3;
    }

    public boolean method_354() {
        return this.field_276 != this.field_292.field_276;
    }

    public boolean method_355() {
        return this.field_275 != this.field_292.field_275;
    }

    public class_58 method_376() {
        return this.field_292.method_376();
    }
}
