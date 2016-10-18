package geometry;

public class GeometryMain {
    public static void main(String[] args) {
        Point2d point = new Point2d(1.0, 2.0);
        Point2d translatedPoint = point.translatedBy(new DirectionVector2d(4.0, 5.0));
        System.out.println(translatedPoint);

        System.out.println(point.isHitAt(1.0, 2.0));
        System.out.println(point.isHitAt(5.0, 2.0));

        System.out.println(new DirectionVector2d(1.0, 2.0).isHitAt(1.0, 2.0));
    }
}
