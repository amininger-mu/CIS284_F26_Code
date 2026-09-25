import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

public class MinesweeperGame {

	// Constants used to set up the program
    final static int BOMB = -1;       // int value representing a bomb (-1)
    final static int ROWS = 8;        // # rows in the grid
    final static int COLS = 10;       // # cols in the grid
    final static int NUM_BOMBS = 15;  // # bombs randomly placed in the grid

	// Different states that a cell can have
    final static int HIDDEN = 0;
    final static int VISIBLE = 1;
    final static int FLAGGED = 2;


    // Place nBombs in random positision in the given grid
    public static void placeBombs(int[][] grid, int nBombs) {
		while (nBombs > 0) {
            int row = (int)(Math.random() * ROWS); // random int from 0 to ROWS-1
            int col = (int)(Math.random() * COLS); // random int from 0 to COLS-1

			// Make sure there's not already a bomb there
			if (grid[row][col] == BOMB) continue;

			grid[row][col] = BOMB;
			nBombs--;
        }
    }

	// Counts the number of bombs in the 8 neighbors of the given cell
    public static int countNeighborBombs(int[][] grid, int row, int col) {
        int bombCount = 0;

        // Look at 3x3 square centered at (r, c)
        // from r-1 to r+1 and c-1 to c+1
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                int nr = row+dr; // neighbor row (from r-1 to r+1)
                int nc = col+dc; // neighbor col (from c-1 to c+1)

                if (nr < 0 || nr >= ROWS) continue; // nr is out of bounds
                if (nc < 0 || nc >= COLS) continue; // nc is out of bounds
                if (grid[nr][nc] == BOMB) {
                    bombCount++;
                }
            }
        }

        return bombCount;
    }

	// Fills in the grid with bomb counts for each cell
    public static void calcBombNeighborCounts(int[][] grid) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] != BOMB) {
					grid[r][c] = countNeighborBombs(grid, r, c);
                }
            }
        }
    }

    public static void setupCanvas() {
        // Sets the window size width and height (50 pixels per square)
        StdDraw.setCanvasSize(COLS * 50, ROWS * 50);

        // Sets horizontal and vertical scale to make drawing easier
        StdDraw.setXscale(-1, COLS);
        StdDraw.setYscale(-1, ROWS);

        StdDraw.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));
        StdDraw.enableDoubleBuffering();
    }


    public static void drawGame(int[][] grid, int[][] state) {
        drawBackground();
        drawGrid(grid, state);
        StdDraw.show();
    }

    public static void drawBackground() {
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

    }    
    
    public static void drawFlag(int row, int col) {
        double[] xs = { col - 0.2, col + 0.2, col - 0.2 };
        double[] ys = { row - 0.3, row, row + 0.3 };
        StdDraw.setPenColor(new Color(200, 0, 0));
        StdDraw.filledPolygon(xs, ys);
    }

    public static void drawBomb(int row, int col) {
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.filledCircle(col, row, 0.4);
    }

    public static void drawBlank(int row, int col) {
        StdDraw.setPenColor(Color.BLUE);
        StdDraw.filledSquare(col, row, 0.45);
    }

    public static void drawNumber(int row, int col, int num) {
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.text(col, row, String.valueOf(num));
    }

    public static void drawGrid(int[][] grid, int[][] state) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (state[r][c] == HIDDEN) continue;
                if (state[r][c] == FLAGGED) {
                    drawFlag(r, c);
                } else if (grid[r][c] == BOMB) {
                    drawBomb(r, c);
                } else if (grid[r][c] == 0) {
                    drawBlank(r, c);
                } else {
                    drawNumber(r, c, grid[r][c]);
                }
            }
        }
    }

	// Handles a mouse press action at the given x, y coordinate
    public static void handleMousePress(int[][] state, double x, double y) {
        // Treat (0, 0) as clicking outside window, ignore
        if (x == 0.0 && y == 0.0) return;

        // Map the mouse x,y coordinate to the nearest row/col
        int col = (int)Math.round(x);
        int row = (int)Math.round(y);

        // Make sure cell is in bounds
        if (col < 0 || col >= COLS || row < 0 || row >= ROWS) return;

        // Ignore clicking on revealed squares
        if (state[row][col] != HIDDEN) return;

		// If Shift is held, then flag the position
        if (StdDraw.isKeyPressed(KeyEvent.VK_SHIFT)) {
            state[row][col] = FLAGGED;

		// Otherwise, make the cell visible
        } else {
            state[row][col] = VISIBLE;
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[ROWS][COLS];
        int[][] state = new int[ROWS][COLS];

		// Set up the grid
        placeBombs(grid, NUM_BOMBS);
		calcBombNeighborCounts(grid);

		// Draw the initial state
        setupCanvas();
        drawGame(grid, state);

		// Inner Game Loop
        while(true) {
			// Handle Mouse Presses
            if (StdDraw.isMousePressed()) {
                handleMousePress(state, StdDraw.mouseX(), StdDraw.mouseY());
                drawGame(grid, state);
            }

			// Loop every 100ms
            StdDraw.pause(100);
        }
    }
}
