/**
* Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
*/
// date: 19-6-2

class Solution {
    // in-place
    public int minPathSum1(int[][] grid) {
        int pre = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < n; i++) {
            grid[0][i] += pre;
            pre = grid[0][i];
        }
        pre = 0;
        for (int i = 0; i < m; i++) {
            grid[i][0] += pre;
            pre = grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int t1 = grid[i][j-1];
                int t2 = grid[i-1][j];
                grid[i][j] += t1 < t2 ? t1 : t2;
            }
        }
        
        return grid[m-1][n-1];
    }
    
    // without messing up original data, O(min{m, n}) space complexity
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] c = new int[n];
        c[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            c[i] = grid[0][i] + c[i-1];
        }
        
        for (int i = 1; i < m; i++) {
            c[0] += grid[i][0];
            for (int j = 1; j < n; j++) {
                int t1 = c[j], t2 = c[j-1];
                c[j] = t1 < t2 ? t1 : t2;
                c[j] += grid[i][j];
            }
        }
        
        return c[n-1];
    }
    
    public static void main(String[] args) {
        int[][] test = new int[][] {
            {1,3,1},
            {1,5,1},
            {4,2,1}
        };
        System.out.println(
            new Solution().minPathSum(test)
        );
    }
}