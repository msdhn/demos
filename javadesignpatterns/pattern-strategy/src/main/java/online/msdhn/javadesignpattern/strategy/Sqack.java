package online.msdhn.javadesignpattern.strategy;

public class Sqack implements QuackBehaviour {

    @Override
    public void quack() {

        System.out.println("I sqack;");
    }


}