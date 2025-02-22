package estebangmz666.comparablecomparator.gestiondeproductos;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.setProperty("file.encoding", "UTF-8");
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Laptop", 1000));
        productos.add(new Producto("Mouse", 20));
        productos.add(new Producto("Teclado", 50));
        productos.add(new Producto("Monitor", 300));
        productos.add(new Producto("Audífonos", 100));

        // Ordenar por precio (Comparable)
        Collections.sort(productos);
        System.out.println("[INFO] Productos ordenados por precio:");
        for (Producto p : productos) {
            System.out.println(p.getNombre() + " - $" + p.getPrecio());
        }

        // Ordenar por nombre (Comparator)
        productos.sort(new ComparadorPorNombre());
        System.out.println("\n[INFO] Productos ordenados por nombre:");
        for (Producto p : productos) {
            System.out.println(p.getNombre() + " - $" + p.getPrecio());
        }
    }
}