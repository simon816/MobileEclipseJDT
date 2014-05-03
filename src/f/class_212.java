package f;

import b.class_233;

// $FF: renamed from: f.j
public final class class_212 {

    // $FF: renamed from: a int
    static int field_905;
    // $FF: renamed from: b int
    public int field_906;
    // $FF: renamed from: c int
    int field_907;
    // $FF: renamed from: a char[][][]
    char[][][] field_908;

    // $FF: renamed from: <init> () void
    public class_212() {
        this.field_907 = field_905;
        this.field_906 = 0;
        this.field_908 = new char[this.field_907][][];
    }

    // $FF: renamed from: a (char[][]) void
    public void method_1198(char[][] var1) {
        if (this.field_906 == this.field_907) {
            System.arraycopy(this.field_908, 0, this.field_908 = new char[this.field_907 *= 2][][], 0, this.field_906);
        }
        this.field_908[this.field_906++] = var1;
    }

    // $FF: renamed from: a (char[][]) boolean
    public boolean method_1199(char[][] var1) {
        int var2 = this.field_906;
        do {
            --var2;
            if (var2 < 0) {
                return false;
            }
        } while (!class_233.method_1363(var1, this.field_908[var2]));
        return true;
    }

    // $FF: renamed from: a (int) char[][]
    public char[][] method_1200(int var1) {
        return this.field_908[var1];
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        for (int var2 = 0; var2 < this.field_906; ++var2) {
            var1.append(class_233.method_1389(this.field_908[var2])).append("\n");
        }
        return var1.toString();
    }

    // $FF: renamed from: <clinit> () void
    static {
        field_905 = 10;
    }
}
