package g;

import g.class_16;
import g.class_313;
import g.class_314;

class class_315 implements class_16 {

    int field_1813;

    int field_1814;

    private final class_313 field_1815;

    private class_315(class_313 var1) {
        this.field_1815 = var1;
        this.field_1813 = 0;
        this.field_1814 = -1;
    }

    public boolean method_47() {
        return this.field_1813 != this.field_1815.method_29();
    }

    public Object method_48() {
        Object var1 = this.field_1815.method_36(this.field_1813);
        this.field_1814 = this.field_1813++;
        return var1;
    }

    class_315(class_313 var1, class_314 var2) {
        this(var1);
    }
}
