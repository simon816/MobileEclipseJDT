package org.eclipse.jdt.internal.compiler.batch;

import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;

import org.eclipse.jdt.internal.compiler.batch.ClasspathLocation;
import org.eclipse.jdt.internal.compiler.classfmt.ClassFileReader;
import org.eclipse.jdt.internal.compiler.classfmt.ClassFormatException;
import org.eclipse.jdt.internal.compiler.env.NameEnvironmentAnswer;
import org.eclipse.jdt.internal.compiler.env.AccessRuleSet;

public class ClasspathJar extends ClasspathLocation {

    protected static Hashtable field_945;

    protected static Hashtable field_946;

    public ClasspathJar(AccessRuleSet var1, String var2) {
        super(var1, var2);
    }

    public NameEnvironmentAnswer findClass(char[] var1, String var2, String var3, boolean var4) {
        if (this.isPackage(var2) && field_946.containsKey(var3.substring(0, var3.length() - 6))) {
            try {
                ClassFileReader var10002 = new ClassFileReader(this.method_1283(var3), var3, false);
                NameEnvironmentAnswer var10000 = new NameEnvironmentAnswer(var10002, this.fetchAccessRestriction(var3));
                return var10000;
            } catch (ClassFormatException var6) {
                ;
            } catch (IOException var7) {
                ;
            }
            return null;
        } else {
            return null;
        }
    }

    public void reset() {
        if (field_945 == null) {
            try {
                Hashtable var1 = new Hashtable(600);
                Hashtable var2 = new Hashtable(150);
                InputStream var3 = this.getClass().getResourceAsStream("/lib/all");
                int var4 = var3.available();
                int var5 = var4;
                byte[] var6;
                for (var6 = new byte[var4]; var5 > 0; var5 -= var3.read(var6, var4 - var5, var5)) {
                    ;
                }
                var3.close();
                while (var5 < var4 - 3) {
                    int var7;
                    for (var7 = var5; var6[var7] != 32; ++var7) {
                        ;
                    }
                    String var8 = (new String(var6, var5, var7 - var5)).replace('.', '/');
                    var1.put(var8, new String(var6, var7 + 1, 2));
                    this.method_1282(var8, var2);
                    var5 = var7 + 5;
                }
                field_945 = var2;
                field_946 = var1;
            } catch (IOException var9) {
                var9.printStackTrace();
            }
        }
    }

    void method_1282(String var1, Hashtable var2) {
        String var4;
        for (int var3 = var1.lastIndexOf(47); var3 > 0; var3 = var4.lastIndexOf(47)) {
            var4 = var1.substring(0, var3);
            if (var2.containsKey(var4)) {
                return;
            }
            var2.put(var4, var4);
        }
    }

    byte[] method_1283(String var1) throws IOException {
        InputStream var2 = this.getClass().getResourceAsStream("/lib/" + field_946.get(var1.substring(0, var1.length() - 6)));
        int var3 = var2.available();
        byte[] var4 = new byte[var3];
        var2.read(var4);
        var2.close();
        return var4;
    }

    public boolean isPackage(String var1) {
        return field_945.containsKey(var1);
    }

    public void cleanup() {}

    public String toString() {
        return "Classpath for jar file ";
    }

    public char[] normalizedPath() {
        return this.normalizedPath;
    }
}
