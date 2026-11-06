
public class Vector {
    private final double x;
    private final double y;

    public Vector() {
        x = 0;
        y = 0;
    }

    public Vector(double vx, double vy) {
        x = vx;
        y = vy;
    }

    public double x() {
        return x;
    }
    public double y() {
        return y;
    }

    public double mag() {
        return Math.sqrt(x*x + y*y);
    }

    public Vector scale(double s) {
        return new Vector(x*s, y*s);
    }

    public Vector rotate(double angle) {
        double nx = x * Math.cos(angle) - y * Math.sin(angle);
        double ny = x * Math.sin(angle) + y * Math.cos(angle);
        return new Vector(nx, ny);
    }

    public String toString() {
        return String.format("(%.3f, %.3f)", x, y);
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Vector)) return false;
        Vector v2 = (Vector)obj;
        return x == v2.x && y == v2.y;
    }

    public static void main(String[] args) {
        Vector u = new Vector(3, 1);
        System.out.println("u: " + u);
        Vector v = null;
        System.out.println(u.equals("(3, 1)"));
    }
}
