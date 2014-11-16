package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.ASTVisitor;
import org.eclipse.jdt.internal.compiler.ast.NumberLiteral;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.impl.DoubleConstant;
import org.eclipse.jdt.internal.compiler.impl.LongConstant;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.parser.ScannerHelper;

public class LongLiteral extends NumberLiteral {

    static final Constant field_802;

    public LongLiteral(char[] var1, int var2, int var3) {
        super(var1, var2, var3);
    }

    public void computeConstant() {
        int var1 = this.source.length - 1;
        long var2;
        int var8;
        if (this.source[0] == 48) {
            if (var1 == 1) {
                this.constant = LongConstant.fromValue(0L);
                return;
            }
            byte var4;
            byte var5;
            int var6;
            if (this.source[1] != 120 && this.source[1] != 88) {
                var4 = 3;
                var6 = 1;
                var5 = 8;
            } else {
                var4 = 4;
                var6 = 2;
                var5 = 16;
            }
            boolean var7 = false;
            while (this.source[var6] == 48) {
                ++var6;
                if (var6 == var1) {
                    this.constant = LongConstant.fromValue(0L);
                    return;
                }
            }
            if ((var8 = ScannerHelper.digit(this.source[var6++], var5)) < 0) {
                this.constant = field_802;
                return;
            }
            int var11;
            if (var8 >= 8) {
                var11 = 4;
            } else if (var8 >= 4) {
                var11 = 3;
            } else if (var8 >= 2) {
                var11 = 2;
            } else {
                var11 = 1;
            }
            for (var2 = (long)var8; var6 < var1; var2 = var2 << var4 | (long)var8) {
                if ((var8 = ScannerHelper.digit(this.source[var6++], var5)) < 0) {
                    this.constant = field_802;
                    return;
                }
                if ((var11 += var4) > 64) {
                    return;
                }
            }
        } else {
            long var10 = 0L;
            var2 = 0L;
            for (var8 = 0; var8 < var1; ++var8) {
                int var9;
                if ((var9 = ScannerHelper.digit(this.source[var8], 10)) < 0) {
                    return;
                }
                var10 = var2;
                if (var2 > 922337203685477580L) {
                    return;
                }
                var2 *= 10L;
                if (var2 + (long)var9 > Long.MAX_VALUE) {
                    return;
                }
                var2 += (long)var9;
                if (var10 > var2) {
                    return;
                }
            }
        }
        this.constant = LongConstant.fromValue(var2);
    }

    public void generateCode(BlockScope var1, CodeStream var2, boolean var3) {
        int var4 = var2.field_1208;
        if (var3) {
            var2.generateConstant(this.constant, this.field_674);
        }
        var2.method_2360(var4, this.field_444);
    }

    public TypeBinding literalType(BlockScope var1) {
        return TypeBinding.field_183;
    }

    public final boolean mayRepresentMIN_VALUE() {
        return this.source.length == 20 && this.source[0] == 57 && this.source[1] == 50 && this.source[2] == 50 && this.source[3] == 51 && this.source[4] == 51 && this.source[5] == 55 && this.source[6] == 50 && this.source[7] == 48 && this.source[8] == 51 && this.source[9] == 54 && this.source[10] == 56 && this.source[11] == 53 && this.source[12] == 52 && this.source[13] == 55 && this.source[14] == 55 && this.source[15] == 53 && this.source[16] == 56 && this.source[17] == 48 && this.source[18] == 56 && (this.field_446 & 534773760) >> 21 == 0;
    }

    public TypeBinding resolveType(BlockScope var1) {
        TypeBinding var2 = super.resolveType(var1);
        if (this.constant == field_802) {
            this.constant = Constant.NotAConstant;
            var1.problemReporter().method_1511(this);
            this.resolvedType = null;
            return null;
        } else {
            return var2;
        }
    }

    public void traverse(ASTVisitor var1, BlockScope var2) {
        var1.visit(this, var2);
        var1.endVisit(this, var2);
    }

    static {
        field_802 = DoubleConstant.fromValue(Double.POSITIVE_INFINITY);
    }
}
