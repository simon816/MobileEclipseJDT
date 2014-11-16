package org.eclipse.jdt.internal.compiler.env;

import org.eclipse.jdt.internal.compiler.env.IGenericField;
import org.eclipse.jdt.internal.compiler.env.IBinaryAnnotation;
import org.eclipse.jdt.internal.compiler.impl.Constant;

public interface IBinaryField extends IGenericField {

    IBinaryAnnotation[] getAnnotations();

    Constant getConstant();

    char[] method_74();

    char[] method_75();

    long getTagBits();

    char[] method_77();
}
