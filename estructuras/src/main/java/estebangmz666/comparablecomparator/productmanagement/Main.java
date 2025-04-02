package estebangmz666.comparablecomparator.productmanagement;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.setProperty("file.encoding", "UTF-8");
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 1000));
        products.add(new Product("Mouse", 20));
        products.add(new Product("Teclado", 50));
        products.add(new Product("Monitor", 300));
        products.add(new Product("Audífonos", 100));

        // Ordenar por precio (Comparable)
        Collections.sort(products);
        System.out.println("[INFO] Productos ordenados por precio:");
        for (Product p : products) {
            System.out.println(p.getName() + " - $" + p.getPrice());
        }

        // Ordenar por nombre (Comparator)
        products.sort(new NameComparator());
        System.out.println("\n[INFO] Productos ordenados por nombre:");
        for (Product p : products) {
            System.out.println(p.getName() + " - $" + p.getPrice());
        }
    }
}