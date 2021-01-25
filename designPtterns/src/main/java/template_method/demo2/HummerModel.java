package template_method.demo2;

public abstract class HummerModel {
    public abstract void start();
    public abstract void stop();
    public abstract void alarm();
    public abstract void engineeBoom();
    public void run(){
        this.start();
        this.engineeBoom();
        if(this.isAlarm()) {
            this.alarm();
        }
        this.stop();
    };
    protected boolean isAlarm() {
        return false;
    }
}
