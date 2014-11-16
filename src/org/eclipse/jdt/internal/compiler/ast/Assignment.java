package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.CastExpression;
import org.eclipse.jdt.internal.compiler.ast.PrefixExpression;
import org.eclipse.jdt.internal.compiler.ast.Reference;
import org.eclipse.jdt.internal.compiler.ast.FieldReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedThisReference;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedNameReference;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.flow.UnconditionalFlowInfo;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.BaseTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.WildcardBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class Assignment extends Expression {

    public Expression field_687;

    public Expression field_688;

    public Assignment(Expression var1, Expression var2, int var3) {
        this.field_687 = var1;
        var1.field_446 |= 8192;
        this.field_688 = var2;
        this.field_444 = var1.field_444;
        this.field_445 = var3;
    }

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        LocalVariableBinding var4 = this.field_687.localVariableBinding();
        int var5 = this.field_688.nullStatus(var3);
        if (var4 != null && (var4.type.tagBits & 2L) == 0L && var5 == 1) {
            var2.recordUsingNullReference(var1, var4, this.field_687, 769, var3);
        }
        UnconditionalFlowInfo var6 = ((Reference)this.field_687).analyseAssignment(var1, var2, var3, this, false).method_3109();
        if (var4 != null && (var4.type.tagBits & 2L) == 0L) {
            switch (var5) {
                case -1:
                    var6.method_3097(var4);
                    break;
                case 1:
                    var6.method_3098(var4);
                    break;
                default:
                    var6.method_3100(var4);
            }
            if (var2.initsOnFinally != null) {
                switch (var5) {
                    case -1:
                        var2.initsOnFinally.method_3097(var4);
                        break;
                    case 1:
                        var2.initsOnFinally.method_3098(var4);
                        break;
                    default:
                        var2.initsOnFinally.method_3100(var4);
                }
            }
        }
        return var6;
    }

    void checkAssignment(BlockScope var1, TypeBinding var2, TypeBinding var3) {
        FieldBinding var4 = this.getLastField(this.field_687);
        if (var4 != null && var3 != TypeBinding.field_187 && var2.kind() == 516 && ((WildcardBinding)var2).field_215 != 2) {
            var1.problemReporter().wildcardAssignment(var2, var3, this.field_688);
        } else if (var4 != null && !var4.method_431() && var4.declaringClass != null && var4.declaringClass.method_166()) {
            var1.problemReporter().unsafeRawFieldAssignment(var4, var3, this.field_687);
        } else if (var3.method_174(var2)) {
            var1.problemReporter().method_1806(this.field_688, var3, var2);
        }
    }

    public void generateCode(BlockScope var1, CodeStream var2, boolean var3) {
        int var4 = var2.field_1208;
        ((Reference)this.field_687).generateAssignment(var1, var2, this, var3);
        var2.method_2360(var4, this.field_444);
    }

    public static Binding method_944(Expression var0) {
        if ((var0.field_446 & 536870912) != 0) {
            return null;
        } else if (var0 instanceof SingleNameReference) {
            return ((SingleNameReference)var0).field_748;
        } else {
            if (var0 instanceof FieldReference) {
                FieldReference var1 = (FieldReference)var0;
                if (var1.receiver.method_755() && !(var1.receiver instanceof QualifiedThisReference)) {
                    return var1.binding;
                }
            } else if (var0 instanceof Assignment) {
                Expression var2 = ((Assignment)var0).field_687;
                if ((var2.field_446 & 8192) != 0) {
                    return method_944(((Assignment)var0).field_687);
                }
                if (var0 instanceof PrefixExpression) {
                    return method_944(((Assignment)var0).field_687);
                }
            } else if (var0 instanceof QualifiedNameReference) {
                QualifiedNameReference var3 = (QualifiedNameReference)var0;
                if (var3.indexOfFirstFieldBinding != 1 && var3.field_756 == null) {
                    return var3.field_748;
                }
            }
            return null;
        }
    }

    FieldBinding getLastField(Expression var1) {
        if (var1 instanceof SingleNameReference) {
            if ((var1.field_446 & 7) == 1) {
                return (FieldBinding)((SingleNameReference)var1).field_748;
            }
        } else {
            if (var1 instanceof FieldReference) {
                return ((FieldReference)var1).binding;
            }
            if (var1 instanceof QualifiedNameReference) {
                QualifiedNameReference var2 = (QualifiedNameReference)var1;
                if (var2.field_756 != null) {
                    return var2.field_756[var2.field_756.length - 1];
                }
                if ((var1.field_446 & 7) == 1) {
                    return (FieldBinding)var2.field_748;
                }
            }
        }
        return null;
    }

    public int nullStatus(FlowInfo var1) {
        return this.field_688.nullStatus(var1);
    }

    public StringBuffer print(int var1, StringBuffer var2) {
        method_759(var1, var2);
        return this.printExpressionNoParenthesis(var1, var2);
    }

    public StringBuffer printExpression(int var1, StringBuffer var2) {
        var2.append('(');
        return this.printExpressionNoParenthesis(0, var2).append(')');
    }

    public StringBuffer printExpressionNoParenthesis(int var1, StringBuffer var2) {
        this.field_687.printExpression(var1, var2).append(" = ");
        return this.field_688.printExpression(0, var2);
    }

    public StringBuffer printStatement(int var1, StringBuffer var2) {
        return this.print(var1, var2).append(';');
    }

    public TypeBinding resolveType(BlockScope var1) {
        this.constant = Constant.NotAConstant;
        if (this.field_687 instanceof Reference && !this.field_687.method_755()) {
            TypeBinding var2 = this.field_687.resolveType(var1);
            this.field_688.setExpectedType(var2);
            if (var2 != null) {
                this.resolvedType = var2.capture(var1, this.field_445);
            }
            TypeBinding var3 = this.field_688.resolveType(var1);
            if (var2 != null && var3 != null) {
                Binding var4 = method_944(this.field_687);
                if (var4 != null && var4 == method_944(this.field_688)) {
                    var1.problemReporter().assignmentHasNoEffect(this, var4.shortReadableName());
                }
                if (var2 != var3) {
                    var1.compilationUnitScope().recordTypeConversion(var2, var3);
                }
                if (!this.field_688.isConstantValueOfTypeAssignableToType(var3, var2) && (!var2.method_148() || !BaseTypeBinding.method_185(var2.id, var3.id)) && !var3.isCompatibleWith(var2)) {
                    if (!var1.isBoxingCompatibleWith(var3, var2) && (!var3.method_148() || var1.compilerOptions().field_1928 < 3211264L || var2.method_148() || !this.field_688.isConstantValueOfTypeAssignableToType(var3, var1.environment().method_486(var2)))) {
                        var1.problemReporter().typeMismatchError(var3, var2, this.field_688, this.field_687);
                        return var2;
                    } else {
                        this.field_688.computeConversion(var1, var2, var3);
                        if (this.field_688 instanceof CastExpression && (this.field_688.field_446 & 16384) == 0) {
                            CastExpression.checkNeedForAssignedCast(var1, var2, (CastExpression)this.field_688);
                        }
                        return this.resolvedType;
                    }
                } else {
                    this.field_688.computeConversion(var1, var2, var3);
                    this.checkAssignment(var1, var2, var3);
                    if (this.field_688 instanceof CastExpression && (this.field_688.field_446 & 16384) == 0) {
                        CastExpression.checkNeedForAssignedCast(var1, var2, (CastExpression)this.field_688);
                    }
                    return this.resolvedType;
                }
            } else {
                return null;
            }
        } else {
            var1.problemReporter().method_1547(this.field_687);
            return null;
        }
    }

    public TypeBinding resolveTypeExpecting(BlockScope var1, TypeBinding var2) {
        TypeBinding var3 = super.resolveTypeExpecting(var1, var2);
        if (var3 == null) {
            return null;
        } else {
            TypeBinding var4 = this.resolvedType;
            TypeBinding var5 = this.field_688.resolvedType;
            if (var2 == TypeBinding.field_186 && var4 == TypeBinding.field_186 && (this.field_687.field_446 & 8192) != 0) {
                var1.problemReporter().possibleAccidentalBooleanAssignment(this);
            }
            this.checkAssignment(var1, var4, var5);
            return var3;
        }
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            this.field_687.traverse(var1, var2);
            this.field_688.traverse(var1, var2);
        }
        var1.endVisit(this, var2);
    }

    public LocalVariableBinding localVariableBinding() {
        return this.field_687.localVariableBinding();
    }
}
