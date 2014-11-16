package org.eclipse.jdt.internal.compiler.batch;

import org.eclipse.jdt.internal.compiler.env.NameEnvironmentAnswer;

public interface FileSystem$Classpath {

    NameEnvironmentAnswer findClass(char[] var1, String var2, String var3, boolean var4);

    boolean isPackage(String var1);

    void cleanup();

    char[] normalizedPath();

    void reset();
}
