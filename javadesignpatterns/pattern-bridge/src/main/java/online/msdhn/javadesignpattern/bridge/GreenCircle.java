package online.msdhn.javadesignpattern.bridge;

class GreenCircle implements DrawingAPI {
    public void drawCircle(final double x, final double y, final double radius) {
        System.out.println("green circle - > (" + x + "," + y + "," + radius + ")");
    }
}