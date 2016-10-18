package geometry;

public abstract class CoordinateVector implements GeometricalObject {
    protected double x;
    protected double y;

    public CoordinateVector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public CoordinateVector translatedBy(DirectionVector2d vec) {
        return createResultObject(x + vec.x, y + vec.y);
    }

    protected abstract CoordinateVector createResultObject(double x, double y);
}
