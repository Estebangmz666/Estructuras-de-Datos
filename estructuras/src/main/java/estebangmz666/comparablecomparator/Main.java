package estebangmz666.comparablecomparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Estudiante> lista = new ArrayList<>();
        lista.add(new Estudiante("Esteban", 22));
        lista.add(new Estudiante("Robinson", 19));
        lista.add(new Estudiante("Jacobo", 25));

        // Ordenar usando Comparable (por edad)
        Collections.sort(lista);
        System.out.println(lista);

        // Ordenar usando Comparator (por nombre)
        lista.sort(new ComparadorPorNombre());
        System.out.println(lista);

        //Tambien se puede usar con lambda
        lista.sort((e1, e2) -> e1.getNombre().compareTo(e2.getNombre()));
        System.out.println(lista);
    }
}
