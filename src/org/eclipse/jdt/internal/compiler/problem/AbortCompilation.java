package org.eclipse.jdt.internal.compiler.problem;

import org.eclipse.jdt.core.compiler.CategorizedProblem;
import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.lookup.InvocationSite;
import org.eclipse.jdt.internal.compiler.util.Util;

public class AbortCompilation extends RuntimeException {

    public CompilationResult field_1049;

    public Throwable field_1050;

    public CategorizedProblem field_1051;

    public boolean field_1052;

    public RuntimeException field_1053;

    public AbortCompilation() {
    }

    public AbortCompilation(CompilationResult var1, CategorizedProblem var2) {
        this();
        this.field_1049 = var1;
        this.field_1051 = var2;
    }

    public AbortCompilation(CompilationResult var1, Throwable var2) {
        this();
        this.field_1049 = var1;
        this.field_1050 = var2;
    }

    public AbortCompilation(boolean var1, RuntimeException var2) {
        this();
        this.field_1052 = var1;
        this.field_1053 = var2;
    }

    public void method_1437(InvocationSite var1, CompilationResult var2) {
        if (this.field_1051 != null) {
            if (this.field_1051.method_1401() == 0 && this.field_1051.method_1402() == 0) {
                this.field_1051.method_13(var1.method_5());
                this.field_1051.method_11(var1.method_6());
                int[] var3 = var2.method_2921();
                this.field_1051.method_12(Util.method_1324(var1.method_5(), var3, 0, var3.length - 1));
                this.field_1049 = var2;
            }
        }
    }

    public void method_1438(ASTNode var1, CompilationResult var2) {
        if (this.field_1051 != null) {
            if (this.field_1051.method_1401() == 0 && this.field_1051.method_1402() == 0) {
                this.field_1051.method_13(var1.method_5());
                this.field_1051.method_11(var1.method_6());
                int[] var3 = var2.method_2921();
                this.field_1051.method_12(Util.method_1324(var1.method_5(), var3, 0, var3.length - 1));
                this.field_1049 = var2;
            }
        }
    }
}
