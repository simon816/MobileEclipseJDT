package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.internal.compiler.lookup.AnnotationBinding;
import org.eclipse.jdt.internal.compiler.lookup.ElementValuePair;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;

public abstract class Binding {

    public static final TypeBinding[] field_149;

    public static final TypeBinding[] field_150;

    public static final ReferenceBinding[] field_151;

    public static final ReferenceBinding[] field_152;

    public static final FieldBinding[] field_153;

    public static final MethodBinding[] field_154;

    public static final ReferenceBinding[] field_155;

    public static final ReferenceBinding[] field_156;

    public static final TypeVariableBinding[] NO_TYPE_VARIABLES;

    public static final AnnotationBinding[] NO_ANNOTATIONS;

    public static final ElementValuePair[] NO_ELEMENT_VALUE_PAIRS;

    public static final FieldBinding[] field_160;

    public static final MethodBinding[] field_161;

    public Binding() {
    }

    public abstract int kind();

    public long getAnnotationTagBits() {
        return 0L;
    }

    public void initializeDeprecatedAnnotationTagBits() {}

    public final boolean isValidBinding() {
        return this.problemId() == 0;
    }

    public int problemId() {
        return 0;
    }

    public abstract char[] readableName();

    public char[] shortReadableName() {
        return this.readableName();
    }

    static {
        field_149 = new TypeBinding[0];
        field_150 = new TypeBinding[0];
        field_151 = new ReferenceBinding[0];
        field_152 = new ReferenceBinding[] {null};
        field_153 = new FieldBinding[0];
        field_154 = new MethodBinding[0];
        field_155 = new ReferenceBinding[0];
        field_156 = new ReferenceBinding[0];
        NO_TYPE_VARIABLES = new TypeVariableBinding[0];
        NO_ANNOTATIONS = new AnnotationBinding[0];
        NO_ELEMENT_VALUE_PAIRS = new ElementValuePair[0];
        field_160 = new FieldBinding[0];
        field_161 = new MethodBinding[0];
    }
}
