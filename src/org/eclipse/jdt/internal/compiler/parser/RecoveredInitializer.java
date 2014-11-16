package org.eclipse.jdt.internal.compiler.parser;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ast.Block;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Initializer;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.parser.RecoveredElement;
import org.eclipse.jdt.internal.compiler.parser.RecoveredField;
import org.eclipse.jdt.internal.compiler.parser.RecoveredAnnotation;
import org.eclipse.jdt.internal.compiler.parser.RecoveredType;
import org.eclipse.jdt.internal.compiler.parser.RecoveredBlock;
import org.eclipse.jdt.internal.compiler.parser.Parser;

public class RecoveredInitializer extends RecoveredField {

    public RecoveredType[] localTypes;

    public int localTypeCount;

    public RecoveredBlock initializerBody;

    int field_1084;

    int field_1085;

    RecoveredAnnotation[] pendingAnnotations;

    int field_1087;

    public RecoveredInitializer(FieldDeclaration var1, RecoveredElement var2, int var3) {
        this(var1, var2, var3, (Parser)null);
    }

    public RecoveredInitializer(FieldDeclaration var1, RecoveredElement var2, int var3, Parser var4) {
        super(var1, var2, var3, var4);
        this.field_1085 = -1;
        this.foundOpeningBrace = true;
    }

    public RecoveredElement add(Block var1, int var2) {
        if (this.fieldDeclaration.field_652 > 0 && var1.field_444 > this.fieldDeclaration.field_652) {
            this.resetPendingModifiers();
            return (RecoveredElement)(this.parent == null ? this : this.parent.add(var1, var2));
        } else {
            if (!this.foundOpeningBrace) {
                this.foundOpeningBrace = true;
                ++this.bracketBalance;
            }
            RecoveredBlock var10001 = new RecoveredBlock(var1, this, var2);
            this.initializerBody = var10001;
            if (var1.field_445 == 0) {
                return this.initializerBody;
            }
            return this;
        }
    }

    public RecoveredElement add(FieldDeclaration var1, int var2) {
        this.resetPendingModifiers();
        char[][] var3;
        if ((var1.field_656 & -17) == 0 && var1.type != null && ((var3 = var1.type.getTypeName()).length != 1 || !CharOperation.method_1364(var3[0], TypeBinding.field_188.method_179()))) {
            return (RecoveredElement)(this.fieldDeclaration.field_652 > 0 && var1.field_653 > this.fieldDeclaration.field_652 ? (this.parent == null ? this : this.parent.add(var1, var2)) : this);
        } else if (this.parent == null) {
            return this;
        } else {
            this.method_1857(this.previousAvailableLineEnd(var1.field_653 - 1));
            return this.parent.add(var1, var2);
        }
    }

    public RecoveredElement add(LocalDeclaration var1, int var2) {
        if (this.fieldDeclaration.field_652 != 0 && var1.field_653 > this.fieldDeclaration.field_652) {
            this.resetPendingModifiers();
            return (RecoveredElement)(this.parent == null ? this : this.parent.add(var1, var2));
        } else {
            Block var10000 = new Block(0);
            Block var3 = var10000;
            var3.field_444 = ((Initializer)this.fieldDeclaration).field_444;
            RecoveredElement var4 = this.add(var3, 1);
            if (this.initializerBody != null) {
                this.initializerBody.attachPendingModifiers(this.pendingAnnotations, this.field_1087, this.field_1084, this.field_1085);
            }
            this.resetPendingModifiers();
            return var4.add(var1, var2);
        }
    }

    public RecoveredElement add(Statement var1, int var2) {
        if (this.fieldDeclaration.field_652 != 0 && var1.field_444 > this.fieldDeclaration.field_652) {
            this.resetPendingModifiers();
            return (RecoveredElement)(this.parent == null ? this : this.parent.add(var1, var2));
        } else {
            Block var10000 = new Block(0);
            Block var3 = var10000;
            var3.field_444 = ((Initializer)this.fieldDeclaration).field_444;
            RecoveredElement var4 = this.add(var3, 1);
            if (this.initializerBody != null) {
                this.initializerBody.attachPendingModifiers(this.pendingAnnotations, this.field_1087, this.field_1084, this.field_1085);
            }
            this.resetPendingModifiers();
            return var4.add(var1, var2);
        }
    }

    public RecoveredElement add(TypeDeclaration var1, int var2) {
        if (this.fieldDeclaration.field_652 != 0 && var1.field_592 > this.fieldDeclaration.field_652) {
            this.resetPendingModifiers();
            return (RecoveredElement)(this.parent == null ? this : this.parent.add(var1, var2));
        } else if ((var1.field_446 & 256) == 0 && !this.parser().field_1621 && !this.parser().field_1622) {
            if (this.localTypes == null) {
                this.localTypes = new RecoveredType[5];
                this.localTypeCount = 0;
            } else if (this.localTypeCount == this.localTypes.length) {
                System.arraycopy(this.localTypes, 0, this.localTypes = new RecoveredType[2 * this.localTypeCount], 0, this.localTypeCount);
            }
            RecoveredType var6 = new RecoveredType(var1, this, var2);
            RecoveredType var5 = var6;
            this.localTypes[this.localTypeCount++] = var5;
            if (this.field_1087 > 0) {
                var5.attach(this.pendingAnnotations, this.field_1087, this.field_1084, this.field_1085);
            }
            this.resetPendingModifiers();
            if (!this.foundOpeningBrace) {
                this.foundOpeningBrace = true;
                ++this.bracketBalance;
            }
            return var5;
        } else {
            Block var10000 = new Block(0);
            Block var3 = var10000;
            var3.field_444 = ((Initializer)this.fieldDeclaration).field_444;
            RecoveredElement var4 = this.add(var3, 1);
            if (this.initializerBody != null) {
                this.initializerBody.attachPendingModifiers(this.pendingAnnotations, this.field_1087, this.field_1084, this.field_1085);
            }
            this.resetPendingModifiers();
            return var4.add(var1, var2);
        }
    }

    public RecoveredElement addAnnotationName(int var1, int var2, int var3, int var4) {
        if (this.pendingAnnotations == null) {
            this.pendingAnnotations = new RecoveredAnnotation[5];
            this.field_1087 = 0;
        } else if (this.field_1087 == this.pendingAnnotations.length) {
            System.arraycopy(this.pendingAnnotations, 0, this.pendingAnnotations = new RecoveredAnnotation[2 * this.field_1087], 0, this.field_1087);
        }
        RecoveredAnnotation var10000 = new RecoveredAnnotation(var1, var2, var3, this, var4);
        RecoveredAnnotation var5 = var10000;
        this.pendingAnnotations[this.field_1087++] = var5;
        return var5;
    }

    public void addModifier(int var1, int var2) {
        this.field_1084 |= var1;
        if (this.field_1085 < 0) {
            this.field_1085 = var2;
        }
    }

    public void resetPendingModifiers() {
        this.pendingAnnotations = null;
        this.field_1087 = 0;
        this.field_1084 = 0;
        this.field_1085 = -1;
    }

    public String toString(int var1) {
        StringBuffer var2 = new StringBuffer(this.tabString(var1));
        var2.append("Recovered initializer:\n");
        this.fieldDeclaration.print(var1 + 1, var2);
        if (this.annotations != null) {
            for (int var3 = 0; var3 < this.field_1076; ++var3) {
                var2.append("\n");
                var2.append(this.annotations[var3].toString(var1 + 1));
            }
        }
        if (this.initializerBody != null) {
            var2.append("\n");
            var2.append(this.initializerBody.toString(var1 + 1));
        }
        return var2.toString();
    }

    public FieldDeclaration method_1863() {
        if (this.initializerBody != null) {
            Block var1 = this.initializerBody.method_1891();
            if (var1 != null) {
                Initializer var2 = (Initializer)this.fieldDeclaration;
                var2.block = var1;
                if (var2.field_652 == 0) {
                    var2.field_652 = var1.field_445;
                    var2.field_667 = var1.field_445;
                }
            }
            if (this.localTypeCount > 0) {
                this.fieldDeclaration.field_446 |= 2;
            }
        }
        if (this.fieldDeclaration.field_445 == 0) {
            this.fieldDeclaration.field_445 = this.fieldDeclaration.field_652;
        }
        return this.fieldDeclaration;
    }

    public RecoveredElement updateOnClosingBrace(int var1, int var2) {
        if (--this.bracketBalance <= 0 && this.parent != null) {
            this.updateSourceEndIfNecessary(var1, var2);
            return this.parent;
        } else {
            return this;
        }
    }

    public RecoveredElement method_1854(int var1, int var2) {
        ++this.bracketBalance;
        return this;
    }

    public void updateSourceEndIfNecessary(int var1, int var2) {
        if (this.fieldDeclaration.field_652 == 0) {
            Initializer var3 = (Initializer)this.fieldDeclaration;
            if (this.parser().field_1611 >= var2) {
                if (var3.field_666 < this.parser().field_1610) {
                    var3.field_652 = this.parser().field_1610;
                } else {
                    var3.field_652 = var3.field_666;
                }
                if (var3.field_666 < this.parser().field_1609) {
                    var3.field_667 = this.parser().field_1609;
                } else {
                    var3.field_667 = var3.field_666;
                }
            } else {
                var3.field_652 = var2;
                var3.field_667 = var1 - 1;
            }
            if (var3.block != null) {
                var3.block.field_445 = var3.field_652;
            }
        }
    }
}
