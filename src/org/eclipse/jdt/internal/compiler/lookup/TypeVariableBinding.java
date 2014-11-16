package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.lookup.Substitution;
import org.eclipse.jdt.internal.compiler.lookup.InferenceContext;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.WildcardBinding;
import org.eclipse.jdt.internal.compiler.lookup.BinaryTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;
import org.eclipse.jdt.internal.compiler.lookup.Scope;

public class TypeVariableBinding extends ReferenceBinding {

    public Binding declaringElement;

    public int rank;

    public TypeBinding firstBound;

    public ReferenceBinding superclass;

    public ReferenceBinding[] superInterfaces;

    public char[] genericTypeSignature;

    public TypeVariableBinding(char[] var1, Binding var2, int var3) {
        this.sourceName = var1;
        this.declaringElement = var2;
        this.rank = var3;
        this.modifiers = 1073741825;
        this.tagBits |= 536870912L;
    }

    public int kind() {
        return 4100;
    }

    public int boundCheck(Substitution var1, TypeBinding var2) {
        if (var2 != TypeBinding.field_187 && var2 != this) {
            boolean var3 = var1 != null;
            if (!(var2 instanceof ReferenceBinding) && !var2.method_147()) {
                return 2;
            } else if (this.superclass == null) {
                return 0;
            } else {
                TypeBinding var8;
                if (var2.kind() != 516) {
                    boolean var14 = false;
                    if (this.superclass.id != 1) {
                        Object var15 = var3 ? Scope.substitute(var1, this.superclass) : this.superclass;
                        if (var15 != var2) {
                            if (!var2.isCompatibleWith((TypeBinding)var15)) {
                                return 2;
                            }
                            TypeBinding var18 = var2.method_140((TypeBinding)var15);
                            if (var18 != null && var18.method_166() && ((TypeBinding)var15).method_149()) {
                                var14 = true;
                            }
                        }
                    }
                    int var16 = 0;
                    for (int var17 = this.superInterfaces.length; var16 < var17; ++var16) {
                        Object var19 = var3 ? Scope.substitute(var1, this.superInterfaces[var16]) : this.superInterfaces[var16];
                        if (var19 != var2) {
                            if (!var2.isCompatibleWith((TypeBinding)var19)) {
                                return 2;
                            }
                            var8 = var2.method_140((TypeBinding)var19);
                            if (var8 != null && var8.method_166() && ((TypeBinding)var19).method_149()) {
                                var14 = true;
                            }
                        }
                    }
                    return var14 ? 1 : 0;
                } else {
                    WildcardBinding var4 = (WildcardBinding)var2;
                    switch (var4.field_215) {
                        case 1:
                            TypeBinding var5 = var4.bound;
                            if (var5 == this) {
                                return 0;
                            } else {
                                ReferenceBinding var6 = var3 ? (ReferenceBinding)Scope.substitute(var1, this.superclass) : this.superclass;
                                boolean var7 = var5.method_147();
                                if (!var5.method_157() && var6.id != 1) {
                                    if (var7) {
                                        if (!var5.isCompatibleWith(var6)) {
                                            return 2;
                                        }
                                    } else {
                                        var8 = var5.method_140(var6);
                                        if (var8 != null) {
                                            if (var6.method_164(var8)) {
                                                return 2;
                                            }
                                        } else {
                                            var8 = var6.method_140(var5);
                                            if (var8 != null) {
                                                if (var8.method_164(var5)) {
                                                    return 2;
                                                }
                                            } else if (!var5.method_169() && !var6.method_169()) {
                                                return 2;
                                            }
                                        }
                                    }
                                }
                                ReferenceBinding[] var20 = var3 ? Scope.substitute(var1, this.superInterfaces) : this.superInterfaces;
                                int var9 = var20.length;
                                boolean var10 = var7 || ((ReferenceBinding)var5).method_221();
                                for (int var11 = 0; var11 < var9; ++var11) {
                                    ReferenceBinding var12 = var20[var11];
                                    if (var7) {
                                        if (!var5.isCompatibleWith(var12)) {
                                            return 2;
                                        }
                                    } else {
                                        TypeBinding var13 = var5.method_140(var12);
                                        if (var13 != null) {
                                            if (var12.method_164(var13)) {
                                                return 2;
                                            }
                                        } else if (var10) {
                                            return 2;
                                        }
                                    }
                                }
                            }
                        case 0:
                        default:
                            return 0;
                        case 2:
                            return this.boundCheck(var1, var4.bound);
                    }
                }
            }
        } else {
            return 0;
        }
    }

    public boolean method_129() {
        return false;
    }

    public void collectSubstitutes(Scope var1, TypeBinding var2, InferenceContext var3, int var4) {
        if (this.declaringElement == var3.genericMethod) {
            switch (var2.kind()) {
                case 132:
                    if (var2 == TypeBinding.field_187) {
                        return;
                    } else {
                        TypeBinding var5 = var1.environment().method_486(var2);
                        if (var5 == var2) {
                            return;
                        } else {
                            var2 = var5;
                        }
                    }
                case 516:
                    return;
                default:
                    byte var6;
                    switch (var4) {
                        case 0:
                            var6 = 0;
                            break;
                        case 1:
                            var6 = 2;
                            break;
                        default:
                            var6 = 1;
                    }
                    var3.recordSubstitute(this, var2, var6);
            }
        }
    }

    public char[] constantPoolName() {
        return this.firstBound != null ? this.firstBound.constantPoolName() : this.superclass.constantPoolName();
    }

    public String debugName() {
        return new String(this.sourceName);
    }

    public TypeBinding erasure() {
        return (TypeBinding)(this.firstBound != null ? this.firstBound.erasure() : this.superclass);
    }

    public char[] method_256() {
        StringBuffer var1 = new StringBuffer(10);
        var1.append(this.sourceName).append(':');
        int var2 = this.superInterfaces == null ? 0 : this.superInterfaces.length;
        if ((var2 == 0 || this.firstBound == this.superclass) && this.superclass != null) {
            var1.append(this.superclass.genericTypeSignature());
        }
        int var3;
        for (var3 = 0; var3 < var2; ++var3) {
            var1.append(':').append(this.superInterfaces[var3].genericTypeSignature());
        }
        var3 = var1.length();
        char[] var4 = new char[var3];
        var1.getChars(0, var3, var4, 0);
        return var4;
    }

    public char[] genericTypeSignature() {
        return this.genericTypeSignature != null ? this.genericTypeSignature : (this.genericTypeSignature = CharOperation.concat('T', this.sourceName, ';'));
    }

    public int method_257() {
        return this.firstBound == null ? 0 : (this.firstBound == this.superclass ? this.superInterfaces.length + 1 : this.superInterfaces.length);
    }

    public boolean isErasureBoundTo(TypeBinding var1) {
        if (this.superclass.erasure() == var1) {
            return true;
        } else {
            int var2 = 0;
            for (int var3 = this.superInterfaces.length; var2 < var3; ++var2) {
                if (this.superInterfaces[var2].erasure() == var1) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean isInterchangeableWith(TypeVariableBinding var1, Substitution var2) {
        if (this == var1) {
            return true;
        } else {
            int var3 = this.superInterfaces.length;
            if (var3 != var1.superInterfaces.length) {
                return false;
            } else if (this.superclass != Scope.substitute(var2, var1.superclass)) {
                return false;
            } else {
                int var4 = 0;
                label35:
                while (var4 < var3) {
                    TypeBinding var5 = Scope.substitute(var2, var1.superInterfaces[var4]);
                    for (int var6 = 0; var6 < var3; ++var6) {
                        if (var5 == this.superInterfaces[var6]) {
                            ++var4;
                            continue label35;
                        }
                    }
                    return false;
                }
                return true;
            }
        }
    }

    public boolean method_169() {
        return true;
    }

    public char[] readableName() {
        return this.sourceName;
    }

    ReferenceBinding method_260(LookupEnvironment var1) {
        if ((this.modifiers & 33554432) == 0) {
            return this;
        } else {
            ReferenceBinding var2 = this.superclass;
            ReferenceBinding var3 = null;
            if (this.superclass != null) {
                this.superclass = BinaryTypeBinding.method_267(this.superclass, var1, true);
            }
            ReferenceBinding[] var4 = this.superInterfaces;
            int var5;
            if ((var5 = var4.length) != 0) {
                var3 = var4[0];
                int var6 = var5;
                while (true) {
                    --var6;
                    if (var6 < 0) {
                        break;
                    }
                    var4[var6] = BinaryTypeBinding.method_267(var4[var6], var1, true);
                }
            }
            if (this.firstBound != null) {
                if (this.firstBound == var2) {
                    this.firstBound = this.superclass;
                } else if (this.firstBound == var3) {
                    this.firstBound = var4[0];
                }
            }
            this.modifiers &= -33554433;
            return this;
        }
    }

    public char[] shortReadableName() {
        return this.readableName();
    }

    public ReferenceBinding superclass() {
        return this.superclass;
    }

    public ReferenceBinding[] superInterfaces() {
        return this.superInterfaces;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer(10);
        var1.append('<').append(this.sourceName);
        if (this.superclass != null && this.firstBound == this.superclass) {
            var1.append(" extends ").append(this.superclass.debugName());
        }
        if (this.superInterfaces != null && this.superInterfaces != Binding.field_155) {
            if (this.firstBound != this.superclass) {
                var1.append(" extends ");
            }
            int var2 = 0;
            for (int var3 = this.superInterfaces.length; var2 < var3; ++var2) {
                if (var2 > 0 || this.firstBound == this.superclass) {
                    var1.append(" & ");
                }
                var1.append(this.superInterfaces[var2].debugName());
            }
        }
        var1.append('>');
        return var1.toString();
    }

    public TypeBinding method_261() {
        return (TypeBinding)(this.firstBound != null ? this.firstBound : this.superclass);
    }
}
