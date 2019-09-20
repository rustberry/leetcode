package Leetcode;

import java.util.Scanner;

public class BalloonArray {
    private int N;
    private int[] arr;
    private int[][] memo;

    private int times = 0;

    public void getInput(Scanner sc) {
        N = sc.nextInt();
        arr = new int[N+2];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = sc.nextInt();
        }
        arr[0] = 1;
        arr[N + 1] = 1;
        memo = new int[N+2][N+2];
    }

    public int maxScore() {
        // base cases;
        for (int i = 1; i < N+1; i++) {
            memo[i][i] = arr[i] * arr[i-1] * arr[i+1];
        }
//        return bf(1, N);
        return dp();
    }

    public int dp() {
        for (int l = N; l >= 1; l--) {
            for (int r = l + 1; r <= N; r++) {
                // The value when the rightest remains last and when the leftest remains last
                int rLast = arr[r] * arr[l-1] * arr[r+1] + memo[l][r-1];  // memo[l][r-1] is the balloon left to rLast
                int lLast = arr[l] * arr[l-1] * arr[r+1] + memo[l+1][r];  // the balloon to the right
                memo[l][r] = Math.max(rLast, lLast);
                // The value when balloon in the middle remains last
                for (int i = l+1; i < r; i++) {
                    memo[l][r] = Math.max(memo[l][r],
                            arr[i] * arr[l-1] * arr[r+1]  // current value
                            + memo[l][i-1] + memo[i+1][r]);  // plus the value to the left and right
                }
            }
        }
        return memo[1][N];
    }

    public int bf(int l, int r) {
        // 2187 vs 728
        if (memo[l][r] != 0) return memo[l][r];
        if (l == r) return arr[l] * arr[l-1] * arr[r+1];
        int max = -1;
        max = Math.max(arr[l] * arr[l-1] * arr[r+1] + bf(l+1, r),
                arr[r] * arr[l-1] * arr[r+1] + bf(l, r-1));

        for (int i = l + 1; i < r; i++) {
            max = Math.max(max,
                    arr[i] * arr[l-1] * arr[r+1] + bf(l, i - 1) + bf(i+1, r));
        }

        return max;
    }

    public static void main(String[] args) {
        ;
    }
}
