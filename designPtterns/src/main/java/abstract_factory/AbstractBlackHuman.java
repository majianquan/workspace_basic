package abstract_factory;

public abstract class AbstractBlackHuman implements Human {

    public void getColor() {
        System.out.println("黑色人种的皮肤颜色是黑色的....");
    }

    public void talk() {
        System.out.println("黑色人种说话,一般都人都听不懂");
    }
}