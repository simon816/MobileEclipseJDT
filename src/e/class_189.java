package e;

import e.class_186;
import k.class_23;

// $FF: renamed from: e.h
public class class_189 extends class_186 implements class_23 {

    // $FF: renamed from: a int
    int field_818;
    // $FF: renamed from: c int
    int field_819;
    // $FF: renamed from: d int
    int field_820;
    // $FF: renamed from: a char[]
    private char[] field_821;
    // $FF: renamed from: b char[]
    private char[] field_822;
    // $FF: renamed from: c char[]
    private char[] field_823;
    // $FF: renamed from: e int
    private int field_824;
    // $FF: renamed from: a boolean
    private boolean field_825;
    // $FF: renamed from: b boolean
    private boolean field_826;
    // $FF: renamed from: c boolean
    private boolean field_827;

    // $FF: renamed from: <init> (byte[], int[], int) void
    public class_189(byte[] var1, int[] var2, int var3) {
        super(var1, var2, var3);
        this.field_818 = -1;
        this.field_819 = -1;
        this.field_820 = -1;
        this.field_824 = -1;
        this.field_825 = false;
        this.field_826 = false;
        this.field_827 = false;
        this.field_818 = this.method_1104(0);
        this.field_819 = this.method_1104(2);
        this.field_820 = this.method_1104(4);
    }

    // $FF: renamed from: a () char[]
    public char[] method_1116() {
        if (!this.field_826) {
            this.field_826 = true;
            if (this.field_819 != 0) {
                int var1 = this.field_806[this.method_1104(this.field_806[this.field_819] - this.field_807 + 1)] - this.field_807;
                this.field_822 = this.method_1106(var1 + 3, this.method_1104(var1 + 1));
            }
        }
        return this.field_822;
    }

    // $FF: renamed from: a () int
    public int method_1117() {
        if (this.field_824 == -1) {
            this.field_824 = this.method_1104(6);
        }
        return this.field_824;
    }

    // $FF: renamed from: b () char[]
    public char[] method_68() {
        if (!this.field_825) {
            this.field_825 = true;
            if (this.field_818 != 0) {
                int var1 = this.field_806[this.field_818] - this.field_807;
                int var2 = this.field_806[this.method_1104(var1 + 1)] - this.field_807;
                this.field_821 = this.method_1106(var2 + 3, this.method_1104(var2 + 1));
            }
        }
        return this.field_821;
    }

    // $FF: renamed from: c () char[]
    public char[] method_1118() {
        if (!this.field_827) {
            this.field_827 = true;
            if (this.field_820 != 0) {
                int var1 = this.field_806[this.field_820] - this.field_807;
                this.field_823 = this.method_1106(var1 + 3, this.method_1104(var1 + 1));
            }
        }
        return this.field_823;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        if (this.method_68() != null) {
            var1.append(this.method_68());
        }
        var1.append("\n");
        if (this.method_1116() != null) {
            var1.append(this.method_1116());
        }
        var1.append("\n");
        if (this.method_1118() != null) {
            var1.append(this.method_1118());
        }
        return var1.toString();
    }

    // $FF: renamed from: a () void
    void method_1119() {
        this.method_1117();
        this.method_68();
        this.method_1118();
        this.method_1116();
        this.method_1102();
    }
}
