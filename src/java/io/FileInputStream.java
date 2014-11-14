package java.io;

import java.io.File;

import java.io.IOException;
import java.io.InputStream;

public class FileInputStream extends InputStream {

    InputStream inputStream;

    public FileInputStream(File var1) throws IOException {
        this.inputStream = var1.connection.openInputStream();
    }

    public int available() throws IOException {
        return this.inputStream.available();
    }

    public void close() throws IOException {
        this.inputStream.close();
    }

    public synchronized void mark(int var1) {
        this.inputStream.mark(var1);
    }

    public boolean markSupported() {
        return this.inputStream.markSupported();
    }

    public int read(byte[] var1) throws IOException {
        return this.inputStream.read(var1);
    }

    public int read(byte[] var1, int var2, int var3) throws IOException {
        return this.inputStream.read(var1, var2, var3);
    }

    public synchronized void reset() throws IOException {
        this.inputStream.reset();
    }

    public long skip(long var1) throws IOException {
        return this.inputStream.skip(var1);
    }

    public int read() throws IOException {
        return this.inputStream.read();
    }
}
