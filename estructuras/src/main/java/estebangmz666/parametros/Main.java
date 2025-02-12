package estebangmz666.parametros;

public class Main {
    public static void main(String[] args) {
        Estudiante est1 = new Estudiante("Robinson");
        cambiarNombre(est1);
        System.out.println(est1.getNombre());
    }
        
    private static void cambiarNombre(Estudiante estudiante) {
        Estudiante est3 = new Estudiante("laura");
        estudiante = est3;
        estudiante.setNombre("Maria");
    }
}