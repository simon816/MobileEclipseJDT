package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.impl.CompilerOptions;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.PackageBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.UnresolvedReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.BinaryTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;
import org.eclipse.jdt.internal.compiler.problem.ProblemReporter;
import org.eclipse.jdt.internal.compiler.util.SimpleSet;
import org.eclipse.jdt.internal.compiler.util.HashtableOfObject;

public class MethodVerifier {

    SourceTypeBinding type;

    HashtableOfObject field_369;

    HashtableOfObject field_370;

    LookupEnvironment environment;

    private boolean allowCompatibleReturnTypes;

    MethodVerifier(LookupEnvironment var1) {
        this.type = null;
        this.field_369 = null;
        this.field_370 = null;
        this.environment = var1;
        this.allowCompatibleReturnTypes = var1.globalOptions.field_1927 >= 3211264L && var1.globalOptions.field_1928 < 3211264L;
    }

    boolean method_522(MethodBinding var1, MethodBinding var2) {
        return this.method_548(var1, var2) && this.method_524(var1, var2);
    }

    boolean method_523(MethodBinding var1, MethodBinding var2) {
        TypeBinding[] var3 = var1.parameters;
        TypeBinding[] var4 = var2.parameters;
        if (var3 == var4) {
            return true;
        } else {
            int var5 = var3.length;
            if (var5 != var4.length) {
                return false;
            } else {
                for (int var6 = 0; var6 < var5; ++var6) {
                    if (!this.areTypesEqual(var3[var6], var4[var6])) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    boolean method_524(MethodBinding var1, MethodBinding var2) {
        return var1.returnType == var2.returnType ? true : (this.areTypesEqual(var1.returnType, var2.returnType) ? true : (this.allowCompatibleReturnTypes && var1.declaringClass instanceof BinaryTypeBinding && var2.declaringClass instanceof BinaryTypeBinding ? this.method_525(var1, var2) : false));
    }

    boolean method_525(MethodBinding var1, MethodBinding var2) {
        return var1.returnType.method_148() ? false : (!var1.declaringClass.method_157() ? (var1.declaringClass.id == 1 ? var2.returnType.isCompatibleWith(var1.returnType) : var1.returnType.isCompatibleWith(var2.returnType)) : (var2.declaringClass.id == 1 ? var1.returnType.isCompatibleWith(var2.returnType) : (var1.declaringClass.implementsInterface(var2.declaringClass, true) ? var1.returnType.isCompatibleWith(var2.returnType) : (var2.declaringClass.implementsInterface(var1.declaringClass, true) ? var2.returnType.isCompatibleWith(var1.returnType) : var1.returnType.isCompatibleWith(var2.returnType) || var2.returnType.isCompatibleWith(var1.returnType)))));
    }

    boolean areTypesEqual(TypeBinding var1, TypeBinding var2) {
        return var1 == var2 ? true : (var1 instanceof UnresolvedReferenceBinding ? ((UnresolvedReferenceBinding)var1).resolvedType == var2 : (var2 instanceof UnresolvedReferenceBinding ? ((UnresolvedReferenceBinding)var2).resolvedType == var1 : false));
    }

    boolean canSkipInheritedMethods() {
        return this.type.superclass() != null && this.type.superclass().method_217() ? false : this.type.superInterfaces() == Binding.field_155;
    }

    boolean method_528(MethodBinding var1, MethodBinding var2) {
        return var2 == null || var1.declaringClass == var2.declaringClass;
    }

    void method_529(MethodBinding var1) {
        if (this.mustImplementAbstractMethod(var1.declaringClass)) {
            TypeDeclaration var2 = this.type.scope.referenceContext;
            if (var2 != null) {
                MethodDeclaration var3 = var2.addMissingAbstractMethodFor(var1);
                var3.scope.problemReporter().method_1463(this.type, var1);
            } else {
                this.problemReporter().method_1463(this.type, var1);
            }
        }
    }

    void checkAgainstInheritedMethods(MethodBinding var1, MethodBinding[] var2, int var3, MethodBinding[] var4) {
        if (this.type.method_145()) {
            this.problemReporter().method_1466(var1, var2[var3 - 1]);
        } else {
            CompilerOptions var5 = this.type.scope.compilerOptions();
            int[] var6 = var3 > 1 ? this.findOverriddenInheritedMethods(var2, var3) : null;
            int var7 = var3;
            label91:
            while (true) {
                --var7;
                if (var7 < 0) {
                    return;
                }
                MethodBinding var8 = var2[var7];
                if (var6 == null || var6[var7] == 0) {
                    if (var1.method_370() != var8.method_370()) {
                        this.problemReporter(var1).method_1756(var1, var8);
                        continue;
                    }
                    if (var8.method_356()) {
                        if (var8.declaringClass.method_157()) {
                            var1.modifiers |= 536870912;
                        } else {
                            var1.modifiers |= 805306368;
                        }
                    } else if (var8.method_369() || !this.type.method_157()) {
                        var1.modifiers |= 268435456;
                    }
                    if (!this.method_524(var1, var8) && (var1.returnType.tagBits & 128L) == 0L && this.method_554(var1, var8)) {
                        continue;
                    }
                    if (var1.thrownExceptions != Binding.field_151) {
                        this.checkExceptions(var1, var8);
                    }
                    if (var8.method_362()) {
                        this.problemReporter(var1).method_1551(var1, var8);
                    }
                    if (!this.method_546(var1, var8)) {
                        this.problemReporter(var1).method_1823(var1, var8);
                    }
                    if (var5.field_1940 && var8.method_375() && (!var1.method_375() || var5.field_1939)) {
                        ReferenceBinding var9 = var8.declaringClass;
                        if (var9.method_157()) {
                            int var10 = var3;
                            while (true) {
                                --var10;
                                if (var10 < 0) {
                                    break;
                                }
                                if (var7 != var10 && var2[var10].declaringClass.implementsInterface(var9, false)) {
                                    continue label91;
                                }
                            }
                        }
                        this.problemReporter(var1).method_1715(var1, var8);
                    }
                }
                this.checkForBridgeMethod(var1, var8, var4);
            }
        }
    }

    void checkConcreteInheritedMethod(MethodBinding var1, MethodBinding[] var2) {
        if (var1.method_370()) {
            this.problemReporter().method_1758(this.type, var1, var2);
        }
        int var3;
        if (!var1.method_369()) {
            var3 = 0;
            int var4 = var2.length;
            if (var1.method_368()) {
                while (var3 < var4 && !var2[var3].method_369()) {
                    ++var3;
                }
            } else if (var1.method_359()) {
                while (var3 < var4 && var2[var3].method_359()) {
                    ++var3;
                }
            }
            if (var3 < var4) {
                this.problemReporter().method_1614(this.type, var1, var2);
            }
        }
        if (var1.thrownExceptions != Binding.field_151) {
            var3 = var2.length;
            while (true) {
                --var3;
                if (var3 < 0) {
                    break;
                }
                this.checkExceptions(var1, var2[var3]);
            }
        }
    }

    void checkExceptions(MethodBinding var1, MethodBinding var2) {
        ReferenceBinding[] var3 = this.resolvedExceptionTypesFor(var1);
        ReferenceBinding[] var4 = this.resolvedExceptionTypesFor(var2);
        int var5 = var3.length;
        while (true) {
            --var5;
            if (var5 < 0) {
                return;
            }
            ReferenceBinding var6 = var3[var5];
            int var7 = var4.length;
            do {
                --var7;
            } while (var7 > -1 && !this.isSameClassOrSubclassOf(var6, var4[var7]));
            if (var7 == -1 && !var6.isUncheckedException(false) && (var6.tagBits & 128L) == 0L) {
                this.problemReporter(var1).incompatibleExceptionInThrowsClause(this.type, var1, var2, var6);
            }
        }
    }

    void checkForBridgeMethod(MethodBinding var1, MethodBinding var2, MethodBinding[] var3) {}

    void method_534(ReferenceBinding var1, ReferenceBinding[] var2) {
        if (var2 != Binding.field_155) {
            SimpleSet var10000 = new SimpleSet(var2.length);
            SimpleSet var3 = var10000;
            int var4 = 0;
            for (int var5 = var2.length; var4 < var5; ++var4) {
                var3.method_1335(var2[var4]);
            }
            ReferenceBinding[] var16 = null;
            var10000 = new SimpleSet(5);
            SimpleSet var17 = var10000;
            ReferenceBinding var6;
            int var7;
            int var11;
            for (var6 = var1; var6 != null && var6.isValidBinding(); var6 = var6.superclass()) {
                if ((var16 = var6.superInterfaces()) != Binding.field_155) {
                    var7 = 0;
                    for (int var8 = var16.length; var7 < var8; ++var7) {
                        ReferenceBinding var9 = var16[var7];
                        if (!var17.includes(var9) && var9.isValidBinding()) {
                            if (var3.includes(var9)) {
                                TypeReference[] var10 = this.type.scope.referenceContext.superInterfaces;
                                var11 = 0;
                                for (int var12 = var10.length; var11 < var12; ++var11) {
                                    if (var10[var11].resolvedType == var9) {
                                        this.problemReporter().redundantSuperInterface(this.type, var10[var11], var9, var6);
                                        break;
                                    }
                                }
                            } else {
                                var17.method_1335(var9);
                            }
                        }
                    }
                }
            }
            var7 = var17.field_988;
            if (var7 != 0) {
                ReferenceBinding[] var18 = new ReferenceBinding[var7];
                var17.asArray(var18);
                for (int var19 = 0; var19 < var7; ++var19) {
                    var6 = var18[var19];
                    if ((var16 = var6.superInterfaces()) != Binding.field_155) {
                        int var20 = var16.length;
                        if (var7 + var20 >= var18.length) {
                            System.arraycopy(var18, 0, var18 = new ReferenceBinding[var7 + var20 + 5], 0, var7);
                        }
                        for (var11 = 0; var11 < var20; ++var11) {
                            ReferenceBinding var21 = var16[var11];
                            if (!var17.includes(var21) && var21.isValidBinding()) {
                                if (var3.includes(var21)) {
                                    TypeReference[] var13 = this.type.scope.referenceContext.superInterfaces;
                                    int var14 = 0;
                                    for (int var15 = var13.length; var14 < var15; ++var14) {
                                        if (var13[var14].resolvedType == var21) {
                                            this.problemReporter().redundantSuperInterface(this.type, var13[var14], var21, var6);
                                            break;
                                        }
                                    }
                                } else {
                                    var17.method_1335(var21);
                                    var18[var7++] = var21;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    void checkInheritedMethods(MethodBinding[] var1, int var2) {
        int var4;
        int var6;
        if (var2 > 1) {
            int[] var3 = this.findOverriddenInheritedMethods(var1, var2);
            if (var3 != null) {
                var4 = 0;
                MethodBinding[] var5 = new MethodBinding[var2];
                for (var6 = 0; var6 < var2; ++var6) {
                    if (var3[var6] == 0) {
                        var5[var4++] = var1[var6];
                    }
                }
                if (var4 > 1 && !this.method_536(var5, var4)) {
                    return;
                }
            } else if (!this.method_536(var1, var2)) {
                return;
            }
        }
        MethodBinding var7 = null;
        if (!this.type.method_157()) {
            var4 = var2;
            while (true) {
                --var4;
                if (var4 < 0) {
                    break;
                }
                if (!var1[var4].method_356()) {
                    var7 = var1[var4];
                    break;
                }
            }
        }
        if (var7 == null) {
            if (!this.type.method_217()) {
                var4 = var2;
                while (true) {
                    --var4;
                    if (var4 < 0) {
                        break;
                    }
                    if (this.mustImplementAbstractMethod(var1[var4].declaringClass)) {
                        TypeDeclaration var10 = this.type.scope.referenceContext;
                        if (var10 != null) {
                            MethodDeclaration var11 = var10.addMissingAbstractMethodFor(var1[0]);
                            var11.scope.problemReporter().method_1463(this.type, var1[0]);
                        } else {
                            this.problemReporter().method_1463(this.type, var1[0]);
                        }
                        return;
                    }
                }
            }
        } else {
            if (var2 > 1) {
                MethodBinding[] var8 = new MethodBinding[var2 - 1];
                int var9 = 0;
                var6 = var2;
                while (true) {
                    --var6;
                    if (var6 < 0) {
                        this.checkConcreteInheritedMethod(var7, var8);
                        break;
                    }
                    if (var1[var6] != var7) {
                        var8[var9++] = var1[var6];
                    }
                }
            }
        }
    }

    boolean method_536(MethodBinding[] var1, int var2) {
        MethodBinding var3 = var1[0];
        int var4 = var2;
        do {
            --var4;
        } while (var4 > 0 && this.method_524(var3, var1[var4]));
        if (var4 == 0) {
            return true;
        } else {
            if (this.type.method_157()) {
                int var5 = var2;
                while (true) {
                    --var5;
                    if (var5 < 0) {
                        break;
                    }
                    if (var1[var5].declaringClass.id == 1) {
                        return false;
                    }
                }
            }
            this.problemReporter().inheritedMethodsHaveIncompatibleReturnTypes(this.type, var1, var2);
            return false;
        }
    }

    void checkMethods() {
        boolean var1 = this.method_551();
        boolean var2 = var1 && this.canSkipInheritedMethods();
        char[][] var3 = this.field_369.keyTable;
        int var4 = var3.length;
        while (true) {
            --var4;
            if (var4 < 0) {
                return;
            }
            if (var3[var4] != null) {
                MethodBinding[] var5 = (MethodBinding[])((MethodBinding[])this.field_370.method_3226(var3[var4]));
                if (var5 != null || !var2) {
                    MethodBinding[] var6 = (MethodBinding[])((MethodBinding[])this.field_369.valueTable[var4]);
                    if (var6.length == 1 && var5 == null) {
                        if (var1 && var6[0].method_356()) {
                            this.method_529(var6[0]);
                        }
                    } else {
                        int var7 = -1;
                        MethodBinding[] var8 = new MethodBinding[var6.length];
                        int var9;
                        int var10;
                        MethodBinding var11;
                        int var12;
                        if (var5 != null) {
                            var9 = 0;
                            for (var10 = var5.length; var9 < var10; ++var9) {
                                var11 = var5[var9];
                                var12 = 0;
                                for (int var13 = var6.length; var12 < var13; ++var12) {
                                    MethodBinding var14 = this.computeSubstituteMethod(var6[var12], var11);
                                    if (var14 != null && this.method_548(var11, var14)) {
                                        ++var7;
                                        var8[var7] = var14;
                                        var6[var12] = null;
                                    }
                                }
                                if (var7 >= 0) {
                                    this.checkAgainstInheritedMethods(var11, var8, var7 + 1, var6);
                                    while (var7 >= 0) {
                                        var8[var7--] = null;
                                    }
                                }
                            }
                        }
                        var9 = 0;
                        for (var10 = var6.length; var9 < var10; ++var9) {
                            var11 = var6[var9];
                            if (var11 != null) {
                                ++var7;
                                var8[var7] = var11;
                                for (var12 = var9 + 1; var12 < var10; ++var12) {
                                    MethodBinding var15 = var6[var12];
                                    if (!this.method_528(var11, var15)) {
                                        var15 = this.computeSubstituteMethod(var15, var11);
                                        if (var15 != null && this.method_548(var11, var15)) {
                                            ++var7;
                                            var8[var7] = var15;
                                            var6[var12] = null;
                                        }
                                    }
                                }
                                if (var7 != -1) {
                                    if (var7 > 0) {
                                        this.checkInheritedMethods(var8, var7 + 1);
                                    } else if (var1 && var8[0].method_356()) {
                                        this.method_529(var8[0]);
                                    }
                                    while (var7 >= 0) {
                                        var8[var7--] = null;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    void method_538(MethodBinding var1) {
        PackageBinding var2 = var1.declaringClass.fPackage;
        if (var2 != this.type.fPackage) {
            ReferenceBinding var3 = this.type.superclass();
            char[] var4 = var1.selector;
            while (var3.isValidBinding()) {
                if (!var3.method_217()) {
                    return;
                }
                if (var2 == var3.fPackage) {
                    MethodBinding[] var5 = var3.getMethods(var4);
                    int var6 = var5.length;
                    while (true) {
                        --var6;
                        if (var6 < 0) {
                            break;
                        }
                        MethodBinding var7 = var5[var6];
                        if (!var7.method_367() && !var7.method_358() && !var7.method_360() && this.method_522(var7, var1)) {
                            return;
                        }
                    }
                }
                if ((var3 = var3.superclass()) == var1.declaringClass) {
                    this.problemReporter().method_1461(this.type, var1);
                    return;
                }
            }
        }
    }

    void method_539() {
        ReferenceBinding var1 = this.type.method_157() ? this.type.scope.method_609() : this.type.superclass();
        this.method_540(var1, this.type.superInterfaces());
        this.method_534(var1, this.type.superInterfaces());
    }

    void method_540(ReferenceBinding var1, ReferenceBinding[] var2) {
        HashtableOfObject var10001 = new HashtableOfObject(51);
        this.field_369 = var10001;
        ReferenceBinding[] var3 = null;
        int var4 = 0;
        if (var2 != Binding.field_155) {
            var4 = var2.length;
            var3 = var2;
        }
        ReferenceBinding var6 = var1;
        HashtableOfObject var10000 = new HashtableOfObject(3);
        HashtableOfObject var7 = var10000;
        boolean var8 = true;
        ReferenceBinding[] var5;
        int var10;
        int var12;
        int var14;
        int var15;
        int var16;
        MethodBinding[] var26;
        while (var6 != null && var6.isValidBinding()) {
            if (var8) {
                if (var6.method_217()) {
                    if ((var5 = var6.superInterfaces()) != Binding.field_155) {
                        if (var3 == null) {
                            var3 = var5;
                            var4 = var5.length;
                        } else {
                            int var9 = var5.length;
                            if (var4 + var9 >= var3.length) {
                                System.arraycopy(var3, 0, var3 = new ReferenceBinding[var4 + var9 + 5], 0, var4);
                            }
                            label216:
                            for (var10 = 0; var10 < var9; ++var10) {
                                ReferenceBinding var11 = var5[var10];
                                for (var12 = 0; var12 < var4; ++var12) {
                                    if (var11 == var3[var12]) {
                                        continue label216;
                                    }
                                }
                                var3[var4++] = var11;
                            }
                        }
                    }
                } else {
                    var8 = false;
                }
            }
            MethodBinding[] var17 = var6.unResolvedMethods();
            var10 = var17.length;
            label203:
            while (true) {
                --var10;
                if (var10 < 0) {
                    var6 = var6.superclass();
                    break;
                }
                MethodBinding var19 = var17[var10];
                if (!var19.method_367() && !var19.method_358() && !var19.method_360()) {
                    MethodBinding[] var20 = (MethodBinding[])((MethodBinding[])this.field_369.method_3226(var19.selector));
                    if (var20 != null) {
                        int var13 = 0;
                        for (var14 = var20.length; var13 < var14; ++var13) {
                            if (var20[var13].declaringClass != var19.declaringClass && this.method_522(var20[var13], var19)) {
                                if (var19.method_359() && var19.method_356()) {
                                    this.method_538(var19);
                                }
                                continue label203;
                            }
                        }
                    }
                    MethodBinding[] var23 = (MethodBinding[])((MethodBinding[])var7.method_3226(var19.selector));
                    if (var23 != null) {
                        var14 = 0;
                        for (var15 = var23.length; var14 < var15; ++var14) {
                            if (this.method_522(var23[var14], var19)) {
                                continue label203;
                            }
                        }
                    }
                    if (var19.method_359() && var19.declaringClass.fPackage != this.type.fPackage) {
                        if (var23 == null) {
                            var23 = new MethodBinding[] {var19};
                        } else {
                            var14 = var23.length;
                            System.arraycopy(var23, 0, var23 = new MethodBinding[var14 + 1], 0, var14);
                            var23[var14] = var19;
                        }
                        var7.put(var19.selector, var23);
                        if (var19.method_356() && !this.type.method_217()) {
                            this.problemReporter().method_1461(this.type, var19);
                        }
                        var26 = (MethodBinding[])((MethodBinding[])this.field_370.method_3226(var19.selector));
                        if (var26 != null && !var19.method_370()) {
                            var15 = 0;
                            for (var16 = var26.length; var15 < var16; ++var15) {
                                if (!var26[var15].method_370() && this.method_522(var26[var15], var19)) {
                                    this.problemReporter().method_1717(var26[var15], var19);
                                    break;
                                }
                            }
                        }
                    } else {
                        if (var20 == null) {
                            var20 = new MethodBinding[] {var19};
                        } else {
                            var14 = var20.length;
                            System.arraycopy(var20, 0, var20 = new MethodBinding[var14 + 1], 0, var14);
                            var20[var14] = var19;
                        }
                        this.field_369.put(var19.selector, var20);
                    }
                }
            }
        }
        if (var4 != 0) {
            SimpleSet var18 = this.findSuperinterfaceCollisions(var1, var2);
            for (var10 = 0; var10 < var4; ++var10) {
                var6 = var3[var10];
                if (var6.isValidBinding() && (var18 == null || !var18.includes(var6))) {
                    if ((var5 = var6.superInterfaces()) != Binding.field_155) {
                        int var21 = var5.length;
                        if (var4 + var21 >= var3.length) {
                            System.arraycopy(var3, 0, var3 = new ReferenceBinding[var4 + var21 + 5], 0, var4);
                        }
                        label149:
                        for (var12 = 0; var12 < var21; ++var12) {
                            ReferenceBinding var24 = var5[var12];
                            for (var14 = 0; var14 < var4; ++var14) {
                                if (var24 == var3[var14]) {
                                    continue label149;
                                }
                            }
                            var3[var4++] = var24;
                        }
                    }
                    MethodBinding[] var22 = var6.unResolvedMethods();
                    var12 = var22.length;
                    label136:
                    while (true) {
                        --var12;
                        if (var12 < 0) {
                            break;
                        }
                        MethodBinding var25 = var22[var12];
                        var26 = (MethodBinding[])((MethodBinding[])this.field_369.method_3226(var25.selector));
                        if (var26 == null) {
                            var26 = new MethodBinding[] {var25};
                        } else {
                            var15 = var26.length;
                            for (var16 = 0; var16 < var15; ++var16) {
                                if (this.isInterfaceMethodImplemented(var25, var26[var16], var6)) {
                                    continue label136;
                                }
                            }
                            System.arraycopy(var26, 0, var26 = new MethodBinding[var15 + 1], 0, var15);
                            var26[var15] = var25;
                        }
                        this.field_369.put(var25.selector, var26);
                    }
                }
            }
        }
    }

    void method_541() {
        MethodBinding[] var1 = this.type.methods();
        int var2 = var1.length;
        HashtableOfObject var10001 = new HashtableOfObject(var2 == 0 ? 1 : var2);
        this.field_370 = var10001;
        int var3 = var2;
        while (true) {
            --var3;
            if (var3 < 0) {
                return;
            }
            MethodBinding var4 = var1[var3];
            if (!var4.method_358() && !var4.method_360()) {
                MethodBinding[] var5 = (MethodBinding[])((MethodBinding[])this.field_370.method_3226(var4.selector));
                if (var5 == null) {
                    var5 = new MethodBinding[1];
                } else {
                    System.arraycopy(var5, 0, var5 = new MethodBinding[var5.length + 1], 0, var5.length - 1);
                }
                var5[var5.length - 1] = var4;
                this.field_370.put(var4.selector, var5);
            }
        }
    }

    MethodBinding computeSubstituteMethod(MethodBinding var1, MethodBinding var2) {
        return var1 == null ? null : (var2.parameters.length != var1.parameters.length ? null : var1);
    }

    boolean method_543(MethodBinding var1, MethodBinding var2) {
        if (!CharOperation.method_1364(var1.selector, var2.selector)) {
            return false;
        } else if (var1 != var2 && !var1.method_370() && !var2.method_370()) {
            if (var2.method_367()) {
                return false;
            } else if (var2.method_359() && var1.declaringClass.getPackage() != var2.declaringClass.getPackage()) {
                return false;
            } else {
                if (!var1.method_369()) {
                    if (var2.method_369()) {
                        return false;
                    }
                    if (var2.method_368() && !var1.method_368()) {
                        return false;
                    }
                }
                return true;
            }
        } else {
            return false;
        }
    }

    SimpleSet findSuperinterfaceCollisions(ReferenceBinding var1, ReferenceBinding[] var2) {
        return null;
    }

    int[] findOverriddenInheritedMethods(MethodBinding[] var1, int var2) {
        int[] var3 = null;
        int var4 = 0;
        ReferenceBinding var5 = var1[var4].declaringClass;
        if (!var5.method_157()) {
            ++var4;
            ReferenceBinding var6;
            for (var6 = var1[var4].declaringClass; var5 == var6; var6 = var1[var4].declaringClass) {
                ++var4;
                if (var4 == var2) {
                    return null;
                }
            }
            if (!var6.method_157()) {
                var3 = new int[var2];
                do {
                    var3[var4] = -1;
                    ++var4;
                    if (var4 == var2) {
                        return var3;
                    }
                    var6 = var1[var4].declaringClass;
                } while (!var6.method_157());
            }
        }
        for (; var4 < var2; ++var4) {
            if (var3 == null || var3[var4] != -1) {
                var5 = var1[var4].declaringClass;
                for (int var8 = var4 + 1; var8 < var2; ++var8) {
                    if (var3 == null || var3[var8] != -1) {
                        ReferenceBinding var7 = var1[var8].declaringClass;
                        if (var5 != var7) {
                            if (var5.implementsInterface(var7, true)) {
                                if (var3 == null) {
                                    var3 = new int[var2];
                                }
                                var3[var8] = -1;
                            } else if (var7.implementsInterface(var5, true)) {
                                if (var3 == null) {
                                    var3 = new int[var2];
                                }
                                var3[var4] = -1;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return var3;
    }

    boolean method_546(MethodBinding var1, MethodBinding var2) {
        return var2.modifiers == var1.modifiers ? true : (var1.method_369() ? true : (var2.method_369() ? false : (var1.method_368() ? true : (var2.method_368() ? false : !var1.method_367()))));
    }

    boolean isInterfaceMethodImplemented(MethodBinding var1, MethodBinding var2, ReferenceBinding var3) {
        return this.method_523(var2, var1) && var2.declaringClass.implementsInterface(var3, true);
    }

    boolean method_548(MethodBinding var1, MethodBinding var2) {
        return this.method_523(var1, var2);
    }

    boolean isSameClassOrSubclassOf(ReferenceBinding var1, ReferenceBinding var2) {
        do {
            if (var1 == var2) {
                return true;
            }
        } while ((var1 = var1.superclass()) != null);
        return false;
    }

    boolean mustImplementAbstractMethod(ReferenceBinding var1) {
        ReferenceBinding var2 = this.type.superclass();
        if (var1.method_151()) {
            while (var2.method_217() && var2 != var1) {
                var2 = var2.superclass();
            }
        } else {
            if (this.type.implementsInterface(var1, false)) {
                if (this.type.method_217()) {
                    return false;
                }
                if (!var2.implementsInterface(var1, true)) {
                    return true;
                }
            }
            while (var2.method_217() && !var2.implementsInterface(var1, false)) {
                var2 = var2.superclass();
            }
        }
        return var2.method_217();
    }

    boolean method_551() {
        return !this.type.method_157() && !this.type.method_217();
    }

    ProblemReporter problemReporter() {
        return this.type.scope.problemReporter();
    }

    ProblemReporter problemReporter(MethodBinding var1) {
        ProblemReporter var2 = this.problemReporter();
        if (var1.declaringClass == this.type && var1.sourceMethod() != null) {
            var2.referenceContext = var1.sourceMethod();
        }
        return var2;
    }

    boolean method_554(MethodBinding var1, MethodBinding var2) {
        this.problemReporter(var1).method_1608(var1, var2);
        return true;
    }

    ReferenceBinding[] resolvedExceptionTypesFor(MethodBinding var1) {
        ReferenceBinding[] var2 = var1.thrownExceptions;
        if ((var1.modifiers & 33554432) == 0) {
            return var2;
        } else if (!(var1.declaringClass instanceof BinaryTypeBinding)) {
            return Binding.field_151;
        } else {
            int var3 = var2.length;
            while (true) {
                --var3;
                if (var3 < 0) {
                    return var2;
                }
                var2[var3] = BinaryTypeBinding.method_267(var2[var3], this.environment, true);
            }
        }
    }

    void verify(SourceTypeBinding var1) {
        this.type = var1;
        this.method_541();
        this.method_539();
        this.checkMethods();
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer(10);
        var1.append("MethodVerifier for type: ");
        var1.append(this.type.readableName());
        var1.append('\n');
        var1.append("\t-inherited methods: ");
        var1.append(this.field_369);
        return var1.toString();
    }
}
