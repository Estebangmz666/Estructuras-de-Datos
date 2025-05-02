package estebangmz666.preparcial_2.ej5;

public class Vehicle {
    String plate;
    int modelYear;
    String brand;

    public Vehicle(String plate, int modelYear, String brand) {
        this.plate = plate;
        this.modelYear = modelYear;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return plate + " - " + modelYear + " - " + brand;
    }
}