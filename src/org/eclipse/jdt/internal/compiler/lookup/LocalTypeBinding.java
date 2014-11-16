package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ast.CaseStatement;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.ArrayBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.NestedTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.InnerEmulationDependency;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodScope;

public final class LocalTypeBinding extends NestedTypeBinding {

    static final char[] LocalTypePrefix;

    private InnerEmulationDependency[] dependents;

    public ArrayBinding[] localArrayBindings;

    public CaseStatement enclosingCase;

    public int sourceStart;

    public MethodBinding enclosingMethod;

    public LocalTypeBinding(ClassScope var1, SourceTypeBinding var2, CaseStatement var3, ReferenceBinding var4) {
        super(new char[][] {CharOperation.concat(LocalTypePrefix, var1.referenceContext.name)}, var1, var2);
        TypeDeclaration var5 = var1.referenceContext;
        if ((var5.field_446 & 512) != 0) {
            this.tagBits |= 52L;
        } else {
            this.tagBits |= 20L;
        }
        this.enclosingCase = var3;
        this.sourceStart = var5.field_444;
        MethodScope var6 = var1.method_583();
        AbstractMethodDeclaration var7 = var6.referenceMethod();
        if (var7 != null) {
            this.enclosingMethod = var7.binding;
        }
    }

    public void addInnerEmulationDependent(BlockScope var1, boolean var2) {
        int var3;
        if (this.dependents == null) {
            var3 = 0;
            this.dependents = new InnerEmulationDependency[1];
        } else {
            var3 = this.dependents.length;
            for (int var4 = 0; var4 < var3; ++var4) {
                if (this.dependents[var4].scope == var1) {
                    return;
                }
            }
            System.arraycopy(this.dependents, 0, this.dependents = new InnerEmulationDependency[var3 + 1], 0, var3);
        }
        InnerEmulationDependency[] var10000 = this.dependents;
        InnerEmulationDependency var10002 = new InnerEmulationDependency(var1, var2);
        var10000[var3] = var10002;
    }

    public ReferenceBinding anonymousOriginalSuperType() {
        if (this.field_253 != Binding.field_155) {
            return this.field_253[0];
        } else if ((this.tagBits & 131072L) == 0L) {
            return this.superclass;
        } else {
            if (this.scope != null) {
                TypeReference var1 = this.scope.referenceContext.allocation.type;
                if (var1 != null) {
                    return (ReferenceBinding)var1.resolvedType;
                }
            }
            return this.superclass;
        }
    }

    public char[] constantPoolName() {
        return this.field_202;
    }

    ArrayBinding createArrayType(int var1, LookupEnvironment var2) {
        if (this.localArrayBindings == null) {
            ArrayBinding[] var10001 = new ArrayBinding[1];
            ArrayBinding var10004 = new ArrayBinding(this, var1, var2);
            var10001[0] = var10004;
            this.localArrayBindings = var10001;
            return this.localArrayBindings[0];
        } else {
            int var3 = this.localArrayBindings.length;
            for (int var4 = 0; var4 < var3; ++var4) {
                if (this.localArrayBindings[var4].dimensions == var1) {
                    return this.localArrayBindings[var4];
                }
            }
            System.arraycopy(this.localArrayBindings, 0, this.localArrayBindings = new ArrayBinding[var3 + 1], 0, var3);
            ArrayBinding[] var10000 = this.localArrayBindings;
            ArrayBinding var10002 = new ArrayBinding(this, var1, var2);
            return var10000[var3] = var10002;
        }
    }

    public char[] genericTypeSignature() {
        if (this.genericReferenceTypeSignature == null && this.constantPoolName() == null) {
            if (this.method_146()) {
                this.setConstantPoolName(this.superclass().method_179());
            } else {
                this.setConstantPoolName(this.method_179());
            }
        }
        return super.genericTypeSignature();
    }

    public char[] readableName() {
        char[] var1;
        if (this.method_146()) {
            var1 = CharOperation.method_1356(TypeConstants.field_49, this.anonymousOriginalSuperType().readableName(), TypeConstants.field_50);
        } else if (this.method_159()) {
            var1 = CharOperation.concat(this.enclosingType().readableName(), this.sourceName, '.');
        } else {
            var1 = this.sourceName;
        }
        TypeVariableBinding[] var2;
        if ((var2 = this.typeVariables()) != Binding.NO_TYPE_VARIABLES) {
            StringBuffer var3 = new StringBuffer(10);
            var3.append(var1).append('<');
            int var4 = 0;
            for (int var5 = var2.length; var4 < var5; ++var4) {
                if (var4 > 0) {
                    var3.append(',');
                }
                var3.append(var2[var4].readableName());
            }
            var3.append('>');
            var4 = var3.length();
            var1 = new char[var4];
            var3.getChars(0, var4, var1, 0);
        }
        return var1;
    }

    public char[] shortReadableName() {
        char[] var1;
        if (this.method_146()) {
            var1 = CharOperation.method_1356(TypeConstants.field_49, this.anonymousOriginalSuperType().shortReadableName(), TypeConstants.field_50);
        } else if (this.method_159()) {
            var1 = CharOperation.concat(this.enclosingType().shortReadableName(), this.sourceName, '.');
        } else {
            var1 = this.sourceName;
        }
        TypeVariableBinding[] var2;
        if ((var2 = this.typeVariables()) != Binding.NO_TYPE_VARIABLES) {
            StringBuffer var3 = new StringBuffer(10);
            var3.append(var1).append('<');
            int var4 = 0;
            for (int var5 = var2.length; var4 < var5; ++var4) {
                if (var4 > 0) {
                    var3.append(',');
                }
                var3.append(var2[var4].shortReadableName());
            }
            var3.append('>');
            var4 = var3.length();
            var1 = new char[var4];
            var3.getChars(0, var4, var1, 0);
        }
        return var1;
    }

    public void method_337() {
        this.tagBits |= 12L;
    }

    public void setConstantPoolName(char[] var1) {
        this.field_202 = var1;
    }

    public char[] method_178() {
        if (this.field_203 == null && this.constantPoolName() == null) {
            if (this.method_146()) {
                this.setConstantPoolName(this.superclass().method_179());
            } else {
                this.setConstantPoolName(this.method_179());
            }
        }
        return super.method_178();
    }

    public char[] method_179() {
        return this.method_146() ? CharOperation.method_1356(TypeConstants.field_49, this.anonymousOriginalSuperType().method_179(), TypeConstants.field_50) : this.sourceName;
    }

    public String toString() {
        return this.method_146() ? "Anonymous type : " + super.toString() : (this.method_159() ? "Local member type : " + new String(this.method_179()) + " " + super.toString() : "Local type : " + new String(this.method_179()) + " " + super.toString());
    }

    public void updateInnerEmulationDependents() {
        if (this.dependents != null) {
            for (int var1 = 0; var1 < this.dependents.length; ++var1) {
                InnerEmulationDependency var2 = this.dependents[var1];
                var2.scope.propagateInnerEmulation(this, var2.wasEnclosingInstanceSupplied);
            }
        }
    }

    static {
        LocalTypePrefix = new char[] {'$', 'L', 'o', 'c', 'a', 'l', '$'};
    }
}
