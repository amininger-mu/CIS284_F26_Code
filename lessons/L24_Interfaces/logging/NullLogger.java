
// Do nothing (ignore log messages)
public class NullLogger implements Logger {
    public void open() { }
    public void log(String message) { } 
    public void close() { }
}
