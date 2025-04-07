package estebangmz666.laboratory_linked_lists.ej9;

public class ListaCircular<T> {
    private Node<T> head;

    public void insertar(T data) {
        Node<T> nuevo = new Node<>(data);
        if (head == null) {
            head = nuevo;
            head.setNext(head); // apunto a sí mismo
        } else {
            Node<T> actual = head;
            while (actual.getNext() != head) {
                actual = actual.getNext();
            }
            actual.setNext(nuevo);
            nuevo.setNext(head); // cierro el ciclo
        }
    }

    public boolean buscar(T valor) {
        if (head == null) return false;

        Node<T> actual = head;
        do {
            if (actual.getData().equals(valor)) {
                return true;
            }
            actual = actual.getNext();
        } while (actual != head);

        return false;
    }

    // Opcional: imprimir para verificar
    public void imprimir() {
        if (head == null) return;

        Node<T> actual = head;
        do {
            System.out.println(actual.getData());
            actual = actual.getNext();
        } while (actual != head);
    }
}

