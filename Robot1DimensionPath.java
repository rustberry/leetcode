import java.util.Arrays;

public class Robot1DimensionPath {
    private int[][] dp;
    // 1 <= start <= len
    public int way(int start, int len, int step, int pos) {
        if (start < 1 || start > len || step < 1 || len < 2 || pos < 1 || pos > len) {
            return 0;  // error
        }
        
        dp = new int[step+1][len];
        for (int i = 0; i < len; i++) {
            dp[0][i] = i == pos - 1 ? 1 : 0;  // the position is 1
        }
        
        for (int j = 1; j < step + 1; j++) {
            for (int i = 0; i < len; i++) {
                if (i == 0) dp[j][i] = dp[j-1][1];
                else if (i == len - 1) dp[j][i] = dp[j-1][i-1];
                else dp[j][i] = dp[j-1][i-1] + dp[j-1][i+1];
            }
        }
        
        return dp[step][start-1];
    }
    
    // using only int[len]
    public int way2(int start, int len, int step, int pos) {
        if (start < 1 || start > len || step < 1 || len < 2 || pos < 1 || pos > len) {
            return 0;  // error
        }
        
        int[] dp1 = new int[len];
        for (int i = 0; i < len; i++) {
            dp1[i] = i == pos - 1 ? 1 : 0;  // the position is 1
        }
        
        for (int i = 0; i < step; i++) {
            int left = dp1[0];
            int tmp = 0;
            dp1[0] = dp1[1];
            for (int j = 1; j < len - 1; j++) {
                // if (j == len - 1) dp1[j] = dp1[j-1];
                tmp = dp1[j];
                dp1[j] = left + dp1[j+1];
                left = tmp;
            }
            dp1[len-1] = left;
        }
        System.out.println(Arrays.toString(dp1));
        return dp1[start-1];
    }
    
    public static void main(String[] args) {
        Robot1DimensionPath r = new Robot1DimensionPath();
        System.out.println(
            r.way2(4, 7, 9, 5)  // return 116
            // r.way2(2, 5, 3, 3)  // return 3
        );
            
        System.out.println(Arrays.deepToString(r.dp));
    }
}
