package strategy.demo1;

public class PekingDuck extends Duck{
    @Override
    public void display() {
        System.out.println("~~~北京鸭~~~");
    }
    // 北京鸭不能飞翔,所以要重写fly
    @Override
    public void fly() {
        System.out.println("北京鸭不会飞翔...");
    }
}
