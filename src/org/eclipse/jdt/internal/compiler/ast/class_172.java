package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.class_264;
import org.eclipse.jdt.internal.compiler.ast.class_126;
import org.eclipse.jdt.internal.compiler.ast.class_170;
import org.eclipse.jdt.internal.compiler.lookup.class_86;

public class class_172 extends class_170 {

    public class_126[] field_787;

    public int field_788;

    public class_172(class_170 var1, class_170 var2) {
        super(var1.field_444, var1.field_445);
        this.field_785 = var1.field_785;
        this.field_787 = new class_170[5];
        this.field_788 = 0;
        this.field_787[this.field_788++] = var1;
        this.method_1087(var2);
    }

    public class_172 method_1087(class_170 var1) {
        this.field_445 = var1.field_445;
        int var2 = this.field_787.length;
        if (this.field_788 == var2) {
            System.arraycopy(this.field_787, 0, this.field_787 = new class_170[var2 + 5], 0, var2);
        }
        int var3 = this.field_785.length;
        System.arraycopy(this.field_785, 0, this.field_785 = new char[var3 + var1.field_785.length], 0, var3);
        System.arraycopy(var1.field_785, 0, this.field_785, var3, var1.field_785.length);
        this.field_787[this.field_788++] = var1;
        return this;
    }

    public StringBuffer method_924(int var1, StringBuffer var2) {
        var2.append("StringLiteralConcatenation{");
        int var3 = 0;
        for (int var4 = this.field_788; var3 < var4; ++var3) {
            this.field_787[var3].method_924(var1, var2);
            var2.append("+\n");
        }
        return var2.append('}');
    }

    public char[] method_1083() {
        return this.field_785;
    }

    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2037(this, var2)) {
            int var3 = 0;
            for (int var4 = this.field_788; var3 < var4; ++var3) {
                this.field_787[var3].method_763(var1, var2);
            }
        }
        var1.method_1952(this, var2);
    }
}
