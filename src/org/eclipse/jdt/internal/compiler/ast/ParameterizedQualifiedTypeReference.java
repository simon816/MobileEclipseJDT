package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.ArrayQualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.PackageBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.ParameterizedTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class ParameterizedQualifiedTypeReference extends ArrayQualifiedTypeReference {

    public TypeReference[][] typeArguments;

    public ParameterizedQualifiedTypeReference(char[][] var1, TypeReference[][] var2, int var3, long[] var4) {
        super(var1, var3, var4);
        this.typeArguments = var2;
    }

    public void checkBounds(Scope var1) {
        if (this.resolvedType != null) {
            this.checkBounds((ReferenceBinding)this.resolvedType.method_173(), var1, this.typeArguments.length - 1);
        }
    }

    public void checkBounds(ReferenceBinding var1, Scope var2, int var3) {
        if (var3 > 0 && var1.enclosingType() != null) {
            this.checkBounds(var1.enclosingType(), var2, var3 - 1);
        }
        if (var1.method_162()) {
            ParameterizedTypeBinding var4 = (ParameterizedTypeBinding)var1;
            ReferenceBinding var5 = var4.method_286();
            TypeVariableBinding[] var6 = var5.typeVariables();
            TypeBinding[] var7 = var4.arguments;
            if (var7 != null && var6 != null) {
                var4.boundCheck(var2, this.typeArguments[var3]);
            }
        }
    }

    public TypeReference copyDims(int var1) {
        ParameterizedQualifiedTypeReference var10000 = new ParameterizedQualifiedTypeReference(this.tokens, this.typeArguments, var1, this.sourcePositions);
        return var10000;
    }

    protected TypeBinding getTypeBinding(Scope var1) {
        return null;
    }

    private TypeBinding internalResolveType(Scope var1, boolean var2) {
        this.constant = Constant.NotAConstant;
        if ((this.field_446 & 262144) != 0 && this.resolvedType != null && this.resolvedType != null) {
            if (this.resolvedType.isValidBinding()) {
                return this.resolvedType;
            } else {
                switch (this.resolvedType.problemId()) {
                    case 1:
                    case 2:
                    case 5:
                        TypeBinding var20 = this.resolvedType.closestMatch();
                        return var20;
                    case 3:
                    case 4:
                    default:
                        return null;
                }
            }
        } else {
            this.field_446 |= 262144;
            boolean var3 = var1.kind == 3;
            Binding var4 = var1.method_615(this.tokens);
            int var8;
            int var9;
            if (var4 != null && !var4.isValidBinding()) {
                this.resolvedType = (ReferenceBinding)var4;
                this.reportInvalidType(var1);
                int var21 = 0;
                for (int var22 = this.tokens.length; var21 < var22; ++var21) {
                    TypeReference[] var24 = this.typeArguments[var21];
                    if (var24 != null) {
                        var8 = var24.length;
                        for (var9 = 0; var9 < var8; ++var9) {
                            TypeReference var23 = var24[var9];
                            if (var3) {
                                var23.resolveType((ClassScope)var1);
                            } else {
                                var23.resolveType((BlockScope)var1, var2);
                            }
                        }
                    }
                }
                return null;
            } else {
                PackageBinding var5 = var4 == null ? null : (PackageBinding)var4;
                boolean var6 = true;
                Object var7 = null;
                var8 = var5 == null ? 0 : var5.compoundName.length;
                for (var9 = this.tokens.length; var8 < var9; ++var8) {
                    this.method_1030(var8, var1, var5);
                    TypeReference[] var11;
                    int var13;
                    if (!this.resolvedType.isValidBinding()) {
                        this.reportInvalidType(var1);
                        for (int var25 = var8; var25 < var9; ++var25) {
                            var11 = this.typeArguments[var25];
                            if (var11 != null) {
                                int var27 = var11.length;
                                for (var13 = 0; var13 < var27; ++var13) {
                                    TypeReference var28 = var11[var13];
                                    if (var3) {
                                        var28.resolveType((ClassScope)var1);
                                    } else {
                                        var28.resolveType((BlockScope)var1);
                                    }
                                }
                            }
                        }
                        return null;
                    }
                    ReferenceBinding var10 = (ReferenceBinding)this.resolvedType;
                    if (var7 == null) {
                        var7 = var10.enclosingType();
                        if (var7 != null) {
                            var7 = var10.method_226() ? (ReferenceBinding)var1.environment().convertToRawType((TypeBinding)var7, false) : var1.environment().convertToParameterizedType((ReferenceBinding)var7);
                        }
                    }
                    if (var6 && var10.method_226() && var7 != null && (((ReferenceBinding)var7).method_162() && ((ParameterizedTypeBinding)var7).arguments != null || ((ReferenceBinding)var7).method_155())) {
                        var1.problemReporter().staticMemberOfParameterizedType(this, var1.environment().createParameterizedType((ReferenceBinding)var10.erasure(), (TypeBinding[])null, (ReferenceBinding)var7));
                        var6 = false;
                    }
                    var11 = this.typeArguments[var8];
                    if (var11 != null) {
                        TypeReference var12 = null;
                        if (var3) {
                            var12 = ((ClassScope)var1).superTypeReference;
                            ((ClassScope)var1).superTypeReference = null;
                        }
                        var13 = var11.length;
                        TypeBinding[] var14 = new TypeBinding[var13];
                        boolean var15 = false;
                        ReferenceBinding var16 = (ReferenceBinding)var10.erasure();
                        for (int var17 = 0; var17 < var13; ++var17) {
                            TypeReference var18 = var11[var17];
                            TypeBinding var19 = var3 ? var18.resolveTypeArgument((ClassScope)var1, var16, var17) : var18.resolveTypeArgument((BlockScope)var1, var16, var17);
                            if (var19 == null) {
                                var15 = true;
                            } else {
                                var14[var17] = var19;
                            }
                        }
                        if (var15) {
                            return null;
                        }
                        if (var3) {
                            ((ClassScope)var1).superTypeReference = var12;
                            if (((ClassScope)var1).detectHierarchyCycle(var16, this)) {
                                return null;
                            }
                        }
                        TypeVariableBinding[] var29 = var16.typeVariables();
                        if (var29 == Binding.NO_TYPE_VARIABLES) {
                            if (var1.compilerOptions().field_1928 >= 3211264L) {
                                var1.problemReporter().nonGenericTypeCannotBeParameterized(var8, this, var10, var14);
                                return null;
                            }
                            this.resolvedType = (TypeBinding)(var7 != null && ((ReferenceBinding)var7).method_162() ? var1.environment().createParameterizedType(var16, (TypeBinding[])null, (ReferenceBinding)var7) : var10);
                            if (this.dimensions > 0) {
                                if (this.dimensions > 255) {
                                    var1.problemReporter().method_1768(this);
                                }
                                this.resolvedType = var1.createArrayType(this.resolvedType, this.dimensions);
                            }
                            return this.resolvedType;
                        }
                        if (var13 != var29.length) {
                            var1.problemReporter().incorrectArityForParameterizedType(this, var10, var14);
                            return null;
                        }
                        if (var6 && !var10.method_226()) {
                            ReferenceBinding var31 = var10.enclosingType();
                            if (var31 != null && var31.method_166()) {
                                var1.problemReporter().rawMemberTypeCannotBeParameterized(this, var1.environment().createRawType(var16, var31), var14);
                                var6 = false;
                            }
                        }
                        ParameterizedTypeBinding var30 = var1.environment().createParameterizedType(var16, var14, (ReferenceBinding)var7);
                        if (var2) {
                            var30.boundCheck(var1, var11);
                        }
                        var7 = var30;
                    } else {
                        ReferenceBinding var26 = (ReferenceBinding)var10.erasure();
                        if (var3 && ((ClassScope)var1).detectHierarchyCycle(var26, this)) {
                            return null;
                        }
                        if (var26.method_155()) {
                            if (var6 && var7 != null && ((ReferenceBinding)var7).method_162()) {
                                var1.problemReporter().method_1722(this, var1.environment().createParameterizedType(var26, (TypeBinding[])null, (ReferenceBinding)var7));
                                var6 = false;
                            }
                            var7 = var1.environment().createRawType(var26, (ReferenceBinding)var7);
                        } else {
                            var7 = var7 != null && ((ReferenceBinding)var7).method_162() ? var1.environment().createParameterizedType(var26, (TypeBinding[])null, (ReferenceBinding)var7) : var10;
                        }
                    }
                    if (this.isTypeUseDeprecated((TypeBinding)var7, var1)) {
                        this.reportDeprecatedType((TypeBinding)var7, var1);
                    }
                    this.resolvedType = (TypeBinding)var7;
                }
                if (this.dimensions > 0) {
                    if (this.dimensions > 255) {
                        var1.problemReporter().method_1768(this);
                    }
                    this.resolvedType = var1.createArrayType(this.resolvedType, this.dimensions);
                }
                return this.resolvedType;
            }
        }
    }

    public StringBuffer printExpression(int var1, StringBuffer var2) {
        int var3 = this.tokens.length;
        int var6;
        for (int var4 = 0; var4 < var3 - 1; ++var4) {
            var2.append(this.tokens[var4]);
            TypeReference[] var5 = this.typeArguments[var4];
            if (var5 != null) {
                var2.append('<');
                var6 = var5.length - 1;
                for (int var7 = 0; var7 < var6; ++var7) {
                    var5[var7].print(0, var2);
                    var2.append(", ");
                }
                var5[var6].print(0, var2);
                var2.append('>');
            }
            var2.append('.');
        }
        var2.append(this.tokens[var3 - 1]);
        TypeReference[] var8 = this.typeArguments[var3 - 1];
        int var9;
        if (var8 != null) {
            var2.append('<');
            var9 = var8.length - 1;
            for (var6 = 0; var6 < var9; ++var6) {
                var8[var6].print(0, var2);
                var2.append(", ");
            }
            var8[var9].print(0, var2);
            var2.append('>');
        }
        if ((this.field_446 & 16384) != 0) {
            for (var9 = 0; var9 < this.dimensions - 1; ++var9) {
                var2.append("[]");
            }
            var2.append("...");
        } else {
            for (var9 = 0; var9 < this.dimensions; ++var9) {
                var2.append("[]");
            }
        }
        return var2;
    }

    public TypeBinding resolveType(BlockScope var1, boolean var2) {
        return this.internalResolveType(var1, var2);
    }

    public TypeBinding resolveType(ClassScope var1) {
        return this.internalResolveType(var1, false);
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        if (var1.visit(this, var2)) {
            int var3 = 0;
            for (int var4 = this.typeArguments.length; var3 < var4; ++var3) {
                if (this.typeArguments[var3] != null) {
                    int var5 = 0;
                    for (int var6 = this.typeArguments[var3].length; var5 < var6; ++var5) {
                        this.typeArguments[var3][var5].traverse(var1, var2);
                    }
                }
            }
        }
        var1.endVisit(this, var2);
    }

    public void traverse(ASTVisitor var1, ClassScope var2) {
        if (var1.visit(this, var2)) {
            int var3 = 0;
            for (int var4 = this.typeArguments.length; var3 < var4; ++var3) {
                if (this.typeArguments[var3] != null) {
                    int var5 = 0;
                    for (int var6 = this.typeArguments[var3].length; var5 < var6; ++var5) {
                        this.typeArguments[var3][var5].traverse(var1, var2);
                    }
                }
            }
        }
        var1.endVisit(this, var2);
    }
}
