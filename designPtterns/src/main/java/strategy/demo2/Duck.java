package strategy.demo2;

public abstract class Duck {
    FlyBehavior flyBehavior;
    SwimBehavior swimBehavior;
    QuackBehavior quackBehavior;

    public Duck() {

    }


    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setSwimBehavior(SwimBehavior swimBehavior) {
        this.swimBehavior = swimBehavior;
    }


    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }


    public abstract void display();

    public void fly() {
        if (flyBehavior != null) {
            flyBehavior.fly();
        }
    }

    public void quack() {
        if (quackBehavior != null) {
            quackBehavior.quack();
        }
    }

    public void swim() {
        if (swimBehavior != null) {
            swimBehavior.swim();
        }
    }
}
