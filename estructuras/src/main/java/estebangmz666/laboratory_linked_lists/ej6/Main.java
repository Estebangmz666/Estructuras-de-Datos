package estebangmz666.laboratory_linked_lists.ej6;

public class Main {
    public static void main(String[] args) {
        ListaDoble<String> lista = new ListaDoble<>();
        lista.insertar("uno");
        lista.insertar("dos");
        lista.insertar("tres");

        System.out.println("Impresión hacia atrás:");
        lista.imprimirHaciaAtras();
    }
}

