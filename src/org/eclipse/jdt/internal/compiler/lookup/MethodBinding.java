package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ClassFile;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.codegen.ConstantPool;
import org.eclipse.jdt.internal.compiler.lookup.InvocationSite;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.AnnotationHolder;
import org.eclipse.jdt.internal.compiler.lookup.AnnotationBinding;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.PackageBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ArrayBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.SyntheticMethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.ParameterizedGenericMethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.SyntheticArgumentBinding;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;

import java.util.List;

public class MethodBinding extends Binding {

    public int modifiers;

    public char[] selector;

    public TypeBinding returnType;

    public TypeBinding[] parameters;

    public ReferenceBinding[] thrownExceptions;

    public ReferenceBinding declaringClass;

    public TypeVariableBinding[] typeVariables;

    char[] signature;

    public long tagBits;

    protected MethodBinding() {
        this.typeVariables = Binding.NO_TYPE_VARIABLES;
    }

    public MethodBinding(int var1, char[] var2, TypeBinding var3, TypeBinding[] var4, ReferenceBinding[] var5, ReferenceBinding var6) {
        this.typeVariables = Binding.NO_TYPE_VARIABLES;
        this.modifiers = var1;
        this.selector = var2;
        this.returnType = var3;
        this.parameters = var4 != null && var4.length != 0 ? var4 : Binding.field_150;
        this.thrownExceptions = var5 != null && var5.length != 0 ? var5 : Binding.field_151;
        this.declaringClass = var6;
        if (this.declaringClass != null && this.declaringClass.method_227() && !this.method_365() && !this.method_356()) {
            this.modifiers |= 2048;
        }
    }

    public MethodBinding(int var1, TypeBinding[] var2, ReferenceBinding[] var3, ReferenceBinding var4) {
        this(var1, TypeConstants.field_135, TypeBinding.field_188, var2, var3, var4);
    }

    public MethodBinding(MethodBinding var1, ReferenceBinding var2) {
        this.typeVariables = Binding.NO_TYPE_VARIABLES;
        this.modifiers = var1.modifiers;
        this.selector = var1.selector;
        this.returnType = var1.returnType;
        this.parameters = var1.parameters;
        this.thrownExceptions = var1.thrownExceptions;
        this.declaringClass = var2;
        var2.storeAnnotationHolder(this, var1.declaringClass.retrieveAnnotationHolder(var1, true));
    }

    public final boolean method_342(MethodBinding var1) {
        TypeBinding[] var2 = var1.parameters;
        if (this.parameters == var2) {
            return true;
        } else {
            int var3 = this.parameters.length;
            if (var3 != var2.length) {
                return false;
            } else {
                for (int var4 = 0; var4 < var3; ++var4) {
                    if (this.parameters[var4] != var2[var4] && this.parameters[var4].erasure() != var2[var4].erasure()) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    public final boolean areParametersCompatibleWith(TypeBinding[] var1) {
        int var2 = this.parameters.length;
        int var3 = var1.length;
        int var4 = var3;
        if (this.method_374()) {
            var4 = var2 - 1;
            TypeBinding var5;
            if (var2 == var3) {
                var5 = this.parameters[var4];
                TypeBinding var6 = var1[var4];
                if (var5 != var6 && !var6.isCompatibleWith(var5)) {
                    return false;
                }
            } else if (var2 < var3) {
                var5 = ((ArrayBinding)this.parameters[var4]).method_187();
                for (int var8 = var4; var8 < var3; ++var8) {
                    if (var5 != var1[var8] && !var1[var8].isCompatibleWith(var5)) {
                        return false;
                    }
                }
            } else if (var4 != var3) {
                return false;
            }
        }
        for (int var7 = 0; var7 < var4; ++var7) {
            if (this.parameters[var7] != var1[var7] && !var1[var7].isCompatibleWith(this.parameters[var7])) {
                return false;
            }
        }
        return true;
    }

    public final boolean method_344(MethodBinding var1) {
        TypeBinding[] var2 = var1.parameters;
        if (this.parameters == var2) {
            return true;
        } else {
            int var3 = this.parameters.length;
            if (var3 != var2.length) {
                return false;
            } else {
                for (int var4 = 0; var4 < var3; ++var4) {
                    if (this.parameters[var4] != var2[var4]) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    public final boolean canBeSeenBy(InvocationSite var1, Scope var2) {
        if (this.method_369()) {
            return true;
        } else {
            SourceTypeBinding var3 = var2.enclosingSourceType();
            if (var3 == this.declaringClass) {
                return true;
            } else if (this.method_368()) {
                return var3.fPackage == this.declaringClass.fPackage ? true : var1.isSuperAccess();
            } else if (!this.method_367()) {
                return var3.fPackage == this.declaringClass.fPackage;
            } else {
                Object var4 = var3;
                ReferenceBinding var5;
                for (var5 = var3.enclosingType(); var5 != null; var5 = var5.enclosingType()) {
                    var4 = var5;
                }
                ReferenceBinding var6 = (ReferenceBinding)this.declaringClass.erasure();
                for (var5 = var6.enclosingType(); var5 != null; var5 = var5.enclosingType()) {
                    var6 = var5;
                }
                return var4 == var6;
            }
        }
    }

    public final boolean canBeSeenBy(PackageBinding var1) {
        return this.method_369() ? true : (this.method_367() ? false : var1 == this.declaringClass.getPackage());
    }

    public final boolean canBeSeenBy(TypeBinding var1, InvocationSite var2, Scope var3) {
        if (this.method_369()) {
            return true;
        } else {
            SourceTypeBinding var4 = var3.enclosingSourceType();
            if (var4 == this.declaringClass && var4 == var1) {
                return true;
            } else if (var4 == null) {
                return !this.method_367() && var3.getCurrentPackage() == this.declaringClass.fPackage;
            } else {
                Object var5;
                ReferenceBinding var7;
                if (this.method_368()) {
                    if (var4 == this.declaringClass) {
                        return true;
                    } else if (var4.fPackage == this.declaringClass.fPackage) {
                        return true;
                    } else {
                        var5 = var4;
                        TypeBinding var10 = var1.erasure();
                        var7 = (ReferenceBinding)this.declaringClass.erasure();
                        int var8 = 0;
                        do {
                            if (((ReferenceBinding)var5).method_140(var7) != null) {
                                if (var2.isSuperAccess()) {
                                    return true;
                                }
                                if (var1 instanceof ArrayBinding) {
                                    return false;
                                }
                                if (this.method_370()) {
                                    if (var8 > 0) {
                                        var2.method_2(var8);
                                    }
                                    return true;
                                }
                                if (var5 == var10 || var10.method_140((TypeBinding)var5) != null) {
                                    if (var8 > 0) {
                                        var2.method_2(var8);
                                    }
                                    return true;
                                }
                            }
                            ++var8;
                            var5 = ((ReferenceBinding)var5).enclosingType();
                        } while (var5 != null);
                        return false;
                    }
                } else {
                    ReferenceBinding var6;
                    if (!this.method_367()) {
                        PackageBinding var9 = this.declaringClass.fPackage;
                        if (var4.fPackage != var9) {
                            return false;
                        } else if (var1 instanceof ArrayBinding) {
                            return false;
                        } else {
                            var6 = (ReferenceBinding)var1;
                            do {
                                if (this.declaringClass == var6) {
                                    return true;
                                }
                                PackageBinding var11 = var6.fPackage;
                                if (var11 != null && var11 != var9) {
                                    return false;
                                }
                            } while ((var6 = var6.superclass()) != null);
                            return false;
                        }
                    } else if (var1 != this.declaringClass && (!var1.method_169() || !((TypeVariableBinding)var1).isErasureBoundTo(this.declaringClass.erasure()))) {
                        return false;
                    } else {
                        if (var4 != this.declaringClass) {
                            var5 = var4;
                            for (var6 = var4.enclosingType(); var6 != null; var6 = var6.enclosingType()) {
                                var5 = var6;
                            }
                            var7 = (ReferenceBinding)this.declaringClass.erasure();
                            for (var6 = var7.enclosingType(); var6 != null; var6 = var6.enclosingType()) {
                                var7 = var6;
                            }
                            if (var5 != var7) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
            }
        }
    }

    public List method_348(List var1) {
        if ((this.tagBits & 128L) != 0L) {
            var1 = this.returnType.method_132(var1);
            int var2 = 0;
            int var3;
            for (var3 = this.parameters.length; var2 < var3; ++var2) {
                var1 = this.parameters[var2].method_132(var1);
            }
            var2 = 0;
            for (var3 = this.thrownExceptions.length; var2 < var3; ++var2) {
                var1 = this.thrownExceptions[var2].method_132(var1);
            }
            var2 = 0;
            for (var3 = this.typeVariables.length; var2 < var3; ++var2) {
                TypeVariableBinding var4 = this.typeVariables[var2];
                var1 = var4.superclass().method_132(var1);
                ReferenceBinding[] var5 = var4.superInterfaces();
                int var6 = 0;
                for (int var7 = var5.length; var6 < var7; ++var6) {
                    var1 = var5[var2].method_132(var1);
                }
            }
        }
        return var1;
    }

    MethodBinding computeSubstitutedMethod(MethodBinding var1, LookupEnvironment var2) {
        int var3 = this.typeVariables.length;
        TypeVariableBinding[] var4 = var1.typeVariables;
        if (var3 != var4.length) {
            return null;
        } else {
            ParameterizedGenericMethodBinding var5 = var2.createParameterizedGenericMethod(var1, this.typeVariables);
            for (int var6 = 0; var6 < var3; ++var6) {
                if (!this.typeVariables[var6].isInterchangeableWith(var4[var6], var5)) {
                    return null;
                }
            }
            return var5;
        }
    }

    public TypeBinding method_350() {
        return this.declaringClass;
    }

    public char[] method_351() {
        if ((this.modifiers & 1073741824) == 0) {
            return null;
        } else {
            StringBuffer var1 = new StringBuffer(10);
            int var2;
            int var3;
            if (this.typeVariables != Binding.NO_TYPE_VARIABLES) {
                var1.append('<');
                var2 = 0;
                for (var3 = this.typeVariables.length; var2 < var3; ++var2) {
                    var1.append(this.typeVariables[var2].method_256());
                }
                var1.append('>');
            }
            var1.append('(');
            var2 = 0;
            for (var3 = this.parameters.length; var2 < var3; ++var2) {
                var1.append(this.parameters[var2].genericTypeSignature());
            }
            var1.append(')');
            if (this.returnType != null) {
                var1.append(this.returnType.genericTypeSignature());
            }
            boolean var6 = false;
            var3 = this.thrownExceptions.length;
            int var4;
            for (var4 = 0; var4 < var3; ++var4) {
                if ((this.thrownExceptions[var4].modifiers & 1073741824) != 0) {
                    var6 = true;
                    break;
                }
            }
            if (var6) {
                for (var4 = 0; var4 < var3; ++var4) {
                    var1.append('^');
                    var1.append(this.thrownExceptions[var4].genericTypeSignature());
                }
            }
            var4 = var1.length();
            char[] var5 = new char[var4];
            var1.getChars(0, var4, var5, 0);
            return var5;
        }
    }

    public final int method_352() {
        return this.modifiers & '\uffff';
    }

    public long getAnnotationTagBits() {
        MethodBinding var1 = this.original();
        if ((var1.tagBits & 8589934592L) == 0L && var1.declaringClass instanceof SourceTypeBinding) {
            ClassScope var2 = ((SourceTypeBinding)var1.declaringClass).scope;
            if (var2 != null) {
                TypeDeclaration var3 = var2.referenceContext;
                AbstractMethodDeclaration var4 = var3.declarationOf(var1);
                if (var4 != null) {
                    ASTNode.method_761(var4.scope, var4.annotations, var1);
                }
            }
        }
        return var1.tagBits;
    }

    public TypeVariableBinding getTypeVariable(char[] var1) {
        int var2 = this.typeVariables.length;
        do {
            --var2;
            if (var2 < 0) {
                return null;
            }
        } while (!CharOperation.method_1364(this.typeVariables[var2].sourceName, var1));
        return this.typeVariables[var2];
    }

    public boolean method_354() {
        return false;
    }

    public boolean method_355() {
        return false;
    }

    public final boolean method_356() {
        return (this.modifiers & 1024) != 0;
    }

    public final boolean method_357() {
        return (this.modifiers & 64) != 0;
    }

    public final boolean method_358() {
        return this.selector == TypeConstants.field_135;
    }

    public final boolean method_359() {
        return !this.method_369() && !this.method_368() && !this.method_367();
    }

    public final boolean method_360() {
        return (this.modifiers & 524288) != 0;
    }

    public final boolean method_361() {
        return (this.modifiers & 1048576) != 0;
    }

    public final boolean method_362() {
        return (this.modifiers & 16) != 0;
    }

    public final boolean method_363() {
        return (this.modifiers & 536870912) != 0;
    }

    public final boolean method_364() {
        if (this.selector.length == 4 && CharOperation.method_1364(this.selector, TypeConstants.field_36) && (this.modifiers & 9) != 0 && TypeBinding.field_188 == this.returnType && this.parameters.length == 1) {
            TypeBinding var1 = this.parameters[0];
            if (var1.method_136() == 1 && var1.method_173().id == 11) {
                return true;
            }
        }
        return false;
    }

    public final boolean method_365() {
        return (this.modifiers & 256) != 0;
    }

    public final boolean method_366() {
        return (this.modifiers & 268435456) != 0;
    }

    public final boolean method_367() {
        return (this.modifiers & 2) != 0;
    }

    public final boolean method_368() {
        return (this.modifiers & 4) != 0;
    }

    public final boolean method_369() {
        return (this.modifiers & 1) != 0;
    }

    public final boolean method_370() {
        return (this.modifiers & 8) != 0;
    }

    public final boolean method_371() {
        return (this.modifiers & 2048) != 0;
    }

    public final boolean method_372() {
        return (this.modifiers & 4096) != 0;
    }

    public final boolean method_373() {
        return (this.modifiers & 134217728) != 0;
    }

    public final boolean method_374() {
        return (this.modifiers & 128) != 0;
    }

    public final boolean method_375() {
        return (this.modifiers & 3145728) != 0;
    }

    public final int kind() {
        return 8;
    }

    public MethodBinding original() {
        return this;
    }

    public char[] readableName() {
        StringBuffer var1 = new StringBuffer(this.parameters.length + 20);
        if (this.method_358()) {
            var1.append(this.declaringClass.method_179());
        } else {
            var1.append(this.selector);
        }
        var1.append('(');
        if (this.parameters != Binding.field_150) {
            int var2 = 0;
            for (int var3 = this.parameters.length; var2 < var3; ++var2) {
                if (var2 > 0) {
                    var1.append(", ");
                }
                var1.append(this.parameters[var2].method_179());
            }
        }
        var1.append(')');
        return var1.toString().toCharArray();
    }

    public void setAnnotations(AnnotationBinding[] var1) {
        this.declaringClass.storeAnnotations(this, var1);
    }

    public void method_378(AnnotationBinding[] var1, AnnotationBinding[][] var2, Object var3) {
        this.declaringClass.storeAnnotationHolder(this, AnnotationHolder.method_1169(var1, var2, var3));
    }

    public void setDefaultValue(Object var1) {
        MethodBinding var2 = this.original();
        var2.tagBits |= 2251799813685248L;
        AnnotationHolder var3 = this.declaringClass.retrieveAnnotationHolder(this, false);
        if (var3 == null) {
            this.method_378((AnnotationBinding[])null, (AnnotationBinding[][])null, var1);
        } else {
            this.method_378(var3.getAnnotations(), var3.getParameterAnnotations(), var1);
        }
    }

    public void setParameterAnnotations(AnnotationBinding[][] var1) {
        AnnotationHolder var2 = this.declaringClass.retrieveAnnotationHolder(this, false);
        if (var2 == null) {
            this.method_378((AnnotationBinding[])null, var1, (Object)null);
        } else {
            this.method_378(var2.getAnnotations(), var1, var2.getDefaultValue());
        }
    }

    protected final void setSelector(char[] var1) {
        this.selector = var1;
        this.signature = null;
    }

    public char[] shortReadableName() {
        StringBuffer var1 = new StringBuffer(this.parameters.length + 20);
        if (this.method_358()) {
            var1.append(this.declaringClass.shortReadableName());
        } else {
            var1.append(this.selector);
        }
        var1.append('(');
        int var2;
        if (this.parameters != Binding.field_150) {
            var2 = 0;
            for (int var3 = this.parameters.length; var2 < var3; ++var2) {
                if (var2 > 0) {
                    var1.append(", ");
                }
                var1.append(this.parameters[var2].shortReadableName());
            }
        }
        var1.append(')');
        var2 = var1.length();
        char[] var4 = new char[var2];
        var1.getChars(0, var2, var4, 0);
        return var4;
    }

    public final char[] signature(ClassFile var1) {
        TypeBinding[] var3;
        boolean var4;
        int var7;
        int var15;
        TypeBinding var16;
        TypeBinding var19;
        TypeBinding var20;
        if (this.signature != null) {
            if ((this.tagBits & 512L) != 0L) {
                boolean var12 = this.method_358();
                var3 = this.parameters;
                var4 = var12 && this.declaringClass.method_160();
                if (var4) {
                    ReferenceBinding[] var13 = this.declaringClass.syntheticEnclosingInstanceTypes();
                    if (var13 != null) {
                        var15 = 0;
                        for (var7 = var13.length; var15 < var7; ++var15) {
                            ReferenceBinding var22 = var13[var15];
                            if (var22.method_160()) {
                                var1.recordInnerClasses(var22);
                            }
                        }
                    }
                    if (this instanceof SyntheticMethodBinding) {
                        var3 = ((SyntheticMethodBinding)this).targetMethod.parameters;
                    }
                }
                int var14;
                if (var3 != Binding.field_150) {
                    for (var14 = 0; var14 < var3.length; ++var14) {
                        var16 = var3[var14];
                        var19 = var16.method_173();
                        if (var19.method_160()) {
                            var1.recordInnerClasses(var19);
                        }
                    }
                }
                if (var4) {
                    var14 = var3.length;
                    for (var15 = this.parameters.length; var14 < var15; ++var14) {
                        var19 = this.parameters[var14];
                        var20 = var19.method_173();
                        if (var20.method_160()) {
                            var1.recordInnerClasses(var20);
                        }
                    }
                }
                if (this.returnType != null) {
                    TypeBinding var18 = this.returnType.method_173();
                    if (var18.method_160()) {
                        var1.recordInnerClasses(var18);
                    }
                }
            }
            return this.signature;
        } else {
            StringBuffer var2 = new StringBuffer(this.parameters.length + 20);
            var2.append('(');
            var3 = this.parameters;
            var4 = this.method_358();
            if (var4 && this.declaringClass.method_153()) {
                var2.append(ConstantPool.field_1433);
                var2.append(TypeBinding.field_179.method_178());
            }
            boolean var5 = var4 && this.declaringClass.method_160();
            int var8;
            if (var5) {
                ReferenceBinding[] var6 = this.declaringClass.syntheticEnclosingInstanceTypes();
                if (var6 != null) {
                    var7 = 0;
                    for (var8 = var6.length; var7 < var8; ++var7) {
                        ReferenceBinding var9 = var6[var7];
                        if (var9.method_160()) {
                            this.tagBits |= 512L;
                            var1.recordInnerClasses(var9);
                        }
                        var2.append(var9.method_178());
                    }
                }
                if (this instanceof SyntheticMethodBinding) {
                    var3 = ((SyntheticMethodBinding)this).targetMethod.parameters;
                }
            }
            if (var3 != Binding.field_150) {
                for (var15 = 0; var15 < var3.length; ++var15) {
                    var19 = var3[var15];
                    var20 = var19.method_173();
                    if (var20.method_160()) {
                        this.tagBits |= 512L;
                        var1.recordInnerClasses(var20);
                    }
                    var2.append(var19.method_178());
                }
            }
            if (var5) {
                SyntheticArgumentBinding[] var17 = this.declaringClass.syntheticOuterLocalVariables();
                var7 = var17 == null ? 0 : var17.length;
                for (var8 = 0; var8 < var7; ++var8) {
                    var2.append(var17[var8].type.method_178());
                }
                var8 = var3.length;
                for (int var21 = this.parameters.length; var8 < var21; ++var8) {
                    TypeBinding var10 = this.parameters[var8];
                    TypeBinding var11 = var10.method_173();
                    if (var11.method_160()) {
                        this.tagBits |= 512L;
                        var1.recordInnerClasses(var11);
                    }
                    var2.append(var10.method_178());
                }
            }
            var2.append(')');
            if (this.returnType != null) {
                var16 = this.returnType.method_173();
                if (var16.method_160()) {
                    this.tagBits |= 512L;
                    var1.recordInnerClasses(var16);
                }
                var2.append(this.returnType.method_178());
            }
            var15 = var2.length();
            this.signature = new char[var15];
            var2.getChars(0, var15, this.signature, 0);
            return this.signature;
        }
    }

    public final int method_383() {
        AbstractMethodDeclaration var1 = this.sourceMethod();
        return var1 == null ? (this.declaringClass instanceof SourceTypeBinding ? ((SourceTypeBinding)this.declaringClass).method_317() : 0) : var1.field_445;
    }

    public AbstractMethodDeclaration sourceMethod() {
        SourceTypeBinding var1;
        try {
            var1 = (SourceTypeBinding)this.declaringClass;
        } catch (ClassCastException var4) {
            return null;
        }
        AbstractMethodDeclaration[] var2 = var1.scope.referenceContext.methods;
        int var3 = var2.length;
        do {
            --var3;
            if (var3 < 0) {
                return null;
            }
        } while (this != var2[var3].binding);
        return var2[var3];
    }

    public final int method_385() {
        AbstractMethodDeclaration var1 = this.sourceMethod();
        return var1 == null ? (this.declaringClass instanceof SourceTypeBinding ? ((SourceTypeBinding)this.declaringClass).method_318() : 0) : var1.field_444;
    }

    public MethodBinding tiebreakMethod() {
        return this;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer(10);
        if ((this.modifiers & 33554432) != 0) {
            var1.append("[unresolved] ");
        }
        ASTNode.method_760(this.modifiers, var1);
        var1.append(this.returnType != null ? this.returnType.debugName() : "<no type>");
        var1.append(" ");
        var1.append(this.selector != null ? new String(this.selector) : "<no selector>");
        var1.append("(");
        int var2;
        int var3;
        if (this.parameters != null) {
            if (this.parameters != Binding.field_150) {
                var2 = 0;
                for (var3 = this.parameters.length; var2 < var3; ++var2) {
                    if (var2 > 0) {
                        var1.append(", ");
                    }
                    var1.append(this.parameters[var2] != null ? this.parameters[var2].debugName() : "<no argument type>");
                }
            }
        } else {
            var1.append("<no argument types>");
        }
        var1.append(") ");
        if (this.thrownExceptions != null) {
            if (this.thrownExceptions != Binding.field_151) {
                var1.append("throws ");
                var2 = 0;
                for (var3 = this.thrownExceptions.length; var2 < var3; ++var2) {
                    if (var2 > 0) {
                        var1.append(", ");
                    }
                    var1.append(this.thrownExceptions[var2] != null ? this.thrownExceptions[var2].debugName() : "<no exception type>");
                }
            }
        } else {
            var1.append("<no exception types>");
        }
        return var1.toString();
    }
}
