package estebangmz666.recursividad.sumaenteros;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("La suma es " + sumar(n));

        List<Integer> lista = new ArrayList<>();
        agregarNumeros(lista, n);
        System.out.println("Lista de números: " + lista);
    }

    public static int sumar(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + sumar(n - 1);
        }
    }

    public static void agregarNumeros(List<Integer> lista, int n) {
        if (n > 0) {
            agregarNumeros(lista, n - 1);
        }
        lista.add(n);
    }
}