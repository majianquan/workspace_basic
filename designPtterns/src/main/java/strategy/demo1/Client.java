package strategy.demo1;

public class Client {
    public static void main(String[] args) {
        Duck duck = new ToyDuck();
        duck.display();
        duck.quack();
        duck.swim();
        duck.fly();
    }
}
