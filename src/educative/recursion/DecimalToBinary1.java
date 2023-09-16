package educative.recursion;

class DecimalToBinary1 {
    public static int decimalToBinary(int n) {
        StringBuilder binary = new StringBuilder();
        recursion(n, binary);
        return Integer.parseInt(binary.toString());
    }

    private static void recursion(int n, StringBuilder binary) {
        if(n == 0) {
            binary.append(0);
            return;
        }
        if(n / 2 == 1) {
            binary.append(1).append(n % 2);
            return;
        }
        recursion(n / 2, binary);
        binary.append(n % 2);
    }

    public static void main(String[] args) {
        System.out.println(decimalToBinary(0));
    }
}