package estebangmz666.preparcial_1.ej3;

import java.util.Collections;
import java.util.List;

/*Implementar un método genérico que reciba una lista de elementos comparables y devuelva el máximo elemento en dicha lista. Usa la interfaz Comparable<T> para asegurar que los elementos puedan ser comparados(no usar ciclos ni recursividad) */

public class ComparableList {
    public static <T extends Comparable<T>> T findMax (List<T> list){
        return list.isEmpty() ? null : Collections.max(list);
    }
}