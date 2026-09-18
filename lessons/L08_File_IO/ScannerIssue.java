import java.util.Scanner;

public class ScannerIssue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

		System.out.print("What is your age? ");
		int age = scanner.nextInt();

		System.out.print("What is your name? "); 
		String name = scanner.nextLine();

		System.out.println("Age: " + age);
		System.out.println("Name: " + name);

        scanner.close();
    }
}