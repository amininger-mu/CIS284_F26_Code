import org.json.JSONObject;

public class StockQuote {

    public static String API_KEY = "";

    public static void main(String[] args) {
        String symbol = args[0].toUpperCase();
        String site = "https://finnhub.io/api/v1/quote";
        String url = String.format("%s?symbol=%s&token=%s", site, symbol, API_KEY);

        System.out.println("Fetching: " + url);
        String response;
        try {
            response = FetchData.fetch(url);
        } catch (Exception e) {
            System.err.println(e);
            return;
        }

        JSONObject data = new JSONObject(response);
        double price = data.getDouble("c");
        System.out.printf("The price of %s is currently $%.2f\n", symbol, price);
    }
}
