package java.util;

import java.util.Collection;
import java.util.Map;
import java.util.ArrayList;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashMap implements Map {

    Hashtable hashtable;

    public HashMap(int var1) {
        this.hashtable = new Hashtable(var1);
    }

    public HashMap() {
        this.hashtable = new Hashtable();
    }

    public int size() {
        return this.hashtable.size();
    }

    public Object get(Object var1) {
        return this.hashtable.get(var1);
    }

    public Object put(Object var1, Object var2) {
        return this.hashtable.put(var1, var2);
    }

    public Object remove(Object var1) {
        return this.hashtable.remove(var1);
    }

    public void clear() {
        this.hashtable.clear();
    }

    public Collection keySet() {
        Enumeration var1 = this.hashtable.keys();
        ArrayList var10000 = new ArrayList(this.hashtable.size());
        ArrayList var2 = var10000;
        while (var1.hasMoreElements()) {
            var2.add(var1.nextElement());
        }
        return var2;
    }

    public Collection values() {
        Enumeration var1 = this.hashtable.elements();
        ArrayList var10000 = new ArrayList(this.hashtable.size());
        ArrayList var2 = var10000;
        while (var1.hasMoreElements()) {
            var2.add(var1.nextElement());
        }
        return var2;
    }

    public Collection entrySet() {
        throw new RuntimeException("HashMap entrySet Not supported yet.");
    }
}
