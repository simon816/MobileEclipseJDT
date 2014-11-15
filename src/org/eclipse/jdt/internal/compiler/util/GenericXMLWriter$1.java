package org.eclipse.jdt.internal.compiler.util;

import java.util.Comparator;
import java.util.Map$Entry;

import org.eclipse.jdt.internal.compiler.util.GenericXMLWriter;

class GenericXMLWriter$1 implements Comparator {

    private final GenericXMLWriter field_901;

    GenericXMLWriter$1(GenericXMLWriter var1) {
        this.field_901 = var1;
    }

    public int compare(Object var1, Object var2) {
        Map$Entry var3 = (Map$Entry)var1;
        Map$Entry var4 = (Map$Entry)var2;
        return ((String)var3.getKey()).compareTo((String)var4.getKey());
    }
}
