package f;

import b.class_233;

public final class class_212 {

    static int field_905;

    public int field_906;

    int field_907;

    char[][][] field_908;

    public class_212() {
        this.field_907 = field_905;
        this.field_906 = 0;
        this.field_908 = new char[this.field_907][][];
    }

    public void method_1198(char[][] var1) {
        if (this.field_906 == this.field_907) {
            System.arraycopy(this.field_908, 0, this.field_908 = new char[this.field_907 *= 2][][], 0, this.field_906);
        }
        this.field_908[this.field_906++] = var1;
    }

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

    static {
        field_905 = 10;
    }
}
