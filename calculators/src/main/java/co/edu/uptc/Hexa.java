package co.edu.uptc;

public class Hexa {
    public String sum(String a, String b) {
        int num1 = Integer.parseInt(a, 16);
        int num2 = Integer.parseInt(b, 16);
        int sum = num1 + num2;
        return Double.toHexString(sum).toUpperCase();
    }

    public String difference(String a, String b) {
        int num1 = Integer.parseInt(a, 16);
        int num2 = Integer.parseInt(b, 16);
        int difference = num1 - num2;
        return Integer.toHexString(difference).toUpperCase();
    }

    public String product(String a, String b) {
        int num1 = Integer.parseInt(a, 16);
        int num2 = Integer.parseInt(b, 16);
        int product = num1 * num2;
        return Integer.toHexString(product).toUpperCase();
    }

    public String division(String a, String b) {
        int num1 = Integer.parseInt(a, 16);
        int num2 = Integer.parseInt(b, 16);
        int division = num1 / num2;
        return Integer.toHexString(division).toUpperCase();
    }
}
