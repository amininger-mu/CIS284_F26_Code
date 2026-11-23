/*****************************************
 * Logs all message to standard out
 *****************************************/
public class PrintLogger implements Logger {
    // open: nothing to do
    public void open() { } 

    // log: print to stdout
    public void log(String message) {
        System.out.println(Logger.addHeader(message));
    }

    // close: nothing to do
    public void close() { }
}
