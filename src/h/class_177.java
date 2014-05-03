package h;

import h.class_169;

// $FF: renamed from: h.ao
public abstract class class_177 extends class_169 {

    // $FF: renamed from: b char[]
    char[] field_792;

    // $FF: renamed from: <init> (char[], int, int) void
    public class_177(char[] var1, int var2, int var3) {
        this(var2, var3);
        this.field_792 = var1;
    }

    // $FF: renamed from: <init> (int, int) void
    public class_177(int var1, int var2) {
        super(var1, var2);
    }

    // $FF: renamed from: a () char[]
    public char[] method_1083() {
        return this.field_792;
    }
}
