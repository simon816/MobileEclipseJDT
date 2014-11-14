package java.io;

import g.DummyFileConnection;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;

public class File {

    String path;

    public int openMode;

    public FileConnection connection;

    public File(String var1) {
        this(var1, 3);
    }

    public File(String var1, int var2) {
        this.path = var1;
        this.openMode = var2;
        try {
            this.connection = (FileConnection)Connector.open("file://" + this.path, var2);
        } catch (Exception var4) {
            DummyFileConnection var10001 = new DummyFileConnection(this.path);
            this.connection = var10001;
        }
    }

    public String getPath() {
        return this.path;
    }

    public boolean exists() {
        return this.connection.exists();
    }

    public String getName() {
        return this.connection.getName();
    }

    public boolean isDirectory() {
        return this.connection.isDirectory();
    }

    public boolean isFile() {
        return this.connection.exists() && !this.connection.isDirectory();
    }

    public long length() throws IOException {
        return this.connection.fileSize();
    }

    public File[] listFiles() throws IOException {
        Enumeration var1 = this.connection.list("*", true);
        Vector var2 = new Vector();
        String var3 = this.connection.getPath() + (this.connection.isDirectory() ? this.connection.getName() : "");
        while (var1.hasMoreElements()) {
            File var10001 = new File(var3 + var1.nextElement());
            var2.addElement(var10001);
        }
        File[] var4 = new File[var2.size()];
        var2.copyInto(var4);
        return var4;
    }

    public String[] list() {
        Enumeration var1;
        try {
            var1 = this.connection.list("*", true);
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

    public boolean mkdirs() {
        if (!this.connection.isDirectory()) {
            try {
                File var10000 = new File(this.connection.getPath());
                var10000.mkdirs();
                ((FileConnection)Connector.open("file://" + this.path, 2)).mkdir();
            } catch (IOException var2) {
                return false;
            }
        }
        return true;
    }

    public String getAbsolutePath() {
        return this.path;
    }

    public boolean mkdir() {
        if (this.connection.isDirectory()) {
            return true;
        } else {
            try {
                this.connection.mkdir();
                return true;
            } catch (IOException var2) {
                return false;
            }
        }
    }

    public long lastModified() {
        return this.connection.lastModified();
    }

    public String toString() {
        return this.connection.getURL();
    }
}
