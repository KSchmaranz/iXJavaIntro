package gol;

public class Position2d implements Position{

    private final int x;
    private final int y;

    public Position2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double distanceFrom(Position other) {
        if (!(other instanceof Position2d))
            throw new IllegalArgumentException("Can only use Position2d");

        Position2d otherPosition2d = (Position2d) other;
        double deltaX = x - otherPosition2d.x;
        double deltaY = y - otherPosition2d.y;

        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
