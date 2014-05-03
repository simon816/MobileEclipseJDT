package batch;

import batch.class_238;
import batch.eclipse;

// $FF: renamed from: batch.j
class class_225 implements Runnable {

    // $FF: renamed from: a batch.eclipse
    private final eclipse field_980;

    // $FF: renamed from: <init> (batch.eclipse) void
    class_225(eclipse var1) {
        this.field_980 = var1;
    }

    public void run() {
        try {
            class_238.method_1409(new String[] {this.field_980.field_420.getString(), this.field_980.field_421.getString(), this.field_980.field_422.getString()});
        } catch (Throwable var2) {
            this.field_980.field_426.append(var2.toString());
            var2.printStackTrace();
        }
    }
}
