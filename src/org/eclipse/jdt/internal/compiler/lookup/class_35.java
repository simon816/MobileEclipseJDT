package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ast.ImportReference;
import org.eclipse.jdt.internal.compiler.lookup.class_34;

public class class_35 extends class_34 {

    public char[][] field_162;

    public boolean field_163;

    public ImportReference field_164;

    public class_34 field_165;

    public class_35(char[][] var1, boolean var2, class_34 var3, ImportReference var4) {
        this.field_162 = var1;
        this.field_163 = var2;
        this.field_165 = var3;
        this.field_164 = var4;
    }

    public final int method_98() {
        return 32;
    }

    public boolean method_106() {
        return this.field_164 != null && this.field_164.method_781();
    }

    public char[] method_103() {
        return this.field_163 ? CharOperation.method_1355(CharOperation.method_1361(this.field_162, '.'), ".*".toCharArray()) : CharOperation.method_1361(this.field_162, '.');
    }

    public String toString() {
        return "import : " + new String(this.method_103());
    }
}
