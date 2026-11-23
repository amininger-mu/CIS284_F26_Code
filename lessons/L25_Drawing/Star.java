import java.awt.Color;
import edu.textbook.StdDraw;

public class Star extends Shape {

    public Star(Point pos, double scale, Color color) {
        super(pos, scale, color);
    }

    public void draw() {
        StdDraw.setPenColor(color);
        double[] vx = new double[10];
        double[] vy = new double[10];
        // Draw 10 evenly spaced vertices in a circle
        for (int i = 0; i < 10; i++) {
            double angle = Math.toRadians(36*i+90);
            // Alternate radius r and r/2
            if (i % 2 == 0) {
                vx[i] = pos.x() + scale*Math.cos(angle);
                vy[i] = pos.y() + scale*Math.sin(angle);
            } else {
                vx[i] = pos.x() + scale/2*Math.cos(angle);
                vy[i] = pos.y() + scale/2*Math.sin(angle);
            }
        }
        StdDraw.filledPolygon(vx, vy);
    }
}
