import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordCountHist {

	public static void main(String[] args) {
		String filename = args[0];
		int MAX_LENGTH = 20;
		Histogram histogram = new Histogram(MAX_LENGTH);

		try (Scanner scanner = new Scanner(new File(filename))) {

			while (scanner.hasNext()) {
				String word = scanner.next();
				word = word.replaceAll("[^a-zA-Z]", "");

				if (word.length() < MAX_LENGTH) {
					histogram.addDataPoint(word.length());
				}
			}

		} catch (FileNotFoundException e) {
			System.err.println("Error opening file " + filename);
			System.err.println(e);
		}

		histogram.draw();
	}

}
