package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.class_264;
import org.eclipse.jdt.internal.compiler.ast.class_173;
import org.eclipse.jdt.internal.compiler.codegen.class_268;
import org.eclipse.jdt.internal.compiler.codegen.BranchLabel;
import org.eclipse.jdt.internal.compiler.impl.class_340;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.class_86;

public class class_174 extends class_173 {

    static final char[] field_789;

    public class_174(int var1, int var2) {
        super(var1, var2);
    }

    public void method_1081() {
        this.field_672 = class_340.method_3307(false);
    }

    public void method_912(class_86 var1, class_268 var2, boolean var3) {
        int var4 = var2.field_1208;
        if (var3) {
            var2.method_2179(this.field_672, this.field_674);
        }
        var2.method_2360(var4, this.field_444);
    }

    public void method_913(class_86 var1, class_268 var2, BranchLabel var3, BranchLabel var4, boolean var5) {
        int var6 = var2.field_1208;
        if (var5 && var4 != null && var3 == null) {
            var2.method_2209(var4);
        }
        var2.method_2360(var6, this.field_444);
    }

    public class_40 method_1082(class_86 var1) {
        return class_40.field_186;
    }

    public char[] method_1083() {
        return field_789;
    }

    public void method_763(class_264 var1, class_86 var2) {
        var1.method_2020(this, var2);
        var1.method_1935(this, var2);
    }

    static {
        field_789 = new char[] {'f', 'a', 'l', 's', 'e'};
    }
}
