package geometry;

public class DirectionVector2d extends CoordinateVector {
    public DirectionVector2d(double x, double y) {
        super(x, y);
    }

    @Override
    public DirectionVector2d translatedBy(DirectionVector2d vec) {
        return (DirectionVector2d)super.translatedBy(vec);
    }

    @Override
    protected CoordinateVector createResultObject(double x, double y) {
        return new DirectionVector2d(x, y);
    }

    @Override
    public String toString() {
        return "[DirectionVector2d: x = " + x + ", y= " + y + "]";
    }

    @Override
    public boolean isHitAt(double x, double y) {
        return false;
    }
}
