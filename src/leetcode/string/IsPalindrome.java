package leetcode.string;

public class IsPalindrome {
    public static boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        int left = 0;
        int right = str.length() - 1;
        while(left < right) {
            char leftChar = str.charAt(left);
            char rightChar = str.charAt(right);
            if(leftChar > 'z' || leftChar < 'a' || leftChar < '0' || leftChar > '9') {
                left ++;
                continue;
            }
            if(rightChar > 'z' || rightChar < 'a' || rightChar <'0' || rightChar > '9') {
                right --;
                continue;
            }
            if(leftChar != rightChar) return false;
            left ++;
            right --;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("race a car"));
    }
}
