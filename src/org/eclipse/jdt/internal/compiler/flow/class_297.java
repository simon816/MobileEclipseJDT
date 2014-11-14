package org.eclipse.jdt.internal.compiler.flow;

import org.eclipse.jdt.internal.compiler.ast.class_126;
import org.eclipse.jdt.internal.compiler.ast.class_154;
import org.eclipse.jdt.internal.compiler.ast.class_89;
import org.eclipse.jdt.internal.compiler.codegen.class_74;
import org.eclipse.jdt.internal.compiler.flow.class_293;
import org.eclipse.jdt.internal.compiler.flow.class_295;
import org.eclipse.jdt.internal.compiler.flow.class_296;
import org.eclipse.jdt.internal.compiler.flow.class_301;
import org.eclipse.jdt.internal.compiler.flow.class_303;
import org.eclipse.jdt.internal.compiler.lookup.class_64;
import org.eclipse.jdt.internal.compiler.lookup.class_65;
import org.eclipse.jdt.internal.compiler.lookup.class_67;
import org.eclipse.jdt.internal.compiler.lookup.class_83;
import org.eclipse.jdt.internal.compiler.lookup.class_86;

public class class_297 extends class_295 {

    public class_74 field_1748;

    public class_303 field_1749;

    private class_303 field_1750;

    private class_297[] field_1751;

    private class_303[] field_1752;

    private int field_1753;

    private class_296[] field_1754;

    private int field_1755;

    class_154[] field_1756;

    class_64[] field_1757;

    int field_1758;

    class_65[] field_1759;

    class_126[] field_1760;

    int[] field_1761;

    int field_1762;

    class_83 field_1763;

    public class_297(class_293 var1, class_301 var2, class_89 var3, class_74 var4, class_74 var5, class_83 var6) {
        super(var1, var3, var4);
        this.field_1749 = class_301.field_1784;
        this.field_1751 = null;
        this.field_1752 = null;
        this.field_1753 = 0;
        this.field_1754 = null;
        this.field_1755 = 0;
        this.field_1758 = 0;
        this.field_1743 = true;
        this.field_1748 = var5;
        this.field_1763 = var6;
        this.field_1750 = var2.method_3107();
    }

    public void method_3057(class_86 var1, class_301 var2) {
        for (int var3 = 0; var3 < this.field_1758; ++var3) {
            class_64 var4 = this.field_1757[var3];
            if (var4 != null) {
                boolean var5 = false;
                if (var4 instanceof class_67) {
                    if (var2.method_3087((class_67)var4)) {
                        var5 = true;
                        var1.method_644().method_1527((class_67)var4, this.field_1756[var3]);
                    }
                } else if (var2.method_3088((class_65)var4)) {
                    var5 = true;
                    var1.method_644().method_1528((class_65)var4, this.field_1756[var3]);
                }
                if (var5) {
                    for (class_293 var6 = this.field_1740; var6 != null; var6 = var6.field_1740) {
                        var6.method_3051(this.field_1756[var3]);
                    }
                }
            }
        }
    }

    public void method_3058(class_86 var1, class_301 var2) {
        for (int var3 = 0; var3 < this.field_1753; ++var3) {
            this.field_1750.method_3113(this.field_1751[var3].field_1750).method_3113(this.field_1752[var3]);
        }
        this.field_1753 = 0;
        class_303 var7 = this.field_1750.method_3113(var2.method_3110());
        int var4;
        if (this.field_1742) {
            for (var4 = 0; var4 < this.field_1762; ++var4) {
                class_65 var5 = this.field_1759[var4];
                class_126 var6 = this.field_1760[var4];
                switch (this.field_1761[var4]) {
                    case 3:
                        if (var7.method_3085(var5)) {
                            this.field_1760[var4] = null;
                            var1.method_644().method_1665(var5, var6);
                            continue;
                        }
                        break;
                    case 256:
                    case 512:
                        if (var7.method_3084(var5)) {
                            this.field_1760[var4] = null;
                            if (this.field_1761[var4] == 512) {
                                var1.method_644().method_1667(var5, var6);
                            } else {
                                var1.method_644().method_1662(var5, var6);
                            }
                            continue;
                        }
                        if (var7.method_3085(var5)) {
                            this.field_1760[var4] = null;
                            if (this.field_1761[var4] == 256) {
                                var1.method_644().method_1668(var5, var6);
                            } else {
                                var1.method_644().method_1663(var5, var6);
                            }
                            continue;
                        }
                        break;
                    case 257:
                    case 513:
                    case 769:
                    case 1025:
                        if (var7.method_3085(var5)) {
                            this.field_1760[var4] = null;
                            switch (this.field_1761[var4] & -256) {
                                case 256:
                                    var1.method_644().method_1668(var5, var6);
                                    continue;
                                case 512:
                                    var1.method_644().method_1663(var5, var6);
                                    continue;
                                case 768:
                                    var1.method_644().method_1669(var5, var6);
                                    continue;
                                case 1024:
                                    var1.method_644().method_1664(var5, var6);
                                    continue;
                            }
                        }
                        break;
                    case 258:
                    case 514:
                        if (var7.method_3084(var5)) {
                            this.field_1760[var4] = null;
                            if (this.field_1761[var4] == 514) {
                                var1.method_644().method_1667(var5, var6);
                            } else {
                                var1.method_644().method_1662(var5, var6);
                            }
                            continue;
                        }
                }
                this.field_1740.method_3050(var1, var5, var6, this.field_1761[var4], var7);
            }
        } else {
            for (var4 = 0; var4 < this.field_1762; ++var4) {
                class_126 var8 = this.field_1760[var4];
                class_65 var9 = this.field_1759[var4];
                switch (this.field_1761[var4]) {
                    case 3:
                        if (var7.method_3085(var9)) {
                            this.field_1760[var4] = null;
                            var1.method_644().method_1665(var9, var8);
                        } else if (var7.method_3090(var9)) {
                            this.field_1760[var4] = null;
                            var1.method_644().method_1666(var9, var8);
                        }
                        break;
                    case 256:
                    case 512:
                        if (var7.method_3084(var9)) {
                            this.field_1760[var4] = null;
                            if (this.field_1761[var4] == 512) {
                                var1.method_644().method_1667(var9, var8);
                            } else {
                                var1.method_644().method_1662(var9, var8);
                            }
                            break;
                        }
                    case 257:
                    case 513:
                    case 769:
                    case 1025:
                        if (var7.method_3085(var9)) {
                            this.field_1760[var4] = null;
                            switch (this.field_1761[var4] & -256) {
                                case 256:
                                    var1.method_644().method_1668(var9, var8);
                                    break;
                                case 512:
                                    var1.method_644().method_1663(var9, var8);
                                    break;
                                case 768:
                                    var1.method_644().method_1669(var9, var8);
                                    break;
                                case 1024:
                                    var1.method_644().method_1664(var9, var8);
                            }
                        }
                }
            }
        }
        this.field_1746.method_3113(var7);
        for (var4 = 0; var4 < this.field_1755; ++var4) {
            this.field_1754[var4].field_1746.method_3113(var7);
        }
    }

    public class_74 method_3034() {
        return this.field_1748;
    }

    public String method_3039() {
        StringBuffer var1 = new StringBuffer("Looping flow context");
        var1.append("[initsOnBreak - ").append(this.field_1746.toString()).append(']');
        var1.append("[initsOnContinue - ").append(this.field_1749.toString()).append(']');
        var1.append("[finalAssignments count - ").append(this.field_1758).append(']');
        var1.append("[nullReferences count - ").append(this.field_1762).append(']');
        return var1.toString();
    }

    public boolean method_3041() {
        return true;
    }

    public void method_3045(class_293 var1) {
        if (var1 instanceof class_296) {
            int var2;
            if ((var2 = this.field_1755++) == 0) {
                this.field_1754 = new class_296[2];
            } else if (var2 == this.field_1754.length) {
                System.arraycopy(this.field_1754, 0, this.field_1754 = new class_296[var2 + 2], 0, var2);
            }
            this.field_1754[var2] = (class_296)var1;
        }
    }

    public void method_3046(class_293 var1, class_301 var2) {
        if ((var2.field_1783 & 1) == 0) {
            if ((this.field_1749.field_1783 & 1) == 0) {
                this.field_1749 = this.field_1749.method_3105(var2.method_3110());
            } else {
                this.field_1749 = var2.method_3107();
            }
            class_293 var3;
            for (var3 = var1; var3 != this && !(var3 instanceof class_297); var3 = var3.field_1740) {
                ;
            }
            if (var3 == this) {
                this.field_1750.method_3113(var2.method_3110());
            } else {
                boolean var4 = false;
                if (this.field_1751 == null) {
                    this.field_1751 = new class_297[5];
                    this.field_1752 = new class_303[5];
                } else {
                    int var5;
                    if (this.field_1753 == (var5 = this.field_1751.length) - 1) {
                        System.arraycopy(this.field_1751, 0, this.field_1751 = new class_297[var5 + 5], 0, var5);
                        System.arraycopy(this.field_1752, 0, this.field_1752 = new class_303[var5 + 5], 0, var5);
                    }
                }
                this.field_1751[this.field_1753] = (class_297)var3;
                this.field_1752[this.field_1753++] = var2.method_3110();
            }
        }
    }

    protected boolean method_3047(class_64 var1, class_154 var2) {
        if (var1 instanceof class_65) {
            Object var3 = ((class_65)var1).field_308;
            while ((var3 = ((class_83)var3).field_374) != null) {
                if (var3 == this.field_1763) {
                    return false;
                }
            }
        }
        if (this.field_1758 == 0) {
            this.field_1756 = new class_154[5];
            this.field_1757 = new class_64[5];
        } else {
            if (this.field_1758 == this.field_1756.length) {
                System.arraycopy(this.field_1756, 0, this.field_1756 = new class_154[this.field_1758 * 2], 0, this.field_1758);
            }
            System.arraycopy(this.field_1757, 0, this.field_1757 = new class_64[this.field_1758 * 2], 0, this.field_1758);
        }
        this.field_1756[this.field_1758] = var2;
        this.field_1757[this.field_1758++] = var1;
        return true;
    }

    protected void method_3059(class_65 var1, class_126 var2, int var3) {
        if (this.field_1762 == 0) {
            this.field_1759 = new class_65[5];
            this.field_1760 = new class_126[5];
            this.field_1761 = new int[5];
        } else if (this.field_1762 == this.field_1759.length) {
            System.arraycopy(this.field_1759, 0, this.field_1759 = new class_65[this.field_1762 * 2], 0, this.field_1762);
            System.arraycopy(this.field_1760, 0, this.field_1760 = new class_126[this.field_1762 * 2], 0, this.field_1762);
            System.arraycopy(this.field_1761, 0, this.field_1761 = new int[this.field_1762 * 2], 0, this.field_1762);
        }
        this.field_1759[this.field_1762] = var1;
        this.field_1760[this.field_1762] = var2;
        this.field_1761[this.field_1762++] = var3;
    }

    public void method_3050(class_83 var1, class_65 var2, class_126 var3, int var4, class_301 var5) {
        if ((var5.field_1783 & 1) == 0 && !var5.method_3086(var2)) {
            switch (var4) {
                case 3:
                    if (var5.method_3084(var2)) {
                        return;
                    } else if (var5.method_3085(var2)) {
                        var1.method_644().method_1665(var2, var3);
                        return;
                    } else {
                        if (var5.method_3090(var2)) {
                            var1.method_644().method_1666(var2, var3);
                            return;
                        }
                        this.method_3059(var2, var3, var4);
                        return;
                    }
                case 256:
                case 512:
                    if (var5.method_3084(var2)) {
                        if (var4 == 512) {
                            var1.method_644().method_1667(var2, var3);
                        } else {
                            var1.method_644().method_1662(var2, var3);
                        }
                    } else if (var5.method_3085(var2)) {
                        if (var4 == 256) {
                            var1.method_644().method_1668(var2, var3);
                        } else {
                            var1.method_644().method_1663(var2, var3);
                        }
                    } else if (!var5.method_3075(var2)) {
                        if (var5.method_3089(var2)) {
                            this.method_3059(var2, var3, 2 | var4 & -256);
                        } else {
                            this.method_3059(var2, var3, var4);
                        }
                    }
                    return;
                case 257:
                case 513:
                case 769:
                case 1025:
                    if (!var5.method_3089(var2) && !var5.method_3091(var2)) {
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
                        this.method_3059(var2, var3, var4);
                        return;
                    }
                    return;
                default:
            }
        }
    }

    void method_3051(class_154 var1) {
        for (int var2 = 0; var2 < this.field_1758; ++var2) {
            if (this.field_1756[var2] == var1) {
                this.field_1756[var2] = null;
                this.field_1757[var2] = null;
                return;
            }
        }
    }
}
