// [10,9,2,5,3,7,101,18] --> [2,3,7,101], 4
// [1,3,6,7,9,4,10,5,6]
// [11,12,13,14,15,6,7,8,101,18,19]
class Solution {
    private int[][] dp;
    // [] [0] [-3,-4] [-2,-2147483648]
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
         dp = new int[nums.length][nums.length];
        // return recurLengthOf(nums, Integer.MIN_VALUE, 0);
        return dpLengthOfLIS(nums);
    }
    
    public int dpLengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ret = 1;
        for (int i = 1; i < nums.length; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    maxVal = Math.max(maxVal, dp[j]);
                }
            }
            dp[i] = maxVal + 1;
            ret = Math.max(dp[i], maxVal);
        }
        return ret;
    }
    
    public int memoLengthOfLIS(int[] nums, int pre, int pos) {
        // int[][] dp = new int[nums.length][nums.length];
        if (pos == nums.length) return 0;
        if (dp[pre][pos] != 0) return dp[pre][pos];
        int take = 0;
        if (nums[pos] > pre) {
            take = 1 + recurLengthOf(nums, nums[pos], pos+1);
        }
        int nottake = recurLengthOf(nums, pre, pos+1);
        int ret = take > nottake ? take : nottake;
        dp[nums[pos]][pos+1] = ret;
        return ret;
    }
    
    public int recurLengthOf(int[] nums, int pre, int pos) {
        if (pos == nums.length) return 0;
        int take = 0;
        if (nums[pos] > pre) {
            take = 1 + recurLengthOf(nums, nums[pos], pos+1);
        }
        int nottake = recurLengthOf(nums, pre, pos+1);
        return take > nottake ? take : nottake;
    }
    
}