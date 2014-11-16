package org.eclipse.jdt.internal.compiler.env;

import org.eclipse.jdt.internal.compiler.env.IBinaryElementValuePair;

public interface IBinaryAnnotation {

    char[] getTypeName();

    IBinaryElementValuePair[] getElementValuePairs();
}
