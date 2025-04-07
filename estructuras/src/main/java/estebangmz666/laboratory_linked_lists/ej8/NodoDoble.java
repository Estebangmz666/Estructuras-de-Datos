package estebangmz666.laboratory_linked_lists.ej8;

public class NodoDoble<T> {
    private T data;
    private NodoDoble<T> next;
    private NodoDoble<T> prev;

    public NodoDoble(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public T getData() {
        return data;
    }

    public NodoDoble<T> getNext() {
        return next;
    }

    public void setNext(NodoDoble<T> next) {
        this.next = next;
    }

    public NodoDoble<T> getPrev() {
        return prev;
    }

    public void setPrev(NodoDoble<T> prev) {
        this.prev = prev;
    }
}

