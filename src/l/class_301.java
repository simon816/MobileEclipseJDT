package l;

import l.class_302;
import l.class_303;
import m.class_65;
import m.class_67;

// $FF: renamed from: l.g
public abstract class class_301 {

    // $FF: renamed from: b int
    public int field_1783;
    // $FF: renamed from: a l.f
    public static final class_303 field_1784;

    // $FF: renamed from: <init> () void
    public class_301() {
    }

    // $FF: renamed from: a (l.g) l.g
    public abstract class_301 method_3071(class_301 var1);

    // $FF: renamed from: b (l.g) l.g
    public abstract class_301 method_3072(class_301 var1);

    // $FF: renamed from: e () l.g
    public class_301 method_3073() {
        return this;
    }

    // $FF: renamed from: a (l.g, l.g) l.g
    public static class_301 method_3074(class_301 var0, class_301 var1) {
        class_302 var10000 = new class_302(var0, var1);
        return var10000;
    }

    // $FF: renamed from: a (m.ab) boolean
    public boolean method_3075(class_65 var1) {
        return this.method_3091(var1) || this.method_3089(var1) && this.method_3090(var1);
    }

    // $FF: renamed from: b (m.ab) boolean
    public boolean method_3076(class_65 var1) {
        return this.method_3084(var1) || this.method_3092(var1);
    }

    // $FF: renamed from: c (m.ab) boolean
    public boolean method_3077(class_65 var1) {
        return this.method_3085(var1) || this.method_3093(var1);
    }

    // $FF: renamed from: a () l.g
    public abstract class_301 method_3078();

    // $FF: renamed from: a (int) l.f
    public static class_303 method_3079(int var0) {
        class_303 var10000 = new class_303();
        class_303 var1 = var10000;
        var1.field_1794 = var0;
        return var1;
    }

    // $FF: renamed from: b () l.g
    public abstract class_301 method_3080();

    // $FF: renamed from: c () l.g
    public abstract class_301 method_3081();

    // $FF: renamed from: a (m.k) boolean
    public abstract boolean method_3082(class_67 var1);

    // $FF: renamed from: d (m.ab) boolean
    public abstract boolean method_3083(class_65 var1);

    // $FF: renamed from: e (m.ab) boolean
    public abstract boolean method_3084(class_65 var1);

    // $FF: renamed from: f (m.ab) boolean
    public abstract boolean method_3085(class_65 var1);

    // $FF: renamed from: g (m.ab) boolean
    public abstract boolean method_3086(class_65 var1);

    // $FF: renamed from: b (m.k) boolean
    public abstract boolean method_3087(class_67 var1);

    // $FF: renamed from: h (m.ab) boolean
    public abstract boolean method_3088(class_65 var1);

    // $FF: renamed from: i (m.ab) boolean
    public abstract boolean method_3089(class_65 var1);

    // $FF: renamed from: j (m.ab) boolean
    public abstract boolean method_3090(class_65 var1);

    // $FF: renamed from: k (m.ab) boolean
    public abstract boolean method_3091(class_65 var1);

    // $FF: renamed from: l (m.ab) boolean
    public abstract boolean method_3092(class_65 var1);

    // $FF: renamed from: m (m.ab) boolean
    public abstract boolean method_3093(class_65 var1);

    // $FF: renamed from: a (m.ab) void
    public abstract void method_3094(class_65 var1);

    // $FF: renamed from: e (m.ab) void
    public abstract void method_3095(class_65 var1);

    // $FF: renamed from: a (m.k) void
    public abstract void method_3096(class_67 var1);

    // $FF: renamed from: b (m.ab) void
    public abstract void method_3097(class_65 var1);

    // $FF: renamed from: c (m.ab) void
    public abstract void method_3098(class_65 var1);

    // $FF: renamed from: f (m.ab) void
    public abstract void method_3099(class_65 var1);

    // $FF: renamed from: d (m.ab) void
    public abstract void method_3100(class_65 var1);

    // $FF: renamed from: a (l.g, boolean, l.g, boolean, boolean) l.f
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

    // $FF: renamed from: a () int
    public int method_3102() {
        return this.field_1783 & 1;
    }

    // $FF: renamed from: d () l.g
    public abstract class_301 method_3103();

    // $FF: renamed from: a (int) l.g
    public abstract class_301 method_3104(int var1);

    // $FF: renamed from: b (l.f) l.f
    public abstract class_303 method_3105(class_303 var1);

    // $FF: renamed from: c () l.f
    public abstract class_303 method_3106();

    public String toString() {
        return this == field_1784 ? "FlowInfo.DEAD_END" : super.toString();
    }

    // $FF: renamed from: d () l.f
    public abstract class_303 method_3107();

    // $FF: renamed from: e () l.f
    public abstract class_303 method_3108();

    // $FF: renamed from: f () l.f
    public abstract class_303 method_3109();

    // $FF: renamed from: g () l.f
    public abstract class_303 method_3110();

    // $FF: renamed from: <clinit> () void
    static {
        class_303 var10000 = new class_303();
        field_1784 = var10000;
        field_1784.field_1783 = 1;
    }
}
