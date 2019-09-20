package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerfectSquareNumbers {
    private List<Integer> squares;

    public int numSquares(int n) {
        squares = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            squares.add(i*i);
        }
//        int[][] dp = new int[squares.size()][n];
//        Arrays.fill(dp, -1);
        int[] memo = new int[n+1];
        int cnt = memoCnt(memo, n);
        return cnt;
    }

    public int memoCnt(int[] memo, int num) {
        if (memo[num] != 0) return memo[num];
        int min = Integer.MAX_VALUE;
        for (Integer i : squares) {
            int ret = -1;
            if (num - i > 0) {
                ret = memoCnt(memo, num - i) + 1;
                if (ret != -1) min = Math.min(min, ret);
            }
            else if (num - i == 0) min = Math.min(min, 1);
        }
        if (min == Integer.MAX_VALUE) min = -1;
        memo[num] = min;
        return min;
    }

    public int dpCnt(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        int i = 1;
        for (; i * i < n; i++) dp[i * i] = 1;
        if (i * i == n) return 1;
        else i--;

        for (int j = 2; j <= n; j++) {
            for (int k = 1; k <= i; k++) {
                if (k * k <= j) dp[j] = Math.min(dp[j], dp[j - k*k] + 1);
            }
        }
        return dp[n];
    }

/*    int dpCoinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[][] dp = new int[amount+1][coins.length];
        for (int[] ints : dp) Arrays.fill(ints, -1);
        for (int i = 0; i < coins.length; i++) dp[coins[i]][0] = 1;
        for (int i = 1; i <= amount; i++) if (i % coins[0] == 0) dp[i][0] = i / coins[0];
        for (int i = 1; i <= amount; i++) {
            for (int j = 1; j < coins.length; j++) {
                int denom = coins[j];
                if (i - denom >= 0 && dp[i-denom][j] != -1) {
                    dp[i][j] = Math.min(dp[i-denom][j] + 1, dp[i][j-1]);
                }
                else dp[i][j] = dp[i][j-1];
            }
        }
        return dp[amount][coins.length-1];
    }*/
}
