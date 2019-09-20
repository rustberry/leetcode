/**

-2 (K)	-3	3
-5	-10	1
10	30	-5 (P)


The difference between this and other matrix DP problems is that, you should
start from the bottom to top. 
    int need = minHealth[i+1][n-1] - dungeon[i][n-1];
    minHealth[i][n-1] = need > 0 ? need : 1;
19-6-3
*/

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] minHealth = new int[m][n];
        int pre = dungeon[0][0];
        
        minHealth[m-1][n-1] = dungeon[m-1][n-1] > 0 ? 1 : 1 - dungeon[m-1][n-1];
        for (int i = n - 2; i >= 0; i--) {
            int need = minHealth[m-1][i+1] - dungeon[m-1][i];
            minHealth[m-1][i] = need > 0 ? need : 1;
        }
        
        for (int i = m - 2; i >= 0; i--) {
            int need = minHealth[i+1][n-1] - dungeon[i][n-1];
            minHealth[i][n-1] = need > 0 ? need : 1;
        }
        
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int need = Math.min(minHealth[i][j+1], minHealth[i+1][j]) - dungeon[i][j];
                minHealth[i][j] = need > 0 ? need : 1;
            }
        }

        for (int k = 0; k < m; k++) {
            for (int l = 0; l < n; l++) {
                System.out.print(minHealth[k][l]+" ");
            }
            System.out.println();
        }
        
        return minHealth[0][0];
    }
}