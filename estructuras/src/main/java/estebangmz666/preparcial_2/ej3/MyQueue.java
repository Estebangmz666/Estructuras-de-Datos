package estebangmz666.preparcial_2.ej3;

public class MyQueue {
    private static class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (rear != null) {
            rear.next = newNode;
        } else {
            front = newNode;
        }
        rear = newNode;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        int value = front.value;
        front = front.next;
        if (front == null) rear = null;
        size--;
        return value;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }

    public int peek() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        return front.value;
    }
}