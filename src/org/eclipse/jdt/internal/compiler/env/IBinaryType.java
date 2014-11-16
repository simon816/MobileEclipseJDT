package org.eclipse.jdt.internal.compiler.env;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.env.IGenericType;
import org.eclipse.jdt.internal.compiler.env.IBinaryNestedType;
import org.eclipse.jdt.internal.compiler.env.IBinaryMethod;
import org.eclipse.jdt.internal.compiler.env.IBinaryField;
import org.eclipse.jdt.internal.compiler.env.IBinaryAnnotation;

public interface IBinaryType extends IGenericType {

    char[][] NoInterface = CharOperation.NO_CHAR_CHAR;

    IBinaryNestedType[] NoNestedType = new IBinaryNestedType[0];

    IBinaryField[] NoField = new IBinaryField[0];

    IBinaryMethod[] NoMethod = new IBinaryMethod[0];

    IBinaryAnnotation[] getAnnotations();

    char[] getContents();

    IBinaryField[] getFields();

    char[] method_52();

    char[][] getPackageName();

    IBinaryNestedType[] getMemberTypes();

    IBinaryMethod[] getMethods();

    char[][][] getMissingTypeNames();

    char[] method_60();

    char[] method_61();

    char[] method_62();

    long getTagBits();

    boolean method_64();

    boolean method_65();

    boolean method_66();
}
