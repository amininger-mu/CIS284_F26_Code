/******************************************************************************
 *  Compilation:  javac-introcs Scale.java
 *  Execution:    java-introcs Scale filename w h
 *  Data files:   https://introcs.cs.princeton.edu/java/31datatype/mandrill.jpg
 *
 *  Scales an image to w-by-h and displays both the original
 *  and the scaled version to the screen.
 *
 *  % java-introcs Scale mandrill.jpg 200 300
 *
 *
 ******************************************************************************/

import java.awt.Color;

import edu.textbook.Picture;

public class Scale {
    public static void main(String[] args) {
        String filename = args[0];
        int width  = Integer.parseInt(args[1]);
        int height = Integer.parseInt(args[2]);
        Picture source = new Picture(filename);
        Picture target = new Picture(width, height);

        for (int colT = 0; colT < width; colT++) {
            for (int colR = 0; colR < height; colR++) {
                int colS = colT * source.width()  / width;
                int rowS = colR * source.height() / height;
                Color color = source.get(colS, rowS);
                target.set(colT, colR, color);
            }
        }

        source.show();
        target.show();
    }
}
