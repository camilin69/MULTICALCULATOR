package co.edu.uptc.model;

public class Octal extends Expression {

    private String doubleToOctalString(double value) {
        long integerPart = (long) value;
        String octalIntegerPart = Long.toString(integerPart, 8);

        double fractionalPart = value - integerPart;
        StringBuilder octalFractionalPart = new StringBuilder(".");
        
        for (int i = 0; i < 10; i++) {
            fractionalPart *= 8;
            int digit = (int) fractionalPart;
            octalFractionalPart.append(Integer.toString(digit));
            fractionalPart -= digit;
        }

        return octalIntegerPart + octalFractionalPart.toString();
    }

    private double octalStringToDouble(String octal) {
        String[] parts = octal.split("\\.");
        long integerPart = Long.parseLong(parts[0], 8);
        double result = integerPart;

        if (parts.length > 1) {
            String fractionalPart = parts[1];
            double divisor = 8.0;

            for (char digit : fractionalPart.toCharArray()) {
                result += Character.getNumericValue(digit) / divisor;
                divisor *= 8;
            }
        }

        return result;
    }

    public String sum(String a, String b) {
        double num1 = octalStringToDouble(a);
        double num2 = octalStringToDouble(b);
        double sum = num1 + num2;
        return doubleToOctalString(sum);
    }

    public String difference(String a, String b) {
        double num1 = octalStringToDouble(a);
        double num2 = octalStringToDouble(b);
        double difference = num1 - num2;
        return doubleToOctalString(difference);
    }

    public String product(String a, String b) {
        double num1 = octalStringToDouble(a);
        double num2 = octalStringToDouble(b);
        double product = num1 * num2;
        return doubleToOctalString(product);
    }

    public String division(String a, String b) {
        double num1 = octalStringToDouble(a);
        double num2 = octalStringToDouble(b);

        if (num2 == 0) {
            throw new ArithmeticException("Division by zero");
        }

        double division = num1 / num2;
        return doubleToOctalString(division);
    }

    public String pow(String a, String b) {
        double num1 = octalStringToDouble(a);
        double num2 = octalStringToDouble(b);
        double pow = Math.pow(num1, num2);
        return doubleToOctalString(pow);
    }
}
