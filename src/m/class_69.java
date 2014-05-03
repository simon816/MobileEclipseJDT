package m;

import m.class_43;
import m.class_67;

// $FF: renamed from: m.ax
public class class_69 extends class_67 {

    // $FF: renamed from: a int
    private int field_316;
    // $FF: renamed from: a m.k
    public class_67 field_317;

    // $FF: renamed from: <init> (m.as, char[], int) void
    public class_69(class_43 var1, char[] var2, int var3) {
        this((class_67)null, var1, var2, var3);
    }

    // $FF: renamed from: <init> (m.k, m.as, char[], int) void
    public class_69(class_67 var1, class_43 var2, char[] var3, int var4) {
        this.field_317 = var1;
        this.field_314 = var2;
        this.field_302 = var3;
        this.field_316 = var4;
    }

    // $FF: renamed from: c () int
    public final int method_102() {
        return this.field_316;
    }
}
