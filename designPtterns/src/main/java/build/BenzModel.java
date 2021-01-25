package build;

public class BenzModel extends CarModel {
    @Override
    protected void start() {
        System.out.println("奔驰启动");
    }

    @Override
    protected void stop() {
        System.out.println("奔驰停止");
    }

    @Override
    protected void alarm() {
        System.out.println("奔驰鸣笛");
    }

    @Override
    protected void engineeBoom() {
        System.out.println("奔驰发动机声音发起...");
    }
}
