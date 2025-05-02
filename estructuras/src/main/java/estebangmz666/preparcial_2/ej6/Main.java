package estebangmz666.preparcial_2.ej6;

public class Main {
    public static void main(String[] args) {
        Stack p = new Stack();
        p.push(5);
        p.push(3);
        p.push(5);
        p.push(2);
        p.push(3);
    
        System.out.println("Before:");
        p.print();
    
        Stack.removeDuplicates(p);
    
        System.out.println("\nAfter:");
        p.print();
    }    
}