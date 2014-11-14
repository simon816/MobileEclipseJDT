package batch;

import batch.Main;
import batch.eclipse;

class CompileRunner implements Runnable {

    private final eclipse eclipse;

    CompileRunner(eclipse var1) {
        this.eclipse = var1;
    }

    public void run() {
        try {
            Main.main(new String[] {this.eclipse.srcTextbox.getString(), this.eclipse.libTextbox.getString(), this.eclipse.classOutTextbox.getString()});
        } catch (Throwable var2) {
            this.eclipse.form.append(var2.toString());
            var2.printStackTrace();
        }
    }
}
