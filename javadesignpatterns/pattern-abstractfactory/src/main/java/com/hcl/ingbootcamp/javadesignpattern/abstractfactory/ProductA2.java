package com.hcl.ingbootcamp.javadesignpattern.abstractfactory;

public class ProductA2 implements AbstractProductA {

    @Override
    public void showPrice() {
        System.out.println("I am product of type A 2 , price : " + 1000d);
    }

}
