package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.InvocationSite;
import org.eclipse.jdt.internal.compiler.lookup.AnnotationBinding;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.PackageBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ArrayBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.VariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodScope;

public class FieldBinding extends VariableBinding {

    public ReferenceBinding declaringClass;

    protected FieldBinding() {
        super((char[])null, (TypeBinding)null, 0, (Constant)null);
    }

    public FieldBinding(char[] var1, TypeBinding var2, int var3, ReferenceBinding var4, Constant var5) {
        super(var1, var2, var3, var5);
        this.declaringClass = var4;
    }

    public FieldBinding(FieldBinding var1, ReferenceBinding var2) {
        super(var1.name, var1.type, var1.field_300, var1.constant());
        this.declaringClass = var2;
        this.field_304 = var1.field_304;
        this.setAnnotations(var1.getAnnotations());
    }

    public FieldBinding(FieldDeclaration var1, TypeBinding var2, int var3, ReferenceBinding var4) {
        this(var1.name, var2, var3, var4, (Constant)null);
        var1.binding = this;
    }

    public final boolean canBeSeenBy(PackageBinding var1) {
        return this.method_430() ? true : (this.method_428() ? false : var1 == this.declaringClass.getPackage());
    }

    public final boolean canBeSeenBy(TypeBinding var1, InvocationSite var2, Scope var3) {
        if (this.method_430()) {
            return true;
        } else {
            SourceTypeBinding var4 = var3.enclosingSourceType();
            if (var4 == this.declaringClass && var4 == var1) {
                return true;
            } else if (var4 == null) {
                return !this.method_428() && var3.getCurrentPackage() == this.declaringClass.fPackage;
            } else {
                Object var5;
                ReferenceBinding var7;
                if (this.method_429()) {
                    if (var4 == this.declaringClass) {
                        return true;
                    } else if (var4.fPackage == this.declaringClass.fPackage) {
                        return true;
                    } else {
                        var5 = var4;
                        int var10 = 0;
                        var7 = (ReferenceBinding)var1.erasure();
                        ReferenceBinding var8 = (ReferenceBinding)this.declaringClass.erasure();
                        do {
                            if (((ReferenceBinding)var5).method_140(var8) != null) {
                                if (var2.isSuperAccess()) {
                                    return true;
                                }
                                if (var1 instanceof ArrayBinding) {
                                    return false;
                                }
                                if (this.method_431()) {
                                    if (var10 > 0) {
                                        var2.method_2(var10);
                                    }
                                    return true;
                                }
                                if (var5 == var7 || var7.method_140((TypeBinding)var5) != null) {
                                    if (var10 > 0) {
                                        var2.method_2(var10);
                                    }
                                    return true;
                                }
                            }
                            ++var10;
                            var5 = ((ReferenceBinding)var5).enclosingType();
                        } while (var5 != null);
                        return false;
                    }
                } else {
                    ReferenceBinding var6;
                    if (!this.method_428()) {
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

    public Constant constant() {
        Constant var1 = this.constant;
        if (var1 == null) {
            if (this.method_409()) {
                FieldBinding var2 = this.original();
                if (var2.declaringClass instanceof SourceTypeBinding) {
                    SourceTypeBinding var3 = (SourceTypeBinding)var2.declaringClass;
                    if (var3.scope != null) {
                        TypeDeclaration var4 = var3.scope.referenceContext;
                        FieldDeclaration var5 = var4.declarationOf(var2);
                        var5.resolve(var2.method_431() ? var4.field_589 : var4.field_588);
                        var1 = var2.constant == null ? Constant.NotAConstant : var2.constant;
                    } else {
                        var1 = Constant.NotAConstant;
                    }
                } else {
                    var1 = Constant.NotAConstant;
                }
            } else {
                var1 = Constant.NotAConstant;
            }
            this.constant = var1;
        }
        return var1;
    }

    public char[] genericSignature() {
        return (this.field_300 & 1073741824) == 0 ? null : this.type.genericTypeSignature();
    }

    public final int method_425() {
        return this.field_300 & '\uffff';
    }

    public AnnotationBinding[] getAnnotations() {
        FieldBinding var1 = this.original();
        ReferenceBinding var2 = var1.declaringClass;
        return var2 == null ? Binding.NO_ANNOTATIONS : var2.retrieveAnnotations(var1);
    }

    public long getAnnotationTagBits() {
        FieldBinding var1 = this.original();
        if ((var1.tagBits & 8589934592L) == 0L && var1.declaringClass instanceof SourceTypeBinding) {
            ClassScope var2 = ((SourceTypeBinding)var1.declaringClass).scope;
            if (var2 == null) {
                this.tagBits |= 25769803776L;
                return 0L;
            }
            TypeDeclaration var3 = var2.referenceContext;
            FieldDeclaration var4 = var3.declarationOf(var1);
            if (var4 != null) {
                MethodScope var5 = this.method_431() ? var3.field_589 : var3.field_588;
                FieldBinding var6 = var5.initializedField;
                int var7 = var5.field_407;
                try {
                    var5.initializedField = var1;
                    var5.field_407 = var1.field_304;
                    ASTNode.method_761(var5, var4.annotations, var1);
                } finally {
                    var5.initializedField = var6;
                    var5.field_407 = var7;
                }
            }
        }
        return var1.tagBits;
    }

    public final boolean method_427() {
        return (this.field_300 & 1048576) != 0;
    }

    public final boolean method_428() {
        return (this.field_300 & 2) != 0;
    }

    public final boolean method_429() {
        return (this.field_300 & 4) != 0;
    }

    public final boolean method_430() {
        return (this.field_300 & 1) != 0;
    }

    public final boolean method_431() {
        return (this.field_300 & 8) != 0;
    }

    public final boolean method_432() {
        return (this.field_300 & 4096) != 0;
    }

    public final boolean method_433() {
        return (this.field_300 & 134217728) != 0;
    }

    public final boolean method_434() {
        return (this.field_300 & 3145728) != 0;
    }

    public final int kind() {
        return 1;
    }

    public FieldBinding original() {
        return this;
    }

    public void setAnnotations(AnnotationBinding[] var1) {
        this.declaringClass.storeAnnotations(this, var1);
    }

    public FieldDeclaration sourceField() {
        SourceTypeBinding var1;
        try {
            var1 = (SourceTypeBinding)this.declaringClass;
        } catch (ClassCastException var4) {
            return null;
        }
        FieldDeclaration[] var2 = var1.scope.referenceContext.fields;
        if (var2 != null) {
            int var3 = var2.length;
            while (true) {
                --var3;
                if (var3 < 0) {
                    break;
                }
                if (this == var2[var3].binding) {
                    return var2[var3];
                }
            }
        }
        return null;
    }
}
