package template_method.demo1;

public class HummerH2Model extends HummerModel {
    @Override
    public void start() {
        System.out.println("悍马h2发动...");
    }

    @Override
    public void stop() {
        System.out.println("悍马h2停止...");
    }

    @Override
    public void alarm() {
        System.out.println("悍马h2鸣笛...");
    }

    @Override
    public void engineeBoom() {
        System.out.println("悍马h2引擎声音...");
    }
}
