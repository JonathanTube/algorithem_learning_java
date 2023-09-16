package leetcode.backtracking;

import java.util.*;

class SumOfThreeNumber {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 0, 1);
        return result;
    }

    private void backtracking(int k, int n, int sum, int startNum) {
        if (sum > n) return;

        if (path.size() == k) {
            if (sum == n) result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startNum; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(startNum);
            backtracking(k, n, sum + startNum, startNum + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        SumOfThreeNumber sumOfThreeNumber = new SumOfThreeNumber();
        sumOfThreeNumber.combinationSum3(3, 7);
        Map<Character, String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tvu");
        map.put('9',"wxyz");
    }
}