package g;

import g.class_16;
import g.class_313;
import g.class_314;

// $FF: renamed from: g.r
class class_315 implements class_16 {

    // $FF: renamed from: a int
    int field_1813;
    // $FF: renamed from: b int
    int field_1814;
    // $FF: renamed from: a g.p
    private final class_313 field_1815;

    // $FF: renamed from: <init> (g.p) void
    private class_315(class_313 var1) {
        this.field_1815 = var1;
        this.field_1813 = 0;
        this.field_1814 = -1;
    }

    // $FF: renamed from: a () boolean
    public boolean method_47() {
        return this.field_1813 != this.field_1815.method_29();
    }

    // $FF: renamed from: a () java.lang.Object
    public Object method_48() {
        Object var1 = this.field_1815.method_36(this.field_1813);
        this.field_1814 = this.field_1813++;
        return var1;
    }

    // $FF: renamed from: <init> (g.p, g.q) void
    class_315(class_313 var1, class_314 var2) {
        this(var1);
    }
}
