package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.WildcardBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.ParameterizedTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.ParameterizedMethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;

public class RawTypeBinding extends ParameterizedTypeBinding {

    public RawTypeBinding(ReferenceBinding var1, ReferenceBinding var2, LookupEnvironment var3) {
        super(var1, (TypeBinding[])null, var2, var3);
        if (var2 == null || (var2.modifiers & 1073741824) == 0) {
            this.modifiers &= -1073741825;
        }
    }

    public ParameterizedMethodBinding createParameterizedMethod(MethodBinding var1) {
        return (ParameterizedMethodBinding)(var1.typeVariables != Binding.NO_TYPE_VARIABLES && !var1.method_370() ? this.environment.createParameterizedGenericMethod(var1, this) : super.createParameterizedMethod(var1));
    }

    public int kind() {
        return 1028;
    }

    public String debugName() {
        StringBuffer var1 = new StringBuffer(10);
        var1.append(this.actualType().method_179()).append("#RAW");
        return var1.toString();
    }

    public char[] genericTypeSignature() {
        if (this.genericTypeSignature == null) {
            if ((this.modifiers & 1073741824) == 0) {
                this.genericTypeSignature = this.method_286().method_178();
            } else {
                StringBuffer var1 = new StringBuffer(10);
                if (this.method_159()) {
                    ReferenceBinding var2 = this.enclosingType();
                    char[] var3 = var2.genericTypeSignature();
                    var1.append(var3, 0, var3.length - 1);
                    if ((var2.modifiers & 1073741824) != 0) {
                        var1.append('.');
                    } else {
                        var1.append('$');
                    }
                    var1.append(this.method_179());
                } else {
                    char[] var4 = this.method_286().method_178();
                    var1.append(var4, 0, var4.length - 1);
                }
                var1.append(';');
                int var5 = var1.length();
                this.genericTypeSignature = new char[var5];
                var1.getChars(0, var5, this.genericTypeSignature, 0);
            }
        }
        return this.genericTypeSignature;
    }

    public boolean isEquivalentTo(TypeBinding var1) {
        if (this == var1) {
            return true;
        } else if (var1 == null) {
            return false;
        } else {
            switch (var1.kind()) {
                case 260:
                case 1028:
                case 2052:
                    return this.erasure() == var1.erasure();
                case 516:
                case 8196:
                    return ((WildcardBinding)var1).boundCheck(this);
                default:
                    return false;
            }
        }
    }

    public boolean method_164(TypeBinding var1) {
        if (this == var1) {
            return false;
        } else if (var1 == null) {
            return true;
        } else {
            switch (var1.kind()) {
                case 260:
                case 1028:
                case 2052:
                    return this.erasure() != var1.erasure();
                default:
                    return true;
            }
        }
    }

    public boolean method_162() {
        return false;
    }

    public boolean method_166() {
        return true;
    }

    protected void initializeArguments() {
        TypeVariableBinding[] var1 = this.method_286().typeVariables();
        int var2 = var1.length;
        TypeBinding[] var3 = new TypeBinding[var2];
        for (int var4 = 0; var4 < var2; ++var4) {
            var3[var4] = this.environment.convertToRawType(var1[var4].erasure(), false);
        }
        this.arguments = var3;
    }

    public char[] readableName() {
        char[] var1;
        if (this.method_159()) {
            var1 = CharOperation.concat(this.enclosingType().readableName(), this.sourceName, '.');
        } else {
            var1 = CharOperation.concatWith(this.actualType().compoundName, '.');
        }
        return var1;
    }

    public char[] shortReadableName() {
        char[] var1;
        if (this.method_159()) {
            var1 = CharOperation.concat(this.enclosingType().shortReadableName(), this.sourceName, '.');
        } else {
            var1 = this.actualType().sourceName;
        }
        return var1;
    }
}
