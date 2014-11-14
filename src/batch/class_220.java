package batch;

import b.CharOperation;
import batch.class_219;
import batch.class_237;
import e.class_190;
import f.Util;
import java.io.File;
import j.class_346;

import java.util.Hashtable;

import k.class_317;
import k.class_343;

public class class_220 extends class_219 {

    protected class_220(class_343 var1, String var2) {
        super(var1, var2);
    }

    private Hashtable field_941;

    private String[] field_942;

    private int field_943;

    private String field_944;

    String[] method_1280(String var1) {
        String[] var2 = (String[])((String[])this.field_941.get(var1));
        if (var2 == this.field_942) {
            return null;
        } else if (var2 != null) {
            return var2;
        } else {
            File var10000 = new File(this.field_937 + var1);
            File var3 = var10000;
            if (var3.isDirectory()) {
                label46: {
                    int var4 = var1.length();
                    int var5 = var1.lastIndexOf(47);
                    do {
                        --var4;
                    } while (var4 > var5 && !class_346.method_3342(var1.charAt(var4)));
                    if (var4 > var5) {
                        if (var5 == -1) {
                            if (!this.method_1281(var1, Util.field_982)) {
                                break label46;
                            }
                        } else {
                            String var6 = var1.substring(var5 + 1);
                            String var7 = var1.substring(0, var5);
                            if (!this.method_1281(var6, var7)) {
                                break label46;
                            }
                        }
                    }
                    if ((var2 = var3.list()) == null) {
                        var2 = CharOperation.field_996;
                    }
                    this.field_941.put(var1, var2);
                    return var2;
                }
            }
            this.field_941.put(var1, this.field_942);
            return null;
        }
    }

    boolean method_1281(String var1, String var2) {
        String[] var3 = this.method_1280(var2);
        if (var3 == null) {
            return false;
        } else {
            int var4 = var3.length;
            do {
                --var4;
                if (var4 < 0) {
                    return false;
                }
            } while (!var1.equals(var3[var4]));
            return true;
        }
    }

    public class_317 method_14(char[] var1, String var2, String var3, boolean var4) {
        if (!this.method_15(var2)) {
            return null;
        } else {
            String var5 = new String(var1);
            boolean var6 = (this.field_943 & 2) != 0 && this.method_1281(var5 + ".class", var2);
            boolean var7 = (this.field_943 & 1) != 0 && this.method_1281(var5 + ".java", var2);
            class_317 var15;
            if (var7 && !var4) {
                String var8 = this.field_937 + var3.substring(0, var3.length() - 6) + ".java";
                class_237 var10002;
                if (!var6) {
                    var10002 = new class_237((char[])null, var8, this.field_944, this.field_940);
                    var15 = new class_317(var10002, this.method_1279(var3));
                    return var15;
                }
                String var9 = this.field_937 + var3;
                File var10000 = new File(var9);
                long var10 = var10000.lastModified();
                var10000 = new File(var8);
                long var12 = var10000.lastModified();
                if (var12 > var10) {
                    var10002 = new class_237((char[])null, var8, this.field_944, this.field_940);
                    var15 = new class_317(var10002, this.method_1279(var3));
                    return var15;
                }
            }
            if (var6) {
                try {
                    class_190 var16 = class_190.method_1122(this.field_937 + var3);
                    if (var16 != null) {
                        var15 = new class_317(var16, this.method_1279(var3));
                        return var15;
                    }
                } catch (Exception var14) {
                    ;
                }
            }
            return null;
        }
    }

    public void method_18() {}

    public boolean method_15(String var1) {
        return this.method_1280(var1) != null;
    }

    public void method_16() {
        this.field_941 = new Hashtable(11);
    }

    public String toString() {
        return "ClasspathDirectory " + this.field_937;
    }

    public char[] method_17() {
        if (this.field_938 == null) {
            this.field_938 = this.field_937.toCharArray();
        }
        return this.field_938;
    }
}
