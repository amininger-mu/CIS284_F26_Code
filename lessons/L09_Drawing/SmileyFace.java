import java.awt.Color;

public class SmileyFace {
    public static void main(String[] args) {

        // StdDraw.setXscale(-0.2, 1.2);
        // StdDraw.setYscale(0.0, 1.4);
        
        StdDraw.setPenColor(230, 230, 0);
        StdDraw.filledCircle(0.5, 0.5, 0.45);

        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(Color.black);
        StdDraw.circle(0.5, 0.5, 0.45);

        StdDraw.filledCircle(0.3, 0.7, 0.1);
        StdDraw.filledCircle(0.7, 0.7, 0.1);

        StdDraw.filledSquare(0.5, 0.5, 0.05);

        StdDraw.setPenColor(Color.blue);
        StdDraw.filledRectangle(0.5, 0.30, 0.25, 0.03);

        // StdDraw.setPenColor(Color.blue);
        // StdDraw.filledPolygon(new double[]{ 0.20, 0.8, 0.5 }, new double[]{ 0.85, 0.85, 1.35 });

    }
    
}
