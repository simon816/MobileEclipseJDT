package g;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import javax.microedition.io.file.FileConnection;

// $FF: renamed from: g.b
public class class_306 implements FileConnection {

    // $FF: renamed from: a java.lang.String
    private String field_1795;

    // $FF: renamed from: <init> (java.lang.String) void
    public class_306(String var1) {
        this.field_1795 = var1;
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
        return this.field_1795;
    }

    public String getPath() {
        return this.field_1795;
    }

    public String getURL() {
        return this.field_1795;
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
