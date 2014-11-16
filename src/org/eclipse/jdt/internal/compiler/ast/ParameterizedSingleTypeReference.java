package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.ArrayTypeReference;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.ParameterizedTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class ParameterizedSingleTypeReference extends ArrayTypeReference {

    public TypeReference[] typeArguments;

    public ParameterizedSingleTypeReference(char[] var1, TypeReference[] var2, int var3, long var4) {
        super(var1, var3, var4);
        this.field_730 = this.field_445;
        this.typeArguments = var2;
    }

    public void checkBounds(Scope var1) {
        if (this.resolvedType != null) {
            if (this.resolvedType.method_173() instanceof ParameterizedTypeBinding) {
                ParameterizedTypeBinding var2 = (ParameterizedTypeBinding)this.resolvedType.method_173();
                ReferenceBinding var3 = var2.method_286();
                TypeVariableBinding[] var4 = var3.typeVariables();
                TypeBinding[] var5 = var2.arguments;
                if (var5 != null && var4 != null) {
                    var2.boundCheck(var1, this.typeArguments);
                }
            }
        }
    }

    public TypeReference copyDims(int var1) {
        ParameterizedSingleTypeReference var10000 = new ParameterizedSingleTypeReference(this.token, this.typeArguments, var1, ((long)this.field_444 << 32) + (long)this.field_445);
        return var10000;
    }

    protected TypeBinding getTypeBinding(Scope var1) {
        return null;
    }

    private TypeBinding internalResolveType(Scope var1, ReferenceBinding var2, boolean var3) {
        this.constant = Constant.NotAConstant;
        if ((this.field_446 & 262144) != 0 && this.resolvedType != null) {
            if (this.resolvedType.isValidBinding()) {
                return this.resolvedType;
            } else {
                switch (this.resolvedType.problemId()) {
                    case 1:
                    case 2:
                    case 5:
                        TypeBinding var15 = this.resolvedType.closestMatch();
                        return var15;
                    case 3:
                    case 4:
                    default:
                        return null;
                }
            }
        } else {
            boolean var4 = false;
            this.field_446 |= 262144;
            Object var5;
            int var8;
            if (var2 == null) {
                this.resolvedType = var1.getType(this.token);
                if (this.resolvedType.isValidBinding()) {
                    var5 = (ReferenceBinding)this.resolvedType;
                } else {
                    var4 = true;
                    this.reportInvalidType(var1);
                    switch (this.resolvedType.problemId()) {
                        case 1:
                        case 2:
                        case 5:
                            TypeBinding var6 = this.resolvedType.closestMatch();
                            if (var6 instanceof ReferenceBinding) {
                                var5 = (ReferenceBinding)var6;
                                break;
                            }
                        case 3:
                        case 4:
                        default:
                            boolean var7 = var1.kind == 3;
                            var8 = this.typeArguments.length;
                            for (int var9 = 0; var9 < var8; ++var9) {
                                TypeReference var10 = this.typeArguments[var9];
                                if (var7) {
                                    var10.resolveType((ClassScope)var1);
                                } else {
                                    var10.resolveType((BlockScope)var1, var3);
                                }
                            }
                            return null;
                    }
                }
                var2 = ((ReferenceBinding)var5).enclosingType();
                if (var2 != null) {
                    var2 = ((ReferenceBinding)var5).method_226() ? (ReferenceBinding)var1.environment().convertToRawType(var2, false) : var1.environment().convertToParameterizedType(var2);
                    var5 = var1.environment().createParameterizedType((ReferenceBinding)((ReferenceBinding)var5).erasure(), (TypeBinding[])null, var2);
                }
            } else {
                this.resolvedType = (TypeBinding)(var5 = var1.getMemberType(this.token, var2));
                if (!this.resolvedType.isValidBinding()) {
                    var4 = true;
                    var1.problemReporter().invalidEnclosingType(this, (TypeBinding)var5, var2);
                    return null;
                }
                if (this.isTypeUseDeprecated((TypeBinding)var5, var1)) {
                    var1.problemReporter().method_1516((TypeBinding)var5, this);
                }
            }
            boolean var16 = var1.kind == 3;
            TypeReference var17 = null;
            if (var16) {
                var17 = ((ClassScope)var1).superTypeReference;
                ((ClassScope)var1).superTypeReference = null;
            }
            var8 = this.typeArguments.length;
            TypeBinding[] var18 = new TypeBinding[var8];
            boolean var19 = false;
            ReferenceBinding var11 = (ReferenceBinding)((ReferenceBinding)var5).erasure();
            for (int var12 = 0; var12 < var8; ++var12) {
                TypeReference var13 = this.typeArguments[var12];
                TypeBinding var14 = var16 ? var13.resolveTypeArgument((ClassScope)var1, var11, var12) : var13.resolveTypeArgument((BlockScope)var1, var11, var12);
                if (var14 == null) {
                    var19 = true;
                } else {
                    var18[var12] = var14;
                }
            }
            if (var19) {
                return null;
            } else {
                if (var16) {
                    ((ClassScope)var1).superTypeReference = var17;
                    if (((ClassScope)var1).detectHierarchyCycle(var11, this)) {
                        return null;
                    }
                }
                TypeVariableBinding[] var20 = var11.typeVariables();
                Object var24;
                if (var20 == Binding.NO_TYPE_VARIABLES) {
                    boolean var23 = var1.compilerOptions().field_1928 >= 3211264L;
                    if ((var11.tagBits & 128L) == 0L && var23) {
                        this.resolvedType = (TypeBinding)var5;
                        var1.problemReporter().nonGenericTypeCannotBeParameterized(0, this, (TypeBinding)var5, var18);
                        return null;
                    }
                    if (!var23) {
                        var24 = var5;
                        if (this.field_729 > 0) {
                            if (this.field_729 > 255) {
                                var1.problemReporter().method_1768(this);
                            }
                            var24 = var1.createArrayType((TypeBinding)var5, this.field_729);
                        }
                        if (var4) {
                            return (TypeBinding)var24;
                        }
                        return (TypeBinding)(this.resolvedType = (TypeBinding)var24);
                    }
                } else {
                    if (var8 != var20.length) {
                        var1.problemReporter().incorrectArityForParameterizedType(this, (TypeBinding)var5, var18);
                        return null;
                    }
                    if (!((ReferenceBinding)var5).method_226()) {
                        ReferenceBinding var21 = ((ReferenceBinding)var5).enclosingType();
                        if (var21 != null && var21.method_166()) {
                            var1.problemReporter().rawMemberTypeCannotBeParameterized(this, var1.environment().createRawType(var11, var21), var18);
                            return null;
                        }
                    }
                }
                ParameterizedTypeBinding var22 = var1.environment().createParameterizedType(var11, var18, var2);
                if (var3) {
                    var22.boundCheck(var1, this.typeArguments);
                }
                if (this.isTypeUseDeprecated(var22, var1)) {
                    this.reportDeprecatedType(var22, var1);
                }
                var24 = var22;
                if (this.field_729 > 0) {
                    if (this.field_729 > 255) {
                        var1.problemReporter().method_1768(this);
                    }
                    var24 = var1.createArrayType(var22, this.field_729);
                }
                if (var4) {
                    return (TypeBinding)var24;
                } else {
                    return (TypeBinding)(this.resolvedType = (TypeBinding)var24);
                }
            }
        }
    }

    public StringBuffer printExpression(int var1, StringBuffer var2) {
        var2.append(this.token);
        var2.append("<");
        int var3 = this.typeArguments.length - 1;
        int var4;
        for (var4 = 0; var4 < var3; ++var4) {
            this.typeArguments[var4].print(0, var2);
            var2.append(", ");
        }
        this.typeArguments[var3].print(0, var2);
        var2.append(">");
        if ((this.field_446 & 16384) != 0) {
            for (var4 = 0; var4 < this.field_729 - 1; ++var4) {
                var2.append("[]");
            }
            var2.append("...");
        } else {
            for (var4 = 0; var4 < this.field_729; ++var4) {
                var2.append("[]");
            }
        }
        return var2;
    }

    public TypeBinding resolveType(BlockScope var1, boolean var2) {
        return this.internalResolveType(var1, (ReferenceBinding)null, var2);
    }

    public TypeBinding resolveType(ClassScope var1) {
        return this.internalResolveType(var1, (ReferenceBinding)null, false);
    }

    public TypeBinding resolveTypeEnclosing(BlockScope var1, ReferenceBinding var2) {
        return this.internalResolveType(var1, var2, true);
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            int var3 = 0;
            for (int var4 = this.typeArguments.length; var3 < var4; ++var3) {
                this.typeArguments[var3].traverse(var1, var2);
            }
        }
        var1.endVisit(this, var2);
    }

    public void traverse(ASTVisitor var1, ClassScope var2) {
        if (var1.visit(this, var2)) {
            int var3 = 0;
            for (int var4 = this.typeArguments.length; var3 < var4; ++var3) {
                this.typeArguments[var3].traverse(var1, var2);
            }
        }
        var1.endVisit(this, var2);
    }
}
