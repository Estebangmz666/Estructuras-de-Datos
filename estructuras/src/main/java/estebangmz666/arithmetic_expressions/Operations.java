package estebangmz666.arithmetic_expressions;

public class Operations {
    public static void main(String[] args) {
        // Operación: (a * b) / (a + c)
        String notacionInfija = "(a * b) / (a + c)";
        String notacionPrefija = "/ * a b + a c"; // Operadores antes de los operandos
        String notacionPostfija = "a b * a c + /"; // Operadores después de los operandos

        System.out.println("Notación Infija: " + notacionInfija);
        System.out.println("Notación Prefija (Polaca): " + notacionPrefija);
        System.out.println("Notación Postfija (Polaca inversa): " + notacionPostfija);
    }
}