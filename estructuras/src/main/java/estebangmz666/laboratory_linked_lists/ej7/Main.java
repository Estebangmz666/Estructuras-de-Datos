package estebangmz666.laboratory_linked_lists.ej7;

public class Main {
    public static void main(String[] args) {
        ListaDoble<String> lista = new ListaDoble<>();
        lista.insertar("uno");
        lista.insertar("dos");
        lista.insertar("tres");

        System.out.println("Usando iterador de lista doble:");
        IteradorListaDoble<String> iterador = new IteradorListaDoble<>(lista.getHead());
        while (iterador.hasNext()) {
            System.out.println(iterador.next());
        }
    }
}

