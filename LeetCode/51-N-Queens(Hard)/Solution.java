/**
 * DFS/backtracking
 * 
 * Scan the board by col.
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        // Initialize
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                board[i][j] = '.';
            }
        }
        
        List<List<String>> res = new ArrayList<List<String>>();
        
        dfs(board, 0, res);
        
        return res;
    }
    
    /**
     * Validate the position is valid for queen.
     * 
     * @param board
     * @param x
     * @param y
     * @return if valid
     */
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
    
    /**
     * 
     * @param board
     * @param col
     * @param res
     */
    private void dfs(char[][] board, int col, List<List<String>> res) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }
        
        for (int i = 0; i < board.length; ++i) {
            if (validate(board, i, col)) {
                board[i][col] = 'Q';
                dfs(board, col + 1, res);
                // restore the status
                board[i][col] = '.';
            }
        }
    }
    
    /**
     * 
     * @param board
     * @return LinekedList<String>
     */
    private List<String> construct(char[][] board) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < board.length; ++i) {
            String s = new String(board[i]);
            res.add(s);
        }
        
        return res;
    }
}