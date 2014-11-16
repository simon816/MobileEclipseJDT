package org.eclipse.jdt.internal.compiler.lookup;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.BinaryTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ProblemReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.LookupEnvironment;
import org.eclipse.jdt.internal.compiler.util.HashtableOfPackage;
import org.eclipse.jdt.internal.compiler.util.HashtableOfType;

public class PackageBinding extends Binding implements TypeConstants {

    public long tagBits;

    public char[][] compoundName;

    PackageBinding parent;

    public LookupEnvironment environment;

    HashtableOfType knownTypes;

    HashtableOfPackage knownPackages;

    protected PackageBinding() {
        this.tagBits = 0L;
    }

    public PackageBinding(char[] var1, LookupEnvironment var2) {
        this(new char[][] {var1}, (PackageBinding)null, var2);
    }

    public PackageBinding(char[][] var1, PackageBinding var2, LookupEnvironment var3) {
        this.tagBits = 0L;
        this.compoundName = var1;
        this.parent = var2;
        this.environment = var3;
        this.knownTypes = null;
        HashtableOfPackage var10001 = new HashtableOfPackage(3);
        this.knownPackages = var10001;
    }

    public PackageBinding(LookupEnvironment var1) {
        this(CharOperation.NO_CHAR_CHAR, (PackageBinding)null, var1);
    }

    private void method_115(char[] var1) {
        this.knownPackages.put(var1, LookupEnvironment.TheNotFoundPackage);
    }

    private void method_116(char[] var1) {
        if (this.knownTypes == null) {
            HashtableOfType var10001 = new HashtableOfType(25);
            this.knownTypes = var10001;
        }
        this.knownTypes.put(var1, LookupEnvironment.TheNotFoundType);
    }

    void addPackage(PackageBinding var1) {
        if ((var1.tagBits & 128L) == 0L) {
            this.clearMissingTagBit();
        }
        this.knownPackages.put(var1.compoundName[var1.compoundName.length - 1], var1);
    }

    void addType(ReferenceBinding var1) {
        if ((var1.tagBits & 128L) == 0L) {
            this.clearMissingTagBit();
        }
        if (this.knownTypes == null) {
            HashtableOfType var10001 = new HashtableOfType(25);
            this.knownTypes = var10001;
        }
        this.knownTypes.put(var1.compoundName[var1.compoundName.length - 1], var1);
    }

    void clearMissingTagBit() {
        PackageBinding var1 = this;
        do {
            var1.tagBits &= -129L;
        } while ((var1 = var1.parent) != null);
    }

    private PackageBinding findPackage(char[] var1) {
        if (!this.environment.isPackage(this.compoundName, var1)) {
            return null;
        } else {
            char[][] var2 = CharOperation.arrayConcat(this.compoundName, var1);
            PackageBinding var10000 = new PackageBinding(var2, this, this.environment);
            PackageBinding var3 = var10000;
            this.addPackage(var3);
            return var3;
        }
    }

    PackageBinding method_121(char[] var1) {
        PackageBinding var2 = this.method_122(var1);
        if (var2 != null) {
            return var2 == LookupEnvironment.TheNotFoundPackage ? null : var2;
        } else if ((var2 = this.findPackage(var1)) != null) {
            return var2;
        } else {
            this.method_115(var1);
            return null;
        }
    }

    PackageBinding method_122(char[] var1) {
        return this.knownPackages.get(var1);
    }

    ReferenceBinding method_123(char[] var1) {
        ReferenceBinding var2 = this.method_124(var1);
        if (var2 == null && (var2 = this.environment.askForType(this, var1)) == null) {
            this.method_116(var1);
            return null;
        } else if (var2 == LookupEnvironment.TheNotFoundType) {
            return null;
        } else {
            var2 = BinaryTypeBinding.method_267(var2, this.environment, false);
            if (var2.method_160()) {
                ProblemReferenceBinding var10000 = new ProblemReferenceBinding(new char[][] {var1}, var2, 4);
                return var10000;
            } else {
                return var2;
            }
        }
    }

    ReferenceBinding method_124(char[] var1) {
        return this.knownTypes == null ? null : this.knownTypes.get(var1);
    }

    public Binding getTypeOrPackage(char[] var1) {
        ReferenceBinding var2 = this.method_124(var1);
        ProblemReferenceBinding var10000;
        if (var2 != null && var2 != LookupEnvironment.TheNotFoundType) {
            var2 = BinaryTypeBinding.method_267(var2, this.environment, false);
            if (var2.method_160()) {
                var10000 = new ProblemReferenceBinding(new char[][] {var1}, var2, 4);
                return var10000;
            } else {
                return var2;
            }
        } else {
            PackageBinding var3 = this.method_122(var1);
            if (var3 != null && var3 != LookupEnvironment.TheNotFoundPackage) {
                return var3;
            } else {
                if (var2 == null) {
                    if ((var2 = this.environment.askForType(this, var1)) != null) {
                        if (var2.method_160()) {
                            var10000 = new ProblemReferenceBinding(new char[][] {var1}, var2, 4);
                            return var10000;
                        }
                        return var2;
                    }
                    this.method_116(var1);
                }
                if (var3 == null) {
                    if ((var3 = this.findPackage(var1)) != null) {
                        return var3;
                    }
                    this.method_115(var1);
                }
                return null;
            }
        }
    }

    public final int kind() {
        return 16;
    }

    public int problemId() {
        return (this.tagBits & 128L) != 0L ? 1 : 0;
    }

    public char[] readableName() {
        return CharOperation.concatWith(this.compoundName, '.');
    }

    public String toString() {
        String var1;
        if (this.compoundName == CharOperation.NO_CHAR_CHAR) {
            var1 = "The Default Package";
        } else {
            var1 = "package " + (this.compoundName != null ? CharOperation.toString(this.compoundName) : "UNNAMED");
        }
        if ((this.tagBits & 128L) != 0L) {
            var1 = var1 + "[MISSING]";
        }
        return var1;
    }
}
