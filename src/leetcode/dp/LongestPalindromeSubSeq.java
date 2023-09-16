package leetcode.dp;

class LongestPalindromeSubSeq {
    public static int longestPalindromeSubSeq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for(int i = 0; i < len; i++) dp[i][i] = 1;

        for(int i = len - 1; i >= 0; i --) {
            System.out.println(">>>>>i=" + i + "<<<<<");
            for(int j = i + 1; j < len; j ++) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                }else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
            print(dp);
        }
        return dp[0][len - 1];
    }

    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + ",");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(longestPalindromeSubSeq(s));
    }
}