package m;

import b.class_233;
import h.class_91;
import m.class_34;

// $FF: renamed from: m.i
public class class_35 extends class_34 {

    // $FF: renamed from: a char[][]
    public char[][] field_162;
    // $FF: renamed from: a boolean
    public boolean field_163;
    // $FF: renamed from: a h.z
    public class_91 field_164;
    // $FF: renamed from: a m.w
    public class_34 field_165;

    // $FF: renamed from: <init> (char[][], boolean, m.w, h.z) void
    public class_35(char[][] var1, boolean var2, class_34 var3, class_91 var4) {
        this.field_162 = var1;
        this.field_163 = var2;
        this.field_165 = var3;
        this.field_164 = var4;
    }

    // $FF: renamed from: a () int
    public final int method_98() {
        return 32;
    }

    // $FF: renamed from: a () boolean
    public boolean method_106() {
        return this.field_164 != null && this.field_164.method_781();
    }

    // $FF: renamed from: a () char[]
    public char[] method_103() {
        return this.field_163 ? class_233.method_1355(class_233.method_1361(this.field_162, '.'), ".*".toCharArray()) : class_233.method_1361(this.field_162, '.');
    }

    public String toString() {
        return "import : " + new String(this.method_103());
    }
}
