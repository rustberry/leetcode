class Solution {
    private int[][] memo;
    private int ans = 1;
    
    // public static void main(String[] args) {
        // Solution s = new Solution();
        // int matrix[][] = new int[][] {
                  // {9,9,4},
                  // {6,6,8},
                  // {2,1,1}} ;
        // int m2[][] = new int[][] {
                      // {3,4,5},
                      // {3,2,6},
                      // {2,2,1}};
        // System.out.println(s.longestIncreasingPath(m2));
    // }
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        memo = new int[matrix.length][matrix[0].length];
        for (int colInd = 0; colInd < matrix[0].length; colInd++) {
            for (int rowInd = 0; rowInd < matrix.length; rowInd++) {
                ans = Math.max(ans, increasPath(matrix, rowInd, colInd));
            }
        }
        return ans;
    }
    
    public int increasPath(int[][] matrix, int row, int col) {
        if (memo[row][col] != 0) return memo[row][col];
        int ret = 0;
        Integer up = null, dn = null, l = null, r = null;
        
        int cur = matrix[row][col];
        if (row + 1 < matrix.length && matrix[row+1][col] < cur) ret = Math.max(ret, increasPath(matrix, row + 1, col));
        if (row - 1 >= 0 && matrix[row-1][col] < cur) ret = Math.max(ret, increasPath(matrix, row - 1, col));
        if (col + 1 < matrix[0].length && matrix[row][col+1] < cur) ret = Math.max(ret, increasPath(matrix, row, col + 1));
        if (col - 1 >= 0 && matrix[row][col-1] < cur) ret = Math.max(ret, increasPath(matrix, row, col - 1));
        
        // ret = getMax(up, dn, l, r) + 1;
        ret += 1;
        memo[row][col] = ret;
        return ret;
    }
    
    // private int getMax(Integer up, Integer dn, Integer l, Integer r) {
        // List<Integer> tmp = new ArrayList<>();
        // if (up != null) tmp.add(up);
        // if (dn != null) tmp.add(dn);
        // if (r != null) tmp.add(r);
        // if (l != null) tmp.add(l);
        // int ret = 0;
        // for (int i : tmp) {
            // if (ret < i) ret = i;
        // }
        // return ret;
    // }
    
}