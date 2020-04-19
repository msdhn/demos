package com.hcl.ingbootcamp.javadesignpattern.factory;

public class ShapeFactoryDemo {

    public static void main(String... args) {
        Shape shape1 = ShapeFactory.instance().getShape("CIRCLE");
        Shape shape2 = ShapeFactory.instance().getShape("TRIANGLE");
        shape1.draw();
        shape2.draw();
    }

}
