package estebangmz666.cola;

public class Queue<T> {
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> front, rear;
    private int size;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(T data) {
        offer(data);
    }

    public boolean offer(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        return true;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("La cola está vacía.");
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("La cola está vacía.");
        }
        return front.data;
    }

    @Override
    public Queue<T> clone() {
        Queue<T> clonedQueue = new Queue<>();
        Node<T> current = front;
        while (current != null) {
            clonedQueue.enqueue(current.data);
            current = current.next;
        }
        return clonedQueue;
    }

    public int size() {
        return size;
    }
}