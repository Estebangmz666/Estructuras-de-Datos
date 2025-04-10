package estebangmz666.arithmetic_expressions;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese una expresión aritmética en notación infija: ");
        String infix = sc.nextLine();
        try {
            String postfix = InfixToPostfixConverter.convertToPostfix(infix);
            System.out.println("Notación postfija: " + postfix);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }

        try {
            String postfix = InfixToPostfixConverter.convertToPostfix(infix);
            int result = EvaluatePostFixNotation.evaluate(postfix);
            System.out.println("Resultado: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Error: División por cero.");
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }

        System.out.println("""                               
 _____     _        _____             _       _         
|  |  |___| |_ _   |     |___ _ _ ___| |_ ___|_|___ ___ 
|     | . | | | |  | | | | . | | |   |  _| .'| |   |_ -|
|__|__|___|_|_  |  |_|_|_|___|___|_|_|_| |__,|_|_|_|___|
            |___|                                       
                """);
    }
}
