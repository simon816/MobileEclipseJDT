package org.eclipse.jdt.internal.compiler.env;

import org.eclipse.jdt.internal.compiler.env.IDependent;

public interface ICompilationUnit extends IDependent {

    char[] getContents();

    char[] method_52();

    char[][] getPackageName();
}
