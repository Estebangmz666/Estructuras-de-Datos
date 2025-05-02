package estebangmz666.preparcial_2.ej5;

public class Main {
    public static void main(String[] args) {
        VehicleQueue queue = new VehicleQueue();
        queue.enqueue(new Vehicle("ABC123", 1985, "Mazda"));
        queue.enqueue(new Vehicle("XYZ789", 1995, "Chevrolet"));
        queue.enqueue(new Vehicle("LMN456", 2001, "Toyota"));
        queue.enqueue(new Vehicle("QWE321", 1999, "Renault"));

        System.out.println("Before filtering:");
        queue.printQueue();

        VehicleQueue.removeVehiclesFrom1991to1999(queue);

        System.out.println("\nAfter filtering:");
        queue.printQueue();
    }
}