package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.WildcardBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.ParameterizedTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.Scope;

public class CaptureBinding extends TypeVariableBinding {

    public TypeBinding lowerBound;

    public WildcardBinding wildcard;

    public int field_228;

    public ReferenceBinding sourceType;

    public int field_230;

    public CaptureBinding(WildcardBinding var1, ReferenceBinding var2, int var3, int var4) {
        super(TypeConstants.field_57, (Binding)null, 0);
        this.wildcard = var1;
        this.modifiers = 1073741825;
        this.fPackage = var1.fPackage;
        this.sourceType = var2;
        this.field_230 = var3;
        this.field_228 = var4;
    }

    public String debugName() {
        if (this.wildcard != null) {
            StringBuffer var1 = new StringBuffer(10);
            var1.append(TypeConstants.field_57).append(this.field_228).append(TypeConstants.field_58).append(this.wildcard.debugName());
            return var1.toString();
        } else {
            return super.debugName();
        }
    }

    public char[] genericTypeSignature() {
        if (this.genericTypeSignature == null) {
            this.genericTypeSignature = CharOperation.concat(TypeConstants.field_59, this.wildcard.genericTypeSignature());
        }
        return this.genericTypeSignature;
    }

    public void initializeBounds(Scope var1, ParameterizedTypeBinding var2) {
        TypeVariableBinding var3 = this.wildcard.typeVariable();
        if (var3 == null) {
            TypeBinding var11 = this.wildcard.bound;
            switch (this.wildcard.field_215) {
                case 0:
                    this.superclass = var1.method_609();
                    this.superInterfaces = Binding.field_155;
                    this.tagBits &= -536870913L;
                    break;
                case 1:
                    TypeBinding var12 = var11.capture(var1, this.field_230);
                    if (var11.method_157()) {
                        this.superclass = var1.method_609();
                        this.superInterfaces = new ReferenceBinding[] {(ReferenceBinding)var12};
                    } else {
                        if (!var12.method_147() && var12 != this) {
                            this.superclass = (ReferenceBinding)var12;
                        } else {
                            this.superclass = var1.method_609();
                        }
                        this.superInterfaces = Binding.field_155;
                    }
                    this.firstBound = var12;
                    if ((var12.tagBits & 536870912L) == 0L) {
                        this.tagBits &= -536870913L;
                    }
                    break;
                case 2:
                    this.superclass = var1.method_609();
                    this.superInterfaces = Binding.field_155;
                    this.lowerBound = this.wildcard.bound;
                    if ((var11.tagBits & 536870912L) == 0L) {
                        this.tagBits &= -536870913L;
                    }
            }
        } else {
            ReferenceBinding var4 = var3.superclass;
            ReferenceBinding var5 = (ReferenceBinding)Scope.substitute(var2, var4);
            if (var5 == this) {
                var5 = var4;
            }
            ReferenceBinding[] var6 = var3.superInterfaces();
            ReferenceBinding[] var7 = Scope.substitute(var2, var6);
            if (var7 != var6) {
                int var8 = 0;
                for (int var9 = var7.length; var8 < var9; ++var8) {
                    if (var7[var8] == this) {
                        var7[var8] = var6[var8];
                    }
                }
            }
            TypeBinding var13 = this.wildcard.bound;
            switch (this.wildcard.field_215) {
                case 0:
                    this.superclass = var5;
                    this.superInterfaces = var7;
                    this.tagBits &= -536870913L;
                    break;
                case 1:
                    TypeBinding var14 = var13.capture(var1, this.field_230);
                    if (var13.method_157()) {
                        this.superclass = var5;
                        if (var7 == Binding.field_155) {
                            this.superInterfaces = new ReferenceBinding[] {(ReferenceBinding)var14};
                        } else {
                            int var10 = var7.length;
                            System.arraycopy(var7, 0, var7 = new ReferenceBinding[var10 + 1], 1, var10);
                            var7[0] = (ReferenceBinding)var14;
                            this.superInterfaces = Scope.greaterLowerBound(var7);
                        }
                    } else {
                        if (!var14.method_147() && var14 != this) {
                            this.superclass = (ReferenceBinding)var14;
                            if (this.superclass.isSuperclassOf(var5)) {
                                this.superclass = var5;
                            }
                        } else {
                            this.superclass = var5;
                        }
                        this.superInterfaces = var7;
                    }
                    this.firstBound = var14;
                    if ((var14.tagBits & 536870912L) == 0L) {
                        this.tagBits &= -536870913L;
                    }
                    break;
                case 2:
                    this.superclass = var5;
                    if (var3.firstBound == var5 || var13 == var5) {
                        this.firstBound = var5;
                    }
                    this.superInterfaces = var7;
                    this.lowerBound = var13;
                    if ((var13.tagBits & 536870912L) == 0L) {
                        this.tagBits &= -536870913L;
                    }
            }
        }
    }

    public boolean isCapture() {
        return true;
    }

    public boolean isEquivalentTo(TypeBinding var1) {
        if (this == var1) {
            return true;
        } else if (var1 == null) {
            return false;
        } else if (this.firstBound != null && this.firstBound.method_147() && this.firstBound.isCompatibleWith(var1)) {
            return true;
        } else {
            switch (var1.kind()) {
                case 516:
                case 8196:
                    return ((WildcardBinding)var1).boundCheck(this);
                default:
                    return false;
            }
        }
    }

    public char[] readableName() {
        if (this.wildcard != null) {
            StringBuffer var1 = new StringBuffer(10);
            var1.append(TypeConstants.field_57).append(this.field_228).append(TypeConstants.field_58).append(this.wildcard.readableName());
            int var2 = var1.length();
            char[] var3 = new char[var2];
            var1.getChars(0, var2, var3, 0);
            return var3;
        } else {
            return super.readableName();
        }
    }

    public char[] shortReadableName() {
        if (this.wildcard != null) {
            StringBuffer var1 = new StringBuffer(10);
            var1.append(TypeConstants.field_57).append(this.field_228).append(TypeConstants.field_58).append(this.wildcard.shortReadableName());
            int var2 = var1.length();
            char[] var3 = new char[var2];
            var1.getChars(0, var2, var3, 0);
            return var3;
        } else {
            return super.shortReadableName();
        }
    }

    public String toString() {
        if (this.wildcard != null) {
            StringBuffer var1 = new StringBuffer(10);
            var1.append(TypeConstants.field_57).append(this.field_228).append(TypeConstants.field_58).append(this.wildcard);
            return var1.toString();
        } else {
            return super.toString();
        }
    }
}
