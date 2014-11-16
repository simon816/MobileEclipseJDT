package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.SwitchStatement;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.NameReference;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedNameReference;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.codegen.CaseLabel;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.impl.IntConstant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class CaseStatement extends Statement {

    public Expression constantExpression;

    public CaseLabel targetLabel;

    public CaseStatement(Expression var1, int var2, int var3) {
        this.constantExpression = var1;
        this.field_445 = var2;
        this.field_444 = var3;
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        if (this.constantExpression != null) {
            if (this.constantExpression.constant == Constant.NotAConstant && !this.constantExpression.resolvedType.method_153()) {
                var1.problemReporter().method_1507(this.constantExpression);
            }
            this.constantExpression.analyseCode(var1, var2, var3);
        }
        return var3;
    }

    public StringBuffer printStatement(int var1, StringBuffer var2) {
        method_759(var1, var2);
        if (this.constantExpression == null) {
            var2.append("default : ");
        } else {
            var2.append("case ");
            this.constantExpression.printExpression(0, var2).append(" : ");
        }
        return var2.append(';');
    }

    public void generateCode(BlockScope var1, CodeStream var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            int var3 = var2.field_1208;
            this.targetLabel.place();
            var2.method_2360(var3, this.field_444);
        }
    }

    public void resolve(BlockScope var1) {}

    public Constant resolveCase(BlockScope var1, TypeBinding var2, SwitchStatement var3) {
        var1.enclosingCase = this;
        if (this.constantExpression == null) {
            if (var3.defaultCase != null) {
                var1.problemReporter().method_1522(this);
            }
            var3.defaultCase = this;
            return Constant.NotAConstant;
        } else {
            var3.field_607[var3.field_610++] = this;
            if (var2 != null && var2.method_153() && this.constantExpression instanceof SingleNameReference) {
                ((SingleNameReference)this.constantExpression).setActualReceiverType((ReferenceBinding)var2);
            }
            TypeBinding var4 = this.constantExpression.resolveType(var1);
            if (var4 != null && var2 != null) {
                if (!this.constantExpression.isConstantValueOfTypeAssignableToType(var4, var2) && !var4.isCompatibleWith(var2)) {
                    if (var1.isBoxingCompatibleWith(var4, var2) || var4.method_148() && var1.compilerOptions().field_1928 >= 3211264L && !var2.method_148() && this.constantExpression.isConstantValueOfTypeAssignableToType(var4, var1.environment().method_486(var2))) {
                        return this.constantExpression.constant;
                    }
                } else {
                    if (!var4.method_153()) {
                        return this.constantExpression.constant;
                    }
                    if ((this.constantExpression.field_446 & 534773760) >> 21 != 0) {
                        var1.problemReporter().method_1542(this.constantExpression);
                    }
                    if (this.constantExpression instanceof NameReference && (this.constantExpression.field_446 & 7) == 1) {
                        NameReference var5 = (NameReference)this.constantExpression;
                        FieldBinding var6 = var5.fieldBinding();
                        if ((var6.field_300 & 16384) == 0) {
                            var1.problemReporter().method_1544(var5, var6);
                        } else if (var5 instanceof QualifiedNameReference) {
                            var1.problemReporter().method_1505(var5, var6);
                        }
                        return IntConstant.fromValue(var6.original().field_304 + 1);
                    }
                }
                var1.problemReporter().typeMismatchError(var4, var2, this.constantExpression, var3.expression);
                return Constant.NotAConstant;
            } else {
                return Constant.NotAConstant;
            }
        }
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2) && this.constantExpression != null) {
            this.constantExpression.traverse(var1, var2);
        }
        var1.endVisit(this, var2);
    }
}
