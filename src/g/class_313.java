package g;

import g.class_13;
import g.class_16;
import g.class_314;
import g.class_315;
import java.util.Vector;

// $FF: renamed from: g.p
public class class_313 implements class_13 {

    // $FF: renamed from: a java.util.Vector
    Vector field_1812;

    // $FF: renamed from: <init> (int) void
    public class_313(int var1) {
        this.field_1812 = new Vector(var1);
    }

    // $FF: renamed from: <init> () void
    public class_313() {
        this.field_1812 = new Vector();
    }

    // $FF: renamed from: a (int) java.lang.Object
    public Object method_36(int var1) {
        return this.field_1812.elementAt(var1);
    }

    // $FF: renamed from: b (int) java.lang.Object
    public Object method_3163(int var1) {
        Object var2 = this.field_1812.elementAt(var1);
        this.field_1812.removeElementAt(var1);
        return var2;
    }

    // $FF: renamed from: a (java.lang.Object) int
    public int method_3164(Object var1) {
        return this.field_1812.indexOf(var1);
    }

    // $FF: renamed from: a () int
    public int method_29() {
        return this.field_1812.size();
    }

    // $FF: renamed from: a (java.lang.Object) boolean
    public boolean method_30(Object var1) {
        return this.field_1812.contains(var1);
    }

    // $FF: renamed from: a () g.k
    public class_16 method_31() {
        class_315 var10000 = new class_315(this, (class_314)null);
        return var10000;
    }

    // $FF: renamed from: a () java.lang.Object[]
    public Object[] method_32() {
        Object[] var1 = new Object[this.field_1812.size()];
        return this.method_33(var1);
    }

    // $FF: renamed from: a (java.lang.Object[]) java.lang.Object[]
    public Object[] method_33(Object[] var1) {
        this.field_1812.copyInto(var1);
        return var1;
    }

    // $FF: renamed from: b (java.lang.Object) boolean
    public boolean method_34(Object var1) {
        this.field_1812.addElement(var1);
        return true;
    }

    // $FF: renamed from: a () void
    public void method_35() {
        this.field_1812.removeAllElements();
    }
}
