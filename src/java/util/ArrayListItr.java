package java.util;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.NullClass;

class ArrayListItr implements Iterator {

    int nextIndex;

    int currentIndex;

    private final ArrayList theList;

    private ArrayListItr(ArrayList var1) {
        this.theList = var1;
        this.nextIndex = 0;
        this.currentIndex = -1;
    }

    public boolean hasNext() {
        return this.nextIndex != this.theList.size();
    }

    public Object next() {
        Object var1 = this.theList.get(this.nextIndex);
        this.currentIndex = this.nextIndex++;
        return var1;
    }

    ArrayListItr(ArrayList var1, NullClass var2) {
        this(var1);
    }
}
