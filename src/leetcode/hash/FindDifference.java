package leetcode.hash;

public class FindDifference {
    public char findTheDifference(String s, String t) {
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            chars[index] += 1;
        }
        for (char c : t.toCharArray()) {
            int index = c - 'a';
            chars[index] -= 1;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == -1) return (char) (i + 'a');
        }
        return '0';
    }

    public static void main(String[] args) {
    }
}
