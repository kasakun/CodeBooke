/*
 * 00, die->die, 0
 * 10, die->live, 2
 * 11, live->live, 3
 * 01, live->die, 1
 * 
 * O(1) space
 **/
class Solution {
    private int numOfLiveCells(int[][]board, int i, int j) {
        int num = 0;
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, board.length - 1); ++x) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, board[0].length - 1); ++y) {
                num += board[x][y] & 1;
            }
        }
        
        num -= board[i][j] & 1; //eliminate self
        
        return num;
    }
    
    public void gameOfLife(int[][] board) {
        if (board.length == 0) return;
        if (board[0].length == 0) return;
        
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                int num = numOfLiveCells(board, i, j);
                
                // we only care about the die->live since the second bit is 0
                // then under other situation we only need to do >>
                if (board[i][j] == 1 && num >= 2 && num <= 3)
                    board[i][j] = 3;
                if (board[i][j] == 0 && num == 3)
                    board[i][j] = 2;
            }
        }
        
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                board[i][j] >>= 1;
            }
        }
        
        return;
    }
}