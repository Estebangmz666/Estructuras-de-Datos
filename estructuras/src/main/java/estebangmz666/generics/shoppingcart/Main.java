package estebangmz666.generics.shoppingcart;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        ShoppingCart<Product> cart = new ShoppingCart<>();
        
        Product p1 = new Product("Laptop", 3500.99, UUID.randomUUID());
        Product p2 = new Product("Mouse Gamer", 150.75, UUID.randomUUID());
        Product p3 = new Product("Teclado Mecánico", 200.00, UUID.randomUUID());
        Product p4 = new Product("Monitor 4K", 800.00, UUID.randomUUID());
        Product p5 = new Product("Producto absurdamente caro", 999999.99, UUID.randomUUID());

        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.addProduct(p3);
        cart.addProduct(p4);
        cart.addProduct(p5);

        cart.showProducts();

        System.out.println("Producto más caro:");
        System.out.println(cart.getMostExpensiveProduct());

        double total = cart.getTotal(Product::getPrice);
        System.out.println("Total: $" + total);
    }
}