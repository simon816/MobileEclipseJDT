package m;

import m.class_34;
import m.class_40;
import m.class_43;
import m.class_58;

// $FF: renamed from: m.aw
public class class_61 extends class_58 {

    // $FF: renamed from: a int
    private int field_290;
    // $FF: renamed from: a m.ae
    public class_58 field_291;

    // $FF: renamed from: <init> (char[], m.s[], int) void
    public class_61(char[] var1, class_40[] var2, int var3) {
        this.field_274 = var1;
        this.field_276 = var2 != null && var2.length != 0 ? var2 : class_34.field_150;
        this.field_290 = var3;
        this.field_277 = class_34.field_151;
    }

    // $FF: renamed from: <init> (char[], m.s[], m.as, int) void
    public class_61(char[] var1, class_40[] var2, class_43 var3, int var4) {
        this.field_274 = var1;
        this.field_276 = var2 != null && var2.length != 0 ? var2 : class_34.field_150;
        this.field_278 = var3;
        this.field_290 = var4;
        this.field_277 = class_34.field_151;
    }

    // $FF: renamed from: <init> (m.ae, char[], m.s[], int) void
    public class_61(class_58 var1, char[] var2, class_40[] var3, int var4) {
        this(var2, var3, var4);
        this.field_291 = var1;
        if (var1 != null && var4 != 3) {
            this.field_278 = var1.field_278;
        }
    }

    // $FF: renamed from: c () int
    public final int method_102() {
        return this.field_290;
    }
}
