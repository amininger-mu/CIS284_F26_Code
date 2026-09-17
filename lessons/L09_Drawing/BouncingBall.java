
public class BouncingBall {
    public static void main(String[] args) throws InterruptedException {

        final int WIDTH = 800;
        final int HEIGHT = 600;
        final int RADIUS = 40;

        StdDraw.setCanvasSize(WIDTH, HEIGHT);
        StdDraw.setXscale(0.0, WIDTH);
        StdDraw.setYscale(0.0, HEIGHT);
        StdDraw.enableDoubleBuffering();

        StdDraw.setPenColor(StdDraw.PURPLE);

    }
}
