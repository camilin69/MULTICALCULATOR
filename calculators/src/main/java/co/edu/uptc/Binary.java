package co.edu.uptc;

public class Binary{
    public String sum(String a, String b) {
        int num1 = Integer.parseInt(a, 2);
        int num2 = Integer.parseInt(b, 2);
        int sum = num1 + num2;
        return Integer.toBinaryString(sum);
    }

    public String difference(String a, String b) {
        int num1 = Integer.parseInt(a, 2);
        int num2 = Integer.parseInt(b, 2);
        int sum = num1 - num2;
        return Integer.toBinaryString(sum);
    }

    public String product(String a, String b) {
        int num1 = Integer.parseInt(a, 2);
        int num2 = Integer.parseInt(b, 2);
        int sum = num1 + num2;
        return Integer.toBinaryString(sum);
    }

    public String division(String a, String b) {
        int num1 = Integer.parseInt(a, 2);
        int num2 = Integer.parseInt(b, 2);
        int sum = num1 / num2;
        return Integer.toBinaryString(sum);
    }

    
}
