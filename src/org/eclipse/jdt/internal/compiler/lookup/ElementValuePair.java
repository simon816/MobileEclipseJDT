package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.ArrayInitializer;
import org.eclipse.jdt.internal.compiler.ast.ClassLiteralAccess;
import org.eclipse.jdt.internal.compiler.ast.Reference;
import org.eclipse.jdt.internal.compiler.ast.FieldReference;
import org.eclipse.jdt.internal.compiler.ast.NameReference;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.impl.Constant;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;

public class ElementValuePair {

    char[] name;

    public Object value;

    public MethodBinding binding;

    public static Object getValue(Expression var0) {
        if (var0 == null) {
            return null;
        } else {
            Constant var1 = var0.constant;
            if (var1 != null && var1 != Constant.NotAConstant) {
                return var1;
            } else if (var0 instanceof Annotation) {
                return ((Annotation)var0).getCompilerAnnotation();
            } else if (!(var0 instanceof ArrayInitializer)) {
                if (var0 instanceof ClassLiteralAccess) {
                    return ((ClassLiteralAccess)var0).targetType;
                } else {
                    if (var0 instanceof Reference) {
                        FieldBinding var6 = null;
                        if (var0 instanceof FieldReference) {
                            var6 = ((FieldReference)var0).fieldBinding();
                        } else if (var0 instanceof NameReference) {
                            Binding var7 = ((NameReference)var0).field_748;
                            if (var7 != null && var7.kind() == 1) {
                                var6 = (FieldBinding)var7;
                            }
                        }
                        if (var6 != null && (var6.field_300 & 16384) > 0) {
                            return var6;
                        }
                    }
                    return null;
                }
            } else {
                Expression[] var2 = ((ArrayInitializer)var0).expressions;
                int var3 = var2 == null ? 0 : var2.length;
                Object[] var4 = new Object[var3];
                for (int var5 = 0; var5 < var3; ++var5) {
                    var4[var5] = getValue(var2[var5]);
                }
                return var4;
            }
        }
    }

    public ElementValuePair(char[] var1, Expression var2, MethodBinding var3) {
        this(var1, getValue(var2), var3);
    }

    public ElementValuePair(char[] var1, Object var2, MethodBinding var3) {
        this.name = var1;
        this.value = var2;
        this.binding = var3;
    }

    public char[] getName() {
        return this.name;
    }

    void setMethodBinding(MethodBinding var1) {
        this.binding = var1;
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer(5);
        var1.append(this.name).append(" = ");
        var1.append(this.value);
        return var1.toString();
    }
}
