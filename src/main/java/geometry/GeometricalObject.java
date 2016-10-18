package geometry;

public interface GeometricalObject {
    GeometricalObject translatedBy(DirectionVector2d vec);
    boolean isHitAt(double x, double y);
    default boolean isHitAt(Point2d point) { return isHitAt(point.x, point.y); }
}
