import org.json.JSONObject;
import edu.textbook.StdDraw;
public class SpaceStation {

    public static void main(String[] args) {
        String url = "http://api.open-notify.org/iss-now.json";

        System.out.println("Fetching: " + url);
        String response;
        try {
            response = FetchData.fetch(url);
        } catch (Exception e) {
            System.err.println(e);
            return;
        }

        JSONObject data = new JSONObject(response);
        JSONObject pos = data.getJSONObject("iss_position");
        double latitude = pos.getDouble("latitude");
        double longitide = pos.getDouble("longitude");

        System.out.println(latitude + "/" + longitide);
        drawISS(latitude, longitide);
    }


	 /*** Draws the earthquake data on a 2D map ***/
    public static void drawISS(double latitude, double longitide) {
        // Setup Canvas
        StdDraw.setCanvasSize(1200, 600);
        StdDraw.setXscale(-180, 180);
        StdDraw.setYscale(-90, 90);
        StdDraw.setPenRadius(0.004);

        // Draw background
        StdDraw.picture(0, 0, "earth.jpg", 360, 180);

        // Draw ISS
        StdDraw.picture(longitide, latitude, "iss.png", 20, 20);
    }
}
