package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ImportReference;
import org.eclipse.jdt.internal.compiler.env.AccessRestriction;
import org.eclipse.jdt.internal.compiler.lookup.InvocationSite;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.ImportBinding;
import org.eclipse.jdt.internal.compiler.lookup.ImportConflictBinding;
import org.eclipse.jdt.internal.compiler.lookup.PackageBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ArrayBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.UnresolvedReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.MissingTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ProblemReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.ProblemFieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;
import org.eclipse.jdt.internal.compiler.lookup.MethodVerifier;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.problem.ProblemReporter;
import org.eclipse.jdt.internal.compiler.util.CompoundNameVector;
import org.eclipse.jdt.internal.compiler.util.SimpleNameVector;
import org.eclipse.jdt.internal.compiler.util.HashtableOfObject;
import org.eclipse.jdt.internal.compiler.util.ObjectVector;
import org.eclipse.jdt.internal.compiler.util.HashtableOfType;

public class CompilationUnitScope extends Scope {

    public LookupEnvironment environment;

    public CompilationUnitDeclaration referenceContext;

    public char[][] currentPackageName;

    public PackageBinding fPackage;

    public ImportBinding[] imports;

    public HashtableOfObject typeOrPackageCache;

    public SourceTypeBinding[] topLevelTypes;

    private CompoundNameVector qualifiedReferences;

    private SimpleNameVector field_386;

    private ObjectVector field_387;

    private ObjectVector field_388;

    HashtableOfType constantPoolNameUsage;

    private int captureID;

    public CompilationUnitScope(CompilationUnitDeclaration var1, LookupEnvironment var2) {
        super(4, (Scope)null);
        this.captureID = 1;
        this.environment = var2;
        this.referenceContext = var1;
        var1.scope = this;
        this.currentPackageName = var1.currentPackage == null ? CharOperation.NO_CHAR_CHAR : var1.currentPackage.tokens;
        if (this.compilerOptions().field_1932) {
            CompoundNameVector var10001 = new CompoundNameVector();
            this.qualifiedReferences = var10001;
            SimpleNameVector var4 = new SimpleNameVector();
            this.field_386 = var4;
            ObjectVector var3 = new ObjectVector();
            this.field_387 = var3;
            var3 = new ObjectVector();
            this.field_388 = var3;
        } else {
            this.qualifiedReferences = null;
            this.field_386 = null;
            this.field_387 = null;
            this.field_388 = null;
        }
    }

    void method_673() {
        int var1 = 0;
        for (int var2 = this.topLevelTypes.length; var1 < var2; ++var1) {
            this.topLevelTypes[var1].scope.method_650();
        }
    }

    void buildTypeBindings(AccessRestriction var1) {
        this.topLevelTypes = new SourceTypeBinding[0];
        boolean var2 = false;
        if (this.referenceContext.compilationResult.compilationUnit != null) {
            char[][] var3 = this.referenceContext.compilationResult.compilationUnit.getPackageName();
            if (var3 != null && !CharOperation.equals(this.currentPackageName, var3)) {
                if (this.referenceContext.currentPackage != null || this.referenceContext.types != null || this.referenceContext.imports != null) {
                    this.problemReporter().method_1719(this.referenceContext);
                }
                this.currentPackageName = var3.length == 0 ? CharOperation.NO_CHAR_CHAR : var3;
            }
        }
        if (this.currentPackageName == CharOperation.NO_CHAR_CHAR) {
            if ((this.fPackage = this.environment.defaultPackage) == null) {
                this.problemReporter().method_1686(this.referenceContext);
                return;
            }
        } else {
            if ((this.fPackage = this.environment.createPackage(this.currentPackageName)) == null) {
                this.problemReporter().method_1718(this.referenceContext);
                return;
            }
            if (this.referenceContext.method_773() && (this.referenceContext.types == null || this.referenceContext.types.length == 0)) {
                this.referenceContext.types = new TypeDeclaration[1];
                TypeDeclaration var10000 = new TypeDeclaration(this.referenceContext.compilationResult);
                TypeDeclaration var11 = var10000;
                this.referenceContext.types[0] = var11;
                var11.name = TypeConstants.field_144;
                var11.field_577 = 512;
                var2 = true;
            }
            this.recordQualifiedReference(this.currentPackageName);
        }
        TypeDeclaration[] var12 = this.referenceContext.types;
        int var4 = var12 == null ? 0 : var12.length;
        this.topLevelTypes = new SourceTypeBinding[var4];
        int var5 = 0;
        for (int var6 = 0; var6 < var4; ++var6) {
            TypeDeclaration var7 = var12[var6];
            ReferenceBinding var8 = this.fPackage.method_124(var7.name);
            this.method_690(var7.name);
            if (var8 != null && var8.isValidBinding() && !(var8 instanceof UnresolvedReferenceBinding)) {
                this.problemReporter().method_1538(this.referenceContext, var7);
            } else {
                if (this.fPackage != this.environment.defaultPackage && this.fPackage.method_121(var7.name) != null) {
                    this.problemReporter().method_1773(this.referenceContext, var7);
                }
                char[] var9;
                if ((var7.field_577 & 1) != 0 && (var9 = this.referenceContext.method_772()) != null && !CharOperation.method_1364(var9, var7.name)) {
                    this.problemReporter().method_1740(this.referenceContext, var7);
                }
                ClassScope var13 = new ClassScope(this, var7);
                ClassScope var14 = var13;
                SourceTypeBinding var10 = var14.buildType((SourceTypeBinding)null, this.fPackage, var1);
                if (var2 && var6 == 0) {
                    var10.modifiers |= 4096;
                }
                if (var10 != null) {
                    this.topLevelTypes[var5++] = var10;
                }
            }
        }
        if (var5 != this.topLevelTypes.length) {
            System.arraycopy(this.topLevelTypes, 0, this.topLevelTypes = new SourceTypeBinding[var5], 0, var5);
        }
    }

    void method_675() {
        if (this.referenceContext.imports == null) {
            this.imports = this.getDefaultImports();
        } else {
            int var1 = this.referenceContext.imports.length;
            int var2 = var1 + 1;
            for (int var3 = 0; var3 < var1; ++var3) {
                ImportReference var4 = this.referenceContext.imports[var3];
                if ((var4.field_446 & 131072) != 0 && CharOperation.equals(TypeConstants.field_86, var4.tokens) && !var4.isStatic()) {
                    --var2;
                    break;
                }
            }
            ImportBinding[] var10 = new ImportBinding[var2];
            var10[0] = this.getDefaultImports()[0];
            int var11 = 1;
            int var5 = 0;
            while (var5 < var1) {
                ImportReference var6 = this.referenceContext.imports[var5];
                char[][] var7 = var6.tokens;
                int var8 = 0;
                while (true) {
                    if (var8 < var11) {
                        ImportBinding var9 = var10[var8];
                        if (var9.onDemand != ((var6.field_446 & 131072) != 0) || var9.isStatic() != var6.isStatic() || !CharOperation.equals(var7, var10[var8].compoundName)) {
                            ++var8;
                            continue;
                        }
                    } else {
                        int var10001;
                        ImportBinding var10002;
                        if ((var6.field_446 & 131072) != 0) {
                            if (!CharOperation.equals(var7, this.currentPackageName)) {
                                Binding var12 = this.method_681(var7, var7.length);
                                if (var12.isValidBinding() && (!var6.isStatic() || !(var12 instanceof PackageBinding))) {
                                    var10001 = var11++;
                                    var10002 = new ImportBinding(var7, true, var12, var6);
                                    var10[var10001] = var10002;
                                }
                            }
                        } else {
                            var10001 = var11++;
                            var10002 = new ImportBinding(var7, false, (Binding)null, var6);
                            var10[var10001] = var10002;
                        }
                    }
                    ++var5;
                    break;
                }
            }
            if (var10.length > var11) {
                System.arraycopy(var10, 0, var10 = new ImportBinding[var11], 0, var11);
            }
            this.imports = var10;
        }
    }

    void method_676() {
        if (this.compilerOptions().field_1928 >= 3211264L) {
            int var1 = 0;
            for (int var2 = this.topLevelTypes.length; var1 < var2; ++var1) {
                ClassScope var3 = this.topLevelTypes[var1].scope;
                var3.method_661();
                var3.method_659();
            }
        }
    }

    public char[] computeConstantPoolName(LocalTypeBinding var1) {
        if (var1.constantPoolName() != null) {
            return var1.constantPoolName();
        } else {
            if (this.constantPoolNameUsage == null) {
                HashtableOfType var10001 = new HashtableOfType();
                this.constantPoolNameUsage = var10001;
            }
            SourceTypeBinding var2 = var1.scope.method_640().enclosingSourceType();
            int var3 = 0;
            boolean var5 = this.compilerOptions().field_1927 >= 3211264L;
            while (true) {
                char[] var4;
                if (var1.method_159()) {
                    if (var3 == 0) {
                        var4 = CharOperation.concat(var1.enclosingType().constantPoolName(), var1.sourceName, '$');
                    } else {
                        var4 = CharOperation.concat(var1.enclosingType().constantPoolName(), '$', String.valueOf(var3).toCharArray(), '$', var1.sourceName);
                    }
                } else if (var1.method_146()) {
                    if (var5) {
                        var4 = CharOperation.concat(var1.enclosingType.constantPoolName(), String.valueOf(var3 + 1).toCharArray(), '$');
                    } else {
                        var4 = CharOperation.concat(var2.constantPoolName(), String.valueOf(var3 + 1).toCharArray(), '$');
                    }
                } else if (var5) {
                    var4 = CharOperation.concat(CharOperation.concat(var1.enclosingType().constantPoolName(), String.valueOf(var3 + 1).toCharArray(), '$'), var1.sourceName);
                } else {
                    var4 = CharOperation.concat(var2.constantPoolName(), '$', String.valueOf(var3 + 1).toCharArray(), '$', var1.sourceName);
                }
                if (this.constantPoolNameUsage.get(var4) == null) {
                    this.constantPoolNameUsage.put(var4, var1);
                    return var4;
                }
                ++var3;
            }
        }
    }

    void method_678() {
        int var1 = 0;
        for (int var2 = this.topLevelTypes.length; var1 < var2; ++var1) {
            this.topLevelTypes[var1].scope.connectTypeHierarchy();
        }
    }

    void method_679() {
        if (this.typeOrPackageCache == null) {
            HashtableOfObject var17;
            if (this.referenceContext.imports == null) {
                var17 = new HashtableOfObject(1);
                this.typeOrPackageCache = var17;
            } else {
                int var1 = this.referenceContext.imports.length;
                HashtableOfType var2 = null;
                int var3;
                int var4;
                int var5;
                label202:
                for (var3 = 0; var3 < var1; ++var3) {
                    if ((this.referenceContext.imports[var3].field_446 & 131072) == 0) {
                        HashtableOfType var10000 = new HashtableOfType(this.topLevelTypes.length + var1);
                        var2 = var10000;
                        var4 = 0;
                        var5 = this.topLevelTypes.length;
                        while (true) {
                            if (var4 >= var5) {
                                break label202;
                            }
                            var2.put(this.topLevelTypes[var4].sourceName, this.topLevelTypes[var4]);
                            ++var4;
                        }
                    }
                }
                var3 = var1 + 1;
                for (var4 = 0; var4 < var1; ++var4) {
                    ImportReference var19 = this.referenceContext.imports[var4];
                    if ((var19.field_446 & 131072) != 0 && CharOperation.equals(TypeConstants.field_86, var19.tokens) && !var19.isStatic()) {
                        --var3;
                        break;
                    }
                }
                ImportBinding[] var18 = new ImportBinding[var3];
                var18[0] = this.getDefaultImports()[0];
                var5 = 1;
                int var6 = 0;
                while (var6 < var1) {
                    ImportReference var7 = this.referenceContext.imports[var6];
                    char[][] var8 = var7.tokens;
                    int var9 = 0;
                    while (true) {
                        if (var9 < var5) {
                            ImportBinding var10 = var18[var9];
                            if (var10.onDemand != ((var7.field_446 & 131072) != 0) || var10.isStatic() != var7.isStatic() || !CharOperation.equals(var8, var10.compoundName)) {
                                ++var9;
                                continue;
                            }
                            this.problemReporter().method_1809(var7);
                        } else {
                            Binding var22;
                            int var10001;
                            if ((var7.field_446 & 131072) != 0) {
                                if (CharOperation.equals(var8, this.currentPackageName)) {
                                    this.problemReporter().method_1809(var7);
                                } else {
                                    var22 = this.method_681(var8, var8.length);
                                    if (!var22.isValidBinding()) {
                                        this.problemReporter().importProblem(var7, var22);
                                    } else if (var7.isStatic() && var22 instanceof PackageBinding) {
                                        this.problemReporter().method_1497(var7);
                                    } else {
                                        var10001 = var5++;
                                        ImportBinding var10002 = new ImportBinding(var8, true, var22, var7);
                                        var18[var10001] = var10002;
                                    }
                                }
                            } else {
                                var22 = this.method_682(var8, var7.isStatic());
                                if (!var22.isValidBinding() && var22.problemId() != 3) {
                                    this.problemReporter().importProblem(var7, var22);
                                } else if (var22 instanceof PackageBinding) {
                                    this.problemReporter().method_1497(var7);
                                } else {
                                    label226: {
                                        ReferenceBinding var24 = null;
                                        if (var22 instanceof MethodBinding) {
                                            var24 = (ReferenceBinding)this.getType(var8, var8.length);
                                            if (!var24.isValidBinding()) {
                                                var24 = null;
                                            }
                                        }
                                        if (!(var22 instanceof ReferenceBinding) && var24 == null) {
                                            if (var22 instanceof FieldBinding) {
                                                for (int var23 = 0; var23 < var5; ++var23) {
                                                    ImportBinding var25 = var18[var23];
                                                    if (var25.isStatic() && var25.resolvedImport instanceof FieldBinding && var22 != var25.resolvedImport && CharOperation.method_1364(var8[var8.length - 1], var25.compoundName[var25.compoundName.length - 1])) {
                                                        this.problemReporter().method_1525(var7);
                                                        break label226;
                                                    }
                                                }
                                            }
                                        } else {
                                            ReferenceBinding var11 = var24 == null ? (ReferenceBinding)var22 : var24;
                                            ReferenceBinding var12 = var11.problemId() == 3 ? ((ProblemReferenceBinding)var11).closestMatch : var11;
                                            if (var7.isTypeUseDeprecated(var12, this)) {
                                                this.problemReporter().method_1516(var12, var7);
                                            }
                                            ReferenceBinding var13 = var2.get(var8[var8.length - 1]);
                                            if (var13 != null) {
                                                if (var13 != var11) {
                                                    int var14 = 0;
                                                    for (int var15 = this.topLevelTypes.length; var14 < var15; ++var14) {
                                                        if (CharOperation.method_1364(this.topLevelTypes[var14].sourceName, var13.sourceName)) {
                                                            this.problemReporter().method_1510(var7);
                                                            break label226;
                                                        }
                                                    }
                                                    this.problemReporter().method_1525(var7);
                                                }
                                                break label226;
                                            }
                                            var2.put(var8[var8.length - 1], var11);
                                        }
                                        var10001 = var5++;
                                        Object var16;
                                        if (var24 == null) {
                                            var16 = new ImportBinding(var8, false, var22, var7);
                                        } else {
                                            var16 = new ImportConflictBinding(var8, var22, var24, var7);
                                        }
                                        var18[var10001] = (ImportBinding)var16;
                                    }
                                }
                            }
                        }
                        ++var6;
                        break;
                    }
                }
                if (var18.length > var5) {
                    System.arraycopy(var18, 0, var18 = new ImportBinding[var5], 0, var5);
                }
                this.imports = var18;
                var6 = this.imports.length;
                var17 = new HashtableOfObject(var6);
                this.typeOrPackageCache = var17;
                for (int var20 = 0; var20 < var6; ++var20) {
                    ImportBinding var21 = this.imports[var20];
                    if (!var21.onDemand && var21.resolvedImport instanceof ReferenceBinding || var21 instanceof ImportConflictBinding) {
                        this.typeOrPackageCache.put(var21.compoundName[var21.compoundName.length - 1], var21);
                    }
                }
            }
        }
    }

    public void method_680() {
        this.method_679();
        int var1 = 0;
        for (int var2 = this.topLevelTypes.length; var1 < var2; ++var1) {
            this.topLevelTypes[var1].method_306();
        }
    }

    private Binding method_681(char[][] var1, int var2) {
        this.recordQualifiedReference(var1);
        Object var3 = this.environment.method_507(var1[0]);
        int var4 = 1;
        if (var3 != null) {
            PackageBinding var5 = (PackageBinding)var3;
            while (true) {
                if (var4 >= var2) {
                    return var5;
                }
                var3 = var5.getTypeOrPackage(var1[var4++]);
                if (var3 == null || !((Binding)var3).isValidBinding()) {
                    var3 = null;
                    break;
                }
                if (!(var3 instanceof PackageBinding)) {
                    break;
                }
                var5 = (PackageBinding)var3;
            }
        }
        ReferenceBinding var7;
        ProblemReferenceBinding var10000;
        if (var3 == null) {
            if (this.environment.defaultPackage == null || this.compilerOptions().field_1927 >= 3145728L) {
                var10000 = new ProblemReferenceBinding(CharOperation.subarray(var1, 0, var4), (ReferenceBinding)null, 1);
                return var10000;
            }
            var7 = this.findType(var1[0], this.environment.defaultPackage, this.environment.defaultPackage);
            if (var7 == null || !var7.isValidBinding()) {
                var10000 = new ProblemReferenceBinding(CharOperation.subarray(var1, 0, var4), (ReferenceBinding)null, 1);
                return var10000;
            }
            var4 = 1;
        } else {
            var7 = (ReferenceBinding)var3;
        }
        do {
            if (var4 >= var2) {
                if (!var7.canBeSeenBy(this.fPackage)) {
                    var10000 = new ProblemReferenceBinding(var1, var7, 2);
                    return var10000;
                }
                return var7;
            }
            var7 = (ReferenceBinding)this.environment.convertToRawType(var7, false);
            if (!var7.canBeSeenBy(this.fPackage)) {
                var10000 = new ProblemReferenceBinding(CharOperation.subarray(var1, 0, var4), var7, 2);
                return var10000;
            }
            char[] var6 = var1[var4++];
            var7 = var7.getMemberType(var6);
        } while (var7 != null);
        var10000 = new ProblemReferenceBinding(CharOperation.subarray(var1, 0, var4), (ReferenceBinding)null, 1);
        return var10000;
    }

    private Binding method_682(char[][] var1, boolean var2) {
        if (var1.length == 1) {
            ProblemReferenceBinding var10000;
            if (this.environment.defaultPackage != null && this.compilerOptions().field_1927 < 3145728L) {
                ReferenceBinding var3 = this.findType(var1[0], this.environment.defaultPackage, this.fPackage);
                if (var3 == null) {
                    var10000 = new ProblemReferenceBinding(var1, (ReferenceBinding)null, 1);
                    return var10000;
                } else {
                    return var3;
                }
            } else {
                var10000 = new ProblemReferenceBinding(var1, (ReferenceBinding)null, 1);
                return var10000;
            }
        } else {
            return var2 ? this.method_683(var1) : this.method_681(var1, var1.length);
        }
    }

    private Binding method_683(char[][] var1) {
        Binding var2 = this.method_681(var1, var1.length - 1);
        if (!var2.isValidBinding()) {
            return var2;
        } else {
            char[] var3 = var1[var1.length - 1];
            ProblemReferenceBinding var10000;
            if (var2 instanceof PackageBinding) {
                Binding var7 = ((PackageBinding)var2).getTypeOrPackage(var3);
                if (var7 != null && var7 instanceof ReferenceBinding) {
                    var10000 = new ProblemReferenceBinding(var1, (ReferenceBinding)var7, 14);
                    return var10000;
                } else {
                    return var2;
                }
            } else {
                ReferenceBinding var4 = (ReferenceBinding)var2;
                FieldBinding var5 = this.findField(var4, var3, (InvocationSite)null, true);
                if (var5 != null) {
                    if (var5.problemId() == 3 && ((ProblemFieldBinding)var5).closestMatch.method_431()) {
                        return var5;
                    }
                    if (var5.isValidBinding() && var5.method_431() && var5.canBeSeenBy(var4, (InvocationSite)null, this)) {
                        return var5;
                    }
                }
                MethodBinding var6 = this.findStaticMethod(var4, var3);
                if (var6 != null) {
                    return var6;
                } else {
                    var4 = this.method_591(var3, var4);
                    if (var4 != null && var4.method_226()) {
                        if (var4.isValidBinding() && !var4.canBeSeenBy(this.fPackage)) {
                            var10000 = new ProblemReferenceBinding(var1, var4, 2);
                            return var10000;
                        } else if (var4.problemId() == 2) {
                            var10000 = new ProblemReferenceBinding(var1, ((ProblemReferenceBinding)var4).closestMatch, 2);
                            return var10000;
                        } else {
                            return var4;
                        }
                    } else if (var5 != null && !var5.isValidBinding() && var5.problemId() != 1) {
                        return var5;
                    } else {
                        var10000 = new ProblemReferenceBinding(var1, var4, 1);
                        return var10000;
                    }
                }
            }
        }
    }

    private MethodBinding findStaticMethod(ReferenceBinding var1, char[] var2) {
        if (!var1.canBeSeenBy(this)) {
            return null;
        } else {
            label28:
            do {
                var1.initializeForStaticImports();
                MethodBinding[] var3 = var1.getMethods(var2);
                if (var3 != Binding.field_154) {
                    int var4 = var3.length;
                    MethodBinding var5;
                    do {
                        --var4;
                        if (var4 < 0) {
                            continue label28;
                        }
                        var5 = var3[var4];
                    } while (!var5.method_370() || !var5.canBeSeenBy(this.fPackage));
                    return var5;
                }
            } while ((var1 = var1.superclass()) != null);
            return null;
        }
    }

    ImportBinding[] getDefaultImports() {
        if (this.environment.defaultImports != null) {
            return this.environment.defaultImports;
        } else {
            Object var1 = this.environment.method_507(TypeConstants.field_26);
            if (var1 != null) {
                var1 = ((PackageBinding)var1).getTypeOrPackage(TypeConstants.field_86[1]);
            }
            if (var1 == null || !((Binding)var1).isValidBinding()) {
                this.problemReporter().isClassPathCorrect(TypeConstants.field_99, this.referenceContext, this.environment.missingClassFileLocation);
                MissingTypeBinding var2 = this.environment.createMissingType((PackageBinding)null, TypeConstants.field_99);
                var1 = var2.fPackage;
            }
            LookupEnvironment var10000 = this.environment;
            ImportBinding[] var10001 = new ImportBinding[1];
            ImportBinding var10004 = new ImportBinding(TypeConstants.field_86, true, (Binding)var1, (ImportReference)null);
            var10001[0] = var10004;
            return var10000.defaultImports = var10001;
        }
    }

    public int nextCaptureID() {
        return this.captureID++;
    }

    public ProblemReporter problemReporter() {
        ProblemReporter var1 = this.referenceContext.problemReporter;
        var1.referenceContext = this.referenceContext;
        return var1;
    }

    void recordQualifiedReference(char[][] var1) {
        if (this.qualifiedReferences != null) {
            int var2 = var1.length;
            if (var2 > 1) {
                while (!this.qualifiedReferences.contains(var1)) {
                    this.qualifiedReferences.add(var1);
                    if (var2 == 2) {
                        this.method_690(var1[0]);
                        this.method_690(var1[1]);
                        return;
                    }
                    --var2;
                    this.method_690(var1[var2]);
                    System.arraycopy(var1, 0, var1 = new char[var2][], 0, var2);
                }
            } else if (var2 == 1) {
                this.method_690(var1[0]);
            }
        }
    }

    void recordReference(char[][] var1, char[] var2) {
        this.recordQualifiedReference(var1);
        this.method_690(var2);
    }

    void recordReference(ReferenceBinding var1, char[] var2) {
        ReferenceBinding var3 = this.typeToRecord(var1);
        if (var3 != null) {
            this.recordReference(var3.compoundName, var2);
        }
    }

    void method_690(char[] var1) {
        if (this.field_386 != null) {
            if (!this.field_386.contains(var1)) {
                this.field_386.add(var1);
            }
        }
    }

    void method_691(TypeBinding var1) {
        if (this.field_388 != null) {
            ReferenceBinding var2 = this.typeToRecord(var1);
            if (var2 != null && !this.field_388.method_3233(var2)) {
                this.field_388.add(var2);
            }
        }
    }

    public void recordTypeConversion(TypeBinding var1, TypeBinding var2) {
        this.method_691(var2);
    }

    void method_693(TypeBinding var1) {
        if (this.field_387 != null) {
            ReferenceBinding var2 = this.typeToRecord(var1);
            if (var2 != null && !this.field_387.method_3233(var2)) {
                this.field_387.add(var2);
            }
        }
    }

    void recordTypeReferences(TypeBinding[] var1) {
        if (this.field_387 != null) {
            if (var1 != null && var1.length != 0) {
                int var2 = 0;
                for (int var3 = var1.length; var2 < var3; ++var2) {
                    ReferenceBinding var4 = this.typeToRecord(var1[var2]);
                    if (var4 != null && !this.field_387.method_3233(var4)) {
                        this.field_387.add(var4);
                    }
                }
            }
        }
    }

    Binding method_695(ImportBinding var1) {
        if (var1.resolvedImport == null) {
            var1.resolvedImport = this.method_682(var1.compoundName, var1.isStatic());
            if (!var1.resolvedImport.isValidBinding() || var1.resolvedImport instanceof PackageBinding) {
                if (var1.resolvedImport.problemId() == 3) {
                    return var1.resolvedImport;
                }
                if (this.imports != null) {
                    ImportBinding[] var2 = new ImportBinding[this.imports.length - 1];
                    int var3 = 0;
                    int var4 = 0;
                    for (int var5 = this.imports.length; var3 < var5; ++var3) {
                        if (this.imports[var3] != var1) {
                            var2[var4++] = this.imports[var3];
                        }
                    }
                    this.imports = var2;
                }
                return null;
            }
        }
        return var1.resolvedImport;
    }

    public void method_696() {
        int var1;
        ReferenceBinding var3;
        for (var1 = 0; var1 < this.field_388.size; ++var1) {
            ReferenceBinding var2 = (ReferenceBinding)this.field_388.elementAt(var1);
            if (!this.field_387.method_3233(var2)) {
                this.field_387.add(var2);
            }
            if (!var2.method_158()) {
                var3 = var2.enclosingType();
                if (var3 != null) {
                    this.method_691(var3);
                }
            }
            var3 = var2.superclass();
            if (var3 != null) {
                this.method_691(var3);
            }
            ReferenceBinding[] var4 = var2.superInterfaces();
            if (var4 != null) {
                int var5 = 0;
                for (int var6 = var4.length; var5 < var6; ++var5) {
                    this.method_691(var4[var5]);
                }
            }
        }
        var1 = 0;
        for (int var7 = this.field_387.size; var1 < var7; ++var1) {
            var3 = (ReferenceBinding)this.field_387.elementAt(var1);
            if (!var3.method_158()) {
                this.recordQualifiedReference(var3.method_159() ? CharOperation.method_1385('.', var3.readableName()) : var3.compoundName);
            }
        }
        var1 = this.qualifiedReferences.size;
        char[][][] var8 = new char[var1][][];
        for (int var9 = 0; var9 < var1; ++var9) {
            var8[var9] = this.qualifiedReferences.elementAt(var9);
        }
        this.referenceContext.compilationResult.qualifiedReferences = var8;
        var1 = this.field_386.size;
        char[][] var11 = new char[var1][];
        for (int var10 = 0; var10 < var1; ++var10) {
            var11[var10] = this.field_386.elementAt(var10);
        }
        this.referenceContext.compilationResult.field_1682 = var11;
    }

    public String toString() {
        return "--- CompilationUnit Scope : " + new String(this.referenceContext.method_771());
    }

    private ReferenceBinding typeToRecord(TypeBinding var1) {
        if (var1.method_147()) {
            var1 = ((ArrayBinding)var1).leafComponentType;
        }
        switch (var1.kind()) {
            case 132:
            case 516:
            case 4100:
            case 8196:
                return null;
            case 260:
            case 1028:
                var1 = var1.erasure();
            default:
                ReferenceBinding var2 = (ReferenceBinding)var1;
                return var2.method_158() ? null : var2;
        }
    }

    public void verifyMethods(MethodVerifier var1) {
        int var2 = 0;
        for (int var3 = this.topLevelTypes.length; var2 < var3; ++var2) {
            this.topLevelTypes[var2].verifyMethods(var1);
        }
    }
}
