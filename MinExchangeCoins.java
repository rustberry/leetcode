import java.util.Arrays;

public class MinExchangeCoins {

    public int minCoin(int[] a, int aim) {
        if (a == null || aim < 0 || a.length <= 0) return -1;
        return process(a, 0, aim);
    }

    public int process(int[] a, int i, int rest) {
        if (i >= a.length) return rest == 0 ? 0 : -1;
        int ret = -1;
        for (int j = 0; a[i] * j <= rest; j++) {
            int r = process(a, i+1, rest-a[i]*j);
            if (r != -1) {
                System.out.println("rest: "+rest+" i: "+a[i]+" ret: "+ret);
                ret = ret == -1 ? j + r : Math.min(ret, j + r);
            }
        }

        return ret;
    }

    public int memoProc(int[] a, int aim) {
        int[][] dp = new int[a.length+1][aim+1];
        // fill in the base case: if (i >= a.length) return rest == 0 ? 0 : -1
        dp[a.length][0] = 0;
        for (int j = 1; j <= aim; j++) {
            dp[a.length][j] = -1;
        }
        
        for (int i = a.length - 1; i >= 0; i--) {
            for (int rest = 0; rest <= aim; rest++) {
                dp[i][rest] = dp[i+1][rest];  // it will have the below value anyway
                if (rest - a[i] >= 0 && dp[i][rest - a[i]] != -1) dp[i][rest] = (dp[i][rest] == -1 ? dp[i][rest-a[i]] + 1 : Math.min(dp[i][rest], dp[i][rest-a[i]] + 1));
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[0][aim];
    }

    public static void main(String[] args) {
        MinExchangeCoins m = new MinExchangeCoins();
        int[] test = new int[] {5,2,3};
        int aim = 20;  // should return 4 on that

        System.out.println("memoProc: "+m.memoProc(test, aim));
    }
}