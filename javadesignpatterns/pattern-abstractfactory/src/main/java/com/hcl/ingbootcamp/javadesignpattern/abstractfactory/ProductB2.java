package com.hcl.ingbootcamp.javadesignpattern.abstractfactory;

public class ProductB2 implements AbstractProductB {

    @Override
    public void showPrice() {
        System.out.println("I am product of type B 2 , price : " + 5000d);
    }

}
