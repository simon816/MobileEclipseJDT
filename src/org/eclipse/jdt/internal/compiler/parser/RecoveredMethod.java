package org.eclipse.jdt.internal.compiler.parser;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ast.ExplicitConstructorCall;
import org.eclipse.jdt.internal.compiler.ast.Block;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeParameter;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.SuperReference;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.MemberValuePair;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ConstructorDeclaration;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.parser.RecoveredElement;
import org.eclipse.jdt.internal.compiler.parser.RecoveredAnnotation;
import org.eclipse.jdt.internal.compiler.parser.RecoveredType;
import org.eclipse.jdt.internal.compiler.parser.RecoveredBlock;
import org.eclipse.jdt.internal.compiler.parser.Scanner;
import org.eclipse.jdt.internal.compiler.parser.Parser;
import org.eclipse.jdt.internal.compiler.util.Util;

public class RecoveredMethod extends RecoveredElement {

    public AbstractMethodDeclaration methodDeclaration;

    public RecoveredAnnotation[] annotations;

    public int field_1090;

    public int field_1091;

    public int field_1092;

    public RecoveredType[] localTypes;

    public int field_1094;

    public RecoveredBlock methodBody;

    public boolean discardBody;

    int field_1097;

    int field_1098;

    RecoveredAnnotation[] pendingAnnotations;

    int field_1100;

    public RecoveredMethod(AbstractMethodDeclaration var1, RecoveredElement var2, int var3, Parser var4) {
        super(var2, var3, var4);
        this.discardBody = true;
        this.field_1098 = -1;
        this.methodDeclaration = var1;
        this.foundOpeningBrace = !this.bodyStartsAtHeaderEnd();
        if (this.foundOpeningBrace) {
            ++this.bracketBalance;
        }
    }

    public RecoveredElement add(Block var1, int var2) {
        if (this.methodDeclaration.field_481 > 0 && var1.field_444 > this.methodDeclaration.field_481) {
            this.resetPendingModifiers();
            return (RecoveredElement)(this.parent == null ? this : this.parent.add(var1, var2));
        } else {
            if (!this.foundOpeningBrace) {
                this.foundOpeningBrace = true;
                ++this.bracketBalance;
            }
            RecoveredBlock var10001 = new RecoveredBlock(var1, this, var2);
            this.methodBody = var10001;
            if (var1.field_445 == 0) {
                return this.methodBody;
            }
            return this;
        }
    }

    public RecoveredElement add(FieldDeclaration var1, int var2) {
        this.resetPendingModifiers();
        char[][] var3;
        if ((var1.field_656 & -17) == 0 && var1.type != null && ((var3 = var1.type.getTypeName()).length != 1 || !CharOperation.method_1364(var3[0], TypeBinding.field_188.method_179()))) {
            if (this.methodDeclaration.field_481 > 0 && var1.field_653 > this.methodDeclaration.field_481) {
                return (RecoveredElement)(this.parent == null ? this : this.parent.add(var1, var2));
            } else {
                if (!this.foundOpeningBrace) {
                    this.foundOpeningBrace = true;
                    ++this.bracketBalance;
                }
                return this;
            }
        } else if (this.parent == null) {
            return this;
        } else {
            this.method_1857(this.previousAvailableLineEnd(var1.field_653 - 1));
            return this.parent.add(var1, var2);
        }
    }

    public RecoveredElement add(LocalDeclaration var1, int var2) {
        this.resetPendingModifiers();
        if (this.methodDeclaration.field_481 != 0 && var1.field_653 > this.methodDeclaration.field_481) {
            return (RecoveredElement)(this.parent == null ? this : this.parent.add(var1, var2));
        } else if (this.methodBody != null) {
            return this.methodBody.add(var1, var2, true);
        } else {
            Block var10000 = new Block(0);
            Block var3 = var10000;
            var3.field_444 = this.methodDeclaration.field_490;
            RecoveredElement var4 = this.add(var3, 1);
            if (this.bracketBalance > 0) {
                for (int var5 = 0; var5 < this.bracketBalance - 1; ++var5) {
                    Block var10001 = new Block(0);
                    var4 = var4.add(var10001, 1);
                }
                this.bracketBalance = 1;
            }
            return var4.add(var1, var2);
        }
    }

    public RecoveredElement add(Statement var1, int var2) {
        this.resetPendingModifiers();
        if (this.methodDeclaration.field_481 != 0 && var1.field_444 > this.methodDeclaration.field_481) {
            return (RecoveredElement)(this.parent == null ? this : this.parent.add(var1, var2));
        } else if (this.methodBody != null) {
            return this.methodBody.add(var1, var2, true);
        } else {
            Block var10000 = new Block(0);
            Block var3 = var10000;
            var3.field_444 = this.methodDeclaration.field_490;
            RecoveredElement var4 = this.add(var3, 1);
            if (this.bracketBalance > 0) {
                for (int var5 = 0; var5 < this.bracketBalance - 1; ++var5) {
                    Block var10001 = new Block(0);
                    var4 = var4.add(var10001, 1);
                }
                this.bracketBalance = 1;
            }
            return var4.add(var1, var2);
        }
    }

    public RecoveredElement add(TypeDeclaration var1, int var2) {
        if (this.methodDeclaration.field_481 != 0 && var1.field_592 > this.methodDeclaration.field_481) {
            return (RecoveredElement)(this.parent == null ? this : this.parent.add(var1, var2));
        } else if ((var1.field_446 & 256) == 0 && !this.parser().field_1621 && !this.parser().field_1622) {
            switch (TypeDeclaration.kind(var1.field_577)) {
                case 2:
                case 4:
                    this.resetPendingModifiers();
                    this.method_1857(this.previousAvailableLineEnd(var1.field_592 - 1));
                    if (this.parent == null) {
                        return this;
                    }
                    return this.parent.add(var1, var2);
                default:
                    if (this.localTypes == null) {
                        this.localTypes = new RecoveredType[5];
                        this.field_1094 = 0;
                    } else if (this.field_1094 == this.localTypes.length) {
                        System.arraycopy(this.localTypes, 0, this.localTypes = new RecoveredType[2 * this.field_1094], 0, this.field_1094);
                    }
                    RecoveredType var5 = new RecoveredType(var1, this, var2);
                    RecoveredType var4 = var5;
                    this.localTypes[this.field_1094++] = var4;
                    if (this.field_1100 > 0) {
                        var4.attach(this.pendingAnnotations, this.field_1100, this.field_1097, this.field_1098);
                    }
                    this.resetPendingModifiers();
                    if (!this.foundOpeningBrace) {
                        this.foundOpeningBrace = true;
                        ++this.bracketBalance;
                    }
                    return var4;
            }
        } else {
            if (this.methodBody == null) {
                Block var10000 = new Block(0);
                Block var3 = var10000;
                var3.field_444 = this.methodDeclaration.field_490;
                this.add(var3, 1);
            }
            this.methodBody.attachPendingModifiers(this.pendingAnnotations, this.field_1100, this.field_1097, this.field_1098);
            this.resetPendingModifiers();
            return this.methodBody.add(var1, var2, true);
        }
    }

    public boolean bodyStartsAtHeaderEnd() {
        return this.methodDeclaration.field_490 == this.methodDeclaration.field_445 + 1;
    }

    public ASTNode parseTree() {
        return this.methodDeclaration;
    }

    public void resetPendingModifiers() {
        this.pendingAnnotations = null;
        this.field_1100 = 0;
        this.field_1097 = 0;
        this.field_1098 = -1;
    }

    public String toString(int var1) {
        StringBuffer var2 = new StringBuffer(this.tabString(var1));
        var2.append("Recovered method:\n");
        this.methodDeclaration.print(var1 + 1, var2);
        int var3;
        if (this.annotations != null) {
            for (var3 = 0; var3 < this.field_1090; ++var3) {
                var2.append("\n");
                var2.append(this.annotations[var3].toString(var1 + 1));
            }
        }
        if (this.localTypes != null) {
            for (var3 = 0; var3 < this.field_1094; ++var3) {
                var2.append("\n");
                var2.append(this.localTypes[var3].toString(var1 + 1));
            }
        }
        if (this.methodBody != null) {
            var2.append("\n");
            var2.append(this.methodBody.toString(var1 + 1));
        }
        return var2.toString();
    }

    public void updateBodyStart(int var1) {
        this.foundOpeningBrace = true;
        this.methodDeclaration.field_490 = var1;
    }

    public AbstractMethodDeclaration method_1866() {
        if (this.field_1091 != 0) {
            this.methodDeclaration.field_482 |= this.field_1091;
            if (this.field_1092 < this.methodDeclaration.field_480) {
                this.methodDeclaration.field_480 = this.field_1092;
            }
        }
        int var3;
        if (this.field_1090 > 0) {
            int var1 = this.methodDeclaration.annotations == null ? 0 : this.methodDeclaration.annotations.length;
            Annotation[] var2 = new Annotation[var1 + this.field_1090];
            if (var1 > 0) {
                System.arraycopy(this.methodDeclaration.annotations, 0, var2, this.field_1090, var1);
            }
            for (var3 = 0; var3 < this.field_1090; ++var3) {
                var2[var3] = this.annotations[var3].updatedAnnotationReference();
            }
            this.methodDeclaration.annotations = var2;
            var3 = this.annotations[0].annotation.field_444;
            if (var3 < this.methodDeclaration.field_480) {
                this.methodDeclaration.field_480 = var3;
            }
        }
        if (this.methodBody != null) {
            Block var4 = this.methodBody.method_1891();
            if (var4 != null) {
                this.methodDeclaration.statements = var4.statements;
                if (this.methodDeclaration.field_481 == 0) {
                    this.methodDeclaration.field_481 = var4.field_445;
                    this.methodDeclaration.field_491 = var4.field_445;
                }
                if (this.methodDeclaration.method_795()) {
                    ConstructorDeclaration var5 = (ConstructorDeclaration)this.methodDeclaration;
                    if (this.methodDeclaration.statements != null && this.methodDeclaration.statements[0] instanceof ExplicitConstructorCall) {
                        var5.constructorCall = (ExplicitConstructorCall)this.methodDeclaration.statements[0];
                        var3 = this.methodDeclaration.statements.length;
                        System.arraycopy(this.methodDeclaration.statements, 1, this.methodDeclaration.statements = new Statement[var3 - 1], 0, var3 - 1);
                    }
                    if (var5.constructorCall == null) {
                        var5.constructorCall = SuperReference.implicitSuperConstructorCall();
                    }
                }
            }
        } else if (this.methodDeclaration.field_481 == 0) {
            if (this.methodDeclaration.field_445 + 1 == this.methodDeclaration.field_490) {
                this.methodDeclaration.field_481 = this.methodDeclaration.field_445;
                this.methodDeclaration.field_490 = this.methodDeclaration.field_445;
                this.methodDeclaration.field_491 = this.methodDeclaration.field_445;
            } else {
                this.methodDeclaration.field_481 = this.methodDeclaration.field_490;
                this.methodDeclaration.field_491 = this.methodDeclaration.field_490;
            }
        }
        if (this.field_1094 > 0) {
            this.methodDeclaration.field_446 |= 2;
        }
        return this.methodDeclaration;
    }

    public void method_1852() {
        if (this.bodyStartsAtHeaderEnd() && this.parent != null) {
            Parser var1 = this.parser();
            if (var1.field_1595 > 0 && var1.field_1557 > 0) {
                int var2;
                int var3;
                boolean var4;
                int var6;
                if (this.methodDeclaration.field_445 == var1.field_1598) {
                    var2 = var1.field_1558[var1.field_1557];
                    var3 = var1.field_1559 - var2;
                    var4 = var3 >= 0;
                    if (var4) {
                        if (!(var1.field_1560[var3] instanceof AbstractMethodDeclaration)) {
                            var4 = false;
                        }
                        int var5 = 1;
                        for (var6 = var2 + 1; var5 < var6; ++var5) {
                            if (!(var1.field_1560[var3 + var5] instanceof TypeReference)) {
                                var4 = false;
                            }
                        }
                    }
                    if (var4) {
                        var1.method_2701();
                    } else {
                        var1.field_1595 = 0;
                    }
                } else {
                    if (var1.field_1563 == 28 || var1.field_1563 == 27) {
                        --var1.field_1558[var1.field_1557];
                        --var1.field_1559;
                        --var1.field_1595;
                        var1.field_1563 = 0;
                    }
                    var2 = var1.field_1558[var1.field_1557];
                    var3 = var1.field_1559 - var2 + 1;
                    var4 = var1.field_1598 < var1.field_1597;
                    MemberValuePair[] var12;
                    for (var12 = null; var2 > 0 && var1.field_1560[var1.field_1559] instanceof MemberValuePair; var4 = true) {
                        System.arraycopy(var1.field_1560, var3, var12 = new MemberValuePair[var2], 0, var2);
                        --var1.field_1557;
                        var1.field_1559 -= var2;
                        var2 = var1.field_1558[var1.field_1557];
                        var3 = var1.field_1559 - var2 + 1;
                    }
                    for (var6 = 0; var6 < var2; ++var6) {
                        ASTNode var7 = var1.field_1560[var3 + var6];
                        if (!(var7 instanceof Argument)) {
                            var1.field_1558[var1.field_1557] = var6;
                            var1.field_1559 = var3 + var6 - 1;
                            var1.field_1595 = var6;
                            var1.field_1563 = 0;
                            break;
                        }
                        Argument var8 = (Argument)var7;
                        char[][] var9 = var8.type.getTypeName();
                        if ((var8.field_656 & -17) != 0 || var9.length == 1 && CharOperation.method_1364(var9[0], TypeBinding.field_188.method_179())) {
                            var1.field_1558[var1.field_1557] = var6;
                            var1.field_1559 = var3 + var6 - 1;
                            var1.field_1595 = var6;
                            var1.field_1563 = 0;
                            break;
                        }
                        if (var4) {
                            var1.field_1598 = var8.field_445 + 1;
                        }
                    }
                    if (var1.field_1595 > 0 && var1.field_1557 > 0) {
                        int var13 = var1.field_1558[var1.field_1557];
                        int var14 = var1.field_1559 - var13;
                        boolean var15 = var14 >= 0;
                        if (var15) {
                            if (!(var1.field_1560[var14] instanceof AbstractMethodDeclaration)) {
                                var15 = false;
                            }
                            int var10 = 1;
                            for (int var11 = var13 + 1; var10 < var11; ++var10) {
                                if (!(var1.field_1560[var14 + var10] instanceof Argument)) {
                                    var15 = false;
                                }
                            }
                        }
                        if (var15) {
                            var1.method_2700();
                            if (var1.currentElement == this) {
                                this.methodDeclaration.field_445 = this.methodDeclaration.arguments[this.methodDeclaration.arguments.length - 1].field_445;
                                this.methodDeclaration.field_490 = this.methodDeclaration.field_445 + 1;
                                var1.field_1590 = this.methodDeclaration.field_490;
                            }
                        }
                    }
                    if (var12 != null) {
                        System.arraycopy(var12, 0, var1.field_1560, var1.field_1559 + 1, var12.length);
                        var1.field_1559 += var12.length;
                        var1.field_1558[++var1.field_1557] = var12.length;
                    }
                }
            }
        }
    }

    public RecoveredElement updateOnClosingBrace(int var1, int var2) {
        if (this.methodDeclaration.method_793()) {
            this.updateSourceEndIfNecessary(var1, var2);
            return (RecoveredElement)(!this.foundOpeningBrace && this.parent != null ? this.parent.updateOnClosingBrace(var1, var2) : this);
        } else {
            if (this.parent != null && this.parent instanceof RecoveredType) {
                int var3 = ((RecoveredType)this.parent).typeDeclaration.field_577;
                if (TypeDeclaration.kind(var3) == 2 && !this.foundOpeningBrace) {
                    this.updateSourceEndIfNecessary(var1 - 1, var1 - 1);
                    return this.parent.updateOnClosingBrace(var1, var2);
                }
            }
            return super.updateOnClosingBrace(var1, var2);
        }
    }

    public RecoveredElement method_1854(int var1, int var2) {
        if (this.bracketBalance == 0) {
            switch (this.parser().field_1593) {
                case -1:
                case 105:
                    break;
                default:
                    this.foundOpeningBrace = true;
                    this.bracketBalance = 1;
            }
        }
        return super.method_1854(var1, var2);
    }

    public void updateParseTree() {
        this.method_1866();
    }

    public void updateSourceEndIfNecessary(int var1, int var2) {
        if (this.methodDeclaration.field_481 == 0) {
            if (this.parser().field_1611 >= var2) {
                this.methodDeclaration.field_481 = this.parser().field_1610;
                this.methodDeclaration.field_491 = this.parser().field_1609;
            } else {
                this.methodDeclaration.field_481 = var2;
                this.methodDeclaration.field_491 = var1 - 1;
            }
        }
    }

    public RecoveredElement addAnnotationName(int var1, int var2, int var3, int var4) {
        if (this.pendingAnnotations == null) {
            this.pendingAnnotations = new RecoveredAnnotation[5];
            this.field_1100 = 0;
        } else if (this.field_1100 == this.pendingAnnotations.length) {
            System.arraycopy(this.pendingAnnotations, 0, this.pendingAnnotations = new RecoveredAnnotation[2 * this.field_1100], 0, this.field_1100);
        }
        RecoveredAnnotation var10000 = new RecoveredAnnotation(var1, var2, var3, this, var4);
        RecoveredAnnotation var5 = var10000;
        this.pendingAnnotations[this.field_1100++] = var5;
        return var5;
    }

    public void addModifier(int var1, int var2) {
        this.field_1097 |= var1;
        if (this.field_1098 < 0) {
            this.field_1098 = var2;
        }
    }

    void attach(TypeParameter[] var1, int var2) {
        if (this.methodDeclaration.field_482 == 0) {
            int var3 = var1[var1.length - 1].field_445;
            Parser var4 = this.parser();
            Scanner var5 = var4.scanner;
            if (Util.getLineNumber(this.methodDeclaration.field_480, var5.field_1256, 0, var5.field_1257) == Util.getLineNumber(var3, var5.field_1256, 0, var5.field_1257)) {
                if (var4.field_1600 <= var3 || var4.field_1600 >= this.methodDeclaration.field_480) {
                    if (this.methodDeclaration instanceof MethodDeclaration) {
                        ((MethodDeclaration)this.methodDeclaration).typeParameters = var1;
                        this.methodDeclaration.field_480 = var2;
                    } else if (this.methodDeclaration instanceof ConstructorDeclaration) {
                        ((ConstructorDeclaration)this.methodDeclaration).typeParameters = var1;
                        this.methodDeclaration.field_480 = var2;
                    }
                }
            }
        }
    }

    public void attach(RecoveredAnnotation[] var1, int var2, int var3, int var4) {
        if (var2 > 0) {
            Annotation[] var5 = this.methodDeclaration.annotations;
            if (var5 != null) {
                this.annotations = new RecoveredAnnotation[var2];
                this.field_1090 = 0;
                label33:
                for (int var6 = 0; var6 < var2; ++var6) {
                    for (int var7 = 0; var7 < var5.length; ++var7) {
                        if (var1[var6].annotation == var5[var7]) {
                            continue label33;
                        }
                    }
                    this.annotations[this.field_1090++] = var1[var6];
                }
            } else {
                this.annotations = var1;
                this.field_1090 = var2;
            }
        }
        if (var3 != 0) {
            this.field_1091 = var3;
            this.field_1092 = var4;
        }
    }
}
