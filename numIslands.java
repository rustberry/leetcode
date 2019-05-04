class Solution {
    private int n;  // cols
    private int m;  // rows
    
    public int numIslands(char[][] grid) {
        return numIslands1(grid);
    }
    
    
    private int numIslands1(char[][] grid) {
        this.n = grid.length;
        if (n == 0) return 0;
        this.m = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            this.m = grid[i].length;
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    private void dfs(char[][] adj, int col, int row) {
        adj[col][row] = '0';
        if (col < n - 1 && adj[col+1][row] == '1') dfs(adj, col+1, row);
        if (row < m - 1 && adj[col][row+1] == '1') dfs(adj, col, row+1);
        if (col - 1 >= 0 && adj[col-1][row] == '1') dfs(adj, col-1, row);
        if (row - 1 >= 0 && adj[col][row-1] == '1') dfs(adj, col, row-1);
        
    }
    /**
    4 cols 5 rows
    [
        ["1","0","0","0","0"],
        ["1","1","0","0","0"],
        ["0","1","0","0","0"],
        ["0","1","1","0","0"]
    ]   
    */
}