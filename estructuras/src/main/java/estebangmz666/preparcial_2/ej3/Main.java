package estebangmz666.preparcial_2.ej3;

public class Main {
    public static void main(String[] args) {
        Pila2Colas stack = new Pila2Colas();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop()); // 30
        System.out.println(stack.pop()); // 20
        stack.push(40);
        System.out.println(stack.top()); // 40
    }
}