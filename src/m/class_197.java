package m;

import b.class_233;

// $FF: renamed from: m.ba
public class class_197 {

    // $FF: renamed from: a char[]
    public char[] field_872;
    // $FF: renamed from: a int
    public int field_873;
    // $FF: renamed from: b int
    public int field_874;
    // $FF: renamed from: c int
    public int field_875;

    // $FF: renamed from: <init> (char[]) void
    public class_197(char[] var1) {
        this.field_872 = var1;
        this.field_873 = 0;
        this.field_874 = this.field_875 = -1;
    }

    // $FF: renamed from: a () boolean
    public boolean method_1161() {
        return this.field_873 < 0 || this.field_873 >= this.field_872.length;
    }

    // $FF: renamed from: a () int
    public int method_1162() {
        int var1;
        for (var1 = this.field_873; this.field_872[var1] == 91; ++var1) {
            ;
        }
        switch (this.field_872[var1]) {
            case 76:
            case 84:
                this.field_874 = class_233.method_1374(';', this.field_872, this.field_873);
                if (this.field_875 <= this.field_873) {
                    this.field_875 = class_233.method_1374('<', this.field_872, this.field_873);
                }
                if (this.field_875 > this.field_873 && this.field_875 < this.field_874) {
                    this.field_874 = this.field_875;
                } else if (this.field_874 == -1) {
                    this.field_874 = this.field_872.length + 1;
                }
                break;
            default:
                this.field_874 = this.field_873;
        }
        this.field_873 = this.field_874 + 1;
        return this.field_874;
    }

    // $FF: renamed from: a () char[]
    public char[] method_1163() {
        this.field_874 = class_233.method_1374(';', this.field_872, this.field_873);
        if (this.field_875 <= this.field_873) {
            this.field_875 = class_233.method_1374('<', this.field_872, this.field_873);
        }
        int var1 = class_233.method_1374('.', this.field_872, this.field_873);
        if (this.field_875 > this.field_873 && this.field_875 < this.field_874) {
            this.field_874 = this.field_875;
        }
        if (var1 > this.field_873 && var1 < this.field_874) {
            this.field_874 = var1;
        }
        return class_233.method_1388(this.field_872, this.field_873, this.field_873 = this.field_874);
    }

    public String toString() {
        return new String(this.field_872) + " @ " + this.field_873;
    }
}
