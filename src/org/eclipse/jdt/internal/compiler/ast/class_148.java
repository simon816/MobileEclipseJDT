package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.class_264;
import org.eclipse.jdt.internal.compiler.ast.class_146;
import org.eclipse.jdt.internal.compiler.ast.class_147;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.class_43;
import org.eclipse.jdt.internal.compiler.lookup.class_45;
import org.eclipse.jdt.internal.compiler.lookup.class_83;
import org.eclipse.jdt.internal.compiler.lookup.class_84;
import org.eclipse.jdt.internal.compiler.lookup.class_86;

public class class_148 extends class_147 {

    public class_146 field_727;

    public int field_728;

    public class_148(int var1) {
        super(field_51, 0L);
        this.field_728 = var1;
    }

    public char[][] method_1012() {
        switch (this.field_728) {
            case 0:
                return new char[][] {field_51};
            case 1:
                return new char[][] {CharOperation.method_1356(field_51, field_53, CharOperation.method_1361(this.field_727.method_1012(), '.'))};
            default:
                return new char[][] {CharOperation.method_1356(field_51, field_52, CharOperation.method_1361(this.field_727.method_1012(), '.'))};
        }
    }

    private class_40 method_1025(class_83 var1, class_43 var2, int var3) {
        class_40 var4 = null;
        if (this.field_727 != null) {
            var4 = var1.field_373 == 3 ? this.field_727.method_1018((class_84)var1) : this.field_727.method_1017((class_86)var1, true);
            if (var4 == null) {
                return null;
            }
        }
        class_45 var5 = var1.method_586().method_502(var2, var3, var4, (class_40[])null, this.field_728);
        return this.field_675 = var5;
    }

    public StringBuffer method_924(int var1, StringBuffer var2) {
        switch (this.field_728) {
            case 0:
                var2.append(field_51);
                break;
            case 1:
                var2.append(field_51).append(field_53);
                this.field_727.method_924(0, var2);
                break;
            default:
                var2.append(field_51).append(field_52);
                this.field_727.method_924(0, var2);
        }
        return var2;
    }

    public class_40 method_1017(class_86 var1, boolean var2) {
        if (this.field_727 != null) {
            this.field_727.method_1017(var1, var2);
        }
        return null;
    }

    public class_40 method_1018(class_84 var1) {
        if (this.field_727 != null) {
            this.field_727.method_1018(var1);
        }
        return null;
    }

    public class_40 method_1019(class_86 var1, class_43 var2, int var3) {
        return this.method_1025(var1, var2, var3);
    }

    public class_40 method_1020(class_84 var1, class_43 var2, int var3) {
        return this.method_1025(var1, var2, var3);
    }

    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2072(this, var2) && this.field_727 != null) {
            this.field_727.method_763(var1, var2);
        }
        var1.method_1987(this, var2);
    }

    public void method_1021(class_264 var1, class_84 var2) {
        if (var1.method_2073(this, var2) && this.field_727 != null) {
            this.field_727.method_1021(var1, var2);
        }
        var1.method_1988(this, var2);
    }
}
