package org.eclipse.jdt.internal.compiler.codegen;

import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.codegen.BranchLabel;

public class CaseLabel extends BranchLabel {

    public int instructionPosition;

    public CaseLabel(CodeStream var1) {
        super(var1);
        this.instructionPosition = -1;
    }

    void method_452() {
        if (this.position == -1) {
            this.addForwardReference(this.codeStream.field_1208);
            this.codeStream.field_1208 += 4;
            this.codeStream.field_1190 += 4;
        } else {
            this.codeStream.writeSignedWord(this.position - this.instructionPosition);
        }
    }

    void method_453() {
        this.method_452();
    }

    public boolean method_457() {
        return false;
    }

    public void place() {
        if ((this.tagBits & 2) != 0) {
            this.position = this.codeStream.getPosition();
        } else {
            this.position = this.codeStream.field_1208;
        }
        if (this.instructionPosition != -1) {
            int var1 = this.position - this.instructionPosition;
            int[] var2 = this.forwardReferences();
            int var3 = 0;
            for (int var4 = this.forwardReferenceCount(); var3 < var4; ++var3) {
                this.codeStream.writeSignedWord(var2[var3], var1);
            }
            this.codeStream.method_2089(this);
        }
    }

    void method_459() {
        if (this.instructionPosition == -1) {
            this.instructionPosition = this.codeStream.field_1208;
        }
    }
}
