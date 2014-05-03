package m;

import m.class_200;
import m.class_203;
import m.class_34;

// $FF: renamed from: m.r
class class_201 extends class_200 {

    // $FF: renamed from: a m.bf[][]
    class_203[][] field_884;

    // $FF: renamed from: <init> (m.bf[], m.bf[][]) void
    class_201(class_203[] var1, class_203[][] var2) {
        this.method_1173(var1);
        this.field_884 = var2;
    }

    // $FF: renamed from: a () m.bf[][]
    public class_203[][] method_1172() {
        return this.field_884;
    }

    // $FF: renamed from: a (m.bf[]) m.bg
    class_200 method_1173(class_203[] var1) {
        this.field_883 = var1 != null && var1.length != 0 ? var1 : class_34.field_158;
        return this;
    }
}
