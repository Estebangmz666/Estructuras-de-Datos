package estebangmz666.generics.carritodecompras;

import java.util.Iterator;
import java.util.List;

public class CarritoIterator<T> implements Iterator<T>{

    int index = 0;
    List<T> items;

    public CarritoIterator(List<T> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        if (index < items.size()) {
            return true;
        }
        return false;
    }

    @Override
    public T next() {
        int indice = index;
        if(indice < items.size()){
            throw new IndexOutOfBoundsException("Pato");
        }
        items.get(index);
        index += 2;
        return null;
    }

}