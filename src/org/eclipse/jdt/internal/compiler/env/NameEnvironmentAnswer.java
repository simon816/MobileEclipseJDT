package org.eclipse.jdt.internal.compiler.env;

import org.eclipse.jdt.internal.compiler.env.ICompilationUnit;
import org.eclipse.jdt.internal.compiler.env.ISourceType;
import org.eclipse.jdt.internal.compiler.env.IBinaryType;
import org.eclipse.jdt.internal.compiler.env.AccessRestriction;

public class NameEnvironmentAnswer {

    IBinaryType binaryType;

    ICompilationUnit compilationUnit;

    ISourceType[] sourceTypes;

    AccessRestriction accessRestriction;

    public NameEnvironmentAnswer(IBinaryType var1, AccessRestriction var2) {
        this.binaryType = var1;
        this.accessRestriction = var2;
    }

    public NameEnvironmentAnswer(ICompilationUnit var1, AccessRestriction var2) {
        this.compilationUnit = var1;
        this.accessRestriction = var2;
    }

    public AccessRestriction getAccessRestriction() {
        return this.accessRestriction;
    }

    public IBinaryType getBinaryType() {
        return this.binaryType;
    }

    public ICompilationUnit getCompilationUnit() {
        return this.compilationUnit;
    }

    public ISourceType[] getSourceTypes() {
        return this.sourceTypes;
    }

    public boolean method_3187() {
        return this.binaryType != null;
    }

    public boolean method_3188() {
        return this.compilationUnit != null;
    }

    public boolean method_3189() {
        return this.sourceTypes != null;
    }

    public boolean method_3190() {
        return this.accessRestriction != null && this.accessRestriction.ignoreIfBetter();
    }

    public boolean isBetter(NameEnvironmentAnswer var1) {
        return var1 == null ? true : (this.accessRestriction == null ? true : var1.accessRestriction != null && this.accessRestriction.getProblemId() < var1.accessRestriction.getProblemId());
    }
}
