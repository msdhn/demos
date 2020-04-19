package online.msdhn.javadesignpattern.factory;

public class ShapeFactory {

    private static final ShapeFactory FACTORY = new ShapeFactory();

    private ShapeFactory() {
    }

    public static ShapeFactory instance() {
        return FACTORY;
    }

    public Shape getShape(String type) {
        if ("CIRCLE".equals(type)) {
            return new Circle();
        } else if ("TRIANGLE".equals(type)) {
            return new Triangle();
        } else {
            throw new IllegalArgumentException("wrong shape type");
        }
    }
}
