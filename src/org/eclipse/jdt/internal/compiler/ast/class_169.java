package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ast.class_126;
import org.eclipse.jdt.internal.compiler.flow.class_293;
import org.eclipse.jdt.internal.compiler.flow.class_301;
import org.eclipse.jdt.internal.compiler.impl.class_331;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.class_86;

public abstract class class_169 extends class_126 {

    public class_169(int var1, int var2) {
        this.field_444 = var1;
        this.field_445 = var2;
    }

    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        return var3;
    }

    public abstract void method_1081();

    public abstract class_40 method_1082(class_86 var1);

    public StringBuffer method_924(int var1, StringBuffer var2) {
        return var2.append(this.method_1083());
    }

    public class_40 method_925(class_86 var1) {
        this.field_675 = this.method_1082(var1);
        this.method_1081();
        if (this.field_672 == null) {
            var1.method_644().method_1512(this, this.field_675);
            this.field_672 = class_331.field_1896;
        }
        return this.field_675;
    }

    public abstract char[] method_1083();
}
