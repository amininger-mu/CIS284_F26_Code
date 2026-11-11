import edu.textbook.StdDraw;

public class Turtle {
	private double x; // x position
	private double y; // y position
	private double a; // radians

    // start at (x0, y0), facing a0 degrees counterclockwise from the x-axis
    public Turtle(double x0, double y0, double a0) {
        x = x0;
        y = y0;
        a = Math.toRadians(a0);
    }

    // rotate orientation delta degrees counterclockwise
    public void turnLeft(double delta) {
        a += Math.toRadians(delta);
    }

    // move forward the given amount, with the pen down
    public void goForward(double step) {
        double oldX = x;
        double oldY = y;
        x += step * Math.cos(a);
        y += step * Math.sin(a);
        StdDraw.line(oldX, oldY, x, y);
    }

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		double angle = 360.0 / n;
		double step = Math.sin(Math.toRadians(angle/2));
		Turtle turtle = new Turtle(0.5, 0.0, angle/2);
		for (int i = 0; i < n; i++) {
			turtle.goForward(step);
			turtle.turnLeft(angle);
		}
	}
}
