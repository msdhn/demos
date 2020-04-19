package com.hcl.ingbootcamp.javadesignpattern.abstractfactory;

public class ProductFactory1 implements ProductFactory {

    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB1();
    }

}
