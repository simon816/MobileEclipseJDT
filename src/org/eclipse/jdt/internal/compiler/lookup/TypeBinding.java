package org.eclipse.jdt.internal.compiler.lookup;

import java.util.List;

import java.util.Vector;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.InferenceContext;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.PackageBinding;
import org.eclipse.jdt.internal.compiler.lookup.BaseTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ArrayBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.UnresolvedReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.WildcardBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.CaptureBinding;
import org.eclipse.jdt.internal.compiler.lookup.ParameterizedTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.NestedTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;
import org.eclipse.jdt.internal.compiler.lookup.Scope;

public abstract class TypeBinding extends Binding {

    public int id;

    public long tagBits;

    public static final BaseTypeBinding field_179;

    public static final BaseTypeBinding field_180;

    public static final BaseTypeBinding field_181;

    public static final BaseTypeBinding field_182;

    public static final BaseTypeBinding field_183;

    public static final BaseTypeBinding field_184;

    public static final BaseTypeBinding field_185;

    public static final BaseTypeBinding field_186;

    public static final BaseTypeBinding field_187;

    public static final BaseTypeBinding field_188;

    public TypeBinding() {
        this.id = Integer.MAX_VALUE;
        this.tagBits = 0L;
    }

    public static final TypeBinding wellKnownType(Scope var0, int var1) {
        switch (var1) {
            case 1:
                return var0.method_609();
            case 2:
                return field_182;
            case 3:
                return field_180;
            case 4:
                return field_181;
            case 5:
                return field_186;
            case 6:
            default:
                return null;
            case 7:
                return field_183;
            case 8:
                return field_185;
            case 9:
                return field_184;
            case 10:
                return field_179;
            case 11:
                return var0.method_610();
        }
    }

    public boolean method_129() {
        return !this.method_148();
    }

    public TypeBinding capture(Scope var1, int var2) {
        return this;
    }

    public TypeBinding closestMatch() {
        return this;
    }

    public List method_132(List var1) {
        return var1;
    }

    public void collectSubstitutes(Scope var1, TypeBinding var2, InferenceContext var3, int var4) {}

    public abstract char[] constantPoolName();

    public String debugName() {
        return new String(this.readableName());
    }

    public int method_136() {
        return 0;
    }

    public ReferenceBinding enclosingType() {
        return null;
    }

    public TypeBinding erasure() {
        return this;
    }

    public ReferenceBinding findSuperTypeOriginatingFrom(int var1, boolean var2) {
        if (!(this instanceof ReferenceBinding)) {
            return null;
        } else {
            ReferenceBinding var3 = (ReferenceBinding)this;
            if (var3.id != var1 && this.method_175().id != var1) {
                ReferenceBinding var4 = var3;
                if (var2) {
                    do {
                        if ((var4 = var4.superclass()) == null) {
                            return null;
                        }
                        if (var4.id == var1) {
                            return var4;
                        }
                    } while (var4.method_175().id != var1);
                    return var4;
                } else {
                    ReferenceBinding[] var5 = null;
                    int var6 = 0;
                    int var9;
                    do {
                        ReferenceBinding[] var7 = var4.superInterfaces();
                        if (var7 != null && var7 != Binding.field_155) {
                            if (var5 == null) {
                                var5 = var7;
                                var6 = var7.length;
                            } else {
                                int var8 = var7.length;
                                if (var6 + var8 >= var5.length) {
                                    System.arraycopy(var5, 0, var5 = new ReferenceBinding[var6 + var8 + 5], 0, var6);
                                }
                                var9 = 0;
                                while (var9 < var8) {
                                    ReferenceBinding var10 = var7[var9];
                                    int var11 = 0;
                                    while (true) {
                                        if (var11 < var6) {
                                            if (var10 != var5[var11]) {
                                                ++var11;
                                                continue;
                                            }
                                        } else {
                                            var5[var6++] = var10;
                                        }
                                        ++var9;
                                        break;
                                    }
                                }
                            }
                        }
                    } while ((var4 = var4.superclass()) != null);
                    for (int var13 = 0; var13 < var6; ++var13) {
                        var4 = var5[var13];
                        if (var4.id == var1) {
                            return var4;
                        }
                        if (var4.method_175().id == var1) {
                            return var4;
                        }
                        ReferenceBinding[] var14 = var4.superInterfaces();
                        if (var14 != null && var14 != Binding.field_155) {
                            var9 = var14.length;
                            if (var6 + var9 >= var5.length) {
                                System.arraycopy(var5, 0, var5 = new ReferenceBinding[var6 + var9 + 5], 0, var6);
                            }
                            label84:
                            for (int var15 = 0; var15 < var9; ++var15) {
                                ReferenceBinding var16 = var14[var15];
                                for (int var12 = 0; var12 < var6; ++var12) {
                                    if (var16 == var5[var12]) {
                                        continue label84;
                                    }
                                }
                                var5[var6++] = var16;
                            }
                        }
                    }
                    return null;
                }
            } else {
                return var3;
            }
        }
    }

    public TypeBinding method_140(TypeBinding var1) {
        if (this == var1) {
            return this;
        } else if (var1 == null) {
            return null;
        } else {
            switch (this.kind()) {
                case 68:
                    ArrayBinding var2 = (ArrayBinding)this;
                    int var3 = var1.method_136();
                    if (var2.dimensions != var3) {
                        switch (var1.id) {
                            case 1:
                            case 36:
                            case 37:
                                return var1;
                            default:
                                if (var3 < var2.dimensions && var1.method_173().id == 1) {
                                    return var1;
                                }
                                return null;
                        }
                    } else if (!(var2.leafComponentType instanceof ReferenceBinding)) {
                        return null;
                    } else {
                        TypeBinding var4 = var2.leafComponentType.method_140(var1.method_173());
                        if (var4 == null) {
                            return null;
                        }
                        return var2.environment().createArrayType(var4, var2.dimensions);
                    }
                case 4100:
                    if (this.isCapture()) {
                        CaptureBinding var5 = (CaptureBinding)this;
                        TypeBinding var6 = var5.firstBound;
                        if (var6 instanceof ArrayBinding) {
                            TypeBinding var7 = var6.method_140(var1);
                            if (var7 != null) {
                                return var7;
                            }
                        }
                    }
                case 4:
                case 260:
                case 516:
                case 1028:
                case 2052:
                case 8196:
                    var1 = var1.method_175();
                    if (this == var1) {
                        return this;
                    } else if (this.method_175() == var1) {
                        return this;
                    } else {
                        ReferenceBinding var14 = (ReferenceBinding)this;
                        if (!var1.method_157()) {
                            do {
                                if ((var14 = var14.superclass()) == null) {
                                    return null;
                                }
                                if (var14 == var1) {
                                    return var14;
                                }
                            } while (var14.method_175() != var1);
                            return var14;
                        } else {
                            ReferenceBinding[] var15 = null;
                            int var16 = 0;
                            int var10;
                            do {
                                ReferenceBinding[] var8 = var14.superInterfaces();
                                if (var8 != Binding.field_155) {
                                    if (var15 == null) {
                                        var15 = var8;
                                        var16 = var8.length;
                                    } else {
                                        int var9 = var8.length;
                                        if (var16 + var9 >= var15.length) {
                                            System.arraycopy(var15, 0, var15 = new ReferenceBinding[var16 + var9 + 5], 0, var16);
                                        }
                                        label137:
                                        for (var10 = 0; var10 < var9; ++var10) {
                                            ReferenceBinding var11 = var8[var10];
                                            for (int var12 = 0; var12 < var16; ++var12) {
                                                if (var11 == var15[var12]) {
                                                    continue label137;
                                                }
                                            }
                                            var15[var16++] = var11;
                                        }
                                    }
                                }
                            } while ((var14 = var14.superclass()) != null);
                            for (int var17 = 0; var17 < var16; ++var17) {
                                var14 = var15[var17];
                                if (var14 == var1) {
                                    return var14;
                                }
                                if (var14.method_175() == var1) {
                                    return var14;
                                }
                                ReferenceBinding[] var18 = var14.superInterfaces();
                                if (var18 != Binding.field_155) {
                                    var10 = var18.length;
                                    if (var16 + var10 >= var15.length) {
                                        System.arraycopy(var15, 0, var15 = new ReferenceBinding[var16 + var10 + 5], 0, var16);
                                    }
                                    label114:
                                    for (int var19 = 0; var19 < var10; ++var19) {
                                        ReferenceBinding var20 = var18[var19];
                                        for (int var13 = 0; var13 < var16; ++var13) {
                                            if (var20 == var15[var13]) {
                                                continue label114;
                                            }
                                        }
                                        var15[var16++] = var20;
                                    }
                                }
                            }
                        }
                    }
                default:
                    return null;
            }
        }
    }

    public TypeBinding method_141(TypeBinding var1) {
        if (this == var1) {
            return null;
        } else {
            TypeBinding var2 = var1.erasure();
            return var2 == this.erasure() ? null : var2;
        }
    }

    public char[] genericTypeSignature() {
        return this.method_178();
    }

    public abstract PackageBinding getPackage();

    void initializeForStaticImports() {}

    public boolean method_145() {
        return false;
    }

    public final boolean method_146() {
        return (this.tagBits & 32L) != 0L;
    }

    public final boolean method_147() {
        return (this.tagBits & 1L) != 0L;
    }

    public final boolean method_148() {
        return (this.tagBits & 2L) != 0L;
    }

    public boolean method_149() {
        return (this.tagBits & 8388608L) != 0L;
    }

    public boolean isCapture() {
        return false;
    }

    public boolean method_151() {
        return false;
    }

    public abstract boolean isCompatibleWith(TypeBinding var1);

    public boolean method_153() {
        return false;
    }

    public boolean isEquivalentTo(TypeBinding var1) {
        if (this == var1) {
            return true;
        } else if (var1 == null) {
            return false;
        } else {
            switch (var1.kind()) {
                case 516:
                case 8196:
                    return ((WildcardBinding)var1).boundCheck(this);
                default:
                    return false;
            }
        }
    }

    public boolean method_155() {
        return false;
    }

    public final boolean method_156() {
        return (this.tagBits & 131072L) != 0L;
    }

    public boolean method_157() {
        return false;
    }

    public final boolean method_158() {
        return (this.tagBits & 16L) != 0L;
    }

    public final boolean method_159() {
        return (this.tagBits & 8L) != 0L;
    }

    public final boolean method_160() {
        return (this.tagBits & 4L) != 0L;
    }

    public final boolean method_161() {
        switch (this.id) {
            case 2:
            case 3:
            case 4:
            case 7:
            case 8:
            case 9:
            case 10:
                return true;
            case 5:
            case 6:
            default:
                return false;
        }
    }

    public boolean method_162() {
        return false;
    }

    private boolean isProvableDistinctSubType(TypeBinding var1) {
        if (var1.method_157()) {
            return this.method_157() ? false : (!this.method_147() && (!(this instanceof ReferenceBinding) || !((ReferenceBinding)this).method_221()) && (!this.method_169() || !((TypeVariableBinding)this).superclass().method_221()) ? false : !this.isCompatibleWith(var1));
        } else {
            if (this.method_157()) {
                if (var1.method_147() || var1 instanceof ReferenceBinding && ((ReferenceBinding)var1).method_221() || var1.method_169() && ((TypeVariableBinding)var1).superclass().method_221()) {
                    return !this.isCompatibleWith(var1);
                }
            } else if (!this.method_169() && !var1.method_169()) {
                return !this.isCompatibleWith(var1);
            }
            return false;
        }
    }

    public boolean method_164(TypeBinding var1) {
        if (this == var1) {
            return false;
        } else if (var1 == null) {
            return true;
        } else {
            switch (this.kind()) {
                case 260:
                    ParameterizedTypeBinding var2 = (ParameterizedTypeBinding)this;
                    int var4;
                    int var6;
                    switch (var1.kind()) {
                        case 260:
                            ParameterizedTypeBinding var3 = (ParameterizedTypeBinding)var1;
                            if (var2.method_286() != var3.method_286()) {
                                return true;
                            } else {
                                if (!var2.method_226()) {
                                    ReferenceBinding var10 = this.enclosingType();
                                    if (var10 != null) {
                                        ReferenceBinding var11 = var3.enclosingType();
                                        if (var11 == null) {
                                            return true;
                                        }
                                        if ((var11.tagBits & 1073741824L) == 0L) {
                                            if (var10 != var11) {
                                                return true;
                                            }
                                        } else if (!var10.isEquivalentTo(var3.enclosingType())) {
                                            return true;
                                        }
                                    }
                                }
                                var4 = var2.arguments == null ? 0 : var2.arguments.length;
                                TypeBinding[] var12 = var3.arguments;
                                var6 = var12 == null ? 0 : var12.length;
                                if (var6 != var4) {
                                    return true;
                                } else {
                                    for (int var13 = 0; var13 < var4; ++var13) {
                                        if (var2.arguments[var13].isProvablyDistinctTypeArgument(var12[var13], var2, var13)) {
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                            }
                        case 1028:
                            return this.erasure() != var1.erasure();
                        case 2052:
                            SourceTypeBinding var7 = (SourceTypeBinding)var1;
                            if (var2.method_286() != var7) {
                                return true;
                            } else {
                                if (!var2.method_226()) {
                                    ReferenceBinding var8 = this.enclosingType();
                                    if (var8 != null) {
                                        ReferenceBinding var9 = var7.enclosingType();
                                        if (var9 == null) {
                                            return true;
                                        }
                                        if ((var9.tagBits & 1073741824L) == 0L) {
                                            if (var8 != var9) {
                                                return true;
                                            }
                                        } else if (!var8.isEquivalentTo(var7.enclosingType())) {
                                            return true;
                                        }
                                    }
                                }
                                var4 = var2.arguments == null ? 0 : var2.arguments.length;
                                TypeVariableBinding[] var5 = var7.typeVariables();
                                var6 = var5 == null ? 0 : var5.length;
                                if (var6 != var4) {
                                    return true;
                                } else {
                                    for (int var14 = 0; var14 < var4; ++var14) {
                                        if (var2.arguments[var14].isProvablyDistinctTypeArgument(var5[var14], var2, var14)) {
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                            }
                        default:
                            return true;
                    }
                case 1028:
                    switch (var1.kind()) {
                        case 260:
                        case 1028:
                        case 2052:
                            return this.erasure() != var1.erasure();
                        default:
                            return true;
                    }
                default:
                    return true;
            }
        }
    }

    private boolean isProvablyDistinctTypeArgument(TypeBinding var1, ParameterizedTypeBinding var2, int var3) {
        if (this == var1) {
            return false;
        } else {
            TypeBinding var4;
            TypeBinding var5;
            var4 = null;
            var5 = null;
            WildcardBinding var6;
            label148:
            switch (this.kind()) {
                case 516:
                    var6 = (WildcardBinding)this;
                    switch (var6.field_215) {
                        case 0:
                            return false;
                        case 1:
                            var4 = var6.bound;
                            break label148;
                        case 2:
                            var5 = var6.bound;
                        default:
                            break label148;
                    }
                case 4100:
                    TypeVariableBinding var7 = (TypeVariableBinding)this;
                    if (var7.isCapture()) {
                        CaptureBinding var8 = (CaptureBinding)var7;
                        switch (var8.wildcard.field_215) {
                            case 0:
                                return false;
                            case 1:
                                var4 = var8.wildcard.bound;
                                break;
                            case 2:
                                var5 = var8.wildcard.bound;
                        }
                    } else {
                        if (var7.firstBound == null) {
                            return false;
                        }
                        TypeBinding var14 = var2.environment.method_488(var7, var2.method_286(), var3, (Vector)null);
                        switch (var14.kind()) {
                            case 516:
                            case 8196:
                                var6 = (WildcardBinding)var14;
                                switch (var6.field_215) {
                                    case 0:
                                        return false;
                                    case 1:
                                        var4 = var6.bound;
                                        break;
                                    case 2:
                                        var5 = var6.bound;
                                }
                        }
                    }
                case 8196:
            }
            TypeBinding var11 = null;
            TypeBinding var12 = null;
            WildcardBinding var13;
            switch (var1.kind()) {
                case 516:
                    var13 = (WildcardBinding)var1;
                    switch (var13.field_215) {
                        case 0:
                            return false;
                        case 1:
                            var11 = var13.bound;
                            return var5 != null ? (var12 != null ? false : (var11 != null ? (!var5.method_169() && !var11.method_169() ? !var5.isCompatibleWith(var11) : false) : (!var5.method_169() && !var1.method_169() ? !var5.isCompatibleWith(var1) : false))) : (var4 == null ? (var12 != null ? (!var12.method_169() && !this.method_169() ? !var12.isCompatibleWith(this) : false) : (var11 != null ? this.isProvableDistinctSubType(var11) : true)) : (var12 != null ? !var12.isCompatibleWith(var4) : (var11 == null ? var1.isProvableDistinctSubType(var4) : var4.isProvableDistinctSubType(var11) && var11.isProvableDistinctSubType(var4))));
                        case 2:
                            var12 = var13.bound;
                            return var5 != null ? (var12 != null ? false : (var11 != null ? (!var5.method_169() && !var11.method_169() ? !var5.isCompatibleWith(var11) : false) : (!var5.method_169() && !var1.method_169() ? !var5.isCompatibleWith(var1) : false))) : (var4 == null ? (var12 != null ? (!var12.method_169() && !this.method_169() ? !var12.isCompatibleWith(this) : false) : (var11 != null ? this.isProvableDistinctSubType(var11) : true)) : (var12 != null ? !var12.isCompatibleWith(var4) : (var11 == null ? var1.isProvableDistinctSubType(var4) : var4.isProvableDistinctSubType(var11) && var11.isProvableDistinctSubType(var4))));
                        default:
                            return var5 != null ? (var12 != null ? false : (var11 != null ? (!var5.method_169() && !var11.method_169() ? !var5.isCompatibleWith(var11) : false) : (!var5.method_169() && !var1.method_169() ? !var5.isCompatibleWith(var1) : false))) : (var4 == null ? (var12 != null ? (!var12.method_169() && !this.method_169() ? !var12.isCompatibleWith(this) : false) : (var11 != null ? this.isProvableDistinctSubType(var11) : true)) : (var12 != null ? !var12.isCompatibleWith(var4) : (var11 == null ? var1.isProvableDistinctSubType(var4) : var4.isProvableDistinctSubType(var11) && var11.isProvableDistinctSubType(var4))));
                    }
                case 4100:
                    TypeVariableBinding var9 = (TypeVariableBinding)var1;
                    if (var9.isCapture()) {
                        CaptureBinding var10 = (CaptureBinding)var9;
                        switch (var10.wildcard.field_215) {
                            case 0:
                                return false;
                            case 1:
                                var11 = var10.wildcard.bound;
                                break;
                            case 2:
                                var12 = var10.wildcard.bound;
                        }
                    } else {
                        if (var9.firstBound == null) {
                            return false;
                        }
                        TypeBinding var15 = var2.environment.method_488(var9, var2.method_286(), var3, (Vector)null);
                        switch (var15.kind()) {
                            case 516:
                            case 8196:
                                var13 = (WildcardBinding)var15;
                                switch (var13.field_215) {
                                    case 0:
                                        return false;
                                    case 1:
                                        var11 = var13.bound;
                                        break;
                                    case 2:
                                        var12 = var13.bound;
                                }
                        }
                    }
                case 8196:
            }
            return var5 != null ? (var12 != null ? false : (var11 != null ? (!var5.method_169() && !var11.method_169() ? !var5.isCompatibleWith(var11) : false) : (!var5.method_169() && !var1.method_169() ? !var5.isCompatibleWith(var1) : false))) : (var4 == null ? (var12 != null ? (!var12.method_169() && !this.method_169() ? !var12.isCompatibleWith(this) : false) : (var11 != null ? this.isProvableDistinctSubType(var11) : true)) : (var12 != null ? !var12.isCompatibleWith(var4) : (var11 == null ? var1.isProvableDistinctSubType(var4) : var4.isProvableDistinctSubType(var11) && var11.isProvableDistinctSubType(var4))));
        }
    }

    public boolean method_166() {
        return false;
    }

    public boolean method_167() {
        TypeBinding var1 = this.method_173();
        if (!(var1 instanceof ReferenceBinding)) {
            return true;
        } else {
            ReferenceBinding var2 = (ReferenceBinding)var1;
            while (true) {
                switch (var2.kind()) {
                    case 260:
                        if (var2.method_149()) {
                            return false;
                        }
                    case 516:
                    case 2052:
                    case 4100:
                    case 8196:
                        return false;
                    case 1028:
                        return true;
                    default:
                        if (var2.method_226()) {
                            return true;
                        }
                        if (var2.method_158()) {
                            NestedTypeBinding var3 = (NestedTypeBinding)var2.erasure();
                            if (var3.scope.method_635().field_404) {
                                return true;
                            }
                        }
                        if ((var2 = var2.enclosingType()) == null) {
                            return true;
                        }
                }
            }
        }
    }

    public boolean method_168(TypeBinding var1) {
        if (this == var1) {
            return true;
        } else {
            WildcardBinding var4;
            switch (var1.kind()) {
                case 260:
                    if (!this.method_162()) {
                        return false;
                    } else {
                        ParameterizedTypeBinding var18 = (ParameterizedTypeBinding)this;
                        ParameterizedTypeBinding var7 = (ParameterizedTypeBinding)var1;
                        if (var18.actualType() != var7.actualType()) {
                            return false;
                        } else {
                            if (!var18.method_226()) {
                                ReferenceBinding var8 = this.enclosingType();
                                if (var8 != null) {
                                    ReferenceBinding var9 = var7.enclosingType();
                                    if (var9 == null) {
                                        return false;
                                    }
                                    if ((var9.tagBits & 1073741824L) == 0L) {
                                        if (var8 != var9) {
                                            return false;
                                        }
                                    } else if (!var8.isEquivalentTo(var7.enclosingType())) {
                                        return false;
                                    }
                                }
                            }
                            int var19 = var18.arguments == null ? 0 : var18.arguments.length;
                            TypeBinding[] var20 = var7.arguments;
                            int var10 = var20 == null ? 0 : var20.length;
                            if (var10 != var19) {
                                return false;
                            } else {
                                for (int var11 = 0; var11 < var19; ++var11) {
                                    TypeBinding var12 = var18.arguments[var11];
                                    TypeBinding var13 = var20[var11];
                                    if (var12 != var13) {
                                        int var14 = var12.kind();
                                        if (var13.kind() != var14) {
                                            return false;
                                        }
                                        switch (var14) {
                                            case 260:
                                                if (!var12.method_168(var13)) {
                                                    return false;
                                                }
                                                break;
                                            case 516:
                                            case 8196:
                                                WildcardBinding var15 = (WildcardBinding)var12;
                                                var4 = (WildcardBinding)var13;
                                                switch (var15.field_215) {
                                                    case 0:
                                                        if (var4.field_215 != 1 || var4.bound != var4.typeVariable().method_261()) {
                                                            return false;
                                                        }
                                                        continue;
                                                    case 1:
                                                        if (var4.field_215 != 0 || var15.bound != var15.typeVariable().method_261()) {
                                                            return false;
                                                        }
                                                        continue;
                                                    case 2:
                                                    default:
                                                        return false;
                                                }
                                            default:
                                                return false;
                                        }
                                    }
                                }
                                return true;
                            }
                        }
                    }
                case 516:
                case 8196:
                    TypeBinding var2;
                    Object var3;
                    var2 = this;
                    var3 = this;
                    label118:
                    switch (this.kind()) {
                        case 516:
                        case 8196:
                            var4 = (WildcardBinding)this;
                            switch (var4.field_215) {
                                case 0:
                                    var3 = var4;
                                    var2 = null;
                                    break label118;
                                case 1:
                                    if (var4.otherBounds == null) {
                                        var3 = var4.bound;
                                        var2 = null;
                                    }
                                    break label118;
                                case 2:
                                    var3 = var4;
                                    var2 = var4.bound;
                                default:
                                    break label118;
                            }
                        case 4100:
                            if (this.isCapture()) {
                                CaptureBinding var5 = (CaptureBinding)this;
                                if (var5.lowerBound != null) {
                                    var2 = var5.lowerBound;
                                }
                            }
                    }
                    var4 = (WildcardBinding)var1;
                    if (var4.otherBounds != null) {
                        return false;
                    } else {
                        TypeBinding var17 = var4.bound;
                        TypeBinding var6;
                        switch (var4.field_215) {
                            case 0:
                            default:
                                return true;
                            case 1:
                                if (var17 == this) {
                                    return true;
                                } else if (var3 == null) {
                                    return false;
                                } else {
                                    var6 = ((TypeBinding)var3).method_140(var17);
                                    if (var6 != null && (var6 = var6.method_173()).method_166()) {
                                        return var6 == var17.method_173();
                                    }
                                    return ((TypeBinding)var3).isCompatibleWith(var17);
                                }
                            case 2:
                                if (var17 == this) {
                                    return true;
                                } else if (var2 == null) {
                                    return false;
                                } else {
                                    var6 = var17.method_140(var2);
                                    if (var6 != null && (var6 = var6.method_173()).method_166()) {
                                        return var6 == var2.method_173();
                                    }
                                    return var17.isCompatibleWith(var2);
                                }
                        }
                    }
                default:
                    if (var1.id == 1) {
                        switch (this.kind()) {
                            case 516:
                                WildcardBinding var16 = (WildcardBinding)this;
                                if (var16.field_215 == 2 && var16.bound.id == 1) {
                                    return true;
                                }
                        }
                    }
                    return false;
            }
        }
    }

    public boolean method_169() {
        return false;
    }

    public boolean method_170() {
        return false;
    }

    public boolean isUncheckedException(boolean var1) {
        return false;
    }

    public boolean method_172() {
        return false;
    }

    public int kind() {
        return 4;
    }

    public TypeBinding method_173() {
        return this;
    }

    public boolean method_174(TypeBinding var1) {
        if (this == var1) {
            return false;
        } else {
            Object var5 = var1.method_173();
            if (!(var5 instanceof ReferenceBinding)) {
                return false;
            } else {
                TypeBinding var2 = this.method_173();
                TypeBinding var3 = var2.method_140((TypeBinding)var5);
                if (!(var3 instanceof ReferenceBinding)) {
                    return false;
                } else {
                    ReferenceBinding var4 = (ReferenceBinding)var3;
                    while (var4.method_166()) {
                        if (((TypeBinding)var5).method_149()) {
                            return true;
                        }
                        if (var4.method_226() || (var4 = var4.enclosingType()) == null || (var5 = ((TypeBinding)var5).enclosingType()) == null) {
                            break;
                        }
                    }
                    return false;
                }
            }
        }
    }

    public TypeBinding method_175() {
        switch (this.kind()) {
            case 68:
            case 260:
            case 1028:
                return this.erasure();
            default:
                return this;
        }
    }

    public char[] method_176() {
        PackageBinding var1 = this.getPackage();
        return var1 != null && var1.compoundName != CharOperation.NO_CHAR_CHAR ? var1.readableName() : CharOperation.NO_CHAR;
    }

    public abstract char[] method_177();

    public char[] method_178() {
        return this.constantPoolName();
    }

    public abstract char[] method_179();

    public void swapUnresolved(UnresolvedReferenceBinding var1, ReferenceBinding var2, LookupEnvironment var3) {}

    public TypeVariableBinding[] typeVariables() {
        return Binding.NO_TYPE_VARIABLES;
    }

    static {
        BaseTypeBinding var10000 = new BaseTypeBinding(10, TypeConstants.field_62, new char[] {'I'});
        field_179 = var10000;
        var10000 = new BaseTypeBinding(3, TypeConstants.field_60, new char[] {'B'});
        field_180 = var10000;
        var10000 = new BaseTypeBinding(4, TypeConstants.field_61, new char[] {'S'});
        field_181 = var10000;
        var10000 = new BaseTypeBinding(2, TypeConstants.field_66, new char[] {'C'});
        field_182 = var10000;
        var10000 = new BaseTypeBinding(7, TypeConstants.field_63, new char[] {'J'});
        field_183 = var10000;
        var10000 = new BaseTypeBinding(9, TypeConstants.field_64, new char[] {'F'});
        field_184 = var10000;
        var10000 = new BaseTypeBinding(8, TypeConstants.field_65, new char[] {'D'});
        field_185 = var10000;
        var10000 = new BaseTypeBinding(5, TypeConstants.field_67, new char[] {'Z'});
        field_186 = var10000;
        var10000 = new BaseTypeBinding(12, TypeConstants.field_68, new char[] {'N'});
        field_187 = var10000;
        var10000 = new BaseTypeBinding(6, TypeConstants.field_69, new char[] {'V'});
        field_188 = var10000;
    }
}
