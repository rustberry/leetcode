package Leetcode;

public class BackPackII125Lint {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int[] V) {
        int n = A.length;
        int[] dp = new int[m+1];
        for (int i = A[0]; i <= m; i++) {
            dp[i] = V[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = m; j >= 0; j--) {
                if (j - A[i] >= 0) {
                    dp[j] = Math.max(dp[j],
                            dp[j-A[i]] + V[i]);
                }
            }
        }
        return dp[m];
    }

    // 218ms, 403ms
    public int backPackII_Omn(int m, int[] A, int[] V) {
        int n = A.length;
        int[][] dp = new int[n][m+1];
        for (int i = A[0]; i <= m; i++) {
            dp[0][i] = V[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j - A[i] < 0) {
                    dp[i][j] = dp[i-1][j];
                } else {  // A[i] + j > m
                    dp[i][j] = Math.max(dp[i-1][j],
                            dp[i-1][j-A[i]] + V[i]);
                }
            }
        }
        return dp[n-1][m];
    }

}
