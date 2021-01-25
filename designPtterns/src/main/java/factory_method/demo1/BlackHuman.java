package factory_method.demo1;

public class BlackHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("黑色皮肤...");
    }

    @Override
    public void talk() {
        System.out.println("黑色人种语言...");
    }
}
