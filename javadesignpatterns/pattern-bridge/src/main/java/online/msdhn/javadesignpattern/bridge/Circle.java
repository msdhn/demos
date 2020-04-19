package online.msdhn.javadesignpattern.bridge;

class Circle extends Shape {

    private double x, y, radius;

    public Circle(final double x, final double y, final double radius, final DrawingAPI drawingAPI) {
        super(drawingAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw() {
        drawingAPI.drawCircle(x, y, radius);
    }

    public void resizeByPercentage(final double pct) {
        radius *= (1.0 + pct / 100.0);
    }
}