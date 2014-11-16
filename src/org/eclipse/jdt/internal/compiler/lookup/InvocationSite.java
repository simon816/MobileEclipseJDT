package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;

public interface InvocationSite {

    TypeBinding[] genericTypeArguments();

    boolean isSuperAccess();

    void method_2(int var1);

    void setFieldIndex(int var1);

    void setActualReceiverType(ReferenceBinding var1);

    int method_5();

    int method_6();
}
