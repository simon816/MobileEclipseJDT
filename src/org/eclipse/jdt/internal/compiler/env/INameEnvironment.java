package org.eclipse.jdt.internal.compiler.env;

import org.eclipse.jdt.internal.compiler.env.NameEnvironmentAnswer;

public interface INameEnvironment {

    NameEnvironmentAnswer findType(char[][] var1);

    NameEnvironmentAnswer findType(char[] var1, char[][] var2);

    boolean isPackage(char[][] var1, char[] var2);
}
