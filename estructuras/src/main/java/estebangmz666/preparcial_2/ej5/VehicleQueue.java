package estebangmz666.preparcial_2.ej5;

public class VehicleQueue {
    private static class Node {
        Vehicle vehicle;
        Node next;

        Node(Vehicle vehicle) {
            this.vehicle = vehicle;
        }
    }

    private Node front, rear;

    public void enqueue(Vehicle v) {
        Node newNode = new Node(v);
        if (rear != null) {
            rear.next = newNode;
        } else {
            front = newNode;
        }
        rear = newNode;
    }

    public Vehicle dequeue() {
        if (isEmpty()) throw new RuntimeException("Empty queue");
        Vehicle v = front.vehicle;
        front = front.next;
        if (front == null) rear = null;
        return v;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void printQueue() {
        Node current = front;
        while (current != null) {
            System.out.println(current.vehicle);
            current = current.next;
        }
    }

    public static void removeVehiclesFrom1991to1999(VehicleQueue queue) {
        VehicleQueue tempQueue = new VehicleQueue();
    
        while (!queue.isEmpty()) {
            Vehicle v = queue.dequeue();
            if (!(v.modelYear > 1990 && v.modelYear < 2000)) {
                tempQueue.enqueue(v);
            }
        }
    
        while (!tempQueue.isEmpty()) {
            queue.enqueue(tempQueue.dequeue());
        }
    }    
}