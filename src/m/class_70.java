package m;

import a.class_331;
import m.class_40;
import m.class_52;
import m.class_67;
import m.class_83;

// $FF: renamed from: m.ao
public class class_70 extends class_67 {

    // $FF: renamed from: a m.k
    public class_67 field_318;

    // $FF: renamed from: <init> (m.al, m.k) void
    public class_70(class_52 var1, class_67 var2) {
        super(var2.field_302, (class_40)((var2.field_300 & 16384) != 0 ? var1 : ((var2.field_300 & 8) != 0 ? var2.field_301 : class_83.method_571(var1, var2.field_301))), var2.field_300, var1, (class_331)null);
        this.field_318 = var2;
        this.field_305 = var2.field_305;
        this.field_304 = var2.field_304;
    }

    // $FF: renamed from: a () a.k
    public class_331 method_407() {
        return this.field_318.method_407();
    }

    // $FF: renamed from: a () m.k
    public class_67 method_435() {
        return this.field_318.method_435();
    }

    // $FF: renamed from: a (a.k) void
    public void method_410(class_331 var1) {
        this.field_318.method_410(var1);
    }
}