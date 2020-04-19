package online.msdhn.javadesignpattern.strategy;

public class FlyWithWings implements FlyingBehaviuor {

    @Override
    public void fly() {
        System.out.println("I fly with wings");
    }

}