package m;

import a.class_331;
import h.class_89;
import m.class_34;
import m.class_40;

// $FF: renamed from: m.q
public abstract class class_64 extends class_34 {

    // $FF: renamed from: b int
    public int field_300;
    // $FF: renamed from: a m.s
    public class_40 field_301;
    // $FF: renamed from: a char[]
    public char[] field_302;
    // $FF: renamed from: a a.k
    protected class_331 field_303;
    // $FF: renamed from: c int
    public int field_304;
    // $FF: renamed from: a long
    public long field_305;

    // $FF: renamed from: <init> (char[], m.s, int, a.k) void
    public class_64(char[] var1, class_40 var2, int var3, class_331 var4) {
        this.field_302 = var1;
        this.field_301 = var2;
        this.field_300 = var3;
        this.field_303 = var4;
        if (var2 != null) {
            this.field_305 |= var2.field_178 & 128L;
        }
    }

    // $FF: renamed from: a () a.k
    public class_331 method_407() {
        return this.field_303;
    }

    // $FF: renamed from: i () boolean
    public final boolean method_408() {
        return (this.field_300 & 67108864) != 0;
    }

    // $FF: renamed from: j () boolean
    public final boolean method_409() {
        return (this.field_300 & 16) != 0;
    }

    // $FF: renamed from: a () char[]
    public char[] method_103() {
        return this.field_302;
    }

    // $FF: renamed from: a (a.k) void
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
