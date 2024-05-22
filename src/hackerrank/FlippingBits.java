package hackerrank;

public class FlippingBits {
    public static void main(String[] args) {
        long n = 3;
        String str = Long.toBinaryString(n);
        str = String.format("%32s", str).replaceAll(" ", "0");
        System.out.println("str=" + str);
        str = str.replaceAll("0", "x");
        System.out.println(str);
        str = str.replaceAll("1", "0");
        System.out.println(str);
        str = str.replaceAll("x", "1");
        System.out.println(str);
        long res = Long.parseLong(str, 2);
        System.out.println(res);


        long aa = 12345;
        // 十进制转二进制
        System.out.println(Long.toBinaryString(aa));
        // 后补0
        System.out.println(String.format("%-10s",aa).replaceAll(" ","0"));
        // 前补0
        System.out.println(String.format("%10s",aa).replaceAll(" ","0"));
        // 二进制字符串转十进制
        System.out.println(Long.parseLong("111",2));
    }
}
