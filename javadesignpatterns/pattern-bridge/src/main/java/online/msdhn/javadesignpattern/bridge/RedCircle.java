package online.msdhn.javadesignpattern.bridge;

class RedCircle implements DrawingAPI {
    public void drawCircle(final double x, final double y, final double radius) {
        System.out.println("red cirtcle - > (" + x + "," + y + "," + radius + ")");
    }
}