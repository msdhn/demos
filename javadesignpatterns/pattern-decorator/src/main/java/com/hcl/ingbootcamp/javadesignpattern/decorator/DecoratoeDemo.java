package com.hcl.ingbootcamp.javadesignpattern.decorator;

public class DecoratoeDemo {

    public static void main(String... args) {
        Beverage beverage = new Expresso();
        Beverage beverageMocha = new Mocha(beverage);
        System.out.println(beverageMocha.getDescription() + " " + beverageMocha.cost());
    }

}
