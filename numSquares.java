class Solution {
    // TODO that's not the best solution
    private int[][] memo;
    public int numSquares(int n) {
        if (n < 1) return -1;
        if (n == 1 || n == 2 || n == 3) return n;
        if (n == 4) return 1;
        
        memo = new int[n+1][n/2+3];
        int ret = dpsquares(n, 1, 0);
        return ret;
    }
    
    public int dpsquares(int n, int start, int cnt) {
        if (n == 0) return cnt;
        if (n < 0 || start * start > n) return -1;
        if (memo[n][start] != 0) {
            // System.out.println("n: "+n+" start: "+start+" hit!! cnt: "+cnt);
            return memo[n][start];
        }
        
        int v1 = dpsquares(n - start * start, start, cnt);
        if (v1 != -1) v1++;  // since curret number is chosen, add 1
        int v2 = dpsquares(n, start + 1, cnt);
        
        int ret = Integer.MAX_VALUE;
        if (v1 != -1) ret = Math.min(ret, v1);
        if (v2 != -1) ret = Math.min(ret, v2);
        if (ret == Integer.MAX_VALUE) ret = -1;
        memo[n][start] = ret;
        return ret;
    }
}