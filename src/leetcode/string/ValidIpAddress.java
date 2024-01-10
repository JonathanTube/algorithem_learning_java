package leetcode.string;

public class ValidIpAddress {
    public String validIPAddress(String queryIP) {
        if(isIP4(queryIP)) return "IPv4";
        if(isIP6(queryIP)) return "IPv6";
        return "Neither";
    }

    private boolean isIP4(String queryIP) {
        String[] arr = queryIP.split("\\.");
        if(arr.length != 4) return false;
        for(String str : arr) {
            if(!isNumber(str, 10)) return false;
            if(Integer.parseInt(str) > 255) return false;
            // 这里获取字符串第N个位置的字符，是xxx.charAt(index)
            if(str.length() > 1 && str.charAt(0) == '0') return false;
        }
        return true;
    }

    private boolean isIP6(String queryIP) {
        String[] arr = queryIP.split(":");
        if(arr.length != 8) return false;
        for(String str : arr) {
            if(str.length() != 4) return false;
            if(!isNumber(str, 16)) return false;
        }
        return true;
    }

    private boolean isNumber(String s, int radix) {
        try {
            Integer.parseInt(s, radix);
        } catch(Exception e)
        {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] arr = "2001:0db8:85a3:0:0:8A2E:0370:7334:".split(":",8);
        System.out.println(arr.length);
        System.out.println();
        for (String s : arr) {
            System.out.println(s);
        }
    }
}
