import java.awt.Color;
import java.awt.Font;

import edu.textbook.StdDraw;

public class ColorContrast {
    
    public static void main(String[] args) {
        Color[] colors = {
            Color.BLACK,
            Color.WHITE,
            Color.BLUE,
            Color.GREEN,
            Color.YELLOW,
            Color.DARK_GRAY
        };

        StdDraw.setCanvasSize(800, 800);
        StdDraw.setXscale(0, colors.length);
        StdDraw.setYscale(0, colors.length);

        StdDraw.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));

        for (int r = 0; r < colors.length; r++) {
            for (int c = 0; c < colors.length; c++) {

                // Draw the inner square (row = background color)
                StdDraw.setPenColor(colors[r]);
                StdDraw.filledSquare(c + 0.5, r + 0.5, 0.5);

                // Draw the text (column = foreground color)
                StdDraw.setPenColor(colors[c]);
                StdDraw.text(c + 0.5, r + 0.5, "TEST");

                // Draw a black border
                StdDraw.setPenColor(Color.black);
                StdDraw.square(c + 0.5, r + 0.5, 0.5);
            }
        }
    }
}
