class Solution {
    // [1,2,3,1]  [] [2]  [1,4,3,2,5] [1,3,4,2,5,6]  
    // [4,1,2,7,5,3,1]
    /**
    * split into two: with the last but without the first
    *                 with the first but without the last
    */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        if (nums.length == 3) return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        
        int[] dp = new int[nums.length];
        int[] dp2 = new int[nums.length];
        
        int ptr = nums.length - 1;
        dp[ptr] = nums[ptr];
        dp[ptr-1] = nums[ptr-1];
        dp[ptr-2] = nums[ptr-2] + nums[ptr];
        dp[ptr-3] = Math.max(dp[ptr-1], dp[ptr]) + nums[ptr-3];
        
        dp2[ptr-1] = nums[ptr-1];
        dp2[ptr-2] = nums[ptr-2];
        dp2[ptr-3] = nums[ptr-3] + nums[ptr-1];
        if (nums.length == 4) return Math.max(dp[1], dp2[0]);
        
        ptr -= 3;
        while (--ptr >= 1) {
            dp[ptr] = Math.max(dp[ptr+2], dp[ptr+3]) + nums[ptr];
            dp2[ptr] = Math.max(dp2[ptr+2], dp2[ptr+3]) + nums[ptr];
        }
        
        // it's like getting the max from two separate rob-I problme,
        // therefore 4 candidates to select
        return Math.max(Math.max(dp[2], dp[1]), (Math.max(dp2[2] , dp2[3]) + nums[0]));
    }
}