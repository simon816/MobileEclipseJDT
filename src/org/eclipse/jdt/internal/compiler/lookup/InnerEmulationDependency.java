package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class InnerEmulationDependency {

    public BlockScope scope;

    public boolean wasEnclosingInstanceSupplied;

    public InnerEmulationDependency(BlockScope var1, boolean var2) {
        this.scope = var1;
        this.wasEnclosingInstanceSupplied = var2;
    }
}
