package educative.recursion;

class DecimalToBinary2 {
    public static int decimalToBinary(int n) {
        if (n == 0) return 0;
        int num1 = n % 2;
        int num2 = decimalToBinary(n / 2);
        return num1 + 10 * num2;
    }

    public static void main(String[] args) {
        System.out.println(decimalToBinary(2));
    }
}