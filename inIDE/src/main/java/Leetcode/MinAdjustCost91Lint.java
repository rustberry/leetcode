package Leetcode;

import java.util.Arrays;
import java.util.List;

public class MinAdjustCost91Lint {
    /*
     * @param A: An integer array
     * @param target: An integer
     * @return: An integer
     */
    public int MinAdjustmentCost(List<Integer> A, int target) {
        int n = A.size();
        int[][] dp = new int[n][101];
        int tmp = A.get(0);
        for (int i = 0; i < 101; i++) {
            dp[0][i] = Math.abs(tmp - i);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 101; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= 100; j++) {  // dp[i][j] is a[i] to j 's min cost
                for (int k = 0; k <= 100; k++) {  // k is all possible prev value
                    if (Math.abs(k - j) <= target) {  // now and prev possible
                        dp[i][j] = Math.min(dp[i][j],
                                dp[i - 1][k] + Math.abs(A.get(i) - j));
                    }
                }
            }
        }
        int min = dp[n-1][0];
        for (int i = 1; i < 101; i++) {
            min = Math.min(min, dp[n-1][i]);
        }
        return min;
    }

    public static void main(String[] args) {
        MinAdjustCost91Lint t = new MinAdjustCost91Lint();
        System.out.println( t.MinAdjustmentCost(Arrays.asList(1,4,2,3), 1));
    }
}
