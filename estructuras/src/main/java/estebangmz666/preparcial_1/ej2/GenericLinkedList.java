package estebangmz666.preparcial_1.ej2;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*Implementar un método genérico que reciba dos listas de cualquier tipo(List) y devuelva una nueva LinkedList con la unión de ambas listas, eliminando los elementos duplicados. Usa las clases e interfaces de java.util.Collections(no se pueden usar ciclos,  ni recursividad).*/

public class GenericLinkedList {
    public static <T> LinkedList<T> mergeLists(List<T> list1, List<T> list2) {
        return Stream.concat(list1.stream(), list2.stream()).distinct().collect(Collectors.toCollection(LinkedList::new));
    }  
}