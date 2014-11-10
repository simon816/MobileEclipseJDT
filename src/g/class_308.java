package g;

import g.class_306;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;
import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;

public class class_308 {

    String field_1806;

    public int field_1807;

    public FileConnection field_1808;

    public class_308(String var1) {
        this(var1, 3);
    }

    public class_308(String var1, int var2) {
        this.field_1806 = var1;
        this.field_1807 = var2;
        try {
            this.field_1808 = (FileConnection)Connector.open("file://" + this.field_1806, var2);
        } catch (Exception var4) {
            class_306 var10001 = new class_306(this.field_1806);
            this.field_1808 = var10001;
        }
    }

    public String method_3143() {
        return this.field_1806;
    }

    public boolean method_3144() {
        return this.field_1808.exists();
    }

    public String method_3145() {
        return this.field_1808.getName();
    }

    public boolean method_3146() {
        return this.field_1808.isDirectory();
    }

    public boolean method_3147() {
        return this.field_1808.exists() && !this.field_1808.isDirectory();
    }

    public long method_3148() throws IOException {
        return this.field_1808.fileSize();
    }

    public class_308[] method_3149() throws IOException {
        Enumeration var1 = this.field_1808.list("*", true);
        Vector var2 = new Vector();
        String var3 = this.field_1808.getPath() + (this.field_1808.isDirectory() ? this.field_1808.getName() : "");
        while (var1.hasMoreElements()) {
            class_308 var10001 = new class_308(var3 + var1.nextElement());
            var2.addElement(var10001);
        }
        class_308[] var4 = new class_308[var2.size()];
        var2.copyInto(var4);
        return var4;
    }

    public String[] method_3150() {
        Enumeration var1;
        try {
            var1 = this.field_1808.list("*", true);
        } catch (IOException var4) {
            return null;
        }
        Vector var2 = new Vector();
        while (var1.hasMoreElements()) {
            var2.addElement(var1.nextElement());
        }
        String[] var3 = new String[var2.size()];
        var2.copyInto(var3);
        return var3;
    }

    public boolean method_3151() {
        if (!this.field_1808.isDirectory()) {
            try {
                class_308 var10000 = new class_308(this.field_1808.getPath());
                var10000.method_3151();
                ((FileConnection)Connector.open("file://" + this.field_1806, 2)).mkdir();
            } catch (IOException var2) {
                return false;
            }
        }
        return true;
    }

    public String method_3152() {
        return this.field_1806;
    }

    public boolean method_3153() {
        if (this.field_1808.isDirectory()) {
            return true;
        } else {
            try {
                this.field_1808.mkdir();
                return true;
            } catch (IOException var2) {
                return false;
            }
        }
    }

    public long method_3154() {
        return this.field_1808.lastModified();
    }

    public String toString() {
        return this.field_1808.getURL();
    }
}
