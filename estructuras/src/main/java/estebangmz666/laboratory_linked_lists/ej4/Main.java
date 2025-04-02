package estebangmz666.laboratory_linked_lists.ej4;

public class Main {
    public static void main(String[] args) {
        ListaEnlazadaSimple<Integer> lista = new ListaEnlazadaSimple<>();
        lista.agregarAlFinal(1);
        lista.agregarAlFinal(2);
        lista.agregarAlFinal(3);
        lista.agregarAlFinal(4);
        lista.agregarAlFinal(5);
        lista.agregarAlFinal(6);
    
        System.out.println("Lista original: " + lista);
        ListaEnlazadaSimple<Integer> listaImpares = lista.obtenerNumerosImpares();
        System.out.println("Lista con impares: " + listaImpares);
    }       
}