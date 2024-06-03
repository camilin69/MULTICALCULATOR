package co.edu.uptc.model;

public class Hexa extends Expression{
    public String sum(String a, String b) {
        long num1 = Long.parseLong(a, 16);
        long num2 = Long.parseLong(b, 16);
        long sum = num1 + num2;
        return formatHexResult(sum);
    }

    public String difference(String a, String b) {
        long num1 = Long.parseLong(a, 16);
        long num2 = Long.parseLong(b, 16);
        long difference = num1 - num2;
        return formatHexResult(difference);
    }

    public String product(String a, String b) {
        long num1 = Long.parseLong(a, 16);
        long num2 = Long.parseLong(b, 16);
        long product = num1 * num2;
        return formatHexResult(product);
    }

    public String division(String a, String b) {
        long num1 = Long.parseLong(a, 16);
        long num2 = Long.parseLong(b, 16);
        if (num2 == 0) throw new ArithmeticException("División por cero");
        long division = num1 / num2;
        return formatHexResult(division);
    }

    private String formatHexResult(long value) {
        if (value < 0) {
            return "-" + Long.toHexString(-value).toUpperCase();
        } else {
            return Long.toHexString(value).toUpperCase();
        }
    }
}
