import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFileWords {
    public static void main(String[] args) {

        File file = new File("employees.csv");
        try (Scanner scanner = new Scanner(file)) {
            String heading = scanner.nextLine(); // Ignore first line

            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] parts = line.split(","); // split the line on commas
                if (parts.length < 3) continue;   // ignore lines without 3 parts

                String name = parts[0];
                String email = parts[1];
                long phone = Long.parseLong(parts[2]);

                System.out.printf("| %20s | %25s | %10d |\n", name, email, phone);
            }

        } catch (FileNotFoundException e) {
            System.err.println("File " + file + " does not exist");
            return;
        }
    } 
}
