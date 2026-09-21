/******************************************************************************
 *  Compilation:  javac RandomWalk.java
 *  Execution:    java RandomWalk N?
 *
 *  Performs a random walk on an 2N*2N square
 *  Reports the number of steps to reach the edge
 *
 ******************************************************************************/

import java.awt.Color;

public class RandomWalk {
    
    public static void main(String[] args) throws InterruptedException {
		// N = Size of grid (-N to N)
        int N = 10;
        if (args.length > 0) {
            N = Integer.parseInt(args[0]);
        }

		// Initialize steps
        int x = 0;
        int y = 0;
        int steps = 0;
        float shade = 0.0f;

        StdDraw.setCanvasSize(1000, 1000);
        StdDraw.setXscale(-N, N);
        StdDraw.setYscale(-N, N);


        while (true) {
            steps++;
            int randDir = (int)(Math.random() * 4);

            if (randDir == 0) {
                x++;
            } else if (randDir == 1) {
                y++;
            } else if (randDir == 2) {
                x--;
            } else if (randDir == 3) {
                y--;
            }

            Color color = Color.getHSBColor(shade, 1.0f, 1.0f);
            StdDraw.setPenColor(color);

            shade += 0.02;
            if (shade > 1.0) {
                shade = 0.0f;
            }
            StdDraw.filledSquare(x, y, 0.5);
            StdDraw.pause(100);

            if (Math.abs(x) == N || Math.abs(y) == N) {
                break;
            }
        }
        System.out.println("Took " + steps + " steps");
    }
}
