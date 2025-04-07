package estebangmz666.laboratory_linked_lists.ej12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Cargar datos desde archivo
        String filePath = "numbers.txt"; // Ruta del archivo
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    double num = Double.parseDouble(line.trim());
                    list.add(num);
                } catch (NumberFormatException e) {
                    System.out.println("Línea inválida ignorada: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo: " + e.getMessage());
            return;
        }

        if (list.size() == 0) {
            System.out.println("No hay datos válidos para procesar.");
            return;
        }

        double mean = list.mean();
        double stdDev = list.standardDeviation();

        System.out.printf("Media: %.4f\n", mean);
        System.out.printf("Desviación Estándar: %.4f\n", stdDev);
    }
}