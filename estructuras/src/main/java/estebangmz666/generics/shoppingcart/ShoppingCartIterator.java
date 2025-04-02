package estebangmz666.generics.shoppingcart;

import java.util.Iterator;
import java.util.List;

public class ShoppingCartIterator<T> implements Iterator<T> {

    private int index = 0;
    private List<T> items;

    public ShoppingCartIterator(List<T> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return index < items.size();
    }

    @Override
    public T next() {
        if (index >= items.size()) {
            throw new IndexOutOfBoundsException("No hay más elementos en el carrito.");
        }
        return items.get(index++);
    }
}