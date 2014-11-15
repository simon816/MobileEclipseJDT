package org.eclipse.jdt.internal.compiler.lookup;

import java.util.List;

import java.util.Vector;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.lookup.class_17;
import org.eclipse.jdt.internal.compiler.lookup.class_321;
import org.eclipse.jdt.internal.compiler.lookup.class_34;
import org.eclipse.jdt.internal.compiler.lookup.PackageBinding;
import org.eclipse.jdt.internal.compiler.lookup.class_41;
import org.eclipse.jdt.internal.compiler.lookup.class_42;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.class_44;
import org.eclipse.jdt.internal.compiler.lookup.class_45;
import org.eclipse.jdt.internal.compiler.lookup.class_46;
import org.eclipse.jdt.internal.compiler.lookup.class_47;
import org.eclipse.jdt.internal.compiler.lookup.class_52;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.class_55;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;
import org.eclipse.jdt.internal.compiler.lookup.class_83;

public abstract class class_40 extends class_34 {

    public int field_177;

    public long field_178;

    public static final class_41 field_179;

    public static final class_41 field_180;

    public static final class_41 field_181;

    public static final class_41 field_182;

    public static final class_41 field_183;

    public static final class_41 field_184;

    public static final class_41 field_185;

    public static final class_41 field_186;

    public static final class_41 field_187;

    public static final class_41 field_188;

    public class_40() {
        this.field_177 = Integer.MAX_VALUE;
        this.field_178 = 0L;
    }

    public static final class_40 method_128(class_83 var0, int var1) {
        switch (var1) {
            case 1:
                return var0.method_609();
            case 2:
                return field_182;
            case 3:
                return field_180;
            case 4:
                return field_181;
            case 5:
                return field_186;
            case 6:
            default:
                return null;
            case 7:
                return field_183;
            case 8:
                return field_185;
            case 9:
                return field_184;
            case 10:
                return field_179;
            case 11:
                return var0.method_610();
        }
    }

    public boolean method_129() {
        return !this.method_148();
    }

    public class_40 method_130(class_83 var1, int var2) {
        return this;
    }

    public class_40 method_131() {
        return this;
    }

    public List method_132(List var1) {
        return var1;
    }

    public void method_133(class_83 var1, class_40 var2, class_321 var3, int var4) {}

    public abstract char[] method_134();

    public String method_135() {
        return new String(this.method_103());
    }

    public int method_136() {
        return 0;
    }

    public ReferenceBinding method_137() {
        return null;
    }

    public class_40 method_138() {
        return this;
    }

    public ReferenceBinding method_139(int var1, boolean var2) {
        if (!(this instanceof ReferenceBinding)) {
            return null;
        } else {
            ReferenceBinding var3 = (ReferenceBinding)this;
            if (var3.field_177 != var1 && this.method_175().field_177 != var1) {
                ReferenceBinding var4 = var3;
                if (var2) {
                    do {
                        if ((var4 = var4.method_240()) == null) {
                            return null;
                        }
                        if (var4.field_177 == var1) {
                            return var4;
                        }
                    } while (var4.method_175().field_177 != var1);
                    return var4;
                } else {
                    ReferenceBinding[] var5 = null;
                    int var6 = 0;
                    int var9;
                    do {
                        ReferenceBinding[] var7 = var4.method_241();
                        if (var7 != null && var7 != class_34.field_155) {
                            if (var5 == null) {
                                var5 = var7;
                                var6 = var7.length;
                            } else {
                                int var8 = var7.length;
                                if (var6 + var8 >= var5.length) {
                                    System.arraycopy(var5, 0, var5 = new ReferenceBinding[var6 + var8 + 5], 0, var6);
                                }
                                var9 = 0;
                                while (var9 < var8) {
                                    ReferenceBinding var10 = var7[var9];
                                    int var11 = 0;
                                    while (true) {
                                        if (var11 < var6) {
                                            if (var10 != var5[var11]) {
                                                ++var11;
                                                continue;
                                            }
                                        } else {
                                            var5[var6++] = var10;
                                        }
                                        ++var9;
                                        break;
                                    }
                                }
                            }
                        }
                    } while ((var4 = var4.method_240()) != null);
                    for (int var13 = 0; var13 < var6; ++var13) {
                        var4 = var5[var13];
                        if (var4.field_177 == var1) {
                            return var4;
                        }
                        if (var4.method_175().field_177 == var1) {
                            return var4;
                        }
                        ReferenceBinding[] var14 = var4.method_241();
                        if (var14 != null && var14 != class_34.field_155) {
                            var9 = var14.length;
                            if (var6 + var9 >= var5.length) {
                                System.arraycopy(var5, 0, var5 = new ReferenceBinding[var6 + var9 + 5], 0, var6);
                            }
                            label84:
                            for (int var15 = 0; var15 < var9; ++var15) {
                                ReferenceBinding var16 = var14[var15];
                                for (int var12 = 0; var12 < var6; ++var12) {
                                    if (var16 == var5[var12]) {
                                        continue label84;
                                    }
                                }
                                var5[var6++] = var16;
                            }
                        }
                    }
                    return null;
                }
            } else {
                return var3;
            }
        }
    }

    public class_40 method_140(class_40 var1) {
        if (this == var1) {
            return this;
        } else if (var1 == null) {
            return null;
        } else {
            switch (this.method_98()) {
                case 68:
                    class_42 var2 = (class_42)this;
                    int var3 = var1.method_136();
                    if (var2.field_193 != var3) {
                        switch (var1.field_177) {
                            case 1:
                            case 36:
                            case 37:
                                return var1;
                            default:
                                if (var3 < var2.field_193 && var1.method_173().field_177 == 1) {
                                    return var1;
                                }
                                return null;
                        }
                    } else if (!(var2.field_192 instanceof ReferenceBinding)) {
                        return null;
                    } else {
                        class_40 var4 = var2.field_192.method_140(var1.method_173());
                        if (var4 == null) {
                            return null;
                        }
                        return var2.method_188().method_493(var4, var2.field_193);
                    }
                case 4100:
                    if (this.method_150()) {
                        class_47 var5 = (class_47)this;
                        class_40 var6 = var5.field_222;
                        if (var6 instanceof class_42) {
                            class_40 var7 = var6.method_140(var1);
                            if (var7 != null) {
                                return var7;
                            }
                        }
                    }
                case 4:
                case 260:
                case 516:
                case 1028:
                case 2052:
                case 8196:
                    var1 = var1.method_175();
                    if (this == var1) {
                        return this;
                    } else if (this.method_175() == var1) {
                        return this;
                    } else {
                        ReferenceBinding var14 = (ReferenceBinding)this;
                        if (!var1.method_157()) {
                            do {
                                if ((var14 = var14.method_240()) == null) {
                                    return null;
                                }
                                if (var14 == var1) {
                                    return var14;
                                }
                            } while (var14.method_175() != var1);
                            return var14;
                        } else {
                            ReferenceBinding[] var15 = null;
                            int var16 = 0;
                            int var10;
                            do {
                                ReferenceBinding[] var8 = var14.method_241();
                                if (var8 != class_34.field_155) {
                                    if (var15 == null) {
                                        var15 = var8;
                                        var16 = var8.length;
                                    } else {
                                        int var9 = var8.length;
                                        if (var16 + var9 >= var15.length) {
                                            System.arraycopy(var15, 0, var15 = new ReferenceBinding[var16 + var9 + 5], 0, var16);
                                        }
                                        label137:
                                        for (var10 = 0; var10 < var9; ++var10) {
                                            ReferenceBinding var11 = var8[var10];
                                            for (int var12 = 0; var12 < var16; ++var12) {
                                                if (var11 == var15[var12]) {
                                                    continue label137;
                                                }
                                            }
                                            var15[var16++] = var11;
                                        }
                                    }
                                }
                            } while ((var14 = var14.method_240()) != null);
                            for (int var17 = 0; var17 < var16; ++var17) {
                                var14 = var15[var17];
                                if (var14 == var1) {
                                    return var14;
                                }
                                if (var14.method_175() == var1) {
                                    return var14;
                                }
                                ReferenceBinding[] var18 = var14.method_241();
                                if (var18 != class_34.field_155) {
                                    var10 = var18.length;
                                    if (var16 + var10 >= var15.length) {
                                        System.arraycopy(var15, 0, var15 = new ReferenceBinding[var16 + var10 + 5], 0, var16);
                                    }
                                    label114:
                                    for (int var19 = 0; var19 < var10; ++var19) {
                                        ReferenceBinding var20 = var18[var19];
                                        for (int var13 = 0; var13 < var16; ++var13) {
                                            if (var20 == var15[var13]) {
                                                continue label114;
                                            }
                                        }
                                        var15[var16++] = var20;
                                    }
                                }
                            }
                        }
                    }
                default:
                    return null;
            }
        }
    }

    public class_40 method_141(class_40 var1) {
        if (this == var1) {
            return null;
        } else {
            class_40 var2 = var1.method_138();
            return var2 == this.method_138() ? null : var2;
        }
    }

    public char[] method_142() {
        return this.method_178();
    }

    public abstract PackageBinding method_143();

    void method_144() {}

    public boolean method_145() {
        return false;
    }

    public final boolean method_146() {
        return (this.field_178 & 32L) != 0L;
    }

    public final boolean method_147() {
        return (this.field_178 & 1L) != 0L;
    }

    public final boolean method_148() {
        return (this.field_178 & 2L) != 0L;
    }

    public boolean method_149() {
        return (this.field_178 & 8388608L) != 0L;
    }

    public boolean method_150() {
        return false;
    }

    public boolean method_151() {
        return false;
    }

    public abstract boolean method_152(class_40 var1);

    public boolean method_153() {
        return false;
    }

    public boolean method_154(class_40 var1) {
        if (this == var1) {
            return true;
        } else if (var1 == null) {
            return false;
        } else {
            switch (var1.method_98()) {
                case 516:
                case 8196:
                    return ((class_45)var1).method_250(this);
                default:
                    return false;
            }
        }
    }

    public boolean method_155() {
        return false;
    }

    public final boolean method_156() {
        return (this.field_178 & 131072L) != 0L;
    }

    public boolean method_157() {
        return false;
    }

    public final boolean method_158() {
        return (this.field_178 & 16L) != 0L;
    }

    public final boolean method_159() {
        return (this.field_178 & 8L) != 0L;
    }

    public final boolean method_160() {
        return (this.field_178 & 4L) != 0L;
    }

    public final boolean method_161() {
        switch (this.field_177) {
            case 2:
            case 3:
            case 4:
            case 7:
            case 8:
            case 9:
            case 10:
                return true;
            case 5:
            case 6:
            default:
                return false;
        }
    }

    public boolean method_162() {
        return false;
    }

    private boolean method_163(class_40 var1) {
        if (var1.method_157()) {
            return this.method_157() ? false : (!this.method_147() && (!(this instanceof ReferenceBinding) || !((ReferenceBinding)this).method_221()) && (!this.method_169() || !((class_46)this).method_240().method_221()) ? false : !this.method_152(var1));
        } else {
            if (this.method_157()) {
                if (var1.method_147() || var1 instanceof ReferenceBinding && ((ReferenceBinding)var1).method_221() || var1.method_169() && ((class_46)var1).method_240().method_221()) {
                    return !this.method_152(var1);
                }
            } else if (!this.method_169() && !var1.method_169()) {
                return !this.method_152(var1);
            }
            return false;
        }
    }

    public boolean method_164(class_40 var1) {
        if (this == var1) {
            return false;
        } else if (var1 == null) {
            return true;
        } else {
            switch (this.method_98()) {
                case 260:
                    class_52 var2 = (class_52)this;
                    int var4;
                    int var6;
                    switch (var1.method_98()) {
                        case 260:
                            class_52 var3 = (class_52)var1;
                            if (var2.method_286() != var3.method_286()) {
                                return true;
                            } else {
                                if (!var2.method_226()) {
                                    ReferenceBinding var10 = this.method_137();
                                    if (var10 != null) {
                                        ReferenceBinding var11 = var3.method_137();
                                        if (var11 == null) {
                                            return true;
                                        }
                                        if ((var11.field_178 & 1073741824L) == 0L) {
                                            if (var10 != var11) {
                                                return true;
                                            }
                                        } else if (!var10.method_154(var3.method_137())) {
                                            return true;
                                        }
                                    }
                                }
                                var4 = var2.field_243 == null ? 0 : var2.field_243.length;
                                class_40[] var12 = var3.field_243;
                                var6 = var12 == null ? 0 : var12.length;
                                if (var6 != var4) {
                                    return true;
                                } else {
                                    for (int var13 = 0; var13 < var4; ++var13) {
                                        if (var2.field_243[var13].method_165(var12[var13], var2, var13)) {
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                            }
                        case 1028:
                            return this.method_138() != var1.method_138();
                        case 2052:
                            SourceTypeBinding var7 = (SourceTypeBinding)var1;
                            if (var2.method_286() != var7) {
                                return true;
                            } else {
                                if (!var2.method_226()) {
                                    ReferenceBinding var8 = this.method_137();
                                    if (var8 != null) {
                                        ReferenceBinding var9 = var7.method_137();
                                        if (var9 == null) {
                                            return true;
                                        }
                                        if ((var9.field_178 & 1073741824L) == 0L) {
                                            if (var8 != var9) {
                                                return true;
                                            }
                                        } else if (!var8.method_154(var7.method_137())) {
                                            return true;
                                        }
                                    }
                                }
                                var4 = var2.field_243 == null ? 0 : var2.field_243.length;
                                class_46[] var5 = var7.method_181();
                                var6 = var5 == null ? 0 : var5.length;
                                if (var6 != var4) {
                                    return true;
                                } else {
                                    for (int var14 = 0; var14 < var4; ++var14) {
                                        if (var2.field_243[var14].method_165(var5[var14], var2, var14)) {
                                            return true;
                                        }
                                    }
                                    return false;
                                }
                            }
                        default:
                            return true;
                    }
                case 1028:
                    switch (var1.method_98()) {
                        case 260:
                        case 1028:
                        case 2052:
                            return this.method_138() != var1.method_138();
                        default:
                            return true;
                    }
                default:
                    return true;
            }
        }
    }

    private boolean method_165(class_40 var1, class_52 var2, int var3) {
        if (this == var1) {
            return false;
        } else {
            class_40 var4;
            class_40 var5;
            var4 = null;
            var5 = null;
            class_45 var6;
            label148:
            switch (this.method_98()) {
                case 516:
                    var6 = (class_45)this;
                    switch (var6.field_215) {
                        case 0:
                            return false;
                        case 1:
                            var4 = var6.field_212;
                            break label148;
                        case 2:
                            var5 = var6.field_212;
                        default:
                            break label148;
                    }
                case 4100:
                    class_46 var7 = (class_46)this;
                    if (var7.method_150()) {
                        class_47 var8 = (class_47)var7;
                        switch (var8.field_227.field_215) {
                            case 0:
                                return false;
                            case 1:
                                var4 = var8.field_227.field_212;
                                break;
                            case 2:
                                var5 = var8.field_227.field_212;
                        }
                    } else {
                        if (var7.field_222 == null) {
                            return false;
                        }
                        class_40 var14 = var2.field_244.method_488(var7, var2.method_286(), var3, (Vector)null);
                        switch (var14.method_98()) {
                            case 516:
                            case 8196:
                                var6 = (class_45)var14;
                                switch (var6.field_215) {
                                    case 0:
                                        return false;
                                    case 1:
                                        var4 = var6.field_212;
                                        break;
                                    case 2:
                                        var5 = var6.field_212;
                                }
                        }
                    }
                case 8196:
            }
            class_40 var11 = null;
            class_40 var12 = null;
            class_45 var13;
            switch (var1.method_98()) {
                case 516:
                    var13 = (class_45)var1;
                    switch (var13.field_215) {
                        case 0:
                            return false;
                        case 1:
                            var11 = var13.field_212;
                            return var5 != null ? (var12 != null ? false : (var11 != null ? (!var5.method_169() && !var11.method_169() ? !var5.method_152(var11) : false) : (!var5.method_169() && !var1.method_169() ? !var5.method_152(var1) : false))) : (var4 == null ? (var12 != null ? (!var12.method_169() && !this.method_169() ? !var12.method_152(this) : false) : (var11 != null ? this.method_163(var11) : true)) : (var12 != null ? !var12.method_152(var4) : (var11 == null ? var1.method_163(var4) : var4.method_163(var11) && var11.method_163(var4))));
                        case 2:
                            var12 = var13.field_212;
                            return var5 != null ? (var12 != null ? false : (var11 != null ? (!var5.method_169() && !var11.method_169() ? !var5.method_152(var11) : false) : (!var5.method_169() && !var1.method_169() ? !var5.method_152(var1) : false))) : (var4 == null ? (var12 != null ? (!var12.method_169() && !this.method_169() ? !var12.method_152(this) : false) : (var11 != null ? this.method_163(var11) : true)) : (var12 != null ? !var12.method_152(var4) : (var11 == null ? var1.method_163(var4) : var4.method_163(var11) && var11.method_163(var4))));
                        default:
                            return var5 != null ? (var12 != null ? false : (var11 != null ? (!var5.method_169() && !var11.method_169() ? !var5.method_152(var11) : false) : (!var5.method_169() && !var1.method_169() ? !var5.method_152(var1) : false))) : (var4 == null ? (var12 != null ? (!var12.method_169() && !this.method_169() ? !var12.method_152(this) : false) : (var11 != null ? this.method_163(var11) : true)) : (var12 != null ? !var12.method_152(var4) : (var11 == null ? var1.method_163(var4) : var4.method_163(var11) && var11.method_163(var4))));
                    }
                case 4100:
                    class_46 var9 = (class_46)var1;
                    if (var9.method_150()) {
                        class_47 var10 = (class_47)var9;
                        switch (var10.field_227.field_215) {
                            case 0:
                                return false;
                            case 1:
                                var11 = var10.field_227.field_212;
                                break;
                            case 2:
                                var12 = var10.field_227.field_212;
                        }
                    } else {
                        if (var9.field_222 == null) {
                            return false;
                        }
                        class_40 var15 = var2.field_244.method_488(var9, var2.method_286(), var3, (Vector)null);
                        switch (var15.method_98()) {
                            case 516:
                            case 8196:
                                var13 = (class_45)var15;
                                switch (var13.field_215) {
                                    case 0:
                                        return false;
                                    case 1:
                                        var11 = var13.field_212;
                                        break;
                                    case 2:
                                        var12 = var13.field_212;
                                }
                        }
                    }
                case 8196:
            }
            return var5 != null ? (var12 != null ? false : (var11 != null ? (!var5.method_169() && !var11.method_169() ? !var5.method_152(var11) : false) : (!var5.method_169() && !var1.method_169() ? !var5.method_152(var1) : false))) : (var4 == null ? (var12 != null ? (!var12.method_169() && !this.method_169() ? !var12.method_152(this) : false) : (var11 != null ? this.method_163(var11) : true)) : (var12 != null ? !var12.method_152(var4) : (var11 == null ? var1.method_163(var4) : var4.method_163(var11) && var11.method_163(var4))));
        }
    }

    public boolean method_166() {
        return false;
    }

    public boolean method_167() {
        class_40 var1 = this.method_173();
        if (!(var1 instanceof ReferenceBinding)) {
            return true;
        } else {
            ReferenceBinding var2 = (ReferenceBinding)var1;
            while (true) {
                switch (var2.method_98()) {
                    case 260:
                        if (var2.method_149()) {
                            return false;
                        }
                    case 516:
                    case 2052:
                    case 4100:
                    case 8196:
                        return false;
                    case 1028:
                        return true;
                    default:
                        if (var2.method_226()) {
                            return true;
                        }
                        if (var2.method_158()) {
                            class_55 var3 = (class_55)var2.method_138();
                            if (var3.field_258.method_635().field_404) {
                                return true;
                            }
                        }
                        if ((var2 = var2.method_137()) == null) {
                            return true;
                        }
                }
            }
        }
    }

    public boolean method_168(class_40 var1) {
        if (this == var1) {
            return true;
        } else {
            class_45 var4;
            switch (var1.method_98()) {
                case 260:
                    if (!this.method_162()) {
                        return false;
                    } else {
                        class_52 var18 = (class_52)this;
                        class_52 var7 = (class_52)var1;
                        if (var18.method_283() != var7.method_283()) {
                            return false;
                        } else {
                            if (!var18.method_226()) {
                                ReferenceBinding var8 = this.method_137();
                                if (var8 != null) {
                                    ReferenceBinding var9 = var7.method_137();
                                    if (var9 == null) {
                                        return false;
                                    }
                                    if ((var9.field_178 & 1073741824L) == 0L) {
                                        if (var8 != var9) {
                                            return false;
                                        }
                                    } else if (!var8.method_154(var7.method_137())) {
                                        return false;
                                    }
                                }
                            }
                            int var19 = var18.field_243 == null ? 0 : var18.field_243.length;
                            class_40[] var20 = var7.field_243;
                            int var10 = var20 == null ? 0 : var20.length;
                            if (var10 != var19) {
                                return false;
                            } else {
                                for (int var11 = 0; var11 < var19; ++var11) {
                                    class_40 var12 = var18.field_243[var11];
                                    class_40 var13 = var20[var11];
                                    if (var12 != var13) {
                                        int var14 = var12.method_98();
                                        if (var13.method_98() != var14) {
                                            return false;
                                        }
                                        switch (var14) {
                                            case 260:
                                                if (!var12.method_168(var13)) {
                                                    return false;
                                                }
                                                break;
                                            case 516:
                                            case 8196:
                                                class_45 var15 = (class_45)var12;
                                                var4 = (class_45)var13;
                                                switch (var15.field_215) {
                                                    case 0:
                                                        if (var4.field_215 != 1 || var4.field_212 != var4.method_253().method_261()) {
                                                            return false;
                                                        }
                                                        continue;
                                                    case 1:
                                                        if (var4.field_215 != 0 || var15.field_212 != var15.method_253().method_261()) {
                                                            return false;
                                                        }
                                                        continue;
                                                    case 2:
                                                    default:
                                                        return false;
                                                }
                                            default:
                                                return false;
                                        }
                                    }
                                }
                                return true;
                            }
                        }
                    }
                case 516:
                case 8196:
                    class_40 var2;
                    Object var3;
                    var2 = this;
                    var3 = this;
                    label118:
                    switch (this.method_98()) {
                        case 516:
                        case 8196:
                            var4 = (class_45)this;
                            switch (var4.field_215) {
                                case 0:
                                    var3 = var4;
                                    var2 = null;
                                    break label118;
                                case 1:
                                    if (var4.field_213 == null) {
                                        var3 = var4.field_212;
                                        var2 = null;
                                    }
                                    break label118;
                                case 2:
                                    var3 = var4;
                                    var2 = var4.field_212;
                                default:
                                    break label118;
                            }
                        case 4100:
                            if (this.method_150()) {
                                class_47 var5 = (class_47)this;
                                if (var5.field_226 != null) {
                                    var2 = var5.field_226;
                                }
                            }
                    }
                    var4 = (class_45)var1;
                    if (var4.field_213 != null) {
                        return false;
                    } else {
                        class_40 var17 = var4.field_212;
                        class_40 var6;
                        switch (var4.field_215) {
                            case 0:
                            default:
                                return true;
                            case 1:
                                if (var17 == this) {
                                    return true;
                                } else if (var3 == null) {
                                    return false;
                                } else {
                                    var6 = ((class_40)var3).method_140(var17);
                                    if (var6 != null && (var6 = var6.method_173()).method_166()) {
                                        return var6 == var17.method_173();
                                    }
                                    return ((class_40)var3).method_152(var17);
                                }
                            case 2:
                                if (var17 == this) {
                                    return true;
                                } else if (var2 == null) {
                                    return false;
                                } else {
                                    var6 = var17.method_140(var2);
                                    if (var6 != null && (var6 = var6.method_173()).method_166()) {
                                        return var6 == var2.method_173();
                                    }
                                    return var17.method_152(var2);
                                }
                        }
                    }
                default:
                    if (var1.field_177 == 1) {
                        switch (this.method_98()) {
                            case 516:
                                class_45 var16 = (class_45)this;
                                if (var16.field_215 == 2 && var16.field_212.field_177 == 1) {
                                    return true;
                                }
                        }
                    }
                    return false;
            }
        }
    }

    public boolean method_169() {
        return false;
    }

    public boolean method_170() {
        return false;
    }

    public boolean method_171(boolean var1) {
        return false;
    }

    public boolean method_172() {
        return false;
    }

    public int method_98() {
        return 4;
    }

    public class_40 method_173() {
        return this;
    }

    public boolean method_174(class_40 var1) {
        if (this == var1) {
            return false;
        } else {
            Object var5 = var1.method_173();
            if (!(var5 instanceof ReferenceBinding)) {
                return false;
            } else {
                class_40 var2 = this.method_173();
                class_40 var3 = var2.method_140((class_40)var5);
                if (!(var3 instanceof ReferenceBinding)) {
                    return false;
                } else {
                    ReferenceBinding var4 = (ReferenceBinding)var3;
                    while (var4.method_166()) {
                        if (((class_40)var5).method_149()) {
                            return true;
                        }
                        if (var4.method_226() || (var4 = var4.method_137()) == null || (var5 = ((class_40)var5).method_137()) == null) {
                            break;
                        }
                    }
                    return false;
                }
            }
        }
    }

    public class_40 method_175() {
        switch (this.method_98()) {
            case 68:
            case 260:
            case 1028:
                return this.method_138();
            default:
                return this;
        }
    }

    public char[] method_176() {
        PackageBinding var1 = this.method_143();
        return var1 != null && var1.field_171 != CharOperation.field_995 ? var1.method_103() : CharOperation.field_994;
    }

    public abstract char[] method_177();

    public char[] method_178() {
        return this.method_134();
    }

    public abstract char[] method_179();

    public void method_180(class_44 var1, ReferenceBinding var2, LookupEnvironment var3) {}

    public class_46[] method_181() {
        return class_34.field_157;
    }

    static {
        class_41 var10000 = new class_41(10, class_17.field_62, new char[] {'I'});
        field_179 = var10000;
        var10000 = new class_41(3, class_17.field_60, new char[] {'B'});
        field_180 = var10000;
        var10000 = new class_41(4, class_17.field_61, new char[] {'S'});
        field_181 = var10000;
        var10000 = new class_41(2, class_17.field_66, new char[] {'C'});
        field_182 = var10000;
        var10000 = new class_41(7, class_17.field_63, new char[] {'J'});
        field_183 = var10000;
        var10000 = new class_41(9, class_17.field_64, new char[] {'F'});
        field_184 = var10000;
        var10000 = new class_41(8, class_17.field_65, new char[] {'D'});
        field_185 = var10000;
        var10000 = new class_41(5, class_17.field_67, new char[] {'Z'});
        field_186 = var10000;
        var10000 = new class_41(12, class_17.field_68, new char[] {'N'});
        field_187 = var10000;
        var10000 = new class_41(6, class_17.field_69, new char[] {'V'});
        field_188 = var10000;
    }
}
