package i;

import m.class_40;

// $FF: renamed from: i.b
public class class_78 {

    // $FF: renamed from: a int
    public int field_340;
    // $FF: renamed from: b int
    public int field_341;
    // $FF: renamed from: a m.s
    public class_40 field_342;

    // $FF: renamed from: <init> (int, int, m.s) void
    public class_78(int var1, int var2, class_40 var3) {
        this.field_340 = var1;
        this.field_342 = var3;
        this.field_341 = var2;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
        var1.append('(').append(this.field_340).append(',').append(this.field_341);
        if (this.field_342 != null) {
            var1.append(',').append(this.field_342.method_176()).append(this.field_342.method_177());
        }
        var1.append(')');
        return String.valueOf(var1);
    }
}
