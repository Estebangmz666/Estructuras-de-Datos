package estebangmz666.comparablecomparator.gestiondeproductos;

import java.util.Comparator;

public class ComparadorPorNombre implements Comparator<Producto> {
    
    @Override
    public int compare(Producto o1, Producto o2) {
        return o1.getNombre().compareTo(o2.getNombre());
    }
}