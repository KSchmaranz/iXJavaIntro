package geometry;

public class Point2d extends CoordinateVector {

    public Point2d(double x, double y) {
        super(x, y);
    }

    @Override
    public Point2d translatedBy(DirectionVector2d vec) {
        return (Point2d)super.translatedBy(vec);
    }

    @Override
    protected CoordinateVector createResultObject(double x, double y) {
        return new Point2d(x, y);
    }

    @Override
    public boolean isHitAt(double x, double y) {
        return this.x == x && this.y == y;
    }

    @Override
    public String toString() {
        return "[Point2d: x = " + x + ", y= " + y + "]";
    }
}
