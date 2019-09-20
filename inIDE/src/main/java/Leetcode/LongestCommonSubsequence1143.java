package Leetcode;

import java.util.Arrays;
//2
11
88888888888
3
000

public class LongestCommonSubsequence1143 {
    private int[][] dp;

    public int longestCommonSubsequence(String text1, String text2) {
        this.dp = new int[text1.length()][text2.length()];
        if (text1.charAt(0) == text2.charAt(0)) dp[0][0] = 1;
        return dp(text1, text2);
    }

    public int dp(String text1, String text2) {
        int to1 = dp.length, to2 = dp[0].length;

        for (int i = 1; i < to1; i++) {
            int prev = dp[i-1][0];
            if (prev == 1) {
                dp[i][0] = 1;
            } else if (text1.charAt(i) == text2.charAt(0)) {
                dp[i][0] = 1;
            }
        }
        for (int i = 1; i < to2; i++) {
            int prev = dp[0][i-1];
            if (prev == 1) {
                dp[0][i] = 1;
            } else if (text2.charAt(i) == text1.charAt(0)) {
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < to1; i++) {
            for (int j = 1; j < to2; j++) {
                if (text1.charAt(i) == text2.charAt(j)) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

//        for (int[] ints : dp) System.out.println(Arrays.toString(ints));
        return dp[to1-1][to2-1];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence1143 test = new LongestCommonSubsequence1143();
        int ans = test.longestCommonSubsequence("abcde", "ace");
        System.out.println(ans);
//        System.out.println(test.longestCommonSubsequence("abc", "abc"));
//        System.out.println(test.longestCommonSubsequence("abc", "def"));
        System.out.println(test.longestCommonSubsequence("abcdeksdfkjsdfkk", "acekljjdflskdfkkk"));
    }
}
