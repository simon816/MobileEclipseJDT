package org.eclipse.jdt.internal.compiler.codegen;

import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.ClassFile;
import org.eclipse.jdt.internal.compiler.codegen.CharArrayCache;
import org.eclipse.jdt.internal.compiler.codegen.CachedIndexEntry;
import org.eclipse.jdt.internal.compiler.codegen.FloatCache;
import org.eclipse.jdt.internal.compiler.codegen.IntegerCache;
import org.eclipse.jdt.internal.compiler.codegen.DoubleCache;
import org.eclipse.jdt.internal.compiler.codegen.AttributeNamesConstants;
import org.eclipse.jdt.internal.compiler.codegen.LongCache;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.util.HashtableOfObject;

public class ConstantPool {

    protected DoubleCache doubleCache;

    protected FloatCache floatCache;

    protected IntegerCache intCache;

    protected LongCache longCache;

    public CharArrayCache UTF8Cache;

    protected CharArrayCache field_1315;

    protected HashtableOfObject field_1316;

    protected CharArrayCache field_1317;

    protected HashtableOfObject field_1318;

    public byte[] poolContent;

    public int field_1320;

    public int field_1321;

    public int[] offsets;

    public ClassFile classFile;

    public static final char[] field_1324;

    public static final char[] field_1325;

    public static final char[] field_1326;

    public static final char[] field_1327;

    public static final char[] field_1328;

    public static final char[] field_1329;

    public static final char[] field_1330;

    public static final char[] field_1331;

    public static final char[] field_1332;

    public static final char[] field_1333;

    public static final char[] field_1334;

    public static final char[] field_1335;

    public static final char[] field_1336;

    public static final char[] field_1337;

    public static final char[] field_1338;

    public static final char[] field_1339;

    public static final char[] field_1340;

    public static final char[] field_1341;

    public static final char[] field_1342;

    public static final char[] field_1343;

    public static final char[] field_1344;

    public static final char[] field_1345;

    public static final char[] field_1346;

    public static final char[] field_1347;

    public static final char[] field_1348;

    public static final char[] field_1349;

    public static final char[] field_1350;

    public static final char[] field_1351;

    public static final char[] field_1352;

    public static final char[] field_1353;

    public static final char[] field_1354;

    public static final char[] field_1355;

    public static final char[] field_1356;

    public static final char[] field_1357;

    public static final char[] field_1358;

    public static final char[] field_1359;

    public static final char[] field_1360;

    public static final char[] field_1361;

    public static final char[] field_1362;

    public static final char[] field_1363;

    public static final char[] field_1364;

    public static final char[] field_1365;

    public static final char[] field_1366;

    public static final char[] field_1367;

    public static final char[] field_1368;

    public static final char[] field_1369;

    public static final char[] field_1370;

    public static final char[] field_1371;

    public static final char[] field_1372;

    public static final char[] field_1373;

    public static final char[] field_1374;

    public static final char[] field_1375;

    public static final char[] field_1376;

    public static final char[] field_1377;

    public static final char[] field_1378;

    public static final char[] field_1379;

    public static final char[] field_1380;

    public static final char[] field_1381;

    public static final char[] field_1382;

    public static final char[] field_1383;

    public static final char[] field_1384;

    public static final char[] field_1385;

    public static final char[] field_1386;

    public static final char[] field_1387;

    public static final char[] field_1388;

    public static final char[] field_1389;

    public static final char[] field_1390;

    public static final char[] field_1391;

    public static final char[] field_1392;

    public static final char[] field_1393;

    public static final char[] field_1394;

    public static final char[] field_1395;

    public static final char[] field_1396;

    public static final char[] field_1397;

    public static final char[] field_1398;

    public static final char[] field_1399;

    public static final char[] field_1400;

    public static final char[] field_1401;

    public static final char[] field_1402;

    public static final char[][] field_1403;

    public static final char[][] field_1404;

    public static final char[] field_1405;

    public static final char[] field_1406;

    public static final char[] field_1407;

    public static final char[] field_1408;

    public static final char[] field_1409;

    public static final char[] field_1410;

    public static final char[] field_1411;

    public static final char[] field_1412;

    public static final char[] field_1413;

    public static final char[] field_1414;

    public static final char[] field_1415;

    public static final char[] field_1416;

    public static final char[] field_1417;

    public static final char[] field_1418;

    public static final char[] field_1419;

    public static final char[] field_1420;

    public static final char[] field_1421;

    public static final char[] field_1422;

    public static final char[] field_1423;

    public static final char[] field_1424;

    public static final char[] field_1425;

    public static final char[] field_1426;

    public static final char[] field_1427;

    public static final char[] field_1428;

    public static final char[] field_1429;

    public static final char[] field_1430;

    public static final char[] field_1431;

    public static final char[] field_1432;

    public static final char[] field_1433;

    public static final char[] field_1434;

    public static final char[] field_1435;

    public static final char[] field_1436;

    public static final char[] field_1437;

    public static final char[] field_1438;

    public static final char[] field_1439;

    public static final char[] field_1440;

    public static final char[] field_1441;

    public static final char[] field_1442;

    public static final char[] field_1443;

    public static final char[] field_1444;

    public static final char[] field_1445;

    public static final char[] field_1446;

    public static final char[] field_1447;

    public static final char[] field_1448;

    public static final char[] field_1449;

    public static final char[] field_1450;

    public static final char[] field_1451;

    public static final char[] field_1452;

    public static final char[] field_1453;

    public static final char[] field_1454;

    public static final char[] field_1455;

    public static final char[] field_1456;

    public static final char[] field_1457;

    public static final char[] field_1458;

    public static final char[] field_1459;

    public static final char[] field_1460;

    public static final char[] field_1461;

    public static final char[] field_1462;

    public static final char[] field_1463;

    public static final char[] field_1464;

    public static final char[] field_1465;

    public static final char[] field_1466;

    public static final char[] field_1467;

    public static final char[] field_1468;

    public static final char[] field_1469;

    public static final char[] field_1470;

    public static final char[] field_1471;

    public static final char[] field_1472;

    public static final char[] field_1473;

    public static final char[] field_1474;

    public static final char[] field_1475;

    public static final char[] field_1476;

    public static final char[] field_1477;

    public static final char[] field_1478;

    public static final char[] field_1479;

    public static final char[] field_1480;

    public static final char[] field_1481;

    public static final char[] field_1482;

    public static final char[] field_1483;

    public static final char[] field_1484;

    public static final char[] field_1485;

    public static final char[] field_1486;

    public static final char[] field_1487;

    public static final char[] field_1488;

    public static final char[] field_1489;

    public static final char[] field_1490;

    public static final char[] field_1491;

    public static final char[] field_1492;

    public static final char[] field_1493;

    public static final char[] field_1494;

    public static final char[] field_1495;

    public static final char[] field_1496;

    public static final char[] field_1497;

    public static final char[] field_1498;

    public static final char[] field_1499;

    public static final char[] field_1500;

    public static final char[] field_1501;

    public static final char[] field_1502;

    public static final char[] field_1503;

    public static final char[] field_1504;

    public static final char[] field_1505;

    public static final char[] field_1506;

    public static final char[] field_1507;

    public static final char[] field_1508;

    public static final char[] field_1509;

    public static final char[] field_1510;

    public static final char[] field_1511;

    public static final char[] field_1512;

    public ConstantPool(ClassFile var1) {
        this.field_1320 = 1;
        CharArrayCache var10001 = new CharArrayCache(778);
        this.UTF8Cache = var10001;
        var10001 = new CharArrayCache(761);
        this.field_1315 = var10001;
        HashtableOfObject var2 = new HashtableOfObject(450);
        this.field_1316 = var2;
        var10001 = new CharArrayCache(86);
        this.field_1317 = var10001;
        var2 = new HashtableOfObject(272);
        this.field_1318 = var2;
        this.offsets = new int[5];
        this.initialize(var1);
    }

    public void initialize(ClassFile var1) {
        this.poolContent = var1.field_1722;
        this.field_1321 = var1.field_1723;
        this.field_1320 = 1;
        this.classFile = var1;
    }

    public int literalIndex(byte[] var1, char[] var2) {
        int var3;
        if ((var3 = this.UTF8Cache.putIfAbsent(var2, this.field_1320)) < 0) {
            if ((var3 = -var3) > '\uffff') {
                this.classFile.referenceBinding.scope.problemReporter().method_1700(this.classFile.referenceBinding.scope.referenceType());
            }
            ++this.field_1320;
            int var4 = this.offsets.length;
            if (var4 <= var3) {
                System.arraycopy(this.offsets, 0, this.offsets = new int[var3 * 2], 0, var4);
            }
            this.offsets[var3] = this.field_1321;
            this.method_2477(1);
            int var5 = var1.length;
            if (this.field_1321 + 2 + var5 >= this.poolContent.length) {
                this.resizePoolContents(2 + var5);
            }
            this.poolContent[this.field_1321++] = (byte)(var5 >> 8);
            this.poolContent[this.field_1321++] = (byte)var5;
            System.arraycopy(var1, 0, this.poolContent, this.field_1321, var5);
            this.field_1321 += var5;
        }
        return var3;
    }

    public int method_2458(TypeBinding var1) {
        TypeBinding var2 = var1.method_173();
        if (var2.method_160()) {
            this.classFile.recordInnerClasses(var2);
        }
        return this.method_2459(var1.method_178());
    }

    public int method_2459(char[] var1) {
        int var2;
        if ((var2 = this.UTF8Cache.putIfAbsent(var1, this.field_1320)) < 0) {
            if ((var2 = -var2) > '\uffff') {
                this.classFile.referenceBinding.scope.problemReporter().method_1700(this.classFile.referenceBinding.scope.referenceType());
            }
            int var3 = this.offsets.length;
            if (var3 <= var2) {
                System.arraycopy(this.offsets, 0, this.offsets = new int[var2 * 2], 0, var3);
            }
            this.offsets[var2] = this.field_1321;
            this.method_2477(1);
            int var4 = this.field_1321;
            if (this.field_1321 + 2 >= this.poolContent.length) {
                this.resizePoolContents(2);
            }
            this.field_1321 += 2;
            var3 = 0;
            for (int var5 = 0; var5 < var1.length; ++var5) {
                char var6 = var1[var5];
                if (var6 >= 1 && var6 <= 127) {
                    this.method_2477(var6);
                    ++var3;
                } else if (var6 > 2047) {
                    var3 += 3;
                    this.method_2477(224 | var6 >> 12 & 15);
                    this.method_2477(128 | var6 >> 6 & 63);
                    this.method_2477(128 | var6 & 63);
                } else {
                    var3 += 2;
                    this.method_2477(192 | var6 >> 6 & 31);
                    this.method_2477(128 | var6 & 63);
                }
            }
            if (var3 >= '\uffff') {
                this.field_1321 = var4 - 1;
                this.classFile.referenceBinding.scope.problemReporter().method_1698(this.classFile.referenceBinding.scope.referenceType());
            }
            if (var2 > '\uffff') {
                this.classFile.referenceBinding.scope.problemReporter().method_1700(this.classFile.referenceBinding.scope.referenceType());
            }
            ++this.field_1320;
            this.poolContent[var4] = (byte)(var3 >> 8);
            this.poolContent[var4 + 1] = (byte)var3;
        }
        return var2;
    }

    public int literalIndex(char[] var1, byte[] var2) {
        int var3;
        if ((var3 = this.field_1315.putIfAbsent(var1, this.field_1320)) < 0) {
            ++this.field_1320;
            if ((var3 = -var3) > '\uffff') {
                this.classFile.referenceBinding.scope.problemReporter().method_1700(this.classFile.referenceBinding.scope.referenceType());
            }
            int var4 = this.offsets.length;
            if (var4 <= var3) {
                System.arraycopy(this.offsets, 0, this.offsets = new int[var3 * 2], 0, var4);
            }
            this.offsets[var3] = this.field_1321;
            this.method_2477(8);
            int var5 = this.field_1321;
            if (this.field_1321 + 2 >= this.poolContent.length) {
                this.resizePoolContents(2);
            }
            this.field_1321 += 2;
            int var6 = this.literalIndex(var2, var1);
            this.poolContent[var5++] = (byte)(var6 >> 8);
            this.poolContent[var5] = (byte)var6;
        }
        return var3;
    }

    public int literalIndex(double var1) {
        if (this.doubleCache == null) {
            DoubleCache var10001 = new DoubleCache(5);
            this.doubleCache = var10001;
        }
        int var3;
        if ((var3 = this.doubleCache.method_2496(var1, this.field_1320)) < 0) {
            if ((var3 = -var3) > '\uffff') {
                this.classFile.referenceBinding.scope.problemReporter().method_1700(this.classFile.referenceBinding.scope.referenceType());
            }
            this.field_1320 += 2;
            int var4 = this.offsets.length;
            if (var4 <= var3) {
                System.arraycopy(this.offsets, 0, this.offsets = new int[var3 * 2], 0, var4);
            }
            this.offsets[var3] = this.field_1321;
            this.method_2477(6);
            long var5 = Double.doubleToLongBits(var1);
            var4 = this.poolContent.length;
            if (this.field_1321 + 8 >= var4) {
                this.resizePoolContents(8);
            }
            this.poolContent[this.field_1321++] = (byte)((int)(var5 >>> 56));
            this.poolContent[this.field_1321++] = (byte)((int)(var5 >>> 48));
            this.poolContent[this.field_1321++] = (byte)((int)(var5 >>> 40));
            this.poolContent[this.field_1321++] = (byte)((int)(var5 >>> 32));
            this.poolContent[this.field_1321++] = (byte)((int)(var5 >>> 24));
            this.poolContent[this.field_1321++] = (byte)((int)(var5 >>> 16));
            this.poolContent[this.field_1321++] = (byte)((int)(var5 >>> 8));
            this.poolContent[this.field_1321++] = (byte)((int)var5);
        }
        return var3;
    }

    public int literalIndex(float var1) {
        if (this.floatCache == null) {
            FloatCache var10001 = new FloatCache(3);
            this.floatCache = var10001;
        }
        int var2;
        if ((var2 = this.floatCache.method_2484(var1, this.field_1320)) < 0) {
            if ((var2 = -var2) > '\uffff') {
                this.classFile.referenceBinding.scope.problemReporter().method_1700(this.classFile.referenceBinding.scope.referenceType());
            }
            ++this.field_1320;
            int var3 = this.offsets.length;
            if (var3 <= var2) {
                System.arraycopy(this.offsets, 0, this.offsets = new int[var2 * 2], 0, var3);
            }
            this.offsets[var2] = this.field_1321;
            this.method_2477(4);
            int var4 = Float.floatToIntBits(var1);
            if (this.field_1321 + 4 >= this.poolContent.length) {
                this.resizePoolContents(4);
            }
            this.poolContent[this.field_1321++] = (byte)(var4 >>> 24);
            this.poolContent[this.field_1321++] = (byte)(var4 >>> 16);
            this.poolContent[this.field_1321++] = (byte)(var4 >>> 8);
            this.poolContent[this.field_1321++] = (byte)var4;
        }
        return var2;
    }

    public int literalIndex(int var1) {
        if (this.intCache == null) {
            IntegerCache var10001 = new IntegerCache(248);
            this.intCache = var10001;
        }
        int var2;
        if ((var2 = this.intCache.method_2490(var1, this.field_1320)) < 0) {
            ++this.field_1320;
            if ((var2 = -var2) > '\uffff') {
                this.classFile.referenceBinding.scope.problemReporter().method_1700(this.classFile.referenceBinding.scope.referenceType());
            }
            int var3 = this.offsets.length;
            if (var3 <= var2) {
                System.arraycopy(this.offsets, 0, this.offsets = new int[var2 * 2], 0, var3);
            }
            this.offsets[var2] = this.field_1321;
            this.method_2477(3);
            if (this.field_1321 + 4 >= this.poolContent.length) {
                this.resizePoolContents(4);
            }
            this.poolContent[this.field_1321++] = (byte)(var1 >>> 24);
            this.poolContent[this.field_1321++] = (byte)(var1 >>> 16);
            this.poolContent[this.field_1321++] = (byte)(var1 >>> 8);
            this.poolContent[this.field_1321++] = (byte)var1;
        }
        return var2;
    }

    public int literalIndex(long var1) {
        if (this.longCache == null) {
            LongCache var10001 = new LongCache(5);
            this.longCache = var10001;
        }
        int var3;
        if ((var3 = this.longCache.method_465(var1, this.field_1320)) < 0) {
            if ((var3 = -var3) > '\uffff') {
                this.classFile.referenceBinding.scope.problemReporter().method_1700(this.classFile.referenceBinding.scope.referenceType());
            }
            this.field_1320 += 2;
            int var4 = this.offsets.length;
            if (var4 <= var3) {
                System.arraycopy(this.offsets, 0, this.offsets = new int[var3 * 2], 0, var4);
            }
            this.offsets[var3] = this.field_1321;
            this.method_2477(5);
            if (this.field_1321 + 8 >= this.poolContent.length) {
                this.resizePoolContents(8);
            }
            this.poolContent[this.field_1321++] = (byte)((int)(var1 >>> 56));
            this.poolContent[this.field_1321++] = (byte)((int)(var1 >>> 48));
            this.poolContent[this.field_1321++] = (byte)((int)(var1 >>> 40));
            this.poolContent[this.field_1321++] = (byte)((int)(var1 >>> 32));
            this.poolContent[this.field_1321++] = (byte)((int)(var1 >>> 24));
            this.poolContent[this.field_1321++] = (byte)((int)(var1 >>> 16));
            this.poolContent[this.field_1321++] = (byte)((int)(var1 >>> 8));
            this.poolContent[this.field_1321++] = (byte)((int)var1);
        }
        return var3;
    }

    public int literalIndex(String var1) {
        char[] var3 = var1.toCharArray();
        int var2;
        if ((var2 = this.field_1315.putIfAbsent(var3, this.field_1320)) < 0) {
            ++this.field_1320;
            if ((var2 = -var2) > '\uffff') {
                this.classFile.referenceBinding.scope.problemReporter().method_1700(this.classFile.referenceBinding.scope.referenceType());
            }
            int var4 = this.offsets.length;
            if (var4 <= var2) {
                System.arraycopy(this.offsets, 0, this.offsets = new int[var2 * 2], 0, var4);
            }
            this.offsets[var2] = this.field_1321;
            this.method_2477(8);
            int var5 = this.field_1321;
            if (this.field_1321 + 2 >= this.poolContent.length) {
                this.resizePoolContents(2);
            }
            this.field_1321 += 2;
            int var6 = this.method_2459(var3);
            this.poolContent[var5++] = (byte)(var6 >> 8);
            this.poolContent[var5] = (byte)var6;
        }
        return var2;
    }

    public int method_2466(char[] var1) {
        int var2;
        if ((var2 = this.field_1317.putIfAbsent(var1, this.field_1320)) < 0) {
            ++this.field_1320;
            if ((var2 = -var2) > '\uffff') {
                this.classFile.referenceBinding.scope.problemReporter().method_1700(this.classFile.referenceBinding.scope.referenceType());
            }
            int var3 = this.offsets.length;
            if (var3 <= var2) {
                System.arraycopy(this.offsets, 0, this.offsets = new int[var2 * 2], 0, var3);
            }
            this.offsets[var2] = this.field_1321;
            this.method_2477(7);
            int var4 = this.field_1321;
            if (this.field_1321 + 2 >= this.poolContent.length) {
                this.resizePoolContents(2);
            }
            this.field_1321 += 2;
            int var5 = this.method_2459(var1);
            this.poolContent[var4++] = (byte)(var5 >> 8);
            this.poolContent[var4] = (byte)var5;
        }
        return var2;
    }

    public int method_2467(TypeBinding var1) {
        TypeBinding var2 = var1.method_173();
        if (var2.method_160()) {
            this.classFile.recordInnerClasses(var2);
        }
        return this.method_2466(var1.constantPoolName());
    }

    public int literalIndexForMethod(char[] var1, char[] var2, char[] var3, boolean var4) {
        int var5;
        if ((var5 = this.putInCacheIfAbsent(var1, var2, var3, this.field_1320)) < 0) {
            ++this.field_1320;
            if ((var5 = -var5) > '\uffff') {
                this.classFile.referenceBinding.scope.problemReporter().method_1700(this.classFile.referenceBinding.scope.referenceType());
            }
            int var6 = this.offsets.length;
            if (var6 <= var5) {
                System.arraycopy(this.offsets, 0, this.offsets = new int[var5 * 2], 0, var6);
            }
            this.offsets[var5] = this.field_1321;
            this.method_2477(var4 ? 11 : 10);
            int var7 = this.field_1321;
            if (this.field_1321 + 4 >= this.poolContent.length) {
                this.resizePoolContents(4);
            }
            this.field_1321 += 4;
            int var8 = this.method_2466(var1);
            int var9 = this.literalIndexForNameAndType(var2, var3);
            this.poolContent[var7++] = (byte)(var8 >> 8);
            this.poolContent[var7++] = (byte)var8;
            this.poolContent[var7++] = (byte)(var9 >> 8);
            this.poolContent[var7] = (byte)var9;
        }
        return var5;
    }

    public int literalIndexForMethod(TypeBinding var1, char[] var2, char[] var3, boolean var4) {
        if (var1.method_160()) {
            this.classFile.recordInnerClasses(var1);
        }
        return this.literalIndexForMethod(var1.constantPoolName(), var2, var3, var4);
    }

    public int literalIndexForNameAndType(char[] var1, char[] var2) {
        int var3;
        if ((var3 = this.putInNameAndTypeCacheIfAbsent(var1, var2, this.field_1320)) < 0) {
            ++this.field_1320;
            if ((var3 = -var3) > '\uffff') {
                this.classFile.referenceBinding.scope.problemReporter().method_1700(this.classFile.referenceBinding.scope.referenceType());
            }
            int var4 = this.offsets.length;
            if (var4 <= var3) {
                System.arraycopy(this.offsets, 0, this.offsets = new int[var3 * 2], 0, var4);
            }
            this.offsets[var3] = this.field_1321;
            this.method_2477(12);
            int var5 = this.field_1321;
            if (this.field_1321 + 4 >= this.poolContent.length) {
                this.resizePoolContents(4);
            }
            this.field_1321 += 4;
            int var6 = this.method_2459(var1);
            int var7 = this.method_2459(var2);
            this.poolContent[var5++] = (byte)(var6 >> 8);
            this.poolContent[var5++] = (byte)var6;
            this.poolContent[var5++] = (byte)(var7 >> 8);
            this.poolContent[var5] = (byte)var7;
        }
        return var3;
    }

    public int literalIndexForField(char[] var1, char[] var2, char[] var3) {
        int var4;
        if ((var4 = this.putInCacheIfAbsent(var1, var2, var3, this.field_1320)) < 0) {
            ++this.field_1320;
            if ((var4 = -var4) > '\uffff') {
                this.classFile.referenceBinding.scope.problemReporter().method_1700(this.classFile.referenceBinding.scope.referenceType());
            }
            int var5 = this.offsets.length;
            if (var5 <= var4) {
                System.arraycopy(this.offsets, 0, this.offsets = new int[var4 * 2], 0, var5);
            }
            this.offsets[var4] = this.field_1321;
            this.method_2477(9);
            int var6 = this.field_1321;
            if (this.field_1321 + 4 >= this.poolContent.length) {
                this.resizePoolContents(4);
            }
            this.field_1321 += 4;
            int var7 = this.method_2466(var1);
            int var8 = this.literalIndexForNameAndType(var2, var3);
            this.poolContent[var6++] = (byte)(var7 >> 8);
            this.poolContent[var6++] = (byte)var7;
            this.poolContent[var6++] = (byte)(var8 >> 8);
            this.poolContent[var6] = (byte)var8;
        }
        return var4;
    }

    public int method_2472(char[] var1) {
        int var2 = this.field_1320;
        int var3 = this.field_1321;
        int var4;
        if ((var4 = this.field_1315.putIfAbsent(var1, this.field_1320)) < 0) {
            if ((var4 = -var4) > '\uffff') {
                this.classFile.referenceBinding.scope.problemReporter().method_1700(this.classFile.referenceBinding.scope.referenceType());
            }
            ++this.field_1320;
            int var5 = this.offsets.length;
            if (var5 <= var4) {
                System.arraycopy(this.offsets, 0, this.offsets = new int[var4 * 2], 0, var5);
            }
            this.offsets[var4] = this.field_1321;
            this.method_2477(8);
            int var6 = this.field_1321;
            if (this.field_1321 + 2 >= this.poolContent.length) {
                this.resizePoolContents(2);
            }
            this.field_1321 += 2;
            int var7;
            if ((var7 = this.UTF8Cache.putIfAbsent(var1, this.field_1320)) < 0) {
                if ((var7 = -var7) > '\uffff') {
                    this.classFile.referenceBinding.scope.problemReporter().method_1700(this.classFile.referenceBinding.scope.referenceType());
                }
                ++this.field_1320;
                var5 = this.offsets.length;
                if (var5 <= var7) {
                    System.arraycopy(this.offsets, 0, this.offsets = new int[var7 * 2], 0, var5);
                }
                this.offsets[var7] = this.field_1321;
                this.method_2477(1);
                int var8 = this.field_1321;
                if (this.field_1321 + 2 >= this.poolContent.length) {
                    this.resizePoolContents(2);
                }
                this.field_1321 += 2;
                var5 = 0;
                for (int var9 = 0; var9 < var1.length; ++var9) {
                    char var10 = var1[var9];
                    if (var10 >= 1 && var10 <= 127) {
                        ++var5;
                        if (this.field_1321 + 1 >= this.poolContent.length) {
                            this.resizePoolContents(1);
                        }
                        this.poolContent[this.field_1321++] = (byte)var10;
                    } else if (var10 > 2047) {
                        var5 += 3;
                        if (this.field_1321 + 3 >= this.poolContent.length) {
                            this.resizePoolContents(3);
                        }
                        this.poolContent[this.field_1321++] = (byte)(224 | var10 >> 12 & 15);
                        this.poolContent[this.field_1321++] = (byte)(128 | var10 >> 6 & 63);
                        this.poolContent[this.field_1321++] = (byte)(128 | var10 & 63);
                    } else {
                        if (this.field_1321 + 2 >= this.poolContent.length) {
                            this.resizePoolContents(2);
                        }
                        var5 += 2;
                        this.poolContent[this.field_1321++] = (byte)(192 | var10 >> 6 & 31);
                        this.poolContent[this.field_1321++] = (byte)(128 | var10 & 63);
                    }
                }
                if (var5 >= '\uffff') {
                    this.field_1321 = var3;
                    this.field_1320 = var2;
                    this.field_1315.remove(var1);
                    this.UTF8Cache.remove(var1);
                    return 0;
                }
                this.poolContent[var8++] = (byte)(var5 >> 8);
                this.poolContent[var8] = (byte)var5;
            }
            this.poolContent[var6++] = (byte)(var7 >> 8);
            this.poolContent[var6] = (byte)var7;
        }
        return var4;
    }

    private int putInNameAndTypeCacheIfAbsent(char[] var1, char[] var2, int var3) {
        Object var5 = this.field_1318.method_3226(var1);
        int var4;
        CachedIndexEntry var6;
        if (var5 == null) {
            CachedIndexEntry var10000 = new CachedIndexEntry(var2, var3);
            var6 = var10000;
            var4 = -var3;
            this.field_1318.put(var1, var6);
        } else if (var5 instanceof CachedIndexEntry) {
            var6 = (CachedIndexEntry)var5;
            if (CharOperation.method_1364(var2, var6.signature)) {
                var4 = var6.index;
            } else {
                CharArrayCache var8 = new CharArrayCache();
                CharArrayCache var7 = var8;
                var7.putIfAbsent(var6.signature, var6.index);
                var4 = var7.putIfAbsent(var2, var3);
                this.field_1318.put(var1, var7);
            }
        } else {
            CharArrayCache var9 = (CharArrayCache)var5;
            var4 = var9.putIfAbsent(var2, var3);
        }
        return var4;
    }

    private int putInCacheIfAbsent(char[] var1, char[] var2, char[] var3, int var4) {
        HashtableOfObject var6 = (HashtableOfObject)this.field_1316.method_3226(var1);
        int var5;
        CachedIndexEntry var11;
        if (var6 == null) {
            HashtableOfObject var10000 = new HashtableOfObject();
            var6 = var10000;
            this.field_1316.put(var1, var6);
            var11 = new CachedIndexEntry(var3, var4);
            CachedIndexEntry var7 = var11;
            var5 = -var4;
            var6.put(var2, var7);
        } else {
            Object var12 = var6.method_3226(var2);
            CachedIndexEntry var8;
            if (var12 == null) {
                var11 = new CachedIndexEntry(var3, var4);
                var8 = var11;
                var5 = -var4;
                var6.put(var2, var8);
            } else if (var12 instanceof CachedIndexEntry) {
                var8 = (CachedIndexEntry)var12;
                if (CharOperation.method_1364(var3, var8.signature)) {
                    var5 = var8.index;
                } else {
                    CharArrayCache var10 = new CharArrayCache();
                    CharArrayCache var9 = var10;
                    var9.putIfAbsent(var8.signature, var8.index);
                    var5 = var9.putIfAbsent(var3, var4);
                    var6.put(var2, var9);
                }
            } else {
                CharArrayCache var13 = (CharArrayCache)var12;
                var5 = var13.putIfAbsent(var3, var4);
            }
        }
        return var5;
    }

    public void resetForClinit(int var1, int var2) {
        this.field_1320 = var1;
        this.field_1321 = var2;
        if (this.UTF8Cache.get(AttributeNamesConstants.field_9) >= var1) {
            this.UTF8Cache.remove(AttributeNamesConstants.field_9);
        }
        if (this.UTF8Cache.get(field_1345) >= var1) {
            this.UTF8Cache.remove(field_1345);
        }
        if (this.UTF8Cache.get(field_1343) >= var1) {
            this.UTF8Cache.remove(field_1343);
        }
    }

    private final void resizePoolContents(int var1) {
        int var2 = this.poolContent.length;
        int var3 = var2;
        if (var2 < var1) {
            var3 = var1;
        }
        System.arraycopy(this.poolContent, 0, this.poolContent = new byte[var2 + var3], 0, var2);
    }

    protected final void method_2477(int var1) {
        if (this.field_1321 + 1 >= this.poolContent.length) {
            this.resizePoolContents(1);
        }
        this.poolContent[this.field_1321++] = (byte)var1;
    }

    public void reset() {
        if (this.doubleCache != null) {
            this.doubleCache.clear();
        }
        if (this.floatCache != null) {
            this.floatCache.clear();
        }
        if (this.intCache != null) {
            this.intCache.clear();
        }
        if (this.longCache != null) {
            this.longCache.clear();
        }
        this.UTF8Cache.clear();
        this.field_1315.clear();
        this.field_1316.clear();
        this.field_1317.clear();
        this.field_1318.clear();
        this.field_1320 = 1;
        this.field_1321 = 0;
    }

    static {
        field_1324 = "append".toCharArray();
        field_1325 = "newInstance".toCharArray();
        field_1326 = "(Ljava/lang/Class;[I)Ljava/lang/Object;".toCharArray();
        field_1327 = "arraycopy".toCharArray();
        field_1328 = "(Ljava/lang/Object;ILjava/lang/Object;II)V".toCharArray();
        field_1329 = "[Ljava/lang/Class;".toCharArray();
        field_1330 = "[Ljava/lang/Object;".toCharArray();
        field_1331 = "(Z)Ljava/lang/Boolean;".toCharArray();
        field_1332 = "(Z)V".toCharArray();
        field_1333 = "booleanValue".toCharArray();
        field_1334 = "()Z".toCharArray();
        field_1335 = "(B)Ljava/lang/Byte;".toCharArray();
        field_1336 = "(B)V".toCharArray();
        field_1337 = "byteValue".toCharArray();
        field_1338 = "()B".toCharArray();
        field_1339 = "(C)Ljava/lang/Character;".toCharArray();
        field_1340 = "(C)V".toCharArray();
        field_1341 = "charValue".toCharArray();
        field_1342 = "()C".toCharArray();
        field_1343 = "<clinit>".toCharArray();
        field_1344 = "()V".toCharArray();
        field_1345 = field_1344;
        field_1346 = "desiredAssertionStatus".toCharArray();
        field_1347 = "()Z".toCharArray();
        field_1348 = "(D)V".toCharArray();
        field_1349 = "(D)Ljava/lang/Double;".toCharArray();
        field_1350 = "doubleValue".toCharArray();
        field_1351 = "()D".toCharArray();
        field_1352 = "exit".toCharArray();
        field_1353 = "(I)V".toCharArray();
        field_1354 = "(F)V".toCharArray();
        field_1355 = "(F)Ljava/lang/Float;".toCharArray();
        field_1356 = "floatValue".toCharArray();
        field_1357 = "()F".toCharArray();
        field_1358 = "forName".toCharArray();
        field_1359 = "(Ljava/lang/String;)Ljava/lang/Class;".toCharArray();
        field_1360 = "getBoolean".toCharArray();
        field_1361 = "(Ljava/lang/Object;)Z".toCharArray();
        field_1362 = "getByte".toCharArray();
        field_1363 = "(Ljava/lang/Object;)B".toCharArray();
        field_1364 = "getChar".toCharArray();
        field_1365 = "(Ljava/lang/Object;)C".toCharArray();
        field_1366 = "getDouble".toCharArray();
        field_1367 = "(Ljava/lang/Object;)D".toCharArray();
        field_1368 = "getFloat".toCharArray();
        field_1369 = "(Ljava/lang/Object;)F".toCharArray();
        field_1370 = "getInt".toCharArray();
        field_1371 = "(Ljava/lang/Object;)I".toCharArray();
        field_1372 = "getLong".toCharArray();
        field_1373 = "(Ljava/lang/Object;)J".toCharArray();
        field_1374 = "get".toCharArray();
        field_1375 = "(Ljava/lang/Object;)Ljava/lang/Object;".toCharArray();
        field_1376 = "getShort".toCharArray();
        field_1377 = "(Ljava/lang/Object;)S".toCharArray();
        field_1378 = "getClass".toCharArray();
        field_1379 = "()Ljava/lang/Class;".toCharArray();
        field_1380 = "getComponentType".toCharArray();
        field_1381 = field_1379;
        field_1382 = "getConstructor".toCharArray();
        field_1383 = "([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;".toCharArray();
        field_1384 = "getDeclaredConstructor".toCharArray();
        field_1385 = "([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;".toCharArray();
        field_1386 = "getDeclaredField".toCharArray();
        field_1387 = "(Ljava/lang/String;)Ljava/lang/reflect/Field;".toCharArray();
        field_1388 = "getDeclaredMethod".toCharArray();
        field_1389 = "(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;".toCharArray();
        field_1390 = "getMessage".toCharArray();
        field_1391 = "()Ljava/lang/String;".toCharArray();
        field_1392 = "hasNext".toCharArray();
        field_1393 = "()Z".toCharArray();
        field_1394 = "<init>".toCharArray();
        field_1395 = "(I)V".toCharArray();
        field_1396 = "intern".toCharArray();
        field_1397 = field_1391;
        field_1398 = "(I)Ljava/lang/Integer;".toCharArray();
        field_1399 = "intValue".toCharArray();
        field_1400 = "()I".toCharArray();
        field_1401 = "invoke".toCharArray();
        field_1402 = "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;".toCharArray();
        field_1403 = new char[][] {TypeConstants.field_26, TypeConstants.field_27, TypeConstants.field_31, "AccessibleObject".toCharArray()};
        field_1404 = new char[][] {TypeConstants.field_26, TypeConstants.field_27, TypeConstants.field_31, "Array".toCharArray()};
        field_1405 = "Ljava/io/PrintStream;".toCharArray();
        field_1406 = "java/lang/AssertionError".toCharArray();
        field_1407 = "java/lang/Boolean".toCharArray();
        field_1408 = "java/lang/Byte".toCharArray();
        field_1409 = "java/lang/Character".toCharArray();
        field_1410 = "java/lang/Class".toCharArray();
        field_1411 = "java/lang/ClassNotFoundException".toCharArray();
        field_1412 = "Ljava/lang/Class;".toCharArray();
        field_1413 = "java/lang/Double".toCharArray();
        field_1414 = "java/lang/Enum".toCharArray();
        field_1415 = "java/lang/Error".toCharArray();
        field_1416 = "java/lang/Exception".toCharArray();
        field_1417 = "java/lang/Float".toCharArray();
        field_1418 = "java/lang/Integer".toCharArray();
        field_1419 = "java/lang/Long".toCharArray();
        field_1420 = "java/lang/NoClassDefFoundError".toCharArray();
        field_1421 = "java/lang/NoSuchFieldError".toCharArray();
        field_1422 = "java/lang/Object".toCharArray();
        field_1423 = "java/lang/reflect/AccessibleObject".toCharArray();
        field_1424 = "java/lang/reflect/Array".toCharArray();
        field_1425 = "java/lang/reflect/Constructor".toCharArray();
        field_1426 = "([Ljava/lang/Object;)Ljava/lang/Object;".toCharArray();
        field_1427 = "java/lang/reflect/Field".toCharArray();
        field_1428 = "java/lang/reflect/Method".toCharArray();
        field_1429 = "java/lang/Short".toCharArray();
        field_1430 = "java/lang/StringBuffer".toCharArray();
        field_1431 = "java/lang/StringBuilder".toCharArray();
        field_1432 = "java/lang/String".toCharArray();
        field_1433 = "Ljava/lang/String;".toCharArray();
        field_1434 = "Ljava/lang/Object;".toCharArray();
        field_1435 = "java/lang/System".toCharArray();
        field_1436 = "java/lang/Throwable".toCharArray();
        field_1437 = "java/lang/Void".toCharArray();
        field_1438 = "java/util/Iterator".toCharArray();
        field_1439 = "(J)V".toCharArray();
        field_1440 = "(J)Ljava/lang/Long;".toCharArray();
        field_1441 = "longValue".toCharArray();
        field_1442 = "()J".toCharArray();
        field_1443 = "newInstance".toCharArray();
        field_1444 = "(Ljava/lang/Class;[I)Ljava/lang/Object;".toCharArray();
        field_1445 = "next".toCharArray();
        field_1446 = "()Ljava/lang/Object;".toCharArray();
        field_1447 = "(Ljava/lang/Object;)V".toCharArray();
        field_1448 = "Ljava/lang/Object;".toCharArray();
        field_1449 = "ordinal".toCharArray();
        field_1450 = "()I".toCharArray();
        field_1451 = "out".toCharArray();
        field_1452 = "setBoolean".toCharArray();
        field_1453 = "(Ljava/lang/Object;Z)V".toCharArray();
        field_1454 = "setByte".toCharArray();
        field_1455 = "(Ljava/lang/Object;B)V".toCharArray();
        field_1456 = "setChar".toCharArray();
        field_1457 = "(Ljava/lang/Object;C)V".toCharArray();
        field_1458 = "setDouble".toCharArray();
        field_1459 = "(Ljava/lang/Object;D)V".toCharArray();
        field_1460 = "setFloat".toCharArray();
        field_1461 = "(Ljava/lang/Object;F)V".toCharArray();
        field_1462 = "setInt".toCharArray();
        field_1463 = "(Ljava/lang/Object;I)V".toCharArray();
        field_1464 = "setLong".toCharArray();
        field_1465 = "(Ljava/lang/Object;J)V".toCharArray();
        field_1466 = "set".toCharArray();
        field_1467 = "(Ljava/lang/Object;Ljava/lang/Object;)V".toCharArray();
        field_1468 = "setShort".toCharArray();
        field_1469 = "(Ljava/lang/Object;S)V".toCharArray();
        field_1470 = "setAccessible".toCharArray();
        field_1471 = "(Z)V".toCharArray();
        field_1472 = "(S)V".toCharArray();
        field_1473 = "(S)Ljava/lang/Short;".toCharArray();
        field_1474 = "shortValue".toCharArray();
        field_1475 = "()S".toCharArray();
        field_1476 = "(Z)Ljava/lang/StringBuffer;".toCharArray();
        field_1477 = "(C)Ljava/lang/StringBuffer;".toCharArray();
        field_1478 = "(D)Ljava/lang/StringBuffer;".toCharArray();
        field_1479 = "(F)Ljava/lang/StringBuffer;".toCharArray();
        field_1480 = "(I)Ljava/lang/StringBuffer;".toCharArray();
        field_1481 = "(J)Ljava/lang/StringBuffer;".toCharArray();
        field_1482 = "(Ljava/lang/Object;)Ljava/lang/StringBuffer;".toCharArray();
        field_1483 = "(Ljava/lang/String;)Ljava/lang/StringBuffer;".toCharArray();
        field_1484 = "(Z)Ljava/lang/StringBuilder;".toCharArray();
        field_1485 = "(C)Ljava/lang/StringBuilder;".toCharArray();
        field_1486 = "(D)Ljava/lang/StringBuilder;".toCharArray();
        field_1487 = "(F)Ljava/lang/StringBuilder;".toCharArray();
        field_1488 = "(I)Ljava/lang/StringBuilder;".toCharArray();
        field_1489 = "(J)Ljava/lang/StringBuilder;".toCharArray();
        field_1490 = "(Ljava/lang/Object;)Ljava/lang/StringBuilder;".toCharArray();
        field_1491 = "(Ljava/lang/String;)Ljava/lang/StringBuilder;".toCharArray();
        field_1492 = "(Ljava/lang/String;)V".toCharArray();
        field_1493 = "this".toCharArray();
        field_1494 = "toString".toCharArray();
        field_1495 = field_1391;
        field_1496 = "TYPE".toCharArray();
        field_1497 = "valueOf".toCharArray();
        field_1498 = "(Z)Ljava/lang/String;".toCharArray();
        field_1499 = "(C)Ljava/lang/String;".toCharArray();
        field_1500 = "(D)Ljava/lang/String;".toCharArray();
        field_1501 = "(F)Ljava/lang/String;".toCharArray();
        field_1502 = "(I)Ljava/lang/String;".toCharArray();
        field_1503 = "(J)Ljava/lang/String;".toCharArray();
        field_1504 = "(Ljava/lang/Object;)Ljava/lang/String;".toCharArray();
        field_1505 = "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;".toCharArray();
        field_1506 = "Ljava/lang/annotation/Documented;".toCharArray();
        field_1507 = "Ljava/lang/annotation/ElementType;".toCharArray();
        field_1508 = "Ljava/lang/annotation/Retention;".toCharArray();
        field_1509 = "Ljava/lang/annotation/RetentionPolicy;".toCharArray();
        field_1510 = "Ljava/lang/annotation/Target;".toCharArray();
        field_1511 = "Ljava/lang/Deprecated;".toCharArray();
        field_1512 = "Ljava/lang/annotation/Inherited;".toCharArray();
    }
}
