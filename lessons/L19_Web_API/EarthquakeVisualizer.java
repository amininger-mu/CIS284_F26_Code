import java.util.Scanner;
import java.awt.Color;
import java.io.File;

import edu.textbook.StdDraw;

import org.json.JSONObject;
import org.json.JSONArray;

public class EarthquakeVisualizer {

    public static record Event(double latitude, double longitude, double magnitude) { }

    // USGS Earthquake API endpoint for recent earthquakes
    private static final String API_URL = 
        //  "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_hour.geojson";   // past 60 minutes
        "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_day.geojson"; // past 24 hours

    
    public static void main(String[] args) throws Exception {
        System.out.println("Fetching: " + API_URL);
        String response;
        try {
            response = FetchData.fetch(API_URL);
        } catch (Exception e) {
            System.err.println(e);
            return;
        }

        Event[] events = parseEarthquakeData(response);
        displayEarthquakes(events);
    }


    /** 
     *   Takes a String that is a json response from the API
     *    and extracts/returns an array of events
     ***/
    private static Event[] parseEarthquakeData(String response) {
        JSONObject data = new JSONObject(response);

        // features = array of earthquake incidences
        JSONArray features = data.getJSONArray("features");

        Event[] events = new Event[features.length()];
        
        for (int i = 0; i < features.length(); i++) {
            JSONObject feature = features.getJSONObject(i);
            JSONObject properties = feature.getJSONObject("properties");
            JSONArray coordinates = feature.getJSONObject("geometry").getJSONArray("coordinates");
            
            // Extract data
            double magnitude = properties.getDouble("mag"); // 
            double longitude = coordinates.getDouble(0);  // from -180 to 180
            double latitude = coordinates.getDouble(1);  // from -90 to 90

            if (magnitude > 5) {
                System.out.printf("Mag %.1f at %.3f,%.3f\n", magnitude, longitude, latitude);
            }

            events[i] = new Event(latitude, longitude, magnitude);
        }
        return events;
    }

	 /*** Draws the earthquake data on a 2D map ***/
    public static void displayEarthquakes(Event[] events) {
        // Setup Canvas
        StdDraw.setCanvasSize(1200, 600);
        StdDraw.setXscale(-180, 180);
        StdDraw.setYscale(-90, 90);
        StdDraw.setPenRadius(0.004);

        // Draw background
        StdDraw.picture(0, 0, "earth.jpg", 360, 180);
        
        for (int i = 0; i < events.length; i++) {
            Event event = events[i];
            // event.magnitude: 0-10
            // event.longitude: -180 to 180
            // event.latitude: -90 to 90

            double radius = Math.pow(1.5, event.magnitude);

            // Draw solid outline
            StdDraw.setPenColor(Color.red);
            StdDraw.circle(event.longitude, event.latitude, radius);

            // Draw transparent inside
            StdDraw.setPenColor(new Color(255, 0, 0, 100));
            StdDraw.filledCircle(event.longitude, event.latitude, radius);
        }
    }
}
