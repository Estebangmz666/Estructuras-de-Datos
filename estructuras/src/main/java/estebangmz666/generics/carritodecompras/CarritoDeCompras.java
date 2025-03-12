package estebangmz666.generics.carritodecompras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

class CarritoDeCompras<T extends Comparable<T>> implements Iterable<T>{
    private List<T> items;

    public CarritoDeCompras() {
        this.items = new ArrayList<>();
    }

    public void agregarProducto(T item) {
        items.add(item);
    }

    public void eliminarProducto(T item) {
        items.remove(item);
    }

    public List<T> obtenerProductos() {
        return items;
    }

    public void mostrarProductos() {
        if (items.isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            System.out.println("Productos en el carrito:");
            for (T item : items) {
                System.out.println(item);
            }
        }
    }

    public T obtenerProductoMasCaro() {
        //return items.stream().max(Comparator.naturalOrder()).orElse(null);
        return items.isEmpty() ? null : Collections.max(items);
    }

    public Double obtenerTotal(Function<T, Double> precioExtractor) {
        return items.stream().mapToDouble(precioExtractor::apply).sum();
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Iterator<T> iterator() {
        return new CarritoIterator(items);
    }
}