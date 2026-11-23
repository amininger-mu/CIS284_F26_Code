package starbattler.geom;

public record Vector(double x, double y) {

    public Vector add(Vector v) {
        return new Vector(x + v.x, y + v.y);
    }

    public Vector mul(double s) {
        return new Vector(x * s, y * s);
    }
}
