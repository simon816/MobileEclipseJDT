package c;

import k.class_19;

public class class_283 implements Runnable {

    class_19[] field_1660;

    int field_1661;

    class_19[] field_1662;

    char[][] field_1663;

    int field_1664;

    int field_1665;

    Thread[] field_1666;

    char[] field_1667;

    int field_1668;

    private Throwable field_1669;

    static int field_1670;

    public static int field_1671;

    static int field_1672;

    public class_283(class_19[] var1, int var2) {
        this.field_1667 = new char[0];
    }

    public char[] method_2910(class_19 var1) {
        if (this.field_1666 != null && this.field_1660.length != 0) {
            boolean var2 = false;
            char[] var3 = null;
            synchronized (this) {
                if (var1 == this.field_1662[this.field_1664]) {
                    for (var3 = this.field_1663[this.field_1664]; var3 == this.field_1667 || var3 == null; var3 = this.field_1663[this.field_1664]) {
                        this.field_1663[this.field_1664] = null;
                        try {
                            this.wait(250L);
                        } catch (InterruptedException var8) {
                            ;
                        }
                    }
                    this.field_1662[this.field_1664] = null;
                    this.field_1663[this.field_1664] = null;
                    if (++this.field_1664 >= this.field_1663.length) {
                        this.field_1664 = 0;
                    }
                    if (this.field_1668 > 0) {
                        this.notify();
                        var2 = this.field_1668 == this.field_1666.length;
                    }
                } else {
                    int var5 = 0;
                    for (int var6 = this.field_1660.length; var5 < var6 && this.field_1660[var5] != var1; ++var5) {
                        ;
                    }
                    if (var5 == this.field_1660.length) {
                        this.field_1660 = new class_19[0];
                    } else if (var5 >= this.field_1661) {
                        this.field_1661 = var5 + field_1670;
                        this.field_1664 = 0;
                        this.field_1665 = 0;
                        this.field_1662 = new class_19[field_1672];
                        this.field_1663 = new char[field_1672][];
                        this.notifyAll();
                    }
                }
            }
            if (var2) {
                Thread.yield();
            }
            return var3 != null ? var3 : var1.method_51();
        } else if (this.field_1669 != null) {
            if (this.field_1669 instanceof Error) {
                throw(Error)this.field_1669;
            } else {
                throw(RuntimeException)this.field_1669;
            }
        } else {
            return var1.method_51();
        }
    }

    public void run() {
        RuntimeException var1;
        try {
            while (this.field_1666 != null && this.field_1661 < this.field_1660.length) {
                var1 = null;
                boolean var2 = true;
                class_19 var17;
                int var18;
                synchronized (this) {
                    if (this.field_1666 == null) {
                        return;
                    }
                    while (this.field_1662[this.field_1665] != null) {
                        ++this.field_1668;
                        try {
                            this.wait(250L);
                        } catch (InterruptedException var12) {
                            ;
                        }
                        --this.field_1668;
                        if (this.field_1666 == null) {
                            return;
                        }
                    }
                    if (this.field_1661 >= this.field_1660.length) {
                        return;
                    }
                    var17 = this.field_1660[this.field_1661++];
                    var18 = this.field_1665;
                    if (++this.field_1665 >= this.field_1663.length) {
                        this.field_1665 = 0;
                    }
                    this.field_1662[var18] = var17;
                    this.field_1663[var18] = this.field_1667;
                }
                char[] var3 = var17.method_51();
                synchronized (this) {
                    if (this.field_1662[var18] == var17) {
                        if (this.field_1663[var18] == null) {
                            this.notifyAll();
                        }
                        this.field_1663[var18] = var3;
                    }
                }
            }
        } catch (Error var14) {
            Error var16 = var14;
            synchronized (this) {
                this.field_1669 = var16;
                this.method_2911();
            }
        } catch (RuntimeException var15) {
            var1 = var15;
            synchronized (this) {
                this.field_1669 = var1;
                this.method_2911();
            }
        }
    }

    public synchronized void method_2911() {
        this.field_1666 = null;
        this.notifyAll();
    }

    static {
        field_1670 = 5;
        field_1671 = 10;
        field_1672 = 15;
    }
}
