/*********************************************
 * class: StatsProgram
 * depends on: DataSet.java
 *
 * Main Program: java StatsProgram
 *
 * This will start a command loop where the user can
 *   do statistical operations on a data set
 * 
 * Including loading/saving data, adding/removing values, 
 *   and computing stats like min, max, mean, sum, variance
 * *******************************************/

import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class StatsProgram {

    // INSTANCE VARIABLES
    private Scanner scanner;  // a Scanner that reads from standard in
    private DataSet dataset;  // A reference to the data set

    public StatsProgram() {
        dataset = new DataSet();
        scanner = new Scanner(System.in);
    }

    public void commandLoop() {
        while(true) {
            System.out.print("\nEnter a command: ");
            String command = scanner.next().toLowerCase();

            if (command.equals("help")) {
                System.out.println("The valid commands are:\n  help, quit, print, add, remove, save, load");
                System.out.println("The valid stat cmds are:\n  min, max, sum, mean, var, stddev");

            } else if (command.equals("quit")) {
                return;

            } else if (command.equals("load")) {
                loadCommand();

            } else if (command.equals("save")) {
                saveCommand();

            } else if (command.equals("add")) {
                addCommand();

            } else if (command.equals("remove")) {
                removeCommand();

            } else if (command.equals("print")) {
                printData();

            } else if (command.equals("max")) {
                System.out.printf("The maximum value is = %.3f\n", dataset.max());

            } else if (command.equals("min")) {
                System.out.printf("The minimum value is = %.3f\n", dataset.min());

            } else if (command.equals("sum")) {
                System.out.printf("The sum of values = %.3f\n", dataset.sum());

            } else if (command.equals("mean")) {
                System.out.printf("The mean of the numbers = %.3f\n", dataset.mean());

            } else if (command.equals("var")) {
                System.out.printf("The sample variance of the numbers = %.3f\n", dataset.var());

            } else if (command.equals("stddev")) {
                double stddev = Math.sqrt(dataset.var());
                System.out.printf("The sample standard deviation of the numbers = %.3f\n", stddev);

            } else {
                System.out.println("Invalid command " + command + "\nEnter 'help' for a list of commands");
            }
        }
    }

    /**
     * Prints the given dataset in a table of 5 columns
     *   to 3 digits of precision
     **/
    private void printData() {
        for (int i = 0; i < dataset.size(); i++) {
            System.out.printf(" %10.3f", dataset.get(i));
            if (i % 5 == 4) {
                System.out.println();
            }
        }
        System.out.println();
    }

    /** 
     * Asks the user to enter a filename, 
     *   then writes the given array of numbers to that file
     */
    private void saveCommand() {
        System.out.print("Enter the file to write: ");
        String filename = scanner.next();
        File file = new File(filename);

        dataset.save(file);
        System.out.printf("Saved %d numbers to file %s\n", dataset.size(), file);
    }

    /** 
     * Asks the user to enter a filename, 
     *   then reads the file and returns an array of numbers read from the file
     */
    private void loadCommand() {
        System.out.print("Enter the file to load: ");
        String filename = scanner.next();
        File file = new File(filename);
        dataset.load(file);
    }

    /***
     * Asks the user for a value,
     *   then returns a new array with the value appended to the end
     **/
    private void addCommand() {
        System.out.print("Enter the number to add: ");
        double n = scanner.nextDouble();
        dataset.add(n);
    }

    /***
     * Prints out each value in the array with its index,
     *   then asks the user to enter an index
     *   and returns a new array with that position removed
     **/
    private void removeCommand() {
        for (int i = 0; i < dataset.size(); i++) {
            System.out.printf("%3d | %.3f\n", i, dataset.get(i));
        }
        System.out.print("Enter the index to remove: ");
        int index = scanner.nextInt();
        dataset.remove(index);
    }


    public static void main(String[] args) {
        StatsProgram program = new StatsProgram();
        program.commandLoop();
        System.out.println("Goodbye!");
    }
}
