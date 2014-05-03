package m;

import m.class_32;
import m.class_40;
import m.class_46;
import m.class_52;
import m.class_62;
import m.class_80;

// $FF: renamed from: m.an
class class_88 implements class_32 {

    // $FF: renamed from: a m.al
    private final class_52 field_414;
    // $FF: renamed from: a boolean
    private final boolean field_415;
    // $FF: renamed from: a int
    private final int field_416;
    // $FF: renamed from: a m.x[]
    private final class_46[] field_417;
    // $FF: renamed from: b m.x[]
    private final class_46[] field_418;
    // $FF: renamed from: a m.am
    private final class_62 field_419;

    // $FF: renamed from: <init> (m.am, m.al, boolean, int, m.x[], m.x[]) void
    class_88(class_62 var1, class_52 var2, boolean var3, int var4, class_46[] var5, class_46[] var6) {
        this.field_419 = var1;
        this.field_414 = var2;
        this.field_415 = var3;
        this.field_416 = var4;
        this.field_417 = var5;
        this.field_418 = var6;
    }

    // $FF: renamed from: a () m.af
    public class_80 method_91() {
        return this.field_414.field_244;
    }

    // $FF: renamed from: a () boolean
    public boolean method_92() {
        return !this.field_415 && this.field_414.method_92();
    }

    // $FF: renamed from: a (m.x) m.s
    public class_40 method_90(class_46 var1) {
        return (class_40)(var1.field_221 < this.field_416 && this.field_417[var1.field_221] == var1 ? this.field_418[var1.field_221] : (!this.field_415 ? this.field_414.method_90(var1) : var1));
    }
}
