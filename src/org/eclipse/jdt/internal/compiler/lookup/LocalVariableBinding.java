package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.AnnotationBinding;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.VariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;

public class LocalVariableBinding extends VariableBinding {

    public int field_306;

    public int field_307;

    public BlockScope declaringScope;

    public LocalDeclaration declaration;

    public int[] initializationPCs;

    public int field_311;

    public LocalVariableBinding(char[] var1, TypeBinding var2, int var3, boolean var4) {
        super(var1, var2, var3, var4 ? Constant.NotAConstant : null);
        this.field_311 = 0;
        if (var4) {
            this.tagBits |= 1024L;
        }
    }

    public LocalVariableBinding(LocalDeclaration var1, TypeBinding var2, int var3, boolean var4) {
        this(var1.name, var2, var3, var4);
        this.declaration = var1;
    }

    public final int kind() {
        return 2;
    }

    public AnnotationBinding[] getAnnotations() {
        int var4;
        if (this.declaringScope == null) {
            if ((this.tagBits & 8589934592L) != 0L) {
                if (this.declaration == null) {
                    return Binding.NO_ANNOTATIONS;
                }
                Annotation[] var6 = this.declaration.annotations;
                if (var6 != null) {
                    int var7 = var6.length;
                    AnnotationBinding[] var8 = new AnnotationBinding[var7];
                    for (var4 = 0; var4 < var7; ++var4) {
                        AnnotationBinding var9 = var6[var4].getCompilerAnnotation();
                        if (var9 == null) {
                            return Binding.NO_ANNOTATIONS;
                        }
                        var8[var4] = var9;
                    }
                    return var8;
                }
            }
            return Binding.NO_ANNOTATIONS;
        } else {
            SourceTypeBinding var1 = this.declaringScope.enclosingSourceType();
            if (var1 == null) {
                return Binding.NO_ANNOTATIONS;
            } else {
                AnnotationBinding[] var2 = var1.retrieveAnnotations(this);
                if ((this.tagBits & 8589934592L) == 0L && (this.tagBits & 1024L) != 0L && this.declaration != null) {
                    Annotation[] var3 = this.declaration.annotations;
                    if (var3 != null) {
                        var4 = var3.length;
                        ASTNode.method_761(this.declaringScope, var3, this);
                        var2 = new AnnotationBinding[var4];
                        for (int var5 = 0; var5 < var4; ++var5) {
                            AnnotationBinding var10002 = new AnnotationBinding(var3[var5]);
                            var2[var5] = var10002;
                        }
                        this.setAnnotations(var2);
                    }
                }
                return var2;
            }
        }
    }

    public void method_414(int var1) {
        if (this.initializationPCs[(this.field_311 - 1 << 1) + 1] == -1) {
            this.initializationPCs[(this.field_311 - 1 << 1) + 1] = var1;
        }
    }

    public void method_415(int var1) {
        if (this.initializationPCs != null) {
            int var2;
            if (this.field_311 > 0) {
                var2 = this.initializationPCs[(this.field_311 - 1 << 1) + 1];
                if (var2 == -1) {
                    return;
                }
                if (var2 == var1) {
                    this.initializationPCs[(this.field_311 - 1 << 1) + 1] = -1;
                    return;
                }
            }
            var2 = this.field_311 << 1;
            if (var2 == this.initializationPCs.length) {
                System.arraycopy(this.initializationPCs, 0, this.initializationPCs = new int[this.field_311 << 2], 0, var2);
            }
            this.initializationPCs[var2] = var1;
            this.initializationPCs[var2 + 1] = -1;
            ++this.field_311;
        }
    }

    public void setAnnotations(AnnotationBinding[] var1) {
        if (this.declaringScope != null) {
            SourceTypeBinding var2 = this.declaringScope.enclosingSourceType();
            if (var2 != null) {
                var2.storeAnnotations(this, var1);
            }
        }
    }

    public String toString() {
        String var1 = super.toString();
        switch (this.field_307) {
            case 0:
                var1 = var1 + "[pos: unused]";
                break;
            case 1:
                var1 = var1 + "[pos: " + this.field_306 + "]";
                break;
            case 2:
                var1 = var1 + "[pos: fake_used]";
        }
        var1 = var1 + "[id:" + this.field_304 + "]";
        if (this.field_311 > 0) {
            var1 = var1 + "[pc: ";
            for (int var2 = 0; var2 < this.field_311; ++var2) {
                if (var2 > 0) {
                    var1 = var1 + ", ";
                }
                var1 = var1 + String.valueOf(this.initializationPCs[var2 << 1]) + "-" + (this.initializationPCs[(var2 << 1) + 1] == -1 ? "?" : String.valueOf(this.initializationPCs[(var2 << 1) + 1]));
            }
            var1 = var1 + "]";
        }
        return var1;
    }
}
