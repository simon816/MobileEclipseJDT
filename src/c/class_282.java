package c;

import c.class_286;
import f.class_329;
import h.class_90;

public class class_282 implements Runnable {

    class_286 field_1649;

    private int field_1650;

    private Thread field_1651;

    class_90 field_1652;

    private Throwable field_1653;

    volatile int field_1654;

    volatile int field_1655;

    volatile int field_1656;

    volatile int field_1657;

    class_90[] field_1658;

    public static int field_1659;

    public class_282(class_286 var1) {
        this.field_1649 = var1;
        this.field_1650 = 0;
        this.field_1654 = 0;
        this.field_1655 = 0;
        this.field_1656 = field_1659;
        this.field_1657 = 0;
        this.field_1658 = new class_90[this.field_1656];
        synchronized (this) {
            this.field_1651 = new Thread(this, "Compiler Processing Task");
            this.field_1651.start();
        }
    }

    private synchronized void method_2905(class_90 var1) {
        for (; this.field_1658[this.field_1655] != null; this.field_1657 = 0) {
            this.field_1657 = 1;
            try {
                this.wait(250L);
            } catch (InterruptedException var3) {
                ;
            }
        }
        this.field_1658[this.field_1655++] = var1;
        if (this.field_1655 >= this.field_1656) {
            this.field_1655 = 0;
        }
        if (this.field_1657 <= -1) {
            this.notify();
        }
    }

    public class_90 method_2906() {
        class_90 var1 = null;
        boolean var2 = false;
        synchronized (this) {
            var1 = this.field_1658[this.field_1654];
            if (var1 == null || this.field_1653 != null) {
                do {
                    if (this.field_1651 == null) {
                        if (this.field_1653 != null) {
                            if (this.field_1653 instanceof Error) {
                                throw(Error)this.field_1653;
                            }
                            throw(RuntimeException)this.field_1653;
                        }
                        return null;
                    }
                    this.field_1657 = -1;
                    try {
                        this.wait(100L);
                    } catch (InterruptedException var6) {
                        ;
                    }
                    this.field_1657 = 0;
                    var1 = this.field_1658[this.field_1654];
                } while (var1 == null);
            }
            this.field_1658[this.field_1654++] = null;
            if (this.field_1654 >= this.field_1656) {
                this.field_1654 = 0;
            }
            if (this.field_1657 >= 1 && ++this.field_1657 > 4) {
                this.notify();
                var2 = this.field_1657 > 8;
            }
        }
        if (var2) {
            Thread.yield();
        }
        return var1;
    }

    public void run() {
        while (this.field_1651 != null) {
            this.field_1652 = null;
            boolean var1 = true;
            try {
                int var19;
                synchronized (this) {
                    if (this.field_1651 == null) {
                        return;
                    }
                    this.field_1652 = this.field_1649.method_2945(this.field_1650);
                    if (this.field_1652 == null) {
                        this.field_1651 = null;
                        return;
                    }
                    var19 = this.field_1650++;
                }
                try {
                    this.field_1649.method_2942(class_329.method_3251(class_329.field_1871, new String(this.field_1652.method_771())));
                    if (this.field_1649.field_1699.field_1931) {
                        this.field_1649.field_1701.println(class_329.method_3253(class_329.field_1864, new String[] {String.valueOf(var19 + 1), String.valueOf(this.field_1649.field_1706), new String(this.field_1652.method_771())}));
                    }
                    this.field_1649.method_2950(this.field_1652, var19);
                } finally {
                    if (this.field_1652 != null) {
                        this.field_1652.method_766();
                    }
                }
                this.method_2905(this.field_1652);
            } catch (Error var17) {
                Error var20 = var17;
                synchronized (this) {
                    this.field_1651 = null;
                    this.field_1653 = var20;
                    return;
                }
            } catch (RuntimeException var18) {
                RuntimeException var2 = var18;
                synchronized (this) {
                    this.field_1651 = null;
                    this.field_1653 = var2;
                    return;
                }
            }
        }
    }

    public void method_2907() {
        try {
            Thread var1 = null;
            synchronized (this) {
                if (this.field_1651 != null) {
                    var1 = this.field_1651;
                    this.field_1651 = null;
                    this.notifyAll();
                }
            }
            if (var1 != null) {
                var1.join();
            }
        } catch (InterruptedException var5) {
            ;
        }
    }

    static {
        field_1659 = 12;
    }
}
