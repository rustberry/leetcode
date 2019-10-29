package Leetcode;

import java.util.Arrays;

/**
 * Note: for every non-zero value, we must check if it's the largest so far.
 */
public class MaximumSubarray53 {
    public static void main(String[] args) {
        MaximumSubarray53 m = new MaximumSubarray53();
        int[][] test = new int[][]{
                {-2, 1, -3, 4, -1, 2, 1, -5, 4},
        };
        for (int[] a : test) {
            System.out.println(Arrays.toString(a) + ":\t" + m.dpMax(a));
        }
    }

    public int maxSubArray(int[] nums) {
//        return maxSubArray_O_n(nums);
        return dpMax(nums);
    }

    public int maxSubArray_O_n(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int from = 0;
        int max = Integer.MIN_VALUE;
        while (from < nums.length && nums[from] < 0) {
            max = Math.max(max, nums[from]);
            from++;
        }
        if (from > nums.length - 1) return max;

        int sum = nums[from];
        max = Math.max(max, sum);
        for (int to = from + 1; to < nums.length; ) {
            sum += nums[to];
            if (sum < 0) {
                from = to + 1;
                while (from < nums.length && nums[from] < 0) from++;
                if (from > nums.length - 1) return max;
                sum = nums[from];
                max = Math.max(max, sum);
                to = from + 1;
            } else {
                max = Math.max(max, sum);
                to++;
            }
        }
        return max;
    }

    public int dpMax(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] < 0 ? nums[i] : nums[i] + dp[i - 1];
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int divideAndConquerMaxSubArray(int[] nums) {
        return 0;
    }
}
