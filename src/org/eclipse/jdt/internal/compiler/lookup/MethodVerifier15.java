package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.ast.TypeParameter;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.BinaryTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.ParameterizedGenericMethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;
import org.eclipse.jdt.internal.compiler.lookup.MethodVerifier;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.util.SimpleSet;
import org.eclipse.jdt.internal.compiler.util.HashtableOfObject;

class MethodVerifier15 extends MethodVerifier {

    MethodVerifier15(LookupEnvironment var1) {
        super(var1);
    }

    boolean method_522(MethodBinding var1, MethodBinding var2) {
        var1 = var1.original();
        var2 = var2.original();
        TypeBinding var3 = var1.declaringClass.method_140(var2.declaringClass);
        if (!(var3 instanceof ReferenceBinding)) {
            return false;
        } else {
            if (var3 != var2.declaringClass) {
                MethodBinding[] var4 = ((ReferenceBinding)var3).getMethods(var2.selector);
                int var5 = 0;
                for (int var6 = var4.length; var5 < var6; ++var5) {
                    if (var4[var5].original() == var2) {
                        return this.method_548(var1, var4[var5]);
                    }
                }
            }
            return this.method_548(var1, var2);
        }
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
                int var6;
                if (var1.declaringClass.method_157()) {
                    for (var6 = 0; var6 < var5; ++var6) {
                        if (!this.areTypesEqual(var3[var6], var4[var6])) {
                            return false;
                        }
                    }
                    return true;
                } else {
                    var6 = 0;
                    while (true) {
                        if (var6 < var5) {
                            if (this.areTypesEqual(var3[var6], var4[var6])) {
                                ++var6;
                                continue;
                            }
                            if (!var3[var6].method_173().method_166() || var3[var6].method_136() != var4[var6].method_136() || !var3[var6].method_173().isEquivalentTo(var4[var6].method_173())) {
                                return false;
                            }
                            if (var1.typeVariables != Binding.NO_TYPE_VARIABLES) {
                                return false;
                            }
                            for (int var7 = 0; var7 < var6; ++var7) {
                                if (var3[var7].method_173().method_162()) {
                                    return false;
                                }
                            }
                        }
                        ++var6;
                        for (; var6 < var5; ++var6) {
                            if (!this.areTypesEqual(var3[var6], var4[var6])) {
                                if (!var3[var6].method_173().method_166() || var3[var6].method_136() != var4[var6].method_136() || !var3[var6].method_173().isEquivalentTo(var4[var6].method_173())) {
                                    return false;
                                }
                            } else if (var3[var6].method_173().method_162()) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
            }
        }
    }

    boolean method_524(MethodBinding var1, MethodBinding var2) {
        return var1.returnType == var2.returnType ? true : this.method_525(var1, var2);
    }

    boolean areTypesEqual(TypeBinding var1, TypeBinding var2) {
        return var1 == var2 ? true : (var1.method_162() && var2.method_162() ? var1.isEquivalentTo(var2) && var2.isEquivalentTo(var1) : false);
    }

    boolean canSkipInheritedMethods() {
        return this.type.superclass() != null && (this.type.superclass().method_217() || this.type.superclass().method_162()) ? false : this.type.superInterfaces() == Binding.field_155;
    }

    boolean method_528(MethodBinding var1, MethodBinding var2) {
        return var2 == null || var1.declaringClass == var2.declaringClass && !var1.declaringClass.method_162();
    }

    void checkConcreteInheritedMethod(MethodBinding var1, MethodBinding[] var2) {
        super.checkConcreteInheritedMethod(var1, var2);
        int var3 = 0;
        for (int var4 = var2.length; var3 < var4; ++var3) {
            MethodBinding var5 = var2[var3];
            if (var1.method_374() != var5.method_374()) {
                this.problemReporter().method_1820(var1, var5, this.type);
            }
            MethodBinding var6 = var5.original();
            if (var6.returnType != var1.returnType) {
                if (var5.returnType.method_173().method_162()) {
                    if (var1.returnType.method_173().method_166()) {
                        this.problemReporter().method_1805(var1, var6, this.type);
                    }
                } else if (var5.method_355() && var6.returnType.method_173().method_169() && ((TypeVariableBinding)var6.returnType.method_173()).declaringElement == var6) {
                    TypeBinding var7 = var1.returnType.method_173();
                    if (!var7.method_169() || ((TypeVariableBinding)var7).declaringElement != var1) {
                        this.problemReporter().method_1805(var1, var6, this.type);
                    }
                }
            }
            if (var6.declaringClass.method_157() && (var1.declaringClass == this.type.superclass && this.type.superclass.method_162() || this.type.superclass.erasure().method_140(var6.declaringClass) == null)) {
                this.type.method_303(var6, var1.original());
            }
        }
    }

    void checkForBridgeMethod(MethodBinding var1, MethodBinding var2, MethodBinding[] var3) {
        if (var1.method_374() != var2.method_374()) {
            this.problemReporter(var1).method_1820(var1, var2, this.type);
        }
        MethodBinding var4 = var2.original();
        if (var4.returnType != var1.returnType) {
            if (var2.returnType.method_173().method_162() && var1.returnType.method_173().method_166()) {
                this.problemReporter(var1).method_1805(var1, var4, this.type);
            } else if (var2.method_355() && var4.returnType.method_173().method_169() && ((TypeVariableBinding)var4.returnType.method_173()).declaringElement == var4) {
                TypeBinding var5 = var1.returnType.method_173();
                if (!var5.method_169() || ((TypeVariableBinding)var5).declaringElement != var1) {
                    this.problemReporter(var1).method_1805(var1, var4, this.type);
                }
            }
        }
        if (this.type.method_303(var4, var1.original()) != null) {
            int var9 = 0;
            for (int var6 = var3.length; var9 < var6; ++var9) {
                MethodBinding var7 = var3[var9];
                MethodBinding var8 = var7.original();
                if (var8 != var4 && var8 != var7 && !var2.method_344(var7) && (var7.declaringClass.erasure() == var2.declaringClass.erasure() || var7.declaringClass.method_140(var2.declaringClass) == null) && this.method_560(var4, var8)) {
                    return;
                }
            }
        }
    }

    void method_557(MethodBinding var1, MethodBinding var2) {
        if (!var1.declaringClass.method_157() && !var2.method_370()) {
            if (!this.method_561(var1, var2)) {
                TypeBinding[] var3 = var1.parameters;
                TypeBinding[] var4 = var2.parameters;
                int var5 = var3.length;
                if (var5 == var4.length) {
                    for (int var6 = 0; var6 < var5; ++var6) {
                        if (var3[var6] != var4[var6] && (var3[var6].method_148() != var4[var6].method_148() || !var4[var6].isCompatibleWith(var3[var6]))) {
                            return;
                        }
                    }
                    ReferenceBinding[] var16 = null;
                    int var7 = 0;
                    ReferenceBinding var8 = var2.declaringClass;
                    ReferenceBinding[] var9 = var8.superInterfaces();
                    if (var9 != Binding.field_155) {
                        var7 = var9.length;
                        var16 = var9;
                    }
                    int var12;
                    for (var8 = var8.superclass(); var8 != null && var8.isValidBinding(); var8 = var8.superclass()) {
                        MethodBinding[] var10 = var8.getMethods(var1.selector);
                        int var11 = 0;
                        for (var12 = var10.length; var11 < var12; ++var11) {
                            MethodBinding var13 = this.computeSubstituteMethod(var10[var11], var1);
                            if (var13 != null && !this.method_564(var1, var13) && this.method_561(var1, var13)) {
                                return;
                            }
                        }
                        if ((var9 = var8.superInterfaces()) != Binding.field_155) {
                            if (var16 == null) {
                                var16 = var9;
                                var7 = var9.length;
                            } else {
                                var11 = var9.length;
                                if (var7 + var11 >= var16.length) {
                                    System.arraycopy(var16, 0, var16 = new ReferenceBinding[var7 + var11 + 5], 0, var7);
                                }
                                label127:
                                for (var12 = 0; var12 < var11; ++var12) {
                                    ReferenceBinding var20 = var9[var12];
                                    for (int var14 = 0; var14 < var7; ++var14) {
                                        if (var20 == var16[var14]) {
                                            continue label127;
                                        }
                                    }
                                    var16[var7++] = var20;
                                }
                            }
                        }
                    }
                    for (int var17 = 0; var17 < var7; ++var17) {
                        var8 = var16[var17];
                        if (var8.isValidBinding()) {
                            MethodBinding[] var18 = var8.getMethods(var1.selector);
                            var12 = 0;
                            int var19;
                            for (var19 = var18.length; var12 < var19; ++var12) {
                                MethodBinding var22 = this.computeSubstituteMethod(var18[var12], var1);
                                if (var22 != null && !this.method_564(var1, var22) && this.method_561(var1, var22)) {
                                    return;
                                }
                            }
                            if ((var9 = var8.superInterfaces()) != Binding.field_155) {
                                var12 = var9.length;
                                if (var7 + var12 >= var16.length) {
                                    System.arraycopy(var16, 0, var16 = new ReferenceBinding[var7 + var12 + 5], 0, var7);
                                }
                                label97:
                                for (var19 = 0; var19 < var12; ++var19) {
                                    ReferenceBinding var21 = var9[var19];
                                    for (int var15 = 0; var15 < var7; ++var15) {
                                        if (var21 == var16[var15]) {
                                            continue label97;
                                        }
                                    }
                                    var16[var7++] = var21;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    void method_558(MethodBinding var1, MethodBinding var2) {
        if (var1.declaringClass.erasure() == var2.declaringClass.erasure()) {
            boolean var3 = var1.method_354() && var2.method_354() ? var1.method_344(var2) : var1.method_342(var2);
            if (var3) {
                this.problemReporter().method_1526(this.type, var1, var2);
                return;
            }
        } else if (var1.declaringClass.method_140(var2.declaringClass) != null) {
            return;
        }
        if (!var1.declaringClass.method_157() && !var1.method_370()) {
            this.method_560(var1.original(), var2.original());
        }
    }

    void checkInheritedMethods(MethodBinding[] var1, int var2) {
        int var3 = var2;
        int[] var4 = new int[var2];
        int var5 = 0;
        int var6;
        for (var6 = var2 - 1; var5 < var6; ++var5) {
            if (var4[var5] != -1) {
                MethodBinding var7 = var1[var5];
                MethodBinding[] var8 = null;
                int var9;
                MethodBinding var10;
                for (var9 = var5 + 1; var9 <= var6; ++var9) {
                    var10 = var1[var9];
                    if (var7.declaringClass == var10.declaringClass && this.method_522(var7, var10)) {
                        var4[var9] = -1;
                        if (var8 == null) {
                            var8 = new MethodBinding[var2];
                        }
                        var8[var9] = var10;
                    }
                }
                if (var8 != null) {
                    var9 = var7.method_356() ? 0 : 1;
                    var10 = var7;
                    int var11 = 0;
                    int var12;
                    for (var12 = var8.length; var11 < var12; ++var11) {
                        if (var8[var11] != null && !var8[var11].method_356()) {
                            var10 = var8[var11];
                            ++var9;
                        }
                    }
                    if (var9 != 1) {
                        var11 = 0;
                        for (var12 = var8.length; var11 < var12; ++var11) {
                            if (var8[var11] != null) {
                                this.problemReporter().method_1526(this.type, var7, var8[var11]);
                                --var3;
                                if (var10 == var8[var11]) {
                                    var1[var5] = null;
                                } else {
                                    var1[var11] = null;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (var3 < var2) {
            if (var3 == 1) {
                return;
            }
            MethodBinding[] var13 = new MethodBinding[var3];
            var6 = var2;
            while (true) {
                --var6;
                if (var6 < 0) {
                    var1 = var13;
                    var2 = var13.length;
                    break;
                }
                if (var1[var6] != null) {
                    --var3;
                    var13[var3] = var1[var6];
                }
            }
        }
        super.checkInheritedMethods(var1, var2);
    }

    boolean method_536(MethodBinding[] var1, int var2) {
        int[] var3 = null;
        int var4 = 0;
        int var5 = var1[0].method_356() ? var2 - 2 : 0;
        int var7;
        while (var4 <= var5) {
            MethodBinding var6 = var1[var4++];
            label89:
            for (var7 = var4; var7 < var2; ++var7) {
                if (!this.method_524(var6, var1[var7])) {
                    if (this.type.method_157()) {
                        int var8 = var2;
                        while (true) {
                            --var8;
                            if (var8 < 0) {
                                break;
                            }
                            if (var1[var8].declaringClass.id == 1) {
                                continue label89;
                            }
                        }
                    } else if ((var6.declaringClass.method_151() || !this.type.implementsInterface(var6.declaringClass, false)) && (var1[var7].declaringClass.method_151() || !this.type.implementsInterface(var1[var7].declaringClass, false))) {
                        continue;
                    }
                    if (this.method_565(var6, var1[var7])) {
                        this.problemReporter(var6).method_1805(var6, var1[var7], this.type);
                    } else {
                        if (var3 == null) {
                            var3 = new int[var2];
                        }
                        var3[var4 - 1] = -1;
                        var3[var7] = -1;
                    }
                }
            }
        }
        if (var3 == null) {
            return true;
        } else {
            var4 = 0;
            for (var5 = 0; var5 < var2; ++var5) {
                if (var3[var5] == -1) {
                    ++var4;
                }
            }
            if (var4 == var2) {
                this.problemReporter().inheritedMethodsHaveIncompatibleReturnTypes(this.type, var1, var2);
                return false;
            } else {
                MethodBinding[] var9 = new MethodBinding[var4];
                int var10 = 0;
                for (var7 = 0; var10 < var2; ++var10) {
                    if (var3[var10] == -1) {
                        var9[var7++] = var1[var10];
                    }
                }
                this.problemReporter().inheritedMethodsHaveIncompatibleReturnTypes(this.type, var9, var4);
                return false;
            }
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
                        byte[] var9 = new byte[var6.length];
                        int var10;
                        int var11;
                        MethodBinding var12;
                        int var13;
                        if (var5 != null) {
                            var10 = 0;
                            for (var11 = var5.length; var10 < var11; ++var10) {
                                var12 = var5[var10];
                                var13 = 0;
                                for (int var14 = var6.length; var13 < var14; ++var13) {
                                    MethodBinding var15 = this.computeSubstituteMethod(var6[var13], var12);
                                    if (var15 != null) {
                                        if (var9[var13] == 0 && this.method_564(var12, var15)) {
                                            ++var7;
                                            var8[var7] = var15;
                                            var9[var13] = 1;
                                        } else {
                                            this.method_557(var12, var15);
                                        }
                                    }
                                }
                                if (var7 >= 0) {
                                    this.checkAgainstInheritedMethods(var12, var8, var7 + 1, var6);
                                    while (var7 >= 0) {
                                        var8[var7--] = null;
                                    }
                                }
                            }
                        }
                        var10 = 0;
                        for (var11 = var6.length; var10 < var11; ++var10) {
                            if (var9[var10] != 1) {
                                var12 = var6[var10];
                                ++var7;
                                var8[var7] = var12;
                                for (var13 = var10 + 1; var13 < var11; ++var13) {
                                    MethodBinding var16 = var6[var13];
                                    if (var9[var13] != 1 && !this.method_528(var12, var16)) {
                                        var16 = this.computeSubstituteMethod(var16, var12);
                                        if (var16 != null) {
                                            if (var12.declaringClass != var16.declaringClass && this.method_564(var12, var16)) {
                                                ++var7;
                                                var8[var7] = var16;
                                                var9[var13] = 1;
                                            } else {
                                                this.method_558(var12, var16);
                                            }
                                        }
                                    }
                                }
                                if (var7 != -1) {
                                    if (var7 > 0) {
                                        this.checkInheritedMethods(var8, var7 + 1);
                                    } else if (var1 && var7 == 0 && var8[0].method_356()) {
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

    void checkTypeVariableMethods(TypeParameter var1) {
        char[][] var2 = this.field_369.keyTable;
        int var3 = var2.length;
        while (true) {
            --var3;
            if (var3 < 0) {
                return;
            }
            if (var2[var3] != null) {
                MethodBinding[] var4 = (MethodBinding[])((MethodBinding[])this.field_369.valueTable[var3]);
                if (var4.length != 1) {
                    int var5 = -1;
                    MethodBinding[] var6 = new MethodBinding[var4.length];
                    int var7 = 0;
                    for (int var8 = var4.length; var7 < var8; ++var7) {
                        while (var5 >= 0) {
                            var6[var5--] = null;
                        }
                        MethodBinding var9 = var4[var7];
                        if (var9 != null) {
                            ++var5;
                            var6[var5] = var9;
                            for (int var10 = var7 + 1; var10 < var8; ++var10) {
                                MethodBinding var11 = var4[var10];
                                if (!this.method_528(var9, var11)) {
                                    var11 = this.computeSubstituteMethod(var11, var9);
                                    if (var11 != null && this.method_564(var9, var11)) {
                                        ++var5;
                                        var6[var5] = var11;
                                        var4[var10] = null;
                                    }
                                }
                            }
                        }
                        if (var5 > 0) {
                            MethodBinding var12 = var6[0];
                            int var13 = var5 + 1;
                            do {
                                --var13;
                            } while (var13 > 0 && this.method_524(var12, var6[var13]));
                            if (var13 > 0) {
                                this.problemReporter().inheritedMethodsHaveIncompatibleReturnTypes(var1, var6, var5 + 1);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    MethodBinding computeSubstituteMethod(MethodBinding var1, MethodBinding var2) {
        if (var1 == null) {
            return null;
        } else if (var2.parameters.length != var1.parameters.length) {
            return null;
        } else {
            if (var2.declaringClass instanceof BinaryTypeBinding) {
                ((BinaryTypeBinding)var2.declaringClass).resolveTypesFor(var2);
            }
            if (var1.declaringClass instanceof BinaryTypeBinding) {
                ((BinaryTypeBinding)var1.declaringClass).resolveTypesFor(var1);
            }
            TypeVariableBinding[] var3 = var1.typeVariables;
            if (var3 == Binding.NO_TYPE_VARIABLES) {
                return var1;
            } else {
                int var4 = var3.length;
                TypeVariableBinding[] var5 = var2.typeVariables;
                int var6 = var5.length;
                if (var6 > 0 && var4 != var6) {
                    return var1;
                } else {
                    TypeBinding[] var7 = new TypeBinding[var4];
                    if (var4 <= var6) {
                        System.arraycopy(var5, 0, var7, 0, var4);
                    } else {
                        System.arraycopy(var5, 0, var7, 0, var6);
                        for (int var8 = var6; var8 < var4; ++var8) {
                            var7[var8] = var3[var8].method_261();
                        }
                    }
                    ParameterizedGenericMethodBinding var18 = this.environment.createParameterizedGenericMethod(var1, var7);
                    for (int var9 = 0; var9 < var4; ++var9) {
                        TypeVariableBinding var10 = var3[var9];
                        TypeBinding var11 = var7[var9];
                        if (var11 instanceof TypeVariableBinding) {
                            TypeVariableBinding var12 = (TypeVariableBinding)var11;
                            if (var12.firstBound == var10.firstBound) {
                                if (var12.firstBound == null) {
                                    continue;
                                }
                            } else if (var12.firstBound != null && var10.firstBound != null && var12.firstBound.method_151() != var10.firstBound.method_151()) {
                                return var1;
                            }
                            if (Scope.substitute(var18, var10.superclass) != var12.superclass) {
                                return var1;
                            }
                            int var13 = var10.superInterfaces.length;
                            ReferenceBinding[] var14 = var12.superInterfaces;
                            if (var13 != var14.length) {
                                return var1;
                            }
                            int var15 = 0;
                            label76:
                            while (var15 < var13) {
                                TypeBinding var16 = Scope.substitute(var18, var10.superInterfaces[var15]);
                                for (int var17 = 0; var17 < var13; ++var17) {
                                    if (var16 == var14[var17]) {
                                        ++var15;
                                        continue label76;
                                    }
                                }
                                return var1;
                            }
                        } else if (var10.boundCheck(var18, var11) != 0) {
                            return var1;
                        }
                    }
                    return var18;
                }
            }
        }
    }

    boolean method_560(MethodBinding var1, MethodBinding var2) {
        if (var1.method_342(var2) && var1.returnType.erasure() == var2.returnType.erasure()) {
            this.problemReporter().method_1617(this.type, var1, var2);
            return true;
        } else {
            return false;
        }
    }

    boolean method_561(MethodBinding var1, MethodBinding var2) {
        MethodBinding var3 = var2.original();
        if (var1.method_342(var3) && var1.returnType.erasure() == var3.returnType.erasure()) {
            this.problemReporter(var1).method_1671(var1, var2.declaringClass.method_166() ? var2 : var3);
            return true;
        } else {
            return false;
        }
    }

    public boolean method_562(MethodBinding var1, MethodBinding var2) {
        return this.method_543(var1, var2) && this.method_522(var1, var2);
    }

    boolean hasGenericParameter(MethodBinding var1) {
        if (var1.method_351() == null) {
            return false;
        } else {
            TypeBinding[] var2 = var1.parameters;
            int var3 = 0;
            for (int var4 = var2.length; var3 < var4; ++var3) {
                TypeBinding var5 = var2[var3].method_173();
                if (var5 instanceof ReferenceBinding) {
                    int var6 = ((ReferenceBinding)var5).modifiers;
                    if ((var6 & 1073741824) != 0) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    SimpleSet findSuperinterfaceCollisions(ReferenceBinding var1, ReferenceBinding[] var2) {
        ReferenceBinding[] var3 = null;
        int var4 = 0;
        if (var2 != Binding.field_155) {
            var4 = var2.length;
            var3 = var2;
        }
        boolean var6 = this.type.method_156();
        ReferenceBinding[] var5;
        ReferenceBinding var7;
        int var8;
        int var9;
        ReferenceBinding var10;
        for (var7 = var1; var7 != null && var7.isValidBinding(); var7 = var7.superclass()) {
            var6 |= var7.method_156();
            if ((var5 = var7.superInterfaces()) != Binding.field_155) {
                if (var3 == null) {
                    var3 = var5;
                    var4 = var5.length;
                } else {
                    var8 = var5.length;
                    if (var4 + var8 >= var3.length) {
                        System.arraycopy(var3, 0, var3 = new ReferenceBinding[var4 + var8 + 5], 0, var4);
                    }
                    label112:
                    for (var9 = 0; var9 < var8; ++var9) {
                        var10 = var5[var9];
                        for (int var11 = 0; var11 < var4; ++var11) {
                            if (var10 == var3[var11]) {
                                continue label112;
                            }
                        }
                        var3[var4++] = var10;
                    }
                }
            }
        }
        int var12;
        for (var8 = 0; var8 < var4; ++var8) {
            var7 = var3[var8];
            if (var7.isValidBinding()) {
                var6 |= var7.method_156();
                if ((var5 = var7.superInterfaces()) != Binding.field_155) {
                    var9 = var5.length;
                    if (var4 + var9 >= var3.length) {
                        System.arraycopy(var3, 0, var3 = new ReferenceBinding[var4 + var9 + 5], 0, var4);
                    }
                    int var15 = 0;
                    while (var15 < var9) {
                        ReferenceBinding var16 = var5[var15];
                        var12 = 0;
                        while (true) {
                            if (var12 < var4) {
                                if (var16 != var3[var12]) {
                                    ++var12;
                                    continue;
                                }
                            } else {
                                var3[var4++] = var16;
                            }
                            ++var15;
                            break;
                        }
                    }
                }
            }
        }
        if (!var6) {
            return null;
        } else {
            SimpleSet var14 = null;
            for (var9 = 0; var9 < var4; ++var9) {
                var10 = var3[var9];
                if (var10.isValidBinding()) {
                    TypeBinding var17 = var10.erasure();
                    for (var12 = var9 + 1; var12 < var4; ++var12) {
                        ReferenceBinding var13 = var3[var12];
                        if (var13.isValidBinding() && var13.erasure() == var17) {
                            if (var14 == null) {
                                SimpleSet var10000 = new SimpleSet(var4);
                                var14 = var10000;
                            }
                            var14.method_1335(var3[var9]);
                            var14.method_1335(var3[var12]);
                        }
                    }
                }
            }
            return var14;
        }
    }

    boolean isInterfaceMethodImplemented(MethodBinding var1, MethodBinding var2, ReferenceBinding var3) {
        if (var1.original() != var1 && var2.declaringClass.method_157()) {
            return false;
        } else {
            var1 = this.computeSubstituteMethod(var1, var2);
            return var1 != null && var1.returnType == var2.returnType && this.method_562(var2, var1);
        }
    }

    boolean method_548(MethodBinding var1, MethodBinding var2) {
        MethodBinding var3 = this.computeSubstituteMethod(var2, var1);
        return var3 != null && this.method_564(var1, var3);
    }

    boolean method_564(MethodBinding var1, MethodBinding var2) {
        return !this.method_523(var1, var2) ? (var2.method_354() && var1.method_342(var2) ? var1.typeVariables == Binding.NO_TYPE_VARIABLES && !this.hasGenericParameter(var1) : false) : (!(var2 instanceof ParameterizedGenericMethodBinding) ? var1.typeVariables == Binding.NO_TYPE_VARIABLES : !this.hasGenericParameter(var1) || var1.typeVariables != Binding.NO_TYPE_VARIABLES);
    }

    boolean method_565(MethodBinding var1, MethodBinding var2) {
        if (var1.returnType == var2.returnType.erasure()) {
            TypeBinding[] var3 = var1.parameters;
            TypeBinding[] var4 = var2.parameters;
            int var5 = 0;
            for (int var6 = var3.length; var5 < var6; ++var5) {
                if (!this.areTypesEqual(var3[var5], var4[var5])) {
                    return true;
                }
            }
        }
        return var1.typeVariables == Binding.NO_TYPE_VARIABLES && var2.original().typeVariables != Binding.NO_TYPE_VARIABLES && var1.returnType.erasure().method_140(var2.returnType.erasure()) != null;
    }

    boolean method_554(MethodBinding var1, MethodBinding var2) {
        if (this.method_565(var1, var2)) {
            this.problemReporter(var1).method_1805(var1, var2, this.type);
            return false;
        } else {
            return super.method_554(var1, var2);
        }
    }

    void verify(SourceTypeBinding var1) {
        if (var1.method_145()) {
            var1.method_200();
        }
        super.verify(var1);
        int var2 = var1.typeVariables.length;
        while (true) {
            --var2;
            if (var2 < 0) {
                return;
            }
            TypeVariableBinding var3 = var1.typeVariables[var2];
            if (var3.superInterfaces != Binding.field_155 && (var3.superInterfaces.length != 1 || var3.superclass.id != 1)) {
                HashtableOfObject var10001 = new HashtableOfObject(0);
                this.field_370 = var10001;
                ReferenceBinding var4 = var3.superclass();
                if (var4.kind() == 4100) {
                    var4 = (ReferenceBinding)var4.erasure();
                }
                ReferenceBinding[] var5 = var3.superInterfaces();
                ReferenceBinding[] var6 = new ReferenceBinding[var5.length];
                int var7 = var5.length;
                while (true) {
                    --var7;
                    if (var7 < 0) {
                        this.method_540(var4, var6);
                        this.checkTypeVariableMethods(var1.scope.referenceContext.typeParameters[var2]);
                        break;
                    }
                    var6[var7] = var5[var7].kind() == 4100 ? (ReferenceBinding)var5[var7].erasure() : var5[var7];
                }
            }
        }
    }
}
