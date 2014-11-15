package org.eclipse.jdt.internal.compiler.flow;

import org.eclipse.jdt.internal.compiler.ast.class_126;
import org.eclipse.jdt.internal.compiler.ast.class_154;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.flow.class_293;
import org.eclipse.jdt.internal.compiler.flow.class_301;
import org.eclipse.jdt.internal.compiler.lookup.class_64;
import org.eclipse.jdt.internal.compiler.lookup.class_65;
import org.eclipse.jdt.internal.compiler.lookup.class_67;
import org.eclipse.jdt.internal.compiler.lookup.class_83;
import org.eclipse.jdt.internal.compiler.lookup.class_86;

public class class_300 extends class_293 {

    class_154[] field_1776;

    class_64[] field_1777;

    int field_1778;

    class_65[] field_1779;

    class_126[] field_1780;

    int[] field_1781;

    int field_1782;

    public class_300(class_293 var1, ASTNode var2) {
        super(var1, var2);
    }

    public void method_3068(class_301 var1, class_86 var2) {
        int var3;
        for (var3 = 0; var3 < this.field_1778; ++var3) {
            class_64 var4 = this.field_1777[var3];
            if (var4 != null) {
                boolean var5 = false;
                if (var4 instanceof class_67) {
                    if (var1.method_3087((class_67)var4)) {
                        var5 = true;
                        var2.method_644().method_1527((class_67)var4, this.field_1776[var3]);
                    }
                } else if (var1.method_3088((class_65)var4)) {
                    var5 = true;
                    var2.method_644().method_1528((class_65)var4, this.field_1776[var3]);
                }
                if (var5) {
                    for (class_293 var6 = this.field_1740; var6 != null; var6 = var6.field_1740) {
                        var6.method_3051(this.field_1776[var3]);
                    }
                }
            }
        }
        if (this.field_1742) {
            for (var3 = 0; var3 < this.field_1782; ++var3) {
                this.field_1740.method_3050(var2, this.field_1779[var3], this.field_1780[var3], this.field_1781[var3], var1);
            }
        } else {
            for (var3 = 0; var3 < this.field_1782; ++var3) {
                class_126 var7 = this.field_1780[var3];
                class_65 var8 = this.field_1779[var3];
                switch (this.field_1781[var3]) {
                    case 3:
                        if (var1.method_3085(var8)) {
                            var2.method_644().method_1665(var8, var7);
                        } else if (var1.method_3090(var8)) {
                            var2.method_644().method_1666(var8, var7);
                        }
                        break;
                    case 256:
                    case 512:
                        if (var1.method_3084(var8)) {
                            if (this.field_1781[var3] == 512) {
                                var2.method_644().method_1667(var8, var7);
                            } else {
                                var2.method_644().method_1662(var8, var7);
                            }
                            break;
                        }
                    case 257:
                    case 513:
                    case 769:
                    case 1025:
                        if (var1.method_3085(var8)) {
                            switch (this.field_1781[var3] & -256) {
                                case 256:
                                    var2.method_644().method_1668(var8, var7);
                                    break;
                                case 512:
                                    var2.method_644().method_1663(var8, var7);
                                    break;
                                case 768:
                                    var2.method_644().method_1669(var8, var7);
                                    break;
                                case 1024:
                                    var2.method_644().method_1664(var8, var7);
                            }
                        }
                }
            }
        }
    }

    public String method_3039() {
        StringBuffer var1 = new StringBuffer("Finally flow context");
        var1.append("[finalAssignments count - ").append(this.field_1778).append(']');
        var1.append("[nullReferences count - ").append(this.field_1782).append(']');
        return var1.toString();
    }

    protected boolean method_3047(class_64 var1, class_154 var2) {
        if (this.field_1778 == 0) {
            this.field_1776 = new class_154[5];
            this.field_1777 = new class_64[5];
        } else {
            if (this.field_1778 == this.field_1776.length) {
                System.arraycopy(this.field_1776, 0, this.field_1776 = new class_154[this.field_1778 * 2], 0, this.field_1778);
            }
            System.arraycopy(this.field_1777, 0, this.field_1777 = new class_64[this.field_1778 * 2], 0, this.field_1778);
        }
        this.field_1776[this.field_1778] = var2;
        this.field_1777[this.field_1778++] = var1;
        return true;
    }

    public void method_3050(class_83 var1, class_65 var2, class_126 var3, int var4, class_301 var5) {
        if ((var5.field_1783 & 1) == 0 && !var5.method_3086(var2)) {
            if (this.field_1742) {
                switch (var4) {
                    case 3:
                        if (var5.method_3076(var2)) {
                            return;
                        }
                        if (var5.method_3077(var2)) {
                            var1.method_644().method_1665(var2, var3);
                            return;
                        }
                        break;
                    case 256:
                    case 257:
                    case 512:
                    case 513:
                    case 769:
                    case 1025:
                        if (var5.method_3076(var2)) {
                            if (var4 == 512) {
                                var1.method_644().method_1667(var2, var3);
                            } else {
                                var1.method_644().method_1662(var2, var3);
                            }
                            return;
                        }
                        if (var5.method_3077(var2)) {
                            switch (var4 & -256) {
                                case 256:
                                    var1.method_644().method_1668(var2, var3);
                                    return;
                                case 512:
                                    var1.method_644().method_1663(var2, var3);
                                    return;
                                case 768:
                                    var1.method_644().method_1669(var2, var3);
                                    return;
                                case 1024:
                                    var1.method_644().method_1664(var2, var3);
                                    return;
                            }
                        }
                }
            } else {
                switch (var4) {
                    case 3:
                        if (var5.method_3085(var2)) {
                            var1.method_644().method_1665(var2, var3);
                            return;
                        }
                        if (var5.method_3090(var2)) {
                            var1.method_644().method_1666(var2, var3);
                            return;
                        }
                        if (var5.method_3084(var2)) {
                            return;
                        }
                        break;
                    case 256:
                    case 512:
                        if (var5.method_3084(var2)) {
                            if (var4 == 512) {
                                var1.method_644().method_1667(var2, var3);
                            } else {
                                var1.method_644().method_1662(var2, var3);
                            }
                            return;
                        }
                    case 257:
                    case 513:
                    case 769:
                    case 1025:
                        if (var5.method_3085(var2)) {
                            switch (var4 & -256) {
                                case 256:
                                    var1.method_644().method_1668(var2, var3);
                                    return;
                                case 512:
                                    var1.method_644().method_1663(var2, var3);
                                    return;
                                case 768:
                                    var1.method_644().method_1669(var2, var3);
                                    return;
                                case 1024:
                                    var1.method_644().method_1664(var2, var3);
                                    return;
                            }
                        }
                }
            }
            this.method_3069(var2, var3, var4);
        }
    }

    void method_3051(class_154 var1) {
        for (int var2 = 0; var2 < this.field_1778; ++var2) {
            if (this.field_1776[var2] == var1) {
                this.field_1776[var2] = null;
                this.field_1777[var2] = null;
                return;
            }
        }
    }

    protected void method_3069(class_65 var1, class_126 var2, int var3) {
        if (this.field_1782 == 0) {
            this.field_1779 = new class_65[5];
            this.field_1780 = new class_126[5];
            this.field_1781 = new int[5];
        } else if (this.field_1782 == this.field_1779.length) {
            int var4 = this.field_1782 * 2;
            System.arraycopy(this.field_1779, 0, this.field_1779 = new class_65[var4], 0, this.field_1782);
            System.arraycopy(this.field_1780, 0, this.field_1780 = new class_126[var4], 0, this.field_1782);
            System.arraycopy(this.field_1781, 0, this.field_1781 = new int[var4], 0, this.field_1782);
        }
        this.field_1779[this.field_1782] = var1;
        this.field_1780[this.field_1782] = var2;
        this.field_1781[this.field_1782++] = var3;
    }
}
