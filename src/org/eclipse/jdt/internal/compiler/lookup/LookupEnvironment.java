package org.eclipse.jdt.internal.compiler.lookup;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import java.util.Vector;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ClassFile;
import org.eclipse.jdt.internal.compiler.ClassFilePool;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.env.IBinaryType;
import org.eclipse.jdt.internal.compiler.env.INameEnvironment;
import org.eclipse.jdt.internal.compiler.env.NameEnvironmentAnswer;
import org.eclipse.jdt.internal.compiler.env.AccessRestriction;
import org.eclipse.jdt.internal.compiler.impl.ITypeRequestor;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.SignatureWrapper;
import org.eclipse.jdt.internal.compiler.lookup.AnnotationBinding;
import org.eclipse.jdt.internal.compiler.lookup.ElementValuePair;
import org.eclipse.jdt.internal.compiler.lookup.ImportBinding;
import org.eclipse.jdt.internal.compiler.lookup.PackageBinding;
import org.eclipse.jdt.internal.compiler.lookup.ProblemPackageBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ArrayBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.UnresolvedReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.WildcardBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.BinaryTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.MissingTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ProblemReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.ParameterizedTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.RawTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.ParameterizedGenericMethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodVerifier;
import org.eclipse.jdt.internal.compiler.lookup.MethodVerifier15;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.CompilationUnitScope;
import org.eclipse.jdt.internal.compiler.problem.ProblemReporter;
import org.eclipse.jdt.internal.compiler.util.HashtableOfPackage;
import org.eclipse.jdt.internal.compiler.util.SimpleLookupTable;

public class LookupEnvironment implements TypeConstants {

    private Map field_345;

    ImportBinding[] defaultImports;

    public PackageBinding defaultPackage;

    HashtableOfPackage knownPackages;

    private int field_349;

    private int field_350;

    public INameEnvironment nameEnvironment;

    public CompilerOptions globalOptions;

    public ProblemReporter problemReporter;

    public ClassFilePool classFilePool;

    private int field_355;

    public ITypeRequestor typeRequestor;

    private ArrayBinding[][] uniqueArrayBindings;

    private SimpleLookupTable field_358;

    private SimpleLookupTable field_359;

    private SimpleLookupTable field_360;

    private SimpleLookupTable field_361;

    public CompilationUnitDeclaration unitBeingCompleted;

    public Object missingClassFileLocation;

    private CompilationUnitDeclaration[] units;

    private MethodVerifier verifier;

    static final ProblemPackageBinding TheNotFoundPackage;

    static final ProblemReferenceBinding TheNotFoundType;

    public LookupEnvironment(ITypeRequestor var1, CompilerOptions var2, ProblemReporter var3, INameEnvironment var4) {
        this.field_349 = -1;
        this.field_350 = -1;
        this.unitBeingCompleted = null;
        this.missingClassFileLocation = null;
        this.units = new CompilationUnitDeclaration[4];
        this.typeRequestor = var1;
        this.globalOptions = var2;
        this.problemReporter = var3;
        PackageBinding var10001 = new PackageBinding(this);
        this.defaultPackage = var10001;
        this.defaultImports = null;
        this.nameEnvironment = var4;
        HashtableOfPackage var8 = new HashtableOfPackage();
        this.knownPackages = var8;
        this.uniqueArrayBindings = new ArrayBinding[5][];
        this.uniqueArrayBindings[0] = new ArrayBinding[50];
        SimpleLookupTable var7 = new SimpleLookupTable(3);
        this.field_358 = var7;
        var7 = new SimpleLookupTable(3);
        this.field_359 = var7;
        var7 = new SimpleLookupTable(3);
        this.field_360 = var7;
        var7 = new SimpleLookupTable(3);
        this.field_361 = var7;
        HashMap var5 = new HashMap(3);
        this.field_345 = var5;
        ClassFilePool var6 = new ClassFilePool();
        this.classFilePool = var6;
    }

    public ReferenceBinding method_481(char[][] var1) {
        NameEnvironmentAnswer var2 = this.nameEnvironment.findType(var1);
        if (var2 == null) {
            return null;
        } else {
            if (var2.method_3187()) {
                this.typeRequestor.accept(var2.getBinaryType(), this.computePackageFrom(var1, false), var2.getAccessRestriction());
            } else if (var2.method_3188()) {
                this.typeRequestor.accept(var2.getCompilationUnit(), var2.getAccessRestriction());
            } else if (var2.method_3189()) {
                this.typeRequestor.accept(var2.getSourceTypes(), this.computePackageFrom(var1, false), var2.getAccessRestriction());
            }
            return this.method_504(var1);
        }
    }

    ReferenceBinding askForType(PackageBinding var1, char[] var2) {
        if (var1 == null) {
            if (this.defaultPackage == null) {
                return null;
            }
            var1 = this.defaultPackage;
        }
        NameEnvironmentAnswer var3 = this.nameEnvironment.findType(var2, var1.compoundName);
        if (var3 == null) {
            return null;
        } else {
            if (var3.method_3187()) {
                this.typeRequestor.accept(var3.getBinaryType(), var1, var3.getAccessRestriction());
            } else if (var3.method_3188()) {
                this.typeRequestor.accept(var3.getCompilationUnit(), var3.getAccessRestriction());
            } else if (var3.method_3189()) {
                this.typeRequestor.accept(var3.getSourceTypes(), var1, var3.getAccessRestriction());
            }
            return var1.method_124(var2);
        }
    }

    public void buildTypeBindings(CompilationUnitDeclaration var1, AccessRestriction var2) {
        CompilationUnitScope var10000 = new CompilationUnitScope(var1, this);
        CompilationUnitScope var3 = var10000;
        var3.buildTypeBindings(var2);
        int var4 = this.units.length;
        if (++this.field_350 >= var4) {
            System.arraycopy(this.units, 0, this.units = new CompilationUnitDeclaration[2 * var4], 0, var4);
        }
        this.units[this.field_350] = var1;
    }

    public void method_484() {
        this.field_355 = 1;
        int var1;
        for (var1 = this.field_349 + 1; var1 <= this.field_350; ++var1) {
            (this.unitBeingCompleted = this.units[var1]).scope.method_675();
        }
        this.field_355 = 2;
        for (var1 = this.field_349 + 1; var1 <= this.field_350; ++var1) {
            (this.unitBeingCompleted = this.units[var1]).scope.method_678();
        }
        this.field_355 = 3;
        for (var1 = this.field_349 + 1; var1 <= this.field_350; ++var1) {
            CompilationUnitScope var2 = (this.unitBeingCompleted = this.units[var1]).scope;
            var2.method_676();
            var2.method_673();
            this.units[var1] = null;
        }
        this.field_355 = 4;
        this.field_349 = this.field_350;
        this.unitBeingCompleted = null;
    }

    public void completeTypeBindings(CompilationUnitDeclaration var1) {
        if (this.field_355 == 4) {
            this.method_484();
        } else {
            if (var1.scope == null) {
                return;
            }
            if (this.field_355 >= 2) {
                (this.unitBeingCompleted = var1).scope.method_675();
            }
            if (this.field_355 >= 3) {
                (this.unitBeingCompleted = var1).scope.method_678();
            }
            this.unitBeingCompleted = null;
        }
    }

    public TypeBinding method_486(TypeBinding var1) {
        ReferenceBinding var2;
        ProblemReferenceBinding var10000;
        switch (var1.id) {
            case 2:
                var2 = this.method_508(field_111);
                if (var2 != null) {
                    return var2;
                }
                var10000 = new ProblemReferenceBinding(field_111, (ReferenceBinding)null, 1);
                return var10000;
            case 3:
                var2 = this.method_508(field_109);
                if (var2 != null) {
                    return var2;
                }
                var10000 = new ProblemReferenceBinding(field_109, (ReferenceBinding)null, 1);
                return var10000;
            case 4:
                var2 = this.method_508(field_110);
                if (var2 != null) {
                    return var2;
                }
                var10000 = new ProblemReferenceBinding(field_110, (ReferenceBinding)null, 1);
                return var10000;
            case 5:
                var2 = this.method_508(field_116);
                if (var2 != null) {
                    return var2;
                }
                var10000 = new ProblemReferenceBinding(field_116, (ReferenceBinding)null, 1);
                return var10000;
            case 6:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            default:
                switch (var1.kind()) {
                    case 516:
                    case 4100:
                    case 8196:
                        switch (var1.erasure().id) {
                            case 26:
                                return TypeBinding.field_180;
                            case 27:
                                return TypeBinding.field_181;
                            case 28:
                                return TypeBinding.field_182;
                            case 29:
                                return TypeBinding.field_179;
                            case 30:
                                return TypeBinding.field_183;
                            case 31:
                                return TypeBinding.field_184;
                            case 32:
                                return TypeBinding.field_185;
                            case 33:
                                return TypeBinding.field_186;
                        }
                    default:
                        return var1;
                }
            case 7:
                var2 = this.method_508(field_113);
                if (var2 != null) {
                    return var2;
                }
                var10000 = new ProblemReferenceBinding(field_113, (ReferenceBinding)null, 1);
                return var10000;
            case 8:
                var2 = this.method_508(field_115);
                if (var2 != null) {
                    return var2;
                }
                var10000 = new ProblemReferenceBinding(field_115, (ReferenceBinding)null, 1);
                return var10000;
            case 9:
                var2 = this.method_508(field_114);
                if (var2 != null) {
                    return var2;
                }
                var10000 = new ProblemReferenceBinding(field_114, (ReferenceBinding)null, 1);
                return var10000;
            case 10:
                var2 = this.method_508(field_112);
                if (var2 != null) {
                    return var2;
                }
                var10000 = new ProblemReferenceBinding(field_112, (ReferenceBinding)null, 1);
                return var10000;
            case 26:
                return TypeBinding.field_180;
            case 27:
                return TypeBinding.field_181;
            case 28:
                return TypeBinding.field_182;
            case 29:
                return TypeBinding.field_179;
            case 30:
                return TypeBinding.field_183;
            case 31:
                return TypeBinding.field_184;
            case 32:
                return TypeBinding.field_185;
            case 33:
                return TypeBinding.field_186;
        }
    }

    private PackageBinding computePackageFrom(char[][] var1, boolean var2) {
        if (var1.length == 1) {
            return this.defaultPackage;
        } else {
            PackageBinding var3 = this.method_505(var1[0]);
            PackageBinding var10000;
            if (var3 == null || var3 == TheNotFoundPackage) {
                var10000 = new PackageBinding(var1[0], this);
                var3 = var10000;
                if (var2) {
                    var3.tagBits |= 128L;
                }
                this.knownPackages.put(var1[0], var3);
            }
            int var4 = 1;
            for (int var5 = var1.length - 1; var4 < var5; ++var4) {
                PackageBinding var6 = var3;
                if ((var3 = var3.method_122(var1[var4])) == null || var3 == TheNotFoundPackage) {
                    var10000 = new PackageBinding(CharOperation.subarray(var1, 0, var4 + 1), var6, this);
                    var3 = var10000;
                    if (var2) {
                        var3.tagBits |= 128L;
                    }
                    var6.addPackage(var3);
                }
            }
            return var3;
        }
    }

    public TypeBinding method_488(TypeBinding var1, ReferenceBinding var2, int var3, Vector var4) {
        if ((var1.tagBits & 536870912L) != 0L) {
            ReferenceBinding var9;
            ReferenceBinding var10;
            TypeBinding var15;
            TypeBinding var19;
            TypeBinding var18;
            switch (var1.kind()) {
                case 68:
                    ArrayBinding var5 = (ArrayBinding)var1;
                    TypeBinding var6 = var5.leafComponentType;
                    TypeBinding var7 = this.method_488(var6, var2, var3, var4);
                    if (var7 != var6) {
                        return this.createArrayType(var7.method_173(), var7.method_136() + var5.method_136());
                    }
                    break;
                case 260:
                    ParameterizedTypeBinding var8 = (ParameterizedTypeBinding)var1;
                    var9 = var8.enclosingType();
                    var10 = var9;
                    if (var9 != null) {
                        var10 = (ReferenceBinding)this.method_488(var9, var2, var3, var4);
                    }
                    TypeBinding[] var27 = var8.arguments;
                    TypeBinding[] var28 = var27;
                    int var29 = 0;
                    for (int var30 = var27 == null ? 0 : var27.length; var29 < var30; ++var29) {
                        var15 = var27[var29];
                        TypeBinding var31 = this.method_488(var15, var8.method_286(), var29, var4);
                        if (var31 != var15) {
                            if (var28 == var27) {
                                System.arraycopy(var27, 0, var28 = new TypeBinding[var30], 0, var29);
                            }
                            var28[var29] = var31;
                        } else if (var28 != var27) {
                            var28[var29] = var15;
                        }
                    }
                    if (var9 != var10 || var27 != var28) {
                        return this.createParameterizedType(var8.method_286(), var28, var10);
                    }
                    break;
                case 516:
                    WildcardBinding var32 = (WildcardBinding)var1;
                    var18 = var32.bound;
                    if (var18 != null) {
                        var19 = this.method_488(var18, var2, var3, var4);
                        if (var19 != var18) {
                            return this.createWildcard(var32.field_210, var32.field_211, var19, (TypeBinding[])null, var32.field_215);
                        }
                    }
                case 1028:
                default:
                    break;
                case 2052:
                    ReferenceBinding var16 = (ReferenceBinding)var1;
                    var9 = var16.enclosingType();
                    var10 = var9;
                    if (var9 != null) {
                        var10 = (ReferenceBinding)this.method_488(var9, var2, var3, var4);
                    }
                    TypeVariableBinding[] var11 = var16.typeVariables();
                    Object var12 = var11;
                    int var17 = 0;
                    for (int var33 = var11 == null ? 0 : var11.length; var17 < var33; ++var17) {
                        TypeVariableBinding var35 = var11[var17];
                        TypeBinding var34 = this.method_488(var35, var16, var17, var4);
                        if (var34 != var35) {
                            if (var12 == var11) {
                                System.arraycopy(var11, 0, var12 = new TypeBinding[var33], 0, var17);
                            }
                            ((Object[])var12)[var17] = var34;
                        } else if (var12 != var11) {
                            ((Object[])var12)[var17] = var35;
                        }
                    }
                    if (var9 != var10 || var11 != var12) {
                        return this.createParameterizedType(var2, (TypeBinding[])var12, var10);
                    }
                    break;
                case 4100:
                    if (var4 != null && var4.contains(var1)) {
                        return this.createWildcard(var2, var3, (TypeBinding)null, (TypeBinding[])null, 0);
                    }
                    TypeVariableBinding var13 = (TypeVariableBinding)var1;
                    TypeBinding var14 = var13.method_261();
                    if (var4 == null) {
                        var4 = new Vector(2);
                    }
                    var4.addElement(var13);
                    var15 = this.method_488(var14, var2, var3, var4);
                    var4.removeElement(var13);
                    return this.createWildcard(var2, var3, var15, (TypeBinding[])null, 1);
                case 8196:
                    WildcardBinding var20 = (WildcardBinding)var1;
                    var18 = var20.bound;
                    var19 = var18;
                    if (var18 != null) {
                        var19 = this.method_488(var18, var2, var3, var4);
                    }
                    TypeBinding[] var21 = var20.otherBounds;
                    TypeBinding[] var22 = var21;
                    int var23 = 0;
                    for (int var24 = var21 == null ? 0 : var21.length; var23 < var24; ++var23) {
                        TypeBinding var25 = var21[var23];
                        TypeBinding var26 = this.method_488(var25, var2, var3, var4);
                        if (var26 != var25) {
                            if (var22 == var21) {
                                System.arraycopy(var21, 0, var22 = new TypeBinding[var24], 0, var23);
                            }
                            var22[var23] = var26;
                        } else if (var22 != var21) {
                            var22[var23] = var25;
                        }
                    }
                    if (var19 != var18 || var22 != var21) {
                        return this.createWildcard(var20.field_210, var20.field_211, var19, var22, var20.field_215);
                    }
            }
        }
        return var1;
    }

    public ReferenceBinding convertToParameterizedType(ReferenceBinding var1) {
        if (var1 != null) {
            boolean var2 = var1.method_155();
            ReferenceBinding var3 = var1.enclosingType();
            ReferenceBinding var4 = var3;
            boolean var5 = var2;
            if (var3 != null) {
                var4 = var1.method_226() ? (ReferenceBinding)this.convertToRawType(var3, false) : this.convertToParameterizedType(var3);
                var5 = var2 | var3 != var4;
            }
            if (var5) {
                return this.createParameterizedType(var1, var2 ? var1.typeVariables() : null, var4);
            }
        }
        return var1;
    }

    public TypeBinding convertToRawType(TypeBinding var1, boolean var2) {
        int var3;
        TypeBinding var4;
        switch (var1.kind()) {
            case 68:
                var3 = var1.method_136();
                var4 = var1.method_173();
                break;
            case 132:
            case 516:
            case 1028:
            case 4100:
            case 8196:
                return var1;
            default:
                if (var1.id == 1) {
                    return var1;
                }
                var3 = 0;
                var4 = var1;
        }
        boolean var5;
        switch (var4.kind()) {
            case 132:
                return var1;
            case 260:
                ParameterizedTypeBinding var6 = (ParameterizedTypeBinding)var4;
                var5 = var6.method_286().method_155();
                break;
            case 2052:
                var5 = true;
                break;
            default:
                var5 = false;
        }
        ReferenceBinding var9 = var4.enclosingType();
        Object var7;
        if (var9 == null) {
            var7 = var5 ? this.createRawType((ReferenceBinding)var4.erasure(), (ReferenceBinding)null) : var4;
        } else {
            ReferenceBinding var8;
            if (var9.kind() == 1028) {
                var5 |= !((ReferenceBinding)var4).method_226();
                var8 = var9;
            } else if (var2 && !var5) {
                var8 = (ReferenceBinding)this.convertToRawType(var9, var2);
                var5 = var9 != var8;
            } else if (!var5 && !((ReferenceBinding)var4).method_226()) {
                var8 = this.convertToParameterizedType(var9);
            } else {
                var8 = (ReferenceBinding)this.convertToRawType(var9, false);
            }
            if (var5) {
                var7 = this.createRawType((ReferenceBinding)var4.erasure(), var8);
            } else if (var9 != var8) {
                var7 = this.createParameterizedType((ReferenceBinding)var4.erasure(), (TypeBinding[])null, var8);
            } else {
                var7 = var4;
            }
        }
        return (TypeBinding)(var4 != var7 ? (var3 > 0 ? this.createArrayType((TypeBinding)var7, var3) : var7) : var1);
    }

    public TypeBinding method_491(TypeBinding var1) {
        int var2;
        TypeBinding var3;
        switch (var1.kind()) {
            case 68:
                var2 = var1.method_136();
                var3 = var1.method_173();
                break;
            case 132:
            case 516:
            case 1028:
            case 4100:
            case 8196:
                return var1;
            default:
                if (var1.id == 1) {
                    return var1;
                }
                var2 = 0;
                var3 = var1;
        }
        boolean var4;
        switch (var3.kind()) {
            case 132:
                return var1;
            case 260:
                ParameterizedTypeBinding var5 = (ParameterizedTypeBinding)var3;
                var4 = var5.method_286().method_155();
                break;
            case 2052:
                var4 = true;
                break;
            default:
                var4 = false;
        }
        ReferenceBinding var8 = var3.enclosingType();
        Object var6;
        if (var8 == null) {
            var6 = var4 ? this.createRawType((ReferenceBinding)var3.erasure(), (ReferenceBinding)null) : var3;
        } else {
            ReferenceBinding var7 = (ReferenceBinding)this.method_491(var8);
            if (var7 != var8) {
                var4 |= !((ReferenceBinding)var3).method_226();
            }
            if (var4) {
                var6 = this.createRawType((ReferenceBinding)var3.erasure(), var7);
            } else if (var8 != var7) {
                var6 = this.createParameterizedType((ReferenceBinding)var3.erasure(), (TypeBinding[])null, var7);
            } else {
                var6 = var3;
            }
        }
        return (TypeBinding)(var3 != var6 ? (var2 > 0 ? this.createArrayType((TypeBinding)var6, var2) : var6) : var1);
    }

    public AnnotationBinding createAnnotation(ReferenceBinding var1, ElementValuePair[] var2) {
        if (var2.length != 0) {
            AnnotationBinding.setMethodBindings(var1, var2);
        }
        AnnotationBinding var10000 = new AnnotationBinding(var1, var2);
        return var10000;
    }

    public ArrayBinding createArrayType(TypeBinding var1, int var2) {
        if (var1 instanceof LocalTypeBinding) {
            return ((LocalTypeBinding)var1).createArrayType(var2, this);
        } else {
            int var3 = var2 - 1;
            int var4 = this.uniqueArrayBindings.length;
            ArrayBinding[] var5;
            if (var3 < var4) {
                if ((var5 = this.uniqueArrayBindings[var3]) == null) {
                    this.uniqueArrayBindings[var3] = var5 = new ArrayBinding[10];
                }
            } else {
                System.arraycopy(this.uniqueArrayBindings, 0, this.uniqueArrayBindings = new ArrayBinding[var2][], 0, var4);
                this.uniqueArrayBindings[var3] = var5 = new ArrayBinding[10];
            }
            int var6 = -1;
            var4 = var5.length;
            ArrayBinding var7;
            do {
                ++var6;
                ArrayBinding var10002;
                if (var6 >= var4) {
                    System.arraycopy(var5, 0, var5 = new ArrayBinding[var4 * 2], 0, var4);
                    this.uniqueArrayBindings[var3] = var5;
                    var10002 = new ArrayBinding(var1, var2, this);
                    return var5[var4] = var10002;
                }
                var7 = var5[var6];
                if (var7 == null) {
                    var10002 = new ArrayBinding(var1, var2, this);
                    return var5[var6] = var10002;
                }
            } while (var7.leafComponentType != var1);
            return var7;
        }
    }

    public BinaryTypeBinding createBinaryTypeFrom(IBinaryType var1, PackageBinding var2, AccessRestriction var3) {
        return this.createBinaryTypeFrom(var1, var2, true, var3);
    }

    public BinaryTypeBinding createBinaryTypeFrom(IBinaryType var1, PackageBinding var2, boolean var3, AccessRestriction var4) {
        BinaryTypeBinding var10000 = new BinaryTypeBinding(var2, var1, this);
        BinaryTypeBinding var5 = var10000;
        ReferenceBinding var6 = var2.method_124(var5.compoundName[var5.compoundName.length - 1]);
        if (var6 != null) {
            if (!(var6 instanceof UnresolvedReferenceBinding)) {
                if (var6.method_218()) {
                    return (BinaryTypeBinding)var6;
                }
                return null;
            }
            ((UnresolvedReferenceBinding)var6).setResolvedType(var5, this);
        }
        var2.addType(var5);
        this.setAccessRestriction(var5, var4);
        var5.method_270(var1, var3);
        return var5;
    }

    public MissingTypeBinding createMissingType(PackageBinding var1, char[][] var2) {
        if (var1 == null) {
            var1 = this.computePackageFrom(var2, true);
            if (var1 == TheNotFoundPackage) {
                var1 = this.defaultPackage;
            }
        }
        MissingTypeBinding var10000 = new MissingTypeBinding(var1, var2, this);
        MissingTypeBinding var3 = var10000;
        if (var3.id != 1) {
            Object var4 = this.method_508(TypeConstants.field_99);
            if (var4 == null) {
                var4 = this.createMissingType((PackageBinding)null, TypeConstants.field_99);
            }
            var3.setMissingSuperclass((ReferenceBinding)var4);
        }
        var1.addType(var3);
        return var3;
    }

    public PackageBinding createPackage(char[][] var1) {
        PackageBinding var2 = this.method_505(var1[0]);
        PackageBinding var10000;
        if (var2 == null || var2 == TheNotFoundPackage) {
            var10000 = new PackageBinding(var1[0], this);
            var2 = var10000;
            this.knownPackages.put(var1[0], var2);
        }
        int var3 = 1;
        for (int var4 = var1.length; var3 < var4; ++var3) {
            ReferenceBinding var5 = var2.method_124(var1[var3]);
            if (var5 != null && var5 != TheNotFoundType && !(var5 instanceof UnresolvedReferenceBinding)) {
                return null;
            }
            PackageBinding var6 = var2;
            if ((var2 = var2.method_122(var1[var3])) == null || var2 == TheNotFoundPackage) {
                if (this.nameEnvironment.findType(var1[var3], var6.compoundName) != null) {
                    return null;
                }
                var10000 = new PackageBinding(CharOperation.subarray(var1, 0, var3 + 1), var6, this);
                var2 = var10000;
                var6.addPackage(var2);
            }
        }
        return var2;
    }

    public ParameterizedGenericMethodBinding createParameterizedGenericMethod(MethodBinding var1, RawTypeBinding var2) {
        ParameterizedGenericMethodBinding[] var3 = (ParameterizedGenericMethodBinding[])((ParameterizedGenericMethodBinding[])this.field_361.method_3241(var1));
        boolean var4 = false;
        int var5 = 0;
        int var6;
        ParameterizedGenericMethodBinding var7;
        if (var3 != null) {
            for (var6 = var3.length; var5 < var6; ++var5) {
                var7 = var3[var5];
                if (var7 == null) {
                    break;
                }
                if (var7.field_297 && var7.declaringClass == (var2 == null ? var1.declaringClass : var2)) {
                    return var7;
                }
            }
            var4 = true;
        } else {
            var3 = new ParameterizedGenericMethodBinding[5];
            this.field_361.put(var1, var3);
        }
        var6 = var3.length;
        if (var4 && var5 == var6) {
            System.arraycopy(var3, 0, var3 = new ParameterizedGenericMethodBinding[var6 * 2], 0, var6);
            this.field_361.put(var1, var3);
        }
        ParameterizedGenericMethodBinding var10000 = new ParameterizedGenericMethodBinding(var1, var2, this);
        var7 = var10000;
        var3[var5] = var7;
        return var7;
    }

    public ParameterizedGenericMethodBinding createParameterizedGenericMethod(MethodBinding var1, TypeBinding[] var2) {
        ParameterizedGenericMethodBinding[] var3 = (ParameterizedGenericMethodBinding[])((ParameterizedGenericMethodBinding[])this.field_361.method_3241(var1));
        int var4 = var2 == null ? 0 : var2.length;
        boolean var5 = false;
        int var6 = 0;
        int var7;
        ParameterizedGenericMethodBinding var8;
        if (var3 != null) {
            label53:
            for (var7 = var3.length; var6 < var7; ++var6) {
                var8 = var3[var6];
                if (var8 == null) {
                    break;
                }
                if (!var8.field_297) {
                    TypeBinding[] var9 = var8.typeArguments;
                    int var10 = var9 == null ? 0 : var9.length;
                    if (var4 == var10) {
                        for (int var11 = 0; var11 < var10; ++var11) {
                            if (var2[var11] != var9[var11]) {
                                continue label53;
                            }
                        }
                        return var8;
                    }
                }
            }
            var5 = true;
        } else {
            var3 = new ParameterizedGenericMethodBinding[5];
            this.field_361.put(var1, var3);
        }
        var7 = var3.length;
        if (var5 && var6 == var7) {
            System.arraycopy(var3, 0, var3 = new ParameterizedGenericMethodBinding[var7 * 2], 0, var7);
            this.field_361.put(var1, var3);
        }
        ParameterizedGenericMethodBinding var10000 = new ParameterizedGenericMethodBinding(var1, var2, this);
        var8 = var10000;
        var3[var6] = var8;
        return var8;
    }

    public ParameterizedTypeBinding createParameterizedType(ReferenceBinding var1, TypeBinding[] var2, ReferenceBinding var3) {
        ParameterizedTypeBinding[] var4 = (ParameterizedTypeBinding[])((ParameterizedTypeBinding[])this.field_358.method_3241(var1));
        int var5 = var2 == null ? 0 : var2.length;
        boolean var6 = false;
        int var7 = 0;
        int var8;
        ParameterizedTypeBinding var9;
        if (var4 != null) {
            label56:
            for (var8 = var4.length; var7 < var8; ++var7) {
                var9 = var4[var7];
                if (var9 == null) {
                    break;
                }
                if (var9.actualType() == var1 && var9.enclosingType() == var3) {
                    TypeBinding[] var10 = var9.arguments;
                    int var11 = var10 == null ? 0 : var10.length;
                    if (var5 == var11) {
                        for (int var12 = 0; var12 < var11; ++var12) {
                            if (var2[var12] != var10[var12]) {
                                continue label56;
                            }
                        }
                        return var9;
                    }
                }
            }
            var6 = true;
        } else {
            var4 = new ParameterizedTypeBinding[5];
            this.field_358.put(var1, var4);
        }
        var8 = var4.length;
        if (var6 && var7 == var8) {
            System.arraycopy(var4, 0, var4 = new ParameterizedTypeBinding[var8 * 2], 0, var8);
            this.field_358.put(var1, var4);
        }
        ParameterizedTypeBinding var10000 = new ParameterizedTypeBinding(var1, var2, var3, this);
        var9 = var10000;
        var4[var7] = var9;
        return var9;
    }

    public RawTypeBinding createRawType(ReferenceBinding var1, ReferenceBinding var2) {
        RawTypeBinding[] var3 = (RawTypeBinding[])((RawTypeBinding[])this.field_359.method_3241(var1));
        boolean var4 = false;
        int var5 = 0;
        int var6;
        RawTypeBinding var7;
        if (var3 != null) {
            for (var6 = var3.length; var5 < var6; ++var5) {
                var7 = var3[var5];
                if (var7 == null) {
                    break;
                }
                if (var7.actualType() == var1 && var7.enclosingType() == var2) {
                    return var7;
                }
            }
            var4 = true;
        } else {
            var3 = new RawTypeBinding[1];
            this.field_359.put(var1, var3);
        }
        var6 = var3.length;
        if (var4 && var5 == var6) {
            System.arraycopy(var3, 0, var3 = new RawTypeBinding[var6 * 2], 0, var6);
            this.field_359.put(var1, var3);
        }
        RawTypeBinding var10000 = new RawTypeBinding(var1, var2, this);
        var7 = var10000;
        var3[var5] = var7;
        return var7;
    }

    public WildcardBinding createWildcard(ReferenceBinding var1, int var2, TypeBinding var3, TypeBinding[] var4, int var5) {
        if (var1 == null) {
            var1 = ReferenceBinding.field_205;
        }
        WildcardBinding[] var6 = (WildcardBinding[])((WildcardBinding[])this.field_360.method_3241(var1));
        boolean var7 = false;
        int var8 = 0;
        int var9;
        WildcardBinding var10;
        if (var6 != null) {
            label73:
            for (var9 = var6.length; var8 < var9; ++var8) {
                var10 = var6[var8];
                if (var10 == null) {
                    break;
                }
                if (var10.field_210 == var1 && var10.field_211 == var2 && var10.field_215 == var5 && var10.bound == var3) {
                    if (var10.otherBounds != var4) {
                        int var11 = var10.otherBounds == null ? 0 : var10.otherBounds.length;
                        int var12 = var4 == null ? 0 : var4.length;
                        if (var11 != var12) {
                            continue;
                        }
                        for (int var13 = 0; var13 < var12; ++var13) {
                            if (var10.otherBounds[var13] != var4[var13]) {
                                continue label73;
                            }
                        }
                    }
                    return var10;
                }
            }
            var7 = true;
        } else {
            var6 = new WildcardBinding[10];
            this.field_360.put(var1, var6);
        }
        var9 = var6.length;
        if (var7 && var8 == var9) {
            System.arraycopy(var6, 0, var6 = new WildcardBinding[var9 * 2], 0, var9);
            this.field_360.put(var1, var6);
        }
        WildcardBinding var10000 = new WildcardBinding(var1, var2, var3, var4, var5, this);
        var10 = var10000;
        var6[var8] = var10;
        return var10;
    }

    public AccessRestriction getAccessRestriction(TypeBinding var1) {
        return (AccessRestriction)this.field_345.get(var1);
    }

    public ReferenceBinding method_504(char[][] var1) {
        if (var1.length == 1) {
            return this.defaultPackage == null ? null : this.defaultPackage.method_124(var1[0]);
        } else {
            PackageBinding var2 = this.method_505(var1[0]);
            if (var2 != null && var2 != TheNotFoundPackage) {
                int var3 = 1;
                for (int var4 = var1.length - 1; var3 < var4; ++var3) {
                    if ((var2 = var2.method_122(var1[var3])) == null || var2 == TheNotFoundPackage) {
                        return null;
                    }
                }
                return var2.method_124(var1[var1.length - 1]);
            } else {
                return null;
            }
        }
    }

    PackageBinding method_505(char[] var1) {
        return this.knownPackages.get(var1);
    }

    public ReferenceBinding getResolvedType(char[][] var1, Scope var2) {
        ReferenceBinding var3 = this.method_508(var1);
        if (var3 != null) {
            return var3;
        } else {
            this.problemReporter.isClassPathCorrect(var1, var2 == null ? this.unitBeingCompleted : var2.referenceCompilationUnit(), this.missingClassFileLocation);
            return this.createMissingType((PackageBinding)null, var1);
        }
    }

    PackageBinding method_507(char[] var1) {
        PackageBinding var2 = this.method_505(var1);
        if (var2 != null) {
            return var2 == TheNotFoundPackage ? null : var2;
        } else if (this.nameEnvironment.isPackage((char[][])null, var1)) {
            HashtableOfPackage var10000 = this.knownPackages;
            PackageBinding var10002 = new PackageBinding(var1, this);
            var2 = var10002;
            var10000.put(var1, var10002);
            return var2;
        } else {
            this.knownPackages.put(var1, TheNotFoundPackage);
            return null;
        }
    }

    public ReferenceBinding method_508(char[][] var1) {
        ReferenceBinding var2;
        PackageBinding var3;
        if (var1.length == 1) {
            if (this.defaultPackage == null) {
                return null;
            }
            if ((var2 = this.defaultPackage.method_124(var1[0])) == null) {
                var3 = this.method_505(var1[0]);
                if (var3 != null && var3 != TheNotFoundPackage) {
                    return null;
                }
                var2 = this.askForType(this.defaultPackage, var1[0]);
            }
        } else {
            var3 = this.method_505(var1[0]);
            if (var3 == TheNotFoundPackage) {
                return null;
            }
            if (var3 != null) {
                int var4 = 1;
                for (int var5 = var1.length - 1; var4 < var5 && (var3 = var3.method_122(var1[var4])) != null; ++var4) {
                    if (var3 == TheNotFoundPackage) {
                        return null;
                    }
                }
            }
            if (var3 == null) {
                var2 = this.method_481(var1);
            } else if ((var2 = var3.method_124(var1[var1.length - 1])) == null) {
                var2 = this.askForType(var3, var1[var1.length - 1]);
            }
        }
        if (var2 != null && var2 != TheNotFoundType) {
            var2 = BinaryTypeBinding.method_267(var2, this, false);
            if (var2.method_160()) {
                ProblemReferenceBinding var10000 = new ProblemReferenceBinding(var1, var2, 4);
                return var10000;
            } else {
                return var2;
            }
        } else {
            return null;
        }
    }

    private TypeBinding[] getTypeArgumentsFromSignature(SignatureWrapper var1, TypeVariableBinding[] var2, ReferenceBinding var3, ReferenceBinding var4, char[][][] var5) {
        ArrayList var10000 = new ArrayList(2);
        ArrayList var6 = var10000;
        int var7 = 0;
        do {
            var6.add(this.getTypeFromVariantTypeSignature(var1, var2, var3, var4, var7++, var5));
        } while (var1.signature[var1.field_873] != 62);
        ++var1.field_873;
        TypeBinding[] var8 = new TypeBinding[var6.size()];
        var6.toArray(var8);
        return var8;
    }

    private ReferenceBinding getTypeFromCompoundName(char[][] var1, boolean var2, boolean var3) {
        Object var4 = this.method_504(var1);
        if (var4 == null) {
            PackageBinding var5 = this.computePackageFrom(var1, false);
            UnresolvedReferenceBinding var10000 = new UnresolvedReferenceBinding(var1, var5);
            var4 = var10000;
            if (var3) {
                ((ReferenceBinding)var4).tagBits |= 128L;
            }
            var5.addType((ReferenceBinding)var4);
        } else if (var4 == TheNotFoundType) {
            this.problemReporter.isClassPathCorrect(var1, this.unitBeingCompleted, this.missingClassFileLocation);
            var4 = this.createMissingType((PackageBinding)null, var1);
        } else if (!var2) {
            var4 = (ReferenceBinding)this.method_491((TypeBinding)var4);
        }
        return (ReferenceBinding)var4;
    }

    ReferenceBinding getTypeFromConstantPoolName(char[] var1, int var2, int var3, boolean var4, char[][][] var5) {
        if (var3 == -1) {
            var3 = var1.length;
        }
        char[][] var6 = CharOperation.splitOn('/', var1, var2, var3);
        boolean var7 = false;
        if (var5 != null) {
            int var8 = 0;
            for (int var9 = var5.length; var8 < var9; ++var8) {
                if (CharOperation.equals(var6, var5[var8])) {
                    var7 = true;
                    break;
                }
            }
        }
        return this.getTypeFromCompoundName(var6, var4, var7);
    }

    TypeBinding getTypeFromSignature(char[] var1, int var2, int var3, boolean var4, TypeBinding var5, char[][][] var6) {
        int var7;
        for (var7 = 0; var1[var2] == 91; ++var7) {
            ++var2;
        }
        if (var3 == -1) {
            var3 = var1.length - 1;
        }
        Object var8 = null;
        if (var2 == var3) {
            switch (var1[var2]) {
                case 66:
                    var8 = TypeBinding.field_180;
                    break;
                case 67:
                    var8 = TypeBinding.field_182;
                    break;
                case 68:
                    var8 = TypeBinding.field_185;
                    break;
                case 69:
                case 71:
                case 72:
                case 75:
                case 76:
                case 77:
                case 78:
                case 79:
                case 80:
                case 81:
                case 82:
                case 84:
                case 85:
                case 87:
                case 88:
                case 89:
                default:
                    this.problemReporter.corruptedSignature(var5, var1, var2);
                    break;
                case 70:
                    var8 = TypeBinding.field_184;
                    break;
                case 73:
                    var8 = TypeBinding.field_179;
                    break;
                case 74:
                    var8 = TypeBinding.field_183;
                    break;
                case 83:
                    var8 = TypeBinding.field_181;
                    break;
                case 86:
                    var8 = TypeBinding.field_188;
                    break;
                case 90:
                    var8 = TypeBinding.field_186;
            }
        } else {
            var8 = this.getTypeFromConstantPoolName(var1, var2 + 1, var3, var4, var6);
        }
        return (TypeBinding)(var7 == 0 ? var8 : this.createArrayType((TypeBinding)var8, var7));
    }

    public TypeBinding getTypeFromTypeSignature(SignatureWrapper var1, TypeVariableBinding[] var2, ReferenceBinding var3, char[][][] var4) {
        int var5;
        for (var5 = 0; var1.signature[var1.field_873] == 91; ++var5) {
            ++var1.field_873;
        }
        ReferenceBinding var16;
        if (var1.signature[var1.field_873] != 84) {
            boolean var14;
            TypeBinding var15 = this.getTypeFromSignature(var1.signature, var1.field_873, var1.computeEnd(), var14 = var1.field_874 == var1.field_875, var3, var4);
            if (!var14) {
                return (TypeBinding)(var5 == 0 ? var15 : this.createArrayType(var15, var5));
            } else {
                var16 = (ReferenceBinding)var15;
                if (var16 instanceof UnresolvedReferenceBinding && CharOperation.method_1371('$', var16.compoundName[var16.compoundName.length - 1]) > 0) {
                    var16 = BinaryTypeBinding.method_267(var16, this, false);
                }
                ReferenceBinding var17 = var16.enclosingType();
                if (var17 != null) {
                    var17 = (ReferenceBinding)this.convertToRawType(var17, false);
                }
                TypeBinding[] var18 = this.getTypeArgumentsFromSignature(var1, var2, var3, var16, var4);
                ParameterizedTypeBinding var11;
                ReferenceBinding var13;
                for (var11 = this.createParameterizedType(var16, var18, var17); var1.signature[var1.field_873] == 46; var11 = this.createParameterizedType(var13, var18, var11)) {
                    ++var1.field_873;
                    char[] var12 = var1.nextWord();
                    BinaryTypeBinding.method_267(var11, this, false);
                    var13 = var11.method_286().getMemberType(var12);
                    if (var1.signature[var1.field_873] == 60) {
                        ++var1.field_873;
                        var18 = this.getTypeArgumentsFromSignature(var1, var2, var3, var13, var4);
                    } else {
                        var18 = null;
                    }
                }
                ++var1.field_873;
                if (var5 == 0) {
                    return var11;
                }
                return this.createArrayType(var11, var5);
            }
        } else {
            int var6 = var1.field_873 + 1;
            int var7 = var1.computeEnd();
            int var8 = var2.length;
            do {
                --var8;
                if (var8 < 0) {
                    var16 = var3;
                    label86:
                    while (true) {
                        TypeVariableBinding[] var9;
                        if (var3 instanceof BinaryTypeBinding) {
                            var9 = ((BinaryTypeBinding)var3).typeVariables;
                        } else {
                            var9 = var3.typeVariables();
                        }
                        int var10 = var9.length;
                        do {
                            --var10;
                            if (var10 < 0) {
                                if ((var3 = var3.enclosingType()) == null) {
                                    this.problemReporter.undefinedTypeVariableSignature(CharOperation.subarray(var1.signature, var6, var7), var16);
                                    return null;
                                }
                                continue label86;
                            }
                        } while (!CharOperation.equals(var9[var10].sourceName, var1.signature, var6, var7));
                        if (var5 == 0) {
                            return var9[var10];
                        }
                        return this.createArrayType(var9[var10], var5);
                    }
                }
            } while (!CharOperation.equals(var2[var8].sourceName, var1.signature, var6, var7));
            if (var5 == 0) {
                return var2[var8];
            }
            return this.createArrayType(var2[var8], var5);
        }
    }

    TypeBinding getTypeFromVariantTypeSignature(SignatureWrapper var1, TypeVariableBinding[] var2, ReferenceBinding var3, ReferenceBinding var4, int var5, char[][][] var6) {
        TypeBinding var7;
        switch (var1.signature[var1.field_873]) {
            case 42:
                ++var1.field_873;
                return this.createWildcard(var4, var5, (TypeBinding)null, (TypeBinding[])null, 0);
            case 43:
                ++var1.field_873;
                var7 = this.getTypeFromTypeSignature(var1, var2, var3, var6);
                return this.createWildcard(var4, var5, var7, (TypeBinding[])null, 1);
            case 44:
            default:
                return this.getTypeFromTypeSignature(var1, var2, var3, var6);
            case 45:
                ++var1.field_873;
                var7 = this.getTypeFromTypeSignature(var1, var2, var3, var6);
                return this.createWildcard(var4, var5, var7, (TypeBinding[])null, 2);
        }
    }

    boolean isPackage(char[][] var1, char[] var2) {
        return var1 != null && var1.length != 0 ? this.nameEnvironment.isPackage(var1, var2) : this.nameEnvironment.isPackage((char[][])null, var2);
    }

    public MethodVerifier methodVerifier() {
        if (this.verifier == null) {
            Object var10001;
            if (this.globalOptions.field_1928 < 3211264L) {
                var10001 = new MethodVerifier(this);
            } else {
                var10001 = new MethodVerifier15(this);
            }
            this.verifier = (MethodVerifier)var10001;
        }
        return this.verifier;
    }

    public void releaseClassFiles(ClassFile[] var1) {
        int var2 = 0;
        for (int var3 = var1.length; var2 < var3; ++var2) {
            this.classFilePool.release(var1[var2]);
        }
    }

    public void method_518() {
        PackageBinding var10001 = new PackageBinding(this);
        this.defaultPackage = var10001;
        this.defaultImports = null;
        HashtableOfPackage var6 = new HashtableOfPackage();
        this.knownPackages = var6;
        HashMap var4 = new HashMap(3);
        this.field_345 = var4;
        this.verifier = null;
        int var1 = this.uniqueArrayBindings.length;
        while (true) {
            --var1;
            if (var1 < 0) {
                SimpleLookupTable var5 = new SimpleLookupTable(3);
                this.field_358 = var5;
                var5 = new SimpleLookupTable(3);
                this.field_359 = var5;
                var5 = new SimpleLookupTable(3);
                this.field_360 = var5;
                var5 = new SimpleLookupTable(3);
                this.field_361 = var5;
                var1 = this.units.length;
                while (true) {
                    --var1;
                    if (var1 < 0) {
                        this.field_350 = -1;
                        this.field_349 = -1;
                        this.unitBeingCompleted = null;
                        this.classFilePool.reset();
                        return;
                    }
                    this.units[var1] = null;
                }
            }
            ArrayBinding[] var2 = this.uniqueArrayBindings[var1];
            if (var2 != null) {
                int var3 = var2.length;
                while (true) {
                    --var3;
                    if (var3 < 0) {
                        break;
                    }
                    var2[var3] = null;
                }
            }
        }
    }

    public void setAccessRestriction(ReferenceBinding var1, AccessRestriction var2) {
        if (var2 != null) {
            var1.modifiers |= 262144;
            this.field_345.put(var1, var2);
        }
    }

    void updateCaches(UnresolvedReferenceBinding var1, ReferenceBinding var2) {
        Object[] var3;
        int var4;
        int var5;
        if (this.field_358.method_3241(var1) != null) {
            var3 = this.field_358.field_1852;
            var4 = 0;
            for (var5 = var3.length; var4 < var5; ++var4) {
                if (var3[var4] == var1) {
                    var3[var4] = var2;
                    break;
                }
            }
        }
        if (this.field_359.method_3241(var1) != null) {
            var3 = this.field_359.field_1852;
            var4 = 0;
            for (var5 = var3.length; var4 < var5; ++var4) {
                if (var3[var4] == var1) {
                    var3[var4] = var2;
                    break;
                }
            }
        }
        if (this.field_360.method_3241(var1) != null) {
            var3 = this.field_360.field_1852;
            var4 = 0;
            for (var5 = var3.length; var4 < var5; ++var4) {
                if (var3[var4] == var1) {
                    var3[var4] = var2;
                    break;
                }
            }
        }
    }

    static {
        ProblemPackageBinding var10000 = new ProblemPackageBinding(CharOperation.NO_CHAR, 1);
        TheNotFoundPackage = var10000;
        ProblemReferenceBinding var0 = new ProblemReferenceBinding(CharOperation.NO_CHAR_CHAR, (ReferenceBinding)null, 1);
        TheNotFoundType = var0;
    }
}
