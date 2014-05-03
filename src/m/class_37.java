package m;

import b.class_233;
import m.class_34;
import m.class_43;

// $FF: renamed from: m.ay
public class class_37 extends class_34 {

    // $FF: renamed from: a char[]
    public char[] field_167;
    // $FF: renamed from: a m.as
    public class_43 field_168;
    // $FF: renamed from: a int
    private int field_169;

    // $FF: renamed from: <init> (char[][], int) void
    public class_37(char[][] var1, int var2) {
        this(class_233.method_1361(var1, '.'), var2);
    }

    // $FF: renamed from: <init> (char[][], m.as, int) void
    public class_37(char[][] var1, class_43 var2, int var3) {
        this(class_233.method_1361(var1, '.'), var2, var3);
    }

    // $FF: renamed from: <init> (char[], int) void
    class_37(char[] var1, int var2) {
        this.field_167 = var1;
        this.field_169 = var2;
    }

    // $FF: renamed from: <init> (char[], m.as, int) void
    class_37(char[] var1, class_43 var2, int var3) {
        this(var1, var3);
        this.field_168 = var2;
    }

    // $FF: renamed from: a () int
    public final int method_98() {
        return 7;
    }

    // $FF: renamed from: c () int
    public final int method_102() {
        return this.field_169;
    }

    // $FF: renamed from: a () char[]
    public char[] method_103() {
        return this.field_167;
    }
}
