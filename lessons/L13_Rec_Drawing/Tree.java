import java.awt.Color;

public class Tree {

    static void draw(int depth, double x, double y, double angle, double length) {
        if (depth == 0) {
            return;
        }

        // Calculate endpoints of line segment
        double x1 = x + Math.cos(angle) * length;
        double y1 = y + Math.sin(angle) * length;

        // Draw the line 
        // StdDraw.setPenRadius(depth * 0.004);
        StdDraw.line(x, y, x1, y1);

        // Draw each branch, changing the angle by +/- ANGLE_OFFSET, 
        //                   and length by x SCALE factor
        final double SCALE = 0.667;
        final double ANGLE_OFFSET = Math.PI/4;
        draw(depth-1, x1, y1, angle - ANGLE_OFFSET, length * SCALE);
        draw(depth-1, x1, y1, angle + ANGLE_OFFSET, length * SCALE);
    }

    public static void main(String[] args) {
        int depth = 5;
        if (args.length > 0) {
            depth = Integer.parseInt(args[0]);
        }

        StdDraw.setCanvasSize(1000, 1000);
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(-0.5, 1.5);
        StdDraw.setYscale(-0.5, 1.5);

        StdDraw.setPenColor(new Color(0, 150, 0));
        StdDraw.setPenRadius(0.01);

        draw(depth, 0.5, 0.0, Math.PI/2, 0.3);

        StdDraw.show();
    }
}
