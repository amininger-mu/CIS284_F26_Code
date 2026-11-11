import edu.textbook.StdDraw;
import java.awt.Color;

public class Koch {

	public static void koch(int depth, Turtle turtle, double dist) {
		if (depth == 0) {
			turtle.goForward(dist);
			return;
		}
		koch(depth-1, turtle, dist/3);
		turtle.turnLeft(60);
		koch(depth-1, turtle, dist/3);
		turtle.turnLeft(-120);
		koch(depth-1, turtle, dist/3);
		turtle.turnLeft(60);
		koch(depth-1, turtle, dist/3);
	}

	public static void main(String[] args) {
		int depth = Integer.parseInt(args[0]);

		StdDraw.setCanvasSize(800, 800);
		StdDraw.clear(new Color(100, 100, 255));
		StdDraw.setPenColor(Color.white);
		StdDraw.setPenRadius(0.01);
		StdDraw.enableDoubleBuffering();

		Turtle turtle = new Turtle(0.1, 0.5, 0.0);
		turtle.turnLeft(-60);

		// Draw a hexagon
		for (int i = 0; i < 6; i++) {
			koch(depth, turtle, 0.4);
			turtle.turnLeft(60);
		}

		StdDraw.show();
	}

}
