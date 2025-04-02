package estebangmz666.queues;

public class Biqueue<T> {
    private static class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node<T> front, rear;
    private int size;

    public Biqueue() {
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
            newNode.prev = rear;
            rear = newNode;
        }
        size++;
        return true;
    }

    public void enqueueFront(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("La biqueue está vacía.");
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        } else {
            front.prev = null;
        }
        size--;
        return data;
    }

    public T dequeueRear() {
        if (isEmpty()) {
            throw new RuntimeException("La biqueue está vacía.");
        }
        T data = rear.data;
        rear = rear.prev;
        if (rear == null) {
            front = null;
        } else {
            rear.next = null;
        }
        size--;
        return data;
    }

    public T peekFront() {
        if (isEmpty()) {
            throw new RuntimeException("La biqueue está vacía.");
        }
        return front.data;
    }

    public T peekRear() {
        if (isEmpty()) {
            throw new RuntimeException("La biqueue está vacía.");
        }
        return rear.data;
    }

    public int size() {
        return size;
    }
}