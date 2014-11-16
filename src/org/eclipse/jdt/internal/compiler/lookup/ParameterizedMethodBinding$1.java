package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.lookup.Substitution;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.ParameterizedTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ParameterizedMethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;

class ParameterizedMethodBinding$1 implements Substitution {

    private final ParameterizedTypeBinding field_414;

    private final boolean field_415;

    private final int field_416;

    private final TypeVariableBinding[] field_417;

    private final TypeVariableBinding[] field_418;

    private final ParameterizedMethodBinding field_419;

    ParameterizedMethodBinding$1(ParameterizedMethodBinding var1, ParameterizedTypeBinding var2, boolean var3, int var4, TypeVariableBinding[] var5, TypeVariableBinding[] var6) {
        this.field_419 = var1;
        this.field_414 = var2;
        this.field_415 = var3;
        this.field_416 = var4;
        this.field_417 = var5;
        this.field_418 = var6;
    }

    public LookupEnvironment environment() {
        return this.field_414.environment;
    }

    public boolean isRawSubstitution() {
        return !this.field_415 && this.field_414.isRawSubstitution();
    }

    public TypeBinding substitute(TypeVariableBinding var1) {
        return (TypeBinding)(var1.rank < this.field_416 && this.field_417[var1.rank] == var1 ? this.field_418[var1.rank] : (!this.field_415 ? this.field_414.substitute(var1) : var1));
    }
}
