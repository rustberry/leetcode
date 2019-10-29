package Leetcode;

import java.util.Arrays;

/**
 * [1, 2, 1, 2, 3, 4, 1, 2, 3]
 * [-1, 0, 0, 1, 0, 1, -1, 0, 1] signs
 * [9, 4, 2, 10, 7, 8, 8, 1, 9]:	4
 * [1, 2, 1, 1]
 * [-1, 1, 1, 1] signs
 * [4, 8, 12, 16]:	2
 * [100]:	1
 */
public class LongestTurbulentSubarray978Medium {

    public static void main(String[] args) {
        LongestTurbulentSubarray978Medium m = new LongestTurbulentSubarray978Medium();
        int[][] test = new int[][]{
                {9, 4, 2, 10, 7, 8, 8, 1, 9}, {4, 8, 12, 16}, {100},
        };
        for (int[] a : test) {
            System.out.println(m.maxTurbulenceSize(a));
        }
    }

    public int maxTurbulenceSize(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][2];
        for (int[] a : dp) {
            Arrays.fill(a,1);
        }
        int max = 1;
        for (int i = 1; i < n; i++) {
            if (A[i] > A[i-1]) dp[i][1] = dp[i-1][0] + 1;
            else if (A[i] < A[i-1]) dp[i][0] = dp[i-1][1] + 1;
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
//        for (int[] a : dp) {
//            System.out.print(Arrays.toString(a)+", ");
//        }
        return max;
    }

    public int maxTurbulenceSize_TimeLimit(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        if (n == 1) return 1;
        if (n == 2) return A[0] == A[1] ? 1 : 2;
        int[] dp = new int[n];
        byte[] signs = new byte[n];  // 0: <, 1: >, -1: ==
        dp[0] = 1;
        int max = Math.max(1, dp[1]);
        for (int i = 1; i < n; i++) {
            if (A[i] > A[i - 1]) signs[i] = 1;
            else if (A[i] == A[i - 1]) signs[i] = -1;
        }

        for (int left = 0; left < n - 1; left++) {
            dp[left + 1] = signs[left + 1] == -1 ? 1 : 2;
            max = Math.max(max, dp[left+1]);
        }

        for (int k = 2; k < n; k++) {
            for (int i = n-1; i >= k; i--) {
//                int i = left + k;
                if (signs[i] == -1) dp[i] = 1;
                else if (signs[i] != signs[i - 1]) dp[i] = dp[i - 1] + 1;
                max = Math.max(max, dp[i]);
            }
        }

//        System.out.println(Arrays.toString(A) + "array");
//        System.out.println(Arrays.toString(signs) + " signs");
        return max;
    }
}
