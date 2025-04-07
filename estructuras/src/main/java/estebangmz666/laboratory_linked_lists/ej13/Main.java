package estebangmz666.laboratory_linked_lists.ej13;

public class Main {
    public static void main(String[] args) {
        Lista list = new Lista();
        list.insertar(4);
        list.insertar(5);
        list.insertar(4);
        list.insertar(8);
        list.insertar(6);
        list.insertar(3);
        list.insertar(4);
        list.insertar(9);

        int clave = 4;
        int result = list.maximaDistancia(clave);
        System.out.println("Max distance for key " + clave + " is: " + result);
    }
}