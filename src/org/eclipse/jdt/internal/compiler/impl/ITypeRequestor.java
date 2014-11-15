package org.eclipse.jdt.internal.compiler.impl;

import org.eclipse.jdt.internal.compiler.env.ICompilationUnit;
import org.eclipse.jdt.internal.compiler.env.ISourceType;
import org.eclipse.jdt.internal.compiler.env.IBinaryType;
import org.eclipse.jdt.internal.compiler.env.AccessRestriction;
import org.eclipse.jdt.internal.compiler.lookup.PackageBinding;

public interface ITypeRequestor {

    void method_87(IBinaryType var1, PackageBinding var2, AccessRestriction var3);

    void method_88(ICompilationUnit var1, AccessRestriction var2);

    void method_89(ISourceType[] var1, PackageBinding var2, AccessRestriction var3);
}
