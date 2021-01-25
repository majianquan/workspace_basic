package strategy.demo1;

public abstract class Duck {
    public Duck(){}
    public abstract void display();
    public void quack() {
        System.out.println("鸭子嘎嘎叫...");
    }
    public void swim() {
        System.out.println("鸭子会游泳...");
    }
    public void fly() {
        System.out.println("鸭子会飞翔...");
    }
}
