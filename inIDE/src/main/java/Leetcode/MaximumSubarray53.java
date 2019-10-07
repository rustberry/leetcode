package Leetcode;

/**
 * Note: for every non-zero value, we must check if it's the largest so far.
 */
public class MaximumSubarray53 {
    public int maxSubArray(int[] nums) {
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

    public int divideAndConquerMaxSubArray(int[] nums) {
        return 0;
    }
}
