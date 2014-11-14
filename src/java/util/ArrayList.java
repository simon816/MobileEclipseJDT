package java.util;

import java.util.List;
import java.util.Iterator;
import java.util.class_314;
import java.util.ArrayListItr;
import java.util.Vector;

public class ArrayList implements List {

    Vector vector;

    public ArrayList(int var1) {
        this.vector = new Vector(var1);
    }

    public ArrayList() {
        this.vector = new Vector();
    }

    public Object get(int var1) {
        return this.vector.elementAt(var1);
    }

    public Object remove(int var1) {
        Object var2 = this.vector.elementAt(var1);
        this.vector.removeElementAt(var1);
        return var2;
    }

    public int indexOf(Object var1) {
        return this.vector.indexOf(var1);
    }

    public int size() {
        return this.vector.size();
    }

    public boolean contains(Object var1) {
        return this.vector.contains(var1);
    }

    public Iterator iterator() {
        ArrayListItr var10000 = new ArrayListItr(this, (class_314)null);
        return var10000;
    }

    public Object[] toArray() {
        Object[] var1 = new Object[this.vector.size()];
        return this.toArray(var1);
    }

    public Object[] toArray(Object[] var1) {
        this.vector.copyInto(var1);
        return var1;
    }

    public boolean add(Object var1) {
        this.vector.addElement(var1);
        return true;
    }

    public void clear() {
        this.vector.removeAllElements();
    }
}
