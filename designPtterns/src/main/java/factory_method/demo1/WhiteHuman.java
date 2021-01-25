package factory_method.demo1;

public class WhiteHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("白色人种...");
    }

    @Override
    public void talk() {
        System.out.println("白色人种语言...");
    }
}
