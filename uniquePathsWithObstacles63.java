public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int flag = 1;
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) flag = 0;
            obstacleGrid[0][i] = flag;
        }
        flag = 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) flag = 0;
            obstacleGrid[i][0] = flag;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) obstacleGrid[i][j] = 0;
                else obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
            }
        }
        return obstacleGrid[m-1][n-1];
    }
    
    public static void main(String[] args) {
        /**{
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };*/
        int[][] test = new int[][] {
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };
        System.out.println(
            new Solution().uniquePathsWithObstacles(test)
        );
        // for (int i = 0; i < 3; i++) {
            // for (int j = 0; j < 3; j++) {
                // System.out.print(test[i][j]+" ");
            // }
            // System.out.println();
        // }
    }
}