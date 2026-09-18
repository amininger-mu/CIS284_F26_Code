import java.awt.Color;

public class RandomCircles {

    public static void main(String[] args) {

        StdDraw.setCanvasSize(800, 800);
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);

        StdDraw.setPenColor(Color.BLUE);

        for (int i = 0; i < 100; i++) {
            double x = Math.random();
            double y = Math.random();
            double r = 0.02 + Math.random() * 0.1;
            StdDraw.filledCircle(x, y, r);
        }

    }

}