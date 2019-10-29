package Leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class BurstBallons312Hard {
    // [3,1,5,8]
    public int maxCoins(int[] nums) {
        int[] help = new int[nums.length+2];
        int n = help.length;
        for (int i = 1; i < n - 1; i++) help[i] = nums[i - 1];
        help[0] = help[n-1] = 1;
        int[][] dp = new int[n][n];
        for (int interval = 2; interval < n; interval++) {
            for (int left = 0; left + interval < n; left++) {
                int right = left + interval;
                for (int k = left + 1; k < right; k++) {
                    dp[left][right] = Math.max(dp[left][right],
                            help[left] * help[k] * help[right] + dp[left][k]+dp[k][right]);
                }
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        BurstBallons312Hard t = new BurstBallons312Hard();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println(
                    t.maxCoins(new int[]{3,1,5,8})
            );
        }
    }
}
