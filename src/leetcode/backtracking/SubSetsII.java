package leetcode.backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class SubSetsII {
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, 0);
        return result;
    }

    private void backtracking(int[] nums, int startIndex) {
        System.out.println(String.format("startIndex=%s", startIndex));
        System.out.println(String.format("path=[%s]", path.stream().map(Object::toString).collect(Collectors.joining(","))));

        result.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        SubSetsII subSetsII = new SubSetsII();
        subSetsII.subsetsWithDup(new int[]{1, 2, 2});
    }
}
