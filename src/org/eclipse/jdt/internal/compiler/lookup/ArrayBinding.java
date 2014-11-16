package org.eclipse.jdt.internal.compiler.lookup;

import java.util.List;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.InferenceContext;
import org.eclipse.jdt.internal.compiler.lookup.PackageBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.UnresolvedReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.WildcardBinding;
import org.eclipse.jdt.internal.compiler.lookup.CaptureBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;
import org.eclipse.jdt.internal.compiler.lookup.Scope;

public final class ArrayBinding extends TypeBinding {

    public static final FieldBinding ArrayLength;

    public TypeBinding leafComponentType;

    public int dimensions;

    LookupEnvironment environment;

    char[] field_195;

    char[] field_196;

    public ArrayBinding(TypeBinding var1, int var2, LookupEnvironment var3) {
        this.tagBits |= 1L;
        this.leafComponentType = var1;
        this.dimensions = var2;
        this.environment = var3;
        if (var1 instanceof UnresolvedReferenceBinding) {
            ((UnresolvedReferenceBinding)var1).addWrapper(this, var3);
        } else {
            this.tagBits |= var1.tagBits & 1610612864L;
        }
    }

    public TypeBinding closestMatch() {
        if (this.isValidBinding()) {
            return this;
        } else {
            TypeBinding var1 = this.leafComponentType.closestMatch();
            return var1 == null ? null : this.environment.createArrayType(this.leafComponentType.closestMatch(), this.dimensions);
        }
    }

    public List method_132(List var1) {
        if ((this.tagBits & 128L) != 0L) {
            var1 = this.leafComponentType.method_132(var1);
        }
        return var1;
    }

    public void collectSubstitutes(Scope var1, TypeBinding var2, InferenceContext var3, int var4) {
        if ((this.tagBits & 536870912L) != 0L) {
            if (var2 != TypeBinding.field_187) {
                switch (var2.kind()) {
                    case 68:
                        int var5 = var2.method_136();
                        if (var5 == this.dimensions) {
                            this.leafComponentType.collectSubstitutes(var1, var2.method_173(), var3, var4);
                        } else if (var5 > this.dimensions) {
                            ArrayBinding var6 = this.environment.createArrayType(var2.method_173(), var5 - this.dimensions);
                            this.leafComponentType.collectSubstitutes(var1, var6, var3, var4);
                        }
                    case 4100:
                    default:
                }
            }
        }
    }

    public char[] constantPoolName() {
        if (this.field_195 != null) {
            return this.field_195;
        } else {
            char[] var1 = new char[this.dimensions];
            for (int var2 = this.dimensions - 1; var2 >= 0; --var2) {
                var1[var2] = 91;
            }
            return this.field_195 = CharOperation.concat(var1, this.leafComponentType.method_178());
        }
    }

    public String debugName() {
        StringBuffer var1 = new StringBuffer(this.dimensions * 2);
        int var2 = this.dimensions;
        while (true) {
            --var2;
            if (var2 < 0) {
                return this.leafComponentType.debugName() + var1.toString();
            }
            var1.append("[]");
        }
    }

    public int method_136() {
        return this.dimensions;
    }

    public TypeBinding method_187() {
        return (TypeBinding)(this.dimensions == 1 ? this.leafComponentType : this.environment.createArrayType(this.leafComponentType, this.dimensions - 1));
    }

    public TypeBinding erasure() {
        TypeBinding var1 = this.leafComponentType.erasure();
        return this.leafComponentType != var1 ? this.environment.createArrayType(var1, this.dimensions) : this;
    }

    public LookupEnvironment environment() {
        return this.environment;
    }

    public char[] genericTypeSignature() {
        if (this.field_196 == null) {
            char[] var1 = new char[this.dimensions];
            for (int var2 = this.dimensions - 1; var2 >= 0; --var2) {
                var1[var2] = 91;
            }
            this.field_196 = CharOperation.concat(var1, this.leafComponentType.genericTypeSignature());
        }
        return this.field_196;
    }

    public PackageBinding getPackage() {
        return this.leafComponentType.getPackage();
    }

    public int hashCode() {
        return this.leafComponentType == null ? super.hashCode() : this.leafComponentType.hashCode();
    }

    public boolean isCompatibleWith(TypeBinding var1) {
        if (this == var1) {
            return true;
        } else {
            switch (var1.kind()) {
                case 68:
                    ArrayBinding var2 = (ArrayBinding)var1;
                    if (var2.leafComponentType.method_148()) {
                        return false;
                    } else if (this.dimensions == var2.dimensions) {
                        return this.leafComponentType.isCompatibleWith(var2.leafComponentType);
                    } else if (this.dimensions < var2.dimensions) {
                        return false;
                    }
                case 132:
                    return false;
                case 516:
                case 8196:
                    return ((WildcardBinding)var1).boundCheck(this);
                case 4100:
                    if (var1.isCapture()) {
                        CaptureBinding var3 = (CaptureBinding)var1;
                        TypeBinding var4 = var3.lowerBound;
                        if (var3.lowerBound != null) {
                            if (!var4.method_147()) {
                                return false;
                            }
                            return this.isCompatibleWith(var4);
                        }
                    }
                    return false;
                default:
                    switch (var1.method_173().id) {
                        case 1:
                        case 36:
                        case 37:
                            return true;
                        default:
                            return false;
                    }
            }
        }
    }

    public int kind() {
        return 68;
    }

    public TypeBinding method_173() {
        return this.leafComponentType;
    }

    public int problemId() {
        return this.leafComponentType.problemId();
    }

    public char[] method_177() {
        char[] var1 = new char[this.dimensions * 2];
        for (int var2 = this.dimensions * 2 - 1; var2 >= 0; var2 -= 2) {
            var1[var2] = 93;
            var1[var2 - 1] = 91;
        }
        return CharOperation.concat(this.leafComponentType.method_177(), var1);
    }

    public char[] readableName() {
        char[] var1 = new char[this.dimensions * 2];
        for (int var2 = this.dimensions * 2 - 1; var2 >= 0; var2 -= 2) {
            var1[var2] = 93;
            var1[var2 - 1] = 91;
        }
        return CharOperation.concat(this.leafComponentType.readableName(), var1);
    }

    public char[] shortReadableName() {
        char[] var1 = new char[this.dimensions * 2];
        for (int var2 = this.dimensions * 2 - 1; var2 >= 0; var2 -= 2) {
            var1[var2] = 93;
            var1[var2 - 1] = 91;
        }
        return CharOperation.concat(this.leafComponentType.shortReadableName(), var1);
    }

    public char[] method_179() {
        char[] var1 = new char[this.dimensions * 2];
        for (int var2 = this.dimensions * 2 - 1; var2 >= 0; var2 -= 2) {
            var1[var2] = 93;
            var1[var2 - 1] = 91;
        }
        return CharOperation.concat(this.leafComponentType.method_179(), var1);
    }

    public void swapUnresolved(UnresolvedReferenceBinding var1, ReferenceBinding var2, LookupEnvironment var3) {
        if (this.leafComponentType == var1) {
            this.leafComponentType = var3.method_491(var2);
            this.tagBits |= this.leafComponentType.tagBits & 1610612864L;
        }
    }

    public String toString() {
        return this.leafComponentType != null ? this.debugName() : "NULL TYPE ARRAY";
    }

    static {
        FieldBinding var10000 = new FieldBinding(TypeConstants.field_32, TypeBinding.field_179, 17, (ReferenceBinding)null, Constant.NotAConstant);
        ArrayLength = var10000;
    }
}
