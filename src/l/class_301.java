package l;

import l.class_302;
import l.class_303;
import m.class_65;
import m.class_67;

public abstract class class_301 {

    public int field_1783;

    public static final class_303 field_1784;

    public class_301() {
    }

    public abstract class_301 method_3071(class_301 var1);

    public abstract class_301 method_3072(class_301 var1);

    public class_301 method_3073() {
        return this;
    }

    public static class_301 method_3074(class_301 var0, class_301 var1) {
        class_302 var10000 = new class_302(var0, var1);
        return var10000;
    }

    public boolean method_3075(class_65 var1) {
        return this.method_3091(var1) || this.method_3089(var1) && this.method_3090(var1);
    }

    public boolean method_3076(class_65 var1) {
        return this.method_3084(var1) || this.method_3092(var1);
    }

    public boolean method_3077(class_65 var1) {
        return this.method_3085(var1) || this.method_3093(var1);
    }

    public abstract class_301 method_3078();

    public static class_303 method_3079(int var0) {
        class_303 var10000 = new class_303();
        class_303 var1 = var10000;
        var1.field_1794 = var0;
        return var1;
    }

    public abstract class_301 method_3080();

    public abstract class_301 method_3081();

    public abstract boolean method_3082(class_67 var1);

    public abstract boolean method_3083(class_65 var1);

    public abstract boolean method_3084(class_65 var1);

    public abstract boolean method_3085(class_65 var1);

    public abstract boolean method_3086(class_65 var1);

    public abstract boolean method_3087(class_67 var1);

    public abstract boolean method_3088(class_65 var1);

    public abstract boolean method_3089(class_65 var1);

    public abstract boolean method_3090(class_65 var1);

    public abstract boolean method_3091(class_65 var1);

    public abstract boolean method_3092(class_65 var1);

    public abstract boolean method_3093(class_65 var1);

    public abstract void method_3094(class_65 var1);

    public abstract void method_3095(class_65 var1);

    public abstract void method_3096(class_67 var1);

    public abstract void method_3097(class_65 var1);

    public abstract void method_3098(class_65 var1);

    public abstract void method_3099(class_65 var1);

    public abstract void method_3100(class_65 var1);

    public static class_303 method_3101(class_301 var0, boolean var1, class_301 var2, boolean var3, boolean var4) {
        class_303 var5;
        if (var1) {
            if (var0 == field_1784 && var4) {
                var5 = var2.method_3104(1).method_3109();
            } else {
                var5 = var0.method_3072(var2.method_3106()).method_3109();
            }
        } else if (var3) {
            if (var2 == field_1784 && var4) {
                var5 = var0.method_3104(1).method_3109();
            } else {
                var5 = var2.method_3072(var0.method_3106()).method_3109();
            }
        } else {
            var5 = var0.method_3105(var2.method_3109());
        }
        return var5;
    }

    public int method_3102() {
        return this.field_1783 & 1;
    }

    public abstract class_301 method_3103();

    public abstract class_301 method_3104(int var1);

    public abstract class_303 method_3105(class_303 var1);

    public abstract class_303 method_3106();

    public String toString() {
        return this == field_1784 ? "FlowInfo.DEAD_END" : super.toString();
    }

    public abstract class_303 method_3107();

    public abstract class_303 method_3108();

    public abstract class_303 method_3109();

    public abstract class_303 method_3110();

    static {
        class_303 var10000 = new class_303();
        field_1784 = var10000;
        field_1784.field_1783 = 1;
    }
}
