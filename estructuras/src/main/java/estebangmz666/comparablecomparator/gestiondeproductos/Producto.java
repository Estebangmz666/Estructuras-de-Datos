package estebangmz666.comparablecomparator.gestiondeproductos;

import java.util.UUID;

public class Producto implements Comparable<Producto> {
    
    private UUID codigo;
    private String nombre;
    private float precio;

    public Producto(String nombre, float precio) {
        this.codigo = UUID.randomUUID();
        this.nombre = nombre;
        this.precio = precio;
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public int compareTo(Producto o) {
        return Float.compare(this.precio, o.precio);
    }
}