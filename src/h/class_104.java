package h;

import c.class_264;
import h.class_89;
import h.class_98;
import h.class_99;
import i.class_268;
import i.class_74;
import l.class_293;
import l.class_296;
import l.class_301;
import l.class_303;
import m.class_86;

public class class_104 extends class_98 {

    public class_98 field_541;

    public char[] field_542;

    public class_74 field_543;

    public int field_544;

    int field_545;

    public class_104(char[] var1, class_98 var2, long var3, int var5) {
        this.field_545 = -1;
        this.field_541 = var2;
        if (var2 instanceof class_99) {
            var2.field_446 |= 1;
        }
        this.field_542 = var1;
        this.field_444 = (int)(var3 >>> 32);
        this.field_544 = (int)var3;
        this.field_445 = var5;
    }

    public class_301 method_814(class_86 var1, class_293 var2, class_301 var3) {
        if (this.field_541 == null) {
            return var3;
        } else {
            class_98 var10000 = this.field_541;
            char[] var10006 = this.field_542;
            class_74 var10008 = new class_74();
            class_296 var10002 = new class_296(var2, this, var10006, this.field_543 = var10008, var1);
            class_296 var4 = var10002;
            class_301 var5 = var10000.method_814(var1, var10002, var3);
            boolean var7 = (var5.field_1783 & 1) != 0 && (var4.field_1746.field_1783 & 1) == 0;
            class_303 var6 = var5.method_3105(var4.field_1746);
            if (var7) {
                ((class_303)var6).method_3071(var3.method_3108()).method_3071(var4.field_1746.method_3108());
            }
            this.field_545 = var1.method_635().method_729(var6);
            if ((this.field_446 & 64) == 0) {
                var1.method_644().method_1810(this);
            }
            return var6;
        }
    }

    public class_89 method_750() {
        return this.field_541;
    }

    public void method_818(class_86 var1, class_268 var2) {
        if ((this.field_446 & Integer.MIN_VALUE) != 0) {
            int var3 = var2.field_1208;
            if (this.field_543 != null) {
                this.field_543.method_456(var2);
                if (this.field_541 != null) {
                    this.field_541.method_818(var1, var2);
                }
                this.field_543.method_458();
            }
            if (this.field_545 != -1) {
                var2.method_2363(var1, this.field_545);
                var2.method_2088(var1, this.field_545);
            }
            var2.method_2360(var3, this.field_444);
        }
    }

    public StringBuffer method_820(int var1, StringBuffer var2) {
        method_759(var1, var2).append(this.field_542).append(": ");
        if (this.field_541 == null) {
            var2.append(';');
        } else {
            this.field_541.method_820(0, var2);
        }
        return var2;
    }

    public void method_821(class_86 var1) {
        if (this.field_541 != null) {
            this.field_541.method_821(var1);
        }
    }

    public void method_763(class_264 var1, class_86 var2) {
        if (var1.method_2030(this, var2) && this.field_541 != null) {
            this.field_541.method_763(var1, var2);
        }
        var1.method_1945(this, var2);
    }
}
