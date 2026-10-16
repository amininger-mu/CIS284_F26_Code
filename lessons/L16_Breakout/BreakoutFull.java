import java.awt.Color;
import java.awt.event.KeyEvent;

public class BreakoutFull {

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

    // Initializes the game state to the beginning state
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

    public static void movePaddle(GameState state, boolean right) {
        if (right) {
            state.paddleX += 10;
            if (state.paddleX + state.paddleRX > WIDTH) {
                state.paddleX = WIDTH - state.paddleRX;
            }
        } else {
            state.paddleX -= 10;
            if (state.paddleX - state.paddleRX < 0) {
                state.paddleX = state.paddleRX;
            }
        }
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


    public static void updateBall(GameState state) {
        state.ballX += state.velX;
        state.ballY += state.velY;

        if (state.velX < 0) {
            // Moving left
            if (state.ballX - state.ballR < 0) {
                // Hit left wall
                state.velX *= -1;
                state.ballX = state.ballR;
            } else {
                Coord brick = getBrick(state.ballX - state.ballR, state.ballY);
                if (brick != null && state.bricks[brick.row][brick.col] > 0) {
                    state.velX *= -1;
                    state.ballX = (brick.col+1) * BRICK_WIDTH + state.ballR;
                    state.score += state.bricks[brick.row][brick.col];
                    state.bricks[brick.row][brick.col] = 0;
                }
            }
        } else {
            if (state.ballX + state.ballR > WIDTH) {
                // Hit right wall
                state.velX *= -1;
                state.ballX = WIDTH - state.ballR;
            } else {
                Coord brick = getBrick(state.ballX + state.ballR, state.ballY);
                if (brick != null && state.bricks[brick.row][brick.col] > 0) {
                    state.velX *= 1;
                    state.ballX = brick.col * BRICK_WIDTH - state.ballR;
                    state.score += state.bricks[brick.row][brick.col];
                    state.bricks[brick.row][brick.col] = 0;
                }
            }
        }

        if (state.velY > 0) {
            // Moving left
            if (state.ballY + state.ballR > HEIGHT) {
                // Hit top wall
                state.velY *= -1;
                state.ballY = HEIGHT - state.ballR;
            } else {
                Coord brick = getBrick(state.ballX, state.ballY + state.ballR);
                if (brick != null && state.bricks[brick.row][brick.col] > 0) {
                    state.velY *= -1;
                    state.ballY = BRICK_THRESHOLD + brick.row * BRICK_HEIGHT - state.ballR;
                    state.score += state.bricks[brick.row][brick.col];
                    state.bricks[brick.row][brick.col] = 0;
                }
            }
        } else {
            // Moving Down
            if (state.ballY - state.ballR < state.paddleY + state.paddleRY) {
                // Below Paddle Line
                double dx = state.ballX - state.paddleX;
                if (dx >= -state.paddleRX && dx <= state.paddleRX) {
                    // Hits paddle
                    state.velY *= -1;
                    state.velX = (state.velX + (dx/10)) / 2;
                    state.velX = Math.clamp(state.velX, -10, 10);
                    state.ballY = state.paddleY + state.paddleRY + state.ballR;
                } else {
                    // You LOSE!
                    state.ballX = WIDTH/2;
                    state.ballY = HEIGHT/2;
                    state.velY = -8.1;
                }
            } else {
                // Check Block
                Coord brick = getBrick(state.ballX, state.ballY - state.ballR);
                if (brick != null && state.bricks[brick.row][brick.col] > 0) {
                    state.velY *= -1;
                    state.ballY = (brick.row+1) * BRICK_HEIGHT + state.ballR;
                    state.score += state.bricks[brick.row][brick.col];
                    state.bricks[brick.row][brick.col] = 0;
                }
            }
        }
    }


    public static void update(GameState state) {
        if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
            movePaddle(state, false);
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
            movePaddle(state, true);
        }

        updateBall(state);
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
        double bottomY = HEIGHT - BRICK_HEIGHT * BRICK_ROWS;
        for (int r = 0; r < state.bricks.length; r++) {
            for (int c = 0; c < state.bricks[r].length; c++) {
                if (state.bricks[r][c] > 0) {
                    float hue = (float)(0.1 * state.bricks[r][c] / 100.0);
                    StdDraw.setPenColor(Color.getHSBColor(hue, 1.0f, 1.0f));
                    double x = (c + 0.5) * BRICK_WIDTH;
                    double y = bottomY + (r + 0.5) * BRICK_HEIGHT;
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
            //long start = System.currentTimeMillis();
            update(state);
            draw(state);
            //System.out.println("Elapsed: " + (System.currentTimeMillis() - start));

            StdDraw.pause(20);
        }
    }
}
