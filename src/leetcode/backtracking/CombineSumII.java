package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombineSumII {
    //设置为全局变量 这样dfs里参数列表不会那么多
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        if (candidates.length == 0) return res;
        dfs(0, candidates, target);
        return res;
    }

    public void dfs(int start, int[] candidates, int target) {
        //设置终止条件
        if (target < 0) return;
        if (start >= candidates.length) return;
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            System.out.println("i=" + i + "&start=" + start + "&candidates[" + i + "]=" + candidates[i] + "&target=" + target);
            //关键：如果下一个和上一个相同则continue
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            path.add(candidates[i]);
            dfs(i + 1, candidates, target - candidates[i]);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombineSumII combineSumII = new CombineSumII();
        combineSumII.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }
}
