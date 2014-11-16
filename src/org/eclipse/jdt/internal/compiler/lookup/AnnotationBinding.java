package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.ElementValuePair;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;
import org.eclipse.jdt.internal.compiler.lookup.Scope;

public class AnnotationBinding {

    ReferenceBinding type;

    ElementValuePair[] pairs;

    public static AnnotationBinding[] addStandardAnnotations(AnnotationBinding[] var0, long var1, LookupEnvironment var3) {
        int var4 = 0;
        if ((var1 & 17557826306048L) != 0L) {
            ++var4;
        }
        if ((var1 & 52776558133248L) != 0L) {
            ++var4;
        }
        if ((var1 & 70368744177664L) != 0L) {
            ++var4;
        }
        if ((var1 & 140737488355328L) != 0L) {
            ++var4;
        }
        if ((var1 & 281474976710656L) != 0L) {
            ++var4;
        }
        if ((var1 & 562949953421312L) != 0L) {
            ++var4;
        }
        if ((var1 & 1125899906842624L) != 0L) {
            ++var4;
        }
        if (var4 == 0) {
            return var0;
        } else {
            int var5 = var0.length;
            AnnotationBinding[] var6 = new AnnotationBinding[var5 + var4];
            System.arraycopy(var0, 0, var6, 0, var5);
            if ((var1 & 17557826306048L) != 0L) {
                var6[var5++] = method_1179(var1, var3);
            }
            if ((var1 & 52776558133248L) != 0L) {
                var6[var5++] = method_1178(var1, var3);
            }
            if ((var1 & 70368744177664L) != 0L) {
                var6[var5++] = buildMarkerAnnotation(TypeConstants.field_119, var3);
            }
            if ((var1 & 140737488355328L) != 0L) {
                var6[var5++] = buildMarkerAnnotation(TypeConstants.field_120, var3);
            }
            if ((var1 & 281474976710656L) != 0L) {
                var6[var5++] = buildMarkerAnnotation(TypeConstants.field_121, var3);
            }
            if ((var1 & 562949953421312L) != 0L) {
                var6[var5++] = buildMarkerAnnotation(TypeConstants.field_122, var3);
            }
            if ((var1 & 1125899906842624L) != 0L) {
                var6[var5++] = buildMarkerAnnotation(TypeConstants.field_124, var3);
            }
            return var6;
        }
    }

    private static AnnotationBinding buildMarkerAnnotation(char[][] var0, LookupEnvironment var1) {
        ReferenceBinding var2 = var1.getResolvedType(var0, (Scope)null);
        return var1.createAnnotation(var2, Binding.NO_ELEMENT_VALUE_PAIRS);
    }

    private static AnnotationBinding method_1178(long var0, LookupEnvironment var2) {
        ReferenceBinding var3 = var2.getResolvedType(TypeConstants.field_126, (Scope)null);
        FieldBinding var4 = null;
        if ((var0 & 52776558133248L) != 0L) {
            var4 = var3.getField(TypeConstants.field_75, true);
        } else if ((var0 & 35184372088832L) != 0L) {
            var4 = var3.getField(TypeConstants.field_74, true);
        } else if ((var0 & 17592186044416L) != 0L) {
            var4 = var3.getField(TypeConstants.field_73, true);
        }
        ReferenceBinding var10001 = var2.getResolvedType(TypeConstants.field_123, (Scope)null);
        ElementValuePair[] var10002 = new ElementValuePair[1];
        ElementValuePair var10005 = new ElementValuePair(TypeConstants.field_70, var4, (MethodBinding)null);
        var10002[0] = var10005;
        return var2.createAnnotation(var10001, var10002);
    }

    private static AnnotationBinding method_1179(long var0, LookupEnvironment var2) {
        ReferenceBinding var3 = var2.getResolvedType(TypeConstants.field_125, (Scope)null);
        if ((var0 & 34359738368L) != 0L) {
            AnnotationBinding var10000 = new AnnotationBinding(var3, Binding.NO_ELEMENT_VALUE_PAIRS);
            return var10000;
        } else {
            int var4 = 0;
            if ((var0 & 4398046511104L) != 0L) {
                ++var4;
            }
            if ((var0 & 1099511627776L) != 0L) {
                ++var4;
            }
            if ((var0 & 137438953472L) != 0L) {
                ++var4;
            }
            if ((var0 & 2199023255552L) != 0L) {
                ++var4;
            }
            if ((var0 & 274877906944L) != 0L) {
                ++var4;
            }
            if ((var0 & 8796093022208L) != 0L) {
                ++var4;
            }
            if ((var0 & 549755813888L) != 0L) {
                ++var4;
            }
            if ((var0 & 68719476736L) != 0L) {
                ++var4;
            }
            Object[] var5 = new Object[var4];
            if (var4 > 0) {
                ReferenceBinding var6 = var2.getResolvedType(TypeConstants.field_127, (Scope)null);
                int var7 = 0;
                if ((var0 & 4398046511104L) != 0L) {
                    var5[var7++] = var6.getField(TypeConstants.field_84, true);
                }
                if ((var0 & 1099511627776L) != 0L) {
                    var5[var7++] = var6.getField(TypeConstants.field_82, true);
                }
                if ((var0 & 137438953472L) != 0L) {
                    var5[var7++] = var6.getField(TypeConstants.field_79, true);
                }
                if ((var0 & 2199023255552L) != 0L) {
                    var5[var7++] = var6.getField(TypeConstants.field_83, true);
                }
                if ((var0 & 274877906944L) != 0L) {
                    var5[var7++] = var6.getField(TypeConstants.field_80, true);
                }
                if ((var0 & 8796093022208L) != 0L) {
                    var5[var7++] = var6.getField(TypeConstants.field_85, true);
                }
                if ((var0 & 549755813888L) != 0L) {
                    var5[var7++] = var6.getField(TypeConstants.field_81, true);
                }
                if ((var0 & 68719476736L) != 0L) {
                    var5[var7++] = var6.getField(TypeConstants.field_78, true);
                }
            }
            ElementValuePair[] var10002 = new ElementValuePair[1];
            ElementValuePair var10005 = new ElementValuePair(TypeConstants.field_70, var5, (MethodBinding)null);
            var10002[0] = var10005;
            return var2.createAnnotation(var3, var10002);
        }
    }

    AnnotationBinding(ReferenceBinding var1, ElementValuePair[] var2) {
        this.type = var1;
        this.pairs = var2;
    }

    AnnotationBinding(Annotation var1) {
        this((ReferenceBinding)var1.resolvedType, var1.computeElementValuePairs());
    }

    public ReferenceBinding getAnnotationType() {
        return this.type;
    }

    public static void setMethodBindings(ReferenceBinding var0, ElementValuePair[] var1) {
        int var2 = var1.length;
        while (true) {
            --var2;
            if (var2 < 0) {
                return;
            }
            ElementValuePair var3 = var1[var2];
            MethodBinding[] var4 = var0.getMethods(var3.getName());
            if (var4 != null && var4.length == 1) {
                var3.setMethodBinding(var4[0]);
            }
        }
    }

    public String toString() {
        StringBuffer var1 = new StringBuffer(5);
        var1.append('@').append(this.type.sourceName);
        if (this.pairs != null && this.pairs.length > 0) {
            var1.append("{ ");
            int var2 = 0;
            for (int var3 = this.pairs.length; var2 < var3; ++var2) {
                if (var2 > 0) {
                    var1.append(", ");
                }
                var1.append(this.pairs[var2]);
            }
            var1.append('}');
        }
        return var1.toString();
    }
}
