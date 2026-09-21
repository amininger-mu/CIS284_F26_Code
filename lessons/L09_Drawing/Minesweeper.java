import java.awt.Font;

public class Minesweeper {
	// Constants used to set up the program
    final static int BOMB = -1;       // int value representing a bomb (-1)
    final static int ROWS = 8;        // # rows in the grid
    final static int COLS = 10;       // # cols in the grid
    final static int NUM_BOMBS = 15;  // # bombs randomly placed in the grid

    public static void main(String[] args) {

        int[][] grid = new int[ROWS][COLS];

        int nBombs = NUM_BOMBS;

        // Place bombs in random positions
		while (nBombs > 0) {
            int row = (int)(Math.random() * ROWS); // random int from 0 to ROWS-1
            int col = (int)(Math.random() * COLS); // random int from 0 to COLS-1

			// Make sure there's not already a bomb there
			if (grid[row][col] == BOMB) continue;

			grid[row][col] = BOMB;
			nBombs--;
        }

        // Calculate Bomb Neighbors
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == BOMB) {
                    continue;
                }

                // Check the 8 neighbors and count bombs
                int bombCount = 0;

				// Look at 3x3 square centered at (r, c)
				// from r-1 to r+1 and c-1 to c+1
                for (int dr = -1; dr <= 1; dr++) {
                    for (int dc = -1; dc <= 1; dc++) {
						int nr = r+dr; // neighbor row (from r-1 to r+1)
						int nc = c+dc; // neighbor col (from c-1 to c+1)

                        if (nr < 0 || nr >= ROWS) continue; // nr is out of bounds
                        if (nc < 0 || nc >= COLS) continue; // nc is out of bounds
                        if (grid[nr][nc] == BOMB) {
                            bombCount++;
                        }
                    }
                }

				// Set bomb count
                grid[r][c] = bombCount;
            }
        }

        // Sets the window size width and height (50 pixels per square)
        StdDraw.setCanvasSize(COLS * 50, ROWS * 50);

        // Sets horizontal and vertical scale to make drawing easier
        StdDraw.setXscale(-1, COLS);
        StdDraw.setYscale(-1, ROWS);

        // Resets the background color
        StdDraw.clear(StdDraw.BOOK_LIGHT_BLUE);

        // Draw a gray outline of each square in the grid
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.setPenRadius(0.01);
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                StdDraw.square(c, r, 0.5);
            }
        }

        // Draw text labels for each square (or circle for bomb)
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
				if (grid[r][c] == 0) continue; // do not draw 0's

                if (grid[r][c] == BOMB) {
                    StdDraw.filledCircle(c, r, 0.4);
                } else if (grid[r][c] >= 0) {
                    StdDraw.text(c, r, "" + grid[r][c]);
                }
            }
        }
    }
}
