
public class BouncingBall {
    public static void main(String[] args) throws InterruptedException {
        final int WIDTH = 800;
        final int HEIGHT = 600;
        final int RADIUS = 40;

        double ballX = 100;
        double ballY = 100;

        double velX = 5 + Math.random() * 20;
        double velY = 5 + Math.random() * 20;

        StdDraw.setCanvasSize(WIDTH, HEIGHT);
        StdDraw.setXscale(0.0, WIDTH);
        StdDraw.setYscale(0.0, HEIGHT);
        StdDraw.enableDoubleBuffering();

        StdDraw.setPenColor(StdDraw.PURPLE);

        while(true) {
			// clear the canvas to draw next frame
            StdDraw.clear(StdDraw.BOOK_LIGHT_BLUE);

            StdDraw.filledCircle(ballX, ballY, RADIUS);
            ballX += velX;
            ballY += velY;

			// Check X Position
            if (ballX - RADIUS < 0) {
                velX *= -1;
				ballX = RADIUS;
            } else if (ballX + RADIUS > WIDTH) {
                velX *= -1;
                ballX = WIDTH - RADIUS;
            }
			// Check Y Position
            if (ballY - RADIUS < 0) {
                velY *= -1;
				ballY = RADIUS;
            } else if (ballY + RADIUS > HEIGHT) {
                velY *= -1;
				ballY = HEIGHT - RADIUS;
            }

            StdDraw.show();
			StdDraw.pause(20); // sleep 20 ms -> 50 fps
        }
    }
}
