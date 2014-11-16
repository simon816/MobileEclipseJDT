package org.eclipse.jdt.internal.compiler;

import org.eclipse.jdt.internal.compiler.CompilationResult;

public interface IDebugRequestor {

    void acceptDebugResult(CompilationResult var1);

    boolean isActive();

    void method_22();
}
