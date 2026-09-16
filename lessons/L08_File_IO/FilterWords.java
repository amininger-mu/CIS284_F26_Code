import java.util.Scanner;

/*** A CLI filter program that extracts all words from standard in,
 *     normalizes them (remove digits/punctuation and make lowercase)
 *     and prints them out 1 per line
 ***/

public class FilterWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase();

			// Delete all characters NOT a-z
			word = word.replaceAll("[^a-z]", ""); 

			if (word.length() == 0) continue;

			System.out.println(word);
        }

        scanner.close();
    } 
}
