package org.eclipse.jdt.internal.compiler.ast;

import org.eclipse.jdt.internal.compiler.class_264;
import org.eclipse.jdt.internal.compiler.ast.class_177;
import org.eclipse.jdt.internal.compiler.codegen.class_268;
import org.eclipse.jdt.internal.compiler.impl.class_338;
import org.eclipse.jdt.internal.compiler.lookup.class_40;
import org.eclipse.jdt.internal.compiler.lookup.class_86;
import org.eclipse.jdt.internal.compiler.parser.ScannerHelper;

public class class_182 extends class_177 {

    char field_801;

    public class_182(char[] var1, int var2, int var3) {
        super(var1, var2, var3);
        this.method_1094();
    }

    public void method_1081() {
        this.field_672 = class_338.method_3303(this.field_801);
    }

    private void method_1094() {
        if ((this.field_801 = this.field_792[1]) == 92) {
            char var1;
            switch (var1 = this.field_792[2]) {
                case 34:
                    this.field_801 = 34;
                    break;
                case 39:
                    this.field_801 = 39;
                    break;
                case 92:
                    this.field_801 = 92;
                    break;
                case 98:
                    this.field_801 = 8;
                    break;
                case 102:
                    this.field_801 = 12;
                    break;
                case 110:
                    this.field_801 = 10;
                    break;
                case 114:
                    this.field_801 = 13;
                    break;
                case 116:
                    this.field_801 = 9;
                    break;
                default:
                    int var2 = ScannerHelper.method_3340(var1);
                    if ((var1 = this.field_792[3]) != 39) {
                        var2 = var2 * 8 + ScannerHelper.method_3340(var1);
                        if ((var1 = this.field_792[4]) != 39) {
                            var2 = var2 * 8 + ScannerHelper.method_3340(var1);
                        }
                        this.field_801 = (char)var2;
                    } else {
                        this.field_672 = class_338.method_3303(this.field_801 = (char)var2);
                    }
            }
        }
    }

    public void method_912(class_86 var1, class_268 var2, boolean var3) {
        int var4 = var2.field_1208;
        if (var3) {
            var2.method_2179(this.field_672, this.field_674);
        }
        var2.method_2360(var4, this.field_444);
    }

    public class_40 method_1082(class_86 var1) {
        return class_40.field_182;
    }

    public void method_763(class_264 var1, class_86 var2) {
        var1.method_2007(this, var2);
        var1.method_1922(this, var2);
    }
}