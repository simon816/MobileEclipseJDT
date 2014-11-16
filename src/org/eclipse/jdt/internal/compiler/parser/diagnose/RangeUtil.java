package org.eclipse.jdt.internal.compiler.parser.diagnose;

import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Initializer;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.parser.diagnose.RangeUtil$RangeResult;

public class RangeUtil {

    public RangeUtil() {
    }

    public static boolean method_1340(AbstractMethodDeclaration var0) {
        return var0.field_445 + 1 == var0.field_490 || var0.field_491 == var0.field_481;
    }

    public static int[][] computeDietRange(TypeDeclaration[] var0) {
        if (var0 != null && var0.length != 0) {
            RangeUtil$RangeResult var10000 = new RangeUtil$RangeResult();
            RangeUtil$RangeResult var1 = var10000;
            computeDietRange0(var0, var1);
            return var1.getRanges();
        } else {
            return new int[3][0];
        }
    }

    private static void computeDietRange0(TypeDeclaration[] var0, RangeUtil$RangeResult var1) {
        for (int var2 = 0; var2 < var0.length; ++var2) {
            TypeDeclaration[] var3 = var0[var2].memberTypes;
            if (var3 != null && var3.length > 0) {
                computeDietRange0(var0[var2].memberTypes, var1);
            }
            AbstractMethodDeclaration[] var4 = var0[var2].methods;
            int var6;
            if (var4 != null) {
                int var5 = var4.length;
                for (var6 = 0; var6 < var5; ++var6) {
                    AbstractMethodDeclaration var7 = var4[var6];
                    if (method_1343(var7)) {
                        if (method_1340(var7)) {
                            var7.field_446 |= 32;
                            var1.addInterval(var7.field_480, var7.field_481, 2);
                        } else {
                            int var8 = var7.field_445 + 1 == var7.field_490 ? 1 : 0;
                            var1.addInterval(var7.field_490, var7.field_491, var8);
                        }
                    }
                }
            }
            FieldDeclaration[] var9 = var0[var2].fields;
            if (var9 != null) {
                var6 = var9.length;
                for (int var10 = 0; var10 < var6; ++var10) {
                    if (var9[var10] instanceof Initializer) {
                        Initializer var11 = (Initializer)var9[var10];
                        if (var11.field_652 == var11.field_667 && var11.field_653 != var11.field_652) {
                            var11.field_446 |= 32;
                            var1.addInterval(var11.field_653, var11.field_652, 2);
                        } else {
                            var1.addInterval(var11.field_666, var11.field_667);
                        }
                    }
                }
            }
        }
    }

    public static boolean method_1343(AbstractMethodDeclaration var0) {
        return !var0.method_796() && !var0.method_794() && (var0.field_482 & 16777216) == 0;
    }
}
