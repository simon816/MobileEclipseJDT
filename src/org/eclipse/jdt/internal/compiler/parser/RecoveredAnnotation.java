package org.eclipse.jdt.internal.compiler.parser;

import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.SingleMemberAnnotation;
import org.eclipse.jdt.internal.compiler.ast.MarkerAnnotation;
import org.eclipse.jdt.internal.compiler.ast.NormalAnnotation;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.MemberValuePair;
import org.eclipse.jdt.internal.compiler.parser.RecoveredElement;
import org.eclipse.jdt.internal.compiler.parser.RecoveryScanner;
import org.eclipse.jdt.internal.compiler.parser.Parser;

public class RecoveredAnnotation extends RecoveredElement {

    private int field_1110;

    private int field_1111;

    private int field_1112;

    private int field_1113;

    public boolean hasPendingMemberValueName;

    public int memberValuPairEqualEnd;

    public Annotation annotation;

    public RecoveredAnnotation(int var1, int var2, int var3, RecoveredElement var4, int var5) {
        super(var4, var5);
        this.memberValuPairEqualEnd = -1;
        this.field_1110 = 0;
        this.field_1111 = var1;
        this.field_1112 = var2;
        this.field_1113 = var3;
    }

    public RecoveredElement add(TypeDeclaration var1, int var2) {
        return (RecoveredElement)(this.annotation == null && (var1.field_446 & 512) != 0 ? this : super.add(var1, var2));
    }

    public RecoveredElement addAnnotationName(int var1, int var2, int var3, int var4) {
        RecoveredAnnotation var10000 = new RecoveredAnnotation(var1, var2, var3, this, var4);
        RecoveredAnnotation var5 = var10000;
        return var5;
    }

    public RecoveredElement addAnnotation(Annotation var1, int var2) {
        this.annotation = var1;
        return (RecoveredElement)(this.parent != null ? this.parent : this);
    }

    public void method_1852() {
        Parser var1 = this.parser();
        if (this.annotation == null && this.field_1111 <= var1.field_1584) {
            Object var2 = null;
            boolean var3 = false;
            MemberValuePair var4 = null;
            int var8;
            int var9;
            if (this.hasPendingMemberValueName && this.field_1111 < var1.field_1584) {
                char[] var5 = var1.identifierStack[this.field_1111 + 1];
                long var6 = var1.identifierPositionStack[this.field_1111 + 1];
                var8 = (int)(var6 >>> 32);
                var9 = (int)var6;
                int var10 = this.memberValuPairEqualEnd > -1 ? this.memberValuPairEqualEnd : var9;
                SingleNameReference var10000 = new SingleNameReference(RecoveryScanner.FAKE_IDENTIFIER, ((long)var10 + 1L << 32) + (long)var10);
                SingleNameReference var11 = var10000;
                MemberValuePair var14 = new MemberValuePair(var5, var8, var9, var11);
                var4 = var14;
            }
            var1.field_1584 = this.field_1111;
            var1.field_1581 = this.field_1112;
            TypeReference var16 = var1.getAnnotationType();
            NormalAnnotation var13;
            Expression var17;
            switch (this.field_1110) {
                case 1:
                    if (var1.field_1559 > -1 && var1.field_1560[var1.field_1559] instanceof MemberValuePair) {
                        var17 = null;
                        int var18 = var1.field_1558[var1.field_1557];
                        var8 = var1.field_1559 - var18 + 1;
                        if (var18 > 0) {
                            MemberValuePair[] var19;
                            if (var4 != null) {
                                var19 = new MemberValuePair[var18 + 1];
                                System.arraycopy(var1.field_1560, var8, var19, 0, var18);
                                --var1.field_1557;
                                var1.field_1559 -= var18;
                                var19[var18] = var4;
                                var9 = var4.field_445;
                            } else {
                                var19 = new MemberValuePair[var18];
                                System.arraycopy(var1.field_1560, var8, var19, 0, var18);
                                --var1.field_1557;
                                var1.field_1559 -= var18;
                                MemberValuePair var22 = var19[var19.length - 1];
                                var9 = var22.value != null ? (var22.value instanceof Annotation ? ((Annotation)var22.value).declarationSourceEnd : var22.value.field_445) : var22.field_445;
                            }
                            var13 = new NormalAnnotation(var16, this.field_1113);
                            NormalAnnotation var23 = var13;
                            var23.memberValuePairs = var19;
                            var23.declarationSourceEnd = var9;
                            var23.field_446 |= 32;
                            var2 = var23;
                            var3 = true;
                        }
                    }
                    break;
                case 2:
                    if (var1.field_1570 > -1) {
                        var17 = var1.expressionStack[var1.field_1570--];
                        SingleMemberAnnotation var15 = new SingleMemberAnnotation(var16, this.field_1113);
                        SingleMemberAnnotation var7 = var15;
                        var7.memberValue = var17;
                        var7.declarationSourceEnd = var17.field_445;
                        var7.field_446 |= 32;
                        var2 = var7;
                        var3 = true;
                    }
            }
            if (!var3) {
                if (var4 != null) {
                    var13 = new NormalAnnotation(var16, this.field_1113);
                    NormalAnnotation var20 = var13;
                    var20.memberValuePairs = new MemberValuePair[] {var4};
                    var20.declarationSourceEnd = var4.value.field_445;
                    var20.field_446 |= 32;
                    var2 = var20;
                } else {
                    MarkerAnnotation var12 = new MarkerAnnotation(var16, this.field_1113);
                    MarkerAnnotation var21 = var12;
                    var21.declarationSourceEnd = var21.field_445;
                    var21.field_446 |= 32;
                    var2 = var21;
                }
            }
            var1.currentElement = this.addAnnotation((Annotation)var2, this.field_1111);
            var1.method_2519(((Annotation)var2).field_444, ((Annotation)var2).declarationSourceEnd);
            if (this.parent != null) {
                this.parent.method_1852();
            }
        }
    }

    public ASTNode parseTree() {
        return this.annotation;
    }

    public void resetPendingModifiers() {
        if (this.parent != null) {
            this.parent.resetPendingModifiers();
        }
    }

    public void setKind(int var1) {
        this.field_1110 = var1;
    }

    public String toString(int var1) {
        return this.annotation != null ? this.tabString(var1) + "Recovered annotation:\n" + this.annotation.print(var1 + 1, new StringBuffer(10)) : this.tabString(var1) + "Recovered annotation: identiferPtr=" + this.field_1111 + " identiferlengthPtr=" + this.field_1112 + "\n";
    }

    public Annotation updatedAnnotationReference() {
        return this.annotation;
    }

    public RecoveredElement updateOnClosingBrace(int var1, int var2) {
        if (this.bracketBalance > 0) {
            --this.bracketBalance;
            return this;
        } else {
            return (RecoveredElement)(this.parent != null ? this.parent.updateOnClosingBrace(var1, var2) : this);
        }
    }

    public void updateParseTree() {
        this.updatedAnnotationReference();
    }
}
