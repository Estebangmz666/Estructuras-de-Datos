package estebangmz666.comparablecomparator;

public class Estudiante implements Comparable<Estudiante>{
    private String nombre;
    private Integer edad;

    public Estudiante(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public int compareTo(Estudiante otro) {
        return Integer.compare(this.edad, otro.edad);
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + " años)";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    
}