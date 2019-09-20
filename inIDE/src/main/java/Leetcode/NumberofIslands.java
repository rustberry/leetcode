package Leetcode;

import java.util.Arrays;

public class NumberofIslands {
    private char[][] grid;
    private int rowLen;
    private int colLen;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        this.grid = grid;
        this.rowLen = grid.length;
        this.colLen = grid[0].length;

        int cnt = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    affect(i, j);
                }
            }
        }

        return cnt;
    }

    public void affect(int row, int col) {
        if (row < 0 || row >= rowLen || col < 0 || col >= colLen
                || grid[row][col] != '1') {
            return;
        }

        this.grid[row][col] = 'a';

        affect(row + 1, col);
        affect(row, col + 1);
        affect(row - 1, col);
        affect(row, col - 1);
    }



    public static void main(String[] args) {
        char[][] matrix = new char[][] {
//                {'0','0','1'},
//                {'1','0','0'},
                {}
        };
        Arrays.deepToString(matrix);
    }
}
