package f;

import b.CharOperation;

public final class class_218 {

    static int field_933;

    public int field_934;

    int field_935;

    char[][] field_936;

    public class_218() {
        this.field_935 = field_933;
        this.field_934 = 0;
        this.field_936 = new char[this.field_935][];
    }

    public void method_1274(char[] var1) {
        if (this.field_934 == this.field_935) {
            System.arraycopy(this.field_936, 0, this.field_936 = new char[this.field_935 *= 2][], 0, this.field_934);
        }
        this.field_936[this.field_934++] = var1;
    }

    public boolean method_1275(char[] var1) {
        int var2 = this.field_934;
        do {
            --var2;
            if (var2 < 0) {
                return false;
            }
        } while (!CharOperation.method_1364(var1, this.field_936[var2]));
        return true;
    }

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

    static {
        field_933 = 10;
    }
}
