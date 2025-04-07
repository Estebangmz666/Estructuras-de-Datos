package estebangmz666.laboratory_linked_lists.ej8;

public class Main {
    public static void main(String[] args) {
        ListaDoble<Persona> lista = new ListaDoble<>();

        lista.insertar(new Persona("Ana", 123456));
        lista.insertar(new Persona("Luis", 987653));
        lista.insertar(new Persona("Carlos", 202023));
        lista.insertar(new Persona("Marta", 135798));

        System.out.println("Personas con cédula par:");
        lista.obtenerCedulasPares();
    }
}

