package estebangmz666.divideyvenceras;

public class Operacion {
    public static int busquedaBinaria(int[] arreglo, int numeroABuscar) {
        return busquedaBinaria(arreglo, numeroABuscar, 0, arreglo.length - 1);
    }
        
    private static int busquedaBinaria(int[] arreglo, int numeroABuscar, int i, int j) {
        if (i > j) {
            return -1;
        }
        int mitad = (i + j) / 2;
        if (arreglo[mitad] == numeroABuscar) {
            return mitad;
        } else if (arreglo[mitad] < numeroABuscar) {
            return busquedaBinaria(arreglo, numeroABuscar, mitad + 1, j);
        } else {
            return busquedaBinaria(arreglo, numeroABuscar, i, mitad - 1);
        }
    }
}