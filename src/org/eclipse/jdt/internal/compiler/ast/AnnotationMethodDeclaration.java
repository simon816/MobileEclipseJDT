package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.ClassFile;
import org.eclipse.jdt.internal.compiler.ast.TypeParameter;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.MemberValuePair;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.lookup.ElementValuePair;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.parser.Parser;

public class AnnotationMethodDeclaration extends MethodDeclaration {

    public Expression defaultValue;

    public int extendedDimensions;

    public AnnotationMethodDeclaration(CompilationResult var1) {
        super(var1);
    }

    public void generateCode(ClassFile var1) {
        var1.generateMethodInfoHeader(this.binding);
        int var2 = var1.field_1719;
        int var3 = var1.generateMethodInfoAttribute(this.binding, this);
        var1.method_2986(var2, var3);
    }

    public boolean method_793() {
        return true;
    }

    public void parseStatements(Parser var1, CompilationUnitDeclaration var2) {}

    public StringBuffer print(int var1, StringBuffer var2) {
        method_759(var1, var2);
        method_760(this.field_482, var2);
        if (this.annotations != null) {
            printAnnotations(this.annotations, var2);
        }
        TypeParameter[] var3 = this.typeParameters();
        int var4;
        if (var3 != null) {
            var2.append('<');
            var4 = var3.length - 1;
            for (int var5 = 0; var5 < var4; ++var5) {
                var3[var5].print(0, var2);
                var2.append(", ");
            }
            var3[var4].print(0, var2);
            var2.append('>');
        }
        this.printReturnType(0, var2).append(this.selector).append('(');
        if (this.arguments != null) {
            for (var4 = 0; var4 < this.arguments.length; ++var4) {
                if (var4 > 0) {
                    var2.append(", ");
                }
                this.arguments[var4].print(0, var2);
            }
        }
        var2.append(')');
        if (this.thrownExceptions != null) {
            var2.append(" throws ");
            for (var4 = 0; var4 < this.thrownExceptions.length; ++var4) {
                if (var4 > 0) {
                    var2.append(", ");
                }
                this.thrownExceptions[var4].print(0, var2);
            }
        }
        if (this.defaultValue != null) {
            var2.append(" default ");
            this.defaultValue.print(0, var2);
        }
        this.printBody(var1 + 1, var2);
        return var2;
    }

    public void resolveStatements() {
        super.resolveStatements();
        if (this.arguments != null) {
            this.scope.problemReporter().method_1468(this);
        }
        if (this.typeParameters != null) {
            this.scope.problemReporter().method_1469(this);
        }
        if (this.extendedDimensions != 0) {
            this.scope.problemReporter().method_1569(this);
        }
        if (this.binding != null) {
            TypeBinding var1 = this.binding.returnType;
            if (var1 != null) {
                label35: {
                    TypeBinding var2 = var1.method_173();
                    if (var1.method_136() <= 1) {
                        switch (var2.erasure().id) {
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 16:
                                break label35;
                            case 6:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                            default:
                                if (var2.method_153() || var2.method_145()) {
                                    break label35;
                                }
                        }
                    }
                    this.scope.problemReporter().method_1622(this);
                }
                if (this.defaultValue != null) {
                    MemberValuePair var10000 = new MemberValuePair(this.selector, this.field_444, this.field_445, this.defaultValue);
                    MemberValuePair var3 = var10000;
                    var3.binding = this.binding;
                    var3.resolveTypeExpecting(this.scope, var1);
                    this.binding.setDefaultValue(ElementValuePair.getValue(this.defaultValue));
                } else {
                    this.binding.setDefaultValue((Object)null);
                }
            }
        }
    }

    public void traverse(ASTVisitor var1, ClassScope var2) {
        if (var1.visit(this, var2)) {
            if (this.annotations != null) {
                int var3 = this.annotations.length;
                for (int var4 = 0; var4 < var3; ++var4) {
                    this.annotations[var4].traverse(var1, this.scope);
                }
            }
            if (this.returnType != null) {
                this.returnType.traverse(var1, this.scope);
            }
            if (this.defaultValue != null) {
                this.defaultValue.traverse(var1, this.scope);
            }
        }
        var1.endVisit(this, var2);
    }
}
