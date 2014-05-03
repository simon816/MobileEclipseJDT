package m;

import m.class_203;
import m.class_320;
import m.class_43;
import m.class_49;
import m.class_80;

// $FF: renamed from: m.l
public class class_204 extends class_203 {

    // $FF: renamed from: a m.af
    private class_80 field_888;
    // $FF: renamed from: a boolean
    private boolean field_889;

    // $FF: renamed from: <init> (m.as, m.c[], m.af) void
    class_204(class_43 var1, class_320[] var2, class_80 var3) {
        super(var1, var2);
        this.field_889 = true;
        this.field_888 = var3;
    }

    // $FF: renamed from: a () m.as
    public class_43 method_1182() {
        if (this.field_889) {
            this.field_886 = class_49.method_267(this.field_886, this.field_888, false);
            this.field_889 = false;
        }
        return this.field_886;
    }
}
