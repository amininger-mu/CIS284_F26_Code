import java.awt.Color;
import edu.textbook.StdDraw;

public class Hilbert {
    public static void hilbert(int depth, Turtle turtle, double angle, double step) {
        if (depth == 0) {
            return;
        }

        turtle.turnLeft(angle);
        hilbert(depth-1, turtle, -angle, step);

        turtle.goForward(step);
        turtle.turnLeft(-angle);
        hilbert(depth-1, turtle, angle, step);

        turtle.goForward(step);
        hilbert(depth-1, turtle, angle, step);

        turtle.turnLeft(-angle);
        turtle.goForward(step);
        hilbert(depth-1, turtle, -angle, step);

        turtle.turnLeft(angle);
    }

    public static void main(String[] args) {
        int depth = 4;
        if (args.length > 0) {
            depth = Integer.parseInt(args[0]);
        }

        StdDraw.setCanvasSize(800, 800);
        StdDraw.clear(Color.black);
        StdDraw.setPenColor(new Color(255, 150, 150));
        StdDraw.setPenRadius(0.004);
        Turtle turtle = new Turtle(0.1, 0.1, 0.0);

        hilbert(depth, turtle, 90, 0.8 / Math.pow(2, depth));
        
    }
    
}
