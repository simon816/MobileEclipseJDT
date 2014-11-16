package org.eclipse.jdt.internal.compiler.lookup;

import java.util.ArrayList;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.env.IBinaryType;
import org.eclipse.jdt.internal.compiler.env.IBinaryNestedType;
import org.eclipse.jdt.internal.compiler.env.IBinaryMethod;
import org.eclipse.jdt.internal.compiler.env.IBinaryField;
import org.eclipse.jdt.internal.compiler.env.IBinaryAnnotation;
import org.eclipse.jdt.internal.compiler.env.IBinaryElementValuePair;
import org.eclipse.jdt.internal.compiler.env.ClassSignature;
import org.eclipse.jdt.internal.compiler.env.EnumConstantSignature;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.SignatureWrapper;
import org.eclipse.jdt.internal.compiler.lookup.AnnotationBinding;
import org.eclipse.jdt.internal.compiler.lookup.UnresolvedAnnotationBinding;
import org.eclipse.jdt.internal.compiler.lookup.ElementValuePair;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.PackageBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ArrayBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.UnresolvedReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.WildcardBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.ParameterizedTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.CompilationUnitScope;
import org.eclipse.jdt.internal.compiler.util.SimpleLookupTable;

public class BinaryTypeBinding extends ReferenceBinding {

    protected ReferenceBinding field_231;

    protected ReferenceBinding field_232;

    protected ReferenceBinding[] field_233;

    protected FieldBinding[] fields;

    protected MethodBinding[] methods;

    protected ReferenceBinding[] field_236;

    protected TypeVariableBinding[] typeVariables;

    protected LookupEnvironment environment;

    protected SimpleLookupTable storedAnnotations;

    static Object convertMemberValue(Object var0, LookupEnvironment var1, char[][][] var2) {
        if (var0 == null) {
            return null;
        } else if (var0 instanceof Constant) {
            return var0;
        } else if (var0 instanceof ClassSignature) {
            TypeBinding var8 = var1.getTypeFromSignature(((ClassSignature)var0).getTypeName(), 0, -1, false, (TypeBinding)null, var2);
            return var8.method_148() ? var8 : method_267((ReferenceBinding)var8, var1, false);
        } else if (var0 instanceof IBinaryAnnotation) {
            return createAnnotation((IBinaryAnnotation)var0, var1, var2);
        } else if (var0 instanceof EnumConstantSignature) {
            EnumConstantSignature var7 = (EnumConstantSignature)var0;
            ReferenceBinding var9 = (ReferenceBinding)var1.getTypeFromSignature(var7.method_3195(), 0, -1, false, (TypeBinding)null, var2);
            var9 = method_267(var9, var1, false);
            return var9.getField(var7.method_3196(), false);
        } else if (!(var0 instanceof Object[])) {
            throw new IllegalStateException();
        } else {
            Object[] var3 = (Object[])((Object[])var0);
            int var4 = var3.length;
            if (var4 == 0) {
                return var3;
            } else {
                Object[] var5 = new Object[var4];
                for (int var6 = 0; var6 < var4; ++var6) {
                    var5[var6] = convertMemberValue(var3[var6], var1, var2);
                }
                return var5;
            }
        }
    }

    static AnnotationBinding createAnnotation(IBinaryAnnotation var0, LookupEnvironment var1, char[][][] var2) {
        IBinaryElementValuePair[] var3 = var0.getElementValuePairs();
        int var4 = var3 == null ? 0 : var3.length;
        ElementValuePair[] var5 = var4 == 0 ? Binding.NO_ELEMENT_VALUE_PAIRS : new ElementValuePair[var4];
        for (int var6 = 0; var6 < var4; ++var6) {
            ElementValuePair var10002 = new ElementValuePair(var3[var6].getName(), convertMemberValue(var3[var6].getValue(), var1, var2), (MethodBinding)null);
            var5[var6] = var10002;
        }
        char[] var8 = var0.getTypeName();
        ReferenceBinding var7 = var1.getTypeFromConstantPoolName(var8, 1, var8.length - 1, false, var2);
        UnresolvedAnnotationBinding var10000 = new UnresolvedAnnotationBinding(var7, var5, var1);
        return var10000;
    }

    public static AnnotationBinding[] createAnnotations(IBinaryAnnotation[] var0, LookupEnvironment var1, char[][][] var2) {
        int var3 = var0 == null ? 0 : var0.length;
        AnnotationBinding[] var4 = var3 == 0 ? Binding.NO_ANNOTATIONS : new AnnotationBinding[var3];
        for (int var5 = 0; var5 < var3; ++var5) {
            var4[var5] = createAnnotation(var0[var5], var1, var2);
        }
        return var4;
    }

    public static ReferenceBinding method_267(ReferenceBinding var0, LookupEnvironment var1, boolean var2) {
        if (var0 instanceof UnresolvedReferenceBinding) {
            return ((UnresolvedReferenceBinding)var0).resolve(var1, var2);
        } else {
            switch (var0.kind()) {
                case 260:
                    return ((ParameterizedTypeBinding)var0).resolve();
                case 516:
                case 8196:
                    return ((WildcardBinding)var0).resolve();
                default:
                    return var2 ? (ReferenceBinding)var1.method_491(var0) : var0;
            }
        }
    }

    public static TypeBinding method_268(TypeBinding var0, LookupEnvironment var1, ParameterizedTypeBinding var2, int var3) {
        switch (var0.kind()) {
            case 68:
                method_268(((ArrayBinding)var0).leafComponentType, var1, var2, var3);
                break;
            case 260:
                return ((ParameterizedTypeBinding)var0).resolve();
            case 516:
            case 8196:
                return ((WildcardBinding)var0).resolve();
            case 2052:
                if (var2 == null) {
                    return var1.method_491(var0);
                }
                break;
            case 4100:
                ((TypeVariableBinding)var0).method_260(var1);
                break;
            default:
                if (var0 instanceof UnresolvedReferenceBinding) {
                    return ((UnresolvedReferenceBinding)var0).resolve(var1, var2 == null);
                }
        }
        return var0;
    }

    protected BinaryTypeBinding() {
        this.storedAnnotations = null;
    }

    public BinaryTypeBinding(PackageBinding var1, IBinaryType var2, LookupEnvironment var3) {
        this.storedAnnotations = null;
        this.compoundName = CharOperation.method_1385('/', var2.method_60());
        this.computeId();
        this.tagBits |= 64L;
        this.environment = var3;
        this.fPackage = var1;
        this.field_201 = var2.method_50();
        char[] var4 = var3.globalOptions.field_1928 >= 3211264L ? var2.method_52() : null;
        this.typeVariables = var4 != null && var4.length > 0 && var4[0] == 60 ? null : Binding.NO_TYPE_VARIABLES;
        this.sourceName = var2.method_61();
        this.modifiers = var2.getModifiers();
        if ((var2.getTagBits() & 131072L) != 0L) {
            this.tagBits |= 131072L;
        }
        if (var2.method_64()) {
            this.tagBits |= 52L;
        } else if (var2.method_65()) {
            this.tagBits |= 20L;
        } else if (var2.method_66()) {
            this.tagBits |= 12L;
        }
        char[] var5 = var2.getContents();
        if (var5 != null) {
            this.field_232 = var3.getTypeFromConstantPoolName(var5, 0, -1, true, (char[][][])null);
            this.tagBits |= 12L;
            this.tagBits |= 134217728L;
            if (this.enclosingType().method_227()) {
                this.modifiers |= 2048;
            }
            if (this.enclosingType().method_220()) {
                this.modifiers |= 2097152;
            }
        }
    }

    void method_270(IBinaryType var1, boolean var2) {
        this.typeVariables = Binding.NO_TYPE_VARIABLES;
        this.field_233 = Binding.field_155;
        this.field_236 = Binding.field_156;
        IBinaryNestedType[] var3 = var1.getMemberTypes();
        if (var3 != null) {
            int var4 = var3.length;
            if (var4 > 0) {
                this.field_236 = new ReferenceBinding[var4];
                for (int var5 = 0; var5 < var4; ++var5) {
                    this.field_236[var5] = this.environment.getTypeFromConstantPoolName(var3[var5].method_68(), 0, -1, false, (char[][][])null);
                }
                this.tagBits |= 268435456L;
            }
        }
        long var13 = this.environment.globalOptions.field_1928;
        char[] var6 = null;
        if (var13 >= 3211264L) {
            var6 = var1.method_52();
            this.tagBits |= var1.getTagBits();
        }
        char[][][] var7 = var1.getMissingTypeNames();
        if (var6 == null) {
            char[] var8 = var1.method_62();
            if (var8 != null) {
                this.field_231 = this.environment.getTypeFromConstantPoolName(var8, 0, -1, false, var7);
                this.tagBits |= 33554432L;
            }
            this.field_233 = Binding.field_155;
            char[][] var9 = var1.getPackageName();
            if (var9 != null) {
                int var10 = var9.length;
                if (var10 > 0) {
                    this.field_233 = new ReferenceBinding[var10];
                    for (int var11 = 0; var11 < var10; ++var11) {
                        this.field_233[var11] = this.environment.getTypeFromConstantPoolName(var9[var11], 0, -1, false, var7);
                    }
                    this.tagBits |= 67108864L;
                }
            }
        } else {
            SignatureWrapper var10000 = new SignatureWrapper(var6);
            SignatureWrapper var14 = var10000;
            if (var14.signature[var14.field_873] == 60) {
                ++var14.field_873;
                this.typeVariables = this.createTypeVariables(var14, true, var7);
                ++var14.field_873;
                this.tagBits |= 16777216L;
                this.modifiers |= 1073741824;
            }
            this.field_231 = (ReferenceBinding)this.environment.getTypeFromTypeSignature(var14, Binding.NO_TYPE_VARIABLES, this, var7);
            this.tagBits |= 33554432L;
            this.field_233 = Binding.field_155;
            if (!var14.atEnd()) {
                ArrayList var12 = new ArrayList(2);
                ArrayList var15 = var12;
                do {
                    var15.add(this.environment.getTypeFromTypeSignature(var14, Binding.NO_TYPE_VARIABLES, this, var7));
                } while (!var14.atEnd());
                this.field_233 = new ReferenceBinding[var15.size()];
                var15.toArray(this.field_233);
                this.tagBits |= 67108864L;
            }
        }
        if (var2) {
            this.createFields(var1.getFields(), var13, var7);
            this.createMethods(var1.getMethods(), var13, var7);
        } else {
            this.fields = Binding.field_153;
            this.methods = Binding.field_154;
        }
        if (this.environment.globalOptions.field_1963) {
            this.setAnnotations(createAnnotations(var1.getAnnotations(), this.environment, var7));
        }
    }

    private void createFields(IBinaryField[] var1, long var2, char[][][] var4) {
        this.fields = Binding.field_153;
        if (var1 != null) {
            int var5 = var1.length;
            if (var5 > 0) {
                this.fields = new FieldBinding[var5];
                boolean var6 = var2 >= 3211264L;
                boolean var7 = this.method_230();
                boolean var8 = this.method_214();
                int var9 = -1;
                int var10;
                IBinaryField var11;
                for (var10 = 0; var10 < var5; ++var10) {
                    var11 = var1[var10];
                    char[] var12 = var6 ? var11.method_74() : null;
                    TypeBinding var10000;
                    if (var12 == null) {
                        var10000 = this.environment.getTypeFromSignature(var11.method_77(), 0, -1, false, this, var4);
                    } else {
                        LookupEnvironment var16 = this.environment;
                        SignatureWrapper var10001 = new SignatureWrapper(var12);
                        var10000 = var16.getTypeFromTypeSignature(var10001, Binding.NO_TYPE_VARIABLES, this, var4);
                    }
                    TypeBinding var13 = var10000;
                    FieldBinding var15 = new FieldBinding(var11.method_75(), var13, var11.getModifiers() | 33554432, this, var11.getConstant());
                    FieldBinding var14 = var15;
                    if (var9 < 0 && this.environment.globalOptions.field_1963 && var11.getAnnotations() != null) {
                        var9 = var10;
                    }
                    var14.field_304 = var10;
                    if (var6) {
                        var14.tagBits |= var11.getTagBits();
                    }
                    if (var7 && !var14.method_427()) {
                        var14.field_300 |= 2097152;
                    }
                    if (var8) {
                        var14.field_300 |= 262144;
                    }
                    if (var12 != null) {
                        var14.field_300 |= 1073741824;
                    }
                    this.fields[var10] = var14;
                }
                if (var9 >= 0) {
                    for (var10 = var9; var10 < var5; ++var10) {
                        var11 = var1[var10];
                        this.fields[var10].setAnnotations(createAnnotations(var11.getAnnotations(), this.environment, var4));
                    }
                }
            }
        }
    }

    private MethodBinding createMethod(IBinaryMethod var1, long var2, char[][][] var4) {
        int var5 = var1.getModifiers() | 33554432;
        if (var2 < 3211264L) {
            var5 &= -129;
        }
        ReferenceBinding[] var6 = Binding.field_151;
        TypeBinding[] var7 = Binding.field_150;
        TypeVariableBinding[] var8 = Binding.NO_TYPE_VARIABLES;
        AnnotationBinding[][] var9 = (AnnotationBinding[][])null;
        TypeBinding var10 = null;
        boolean var11 = var2 >= 3211264L;
        char[] var12 = var11 ? var1.method_74() : null;
        int var14;
        int var16;
        int var25;
        if (var12 == null) {
            char[] var13 = var1.method_75();
            var14 = 0;
            var16 = 0;
            while (true) {
                ++var16;
                char var15;
                if ((var15 = var13[var16]) == 41) {
                    int var17 = var1.isConstructor() && this.method_159() && !this.method_226() ? 1 : 0;
                    int var18 = var14 - var17;
                    int var20;
                    if (var18 > 0) {
                        var7 = new TypeBinding[var18];
                        if (this.environment.globalOptions.field_1963) {
                            var9 = new AnnotationBinding[var18][];
                        }
                        var16 = 1;
                        int var19 = 0;
                        for (var20 = 0; var20 < var14; ++var20) {
                            do {
                                ++var19;
                            } while ((var15 = var13[var19]) == 91);
                            if (var15 == 76) {
                                while (true) {
                                    ++var19;
                                    if (var13[var19] != 59) {
                                        continue;
                                    }
                                }
                            }
                            if (var20 >= var17) {
                                var7[var20 - var17] = this.environment.getTypeFromSignature(var13, var16, var19, false, this, var4);
                                if (var9 != null) {
                                    var9[var20 - var17] = createAnnotations(var1.getParameterAnnotations(var20), this.environment, var4);
                                }
                            }
                            var16 = var19 + 1;
                        }
                    }
                    char[][] var26 = var1.getExceptionTypeNames();
                    if (var26 != null) {
                        var18 = var26.length;
                        if (var18 > 0) {
                            var6 = new ReferenceBinding[var18];
                            for (var20 = 0; var20 < var18; ++var20) {
                                var6[var20] = this.environment.getTypeFromConstantPoolName(var26[var20], 0, -1, false, var4);
                            }
                        }
                    }
                    if (!var1.isConstructor()) {
                        var10 = this.environment.getTypeFromSignature(var13, var16 + 1, -1, false, this, var4);
                    }
                    break;
                }
                if (var15 != 91) {
                    ++var14;
                    if (var15 == 76) {
                        while (true) {
                            ++var16;
                            if (var13[var16] == 59) {
                                break;
                            }
                        }
                    }
                }
            }
        } else {
            var5 |= 1073741824;
            SignatureWrapper var10000 = new SignatureWrapper(var12);
            SignatureWrapper var22 = var10000;
            if (var22.signature[var22.field_873] == 60) {
                ++var22.field_873;
                var8 = this.createTypeVariables(var22, false, var4);
                ++var22.field_873;
            }
            ArrayList var24;
            ArrayList var28;
            if (var22.signature[var22.field_873] == 40) {
                ++var22.field_873;
                if (var22.signature[var22.field_873] == 41) {
                    ++var22.field_873;
                } else {
                    var28 = new ArrayList(2);
                    var24 = var28;
                    while (var22.signature[var22.field_873] != 41) {
                        var24.add(this.environment.getTypeFromTypeSignature(var22, var8, this, var4));
                    }
                    ++var22.field_873;
                    var25 = var24.size();
                    var7 = new TypeBinding[var25];
                    var24.toArray(var7);
                    if (this.environment.globalOptions.field_1963) {
                        var9 = new AnnotationBinding[var25][];
                        for (var16 = 0; var16 < var25; ++var16) {
                            var9[var16] = createAnnotations(var1.getParameterAnnotations(var16), this.environment, var4);
                        }
                    }
                }
            }
            var10 = this.environment.getTypeFromTypeSignature(var22, var8, this, var4);
            if (!var22.atEnd() && var22.signature[var22.field_873] == 94) {
                var28 = new ArrayList(2);
                var24 = var28;
                do {
                    ++var22.field_873;
                    var24.add(this.environment.getTypeFromTypeSignature(var22, var8, this, var4));
                } while (!var22.atEnd() && var22.signature[var22.field_873] == 94);
                var6 = new ReferenceBinding[var24.size()];
                var24.toArray(var6);
            } else {
                char[][] var23 = var1.getExceptionTypeNames();
                if (var23 != null) {
                    var25 = var23.length;
                    if (var25 > 0) {
                        var6 = new ReferenceBinding[var25];
                        for (var16 = 0; var16 < var25; ++var16) {
                            var6[var16] = this.environment.getTypeFromConstantPoolName(var23[var16], 0, -1, false, var4);
                        }
                    }
                }
            }
        }
        MethodBinding var27;
        if (var1.isConstructor()) {
            var27 = new MethodBinding(var5, var7, var6, this);
        } else {
            var27 = new MethodBinding(var5, var1.method_77(), var10, var7, var6, this);
        }
        MethodBinding var21 = var27;
        if (this.environment.globalOptions.field_1963) {
            var21.method_378(createAnnotations(var1.getAnnotations(), this.environment, var4), var9, this.method_145() ? convertMemberValue(var1.getDefaultValue(), this.environment, var4) : null);
        }
        if (var11) {
            var21.tagBits |= var1.getTagBits();
        }
        var21.typeVariables = var8;
        var14 = 0;
        for (var25 = var8.length; var14 < var25; ++var14) {
            var8[var14].declaringElement = var21;
        }
        return var21;
    }

    private void createMethods(IBinaryMethod[] var1, long var2, char[][][] var4) {
        int var5 = 0;
        int var6 = 0;
        int var7 = -1;
        int[] var8 = null;
        boolean var9;
        if (var1 != null) {
            var5 = var6 = var1.length;
            var9 = var2 < 3211264L && this.environment.globalOptions.field_1927 >= 3211264L;
            int var10 = var5;
            while (true) {
                --var10;
                if (var10 < 0) {
                    break;
                }
                IBinaryMethod var11 = var1[var10];
                if ((var11.getModifiers() & 4096) != 0) {
                    if (!var9 || (var11.getModifiers() & 64) == 0) {
                        if (var8 == null) {
                            var8 = new int[var1.length];
                        }
                        var8[var10] = -1;
                        --var5;
                    }
                } else if (var7 == -1) {
                    char[] var12 = var11.method_77();
                    if (var12.length == 8 && var12[0] == 60) {
                        var7 = var10;
                        --var5;
                    }
                }
            }
        }
        if (var5 == 0) {
            this.methods = Binding.field_154;
        } else {
            var9 = this.method_230();
            boolean var15 = this.method_214();
            this.methods = new MethodBinding[var5];
            int var14;
            if (var5 == var6) {
                for (var14 = 0; var14 < var6; ++var14) {
                    MethodBinding var16 = this.createMethod(var1[var14], var2, var4);
                    if (var9 && !var16.method_361()) {
                        var16.modifiers |= 2097152;
                    }
                    if (var15) {
                        var16.modifiers |= 262144;
                    }
                    this.methods[var14] = var16;
                }
            } else {
                var14 = 0;
                for (int var17 = 0; var14 < var6; ++var14) {
                    if (var7 != var14 && (var8 == null || var8[var14] != -1)) {
                        MethodBinding var13 = this.createMethod(var1[var14], var2, var4);
                        if (var9 && !var13.method_361()) {
                            var13.modifiers |= 2097152;
                        }
                        if (var15) {
                            var13.modifiers |= 262144;
                        }
                        this.methods[var17++] = var13;
                    }
                }
            }
        }
    }

    private TypeVariableBinding[] createTypeVariables(SignatureWrapper var1, boolean var2, char[][][] var3) {
        char[] var4 = var1.signature;
        boolean var5 = false;
        int var6 = var4.length;
        int var7 = 0;
        ArrayList var10000 = new ArrayList(1);
        ArrayList var8 = var10000;
        int var13 = 0;
        boolean var9 = true;
        int var11;
        label41:
        for (int var10 = 1; var10 < var6; ++var10) {
            switch (var4[var10]) {
                case 59:
                    if (var13 == 0 && var10 + 1 < var6 && var4[var10 + 1] != 58) {
                        var9 = true;
                    }
                    break;
                case 60:
                    ++var13;
                    break;
                case 61:
                default:
                    if (var9) {
                        var9 = false;
                        var11 = CharOperation.method_1374(':', var4, var10);
                        char[] var12 = CharOperation.subarray(var4, var10, var11);
                        TypeVariableBinding var10001 = new TypeVariableBinding(var12, this, var7++);
                        var8.add(var10001);
                    }
                    break;
                case 62:
                    --var13;
                    if (var13 < 0) {
                        break label41;
                    }
            }
        }
        TypeVariableBinding[] var14;
        var8.toArray(var14 = new TypeVariableBinding[var7]);
        if (var2) {
            this.typeVariables = var14;
        }
        for (var11 = 0; var11 < var7; ++var11) {
            this.initializeTypeVariable(var14[var11], var14, var1, var3);
        }
        return var14;
    }

    public ReferenceBinding enclosingType() {
        if ((this.tagBits & 134217728L) == 0L) {
            return this.field_232;
        } else {
            this.field_232 = method_267(this.field_232, this.environment, false);
            this.tagBits &= -134217729L;
            return this.field_232;
        }
    }

    public FieldBinding[] fields() {
        if ((this.tagBits & 8192L) != 0L) {
            return this.fields;
        } else {
            int var1;
            if ((this.tagBits & 4096L) == 0L) {
                var1 = this.fields.length;
                if (var1 > 1) {
                    ReferenceBinding.sortFields(this.fields, 0, var1);
                }
                this.tagBits |= 4096L;
            }
            var1 = this.fields.length;
            while (true) {
                --var1;
                if (var1 < 0) {
                    this.tagBits |= 8192L;
                    return this.fields;
                }
                this.resolveTypeFor(this.fields[var1]);
            }
        }
    }

    public char[] genericTypeSignature() {
        return this.computeGenericTypeSignature(this.typeVariables);
    }

    public MethodBinding getExactConstructor(TypeBinding[] var1) {
        int var2;
        if ((this.tagBits & 16384L) == 0L) {
            var2 = this.methods.length;
            if (var2 > 1) {
                ReferenceBinding.sortMethods(this.methods, 0, var2);
            }
            this.tagBits |= 16384L;
        }
        var2 = var1.length;
        long var3;
        if ((var3 = ReferenceBinding.binarySearch(TypeConstants.field_135, this.methods)) >= 0L) {
            int var5 = (int)var3;
            label35:
            for (int var6 = (int)(var3 >> 32); var5 <= var6; ++var5) {
                MethodBinding var7 = this.methods[var5];
                if (var7.parameters.length == var2) {
                    this.resolveTypesFor(var7);
                    TypeBinding[] var8 = var7.parameters;
                    for (int var9 = 0; var9 < var2; ++var9) {
                        if (var8[var9] != var1[var9]) {
                            continue label35;
                        }
                    }
                    return var7;
                }
            }
        }
        return null;
    }

    public MethodBinding getExactMethod(char[] var1, TypeBinding[] var2, CompilationUnitScope var3) {
        int var4;
        if ((this.tagBits & 16384L) == 0L) {
            var4 = this.methods.length;
            if (var4 > 1) {
                ReferenceBinding.sortMethods(this.methods, 0, var4);
            }
            this.tagBits |= 16384L;
        }
        var4 = var2.length;
        boolean var5 = true;
        long var6;
        if ((var6 = ReferenceBinding.binarySearch(var1, this.methods)) >= 0L) {
            int var8 = (int)var6;
            label54:
            for (int var9 = (int)(var6 >> 32); var8 <= var9; ++var8) {
                MethodBinding var10 = this.methods[var8];
                var5 = false;
                if (var10.parameters.length == var4) {
                    this.resolveTypesFor(var10);
                    TypeBinding[] var11 = var10.parameters;
                    for (int var12 = 0; var12 < var4; ++var12) {
                        if (var11[var12] != var2[var12]) {
                            continue label54;
                        }
                    }
                    return var10;
                }
            }
        }
        if (var5) {
            if (this.method_157()) {
                if (this.superInterfaces().length == 1) {
                    if (var3 != null) {
                        var3.method_693(this.field_233[0]);
                    }
                    return this.field_233[0].getExactMethod(var1, var2, var3);
                }
            } else if (this.superclass() != null) {
                if (var3 != null) {
                    var3.method_693(this.field_231);
                }
                return this.field_231.getExactMethod(var1, var2, var3);
            }
        }
        return null;
    }

    public FieldBinding getField(char[] var1, boolean var2) {
        if ((this.tagBits & 4096L) == 0L) {
            int var3 = this.fields.length;
            if (var3 > 1) {
                ReferenceBinding.sortFields(this.fields, 0, var3);
            }
            this.tagBits |= 4096L;
        }
        FieldBinding var4 = ReferenceBinding.binarySearch(var1, this.fields);
        return var2 && var4 != null ? this.resolveTypeFor(var4) : var4;
    }

    public ReferenceBinding getMemberType(char[] var1) {
        int var2 = this.field_236.length;
        while (true) {
            --var2;
            if (var2 < 0) {
                return null;
            }
            ReferenceBinding var3 = this.field_236[var2];
            if (var3 instanceof UnresolvedReferenceBinding) {
                char[] var4 = var3.sourceName;
                int var5 = this.compoundName[this.compoundName.length - 1].length + 1;
                if (var4.length == var5 + var1.length && CharOperation.fragmentEquals(var1, var4, var5, true)) {
                    return this.field_236[var2] = method_267(var3, this.environment, false);
                }
            } else if (CharOperation.method_1364(var1, var3.sourceName)) {
                return var3;
            }
        }
    }

    public MethodBinding[] getMethods(char[] var1) {
        int var4;
        int var5;
        int var6;
        MethodBinding[] var7;
        long var10;
        if ((this.tagBits & 32768L) != 0L) {
            if ((var10 = ReferenceBinding.binarySearch(var1, this.methods)) >= 0L) {
                var4 = (int)var10;
                var5 = (int)(var10 >> 32);
                var6 = var5 - var4 + 1;
                if ((this.tagBits & 32768L) != 0L) {
                    System.arraycopy(this.methods, var4, var7 = new MethodBinding[var6], 0, var6);
                    return var7;
                }
            }
            return Binding.field_154;
        } else {
            if ((this.tagBits & 16384L) == 0L) {
                int var2 = this.methods.length;
                if (var2 > 1) {
                    ReferenceBinding.sortMethods(this.methods, 0, var2);
                }
                this.tagBits |= 16384L;
            }
            if ((var10 = ReferenceBinding.binarySearch(var1, this.methods)) < 0L) {
                return Binding.field_154;
            } else {
                var4 = (int)var10;
                var5 = (int)(var10 >> 32);
                var6 = var5 - var4 + 1;
                var7 = new MethodBinding[var6];
                int var8 = var4;
                for (int var9 = 0; var8 <= var5; ++var9) {
                    var7[var9] = this.resolveTypesFor(this.methods[var8]);
                    ++var8;
                }
                return var7;
            }
        }
    }

    public boolean method_213() {
        return this.field_236.length > 0;
    }

    public TypeVariableBinding getTypeVariable(char[] var1) {
        TypeVariableBinding var2 = super.getTypeVariable(var1);
        var2.method_260(this.environment);
        return var2;
    }

    private void initializeTypeVariable(TypeVariableBinding var1, TypeVariableBinding[] var2, SignatureWrapper var3, char[][][] var4) {
        int var5 = CharOperation.method_1374(':', var3.signature, var3.field_873);
        var3.field_873 = var5 + 1;
        ReferenceBinding var7 = null;
        ReferenceBinding var6;
        if (var3.signature[var3.field_873] == 58) {
            var6 = this.environment.getResolvedType(TypeConstants.field_99, (Scope)null);
        } else {
            var6 = (ReferenceBinding)this.environment.getTypeFromTypeSignature(var3, var2, this, var4);
            var7 = var6;
        }
        var1.modifiers |= 33554432;
        var1.superclass = var6;
        ReferenceBinding[] var8 = null;
        if (var3.signature[var3.field_873] == 58) {
            ArrayList var10000 = new ArrayList(2);
            ArrayList var9 = var10000;
            do {
                ++var3.field_873;
                var9.add(this.environment.getTypeFromTypeSignature(var3, var2, this, var4));
            } while (var3.signature[var3.field_873] == 58);
            var8 = new ReferenceBinding[var9.size()];
            var9.toArray(var8);
        }
        var1.superInterfaces = var8 == null ? Binding.field_155 : var8;
        if (var7 == null) {
            var7 = var1.superInterfaces.length == 0 ? null : var1.superInterfaces[0];
        }
        var1.firstBound = var7;
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
                case 1028:
                    return var1.erasure() == this;
                default:
                    return false;
            }
        }
    }

    public boolean method_155() {
        return this.typeVariables != Binding.NO_TYPE_VARIABLES;
    }

    public int kind() {
        return this.typeVariables != Binding.NO_TYPE_VARIABLES ? 2052 : 4;
    }

    public ReferenceBinding[] memberTypes() {
        if ((this.tagBits & 268435456L) == 0L) {
            return this.field_236;
        } else {
            int var1 = this.field_236.length;
            while (true) {
                --var1;
                if (var1 < 0) {
                    this.tagBits &= -268435457L;
                    return this.field_236;
                }
                this.field_236[var1] = method_267(this.field_236[var1], this.environment, false);
            }
        }
    }

    public MethodBinding[] methods() {
        if ((this.tagBits & 32768L) != 0L) {
            return this.methods;
        } else {
            int var1;
            if ((this.tagBits & 16384L) == 0L) {
                var1 = this.methods.length;
                if (var1 > 1) {
                    ReferenceBinding.sortMethods(this.methods, 0, var1);
                }
                this.tagBits |= 16384L;
            }
            var1 = this.methods.length;
            while (true) {
                --var1;
                if (var1 < 0) {
                    this.tagBits |= 32768L;
                    return this.methods;
                }
                this.resolveTypesFor(this.methods[var1]);
            }
        }
    }

    private FieldBinding resolveTypeFor(FieldBinding var1) {
        if ((var1.field_300 & 33554432) == 0) {
            return var1;
        } else {
            TypeBinding var2 = method_268(var1.type, this.environment, (ParameterizedTypeBinding)null, 0);
            var1.type = var2;
            if ((var2.tagBits & 128L) != 0L) {
                var1.tagBits |= 128L;
            }
            var1.field_300 &= -33554433;
            return var1;
        }
    }

    MethodBinding resolveTypesFor(MethodBinding var1) {
        if ((var1.modifiers & 33554432) == 0) {
            return var1;
        } else {
            if (!var1.method_358()) {
                TypeBinding var2 = method_268(var1.returnType, this.environment, (ParameterizedTypeBinding)null, 0);
                var1.returnType = var2;
                if ((var2.tagBits & 128L) != 0L) {
                    var1.tagBits |= 128L;
                }
            }
            int var4 = var1.parameters.length;
            while (true) {
                --var4;
                if (var4 < 0) {
                    var4 = var1.thrownExceptions.length;
                    while (true) {
                        --var4;
                        if (var4 < 0) {
                            var4 = var1.typeVariables.length;
                            while (true) {
                                --var4;
                                if (var4 < 0) {
                                    var1.modifiers &= -33554433;
                                    return var1;
                                }
                                var1.typeVariables[var4].method_260(this.environment);
                            }
                        }
                        ReferenceBinding var5 = method_267(var1.thrownExceptions[var4], this.environment, true);
                        var1.thrownExceptions[var4] = var5;
                        if ((var5.tagBits & 128L) != 0L) {
                            var1.tagBits |= 128L;
                        }
                    }
                }
                TypeBinding var3 = method_268(var1.parameters[var4], this.environment, (ParameterizedTypeBinding)null, 0);
                var1.parameters[var4] = var3;
                if ((var3.tagBits & 128L) != 0L) {
                    var1.tagBits |= 128L;
                }
            }
        }
    }

    AnnotationBinding[] retrieveAnnotations(Binding var1) {
        return AnnotationBinding.addStandardAnnotations(super.retrieveAnnotations(var1), var1.getAnnotationTagBits(), this.environment);
    }

    SimpleLookupTable storedAnnotations(boolean var1) {
        if (var1 && this.storedAnnotations == null) {
            if (!this.environment.globalOptions.field_1963) {
                return null;
            }
            SimpleLookupTable var10001 = new SimpleLookupTable(3);
            this.storedAnnotations = var10001;
        }
        return this.storedAnnotations;
    }

    public ReferenceBinding superclass() {
        if ((this.tagBits & 33554432L) == 0L) {
            return this.field_231;
        } else {
            this.field_231 = method_267(this.field_231, this.environment, true);
            this.tagBits &= -33554433L;
            if (this.field_231.problemId() == 1) {
                this.tagBits |= 131072L;
            }
            return this.field_231;
        }
    }

    public ReferenceBinding[] superInterfaces() {
        if ((this.tagBits & 67108864L) == 0L) {
            return this.field_233;
        } else {
            int var1 = this.field_233.length;
            while (true) {
                --var1;
                if (var1 < 0) {
                    this.tagBits &= -67108865L;
                    return this.field_233;
                }
                this.field_233[var1] = method_267(this.field_233[var1], this.environment, true);
                if (this.field_233[var1].problemId() == 1) {
                    this.tagBits |= 131072L;
                }
            }
        }
    }

    public TypeVariableBinding[] typeVariables() {
        if ((this.tagBits & 16777216L) == 0L) {
            return this.typeVariables;
        } else {
            int var1 = this.typeVariables.length;
            while (true) {
                --var1;
                if (var1 < 0) {
                    this.tagBits &= -16777217L;
                    return this.typeVariables;
                }
                this.typeVariables[var1].method_260(this.environment);
            }
        }
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer();
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
        var1.append(this.compoundName != null ? CharOperation.toString(this.compoundName) : "UNNAMED TYPE");
        var1.append("\n\textends ");
        var1.append(this.field_231 != null ? this.field_231.debugName() : "NULL TYPE");
        int var2;
        int var3;
        if (this.field_233 != null) {
            if (this.field_233 != Binding.field_155) {
                var1.append("\n\timplements : ");
                var2 = 0;
                for (var3 = this.field_233.length; var2 < var3; ++var2) {
                    if (var2 > 0) {
                        var1.append(", ");
                    }
                    var1.append(this.field_233[var2] != null ? this.field_233[var2].debugName() : "NULL TYPE");
                }
            }
        } else {
            var1.append("NULL SUPERINTERFACES");
        }
        if (this.field_232 != null) {
            var1.append("\n\tenclosing type : ");
            var1.append(this.field_232.debugName());
        }
        if (this.fields != null) {
            if (this.fields != Binding.field_153) {
                var1.append("\n/*   fields   */");
                var2 = 0;
                for (var3 = this.fields.length; var2 < var3; ++var2) {
                    var1.append(this.fields[var2] != null ? "\n" + this.fields[var2].toString() : "\nNULL FIELD");
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
                    var1.append(this.methods[var2] != null ? "\n" + this.methods[var2].toString() : "\nNULL METHOD");
                }
            }
        } else {
            var1.append("NULL METHODS");
        }
        if (this.field_236 != null) {
            if (this.field_236 != Binding.field_156) {
                var1.append("\n/*   members   */");
                var2 = 0;
                for (var3 = this.field_236.length; var2 < var3; ++var2) {
                    var1.append(this.field_236[var2] != null ? "\n" + this.field_236[var2].toString() : "\nNULL TYPE");
                }
            }
        } else {
            var1.append("NULL MEMBER TYPES");
        }
        var1.append("\n\n\n");
        return var1.toString();
    }

    MethodBinding[] unResolvedMethods() {
        return this.methods;
    }
}
