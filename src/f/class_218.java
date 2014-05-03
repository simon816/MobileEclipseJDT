package f;

import b.class_233;

// $FF: renamed from: f.p
public final class class_218 {

    // $FF: renamed from: a int
    static int field_933;
    // $FF: renamed from: b int
    public int field_934;
    // $FF: renamed from: c int
    int field_935;
    // $FF: renamed from: a char[][]
    char[][] field_936;

    // $FF: renamed from: <init> () void
    public class_218() {
        this.field_935 = field_933;
        this.field_934 = 0;
        this.field_936 = new char[this.field_935][];
    }

    // $FF: renamed from: a (char[]) void
    public void method_1274(char[] var1) {
        if (this.field_934 == this.field_935) {
            System.arraycopy(this.field_936, 0, this.field_936 = new char[this.field_935 *= 2][], 0, this.field_934);
        }
        this.field_936[this.field_934++] = var1;
    }

    // $FF: renamed from: a (char[]) boolean
    public boolean method_1275(char[] var1) {
        int var2 = this.field_934;
        do {
            --var2;
            if (var2 < 0) {
                return false;
            }
        } while (!class_233.method_1364(var1, this.field_936[var2]));
        return true;
    }

    // $FF: renamed from: a (int) char[]
    public char[] method_1276(int var1) {
        return this.field_936[var1];
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        for (int var2 = 0; var2 < this.field_934; ++var2) {
            var1.append(this.field_936[var2]).append("\n");
        }
        return var1.toString();
    }

    // $FF: renamed from: <clinit> () void
    static {
        field_933 = 10;
    }
}
