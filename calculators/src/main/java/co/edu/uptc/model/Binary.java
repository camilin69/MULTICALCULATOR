package co.edu.uptc.model;

public class Binary extends Expression{

    public String sum(String a, String b) {
        int num1 = Integer.parseInt(a, 2);
        int num2 = Integer.parseInt(b, 2);
        int sum = num1 + num2;
        return toBinaryString(sum);
    }

    public String difference(String a, String b) {
        int num1 = Integer.parseInt(a, 2);
        int num2 = Integer.parseInt(b, 2);
        int difference = num1 - num2;
        return toBinaryString(difference);
    }

    public String product(String a, String b) {
        int num1 = Integer.parseInt(a, 2);
        int num2 = Integer.parseInt(b, 2);
        int product = num1 * num2;
        return toBinaryString(product);
    }

    public String division(String a, String b) {
        int num1 = Integer.parseInt(a, 2);
        int num2 = Integer.parseInt(b, 2);
        if (num2 == 0) throw new ArithmeticException("División por cero");
        int division = num1 / num2;
        return toBinaryString(division);
    }

    public String pow(String a, String b) {
        int num1 = Integer.parseInt(a, 2);
        int num2 = Integer.parseInt(b, 2);
        int pow = (int) Math.pow(num1, num2);
        return toBinaryString(pow);
    }

    private String toBinaryString(int num) {
        if (num < 0) {
            return "-" + Long.toBinaryString(-num);
        } else {
            return Long.toBinaryString(num);
        }
    }

    
}
