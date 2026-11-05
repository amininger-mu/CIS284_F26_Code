/*********************************************
 * class: Starfield
 * depends on: StdDraw, Star.java
 *
 * Main Program: java Starfield [N?]
 *   You can provide an optional N for number of stars
 *
 * This will animate a Starfield (zooming through space)
 * 
 * It demonstrates a simple particle system
 * *******************************************/

import java.awt.Color;
import edu.textbook.StdDraw;

public class Starfield {

    public static void main(String[] args) {
        // Optional arg0 [int]: number of stars
        int nStars = 100; 
        if (args.length > 0) {
            nStars = Integer.parseInt(args[0]);
        }

        // Set up the canvas
        StdDraw.setCanvasSize(600, 600);
        StdDraw.setXscale(-1, 1);
        StdDraw.setYscale(-1, 1);
        StdDraw.enableDoubleBuffering();

        // Create N stars
        Star[] stars = new Star[nStars];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star();
        }

        // Animation Loop
        while(true) {
            // Clear the canvas (black background)
            StdDraw.clear(Color.black);

            // update all stars
            for (int i = 0; i < stars.length; i++) {
                stars[i].update();
            }

            // draw all stars
            for (int i = 0; i < stars.length; i++) {
                stars[i].draw();
            }

            // show the result (update screen)
            StdDraw.show();

            // Sleep for 13ms (= 60 fps)
            StdDraw.pause(13);
        }
    }
}
