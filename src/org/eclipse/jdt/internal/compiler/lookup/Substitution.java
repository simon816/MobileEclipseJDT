package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;

public interface Substitution {

    TypeBinding substitute(TypeVariableBinding var1);

    LookupEnvironment environment();

    boolean isRawSubstitution();
}
