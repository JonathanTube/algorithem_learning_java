package educative.dynamicprograming;

class LongestCommonSubstring {
    public static int LCSLength(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int maxLen = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 0;
                }
                maxLen = Math.max(dp[i][j], maxLen);
            }
        }
        printArr(dp);
        return maxLen;
    }

    static void printArr(int[][] arr) {
        System.out.println("[");
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + ",");
            }
            System.out.println();
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        System.out.println(LCSLength("educative.io/explore", "educative.io/edpresso"));
    }
}