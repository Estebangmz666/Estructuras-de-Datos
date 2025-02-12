package estebangmz666.divideyvenceras;

public class BusquedaBinaria {
    public static void main(String[] args) {
        int [] arreglo = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int numeroABuscar = 5;
        System.out.println("El número" + numeroABuscar +  "se encuentra en la posición: " + Operacion.busquedaBinaria(arreglo, numeroABuscar));
    }
}