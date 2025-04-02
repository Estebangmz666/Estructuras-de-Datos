package estebangmz666.generics.shoppingcart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class ShoppingCart<T extends Comparable<T>> implements Iterable<T> {
    private List<T> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addProduct(T item) {
        items.add(item);
    }

    public void removeProduct(T item) {
        items.remove(item);
    }

    public List<T> getProducts() {
        return items;
    }

    public void showProducts() {
        if (items.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            System.out.println("Productos en el carrito:");
            for (T item : items) {
                System.out.println(item);
            }
        }
    }

    public T getMostExpensiveProduct() {
        return items.isEmpty() ? null : Collections.max(items);
    }

    public Double getTotal(Function<T, Double> priceExtractor) {
        return items.stream().mapToDouble(priceExtractor::apply).sum();
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Iterator<T> iterator() {
        return new ShoppingCartIterator(items);
    }
}