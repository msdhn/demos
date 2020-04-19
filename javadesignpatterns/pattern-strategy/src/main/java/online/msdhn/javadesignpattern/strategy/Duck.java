package online.msdhn.javadesignpattern.strategy;

public abstract class Duck {

    private FlyingBehaviuor flyingBehaviuor;
    private QuackBehaviour quackBehaviour;

    Duck(FlyingBehaviuor flybBehaviuor, QuackBehaviour quackBehaviour) {
        this.flyingBehaviuor = flybBehaviuor;
        this.quackBehaviour = quackBehaviour;
    }

    public abstract void fly();

    public abstract void quack();

    public abstract void display();

    public FlyingBehaviuor getFlyingBehaviuor() {
        return flyingBehaviuor;
    }

    public void setFlyingBehaviuor(FlyingBehaviuor flyingBehaviuor) {
        this.flyingBehaviuor = flyingBehaviuor;
    }

    public QuackBehaviour getQuackBehaviour() {
        return quackBehaviour;
    }

    public void setQuackBehaviour(QuackBehaviour quackBehaviour) {
        this.quackBehaviour = quackBehaviour;
    }
}