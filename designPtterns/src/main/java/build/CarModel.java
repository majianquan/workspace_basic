package build;

import java.util.ArrayList;

public abstract class CarModel {
    private ArrayList<String> sequence = new ArrayList();
    protected abstract void start();
    protected abstract void stop();
    protected abstract void alarm();
    protected abstract void engineeBoom();
    final public void run() {
        for (int i = 0; i < sequence.size(); i++) {
            String actionName = this.sequence.get(i);
            if(actionName.equalsIgnoreCase("start")) {
                this.start();
            } else if(actionName.equalsIgnoreCase("stop")) {
                this.stop();
            } else if(actionName.equalsIgnoreCase("alarm")) {
                this.alarm();
            } else if(actionName.equalsIgnoreCase("engineeBoom")) {
                this.engineeBoom();
            }
        }
    }

    public void setSequence(ArrayList<String> sequence) {
        this.sequence = sequence;
    }
}
