package g;

import java.io.IOException;
import g.class_308;
import java.io.InputStream;

// $FF: renamed from: g.h
public class class_310 extends InputStream {

    // $FF: renamed from: a java.io.InputStream
    InputStream field_1809;

    // $FF: renamed from: <init> (g.g) void
    public class_310(class_308 var1) throws IOException {
        this.field_1809 = var1.field_1808.openInputStream();
    }

    public int available() throws IOException {
        return this.field_1809.available();
    }

    public void close() throws IOException {
        this.field_1809.close();
    }

    public synchronized void mark(int var1) {
        this.field_1809.mark(var1);
    }

    public boolean markSupported() {
        return this.field_1809.markSupported();
    }

    public int read(byte[] var1) throws IOException {
        return this.field_1809.read(var1);
    }

    public int read(byte[] var1, int var2, int var3) throws IOException {
        return this.field_1809.read(var1, var2, var3);
    }

    public synchronized void reset() throws IOException {
        this.field_1809.reset();
    }

    public long skip(long var1) throws IOException {
        return this.field_1809.skip(var1);
    }

    public int read() throws IOException {
        return this.field_1809.read();
    }
}
