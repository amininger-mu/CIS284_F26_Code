import java.awt.Color;
import java.awt.event.KeyEvent;

public class Breakout {

    final static int WIDTH = 800;
    final static int HEIGHT = 400;

    final static int BRICK_ROWS = 5;
    final static int BRICK_COLS = 10;

    final static int BRICK_WIDTH = WIDTH / BRICK_COLS;
    final static int BRICK_HEIGHT = 30;
    final static int BRICK_THRESHOLD = HEIGHT - BRICK_HEIGHT * BRICK_ROWS;


    static class GameState {
        int score;
        double ballX;
        double ballY;
        double ballR;
        double velX;
        double velY;
        double paddleX;
        double paddleY;
        double paddleRX;
        double paddleRY;
        int[][] bricks;
    }

    // // Initializes the game state to the beginning state
    public static GameState initGame() {
        GameState state = new GameState();
        state.ballX = WIDTH/2;
        state.ballY = HEIGHT/2;
        state.ballR = 10;
        state.velX = (Math.random() - 0.5) * 8;
        state.velY = -8 - Math.random();
        state.paddleX = WIDTH/2;
        state.paddleY = 30;
        state.paddleRX = 80;
        state.paddleRY = 10;
        state.bricks = new int[BRICK_ROWS][BRICK_COLS];
        state.score = 0;
        for (int r = 0; r < state.bricks.length; r++) {
            for (int c = 0; c < state.bricks[r].length; c++) {
                state.bricks[r][c] = 100 * (r + 1);
            }
        }
        return state;
    }


    public static record Coord(int row, int col) {};

    public static Coord getBrick(double x, double y) {
        int col = (int)Math.floor(x / BRICK_WIDTH);
        int row = (int)Math.floor((y - BRICK_THRESHOLD) / BRICK_HEIGHT);
        if (col < 0 || col >= BRICK_COLS || row < 0 || row >= BRICK_ROWS) {
            return null;
        }
        return new Coord(row, col);
    }

    public static void update(GameState state) {
        if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
            state.paddleX -= 10;
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
            state.paddleX += 10;
        }
        state.paddleX = Math.clamp(state.paddleX, state.paddleRX, WIDTH - state.paddleRX);


        state.ballX += state.velX;
        state.ballY += state.velY;

        if(state.ballX - state.ballR < 0) {
            state.velX = Math.abs(state.velX);
        } else if (state.ballX + state.ballR > WIDTH) {
            state.velX = -Math.abs(state.velX);
        }

        if(state.ballY  - state.ballR < state.paddleY + state.paddleRY) {
            if (Math.abs(state.ballX - state.paddleX) < state.paddleRX) {
                state.velY = Math.abs(state.velY);
            } else {
                // MISS
                state.ballX = WIDTH/2;
                state.ballY = HEIGHT/2;
            }
        } else if (state.ballY + state.ballR > HEIGHT) {
            state.velY = -Math.abs(state.velY);
        }

        Coord brick = getBrick(state.ballX, state.ballY);
        if (brick != null) {
            state.score += state.bricks[brick.row][brick.col];
            state.bricks[brick.row][brick.col] = 0;

        }

    }

    public static void draw(GameState state) {
        StdDraw.clear();

        // Draw the ball
        StdDraw.setPenColor(Color.blue);
        StdDraw.filledCircle(state.ballX, state.ballY, state.ballR);
        StdDraw.setPenColor(Color.black);
        StdDraw.circle(state.ballX, state.ballY, state.ballR);

        // Draw the paddle
        StdDraw.setPenColor(Color.darkGray);
        StdDraw.filledRectangle(state.paddleX, state.paddleY, state.paddleRX, state.paddleRY);

        // Draw the bricks
        for (int r = 0; r < state.bricks.length; r++) {
            for (int c = 0; c < state.bricks[r].length; c++) {
                if (state.bricks[r][c] > 0) {
                    float hue = (float)(0.1 * state.bricks[r][c] / 100.0);
                    StdDraw.setPenColor(Color.getHSBColor(hue, 1.0f, 1.0f));
                    double x = (c + 0.5) * BRICK_WIDTH;
                    double y = BRICK_THRESHOLD + (r + 0.5) * BRICK_HEIGHT;
                    StdDraw.filledRectangle(x, y, BRICK_WIDTH/2.1, BRICK_HEIGHT/2.1);
                }
            }
        }
         StdDraw.show();
    }

    public static void main(String[] args) {

        StdDraw.setCanvasSize(WIDTH, HEIGHT);
        StdDraw.setXscale(0, WIDTH);
        StdDraw.setYscale(0, HEIGHT);
        StdDraw.enableDoubleBuffering();

        GameState state = initGame();

        while(true) {
            update(state);
            draw(state);
            StdDraw.pause(20);
        }
    }
}
