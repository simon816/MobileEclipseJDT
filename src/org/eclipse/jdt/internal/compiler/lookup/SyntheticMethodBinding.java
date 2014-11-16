package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;

public class SyntheticMethodBinding extends MethodBinding {

    public FieldBinding field_283;

    public FieldBinding field_284;

    public MethodBinding targetMethod;

    public TypeBinding targetEnumType;

    public int field_287;

    public int field_288;

    public int field_289;

    public SyntheticMethodBinding(FieldBinding var1, boolean var2, ReferenceBinding var3) {
        this.field_288 = 0;
        this.modifiers = 4104;
        this.tagBits |= 25769803776L;
        SourceTypeBinding var4 = (SourceTypeBinding)var3;
        SyntheticMethodBinding[] var5 = var4.syntheticMethods();
        int var6 = var5 == null ? 0 : var5.length;
        this.field_289 = var6;
        this.selector = CharOperation.concat(TypeConstants.field_143, String.valueOf(var6).toCharArray());
        if (var2) {
            this.returnType = var1.type;
            if (var1.method_431()) {
                this.parameters = Binding.field_150;
            } else {
                this.parameters = new TypeBinding[1];
                this.parameters[0] = var4;
            }
            this.field_283 = var1;
            this.field_287 = 1;
        } else {
            this.returnType = TypeBinding.field_188;
            if (var1.method_431()) {
                this.parameters = new TypeBinding[1];
                this.parameters[0] = var1.type;
            } else {
                this.parameters = new TypeBinding[2];
                this.parameters[0] = var4;
                this.parameters[1] = var1.type;
            }
            this.field_284 = var1;
            this.field_287 = 2;
        }
        this.thrownExceptions = Binding.field_151;
        this.declaringClass = var4;
        boolean var7;
        do {
            label99: {
                var7 = false;
                MethodBinding[] var10 = var4.methods();
                long var8;
                int var11;
                int var12;
                if ((var8 = ReferenceBinding.binarySearch(this.selector, var10)) >= 0L) {
                    var11 = this.parameters.length;
                    var12 = (int)var8;
                    label90:
                    for (int var13 = (int)(var8 >> 32); var12 <= var13; ++var12) {
                        MethodBinding var14 = var10[var12];
                        if (var14.parameters.length == var11) {
                            TypeBinding[] var15 = var14.parameters;
                            for (int var16 = 0; var16 < var11; ++var16) {
                                if (var15[var16] != this.parameters[var16]) {
                                    continue label90;
                                }
                            }
                            var7 = true;
                            break label99;
                        }
                    }
                }
                if (var5 != null) {
                    var11 = 0;
                    for (var12 = var5.length; var11 < var12; ++var11) {
                        if (var5[var11] != null && CharOperation.method_1364(this.selector, var5[var11].selector) && this.method_344(var10[var11])) {
                            var7 = true;
                            break;
                        }
                    }
                }
            }
            if (var7) {
                ++var6;
                this.setSelector(CharOperation.concat(TypeConstants.field_143, String.valueOf(var6).toCharArray()));
            }
        } while (var7);
        FieldDeclaration[] var17 = var4.scope.referenceContext.fields;
        if (var17 != null) {
            int var9 = 0;
            for (int var18 = var17.length; var9 < var18; ++var9) {
                if (var17[var9].binding == var1) {
                    this.field_288 = var17[var9].field_444;
                    return;
                }
            }
        }
        this.field_288 = var4.scope.referenceContext.field_444;
    }

    public SyntheticMethodBinding(FieldBinding var1, ReferenceBinding var2, TypeBinding var3, char[] var4) {
        this.field_288 = 0;
        this.modifiers = 4104;
        this.tagBits |= 25769803776L;
        SourceTypeBinding var5 = (SourceTypeBinding)var2;
        SyntheticMethodBinding[] var6 = var5.syntheticMethods();
        int var7 = var6 == null ? 0 : var6.length;
        this.field_289 = var7;
        this.selector = var4;
        this.returnType = var5.scope.createArrayType(TypeBinding.field_179, 1);
        this.parameters = Binding.field_150;
        this.field_283 = var1;
        this.targetEnumType = var3;
        this.field_287 = 9;
        this.thrownExceptions = Binding.field_151;
        this.declaringClass = var5;
        if (var5.method_227()) {
            this.modifiers |= 2048;
        }
        boolean var8;
        do {
            label71: {
                var8 = false;
                MethodBinding[] var11 = var5.methods();
                long var9;
                int var12;
                int var13;
                if ((var9 = ReferenceBinding.binarySearch(this.selector, var11)) >= 0L) {
                    var12 = this.parameters.length;
                    var13 = (int)var9;
                    label62:
                    for (int var14 = (int)(var9 >> 32); var13 <= var14; ++var13) {
                        MethodBinding var15 = var11[var13];
                        if (var15.parameters.length == var12) {
                            TypeBinding[] var16 = var15.parameters;
                            for (int var17 = 0; var17 < var12; ++var17) {
                                if (var16[var17] != this.parameters[var17]) {
                                    continue label62;
                                }
                            }
                            var8 = true;
                            break label71;
                        }
                    }
                }
                if (var6 != null) {
                    var12 = 0;
                    for (var13 = var6.length; var12 < var13; ++var12) {
                        if (var6[var12] != null && CharOperation.method_1364(this.selector, var6[var12].selector) && this.method_344(var11[var12])) {
                            var8 = true;
                            break;
                        }
                    }
                }
            }
            if (var8) {
                ++var7;
                this.setSelector(CharOperation.concat(var4, String.valueOf(var7).toCharArray()));
            }
        } while (var8);
        this.field_288 = var5.scope.referenceContext.field_444;
    }

    public SyntheticMethodBinding(MethodBinding var1, boolean var2, ReferenceBinding var3) {
        this.field_288 = 0;
        if (var1.method_358()) {
            this.initializeConstructorAccessor(var1);
        } else {
            this.initializeMethodAccessor(var1, var2, var3);
        }
    }

    public SyntheticMethodBinding(MethodBinding var1, MethodBinding var2, SourceTypeBinding var3) {
        this.field_288 = 0;
        this.declaringClass = var3;
        this.selector = var1.selector;
        this.modifiers = (var2.modifiers | 64 | 4096) & -1073743121;
        this.tagBits |= 25769803776L;
        this.returnType = var1.returnType;
        this.parameters = var1.parameters;
        this.thrownExceptions = var1.thrownExceptions;
        this.targetMethod = var2;
        this.field_287 = 6;
        SyntheticMethodBinding[] var4 = var3.syntheticMethods();
        int var5 = var4 == null ? 0 : var4.length;
        this.field_289 = var5;
    }

    public SyntheticMethodBinding(SourceTypeBinding var1, char[] var2) {
        this.field_288 = 0;
        this.declaringClass = var1;
        this.selector = var2;
        this.modifiers = 9;
        this.tagBits |= 25769803776L;
        LookupEnvironment var3 = var1.scope.environment();
        this.thrownExceptions = Binding.field_151;
        if (var2 == TypeConstants.field_71) {
            this.returnType = var3.createArrayType(var3.convertToParameterizedType(var1), 1);
            this.parameters = Binding.field_150;
            this.field_287 = 7;
        } else if (var2 == TypeConstants.field_72) {
            this.returnType = var3.convertToParameterizedType(var1);
            this.parameters = new TypeBinding[] {var1.scope.method_610()};
            this.field_287 = 8;
        }
        SyntheticMethodBinding[] var4 = ((SourceTypeBinding)this.declaringClass).syntheticMethods();
        int var5 = var4 == null ? 0 : var4.length;
        this.field_289 = var5;
        if (var1.method_227()) {
            this.modifiers |= 2048;
        }
    }

    public void initializeConstructorAccessor(MethodBinding var1) {
        this.targetMethod = var1;
        this.modifiers = 4096;
        this.tagBits |= 25769803776L;
        SourceTypeBinding var2 = (SourceTypeBinding)var1.declaringClass;
        SyntheticMethodBinding[] var3 = var2.syntheticMethods();
        this.field_289 = var3 == null ? 0 : var3.length;
        this.selector = var1.selector;
        this.returnType = var1.returnType;
        this.field_287 = 4;
        this.parameters = new TypeBinding[var1.parameters.length + 1];
        System.arraycopy(var1.parameters, 0, this.parameters, 0, var1.parameters.length);
        this.parameters[var1.parameters.length] = var1.declaringClass;
        this.thrownExceptions = var1.thrownExceptions;
        this.declaringClass = var2;
        while (true) {
            boolean var4 = false;
            MethodBinding[] var5 = var2.methods();
            int var6 = 0;
            int var7 = var5.length;
            while (true) {
                if (var6 < var7) {
                    if (!CharOperation.method_1364(this.selector, var5[var6].selector) || !this.method_344(var5[var6])) {
                        ++var6;
                        continue;
                    }
                    var4 = true;
                } else if (var3 != null) {
                    var6 = 0;
                    for (var7 = var3.length; var6 < var7; ++var6) {
                        if (var3[var6] != null && CharOperation.method_1364(this.selector, var3[var6].selector) && this.method_344(var3[var6])) {
                            var4 = true;
                            break;
                        }
                    }
                }
                if (var4) {
                    int var8 = this.parameters.length;
                    System.arraycopy(this.parameters, 0, this.parameters = new TypeBinding[var8 + 1], 0, var8);
                    this.parameters[var8] = this.declaringClass;
                }
                if (!var4) {
                    AbstractMethodDeclaration[] var9 = var2.scope.referenceContext.methods;
                    if (var9 != null) {
                        var6 = 0;
                        for (var7 = var9.length; var6 < var7; ++var6) {
                            if (var9[var6].binding == var1) {
                                this.field_288 = var9[var6].field_444;
                                return;
                            }
                        }
                    }
                    return;
                }
                break;
            }
        }
    }

    public void initializeMethodAccessor(MethodBinding var1, boolean var2, ReferenceBinding var3) {
        this.targetMethod = var1;
        this.modifiers = 4104;
        this.tagBits |= 25769803776L;
        SourceTypeBinding var4 = (SourceTypeBinding)var3;
        SyntheticMethodBinding[] var5 = var4.syntheticMethods();
        int var6 = var5 == null ? 0 : var5.length;
        this.field_289 = var6;
        this.selector = CharOperation.concat(TypeConstants.field_143, String.valueOf(var6).toCharArray());
        this.returnType = var1.returnType;
        this.field_287 = var2 ? 5 : 3;
        if (var1.method_370()) {
            this.parameters = var1.parameters;
        } else {
            this.parameters = new TypeBinding[var1.parameters.length + 1];
            this.parameters[0] = var4;
            System.arraycopy(var1.parameters, 0, this.parameters, 1, var1.parameters.length);
        }
        this.thrownExceptions = var1.thrownExceptions;
        this.declaringClass = var4;
        while (true) {
            boolean var7 = false;
            MethodBinding[] var8 = var4.methods();
            int var9 = 0;
            int var10 = var8.length;
            while (true) {
                if (var9 < var10) {
                    if (!CharOperation.method_1364(this.selector, var8[var9].selector) || !this.method_344(var8[var9])) {
                        ++var9;
                        continue;
                    }
                    var7 = true;
                } else if (var5 != null) {
                    var9 = 0;
                    for (var10 = var5.length; var9 < var10; ++var9) {
                        if (var5[var9] != null && CharOperation.method_1364(this.selector, var5[var9].selector) && this.method_344(var5[var9])) {
                            var7 = true;
                            break;
                        }
                    }
                }
                if (var7) {
                    ++var6;
                    this.setSelector(CharOperation.concat(TypeConstants.field_143, String.valueOf(var6).toCharArray()));
                }
                if (!var7) {
                    AbstractMethodDeclaration[] var11 = var4.scope.referenceContext.methods;
                    if (var11 != null) {
                        var9 = 0;
                        for (var10 = var11.length; var9 < var10; ++var9) {
                            if (var11[var9].binding == var1) {
                                this.field_288 = var11[var9].field_444;
                                return;
                            }
                        }
                    }
                    return;
                }
                break;
            }
        }
    }
}
