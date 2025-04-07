package estebangmz666.laboratory_linked_lists.ej10;

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

    public static <T> ListaSimple<T> concatenar(ListaSimple<T> lista1, ListaSimple<T> lista2) {
        ListaSimple<T> resultado = new ListaSimple<>();

        Node<T> actual = lista1.head;
        while (actual != null) {
            resultado.insertar(actual.getData());
            actual = actual.getNext();
        }

        actual = lista2.head;
        while (actual != null) {
            resultado.insertar(actual.getData());
            actual = actual.getNext();
        }

        return resultado;
    }

    public void imprimir() {
        Node<T> actual = head;
        while (actual != null) {
            System.out.println(actual.getData());
            actual = actual.getNext();
        }
    }
}

