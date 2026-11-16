import java.io.File;
import java.io.IOException;
    
public class VendingMachine {

    private final Product[] products;
    private final File dataFile;
    private int balance;

    // Creates machine and loads given data file
    public VendingMachine(File dataFile) throws IOException{
        this.dataFile = dataFile;
        this.products = ProductDataFile.read(dataFile);
        this.balance = 0;
    }

   
    // get number of product slots
    public int capacity() {
        return products.length;
    }

    // gets product at slot i (or null)
    public Product getProduct(int i) {
        return products[i];
    }

    // puts given product in slot i
    public void setProduct(int i, Product product) {
        products[i] = product;
    }

    // gets current amount of money in machine
    public int balance() {
        return balance;
    }

    // adds given amount of cents to balance
    public void addMoney(int cents) {
        balance += cents;
    }

    // dispenses 1 product in slot 1 (boolean if successful)
    public boolean dispense(int i) {
        Product product = products[i];
        if (product.quantity() == 0) {
            return false;
        }
        if (balance < product.price()) {
            return false;
        }
        balance -= product.price();
        product.removeStock(1);
        saveData();

        return true;
    }

    // clears remaining balance
    public int getChange() {
        int change = balance;
        balance = 0;
        return change;
    }

    private void saveData() {
        try {
            ProductDataFile.write(dataFile, products);
        } catch (Exception e) {
            System.err.println("Error saving data:");
            System.err.println(e);
        }
    }
}
