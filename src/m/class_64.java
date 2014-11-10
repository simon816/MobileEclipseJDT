package m;

import a.class_331;
import h.class_89;
import m.class_34;
import m.class_40;

public abstract class class_64 extends class_34 {

    public int field_300;

    public class_40 field_301;

    public char[] field_302;

    protected class_331 field_303;

    public int field_304;

    public long field_305;

    public class_64(char[] var1, class_40 var2, int var3, class_331 var4) {
        this.field_302 = var1;
        this.field_301 = var2;
        this.field_300 = var3;
        this.field_303 = var4;
        if (var2 != null) {
            this.field_305 |= var2.field_178 & 128L;
        }
    }

    public class_331 method_407() {
        return this.field_303;
    }

    public final boolean method_408() {
        return (this.field_300 & 67108864) != 0;
    }

    public final boolean method_409() {
        return (this.field_300 & 16) != 0;
    }

    public char[] method_103() {
        return this.field_302;
    }

    public void method_410(class_331 var1) {
        this.field_303 = var1;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer(10);
        class_89.method_760(this.field_300, var1);
        if ((this.field_300 & 33554432) != 0) {
            var1.append("[unresolved] ");
        }
        var1.append(this.field_301 != null ? this.field_301.method_135() : "<no type>");
        var1.append(" ");
        var1.append(this.field_302 != null ? new String(this.field_302) : "<no name>");
        return var1.toString();
    }
}
