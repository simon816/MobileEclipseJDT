package org.eclipse.jdt.internal.compiler.env;

import org.eclipse.jdt.internal.compiler.env.IGenericMethod;
import org.eclipse.jdt.internal.compiler.env.IBinaryAnnotation;

public interface IBinaryMethod extends IGenericMethod {

    IBinaryAnnotation[] getAnnotations();

    Object getDefaultValue();

    char[][] getExceptionTypeNames();

    char[] method_74();

    char[] method_75();

    IBinaryAnnotation[] getParameterAnnotations(int var1);

    char[] method_77();

    long getTagBits();
}
