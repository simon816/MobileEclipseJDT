package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;

public class InferenceContext {

    private TypeBinding[][][] collectedSubstitutes;

    MethodBinding genericMethod;

    int field_1828;

    int field_1829;

    TypeBinding expectedType;

    boolean hasExplicitExpectedType;

    TypeBinding[] substitutes;

    public InferenceContext(MethodBinding var1) {
        this.genericMethod = var1;
        TypeVariableBinding[] var2 = var1.typeVariables;
        int var3 = var2.length;
        this.collectedSubstitutes = new TypeBinding[var3][3][];
        this.substitutes = new TypeBinding[var3];
    }

    public boolean method_3203() {
        if (this.field_1828 > 0) {
            return false;
        } else {
            this.field_1829 = 2;
            return true;
        }
    }

    public TypeBinding[] getSubstitutes(TypeVariableBinding var1, int var2) {
        return this.collectedSubstitutes[var1.rank][var2];
    }

    public boolean method_3205() {
        int var1 = 0;
        for (int var2 = this.substitutes.length; var1 < var2; ++var1) {
            if (this.substitutes[var1] == null) {
                return true;
            }
        }
        return false;
    }

    public void recordSubstitute(TypeVariableBinding var1, TypeBinding var2, int var3) {
        TypeBinding[][] var4 = this.collectedSubstitutes[var1.rank];
        TypeBinding[] var5 = var4[var3];
        int var6;
        if (var5 == null) {
            var6 = 0;
            var5 = new TypeBinding[1];
        } else {
            var6 = var5.length;
            for (int var7 = 0; var7 < var6; ++var7) {
                TypeBinding var8 = var5[var7];
                if (var8 == var2) {
                    return;
                }
                if (var8 == null) {
                    var5[var7] = var2;
                    return;
                }
            }
            System.arraycopy(var5, 0, var5 = new TypeBinding[var6 + 1], 0, var6);
        }
        var5[var6] = var2;
        var4[var3] = var5;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer(20);
        var1.append("InferenceContex for ");
        int var2 = 0;
        int var3;
        for (var3 = this.genericMethod.typeVariables.length; var2 < var3; ++var2) {
            var1.append(this.genericMethod.typeVariables[var2]);
        }
        var1.append(this.genericMethod);
        var1.append("\n\t[status=");
        switch (this.field_1829) {
            case 0:
                var1.append("ok]");
                break;
            case 1:
                var1.append("failed]");
                break;
            case 2:
                var1.append("raw-subst]");
        }
        if (this.expectedType == null) {
            var1.append(" [expectedType=null]");
        } else {
            var1.append(" [expectedType=").append(this.expectedType.shortReadableName()).append(']');
        }
        var1.append(" [depth=").append(this.field_1828).append(']');
        var1.append("\n\t[collected={");
        var2 = 0;
        for (var3 = this.collectedSubstitutes == null ? 0 : this.collectedSubstitutes.length; var2 < var3; ++var2) {
            TypeBinding[][] var4 = this.collectedSubstitutes[var2];
            for (int var5 = 0; var5 <= 2; ++var5) {
                TypeBinding[] var6 = var4[var5];
                if (var6 != null) {
                    int var7 = 0;
                    for (int var8 = var6.length; var7 < var8; ++var7) {
                        var1.append("\n\t\t").append(this.genericMethod.typeVariables[var2].sourceName);
                        switch (var5) {
                            case 0:
                                var1.append("=");
                                break;
                            case 1:
                                var1.append("<:");
                                break;
                            case 2:
                                var1.append(">:");
                        }
                        if (var6[var7] != null) {
                            var1.append(var6[var7].shortReadableName());
                        }
                    }
                }
            }
        }
        var1.append("}]");
        var1.append("\n\t[inferred=");
        var2 = 0;
        var3 = 0;
        for (int var9 = this.substitutes == null ? 0 : this.substitutes.length; var3 < var9; ++var3) {
            if (this.substitutes[var3] != null) {
                ++var2;
                var1.append('{').append(this.genericMethod.typeVariables[var3].sourceName);
                var1.append("=").append(this.substitutes[var3].shortReadableName()).append('}');
            }
        }
        if (var2 == 0) {
            var1.append("{}");
        }
        var1.append(']');
        return var1.toString();
    }
}
