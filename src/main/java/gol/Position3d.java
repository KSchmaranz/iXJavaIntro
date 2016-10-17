package gol;

public class Position3d implements Position {
    private final int x;
    private final int y;
    private final int z;

    public Position3d(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distanceFrom(Position other) {
        if (!(other instanceof Position3d))
            throw new IllegalArgumentException("Can only use Position3d");

        Position3d otherPosition3d = (Position3d) other;

        double deltaX = x - otherPosition3d.x;
        double deltaY = y - otherPosition3d.y;
        double deltaZ = z - otherPosition3d.z;

        return Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);
    }

}
