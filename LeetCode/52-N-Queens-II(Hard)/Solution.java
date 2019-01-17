/**
 * The same as 51.
 * 
 */
class Solution {
    private int count = 0;
    
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        // Initialize
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                board[i][j] = '.';
            }
        }
        
        dfs(board, 0);
        
        return count;
    }
    
    private boolean validate(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < y; ++j) {
                if (board[i][j] == 'Q' &&
                    (x - i == y - j ||
                    x - i == j - y ||
                    x == i))
                    return false;
            }
        }
        
        return true;
    }
    
    private void dfs(char[][] board, int col) {
        if (col == board.length) {
            ++count;
            return;
        }
        
        for (int i = 0; i < board.length; ++i) {
            if (validate(board, i, col)) {
                board[i][col] = 'Q';
                dfs(board, col + 1);
                board[i][col] = '.';
            }
        }
    }
    
    
}