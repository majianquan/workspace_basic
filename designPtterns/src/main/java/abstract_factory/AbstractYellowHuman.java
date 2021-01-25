package abstract_factory;

public abstract class AbstractYellowHuman implements Human {
    public void getColor() {
        System.out.println("黄色人种的皮肤颜色是黄色的....");
    }

    public void talk() {
        System.out.println("黄色人种说话,一般都人都是双字节");
    }
}
