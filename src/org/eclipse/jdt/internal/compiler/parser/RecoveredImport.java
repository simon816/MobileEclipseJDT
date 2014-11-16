package org.eclipse.jdt.internal.compiler.parser;

import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.ImportReference;
import org.eclipse.jdt.internal.compiler.parser.RecoveredElement;

public class RecoveredImport extends RecoveredElement {

    public ImportReference importReference;

    public RecoveredImport(ImportReference var1, RecoveredElement var2, int var3) {
        super(var2, var3);
        this.importReference = var1;
    }

    public ASTNode parseTree() {
        return this.importReference;
    }

    public String toString(int var1) {
        return this.tabString(var1) + "Recovered import: " + this.importReference.toString();
    }

    public ImportReference updatedImportReference() {
        return this.importReference;
    }

    public void updateParseTree() {
        this.updatedImportReference();
    }

    public void updateSourceEndIfNecessary(int var1, int var2) {
        if (this.importReference.field_471 == 0) {
            this.importReference.field_471 = var2;
            this.importReference.field_469 = var2;
        }
    }
}
