package java.util;

import java.util.Iterator;

public interface Collection {

    int size();

    boolean contains(Object var1);

    Iterator iterator();

    Object[] toArray();

    Object[] toArray(Object[] var1);

    boolean add(Object var1);

    void clear();

    boolean equals(Object var1);

    int hashCode();
}
