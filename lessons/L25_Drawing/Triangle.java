import java.awt.Color;
import edu.textbook.StdDraw;

public class Triangle extends Shape {
    private final double[] vx;
    private final double[] vy;

    public Triangle(Point p1, Point p2, Point p3, Color color) {
        super(new Point(0, 0), 1.0, color);
        this.vx = new double[]{ p1.x(), p2.x(), p3.x() };
        this.vy = new double[]{ p1.y(), p2.y(), p3.y() };
        double cx = (vx[0] + vx[1] + vx[2])/3;
        double cy = (vy[0] + vy[1] + vy[2])/3;
        this.pos = new Point(cx, cy);
    }

    public void draw() {
        StdDraw.setPenColor(color);
        StdDraw.filledPolygon(vx, vy);
    }
}
