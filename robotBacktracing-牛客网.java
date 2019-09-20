public class Solution {
    private int[][] visited;
    
    public int movingCount(int threshold, int rows, int cols)
    {
        visited = new int[rows][cols];
        return doCheck(threshold, rows, cols, 0, 0);
    }
    
    public int doCheck(int threshold, int rows, int cols, int r, int c) {
        int cnt = 0;
        // this.visited[r][c] = 1;
        
        if (check(rows, cols, r, c) && bitSum(r) + bitSum(c) <= threshold) {
            this.visited[r][c] = 1;
            cnt++;
            cnt = cnt +
                doCheck(threshold, rows, cols, r - 1, c) +
                doCheck(threshold, rows, cols, r + 1, c) +
                doCheck(threshold, rows, cols, r, c-1) +
                doCheck(threshold, rows, cols, r, c+1);
            // if (r - 1 >= 0 && !visited(r-1, c)) {
                // cnt += doCheck(threshold, rows, cols, r - 1, c);
            // }
            // if (r + 1 < rows && !visited(r+1, c)) {
                // cnt += doCheck(threshold, rows, cols, r + 1, c);
            // }
            // if (c - 1 >= 0 && !visited(r, c-1)) {
                // cnt += doCheck(threshold, rows, cols, r, c-1);
            // }
            // if (c + 1 < cols && !visited(r, c+1)) {
                // cnt += doCheck(threshold, rows, cols, r, c+1);
            // }
        }
        return cnt;
    }
    
    private int bitSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    
    private boolean check(int rows, int cols, int r, int c) {
        return c >= 0 && c < cols && r >= 0 && r < rows
        && !visitedBefore(r, c);
    }
    
    private boolean visitedBefore(int r, int c) {
        return this.visited[r][c] == 1;
    }
    
    // private boolean surroundingVisited(int[][] record, int r, int c) {
        // if (r -)
        // return false;
    // }
}