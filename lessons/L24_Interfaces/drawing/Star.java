import java.awt.Color;
import edu.textbook.StdDraw;

public class Star implements Shape {
    private double x;
    private double y;
    private double r;
    private Color color;

    public Star(double x, double y, double r, Color color) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.color = color;
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
                vx[i] = x + r*Math.cos(angle);
                vy[i] = y + r*Math.sin(angle);
            } else {
                vx[i] = x + r/2*Math.cos(angle);
                vy[i] = y + r/2*Math.sin(angle);
            }
        }
        StdDraw.filledPolygon(vx, vy);
    }
}
