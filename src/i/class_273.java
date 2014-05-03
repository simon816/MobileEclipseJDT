package i;

import b.class_233;
import g.class_11;

// $FF: renamed from: i.j
public class class_273 implements class_11 {

    // $FF: renamed from: a char[]
    public char[] field_1513;
    // $FF: renamed from: a int
    public int field_1514;

    // $FF: renamed from: <init> (int, char[]) void
    public class_273(int var1, char[] var2) {
        this.field_1514 = var1;
        this.field_1513 = var2;
    }

    // $FF: renamed from: a (java.lang.Object) int
    public int method_28(Object var1) {
        return var1 instanceof class_273 ? this.field_1514 - ((class_273)var1).field_1514 : 0;
    }

    public boolean equals(Object var1) {
        if (!(var1 instanceof class_273)) {
            return false;
        } else {
            class_273 var2 = (class_273)var1;
            return this.field_1514 == var2.field_1514 && class_233.method_1364(this.field_1513, var2.field_1513);
        }
    }

    public int hashCode() {
        return this.field_1514 + this.field_1513.hashCode();
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        var1.append('(').append(this.field_1514).append(',').append(this.field_1513).append(')');
        return String.valueOf(var1);
    }
}
