/**
 * O(n^2)
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        boolean[][] seen = new boolean[n][n];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int row = 0, col = 0, di = 0;
        
        for (int i = 1; i <= n*n; ++i) {
            
            res[row][col] = i;
            seen[row][col] = true;
            
            int nextRow = row + dr[di], nextCol = col + dc[di];

            if (0 <= nextRow &&
                nextRow < n &&
                0 <= nextCol &&
                nextCol < n && 
                !seen[nextRow][nextCol]) {
                row = nextRow;
                col = nextCol;
            } else {
                di = (di + 1)%4;
                row += dr[di];
                col += dc[di];
            }
        }
        
        return res;
    }
}