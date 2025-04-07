package estebangmz666.laboratory_linked_lists.ej12;

public class LinkedList {
    private Node head;
    private int size;

    private static class Node {
        double data;
        Node next;

        public Node(double data) {
            this.data = data;
        }
    }

    public void add(double value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null)
                current = current.next;
            current.next = newNode;
        }
        size++;
    }

    public double mean() {
        if (size == 0) return 0;
        double sum = 0;
        Node current = head;
        while (current != null) {
            sum += current.data;
            current = current.next;
        }
        return sum / size;
    }

    public double standardDeviation() {
        if (size <= 1) return 0;
        double mean = mean();
        double sumSqDiff = 0;
        Node current = head;
        while (current != null) {
            double diff = current.data - mean;
            sumSqDiff += diff * diff;
            current = current.next;
        }
        return Math.sqrt(sumSqDiff / (size - 1));
    }

    public int size() {
        return size;
    }
}