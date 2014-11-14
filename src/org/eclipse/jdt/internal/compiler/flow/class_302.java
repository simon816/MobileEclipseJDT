package org.eclipse.jdt.internal.compiler.flow;

import org.eclipse.jdt.internal.compiler.flow.class_301;
import org.eclipse.jdt.internal.compiler.flow.class_303;
import org.eclipse.jdt.internal.compiler.lookup.class_65;
import org.eclipse.jdt.internal.compiler.lookup.class_67;

public class class_302 extends class_301 {

    public class_301 field_1785;

    public class_301 field_1786;

    class_302(class_301 var1, class_301 var2) {
        this.field_1785 = var1;
        this.field_1786 = var2;
    }

    public class_301 method_3071(class_301 var1) {
        this.field_1785.method_3071(var1);
        this.field_1786.method_3071(var1);
        return this;
    }

    public class_301 method_3072(class_301 var1) {
        this.field_1785.method_3072(var1);
        this.field_1786.method_3072(var1);
        return this;
    }

    public class_301 method_3073() {
        class_301 var1 = this.field_1785;
        this.field_1785 = this.field_1786;
        this.field_1786 = var1;
        return this;
    }

    public class_301 method_3078() {
        class_302 var10000 = new class_302(this.field_1785.method_3078(), this.field_1786.method_3078());
        return var10000;
    }

    public class_301 method_3080() {
        return this.field_1786;
    }

    public class_301 method_3081() {
        return this.field_1785;
    }

    public boolean method_3082(class_67 var1) {
        return this.field_1785.method_3082(var1) && this.field_1786.method_3082(var1);
    }

    public boolean method_3083(class_65 var1) {
        return this.field_1785.method_3083(var1) && this.field_1786.method_3083(var1);
    }

    public boolean method_3084(class_65 var1) {
        return this.field_1785.method_3084(var1) && this.field_1786.method_3084(var1);
    }

    public boolean method_3085(class_65 var1) {
        return this.field_1785.method_3085(var1) && this.field_1786.method_3085(var1);
    }

    public boolean method_3086(class_65 var1) {
        return this.field_1785.method_3086(var1) && this.field_1786.method_3086(var1);
    }

    public boolean method_3087(class_67 var1) {
        return this.field_1785.method_3087(var1) || this.field_1786.method_3087(var1);
    }

    public boolean method_3088(class_65 var1) {
        return this.field_1785.method_3088(var1) || this.field_1786.method_3088(var1);
    }

    public boolean method_3089(class_65 var1) {
        return this.field_1785.method_3089(var1) || this.field_1786.method_3089(var1);
    }

    public boolean method_3090(class_65 var1) {
        return this.field_1785.method_3090(var1) || this.field_1786.method_3090(var1);
    }

    public boolean method_3091(class_65 var1) {
        return this.field_1785.method_3091(var1) || this.field_1786.method_3091(var1);
    }

    public boolean method_3092(class_65 var1) {
        return this.field_1785.method_3092(var1) && this.field_1786.method_3092(var1);
    }

    public boolean method_3093(class_65 var1) {
        return this.field_1785.method_3093(var1) && this.field_1786.method_3093(var1);
    }

    public void method_3094(class_65 var1) {
        this.field_1785.method_3094(var1);
        this.field_1786.method_3094(var1);
    }

    public void method_3095(class_65 var1) {
        this.field_1785.method_3095(var1);
        this.field_1786.method_3095(var1);
    }

    public void method_3096(class_67 var1) {
        this.field_1785.method_3096(var1);
        this.field_1786.method_3096(var1);
    }

    public void method_3099(class_65 var1) {
        this.field_1785.method_3099(var1);
        this.field_1786.method_3099(var1);
    }

    public void method_3097(class_65 var1) {
        this.field_1785.method_3097(var1);
        this.field_1786.method_3097(var1);
    }

    public void method_3098(class_65 var1) {
        this.field_1785.method_3098(var1);
        this.field_1786.method_3098(var1);
    }

    public void method_3100(class_65 var1) {
        this.field_1785.method_3100(var1);
        this.field_1786.method_3100(var1);
    }

    public class_301 method_3104(int var1) {
        if (var1 == 0) {
            this.field_1783 &= -2;
        } else {
            this.field_1783 |= 1;
        }
        this.field_1785.method_3104(var1);
        this.field_1786.method_3104(var1);
        return this;
    }

    public class_303 method_3105(class_303 var1) {
        return this.method_3109().method_3105(var1);
    }

    public class_303 method_3106() {
        return this.method_3110().method_3106();
    }

    public String toString() {
        return "FlowInfo<true: " + this.field_1785.toString() + ", false: " + this.field_1786.toString() + ">";
    }

    public class_301 method_3103() {
        return this.field_1785;
    }

    public class_303 method_3107() {
        return this.field_1785.method_3107().method_3105(this.field_1786.method_3109());
    }

    public class_303 method_3108() {
        return this.field_1785.method_3108().method_3105(this.field_1786.method_3108());
    }

    public class_303 method_3109() {
        return this.field_1785.method_3109().method_3105(this.field_1786.method_3109());
    }

    public class_303 method_3110() {
        return this.field_1785.method_3107().method_3105(this.field_1786.method_3109());
    }
}
