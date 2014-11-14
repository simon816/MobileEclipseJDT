package java.io;

import java.io.IOException;
import java.io.File;
import java.io.OutputStream;

public class FileOutputStream extends OutputStream {

    OutputStream outputStream;

    public FileOutputStream(File var1) throws IOException {
        if (!var1.isFile()) {
            var1.connection.create();
        }
        this.outputStream = var1.connection.openOutputStream();
    }

    public void close() throws IOException {
        this.outputStream.close();
    }

    public void write(byte[] var1) throws IOException {
        this.outputStream.write(var1);
    }

    public void write(byte[] var1, int var2, int var3) throws IOException {
        this.outputStream.write(var1, var2, var3);
    }

    public void write(int var1) throws IOException {
        this.outputStream.write(var1);
    }
}
