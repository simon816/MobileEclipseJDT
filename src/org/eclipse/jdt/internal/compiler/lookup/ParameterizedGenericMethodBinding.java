package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.lookup.InvocationSite;
import org.eclipse.jdt.internal.compiler.lookup.Substitution;
import org.eclipse.jdt.internal.compiler.lookup.InferenceContext;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ArrayBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.RawTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.ProblemMethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.ParameterizedMethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;
import org.eclipse.jdt.internal.compiler.lookup.Scope;

public class ParameterizedGenericMethodBinding extends ParameterizedMethodBinding implements Substitution {

    public TypeBinding[] typeArguments;

    private LookupEnvironment environment;

    public boolean field_295;

    public boolean field_296;

    public boolean field_297;

    private MethodBinding tiebreakMethod;

    public boolean field_299;

    public static MethodBinding computeCompatibleMethod(MethodBinding var0, TypeBinding[] var1, Scope var2, InvocationSite var3) {
        TypeVariableBinding[] var5 = var0.typeVariables;
        TypeBinding[] var6 = var3.genericTypeArguments();
        ParameterizedGenericMethodBinding var4;
        ProblemMethodBinding var10000;
        if (var6 != null) {
            if (var6.length != var5.length) {
                var10000 = new ProblemMethodBinding(var0, var0.selector, var6, 11);
                return var10000;
            }
            var4 = var2.environment().createParameterizedGenericMethod(var0, var6);
        } else {
            TypeBinding[] var7 = var0.parameters;
            InferenceContext var13 = new InferenceContext(var0);
            InferenceContext var8 = var13;
            var4 = inferFromArgumentTypes(var2, var0, var1, var7, var8);
            if (var4 == null) {
                return null;
            }
            if (var8.method_3205()) {
                if (var4.returnType != TypeBinding.field_188) {
                    Object var9 = null;
                    if (var3 instanceof MessageSend) {
                        MessageSend var10 = (MessageSend)var3;
                        var9 = var10.field_778;
                    }
                    if (var9 != null) {
                        var8.hasExplicitExpectedType = true;
                    } else {
                        var9 = var2.method_609();
                    }
                    var8.expectedType = (TypeBinding)var9;
                }
                var4 = var4.inferFromExpectedType(var2, var8);
                if (var4 == null) {
                    return null;
                }
            }
        }
        if (!var4.field_297) {
            int var14 = 0;
            int var15 = var5.length;
            while (var14 < var15) {
                TypeVariableBinding var17 = var5[var14];
                TypeBinding var16 = var4.typeArguments[var14];
                switch (var17.boundCheck(var4, var16)) {
                    case 1:
                        var4.field_299 = true;
                    case 2:
                        int var11 = var1.length;
                        TypeBinding[] var12 = new TypeBinding[var11 + 2];
                        System.arraycopy(var1, 0, var12, 0, var11);
                        var12[var11] = var16;
                        var12[var11 + 1] = var17;
                        var10000 = new ProblemMethodBinding(var4, var0.selector, var12, 10);
                        return var10000;
                    default:
                        ++var14;
                }
            }
        }
        return var4;
    }

    private static ParameterizedGenericMethodBinding inferFromArgumentTypes(Scope var0, MethodBinding var1, TypeBinding[] var2, TypeBinding[] var3, InferenceContext var4) {
        int var5;
        int var6;
        int var8;
        if (var1.method_374()) {
            var5 = var3.length;
            var6 = var5 - 1;
            int var7 = var2.length;
            for (var8 = 0; var8 < var6; ++var8) {
                var3[var8].collectSubstitutes(var0, var2[var8], var4, 1);
                if (var4.field_1829 == 1) {
                    return null;
                }
            }
            if (var6 < var7) {
                TypeBinding var14;
                label84: {
                    var14 = var3[var6];
                    TypeBinding var9 = var2[var6];
                    if (var5 == var7) {
                        if (var9 == TypeBinding.field_187) {
                            break label84;
                        }
                        switch (var9.method_136()) {
                            case 0:
                                break;
                            case 1:
                                if (!var9.method_173().method_148()) {
                                    break label84;
                                }
                                break;
                            default:
                                break label84;
                        }
                    }
                    var14 = ((ArrayBinding)var14).method_187();
                }
                for (int var10 = var6; var10 < var7; ++var10) {
                    var14.collectSubstitutes(var0, var2[var10], var4, 1);
                    if (var4.field_1829 == 1) {
                        return null;
                    }
                }
            }
        } else {
            var5 = var3.length;
            for (var6 = 0; var6 < var5; ++var6) {
                var3[var6].collectSubstitutes(var0, var2[var6], var4, 1);
                if (var4.field_1829 == 1) {
                    return null;
                }
            }
        }
        if (var4.field_1829 == 2) {
            return var0.environment().createParameterizedGenericMethod(var1, (RawTypeBinding)null);
        } else {
            TypeVariableBinding[] var11 = var1.typeVariables;
            if (!resolveSubstituteConstraints(var0, var11, var4, false)) {
                return null;
            } else {
                TypeBinding[] var13 = var4.substitutes;
                TypeBinding[] var12 = var13;
                var8 = 0;
                for (int var15 = var11.length; var8 < var15; ++var8) {
                    if (var13[var8] == null) {
                        if (var12 == var13) {
                            System.arraycopy(var13, 0, var12 = new TypeBinding[var15], 0, var8);
                        }
                        var12[var8] = var11[var8];
                    } else if (var12 != var13) {
                        var12[var8] = var13[var8];
                    }
                }
                ParameterizedGenericMethodBinding var16 = var0.environment().createParameterizedGenericMethod(var1, var12);
                return var16;
            }
        }
    }

    private static boolean resolveSubstituteConstraints(Scope var0, TypeVariableBinding[] var1, InferenceContext var2, boolean var3) {
        TypeBinding[] var4 = var2.substitutes;
        int var5 = var1.length;
        int var6;
        TypeVariableBinding var7;
        TypeBinding var8;
        TypeBinding[] var9;
        label98:
        for (var6 = 0; var6 < var5; ++var6) {
            var7 = var1[var6];
            var8 = var4[var6];
            if (var8 == null) {
                var9 = var2.getSubstitutes(var7, 0);
                if (var9 != null) {
                    int var10 = 0;
                    for (int var11 = var9.length; var10 < var11; ++var10) {
                        TypeBinding var12 = var9[var10];
                        if (var12 != null) {
                            if (var12 == var7) {
                                for (int var13 = var10 + 1; var13 < var11; ++var13) {
                                    var12 = var9[var13];
                                    if (var12 != var7 && var12 != null) {
                                        var4[var6] = var12;
                                        continue label98;
                                    }
                                }
                                var4[var6] = var7;
                                break;
                            }
                            var4[var6] = var12;
                            break;
                        }
                    }
                }
            }
        }
        if (var2.method_3205()) {
            for (var6 = 0; var6 < var5; ++var6) {
                var7 = var1[var6];
                var8 = var4[var6];
                if (var8 == null) {
                    var9 = var2.getSubstitutes(var7, 2);
                    if (var9 != null) {
                        TypeBinding var16 = var0.lowerUpperBound(var9);
                        if (var16 == null) {
                            return false;
                        }
                        if (var16 != TypeBinding.field_188) {
                            var4[var6] = var16;
                        }
                    }
                }
            }
        }
        if (var3 && var2.method_3205()) {
            for (var6 = 0; var6 < var5; ++var6) {
                var7 = var1[var6];
                var8 = var4[var6];
                if (var8 == null) {
                    var9 = var2.getSubstitutes(var7, 1);
                    if (var9 != null) {
                        TypeBinding[] var14 = Scope.greaterLowerBound(var9);
                        TypeBinding var15 = null;
                        if (var14 != null) {
                            var15 = var14[0];
                        }
                        if (var15 != null) {
                            var4[var6] = var15;
                        }
                    }
                }
            }
        }
        return true;
    }

    public ParameterizedGenericMethodBinding(MethodBinding var1, RawTypeBinding var2, LookupEnvironment var3) {
        TypeVariableBinding[] var4 = var1.typeVariables;
        int var5 = var4.length;
        TypeBinding[] var6 = new TypeBinding[var5];
        for (int var7 = 0; var7 < var5; ++var7) {
            var6[var7] = var3.convertToRawType(var4[var7].erasure(), false);
        }
        this.field_297 = true;
        this.tagBits = var1.tagBits;
        this.environment = var3;
        this.modifiers = var1.modifiers;
        this.selector = var1.selector;
        this.declaringClass = (ReferenceBinding)(var2 == null ? var1.declaringClass : var2);
        this.typeVariables = Binding.NO_TYPE_VARIABLES;
        this.typeArguments = var6;
        this.originalMethod = var1;
        boolean var8 = var2 == null || var1.method_370();
        this.parameters = Scope.substitute(this, var8 ? var1.parameters : Scope.substitute(var2, var1.parameters));
        this.thrownExceptions = Scope.substitute(this, var8 ? var1.thrownExceptions : Scope.substitute(var2, var1.thrownExceptions));
        if (this.thrownExceptions == null) {
            this.thrownExceptions = Binding.field_151;
        }
        this.returnType = Scope.substitute(this, var8 ? var1.returnType : Scope.substitute(var2, var1.returnType));
        this.field_296 = false;
    }

    public ParameterizedGenericMethodBinding(MethodBinding var1, TypeBinding[] var2, LookupEnvironment var3) {
        this.environment = var3;
        this.modifiers = var1.modifiers;
        this.selector = var1.selector;
        this.declaringClass = var1.declaringClass;
        this.typeVariables = Binding.NO_TYPE_VARIABLES;
        this.typeArguments = var2;
        this.field_297 = false;
        this.tagBits = var1.tagBits;
        this.originalMethod = var1;
        this.parameters = Scope.substitute(this, var1.parameters);
        this.thrownExceptions = Scope.substitute(this, var1.thrownExceptions);
        if (this.thrownExceptions == null) {
            this.thrownExceptions = Binding.field_151;
        }
        this.returnType = Scope.substitute(this, var1.returnType);
        if ((this.tagBits & 128L) == 0L) {
            if ((this.returnType.tagBits & 128L) != 0L) {
                this.tagBits |= 128L;
            } else {
                int var4 = 0;
                int var5 = this.parameters.length;
                label34:
                while (true) {
                    if (var4 >= var5) {
                        var4 = 0;
                        var5 = this.thrownExceptions.length;
                        while (true) {
                            if (var4 >= var5) {
                                break label34;
                            }
                            if ((this.thrownExceptions[var4].tagBits & 128L) != 0L) {
                                this.tagBits |= 128L;
                                break label34;
                            }
                            ++var4;
                        }
                    }
                    if ((this.parameters[var4].tagBits & 128L) != 0L) {
                        this.tagBits |= 128L;
                        break;
                    }
                    ++var4;
                }
            }
        }
        this.field_296 = true;
    }

    public LookupEnvironment environment() {
        return this.environment;
    }

    public boolean method_354() {
        return this.field_296 ? this.originalMethod.method_354() : super.method_354();
    }

    public boolean method_355() {
        return this.field_295 ? this.originalMethod.method_355() : super.method_355();
    }

    private ParameterizedGenericMethodBinding inferFromExpectedType(Scope var1, InferenceContext var2) {
        TypeVariableBinding[] var3 = this.originalMethod.typeVariables;
        int var4 = var3.length;
        if (var2.expectedType != null) {
            this.returnType.collectSubstitutes(var1, var2.expectedType, var2, 2);
            if (var2.field_1829 == 1) {
                return null;
            }
        }
        int var5;
        for (var5 = 0; var5 < var4; ++var5) {
            TypeVariableBinding var6 = var3[var5];
            TypeBinding var7 = this.typeArguments[var5];
            boolean var8 = var7 != var6;
            if (var6.firstBound == var6.superclass) {
                TypeBinding var9 = Scope.substitute(this, var6.superclass);
                var7.collectSubstitutes(var1, var9, var2, 2);
                if (var2.field_1829 == 1) {
                    return null;
                }
                if (var8) {
                    var9.collectSubstitutes(var1, var7, var2, 1);
                    if (var2.field_1829 == 1) {
                        return null;
                    }
                }
            }
            int var16 = 0;
            for (int var10 = var6.superInterfaces.length; var16 < var10; ++var16) {
                TypeBinding var11 = Scope.substitute(this, var6.superInterfaces[var16]);
                var7.collectSubstitutes(var1, var11, var2, 2);
                if (var2.field_1829 == 1) {
                    return null;
                }
                if (var8) {
                    var11.collectSubstitutes(var1, var7, var2, 1);
                    if (var2.field_1829 == 1) {
                        return null;
                    }
                }
            }
        }
        if (var2.field_1829 == 2) {
            this.field_297 = true;
            this.field_299 = false;
            for (var5 = 0; var5 < var4; ++var5) {
                this.typeArguments[var5] = var3[var5].method_261();
            }
        } else {
            if (!resolveSubstituteConstraints(var1, var3, var2, true)) {
                return null;
            }
            for (var5 = 0; var5 < var4; ++var5) {
                TypeBinding var13 = var2.substitutes[var5];
                if (var13 != null) {
                    this.typeArguments[var5] = var2.substitutes[var5];
                } else {
                    this.typeArguments[var5] = var3[var5].method_261();
                }
            }
        }
        this.typeArguments = Scope.substitute(this, this.typeArguments);
        TypeBinding var15 = this.returnType;
        this.returnType = Scope.substitute(this, this.returnType);
        this.field_295 = var2.hasExplicitExpectedType && this.returnType != var15;
        this.parameters = Scope.substitute(this, this.parameters);
        this.thrownExceptions = Scope.substitute(this, this.thrownExceptions);
        if (this.thrownExceptions == null) {
            this.thrownExceptions = Binding.field_151;
        }
        if ((this.tagBits & 128L) == 0L) {
            if ((this.returnType.tagBits & 128L) != 0L) {
                this.tagBits |= 128L;
            } else {
                int var12 = 0;
                int var14 = this.parameters.length;
                while (true) {
                    if (var12 >= var14) {
                        var12 = 0;
                        for (var14 = this.thrownExceptions.length; var12 < var14; ++var12) {
                            if ((this.thrownExceptions[var12].tagBits & 128L) != 0L) {
                                this.tagBits |= 128L;
                                return this;
                            }
                        }
                        return this;
                    }
                    if ((this.parameters[var12].tagBits & 128L) != 0L) {
                        this.tagBits |= 128L;
                        break;
                    }
                    ++var12;
                }
            }
        }
        return this;
    }

    public boolean isRawSubstitution() {
        return this.field_297;
    }

    public TypeBinding substitute(TypeVariableBinding var1) {
        TypeVariableBinding[] var2 = this.originalMethod.typeVariables;
        int var3 = var2.length;
        return (TypeBinding)(var1.rank < var3 && var2[var1.rank] == var1 ? this.typeArguments[var1.rank] : var1);
    }

    public MethodBinding tiebreakMethod() {
        if (this.tiebreakMethod == null) {
            TypeVariableBinding[] var1 = this.originalMethod.typeVariables;
            int var2 = var1.length;
            TypeBinding[] var3 = new TypeBinding[var2];
            for (int var4 = 0; var4 < var2; ++var4) {
                TypeVariableBinding var5 = var1[var4];
                if (var5.method_257() <= 1) {
                    var3[var4] = this.environment.convertToRawType(var5.method_261(), false);
                } else {
                    var3[var4] = this.environment.convertToRawType(this.environment.createWildcard((ReferenceBinding)null, 0, var5.superclass(), var5.superInterfaces(), 1), false);
                }
            }
            this.tiebreakMethod = this.environment.createParameterizedGenericMethod(this.originalMethod, var3);
        }
        return this.tiebreakMethod;
    }
}
