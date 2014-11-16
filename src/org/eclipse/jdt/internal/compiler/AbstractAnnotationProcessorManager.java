package org.eclipse.jdt.internal.compiler;

import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.env.ICompilationUnit;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;

public abstract class AbstractAnnotationProcessorManager {

    public AbstractAnnotationProcessorManager() {
    }

    public abstract ICompilationUnit[] method_2935();

    public abstract ReferenceBinding[] getNewClassFiles();

    public abstract void reset();

    public abstract void processAnnotations(CompilationUnitDeclaration[] var1, ReferenceBinding[] var2, boolean var3);
}
