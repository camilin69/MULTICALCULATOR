package co.edu.uptc;

public class Octal {
    public static String sum(String a, String b) {
        int num1 = Integer.parseInt(a, 8);
        int num2 = Integer.parseInt(b, 8);
        int sum = num1 + num2;
        return Integer.toString(sum, 8);
    }

    public String difference(String a, String b) {
        int num1 = Integer.parseInt(a, 8);
        int num2 = Integer.parseInt(b, 8);
        int sum = num1 - num2;
        return Integer.toString(sum, 8);
    }

    public String product(String a, String b) {
        int num1 = Integer.parseInt(a, 8);
        int num2 = Integer.parseInt(b, 8);
        int sum = num1 + num2;
        return Integer.toString(sum, 8);
    }

    public String division(String a, String b) {
        int num1 = Integer.parseInt(a, 8);
        int num2 = Integer.parseInt(b, 8);
        int sum = num1 / num2;
        return Integer.toString(sum, 8);
    }
}
