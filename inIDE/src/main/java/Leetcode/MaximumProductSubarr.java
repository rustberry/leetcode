package Leetcode;

/**
 * 当遇到数组中的数为负数时，将当前最大与最小的连续数组乘积交换，然后与相乘进行比较。
 */
public class MaximumProductSubarr {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int res = nums[0];
        int maxSofar = nums[0], minSofar = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] < 0) {  // swap
                int tmp = maxSofar;
                maxSofar = minSofar;
                minSofar = tmp;
            }
            minSofar = Math.min(nums[i], minSofar*nums[i]);
            maxSofar = Math.max(nums[i], maxSofar*nums[i]);
            res = Math.max(res, maxSofar);
        }
        return res;
    }

    public int maxProduct_fail(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int record = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
            record = Math.max(record, dp[i]);
            for (int j = i+1; j < n; j++) {
                if (dp[j-1] == 0) {
                    dp[j] = nums[j];
                    record = Math.max(record, dp[j]);
                } else {
                    dp[j] = dp[j-1] * nums[j];
                    if (dp[j] < 0) {
                        record = Math.max(record, nums[j]);
                    } else {
                        record = Math.max(record, dp[j]);
                    }
                }
            }
        }
        return record;
    }

    public static void main(String[] args) {
        MaximumProductSubarr t = new MaximumProductSubarr();
        System.out.println(
                t.maxProduct(new int[]{2,-4,3,-1,-9}));
    }
}
