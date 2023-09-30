package leetcode.slideWindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int len = s.length(); // 4
        int size = p.length();

        // 2 + 2 - 1  = 3
        for (int i = 0; i + size - 1 < len; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (p.contains(s.charAt(i + j) + "")) {
                    set.add(i + j);
                }
            }
            if (set.size() == size) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        findAnagrams("abab", "ab");
    }
}
