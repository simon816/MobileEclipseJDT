package g;

import g.class_12;
import g.class_14;
import g.class_313;
import java.util.Enumeration;
import java.util.Hashtable;

public class class_312 implements class_14 {

    Hashtable field_1811;

    public class_312(int var1) {
        this.field_1811 = new Hashtable(var1);
    }

    public class_312() {
        this.field_1811 = new Hashtable();
    }

    public int method_37() {
        return this.field_1811.size();
    }

    public Object method_38(Object var1) {
        return this.field_1811.get(var1);
    }

    public Object method_39(Object var1, Object var2) {
        return this.field_1811.put(var1, var2);
    }

    public Object method_40(Object var1) {
        return this.field_1811.remove(var1);
    }

    public void method_41() {
        this.field_1811.clear();
    }

    public class_12 method_42() {
        Enumeration var1 = this.field_1811.keys();
        class_313 var10000 = new class_313(this.field_1811.size());
        class_313 var2 = var10000;
        while (var1.hasMoreElements()) {
            var2.method_34(var1.nextElement());
        }
        return var2;
    }

    public class_12 method_43() {
        Enumeration var1 = this.field_1811.elements();
        class_313 var10000 = new class_313(this.field_1811.size());
        class_313 var2 = var10000;
        while (var1.hasMoreElements()) {
            var2.method_34(var1.nextElement());
        }
        return var2;
    }

    public class_12 method_44() {
        throw new RuntimeException("HashMap entrySet Not supported yet.");
    }
}
