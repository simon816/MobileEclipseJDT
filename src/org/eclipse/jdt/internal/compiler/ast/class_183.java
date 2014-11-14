package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.class_264;
import org.eclipse.jdt.internal.compiler.ast.class_177;
import org.eclipse.jdt.internal.compiler.codegen.class_268;
import org.eclipse.jdt.internal.compiler.impl.class_331;
import org.eclipse.jdt.internal.compiler.impl.class_332;
import org.eclipse.jdt.internal.compiler.impl.class_335;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.class_86;
import org.eclipse.jdt.internal.compiler.parser.ScannerHelper;

public class class_183 extends class_177 {

    static final class_331 field_802;

    public class_183(char[] var1, int var2, int var3) {
        super(var1, var2, var3);
    }

    public void method_1081() {
        int var1 = this.field_792.length - 1;
        long var2;
        int var8;
        if (this.field_792[0] == 48) {
            if (var1 == 1) {
                this.field_672 = class_335.method_3297(0L);
                return;
            }
            byte var4;
            byte var5;
            int var6;
            if (this.field_792[1] != 120 && this.field_792[1] != 88) {
                var4 = 3;
                var6 = 1;
                var5 = 8;
            } else {
                var4 = 4;
                var6 = 2;
                var5 = 16;
            }
            boolean var7 = false;
            while (this.field_792[var6] == 48) {
                ++var6;
                if (var6 == var1) {
                    this.field_672 = class_335.method_3297(0L);
                    return;
                }
            }
            if ((var8 = ScannerHelper.method_3339(this.field_792[var6++], var5)) < 0) {
                this.field_672 = field_802;
                return;
            }
            int var11;
            if (var8 >= 8) {
                var11 = 4;
            } else if (var8 >= 4) {
                var11 = 3;
            } else if (var8 >= 2) {
                var11 = 2;
            } else {
                var11 = 1;
            }
            for (var2 = (long)var8; var6 < var1; var2 = var2 << var4 | (long)var8) {
                if ((var8 = ScannerHelper.method_3339(this.field_792[var6++], var5)) < 0) {
                    this.field_672 = field_802;
                    return;
                }
                if ((var11 += var4) > 64) {
                    return;
                }
            }
        } else {
            long var10 = 0L;
            var2 = 0L;
            for (var8 = 0; var8 < var1; ++var8) {
                int var9;
                if ((var9 = ScannerHelper.method_3339(this.field_792[var8], 10)) < 0) {
                    return;
                }
                var10 = var2;
                if (var2 > 922337203685477580L) {
                    return;
                }
                var2 *= 10L;
                if (var2 + (long)var9 > Long.MAX_VALUE) {
                    return;
                }
                var2 += (long)var9;
                if (var10 > var2) {
                    return;
                }
            }
        }
        this.field_672 = class_335.method_3297(var2);
    }

    public void method_912(class_86 var1, class_268 var2, boolean var3) {
        int var4 = var2.field_1208;
        if (var3) {
            var2.method_2179(this.field_672, this.field_674);
        }
        var2.method_2360(var4, this.field_444);
    }

    public class_40 method_1082(class_86 var1) {
        return class_40.field_183;
    }

    public final boolean method_1095() {
        return this.field_792.length == 20 && this.field_792[0] == 57 && this.field_792[1] == 50 && this.field_792[2] == 50 && this.field_792[3] == 51 && this.field_792[4] == 51 && this.field_792[5] == 55 && this.field_792[6] == 50 && this.field_792[7] == 48 && this.field_792[8] == 51 && this.field_792[9] == 54 && this.field_792[10] == 56 && this.field_792[11] == 53 && this.field_792[12] == 52 && this.field_792[13] == 55 && this.field_792[14] == 55 && this.field_792[15] == 53 && this.field_792[16] == 56 && this.field_792[17] == 48 && this.field_792[18] == 56 && (this.field_446 & 534773760) >> 21 == 0;
    }

    public class_40 method_925(class_86 var1) {
        class_40 var2 = super.method_925(var1);
        if (this.field_672 == field_802) {
            this.field_672 = class_331.field_1896;
            var1.method_644().method_1511(this);
            this.field_675 = null;
            return null;
        } else {
            return var2;
        }
    }

    public void method_763(class_264 var1, class_86 var2) {
        var1.method_2032(this, var2);
        var1.method_1947(this, var2);
    }

    static {
        field_802 = class_332.method_3291(Double.POSITIVE_INFINITY);
    }
}
