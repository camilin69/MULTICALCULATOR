package co.edu.uptc.model;

public class Hexa extends Expression {

    private String doubleToHexadecimalString(double value) {
        long integerPart = (long) value;
        String hexadecimalIntegerPart = Long.toString(integerPart, 16);

        double fractionalPart = value - integerPart;
        StringBuilder hexadecimalFractionalPart = new StringBuilder(".");
        
        for (int i = 0; i < 10; i++) {
            fractionalPart *= 16;
            int digit = (int) fractionalPart;
            hexadecimalFractionalPart.append(Integer.toHexString(digit));
            fractionalPart -= digit;
        }

        return hexadecimalIntegerPart + hexadecimalFractionalPart.toString();
    }

    private double hexadecimalStringToDouble(String hexadecimal) {
        String[] parts = hexadecimal.split("\\.");
        long integerPart = Long.parseLong(parts[0], 16);
        double result = integerPart;

        if (parts.length > 1) {
            String fractionalPart = parts[1];
            double divisor = 16.0;

            for (char digit : fractionalPart.toCharArray()) {
                result += Character.getNumericValue(digit) / divisor;
                divisor *= 16;
            }
        }

        return result;
    }

    public String sum(String a, String b) {
        double num1 = hexadecimalStringToDouble(a);
        double num2 = hexadecimalStringToDouble(b);
        double sum = num1 + num2;
        return doubleToHexadecimalString(sum);
    }

    public String difference(String a, String b) {
        double num1 = hexadecimalStringToDouble(a);
        double num2 = hexadecimalStringToDouble(b);
        double difference = num1 - num2;
        return doubleToHexadecimalString(difference);
    }

    public String product(String a, String b) {
        double num1 = hexadecimalStringToDouble(a);
        double num2 = hexadecimalStringToDouble(b);
        double product = num1 * num2;
        return doubleToHexadecimalString(product);
    }

    public String division(String a, String b) {
        double num1 = hexadecimalStringToDouble(a);
        double num2 = hexadecimalStringToDouble(b);

        if (num2 == 0) {
            throw new ArithmeticException("Division by zero");
        }

        double division = num1 / num2;
        return doubleToHexadecimalString(division);
    }

    public String pow(String a, String b) {
        double num1 = hexadecimalStringToDouble(a);
        double num2 = hexadecimalStringToDouble(b);
        double pow = Math.pow(num1, num2);
        return doubleToHexadecimalString(pow);
    }
}
