/******************************************************************************
 *  Compilation:  javac RandomWalk.java
 *  Execution:    java RandomWalk N?
 *
 *  Performs a random walk on an 2N*2N square
 *  Reports the number of steps to reach the edge
 *
 ******************************************************************************/

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

            if (Math.abs(x) == N || Math.abs(y) == N) {
                break;
            }
        }
        System.out.println("Took " + steps + " steps");
    }
}
