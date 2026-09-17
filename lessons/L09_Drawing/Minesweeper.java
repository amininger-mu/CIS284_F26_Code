import java.awt.Font;

public class Minesweeper {
    final static int BOMB = -1;
    final static int ROWS = 8;
    final static int COLS = 10;
    final static int NUM_BOMBS = 15;

    public static void main(String[] args) {

        int[][] grid = new int[ROWS][COLS];

        int nBombs = NUM_BOMBS;

        // Place bombs in random positions

        // Calculate Bomb Neighbors
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == BOMB) {
                    continue;
                }

                // Check the 8 neighbors and count bombs
                int bombCount = 0;

                grid[r][c] = bombCount;
            }
        }

        // Sets the window size width and height (50 pixels per square)
        StdDraw.setCanvasSize(COLS * 50, ROWS * 50);

        // Sets horizontal and vertical scale to make drawing easier
        StdDraw.setXscale(0.0, COLS);
        StdDraw.setYscale(0.0, ROWS);

        // Resets the background color
        StdDraw.clear(StdDraw.BOOK_LIGHT_BLUE);

        // Draw a gray outline of each square in the grid
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.setPenRadius(0.01);
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                StdDraw.square(c+0.5, r+0.5, 0.5);
            }
        }

        // Draw text labels for each square (or circle for bomb)
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == BOMB) {
                    StdDraw.filledCircle(c + 0.5, r + 0.5, 0.4);
                } else if (grid[r][c] >= 0) {
                    StdDraw.text(c + 0.5, r + 0.5, "" + grid[r][c]);
                }
            }
        }
    }
}
