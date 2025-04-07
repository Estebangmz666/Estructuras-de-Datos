package estebangmz666.laboratory_linked_lists.ej8;

public class Persona {
    private String nombre;
    private int cedula;

    public Persona(String nombre, int cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCedula() {
        return cedula;
    }

    @Override
    public String toString() {
        return nombre + " - Cédula: " + cedula;
    }
}

