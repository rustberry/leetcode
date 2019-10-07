package Leetcode;

public class BackPackV563Lint {
    /**
     * @param nums: an integer array and all positive numbers
     * @param target: An integer
     * @return: An integer
     */
    public int backPackV(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target+1];

        dp[nums[0]] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = target; j >= 0; j--) {
                if (dp[j] != 0) {
                    if (j - nums[i] > 0 && dp[j-nums[i]] != 0) {
                        dp[j] = dp[j] + dp[j-nums[i]];
                    }
                    /*else {
                        dp[j] = dp[j];
                    }*/
                } else if (j - nums[i] > 0 && dp[j-nums[i]] != 0) {
                    dp[j] = dp[j-nums[i]];
                }
            }
            if (nums[i] <= target) dp[nums[i]]++;
        }
        return dp[target];
    }

    public int backPackV_Otargetn(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target+1];

        dp[0][nums[0]] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                if (dp[i-1][j] != 0) {
                    if (j - nums[i] > 0 && dp[i-1][j-nums[i]] != 0) {
                        dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i]];
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                } else if (j - nums[i] > 0 && dp[i-1][j-nums[i]] != 0) {
                    dp[i][j] = dp[i-1][j-nums[i]];
                }
            }
            if (nums[i] <= target) dp[i][nums[i]]++;
        }
        return dp[n-1][target];
    }
}
