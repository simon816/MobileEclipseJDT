package e;

import e.class_187;
import e.class_196;
import k.class_29;

// $FF: renamed from: e.k
public final class class_188 extends class_187 {

    // $FF: renamed from: a e.b[]
    private class_196[] field_817;

    // $FF: renamed from: <init> (e.j, e.b[]) void
    class_188(class_187 var1, class_196[] var2) {
        super(var1.field_805, var1.field_806, var1.field_807);
        this.field_808 = var1.field_808;
        this.field_809 = var1.field_809;
        this.field_810 = var1.field_810;
        this.field_806 = var1.field_806;
        this.field_811 = var1.field_811;
        this.field_812 = var1.field_812;
        this.field_813 = var1.field_813;
        this.field_814 = var1.field_814;
        this.field_815 = var1.field_815;
        this.field_816 = var1.field_816;
        this.field_817 = var2;
    }

    // $FF: renamed from: a () k.e[]
    public class_29[] method_71() {
        return this.field_817;
    }

    // $FF: renamed from: a () void
    protected void method_1109() {
        int var1 = 0;
        for (int var2 = this.field_817.length; var1 < var2; ++var1) {
            this.field_817[var1].method_1154();
        }
        super.method_1109();
    }

    // $FF: renamed from: b () void
    protected void method_1102() {
        if (this.field_817 != null) {
            int var1 = 0;
            for (int var2 = this.field_817.length; var1 < var2; ++var1) {
                this.field_817[var1].method_1102();
            }
        }
        super.method_1102();
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer(this.getClass().getName());
        if (this.field_817 != null) {
            var1.append('\n');
            for (int var2 = 0; var2 < this.field_817.length; ++var2) {
                var1.append(this.field_817[var2]);
                var1.append('\n');
            }
        }
        this.method_1114(var1);
        return var1.toString();
    }
}
