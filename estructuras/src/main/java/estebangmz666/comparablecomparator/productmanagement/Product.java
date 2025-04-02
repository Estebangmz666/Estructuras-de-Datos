package estebangmz666.comparablecomparator.productmanagement;

import java.util.UUID;

public class Product implements Comparable<Product> {
    
    private UUID code;
    private String name;
    private float price;

    public Product(String name, float price) {
        this.code = UUID.randomUUID();
        this.name = name;
        this.price = price;
    }

    public UUID getCode() {
        return code;
    }

    public void setCode(UUID code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public int compareTo(Product o) {
        return Float.compare(this.price, o.price);
    }
}