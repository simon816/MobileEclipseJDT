package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ast.CaseStatement;
import org.eclipse.jdt.internal.compiler.ast.TypeParameter;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ImportReference;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.impl.ReferenceContext;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;
import org.eclipse.jdt.internal.compiler.lookup.InvocationSite;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.Substitution;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.ImportBinding;
import org.eclipse.jdt.internal.compiler.lookup.ImportConflictBinding;
import org.eclipse.jdt.internal.compiler.lookup.ProblemBinding;
import org.eclipse.jdt.internal.compiler.lookup.PackageBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ArrayBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.WildcardBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.CaptureBinding;
import org.eclipse.jdt.internal.compiler.lookup.MissingTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ProblemReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.ParameterizedTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding2;
import org.eclipse.jdt.internal.compiler.lookup.ProblemMethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.ParameterizedMethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.ParameterizedGenericMethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.ProblemFieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;
import org.eclipse.jdt.internal.compiler.lookup.MethodVerifier;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.lookup.CompilationUnitScope;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodScope;
import org.eclipse.jdt.internal.compiler.problem.AbortCompilation;
import org.eclipse.jdt.internal.compiler.problem.ProblemReporter;
import org.eclipse.jdt.internal.compiler.util.SimpleSet;
import org.eclipse.jdt.internal.compiler.util.HashtableOfObject;
import org.eclipse.jdt.internal.compiler.util.ObjectVector;

import java.util.List;
import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;
import java.util.ArrayList;

public abstract class Scope implements TypeConstants {

    public int kind;

    public Scope parent;

    private static final char[][] field_375 = field_92;

    public static int compareTypes(TypeBinding var0, TypeBinding var1) {
        return var0.isCompatibleWith(var1) ? -1 : (var1.isCompatibleWith(var0) ? 1 : 0);
    }

    public static TypeBinding getBaseType(char[] var0) {
        int var1 = var0.length;
        if (var1 > 2 && var1 < 8) {
            switch (var0[0]) {
                case 98:
                    if (var1 == 7 && var0[1] == 111 && var0[2] == 111 && var0[3] == 108 && var0[4] == 101 && var0[5] == 97 && var0[6] == 110) {
                        return TypeBinding.field_186;
                    }
                    if (var1 == 4 && var0[1] == 121 && var0[2] == 116 && var0[3] == 101) {
                        return TypeBinding.field_180;
                    }
                    break;
                case 99:
                    if (var1 == 4 && var0[1] == 104 && var0[2] == 97 && var0[3] == 114) {
                        return TypeBinding.field_182;
                    }
                    break;
                case 100:
                    if (var1 == 6 && var0[1] == 111 && var0[2] == 117 && var0[3] == 98 && var0[4] == 108 && var0[5] == 101) {
                        return TypeBinding.field_185;
                    }
                case 101:
                case 103:
                case 104:
                case 106:
                case 107:
                case 109:
                case 110:
                case 111:
                case 112:
                case 113:
                case 114:
                case 116:
                case 117:
                default:
                    break;
                case 102:
                    if (var1 == 5 && var0[1] == 108 && var0[2] == 111 && var0[3] == 97 && var0[4] == 116) {
                        return TypeBinding.field_184;
                    }
                    break;
                case 105:
                    if (var1 == 3 && var0[1] == 110 && var0[2] == 116) {
                        return TypeBinding.field_179;
                    }
                    break;
                case 108:
                    if (var1 == 4 && var0[1] == 111 && var0[2] == 110 && var0[3] == 103) {
                        return TypeBinding.field_183;
                    }
                    break;
                case 115:
                    if (var1 == 5 && var0[1] == 104 && var0[2] == 111 && var0[3] == 114 && var0[4] == 116) {
                        return TypeBinding.field_181;
                    }
                    break;
                case 118:
                    if (var1 == 4 && var0[1] == 111 && var0[2] == 105 && var0[3] == 100) {
                        return TypeBinding.field_188;
                    }
            }
        }
        return null;
    }

    public static ReferenceBinding[] greaterLowerBound(ReferenceBinding[] var0) {
        if (var0 == null) {
            return null;
        } else {
            int var1 = var0.length;
            if (var1 == 0) {
                return null;
            } else {
                ReferenceBinding[] var2 = var0;
                int var3 = 0;
                int var6;
                ReferenceBinding var7;
                for (int var4 = 0; var4 < var1; ++var4) {
                    ReferenceBinding var5 = var2[var4];
                    if (var5 != null) {
                        for (var6 = 0; var6 < var1; ++var6) {
                            if (var4 != var6) {
                                var7 = var2[var6];
                                if (var7 != null && var5.isCompatibleWith(var7)) {
                                    if (var2 == var0) {
                                        System.arraycopy(var2, 0, var2 = new ReferenceBinding[var1], 0, var1);
                                    }
                                    var2[var6] = null;
                                    ++var3;
                                }
                            }
                        }
                    }
                }
                if (var3 == 0) {
                    return var2;
                } else if (var1 == var3) {
                    return null;
                } else {
                    ReferenceBinding[] var8 = new ReferenceBinding[var1 - var3];
                    int var9 = 0;
                    for (var6 = 0; var9 < var1; ++var9) {
                        var7 = var2[var9];
                        if (var7 != null) {
                            var8[var6++] = var7;
                        }
                    }
                    return var8;
                }
            }
        }
    }

    public static TypeBinding[] greaterLowerBound(TypeBinding[] var0) {
        if (var0 == null) {
            return null;
        } else {
            int var1 = var0.length;
            if (var1 == 0) {
                return null;
            } else {
                TypeBinding[] var2 = var0;
                int var3 = 0;
                int var6;
                TypeBinding var7;
                for (int var4 = 0; var4 < var1; ++var4) {
                    TypeBinding var5 = var2[var4];
                    if (var5 != null) {
                        for (var6 = 0; var6 < var1; ++var6) {
                            if (var4 != var6) {
                                var7 = var2[var6];
                                if (var7 != null && var5.isCompatibleWith(var7)) {
                                    if (var2 == var0) {
                                        System.arraycopy(var2, 0, var2 = new TypeBinding[var1], 0, var1);
                                    }
                                    var2[var6] = null;
                                    ++var3;
                                }
                            }
                        }
                    }
                }
                if (var3 == 0) {
                    return var2;
                } else if (var1 == var3) {
                    return null;
                } else {
                    TypeBinding[] var8 = new TypeBinding[var1 - var3];
                    int var9 = 0;
                    for (var6 = 0; var9 < var1; ++var9) {
                        var7 = var2[var9];
                        if (var7 != null) {
                            var8[var6++] = var7;
                        }
                    }
                    return var8;
                }
            }
        }
    }

    public static ReferenceBinding[] substitute(Substitution var0, ReferenceBinding[] var1) {
        if (var1 == null) {
            return null;
        } else {
            ReferenceBinding[] var2 = var1;
            int var3 = 0;
            for (int var4 = var1.length; var3 < var4; ++var3) {
                ReferenceBinding var5 = var1[var3];
                TypeBinding var6 = substitute(var0, var5);
                if (!(var6 instanceof ReferenceBinding)) {
                    return null;
                }
                if (var6 != var5) {
                    if (var2 == var1) {
                        System.arraycopy(var1, 0, var2 = new ReferenceBinding[var4], 0, var3);
                    }
                    var2[var3] = (ReferenceBinding)var6;
                } else if (var2 != var1) {
                    var2[var3] = var5;
                }
            }
            return var2;
        }
    }

    public static TypeBinding substitute(Substitution var0, TypeBinding var1) {
        if (var1 == null) {
            return null;
        } else {
            ReferenceBinding var3;
            ReferenceBinding var4;
            TypeBinding[] var6;
            ReferenceBinding var11;
            switch (var1.kind()) {
                case 4:
                    if (var1.method_159()) {
                        var11 = (ReferenceBinding)var1;
                        var3 = var1.enclosingType();
                        var4 = var3;
                        if (var3 != null) {
                            var4 = (ReferenceBinding)substitute(var0, var3);
                        }
                        if (var4 != var3) {
                            return (TypeBinding)(var0.isRawSubstitution() ? var0.environment().createRawType(var11, var4) : var0.environment().createParameterizedType(var11, (TypeBinding[])null, var4));
                        }
                    }
                    break;
                case 68:
                    ArrayBinding var7 = (ArrayBinding)var1;
                    TypeBinding var8 = var7.leafComponentType;
                    TypeBinding var9 = substitute(var0, var8);
                    if (var9 != var8) {
                        return var7.environment.createArrayType(var9.method_173(), var9.method_136() + var1.method_136());
                    }
                    break;
                case 260:
                    ParameterizedTypeBinding var2 = (ParameterizedTypeBinding)var1;
                    var3 = var1.enclosingType();
                    var4 = var3;
                    if (var3 != null) {
                        var4 = (ReferenceBinding)substitute(var0, var3);
                    }
                    TypeBinding[] var16 = var2.arguments;
                    var6 = var16;
                    if (var16 != null) {
                        if (var0.isRawSubstitution()) {
                            return var2.environment.createRawType(var2.method_286(), var4);
                        }
                        var6 = substitute(var0, var16);
                    }
                    if (var6 != var16 || var4 != var3) {
                        return var2.environment.createParameterizedType(var2.method_286(), var6, var4);
                    }
                    break;
                case 516:
                case 8196:
                    WildcardBinding var10 = (WildcardBinding)var1;
                    if (var10.field_215 != 0) {
                        TypeBinding var15 = var10.bound;
                        TypeBinding var12 = substitute(var0, var15);
                        TypeBinding[] var13 = var10.otherBounds;
                        TypeBinding[] var14 = substitute(var0, var13);
                        if (var12 != var15 || var13 != var14) {
                            return var10.environment.createWildcard(var10.field_210, var10.field_211, var12, var14, var10.field_215);
                        }
                    }
                    break;
                case 2052:
                    var11 = (ReferenceBinding)var1;
                    var3 = var1.enclosingType();
                    var4 = var3;
                    if (var3 != null) {
                        var4 = (ReferenceBinding)substitute(var0, var3);
                    }
                    if (var0.isRawSubstitution()) {
                        return var0.environment().createRawType(var11, var4);
                    }
                    TypeVariableBinding[] var5 = var11.typeVariables();
                    var6 = substitute(var0, var5);
                    return var0.environment().createParameterizedType(var11, var6, var4);
                case 4100:
                    return var0.substitute((TypeVariableBinding)var1);
            }
            return var1;
        }
    }

    public static TypeBinding[] substitute(Substitution var0, TypeBinding[] var1) {
        if (var1 == null) {
            return null;
        } else {
            TypeBinding[] var2 = var1;
            int var3 = 0;
            for (int var4 = var1.length; var3 < var4; ++var3) {
                TypeBinding var5 = var1[var3];
                TypeBinding var6 = substitute(var0, var5);
                if (var6 != var5) {
                    if (var2 == var1) {
                        System.arraycopy(var1, 0, var2 = new TypeBinding[var4], 0, var3);
                    }
                    var2[var3] = var6;
                } else if (var2 != var1) {
                    var2[var3] = var5;
                }
            }
            return var2;
        }
    }

    protected Scope(int var1, Scope var2) {
        this.kind = var1;
        this.parent = var2;
    }

    public TypeBinding boxing(TypeBinding var1) {
        return var1.method_148() ? this.environment().method_486(var1) : var1;
    }

    public final ClassScope method_575() {
        Scope var1 = this;
        while (!(var1 instanceof ClassScope)) {
            var1 = var1.parent;
            if (var1 == null) {
                return null;
            }
        }
        return (ClassScope)var1;
    }

    public final CompilationUnitScope compilationUnitScope() {
        Scope var1 = null;
        Scope var2 = this;
        do {
            var1 = var2;
            var2 = var2.parent;
        } while (var2 != null);
        return (CompilationUnitScope)var1;
    }

    public final CompilerOptions compilerOptions() {
        return this.compilationUnitScope().environment.globalOptions;
    }

    protected final MethodBinding computeCompatibleMethod(MethodBinding var1, TypeBinding[] var2, InvocationSite var3) {
        TypeBinding[] var4 = var3.genericTypeArguments();
        TypeBinding[] var5 = var1.parameters;
        TypeVariableBinding[] var6 = var1.typeVariables;
        if (var5 == var2 && (var1.returnType.tagBits & 536870912L) == 0L && var4 == null && var6 == Binding.NO_TYPE_VARIABLES) {
            return var1;
        } else {
            int var7 = var2.length;
            int var8 = var5.length;
            boolean var9 = var1.method_374();
            if (var7 != var8 && (!var9 || var7 < var8 - 1)) {
                return null;
            } else {
                ProblemMethodBinding var10000;
                if (var6 != Binding.NO_TYPE_VARIABLES) {
                    TypeBinding[] var10 = null;
                    for (int var11 = 0; var11 < var7; ++var11) {
                        TypeBinding var12 = var11 < var8 ? var5[var11] : var5[var8 - 1];
                        if (var2[var11].method_148() != var12.method_148()) {
                            if (var10 == null) {
                                var10 = new TypeBinding[var7];
                                System.arraycopy(var2, 0, var10, 0, var7);
                            }
                            var10[var11] = this.environment().method_486(var2[var11]);
                        }
                    }
                    if (var10 != null) {
                        var2 = var10;
                    }
                    var1 = ParameterizedGenericMethodBinding.computeCompatibleMethod(var1, var2, this, var3);
                    if (var1 == null) {
                        return null;
                    }
                    if (!var1.isValidBinding()) {
                        return var1;
                    }
                } else if (var4 != null) {
                    if (var1 instanceof ParameterizedGenericMethodBinding) {
                        if (!((ParameterizedGenericMethodBinding)var1).field_296) {
                            var10000 = new ProblemMethodBinding(var1, var1.selector, var4, 13);
                            return var10000;
                        }
                    } else if (this.compilerOptions().field_1927 < 3342336L) {
                        var10000 = new ProblemMethodBinding(var1, var1.selector, var4, 11);
                        return var10000;
                    }
                }
                if (this.parameterCompatibilityLevel(var1, var2) > -1) {
                    return var1;
                } else if (var4 != null) {
                    var10000 = new ProblemMethodBinding(var1, var1.selector, var2, 12);
                    return var10000;
                } else {
                    return null;
                }
            }
        }
    }

    protected boolean connectTypeVariables(TypeParameter[] var1, boolean var2) {
        if (var1 != null && this.compilerOptions().field_1928 >= 3211264L) {
            HashMap var10000 = new HashMap(2);
            HashMap var3 = var10000;
            boolean var4 = true;
            int var5 = 0;
            int var6;
            TypeParameter var7;
            TypeVariableBinding var8;
            for (var6 = var1.length; var5 < var6; ++var5) {
                var7 = var1[var5];
                var8 = var7.binding;
                if (var8 == null) {
                    return false;
                }
                var8.superclass = this.method_609();
                var8.superInterfaces = Binding.field_155;
                var8.firstBound = null;
            }
            var5 = 0;
            for (var6 = var1.length; var5 < var6; ++var5) {
                var7 = var1[var5];
                var8 = var7.binding;
                TypeReference var9 = var7.type;
                if (var9 != null) {
                    boolean var10 = false;
                    TypeBinding var11 = this.kind == 2 ? var9.resolveType((BlockScope)this, false) : var9.resolveType((ClassScope)this);
                    if (var11 == null) {
                        var8.tagBits |= 131072L;
                    } else {
                        label155: {
                            var9.resolvedType = var11;
                            switch (var11.kind()) {
                                case 68:
                                    this.problemReporter().method_1486(var9, var11);
                                    var8.tagBits |= 131072L;
                                    break label155;
                                case 4100:
                                    var10 = true;
                                    TypeVariableBinding var12 = (TypeVariableBinding)var11;
                                    if (var12.rank >= var8.rank && var12.declaringElement == var8.declaringElement && this.compilerOptions().field_1927 <= 3276800L) {
                                        this.problemReporter().forwardTypeVariableReference(var7, var12);
                                        var8.tagBits |= 131072L;
                                        break label155;
                                    }
                                    break;
                                default:
                                    if (((ReferenceBinding)var11).method_221()) {
                                        this.problemReporter().finalVariableBound(var8, var9);
                                    }
                            }
                            ReferenceBinding var19 = (ReferenceBinding)var11;
                            if (!var11.method_157()) {
                                var8.superclass = var19;
                            } else {
                                var8.superInterfaces = new ReferenceBinding[] {var19};
                            }
                            var8.firstBound = var19;
                        }
                    }
                    TypeReference[] var20 = var7.bounds;
                    if (var20 != null) {
                        int var13 = 0;
                        for (int var14 = var20.length; var13 < var14; ++var13) {
                            var9 = var20[var13];
                            var11 = this.kind == 2 ? var9.resolveType((BlockScope)this, false) : var9.resolveType((ClassScope)this);
                            if (var11 == null) {
                                var8.tagBits |= 131072L;
                            } else {
                                boolean var15 = !var9.resolvedType.isValidBinding();
                                if (var10 && var13 == 0) {
                                    this.problemReporter().method_1692(var9);
                                    var8.tagBits |= 131072L;
                                    var15 = true;
                                } else {
                                    if (var11.method_147()) {
                                        if (!var15) {
                                            this.problemReporter().method_1486(var9, var11);
                                            var8.tagBits |= 131072L;
                                        }
                                        continue;
                                    }
                                    if (!var11.method_157()) {
                                        if (!var15) {
                                            this.problemReporter().method_1487(var9, var11);
                                            var8.tagBits |= 131072L;
                                        }
                                        continue;
                                    }
                                }
                                if (!var2 || var8.firstBound != var8.superclass || !this.method_621(var11, var8.superclass, var3, var8, var9)) {
                                    ReferenceBinding var16 = (ReferenceBinding)var11;
                                    int var17 = var8.superInterfaces.length;
                                    ReferenceBinding var18;
                                    do {
                                        --var17;
                                        if (var17 < 0) {
                                            var17 = var8.superInterfaces.length;
                                            System.arraycopy(var8.superInterfaces, 0, var8.superInterfaces = new ReferenceBinding[var17 + 1], 0, var17);
                                            var8.superInterfaces[var17] = var16;
                                            break;
                                        }
                                        var18 = var8.superInterfaces[var17];
                                        if (var18 == var16) {
                                            this.problemReporter().method_1520(var9, var11);
                                            var8.tagBits |= 131072L;
                                            break;
                                        }
                                    } while (!var2 || !this.method_621(var11, var18, var3, var8, var9));
                                }
                            }
                        }
                    }
                    var4 &= (var8.tagBits & 131072L) == 0L;
                }
            }
            return var4;
        } else {
            return true;
        }
    }

    public ArrayBinding createArrayType(TypeBinding var1, int var2) {
        if (var1.isValidBinding()) {
            return this.environment().createArrayType(var1, var2);
        } else {
            ArrayBinding var10000 = new ArrayBinding(var1, var2, this.environment());
            return var10000;
        }
    }

    public TypeVariableBinding[] createTypeVariables(TypeParameter[] var1, Binding var2) {
        if (var1 != null && this.compilerOptions().field_1928 >= 3211264L) {
            PackageBinding var3 = this.compilationUnitScope().fPackage;
            int var4 = var1.length;
            TypeVariableBinding[] var5 = new TypeVariableBinding[var4];
            int var6 = 0;
            for (int var7 = 0; var7 < var4; ++var7) {
                TypeParameter var8 = var1[var7];
                TypeVariableBinding var10000 = new TypeVariableBinding(var8.name, var2, var7);
                TypeVariableBinding var9 = var10000;
                var9.fPackage = var3;
                var8.binding = var9;
                for (int var10 = 0; var10 < var6; ++var10) {
                    TypeVariableBinding var11 = var5[var10];
                    if (CharOperation.method_1364(var11.sourceName, var8.name)) {
                        this.problemReporter().duplicateTypeParameterInType(var8);
                    }
                }
                var5[var6++] = var9;
            }
            if (var6 != var4) {
                System.arraycopy(var5, 0, var5 = new TypeVariableBinding[var6], 0, var6);
            }
            return var5;
        } else {
            return Binding.NO_TYPE_VARIABLES;
        }
    }

    public final ClassScope method_582() {
        Scope var1 = this;
        do {
            if ((var1 = var1.parent) == null) {
                return null;
            }
        } while (!(var1 instanceof ClassScope));
        return (ClassScope)var1;
    }

    public final MethodScope method_583() {
        Scope var1 = this;
        do {
            if ((var1 = var1.parent) == null) {
                return null;
            }
        } while (!(var1 instanceof MethodScope));
        return (MethodScope)var1;
    }

    public final ReferenceBinding method_584() {
        Scope var1 = this;
        while (!(var1 instanceof ClassScope)) {
            var1 = var1.parent;
            if (var1 == null) {
                return null;
            }
        }
        return this.environment().convertToParameterizedType(((ClassScope)var1).referenceContext.binding);
    }

    public final SourceTypeBinding enclosingSourceType() {
        Scope var1 = this;
        while (!(var1 instanceof ClassScope)) {
            var1 = var1.parent;
            if (var1 == null) {
                return null;
            }
        }
        return ((ClassScope)var1).referenceContext.binding;
    }

    public final LookupEnvironment environment() {
        Scope var2 = this;
        while (true) {
            Scope var1 = var2.parent;
            if (var2.parent == null) {
                return ((CompilationUnitScope)var2).environment;
            }
            var2 = var1;
        }
    }

    protected MethodBinding findDefaultAbstractMethod(ReferenceBinding var1, char[] var2, TypeBinding[] var3, InvocationSite var4, ReferenceBinding var5, ObjectVector var6, MethodBinding var7) {
        int var8 = var6.size;
        for (ReferenceBinding var9 = var5; var9 != null; var9 = var9.superclass()) {
            this.method_595(var9, var2, var6);
        }
        MethodBinding[] var10 = null;
        int var11 = 0;
        MethodBinding var12 = null;
        int var13 = var6.size;
        if (var13 > var8) {
            for (int var14 = var8; var14 < var13; ++var14) {
                MethodBinding var15 = (MethodBinding)var6.elementAt(var14);
                MethodBinding var16 = this.computeCompatibleMethod(var15, var3, var4);
                if (var16 != null) {
                    if (var16.isValidBinding()) {
                        if (var7 == null || ((MethodBinding)var7).declaringClass.method_140(var16.declaringClass) == null || !this.environment().methodVerifier().method_548((MethodBinding)var7, var16)) {
                            if (var11 == 0) {
                                var10 = new MethodBinding[var13 - var8 + 1];
                                if (var7 != null) {
                                    var10[var11++] = (MethodBinding)var7;
                                }
                            }
                            var10[var11++] = var16;
                        }
                    } else if (var12 == null) {
                        var12 = var16;
                    }
                }
            }
        }
        if (var11 < 2) {
            if (var7 == null) {
                if (var11 == 0) {
                    return var12;
                }
                var7 = var10[0];
            }
            this.compilationUnitScope().recordTypeReferences(((MethodBinding)var7).thrownExceptions);
            return (MethodBinding)var7;
        } else {
            return this.compilerOptions().field_1927 >= 3145728L ? this.mostSpecificMethodBinding(var10, var11, var3, var4, var1) : this.method_638(var10, var11, var4);
        }
    }

    public ReferenceBinding method_588(char[] var1, ReferenceBinding var2) {
        if ((var2.tagBits & 65536L) != 0L) {
            return null;
        } else {
            ReferenceBinding var3 = this.method_584();
            CompilationUnitScope var4 = this.compilationUnitScope();
            var4.recordReference(var2, var1);
            ReferenceBinding var5 = var2.getMemberType(var1);
            if (var5 == null) {
                return null;
            } else {
                var4.method_693(var5);
                if (var3 == null) {
                    if (var5.canBeSeenBy(this.getCurrentPackage())) {
                        return var5;
                    }
                } else if (var5.canBeSeenBy(var2, var3)) {
                    return var5;
                }
                ProblemReferenceBinding var10000 = new ProblemReferenceBinding(new char[][] {var1}, var5, 2);
                return var10000;
            }
        }
    }

    public MethodBinding method_589(ReferenceBinding var1, char[] var2, TypeBinding[] var3, InvocationSite var4) {
        CompilationUnitScope var5 = this.compilationUnitScope();
        var5.recordTypeReferences(var3);
        MethodBinding var6 = var1.getExactMethod(var2, var3, var5);
        if (var6 != null && var6.typeVariables == Binding.NO_TYPE_VARIABLES && !var6.method_357()) {
            if (this.compilerOptions().field_1928 >= 3211264L) {
                int var7 = var3.length;
                while (true) {
                    --var7;
                    if (var7 < 0) {
                        break;
                    }
                    if (var3[var7].method_166()) {
                        return null;
                    }
                }
            }
            var5.recordTypeReferences(var6.thrownExceptions);
            if (var1.method_157() || var6.canBeSeenBy(var1, var4, this)) {
                if (var1.id != 1 && var3 == Binding.field_150 && CharOperation.method_1364(var2, TypeConstants.field_34) && var6.returnType.method_162()) {
                    return ParameterizedMethodBinding.instantiateGetClass(var1, var6, this);
                }
                if (var4.genericTypeArguments() != null) {
                    var6 = this.computeCompatibleMethod(var6, var3, var4);
                }
                return var6;
            }
        }
        return null;
    }

    public FieldBinding findField(TypeBinding var1, char[] var2, InvocationSite var3, boolean var4) {
        CompilationUnitScope var5 = this.compilationUnitScope();
        var5.method_693(var1);
        TypeBinding var6;
        ProblemFieldBinding var10000;
        switch (var1.kind()) {
            case 68:
                var6 = var1.method_173();
                break;
            case 132:
                return null;
            case 516:
            case 4100:
            case 8196:
                TypeBinding var7 = var1.erasure();
                if (var7.method_147()) {
                    var6 = var7.method_173();
                    break;
                }
            default:
                ReferenceBinding var22 = (ReferenceBinding)var1;
                if (!var22.canBeSeenBy(this)) {
                    var10000 = new ProblemFieldBinding(var22, var2, 8);
                    return var10000;
                }
                var22.initializeForStaticImports();
                FieldBinding var21 = var22.getField(var2, var4);
                if (var21 != null) {
                    if (var3 == null) {
                        if (var21.canBeSeenBy(this.getCurrentPackage())) {
                            return var21;
                        }
                    } else if (var21.canBeSeenBy(var22, var3, this)) {
                        return var21;
                    }
                    var10000 = new ProblemFieldBinding(var21, var21.declaringClass, var2, 2);
                    return var10000;
                }
                ReferenceBinding[] var8 = null;
                int var9 = 0;
                FieldBinding var10 = null;
                boolean var11 = true;
                FieldBinding var12 = null;
                int var14;
                int var17;
                while (var11) {
                    ReferenceBinding[] var13 = var22.superInterfaces();
                    if (var13 != null && var13 != Binding.field_155) {
                        if (var8 == null) {
                            var8 = var13;
                            var9 = var13.length;
                        } else {
                            var14 = var13.length;
                            if (var9 + var14 >= var8.length) {
                                System.arraycopy(var8, 0, var8 = new ReferenceBinding[var9 + var14 + 5], 0, var9);
                            }
                            label157:
                            for (int var15 = 0; var15 < var14; ++var15) {
                                ReferenceBinding var16 = var13[var15];
                                for (var17 = 0; var17 < var9; ++var17) {
                                    if (var16 == var8[var17]) {
                                        continue label157;
                                    }
                                }
                                var8[var9++] = var16;
                            }
                        }
                    }
                    if ((var22 = var22.superclass()) == null) {
                        break;
                    }
                    var5.method_693(var22);
                    var22.initializeForStaticImports();
                    if ((var21 = var22.getField(var2, var4)) != null) {
                        var11 = false;
                        if (var21.canBeSeenBy(var1, var3, this)) {
                            if (var10 != null) {
                                var10000 = new ProblemFieldBinding(var10, var10.declaringClass, var2, 3);
                                return var10000;
                            }
                            var10 = var21;
                        } else if (var12 == null) {
                            var12 = var21;
                        }
                    }
                }
                if (var8 != null) {
                    ProblemFieldBinding var23 = null;
                    for (var14 = 0; var14 < var9; ++var14) {
                        ReferenceBinding var25 = var8[var14];
                        var5.method_693(var25);
                        if ((var21 = var25.getField(var2, true)) != null) {
                            if (var10 != null) {
                                var10000 = new ProblemFieldBinding(var10, var10.declaringClass, var2, 3);
                                var23 = var10000;
                                break;
                            }
                            var10 = var21;
                        } else {
                            ReferenceBinding[] var24 = var25.superInterfaces();
                            if (var24 != null && var24 != Binding.field_155) {
                                var17 = var24.length;
                                if (var9 + var17 >= var8.length) {
                                    System.arraycopy(var8, 0, var8 = new ReferenceBinding[var9 + var17 + 5], 0, var9);
                                }
                                label130:
                                for (int var18 = 0; var18 < var17; ++var18) {
                                    ReferenceBinding var19 = var24[var18];
                                    for (int var20 = 0; var20 < var9; ++var20) {
                                        if (var19 == var8[var20]) {
                                            continue label130;
                                        }
                                    }
                                    var8[var9++] = var19;
                                }
                            }
                        }
                    }
                    if (var23 != null) {
                        return var23;
                    }
                }
                if (var10 != null) {
                    return var10;
                }
                if (var12 != null) {
                    var10000 = new ProblemFieldBinding(var12, var22, var2, 2);
                    return var10000;
                }
                return null;
        }
        if (var6 instanceof ReferenceBinding && !((ReferenceBinding)var6).canBeSeenBy(this)) {
            var10000 = new ProblemFieldBinding((ReferenceBinding)var6, var2, 8);
            return var10000;
        } else if (CharOperation.method_1364(var2, TypeConstants.field_32)) {
            if ((var6.tagBits & 128L) != 0L) {
                var10000 = new ProblemFieldBinding(ArrayBinding.ArrayLength, (ReferenceBinding)null, var2, 1);
                return var10000;
            } else {
                return ArrayBinding.ArrayLength;
            }
        } else {
            return null;
        }
    }

    public ReferenceBinding method_591(char[] var1, ReferenceBinding var2) {
        if ((var2.tagBits & 65536L) != 0L) {
            return null;
        } else {
            SourceTypeBinding var3 = this.enclosingSourceType();
            PackageBinding var4 = this.getCurrentPackage();
            CompilationUnitScope var5 = this.compilationUnitScope();
            var5.recordReference(var2, var1);
            ReferenceBinding var6 = var2.getMemberType(var1);
            ProblemReferenceBinding var10000;
            if (var6 != null) {
                var5.method_693(var6);
                if (var3 == null) {
                    if (var6.canBeSeenBy(var4)) {
                        return var6;
                    }
                } else if (var6.canBeSeenBy(var2, var3)) {
                    return var6;
                }
                var10000 = new ProblemReferenceBinding(new char[][] {var1}, var6, 2);
                return var10000;
            } else {
                ReferenceBinding var7 = var2;
                ReferenceBinding[] var8 = null;
                int var9 = 0;
                ReferenceBinding var10 = null;
                boolean var11 = true;
                ReferenceBinding var12 = null;
                int var17;
                int var22;
                while (var11) {
                    ReferenceBinding[] var13 = var7.superInterfaces();
                    if (var13 == null) {
                        ReferenceBinding var14 = var7.method_162() ? ((ParameterizedTypeBinding)var7).method_286() : var7;
                        if (var14.method_222()) {
                            return null;
                        }
                        ((SourceTypeBinding)var14).scope.connectTypeHierarchy();
                        var13 = var7.superInterfaces();
                    }
                    if (var13 != null && var13 != Binding.field_155) {
                        if (var8 == null) {
                            var8 = var13;
                            var9 = var13.length;
                        } else {
                            var22 = var13.length;
                            if (var9 + var22 >= var8.length) {
                                System.arraycopy(var8, 0, var8 = new ReferenceBinding[var9 + var22 + 5], 0, var9);
                            }
                            label156:
                            for (int var15 = 0; var15 < var22; ++var15) {
                                ReferenceBinding var16 = var13[var15];
                                for (var17 = 0; var17 < var9; ++var17) {
                                    if (var16 == var8[var17]) {
                                        continue label156;
                                    }
                                }
                                var8[var9++] = var16;
                            }
                        }
                    }
                    if ((var7 = var7.superclass()) == null) {
                        break;
                    }
                    var5.recordReference(var7, var1);
                    if ((var6 = var7.getMemberType(var1)) != null) {
                        label142: {
                            var5.method_693(var6);
                            var11 = false;
                            if (var3 == null) {
                                if (var6.canBeSeenBy(var4)) {
                                    break label142;
                                }
                            } else if (var6.canBeSeenBy(var2, var3)) {
                                break label142;
                            }
                            var12 = var6;
                            continue;
                        }
                        if (var10 != null) {
                            var10000 = new ProblemReferenceBinding(new char[][] {var1}, var10, 3);
                            return var10000;
                        }
                        var10 = var6;
                    }
                }
                if (var8 != null) {
                    ProblemReferenceBinding var21 = null;
                    for (var22 = 0; var22 < var9; ++var22) {
                        Object var24 = var8[var22];
                        var5.recordReference((ReferenceBinding)var24, var1);
                        if ((var6 = ((ReferenceBinding)var24).getMemberType(var1)) != null) {
                            var5.method_693(var6);
                            if (var10 != null) {
                                var10000 = new ProblemReferenceBinding(new char[][] {var1}, var10, 3);
                                var21 = var10000;
                                break;
                            }
                            var10 = var6;
                        } else {
                            ReferenceBinding[] var23 = ((ReferenceBinding)var24).superInterfaces();
                            if (var23 != null && var23 != Binding.field_155) {
                                var17 = var23.length;
                                if (var9 + var17 >= var8.length) {
                                    System.arraycopy(var8, 0, var8 = new ReferenceBinding[var9 + var17 + 5], 0, var9);
                                }
                                label119:
                                for (int var18 = 0; var18 < var17; ++var18) {
                                    ReferenceBinding var19 = var23[var18];
                                    for (int var20 = 0; var20 < var9; ++var20) {
                                        if (var19 == var8[var20]) {
                                            continue label119;
                                        }
                                    }
                                    var8[var9++] = var19;
                                }
                            }
                        }
                    }
                    if (var21 != null) {
                        return var21;
                    }
                }
                if (var10 != null) {
                    return var10;
                } else if (var12 != null) {
                    var10000 = new ProblemReferenceBinding(new char[][] {var1}, var12, 2);
                    return var10000;
                } else {
                    return null;
                }
            }
        }
    }

    public MethodBinding method_592(ReferenceBinding var1, char[] var2, TypeBinding[] var3, InvocationSite var4) {
        return this.findMethod(var1, var2, var3, var4, false);
    }

    public MethodBinding findMethod(ReferenceBinding var1, char[] var2, TypeBinding[] var3, InvocationSite var4, boolean var5) {
        ReferenceBinding var6 = var1;
        boolean var7 = var1.method_157();
        ObjectVector var10000 = new ObjectVector(3);
        ObjectVector var8 = var10000;
        CompilationUnitScope var9 = this.compilationUnitScope();
        var9.recordTypeReferences(var3);
        if (var7) {
            var9.method_693(var1);
            MethodBinding[] var10 = var1.getMethods(var2);
            if (var10.length > 0) {
                var8.method_3232(var10);
            }
            this.method_595(var1, var2, var8);
            var6 = this.method_609();
        }
        long var33 = this.compilerOptions().field_1927;
        boolean var12 = var33 >= 3145728L;
        boolean var13 = var33 >= 3211264L;
        ReferenceBinding var14 = var6;
        int var18;
        int var21;
        MethodBinding var23;
        int var22;
        for (MethodVerifier var15 = this.environment().methodVerifier(); var6 != null; var6 = var6.superclass()) {
            var9.method_693(var6);
            MethodBinding[] var16 = var6.getMethods(var2);
            int var17 = var16.length;
            if (var17 > 0) {
                int var19;
                MethodBinding var20;
                if (var12 && (var7 || var8.size > 0)) {
                    var18 = 0;
                    for (var19 = var17; var18 < var19; ++var18) {
                        var20 = var16[var18];
                        if (var20 != null) {
                            if (var7 && !var20.method_369()) {
                                --var17;
                                var16[var18] = null;
                            } else {
                                var21 = 0;
                                for (var22 = var8.size; var21 < var22; ++var21) {
                                    var23 = (MethodBinding)var8.elementAt(var21);
                                    if (var15.method_548(var23.original(), var20.original())) {
                                        if (!var13 || !var23.method_357() || var20.method_357()) {
                                            --var17;
                                            var16[var18] = null;
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                if (var17 > 0) {
                    if (var16.length == var17) {
                        var8.method_3232(var16);
                    } else {
                        var18 = 0;
                        for (var19 = var16.length; var18 < var19; ++var18) {
                            var20 = var16[var18];
                            if (var20 != null) {
                                var8.add(var20);
                            }
                        }
                    }
                }
            }
        }
        int var34 = var8.size;
        MethodBinding[] var35 = null;
        var18 = 0;
        MethodBinding var37 = null;
        boolean var36 = var12 && !var7 && (var1.method_217() || var1.method_169());
        MethodBinding var38;
        if (var34 > 0) {
            for (var21 = 0; var21 < var34; ++var21) {
                var38 = (MethodBinding)var8.elementAt(var21);
                var23 = this.computeCompatibleMethod(var38, var3, var4);
                if (var23 != null) {
                    if (var23.isValidBinding()) {
                        if (var34 == 1 && var23.canBeSeenBy(var1, var4, this)) {
                            if (var36) {
                                return this.findDefaultAbstractMethod(var1, var2, var3, var4, var14, var8, var23);
                            }
                            var9.recordTypeReferences(var23.thrownExceptions);
                            return var23;
                        }
                        if (var18 == 0) {
                            var35 = new MethodBinding[var34];
                        }
                        var35[var18++] = var23;
                    } else if (var37 == null) {
                        var37 = var23;
                    }
                }
            }
        }
        int var24;
        ProblemMethodBinding var46;
        if (var18 == 0) {
            MethodBinding var40 = this.findDefaultAbstractMethod(var1, var2, var3, var4, var14, var8, (MethodBinding)null);
            if (var40 != null) {
                return var40;
            } else if (var8.size == 0) {
                return null;
            } else if (var37 != null) {
                return var37;
            } else {
                var22 = -1;
                var23 = (MethodBinding)var8.elementAt(0);
                var24 = var3.length;
                var34 = var8.size;
                for (int var42 = 0; var42 < var34; ++var42) {
                    MethodBinding var26 = (MethodBinding)var8.elementAt(var42);
                    TypeBinding[] var27 = var26.parameters;
                    int var28 = var27.length;
                    int var29 = 0;
                    int var30 = 0;
                    int var32;
                    while (var30 < var24) {
                        TypeBinding var31 = var3[var30];
                        var32 = var30 == 0 ? 0 : var30 - 1;
                        while (true) {
                            if (var32 < var28 && var32 < var30 + 1) {
                                if (var27[var32] != var31) {
                                    ++var32;
                                    continue;
                                }
                                ++var29;
                            }
                            ++var30;
                            break;
                        }
                    }
                    if (var29 >= var22) {
                        if (var29 == var22) {
                            var30 = var28 < var24 ? 2 * (var24 - var28) : var28 - var24;
                            int var45 = var23.parameters.length;
                            var32 = var45 < var24 ? 2 * (var24 - var45) : var45 - var24;
                            if (var30 >= var32) {
                                continue;
                            }
                        }
                        var22 = var29;
                        var23 = var26;
                    }
                }
                var46 = new ProblemMethodBinding(var23, var23.selector, var3, 1);
                return var46;
            }
        } else {
            var21 = 0;
            if (var7) {
                if (var18 == 1) {
                    var9.recordTypeReferences(var35[0].thrownExceptions);
                    return var35[0];
                }
                var21 = var18;
            } else {
                for (var22 = 0; var22 < var18; ++var22) {
                    Object var43 = var35[var22];
                    if (((MethodBinding)var43).canBeSeenBy(var1, var4, this)) {
                        if (var21 != var22) {
                            var35[var22] = null;
                            var35[var21] = (MethodBinding)var43;
                        }
                        ++var21;
                    }
                }
                switch (var21) {
                    case 0:
                        var38 = this.findDefaultAbstractMethod(var1, var2, var3, var4, var14, var8, (MethodBinding)null);
                        if (var38 != null) {
                            return var38;
                        }
                        var46 = new ProblemMethodBinding(var35[0], var35[0].selector, var35[0].parameters, 2);
                        return var46;
                    case 1:
                        if (var36) {
                            return this.findDefaultAbstractMethod(var1, var2, var3, var4, var14, var8, var35[0]);
                        }
                        var9.recordTypeReferences(var35[0].thrownExceptions);
                        return var35[0];
                }
            }
            if (var33 <= 3080192L) {
                ReferenceBinding var39 = var35[0].declaringClass;
                return !var39.method_157() ? this.method_637(var35, var21, var4) : this.method_638(var35, var21, var4);
            } else {
                if (this.compilerOptions().field_1928 >= 3211264L) {
                    for (var22 = 0; var22 < var21; ++var22) {
                        var23 = var35[var22];
                        if (var23 instanceof ParameterizedGenericMethodBinding) {
                            var23 = ((ParameterizedGenericMethodBinding)var23).originalMethod;
                        }
                        if (var23 instanceof ParameterizedMethodBinding) {
                            for (var24 = var22 + 1; var24 < var21; ++var24) {
                                MethodBinding var25 = var35[var24];
                                if (var25 == var23 || var23.declaringClass == var25.declaringClass && var23.method_344(var25)) {
                                    var46 = new ProblemMethodBinding(var35[var22], var35[var22].selector, var35[var22].parameters, 3);
                                    return var46;
                                }
                            }
                        }
                    }
                }
                if (var5) {
                    MethodBinding[] var44 = new MethodBinding[var21];
                    int var41 = 0;
                    for (var24 = 0; var24 < var21; ++var24) {
                        if (var35[var24].method_370()) {
                            var44[var41++] = var35[var24];
                        }
                    }
                    if (var41 == 1) {
                        return var44[0];
                    }
                    if (var41 > 1) {
                        return this.mostSpecificMethodBinding(var44, var41, var3, var4, var1);
                    }
                }
                var38 = this.mostSpecificMethodBinding(var35, var21, var3, var4, var1);
                if (var36) {
                    if (var38.isValidBinding()) {
                        return this.findDefaultAbstractMethod(var1, var2, var3, var4, var14, var8, var38);
                    }
                    var23 = this.findDefaultAbstractMethod(var1, var2, var3, var4, var14, var8, (MethodBinding)null);
                    if (var23 != null && var23.isValidBinding()) {
                        return var23;
                    }
                }
                return var38;
            }
        }
    }

    public MethodBinding findMethodForArray(ArrayBinding var1, char[] var2, TypeBinding[] var3, InvocationSite var4) {
        TypeBinding var5 = var1.method_173();
        ProblemMethodBinding var8;
        if (var5 instanceof ReferenceBinding && !((ReferenceBinding)var5).canBeSeenBy(this)) {
            var8 = new ProblemMethodBinding(var2, Binding.field_150, (ReferenceBinding)var5, 8);
            return var8;
        } else {
            ReferenceBinding var6 = this.method_609();
            MethodBinding var7 = var6.getExactMethod(var2, var3, (CompilationUnitScope)null);
            if (var7 != null) {
                if (var3 == Binding.field_150) {
                    switch (var2[0]) {
                        case 99:
                            if (CharOperation.method_1364(var2, TypeConstants.field_33)) {
                                TypeBinding var9;
                                if (this.compilerOptions().field_1929 >= 3145728L) {
                                    var9 = var1;
                                } else {
                                    var9 = var6;
                                }
                                MethodBinding2 var10000 = new MethodBinding2(var9, var7.modifiers & -5 | 1, TypeConstants.field_33, var7.returnType, var3, (ReferenceBinding[])null, var6);
                                return var10000;
                            }
                            break;
                        case 103:
                            if (CharOperation.method_1364(var2, TypeConstants.field_34) && var7.returnType.method_162()) {
                                return ParameterizedMethodBinding.instantiateGetClass(var1, var7, this);
                            }
                    }
                }
                if (var7.canBeSeenBy(var1, var4, this)) {
                    return var7;
                }
            }
            var7 = this.method_592(var6, var2, var3, var4);
            if (var7 == null) {
                var8 = new ProblemMethodBinding(var2, var3, 1);
                return var8;
            } else {
                return var7;
            }
        }
    }

    protected void method_595(ReferenceBinding var1, char[] var2, ObjectVector var3) {
        ReferenceBinding[] var4 = var1.superInterfaces();
        if (var4 != null && var4 != Binding.field_155) {
            ReferenceBinding[] var5 = var4;
            int var6 = var4.length;
            for (int var7 = 0; var7 < var6; ++var7) {
                var1 = var5[var7];
                this.compilationUnitScope().method_693(var1);
                MethodBinding[] var8 = var1.getMethods(var2);
                int var9;
                int var10;
                if (var8.length > 0) {
                    var9 = var3.size;
                    if (var9 > 0) {
                        var10 = 0;
                        label67:
                        for (int var11 = var8.length; var10 < var11; ++var10) {
                            MethodBinding var12 = var8[var10];
                            for (int var13 = 0; var13 < var9; ++var13) {
                                if (var12 == var3.elementAt(var13)) {
                                    continue label67;
                                }
                            }
                            var3.add(var12);
                        }
                    } else {
                        var3.method_3232(var8);
                    }
                }
                if ((var4 = var1.superInterfaces()) != null && var4 != Binding.field_155) {
                    var9 = var4.length;
                    if (var6 + var9 >= var5.length) {
                        System.arraycopy(var5, 0, var5 = new ReferenceBinding[var6 + var9 + 5], 0, var6);
                    }
                    label51:
                    for (var10 = 0; var10 < var9; ++var10) {
                        ReferenceBinding var14 = var4[var10];
                        for (int var15 = 0; var15 < var6; ++var15) {
                            if (var14 == var5[var15]) {
                                continue label51;
                            }
                        }
                        var5[var6++] = var14;
                    }
                }
            }
        }
    }

    public ReferenceBinding findType(char[] var1, PackageBinding var2, PackageBinding var3) {
        this.compilationUnitScope().recordReference(var2.compoundName, var1);
        ReferenceBinding var4 = var2.method_123(var1);
        if (var4 == null) {
            return null;
        } else if (var4.isValidBinding() && var2 != var3 && !var4.canBeSeenBy(var3)) {
            ProblemReferenceBinding var10000 = new ProblemReferenceBinding(new char[][] {var1}, var4, 2);
            return var10000;
        } else {
            return var4;
        }
    }

    public LocalVariableBinding findVariable(char[] var1) {
        return null;
    }

    public Binding getBinding(char[] var1, int var2, InvocationSite var3, boolean var4) {
        CompilationUnitScope var5 = this.compilationUnitScope();
        LookupEnvironment var6 = var5.environment;
        try {
            var6.missingClassFileLocation = var3;
            Object var7 = null;
            FieldBinding var8 = null;
            if ((var2 & 3) != 0) {
                boolean var9 = false;
                boolean var10 = false;
                boolean var11 = false;
                FieldBinding var12 = null;
                ProblemFieldBinding var13 = null;
                Scope var14 = this;
                int var15 = 0;
                int var16 = 0;
                ReferenceBinding var17 = null;
                label614:
                while (true) {
                    FieldBinding var23;
                    ProblemFieldBinding var10000;
                    switch (var14.kind) {
                        case 2:
                            MethodScope var37 = (MethodScope)var14;
                            var9 |= var37.field_404;
                            var10 |= var37.field_405;
                            var11 = var37.field_412;
                        case 1:
                            LocalVariableBinding var40 = var14.findVariable(var1);
                            if (var40 != null) {
                                if (var12 != null && var12.isValidBinding()) {
                                    var10000 = new ProblemFieldBinding(var12, var12.declaringClass, var1, 5);
                                    ProblemFieldBinding var51 = var10000;
                                    return var51;
                                }
                                if (var15 > 0) {
                                    var3.method_2(var15);
                                }
                                LocalVariableBinding var50 = var40;
                                return var50;
                            }
                            break;
                        case 3:
                            ClassScope var48 = (ClassScope)var14;
                            ReferenceBinding var49 = var48.method_584();
                            if (!var11) {
                                FieldBinding var43 = var48.findField(var49, var1, var3, var4);
                                if (var43 != null) {
                                    ProblemFieldBinding var52;
                                    if (var43.problemId() == 3) {
                                        if (var12 != null && var12.problemId() != 2) {
                                            var10000 = new ProblemFieldBinding(var12, var12.declaringClass, var1, 5);
                                            var52 = var10000;
                                            return var52;
                                        }
                                        var23 = var43;
                                        return var23;
                                    }
                                    var52 = null;
                                    if (var43.isValidBinding()) {
                                        if (!var43.method_431()) {
                                            if (var10) {
                                                var10000 = new ProblemFieldBinding(var43, var43.declaringClass, var1, 6);
                                                var52 = var10000;
                                            } else if (var9) {
                                                var10000 = new ProblemFieldBinding(var43, var43.declaringClass, var1, 7);
                                                var52 = var10000;
                                            }
                                        }
                                        if (var49 == var43.declaringClass || this.compilerOptions().field_1927 >= 3145728L) {
                                            if (var12 == null) {
                                                if (var15 > 0) {
                                                    var3.method_2(var15);
                                                    var3.setActualReceiverType(var49);
                                                }
                                                Object var54 = var52 == null ? var43 : var52;
                                                return (Binding)var54;
                                            }
                                            if (var12.isValidBinding() && var12.declaringClass != var43.declaringClass) {
                                                var10000 = new ProblemFieldBinding(var12, var12.declaringClass, var1, 5);
                                                ProblemFieldBinding var53 = var10000;
                                                return var53;
                                            }
                                        }
                                    }
                                    if (var12 == null || var12.problemId() == 2 && var43.problemId() != 2) {
                                        var16 = var15;
                                        var17 = var49;
                                        var13 = var52;
                                        var12 = var43;
                                    }
                                }
                            }
                            var11 = false;
                            ++var15;
                            var9 |= var49.method_226();
                            MethodScope var44 = var14.method_635();
                            var10 = var44 == null ? false : var44.field_405;
                            break;
                        case 4:
                            if (var13 != null) {
                                ProblemFieldBinding var38 = var13;
                                return var38;
                            }
                            if (var12 != null) {
                                if (var12.isValidBinding()) {
                                    if (var16 > 0) {
                                        var3.method_2(var16);
                                        var3.setActualReceiverType(var17);
                                    }
                                    FieldBinding var39 = var12;
                                    return var39;
                                }
                                var8 = var12;
                                var12 = null;
                            }
                            if (this.compilerOptions().field_1928 < 3211264L) {
                                break label614;
                            }
                            var5.method_679();
                            ImportBinding[] var18 = var5.imports;
                            if (var18 == null) {
                                break label614;
                            }
                            int var19 = 0;
                            int var20;
                            for (var20 = var18.length; var19 < var20; ++var19) {
                                ImportBinding var21 = var18[var19];
                                if (var21.isStatic() && !var21.onDemand && CharOperation.method_1364(var21.compoundName[var21.compoundName.length - 1], var1) && var5.method_695(var21) != null && var21.resolvedImport instanceof FieldBinding) {
                                    var12 = (FieldBinding)var21.resolvedImport;
                                    ImportReference var22 = var21.reference;
                                    if (var22 != null && var4) {
                                        var22.field_446 |= 2;
                                    }
                                    var3.setActualReceiverType(var12.declaringClass);
                                    if (var12.isValidBinding()) {
                                        var23 = var12;
                                        return var23;
                                    }
                                    if (var8 == null) {
                                        var8 = var12;
                                    }
                                }
                            }
                            boolean var41 = false;
                            var20 = 0;
                            for (int var47 = var18.length; var20 < var47; ++var20) {
                                ImportBinding var42 = var18[var20];
                                if (var42.isStatic() && var42.onDemand) {
                                    Binding var45 = var42.resolvedImport;
                                    if (var45 instanceof ReferenceBinding) {
                                        FieldBinding var24 = this.findField((ReferenceBinding)var45, var1, var3, var4);
                                        if (var24 != null) {
                                            if (!var24.isValidBinding()) {
                                                if (var8 == null) {
                                                    var8 = var24;
                                                }
                                            } else if (var24.method_431() && var12 != var24) {
                                                ImportReference var25 = var42.reference;
                                                if (var25 != null && var4) {
                                                    var25.field_446 |= 2;
                                                }
                                                if (var41) {
                                                    var10000 = new ProblemFieldBinding(var12, var12.declaringClass, var1, 3);
                                                    ProblemFieldBinding var26 = var10000;
                                                    return var26;
                                                }
                                                var12 = var24;
                                                var41 = true;
                                            }
                                        }
                                    }
                                }
                            }
                            if (var12 != null) {
                                var3.setActualReceiverType(var12.declaringClass);
                                FieldBinding var46 = var12;
                                return var46;
                            }
                            break label614;
                    }
                    var14 = var14.parent;
                }
            }
            Object var33;
            if ((var2 & 4) != 0) {
                TypeBinding var32;
                if ((var32 = getBaseType(var1)) != null) {
                    TypeBinding var35 = var32;
                    return var35;
                }
                var7 = this.getTypeOrPackage(var1, (var2 & 16) == 0 ? 4 : 20, var4);
                if (((Binding)var7).isValidBinding() || var2 == 4) {
                    var33 = var7;
                    return (Binding)var33;
                }
            } else if ((var2 & 16) != 0) {
                var5.method_690(var1);
                if ((var7 = var6.method_507(var1)) != null) {
                    var33 = var7;
                    return (Binding)var33;
                }
            }
            if (var8 != null) {
                FieldBinding var36 = var8;
                return var36;
            } else if (var7 != null && ((Binding)var7).problemId() != 1) {
                var33 = var7;
                return (Binding)var33;
            } else {
                ProblemBinding var55 = new ProblemBinding(var1, this.enclosingSourceType(), 1);
                ProblemBinding var34 = var55;
                return var34;
            }
        } catch (AbortCompilation var30) {
            var30.updateContext(var3, this.referenceCompilationUnit().compilationResult);
            throw var30;
        } finally {
            var6.missingClassFileLocation = null;
        }
    }

    public MethodBinding method_599(ReferenceBinding var1, TypeBinding[] var2, InvocationSite var3) {
        CompilationUnitScope var4 = this.compilationUnitScope();
        LookupEnvironment var5 = var4.environment;
        MethodBinding var13;
        try {
            var5.missingClassFileLocation = var3;
            var4.method_693(var1);
            var4.recordTypeReferences(var2);
            MethodBinding var6 = var1.getExactConstructor(var2);
            if (var6 != null && var6.canBeSeenBy(var3, this)) {
                if (var3.genericTypeArguments() != null) {
                    var6 = this.computeCompatibleMethod(var6, var2, var3);
                }
                MethodBinding var20 = var6;
                return var20;
            }
            MethodBinding[] var7 = var1.getMethods(TypeConstants.field_135);
            ProblemMethodBinding var10000;
            if (var7 == Binding.field_154) {
                var10000 = new ProblemMethodBinding(TypeConstants.field_135, var2, 1);
                ProblemMethodBinding var21 = var10000;
                return var21;
            }
            MethodBinding[] var8 = new MethodBinding[var7.length];
            int var9 = 0;
            MethodBinding var10 = null;
            int var11 = 0;
            int var12;
            for (var12 = var7.length; var11 < var12; ++var11) {
                var13 = this.computeCompatibleMethod(var7[var11], var2, var3);
                if (var13 != null) {
                    if (var13.isValidBinding()) {
                        var8[var9++] = var13;
                    } else if (var10 == null) {
                        var10 = var13;
                    }
                }
            }
            if (var9 == 0) {
                if (var10 == null) {
                    var10000 = new ProblemMethodBinding(var7[0], TypeConstants.field_135, var2, 1);
                    ProblemMethodBinding var22 = var10000;
                    return var22;
                }
                MethodBinding var24 = var10;
                return var24;
            }
            MethodBinding[] var23 = new MethodBinding[var9];
            var12 = 0;
            for (int var25 = 0; var25 < var9; ++var25) {
                MethodBinding var14 = var8[var25];
                if (var14.canBeSeenBy(var3, this)) {
                    var23[var12++] = var14;
                }
            }
            if (var12 != 1) {
                if (var12 == 0) {
                    var10000 = new ProblemMethodBinding(var8[0], TypeConstants.field_135, var8[0].parameters, 2);
                    ProblemMethodBinding var26 = var10000;
                    return var26;
                }
                var13 = this.mostSpecificMethodBinding(var23, var12, var2, var3, var1);
                return var13;
            }
            var13 = var23[0];
        } catch (AbortCompilation var18) {
            var18.updateContext(var3, this.referenceCompilationUnit().compilationResult);
            throw var18;
        } finally {
            var5.missingClassFileLocation = null;
        }
        return var13;
    }

    public final PackageBinding getCurrentPackage() {
        Scope var2 = this;
        while (true) {
            Scope var1 = var2.parent;
            if (var2.parent == null) {
                return ((CompilationUnitScope)var2).fPackage;
            }
            var2 = var1;
        }
    }

    public FieldBinding method_601(TypeBinding var1, char[] var2, InvocationSite var3) {
        LookupEnvironment var4 = this.environment();
        ProblemFieldBinding var6;
        try {
            var4.missingClassFileLocation = var3;
            FieldBinding var5 = this.findField(var1, var2, var3, true);
            if (var5 != null) {
                FieldBinding var12 = var5;
                return var12;
            }
            ProblemFieldBinding var10000 = new ProblemFieldBinding(var1 instanceof ReferenceBinding ? (ReferenceBinding)var1 : null, var2, 1);
            var6 = var10000;
        } catch (AbortCompilation var10) {
            var10.updateContext(var3, this.referenceCompilationUnit().compilationResult);
            throw var10;
        } finally {
            var4.missingClassFileLocation = null;
        }
        return var6;
    }

    public MethodBinding getImplicitMethod(char[] var1, TypeBinding[] var2, InvocationSite var3) {
        boolean var4 = false;
        boolean var5 = false;
        boolean var6 = false;
        MethodBinding var7 = null;
        Object var8 = null;
        boolean var9 = false;
        Scope var10 = this;
        int var11 = 0;
        CompilerOptions var12;
        boolean var13 = (var12 = this.compilerOptions()).field_1927 >= 3145728L;
        while (true) {
            ProblemMethodBinding var35;
            switch (var10.kind) {
                case 2:
                    MethodScope var27 = (MethodScope)var10;
                    var4 |= var27.field_404;
                    var5 |= var27.field_405;
                    var6 = var27.field_412;
                    break;
                case 3:
                    ClassScope var26 = (ClassScope)var10;
                    ReferenceBinding var28 = var26.method_584();
                    if (!var6) {
                        MethodBinding var29 = var26.method_589(var28, var1, var2, var3);
                        if (var29 == null) {
                            var29 = var26.method_592(var28, var1, var2, var3);
                        }
                        if (var29 != null) {
                            if (var7 == null) {
                                if (var29.isValidBinding()) {
                                    if (!var29.method_370() && (var5 || var4)) {
                                        if (var8 != null && ((MethodBinding)var8).problemId() != 2) {
                                            return (MethodBinding)var8;
                                        }
                                        var35 = new ProblemMethodBinding(var29, var29.selector, var29.parameters, var5 ? 6 : 7);
                                        return var35;
                                    }
                                    if (var13 || var28 == var29.declaringClass || var28.getMethods(var1) != Binding.field_154) {
                                        if (var9) {
                                            return (MethodBinding)var8;
                                        }
                                        if (var11 > 0) {
                                            var3.method_2(var11);
                                            var3.setActualReceiverType(var28);
                                        }
                                        if (var28.id != 1 && var2 == Binding.field_150 && CharOperation.method_1364(var1, TypeConstants.field_34) && var29.returnType.method_162()) {
                                            return ParameterizedMethodBinding.instantiateGetClass(var28, var29, this);
                                        }
                                        return var29;
                                    }
                                    if (var8 == null || ((MethodBinding)var8).problemId() == 2) {
                                        if (var8 != null) {
                                            var8 = null;
                                        }
                                        if (var11 > 0) {
                                            var3.method_2(var11);
                                            var3.setActualReceiverType(var28);
                                        }
                                        var7 = var29;
                                    }
                                } else {
                                    if (var29.problemId() != 2 && var29.problemId() != 1) {
                                        return var29;
                                    }
                                    if (var8 == null) {
                                        var8 = var29;
                                    }
                                    if (!var9 && var29.problemId() == 1) {
                                        MethodBinding var30 = ((ProblemMethodBinding)var29).closestMatch;
                                        if (var30 != null && var30.canBeSeenBy(var28, var3, this)) {
                                            var8 = var29;
                                            var9 = true;
                                        }
                                    }
                                }
                            } else if (var29.problemId() == 3 || var7.declaringClass != var29.declaringClass && (var28 == var29.declaringClass || var28.getMethods(var1) != Binding.field_154)) {
                                var35 = new ProblemMethodBinding(var29, var1, var2, 5);
                                return var35;
                            }
                        }
                    }
                    var6 = false;
                    ++var11;
                    var4 |= var28.method_226();
                    MethodScope var32 = var10.method_635();
                    var5 = var32 == null ? false : var32.field_405;
                    break;
                case 4:
                    if (var4 && var12.field_1928 >= 3211264L) {
                        if (var8 != null) {
                            if (((MethodBinding)var8).declaringClass != null && ((MethodBinding)var8).declaringClass.id == 1) {
                                return (MethodBinding)var8;
                            }
                            if (((MethodBinding)var8).problemId() == 1 && var9) {
                                return (MethodBinding)var8;
                            }
                        }
                        CompilationUnitScope var14 = (CompilationUnitScope)var10;
                        var14.method_679();
                        ImportBinding[] var15 = var14.imports;
                        if (var15 != null) {
                            ObjectVector var16 = null;
                            boolean var17 = false;
                            int var18 = 0;
                            for (int var19 = var15.length; var18 < var19; ++var18) {
                                ImportBinding var20 = var15[var18];
                                if (var20.isStatic()) {
                                    Binding var21 = var20.resolvedImport;
                                    MethodBinding var22 = null;
                                    MethodBinding var23;
                                    if (var20.onDemand) {
                                        if (!var17 && var21 instanceof ReferenceBinding) {
                                            var22 = this.findMethod((ReferenceBinding)var21, var1, var2, var3, true);
                                        }
                                    } else if (var21 instanceof MethodBinding) {
                                        var23 = (MethodBinding)var21;
                                        if (CharOperation.method_1364(var23.selector, var1)) {
                                            var22 = this.findMethod(var23.declaringClass, var1, var2, var3, true);
                                        }
                                    } else if (var21 instanceof FieldBinding) {
                                        FieldBinding var33 = (FieldBinding)var21;
                                        if (CharOperation.method_1364(var33.name, var1)) {
                                            char[][] var24 = var20.reference.tokens;
                                            TypeBinding var25 = this.getType(var24, var24.length - 1);
                                            if (var25 != null) {
                                                var22 = this.findMethod((ReferenceBinding)var25, var1, var2, var3, true);
                                            }
                                        }
                                    }
                                    if (var22 != null && var22 != var8) {
                                        if (!var22.isValidBinding()) {
                                            if (var8 == null) {
                                                var8 = var22;
                                            }
                                        } else if (var22.method_370()) {
                                            var23 = this.computeCompatibleMethod(var22, var2, var3);
                                            if (var23 != null) {
                                                if (var23.isValidBinding()) {
                                                    if (var23.canBeSeenBy(var14.fPackage)) {
                                                        if (var16 == null || !var16.method_3234(var23)) {
                                                            ImportReference var34 = var20.reference;
                                                            if (var34 != null) {
                                                                var34.field_446 |= 2;
                                                            }
                                                            if (!var17 && !var20.onDemand) {
                                                                var16 = null;
                                                                var17 = true;
                                                            }
                                                            if (var16 == null) {
                                                                ObjectVector var10000 = new ObjectVector(3);
                                                                var16 = var10000;
                                                            }
                                                            var16.add(var23);
                                                        }
                                                    } else if (var8 == null) {
                                                        var35 = new ProblemMethodBinding(var23, var1, var23.parameters, 2);
                                                        var8 = var35;
                                                    }
                                                } else if (var8 == null) {
                                                    var8 = var23;
                                                }
                                            } else if (var8 == null) {
                                                var35 = new ProblemMethodBinding(var22, var1, var2, 1);
                                                var8 = var35;
                                            }
                                        }
                                    }
                                }
                            }
                            if (var16 != null) {
                                MethodBinding[] var31 = new MethodBinding[var16.size];
                                var16.method_3235(var31);
                                var7 = this.mostSpecificMethodBinding(var31, var31.length, var2, var3, (ReferenceBinding)null);
                            }
                        }
                    }
                    if (var7 != null) {
                        var3.setActualReceiverType(var7.declaringClass);
                        return var7;
                    }
                    if (var8 != null) {
                        return (MethodBinding)var8;
                    }
                    var35 = new ProblemMethodBinding(var1, var2, 1);
                    return var35;
            }
            var10 = var10.parent;
        }
    }

    public final ReferenceBinding method_603() {
        CompilationUnitScope var1 = this.compilationUnitScope();
        var1.recordQualifiedReference(TypeConstants.field_108);
        return var1.environment.getResolvedType(TypeConstants.field_108, this);
    }

    public final ReferenceBinding method_604() {
        CompilationUnitScope var1 = this.compilationUnitScope();
        var1.recordQualifiedReference(TypeConstants.field_88);
        return var1.environment.getResolvedType(TypeConstants.field_88, this);
    }

    public final ReferenceBinding method_605() {
        CompilationUnitScope var1 = this.compilationUnitScope();
        var1.recordQualifiedReference(TypeConstants.field_89);
        return var1.environment.getResolvedType(TypeConstants.field_89, this);
    }

    public final ReferenceBinding method_606() {
        CompilationUnitScope var1 = this.compilationUnitScope();
        var1.recordQualifiedReference(TypeConstants.field_90);
        return var1.environment.getResolvedType(TypeConstants.field_90, this);
    }

    public final ReferenceBinding method_607() {
        CompilationUnitScope var1 = this.compilationUnitScope();
        var1.recordQualifiedReference(field_375);
        return var1.environment.getResolvedType(field_375, this);
    }

    public final ReferenceBinding method_608() {
        CompilationUnitScope var1 = this.compilationUnitScope();
        var1.recordQualifiedReference(TypeConstants.field_93);
        return var1.environment.getResolvedType(TypeConstants.field_93, this);
    }

    public final ReferenceBinding method_609() {
        CompilationUnitScope var1 = this.compilationUnitScope();
        var1.recordQualifiedReference(TypeConstants.field_99);
        return var1.environment.getResolvedType(TypeConstants.field_99, this);
    }

    public final ReferenceBinding method_610() {
        CompilationUnitScope var1 = this.compilationUnitScope();
        var1.recordQualifiedReference(TypeConstants.field_100);
        return var1.environment.getResolvedType(TypeConstants.field_100, this);
    }

    public final ReferenceBinding method_611() {
        CompilationUnitScope var1 = this.compilationUnitScope();
        var1.recordQualifiedReference(TypeConstants.field_105);
        return var1.environment.getResolvedType(TypeConstants.field_105, this);
    }

    public final ReferenceBinding method_612() {
        CompilationUnitScope var1 = this.compilationUnitScope();
        var1.recordQualifiedReference(TypeConstants.field_118);
        return var1.environment.getResolvedType(TypeConstants.field_118, this);
    }

    public final ReferenceBinding getMemberType(char[] var1, ReferenceBinding var2) {
        ReferenceBinding var3 = this.method_591(var1, var2);
        if (var3 != null) {
            return var3;
        } else {
            char[][] var4 = new char[][] {var1};
            ProblemReferenceBinding var10000 = new ProblemReferenceBinding(var4, (ReferenceBinding)null, 1);
            return var10000;
        }
    }

    public MethodBinding method_614(TypeBinding var1, char[] var2, TypeBinding[] var3, InvocationSite var4) throws Throwable {
        CompilationUnitScope var5 = this.compilationUnitScope();
        LookupEnvironment var6 = var5.environment;
        ProblemMethodBinding var7;
        label86: {
            MethodBinding var13;
            label85: {
                ProblemMethodBinding var15;
                label84: {
                    MethodBinding var9;
                    label83: {
                        ProblemMethodBinding var17;
                        label82: {
                            label81: {
                                ParameterizedMethodBinding var16;
                                label80: {
                                    try {
                                        try {
                                            var6.missingClassFileLocation = var4;
                                            ProblemMethodBinding var10000;
                                            switch (var1.kind()) {
                                                case 68:
                                                    var5.method_693(var1);
                                                    var13 = this.findMethodForArray((ArrayBinding)var1, var2, var3, var4);
                                                    break label85;
                                                case 132:
                                                    var10000 = new ProblemMethodBinding(var2, var3, 1);
                                                    var7 = var10000;
                                                    break label86;
                                            }
                                            var5.method_693(var1);
                                            ReferenceBinding var14 = (ReferenceBinding)var1;
                                            if (!var14.canBeSeenBy(this)) {
                                                var10000 = new ProblemMethodBinding(var2, var3, 8);
                                                var15 = var10000;
                                                break label84;
                                            }
                                            MethodBinding var8 = this.method_589(var14, var2, var3, var4);
                                            if (var8 != null) {
                                                var9 = var8;
                                                break label83;
                                            }
                                            var8 = this.method_592(var14, var2, var3, var4);
                                            if (var8 == null) {
                                                var10000 = new ProblemMethodBinding(var2, var3, 1);
                                                var17 = var10000;
                                                break label82;
                                            }
                                            if (!var8.isValidBinding()) {
                                                var9 = var8;
                                                break label81;
                                            }
                                            if (var1.id != 1 && var3 == Binding.field_150 && CharOperation.method_1364(var2, TypeConstants.field_34) && var8.returnType.method_162()) {
                                                var16 = ParameterizedMethodBinding.instantiateGetClass(var1, var8, this);
                                                break label80;
                                            }
                                            var9 = var8;
                                        } catch (AbortCompilation var11) {
                                            var11.updateContext(var4, this.referenceCompilationUnit().compilationResult);
                                            throw var11;
                                        }
                                    } catch (Throwable var12) {
                                        var6.missingClassFileLocation = null;
                                        throw var12;
                                    }
                                    var6.missingClassFileLocation = null;
                                    return var9;
                                }
                                var6.missingClassFileLocation = null;
                                return var16;
                            }
                            var6.missingClassFileLocation = null;
                            return var9;
                        }
                        var6.missingClassFileLocation = null;
                        return var17;
                    }
                    var6.missingClassFileLocation = null;
                    return var9;
                }
                var6.missingClassFileLocation = null;
                return var15;
            }
            var6.missingClassFileLocation = null;
            return var13;
        }
        var6.missingClassFileLocation = null;
        return var7;
    }

    public final Binding method_615(char[][] var1) {
        this.compilationUnitScope().recordQualifiedReference(var1);
        Binding var2 = this.getTypeOrPackage(var1[0], 20, true);
        char[][] var6;
        ProblemReferenceBinding var10000;
        if (var2 == null) {
            var6 = new char[][] {var1[0]};
            var10000 = new ProblemReferenceBinding(var6, this.environment().createMissingType((PackageBinding)null, var1), 1);
            return var10000;
        } else if (!var2.isValidBinding()) {
            if (var2 instanceof PackageBinding) {
                var6 = new char[][] {var1[0]};
                var10000 = new ProblemReferenceBinding(var6, (ReferenceBinding)null, 1);
                return var10000;
            } else {
                return var2;
            }
        } else if (!(var2 instanceof PackageBinding)) {
            return null;
        } else {
            int var3 = 1;
            int var4 = var1.length;
            for (PackageBinding var5 = (PackageBinding)var2; var3 < var4; var5 = (PackageBinding)var2) {
                var2 = var5.getTypeOrPackage(var1[var3++]);
                if (var2 == null) {
                    var10000 = new ProblemReferenceBinding(CharOperation.subarray(var1, 0, var3), (ReferenceBinding)null, 1);
                    return var10000;
                }
                if (!var2.isValidBinding()) {
                    var10000 = new ProblemReferenceBinding(CharOperation.subarray(var1, 0, var3), var2 instanceof ReferenceBinding ? (ReferenceBinding)((ReferenceBinding)var2).closestMatch() : null, var2.problemId());
                    return var10000;
                }
                if (!(var2 instanceof PackageBinding)) {
                    return var5;
                }
            }
            var10000 = new ProblemReferenceBinding(var1, (ReferenceBinding)null, 1);
            return var10000;
        }
    }

    public final TypeBinding getType(char[] var1) {
        TypeBinding var2 = getBaseType(var1);
        return (TypeBinding)(var2 != null ? var2 : (ReferenceBinding)this.getTypeOrPackage(var1, 4, true));
    }

    public final TypeBinding getType(char[] var1, PackageBinding var2) {
        if (var2 == null) {
            return this.getType(var1);
        } else {
            Binding var3 = var2.getTypeOrPackage(var1);
            ProblemReferenceBinding var10000;
            if (var3 == null) {
                var10000 = new ProblemReferenceBinding(CharOperation.arrayConcat(var2.compoundName, var1), (ReferenceBinding)null, 1);
                return var10000;
            } else if (!var3.isValidBinding()) {
                var10000 = new ProblemReferenceBinding(var3 instanceof ReferenceBinding ? ((ReferenceBinding)var3).compoundName : CharOperation.arrayConcat(var2.compoundName, var1), var3 instanceof ReferenceBinding ? (ReferenceBinding)((ReferenceBinding)var3).closestMatch() : null, var3.problemId());
                return var10000;
            } else {
                ReferenceBinding var4 = (ReferenceBinding)var3;
                if (!var4.canBeSeenBy(this)) {
                    var10000 = new ProblemReferenceBinding(var4.compoundName, var4, 2);
                    return var10000;
                } else {
                    return var4;
                }
            }
        }
    }

    public final TypeBinding getType(char[][] var1, int var2) {
        if (var2 == 1) {
            TypeBinding var3 = getBaseType(var1[0]);
            if (var3 != null) {
                return var3;
            }
        }
        CompilationUnitScope var9 = this.compilationUnitScope();
        var9.recordQualifiedReference(var1);
        Binding var4 = this.getTypeOrPackage(var1[0], var2 == 1 ? 4 : 20, true);
        ProblemReferenceBinding var10000;
        if (var4 == null) {
            char[][] var10 = new char[][] {var1[0]};
            var10000 = new ProblemReferenceBinding(var10, this.environment().createMissingType(this.compilationUnitScope().getCurrentPackage(), var10), 1);
            return var10000;
        } else if (!var4.isValidBinding()) {
            return (ReferenceBinding)var4;
        } else {
            int var5 = 1;
            boolean var6 = false;
            if (var4 instanceof PackageBinding) {
                char[][] var8;
                for (PackageBinding var7 = (PackageBinding)var4; var5 < var2; var7 = (PackageBinding)var4) {
                    var4 = var7.getTypeOrPackage(var1[var5++]);
                    if (var4 == null) {
                        var8 = CharOperation.subarray(var1, 0, var5);
                        var10000 = new ProblemReferenceBinding(var8, this.environment().createMissingType(var7, var8), 1);
                        return var10000;
                    }
                    if (!var4.isValidBinding()) {
                        var10000 = new ProblemReferenceBinding(CharOperation.subarray(var1, 0, var5), var4 instanceof ReferenceBinding ? (ReferenceBinding)((ReferenceBinding)var4).closestMatch() : null, var4.problemId());
                        return var10000;
                    }
                    if (!(var4 instanceof PackageBinding)) {
                        break;
                    }
                }
                if (var4 instanceof PackageBinding) {
                    var8 = CharOperation.subarray(var1, 0, var5);
                    var10000 = new ProblemReferenceBinding(var8, this.environment().createMissingType((PackageBinding)null, var8), 1);
                    return var10000;
                }
                var6 = true;
            }
            ReferenceBinding var11 = (ReferenceBinding)var4;
            var9.method_693(var11);
            if (var6 && !var11.canBeSeenBy(this)) {
                var10000 = new ProblemReferenceBinding(CharOperation.subarray(var1, 0, var5), var11, 2);
                return var10000;
            } else {
                do {
                    if (var5 >= var2) {
                        return var11;
                    }
                    var11 = this.getMemberType(var1[var5++], var11);
                } while (var11.isValidBinding());
                if (var11 instanceof ProblemReferenceBinding) {
                    ProblemReferenceBinding var12 = (ProblemReferenceBinding)var11;
                    var10000 = new ProblemReferenceBinding(CharOperation.subarray(var1, 0, var5), var12.closestReferenceMatch(), var11.problemId());
                    return var10000;
                } else {
                    var10000 = new ProblemReferenceBinding(CharOperation.subarray(var1, 0, var5), (ReferenceBinding)((ReferenceBinding)var4).closestMatch(), var11.problemId());
                    return var10000;
                }
            }
        }
    }

    final Binding getTypeOrPackage(char[] var1, int var2, boolean var3) {
        Scope var4 = this;
        Object var5 = null;
        boolean var6 = false;
        boolean var7 = false;
        int var12;
        ReferenceBinding var35;
        ProblemReferenceBinding var10000;
        if ((var2 & 4) == 0) {
            while (true) {
                Scope var8 = var4.parent;
                if (var4.parent == null) {
                    break;
                }
                var4 = var8;
            }
        } else {
            boolean var22 = this.compilerOptions().field_1927 >= 3145728L;
            label340:
            while (true) {
                switch (var4.kind) {
                    case 2:
                        MethodScope var23 = (MethodScope)var4;
                        AbstractMethodDeclaration var36 = var23.referenceMethod();
                        if (var36 != null) {
                            if (var36.binding != null) {
                                TypeVariableBinding var37 = var36.binding.getTypeVariable(var1);
                                if (var37 != null) {
                                    return var37;
                                }
                            } else {
                                TypeParameter[] var33 = var36.typeParameters();
                                var12 = var33 == null ? 0 : var33.length;
                                while (true) {
                                    --var12;
                                    if (var12 < 0) {
                                        break;
                                    }
                                    if (CharOperation.method_1364(var33[var12].name, var1) && var33[var12].binding != null && var33[var12].binding.isValidBinding()) {
                                        return var33[var12].binding;
                                    }
                                }
                            }
                        }
                        var6 |= var23.field_404;
                        var7 = var23.field_412;
                    case 1:
                        ReferenceBinding var34 = ((BlockScope)var4).findLocalType(var1);
                        if (var34 != null) {
                            if (var5 != null && var5 != var34) {
                                var10000 = new ProblemReferenceBinding(new char[][] {var1}, (ReferenceBinding)var5, 5);
                                return var10000;
                            }
                            return var34;
                        }
                        break;
                    case 3:
                        SourceTypeBinding var29 = ((ClassScope)var4).referenceContext.binding;
                        TypeVariableBinding var40;
                        if (var4 == this && (var29.tagBits & 262144L) == 0L) {
                            var40 = var29.getTypeVariable(var1);
                            if (var40 != null) {
                                return var40;
                            }
                            if (CharOperation.method_1364(var1, var29.sourceName)) {
                                return var29;
                            }
                            var6 |= var29.method_226();
                        } else {
                            if (!var7) {
                                var35 = this.method_591(var1, var29);
                                if (var35 != null) {
                                    if (var35.problemId() == 3) {
                                        if (var5 != null && ((ReferenceBinding)var5).problemId() != 2) {
                                            var10000 = new ProblemReferenceBinding(new char[][] {var1}, (ReferenceBinding)var5, 5);
                                            return var10000;
                                        }
                                        return var35;
                                    }
                                    if (var35.isValidBinding() && (var29 == var35.enclosingType() || var22)) {
                                        if (var6 && !var35.method_226() && var29.method_155()) {
                                            var10000 = new ProblemReferenceBinding(new char[][] {var1}, var35, 7);
                                            return var10000;
                                        }
                                        if (var5 == null || var22 && ((ReferenceBinding)var5).problemId() == 2) {
                                            return var35;
                                        }
                                        if (((ReferenceBinding)var5).isValidBinding() && var5 != var35) {
                                            var10000 = new ProblemReferenceBinding(new char[][] {var1}, (ReferenceBinding)var5, 5);
                                            return var10000;
                                        }
                                    }
                                    if (var5 == null || ((ReferenceBinding)var5).problemId() == 2 && var35.problemId() != 2) {
                                        var5 = var35;
                                    }
                                }
                            }
                            var40 = var29.getTypeVariable(var1);
                            if (var40 != null) {
                                if (var6) {
                                    var10000 = new ProblemReferenceBinding(new char[][] {var1}, var40, 7);
                                    return var10000;
                                }
                                return var40;
                            }
                            var6 |= var29.method_226();
                            var7 = false;
                            if (CharOperation.method_1364(var29.sourceName, var1)) {
                                if (var5 != null && var5 != var29 && ((ReferenceBinding)var5).problemId() != 2) {
                                    var10000 = new ProblemReferenceBinding(new char[][] {var1}, (ReferenceBinding)var5, 5);
                                    return var10000;
                                }
                                return var29;
                            }
                        }
                        break;
                    case 4:
                        if (var5 != null && ((ReferenceBinding)var5).problemId() != 2) {
                            return (Binding)var5;
                        }
                        break label340;
                }
                var4 = var4.parent;
            }
        }
        CompilationUnitScope var21 = (CompilationUnitScope)var4;
        HashtableOfObject var9 = var21.typeOrPackageCache;
        if (var9 != null) {
            Object var10 = (Binding)var9.method_3226(var1);
            if (var10 != null) {
                if (var10 instanceof ImportBinding) {
                    ImportReference var11 = ((ImportBinding)var10).reference;
                    if (var11 != null) {
                        var11.field_446 |= 2;
                    }
                    if (var10 instanceof ImportConflictBinding) {
                        var9.put(var1, var10 = ((ImportConflictBinding)var10).conflictingTypeBinding);
                    } else {
                        var9.put(var1, var10 = ((ImportBinding)var10).resolvedImport);
                    }
                }
                if ((var2 & 4) != 0) {
                    if (var5 != null && ((ReferenceBinding)var5).problemId() != 2 && ((Binding)var10).problemId() != 3) {
                        return (Binding)var5;
                    }
                    if (var10 instanceof ReferenceBinding) {
                        return (Binding)var10;
                    }
                }
                if ((var2 & 16) != 0 && var10 instanceof PackageBinding) {
                    return (Binding)var10;
                }
            }
        }
        if ((var2 & 4) != 0) {
            ImportBinding[] var31 = var21.imports;
            if (var31 != null && var9 == null) {
                int var24 = 0;
                for (var12 = var31.length; var24 < var12; ++var24) {
                    ImportBinding var13 = var31[var24];
                    if (!var13.onDemand && CharOperation.method_1364(var13.compoundName[var13.compoundName.length - 1], var1)) {
                        Object var14 = var21.method_695(var13);
                        if (var14 != null) {
                            if (var14 instanceof MethodBinding) {
                                var14 = this.getType(var13.compoundName, var13.compoundName.length);
                                if (!((Binding)var14).isValidBinding()) {
                                    continue;
                                }
                            }
                            if (var14 instanceof TypeBinding) {
                                ImportReference var15 = var13.reference;
                                if (var15 != null) {
                                    var15.field_446 |= 2;
                                }
                                return (Binding)var14;
                            }
                        }
                    }
                }
            }
            PackageBinding var30 = var21.fPackage;
            var21.recordReference(var30.compoundName, var1);
            Binding var27 = var30.getTypeOrPackage(var1);
            if (var27 instanceof ReferenceBinding) {
                var35 = (ReferenceBinding)var27;
                if ((var35.tagBits & 128L) == 0L) {
                    if (var9 != null) {
                        var9.put(var1, var35);
                    }
                    return var35;
                }
            }
            if (var31 != null) {
                boolean var32 = false;
                ReferenceBinding var38 = null;
                int var39 = 0;
                for (int var16 = var31.length; var39 < var16; ++var39) {
                    ImportBinding var17 = var31[var39];
                    if (var17.onDemand) {
                        Binding var18 = var17.resolvedImport;
                        ReferenceBinding var19 = null;
                        if (var18 instanceof PackageBinding) {
                            var19 = this.findType(var1, (PackageBinding)var18, var30);
                        } else if (var17.isStatic()) {
                            var19 = this.method_591(var1, (ReferenceBinding)var18);
                            if (var19 != null && !var19.method_226()) {
                                var19 = null;
                            }
                        } else {
                            var19 = this.method_588(var1, (ReferenceBinding)var18);
                        }
                        if (var19 != var38 && var19 != null) {
                            if (var19.isValidBinding()) {
                                ImportReference var20 = var17.reference;
                                if (var20 != null) {
                                    var20.field_446 |= 2;
                                }
                                if (var32) {
                                    var10000 = new ProblemReferenceBinding(new char[][] {var1}, var38, 3);
                                    ProblemReferenceBinding var41 = var10000;
                                    if (var9 != null) {
                                        var9.put(var1, var41);
                                    }
                                    return var41;
                                }
                                var38 = var19;
                                var32 = true;
                            } else if (var5 == null) {
                                var5 = var19;
                            }
                        }
                    }
                }
                if (var38 != null) {
                    if (var9 != null) {
                        var9.put(var1, var38);
                    }
                    return var38;
                }
            }
        }
        var21.method_690(var1);
        if ((var2 & 16) != 0) {
            PackageBinding var26 = var21.environment.method_507(var1);
            if (var26 != null) {
                if (var9 != null) {
                    var9.put(var1, var26);
                }
                return var26;
            }
        }
        char[][] var28;
        if (var5 == null) {
            var28 = new char[][] {var1};
            MissingTypeBinding var25 = null;
            if (((var2 & 16) != 0 || var21.environment.method_507(var1) == null) && var3) {
                var25 = this.environment().createMissingType(var21.fPackage, var28);
            }
            var10000 = new ProblemReferenceBinding(var28, var25, 1);
            var5 = var10000;
            if (var9 != null && (var2 & 16) != 0) {
                var9.put(var1, var5);
            }
        } else if ((((ReferenceBinding)var5).tagBits & 128L) != 0L) {
            var28 = new char[][] {var1};
            var10000 = new ProblemReferenceBinding(var28, (ReferenceBinding)var5, 1);
            var5 = var10000;
            if (var9 != null && (var2 & 16) != 0) {
                var9.put(var1, var5);
            }
        }
        return (Binding)var5;
    }

    public final Binding method_620(char[][] var1) {
        int var2 = var1.length;
        if (var2 == 1) {
            TypeBinding var3 = getBaseType(var1[0]);
            if (var3 != null) {
                return var3;
            }
        }
        Binding var8 = this.getTypeOrPackage(var1[0], 20, true);
        if (!var8.isValidBinding()) {
            return var8;
        } else {
            int var4 = 1;
            boolean var5 = false;
            ProblemReferenceBinding var10000;
            if (var8 instanceof PackageBinding) {
                for (PackageBinding var6 = (PackageBinding)var8; var4 < var2; var6 = (PackageBinding)var8) {
                    var8 = var6.getTypeOrPackage(var1[var4++]);
                    if (var8 == null) {
                        var10000 = new ProblemReferenceBinding(CharOperation.subarray(var1, 0, var4), (ReferenceBinding)null, 1);
                        return var10000;
                    }
                    if (!var8.isValidBinding()) {
                        var10000 = new ProblemReferenceBinding(CharOperation.subarray(var1, 0, var4), var8 instanceof ReferenceBinding ? (ReferenceBinding)((ReferenceBinding)var8).closestMatch() : null, var8.problemId());
                        return var10000;
                    }
                    if (!(var8 instanceof PackageBinding)) {
                        break;
                    }
                }
                if (var8 instanceof PackageBinding) {
                    return var8;
                }
                var5 = true;
            }
            ReferenceBinding var9 = (ReferenceBinding)var8;
            Object var7 = (ReferenceBinding)this.environment().convertToRawType(var9, false);
            if (var5 && !var9.canBeSeenBy(this)) {
                var10000 = new ProblemReferenceBinding(CharOperation.subarray(var1, 0, var4), var9, 2);
                return var10000;
            } else {
                while (var4 < var2) {
                    var9 = this.getMemberType(var1[var4++], var9);
                    if (!var9.isValidBinding()) {
                        var10000 = new ProblemReferenceBinding(CharOperation.subarray(var1, 0, var4), (ReferenceBinding)var9.closestMatch(), var9.problemId());
                        return var10000;
                    }
                    if (var9.method_155()) {
                        var7 = this.environment().createRawType(var9, (ReferenceBinding)var7);
                    } else {
                        var7 = var7 != null && (((ReferenceBinding)var7).method_166() || ((ReferenceBinding)var7).method_162()) ? this.environment().createParameterizedType(var9, (TypeBinding[])null, (ReferenceBinding)var7) : var9;
                    }
                }
                return (Binding)var7;
            }
        }
    }

    protected boolean method_621(TypeBinding var1, TypeBinding var2, Map var3, ReferenceBinding var4, ASTNode var5) {
        var3.clear();
        TypeBinding[] var6 = this.method_636(new TypeBinding[] {var1, var2}, var3);
        if (var6 != null) {
            int var7 = 0;
            for (int var8 = var6.length; var7 < var8; ++var7) {
                TypeBinding var9 = var6[var7];
                if (var9 != null) {
                    Object var10 = var3.get(var9);
                    if (var10 instanceof TypeBinding[]) {
                        TypeBinding[] var11 = (TypeBinding[])((TypeBinding[])var10);
                        this.problemReporter().superinterfacesCollide(var11[0].erasure(), var5, var11[0], var11[1]);
                        var4.tagBits |= 131072L;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public CaseStatement innermostSwitchCase() {
        Scope var1 = this;
        while (!(var1 instanceof BlockScope)) {
            var1 = var1.parent;
            if (var1 == null) {
                return null;
            }
        }
        return ((BlockScope)var1).enclosingCase;
    }

    protected boolean isAcceptableMethod(MethodBinding var1, MethodBinding var2) {
        TypeBinding[] var3 = var1.parameters;
        TypeBinding[] var4 = var2.parameters;
        int var5 = var3.length;
        int var6 = var4.length;
        int var7;
        if (var5 == var6) {
            for (var7 = 0; var7 < var5; ++var7) {
                TypeBinding var8 = var3[var7];
                TypeBinding var9 = var4[var7];
                if (var8 == var9) {
                    if (var9.method_173().method_166() && var8 == var1.original().parameters[var7] && var9.method_173().erasure() != var2.original().parameters[var7].method_173().erasure()) {
                        return false;
                    }
                } else {
                    if (!var8.isCompatibleWith(var9)) {
                        if (var7 == var5 - 1 && var1.method_374() && var2.method_374()) {
                            TypeBinding var10 = ((ArrayBinding)var9).method_187();
                            if (var8 == var10 || var8.isCompatibleWith(var10)) {
                                return true;
                            }
                        }
                        return false;
                    }
                    if (var8.method_173().method_166() && var8.method_174(var2.declaringClass.method_166() ? var9 : var2.original().parameters[var7])) {
                        return false;
                    }
                }
            }
            return true;
        } else {
            if (var1.method_374() && var2.method_374()) {
                if (var5 > var6 && ((ArrayBinding)var4[var6 - 1]).method_187().id != 1) {
                    return false;
                }
                for (var7 = (var5 > var6 ? var6 : var5) - 2; var7 >= 0; --var7) {
                    if (var3[var7] != var4[var7] && !var3[var7].isCompatibleWith(var4[var7])) {
                        return false;
                    }
                }
                if (this.parameterCompatibilityLevel(var1, var4) == -1 && this.parameterCompatibilityLevel(var2, var3) == 2) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean isBoxingCompatibleWith(TypeBinding var1, TypeBinding var2) {
        LookupEnvironment var3 = this.environment();
        if (var3.globalOptions.field_1928 >= 3211264L && var1.method_148() != var2.method_148()) {
            TypeBinding var4 = var3.method_486(var1);
            return var4 == var2 || var4.isCompatibleWith(var2);
        } else {
            return false;
        }
    }

    public final boolean isDefinedInField(FieldBinding var1) {
        Scope var2 = this;
        do {
            if (var2 instanceof MethodScope) {
                MethodScope var3 = (MethodScope)var2;
                if (var3.initializedField == var1) {
                    return true;
                }
            }
            var2 = var2.parent;
        } while (var2 != null);
        return false;
    }

    public final boolean isDefinedInMethod(MethodBinding var1) {
        Scope var2 = this;
        do {
            if (var2 instanceof MethodScope) {
                ReferenceContext var3 = ((MethodScope)var2).referenceContext;
                if (var3 instanceof AbstractMethodDeclaration && ((AbstractMethodDeclaration)var3).binding == var1) {
                    return true;
                }
            }
            var2 = var2.parent;
        } while (var2 != null);
        return false;
    }

    public final boolean method_627(ReferenceBinding var1) {
        ReferenceBinding var2;
        for (var2 = var1; (var1 = var2.enclosingType()) != null; var2 = var1) {
            ;
        }
        Scope var4 = this;
        while (true) {
            Scope var3 = var4.parent;
            if (var4.parent == null) {
                SourceTypeBinding[] var5 = ((CompilationUnitScope)var4).topLevelTypes;
                int var6 = var5.length;
                do {
                    --var6;
                    if (var6 < 0) {
                        return false;
                    }
                } while (var5[var6] != var2);
                return true;
            }
            var4 = var3;
        }
    }

    public final boolean method_628(ReferenceBinding var1) {
        Scope var2 = this;
        do {
            if (var2 instanceof ClassScope && ((ClassScope)var2).referenceContext.binding == var1) {
                return true;
            }
            var2 = var2.parent;
        } while (var2 != null);
        return false;
    }

    public boolean isInsideCase(CaseStatement var1) {
        Scope var2 = this;
        do {
            switch (var2.kind) {
                case 1:
                    if (((BlockScope)var2).enclosingCase == var1) {
                        return true;
                    }
            }
            var2 = var2.parent;
        } while (var2 != null);
        return false;
    }

    public boolean isInsideDeprecatedCode() {
        SourceTypeBinding var2;
        switch (this.kind) {
            case 1:
            case 2:
                MethodScope var1 = this.method_635();
                if (!var1.method_727()) {
                    MethodBinding var5 = ((AbstractMethodDeclaration)var1.referenceContext).binding;
                    if (var5 != null && var5.method_375()) {
                        return true;
                    }
                } else {
                    var2 = ((BlockScope)this).referenceType().binding;
                    if (var1.initializedField != null && var1.initializedField.method_434()) {
                        return true;
                    }
                    if (var2 != null) {
                        var2.initializeDeprecatedAnnotationTagBits();
                        if (var2.method_230()) {
                            return true;
                        }
                    }
                }
                break;
            case 3:
                var2 = ((ClassScope)this).referenceType().binding;
                if (var2 != null) {
                    var2.initializeDeprecatedAnnotationTagBits();
                    if (var2.method_230()) {
                        return true;
                    }
                }
                break;
            case 4:
                CompilationUnitDeclaration var3 = this.referenceCompilationUnit();
                if (var3.types != null && var3.types.length > 0) {
                    SourceTypeBinding var4 = var3.types[0].binding;
                    if (var4 != null) {
                        var4.initializeDeprecatedAnnotationTagBits();
                        if (var4.method_230()) {
                            return true;
                        }
                    }
                }
        }
        return false;
    }

    private TypeBinding method_631(TypeBinding var1, Object var2, List var3) {
        if (var2 == null) {
            return var1;
        } else if (var2 instanceof TypeBinding) {
            return (TypeBinding)var2;
        } else {
            TypeBinding[] var4 = (TypeBinding[])((TypeBinding[])var2);
            int var5 = var1.method_136();
            var1 = var1.method_173();
            int var6 = var1.typeVariables().length;
            if (var6 == 0) {
                return var1;
            } else {
                TypeBinding[] var7 = new TypeBinding[var6];
                int var8 = 0;
                label67:
                for (int var9 = var4.length; var8 < var9; ++var8) {
                    TypeBinding var10 = var4[var8].method_173();
                    switch (var10.kind()) {
                        case 260:
                            ParameterizedTypeBinding var16 = (ParameterizedTypeBinding)var10;
                            int var17 = 0;
                            while (true) {
                                if (var17 >= var6) {
                                    continue label67;
                                }
                                TypeBinding var14 = this.method_632(var7[var17], var16.arguments[var17], (ReferenceBinding)var1, var17, var3);
                                if (var14 == null) {
                                    return null;
                                }
                                var7[var17] = var14;
                                ++var17;
                            }
                        case 1028:
                            return (TypeBinding)(var5 == 0 ? var10 : this.environment().createArrayType(var10, var5));
                        case 2052:
                            TypeVariableBinding[] var11 = var10.typeVariables();
                            for (int var12 = 0; var12 < var6; ++var12) {
                                TypeBinding var13 = this.method_632(var7[var12], var11[var12], (ReferenceBinding)var1, var12, var3);
                                if (var13 == null) {
                                    return null;
                                }
                                var7[var12] = var13;
                            }
                    }
                }
                ParameterizedTypeBinding var15 = this.environment().createParameterizedType((ReferenceBinding)var1.erasure(), var7, var1.enclosingType());
                if (var5 == 0) {
                    return var15;
                }
                return this.environment().createArrayType(var15, var5);
            }
        }
    }

    private TypeBinding method_632(TypeBinding var1, TypeBinding var2, ReferenceBinding var3, int var4, List var5) {
        if (var1 == null) {
            return var2;
        } else if (var1 == var2) {
            return var1;
        } else {
            WildcardBinding var6;
            TypeBinding[] var8;
            TypeBinding var10;
            if (var2.method_172()) {
                var6 = (WildcardBinding)var2;
                if (var1.method_172()) {
                    WildcardBinding var7 = (WildcardBinding)var1;
                    label86:
                    switch (var7.field_215) {
                        case 1:
                            switch (var6.field_215) {
                                case 1:
                                    TypeBinding var11 = this.method_634(new TypeBinding[] {var7.bound, var6.bound}, var5);
                                    if (var11 == null) {
                                        return null;
                                    }
                                    if (var11 == TypeBinding.field_179) {
                                        return this.environment().createWildcard(var3, var4, (TypeBinding)null, (TypeBinding[])null, 0);
                                    }
                                    return this.environment().createWildcard(var3, var4, var11, (TypeBinding[])null, 1);
                                case 2:
                                    if (var7.bound == var6.bound) {
                                        return var7.bound;
                                    }
                                    return this.environment().createWildcard(var3, var4, (TypeBinding)null, (TypeBinding[])null, 0);
                                default:
                                    break label86;
                            }
                        case 2:
                            if (var7.field_215 == 2) {
                                var8 = greaterLowerBound(new TypeBinding[] {var7.bound, var6.bound});
                                if (var8 == null) {
                                    return null;
                                }
                                return this.environment().createWildcard(var3, var4, var8[0], (TypeBinding[])null, 2);
                            }
                    }
                } else {
                    switch (var6.field_215) {
                        case 0:
                        default:
                            break;
                        case 1:
                            var10 = this.method_634(new TypeBinding[] {var1, var6.bound}, var5);
                            if (var10 == null) {
                                return null;
                            }
                            if (var10 == TypeBinding.field_179) {
                                return this.environment().createWildcard(var3, var4, (TypeBinding)null, (TypeBinding[])null, 0);
                            }
                            return this.environment().createWildcard(var3, var4, var10, (TypeBinding[])null, 1);
                        case 2:
                            var8 = greaterLowerBound(new TypeBinding[] {var1, var6.bound});
                            if (var8 == null) {
                                return null;
                            }
                            return this.environment().createWildcard(var3, var4, var8[0], (TypeBinding[])null, 2);
                    }
                }
            } else if (var1.method_172()) {
                var6 = (WildcardBinding)var1;
                switch (var6.field_215) {
                    case 0:
                    default:
                        break;
                    case 1:
                        var10 = this.method_634(new TypeBinding[] {var6.bound, var2}, var5);
                        if (var10 == null) {
                            return null;
                        }
                        if (var10 == TypeBinding.field_179) {
                            return this.environment().createWildcard(var3, var4, (TypeBinding)null, (TypeBinding[])null, 0);
                        }
                        return this.environment().createWildcard(var3, var4, var10, (TypeBinding[])null, 1);
                    case 2:
                        var8 = greaterLowerBound(new TypeBinding[] {var6.bound, var2});
                        if (var8 == null) {
                            return null;
                        }
                        return this.environment().createWildcard(var3, var4, var8[0], (TypeBinding[])null, 2);
                }
            }
            TypeBinding var9 = this.method_634(new TypeBinding[] {var1, var2}, var5);
            return var9 == null ? null : (var9 == TypeBinding.field_179 ? this.environment().createWildcard(var3, var4, (TypeBinding)null, (TypeBinding[])null, 0) : this.environment().createWildcard(var3, var4, var9, (TypeBinding[])null, 1));
        }
    }

    public TypeBinding lowerUpperBound(TypeBinding[] var1) {
        int var2 = var1.length;
        if (var2 == 1) {
            TypeBinding var3 = var1[0];
            return (TypeBinding)(var3 == null ? TypeBinding.field_188 : var3);
        } else {
            ArrayList var10002 = new ArrayList(1);
            return this.method_634(var1, var10002);
        }
    }

    private TypeBinding method_634(TypeBinding[] var1, List var2) {
        int var3 = var1.length;
        if (var3 == 1) {
            TypeBinding var15 = var1[0];
            return (TypeBinding)(var15 == null ? TypeBinding.field_188 : var15);
        } else {
            int var4 = var2.size();
            TypeBinding[] var6;
            int var7;
            int var8;
            TypeBinding var9;
            int var10;
            label134:
            for (int var5 = 0; var5 < var4; ++var5) {
                var6 = (TypeBinding[])((TypeBinding[])var2.get(var5));
                var7 = var6.length;
                if (var7 >= var3) {
                    for (var8 = 0; var8 < var3; ++var8) {
                        var9 = var1[var8];
                        if (var9 != null) {
                            var10 = 0;
                            while (true) {
                                if (var10 >= var7) {
                                    continue label134;
                                }
                                TypeBinding var11 = var6[var10];
                                if (var11 != null && (var11 == var9 || var11.isEquivalentTo(var9))) {
                                    break;
                                }
                                ++var10;
                            }
                        }
                    }
                    return TypeBinding.field_179;
                }
            }
            var2.add(var1);
            HashMap var10000 = new HashMap(1);
            HashMap var16 = var10000;
            var6 = this.method_636(var1, var16);
            if (var6 == null) {
                return null;
            } else {
                var7 = var6.length;
                if (var7 == 0) {
                    return TypeBinding.field_188;
                } else {
                    var8 = 0;
                    var9 = null;
                    var10 = -1;
                    int var13;
                    for (int var17 = 0; var17 < var7; ++var17) {
                        TypeBinding var12 = var6[var17];
                        if (var12 != null) {
                            var12 = this.method_631(var12, var16.get(var12), var2);
                            if (var12 == null) {
                                return null;
                            }
                            var13 = var12.method_136();
                            if (var10 == -1) {
                                var10 = var13;
                            } else if (var13 != var10) {
                                return null;
                            }
                            if (var9 == null && !var12.method_173().method_157()) {
                                var9 = var12.method_173();
                            }
                            var6[var8++] = var12;
                        }
                    }
                    switch (var8) {
                        case 0:
                            return TypeBinding.field_188;
                        case 1:
                            return var6[0];
                        case 2:
                            if ((var10 == 0 ? var6[1].id : var6[1].method_173().id) == 1) {
                                return var6[0];
                            } else if ((var10 == 0 ? var6[0].id : var6[0].method_173().id) == 1) {
                                return var6[1];
                            }
                        default:
                            TypeBinding[] var19 = new TypeBinding[var8 - 1];
                            int var18 = 0;
                            for (var13 = 0; var13 < var8; ++var13) {
                                TypeBinding var14 = var10 == 0 ? var6[var13] : var6[var13].method_173();
                                if (var14.method_157()) {
                                    var19[var18++] = var14;
                                }
                            }
                            WildcardBinding var20 = this.environment().createWildcard((ReferenceBinding)null, 0, var9, var19, 1);
                            if (var10 == 0) {
                                return var20;
                            }
                            return this.environment().createArrayType(var20, var10);
                    }
                }
            }
        }
    }

    public final MethodScope method_635() {
        Scope var1 = this;
        while (!(var1 instanceof MethodScope)) {
            var1 = var1.parent;
            if (var1 == null) {
                return null;
            }
        }
        return (MethodScope)var1;
    }

    protected TypeBinding[] method_636(TypeBinding[] var1, Map var2) {
        int var3 = var1.length;
        int var4 = -1;
        int var5 = 0;
        for (int var6 = 0; var6 < var3; ++var6) {
            TypeBinding var7 = var1[var6];
            if (var7 != null) {
                if (var7.method_148()) {
                    return null;
                }
                if (var4 < 0) {
                    var4 = var6;
                }
                ++var5;
            }
        }
        switch (var5) {
            case 0:
                return Binding.field_149;
            case 1:
                return var1;
            default:
                TypeBinding var26 = var1[var4];
                if (var26.method_148()) {
                    return null;
                } else {
                    ArrayList var10000 = new ArrayList(5);
                    ArrayList var27 = var10000;
                    int var8 = var26.method_136();
                    TypeBinding var9 = var26.method_173();
                    TypeBinding var10;
                    switch (var9.kind()) {
                        case 68:
                        case 260:
                        case 1028:
                            var10 = var26.erasure();
                            break;
                        default:
                            var10 = var26;
                    }
                    if (var10 != var26) {
                        var2.put(var10, var26);
                    }
                    var27.add(var26);
                    int var11 = 1;
                    int var13 = 0;
                    int var17;
                    int var16;
                    for (; var13 < var11; ++var13) {
                        TypeBinding var14 = (TypeBinding)var27.get(var13);
                        var8 = var14.method_136();
                        TypeBinding var31;
                        if (var8 > 0) {
                            var9 = var14.method_173();
                            switch (var9.id) {
                                case 1:
                                    if (var8 > 1) {
                                        var31 = ((ArrayBinding)var14).method_187();
                                        if (!var27.contains(var31)) {
                                            var27.add(var31);
                                            ++var11;
                                        }
                                        continue;
                                    }
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                    ReferenceBinding var15 = this.method_603();
                                    if (!var27.contains(var15)) {
                                        var27.add(var15);
                                        ++var11;
                                    }
                                    var15 = this.method_607();
                                    if (!var27.contains(var15)) {
                                        var27.add(var15);
                                        ++var11;
                                    }
                                    var15 = this.method_609();
                                    if (!var27.contains(var15)) {
                                        var27.add(var15);
                                        ++var11;
                                    }
                                    continue;
                                case 6:
                                default:
                                    var14 = var9;
                            }
                        }
                        ReferenceBinding var12 = (ReferenceBinding)var14;
                        Object var33;
                        if (var12.isCapture()) {
                            var31 = ((CaptureBinding)var12).firstBound;
                            if (var31 != null && var31.method_147()) {
                                Object var35 = var8 == 0 ? var31 : this.environment().createArrayType(var31, var8);
                                if (!var27.contains(var35)) {
                                    var27.add(var35);
                                    ++var11;
                                    var33 = !var31.method_169() && !var31.method_172() ? ((TypeBinding)var35).erasure() : var35;
                                    if (var33 != var35) {
                                        var2.put(var33, var35);
                                    }
                                }
                                continue;
                            }
                        }
                        ReferenceBinding[] var30 = var12.superInterfaces();
                        if (var30 != null) {
                            var16 = 0;
                            for (var17 = var30.length; var16 < var17; ++var16) {
                                ReferenceBinding var18 = var30[var16];
                                Object var19;
                                if (var8 == 0) {
                                    var19 = var18;
                                } else {
                                    var19 = this.environment().createArrayType(var18, var8);
                                }
                                if (!var27.contains(var19)) {
                                    var27.add(var19);
                                    ++var11;
                                    Object var20 = !var18.method_169() && !var18.method_172() ? ((TypeBinding)var19).erasure() : var19;
                                    if (var20 != var19) {
                                        var2.put(var20, var19);
                                    }
                                }
                            }
                        }
                        ReferenceBinding var29 = var12.superclass();
                        if (var29 != null) {
                            if (var8 == 0) {
                                var33 = var29;
                            } else {
                                var33 = this.environment().createArrayType(var29, var8);
                            }
                            if (!var27.contains(var33)) {
                                var27.add(var33);
                                ++var11;
                                Object var39 = !var29.method_169() && !var29.method_172() ? ((TypeBinding)var33).erasure() : var33;
                                if (var39 != var33) {
                                    var2.put(var39, var33);
                                }
                            }
                        }
                    }
                    var13 = var27.size();
                    TypeBinding[] var28 = new TypeBinding[var13];
                    int var36 = 0;
                    TypeBinding var32;
                    for (Iterator var34 = var27.iterator(); var34.hasNext(); var28[var36++] = !var9.method_169() && !var9.method_172() ? var32.erasure() : var32) {
                        var32 = (TypeBinding)var34.next();
                        var9 = var32.method_173();
                    }
                    var16 = var13;
                    TypeBinding var38;
                    int var37;
                    TypeBinding var40;
                    for (var17 = var4 + 1; var17 < var3; ++var17) {
                        var38 = var1[var17];
                        if (var38 != null) {
                            TypeBinding var21;
                            TypeBinding[] var23;
                            Object var22;
                            int var25;
                            int var24;
                            if (var38.method_147()) {
                                label247:
                                for (var37 = 0; var37 < var13; ++var37) {
                                    var40 = var28[var37];
                                    if (var40 != null && var40 != var38) {
                                        if ((var21 = var38.method_140(var40)) == null) {
                                            var28[var37] = null;
                                            --var16;
                                            if (var16 == 0) {
                                                return null;
                                            }
                                        } else {
                                            var22 = var2.get(var40);
                                            if (var22 == null) {
                                                var2.put(var40, var21);
                                            } else if (var22 instanceof TypeBinding) {
                                                if (var21 != var22) {
                                                    var23 = new TypeBinding[] {(TypeBinding)var22, var21};
                                                    var2.put(var40, var23);
                                                }
                                            } else {
                                                var23 = (TypeBinding[])((TypeBinding[])var22);
                                                var24 = var23.length;
                                                for (var25 = 0; var25 < var24; ++var25) {
                                                    if (var23[var25] == var21) {
                                                        continue label247;
                                                    }
                                                }
                                                System.arraycopy(var23, 0, var23 = new TypeBinding[var24 + 1], 0, var24);
                                                var2.put(var40, var23);
                                                var23[var24] = var21;
                                            }
                                        }
                                    }
                                }
                            } else {
                                label277:
                                for (var37 = 0; var37 < var13; ++var37) {
                                    var40 = var28[var37];
                                    if (var40 != null) {
                                        if (var40 != var38 && (var40.id != 1 || !var38.method_157())) {
                                            if (var40.method_147()) {
                                                var21 = null;
                                            } else {
                                                var21 = var38.method_140(var40);
                                            }
                                            if (var21 == null) {
                                                var28[var37] = null;
                                                --var16;
                                                if (var16 == 0) {
                                                    return null;
                                                }
                                                continue;
                                            }
                                        } else {
                                            var21 = var40;
                                        }
                                        var22 = var2.get(var40);
                                        if (var22 == null) {
                                            var2.put(var40, var21);
                                        } else if (var22 instanceof TypeBinding) {
                                            if (var21 != var22) {
                                                var23 = new TypeBinding[] {(TypeBinding)var22, var21};
                                                var2.put(var40, var23);
                                            }
                                        } else {
                                            var23 = (TypeBinding[])((TypeBinding[])var22);
                                            var24 = var23.length;
                                            for (var25 = 0; var25 < var24; ++var25) {
                                                if (var23[var25] == var21) {
                                                    continue label277;
                                                }
                                            }
                                            System.arraycopy(var23, 0, var23 = new TypeBinding[var24 + 1], 0, var24);
                                            var2.put(var40, var23);
                                            var23[var24] = var21;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (var16 > 1) {
                        for (var17 = 0; var17 < var13; ++var17) {
                            var38 = var28[var17];
                            if (var38 != null) {
                                for (var37 = 0; var37 < var13; ++var37) {
                                    if (var17 != var37) {
                                        var40 = var28[var37];
                                        if (var40 != null) {
                                            if (var38 instanceof ReferenceBinding) {
                                                if ((var40.id != 1 || !var38.method_157()) && var38.method_140(var40) != null) {
                                                    var28[var37] = null;
                                                    --var16;
                                                }
                                            } else if (var38.method_147() && (!var40.method_147() || var40.method_173().id != 1 || var40.method_136() != var38.method_136() || !var38.method_173().method_157()) && var38.method_140(var40) != null) {
                                                var28[var37] = null;
                                                --var16;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return var28;
                }
        }
    }

    protected final MethodBinding method_637(MethodBinding[] var1, int var2, InvocationSite var3) {
        MethodBinding var4 = null;
        int var5 = 0;
        label36:
        while (var5 < var2) {
            MethodBinding var6 = var1[var5];
            if (var4 != null && var6.declaringClass != var4.declaringClass) {
                break;
            }
            if (!var6.method_370()) {
                var4 = var6;
            }
            for (int var7 = 0; var7 < var2; ++var7) {
                if (var5 != var7 && !var1[var7].areParametersCompatibleWith(var6.parameters)) {
                    ++var5;
                    continue label36;
                }
            }
            this.compilationUnitScope().recordTypeReferences(var6.thrownExceptions);
            return var6;
        }
        ProblemMethodBinding var10000 = new ProblemMethodBinding(var1[0], var1[0].selector, var1[0].parameters, 3);
        return var10000;
    }

    protected final MethodBinding method_638(MethodBinding[] var1, int var2, InvocationSite var3) {
        int var4 = 0;
        label26:
        while (var4 < var2) {
            MethodBinding var5 = var1[var4];
            for (int var6 = 0; var6 < var2; ++var6) {
                if (var4 != var6 && !var1[var6].areParametersCompatibleWith(var5.parameters)) {
                    ++var4;
                    continue label26;
                }
            }
            this.compilationUnitScope().recordTypeReferences(var5.thrownExceptions);
            return var5;
        }
        ProblemMethodBinding var10000 = new ProblemMethodBinding(var1[0], var1[0].selector, var1[0].parameters, 3);
        return var10000;
    }

    protected final MethodBinding mostSpecificMethodBinding(MethodBinding[] var1, int var2, TypeBinding[] var3, InvocationSite var4, ReferenceBinding var5) {
        int[] var6 = new int[var2];
        for (int var7 = 0; var7 < var2; ++var7) {
            var6[var7] = this.parameterCompatibilityLevel(var1[var7], var3);
        }
        boolean var25 = var4.genericTypeArguments() == null;
        MethodBinding[] var8 = new MethodBinding[var2];
        int var9 = 0;
        int var10 = 0;
        MethodBinding var14;
        MethodBinding var17;
        int var16;
        MethodBinding var32;
        for (int var11 = 2; var10 <= var11; ++var10) {
            label308:
            for (int var12 = 0; var12 < var2; ++var12) {
                if (var6[var12] == var10) {
                    var11 = var10;
                    MethodBinding var13 = var1[var12];
                    var14 = var13.original();
                    MethodBinding var15 = var25 ? var13.tiebreakMethod() : var13;
                    for (var16 = 0; var16 < var2; ++var16) {
                        if (var12 != var16 && var6[var16] == var10) {
                            var17 = var1[var16];
                            if (var14 == var17.original()) {
                                var6[var16] = -1;
                            } else {
                                MethodBinding var18 = var17;
                                if (var17 instanceof ParameterizedGenericMethodBinding) {
                                    ParameterizedGenericMethodBinding var19 = (ParameterizedGenericMethodBinding)var17;
                                    if (!var19.field_297 || var19.method_370()) {
                                        var18 = var19.originalMethod;
                                    }
                                }
                                var32 = this.computeCompatibleMethod(var18, var15.parameters, var4);
                                if (var32 == null || !var32.isValidBinding() || !this.isAcceptableMethod(var15, var32) || var13.method_357() && !var17.method_357() && var15.method_344(var32)) {
                                    continue label308;
                                }
                            }
                        }
                    }
                    var8[var12] = var13;
                    ++var9;
                }
            }
        }
        ProblemMethodBinding var42;
        if (var9 == 1) {
            for (var10 = 0; var10 < var2; ++var10) {
                if (var8[var10] != null) {
                    this.compilationUnitScope().recordTypeReferences(var1[var10].thrownExceptions);
                    return var1[var10];
                }
            }
        } else if (var9 == 0) {
            var42 = new ProblemMethodBinding(var1[0], var1[0].selector, var1[0].parameters, 3);
            return var42;
        }
        if (var5 != null) {
            var5 = var5 instanceof CaptureBinding ? var5 : (ReferenceBinding)var5.erasure();
        }
        label267:
        for (var10 = 0; var10 < var2; ++var10) {
            MethodBinding var27 = var8[var10];
            if (var27 != null) {
                ReferenceBinding[] var26 = null;
                SimpleSet var28 = null;
                var14 = var27.original();
                int var21;
                for (int var29 = 0; var29 < var2; ++var29) {
                    MethodBinding var30 = var8[var29];
                    if (var30 != null && var10 != var29) {
                        var17 = var30.original();
                        if (var14.declaringClass == var17.declaringClass) {
                            break label267;
                        }
                        int var20;
                        TypeBinding var33;
                        MethodBinding[] var37;
                        if (!var14.method_356()) {
                            if (!var17.method_356()) {
                                var33 = var14.declaringClass.method_140(var17.declaringClass.erasure());
                                if (var33 == null) {
                                    continue label267;
                                }
                                if (var27.method_354() || var14.typeVariables != Binding.NO_TYPE_VARIABLES) {
                                    if (var17.declaringClass != var33) {
                                        var37 = ((ReferenceBinding)var33).getMethods(var17.selector);
                                        var20 = 0;
                                        for (var21 = var37.length; var20 < var21; ++var20) {
                                            if (var37[var20].original() == var17) {
                                                var17 = var37[var20];
                                                break;
                                            }
                                        }
                                    }
                                    if (!this.environment().methodVerifier().method_548(var14, var17)) {
                                        continue label267;
                                    }
                                }
                            }
                        } else if (var5 != null) {
                            var33 = var5.method_140(var14.declaringClass.erasure());
                            if (var14.declaringClass != var33 && var33 instanceof ReferenceBinding) {
                                var37 = ((ReferenceBinding)var33).getMethods(var14.selector);
                                var20 = 0;
                                for (var21 = var37.length; var20 < var21; ++var20) {
                                    if (var37[var20].original() == var14) {
                                        var14 = var37[var20];
                                        break;
                                    }
                                }
                            }
                            var33 = var5.method_140(var17.declaringClass.erasure());
                            if (var17.declaringClass != var33 && var33 instanceof ReferenceBinding) {
                                var37 = ((ReferenceBinding)var33).getMethods(var17.selector);
                                var20 = 0;
                                for (var21 = var37.length; var20 < var21; ++var20) {
                                    if (var37[var20].original() == var17) {
                                        var17 = var37[var20];
                                        break;
                                    }
                                }
                            }
                            if (var14.typeVariables != Binding.NO_TYPE_VARIABLES) {
                                var17 = var14.computeSubstitutedMethod(var17, this.environment());
                            }
                            if (var17 == null || !var14.method_342(var17) || !var14.returnType.isCompatibleWith(var17.returnType) && !var14.returnType.erasure().isCompatibleWith(var17.returnType.erasure())) {
                                continue label267;
                            }
                            if (var14.thrownExceptions != var17.thrownExceptions) {
                                if (var26 == null) {
                                    var26 = var14.thrownExceptions;
                                }
                                SimpleSet var10000;
                                if (var28 == null) {
                                    var10000 = new SimpleSet(3);
                                    var28 = var10000;
                                }
                                int var34 = var26.length;
                                var20 = var17.thrownExceptions.length;
                                var10000 = new SimpleSet(var34);
                                SimpleSet var41 = var10000;
                                for (int var22 = 0; var22 < var34; ++var22) {
                                    ReferenceBinding var23 = var26[var22];
                                    for (int var24 = 0; var24 < var20; ++var24) {
                                        if (var23.isCompatibleWith(var17.thrownExceptions[var24])) {
                                            var28.method_1335(var27);
                                            var41.method_1335(var23);
                                            break;
                                        }
                                        if (var17.thrownExceptions[var24].isCompatibleWith(var23)) {
                                            var28.method_1335(var30);
                                            var41.method_1335(var17.thrownExceptions[var24]);
                                            break;
                                        }
                                    }
                                }
                                var26 = var41.field_988 == 0 ? Binding.field_151 : new ReferenceBinding[var41.field_988];
                                var41.asArray(var26);
                            }
                        }
                    }
                }
                if (var26 == null) {
                    return var27;
                }
                Object[] var31 = var28.values;
                var16 = var26.length;
                int var36 = 0;
                label186:
                for (int var35 = var31.length; var36 < var35; ++var36) {
                    var32 = (MethodBinding)var31[var36];
                    if (var32 != null) {
                        ReferenceBinding[] var38 = var32.thrownExceptions;
                        if (var38.length == var16) {
                            var21 = 0;
                            while (var21 < var16) {
                                ReferenceBinding var39 = var38[var21];
                                int var40 = 0;
                                while (true) {
                                    if (var40 >= var16) {
                                        continue label186;
                                    }
                                    if (var39 == var26[var40]) {
                                        ++var21;
                                        break;
                                    }
                                    ++var40;
                                }
                            }
                            return var32;
                        }
                    }
                }
                MethodBinding var43 = new MethodBinding(var27.modifiers | 4096, var27.selector, var27.returnType, var27.parameters, var26, var27.declaringClass);
                return var43;
            }
        }
        var42 = new ProblemMethodBinding(var1[0], var1[0].selector, var1[0].parameters, 3);
        return var42;
    }

    public final ClassScope method_640() {
        ClassScope var1 = null;
        Scope var2 = this;
        do {
            if (var2 instanceof ClassScope) {
                var1 = (ClassScope)var2;
            }
            var2 = var2.parent;
        } while (var2 != null);
        return var1;
    }

    public final MethodScope method_641() {
        MethodScope var1 = null;
        Scope var2 = this;
        do {
            if (var2 instanceof MethodScope) {
                var1 = (MethodScope)var2;
            }
            var2 = var2.parent;
        } while (var2 != null);
        return var1;
    }

    public int parameterCompatibilityLevel(MethodBinding var1, TypeBinding[] var2) {
        TypeBinding[] var3 = var1.parameters;
        int var4 = var3.length;
        int var5 = var2.length;
        int var6;
        if (this.compilerOptions().field_1928 < 3211264L) {
            if (var4 != var5) {
                return -1;
            } else {
                for (var6 = 0; var6 < var5; ++var6) {
                    TypeBinding var13 = var3[var6];
                    TypeBinding var14 = var2[var6];
                    if (var14 != var13 && !var14.isCompatibleWith(var13)) {
                        return -1;
                    }
                }
                return 0;
            }
        } else {
            var6 = 0;
            int var7 = var5;
            LookupEnvironment var8 = this.environment();
            TypeBinding var10;
            TypeBinding var11;
            if (var1.method_374()) {
                var7 = var4 - 1;
                TypeBinding var9;
                if (var4 == var5) {
                    var9 = var3[var7];
                    var10 = var2[var7];
                    if (var9 != var10) {
                        var6 = this.parameterCompatibilityLevel(var10, var9, var8);
                        if (var6 == -1) {
                            var9 = ((ArrayBinding)var9).method_187();
                            if (this.parameterCompatibilityLevel(var10, var9, var8) == -1) {
                                return -1;
                            }
                            var6 = 2;
                        }
                    }
                } else {
                    if (var4 < var5) {
                        var9 = ((ArrayBinding)var3[var7]).method_187();
                        for (int var16 = var7; var16 < var5; ++var16) {
                            var11 = var2[var16];
                            if (var9 != var11 && this.parameterCompatibilityLevel(var11, var9, var8) == -1) {
                                return -1;
                            }
                        }
                    } else if (var7 != var5) {
                        return -1;
                    }
                    var6 = 2;
                }
            } else if (var4 != var5) {
                return -1;
            }
            for (int var15 = 0; var15 < var7; ++var15) {
                var10 = var3[var15];
                var11 = var2[var15];
                if (var11 != var10) {
                    int var12 = this.parameterCompatibilityLevel(var11, var10, var8);
                    if (var12 == -1) {
                        return -1;
                    }
                    if (var12 > var6) {
                        var6 = var12;
                    }
                }
            }
            return var6;
        }
    }

    private int parameterCompatibilityLevel(TypeBinding var1, TypeBinding var2, LookupEnvironment var3) {
        if (var1.isCompatibleWith(var2)) {
            return 0;
        } else {
            if (var1.method_148() != var2.method_148()) {
                TypeBinding var4 = var3.method_486(var1);
                if (var4 == var2 || var4.isCompatibleWith(var2)) {
                    return 1;
                }
            }
            return -1;
        }
    }

    public abstract ProblemReporter problemReporter();

    public final CompilationUnitDeclaration referenceCompilationUnit() {
        Scope var2 = this;
        while (true) {
            Scope var1 = var2.parent;
            if (var2.parent == null) {
                return ((CompilationUnitScope)var2).referenceContext;
            }
            var2 = var1;
        }
    }

    int startIndex() {
        return 0;
    }
}
