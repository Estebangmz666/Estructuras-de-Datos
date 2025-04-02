package estebangmz666.laboratorio_listas_enlazadas.ej1;

public class Main {
    public static void main(String[] args) {
    ListaEnlazadaSimple<Integer> lista = new ListaEnlazadaSimple<>();
    lista.agregarAlInicio(1);
    lista.agregarAlInicio(2);
    lista.agregarAlInicio(3);
    lista.agregarAlFinal(4);
    lista.agregarAlFinal(5);
    lista.agregarAlFinal(6);
    ListaEnlazadaSimple<Integer> impares = lista.obtenerPosicionesImpares();
    System.out.println(impares);   
    }
}