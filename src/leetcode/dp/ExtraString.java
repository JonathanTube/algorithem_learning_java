package leetcode.dp;

import java.util.*;

public class ExtraString {
    public static int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        Set<String> set = new HashSet<>(dictionary.length);
        set.addAll(Arrays.asList(dictionary));

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 777);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            System.out.println(String.format("i=%s", i));
            dp[i + 1] = dp[i] + 1;
            for (int j = 0; j <= i; j++) {
                System.out.println(String.format("\tj=%s", j));
                System.out.println(String.format("\t\ts.substring(%s, %s)='%s'", j, i + 1, s.substring(j, i + 1)));
                if (set.contains(s.substring(j, i + 1))) {
                    dp[i + 1] = Math.min(dp[i + 1], dp[j]);
                }
                System.out.print("\t\t\t");
                Arrays.stream(dp).forEach(item -> System.out.print(item + ","));
                System.out.println();
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int result = ExtraString.minExtraChar("leetscode", new String[]{"leet", "code", "leetcode"});
        System.out.println(result);
    }
}
