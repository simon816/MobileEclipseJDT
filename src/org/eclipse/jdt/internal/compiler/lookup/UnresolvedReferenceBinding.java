package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.lookup.PackageBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;

public class UnresolvedReferenceBinding extends ReferenceBinding {

    ReferenceBinding resolvedType;

    TypeBinding[] wrappers;

    UnresolvedReferenceBinding(char[][] var1, PackageBinding var2) {
        this.compoundName = var1;
        this.sourceName = var1[var1.length - 1];
        this.fPackage = var2;
        this.wrappers = null;
    }

    void addWrapper(TypeBinding var1, LookupEnvironment var2) {
        if (this.resolvedType != null) {
            var1.swapUnresolved(this, this.resolvedType, var2);
        } else {
            if (this.wrappers == null) {
                this.wrappers = new TypeBinding[] {var1};
            } else {
                int var3 = this.wrappers.length;
                System.arraycopy(this.wrappers, 0, this.wrappers = new TypeBinding[var3 + 1], 0, var3);
                this.wrappers[var3] = var1;
            }
        }
    }

    public String debugName() {
        return this.toString();
    }

    ReferenceBinding resolve(LookupEnvironment var1, boolean var2) {
        Object var3 = this.resolvedType;
        if (var3 == null) {
            var3 = this.fPackage.method_124(this.compoundName[this.compoundName.length - 1]);
            if (var3 == this) {
                var3 = var1.method_481(this.compoundName);
            }
            if (var3 == null || var3 == this) {
                if ((this.tagBits & 128L) == 0L) {
                    var1.problemReporter.isClassPathCorrect(this.compoundName, var1.unitBeingCompleted, var1.missingClassFileLocation);
                }
                var3 = var1.createMissingType((PackageBinding)null, this.compoundName);
            }
            this.setResolvedType((ReferenceBinding)var3, var1);
        }
        if (var2) {
            var3 = (ReferenceBinding)var1.method_491((TypeBinding)var3);
        }
        return (ReferenceBinding)var3;
    }

    void setResolvedType(ReferenceBinding var1, LookupEnvironment var2) {
        if (this.resolvedType != var1) {
            this.resolvedType = var1;
            if (this.wrappers != null) {
                int var3 = 0;
                for (int var4 = this.wrappers.length; var3 < var4; ++var3) {
                    this.wrappers[var3].swapUnresolved(this, var1, var2);
                }
            }
            var2.updateCaches(this, var1);
        }
    }

    public String toString() {
        return "Unresolved type " + (this.compoundName != null ? CharOperation.toString(this.compoundName) : "UNNAMED");
    }
}
