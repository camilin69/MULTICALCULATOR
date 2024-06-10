package co.edu.uptc.model;

public class Binary extends Expression {

    private String doubleToBinaryString(double value) {
        long integerPart = (long) value;
        String binaryIntegerPart = Long.toString(integerPart, 2);

        double fractionalPart = value - integerPart;
        StringBuilder binaryFractionalPart = new StringBuilder(".");
        
        for (int i = 0; i < 10; i++) {
            fractionalPart *= 2;
            int digit = (int) fractionalPart;
            binaryFractionalPart.append(Integer.toString(digit));
            fractionalPart -= digit;
        }

        return binaryIntegerPart + binaryFractionalPart.toString();
    }

    private double binaryStringToDouble(String binary) {
        String[] parts = binary.split("\\.");
        long integerPart = Long.parseLong(parts[0], 2);
        double result = integerPart;

        if (parts.length > 1) {
            String fractionalPart = parts[1];
            double divisor = 2.0;

            for (char digit : fractionalPart.toCharArray()) {
                result += Character.getNumericValue(digit) / divisor;
                divisor *= 2;
            }
        }

        return result;
    }

    public String sum(String a, String b) {
        double num1 = binaryStringToDouble(a);
        double num2 = binaryStringToDouble(b);
        double sum = num1 + num2;
        return doubleToBinaryString(sum);
    }

    public String difference(String a, String b) {
        double num1 = binaryStringToDouble(a);
        double num2 = binaryStringToDouble(b);
        double difference = num1 - num2;
        return doubleToBinaryString(difference);
    }

    public String product(String a, String b) {
        double num1 = binaryStringToDouble(a);
        double num2 = binaryStringToDouble(b);
        double product = num1 * num2;
        return doubleToBinaryString(product);
    }

    public String division(String a, String b) {
        double num1 = binaryStringToDouble(a);
        double num2 = binaryStringToDouble(b);

        if (num2 == 0) {
            throw new ArithmeticException("Division by zero");
        }

        double division = num1 / num2;
        return doubleToBinaryString(division);
    }

    public String pow(String a, String b) {
        double num1 = binaryStringToDouble(a);
        double num2 = binaryStringToDouble(b);
        double pow = Math.pow(num1, num2);
        return doubleToBinaryString(pow);
    }
}
