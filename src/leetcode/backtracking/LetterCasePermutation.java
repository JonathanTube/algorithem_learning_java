package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    List<String> result = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        char[] chars = s.toCharArray();
        backtracking(chars, 0);
        return result;
    }

    private void backtracking(char[] chars, int startIndex) {
        result.add(new String(chars));

        for (int i = startIndex; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isDigit(c)) continue;
            if (Character.isLowerCase(c)) {
                chars[i] = (char) (chars[i] - 32); // 小写转大写
                backtracking(chars, i + 1);
                chars[i] = (char) (chars[i] + 32); // 回溯
            } else {
                chars[i] = (char) (chars[i] + 32); // 大写转小写
                backtracking(chars, i + 1);
                chars[i] = (char) (chars[i] - 32); // 回溯
            }
        }
    }

    public static void main(String[] args) {
        LetterCasePermutation letterCasePermutation = new LetterCasePermutation();
        letterCasePermutation.letterCasePermutation("a1b2").forEach(System.out::println);
    }
}
