package com.hcl.ingbootcamp.javadesignpattern.abstractfactory;

public class ProductFactory2 implements ProductFactory {

    @Override
    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB2();
    }
}
