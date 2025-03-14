package estebangmz666.preparcial_1.ej5;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*Implementar un método genérico que reciba una List de cualquier tipo y devuelva una lista invertida sin modificar la original, sin usar ciclos o recursividad. */

public class ListReverter {
    public static <E> List<E> revertList(List<E> list) {
        return list.stream()
                   .collect(Collectors.collectingAndThen(Collectors.toList(), l -> {Collections.reverse(l);
                    return l;}));
    }
}