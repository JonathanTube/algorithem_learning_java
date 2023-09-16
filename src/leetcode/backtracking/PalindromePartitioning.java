package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {
    List<List<String>> result = new ArrayList<>();
    Deque<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        palindrome(s, 0);
        return result;
    }

    private void palindrome(String s, int startIndex) {
        if (startIndex >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String temp = s.substring(startIndex, i + 1);
            if (!isPalindrome(temp)) continue;
            path.add(temp);
            palindrome(s, i + 1);
            path.removeLast();
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning pp = new PalindromePartitioning();
        pp.partition("aab");
        /**
         *                    a
         *          /         |       \
         *       a|ab        aa|b    aab|
         *       /   \      /   \
         *  a|a|b  a|ab|  aa|b|
         *    /
         * a|a|b|
         */
    }

}
