package java.util;

import java.util.Collection;

public interface Map {

    int size();

    Object get(Object var1);

    Object put(Object var1, Object var2);

    Object remove(Object var1);

    void clear();

    Collection keySet();

    Collection values();

    Collection entrySet();

    boolean equals(Object var1);

    int hashCode();
}
