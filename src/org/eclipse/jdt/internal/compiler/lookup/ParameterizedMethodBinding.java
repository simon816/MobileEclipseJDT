package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.Substitution;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.ParameterizedTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.ParameterizedMethodBinding$1;

public class ParameterizedMethodBinding extends MethodBinding {

    protected MethodBinding originalMethod;

    public ParameterizedMethodBinding(ParameterizedTypeBinding var1, MethodBinding var2) {
        super(var2.modifiers, var2.selector, var2.returnType, var2.parameters, var2.thrownExceptions, var1);
        this.originalMethod = var2;
        this.tagBits = var2.tagBits;
        TypeVariableBinding[] var3 = var2.typeVariables;
        Object var4 = null;
        int var5 = var3.length;
        boolean var6 = var2.method_370();
        int var8;
        if (var5 == 0) {
            this.typeVariables = Binding.NO_TYPE_VARIABLES;
            if (!var6) {
                var4 = var1;
            }
        } else {
            TypeVariableBinding[] var7 = new TypeVariableBinding[var5];
            TypeVariableBinding var9;
            for (var8 = 0; var8 < var5; ++var8) {
                var9 = var3[var8];
                TypeVariableBinding var10002 = new TypeVariableBinding(var9.sourceName, this, var9.rank);
                var7[var8] = var10002;
            }
            this.typeVariables = var7;
            ParameterizedMethodBinding$1 var10000 = new ParameterizedMethodBinding$1(this, var1, var6, var5, var3, var7);
            var4 = var10000;
            for (var8 = 0; var8 < var5; ++var8) {
                var9 = var3[var8];
                TypeVariableBinding var10 = var7[var8];
                TypeBinding var11 = Scope.substitute((Substitution)var4, var9.superclass);
                ReferenceBinding[] var12 = Scope.substitute((Substitution)var4, var9.superInterfaces);
                if (var9.firstBound != null) {
                    var10.firstBound = (TypeBinding)(var9.firstBound == var9.superclass ? var11 : var12[0]);
                }
                switch (var11.kind()) {
                    case 68:
                        var10.superclass = var1.environment.getResolvedType(TypeConstants.field_99, (Scope)null);
                        var10.superInterfaces = var12;
                        break;
                    default:
                        if (var11.method_157()) {
                            var10.superclass = var1.environment.getResolvedType(TypeConstants.field_99, (Scope)null);
                            int var13 = var12.length;
                            System.arraycopy(var12, 0, var12 = new ReferenceBinding[var13 + 1], 1, var13);
                            var12[0] = (ReferenceBinding)var11;
                            var10.superInterfaces = var12;
                        } else {
                            var10.superclass = (ReferenceBinding)var11;
                            var10.superInterfaces = var12;
                        }
                }
            }
        }
        if (var4 != null) {
            this.returnType = Scope.substitute((Substitution)var4, this.returnType);
            this.parameters = Scope.substitute((Substitution)var4, this.parameters);
            this.thrownExceptions = Scope.substitute((Substitution)var4, this.thrownExceptions);
            if (this.thrownExceptions == null) {
                this.thrownExceptions = Binding.field_151;
            }
        }
        if ((this.tagBits & 128L) == 0L) {
            if ((this.returnType.tagBits & 128L) != 0L) {
                this.tagBits |= 128L;
            } else {
                int var14 = 0;
                var8 = this.parameters.length;
                while (true) {
                    if (var14 >= var8) {
                        var14 = 0;
                        for (var8 = this.thrownExceptions.length; var14 < var8; ++var14) {
                            if ((this.thrownExceptions[var14].tagBits & 128L) != 0L) {
                                this.tagBits |= 128L;
                                return;
                            }
                        }
                        return;
                    }
                    if ((this.parameters[var14].tagBits & 128L) != 0L) {
                        this.tagBits |= 128L;
                        break;
                    }
                    ++var14;
                }
            }
        }
    }

    public ParameterizedMethodBinding() {
    }

    public static ParameterizedMethodBinding instantiateGetClass(TypeBinding var0, MethodBinding var1, Scope var2) {
        ParameterizedMethodBinding var10000 = new ParameterizedMethodBinding();
        ParameterizedMethodBinding var3 = var10000;
        var3.modifiers = var1.modifiers;
        var3.selector = var1.selector;
        var3.declaringClass = var1.declaringClass;
        var3.typeVariables = Binding.NO_TYPE_VARIABLES;
        var3.originalMethod = var1;
        var3.parameters = var1.parameters;
        var3.thrownExceptions = var1.thrownExceptions;
        var3.tagBits = var1.tagBits;
        ReferenceBinding var4 = var2.method_606();
        LookupEnvironment var5 = var2.environment();
        TypeBinding var6 = var5.convertToRawType(var0.erasure(), false);
        var3.returnType = var5.createParameterizedType(var4, new TypeBinding[] {var5.createWildcard(var4, 0, var6, (TypeBinding[])null, 1)}, (ReferenceBinding)null);
        if ((var3.returnType.tagBits & 128L) != 0L) {
            var3.tagBits |= 128L;
        }
        return var3;
    }

    public boolean method_354() {
        return this.parameters != this.originalMethod.parameters;
    }

    public boolean method_355() {
        return this.returnType != this.originalMethod.returnType;
    }

    public MethodBinding original() {
        return this.originalMethod.original();
    }
}
