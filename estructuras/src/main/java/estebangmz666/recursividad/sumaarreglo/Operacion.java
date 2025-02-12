package estebangmz666.recursividad.sumaarreglo;

public class Operacion {
    public static int sumarArregloRecursivamente(int[] arreglo) {
        if (arreglo.length == 1) {
            return arreglo[0];
        } else {
            int[] arregloIzquierda = new int[arreglo.length / 2];
            int[] arregloDerecha = new int[arreglo.length - arregloIzquierda.length];
            System.arraycopy(arreglo, 0, arregloIzquierda, 0, arregloIzquierda.length);
            System.arraycopy(arreglo, arregloIzquierda.length, arregloDerecha, 0, arregloDerecha.length);
            return sumarArregloRecursivamente(arregloIzquierda) + sumarArregloRecursivamente(arregloDerecha);
        }
    }
}