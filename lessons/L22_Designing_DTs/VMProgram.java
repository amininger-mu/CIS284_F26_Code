import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class VMProgram {
    private static Scanner scanner;

    private static String dollars(int cents) {
        return String.format("$%d.%02d", cents/100, cents%100);
    }

    private static void printHelp() {
        System.out.println("Valid commands are:");
        System.out.println("  quit: exit program");
        System.out.println("  help: print help message");
        System.out.println("  list: print a list of all products");
        System.out.println("  add <cents>: add the given amount of money to the machine");
        System.out.println("  dispense <i>: dispense product i");
        System.out.println("  change: get back remaining balance");
    }
    
    private static void listProducts(VendingMachine vm) {
        System.out.printf("| %3s | %7s | %-15s |\n", "#", "Price", "Name");
        for (int i = 0; i < vm.capacity(); i++) {
            Product p = vm.getProduct(i);
            if (p == null) {
                System.out.printf("| %3d | %7s | %-15s |\n", i+1, "", "---");
            } else if (p.quantity() == 0) {
                System.out.printf("| %3d | %7s | %-15s |\n", i+1, "E", p.name());
            } else {
                System.out.printf("| %3d | %7s | %-15s |\n", i+1, dollars(p.price()), p.name());
            }
        }
    }

    private static void addMoney(VendingMachine vm) {
        System.out.print("How much (in cents): ");
        int amount = scanner.nextInt();
        vm.addMoney(amount);
    }

    private static void dispenseProduct(VendingMachine vm) {
        System.out.print("Which product? ");
        int i = scanner.nextInt() - 1;
        boolean result = vm.dispense(i);
        if (result) {
            System.out.println("You received 1 " + vm.getProduct(i).name());
        } else {
            System.out.println("Error dispensing product " + i);
        }
    }

    private static void dispenseChange(VendingMachine vm) {
        int change = vm.getChange();
        System.out.printf("You received %s in change\n", dollars(change));
    }


    private static void commandLoop(VendingMachine vm) {
        while (true) {
            System.out.println("Balance = " + dollars(vm.balance()));
            System.out.print("Command > ");
            String cmd = scanner.next().toLowerCase();
            if (cmd.equals("help")) {
                printHelp();
            } else if (cmd.equals("quit")) {
                return;
            } else if (cmd.equals("list")) {
                listProducts(vm);
            } else if (cmd.equals("add")) {
                addMoney(vm);
            } else if (cmd.equals("dispense")) {
                dispenseProduct(vm);
            } else if (cmd.equals("change")) {
                dispenseChange(vm);
            } else {
                System.out.println("Unrecognized Command: " + cmd);
                printHelp();
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        File productsFile = new File("products.csv");
        scanner = new Scanner(System.in);

        VendingMachine vm;
        try {
            vm = new VendingMachine(productsFile);
        } catch (Exception e) {
            System.err.println("Error initializing VendingMachine");
            System.err.println(e);
            return;
        }

        commandLoop(vm);
        scanner.close();
    }
}
