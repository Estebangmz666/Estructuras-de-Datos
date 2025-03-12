package estebangmz666.generics.carritodecompras;

import java.util.UUID;

public class Producto implements Comparable<Producto> {
    private String nombre;
    private double precio;
    private UUID codigo;

    public Producto(String nombre, double precio, UUID codigo) {
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return nombre + " - $" + precio + " - " + codigo;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public int compareTo(Producto o) {
        return Double.compare(precio, o.precio);
    }
}