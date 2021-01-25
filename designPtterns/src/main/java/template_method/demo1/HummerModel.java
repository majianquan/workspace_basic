package template_method.demo1;

public abstract class HummerModel {
    public abstract void start();
    public abstract void stop();
    public abstract void alarm();
    public abstract void engineeBoom();
    public void run(){
        this.start();
        this.engineeBoom();
        this.alarm();
        this.stop();
    };
}
