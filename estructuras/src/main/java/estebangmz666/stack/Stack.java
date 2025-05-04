package estebangmz666.stack;

public class Stack<T> {
    private Node<T> topNode;
    private int size;

    private static class Node<T> {
        private Node<T> next;
        private T value;

        public Node(T value) {
            this.value = value;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getNext() {
            return next;
        }

        public T getValue() {
            return value;
        }
    }

    public Stack() {
        this.topNode = null;
        this.size = 0;
    }

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        if (topNode == null) {
            topNode = newNode;
        } else {
            newNode.setNext(topNode);
            topNode = newNode;
        }
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        Node<T> nodeToRemove = topNode;
        topNode = topNode.getNext();
        nodeToRemove.setNext(null);
        size--;
        return nodeToRemove.getValue();
    }    

    public T peek() {
        if (topNode == null) {
            return null;
        }
        return topNode.getValue();
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return topNode == null;
    }

    public boolean contains(T value) {
        Node<T> current = topNode;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> currentNode = topNode;
        while (currentNode != null) {
            sb.append(currentNode.getValue()).append(" -> ");
            currentNode = currentNode.getNext();
        }
        sb.append("null");
        return sb.toString();
    }
}