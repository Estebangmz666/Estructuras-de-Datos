package estebangmz666.laboratory_linked_lists.ej5;

public class Main {
    public static void main(String[] args) {
        ListaSimple<String> lista = new ListaSimple<>();
        lista.insertar("gato");
        lista.insertar("perro");
        lista.insertar("gato");
        lista.insertar("pez");
        lista.insertar("gato");

        String valor = "gato";
        int repeticiones = lista.contarRepeticiones(valor);

        System.out.println("El valor '" + valor + "' se repite " + repeticiones + " veces.");
    }
}

