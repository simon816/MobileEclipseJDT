package h;

import a.class_333;
import c.class_264;
import f.class_215;
import h.class_177;
import i.class_268;
import m.class_40;
import m.class_86;

// $FF: renamed from: h.k
public class class_179 extends class_177 {

    // $FF: renamed from: a float
    float field_794;
    // $FF: renamed from: b float
    static final float field_795;

    // $FF: renamed from: <init> (char[], int, int) void
    public class_179(char[] var1, int var2, int var3) {
        super(var1, var2, var3);
    }

    // $FF: renamed from: a () void
    public void method_1081() {
        Float var1;
        try {
            var1 = Float.valueOf(String.valueOf(this.field_792));
        } catch (NumberFormatException var6) {
            try {
                float var3 = class_215.method_1223(this.field_792);
                if (var3 == Float.POSITIVE_INFINITY) {
                    return;
                }
                if (Float.isNaN(var3)) {
                    return;
                }
                this.field_794 = var3;
                this.field_672 = class_333.method_3293(var3);
            } catch (NumberFormatException var5) {
                ;
            }
            return;
        }
        float var2 = var1.floatValue();
        if (var2 <= Float.MAX_VALUE) {
            if (var2 < Float.MIN_VALUE) {
                boolean var7 = false;
                int var4 = 0;
                label52:
                while (var4 < this.field_792.length) {
                    switch (this.field_792[var4]) {
                        case 68:
                        case 69:
                        case 70:
                        case 100:
                        case 101:
                        case 102:
                            if (var7) {
                                return;
                            }
                        case 80:
                        case 112:
                            break label52;
                        case 88:
                        case 120:
                            var7 = true;
                        case 46:
                        case 48:
                            ++var4;
                            break;
                        default:
                            return;
                    }
                }
            }
            this.field_794 = var2;
            this.field_672 = class_333.method_3293(this.field_794);
        }
    }

    // $FF: renamed from: a (m.v, i.o, boolean) void
    public void method_912(class_86 var1, class_268 var2, boolean var3) {
        int var4 = var2.field_1208;
        if (var3) {
            var2.method_2179(this.field_672, this.field_674);
        }
        var2.method_2360(var4, this.field_444);
    }

    // $FF: renamed from: b (m.v) m.s
    public class_40 method_1082(class_86 var1) {
        return class_40.field_184;
    }

    // $FF: renamed from: a (c.j, m.v) void
    public void method_763(class_264 var1, class_86 var2) {
        var1.method_2023(this, var2);
        var1.method_1938(this, var2);
    }

    // $FF: renamed from: <clinit> () void
    static {
        field_795 = Float.intBitsToFloat(1);
    }
}
