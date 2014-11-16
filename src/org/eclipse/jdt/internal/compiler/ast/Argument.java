package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ArrayBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodScope;

public class Argument extends LocalDeclaration {

    private static final char[] SET;

    public Argument(char[] var1, long var2, TypeReference var4, int var5) {
        super(var1, (int)(var2 >>> 32), (int)var2);
        this.field_652 = (int)var2;
        this.field_656 = var5;
        this.type = var4;
        this.field_446 |= 1073741824;
    }

    public void bind(MethodScope var1, TypeBinding var2, boolean var3) {
        Binding var4 = var1.getBinding(this.name, 3, this, false);
        if (var4 != null && var4.isValidBinding()) {
            if (var4 instanceof LocalVariableBinding && this.field_654 == 0) {
                var1.problemReporter().method_1744(this);
            } else {
                boolean var5 = false;
                if (var4 instanceof FieldBinding) {
                    if (var1.method_726()) {
                        var5 = true;
                    } else {
                        AbstractMethodDeclaration var6 = var1.referenceMethod();
                        if (var6 != null && CharOperation.method_1381(SET, var6.selector)) {
                            var5 = true;
                        }
                    }
                }
                var1.problemReporter().localVariableHiding(this, var4, var5);
            }
        }
        if (this.binding == null) {
            LocalVariableBinding var10001 = new LocalVariableBinding(this, var2, this.field_656, true);
            this.binding = var10001;
        }
        var1.addLocalVariable(this.binding);
        method_761(var1, this.annotations, this.binding);
        this.binding.declaration = this;
        this.binding.field_307 = var3 ? 1 : 0;
    }

    public int getKind() {
        return 5;
    }

    public boolean isVarArgs() {
        return this.type != null && (this.type.field_446 & 16384) != 0;
    }

    public StringBuffer print(int var1, StringBuffer var2) {
        method_759(var1, var2);
        method_760(this.field_656, var2);
        if (this.annotations != null) {
            printAnnotations(this.annotations, var2);
        }
        if (this.type == null) {
            var2.append("<no type> ");
        } else {
            this.type.print(0, var2).append(' ');
        }
        return var2.append(this.name);
    }

    public StringBuffer printStatement(int var1, StringBuffer var2) {
        return this.print(var1, var2).append(';');
    }

    public TypeBinding resolveForCatch(BlockScope var1) {
        TypeBinding var2 = this.type.resolveType(var1, true);
        boolean var3;
        if (var2 == null) {
            var3 = true;
        } else {
            var3 = false;
            switch (var2.kind()) {
                case 68:
                    if (((ArrayBinding)var2).leafComponentType == TypeBinding.field_188) {
                        var1.problemReporter().method_1822(this);
                        var3 = true;
                    }
                    break;
                case 260:
                    if (var2.method_149()) {
                        var3 = true;
                        var1.problemReporter().method_1637(var2, this);
                    }
                    break;
                case 4100:
                    var1.problemReporter().method_1643(var2, this);
                    var3 = true;
            }
            if (var2.findSuperTypeOriginatingFrom(21, true) == null && var2.isValidBinding()) {
                var1.problemReporter().method_1504(this.type, var2);
                var3 = true;
            }
        }
        Binding var4 = var1.getBinding(this.name, 3, this, false);
        if (var4 != null && var4.isValidBinding()) {
            if (var4 instanceof LocalVariableBinding && this.field_654 == 0) {
                var1.problemReporter().method_1744(this);
            } else {
                var1.problemReporter().localVariableHiding(this, var4, false);
            }
        }
        LocalVariableBinding var10001 = new LocalVariableBinding(this, var2, this.field_656, false);
        this.binding = var10001;
        method_761(var1, this.annotations, this.binding);
        var1.addLocalVariable(this.binding);
        this.binding.setConstant(Constant.NotAConstant);
        return var3 ? null : var2;
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            if (this.annotations != null) {
                int var3 = this.annotations.length;
                for (int var4 = 0; var4 < var3; ++var4) {
                    this.annotations[var4].traverse(var1, var2);
                }
            }
            if (this.type != null) {
                this.type.traverse(var1, var2);
            }
        }
        var1.endVisit(this, var2);
    }

    static {
        SET = "set".toCharArray();
    }
}
