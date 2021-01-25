package factory_method.demo1;

public class NvWa {
    public static void main(String[] args) {
        AbstractHumanFactory YinYangLu = new HumanFactory();

        // 创建白色人种
        WhiteHuman human = YinYangLu.createHuman(WhiteHuman.class);
        human.getColor();

        // 创建黑色人种
        BlackHuman human1 = YinYangLu.createHuman(BlackHuman.class);
        human1.getColor();

        // 创建白色人种
        YellowHuman human2 = YinYangLu.createHuman(YellowHuman.class);
        human2.getColor();
    }
}
