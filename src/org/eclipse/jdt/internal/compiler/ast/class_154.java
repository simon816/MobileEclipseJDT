package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ast.class_126;
import org.eclipse.jdt.internal.compiler.ast.class_131;
import org.eclipse.jdt.internal.compiler.ast.class_132;
import org.eclipse.jdt.internal.compiler.codegen.class_268;
import org.eclipse.jdt.internal.compiler.flow.class_293;
import org.eclipse.jdt.internal.compiler.flow.class_301;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.class_58;
import org.eclipse.jdt.internal.compiler.lookup.class_67;
import org.eclipse.jdt.internal.compiler.lookup.class_86;

public abstract class class_154 extends class_126 {

    public class_154() {
    }

    public abstract class_301 method_1035(class_86 var1, class_293 var2, class_301 var3, class_131 var4, boolean var5);

    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        return var3;
    }

    public class_67 method_1036() {
        return null;
    }

    public void method_1037(class_268 var1, class_67 var2, class_58 var3, boolean var4) {
        int var5 = var1.field_1208;
        if (var2.method_431()) {
            if (var4) {
                if (var2.field_301 != class_40.field_183 && var2.field_301 != class_40.field_185) {
                    var1.method_2141();
                } else {
                    var1.method_2144();
                }
            }
            if (var3 == null) {
                var1.method_2357(var2);
            } else {
                var1.method_2273(var3);
            }
        } else {
            if (var4) {
                if (var2.field_301 != class_40.field_183 && var2.field_301 != class_40.field_185) {
                    var1.method_2142();
                } else {
                    var1.method_2145();
                }
            }
            if (var3 == null) {
                var1.method_2356(var2);
            } else {
                var1.method_2273(var3);
            }
        }
        var1.method_2360(var5, this.field_444);
    }

    public abstract void method_1038(class_86 var1, class_268 var2, class_131 var3, boolean var4);

    public abstract void method_1039(class_86 var1, class_268 var2, class_126 var3, int var4, int var5, boolean var6);

    public abstract void method_1040(class_86 var1, class_268 var2, class_132 var3, boolean var4);
}
