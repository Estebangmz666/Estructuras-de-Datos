package estebangmz666.preparcial_2.ej2;

public class LinkedList {

    public static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }  

    private Node head;
    private Node tail;
    
    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public Node getHead() {
        return head;
    }
}