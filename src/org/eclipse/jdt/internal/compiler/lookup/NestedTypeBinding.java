package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.SyntheticArgumentBinding;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;

public class NestedTypeBinding extends SourceTypeBinding {

    public SourceTypeBinding enclosingType;

    public SyntheticArgumentBinding[] field_263;

    public SyntheticArgumentBinding[] field_264;

    public int field_265;

    public int field_266;

    public NestedTypeBinding(char[][] var1, ClassScope var2, SourceTypeBinding var3) {
        super(var1, var3.fPackage, var2);
        this.tagBits |= 4L;
        this.enclosingType = var3;
    }

    public SyntheticArgumentBinding method_323(LocalVariableBinding var1) {
        SyntheticArgumentBinding var2 = null;
        if (this.field_264 == null) {
            SyntheticArgumentBinding var10000 = new SyntheticArgumentBinding(var1);
            var2 = var10000;
            this.field_264 = new SyntheticArgumentBinding[] {var2};
        } else {
            int var3 = this.field_264.length;
            int var4 = var3;
            int var5 = var3;
            while (true) {
                --var5;
                if (var5 < 0) {
                    SyntheticArgumentBinding[] var6 = new SyntheticArgumentBinding[var3 + 1];
                    System.arraycopy(this.field_264, 0, var6, 0, var4);
                    SyntheticArgumentBinding var10002 = new SyntheticArgumentBinding(var1);
                    var2 = var10002;
                    var6[var4] = var10002;
                    System.arraycopy(this.field_264, var4, var6, var4 + 1, var3 - var4);
                    this.field_264 = var6;
                    break;
                }
                if (this.field_264[var5].actualOuterLocalVariable == var1) {
                    return this.field_264[var5];
                }
                if (this.field_264[var5].field_304 > var1.field_304) {
                    var4 = var5;
                }
            }
        }
        if (this.scope.referenceCompilationUnit().field_458) {
            this.updateInnerEmulationDependents();
        }
        return var2;
    }

    public SyntheticArgumentBinding method_324(ReferenceBinding var1) {
        SyntheticArgumentBinding var2 = null;
        if (this.field_263 == null) {
            SyntheticArgumentBinding var10000 = new SyntheticArgumentBinding(var1);
            var2 = var10000;
            this.field_263 = new SyntheticArgumentBinding[] {var2};
        } else {
            int var3 = this.field_263.length;
            int var4 = var3;
            int var5 = var3;
            while (true) {
                --var5;
                if (var5 < 0) {
                    SyntheticArgumentBinding[] var6 = new SyntheticArgumentBinding[var3 + 1];
                    System.arraycopy(this.field_263, 0, var6, var4 == 0 ? 1 : 0, var3);
                    SyntheticArgumentBinding var10002 = new SyntheticArgumentBinding(var1);
                    var2 = var10002;
                    var6[var4] = var10002;
                    this.field_263 = var6;
                    break;
                }
                if (this.field_263[var5].type == var1) {
                    return this.field_263[var5];
                }
                if (this.enclosingType() == var1) {
                    var4 = 0;
                }
            }
        }
        if (this.scope.referenceCompilationUnit().field_458) {
            this.updateInnerEmulationDependents();
        }
        return var2;
    }

    public SyntheticArgumentBinding method_325(LocalVariableBinding var1) {
        SyntheticArgumentBinding var2 = this.method_323(var1);
        if (var2 == null) {
            return null;
        } else {
            if (var2.matchingField == null) {
                var2.matchingField = this.method_293(var1);
            }
            return var2;
        }
    }

    public SyntheticArgumentBinding method_326(ReferenceBinding var1) {
        SyntheticArgumentBinding var2 = this.method_324(var1);
        if (var2 == null) {
            return null;
        } else {
            if (var2.matchingField == null) {
                var2.matchingField = this.addSyntheticFieldForInnerclass(var1);
            }
            return var2;
        }
    }

    public final void method_327() {
        int var1 = 0;
        int var2 = this.field_263 == null ? 0 : this.field_263.length;
        int var3;
        for (var3 = 0; var3 < var2; ++var3) {
            SyntheticArgumentBinding var4 = this.field_263[var3];
            var4.field_306 = var1 + 1;
            if (var1 + 1 > 255) {
                this.scope.problemReporter().method_1697(var4, this.scope.referenceType());
            }
            if (var4.type != TypeBinding.field_183 && var4.type != TypeBinding.field_185) {
                ++var1;
            } else {
                var1 += 2;
            }
        }
        this.field_265 = var1;
        var1 = 0;
        var3 = this.field_264 == null ? 0 : this.field_264.length;
        for (int var6 = 0; var6 < var3; ++var6) {
            SyntheticArgumentBinding var5 = this.field_264[var6];
            if (var5.type != TypeBinding.field_183 && var5.type != TypeBinding.field_185) {
                ++var1;
            } else {
                var1 += 2;
            }
        }
        this.field_266 = var1;
    }

    public ReferenceBinding enclosingType() {
        return this.enclosingType;
    }

    public SyntheticArgumentBinding method_328(LocalVariableBinding var1) {
        if (this.field_264 == null) {
            return null;
        } else {
            int var2 = this.field_264.length;
            do {
                --var2;
                if (var2 < 0) {
                    return null;
                }
            } while (this.field_264[var2].actualOuterLocalVariable != var1);
            return this.field_264[var2];
        }
    }

    public SyntheticArgumentBinding[] method_329() {
        return this.field_263;
    }

    public ReferenceBinding[] syntheticEnclosingInstanceTypes() {
        if (this.field_263 == null) {
            return null;
        } else {
            int var1 = this.field_263.length;
            ReferenceBinding[] var2 = new ReferenceBinding[var1];
            for (int var3 = 0; var3 < var1; ++var3) {
                var2[var3] = (ReferenceBinding)this.field_263[var3].type;
            }
            return var2;
        }
    }

    public SyntheticArgumentBinding[] syntheticOuterLocalVariables() {
        return this.field_264;
    }

    public void updateInnerEmulationDependents() {}

    public SyntheticArgumentBinding getSyntheticArgument(ReferenceBinding var1, boolean var2) {
        if (this.field_263 == null) {
            return null;
        } else {
            int var3 = this.field_263.length;
            do {
                --var3;
                if (var3 < 0) {
                    if (!var2) {
                        var3 = this.field_263.length;
                        while (true) {
                            --var3;
                            if (var3 < 0) {
                                break;
                            }
                            if (this.field_263[var3].actualOuterLocalVariable == null && this.field_263[var3].type.method_140(var1) != null) {
                                return this.field_263[var3];
                            }
                        }
                    }
                    return null;
                }
            } while (this.field_263[var3].type != var1 || this.field_263[var3].actualOuterLocalVariable != null);
            return this.field_263[var3];
        }
    }
}
