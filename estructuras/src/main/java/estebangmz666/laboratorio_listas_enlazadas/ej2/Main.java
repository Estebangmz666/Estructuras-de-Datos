package estebangmz666.laboratorio_listas_enlazadas.ej2;

public class Main {
    public static void main(String[] args) {
        ListaEnlazadaSimple<Persona> lista = new ListaEnlazadaSimple<>();
        lista.agregarAlInicio(new Persona("Juan", "123456789"));
        lista.agregarAlInicio(new Persona("Maria", "987654321"));
        lista.agregarAlInicio(new Persona("Pedro", "456789123"));
        lista.agregarAlFinal(new Persona("Ana", "321654987"));
        lista.agregarAlFinal(new Persona("Luis", "65432178")); // Cédula con longitud par
        lista.agregarAlFinal(new Persona("Sofia", "78912345")); // Cédula con longitud par

        System.out.println("Lista original: " + lista);
        ListaEnlazadaSimple<Persona> resultado = lista.obtenerPersonasConCedulaPar();
        System.out.println("Personas con cédula de longitud par: " + resultado);
    }
}