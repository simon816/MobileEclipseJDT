package m;

import m.class_38;

// $FF: renamed from: m.av
public class class_39 extends class_38 {

    // $FF: renamed from: a int
    private int field_176;

    // $FF: renamed from: <init> (char[][], int) void
    class_39(char[][] var1, int var2) {
        this.field_171 = var1;
        this.field_176 = var2;
    }

    // $FF: renamed from: <init> (char[], int) void
    class_39(char[] var1, int var2) {
        this(new char[][] {var1}, var2);
    }

    // $FF: renamed from: c () int
    public final int method_102() {
        return this.field_176;
    }
}
