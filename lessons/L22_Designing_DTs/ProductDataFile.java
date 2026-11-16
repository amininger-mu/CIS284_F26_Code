import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ProductDataFile {

    // Reads the given file and returns an array of products
    public static Product[] read(File file) throws IOException {
        try (Scanner reader = new Scanner(file)) {

            int capacity = reader.nextInt();
            Product[] products = new Product[capacity];

            for (int i = 0; i < capacity; i++) {
                if (!reader.hasNextLine()) break;

                String line = reader.nextLine();
                // Split on comma
                String[] parts = line.split(",");

                // Looking for 3 parts
                if (parts.length < 3) continue;

                // name,price,quantity
                String name = parts[0];
                int price = Integer.parseInt(parts[1]);
                int quantity = Integer.parseInt(parts[2]);

                // Create the product
                products[i] = new Product(name, price);
                products[i].addStock(quantity);
            }
            return products;
        }
    }

    // Writes the given product array to a file
    public static void write(File file, Product[] products) throws IOException {
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println(products.length);
            for (int i = 0; i < products.length; i++) {
                Product product = products[i];
                if (product == null) {
                    writer.println("X");
                } else {
                    writer.printf("%s,%d,%d\n", product.name(), product.price(), product.quantity());
                }
            }
        }
    }
}
