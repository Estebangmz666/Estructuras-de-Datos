package estebangmz666.laboratory_linked_lists.ej11;

public class Polynomial {
    private Node head;

    static class Node {
        double coefficient;
        int exponent;
        Node next;
    
        public Node(double coefficient, int exponent) {
            this.coefficient = coefficient;
            this.exponent = exponent;
            this.next = null;
        }
    }
    

    public void addTerm(double coef, int exp) {
        Node newNode = new Node(coef, exp);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public double evaluate(double x) {
        double result = 0.0;
        Node current = head;
        while (current != null) {
            result += current.coefficient * Math.pow(x, current.exponent);
            current = current.next;
        }
        return result;
    }

    public void printTable() {
        System.out.println(" x\t|\tP(x)");
        System.out.println("-------------------------");
        for (double x = 0.0; x <= 5.0; x += 0.5) {
            System.out.printf(" %.1f\t|\t%.4f%n", x, evaluate(x));
        }
    }
}