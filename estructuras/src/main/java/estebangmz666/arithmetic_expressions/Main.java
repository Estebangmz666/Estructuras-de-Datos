package estebangmz666.arithmetic_expressions;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese una expresión aritmética en notación infija: ");
        String infix = sc.nextLine();

        try {
            String postfix = InfixToPostfixConverter.convertToPostfix(infix);
            loadingAnimation("Convirtiendo a postfijo", 4, 300);
            printWithDelay("Notación postfija: " + postfix + "\n", 30);

            loadingAnimation("Evaluando expresión", 5, 300);
            int result = EvaluatePostFixNotation.evaluate(postfix);
            printWithDelay("Resultado: " + result + "\n", 40);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Error: División por cero.");
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        } finally {
            sc.close();
        }
        String banner = """ 
 ____      _          _____ _               _                   
|    \\ ___| |_ ___   |   __| |_ ___ _ _ ___| |_ _ _ ___ ___ ___ 
|  |  | .'|  _| .'|  |__   |  _|  _| | |  _|  _| | |  _| -_|_ -|
|____/|__,|_| |__,|  |_____|_| |_| |___|___|_| |___|_| |___|___|
                                                                 """;
        printWithDelay(banner, 4);
    }

    public static void printWithDelay(String text, long delayMillis) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delayMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void loadingAnimation(String message, int dots, int delayMillis) {
        System.out.print(message);
        for (int i = 0; i < dots; i++) {
            try {
                Thread.sleep(delayMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
        }
        System.out.println();
    }
}