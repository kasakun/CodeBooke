class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            Set<Character> row = new HashSet<>();
            
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') continue;
                if (row.contains(board[i][j])) return false;
                row.add(board[i][j]);
            }
        }
        
        for (int j = 0; j < 9; ++j) {
            Set<Character> col = new HashSet<>();
            
            for (int i = 0; i < 9; ++i) {
                if (board[i][j] == '.') continue;
                if (col.contains(board[i][j])) return false;
                col.add(board[i][j]);
            }
        }
        
        for (int index = 0; index < 9; ++index) {
            Set<Character> cube = new HashSet<>();
            
            for (int subIndex = 0; subIndex < 9; ++subIndex) {
                int i = index/3*3 + subIndex/3;
                int j = index%3*3 + subIndex%3;
                
                if (board[i][j] == '.') continue;
                if (cube.contains(board[i][j])) return false;
                cube.add(board[i][j]);
            }
        }
        
        return true;
    }
}