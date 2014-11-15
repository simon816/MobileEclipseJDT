package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ast.class_126;
import org.eclipse.jdt.internal.compiler.ast.class_146;
import org.eclipse.jdt.internal.compiler.ast.class_164;
import org.eclipse.jdt.internal.compiler.ast.class_98;
import org.eclipse.jdt.internal.compiler.flow.class_293;
import org.eclipse.jdt.internal.compiler.flow.class_301;
import org.eclipse.jdt.internal.compiler.lookup.InvocationSite;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.class_86;

public abstract class class_120 extends class_98 implements InvocationSite {

    public int field_651;

    public int field_652;

    public int field_653;

    public int field_654;

    public class_126 field_655;

    public int field_656;

    public int field_657;

    public class_164[] field_658;

    public char[] field_659;

    public class_146 field_660;

    public class_120() {
    }

    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        return var3;
    }

    public class_40[] method_0() {
        return null;
    }

    public abstract int method_887();

    public boolean method_1() {
        return false;
    }

    public StringBuffer method_820(int var1, StringBuffer var2) {
        this.method_888(var1, var2);
        switch (this.method_887()) {
            case 3:
                return var2.append(',');
            default:
                return var2.append(';');
        }
    }

    public StringBuffer method_888(int var1, StringBuffer var2) {
        method_759(var1, var2);
        method_760(this.field_656, var2);
        if (this.field_658 != null) {
            method_758(this.field_658, var2);
        }
        if (this.field_660 != null) {
            this.field_660.method_757(0, var2).append(' ');
        }
        var2.append(this.field_659);
        switch (this.method_887()) {
            case 3:
                if (this.field_655 != null) {
                    this.field_655.method_924(var1, var2);
                }
                break;
            default:
                if (this.field_655 != null) {
                    var2.append(" = ");
                    this.field_655.method_924(var1, var2);
                }
        }
        return var2;
    }

    public void method_821(class_86 var1) {}

    public void method_4(ReferenceBinding var1) {}

    public void method_2(int var1) {
        this.field_654 = var1;
    }

    public void method_3(int var1) {}
}
