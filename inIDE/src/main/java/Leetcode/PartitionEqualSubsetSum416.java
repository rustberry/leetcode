package Leetcode;

public class PartitionEqualSubsetSum416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        if (nums.length == 1) return false;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        sum = sum / 2;
        int n = nums.length;
        int[] dp = new int[sum + 1];
        if (nums[0] <= sum) dp[nums[0]]++;
        for (int i = 1; i < n; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j - nums[i] >= 0 && dp[j - nums[i]] != 0) dp[j] = 1;
            }
            if (nums[i] <= sum) dp[nums[i]] = 1;
            if (dp[sum] == 1) return true;
        }
        return false;
    }

    public boolean canPartition_notOpt(int[] nums) {
        int sum = 0;
        if (nums.length == 1) return false;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        sum = sum / 2;

        int n = nums.length;
        int[][] dp = new int[n][sum + 1];
        if (nums[0] <= sum) dp[0][nums[0]] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (dp[i - 1][j] != 0) {
                    if (j - nums[i] >= 0 && dp[i - 1][j - nums[i]] != 0) {
                        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else if (j - nums[i] >= 0 && dp[i - 1][j - nums[i]] != 0) {
                    dp[i][j] = dp[i - 1][j - nums[i]];
                }
            }
            if (nums[i] <= sum) dp[i][nums[i]]++;
            if (dp[i][sum] != 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum416 t = new PartitionEqualSubsetSum416();
        System.out.println(
                t.canPartition(new int[]{1, 5, 11, 5})
        );
    }
}
