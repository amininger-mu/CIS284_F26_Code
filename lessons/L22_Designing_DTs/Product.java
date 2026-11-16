import java.lang.IllegalArgumentException;

public class Product {
    private final String name;
    private final int price;
    private int quantity;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }

    // get the product name
    public String name() {
        return name;
    }

    // get the unit price (cents)
    public int price() {
        return price;
    }

    // get the number available
    public int quantity() {
        return quantity;
    }

    // adds n units to the quantity
    public void addStock(int n) {
        quantity += n;
    }

    // removes n units from the product
    void removeStock(int n) {
        quantity -= n;
    }
}