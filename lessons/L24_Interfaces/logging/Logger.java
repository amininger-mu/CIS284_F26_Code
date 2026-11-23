import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface Logger {
    void open();
    void log(String message);
    void close();

    // Adds a time header to the message
    public static String addHeader(String msg) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        return String.format("[%s] %s", timestamp, msg);
    }
}
