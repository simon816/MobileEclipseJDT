package org.eclipse.jdt.internal.compiler.lookup;

import java.util.List;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.InferenceContext;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.UnresolvedReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.CaptureBinding;
import org.eclipse.jdt.internal.compiler.lookup.BinaryTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ParameterizedTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;
import org.eclipse.jdt.internal.compiler.lookup.Scope;

public class WildcardBinding extends ReferenceBinding {

    ReferenceBinding field_210;

    int field_211;

    public TypeBinding bound;

    public TypeBinding[] otherBounds;

    char[] genericSignature;

    public int field_215;

    ReferenceBinding field_216;

    ReferenceBinding[] superInterfaces;

    TypeVariableBinding typeVariable;

    LookupEnvironment environment;

    public WildcardBinding(ReferenceBinding var1, int var2, TypeBinding var3, TypeBinding[] var4, int var5, LookupEnvironment var6) {
        this.field_211 = var2;
        this.field_215 = var5;
        this.modifiers = 1073741825;
        this.environment = var6;
        this.initialize(var1, var3, var4);
        if (var1 instanceof UnresolvedReferenceBinding) {
            ((UnresolvedReferenceBinding)var1).addWrapper(this, var6);
        }
        if (var3 instanceof UnresolvedReferenceBinding) {
            ((UnresolvedReferenceBinding)var3).addWrapper(this, var6);
        }
        this.tagBits |= 16777216L;
    }

    public int kind() {
        return this.otherBounds == null ? 516 : 8196;
    }

    public boolean boundCheck(TypeBinding var1) {
        switch (this.field_215) {
            case 0:
                return true;
            case 1:
                if (var1.isCompatibleWith(this.bound)) {
                    return true;
                } else {
                    int var2 = 0;
                    for (int var3 = this.otherBounds == null ? 0 : this.otherBounds.length; var2 < var3; ++var2) {
                        if (var1.isCompatibleWith(this.otherBounds[var2])) {
                            return true;
                        }
                    }
                    return false;
                }
            default:
                return var1.isCompatibleWith(this.bound);
        }
    }

    public boolean method_129() {
        return false;
    }

    public List method_132(List var1) {
        if ((this.tagBits & 128L) != 0L) {
            var1 = this.bound.method_132(var1);
        }
        return var1;
    }

    public void collectSubstitutes(Scope var1, TypeBinding var2, InferenceContext var3, int var4) {
        if ((this.tagBits & 536870912L) != 0L) {
            if (var2 != TypeBinding.field_187) {
                if (((TypeBinding)var2).isCapture()) {
                    CaptureBinding var5 = (CaptureBinding)var2;
                    var2 = var5.wildcard;
                }
                int var6;
                int var7;
                int var8;
                WildcardBinding var9;
                WildcardBinding var10;
                label205:
                switch (var4) {
                    case 0:
                        switch (this.field_215) {
                            case 0:
                            default:
                                return;
                            case 1:
                                switch (((TypeBinding)var2).kind()) {
                                    case 516:
                                        var9 = (WildcardBinding)var2;
                                        switch (var9.field_215) {
                                            case 0:
                                            case 2:
                                            default:
                                                return;
                                            case 1:
                                                this.bound.collectSubstitutes(var1, var9.bound, var3, 0);
                                                var6 = 0;
                                                for (var7 = var9.otherBounds == null ? 0 : var9.otherBounds.length; var6 < var7; ++var6) {
                                                    this.bound.collectSubstitutes(var1, var9.otherBounds[var6], var3, 0);
                                                }
                                                return;
                                        }
                                    case 8196:
                                        var10 = (WildcardBinding)var2;
                                        this.bound.collectSubstitutes(var1, var10.bound, var3, 0);
                                        var7 = 0;
                                        for (var8 = var10.otherBounds == null ? 0 : var10.otherBounds.length; var7 < var8; ++var7) {
                                            this.bound.collectSubstitutes(var1, var10.otherBounds[var7], var3, 0);
                                        }
                                        break label205;
                                    default:
                                        return;
                                }
                            case 2:
                                switch (((TypeBinding)var2).kind()) {
                                    case 516:
                                        var9 = (WildcardBinding)var2;
                                        switch (var9.field_215) {
                                            case 0:
                                            case 1:
                                            default:
                                                return;
                                            case 2:
                                                this.bound.collectSubstitutes(var1, var9.bound, var3, 0);
                                                var6 = 0;
                                                for (var7 = var9.otherBounds == null ? 0 : var9.otherBounds.length; var6 < var7; ++var6) {
                                                    this.bound.collectSubstitutes(var1, var9.otherBounds[var6], var3, 0);
                                                }
                                                break label205;
                                        }
                                    case 8196:
                                    default:
                                        return;
                                }
                        }
                    case 1:
                        switch (this.field_215) {
                            case 0:
                            default:
                                return;
                            case 1:
                                switch (((TypeBinding)var2).kind()) {
                                    case 516:
                                        var9 = (WildcardBinding)var2;
                                        switch (var9.field_215) {
                                            case 0:
                                            case 2:
                                            default:
                                                return;
                                            case 1:
                                                this.bound.collectSubstitutes(var1, var9.bound, var3, 1);
                                                return;
                                        }
                                    case 8196:
                                        var10 = (WildcardBinding)var2;
                                        this.bound.collectSubstitutes(var1, var10.bound, var3, 1);
                                        var7 = 0;
                                        for (var8 = var10.otherBounds.length; var7 < var8; ++var7) {
                                            this.bound.collectSubstitutes(var1, var10.otherBounds[var7], var3, 1);
                                        }
                                        return;
                                    default:
                                        this.bound.collectSubstitutes(var1, (TypeBinding)var2, var3, 1);
                                        return;
                                }
                            case 2:
                                switch (((TypeBinding)var2).kind()) {
                                    case 516:
                                        var9 = (WildcardBinding)var2;
                                        switch (var9.field_215) {
                                            case 0:
                                            case 1:
                                            default:
                                                return;
                                            case 2:
                                                this.bound.collectSubstitutes(var1, var9.bound, var3, 2);
                                                var6 = 0;
                                                for (var7 = var9.otherBounds == null ? 0 : var9.otherBounds.length; var6 < var7; ++var6) {
                                                    this.bound.collectSubstitutes(var1, var9.otherBounds[var6], var3, 2);
                                                }
                                                break label205;
                                        }
                                    case 8196:
                                        return;
                                    default:
                                        this.bound.collectSubstitutes(var1, (TypeBinding)var2, var3, 2);
                                        return;
                                }
                        }
                    case 2:
                        label152:
                        switch (this.field_215) {
                            case 0:
                            default:
                                break;
                            case 1:
                                switch (((TypeBinding)var2).kind()) {
                                    case 516:
                                        var9 = (WildcardBinding)var2;
                                        switch (var9.field_215) {
                                            case 0:
                                            case 2:
                                            default:
                                                return;
                                            case 1:
                                                this.bound.collectSubstitutes(var1, var9.bound, var3, 2);
                                                var6 = 0;
                                                for (var7 = var9.otherBounds == null ? 0 : var9.otherBounds.length; var6 < var7; ++var6) {
                                                    this.bound.collectSubstitutes(var1, var9.otherBounds[var6], var3, 2);
                                                }
                                                return;
                                        }
                                    case 8196:
                                        var10 = (WildcardBinding)var2;
                                        this.bound.collectSubstitutes(var1, var10.bound, var3, 2);
                                        var7 = 0;
                                        for (var8 = var10.otherBounds == null ? 0 : var10.otherBounds.length; var7 < var8; ++var7) {
                                            this.bound.collectSubstitutes(var1, var10.otherBounds[var7], var3, 2);
                                        }
                                        break label152;
                                    default:
                                        return;
                                }
                            case 2:
                                switch (((TypeBinding)var2).kind()) {
                                    case 516:
                                        var9 = (WildcardBinding)var2;
                                        switch (var9.field_215) {
                                            case 0:
                                            case 1:
                                            default:
                                                break;
                                            case 2:
                                                this.bound.collectSubstitutes(var1, var9.bound, var3, 2);
                                                var6 = 0;
                                                for (var7 = var9.otherBounds == null ? 0 : var9.otherBounds.length; var6 < var7; ++var6) {
                                                    this.bound.collectSubstitutes(var1, var9.otherBounds[var6], var3, 2);
                                                }
                                        }
                                    case 8196:
                                }
                        }
                }
            }
        }
    }

    public char[] constantPoolName() {
        return this.erasure().constantPoolName();
    }

    public String debugName() {
        return this.toString();
    }

    public TypeBinding erasure() {
        return this.otherBounds == null ? (this.field_215 == 1 ? this.bound.erasure() : this.typeVariable().erasure()) : (this.bound.id == 1 ? this.otherBounds[0].erasure() : this.bound.erasure());
    }

    public char[] genericTypeSignature() {
        if (this.genericSignature == null) {
            switch (this.field_215) {
                case 0:
                    this.genericSignature = TypeConstants.field_55;
                    break;
                case 1:
                    this.genericSignature = CharOperation.concat(TypeConstants.field_56, this.bound.genericTypeSignature());
                    break;
                default:
                    this.genericSignature = CharOperation.concat(TypeConstants.field_54, this.bound.genericTypeSignature());
            }
        }
        return this.genericSignature;
    }

    public int hashCode() {
        return this.field_210.hashCode();
    }

    void initialize(ReferenceBinding var1, TypeBinding var2, TypeBinding[] var3) {
        this.field_210 = var1;
        this.bound = var2;
        this.otherBounds = var3;
        if (var1 != null) {
            this.fPackage = var1.getPackage();
        }
        if (var2 != null) {
            this.tagBits |= var2.tagBits & 536871040L;
        }
    }

    public boolean isSuperclassOf(ReferenceBinding var1) {
        return this.field_215 == 2 ? (this.bound instanceof ReferenceBinding ? ((ReferenceBinding)this.bound).isSuperclassOf(var1) : var1.id == 1) : false;
    }

    public boolean method_170() {
        return this.field_215 == 0;
    }

    public boolean method_172() {
        return true;
    }

    public char[] readableName() {
        switch (this.field_215) {
            case 0:
                return TypeConstants.field_51;
            case 1:
                if (this.otherBounds == null) {
                    return CharOperation.method_1356(TypeConstants.field_51, TypeConstants.field_53, this.bound.readableName());
                }
                StringBuffer var1 = new StringBuffer(10);
                var1.append(this.bound.readableName());
                int var2 = 0;
                for (int var3 = this.otherBounds.length; var2 < var3; ++var2) {
                    var1.append('&').append(this.otherBounds[var2].readableName());
                }
                char[] var4 = new char[var2 = var1.length()];
                var1.getChars(0, var2, var4, 0);
                return var4;
            default:
                return CharOperation.method_1356(TypeConstants.field_51, TypeConstants.field_52, this.bound.readableName());
        }
    }

    ReferenceBinding resolve() {
        if ((this.tagBits & 16777216L) == 0L) {
            return this;
        } else {
            this.tagBits &= -16777217L;
            BinaryTypeBinding.method_268(this.field_210, this.environment, (ParameterizedTypeBinding)null, 0);
            switch (this.field_215) {
                case 0:
                default:
                    break;
                case 1:
                    this.bound = BinaryTypeBinding.method_268(this.bound, this.environment, (ParameterizedTypeBinding)null, 0);
                    int var1 = 0;
                    for (int var2 = this.otherBounds == null ? 0 : this.otherBounds.length; var1 < var2; ++var1) {
                        this.otherBounds[var1] = BinaryTypeBinding.method_268(this.bound, this.environment, (ParameterizedTypeBinding)null, 0);
                    }
                    return this;
                case 2:
                    this.bound = BinaryTypeBinding.method_268(this.bound, this.environment, (ParameterizedTypeBinding)null, 0);
            }
            return this;
        }
    }

    public char[] shortReadableName() {
        switch (this.field_215) {
            case 0:
                return TypeConstants.field_51;
            case 1:
                if (this.otherBounds == null) {
                    return CharOperation.method_1356(TypeConstants.field_51, TypeConstants.field_53, this.bound.shortReadableName());
                }
                StringBuffer var1 = new StringBuffer(10);
                var1.append(this.bound.shortReadableName());
                int var2 = 0;
                for (int var3 = this.otherBounds.length; var2 < var3; ++var2) {
                    var1.append('&').append(this.otherBounds[var2].shortReadableName());
                }
                char[] var4 = new char[var2 = var1.length()];
                var1.getChars(0, var2, var4, 0);
                return var4;
            default:
                return CharOperation.method_1356(TypeConstants.field_51, TypeConstants.field_52, this.bound.shortReadableName());
        }
    }

    public char[] method_178() {
        if (this.field_203 == null) {
            switch (this.field_215) {
                case 1:
                    return this.bound.method_178();
                default:
                    return this.typeVariable().method_178();
            }
        } else {
            return this.field_203;
        }
    }

    public char[] method_179() {
        switch (this.field_215) {
            case 0:
                return TypeConstants.field_51;
            case 1:
                return CharOperation.method_1356(TypeConstants.field_51, TypeConstants.field_53, this.bound.method_179());
            default:
                return CharOperation.method_1356(TypeConstants.field_51, TypeConstants.field_52, this.bound.method_179());
        }
    }

    public ReferenceBinding superclass() {
        if (this.field_216 == null) {
            TypeBinding var1 = null;
            if (this.field_215 == 1 && !this.bound.method_157()) {
                var1 = this.bound;
            } else {
                TypeVariableBinding var2 = this.typeVariable();
                if (var2 != null) {
                    var1 = var2.firstBound;
                }
            }
            this.field_216 = var1 instanceof ReferenceBinding && !var1.method_157() ? (ReferenceBinding)var1 : this.environment.getResolvedType(TypeConstants.field_99, (Scope)null);
        }
        return this.field_216;
    }

    public ReferenceBinding[] superInterfaces() {
        if (this.superInterfaces == null) {
            if (this.typeVariable() != null) {
                this.superInterfaces = this.typeVariable.superInterfaces();
            } else {
                this.superInterfaces = Binding.field_155;
            }
            if (this.field_215 == 1) {
                int var1;
                if (this.bound.method_157()) {
                    var1 = this.superInterfaces.length;
                    System.arraycopy(this.superInterfaces, 0, this.superInterfaces = new ReferenceBinding[var1 + 1], 1, var1);
                    this.superInterfaces[0] = (ReferenceBinding)this.bound;
                }
                if (this.otherBounds != null) {
                    var1 = this.superInterfaces.length;
                    int var2 = this.otherBounds.length;
                    System.arraycopy(this.superInterfaces, 0, this.superInterfaces = new ReferenceBinding[var1 + var2], 0, var1);
                    for (int var3 = 0; var3 < var2; ++var3) {
                        this.superInterfaces[var1 + var3] = (ReferenceBinding)this.otherBounds[var3];
                    }
                }
            }
        }
        return this.superInterfaces;
    }

    public void swapUnresolved(UnresolvedReferenceBinding var1, ReferenceBinding var2, LookupEnvironment var3) {
        boolean var4 = false;
        if (this.field_210 == var1) {
            this.field_210 = var2;
            var4 = true;
        }
        if (this.bound == var1) {
            this.bound = var3.method_491(var2);
            var4 = true;
        }
        if (this.otherBounds != null) {
            int var5 = 0;
            for (int var6 = this.otherBounds.length; var5 < var6; ++var5) {
                if (this.otherBounds[var5] == var1) {
                    this.otherBounds[var5] = var3.method_491(var2);
                    var4 = true;
                }
            }
        }
        if (var4) {
            this.initialize(this.field_210, this.bound, this.otherBounds);
        }
    }

    public String toString() {
        switch (this.field_215) {
            case 0:
                return new String(TypeConstants.field_51);
            case 1:
                if (this.otherBounds == null) {
                    return new String(CharOperation.method_1356(TypeConstants.field_51, TypeConstants.field_53, this.bound.debugName().toCharArray()));
                }
                StringBuffer var1 = new StringBuffer(this.bound.debugName());
                int var2 = 0;
                for (int var3 = this.otherBounds.length; var2 < var3; ++var2) {
                    var1.append('&').append(this.otherBounds[var2].debugName());
                }
                return var1.toString();
            default:
                return new String(CharOperation.method_1356(TypeConstants.field_51, TypeConstants.field_52, this.bound.debugName().toCharArray()));
        }
    }

    public TypeVariableBinding typeVariable() {
        if (this.typeVariable == null) {
            TypeVariableBinding[] var1 = this.field_210.typeVariables();
            if (this.field_211 < var1.length) {
                this.typeVariable = var1[this.field_211];
            }
        }
        return this.typeVariable;
    }
}
