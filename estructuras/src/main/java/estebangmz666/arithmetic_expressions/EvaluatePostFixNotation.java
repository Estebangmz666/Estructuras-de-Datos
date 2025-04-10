package estebangmz666.arithmetic_expressions;

import java.util.Stack;

public class EvaluatePostFixNotation {

    /*
     * 1. Inicializar la pila
     * 2. Repetir hasta que no haya caracteres en la expresión a evaluar
     *   2.1. Obtener el siguiente item de la expresión
     *   2.2. Si el elemento es un operando se mete en la pila
     *   2.3. Si el elemento es un operador
     *     2.3.1. Se extraen los dos elementos superiores de la pila, denominados Op2 y Op1 respectivamente
     *     2.3.2. Se evalua el resultado de Op1 y Op2 y se alamcena en Z
     *     2.3.3. Se introduce Z encima de la pila
     * 3. Obtener el valor de la expresión de la cima de la pila
     */

    public static int evaluate(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            if (isOperator(token)) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                int result = applyOperator(op1, op2, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static int applyOperator(int op1, int op2, String operator) {
        return switch (operator) {
            case "+" -> op1 + op2;
            case "-" -> op1 - op2;
            case "*" -> op1 * op2;
            case "/" -> op1 / op2;
            default -> throw new IllegalArgumentException("Operador inválido: " + operator);
        };
    }

    public static void main(String[] args) {
        String expression = "3 4 + 2 * 7 /"; // ((3 + 4) * 2) / 7 = 2
        int result = evaluate(expression);
        System.out.println("Resultado: " + result);
    }
}