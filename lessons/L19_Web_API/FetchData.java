import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FetchData {
    public static String fetch(String url) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        // Create and build the request (GET request using API_URL)
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .GET()
            .build();

        // Send the request and read response as String
        HttpResponse<String> response = client.send(request,
            HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new Exception("HTTP request failed with code: " + response.statusCode());
        }

        return response.body();
    }
}
