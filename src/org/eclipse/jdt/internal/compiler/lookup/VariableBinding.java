package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;

public abstract class VariableBinding extends Binding {

    public int field_300;

    public TypeBinding type;

    public char[] name;

    protected Constant constant;

    public int field_304;

    public long tagBits;

    public VariableBinding(char[] var1, TypeBinding var2, int var3, Constant var4) {
        this.name = var1;
        this.type = var2;
        this.field_300 = var3;
        this.constant = var4;
        if (var2 != null) {
            this.tagBits |= var2.tagBits & 128L;
        }
    }

    public Constant constant() {
        return this.constant;
    }

    public final boolean method_408() {
        return (this.field_300 & 67108864) != 0;
    }

    public final boolean method_409() {
        return (this.field_300 & 16) != 0;
    }

    public char[] readableName() {
        return this.name;
    }

    public void setConstant(Constant var1) {
        this.constant = var1;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer(10);
        ASTNode.method_760(this.field_300, var1);
        if ((this.field_300 & 33554432) != 0) {
            var1.append("[unresolved] ");
        }
        var1.append(this.type != null ? this.type.debugName() : "<no type>");
        var1.append(" ");
        var1.append(this.name != null ? new String(this.name) : "<no name>");
        return var1.toString();
    }
}
