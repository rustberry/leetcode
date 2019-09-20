package Leetcode;

import java.util.List;

public class MultiSolution {
    private int[] memo;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (coins == null || coins.length == 0) return -1;
//        return bf(coins, amount);
        this.memo = new int[amount + 1];
        return memoBf(coins, amount);
    }

    public int memoBf(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (memo[amount] != 0) return memo[amount];

        int cnt = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int denom = coins[i];  // 当前面值

            for (int j = 1; j * denom <= amount; j++) {
                if ((amount - j*denom) == 0) cnt = Math.min(cnt, j);
                else {
                    int ret = memoBf(coins, amount - j * denom);
                    if (ret != -1) cnt = Math.min(cnt, (ret + j));
                }
            }
        }

        if (cnt == Integer.MAX_VALUE) cnt = -1;
        if (memo[amount] == 0)
            memo[amount] = cnt;
        return cnt;
    }

    private int bf(int[] coins, int amount) {
        if (amount == 0) return 0;

        int cnt = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int denom = coins[i];  // 当前面值
            for (int j = 1; j * denom <= amount; j++) {
                if ((amount - j*denom) == 0) cnt = Math.min(cnt, j);
                else {
                    int ret = bf(coins, amount - j * denom);
                    if (ret != -1) cnt = Math.min(cnt, (ret + j));
                }
            }
        }

        if (cnt == Integer.MAX_VALUE) cnt = -1;
        return cnt;
    }

    public static void main(String[] args) {
        MultiSolution test = new MultiSolution();
        int ans = test.coinChange(new int[]{1,2,5}, 11);
        System.out.println(ans);

        System.out.println(test.coinChange(new int[]{2}, 3));

        System.out.println(test.coinChange(new int[]{}, 120));
    }

}
