package estebangmz666.laboratory_linked_lists.ej11;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Polynomial poly = new Polynomial();

        System.out.println("Enter the number of terms in the polynomial:");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.printf("Coefficient of term %d: ", i + 1);
            double coef = sc.nextDouble();
            System.out.printf("Exponent of term %d: ", i + 1);
            int exp = sc.nextInt();
            poly.addTerm(coef, exp);
        }

        System.out.println("\nPolynomial Value Table:");
        poly.printTable();

        sc.close();
    }
}