class Solution {
    // [1,2,3,1]
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        
        int[] dp = new int[nums.length];
        int len = nums.length;
        dp[len-1] = nums[len-1];
        dp[len-2] = nums[len-2];
        dp[len-3] = nums[len-3] + nums[len-1];
        
        if (nums.length == 3) return Math.max(dp[0], dp[1]);
        
        len -= 3;
        while (--len >= 0) {
            dp[len] = Math.max(dp[len+2], dp[len+3]) + nums[len];
        }
        return Math.max(dp[0], dp[1]);
    }
    
    public int BFrob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int max = 0;
        max = Math.max(helper(nums, 0), helper(nums, 1));
        return max;
    }
    
    public int helper(int[] nums, int start) {
        int sum = nums[start];
        int max = sum;
        for (int i = start+2; i < nums.length; i++) {
            sum += helper(nums, i);
            max = Math.max(max, sum);
            sum = nums[start];
        }
        return max;
    }
}