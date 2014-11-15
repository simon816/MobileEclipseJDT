package org.eclipse.jdt.internal.compiler.env;

import org.eclipse.jdt.internal.compiler.env.ICompilationUnit;
import org.eclipse.jdt.internal.compiler.env.ISourceType;
import org.eclipse.jdt.internal.compiler.env.IBinaryType;
import org.eclipse.jdt.internal.compiler.env.AccessRestriction;

public class NameEnvironmentAnswer {

    IBinaryType field_1816;

    ICompilationUnit field_1817;

    ISourceType[] field_1818;

    AccessRestriction field_1819;

    public NameEnvironmentAnswer(IBinaryType var1, AccessRestriction var2) {
        this.field_1816 = var1;
        this.field_1819 = var2;
    }

    public NameEnvironmentAnswer(ICompilationUnit var1, AccessRestriction var2) {
        this.field_1817 = var1;
        this.field_1819 = var2;
    }

    public AccessRestriction method_3183() {
        return this.field_1819;
    }

    public IBinaryType method_3184() {
        return this.field_1816;
    }

    public ICompilationUnit method_3185() {
        return this.field_1817;
    }

    public ISourceType[] method_3186() {
        return this.field_1818;
    }

    public boolean method_3187() {
        return this.field_1816 != null;
    }

    public boolean method_3188() {
        return this.field_1817 != null;
    }

    public boolean method_3189() {
        return this.field_1818 != null;
    }

    public boolean method_3190() {
        return this.field_1819 != null && this.field_1819.method_3330();
    }

    public boolean method_3191(NameEnvironmentAnswer var1) {
        return var1 == null ? true : (this.field_1819 == null ? true : var1.field_1819 != null && this.field_1819.method_3329() < var1.field_1819.method_3329());
    }
}
