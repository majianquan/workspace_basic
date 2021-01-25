package strategy.demo2;

public class PekingDuck extends Duck {
    public PekingDuck() {
        flyBehavior = new GoodFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println("北京鸭....");
    }
}
