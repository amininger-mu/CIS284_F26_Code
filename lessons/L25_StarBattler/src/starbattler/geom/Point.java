package starbattler.geom;

public record Point(double x, double y) { 

    public Point add(double dx, double dy) {
        return new Point(x + dx, y + dy);
    }

    public Point add(Vector v) {
        return new Point(x + v.x(), y + v.y());
    }

}
