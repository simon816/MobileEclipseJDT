package g;

import g.class_13;
import g.class_16;
import g.class_314;
import g.class_315;
import java.util.Vector;

public class class_313 implements class_13 {

    Vector field_1812;

    public class_313(int var1) {
        this.field_1812 = new Vector(var1);
    }

    public class_313() {
        this.field_1812 = new Vector();
    }

    public Object method_36(int var1) {
        return this.field_1812.elementAt(var1);
    }

    public Object method_3163(int var1) {
        Object var2 = this.field_1812.elementAt(var1);
        this.field_1812.removeElementAt(var1);
        return var2;
    }

    public int method_3164(Object var1) {
        return this.field_1812.indexOf(var1);
    }

    public int method_29() {
        return this.field_1812.size();
    }

    public boolean method_30(Object var1) {
        return this.field_1812.contains(var1);
    }

    public class_16 method_31() {
        class_315 var10000 = new class_315(this, (class_314)null);
        return var10000;
    }

    public Object[] method_32() {
        Object[] var1 = new Object[this.field_1812.size()];
        return this.method_33(var1);
    }

    public Object[] method_33(Object[] var1) {
        this.field_1812.copyInto(var1);
        return var1;
    }

    public boolean method_34(Object var1) {
        this.field_1812.addElement(var1);
        return true;
    }

    public void method_35() {
        this.field_1812.removeAllElements();
    }
}
