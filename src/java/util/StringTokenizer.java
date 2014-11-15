package java.util;

import java.util.Enumeration;

public class StringTokenizer implements Enumeration {

    private int currentPosition;

    private int newPosition;

    private int maxPosition;

    private String str;

    private String delimiters;

    private boolean retDelims;

    private boolean delimsChanged;

    private int maxDelimCodePoint;

    private boolean hasSurrogates;

    private int[] delimiterCodePoints;

    private void setMaxDelimCodePoint() {
        if (this.delimiters == null) {
            this.maxDelimCodePoint = 0;
        } else {
            int var1 = 0;
            int var3 = 0;
            int var2;
            int var4;
            for (var4 = 0; var4 < this.delimiters.length(); var4 += charCount(var2)) {
                var2 = this.delimiters.charAt(var4);
                if (var2 >= '\ud800' && var2 <= '\udfff') {
                    var2 = codePointAt(this.delimiters, var4);
                    this.hasSurrogates = true;
                }
                if (var1 < var2) {
                    var1 = var2;
                }
                ++var3;
            }
            this.maxDelimCodePoint = var1;
            if (this.hasSurrogates) {
                this.delimiterCodePoints = new int[var3];
                var4 = 0;
                for (int var5 = 0; var4 < var3; var5 += charCount(var2)) {
                    var2 = codePointAt(this.delimiters, var5);
                    this.delimiterCodePoints[var4] = var2;
                    ++var4;
                }
            }
        }
    }

    static int charCount(int var0) {
        return var0 >= 65536 ? 2 : 1;
    }

    static int codePointAt(String var0, int var1) {
        char var2 = var0.charAt(var1++);
        if (var2 >= '\ud800' && var2 <= '\udbff' && var1 < var0.length()) {
            char var3 = var0.charAt(var1);
            if (var3 >= '\udc00' && var3 <= '\udfff') {
                return (var2 - '\ud800' << 10) + (var3 - '\udc00') + 65536;
            }
        }
        return var2;
    }

    public StringTokenizer(String var1, String var2, boolean var3) {
        this.hasSurrogates = false;
        this.currentPosition = 0;
        this.newPosition = -1;
        this.delimsChanged = false;
        this.str = var1;
        this.maxPosition = var1.length();
        this.delimiters = var2;
        this.retDelims = var3;
        this.setMaxDelimCodePoint();
    }

    public StringTokenizer(String var1, String var2) {
        this(var1, var2, false);
    }

    private int skipDelimiters(int var1) {
        if (this.delimiters == null) {
            throw new NullPointerException();
        } else {
            int var2 = var1;
            while (!this.retDelims && var2 < this.maxPosition) {
                if (!this.hasSurrogates) {
                    char var4 = this.str.charAt(var2);
                    if (var4 > this.maxDelimCodePoint || this.delimiters.indexOf(var4) < 0) {
                        break;
                    }
                    ++var2;
                } else {
                    int var3 = codePointAt(this.str, var2);
                    if (var3 > this.maxDelimCodePoint || !this.isDelimiter(var3)) {
                        break;
                    }
                    var2 += charCount(var3);
                }
            }
            return var2;
        }
    }

    private int scanToken(int var1) {
        int var2 = var1;
        int var3;
        char var4;
        while (var2 < this.maxPosition) {
            if (!this.hasSurrogates) {
                var4 = this.str.charAt(var2);
                if (var4 <= this.maxDelimCodePoint && this.delimiters.indexOf(var4) >= 0) {
                    break;
                }
                ++var2;
            } else {
                var3 = codePointAt(this.str, var2);
                if (var3 <= this.maxDelimCodePoint && this.isDelimiter(var3)) {
                    break;
                }
                var2 += charCount(var3);
            }
        }
        if (this.retDelims && var1 == var2) {
            if (!this.hasSurrogates) {
                var4 = this.str.charAt(var2);
                if (var4 <= this.maxDelimCodePoint && this.delimiters.indexOf(var4) >= 0) {
                    ++var2;
                }
            } else {
                var3 = codePointAt(this.str, var2);
                if (var3 <= this.maxDelimCodePoint && this.isDelimiter(var3)) {
                    var2 += charCount(var3);
                }
            }
        }
        return var2;
    }

    private boolean isDelimiter(int var1) {
        for (int var2 = 0; var2 < this.delimiterCodePoints.length; ++var2) {
            if (this.delimiterCodePoints[var2] == var1) {
                return true;
            }
        }
        return false;
    }

    public boolean hasMoreTokens() {
        this.newPosition = this.skipDelimiters(this.currentPosition);
        return this.newPosition < this.maxPosition;
    }

    public String nextToken() {
        this.currentPosition = this.newPosition >= 0 && !this.delimsChanged ? this.newPosition : this.skipDelimiters(this.currentPosition);
        this.delimsChanged = false;
        this.newPosition = -1;
        if (this.currentPosition >= this.maxPosition) {
            throw new RuntimeException();
        } else {
            int var1 = this.currentPosition;
            this.currentPosition = this.scanToken(this.currentPosition);
            return this.str.substring(var1, this.currentPosition);
        }
    }

    public boolean hasMoreElements() {
        return this.hasMoreTokens();
    }

    public Object nextElement() {
        return this.nextToken();
    }
}
