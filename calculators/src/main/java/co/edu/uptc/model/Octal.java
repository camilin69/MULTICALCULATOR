package co.edu.uptc.model;

public class Octal extends Expression{
    public String sum(String a, String b) {
        long num1 = Long.parseLong(a, 8);
        long num2 = Long.parseLong(b, 8);
        long sum = num1 + num2;
        return Long.toString(sum, 8);
    }

    public String difference(String a, String b) {
        long num1 = Long.parseLong(a, 8);
        long num2 = Long.parseLong(b, 8);
        long difference = num1 - num2;
        return Long.toString(difference, 8);
    }

    public String product(String a, String b) {
        long num1 = Long.parseLong(a, 8);
        long num2 = Long.parseLong(b, 8);
        long product = num1 * num2;
        return Long.toString(product, 8);
    }

    public String division(String a, String b) {
        long num1 = Long.parseLong(a, 8);
        long num2 = Long.parseLong(b, 8);
        long division = num1 / num2;
        return Long.toString(division, 8);
    }

    public String pow(String a, String b) {
        int num1 = Integer.parseInt(a, 2);
        int num2 = Integer.parseInt(b, 2);
        int pow = (int) Math.pow(num1, num2);
        return Long.toString(pow, 8);
    }
}
