package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ArrayBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class ClassLiteralAccess extends Expression {

    public TypeReference type;

    public TypeBinding targetType;

    FieldBinding syntheticField;

    public ClassLiteralAccess(int var1, TypeReference var2) {
        this.type = var2;
        var2.field_446 |= 1073741824;
        this.field_444 = var2.field_444;
        this.field_445 = var1;
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        SourceTypeBinding var4 = var1.method_640().enclosingSourceType();
        if (!var4.method_157() && !this.targetType.method_148() && var1.compilerOptions().field_1928 < 3211264L) {
            this.syntheticField = var4.addSyntheticFieldForClassLiteral(this.targetType, var1);
        }
        return var3;
    }

    public void generateCode(BlockScope var1, CodeStream var2, boolean var3) {
        int var4 = var2.field_1208;
        if (var3) {
            var2.generateClassLiteralAccessForType(this.type.resolvedType, this.syntheticField);
            var2.method_2182(this.field_674);
        }
        var2.method_2360(var4, this.field_444);
    }

    public StringBuffer printExpression(int var1, StringBuffer var2) {
        return this.type.print(0, var2).append(".class");
    }

    public TypeBinding resolveType(BlockScope var1) {
        this.constant = Constant.NotAConstant;
        if ((this.targetType = this.type.resolveType(var1, true)) == null) {
            return null;
        } else {
            TypeBinding var3;
            if (this.targetType.method_147()) {
                ArrayBinding var2 = (ArrayBinding)this.targetType;
                var3 = var2.leafComponentType;
                if (var3 == TypeBinding.field_188) {
                    var1.problemReporter().method_1490(this);
                    return null;
                }
                if (var3.method_169()) {
                    var1.problemReporter().method_1568((TypeVariableBinding)var3, this);
                }
            } else if (this.targetType.method_169()) {
                var1.problemReporter().method_1568((TypeVariableBinding)this.targetType, this);
            }
            ReferenceBinding var4 = var1.method_606();
            if (var4.method_155()) {
                var3 = null;
                Object var5;
                if (this.targetType.id == 6) {
                    var5 = var1.environment().getResolvedType(field_117, var1);
                } else {
                    var5 = var1.boxing(this.targetType);
                }
                this.resolvedType = var1.environment().createParameterizedType(var4, new TypeBinding[] {(TypeBinding)var5}, (ReferenceBinding)null);
            } else {
                this.resolvedType = var4;
            }
            return this.resolvedType;
        }
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            this.type.traverse(var1, var2);
        }
        var1.endVisit(this, var2);
    }
}
