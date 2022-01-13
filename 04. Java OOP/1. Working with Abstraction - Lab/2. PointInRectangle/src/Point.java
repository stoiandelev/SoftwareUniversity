public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean greaterOrEquals(Point p) {
        return p.x <= x && p.y <= y;
    }

    public boolean lessOrEquals(Point p) {
        return x <= p.x && y <= p.y;
    }
}

