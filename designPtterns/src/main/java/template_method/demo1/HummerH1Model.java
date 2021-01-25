package template_method.demo1;

public class HummerH1Model extends HummerModel {
    @Override
    public void start() {
        System.out.println("悍马h1发动...");
    }

    @Override
    public void stop() {
        System.out.println("悍马h1停止...");
    }

    @Override
    public void alarm() {
        System.out.println("悍马h1鸣笛...");
    }

    @Override
    public void engineeBoom() {
        System.out.println("悍马h1引擎声音...");
    }
}
