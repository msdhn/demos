package online.msdhn.javadesignpattern.strategy;

public class FlyWinthNoWing implements FlyingBehaviuor {

    @Override
    public void fly() {
        System.out.println("I fly with no wing");
    }


}