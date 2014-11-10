package g;

import java.io.IOException;
import g.class_308;
import java.io.OutputStream;

public class class_311 extends OutputStream {

    OutputStream field_1810;

    public class_311(class_308 var1) throws IOException {
        if (!var1.method_3147()) {
            var1.field_1808.create();
        }
        this.field_1810 = var1.field_1808.openOutputStream();
    }

    public void close() throws IOException {
        this.field_1810.close();
    }

    public void write(byte[] var1) throws IOException {
        this.field_1810.write(var1);
    }

    public void write(byte[] var1, int var2, int var3) throws IOException {
        this.field_1810.write(var1, var2, var3);
    }

    public void write(int var1) throws IOException {
        this.field_1810.write(var1);
    }
}
