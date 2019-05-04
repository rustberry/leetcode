class Solution {
    private int col;
    private int row;
    private boolean[][] marked;
    
    public void solve(char[][] board) {
        solve1(board);
    }
    
    private void solve1(char[][] board) {
        this.col = board.length;
        this.row = board[0].length;
        marked = new boolean[col][row];
        for (int i = 0; i < this.col; i++) {
            for (int j = 0; j < this.row; j++) {
                marked[i][j] = false;
            }
        }

        for (int i = 0; i < board.length; i++) {
            this.row = board[i].length;
            
            for (int j = 0; j < this.row; j++) {
                if (board[i][j] == 'O') {
                    dfs(board, j, i);
                }
            }
        }
    }
    
    // r == board || c == board
    private boolean dfs(char[][] board, int r, int c) {
        // System.out.println("cur: " + board[r][c] + " index is: board[" + c + r + "]");
        if (marked[c][r]) {
            return board[c][r] == 'X' ? true : false;
        } else {
            marked[c][r] = true;
        }
        if (r >= this.row - 1 || c >= this.col - 1 || r < 1 || c < 1) {
            if (board[c][r] == 'O') {
                return false;
            }
            return true;
        }

        if (board[c][r] == 'X') return true;
            
        if (dfs(board, r+1, c) && dfs(board, r, c+1) && dfs(board, r-1, c) && dfs(board, r, c-1)) {
            System.out.println("cur: " + board[r][c] + " index is: board[" + c + r + "]");
            board[c][r] = 'X';
            return true;
        } else {
            return false;
        }
        
    }
    
/**
[
["X","X","X","X"],
["X","O","O","X"],
["X","X","O","X"],
["X","O","X","X"]]
*/
}