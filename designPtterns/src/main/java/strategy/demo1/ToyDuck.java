package strategy.demo1;

public class ToyDuck extends Duck{
    @Override
    public void display() {
        System.out.println("~~~玩具鸭~~~");
    }
    // 鸭子类所有方法都不符合,都需要重写
    @Override
    public void quack() {
        System.out.println("玩具鸭不会叫...");
    }

    @Override
    public void swim() {
        System.out.println("玩具鸭不会游泳...");
    }

    @Override
    public void fly() {
        System.out.println("玩具鸭不会飞翔...");
    }
}
