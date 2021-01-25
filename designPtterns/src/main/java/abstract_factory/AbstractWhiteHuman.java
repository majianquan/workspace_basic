package abstract_factory;

public abstract class AbstractWhiteHuman implements Human {

    public void getColor() {
        System.out.println("白色人种的皮肤颜色是白色的....");
    }

    public void talk() {
        System.out.println("白色人种说话,一般都是单个字节");
    }
}
