import java.util.Scanner;
public class Greeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");

        // Read 1 word -> name
        String name = scanner.next();
        System.out.println("Hello " + name);
        System.out.println("What is your age?");

        // Read 1 int -> age
        int age = scanner.nextInt();
        System.out.println("I see you are " + age);
    }
}