package estebangmz666.laboratory_linked_lists.ej5;

public class ListaSimple<T> {
    private Node<T> head;

    public void insertar(T data) {
        Node<T> nuevo = new Node<>(data);
        if (head == null) {
            head = nuevo;
        } else {
            Node<T> actual = head;
            while (actual.getNext() != null) {
                actual = actual.getNext();
            }
            actual.setNext(nuevo);
        }
    }

    public int contarRepeticiones(T valor) {
        int contador = 0;
        Node<T> actual = head;
        while (actual != null) {
            if (actual.getData().equals(valor)) {
                contador++;
            }
            actual = actual.getNext();
        }
        return contador;
    }

    // Lo usamos luego para imprimir y probar
    public Node<T> getHead() {
        return head;
    }
}

