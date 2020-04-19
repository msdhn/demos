package online.msdhn.javadesignpattern.strategy;

public class DuckTypeA extends Duck {

    DuckTypeA(FlyingBehaviuor flybBehaviuor, QuackBehaviour quackBehaviour) {
        super(flybBehaviuor, quackBehaviour);
    }

    @Override
    public void fly() {
        this.getFlyingBehaviuor().fly();
    }

    @Override
    public void quack() {
        this.getQuackBehaviour().quack();
    }

    @Override
    public void display() {
        System.out.println("I am Duck type A.");
    }

}