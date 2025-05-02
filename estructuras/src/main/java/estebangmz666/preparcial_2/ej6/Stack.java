package estebangmz666.preparcial_2.ej6;

public class Stack {
    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node top;

    public void push(int value) {
        Node node = new Node(value);
        node.next = top;
        top = node;
    }

    public int pop() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        int val = top.value;
        top = top.next;
        return val;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void print() {
        Node current = top;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public static void removeDuplicates(Stack p) {
        Stack aux = new Stack();
        Stack temp = new Stack();
    
        while (!p.isEmpty()) {
            int current = p.pop();
            boolean isDuplicate = false;
    
            while (!aux.isEmpty()) {
                int topAux = aux.pop();
                if (topAux == current) isDuplicate = true;
                temp.push(topAux);
            }
    
            while (!temp.isEmpty()) {
                aux.push(temp.pop());
            }
    
            if (!isDuplicate) {
                aux.push(current);
            }
        }
    
        while (!aux.isEmpty()) {
            temp.push(aux.pop());
        }
    
        while (!temp.isEmpty()) {
            p.push(temp.pop());
        }
    }    
}