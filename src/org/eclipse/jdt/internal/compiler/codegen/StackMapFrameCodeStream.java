package org.eclipse.jdt.internal.compiler.codegen;

import java.util.Collection;
import java.util.Iterator;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Vector;

import org.eclipse.jdt.internal.compiler.ClassFile;
import org.eclipse.jdt.internal.compiler.codegen.CodeStream;
import org.eclipse.jdt.internal.compiler.codegen.ConstantPool;
import org.eclipse.jdt.internal.compiler.codegen.StackMapFrameCodeStream$ExceptionMarker;
import org.eclipse.jdt.internal.compiler.codegen.StackMapFrameCodeStream$FramePosition;
import org.eclipse.jdt.internal.compiler.codegen.StackMapFrameCodeStream$StackMarker;
import org.eclipse.jdt.internal.compiler.codegen.ExceptionLabel;
import org.eclipse.jdt.internal.compiler.codegen.BranchLabel;
import org.eclipse.jdt.internal.compiler.codegen.StackMapFrameCodeStream$StackDepthMarker;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.LocalVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.Scope;

public class StackMapFrameCodeStream extends CodeStream {

    public int[] stateIndexes;

    public int stateIndexesCounter;

    private HashMap field_1219;

    public Vector field_1220;

    public ArrayList field_1221;

    public ArrayList field_1222;

    public StackMapFrameCodeStream(ClassFile var1) {
        super(var1);
        this.field_1195 |= 16;
    }

    public void method_2088(Scope var1, int var2) {
        for (int var3 = 0; var3 < this.visibleLocalsCount; ++var3) {
            LocalVariableBinding var4 = this.field_1214[var3];
            if (var4 != null) {
                boolean var5 = this.isDefinitelyAssigned(var1, var2, var4);
                if (!var5) {
                    if (this.stateIndexes != null) {
                        int var6 = 0;
                        for (int var7 = this.stateIndexesCounter; var6 < var7; ++var6) {
                            if (this.isDefinitelyAssigned(var1, this.stateIndexes[var6], var4)) {
                                if (var4.field_311 == 0 || var4.initializationPCs[(var4.field_311 - 1 << 1) + 1] != -1) {
                                    var4.method_415(this.field_1208);
                                }
                                break;
                            }
                        }
                    }
                } else if (var4.field_311 == 0 || var4.initializationPCs[(var4.field_311 - 1 << 1) + 1] != -1) {
                    var4.method_415(this.field_1208);
                }
            }
        }
    }

    public void addExceptionMarker(int var1, TypeBinding var2) {
        if (this.field_1220 == null) {
            this.field_1220 = new Vector();
        }
        StackMapFrameCodeStream$ExceptionMarker var10001;
        Vector var10000;
        if (var2 == null) {
            var10000 = this.field_1220;
            var10001 = new StackMapFrameCodeStream$ExceptionMarker(var1, ConstantPool.field_1436);
            var10000.addElement(var10001);
        } else {
            switch (var2.id) {
                case 7:
                    var10000 = this.field_1220;
                    var10001 = new StackMapFrameCodeStream$ExceptionMarker(var1, ConstantPool.field_1421);
                    var10000.addElement(var10001);
                    break;
                case 12:
                    var10000 = this.field_1220;
                    var10001 = new StackMapFrameCodeStream$ExceptionMarker(var1, ConstantPool.field_1411);
                    var10000.addElement(var10001);
                    break;
                default:
                    var10000 = this.field_1220;
                    var10001 = new StackMapFrameCodeStream$ExceptionMarker(var1, var2.constantPoolName());
                    var10000.addElement(var10001);
            }
        }
    }

    public void method_2391(int var1) {
        Integer var2 = new Integer(var1);
        StackMapFrameCodeStream$FramePosition var3;
        if ((var3 = (StackMapFrameCodeStream$FramePosition)this.field_1219.get(var2)) != null) {
            ++var3.counter;
        } else {
            HashMap var10000 = this.field_1219;
            StackMapFrameCodeStream$FramePosition var10002 = new StackMapFrameCodeStream$FramePosition();
            var10000.put(var2, var10002);
        }
    }

    public void optimizeBranch(int var1, BranchLabel var2) {
        super.optimizeBranch(var1, var2);
        this.method_2392(var1);
    }

    public void method_2392(int var1) {
        Integer var2 = new Integer(var1);
        StackMapFrameCodeStream$FramePosition var3;
        if ((var3 = (StackMapFrameCodeStream$FramePosition)this.field_1219.get(var2)) != null) {
            --var3.counter;
            if (var3.counter <= 0) {
                this.field_1219.remove(var2);
            }
        }
    }

    public void addVariable(LocalVariableBinding var1) {
        if (var1.initializationPCs == null) {
            this.method_2358(var1);
        }
        var1.method_415(this.field_1208);
    }

    private void addStackMarker(int var1, int var2) {
        StackMapFrameCodeStream$StackMarker var4;
        ArrayList var10000;
        if (this.field_1222 == null) {
            ArrayList var10001 = new ArrayList();
            this.field_1222 = var10001;
            var10000 = this.field_1222;
            var4 = new StackMapFrameCodeStream$StackMarker(var1, var2);
            var10000.add(var4);
        } else {
            int var3 = this.field_1222.size();
            if (var3 == 0 || ((StackMapFrameCodeStream$StackMarker)this.field_1222.get(var3 - 1)).field_319 != this.field_1208) {
                var10000 = this.field_1222;
                var4 = new StackMapFrameCodeStream$StackMarker(var1, var2);
                var10000.add(var4);
            }
        }
    }

    private void addStackDepthMarker(int var1, int var2, TypeBinding var3) {
        StackMapFrameCodeStream$StackDepthMarker var5;
        ArrayList var10000;
        if (this.field_1221 == null) {
            ArrayList var10001 = new ArrayList();
            this.field_1221 = var10001;
            var10000 = this.field_1221;
            var5 = new StackMapFrameCodeStream$StackDepthMarker(var1, var2, var3);
            var10000.add(var5);
        } else {
            int var4 = this.field_1221.size();
            if (var4 == 0 || ((StackMapFrameCodeStream$StackDepthMarker)this.field_1221.get(var4 - 1)).field_340 != this.field_1208) {
                var10000 = this.field_1221;
                var5 = new StackMapFrameCodeStream$StackDepthMarker(var1, var2, var3);
                var10000.add(var5);
            }
        }
    }

    public void method_2125(int var1) {
        super.method_2125(var1);
        this.addStackDepthMarker(this.field_1208, -1, (TypeBinding)null);
    }

    public void method_2359(TypeBinding var1) {
        this.addStackDepthMarker(this.field_1208, 0, var1);
    }

    public void generateClassLiteralAccessForType(TypeBinding var1, FieldBinding var2) {
        if (var1.method_148() && var1 != TypeBinding.field_187) {
            this.method_2208(var1.id);
        } else {
            if (this.targetLevel >= 3211264L) {
                this.method_2312(var1);
            } else {
                BranchLabel var10000 = new BranchLabel(this);
                BranchLabel var3 = var10000;
                if (var2 != null) {
                    this.method_2207(var2);
                    this.method_2141();
                    this.method_2243(var3);
                    this.method_2352();
                }
                ExceptionLabel var7 = new ExceptionLabel(this, TypeBinding.field_187);
                ExceptionLabel var4 = var7;
                var4.method_449();
                this.ldc(var1 == TypeBinding.field_187 ? "java.lang.Object" : String.valueOf(var1.constantPoolName()).replace('/', '.'));
                this.method_2259();
                var4.method_448();
                if (var2 != null) {
                    this.method_2141();
                    this.method_2357(var2);
                }
                int var5 = this.field_1208;
                this.method_2209(var3);
                int var6 = this.field_1210;
                this.method_2355(TypeBinding.field_187);
                var4.method_447();
                this.method_2348();
                this.method_2142();
                this.method_2377();
                this.method_2281();
                this.method_2270();
                this.method_2107();
                var3.place();
                this.addStackMarker(var5, this.field_1208);
                this.field_1210 = var6;
            }
        }
    }

    public StackMapFrameCodeStream$ExceptionMarker[] getExceptionMarkers() {
        Vector var1 = this.field_1220;
        if (this.field_1220 == null) {
            return null;
        } else {
            int var2 = var1.size();
            StackMapFrameCodeStream$ExceptionMarker[] var3 = new StackMapFrameCodeStream$ExceptionMarker[var2];
            var1.copyInto(var3);
            Arrays.sort(var3);
            return var3;
        }
    }

    public int[] getFramePositions() {
        Collection var1 = this.field_1219.keySet();
        int var2 = var1.size();
        int[] var3 = new int[var2];
        int var4 = 0;
        for (Iterator var5 = var1.iterator(); var5.hasNext(); var3[var4++] = ((Integer)var5.next()).intValue()) {
            ;
        }
        Arrays.sort(var3);
        return var3;
    }

    public StackMapFrameCodeStream$StackDepthMarker[] getStackDepthMarkers() {
        if (this.field_1221 == null) {
            return null;
        } else {
            int var1 = this.field_1221.size();
            if (var1 == 0) {
                return null;
            } else {
                StackMapFrameCodeStream$StackDepthMarker[] var2 = new StackMapFrameCodeStream$StackDepthMarker[var1];
                this.field_1221.toArray(var2);
                return var2;
            }
        }
    }

    public StackMapFrameCodeStream$StackMarker[] getStackMarkers() {
        if (this.field_1222 == null) {
            return null;
        } else {
            int var1 = this.field_1222.size();
            if (var1 == 0) {
                return null;
            } else {
                StackMapFrameCodeStream$StackMarker[] var2 = new StackMapFrameCodeStream$StackMarker[var1];
                this.field_1222.toArray(var2);
                return var2;
            }
        }
    }

    public boolean hasFramePositions() {
        return this.field_1219.size() != 0;
    }

    public void method_2255(ClassFile var1) {
        super.method_2255(var1);
        this.stateIndexesCounter = 0;
        if (this.field_1219 != null) {
            this.field_1219.clear();
        }
        if (this.field_1220 != null) {
            this.field_1220.removeAllElements();
        }
        if (this.field_1221 != null) {
            this.field_1221.clear();
        }
        if (this.field_1222 != null) {
            this.field_1222.clear();
        }
    }

    public void initializeMaxLocals(MethodBinding var1) {
        super.initializeMaxLocals(var1);
        if (this.field_1219 == null) {
            HashMap var10001 = new HashMap();
            this.field_1219 = var10001;
        } else {
            this.field_1219.clear();
        }
    }

    public void method_2400() {
        --this.stateIndexesCounter;
    }

    public void method_2401(int var1) {
        if (this.stateIndexes == null) {
            this.stateIndexes = new int[3];
        }
        int var2 = this.stateIndexes.length;
        if (var2 == this.stateIndexesCounter) {
            System.arraycopy(this.stateIndexes, 0, this.stateIndexes = new int[var2 * 2], 0, var2);
        }
        this.stateIndexes[this.stateIndexesCounter++] = var1;
    }

    public void method_2363(Scope var1, int var2) {
        int var3 = this.visibleLocalsCount;
        label34:
        for (int var4 = 0; var4 < var3; ++var4) {
            LocalVariableBinding var5 = this.field_1214[var4];
            if (var5 != null && var5.field_311 > 0) {
                boolean var6 = this.isDefinitelyAssigned(var1, var2, var5);
                if (!var6) {
                    if (this.stateIndexes != null) {
                        int var7 = 0;
                        for (int var8 = this.stateIndexesCounter; var7 < var8; ++var7) {
                            if (this.isDefinitelyAssigned(var1, this.stateIndexes[var7], var5)) {
                                continue label34;
                            }
                        }
                    }
                    var5.method_414(this.field_1208);
                }
            }
        }
    }

    public void method_2367(ClassFile var1) {
        super.method_2367(var1);
        this.stateIndexesCounter = 0;
        if (this.field_1219 != null) {
            this.field_1219.clear();
        }
        if (this.field_1220 != null) {
            this.field_1220.removeAllElements();
        }
        if (this.field_1221 != null) {
            this.field_1221.clear();
        }
        if (this.field_1222 != null) {
            this.field_1222.clear();
        }
    }

    protected void method_2381(BranchLabel var1) {
        super.method_2381(var1);
        this.method_2391(var1.position);
    }

    protected void writePosition(BranchLabel var1, int var2) {
        super.writePosition(var1, var2);
        this.method_2391(var1.position);
    }

    protected void writeSignedWord(int var1, int var2) {
        super.writeSignedWord(var1, var2);
        this.method_2391(this.field_1208);
    }

    protected void method_2388(BranchLabel var1) {
        super.method_2388(var1);
        this.method_2391(var1.position);
    }

    public void method_2098() {
        super.method_2098();
        this.method_2391(this.field_1208);
    }

    public void method_2285() {
        super.method_2285();
        this.method_2391(this.field_1208);
    }

    public void method_2329() {
        super.method_2329();
        this.method_2391(this.field_1208);
    }

    public void method_2169() {
        super.method_2169();
        this.method_2391(this.field_1208);
    }

    public void method_2134() {
        super.method_2134();
        this.method_2391(this.field_1208);
    }

    public void method_2371() {
        super.method_2371();
        this.method_2391(this.field_1208);
    }

    public void method_2107() {
        super.method_2107();
        this.method_2391(this.field_1208);
    }

    public void method_2354(TypeBinding var1) {
        super.method_2354(var1);
        this.addStackDepthMarker(this.field_1208, 1, var1);
    }

    public void method_2355(TypeBinding var1) {
        super.method_2355(var1);
        this.addExceptionMarker(this.field_1208, var1);
    }

    public void method_2209(BranchLabel var1) {
        super.method_2209(var1);
        this.method_2391(this.field_1208);
    }

    public void method_2210(BranchLabel var1) {
        super.method_2210(var1);
        this.method_2391(this.field_1208);
    }
}
