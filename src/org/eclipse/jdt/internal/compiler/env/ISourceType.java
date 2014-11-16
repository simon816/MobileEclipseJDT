package org.eclipse.jdt.internal.compiler.env;

import org.eclipse.jdt.internal.compiler.env.IGenericType;

public interface ISourceType extends IGenericType {

    char[] getContents();
}
