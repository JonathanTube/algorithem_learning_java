package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class RestoreIpAddresses {
    List<String> result = new ArrayList<>();
    Deque<String> path = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4) return result;
        backtracking(s, 0);
        return result;
    }

    private void backtracking(String s, int startIndex) {
        if (path.size() == 4 && startIndex == s.length()) {
            result.add(String.join(".", path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String temp = s.substring(startIndex, i + 1);
            if (!isValid(temp)) return;
            path.add(temp);
            backtracking(s, i + 1);
            path.removeLast();
        }
    }

    private boolean isValid(String str) {
        if (str.startsWith("0")) return false;
        return Integer.parseInt(str) <= 255;
    }

    public static void main(String[] args) {
        RestoreIpAddresses ria = new RestoreIpAddresses();
        System.out.println(ria.restoreIpAddresses("25525511135"));
    }
}
