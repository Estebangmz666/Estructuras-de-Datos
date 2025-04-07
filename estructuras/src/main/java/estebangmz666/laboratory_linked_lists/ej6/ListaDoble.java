package estebangmz666.laboratory_linked_lists.ej6;

public class ListaDoble<T> {
    private NodoDoble<T> head;
    private NodoDoble<T> tail;

    public void insertar(T data) {
        NodoDoble<T> nuevo = new NodoDoble<>(data);
        if (head == null) {
            head = tail = nuevo;
        } else {
            tail.setNext(nuevo);
            nuevo.setPrev(tail);
            tail = nuevo;
        }
    }

    public void imprimirHaciaAtras() {
        NodoDoble<T> actual = tail;
        while (actual != null) {
            System.out.println(actual.getData());
            actual = actual.getPrev();
        }
    }

    // Para usar luego con el iterador
    public NodoDoble<T> getHead() {
        return head;
    }
}

