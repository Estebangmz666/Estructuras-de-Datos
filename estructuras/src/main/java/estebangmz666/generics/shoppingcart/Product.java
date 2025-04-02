package estebangmz666.generics.shoppingcart;

import java.util.UUID;

public class Product implements Comparable<Product> {
    private String name;
    private double price;
    private UUID code;

    public Product(String name, double price, UUID code) {
        this.name = name;
        this.price = price;
        this.code = code;
    }

    @Override
    public String toString() {
        return name + " - $" + price + " - " + code;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Product other) {
        return Double.compare(price, other.price);
    }
}