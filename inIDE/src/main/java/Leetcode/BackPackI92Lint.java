package Leetcode;

public class BackPackI92Lint {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        int n = A.length;
        int[] dp = new int[m + 1];
        for (int i = A[0]; i <= m; i++) {
            dp[i] = A[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = m; j >= 1; j--) {
                if (dp[j] + A[i] <= j) {
                    dp[j] = dp[j] + A[i];
                } else if (dp[j] + A[i] > j && j >= A[i]) {
                    dp[j] = Math.max(dp[j],
                            dp[j - A[i]] + A[i]);
                }
            }
        }
        return dp[m];
    }

    public int backPack_Omn(int m, int[] A) {
        int n = A.length;
        int[][] dp = new int[n][m + 1];
        for (int i = A[0]; i <= m; i++) {
            dp[0][i] = A[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                int res = 0;
                if (j < A[i]) {
                    res = dp[i - 1][j];
                } else if (dp[i - 1][j] + A[i] < j) {  // should be `<= j`
                    res = dp[i - 1][j] + A[i];
                } else {  // prev + A[j] > j
                    res = Math.max(dp[i - 1][j],
                            dp[i - 1][j - A[i]] + A[i]);
                }
                dp[i][j] = res;
            }
        }
        return dp[n - 1][m];

//        int[][] mem = dp;
//        return rec(0, 0, m, n, A, mem);
    }

    // rec(0, 0, m, n, a)
    public int rec(int ind, int tot, int m, int n, int[] a, int[][] mem) {
        if (ind == n) return tot;
        if (a[ind] + tot > m) {
            int res = rec(ind + 1, tot, m, n, a, mem);
            mem[ind][tot] = res;
            return res;
        }
        if (mem[ind][tot] != 0) return mem[ind][tot];
        int res = Math.max(rec(ind + 1, tot + a[ind], m, n, a, mem),
                rec(ind + 1, tot, m, n, a, mem));
        mem[ind][tot] = res;
        return res;
    }
}
