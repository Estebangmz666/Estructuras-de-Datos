package estebangmz666.laboratory_linked_lists.ej7;

import java.util.Iterator;

public class IteradorListaDoble<T> implements Iterator<T> {
    private NodoDoble<T> actual;

    public IteradorListaDoble(NodoDoble<T> inicio) {
        this.actual = inicio;
    }

    @Override
    public boolean hasNext() {
        return actual != null;
    }

    @Override
    public T next() {
        T valor = actual.getData();
        actual = actual.getNext();
        return valor;
    }
}

