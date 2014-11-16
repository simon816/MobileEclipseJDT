package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.SingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.ArrayTypeReference;
import org.eclipse.jdt.internal.compiler.flow.FlowContext;
import org.eclipse.jdt.internal.compiler.flow.FlowInfo;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ArrayBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.ProblemReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public abstract class TypeReference extends Expression {

    public TypeReference() {
    }

    public static final TypeReference baseTypeReference(int var0, int var1) {
        if (var1 == 0) {
            SingleTypeReference var2;
            switch (var0) {
                case 2:
                    var2 = new SingleTypeReference(TypeBinding.field_182.simpleName, 0L);
                    return var2;
                case 3:
                    var2 = new SingleTypeReference(TypeBinding.field_180.simpleName, 0L);
                    return var2;
                case 4:
                    var2 = new SingleTypeReference(TypeBinding.field_181.simpleName, 0L);
                    return var2;
                case 5:
                    var2 = new SingleTypeReference(TypeBinding.field_186.simpleName, 0L);
                    return var2;
                case 6:
                    var2 = new SingleTypeReference(TypeBinding.field_188.simpleName, 0L);
                    return var2;
                case 7:
                default:
                    var2 = new SingleTypeReference(TypeBinding.field_183.simpleName, 0L);
                    return var2;
                case 8:
                    var2 = new SingleTypeReference(TypeBinding.field_185.simpleName, 0L);
                    return var2;
                case 9:
                    var2 = new SingleTypeReference(TypeBinding.field_184.simpleName, 0L);
                    return var2;
                case 10:
                    var2 = new SingleTypeReference(TypeBinding.field_179.simpleName, 0L);
                    return var2;
            }
        } else {
            ArrayTypeReference var10000;
            switch (var0) {
                case 2:
                    var10000 = new ArrayTypeReference(TypeBinding.field_182.simpleName, var1, 0L);
                    return var10000;
                case 3:
                    var10000 = new ArrayTypeReference(TypeBinding.field_180.simpleName, var1, 0L);
                    return var10000;
                case 4:
                    var10000 = new ArrayTypeReference(TypeBinding.field_181.simpleName, var1, 0L);
                    return var10000;
                case 5:
                    var10000 = new ArrayTypeReference(TypeBinding.field_186.simpleName, var1, 0L);
                    return var10000;
                case 6:
                    var10000 = new ArrayTypeReference(TypeBinding.field_188.simpleName, var1, 0L);
                    return var10000;
                case 7:
                default:
                    var10000 = new ArrayTypeReference(TypeBinding.field_183.simpleName, var1, 0L);
                    return var10000;
                case 8:
                    var10000 = new ArrayTypeReference(TypeBinding.field_185.simpleName, var1, 0L);
                    return var10000;
                case 9:
                    var10000 = new ArrayTypeReference(TypeBinding.field_184.simpleName, var1, 0L);
                    return var10000;
                case 10:
                    var10000 = new ArrayTypeReference(TypeBinding.field_179.simpleName, var1, 0L);
                    return var10000;
            }
        }
    }

    public void method_1006(Scope var1) {}

    public FlowInfo analyseCode(BlockScope var1, FlowContext var2, FlowInfo var3) {
        return var3;
    }

    public void checkBounds(Scope var1) {}

    public abstract TypeReference copyDims(int var1);

    public int dimensions() {
        return 0;
    }

    public abstract char[] getLastToken();

    protected abstract TypeBinding getTypeBinding(Scope var1);

    public abstract char[][] getTypeName();

    protected TypeBinding internalResolveType(Scope var1) {
        this.constant = Constant.NotAConstant;
        if (this.resolvedType != null) {
            if (this.resolvedType.isValidBinding()) {
                return this.resolvedType;
            } else {
                switch (this.resolvedType.problemId()) {
                    case 1:
                    case 2:
                    case 5:
                        TypeBinding var4 = this.resolvedType.closestMatch();
                        if (var4 == null) {
                            return null;
                        }
                        return var1.environment().convertToRawType(var4, false);
                    case 3:
                    case 4:
                    default:
                        return null;
                }
            }
        } else {
            TypeBinding var3 = this.resolvedType = this.getTypeBinding(var1);
            if (var3 == null) {
                return null;
            } else {
                boolean var2;
                if (var2 = !var3.isValidBinding()) {
                    this.reportInvalidType(var1);
                    switch (var3.problemId()) {
                        case 1:
                        case 2:
                        case 5:
                            var3 = var3.closestMatch();
                            if (var3 == null) {
                                return null;
                            }
                            break;
                        case 3:
                        case 4:
                        default:
                            return null;
                    }
                }
                if (var3.method_147() && ((ArrayBinding)var3).leafComponentType == TypeBinding.field_188) {
                    var1.problemReporter().method_1490(this);
                    return null;
                } else {
                    if (this.isTypeUseDeprecated(var3, var1)) {
                        this.reportDeprecatedType(var3, var1);
                    }
                    var3 = var1.environment().convertToRawType(var3, false);
                    if (var3.method_173().method_166() && (this.field_446 & 1073741824) == 0 && var1.compilerOptions().method_3313(35184372088832L) != -1) {
                        var1.problemReporter().method_1742(this, var3);
                    }
                    return var2 ? var3 : (this.resolvedType = var3);
                }
            }
        }
    }

    protected void reportDeprecatedType(TypeBinding var1, Scope var2) {
        var2.problemReporter().method_1516(var1, this);
    }

    protected void reportInvalidType(Scope var1) {
        var1.problemReporter().method_1639(this, this.resolvedType);
    }

    public TypeBinding method_1016(ClassScope var1) {
        TypeBinding var2 = this.resolveType(var1);
        if (var2 == null) {
            return null;
        } else if (var2.method_169()) {
            if (this.resolvedType.isValidBinding()) {
                ProblemReferenceBinding var10001 = new ProblemReferenceBinding(this.getTypeName(), (ReferenceBinding)this.resolvedType, 9);
                this.resolvedType = var10001;
                this.reportInvalidType(var1);
            }
            return null;
        } else {
            return var2;
        }
    }

    public final TypeBinding resolveType(BlockScope var1) {
        return this.resolveType(var1, true);
    }

    public TypeBinding resolveType(BlockScope var1, boolean var2) {
        return this.internalResolveType(var1);
    }

    public TypeBinding resolveType(ClassScope var1) {
        return this.internalResolveType(var1);
    }

    public TypeBinding resolveTypeArgument(BlockScope var1, ReferenceBinding var2, int var3) {
        return this.resolveType(var1, true);
    }

    public TypeBinding resolveTypeArgument(ClassScope var1, ReferenceBinding var2, int var3) {
        return this.resolveType(var1);
    }

    public abstract void traverse(ASTVisitor var1, BlockScope var2);

    public abstract void traverse(ASTVisitor var1, ClassScope var2);
}
