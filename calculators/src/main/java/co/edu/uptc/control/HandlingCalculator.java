package co.edu.uptc.control;

import java.util.Stack;

import co.edu.uptc.model.Expression;

public class HandlingCalculator {

    public static String evaluate(Expression ex, String toOperate) {
        toOperate = toOperate.replaceAll("\\s+", "");

        if (!isValidExpression(toOperate)) {
            throw new IllegalArgumentException("Invalid operation: " + toOperate);
        }

        Stack<String> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        try {
            for (int i = 0; i < toOperate.length(); i++) {
                char c = toOperate.charAt(i);
                if (Character.isDigit(c) || (c >= 'A' && c <= 'F')) {
                    StringBuilder numStr = new StringBuilder();

                    while (i < toOperate.length() && (Character.isDigit(toOperate.charAt(i)) || (toOperate.charAt(i) >= 'A' && toOperate.charAt(i) <= 'F'))) {
                        numStr.append(toOperate.charAt(i++));
                    }
                    i--;
                    numbers.push(numStr.toString());
                } else if (c == '(') {
                    operators.push(c);
                } else if (c == ')') {
                    while (operators.peek() != '(') {
                        numbers.push(applyOperation(ex, operators.pop(), numbers.pop(), numbers.pop()));
                    }
                    operators.pop(); 
                } else if (c == '+' || c == '-' || c == 'x' || c == '/') {
                    while (!operators.isEmpty() && hasPrecedence(c, operators.peek())) {
                        numbers.push(applyOperation(ex, operators.pop(), numbers.pop(), numbers.pop()));
                    }
                    operators.push(c);
                } else {
                    throw new IllegalArgumentException("Invalid Char in: " + c);
                }
            }

            while (!operators.isEmpty()) {
                numbers.push(applyOperation(ex, operators.pop(), numbers.pop(), numbers.pop()));
            }

            return numbers.pop();
        } catch (Exception e) {
            throw new IllegalArgumentException("Error evaluating: " + toOperate, e);
        }
    }

    private static String applyOperation(Expression ex, char operator, String b, String a) {
        switch (operator) {
            case '+':
                return ex.sum(a, b);
            case '-':
                return ex.difference(a, b);
            case 'x':
                return ex.product(a, b);
            case '/':
                if (Integer.parseInt(b, 16) == 0) throw new ArithmeticException("Division by zero impossible");
                return ex.division(a, b);
        }
        return "0";
    }

    private static boolean hasPrecedence(char op1, char op2) {
        return (op2 != '(' && op2 != ')') && ((op1 == 'x' || op1 == '/') || (op2 == '+' || op2 == '-'));
    }

    private static boolean isValidExpression(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }

        return expression.matches("[0-9A-F+\\-x/().]*");
    }

}
