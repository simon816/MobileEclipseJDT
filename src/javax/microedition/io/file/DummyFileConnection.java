package javax.microedition.io.file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import javax.microedition.io.file.FileConnection;

public class DummyFileConnection implements FileConnection {

    private String path;

    public DummyFileConnection(String var1) {
        this.path = var1;
    }

    public long availableSize() {
        return 0L;
    }

    public boolean canRead() {
        return false;
    }

    public boolean canWrite() {
        return false;
    }

    public void create() {}

    public void delete() {}

    public long directorySize(boolean var1) {
        return 0L;
    }

    public boolean exists() {
        return false;
    }

    public long fileSize() {
        return 0L;
    }

    public String getName() {
        return this.path;
    }

    public String getPath() {
        return this.path;
    }

    public String getURL() {
        return this.path;
    }

    public boolean isDirectory() {
        return false;
    }

    public boolean isHidden() {
        return false;
    }

    public boolean isOpen() {
        return false;
    }

    public long lastModified() {
        return 0L;
    }

    public Enumeration list() {
        return null;
    }

    public Enumeration list(String var1, boolean var2) {
        return null;
    }

    public void mkdir() {}

    public DataInputStream openDataInputStream() {
        return null;
    }

    public DataOutputStream openDataOutputStream() {
        return null;
    }

    public InputStream openInputStream() {
        return null;
    }

    public OutputStream openOutputStream() {
        return null;
    }

    public OutputStream openOutputStream(long var1) {
        return null;
    }

    public void rename(String var1) {}

    public void setFileConnection(String var1) {}

    public void setHidden(boolean var1) {}

    public void setReadable(boolean var1) {}

    public void setWritable(boolean var1) {}

    public long totalSize() {
        return 0L;
    }

    public void truncate(long var1) {}

    public long usedSize() {
        return 0L;
    }

    public void close() {}
}
