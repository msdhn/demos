package com.hcl.ingbootcamp.javadesignpattern.bridge;

class BridgePatternDemo {
    public static void main(final String[] args) {

        Shape[] shapes = new Shape[]{new Circle(1, 2, 3, new RedCircle()),
                new Circle(5, 7, 11, new GreenCircle())};

        for (Shape shape : shapes) {
            shape.resizeByPercentage(2.5);
            shape.draw();
        }

    }
}