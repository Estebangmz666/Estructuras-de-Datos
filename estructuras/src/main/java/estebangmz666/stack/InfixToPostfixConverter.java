package estebangmz666.stack;

import java.util.StringTokenizer;

public class InfixToPostfixConverter {

    public static String convertToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<String> operators = new Stack<>();

        StringTokenizer tokens = new StringTokenizer(infix, "+-*/^() ", true);
        while (tokens.hasMoreTokens()) {
            String token = tokens.nextToken().trim();

            if (token.isEmpty()) continue;

            if (isNumber(token)) {
                postfix.append(token).append(" ");
            } else if (isOperator(token)) {
                while (!operators.isEmpty() &&
                        !operators.peek().equals("(") &&
                        precedence(operators.peek()) >= precedence(token)) {
                    postfix.append(operators.pop()).append(" ");
                }
                operators.push(token);
            } else if (token.equals("(")) {
                operators.push(token);
            } else if (token.equals(")")) {
                while (!operators.isEmpty() && !operators.peek().equals("(")) {
                    postfix.append(operators.pop()).append(" ");
                }
                if (!operators.isEmpty() && operators.peek().equals("(")) {
                    operators.pop();
                } else {
                    throw new IllegalArgumentException("Mismatched parentheses");
                }
            }
        }

        while (!operators.isEmpty()) {
            String op = operators.pop();
            if (op.equals("(") || op.equals(")")) {
                throw new IllegalArgumentException("Mismatched parentheses");
            }
            postfix.append(op).append(" ");
        }

        return postfix.toString().trim();
    }

    private static boolean isOperator(String token) {
        return "+-*/^".contains(token);
    }

    private static int precedence(String op) {
        return switch (op) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            case "^" -> 3;
            default -> -1;
        };
    }

    private static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}