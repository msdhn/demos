package com.hcl.ingbootcamp.javadesignpattern.strategy;

public class StrategyTest {

    public static void main(String... args) {
        Duck a = new DuckTypeA(new FlyWithWings(), new Sqack());
        a.display();
        a.fly();
        a.quack();

        Duck b = new DuckTypeB(new FlyWinthNoWing(), new Mute());
        b.display();
        b.fly();
        b.quack();


    }
}
