package k;

// $FF: renamed from: k.f
public class class_319 {

    // $FF: renamed from: a char[]
    char[] field_1821;
    // $FF: renamed from: b char[]
    char[] field_1822;

    // $FF: renamed from: <init> (char[], char[]) void
    public class_319(char[] var1, char[] var2) {
        this.field_1821 = var1;
        this.field_1822 = var2;
    }

    // $FF: renamed from: a () char[]
    public char[] method_3195() {
        return this.field_1821;
    }

    // $FF: renamed from: b () char[]
    public char[] method_3196() {
        return this.field_1822;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        var1.append(this.field_1821);
        var1.append('.');
        var1.append(this.field_1822);
        return var1.toString();
    }
}
