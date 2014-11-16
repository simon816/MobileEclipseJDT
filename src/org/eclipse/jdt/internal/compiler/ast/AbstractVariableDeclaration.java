package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.lookup.InvocationSite;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public abstract class AbstractVariableDeclaration extends Statement implements InvocationSite {

    public int field_651;

    public int field_652;

    public int field_653;

    public int field_654;

    public Expression initialization;

    public int field_656;

    public int field_657;

    public Annotation[] annotations;

    public char[] name;

    public TypeReference type;

    public AbstractVariableDeclaration() {
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        return var3;
    }

    public TypeBinding[] genericTypeArguments() {
        return null;
    }

    public abstract int getKind();

    public boolean isSuperAccess() {
        return false;
    }

    public StringBuffer printStatement(int var1, StringBuffer var2) {
        this.method_888(var1, var2);
        switch (this.getKind()) {
            case 3:
                return var2.append(',');
            default:
                return var2.append(';');
        }
    }

    public StringBuffer method_888(int var1, StringBuffer var2) {
        method_759(var1, var2);
        method_760(this.field_656, var2);
        if (this.annotations != null) {
            printAnnotations(this.annotations, var2);
        }
        if (this.type != null) {
            this.type.print(0, var2).append(' ');
        }
        var2.append(this.name);
        switch (this.getKind()) {
            case 3:
                if (this.initialization != null) {
                    this.initialization.printExpression(var1, var2);
                }
                break;
            default:
                if (this.initialization != null) {
                    var2.append(" = ");
                    this.initialization.printExpression(var1, var2);
                }
        }
        return var2;
    }

    public void resolve(BlockScope var1) {}

    public void setActualReceiverType(ReferenceBinding var1) {}

    public void method_2(int var1) {
        this.field_654 = var1;
    }

    public void setFieldIndex(int var1) {}
}
