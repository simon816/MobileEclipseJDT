package org.eclipse.jdt.internal.compiler;

import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.env.ICompilationUnit;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;

public abstract class AbstractAnnotationProcessorManager {

    public AbstractAnnotationProcessorManager() {
    }

    public abstract ICompilationUnit[] method_2935();

    public abstract ReferenceBinding[] method_2936();

    public abstract void method_2937();

    public abstract void method_2938(CompilationUnitDeclaration[] var1, ReferenceBinding[] var2, boolean var3);
}
