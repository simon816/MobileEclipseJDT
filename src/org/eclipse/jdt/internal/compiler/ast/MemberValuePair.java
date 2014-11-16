package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.ArrayAllocationExpression;
import org.eclipse.jdt.internal.compiler.ast.ArrayInitializer;
import org.eclipse.jdt.internal.compiler.ast.ClassLiteralAccess;
import org.eclipse.jdt.internal.compiler.ast.NameReference;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.NullLiteral;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.ElementValuePair;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.BaseTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class MemberValuePair extends ASTNode {

    public char[] name;

    public Expression value;

    public MethodBinding binding;

    public ElementValuePair compilerElementPair;

    public MemberValuePair(char[] var1, int var2, int var3, Expression var4) {
        this.compilerElementPair = null;
        this.name = var1;
        this.field_444 = var2;
        this.field_445 = var3;
        this.value = var4;
        if (var4 instanceof ArrayInitializer) {
            var4.field_446 |= 1;
        }
    }

    public StringBuffer print(int var1, StringBuffer var2) {
        var2.append(this.name).append(" = ");
        this.value.print(0, var2);
        return var2;
    }

    public void resolveTypeExpecting(BlockScope var1, TypeBinding var2) {
        ElementValuePair var10001;
        if (this.value == null) {
            var10001 = new ElementValuePair(this.name, this.value, this.binding);
            this.compilerElementPair = var10001;
        } else if (var2 == null) {
            if (this.value instanceof ArrayInitializer) {
                this.value.resolveTypeExpecting(var1, (TypeBinding)null);
            } else {
                this.value.resolveType(var1);
            }
            var10001 = new ElementValuePair(this.name, this.value, this.binding);
            this.compilerElementPair = var10001;
        } else {
            this.value.setExpectedType(var2);
            TypeBinding var3;
            if (this.value instanceof ArrayInitializer) {
                ArrayInitializer var4 = (ArrayInitializer)this.value;
                var3 = var4.resolveTypeExpecting(var1, this.binding.returnType);
            } else if (this.value instanceof ArrayAllocationExpression) {
                var1.problemReporter().method_1475(this.binding.declaringClass, this.name, this.value);
                this.value.resolveType(var1);
                var3 = null;
            } else {
                var3 = this.value.resolveType(var1);
            }
            var10001 = new ElementValuePair(this.name, this.value, this.binding);
            this.compilerElementPair = var10001;
            if (var3 != null) {
                TypeBinding var13 = var2.method_173();
                if (!this.value.isConstantValueOfTypeAssignableToType(var3, var2) && (!var2.method_148() || !BaseTypeBinding.method_185(var2.id, var3.id)) && !var3.isCompatibleWith(var2)) {
                    if ((!var2.method_147() || var2.method_136() != 1 || !this.value.isConstantValueOfTypeAssignableToType(var3, var13) && (!var13.method_148() || !BaseTypeBinding.method_185(var13.id, var3.id))) && !var3.isCompatibleWith(var13)) {
                        if (var13.method_145() && !var3.method_145()) {
                            var1.problemReporter().annotationValueMustBeAnnotation(this.binding.declaringClass, this.name, this.value, var13);
                        } else {
                            var1.problemReporter().typeMismatchError(var3, var2, this.value, (ASTNode)null);
                        }
                        return;
                    }
                } else {
                    var1.compilationUnitScope().recordTypeConversion(var2.method_173(), var3.method_173());
                    this.value.computeConversion(var1, var2, var3);
                }
                ArrayInitializer var5;
                Expression[] var6;
                int var7;
                int var8;
                Expression var9;
                switch (var13.erasure().id) {
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                        if (this.value instanceof ArrayInitializer) {
                            var5 = (ArrayInitializer)this.value;
                            var6 = var5.expressions;
                            if (var6 != null) {
                                var7 = 0;
                                for (var8 = var6.length; var7 < var8; ++var7) {
                                    var9 = var6[var7];
                                    if (var9.resolvedType != null && var9.constant == Constant.NotAConstant) {
                                        var1.problemReporter().annotationValueMustBeConstant(this.binding.declaringClass, this.name, var6[var7], false);
                                    }
                                }
                            }
                        } else if (this.value.constant == Constant.NotAConstant) {
                            if (var3.method_147()) {
                                var1.problemReporter().method_1475(this.binding.declaringClass, this.name, this.value);
                            } else {
                                var1.problemReporter().annotationValueMustBeConstant(this.binding.declaringClass, this.name, this.value, false);
                            }
                        }
                        break;
                    case 6:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    default:
                        if (var13.method_153()) {
                            if (this.value instanceof NullLiteral) {
                                var1.problemReporter().annotationValueMustBeConstant(this.binding.declaringClass, this.name, this.value, true);
                            } else if (this.value instanceof ArrayInitializer) {
                                var5 = (ArrayInitializer)this.value;
                                var6 = var5.expressions;
                                if (var6 != null) {
                                    var7 = 0;
                                    for (var8 = var6.length; var7 < var8; ++var7) {
                                        var9 = var6[var7];
                                        if (var9 instanceof NullLiteral) {
                                            var1.problemReporter().annotationValueMustBeConstant(this.binding.declaringClass, this.name, var9, true);
                                        } else if (var9 instanceof NameReference) {
                                            NameReference var10 = (NameReference)var9;
                                            Binding var11 = var10.field_748;
                                            if (var11.kind() == 1) {
                                                FieldBinding var12 = (FieldBinding)var11;
                                                if (!var12.declaringClass.method_153()) {
                                                    var1.problemReporter().annotationValueMustBeConstant(this.binding.declaringClass, this.name, var9, true);
                                                }
                                            }
                                        }
                                    }
                                }
                            } else if (this.value instanceof NameReference) {
                                NameReference var14 = (NameReference)this.value;
                                Binding var15 = var14.field_748;
                                if (var15.kind() == 1) {
                                    FieldBinding var16 = (FieldBinding)var15;
                                    if (!var16.declaringClass.method_153()) {
                                        if (!var16.type.method_147()) {
                                            var1.problemReporter().annotationValueMustBeConstant(this.binding.declaringClass, this.name, this.value, true);
                                        } else {
                                            var1.problemReporter().method_1475(this.binding.declaringClass, this.name, this.value);
                                        }
                                    }
                                }
                            }
                        } else if (var13.method_145()) {
                            if (!var3.method_173().method_145()) {
                                var1.problemReporter().annotationValueMustBeAnnotation(this.binding.declaringClass, this.name, this.value, var13);
                            } else if (this.value instanceof ArrayInitializer) {
                                var5 = (ArrayInitializer)this.value;
                                var6 = var5.expressions;
                                if (var6 != null) {
                                    var7 = 0;
                                    for (var8 = var6.length; var7 < var8; ++var7) {
                                        var9 = var6[var7];
                                        if (var9 instanceof NullLiteral || !(var9 instanceof Annotation)) {
                                            var1.problemReporter().annotationValueMustBeAnnotation(this.binding.declaringClass, this.name, var9, var13);
                                        }
                                    }
                                }
                            } else if (!(this.value instanceof Annotation)) {
                                var1.problemReporter().annotationValueMustBeAnnotation(this.binding.declaringClass, this.name, this.value, var13);
                            }
                        }
                        break;
                    case 16:
                        if (this.value instanceof ArrayInitializer) {
                            var5 = (ArrayInitializer)this.value;
                            var6 = var5.expressions;
                            if (var6 != null) {
                                var7 = 0;
                                for (var8 = var6.length; var7 < var8; ++var7) {
                                    var9 = var6[var7];
                                    if (!(var9 instanceof ClassLiteralAccess)) {
                                        var1.problemReporter().method_1476(this.binding.declaringClass, this.name, var9);
                                    }
                                }
                            }
                        } else if (!(this.value instanceof ClassLiteralAccess)) {
                            var1.problemReporter().method_1476(this.binding.declaringClass, this.name, this.value);
                        }
                }
            }
        }
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2) && this.value != null) {
            this.value.traverse(var1, var2);
        }
        var1.endVisit(this, var2);
    }
}
