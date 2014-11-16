package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.Substitution;
import org.eclipse.jdt.internal.compiler.lookup.InferenceContext;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.UnresolvedReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.WildcardBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.CaptureBinding;
import org.eclipse.jdt.internal.compiler.lookup.BinaryTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.ParameterizedMethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.SyntheticArgumentBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.ParameterizedFieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.CompilationUnitScope;

import java.util.List;

public class ParameterizedTypeBinding extends ReferenceBinding implements Substitution {

    private ReferenceBinding field_242;

    public TypeBinding[] arguments;

    public LookupEnvironment environment;

    public char[] genericTypeSignature;

    public ReferenceBinding superclass;

    public ReferenceBinding[] field_247;

    public FieldBinding[] fields;

    public ReferenceBinding[] field_249;

    public MethodBinding[] methods;

    private ReferenceBinding field_251;

    public ParameterizedTypeBinding(ReferenceBinding var1, TypeBinding[] var2, ReferenceBinding var3, LookupEnvironment var4) {
        this.environment = var4;
        this.field_251 = var3;
        this.initialize(var1, var2);
        if (var1 instanceof UnresolvedReferenceBinding) {
            ((UnresolvedReferenceBinding)var1).addWrapper(this, var4);
        }
        if (var2 != null) {
            int var5 = 0;
            for (int var6 = var2.length; var5 < var6; ++var5) {
                if (var2[var5] instanceof UnresolvedReferenceBinding) {
                    ((UnresolvedReferenceBinding)var2[var5]).addWrapper(this, var4);
                }
            }
        }
        this.tagBits |= 16777216L;
    }

    protected ReferenceBinding actualType() {
        return this.field_242;
    }

    public void boundCheck(Scope var1, TypeReference[] var2) {
        if ((this.tagBits & 4194304L) == 0L) {
            boolean var3 = false;
            TypeVariableBinding[] var4 = this.field_242.typeVariables();
            if (this.arguments != null && var4 != null) {
                int var5 = 0;
                for (int var6 = var4.length; var5 < var6; ++var5) {
                    if (var4[var5].boundCheck(this, this.arguments[var5]) != 0) {
                        var3 = true;
                        if ((this.arguments[var5].tagBits & 128L) == 0L) {
                            var1.problemReporter().typeMismatchError(this.arguments[var5], var4[var5], this.field_242, var2[var5]);
                        }
                    }
                }
            }
            if (!var3) {
                this.tagBits |= 4194304L;
            }
        }
    }

    public boolean method_129() {
        return (this.tagBits & 1073741824L) == 0L && super.method_129();
    }

    public TypeBinding capture(Scope var1, int var2) {
        if ((this.tagBits & 1073741824L) == 0L) {
            return this;
        } else {
            TypeBinding[] var3 = this.arguments;
            int var4 = var3.length;
            TypeBinding[] var5 = new TypeBinding[var4];
            Object var6 = var1.enclosingSourceType();
            if (var6 != null) {
                var6 = ((ReferenceBinding)var6).outermostEnclosingType();
            }
            for (int var7 = 0; var7 < var4; ++var7) {
                TypeBinding var8 = var3[var7];
                if (var8.kind() == 516) {
                    CaptureBinding var10002 = new CaptureBinding((WildcardBinding)var8, (ReferenceBinding)var6, var2, var1.compilationUnitScope().nextCaptureID());
                    var5[var7] = var10002;
                } else {
                    var5[var7] = var8;
                }
            }
            ParameterizedTypeBinding var10 = this.environment.createParameterizedType(this.field_242, var5, this.enclosingType());
            for (int var11 = 0; var11 < var4; ++var11) {
                TypeBinding var9 = var5[var11];
                if (var9.isCapture()) {
                    ((CaptureBinding)var9).initializeBounds(var1, var10);
                }
            }
            return var10;
        }
    }

    public List method_132(List var1) {
        if ((this.tagBits & 128L) != 0L) {
            if (this.field_251 != null) {
                var1 = this.field_251.method_132(var1);
            }
            var1 = this.method_286().method_132(var1);
            if (this.arguments != null) {
                int var2 = 0;
                for (int var3 = this.arguments.length; var2 < var3; ++var2) {
                    var1 = this.arguments[var2].method_132(var1);
                }
            }
        }
        return var1;
    }

    public void collectSubstitutes(Scope var1, TypeBinding var2, InferenceContext var3, int var4) {
        if ((this.tagBits & 536870912L) != 0L) {
            if (var2 != TypeBinding.field_187) {
                if (var2 instanceof ReferenceBinding) {
                    Object var5;
                    TypeBinding var6;
                    switch (var4) {
                        case 0:
                        case 1:
                            var5 = this;
                            var6 = var2.method_140(this.field_242);
                            if (var6 == null) {
                                return;
                            }
                            break;
                        case 2:
                        default:
                            var5 = this.method_140(var2);
                            if (var5 == null) {
                                return;
                            }
                            var6 = var2;
                    }
                    ReferenceBinding var7 = ((TypeBinding)var5).enclosingType();
                    if (var7 != null) {
                        var7.collectSubstitutes(var1, var6.enclosingType(), var3, var4);
                    }
                    if (this.arguments != null) {
                        Object var8;
                        switch (((TypeBinding)var5).kind()) {
                            case 260:
                                var8 = ((ParameterizedTypeBinding)var5).arguments;
                                break;
                            case 1028:
                                if (!var3.method_3203()) {
                                    var3.field_1829 = 1;
                                }
                                return;
                            case 2052:
                                var8 = ((TypeBinding)var5).typeVariables();
                                break;
                            default:
                                return;
                        }
                        Object var9;
                        switch (var6.kind()) {
                            case 260:
                                var9 = ((ParameterizedTypeBinding)var6).arguments;
                                break;
                            case 1028:
                                if (!var3.method_3203()) {
                                    var3.field_1829 = 1;
                                }
                                return;
                            case 2052:
                                var9 = var6.typeVariables();
                                break;
                            default:
                                return;
                        }
                        ++var3.field_1828;
                        int var10 = 0;
                        for (int var11 = ((Object[])var8).length; var10 < var11; ++var10) {
                            Object var12 = ((Object[])var8)[var10];
                            Object var13 = ((Object[])var9)[var10];
                            if (((TypeBinding)var12).method_172()) {
                                ((TypeBinding)var12).collectSubstitutes(var1, (TypeBinding)var13, var3, var4);
                            } else {
                                if (((TypeBinding)var13).method_172()) {
                                    WildcardBinding var14 = (WildcardBinding)var13;
                                    if (var14.otherBounds == null) {
                                        if (var4 == 2) {
                                            switch (var14.field_215) {
                                                case 1:
                                                    ((TypeBinding)var12).collectSubstitutes(var1, var14.bound, var3, 2);
                                                    continue;
                                                case 2:
                                                    ((TypeBinding)var12).collectSubstitutes(var1, var14.bound, var3, 1);
                                            }
                                        }
                                        continue;
                                    }
                                }
                                ((TypeBinding)var12).collectSubstitutes(var1, (TypeBinding)var13, var3, 0);
                            }
                        }
                        --var3.field_1828;
                    }
                }
            }
        }
    }

    public void computeId() {
        this.id = Integer.MAX_VALUE;
    }

    public char[] constantPoolName() {
        return this.field_242.constantPoolName();
    }

    public ParameterizedMethodBinding createParameterizedMethod(MethodBinding var1) {
        ParameterizedMethodBinding var10000 = new ParameterizedMethodBinding(this, var1);
        return var10000;
    }

    public String debugName() {
        StringBuffer var1 = new StringBuffer(10);
        if (this.field_242 instanceof UnresolvedReferenceBinding) {
            var1.append(this.field_242);
        } else {
            var1.append(this.field_242.method_179());
        }
        if (this.arguments != null) {
            var1.append('<');
            int var2 = 0;
            for (int var3 = this.arguments.length; var2 < var3; ++var2) {
                if (var2 > 0) {
                    var1.append(',');
                }
                var1.append(this.arguments[var2].debugName());
            }
            var1.append('>');
        }
        return var1.toString();
    }

    public ReferenceBinding enclosingType() {
        return this.field_251;
    }

    public LookupEnvironment environment() {
        return this.environment;
    }

    public TypeBinding erasure() {
        return this.field_242.erasure();
    }

    public int method_203() {
        return this.field_242.method_203();
    }

    public FieldBinding[] fields() {
        if ((this.tagBits & 8192L) != 0L) {
            return this.fields;
        } else {
            try {
                FieldBinding[] var1 = this.field_242.fields();
                int var2 = var1.length;
                FieldBinding[] var3 = new FieldBinding[var2];
                for (int var4 = 0; var4 < var2; ++var4) {
                    ParameterizedFieldBinding var10002 = new ParameterizedFieldBinding(this, var1[var4]);
                    var3[var4] = var10002;
                }
                this.fields = var3;
                return this.fields;
            } finally {
                if (this.fields == null) {
                    this.fields = Binding.field_153;
                }
                this.tagBits |= 8192L;
            }
        }
    }

    public ReferenceBinding method_286() {
        if (this.field_242 instanceof UnresolvedReferenceBinding) {
            ((UnresolvedReferenceBinding)this.field_242).resolve(this.environment, false);
        }
        return this.field_242;
    }

    public char[] genericTypeSignature() {
        if (this.genericTypeSignature == null) {
            if ((this.modifiers & 1073741824) == 0) {
                this.genericTypeSignature = this.field_242.method_178();
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
                    char[] var4 = this.field_242.method_178();
                    var1.append(var4, 0, var4.length - 1);
                }
                int var5;
                if (this.arguments != null) {
                    var1.append('<');
                    var5 = 0;
                    for (int var6 = this.arguments.length; var5 < var6; ++var5) {
                        var1.append(this.arguments[var5].genericTypeSignature());
                    }
                    var1.append('>');
                }
                var1.append(';');
                var5 = var1.length();
                this.genericTypeSignature = new char[var5];
                var1.getChars(0, var5, this.genericTypeSignature, 0);
            }
        }
        return this.genericTypeSignature;
    }

    public long getAnnotationTagBits() {
        return this.field_242.getAnnotationTagBits();
    }

    public MethodBinding getExactConstructor(TypeBinding[] var1) {
        int var2 = var1.length;
        MethodBinding var3 = null;
        if ((this.tagBits & 32768L) != 0L) {
            long var4;
            if ((var4 = ReferenceBinding.binarySearch(TypeConstants.field_135, this.methods)) >= 0L) {
                int var6 = (int)var4;
                label61:
                for (int var7 = (int)(var4 >> 32); var6 <= var7; ++var6) {
                    MethodBinding var8 = this.methods[var6];
                    if (var8.parameters.length == var2) {
                        TypeBinding[] var9 = var8.parameters;
                        for (int var10 = 0; var10 < var2; ++var10) {
                            if (var9[var10] != var1[var10]) {
                                continue label61;
                            }
                        }
                        if (var3 != null) {
                            return null;
                        }
                        var3 = var8;
                    }
                }
            }
        } else {
            MethodBinding[] var11 = this.getMethods(TypeConstants.field_135);
            int var5 = var11.length;
            label47:
            while (true) {
                --var5;
                if (var5 < 0) {
                    break;
                }
                MethodBinding var12 = var11[var5];
                TypeBinding[] var13 = var12.parameters;
                if (var13.length == var2) {
                    for (int var14 = 0; var14 < var2; ++var14) {
                        if (var13[var14] != var1[var14]) {
                            continue label47;
                        }
                    }
                    if (var3 != null) {
                        return null;
                    }
                    var3 = var12;
                }
            }
        }
        return var3;
    }

    public MethodBinding getExactMethod(char[] var1, TypeBinding[] var2, CompilationUnitScope var3) {
        int var4 = var2.length;
        boolean var5 = true;
        MethodBinding var6 = null;
        if ((this.tagBits & 32768L) != 0L) {
            long var7;
            if ((var7 = ReferenceBinding.binarySearch(var1, this.methods)) >= 0L) {
                int var9 = (int)var7;
                label99:
                for (int var10 = (int)(var7 >> 32); var9 <= var10; ++var9) {
                    MethodBinding var11 = this.methods[var9];
                    var5 = false;
                    if (var11.parameters.length == var4) {
                        TypeBinding[] var12 = var11.parameters;
                        for (int var13 = 0; var13 < var4; ++var13) {
                            if (var12[var13] != var2[var13]) {
                                continue label99;
                            }
                        }
                        if (var6 != null) {
                            return null;
                        }
                        var6 = var11;
                    }
                }
            }
        } else {
            MethodBinding[] var14 = this.getMethods(var1);
            var5 = var14 == Binding.field_154;
            int var8 = var14.length;
            label85:
            while (true) {
                --var8;
                if (var8 < 0) {
                    break;
                }
                MethodBinding var15 = var14[var8];
                TypeBinding[] var17 = var15.parameters;
                if (var17.length == var4) {
                    for (int var16 = 0; var16 < var4; ++var16) {
                        if (var17[var16] != var2[var16]) {
                            continue label85;
                        }
                    }
                    if (var6 != null) {
                        return null;
                    }
                    var6 = var15;
                }
            }
        }
        if (var6 != null) {
            return var6.method_354() ? null : var6;
        } else {
            if (var5 && (this.arguments == null || this.arguments.length <= 1)) {
                if (this.method_157()) {
                    if (this.superInterfaces().length == 1) {
                        if (var3 != null) {
                            var3.method_693(this.field_247[0]);
                        }
                        return this.field_247[0].getExactMethod(var1, var2, var3);
                    }
                } else if (this.superclass() != null) {
                    if (var3 != null) {
                        var3.method_693(this.superclass);
                    }
                    return this.superclass.getExactMethod(var1, var2, var3);
                }
            }
            return null;
        }
    }

    public FieldBinding getField(char[] var1, boolean var2) {
        this.fields();
        return ReferenceBinding.binarySearch(var1, this.fields);
    }

    public ReferenceBinding getMemberType(char[] var1) {
        this.memberTypes();
        int var2 = var1.length;
        int var3 = this.field_249.length;
        ReferenceBinding var4;
        do {
            --var3;
            if (var3 < 0) {
                return null;
            }
            var4 = this.field_249[var3];
        } while (var4.sourceName.length != var2 || !CharOperation.method_1364(var4.sourceName, var1));
        return var4;
    }

    public MethodBinding[] getMethods(char[] var1) {
        long var2;
        int var4;
        int var5;
        MethodBinding[] var6;
        if (this.methods != null && (var2 = ReferenceBinding.binarySearch(var1, this.methods)) >= 0L) {
            var4 = (int)var2;
            var5 = (int)(var2 >> 32) - var4 + 1;
            System.arraycopy(this.methods, var4, var6 = new MethodBinding[var5], 0, var5);
            return var6;
        } else if ((this.tagBits & 32768L) != 0L) {
            return Binding.field_154;
        } else {
            MethodBinding[] var10 = null;
            MethodBinding[] var11;
            try {
                MethodBinding[] var3 = this.field_242.getMethods(var1);
                var4 = var3.length;
                if (var4 == 0) {
                    var11 = Binding.field_154;
                    return var11;
                }
                var10 = new MethodBinding[var4];
                for (var5 = 0; var5 < var4; ++var5) {
                    var10[var5] = this.createParameterizedMethod(var3[var5]);
                }
                if (this.methods == null) {
                    var11 = new MethodBinding[var4];
                    System.arraycopy(var10, 0, var11, 0, var4);
                    this.methods = var11;
                } else {
                    var5 = var4 + this.methods.length;
                    var6 = new MethodBinding[var5];
                    System.arraycopy(var10, 0, var6, 0, var4);
                    System.arraycopy(this.methods, 0, var6, var4, this.methods.length);
                    if (var5 > 1) {
                        ReferenceBinding.sortMethods(var6, 0, var5);
                    }
                    this.methods = var6;
                }
                var11 = var10;
            } finally {
                if (var10 == null) {
                    var10 = Binding.field_154;
                    this.methods = Binding.field_154;
                }
            }
            return var11;
        }
    }

    public boolean method_213() {
        return this.field_242.method_213();
    }

    public boolean implementsMethod(MethodBinding var1) {
        return this.field_242.implementsMethod(var1);
    }

    void initialize(ReferenceBinding var1, TypeBinding[] var2) {
        this.field_242 = var1;
        this.sourceName = var1.sourceName;
        this.compoundName = var1.compoundName;
        this.fPackage = var1.fPackage;
        this.field_201 = var1.field_201;
        this.modifiers = var1.modifiers & -1073741825;
        if (var2 != null) {
            this.modifiers |= 1073741824;
        } else if (this.field_251 != null) {
            this.modifiers |= this.field_251.modifiers & 1073741824;
            this.tagBits |= this.field_251.tagBits & 536871040L;
        }
        if (var2 != null) {
            this.arguments = var2;
            int var3 = 0;
            for (int var4 = var2.length; var3 < var4; ++var3) {
                TypeBinding var5 = var2[var3];
                switch (var5.kind()) {
                    case 516:
                        this.tagBits |= 1073741824L;
                        if (((WildcardBinding)var5).field_215 != 0) {
                            this.tagBits |= 8388608L;
                        }
                        break;
                    case 8196:
                        this.tagBits |= 1073741824L;
                        break;
                    default:
                        this.tagBits |= 8388608L;
                }
                this.tagBits |= var5.tagBits & 536871040L;
            }
        }
        this.tagBits |= var1.tagBits & 156L;
        this.tagBits &= -40961L;
    }

    protected void initializeArguments() {}

    void initializeForStaticImports() {
        this.field_242.initializeForStaticImports();
    }

    public boolean isEquivalentTo(TypeBinding var1) {
        if (this == var1) {
            return true;
        } else if (var1 == null) {
            return false;
        } else {
            switch (var1.kind()) {
                case 260:
                    ParameterizedTypeBinding var2 = (ParameterizedTypeBinding)var1;
                    if (this.field_242 != var2.field_242) {
                        return false;
                    } else {
                        if (!this.method_226()) {
                            ReferenceBinding var3 = this.enclosingType();
                            if (var3 != null) {
                                ReferenceBinding var4 = var2.enclosingType();
                                if (var4 == null) {
                                    return false;
                                }
                                if ((var4.tagBits & 1073741824L) == 0L) {
                                    if (var3 != var4) {
                                        return false;
                                    }
                                } else if (!var3.isEquivalentTo(var2.enclosingType())) {
                                    return false;
                                }
                            }
                        }
                        if (this.arguments == null) {
                            return var2.arguments == null;
                        } else {
                            int var6 = this.arguments.length;
                            TypeBinding[] var7 = var2.arguments;
                            if (var7 != null && var7.length == var6) {
                                for (int var5 = 0; var5 < var6; ++var5) {
                                    if (!this.arguments[var5].method_168(var7[var5])) {
                                        return false;
                                    }
                                }
                                return true;
                            }
                            return false;
                        }
                    }
                case 516:
                case 8196:
                    return ((WildcardBinding)var1).boundCheck(this);
                case 1028:
                    return this.erasure() == var1.erasure();
                default:
                    return false;
            }
        }
    }

    public boolean method_162() {
        return true;
    }

    public boolean isRawSubstitution() {
        return this.method_166();
    }

    public int kind() {
        return 260;
    }

    public ReferenceBinding[] memberTypes() {
        if (this.field_249 == null) {
            try {
                ReferenceBinding[] var1 = this.field_242.memberTypes();
                int var2 = var1.length;
                ReferenceBinding[] var3 = new ReferenceBinding[var2];
                for (int var4 = 0; var4 < var2; ++var4) {
                    var3[var4] = this.environment.createParameterizedType(var1[var4], (TypeBinding[])null, this);
                }
                this.field_249 = var3;
            } finally {
                if (this.field_249 == null) {
                    this.field_249 = Binding.field_156;
                }
            }
        }
        return this.field_249;
    }

    public MethodBinding[] methods() {
        if ((this.tagBits & 32768L) != 0L) {
            return this.methods;
        } else {
            try {
                MethodBinding[] var1 = this.field_242.methods();
                int var2 = var1.length;
                MethodBinding[] var3 = new MethodBinding[var2];
                for (int var4 = 0; var4 < var2; ++var4) {
                    var3[var4] = this.createParameterizedMethod(var1[var4]);
                }
                this.methods = var3;
                return this.methods;
            } finally {
                if (this.methods == null) {
                    this.methods = Binding.field_154;
                }
                this.tagBits |= 32768L;
            }
        }
    }

    public char[] method_176() {
        return this.field_242.method_176();
    }

    public char[] method_177() {
        return this.field_242.method_177();
    }

    public char[] readableName() {
        StringBuffer var1 = new StringBuffer(10);
        if (this.method_159()) {
            var1.append(CharOperation.concat(this.enclosingType().readableName(), this.sourceName, '.'));
        } else {
            var1.append(CharOperation.concatWith(this.field_242.compoundName, '.'));
        }
        int var2;
        if (this.arguments != null) {
            var1.append('<');
            var2 = 0;
            for (int var3 = this.arguments.length; var2 < var3; ++var2) {
                if (var2 > 0) {
                    var1.append(',');
                }
                var1.append(this.arguments[var2].readableName());
            }
            var1.append('>');
        }
        var2 = var1.length();
        char[] var4 = new char[var2];
        var1.getChars(0, var2, var4, 0);
        return var4;
    }

    ReferenceBinding resolve() {
        if ((this.tagBits & 16777216L) == 0L) {
            return this;
        } else {
            this.tagBits &= -16777217L;
            ReferenceBinding var1 = BinaryTypeBinding.method_267(this.field_242, this.environment, false);
            if (this.arguments != null) {
                int var2 = this.arguments.length;
                for (int var3 = 0; var3 < var2; ++var3) {
                    this.arguments[var3] = BinaryTypeBinding.method_268(this.arguments[var3], this.environment, (ParameterizedTypeBinding)null, 0);
                }
                TypeVariableBinding[] var4 = var1.typeVariables();
                if (var4 == Binding.NO_TYPE_VARIABLES) {
                    if ((var1.tagBits & 128L) == 0L) {
                        this.environment.problemReporter.nonGenericTypeCannotBeParameterized(0, (ASTNode)null, var1, this.arguments);
                    }
                    return this;
                }
                if (var2 != var4.length) {
                    this.environment.problemReporter.incorrectArityForParameterizedType((ASTNode)null, var1, this.arguments);
                    return this;
                }
            }
            return this;
        }
    }

    public char[] shortReadableName() {
        StringBuffer var1 = new StringBuffer(10);
        if (this.method_159()) {
            var1.append(CharOperation.concat(this.enclosingType().shortReadableName(), this.sourceName, '.'));
        } else {
            var1.append(this.field_242.sourceName);
        }
        int var2;
        if (this.arguments != null) {
            var1.append('<');
            var2 = 0;
            for (int var3 = this.arguments.length; var2 < var3; ++var2) {
                if (var2 > 0) {
                    var1.append(',');
                }
                var1.append(this.arguments[var2].shortReadableName());
            }
            var1.append('>');
        }
        var2 = var1.length();
        char[] var4 = new char[var2];
        var1.getChars(0, var2, var4, 0);
        return var4;
    }

    public char[] method_178() {
        if (this.field_203 == null) {
            this.field_203 = this.field_242.method_178();
        }
        return this.field_203;
    }

    public char[] method_179() {
        return this.field_242.method_179();
    }

    public TypeBinding substitute(TypeVariableBinding var1) {
        ParameterizedTypeBinding var2 = this;
        while (true) {
            TypeVariableBinding[] var3 = var2.field_242.typeVariables();
            int var4 = var3.length;
            if (var1.rank < var4 && var3[var1.rank] == var1) {
                if (var2.arguments == null) {
                    var2.initializeArguments();
                }
                if (var2.arguments != null) {
                    return var2.arguments[var1.rank];
                }
            }
            if (var2.method_226()) {
                break;
            }
            ReferenceBinding var5 = var2.enclosingType();
            if (!(var5 instanceof ParameterizedTypeBinding)) {
                break;
            }
            var2 = (ParameterizedTypeBinding)var5;
        }
        return var1;
    }

    public ReferenceBinding superclass() {
        if (this.superclass == null) {
            ReferenceBinding var1 = this.field_242.superclass();
            if (var1 == null) {
                return null;
            }
            this.superclass = (ReferenceBinding)Scope.substitute(this, var1);
        }
        return this.superclass;
    }

    public ReferenceBinding[] superInterfaces() {
        if (this.field_247 == null) {
            if (this.field_242.method_222()) {
                return Binding.field_155;
            }
            this.field_247 = Scope.substitute(this, this.field_242.superInterfaces());
        }
        return this.field_247;
    }

    public void swapUnresolved(UnresolvedReferenceBinding var1, ReferenceBinding var2, LookupEnvironment var3) {
        boolean var4 = false;
        if (this.field_242 == var1) {
            this.field_242 = var2;
            var4 = true;
            ReferenceBinding var5 = var2.enclosingType();
            if (var5 != null) {
                this.field_251 = (ReferenceBinding)var3.method_491(var5);
            }
        }
        if (this.arguments != null) {
            int var7 = 0;
            for (int var6 = this.arguments.length; var7 < var6; ++var7) {
                if (this.arguments[var7] == var1) {
                    this.arguments[var7] = var3.method_491(var2);
                    var4 = true;
                }
            }
        }
        if (var4) {
            this.initialize(this.field_242, this.arguments);
        }
    }

    public ReferenceBinding[] syntheticEnclosingInstanceTypes() {
        return this.field_242.syntheticEnclosingInstanceTypes();
    }

    public SyntheticArgumentBinding[] syntheticOuterLocalVariables() {
        return this.field_242.syntheticOuterLocalVariables();
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer(30);
        if (this.field_242 instanceof UnresolvedReferenceBinding) {
            var1.append(this.debugName());
        } else {
            if (this.method_220()) {
                var1.append("deprecated ");
            }
            if (this.method_225()) {
                var1.append("public ");
            }
            if (this.method_224()) {
                var1.append("protected ");
            }
            if (this.method_223()) {
                var1.append("private ");
            }
            if (this.method_217() && this.method_151()) {
                var1.append("abstract ");
            }
            if (this.method_226() && this.method_160()) {
                var1.append("static ");
            }
            if (this.method_221()) {
                var1.append("final ");
            }
            if (this.method_153()) {
                var1.append("enum ");
            } else if (this.method_145()) {
                var1.append("@interface ");
            } else if (this.method_151()) {
                var1.append("class ");
            } else {
                var1.append("interface ");
            }
            var1.append(this.debugName());
            var1.append("\n\textends ");
            var1.append(this.superclass != null ? this.superclass.debugName() : "NULL TYPE");
            int var2;
            int var3;
            if (this.field_247 != null) {
                if (this.field_247 != Binding.field_155) {
                    var1.append("\n\timplements : ");
                    var2 = 0;
                    for (var3 = this.field_247.length; var2 < var3; ++var2) {
                        if (var2 > 0) {
                            var1.append(", ");
                        }
                        var1.append(this.field_247[var2] != null ? this.field_247[var2].debugName() : "NULL TYPE");
                    }
                }
            } else {
                var1.append("NULL SUPERINTERFACES");
            }
            if (this.enclosingType() != null) {
                var1.append("\n\tenclosing type : ");
                var1.append(this.enclosingType().debugName());
            }
            if (this.fields != null) {
                if (this.fields != Binding.field_153) {
                    var1.append("\n/*   fields   */");
                    var2 = 0;
                    for (var3 = this.fields.length; var2 < var3; ++var2) {
                        var1.append('\n').append(this.fields[var2] != null ? this.fields[var2].toString() : "NULL FIELD");
                    }
                }
            } else {
                var1.append("NULL FIELDS");
            }
            if (this.methods != null) {
                if (this.methods != Binding.field_154) {
                    var1.append("\n/*   methods   */");
                    var2 = 0;
                    for (var3 = this.methods.length; var2 < var3; ++var2) {
                        var1.append('\n').append(this.methods[var2] != null ? this.methods[var2].toString() : "NULL METHOD");
                    }
                }
            } else {
                var1.append("NULL METHODS");
            }
            var1.append("\n\n");
        }
        return var1.toString();
    }

    public TypeVariableBinding[] typeVariables() {
        return this.arguments == null ? this.field_242.typeVariables() : Binding.NO_TYPE_VARIABLES;
    }
}
