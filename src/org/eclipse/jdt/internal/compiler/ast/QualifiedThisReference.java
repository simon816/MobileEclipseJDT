package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class QualifiedThisReference extends ThisReference {

    public TypeReference qualification;

    ReferenceBinding currentCompatibleType;

    public QualifiedThisReference(TypeReference var1, int var2, int var3) {
        super(var2, var3);
        this.qualification = var1;
        var1.field_446 |= 1073741824;
        this.field_444 = var1.field_444;
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        return var3;
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3, boolean var4) {
        return var3;
    }

    public void generateCode(BlockScope var1, CodeStream var2, boolean var3) {
        int var4 = var2.field_1208;
        if (var3) {
            if ((this.field_446 & 8160) != 0) {
                Object[] var5 = var1.getEmulationPath(this.currentCompatibleType, true, false);
                var2.generateOuterAccess(var5, this, this.currentCompatibleType, var1);
            } else {
                var2.method_2093();
            }
        }
        var2.method_2360(var4, this.field_444);
    }

    public TypeBinding resolveType(BlockScope var1) {
        this.constant = Constant.NotAConstant;
        TypeBinding var2 = this.qualification.resolveType(var1, true);
        if (var2 != null && var2.isValidBinding()) {
            var2 = var2.erasure();
            if (var2 instanceof ReferenceBinding) {
                this.resolvedType = var1.environment().convertToParameterizedType((ReferenceBinding)var2);
            } else {
                this.resolvedType = var2;
            }
            int var3 = 0;
            for (this.currentCompatibleType = var1.referenceType().binding; this.currentCompatibleType != null && this.currentCompatibleType != var2; this.currentCompatibleType = this.currentCompatibleType.method_226() ? null : this.currentCompatibleType.enclosingType()) {
                ++var3;
            }
            this.field_446 &= -8161;
            this.field_446 |= (var3 & 255) << 5;
            if (this.currentCompatibleType == null) {
                var1.problemReporter().noSuchEnclosingInstance(var2, this, false);
                return this.resolvedType;
            } else {
                if (var3 == 0) {
                    this.checkAccess(var1.method_635());
                }
                return this.resolvedType;
            }
        } else {
            return null;
        }
    }

    public StringBuffer printExpression(int var1, StringBuffer var2) {
        return this.qualification.print(0, var2).append(".this");
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            this.qualification.traverse(var1, var2);
        }
        var1.endVisit(this, var2);
    }
}
