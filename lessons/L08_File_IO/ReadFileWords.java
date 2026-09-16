import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFileWords {
    public static void main(String[] args) {
        String filename = args[0];

        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)) {

            while(scanner.hasNext()) {
                String word = scanner.next();

                // Do something with word

                System.out.println(word);
            }

        } catch (FileNotFoundException e) {
            System.err.println("File " + filename + " does not exist");
            return;
        }
    } 
}
