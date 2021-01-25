package build;

public class BMWModel extends CarModel{
    @Override
    protected void start() {
        System.out.println("宝马启动");
    }

    @Override
    protected void stop() {
        System.out.println("宝马停止");
    }

    @Override
    protected void alarm() {
        System.out.println("宝马鸣笛");
    }

    @Override
    protected void engineeBoom() {
        System.out.println("宝马发动机声音发起...");
    }
}
