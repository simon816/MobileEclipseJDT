package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.Assignment;
import org.eclipse.jdt.internal.compiler.ast.CompoundAssignment;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public abstract class Reference extends Expression {

    public Reference() {
    }

    public abstract FlowInfo analyseAssignment(BlockScope var1, FlowContext var2, FlowInfo var3, Assignment var4, boolean var5);

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        return var3;
    }

    public FieldBinding fieldBinding() {
        return null;
    }

    public void method_1037(CodeStream var1, FieldBinding var2, MethodBinding var3, boolean var4) {
        int var5 = var1.field_1208;
        if (var2.method_431()) {
            if (var4) {
                if (var2.type != TypeBinding.field_183 && var2.type != TypeBinding.field_185) {
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
                if (var2.type != TypeBinding.field_183 && var2.type != TypeBinding.field_185) {
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

    public abstract void generateAssignment(BlockScope var1, CodeStream var2, Assignment var3, boolean var4);

    public abstract void generateCompoundAssignment(BlockScope var1, CodeStream var2, Expression var3, int var4, int var5, boolean var6);

    public abstract void generatePostIncrement(BlockScope var1, CodeStream var2, CompoundAssignment var3, boolean var4);
}
