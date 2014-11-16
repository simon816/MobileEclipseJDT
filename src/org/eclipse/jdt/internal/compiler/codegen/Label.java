package org.eclipse.jdt.internal.compiler.codegen;

import org.eclipse.jdt.internal.compiler.codegen.CodeStream;

public abstract class Label {

    public CodeStream codeStream;

    public int position;

    public Label() {
        this.position = -1;
    }

    public Label(CodeStream var1) {
        this.position = -1;
        this.codeStream = var1;
    }
}
