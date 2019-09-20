class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) return -1;
        if (amount == 0) return 0;
        
        dpChange(coins, amount);
        // return dpProcess(coins, amount);
        // return helper(coins, 0, amount);
    }
    
    // O(rest) space
    public int dpChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for (int i = 1; i <= amount; i++) dp[i] = -1;
        
        for (int i = coins.length - 1; i >= 0; i--) {
            for (int amnt = 1; amnt <= amount; amnt++) {
                if (amnt - coins[i] >= 0 && dp[amnt - coins[i]] != -1) {
                    if (dp[amnt] != -1) dp[amnt] = Math.min(dp[amnt], (dp[amnt-coins[i]] + 1));
                    else dp[amnt] = dp[amnt-coins[i]] + 1;
                }
            }
        }
        return dp[amount];
    }
    
    // O(rest*length) space
    public int helper(int[] coins, int ind, int rest) {
        if (ind == coins.length) return  rest == 0 ? 0 : -1;
        
        int c = coins[ind];
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i * c <= rest; i++) {
            int cnt = helper(coins, ind + 1, rest - c * i);
            // System.out.println(cnt + "rest: "+(rest - c * i));
            if (cnt != -1) ret = Math.min((cnt + i), ret);
        }
        if (ret == Integer.MAX_VALUE) ret = -1;
        return ret;
    }
    
    public int dpProcess(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        // dp[0][0] = amount % coins[0] == 0 ? amount / coins[0] : -1;
        for (int i = 1; i < amount+1; i++) dp[coins.length][i] = -1;

        for (int i = coins.length-1; i >= 0; i--) {
            for (int rest = 1; rest < amount+1; rest++) {
                dp[i][rest] = dp[i+1][rest];
                if (rest - coins[i] >= 0 && dp[i][rest-coins[i]] != -1) {
                    if (dp[i+1][rest] != -1) {
                        dp[i][rest] = Math.min(dp[i][rest], (dp[i][rest-coins[i]] + 1));                        
                    } else {
                        dp[i][rest] = dp[i][rest-coins[i]] + 1;
                    }
                }
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        
        return dp[0][amount];
    }
    
}