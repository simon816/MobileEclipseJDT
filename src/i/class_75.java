package i;

import i.class_268;
import i.class_74;

// $FF: renamed from: i.q
public class class_75 extends class_74 {

    // $FF: renamed from: b int
    public int field_331;

    // $FF: renamed from: <init> (i.o) void
    public class_75(class_268 var1) {
        super(var1);
        this.field_331 = -1;
    }

    // $FF: renamed from: a () void
    void method_452() {
        if (this.field_323 == -1) {
            this.method_450(this.field_322.field_1208);
            this.field_322.field_1208 += 4;
            this.field_322.field_1190 += 4;
        } else {
            this.field_322.method_2385(this.field_323 - this.field_331);
        }
    }

    // $FF: renamed from: b () void
    void method_453() {
        this.method_452();
    }

    // $FF: renamed from: a () boolean
    public boolean method_457() {
        return false;
    }

    // $FF: renamed from: c () void
    public void method_458() {
        if ((this.field_330 & 2) != 0) {
            this.field_323 = this.field_322.method_2206();
        } else {
            this.field_323 = this.field_322.field_1208;
        }
        if (this.field_331 != -1) {
            int var1 = this.field_323 - this.field_331;
            int[] var2 = this.method_455();
            int var3 = 0;
            for (int var4 = this.method_454(); var3 < var4; ++var3) {
                this.field_322.method_2386(var2[var3], var1);
            }
            this.field_322.method_2089(this);
        }
    }

    // $FF: renamed from: d () void
    void method_459() {
        if (this.field_331 == -1) {
            this.field_331 = this.field_322.field_1208;
        }
    }
}