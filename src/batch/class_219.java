package batch;

import batch.class_4;
import f.class_2;
import k.class_343;
import k.class_345;

// $FF: renamed from: batch.l
public abstract class class_219 implements class_4, class_2 {

    // $FF: renamed from: a java.lang.String
    String field_937;
    // $FF: renamed from: a char[]
    char[] field_938;
    // $FF: renamed from: a k.a
    public class_343 field_939;
    // $FF: renamed from: b java.lang.String
    public String field_940;

    // $FF: renamed from: <init> (k.a, java.lang.String) void
    protected class_219(class_343 var1, String var2) {
        this.field_939 = var1;
        this.field_940 = var2;
    }

    // $FF: renamed from: a (java.lang.String) k.c
    protected class_345 method_1279(String var1) {
        if (this.field_939 == null) {
            return null;
        } else {
            char[] var2 = var1.substring(0, var1.length() - field_1.length).toCharArray();
            return this.field_939.method_3324(var2);
        }
    }
}
