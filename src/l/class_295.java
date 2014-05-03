package l;

import h.class_89;
import i.class_74;
import l.class_293;
import l.class_301;
import l.class_303;

// $FF: renamed from: l.e
public class class_295 extends class_293 {

    // $FF: renamed from: b i.s
    public class_74 field_1745;
    // $FF: renamed from: b l.f
    public class_303 field_1746;

    // $FF: renamed from: <init> (l.j, h.cj, i.s) void
    public class_295(class_293 var1, class_89 var2, class_74 var3) {
        super(var1, var2);
        this.field_1746 = class_301.field_1784;
        this.field_1745 = var3;
    }

    // $FF: renamed from: b () i.s
    public class_74 method_3031() {
        return this.field_1745;
    }

    // $FF: renamed from: a () java.lang.String
    public String method_3039() {
        StringBuffer var1 = new StringBuffer("Switch flow context");
        var1.append("[initsOnBreak -").append(this.field_1746.toString()).append(']');
        return var1.toString();
    }

    // $FF: renamed from: c () boolean
    public boolean method_3040() {
        return true;
    }

    // $FF: renamed from: a (l.g) void
    public void method_3044(class_301 var1) {
        if ((this.field_1746.field_1783 & 1) == 0) {
            this.field_1746 = this.field_1746.method_3105(var1.method_3109());
        } else {
            this.field_1746 = var1.method_3107();
        }
    }
}
