/*****************************************
 * Logs all message to a file
 *****************************************/
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger implements Logger {
    private File file;
    private PrintWriter writer;

    public FileLogger(File file) {
        this.file = file;
        this.writer = null;
    }

    // open: open the file
    public void open() { 
        if (writer != null) return;

        try {
            writer = new PrintWriter(file);
        } catch (IOException e) {
            System.err.println("Error opening log file " + file);
            System.err.println(e);
            writer = null;
        }
    } 

    // log: write to the file
    public void log(String message) {
        if (writer != null) {
            writer.println(Logger.addHeader(message));
            writer.flush(); // makes sure the message is written immediately
        }
    }

    // close: close the writer
    public void close() { 
        writer.close();
        writer = null;
    }
}
