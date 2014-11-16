package org.eclipse.jdt.internal.compiler.parser;

import org.eclipse.jdt.internal.compiler.ast.Block;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Initializer;
import org.eclipse.jdt.internal.compiler.ast.TypeParameter;
import org.eclipse.jdt.internal.compiler.ast.QualifiedAllocationExpression;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.parser.RecoveredElement;
import org.eclipse.jdt.internal.compiler.parser.RecoveredField;
import org.eclipse.jdt.internal.compiler.parser.RecoveredInitializer;
import org.eclipse.jdt.internal.compiler.parser.RecoveredMethod;
import org.eclipse.jdt.internal.compiler.parser.RecoveredAnnotation;
import org.eclipse.jdt.internal.compiler.parser.RecoveredStatement;
import org.eclipse.jdt.internal.compiler.parser.Parser;

public class RecoveredType extends RecoveredStatement {

    public TypeDeclaration typeDeclaration;

    public RecoveredAnnotation[] annotations;

    public int field_1126;

    public int field_1127;

    public int field_1128;

    public RecoveredType[] memberTypes;

    public int field_1130;

    public RecoveredField[] fields;

    public int field_1132;

    public RecoveredMethod[] methods;

    public int field_1134;

    public boolean field_1135;

    public int field_1136;

    public boolean field_1137;

    public TypeParameter[] pendingTypeParameters;

    public int field_1139;

    int field_1140;

    int field_1141;

    RecoveredAnnotation[] pendingAnnotations;

    int field_1143;

    public RecoveredType(TypeDeclaration var1, RecoveredElement var2, int var3) {
        super(var1, var2, var3);
        this.field_1135 = false;
        this.field_1137 = false;
        this.field_1141 = -1;
        this.typeDeclaration = var1;
        if (var1.allocation != null && var1.allocation.type == null) {
            this.foundOpeningBrace = true;
        } else {
            this.foundOpeningBrace = !this.bodyStartsAtHeaderEnd();
        }
        this.field_1137 = TypeDeclaration.kind(var1.field_577) == 3;
        if (this.foundOpeningBrace) {
            ++this.bracketBalance;
        }
        this.field_1135 = this.parser().field_1621 || this.parser().field_1622;
    }

    public RecoveredElement add(AbstractMethodDeclaration var1, int var2) {
        if (this.typeDeclaration.field_593 != 0 && var1.field_480 > this.typeDeclaration.field_593) {
            this.pendingTypeParameters = null;
            this.resetPendingModifiers();
            return this.parent.add(var1, var2);
        } else {
            if (this.methods == null) {
                this.methods = new RecoveredMethod[5];
                this.field_1134 = 0;
            } else if (this.field_1134 == this.methods.length) {
                System.arraycopy(this.methods, 0, this.methods = new RecoveredMethod[2 * this.field_1134], 0, this.field_1134);
            }
            RecoveredMethod var10000 = new RecoveredMethod(var1, this, var2, this.recoveringParser);
            RecoveredMethod var3 = var10000;
            this.methods[this.field_1134++] = var3;
            if (this.pendingTypeParameters != null) {
                var3.attach(this.pendingTypeParameters, this.field_1139);
                this.pendingTypeParameters = null;
            }
            if (this.field_1143 > 0) {
                var3.attach(this.pendingAnnotations, this.field_1143, this.field_1140, this.field_1141);
            }
            this.resetPendingModifiers();
            this.field_1137 = false;
            if (!this.foundOpeningBrace) {
                this.foundOpeningBrace = true;
                ++this.bracketBalance;
            }
            if (var1.field_481 == 0) {
                return var3;
            }
            return this;
        }
    }

    public RecoveredElement add(Block var1, int var2) {
        this.pendingTypeParameters = null;
        this.resetPendingModifiers();
        byte var3 = 0;
        if (this.parser().field_1614 != 0) {
            var3 = 8;
        }
        Initializer var10001 = new Initializer(var1, var3);
        return this.add(var10001, var2);
    }

    public RecoveredElement add(FieldDeclaration var1, int var2) {
        this.pendingTypeParameters = null;
        if (this.typeDeclaration.field_593 != 0 && var1.field_653 > this.typeDeclaration.field_593) {
            this.resetPendingModifiers();
            return this.parent.add(var1, var2);
        } else {
            if (this.fields == null) {
                this.fields = new RecoveredField[5];
                this.field_1132 = 0;
            } else if (this.field_1132 == this.fields.length) {
                System.arraycopy(this.fields, 0, this.fields = new RecoveredField[2 * this.field_1132], 0, this.field_1132);
            }
            Object var3;
            switch (var1.getKind()) {
                case 1:
                case 3:
                    RecoveredField var4 = new RecoveredField(var1, this, var2);
                    var3 = var4;
                    break;
                case 2:
                    RecoveredInitializer var10000 = new RecoveredInitializer(var1, this, var2);
                    var3 = var10000;
                    break;
                default:
                    return this;
            }
            this.fields[this.field_1132++] = (RecoveredField)var3;
            if (this.field_1143 > 0) {
                ((RecoveredField)var3).attach(this.pendingAnnotations, this.field_1143, this.field_1140, this.field_1141);
            }
            this.resetPendingModifiers();
            if (!this.foundOpeningBrace) {
                this.foundOpeningBrace = true;
                ++this.bracketBalance;
            }
            if (var1.field_652 == 0) {
                return (RecoveredElement) var3;
            }
            return this;
        }
    }

    public RecoveredElement add(TypeDeclaration var1, int var2) {
        this.pendingTypeParameters = null;
        if (this.typeDeclaration.field_593 != 0 && var1.field_592 > this.typeDeclaration.field_593) {
            this.resetPendingModifiers();
            return this.parent.add(var1, var2);
        } else {
            this.field_1137 = false;
            if ((var1.field_446 & 512) != 0) {
                if (this.field_1134 > 0) {
                    RecoveredMethod var4 = this.methods[this.field_1134 - 1];
                    var4.methodDeclaration.field_491 = 0;
                    var4.methodDeclaration.field_481 = 0;
                    ++var4.bracketBalance;
                    this.resetPendingModifiers();
                    return var4.add(var1, var2);
                } else {
                    return this;
                }
            } else {
                if (this.memberTypes == null) {
                    this.memberTypes = new RecoveredType[5];
                    this.field_1130 = 0;
                } else if (this.field_1130 == this.memberTypes.length) {
                    System.arraycopy(this.memberTypes, 0, this.memberTypes = new RecoveredType[2 * this.field_1130], 0, this.field_1130);
                }
                RecoveredType var10000 = new RecoveredType(var1, this, var2);
                RecoveredType var3 = var10000;
                this.memberTypes[this.field_1130++] = var3;
                if (this.field_1143 > 0) {
                    var3.attach(this.pendingAnnotations, this.field_1143, this.field_1140, this.field_1141);
                }
                this.resetPendingModifiers();
                if (!this.foundOpeningBrace) {
                    this.foundOpeningBrace = true;
                    ++this.bracketBalance;
                }
                return var1.field_593 == 0 ? var3 : this;
            }
        }
    }

    public void add(TypeParameter[] var1, int var2) {
        this.pendingTypeParameters = var1;
        this.field_1139 = var2;
    }

    public RecoveredElement addAnnotationName(int var1, int var2, int var3, int var4) {
        if (this.pendingAnnotations == null) {
            this.pendingAnnotations = new RecoveredAnnotation[5];
            this.field_1143 = 0;
        } else if (this.field_1143 == this.pendingAnnotations.length) {
            System.arraycopy(this.pendingAnnotations, 0, this.pendingAnnotations = new RecoveredAnnotation[2 * this.field_1143], 0, this.field_1143);
        }
        RecoveredAnnotation var10000 = new RecoveredAnnotation(var1, var2, var3, this, var4);
        RecoveredAnnotation var5 = var10000;
        this.pendingAnnotations[this.field_1143++] = var5;
        return var5;
    }

    public void addModifier(int var1, int var2) {
        this.field_1140 |= var1;
        if (this.field_1141 < 0) {
            this.field_1141 = var2;
        }
    }

    public void attach(RecoveredAnnotation[] var1, int var2, int var3, int var4) {
        if (var2 > 0) {
            Annotation[] var5 = this.typeDeclaration.annotations;
            if (var5 != null) {
                this.annotations = new RecoveredAnnotation[var2];
                this.field_1126 = 0;
                label33:
                for (int var6 = 0; var6 < var2; ++var6) {
                    for (int var7 = 0; var7 < var5.length; ++var7) {
                        if (var1[var6].annotation == var5[var7]) {
                            continue label33;
                        }
                    }
                    this.annotations[this.field_1126++] = var1[var6];
                }
            } else {
                this.annotations = var1;
                this.field_1126 = var2;
            }
        }
        if (var3 != 0) {
            this.field_1127 = var3;
            this.field_1128 = var4;
        }
    }

    public int method_1882() {
        return this.field_1136 == 0 ? this.typeDeclaration.field_593 : this.field_1136;
    }

    public boolean bodyStartsAtHeaderEnd() {
        return this.typeDeclaration.superInterfaces == null ? (this.typeDeclaration.superclass == null ? (this.typeDeclaration.typeParameters == null ? this.typeDeclaration.field_594 == this.typeDeclaration.field_445 + 1 : this.typeDeclaration.field_594 == this.typeDeclaration.typeParameters[this.typeDeclaration.typeParameters.length - 1].field_445 + 1) : this.typeDeclaration.field_594 == this.typeDeclaration.superclass.field_445 + 1) : this.typeDeclaration.field_594 == this.typeDeclaration.superInterfaces[this.typeDeclaration.superInterfaces.length - 1].field_445 + 1;
    }

    public RecoveredType enclosingType() {
        for (RecoveredElement var1 = this.parent; var1 != null; var1 = var1.parent) {
            if (var1 instanceof RecoveredType) {
                return (RecoveredType)var1;
            }
        }
        return null;
    }

    public ASTNode parseTree() {
        return this.typeDeclaration;
    }

    public void resetPendingModifiers() {
        this.pendingAnnotations = null;
        this.field_1143 = 0;
        this.field_1140 = 0;
        this.field_1141 = -1;
    }

    public String toString(int var1) {
        StringBuffer var2 = new StringBuffer(this.tabString(var1));
        var2.append("Recovered type:\n");
        if ((this.typeDeclaration.field_446 & 512) != 0) {
            var2.append(this.tabString(var1));
            var2.append(" ");
        }
        this.typeDeclaration.print(var1 + 1, var2);
        int var3;
        if (this.annotations != null) {
            for (var3 = 0; var3 < this.field_1126; ++var3) {
                var2.append("\n");
                var2.append(this.annotations[var3].toString(var1 + 1));
            }
        }
        if (this.memberTypes != null) {
            for (var3 = 0; var3 < this.field_1130; ++var3) {
                var2.append("\n");
                var2.append(this.memberTypes[var3].toString(var1 + 1));
            }
        }
        if (this.fields != null) {
            for (var3 = 0; var3 < this.field_1132; ++var3) {
                var2.append("\n");
                var2.append(this.fields[var3].toString(var1 + 1));
            }
        }
        if (this.methods != null) {
            for (var3 = 0; var3 < this.field_1134; ++var3) {
                var2.append("\n");
                var2.append(this.methods[var3].toString(var1 + 1));
            }
        }
        return var2.toString();
    }

    public void updateBodyStart(int var1) {
        this.foundOpeningBrace = true;
        this.typeDeclaration.field_594 = var1;
    }

    public Statement method_1876() {
        if ((this.typeDeclaration.field_446 & 512) != 0 && !this.field_1135) {
            return null;
        } else {
            TypeDeclaration var1 = this.method_1884();
            if ((var1.field_446 & 512) != 0) {
                QualifiedAllocationExpression var2 = var1.allocation;
                if (var2.field_673 == -1) {
                    var2.field_673 = var1.field_593;
                }
                return var2;
            } else {
                return var1;
            }
        }
    }

    public TypeDeclaration method_1884() {
        int var1 = this.typeDeclaration.field_594;
        if (this.field_1127 != 0) {
            this.typeDeclaration.field_577 |= this.field_1127;
            if (this.field_1128 < this.typeDeclaration.field_592) {
                this.typeDeclaration.field_592 = this.field_1128;
            }
        }
        int var2;
        int var4;
        if (this.field_1126 > 0) {
            var2 = this.typeDeclaration.annotations == null ? 0 : this.typeDeclaration.annotations.length;
            Annotation[] var3 = new Annotation[var2 + this.field_1126];
            if (var2 > 0) {
                System.arraycopy(this.typeDeclaration.annotations, 0, var3, this.field_1126, var2);
            }
            for (var4 = 0; var4 < this.field_1126; ++var4) {
                var3[var4] = this.annotations[var4].updatedAnnotationReference();
            }
            this.typeDeclaration.annotations = var3;
            var4 = this.annotations[0].annotation.field_444;
            if (var4 < this.typeDeclaration.field_592) {
                this.typeDeclaration.field_592 = var4;
            }
        }
        if (this.field_1130 > 0) {
            var2 = this.typeDeclaration.memberTypes == null ? 0 : this.typeDeclaration.memberTypes.length;
            TypeDeclaration[] var10 = new TypeDeclaration[var2 + this.field_1130];
            if (var2 > 0) {
                System.arraycopy(this.typeDeclaration.memberTypes, 0, var10, 0, var2);
            }
            if (this.memberTypes[this.field_1130 - 1].typeDeclaration.field_593 == 0) {
                var4 = this.method_1882();
                this.memberTypes[this.field_1130 - 1].typeDeclaration.field_593 = var4;
                this.memberTypes[this.field_1130 - 1].typeDeclaration.field_595 = var4;
            }
            for (var4 = 0; var4 < this.field_1130; ++var4) {
                var10[var2 + var4] = this.memberTypes[var4].method_1884();
            }
            this.typeDeclaration.memberTypes = var10;
            if (var10[var10.length - 1].field_593 > var1) {
                var1 = var10[var10.length - 1].field_593;
            }
        }
        if (this.field_1132 > 0) {
            var2 = this.typeDeclaration.fields == null ? 0 : this.typeDeclaration.fields.length;
            FieldDeclaration[] var11 = new FieldDeclaration[var2 + this.field_1132];
            if (var2 > 0) {
                System.arraycopy(this.typeDeclaration.fields, 0, var11, 0, var2);
            }
            if (this.fields[this.field_1132 - 1].fieldDeclaration.field_652 == 0) {
                var4 = this.method_1882();
                this.fields[this.field_1132 - 1].fieldDeclaration.field_652 = var4;
                this.fields[this.field_1132 - 1].fieldDeclaration.field_651 = var4;
            }
            for (var4 = 0; var4 < this.field_1132; ++var4) {
                var11[var2 + var4] = this.fields[var4].method_1863();
            }
            this.typeDeclaration.fields = var11;
            if (var11[var11.length - 1].field_652 > var1) {
                var1 = var11[var11.length - 1].field_652;
            }
        }
        var2 = this.typeDeclaration.methods == null ? 0 : this.typeDeclaration.methods.length;
        boolean var12 = false;
        boolean var14 = false;
        boolean var5 = false;
        int var6 = -1;
        AbstractMethodDeclaration[] var7;
        int var8;
        int var13;
        if (this.field_1134 > 0) {
            var7 = new AbstractMethodDeclaration[var2 + this.field_1134];
            AbstractMethodDeclaration var9;
            for (var8 = 0; var8 < var2; ++var8) {
                var9 = this.typeDeclaration.methods[var8];
                if (var9.method_796()) {
                    var6 = var8;
                }
                if (var9.method_792()) {
                    var5 = true;
                }
                var7[var8] = var9;
            }
            if (this.methods[this.field_1134 - 1].methodDeclaration.field_481 == 0) {
                var8 = this.method_1882();
                this.methods[this.field_1134 - 1].methodDeclaration.field_481 = var8;
                this.methods[this.field_1134 - 1].methodDeclaration.field_491 = var8;
            }
            for (var8 = 0; var8 < this.field_1134; ++var8) {
                var9 = this.methods[var8].method_1866();
                if (var9.method_795()) {
                    var14 = true;
                }
                if (var9.method_792()) {
                    var5 = true;
                }
                var7[var2 + var8] = var9;
            }
            this.typeDeclaration.methods = var7;
            if (var7[var7.length - 1].field_481 > var1) {
                var1 = var7[var7.length - 1].field_481;
            }
            if (var5) {
                this.typeDeclaration.field_446 |= 2048;
            }
            var12 = this.typeDeclaration.checkConstructors(this.parser());
        } else {
            for (var13 = 0; var13 < var2; ++var13) {
                if (this.typeDeclaration.methods[var13].method_795()) {
                    var12 = true;
                }
            }
        }
        if (this.typeDeclaration.needClassInitMethod()) {
            boolean var15 = false;
            for (var8 = 0; var8 < var2; ++var8) {
                if (this.typeDeclaration.methods[var8].method_794()) {
                    var15 = true;
                    break;
                }
            }
            if (!var15) {
                this.typeDeclaration.addClinit();
            }
        }
        if (var6 >= 0 && var14) {
            var7 = new AbstractMethodDeclaration[this.typeDeclaration.methods.length - 1];
            if (var6 != 0) {
                System.arraycopy(this.typeDeclaration.methods, 0, var7, 0, var6);
            }
            if (var6 != this.typeDeclaration.methods.length - 1) {
                System.arraycopy(this.typeDeclaration.methods, var6 + 1, var7, var6, this.typeDeclaration.methods.length - var6 - 1);
            }
            this.typeDeclaration.methods = var7;
        } else {
            var13 = TypeDeclaration.kind(this.typeDeclaration.field_577);
            if (!var12 && var13 != 2 && var13 != 4 && this.typeDeclaration.allocation == null) {
                boolean var17 = false;
                for (RecoveredElement var16 = this.parent; var16 != null; var16 = var16.parent) {
                    if (var16 instanceof RecoveredField) {
                        var17 = true;
                        break;
                    }
                }
                this.typeDeclaration.createDefaultConstructor(!this.parser().field_1564 || var17, true);
            }
        }
        if (this.parent instanceof RecoveredType) {
            this.typeDeclaration.field_446 |= 1024;
        } else if (this.parent instanceof RecoveredMethod) {
            this.typeDeclaration.field_446 |= 256;
        }
        if (this.typeDeclaration.field_593 == 0) {
            this.typeDeclaration.field_593 = var1;
            this.typeDeclaration.field_595 = var1;
        }
        return this.typeDeclaration;
    }

    public void method_1852() {
        if (this.bodyStartsAtHeaderEnd() && this.typeDeclaration.allocation == null) {
            Parser var1 = this.parser();
            int var2;
            int var3;
            boolean var4;
            int var5;
            if (var1.field_1595 > 0 && var1.field_1557 > 0) {
                var2 = var1.field_1558[var1.field_1557];
                var3 = var1.field_1559 - var2;
                var4 = var3 >= 0;
                if (var4) {
                    if (!(var1.field_1560[var3] instanceof TypeDeclaration)) {
                        var4 = false;
                    }
                    var5 = 1;
                    for (int var6 = var2 + 1; var5 < var6; ++var5) {
                        if (!(var1.field_1560[var3 + var5] instanceof TypeReference)) {
                            var4 = false;
                        }
                    }
                }
                if (var4) {
                    var1.method_2575();
                }
            } else if (var1.field_1596 > 0) {
                var2 = var1.field_1596;
                var3 = var1.field_1577;
                var4 = var3 + 1 >= var2 && var1.field_1559 > -1;
                if (var4) {
                    if (!(var1.field_1560[var1.field_1559] instanceof TypeDeclaration)) {
                        var4 = false;
                    }
                    while (var3 + 1 > var2 && !(var1.field_1578[var3] instanceof TypeParameter)) {
                        --var3;
                    }
                    for (var5 = 0; var5 < var2; ++var5) {
                        if (!(var1.field_1578[var3 - var5] instanceof TypeParameter)) {
                            var4 = false;
                        }
                    }
                }
                if (var4) {
                    TypeDeclaration var7 = (TypeDeclaration)var1.field_1560[var1.field_1559];
                    System.arraycopy(var1.field_1578, var3 - var2 + 1, var7.typeParameters = new TypeParameter[var2], 0, var2);
                    var7.field_594 = var7.typeParameters[var2 - 1].field_652 + 1;
                    var1.field_1596 = 0;
                    var1.field_1590 = var7.field_594;
                }
            }
        }
    }

    public RecoveredElement updateOnClosingBrace(int var1, int var2) {
        if (--this.bracketBalance <= 0 && this.parent != null) {
            this.updateSourceEndIfNecessary(var1, var2);
            this.field_1136 = var1 - 1;
            return this.parent;
        } else {
            return this;
        }
    }

    public RecoveredElement method_1854(int var1, int var2) {
        if (this.bracketBalance == 0) {
            Parser var3 = this.parser();
            switch (var3.field_1593) {
                case -1:
                case 10:
                case 11:
                case 13:
                case 99:
                case 106:
                    if (var3.field_1614 == 0) {
                        break;
                    }
                default:
                    this.foundOpeningBrace = true;
                    this.bracketBalance = 1;
            }
        }
        if (this.bracketBalance == 1) {
            Block var10000 = new Block(0);
            Block var6 = var10000;
            Parser var4 = this.parser();
            var6.field_444 = var4.scanner.field_1230;
            Initializer var5;
            Initializer var7;
            if (var4.field_1614 == 0) {
                var7 = new Initializer(var6, 0);
                var5 = var7;
            } else {
                var7 = new Initializer(var6, 8);
                var5 = var7;
                var5.field_653 = var4.field_1614;
            }
            var5.field_666 = var4.scanner.field_1231;
            return this.add(var5, 1);
        } else {
            return super.method_1854(var1, var2);
        }
    }

    public void updateParseTree() {
        this.method_1884();
    }

    public void updateSourceEndIfNecessary(int var1, int var2) {
        if (this.typeDeclaration.field_593 == 0) {
            this.field_1136 = 0;
            this.typeDeclaration.field_593 = var2;
            this.typeDeclaration.field_595 = var2;
        }
    }
}
