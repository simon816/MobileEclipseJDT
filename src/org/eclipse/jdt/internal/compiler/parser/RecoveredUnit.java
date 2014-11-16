package org.eclipse.jdt.internal.compiler.parser;

import org.eclipse.jdt.internal.compiler.ast.Block;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Initializer;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ImportReference;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.parser.RecoveredElement;
import org.eclipse.jdt.internal.compiler.parser.RecoveredImport;
import org.eclipse.jdt.internal.compiler.parser.RecoveredAnnotation;
import org.eclipse.jdt.internal.compiler.parser.RecoveredType;
import org.eclipse.jdt.internal.compiler.parser.Parser;

public class RecoveredUnit extends RecoveredElement {

    public CompilationUnitDeclaration unitDeclaration;

    public RecoveredImport[] imports;

    public int field_1103;

    public RecoveredType[] types;

    public int field_1105;

    int field_1106;

    int field_1107;

    RecoveredAnnotation[] pendingAnnotations;

    int field_1109;

    public RecoveredUnit(CompilationUnitDeclaration var1, int var2, Parser var3) {
        super((RecoveredElement)null, var2, var3);
        this.field_1107 = -1;
        this.unitDeclaration = var1;
    }

    public RecoveredElement addAnnotationName(int var1, int var2, int var3, int var4) {
        if (this.pendingAnnotations == null) {
            this.pendingAnnotations = new RecoveredAnnotation[5];
            this.field_1109 = 0;
        } else if (this.field_1109 == this.pendingAnnotations.length) {
            System.arraycopy(this.pendingAnnotations, 0, this.pendingAnnotations = new RecoveredAnnotation[2 * this.field_1109], 0, this.field_1109);
        }
        RecoveredAnnotation var10000 = new RecoveredAnnotation(var1, var2, var3, this, var4);
        RecoveredAnnotation var5 = var10000;
        this.pendingAnnotations[this.field_1109++] = var5;
        return var5;
    }

    public void addModifier(int var1, int var2) {
        this.field_1106 |= var1;
        if (this.field_1107 < 0) {
            this.field_1107 = var2;
        }
    }

    public RecoveredElement add(AbstractMethodDeclaration var1, int var2) {
        if (this.field_1105 > 0) {
            RecoveredType var3 = this.types[this.field_1105 - 1];
            int var4 = var3.field_1136;
            int var5 = var3.typeDeclaration.field_595;
            var3.field_1136 = 0;
            var3.typeDeclaration.field_593 = 0;
            var3.typeDeclaration.field_595 = 0;
            int var6 = TypeDeclaration.kind(var3.typeDeclaration.field_577);
            if (var4 > 0 && var4 < var5 && var6 != 2 && var6 != 4) {
                Block var10002 = new Block(0);
                Initializer var10000 = new Initializer(var10002, 0);
                Initializer var7 = var10000;
                var7.field_666 = var5;
                var7.field_667 = var5;
                var7.field_653 = var5;
                var7.field_652 = var5;
                var7.field_444 = var5;
                var7.field_445 = var5;
                var3.add(var7, var2);
            }
            this.resetPendingModifiers();
            return var3.add(var1, var2);
        } else {
            return this;
        }
    }

    public RecoveredElement add(FieldDeclaration var1, int var2) {
        if (this.field_1105 > 0) {
            RecoveredType var3 = this.types[this.field_1105 - 1];
            var3.field_1136 = 0;
            var3.typeDeclaration.field_593 = 0;
            var3.typeDeclaration.field_595 = 0;
            this.resetPendingModifiers();
            return var3.add(var1, var2);
        } else {
            return this;
        }
    }

    public RecoveredElement add(ImportReference var1, int var2) {
        this.resetPendingModifiers();
        if (this.imports == null) {
            this.imports = new RecoveredImport[5];
            this.field_1103 = 0;
        } else if (this.field_1103 == this.imports.length) {
            System.arraycopy(this.imports, 0, this.imports = new RecoveredImport[2 * this.field_1103], 0, this.field_1103);
        }
        RecoveredImport var10000 = new RecoveredImport(var1, this, var2);
        RecoveredImport var3 = var10000;
        this.imports[this.field_1103++] = var3;
        if (var1.field_471 == 0) {
            return var3;
        }
        return this;
    }

    public RecoveredElement add(TypeDeclaration var1, int var2) {
        RecoveredType var3;
        if ((var1.field_446 & 512) != 0 && this.field_1105 > 0) {
            var3 = this.types[this.field_1105 - 1];
            var3.field_1136 = 0;
            var3.typeDeclaration.field_595 = 0;
            var3.typeDeclaration.field_593 = 0;
            ++var3.bracketBalance;
            this.resetPendingModifiers();
            return var3.add(var1, var2);
        } else {
            if (this.types == null) {
                this.types = new RecoveredType[5];
                this.field_1105 = 0;
            } else if (this.field_1105 == this.types.length) {
                System.arraycopy(this.types, 0, this.types = new RecoveredType[2 * this.field_1105], 0, this.field_1105);
            }
            RecoveredType var10000 = new RecoveredType(var1, this, var2);
            var3 = var10000;
            this.types[this.field_1105++] = var3;
            if (this.field_1109 > 0) {
                var3.attach(this.pendingAnnotations, this.field_1109, this.field_1106, this.field_1107);
            }
            this.resetPendingModifiers();
            if (var1.field_593 == 0) {
                return var3;
            }
            return this;
        }
    }

    public ASTNode parseTree() {
        return this.unitDeclaration;
    }

    public void resetPendingModifiers() {
        this.pendingAnnotations = null;
        this.field_1109 = 0;
        this.field_1106 = 0;
        this.field_1107 = -1;
    }

    public String toString(int var1) {
        StringBuffer var2 = new StringBuffer(this.tabString(var1));
        var2.append("Recovered unit: [\n");
        this.unitDeclaration.print(var1 + 1, var2);
        var2.append(this.tabString(var1 + 1));
        var2.append("]");
        int var3;
        if (this.imports != null) {
            for (var3 = 0; var3 < this.field_1103; ++var3) {
                var2.append("\n");
                var2.append(this.imports[var3].toString(var1 + 1));
            }
        }
        if (this.types != null) {
            for (var3 = 0; var3 < this.field_1105; ++var3) {
                var2.append("\n");
                var2.append(this.types[var3].toString(var1 + 1));
            }
        }
        return var2.toString();
    }

    public CompilationUnitDeclaration updatedCompilationUnitDeclaration() {
        if (this.field_1103 > 0) {
            ImportReference[] var1 = new ImportReference[this.field_1103];
            for (int var2 = 0; var2 < this.field_1103; ++var2) {
                var1[var2] = this.imports[var2].updatedImportReference();
            }
            this.unitDeclaration.imports = var1;
        }
        if (this.field_1105 > 0) {
            int var6 = this.unitDeclaration.types == null ? 0 : this.unitDeclaration.types.length;
            TypeDeclaration[] var7 = new TypeDeclaration[var6 + this.field_1105];
            if (var6 > 0) {
                System.arraycopy(this.unitDeclaration.types, 0, var7, 0, var6);
            }
            if (this.types[this.field_1105 - 1].typeDeclaration.field_593 == 0) {
                this.types[this.field_1105 - 1].typeDeclaration.field_593 = this.unitDeclaration.field_445;
                this.types[this.field_1105 - 1].typeDeclaration.field_595 = this.unitDeclaration.field_445;
            }
            int var3 = var6;
            for (int var4 = 0; var4 < this.field_1105; ++var4) {
                TypeDeclaration var5 = this.types[var4].method_1884();
                if ((var5.field_446 & 256) == 0) {
                    var7[var3++] = var5;
                }
            }
            if (var3 != this.field_1105) {
                System.arraycopy(var7, 0, var7 = new TypeDeclaration[var6 + var3], 0, var6 + var3);
            }
            this.unitDeclaration.types = var7;
        }
        return this.unitDeclaration;
    }

    public void updateParseTree() {
        this.updatedCompilationUnitDeclaration();
    }

    public void updateSourceEndIfNecessary(int var1, int var2) {
        if (this.unitDeclaration.field_445 == 0) {
            this.unitDeclaration.field_445 = var2;
        }
    }
}
