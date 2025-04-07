package estebangmz666.laboratory_linked_lists.ej10;

public class Main {
    public static void main(String[] args) {
        ListaSimple<String> lista1 = new ListaSimple<>();
        lista1.insertar("A");
        lista1.insertar("B");

        ListaSimple<String> lista2 = new ListaSimple<>();
        lista2.insertar("C");
        lista2.insertar("D");

        ListaSimple<String> concatenada = ListaSimple.concatenar(lista1, lista2);

        System.out.println("Lista concatenada:");
        concatenada.imprimir();
    }
}

