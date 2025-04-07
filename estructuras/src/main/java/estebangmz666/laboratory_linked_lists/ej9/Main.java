package estebangmz666.laboratory_linked_lists.ej9;

public class Main {
    public static void main(String[] args) {
        ListaCircular<String> lista = new ListaCircular<>();
        lista.insertar("Lunes");
        lista.insertar("Martes");
        lista.insertar("Miércoles");

        lista.imprimir();

        String buscar = "Martes";
        System.out.println("¿Existe '" + buscar + "'? " + lista.buscar(buscar));
    }
}

